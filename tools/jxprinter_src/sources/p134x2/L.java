package p134x2;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L {
    public final String getBluetoothDevice() {
        return M.BluetoothDevice;
    }

    public final String getUsbDevice() {
        return M.UsbDevice;
    }

    public final String getWifiDevice() {
        return M.WifiDevice;
    }

    public final void setBluetoothDevice(String str) {
        E.f(str, "<set-?>");
        M.BluetoothDevice = str;
    }

    public final void setUsbDevice(String str) {
        E.f(str, "<set-?>");
        M.UsbDevice = str;
    }

    public final void setWifiDevice(String str) {
        E.f(str, "<set-?>");
        M.WifiDevice = str;
    }
}
