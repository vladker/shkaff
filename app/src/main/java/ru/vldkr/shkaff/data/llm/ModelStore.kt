package ru.vldkr.shkaff.data.llm

import android.content.Context
import android.content.Intent
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.ensureActive
import kotlin.coroutines.coroutineContext
import org.json.JSONArray
import org.json.JSONObject
import ru.vldkr.shkaff.domain.llm.ModelPreset
import ru.vldkr.shkaff.domain.llm.ModelRegistry
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.UUID

enum class ModelState { IDLE, DOWNLOADING, COMPLETED, ERROR }

/**
 * Строка «модели» в каталоге устройства. Внешние GGUF-файлы живут только на
 * устройстве (getExternalFilesDir("models")) — в Room и в бэкап не попадают,
 * поэтому миграции БД не затрагиваются.
 */
data class ModelRow(
    val id: String,
    val name: String,
    val file: String,
    val url: String,
    val sizeBytes: Long,
    val mmprojFile: String? = null,
    val mmprojUrl: String? = null,
    val mmprojSizeBytes: Long? = null,
    val custom: Boolean = false,
    val state: ModelState = ModelState.IDLE,
    val message: String? = null,
    val quantId: String = "",
    val quantName: String = "",
)

data class StoreState(
    val rows: List<ModelRow> = emptyList(),
    val activeId: String? = null,
    val activeName: String? = null,
    val bytes: Long = 0,
    val total: Long = 0,
)

private data class CustomModel(
    val id: String,
    val name: String,
    val file: String,
    val url: String,
    val sizeBytes: Long,
)

/**
 * Синглтон (в Deps): каталог моделей, индекс пользовательских моделей и текущая
 * загрузка. Файлы скачиваются в «*.part» и переименовываются по завершении,
 * поэтому прерванная загрузка продолжается с места остановки (HTTP Range).
 */
class ModelStore(private val context: Context) {

    private val _state = MutableStateFlow(StoreState())
    val state: StateFlow<StoreState> = _state

    val activeFile: String?
        get() = _state.value.activeName

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var activeJob: Job? = null

    init {
        dir.mkdirs()
        reload()
    }

    val dir: File
        get() = context.getExternalFilesDir("models")
            ?: File(context.filesDir, "models").also { it.mkdirs() }

    fun reload() {
        val rows = ModelRegistry.presets.flatMap { preset ->
            preset.quantizations.map { quant ->
                rowOf(preset, quant)
            }
        } + customs.map { rowOf(it) }
        val prevActive = _state.value.activeName
        _state.value = StoreState(rows = rows, activeName = prevActive)
    }

    private fun rowOf(p: ModelPreset, q: ModelQuantization) = ModelRow(
        id = "${p.id}-${q.id}",
        name = "${p.name} (${q.name})",
        file = q.fileName,
        url = q.url,
        sizeBytes = q.sizeBytes,
        mmprojFile = p.mmprojFile,
        mmprojUrl = p.mmprojUrl,
        mmprojSizeBytes = p.mmprojSizeBytes,
        quantId = q.id,
        quantName = q.name,
    )

    private fun rowOf(c: CustomModel) = ModelRow(
        id = c.id,
        name = c.name,
        file = c.file,
        url = c.url,
        sizeBytes = c.sizeBytes,
        custom = true,
    )

    fun isDownloaded(row: ModelRow): Boolean = fileComplete(row.file, row.sizeBytes)

    fun fileComplete(file: String, expected: Long): Boolean {
        val f = File(dir, file)
        return f.exists() && (expected <= 0 || f.length() >= expected)
    }

    fun mmprojDone(row: ModelRow): Boolean =
        row.mmprojFile?.let { File(dir, it).exists() } == true

    fun partBytes(file: String): Long {
        val p = File(dir, file + PART)
        return if (p.exists()) p.length() else 0L
    }

    /** Прогресс активного файла из ModelDownloadService. */
    fun trackProgress(file: String, bytes: Long, total: Long) {
        val s = _state.value
        _state.value = s.copy(activeName = file, bytes = bytes, total = total)
    }

    /** Запуск выбранной модели: сигналит foreground-сервису выполнить скачивание. */
    fun start(row: ModelRow) {
        if (_state.value.activeName != null) return
        updateRow(row.id) { it.copy(state = ModelState.DOWNLOADING, message = null) }
        _state.value = _state.value.copy(activeId = row.id, activeName = row.file)
        val i = Intent(context, ModelDownloadService::class.java)
            .setAction(ModelDownloadService.ACTION_DOWNLOAD)
            .putExtra(ModelDownloadService.EXTRA_ID, row.id)
        context.startForegroundService(i)
    }

    /** Отмена активной загрузки: файл «*.part» сохраняется для возобновления. */
    fun cancel() {
        activeJob?.cancel()
        _state.value = _state.value.copy(activeId = null, activeName = null, bytes = 0, total = 0)
        val s = _state.value.rows
        if (s.isNotEmpty()) {
            _state.value = _state.value.copy(rows = s.map { it.copy(state = ModelState.IDLE, message = null) })
        }
    }

