package p134x2;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M {
    private static String BluetoothDevice = "BluetoothDevice";
    public static final L Companion = new L();
    private static String UsbDevice = "UsbDevice";
    private static String WifiDevice = "WifiDevice";
    private String bleDeviceMac;
    private String bleDeviceName;
    private String type;

    public M(String type, String str, String str2) {
        E.f(type, "type");
        this.type = type;
        System.currentTimeMillis();
        this.bleDeviceMac = str;
        this.bleDeviceName = str2;
    }

    public final String getBleDeviceMac() {
        return this.bleDeviceMac;
    }

    public final String getBleDeviceName() {
        return this.bleDeviceName;
    }

    public final String getType() {
        return this.type;
    }

    public final void setBleDeviceMac(String str) {
        this.bleDeviceMac = str;
    }

    public final void setBleDeviceName(String str) {
        this.bleDeviceName = str;
    }

    public final void setType(String str) {
        E.f(str, "<set-?>");
        this.type = str;
    }

    public M(String type) {
        E.f(type, "type");
        this.type = type;
        System.currentTimeMillis();
    }
}
