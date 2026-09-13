package io.flutter.plugins.camera;

import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class DeviceInfo {

    @Nullable
    @VisibleForTesting
    public static String BRAND = Build.BRAND;

    @Nullable
    @VisibleForTesting
    public static String MODEL = Build.MODEL;

    @Nullable
    public static String getBrand() {
        return BRAND;
    }

    @Nullable
    public static String getModel() {
        return MODEL;
    }
}
