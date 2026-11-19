package ru.vldkr.shkaff.data.llm

import android.content.Context
import android.content.Intent
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.json.JSONArray
import org.json.JSONObject
import ru.vldkr.shkaff.domain.llm.ModelPreset
import ru.vldkr.shkaff.domain.llm.ModelQuantization
import ru.vldkr.shkaff.domain.llm.ModelRegistry
import ru.vldkr.shkaff.domain.llm.StorageFit
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.UUID
import kotlin.coroutines.coroutineContext

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
    // T-057: битый индекс своих моделей — список не должен молча исчезать в ноль,
    // экран обязан показать причину.
    val customsError: String? = null,
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
class ModelStore(
    private val context: Context,
) {
    private val _state = MutableStateFlow(StoreState())
    val state: StateFlow<StoreState> = _state

    val activeFile: String?
        get() = _state.value.activeName

    init {
        dir.mkdirs()
        reload()
    }

    val dir: File
        get() =
            context.getExternalFilesDir("models")
                ?: File(context.filesDir, "models").also { it.mkdirs() }

    fun reload() {
        val (customs, customsError) = readCustoms()
        val rows =
            ModelRegistry.presets.flatMap { preset ->
                preset.quantizations.map { quant ->
                    rowOf(preset, quant)
                }
            } + customs.map { rowOf(it) }
        val prevActive = _state.value.activeName
        _state.value = StoreState(rows = rows, activeName = prevActive, customsError = customsError)
    }

    private fun rowOf(
        p: ModelPreset,
        q: ModelQuantization,
    ) = ModelRow(
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

    private fun rowOf(c: CustomModel) =
        ModelRow(
            id = c.id,
            name = c.name,
            file = c.file,
            url = c.url,
            sizeBytes = c.sizeBytes,
            custom = true,
        )

    fun isDownloaded(row: ModelRow): Boolean = fileComplete(row.file, row.sizeBytes)

    fun fileComplete(
        file: String,
        expected: Long,
    ): Boolean {
        val f = File(dir, file)
        return f.exists() && (expected <= 0 || f.length() >= expected)
    }

    fun mmprojDone(row: ModelRow): Boolean = row.mmprojFile?.let { File(dir, it).exists() } == true

    fun partBytes(file: String): Long {
        val p = File(dir, file + PART)
        return if (p.exists()) p.length() else 0L
    }

    /** Прогресс активного файла из ModelDownloadService. */
    fun trackProgress(
        file: String,
        bytes: Long,
        total: Long,
    ) {
        val s = _state.value
        _state.value = s.copy(activeName = file, bytes = bytes, total = total)
    }

    /** Запуск выбранной модели: сигналит foreground-сервису выполнить скачивание. */
    fun start(row: ModelRow) {
        // T-055: параллельная загрузка запрещена, но молча игнорировать нажатие
        // нельзя — строка обязана объяснить, почему «Скачать» не сработало.
        val busy = _state.value.activeName
        if (busy != null) {
            updateRow(row.id) {
                it.copy(state = ModelState.ERROR, message = "Одновременно качается другая модель («$busy»). Дождитесь её или отмените.")
            }
            return
        }
        // T-052: GGUF до 10 ГБ писались вслепую и ловили ENOSPC посреди загрузки —
        // сперва сверяем остаток (с учётом *.part) со свободным местом и запасом.
        val needed =
            StorageFit.requiredBytes(
                mainSize = row.sizeBytes,
                mainDone = partBytes(row.file),
                mmprojSize = if (row.mmprojFile != null && row.mmprojUrl != null) row.mmprojSizeBytes else null,
                mmprojDone = row.mmprojFile?.let { partBytes(it) } ?: 0L,
            )
        val usable = dir.usableSpace
        if (!StorageFit.fits(needed, usable)) {
            updateRow(row.id) {
                it.copy(state = ModelState.ERROR, message = StorageFit.notEnoughSpaceText(needed, usable))
            }
            return
        }
        updateRow(row.id) { it.copy(state = ModelState.DOWNLOADING, message = null) }
        _state.value = _state.value.copy(activeId = row.id, activeName = row.file)
        val i =
            Intent(context, ModelDownloadService::class.java)
                .setAction(ModelDownloadService.ACTION_DOWNLOAD)
                .putExtra(ModelDownloadService.EXTRA_ID, row.id)
        context.startForegroundService(i)
    }

    /** Отмена активной загрузки: файл «*.part» сохраняется для возобновления. */
    fun cancel() {
        // Скачивание живёт в scope сервиса — гасим его через ACTION_CANCEL
        // (onDestroy сервиса отменит coroutine), а локальное состояние чистим тут.
        context.startService(
            Intent(context, ModelDownloadService::class.java).setAction(ModelDownloadService.ACTION_CANCEL),
        )
        val s = _state.value
        val activeId = s.activeId
        val activeFile = s.activeName
        _state.value =
            s.copy(
                activeId = null,
                activeName = null,
                bytes = 0,
                total = 0,
                // T-055: сбрасываем только отменённую строку — чужие состояния
                // (например, ошибка «недостаточно места») терять нельзя.
                rows =
                    s.rows.map {
                        if (it.id == activeId || it.file == activeFile || it.mmprojFile == activeFile) {
                            it.copy(state = ModelState.IDLE, message = null)
                        } else {
                            it
                        }
                    },
            )
    }

    /**
     * Вызывается из ModelDownloadService. Гоняет файлы (основной + mmproj для
     * vision) в scope сервиса и публикует прогресс в state + уведомление.
     */
    suspend fun perform(
        row: ModelRow,
        onProgress: (name: String, fraction: Float) -> Unit,
    ) {
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
            // ENOSPC из середины докачки показываем по-русски (T-052), прочее — как есть.
            updateRow(row.id) { it.copy(state = ModelState.ERROR, message = StorageFit.errorText(e)) }
        } finally {
            // После завершения (успех/ошибка/отмена) сбрасываем «активную загрузку»,
            // иначе UI зависает на прогресс-баре и другие модели скачать нельзя
            val s = _state.value
            if (s.activeId == row.id || s.activeName == row.file || s.activeName == row.mmprojFile) {
                _state.value = s.copy(activeId = null, activeName = null, bytes = 0, total = 0)
            }
        }
    }

    private fun frac(
        done: Long,
        total: Long,
    ) = if (total <= 0) 0f else (done.toFloat() / total).coerceIn(0f, 1f)

    /** Скачивание одного файла с докачкой по HTTP Range; отмена = CancellationException. */
    private suspend fun downloadFile(
        file: String,
        url: String,
        expected: Long,
        onProgress: (Long) -> Unit,
    ) {
        val part = File(dir, file + PART)
        var written = if (part.exists()) part.length() else 0L
        var conn: HttpURLConnection? = null
        try {
            conn =
                (URL(url).openConnection() as HttpURLConnection).apply {
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

    fun delete(row: ModelRow) {
        // T-054: во время докачки vision-файла activeName == mmprojFile — без
        // отмены сервис после удаления переименовывает *.part обратно в файл.
        val active = _state.value.activeName
        if (active == row.file || (row.mmprojFile != null && active == row.mmprojFile)) cancel()
        File(dir, row.file).delete()
        File(dir, row.file + PART).delete()
        row.mmprojFile?.let {
            File(dir, it).delete()
            File(dir, it + PART).delete()
        }
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

    /**
     * T-057: чтение индекса своих моделей. Битый файл нельзя молча превращать
     * в пустой список: сохраняем копию битого («.custom.json.corrupt») и
     * возвращаем русское сообщение об ошибке для флага в StoreState.
     */
    private fun readCustoms(): Pair<List<CustomModel>, String?> {
        val f = customIndex()
        if (!f.exists()) return emptyList<CustomModel>() to null
        return try {
            val arr = JSONArray(f.readText())
            (0 until arr.length()).map { i ->
                val o = arr.getJSONObject(i)
                CustomModel(o.getString("id"), o.getString("name"), o.getString("file"), o.getString("url"), o.getLong("sizeBytes"))
            } to null
        } catch (e: Exception) {
            val bak = File(dir, customIndex().name + ".corrupt")
            runCatching { f.copyTo(bak, overwrite = true) }
            emptyList<CustomModel>() to
                "Список своих моделей повреждён: файл индекса не разобрался. Копия битого файла сохранена " +
                "как «${bak.name}», список очищен. Добавьте модели заново — индекс будет перезаписан."
        }
    }

    private val customs: List<CustomModel>
        get() = readCustoms().first

    private fun saveCustoms(list: List<CustomModel>) {
        val arr = JSONArray()
        list.forEach { c ->
            arr.put(
                JSONObject().apply {
                    put("id", c.id)
                    put("name", c.name)
                    put("file", c.file)
                    put("url", c.url)
                    put("sizeBytes", c.sizeBytes)
                },
            )
        }
        customIndex().writeText(arr.toString())
    }

    private fun updateRow(
        id: String,
        transform: (ModelRow) -> ModelRow,
    ) {
        val s = _state.value
        _state.value = s.copy(rows = s.rows.map { if (it.id == id) transform(it) else it })
    }

    companion object {
        private const val PART = ".part"
    }
}
