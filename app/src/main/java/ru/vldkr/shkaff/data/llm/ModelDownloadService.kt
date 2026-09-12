package ru.vldkr.shkaff.data.llm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.di.Deps

/**
 * Foreground-сервис (тип dataSync) для скачивания моделей: удерживает процесс,
 * пока приложение в фоне. Сам скачивания не делает — держит scope, в котором
 * ModelStore.perform гоняет файлы, а сервис обновляет уведомление с прогрессом.
 */
class ModelDownloadService : Service() {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var notificationManager: NotificationManager? = null

    override fun onCreate() {
        super.onCreate()
        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Скачивание моделей",
            NotificationManager.IMPORTANCE_LOW,
        )
        notificationManager?.createNotificationChannel(channel)
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_DOWNLOAD -> {
                val id = intent.getStringExtra(EXTRA_ID)
                val row = Deps.modelStore.state.value.rows.firstOrNull { it.id == id }
                if (row == null) {
                    stopSelf()
                    return START_NOT_STICKY
                }
                startForeground(NOTIFICATION_ID, buildNotification(row.name, 0f))
                scope.launch {
                    var lastFile: String? = null
                    var lastPct = -1
                    Deps.modelStore.perform(row) { file, fraction ->
                        val current = Deps.modelStore.partBytes(file)
                        val total = if (fraction > 0f) (current / fraction).toLong() else 0L
                        Deps.modelStore.trackProgress(file, current, total)
                        val pct = (fraction * 100).toInt().coerceIn(0, 100)
                        if (file != lastFile || pct != lastPct) {
                            updateNotification(row.name, fraction)
                            lastFile = file
                            lastPct = pct
                        }
                    }
                    stopSelf()
                }
            }
            ACTION_CANCEL -> {
                Deps.modelStore.cancel()
                stopSelf()
            }
        }
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        scope.cancel()
        notificationManager?.cancel(NOTIFICATION_ID)
        super.onDestroy()
    }

    private fun updateNotification(title: String, fraction: Float) {
        val percent = (fraction * 100).toInt().coerceIn(0, 100)
        val notif = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.stat_sys_download)
            .setContentTitle(title)
            .setContentText("$percent%")
            .setOngoing(true)
            .setOnlyAlertOnce(true)
            .setProgress(100, percent, false)
            .build()
        notificationManager?.notify(NOTIFICATION_ID, notif)
    }

    private fun buildNotification(title: String, fraction: Float): Notification =
        NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.stat_sys_download)
            .setContentTitle(title)
            .setContentText("${(fraction * 100).toInt()}%")
            .setOngoing(true)
            .setProgress(100, (fraction * 100).toInt(), false)
            .build()

    companion object {
        private const val CHANNEL_ID = "model_downloads"
        private const val NOTIFICATION_ID = 1001
        const val ACTION_DOWNLOAD = "ru.vldkr.shkaff.llm.DOWNLOAD"
        const val ACTION_CANCEL = "ru.vldkr.shkaff.llm.CANCEL"
        const val EXTRA_ID = "record_id"
    }
}