package ru.vldkr.shkaff.sync

import ru.vldkr.shkaff.di.Deps
import java.io.ByteArrayOutputStream
import java.net.Socket

// Клиент пир-синхронизации (US-G2). Каждое действие — отдельное короткое TCP-соединение
// (сервер бесстандартно прост, состояние не храним). Протокол — см. PeerServer.
object PeerClient {

    class PeerException(message: String) : Exception(message)
    class PeerDenied(message: String = "Пир отклонил запрос") : Exception(message)

    data class PushResult(
        val ok: Boolean,
        val added: Int = 0,
        val changed: Int = 0,
        val deleted: Int = 0,
        val conflicts: Int = 0,
        val denied: Boolean = false
    )

    private const val CONNECT_TIMEOUT_MS = 8000
    private const val SO_TIMEOUT_MS = 30000

    private inline fun <T> withSocket(host: String, port: Int, block: (Socket) -> T): T {
        val sock = try {
            Socket().apply {
                soTimeout = SO_TIMEOUT_MS
                connect(java.net.InetSocketAddress(host, port), CONNECT_TIMEOUT_MS)
            }
        } catch (e: Exception) {
            throw PeerException("Нет соединения с $host:$port — ${e.message ?: "таймаут"}")
        }
        return sock.use { block(it) }
    }

    // HELLO → deviceId удалённого устройства.
    fun hello(host: String, port: Int): String = withSocket(host, port) { sock ->
        writeLine(sock, "HELLO ${Deps.deviceId}")
        val line = readLine(sock) ?: throw PeerException("Пир не ответил")
        if (!line.startsWith("OK ")) throw PeerException("Неизвестный ответ: $line")
        line.removePrefix("OK ").trim()
    }

    // PULL → JSON-база пира (уже обрезанная сервером под нашу область доверия).
    fun pull(host: String, port: Int): String = withSocket(host, port) { sock ->
        writeLine(sock, "PULL ${Deps.deviceId}")
        val line = readLine(sock) ?: throw PeerException("Пир не ответил")
        when {
            line.startsWith("DATA ") -> {
                val len = line.removePrefix("DATA ").trim().toIntOrNull()
                    ?: throw PeerException("Некорректный размер данных")
                val bytes = readExact(sock, len)
                bytes.toString(Charsets.UTF_8)
            }
            line == "DENIED" -> throw PeerDenied()
            else -> throw PeerException("Пир ответил: $line")
        }
    }

    // PUSH → применение нашей базы пира; ответ — статистика, конфликты или отказ.
    fun push(host: String, port: Int, json: String): PushResult = withSocket(host, port) { sock ->
        val bytes = json.toByteArray(Charsets.UTF_8)
        writeLine(sock, "PUSH ${Deps.deviceId} ${bytes.size}")
        sock.getOutputStream().write(bytes)
        sock.getOutputStream().flush()
        val line = readLine(sock) ?: throw PeerException("Пир не ответил")
        when {
            line.startsWith("OK ") -> {
                val p = line.removePrefix("OK ").trim().split(" ")
                PushResult(ok = true,
                    added = p.getOrElse(0) { "0" }.toIntOrNull() ?: 0,
                    changed = p.getOrElse(1) { "0" }.toIntOrNull() ?: 0,
                    deleted = p.getOrElse(2) { "0" }.toIntOrNull() ?: 0)
            }
            line.startsWith("CONFLICTS ") -> {
                PushResult(ok = false, conflicts = line.removePrefix("CONFLICTS ").trim().toIntOrNull() ?: 0)
            }
            line == "DENIED" -> PushResult(ok = false, denied = true)
            else -> throw PeerException("Пир ответил: $line")
        }
    }

    // Чтение строки побайтно (BufferedReader съел бы байты следующего кадра).
    private fun readLine(sock: Socket): String? {
        val inStream = sock.getInputStream()
        val buf = ByteArrayOutputStream()
        while (true) {
            val b = inStream.read()
            if (b == -1) return buf.size().let { if (it > 0) buf.toString(Charsets.UTF_8) else null }
            buf.write(b)
            if (b == '\n'.code) break
        }
        return buf.toString(Charsets.UTF_8).trimEnd('\r')
    }

    private fun readExact(sock: Socket, len: Int): ByteArray {
        if (len <= 0) return ByteArray(0)
        val inStream = sock.getInputStream()
        val out = ByteArray(len)
        var off = 0
        while (off < len) {
            val n = inStream.read(out, off, len - off)
            if (n == -1) throw PeerException("Соединение оборвано при приёме данных")
            off += n
        }
        return out
    }

    private fun writeLine(sock: Socket, line: String) {
        val out = sock.getOutputStream()
        out.write(line.toByteArray(Charsets.UTF_8))
        out.write('\n'.code)
        out.flush()
    }
}
