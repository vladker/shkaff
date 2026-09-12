package ru.vldkr.shkaff.domain.agent

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.llm.LlamaBridge
import ru.vldkr.shkaff.llm.LlamaGenerationCallback
import java.io.File
import java.util.concurrent.atomic.AtomicReference

// US-B3: офлайн-провайдер. Модель — GGUF из каталога приложения
// (`settings.model` = имя файла), vision-модель ищет по mmproj из строки каталога.
// Движок один и stateful, поэтому каждый запрос собирается заново:
// система — через setSystemPrompt, остальной дилог — одним текстовым транскриптом.
object DeviceLlm {

    const val N_MAX_TOKENS = 2048

    suspend fun complete(
        settings: AgentSettings,
        messages: List<ChatMessage>,
        onToken: (String) -> Unit = {},
    ): String = withContext(Dispatchers.IO) {
        val fileName = settings.model.trim()
        if (fileName.isEmpty()) {
            throw IllegalStateException("Модель на устройстве не выбрана — откройте «Модели» и скачайте GGUF")
        }
        val dir = Deps.modelStore.dir
        val file = File(dir, fileName)
        if (!file.isFile) {
            throw IllegalStateException("Модель не скачана ($fileName). Скачайте её в разделе «Модели»")
        }
        val mmprojPath = Deps.modelStore.state.value.rows
            .firstOrNull { it.file == fileName && !it.mmprojFile.isNullOrBlank() }
            ?.mmprojFile
            ?.let { File(dir, it) }
            ?.takeIf { it.isFile }
            ?.absolutePath

        val code = LlmRuntime.ensureLoaded(file.absolutePath, mmprojPath)
        if (code != LlamaBridge.OK) {
            throw IllegalStateException("Не удалось загрузить модель: ${LlamaBridge.lastError().ifBlank { "код $code" }}")
        }

        val system = messages.filter { it.role == "system" }.joinToString("\n") { it.content }.trim()
        if (system.isNotEmpty()) {
            LlamaBridge.setSystemPrompt(system)
        } else {
            LlamaBridge.resetChat()
        }

        val transcript = buildTranscript(messages.filter { it.role != "system" })
        val sb = StringBuilder()
        val errMsg = AtomicReference<String?>(null)
        val rc = LlamaBridge.complete(
            prompt = transcript,
            imagePath = null,
            nMaxTokens = N_MAX_TOKENS,
            cb = object : LlamaGenerationCallback {
                override fun onToken(text: String) {
                    sb.append(text)
                    onToken(text)
                }

                override fun onError(code: Int, message: String) {
                    errMsg.set(message)
                }
            },
        )
        val out = sb.toString().trim()
        if (out.isEmpty()) {
            val reason = errMsg.get() ?: LlamaBridge.lastError().ifBlank {
                if (rc == LlamaBridge.ABORTED) "генерация прервана" else "модель не ответила"
            }
            throw IllegalStateException(reason)
        }
        out
    }

    fun abort() = LlamaBridge.abort()

    // Дилог для промпта одной строкой на реплику: модель получает весь контекст
    // в одном user-сообщении, KV-кэш не накапливается между запросами.
    fun buildTranscript(messages: List<ChatMessage>): String {
        val sb = StringBuilder()
        var hasTurn = false
        for (m in messages) {
            if (m.role == "system") continue
            val role = if (m.role == "assistant") "Ассистент" else "Пользователь"
            sb.append(role).append(": ").append(m.content.trim()).append("\n")
            hasTurn = true
        }
        if (hasTurn) sb.append("Ассистент:")
        return sb.toString().trimEnd()
    }
}
