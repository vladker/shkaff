package ru.vldkr.shkaff.data.llm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.MainActivity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.llm.DownloadNotify

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
                notificationManager?.cancel(FINAL_NOTIFICATION_ID)
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
                    // T-056: обрыв/ошибка молча гасились — по окончании perform
                    // читаем итоговый статус строки и докладываем баннером.
                    // Отмена (scope.cancel в onDestroy) кидает CancellationException
                    // из perform — до этого места не доходит, баннер не показываем.
                    val fin = Deps.modelStore.state.value.rows.firstOrNull { it.id == id }
                    when (fin?.state) {
                        ModelState.ERROR ->
                            showFinal(DownloadNotify.failTitle(), DownloadNotify.errorText(fin.message))
                        // IDLE/DOWNLOADING сюда — значит отмена или сброс состояния: молча.
                        ModelState.IDLE, ModelState.DOWNLOADING -> Unit
                        // COMPLETED или строка удалена во время скачивания.
                        else -> showFinal(DownloadNotify.doneTitle(), row.name)
                    }
                    stopSelf()
                }
            }
            ACTION_CANCEL -> {
                // stopSelf() → onDestroy() → scope.cancel() прекращает скачивание.
                // modelStore.cancel() здесь НЕ вызывать: он шлёт этот же intent — зациклится.
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
        val percent = DownloadNotify.percent(fraction)
        val notif = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.stat_sys_download)
            .setContentTitle(title)
            .setContentText(DownloadNotify.progressText(fraction))
            .setOngoing(true)
            .setOnlyAlertOnce(true)
            .setProgress(100, percent, false)
            .setContentIntent(openModelsIntent())
            .build()
        notificationManager?.notify(NOTIFICATION_ID, notif)
    }

    private fun buildNotification(title: String, fraction: Float): Notification =
        NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.stat_sys_download)
            .setContentTitle(title)
            .setContentText(DownloadNotify.progressText(fraction))
            .setOngoing(true)
            .setProgress(100, DownloadNotify.percent(fraction), false)
            .setContentIntent(openModelsIntent())
            .build()

    // T-056: итог скачивания — отдельный финальный баннер (id ≠ NOTIFICATION_ID,
    // чтобы onDestroy его не гасил); при следующем скачивании снимается.
    private fun showFinal(title: String, text: String) {
        val notif = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.stat_sys_download_done)
            .setContentTitle(title)
            .setContentText(text)
            .setAutoCancel(true)
            .setContentIntent(openModelsIntent())
            .build()
        notificationManager?.notify(FINAL_NOTIFICATION_ID, notif)
    }

    // Тап по любому уведомлению загрузки ведёт на экран «Модели» (роут llm-models).
    private fun openModelsIntent(): PendingIntent {
        val intent = Intent(this, MainActivity::class.java)
            .putExtra(MainActivity.EXTRA_ROUTE, "llm-models")
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        return PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT,
        )
    }

    companion object {
        private const val CHANNEL_ID = "model_downloads"
        private const val NOTIFICATION_ID = 1001
        private const val FINAL_NOTIFICATION_ID = 1002
        const val ACTION_DOWNLOAD = "ru.vldkr.shkaff.llm.DOWNLOAD"
        const val ACTION_CANCEL = "ru.vldkr.shkaff.llm.CANCEL"
        const val EXTRA_ID = "record_id"
    }
}