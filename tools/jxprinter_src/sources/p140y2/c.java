package p140y2;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.E;
import p134x2.O;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f9033a;

    public c(e eVar) {
        this.f9033a = eVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        E.f(context, "context");
        E.f(intent, "intent");
        if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(intent.getAction())) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            e eVar = this.f9033a;
            if (E.a(eVar.device.getDevice(), bluetoothDevice)) {
                if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(eVar.context, "android.permission.BLUETOOTH_CONNECT") != 0) {
                    O.INSTANCE.i("BluetoothConnection", "ConnectThread failed. Permission error 4");
                }
                E.c(bluetoothDevice);
                switch (bluetoothDevice.getBondState()) {
                    case 10:
                        eVar.state = b.c;
                        eVar.context.unregisterReceiver(this);
                        O.INSTANCE.i("BluetoothConnection", "bound cancel");
                        break;
                    case 11:
                        O.INSTANCE.i("BluetoothConnection", "bounding......");
                        break;
                    case 12:
                        O.INSTANCE.i("BluetoothConnection", "bound success");
                        eVar.state = b.b;
                        eVar.context.unregisterReceiver(this);
                        break;
                }
            }
        }
    }
}
