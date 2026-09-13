package ru.vldkr.shkaff.sync

import ru.vldkr.shkaff.data.db.PeerEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.util.newId

// Клиентская сторона синхронизации (US-G2): HELLO → PULL → слияние → PUSH.
// Правила слияние те же, что и при импорте файла: LWW по updated_at,
// при равных датах локальная выигрывает (remoteWins=false), конфликты — на выбор.
object PeerSync {

    data class SyncResult(
        val ok: Boolean,
        val conflicts: Boolean = false,
        val message: String = "",
        val added: Int = 0,
        val changed: Int = 0,
        val deleted: Int = 0,
        val pushDenied: Boolean = false
    )

    suspend fun syncWith(host: String, port: Int): SyncResult {
        val serverId = PeerClient.hello(host, port)
        if (serverId == Deps.deviceId) {
            return SyncResult(ok = false, message = "Это устройство подключено к самому себе")
        }

        val remote = Backup.fromJson(PeerClient.pull(host, port))
        val local = Backup.buildInput(Deps.db)
        val result = MergeEngine.merge(local, remote, remoteWins = false)
        val sanitized = MergeSanitizer.sanitize(result.merged)
        val merged = result.copy(merged = sanitized.merged)

        if (merged.conflicts.isNotEmpty()) {
            MergeSession.start(local, remote, merged, sanitized.warnings)
            Deps.actionLog.log(
                "import", "peer", serverId,
                mapOf("event" to "sync-conflicts", "count" to merged.conflicts.size.toString())
            )
            return SyncResult(
                ok = false,
                conflicts = true,
                message = "${merged.conflicts.size} конфликт(ов) — выберите, что оставить"
            )
        }

        Backup.applyMerge(merged, Deps.db)
        val s = merged.stats

        // Отдаём пиру то, что изменилось у нас (обратное слияние, входящее выигрывает).
        var pushDenied = false
        var pushNote = ""
        try {
            val push = PeerClient.push(host, port, Backup.toJson(Backup.buildInput(Deps.db)))
            pushDenied = push.denied
            pushNote = when {
                push.ok -> " · пир обновлён (+${push.added} ~${push.changed} −${push.deleted})"
                push.denied -> " · пир отклонил обратное обновление (роль без права добавления)"
                push.conflicts > 0 -> " · на пиере ${push.conflicts} конфликт(ов) — разрешите с его стороны"
                else -> ""
            }
        } catch (e: Exception) {
            pushNote = " · обратное обновление не дошло (${e.message})"
        }

        upsertPeer(serverId, "$host:$port")
        Deps.actionLog.log(
            "import", "peer", serverId,
            mapOf(
                "event" to "sync",
                "added" to s.added.toString(),
                "changed" to s.changed.toString(),
                "deleted" to s.deleted.toString()
            )
        )
        return SyncResult(
            ok = true,
            message = "Синхронизация: +${s.added} ~${s.changed} −${s.deleted}$pushNote",
            added = s.added, changed = s.changed, deleted = s.deleted,
            pushDenied = pushDenied
        )
    }

    // Пир, к которому мы подключились, запоминаем у себя как доверенное устройство.
    private suspend fun upsertPeer(serverId: String, label: String) {
        val dao = Deps.db.peerDao()
        val now = System.currentTimeMillis()
        val existing = dao.byPeerDevice(serverId)
        if (existing != null) {
            dao.upsert(existing.copy(last_synced_at = now, updated_at = now, device_last_modified = Deps.deviceId))
        } else {
            dao.upsert(
                PeerEntity(
                    id = newId(),
                    name = "Пир $label",
                    peer_device_id = serverId,
                    trust = PeerEntity.DEFAULT_TRUST,
                    last_synced_at = now,
                    created_at = now,
                    updated_at = now,
                    deleted_at = null,
                    device_last_modified = Deps.deviceId
                )
            )
        }
    }
}
