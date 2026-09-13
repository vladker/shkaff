package org.opencv.android;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface InstallCallbackInterface {
    public static final int INSTALLATION_PROGRESS = 1;
    public static final int NEW_INSTALLATION = 0;

    void cancel();

    String getPackageName();

    void install();

    void wait_install();
}
