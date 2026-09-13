package androidx.constraintlayout.core.state;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface RegistryCallback {
    String currentLayoutInformation();

    String currentMotionScene();

    long getLastModified();

    void onDimensions(int i5, int i6);

    void onNewMotionScene(String str);

    void onProgress(float f6);

    void setDrawDebug(int i5);

    void setLayoutInformationMode(int i5);
}
