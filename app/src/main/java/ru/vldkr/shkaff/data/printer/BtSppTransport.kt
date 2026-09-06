package ru.vldkr.shkaff.data.printer

import android.bluetooth.BluetoothAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

// Bluetooth Classic SPP (RFCOMM, канал 1)
class BtSppTransport(
    private val mac: String
) : Transport {

    companion object {
        val SPP_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-001020000011")
    }

    override suspend fun send(bytes: ByteArray): Result<Unit> = withContext(Dispatchers.IO) {
        val result = runCatching {
            require(mac.isNotBlank()) { "Не задан MAC-адрес принтера" }
            val adapter = BluetoothAdapter.getDefaultAdapter()
                ?: throw IllegalStateException("Bluetooth недоступен")
            val dev = adapter.getRemoteDevice(mac.trim())
            dev.createRfcommSocketToServiceRecord(SPP_UUID).use { s ->
                s.connect()
                s.outputStream.use { os ->
                    os.write(bytes)
                    os.flush()
                }
            }
        }
        if (result.isFailure) {
            val e = result.exceptionOrNull()!!
            Result.failure(
                if (e is SecurityException) {
                    IllegalStateException("Нужно разрешение «Близкие устройства» (Bluetooth) — включите в настройках приложения", e)
                } else e
            )
        } else {
            result
        }
    }
}
