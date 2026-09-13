package p102s;

import E3.g;
import O3.l;
import S2.r;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.idlefish.flutterboost.FlutterBoost;
import java.util.Arrays;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.T;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.C0315z0;
import p018c4.G;
import p023d4.I;
import p051j0.a;
import p051j0.b;
import p051j0.f;
import p108t.C1770b;
import p108t.M;
import p108t.Z;
import p108t.b0;
import p108t.d0;
import p134x2.K0;
import p134x2.M0;
import p134x2.O;
import p134x2.P0;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements M {
    public final void a(long j6, long j7) {
        T t6 = new T();
        P0 p0H = a.h();
        if (p0H == null) {
            return;
        }
        t6.f5689a = p0H;
        p0H.setCmdMode(String.format("%02x", Arrays.copyOf(new Object[]{Long.valueOf(j6)}, 1)));
        if (E.a(((P0) t6.f5689a).getCmdMode(), "01")) {
            ((P0) t6.f5689a).f8874q = (int) j7;
        }
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new x(t6, null, 0));
    }

    @Override // p108t.M
    public void connectBluetooth(C1770b blueToothDevice, l callback) {
        E.f(blueToothDevice, "blueToothDevice");
        E.f(callback, "callback");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new G(blueToothDevice, callback, null, 8));
    }

    @Override // p108t.M
    public void connectUsb(b0 usbDevice, l callback) {
        E.f(usbDevice, "usbDevice");
        E.f(callback, "callback");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new G(usbDevice, callback, null, 9));
    }

    @Override // p108t.M
    public void connectWifi(d0 wifiDevice, l callback) {
        E.f(wifiDevice, "wifiDevice");
        E.f(callback, "callback");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new G(wifiDevice, callback, null, 10));
    }

    @Override // p108t.M
    public String getBluetoothDeviceName() {
        if (getPrinterType() != Z.BLUETOOTH) {
            return null;
        }
        String printDeviceAddress = f.getPrintDeviceAddress();
        if (printDeviceAddress.length() == 0) {
            return null;
        }
        try {
            Activity activityCurrentActivity = FlutterBoost.instance().currentActivity();
            if (activityCurrentActivity == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(activityCurrentActivity, "android.permission.BLUETOOTH_CONNECT") != 0) {
                O.INSTANCE.e("AndroidFlutterPrintUtil", "BLUETOOTH_CONNECT permission not granted");
                return null;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                return defaultAdapter.getRemoteDevice(printDeviceAddress).getName();
            }
            return null;
        } catch (SecurityException e) {
            O.INSTANCE.e("AndroidFlutterPrintUtil", "SecurityException: Failed to get bluetooth device name", e);
        } catch (Exception e6) {
            O.INSTANCE.e("AndroidFlutterPrintUtil", "Failed to get bluetooth device name", e6);
        }
    }

    @Override // p108t.M
    public String getDeviceName() {
        P0 p0H = a.h();
        if (p0H != null) {
            return p0H.getDeviceName();
        }
        return null;
    }

    @Override // p108t.M
    public void getIp(l callback) {
        E.f(callback, "callback");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new I(callback, null, 1));
    }

    @Override // p108t.M
    public String getPrintAddress() {
        return f.getPrintDeviceAddress();
    }

    @Override // p108t.M
    public Z getPrinterType() {
        if (!p134x2.E.n()) {
            return Z.UNCONNECTED;
        }
        K0 printer = p134x2.E.getPrinter();
        E.c(printer);
        M0 printerDevice = printer.getPrinterDevice();
        E.c(printerDevice);
        int iOrdinal = printerDevice.getPrinterType().ordinal();
        if (iOrdinal == 0) {
            return Z.BLUETOOTH;
        }
        if (iOrdinal == 1) {
            return Z.USB;
        }
        if (iOrdinal == 2) {
            return Z.WIFI;
        }
        throw new C1937q();
    }

    @Override // p108t.M
    public Long getPrinterVersion() {
        P0 p0H = a.h();
        if (p0H == null) {
            return null;
        }
        return Long.valueOf(p0H.c);
    }

    @Override // p108t.M
    public void sendData(byte[] data, String progressId, l callback) {
        E.f(data, "data");
        E.f(progressId, "progressId");
        E.f(callback, "callback");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new r(data, callback, progressId, (g) null));
    }

    @Override // p108t.M
    public void setDhcp(boolean z6, l callback) {
        E.f(callback, "callback");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new y(z6, callback, null));
    }

    @Override // p108t.M
    public void setWifi(String ssid, String password, l callback) {
        E.f(ssid, "ssid");
        E.f(password, "password");
        E.f(callback, "callback");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new r(ssid, password, callback, null, 4));
    }

    @Override // p108t.M
    public void updateTime(String time) {
        E.f(time, "time");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new b(time, null, 1));
    }
}
