package cn.bertsir.zbar;

import android.app.Activity;
import android.content.Intent;
import cn.bertsir.zbar.Qr.ScanResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class QrManager {
    private static QrManager instance;
    private QrConfig options;
    public OnScanResultCallback resultCallback;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnScanResultCallback {
        void onScanSuccess(ScanResult scanResult);
    }

    public static synchronized QrManager getInstance() {
        try {
            if (instance == null) {
                instance = new QrManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    public OnScanResultCallback getResultCallback() {
        return this.resultCallback;
    }

    public QrManager init(QrConfig qrConfig) {
        this.options = qrConfig;
        return this;
    }

    public void startScan(Activity activity, OnScanResultCallback onScanResultCallback) {
        if (this.options == null) {
            this.options = new QrConfig.Builder().create();
        }
        this.resultCallback = onScanResultCallback;
        Intent intent = new Intent(activity, (Class<?>) QRActivity.class);
        intent.putExtra(QrConfig.EXTRA_THIS_CONFIG, this.options);
        activity.startActivity(intent);
    }
}
