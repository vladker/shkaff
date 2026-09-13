package p146z2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.N;
import p134x2.O;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f9121a;

    public i(j jVar) {
        this.f9121a = jVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        E.f(context, "context");
        E.f(intent, "intent");
        String action = intent.getAction();
        O o6 = O.INSTANCE;
        o6.i("UsbConnection", "receiver action: " + action);
        if ("com.android.sandu.USB_PERMISSION".equals(action)) {
            context.unregisterReceiver(this);
            UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
            j jVar = this.f9121a;
            if (usbDevice == null) {
                AbstractC0272e.b(N.CoroutineScope(C0276f0.getIO()), null, 3, new h(jVar, null));
                return;
            }
            if (intent.getBooleanExtra("permission", false)) {
                AbstractC0272e.b(N.CoroutineScope(C0276f0.getIO()), null, 3, new g(jVar, null));
                return;
            }
            jVar.state = d.d;
            o6.e("UsbConnection", "permission denied for device " + usbDevice);
        }
    }
}
