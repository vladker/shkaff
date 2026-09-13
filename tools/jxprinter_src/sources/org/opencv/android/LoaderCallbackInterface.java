package org.opencv.android;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface LoaderCallbackInterface {
    public static final int INCOMPATIBLE_MANAGER_VERSION = 4;
    public static final int INIT_FAILED = 255;
    public static final int INSTALL_CANCELED = 3;
    public static final int MARKET_ERROR = 2;
    public static final int SUCCESS = 0;

    void onManagerConnected(int i5);

    void onPackageInstall(int i5, InstallCallbackInterface installCallbackInterface);
}
