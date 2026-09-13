package com.appdev.standard.model;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class LastConnectDeviceInfo {
    public static String BluetoothDevice = "BluetoothDevice";
    public static String UsbDevice = "UsbDevice";
    public static String WifiDevice = "WifiDevice";
    private String bleDeviceMac;
    private String bleDeviceName;
    private long time = System.currentTimeMillis();
    private String type;

    public LastConnectDeviceInfo(String str, String str2, String str3) {
        this.type = str;
        this.bleDeviceMac = str2;
        this.bleDeviceName = str3;
    }

    public String getBleDeviceMac() {
        return this.bleDeviceMac;
    }

    public String getBleDeviceName() {
        return this.bleDeviceName;
    }

    public long getTime() {
        return this.time;
    }

    public String getType() {
        return this.type;
    }

    public void setBleDeviceMac(String str) {
        this.bleDeviceMac = str;
    }

    public void setBleDeviceName(String str) {
        this.bleDeviceName = str;
    }

    public void setTime(long j6) {
        this.time = j6;
    }

    public void setType(String str) {
        this.type = str;
    }

    public LastConnectDeviceInfo(String str) {
        this.type = str;
    }
}