    /**
     * Вызывается из ModelDownloadService. Гоняет файлы (основной + mmproj для
     * vision) в scope сервиса и публикует прогресс в state + уведомление.
     */
    suspend fun perform(row: ModelRow, onProgress: (name: String, fraction: Float) -> Unit) {
        updateRow(row.id) { it.copy(state = ModelState.DOWNLOADING, message = null) }
        try {
            if (!fileComplete(row.file, row.sizeBytes)) {
                downloadFile(row.file, row.url, row.sizeBytes) { done -> onProgress(row.file, frac(done, row.sizeBytes)) }
            }
            if (row.mmprojFile != null && row.mmprojUrl != null && row.mmprojSizeBytes != null) {
                if (!fileComplete(row.mmprojFile, row.mmprojSizeBytes)) {
                    downloadFile(row.mmprojFile, row.mmprojUrl, row.mmprojSizeBytes) { done ->
                        onProgress(row.mmprojFile!!, frac(done, row.mmprojSizeBytes!!))
                    }
                }
            }
            updateRow(row.id) { it.copy(state = ModelState.COMPLETED, message = null) }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            updateRow(row.id) { it.copy(state = ModelState.ERROR, message = e.message ?: "Ошибка загрузки") }
        }
    }

    private fun frac(done: Long, total: Long) =
        if (total <= 0) 0f else (done.toFloat() / total).coerceIn(0f, 1f)

    /** Скачивание одного файла с докачкой по HTTP Range; отмена = CancellationException. */
    private suspend fun downloadFile(file: String, url: String, expected: Long, onProgress: (Long) -> Unit) {
        val part = File(dir, file + PART)
        var written = if (part.exists()) part.length() else 0L
        var conn: HttpURLConnection? = null
        try {
            conn = (URL(url).openConnection() as HttpURLConnection).apply {
                connectTimeout = 20_000
                readTimeout = 120_000
                instanceFollowRedirects = true
                setRequestProperty("User-Agent", "Shkaff/1.0")
                setRequestProperty("Accept-Encoding", "identity")
                if (written > 0) setRequestProperty("Range", "bytes=$written-")
            }
            val code = conn.responseCode
            if (code !in 200..299) throw IOException("HTTP $code")
            if (code == 200 && written > 0) {
                // сервер проигнорировал Range — начинаем с нуля
                written = 0
                part.delete()
            }
            val completed: Long
            conn.inputStream.use { ins ->
                FileOutputStream(part, true).use { out ->
                    val buf = ByteArray(256 * 1024)
                    var done = written
                    while (true) {
                        val n = ins.read(buf)
                        if (n < 0) break
                        out.write(buf, 0, n)
                        done += n
                        onProgress(done)
                        coroutineContext.ensureActive()
                    }
                    completed = done
                }
            }
            if (expected > 0 && completed != expected) throw IOException("Размер файла не совпал: ожидалось $expected")
            val target = File(dir, file)
            if (target.exists()) target.delete()
            if (!part.renameTo(target)) {
                part.copyTo(target, overwrite = true)
                part.delete()
            }
        } finally {
            conn?.disconnect()
        }
    }

    private fun done() = _state.value.bytes

    fun delete(row: ModelRow) {
        if (_state.value.activeName == row.file) cancel()
        File(dir, row.file).delete()
        File(dir, row.file + PART).delete()
        row.mmprojFile?.let { File(dir, it).delete() }
        if (row.custom) {
            val rest = customs.filterNot { it.id == row.id }
            saveCustoms(rest)
        }
        reload()
    }

    /** Добавление произвольной модели по ссылке (как в LM Studio). */
    fun addCustom(rawUrl: String): Result<ModelRow> {
        val u = rawUrl.trim()
        return runCatching {
            require(u.startsWith("https://") || u.startsWith("http://")) { "Нужна ссылка http(s)" }
            val file = u.substringAfterLast('/').substringBefore('?').trim()
            require(file.isNotEmpty() && file.contains('.')) { "Ссылка должна вести на файл" }
            require(_state.value.rows.none { it.file == file }) { "Такая модель уже в списке" }
            val row = CustomModel(UUID.randomUUID().toString(), file.substringBeforeLast('.'), file, u, 0)
            saveCustoms(customs + row)
            reload()
            _state.value.rows.first { it.id == row.id }
        }
    }

    private fun customIndex() = File(dir, ".custom.json")

    private val customs: List<CustomModel>
        get() {
            val f = customIndex()
            if (!f.exists()) return emptyList()
            return kotlin.runCatching {
                val arr = JSONArray(f.readText())
                (0 until arr.length()).mapNotNull { i ->
                    val o = arr.getJSONObject(i)
                    CustomModel(o.getString("id"), o.getString("name"), o.getString("file"), o.getString("url"), o.getLong("sizeBytes"))
                }
            }.getOrDefault(emptyList())
        }

    private fun saveCustoms(list: List<CustomModel>) {
        val arr = JSONArray()
        list.forEach { c ->
            arr.put(JSONObject().apply {
                put("id", c.id)
                put("name", c.name)
                put("file", c.file)
                put("url", c.url)
                put("sizeBytes", c.sizeBytes)
            })
        }
        customIndex().writeText(arr.toString())
    }

    private fun updateRow(id: String, transform: (ModelRow) -> ModelRow) {
        val s = _state.value
        _state.value = s.copy(rows = s.rows.map { if (it.id == id) transform(it) else it })
    }

    companion object {
        private const val PART = ".part"
    }
}