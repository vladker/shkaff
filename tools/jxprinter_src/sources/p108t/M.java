package p108t;

import O3.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface M {
    public static final L Companion = L.f8517a;

    void connectBluetooth(C1770b c1770b, l lVar);

    void connectUsb(b0 b0Var, l lVar);

    void connectWifi(d0 d0Var, l lVar);

    String getBluetoothDeviceName();

    String getDeviceName();

    void getIp(l lVar);

    String getPrintAddress();

    Z getPrinterType();

    Long getPrinterVersion();

    void sendData(byte[] bArr, String str, l lVar);

    void setDhcp(boolean z6, l lVar);

    void setWifi(String str, String str2, l lVar);

    void updateTime(String str);
}
