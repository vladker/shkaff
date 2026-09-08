package ru.vldkr.shkaff.data.printer

// Результат опроса принтера (команда ESC ## JXIG): фирмварь лейбл-принтеров сама сообщает,
// в каком режиме команд она работает — "01" = ESC/POS, "02" = TSC (TSPL).
data class PrinterProbe(
    val cmdModeHex: String?,
    val dpiTypeHex: String?
)

// Канал отправки данных на принтер (или «гарантированный путь» — Share)
interface Transport {
    suspend fun send(bytes: ByteArray): Result<Unit>

    // Необязательный опрос принтера; транспорты без ответного канала возвращают null.
    suspend fun probe(): Result<PrinterProbe?> = Result.success(null)
}