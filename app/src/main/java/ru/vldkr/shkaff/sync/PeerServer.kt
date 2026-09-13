package ru.vldkr.shkaff.sync

import kotlinx.coroutines.runBlocking
import ru.vldkr.shkaff.data.db.PeerEntity
import ru.vldkr.shkaff.data.db.SchemaMetaEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.util.newId
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.InetAddress
import java.net.NetworkInterface
import java.net.ServerSocket
import java.net.Socket

// Сервер пир-синхронизации (US-G2). Протокол — строки + байтовые кадры по TCP:
//   HELLO <deviceId>   → OK <deviceId сервера>
//   PULL <deviceId>    → DATA <n> + n байт JSON | DENIED
//   PUSH <deviceId> <n> (n байт JSON) → OK <added> <changed> <deleted> | CONFLICTS <n> | DENIED
// Доверие проверяется на стороне сервера: пиру отдаётся только его область (PeerScope),
// PUSH принимают только роли с правом добавления.

object PeerServer {

    @Volatile
    var running = false
        private set

    @Volatile
    var port = 0
        private set

    @Volatile
    var lastError: String? = null

    private var server: ServerSocket? = null
    private var thread: Thread? = null

    // null — успех; иначе текст ошибки (порт занят и т.п.).
    fun start(port: Int): String? {
        if (running) return null
        lastError = null
        val ss = try {
            ServerSocket(port, 50, InetAddress.getByName("0.0.0.0"))
        } catch (e: Exception) {
            lastError = e.message ?: "Не удалось занять порт"
            return lastError
        }
        server = ss
        running = true
        this.port = ss.localPort
        thread = Thread({
            while (running) {
                val sock = try {
                    ss.accept()
                } catch (e: Exception) {
                    break
                }
                Thread({
                    runCatching { handle(sock) }.onFailure { lastError = it.message }
                }, "peer-conn").apply { isDaemon = true; start() }
            }
        }, "peer-server").apply { isDaemon = true; start() }
        return null
    }

    fun stop() {
        running = false
        runCatching { server?.close() }
        server = null
        port = 0
    }

    // IP в локальной сети (для подсказки «введите на другом устройстве»).
    fun lanIp(): String? = runCatching {
        NetworkInterface.getNetworkInterfaces().toList()
            .flatMap { it.inetAddresses.toList() }
            .firstOrNull { it.isSiteLocalAddress && it !is java.net.Inet6Address }
            ?.hostAddress
    }.getOrNull()

    private fun handle(sock: Socket) {
        sock.use { s ->
            val inStream = s.getInputStream()
            val out = s.getOutputStream()
            while (true) {
                val lineBytes = readLineBytes(inStream) ?: break
                val line = lineBytes.toString(Charsets.UTF_8).trim()
                if (line.isEmpty()) continue
                val parts = line.split(" ")
                when (parts[0]) {
                    "HELLO" -> writeLine(out, "OK ${Deps.deviceId}")

                    "PULL" -> {
                        val peer = ensurePeer(parts.getOrElse(1) { "" })
                            ?: return@use writeLine(out, "DENIED")
                        val trust = PeerTrust.parse(peer.trust)
                        val input = PeerScope.apply(
                            runBlocking { Backup.buildInput(Deps.db) },
                            trust
                        )
                        val bytes = Backup.toJson(input).toByteArray(Charsets.UTF_8)
                        writeLine(out, "DATA ${bytes.size}")
                        out.write(bytes)
                        out.flush()
                        touchPeer(peer.id)
                    }

                    "PUSH" -> {
                        val peer = ensurePeer(parts.getOrElse(1) { "" })
                            ?: return@use writeLine(out, "DENIED")
                        val trust = PeerTrust.parse(peer.trust)
                        // Роль без права создания не может менять чужую базу (US-G1 → US-G2).
                        if (!Access.can(trust.role, Access.CREATE)) {
                            return@use writeLine(out, "DENIED")
                        }
                        val len = parts.getOrElse(2) { "0" }.toIntOrNull() ?: 0
                        val bytes = readExact(inStream, len)
                        val remote = Backup.fromJson(bytes.toString(Charsets.UTF_8))
                        val local = runBlocking { Backup.buildInput(Deps.db) }
                        val result = MergeEngine.merge(local, remote, remoteWins = true)
                        val sanitized = MergeSanitizer.sanitize(result.merged)
                        if (result.conflicts.isNotEmpty()) {
                            MergeSession.start(
                                local, remote,
                                result.copy(merged = sanitized.merged),
                                sanitized.warnings
                            )
                            writeLine(out, "CONFLICTS ${result.conflicts.size}")
                        } else {
                            runBlocking {
                                Backup.applyMerge(result.copy(merged = sanitized.merged), Deps.db)
                                Deps.db.metaDao().upsert(
                                    SchemaMetaEntity("lastSyncWatermark", System.currentTimeMillis().toString())
                                )
                            }
                            val st = result.stats
                            writeLine(out, "OK ${st.added} ${st.changed} ${st.deleted}")
                        }
                        touchPeer(peer.id)
                    }

                    "BYE" -> return@use

                    else -> writeLine(out, "ERR unknown-command")
                }
            }
        }
    }

