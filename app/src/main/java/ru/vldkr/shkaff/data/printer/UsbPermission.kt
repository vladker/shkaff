package ru.vldkr.shkaff.data.printer

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.MainActivity
import ru.vldkr.shkaff.di.Deps

// Кидается транспортом, когда нужно разрешение Android на доступ к USB-устройству
class UsbPermissionPendingException(val device: UsbDevice) :
    Exception("Нужно разрешение на доступ к USB-принтеру")

// Повтор действия после того, как пользователь подтвердит доступ в системном диалоге
object UsbBridge {
    @Volatile
    var pending: (suspend () -> Unit)? = null
}

object UsbPermission {

    fun request(ctx: Context, device: UsbDevice) {
        val pi = PendingIntent.getActivity(
            ctx,
            0,
            Intent(ctx, MainActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP),
            PendingIntent.FLAG_IMMUTABLE
        )
        UsbTransport.get(ctx).requestPermission(device, pi)
    }

    // Вызывается MainActivity при intent android.hardware.usb.action.USB_PERMISSION
    fun onIntent(intent: Intent?) {
        if (intent?.action != UsbTransport.ACTION_USB_PERMISSION) return
        if (!intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) return
        val pending = UsbBridge.pending ?: return
        UsbBridge.pending = null
        CoroutineScope(Dispatchers.Main).launch {
            runCatching { pending() }
        }
    }

    // Сообщение для UI; при нехватке разрешения USB — регистрирует повтор
    fun failureMessage(e: Throwable, retry: suspend () -> Unit): String {
        val ex = e as? UsbPermissionPendingException
            ?: return "Ошибка: ${e.message ?: e.javaClass.simpleName}"
        UsbBridge.pending = retry
        request(Deps.app, ex.device)
        return "Разрешение запрошено — после «Разрешить» печать повторится автоматически"
    }
}
