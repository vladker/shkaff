package ru.vldkr.shkaff.data.printer

// Канал отправки данных на принтер (или «гарантированный путь» — Share)
interface Transport {
    suspend fun send(bytes: ByteArray): Result<Unit>
}
