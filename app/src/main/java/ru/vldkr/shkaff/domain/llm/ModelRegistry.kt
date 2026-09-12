package ru.vldkr.shkaff.domain.llm

/**
 * Прессеты моделей для локального ИИ-агента (этап 2: скачивание «как в LM Studio»).
 * Ссылки — прямые resolve-URL Hugging Face (ungated репозитории); имя файла —
 * последний сегмент URL. Для vision-модели mmproj скачивается отдельным файлом.
 */
data class ModelPreset(
    val id: String,
    val name: String,
    val description: String,
    val url: String,
    val fileName: String,
    val sizeBytes: Long,
    val mmprojUrl: String? = null,
    val mmprojFile: String? = null,
    val mmprojSizeBytes: Long? = null,
    val recommended: Boolean = false,
)

object ModelRegistry {

    val presets: List<ModelPreset> = listOf(
        ModelPreset(
            id = "qwen3-4b-thinking",
            name = "Qwen3 4B Thinking",
            description = "Умная модель-агент: размышляет перед ответом. Для S24 Ultra и мощнее.",
            url = "https://huggingface.co/lmstudio-community/Qwen3-4B-Thinking-2507-GGUF/resolve/main/Qwen3-4B-Thinking-2507-Q4_K_M.gguf",
            fileName = "Qwen3-4B-Thinking-2507-Q4_K_M.gguf",
            sizeBytes = 2497280448,
            recommended = true,
        ),
        ModelPreset(
            id = "qwen3-1-7b",
            name = "Qwen3 1.7B",
            description = "Лёгкая модель для слабых устройств. Меньше думает — быстрее отвечает.",
            url = "https://huggingface.co/lmstudio-community/Qwen3-1.7B-GGUF/resolve/main/Qwen3-1.7B-Q4_K_M.gguf",
            fileName = "Qwen3-1.7B-Q4_K_M.gguf",
            sizeBytes = 1282439328,
        ),
        ModelPreset(
            id = "qwen3-vl-4b",
            name = "Qwen3-VL 4B",
            description = "Vision: понимает фото, читает этикетки. Требует дополнительный файл mmproj.",
            url = "https://huggingface.co/lmstudio-community/Qwen3-VL-4B-Instruct-GGUF/resolve/main/Qwen3-VL-4B-Instruct-Q4_K_M.gguf",
            fileName = "Qwen3-VL-4B-Instruct-Q4_K_M.gguf",
            sizeBytes = 2497281568,
            mmprojUrl = "https://huggingface.co/lmstudio-community/Qwen3-VL-4B-Instruct-GGUF/resolve/main/mmproj-Qwen3-VL-4B-Instruct-F16.gguf",
            mmprojFile = "mmproj-Qwen3-VL-4B-Instruct-F16.gguf",
            mmprojSizeBytes = 836180160,
        ),
    )
}