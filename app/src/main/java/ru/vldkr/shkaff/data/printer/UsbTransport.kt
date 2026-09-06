package ru.vldkr.shkaff.data.printer

import android.content.Context
import android.hardware.usb.UsbConstants
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbEndpoint
import android.hardware.usb.UsbInterface
import android.hardware.usb.UsbManager

class UsbTransport(private val ctx: Context, private val deviceName: String) : Transport {

    companion object {
        const val ACTION_USB_PERMISSION = "android.hardware.usb.action.USB_PERMISSION"

        fun get(ctx: Context): UsbManager =
            ctx.getSystemService(Context.USB_SERVICE) as UsbManager

        fun list(ctx: Context): List<String> {
            val manager = get(ctx)
            return manager.deviceList.values
                .filter { d -> eachInterface(d).any { itf -> bulkOut(itf) != null } }
                .sortedBy { it.deviceName }
                .map { it -> "${manufacturerName(it)} ${it.productName} (${it.deviceName})" }
        }

        fun eachInterface(d: UsbDevice): List<UsbInterface> =
            (0 until d.interfaceCount).map { d.getInterface(it) }

        fun eachEndpoint(itf: UsbInterface): List<UsbEndpoint> =
            (0 until itf.endpointCount).map { itf.getEndpoint(it) }

        fun bulkOut(itf: UsbInterface): UsbEndpoint? =
            eachEndpoint(itf).firstOrNull {
                (it.direction and UsbConstants.USB_ENDPOINT_DIR_MASK) == 0 &&
                    (it.type and UsbConstants.USB_ENDPOINT_XFERTYPE_MASK) == UsbConstants.USB_ENDPOINT_XFER_BULK
            }

        private fun manufacturerName(d: UsbDevice): String =
            d.manufacturerName?.ifBlank { "Принтер" } ?: "Принтер"
    }

    override suspend fun send(bytes: ByteArray): Result<Unit> {
        val manager = get(ctx)
        val device = manager.deviceList.values.firstOrNull { it.deviceName == deviceName }
            ?: return Result.failure(java.io.IOException("устройство $deviceName не найдено — возможно, кабель отключён"))
        if (!manager.hasPermission(device)) throw UsbPermissionPendingException(device)

        val conn = manager.openDevice(device)
            ?: return Result.failure(java.io.IOException("openDevice: соединение не установлено"))
        try {
            val itf = eachInterface(device).firstOrNull { bulkOut(it) != null }
                ?: return Result.failure(java.io.IOException("нет bulk-OUT эндпоинта"))
            val ep = bulkOut(itf)!!
            if (!conn.claimInterface(itf, false)) {
                return Result.failure(java.io.IOException("claimInterface: нет доступа (принтер занят другим приложением?)"))
            }
            try {
                val sent = conn.bulkTransfer(ep, bytes, 0, bytes.size, 5000)
                if (sent < 0) return Result.failure(java.io.IOException("bulkTransfer: ошибка $sent"))
            } finally {
                conn.releaseInterface(itf)
            }
        } finally {
            conn.close()
        }
        return Result.success(Unit)
    }
}
