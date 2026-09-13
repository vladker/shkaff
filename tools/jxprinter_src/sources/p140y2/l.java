package p140y2;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.exifinterface.media.a;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.N;
import p134x2.O;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f9039a;

    public l(m mVar) {
        this.f9039a = mVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        E.f(context, "context");
        E.f(intent, "intent");
        String action = intent.getAction();
        boolean zEquals = "android.bluetooth.device.action.FOUND".equals(action);
        m mVar = this.f9039a;
        if (!zEquals) {
            if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                O.INSTANCE.i("BluetoothScanner", "扫描结束");
                AbstractC0272e.b(N.CoroutineScope(C0276f0.getDefault()), null, 3, new k(mVar, null));
                return;
            }
            return;
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice != null) {
            O o6 = O.INSTANCE;
            o6.i("BluetoothScanner", a.m("扫描到设备 ", bluetoothDevice.getName(), " ", bluetoothDevice.getAddress()));
            if (bluetoothDevice.getBluetoothClass() == null || bluetoothDevice.getBluetoothClass().getMajorDeviceClass() != 1536) {
                return;
            }
            o6.i("BluetoothScanner", a.m("匹配到打印机设备 ", bluetoothDevice.getName(), " ", bluetoothDevice.getAddress()));
            AbstractC0272e.b(N.CoroutineScope(C0276f0.getDefault()), null, 3, new j(mVar, bluetoothDevice, null));
        }
    }
}
