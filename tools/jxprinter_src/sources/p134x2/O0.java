package p134x2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface O0 {
    void onGetPrinterInfo(M0 m6, boolean z6, P0 p1);

    void onPrinterConnected(M0 m6, boolean z6, byte[] bArr);

    void onPrinterDisconnected(M0 m6);

    void onPrinterError(M0 m6, boolean z6, N0 n6, String str);

    void onRecvData(M0 m6, byte[] bArr);

    void onVerfiyPrinterSuccess(M0 m6, boolean z6);
}
