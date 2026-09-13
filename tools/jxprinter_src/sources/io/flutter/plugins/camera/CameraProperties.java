package io.flutter.plugins.camera;

import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CameraProperties {
    @NonNull
    int[] getAvailableNoiseReductionModes();

    @NonNull
    String getCameraName();

    @NonNull
    Range<Integer>[] getControlAutoExposureAvailableTargetFpsRanges();

    @NonNull
    Range<Integer> getControlAutoExposureCompensationRange();

    double getControlAutoExposureCompensationStep();

    @NonNull
    int[] getControlAutoFocusAvailableModes();

    @NonNull
    Integer getControlMaxRegionsAutoExposure();

    @NonNull
    Integer getControlMaxRegionsAutoFocus();

    @Nullable
    @RequiresApi(api = 28)
    int[] getDistortionCorrectionAvailableModes();

    @NonNull
    Boolean getFlashInfoAvailable();

    int getHardwareLevel();

    int getLensFacing();

    @Nullable
    Float getLensInfoMinimumFocusDistance();

    @NonNull
    Float getScalerAvailableMaxDigitalZoom();

    @Nullable
    @RequiresApi(api = 30)
    Float getScalerMaxZoomRatio();

    @Nullable
    @RequiresApi(api = 30)
    Float getScalerMinZoomRatio();

    @NonNull
    Rect getSensorInfoActiveArraySize();

    @NonNull
    Size getSensorInfoPixelArraySize();

    @NonNull
    @RequiresApi(api = 23)
    Rect getSensorInfoPreCorrectionActiveArraySize();

    int getSensorOrientation();
}
