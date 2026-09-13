package io.flutter.plugins.camera;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class SdkCapabilityChecker {

    @SuppressLint({"AnnotateVersionCheck"})
    @VisibleForTesting
    public static int SDK_VERSION = Build.VERSION.SDK_INT;

    @ChecksSdkIntAtLeast(api = 28)
    public static boolean supportsDistortionCorrection() {
        return SDK_VERSION >= 28;
    }

    @ChecksSdkIntAtLeast(api = 26)
    public static boolean supportsEglRecordableAndroid() {
        return SDK_VERSION >= 26;
    }

    @ChecksSdkIntAtLeast(api = 31)
    public static boolean supportsEncoderProfiles() {
        return SDK_VERSION >= 31;
    }

    @ChecksSdkIntAtLeast(api = 23)
    public static boolean supportsMarshmallowNoiseReductionModes() {
        return SDK_VERSION >= 23;
    }

    @ChecksSdkIntAtLeast(api = 28)
    public static boolean supportsSessionConfiguration() {
        return SDK_VERSION >= 28;
    }

    @ChecksSdkIntAtLeast(api = 24)
    public static boolean supportsVideoPause() {
        return SDK_VERSION >= 24;
    }

    @ChecksSdkIntAtLeast(api = 30)
    public static boolean supportsZoomRatio() {
        return SDK_VERSION >= 30;
    }
}