    // Неизвестное устройство — заводим пир-строку с доверием по умолчанию
    // (план: «новая база может подключиться без передачи ей прав на свою базу» —
    // права редактируют вручную в «Федерации», до первого контакта пир не виден).
    private fun ensurePeer(peerDeviceId: String): PeerEntity? {
        if (peerDeviceId.isBlank()) return null
        val dao = Deps.db.peerDao()
        val existing = runBlocking { dao.byPeerDevice(peerDeviceId) }
        if (existing != null) return existing
        val now = System.currentTimeMillis()
        val p = PeerEntity(
            id = newId(),
            name = "Устройство ${peerDeviceId.take(8)}",
            peer_device_id = peerDeviceId,
            trust = PeerTrust.toJson(PeerTrust.DEFAULT),
            last_synced_at = 0L,
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = Deps.deviceId
        )
        return runBlocking {
            dao.upsert(p)
            Deps.actionLog.log(
                "service", "peer", peerDeviceId,
                mapOf("event" to "peer-joined", "name" to p.name)
            )
            p
        }
    }

    private fun touchPeer(id: String) {
        val now = System.currentTimeMillis()
        runCatching {
            runBlocking {
                val p = Deps.db.peerDao().all().firstOrNull { it.id == id } ?: return@runBlocking
                Deps.db.peerDao().upsert(
                    p.copy(last_synced_at = now, updated_at = now, device_last_modified = Deps.deviceId)
                )
                Deps.actionLog.log(
                    "import", "peer", p.peer_device_id,
                    mapOf("event" to "peer-sync", "name" to p.name)
                )
            }
        }
    }

    // Строку читаем побайтно: BufferedReader «съел бы» часть байтового кадра,
    // идущего следом за заголовком (DATA/PUSH).
    private fun readLineBytes(inStream: InputStream): ByteArray? {
        val buf = ByteArrayOutputStream()
        while (true) {
            val b = inStream.read()
            if (b == -1) return if (buf.size() > 0) buf.toByteArray() else null
            buf.write(b)
            if (b == '\n'.code) break
        }
        return buf.toByteArray()
    }

    private fun readExact(inStream: InputStream, len: Int): ByteArray {
        if (len <= 0) return ByteArray(0)
        val out = ByteArray(len)
        var off = 0
        while (off < len) {
            val n = inStream.read(out, off, len - off)
            if (n == -1) throw IOException("Соединение разорвано при приёме данных")
            off += n
        }
        return out
    }

    private fun writeLine(out: OutputStream, line: String) {
        out.write(line.toByteArray(Charsets.UTF_8))
        out.write('\n'.code)
        out.flush()
    }
}
