package p140y2;

import android.bluetooth.BluetoothDevice;
import kotlin.jvm.internal.E;
import p134x2.L0;
import p134x2.M0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements M0 {
    private final BluetoothDevice device;

    public f(BluetoothDevice device) {
        E.f(device, "device");
        this.device = device;
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    @Override // p134x2.M0
    public String getPrintDeviceAddress() {
        String address = this.device.getAddress();
        E.e(address, "getAddress(...)");
        return address;
    }

    @Override // p134x2.M0
    public String getPrintDeviceName() {
        String name = this.device.getName();
        if (name != null) {
            return name;
        }
        String address = this.device.getAddress();
        E.e(address, "getAddress(...)");
        return address;
    }

    @Override // p134x2.M0
    public L0 getPrinterType() {
        return L0.f8859a;
    }

    @Override // p134x2.M0
    public boolean isSameDevice(M0 device) {
        E.f(device, "device");
        if (device instanceof f) {
            return E.a(this.device, ((f) device).device);
        }
        return false;
    }
}
