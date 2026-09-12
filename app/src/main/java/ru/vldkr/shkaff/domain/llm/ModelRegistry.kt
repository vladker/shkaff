package ru.vldkr.shkaff.domain.llm

/**
 * Прессеты моделей для локального ИИ-агента (этап 2: скачивание «как в LM Studio»).
 * Ссылки — прямые resolve-URL Hugging Face (ungated репозитории); имя файла —
 * последний сегмент URL. Для vision-модели mmproj скачивается отдельным файлом.
 */
data class ModelQuantization(
    val id: String,
    val name: String,
    val url: String,
    val fileName: String,
    val sizeBytes: Long,
    val description: String = "",
)

data class ModelPreset(
    val id: String,
    val name: String,
    val description: String,
    val quantizations: List<ModelQuantization>,
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
            quantizations = listOf(
                ModelQuantization(
                    id = "q3_k_l",
                    name = "Q3_K_L",
                    url = "https://huggingface.co/lmstudio-community/Qwen3-4B-Thinking-2507-GGUF/resolve/main/Qwen3-4B-Thinking-2507-Q3_K_L.gguf",
                    fileName = "Qwen3-4B-Thinking-2507-Q3_K_L.gguf",
                    sizeBytes = 2239785408,
                    description = "2.1 ГБ · быстрая, меньше точность"
                ),
                ModelQuantization(
                    id = "q4_k_m",
                    name = "Q4_K_M",
                    url = "https://huggingface.co/lmstudio-community/Qwen3-4B-Thinking-2507-GGUF/resolve/main/Qwen3-4B-Thinking-2507-Q4_K_M.gguf",
                    fileName = "Qwen3-4B-Thinking-2507-Q4_K_M.gguf",
                    sizeBytes = 2497280448,
                    description = "2.3 ГБ · баланс скорости и качества (рекомендуется)"
                ),
                ModelQuantization(
                    id = "q6_k",
                    name = "Q6_K",
                    url = "https://huggingface.co/lmstudio-community/Qwen3-4B-Thinking-2507-GGUF/resolve/main/Qwen3-4B-Thinking-2507-Q6_K.gguf",
                    fileName = "Qwen3-4B-Thinking-2507-Q6_K.gguf",
                    sizeBytes = 3306260928,
                    description = "3.1 ГБ · высокая точность"
                ),
                ModelQuantization(
                    id = "q8_0",
                    name = "Q8_0",
                    url = "https://huggingface.co/lmstudio-community/Qwen3-4B-Thinking-2507-GGUF/resolve/main/Qwen3-4B-Thinking-2507-Q8_0.gguf",
                    fileName = "Qwen3-4B-Thinking-2507-Q8_0.gguf",
                    sizeBytes = 4280404928,
                    description = "4.0 ГБ · максимальная точность"
                )
            ),
            recommended = true,
        ),
        ModelPreset(
            id = "qwen3-1-7b",
            name = "Qwen3 1.7B",
            description = "Лёгкая модель для слабых устройств. Меньше думает — быстрее отвечает.",
            quantizations = listOf(
                ModelQuantization(
                    id = "q4_k_m",
                    name = "Q4_K_M",
                    url = "https://huggingface.co/lmstudio-community/Qwen3-1.7B-GGUF/resolve/main/Qwen3-1.7B-Q4_K_M.gguf",
                    fileName = "Qwen3-1.7B-Q4_K_M.gguf",
                    sizeBytes = 1282439328,
                    description = "1.2 ГБ · баланс"
                )
            ),
        ),
        ModelPreset(
            id = "qwen3-vl-4b",
            name = "Qwen3-VL 4B",
            description = "Vision: понимает фото, читает этикетки. Требует дополнительный файл mmproj.",
            quantizations = listOf(
                ModelQuantization(
                    id = "q4_k_m",
                    name = "Q4_K_M",
                    url = "https://huggingface.co/lmstudio-community/Qwen3-VL-4B-Instruct-GGUF/resolve/main/Qwen3-VL-4B-Instruct-Q4_K_M.gguf",
                    fileName = "Qwen3-VL-4B-Instruct-Q4_K_M.gguf",
                    sizeBytes = 2497281568,
                    description = "2.3 ГБ · баланс"
                )
            ),
            mmprojUrl = "https://huggingface.co/lmstudio-community/Qwen3-VL-4B-Instruct-GGUF/resolve/main/mmproj-Qwen3-VL-4B-Instruct-F16.gguf",
            mmprojFile = "mmproj-Qwen3-VL-4B-Instruct-F16.gguf",
            mmprojSizeBytes = 836180160,
        ),
        ModelPreset(
            id = "gemma-4-e2b-it",
            name = "Gemma 4 E2B IT",
            description = "Новая модель Google для агентских задач. Требует мощный телефон.",
            quantizations = listOf(
                ModelQuantization(
                    id = "q3_k_s",
                    name = "Q3_K_S",
                    url = "https://huggingface.co/unsloth/gemma-4-E2B-it-GGUF/resolve/main/gemma-4-E2B-it-Q3_K_S.gguf",
                    fileName = "gemma-4-E2B-it-Q3_K_S.gguf",
                    sizeBytes = 2445652064,
                    description = "2.3 ГБ · быстрая"
                ),
                ModelQuantization(
                    id = "q3_k_m",
                    name = "Q3_K_M",
                    url = "https://huggingface.co/unsloth/gemma-4-E2B-it-GGUF/resolve/main/gemma-4-E2B-it-Q3_K_M.gguf",
                    fileName = "gemma-4-E2B-it-Q3_K_M.gguf",
                    sizeBytes = 2536786016,
                    description = "2.4 ГБ · баланс скорости"
                ),
                ModelQuantization(
                    id = "q4_k_s",
                    name = "Q4_K_S",
                    url = "https://huggingface.co/unsloth/gemma-4-E2B-it-GGUF/resolve/main/gemma-4-E2B-it-Q4_K_S.gguf",
                    fileName = "gemma-4-E2B-it-Q4_K_S.gguf",
                    sizeBytes = 3043934304,
                    description = "2.8 ГБ · компактная"
                ),
                ModelQuantization(
                    id = "q4_k_m",
                    name = "Q4_K_M",
                    url = "https://huggingface.co/unsloth/gemma-4-E2B-it-GGUF/resolve/main/gemma-4-E2B-it-Q4_K_M.gguf",
                    fileName = "gemma-4-E2B-it-Q4_K_M.gguf",
                    sizeBytes = 3106738272,
                    description = "2.9 ГБ · баланс (рекомендуется)"
                ),
                ModelQuantization(
                    id = "q4_1",
                    name = "Q4_1",
                    url = "https://huggingface.co/unsloth/gemma-4-E2B-it-GGUF/resolve/main/gemma-4-E2B-it-Q4_1.gguf",
                    fileName = "gemma-4-E2B-it-Q4_1.gguf",
                    sizeBytes = 3154919520,
                    description = "2.9 ГБ · улучшенная"
                ),
                ModelQuantization(
                    id = "q5_k_s",
                    name = "Q5_K_S",
                    url = "https://huggingface.co/unsloth/gemma-4-E2B-it-GGUF/resolve/main/gemma-4-E2B-it-Q5_K_S.gguf",
                    fileName = "gemma-4-E2B-it-Q5_K_S.gguf",
                    sizeBytes = 3321151584,
                    description = "3.1 ГБ · высокая точность"
                ),
                ModelQuantization(
                    id = "q5_k_m",
                    name = "Q5_K_M",
                    url = "https://huggingface.co/unsloth/gemma-4-E2B-it-GGUF/resolve/main/gemma-4-E2B-it-Q5_K_M.gguf",
                    fileName = "gemma-4-E2B-it-Q5_K_M.gguf",
                    sizeBytes = 3356037216,
                    description = "3.1 ГБ · высокая точность"
                ),
                ModelQuantization(
                    id = "q6_k",
                    name = "Q6_K",
                    url = "https://huggingface.co/unsloth/gemma-4-E2B-it-GGUF/resolve/main/gemma-4-E2B-it-Q6_K.gguf",
                    fileName = "gemma-4-E2B-it-Q6_K.gguf",
                    sizeBytes = 4501721184,
                    description = "4.2 ГБ · очень высокая точность"
                ),
                ModelQuantization(
                    id = "q8_0",
                    name = "Q8_0",
                    url = "https://huggingface.co/unsloth/gemma-4-E2B-it-GGUF/resolve/main/gemma-4-E2B-it-Q8_0.gguf",
                    fileName = "gemma-4-E2B-it-Q8_0.gguf",
                    sizeBytes = 5048352864,
                    description = "4.7 ГБ · максимальная точность"
                )
            ),
        ),
        ModelPreset(
            id = "ornith-1.5-9b",
            name = "Ornith 1.5 9B",
            description = "Мощная универсальная модель для агентских задач. Требует флагманский телефон (12+ ГБ ОЗУ).",
            quantizations = listOf(
                ModelQuantization(
                    id = "q4_k_m",
                    name = "Q4_K_M",
                    url = "https://huggingface.co/ornith-ai/Ornith-1.5-9B-GGUF/resolve/main/Ornith-1.5-9B-Q4_K_M.gguf",
                    fileName = "Ornith-1.5-9B-Q4_K_M.gguf",
                    sizeBytes = 5780090816,
                    description = "5.4 ГБ · баланс"
                ),
                ModelQuantization(
                    id = "q5_k_m",
                    name = "Q5_K_M",
                    url = "https://huggingface.co/ornith-ai/Ornith-1.5-9B-GGUF/resolve/main/Ornith-1.5-9B-Q5_K_M.gguf",
                    fileName = "Ornith-1.5-9B-Q5_K_M.gguf",
                    sizeBytes = 6642544576,
                    description = "6.2 ГБ · высокая точность"
                ),
                ModelQuantization(
                    id = "q6_k",
                    name = "Q6_K",
                    url = "https://huggingface.co/ornith-ai/Ornith-1.5-9B-GGUF/resolve/main/Ornith-1.5-9B-Q6_K.gguf",
                    fileName = "Ornith-1.5-9B-Q6_K.gguf",
                    sizeBytes = 7558901696,
                    description = "7.0 ГБ · очень высокая точность"
                ),
                ModelQuantization(
                    id = "q8_0",
                    name = "Q8_0",
                    url = "https://huggingface.co/ornith-ai/Ornith-1.5-9B-GGUF/resolve/main/Ornith-1.5-9B-Q8_0.gguf",
                    fileName = "Ornith-1.5-9B-Q8_0.gguf",
                    sizeBytes = 9786060384,
                    description = "9.1 ГБ · максимальная точность"
                )
            ),
        ),
    )
}