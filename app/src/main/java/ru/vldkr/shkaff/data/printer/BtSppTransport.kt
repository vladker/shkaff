package ru.vldkr.shkaff.data.printer

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.core.content.ContextCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.util.UUID
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

// Bluetooth Classic SPP (RFCOMM, канал 1). Китайские лейбл-принтеры печатают именно по RFCOMM,
// а не по BLE GATT (см. eleph-label: socket 0x1101). Перед connect — сопряжение, как в референсе.
class BtSppTransport(
    private val ctx: Context,
    private val mac: String
) : Transport {

    companion object {
        val SPP_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb")
        // ESC ## JXIG — запрос информации о принтере/режиме команд (ответ 116 байт, cmdMode на байте 11)
        val JXIG: ByteArray = byteArrayOf(0x1B, 0x23, 0x23, 0x4A, 0x58, 0x49, 0x47)
    }

    override suspend fun send(bytes: ByteArray): Result<Unit> = withContext(Dispatchers.IO) {
        runCatching {
            withSocket { s ->
                s.outputStream.use { os ->
                    os.write(bytes)
                    os.flush()
                }
            }
        }.mapConnectError().mapSecurity()
    }

    override suspend fun probe(): Result<PrinterProbe?> = withContext(Dispatchers.IO) {
        runCatching {
            withSocket { s ->
                val os = s.outputStream
                os.write(JXIG)
                os.flush()
                val buf = readFully(s.inputStream)
                fun hex(b: Byte): String = "%02X".format(b.toInt() and 0xFF)
                PrinterProbe(cmdModeHex = hex(buf[11]), dpiTypeHex = hex(buf[10]))
            }
        }.mapSecurity()
    }

    // Сопряжение перед connect: без BOND_BONDED socket.connect() на многих телефонах падает.
    private fun bondIfNeeded(dev: BluetoothDevice) {
        if (dev.bondState == BluetoothDevice.BOND_BONDED) return
        if (dev.bondState == BluetoothDevice.BOND_BONDING) {
            waitBonded(dev)
            return
        }
        val latch = CountDownLatch(1)
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(c: Context?, intent: Intent) {
                if (intent.action != BluetoothDevice.ACTION_BOND_STATE_CHANGED) return
                val device: BluetoothDevice? = if (Build.VERSION.SDK_INT >= 33) {
                    intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE, BluetoothDevice::class.java)
                } else {
                    @Suppress("DEPRECATION")
                    intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                }
                if (device == dev) latch.countDown()
            }
        }
        val filter = IntentFilter().apply { addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED) }
        if (Build.VERSION.SDK_INT >= 33) {
            ctx.registerReceiver(receiver, filter, ContextCompat.RECEIVER_NOT_EXPORTED)
        } else {
            @Suppress("DEPRECATION")
            ctx.registerReceiver(receiver, filter)
        }
        try {
            if (!dev.createBond()) {
                throw IllegalStateException("Не удалось начать сопряжение с принтером — нажмите на устройство в «Настройки → Bluetooth → Сопряжённые устройства»")
            }
            waitBonded(dev, latch)
        } finally {
            runCatching { ctx.unregisterReceiver(receiver) }
        }
    }

    private fun waitBonded(dev: BluetoothDevice, latch: CountDownLatch? = null) {
        latch?.await(25, TimeUnit.SECONDS)
        repeat(50) {
            if (dev.bondState == BluetoothDevice.BOND_BONDED) return
            Thread.sleep(200)
        }
        throw IllegalStateException(
            "Сопряжение с принтером не завершено — подтвердите сопряжение в системном диалоге Bluetooth"
        )
    }

    private inline fun <T> withSocket(block: (BluetoothSocket) -> T): T {
        require(mac.isNotBlank()) { "Не задан MAC-адрес принтера" }
        val adapter = BluetoothAdapter.getDefaultAdapter()
            ?: throw IllegalStateException("Bluetooth недоступен")
        val dev = adapter.getRemoteDevice(mac.trim())
        bondIfNeeded(dev)
        return dev.createRfcommSocketToServiceRecord(SPP_UUID).use { s ->
            s.connect()
            block(s)
        }
    }

    // Чтение ровно 116 байт с таймаутом 6 c: blocking read не отменяется из корутины,
    // поэтому ведём его в отдельном потоке (daemon — не будет висеть при закрытии сокета).
    private fun readFully(ins: java.io.InputStream): ByteArray {
        val buf = ByteArray(116)
        val read = java.util.concurrent.atomic.AtomicInteger(0)
        val t = Thread {
            var off = 0
            try {
                while (off < buf.size) {
                    val n = ins.read(buf, off, buf.size - off)
                    if (n <= 0) break
                    off += n
                }
            } catch (_: Exception) {
            } finally {
                read.set(off)
            }
        }.apply { isDaemon = true; start() }
        t.join(6000)
        if (t.isAlive) throw IOException("Принтер не ответил на запрос информации (JXIG)")
        if (read.get() < buf.size) throw IOException("Принтер не ответил на запрос информации (JXIG)")
        return buf
    }

    private fun <T> Result<T>.mapConnectError(): Result<T> {
        val e = exceptionOrNull() ?: return this
        return if (e is IOException) {
            Result.failure(
                IllegalStateException(
                    "Не удалось подключиться по Bluetooth (классический RFCOMM). " +
                        "Убедитесь, что принтер включён, и в форме выбран транспорт «BT», а не «BLE»",
                    e
                )
            )
        } else this
    }

    private fun <T> Result<T>.mapSecurity(): Result<T> {
        val e = exceptionOrNull() ?: return this
        return if (e is SecurityException) {
            Result.failure(
                IllegalStateException("Нужно разрешение «Близкие устройства» (Bluetooth) — включите в настройках приложения", e)
            )
        } else this
    }
}