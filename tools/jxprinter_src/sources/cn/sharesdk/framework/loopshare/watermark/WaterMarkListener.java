package cn.sharesdk.framework.loopshare.watermark;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface WaterMarkListener {
    void onCancel();

    void onEnd(int i5);

    void onFailed(String str, int i5);

    void onProgress(int i5);

    void onStart();
}
