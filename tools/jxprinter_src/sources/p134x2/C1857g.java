package p134x2;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.C0315z0;

/* JADX INFO: renamed from: x2.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1857g extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        E.f(context, "context");
        E.f(intent, "intent");
        String action = intent.getAction();
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -1530327060) {
                if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    if (intExtra == 10) {
                        O.INSTANCE.e("CurrentPrinter", "系统蓝牙已关闭");
                        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new C1855f(2, null));
                        return;
                    }
                    if (intExtra != 12) {
                        return;
                    }
                    O.INSTANCE.e("CurrentPrinter", "系统蓝牙已开启");
                    E.INSTANCE.getClass();
                    M mL = E.l();
                    if (mL == null || !E.a(M.Companion.getBluetoothDevice(), mL.getType()) || mL.getBleDeviceMac() == null) {
                        return;
                    }
                    String bleDeviceMac = mL.getBleDeviceMac();
                    E.c(bleDeviceMac);
                    if (bleDeviceMac.length() > 0) {
                        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new C1853e(mL, null));
                        return;
                    }
                    return;
                }
                return;
            }
            if (iHashCode == -301431627) {
                if (action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
                    if (bluetoothDevice != null) {
                        O.INSTANCE.e("CurrentPrinter", "连接设备:" + bluetoothDevice.getAddress());
                    }
                    E e = E.INSTANCE;
                    E.b = System.currentTimeMillis();
                    return;
                }
                return;
            }
            if (iHashCode == 1821585647 && action.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
                if (bluetoothDevice != null) {
                    O.INSTANCE.e("CurrentPrinter", "断开连接:" + bluetoothDevice.getAddress());
                }
                if (bluetoothDevice != null) {
                    String address = bluetoothDevice.getAddress();
                    E.e(address, "getAddress(...)");
                    if (address.length() != 0 && E.a(bluetoothDevice.getAddress(), E.getPrintDeviceAddress())) {
                        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new C1851d(2, null));
                    }
                }
            }
        }
    }
}
