package ru.vldkr.shkaff.data.printer

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

// BLE: ESC/POS через GATT-сервис SPP (0x1101), запись в характеристику WRITE (0x2901)
class BleSppTransport(
    private val ctx: Context,
    private val mac: String
) : Transport {

    companion object {
        val SPP_SERVICE: UUID = UUID.fromString("00001101-0000-1000-8000-0010AC510000")
        val SPP_WRITE: UUID = UUID.fromString("00002901-0000-1000-8000-0010AC510000")
    }

    override suspend fun send(bytes: ByteArray): Result<Unit> = withContext(Dispatchers.IO) {
        val result = runCatching {
            require(mac.isNotBlank()) { "Не задан MAC-адрес принтера" }
            val adapter = BluetoothAdapter.getDefaultAdapter()
                ?: throw IllegalStateException("Bluetooth недоступен")
            val dev = adapter.getRemoteDevice(mac.trim())

            var discStatus = BluetoothGatt.GATT_FAILURE
            val discLatch = CountDownLatch(1)
            var mtu = 23
            val mtuLatch = CountDownLatch(1)
            var writeStatus = BluetoothGatt.GATT_FAILURE
            var writeLatch = CountDownLatch(1)

            val gatt = dev.connectGatt(ctx, false, object : BluetoothGattCallback() {
                override fun onServicesDiscovered(g: BluetoothGatt, status: Int) {
                    discStatus = status
                    discLatch.countDown()
                }
                override fun onMtuChanged(g: BluetoothGatt, value: Int, status: Int) {
                    if (status == BluetoothGatt.GATT_SUCCESS) mtu = value
                    mtuLatch.countDown()
                }
                override fun onCharacteristicWrite(g: BluetoothGatt, c: BluetoothGattCharacteristic, status: Int) {
                    writeStatus = status
                    writeLatch.countDown()
                }
            }) ?: throw IllegalStateException("Не удалось подключиться к принтеру по BLE")
            try {
                if (!gatt.discoverServices() ||
                    !discLatch.await(10, TimeUnit.SECONDS) ||
                    discStatus != BluetoothGatt.GATT_SUCCESS
                ) {
                    throw IllegalStateException("Не удалось получить BLE-сервисы принтера")
                }
                val svc = gatt.getService(SPP_SERVICE)
                    ?: throw IllegalStateException(
                        "На принтере нет SPP-сервиса (0x1101) — возможно, он не поддерживает печать по BLE"
                    )
                val ch = svc.getCharacteristic(SPP_WRITE)
                    ?: throw IllegalStateException("В SPP-сервисе нет характеристики записи (0x2901)")
                val noResponse = ch.writeType == BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE

                gatt.requestMtu(512)
                mtuLatch.await(3, TimeUnit.SECONDS)
                val chunk = (mtu - 3).coerceIn(20, 512)

                var off = 0
                while (off < bytes.size) {
                    val len = minOf(chunk, bytes.size - off)
                    ch.value = bytes.copyOfRange(off, off + len)
                    ch.writeType = if (noResponse) {
                        BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
                    } else {
                        BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                    }
                    if (!noResponse) {
                        writeStatus = BluetoothGatt.GATT_FAILURE
                        writeLatch = CountDownLatch(1)
                    }
                    val ok = gatt.writeCharacteristic(ch)
                    if (!ok) {
                        throw IllegalStateException("Не удалось отправить данные на принтер (BLE)")
                    }
                    if (!noResponse && (!writeLatch.await(10, TimeUnit.SECONDS) ||
                            writeStatus != BluetoothGatt.GATT_SUCCESS)
                    ) {
                        throw IllegalStateException("Принтер вернул ошибку BLE-записи (статус $writeStatus)")
                    }
                    off += len
                }
            } finally {
                gatt.close()
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
