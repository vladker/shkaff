package io.flutter.plugins.camera.features.fpsrange;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.DeviceInfo;
import io.flutter.plugins.camera.features.CameraFeature;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FpsRangeFeature extends CameraFeature<Range<Integer>> {
    private static final Range<Integer> MAX_PIXEL4A_RANGE = new Range<>(30, 30);

    @Nullable
    private Range<Integer> currentSetting;

    public FpsRangeFeature(@NonNull CameraProperties cameraProperties) {
        Range<Integer> range;
        super(cameraProperties);
        if (isPixel4A()) {
            this.currentSetting = MAX_PIXEL4A_RANGE;
            return;
        }
        Range<Integer>[] controlAutoExposureAvailableTargetFpsRanges = cameraProperties.getControlAutoExposureAvailableTargetFpsRanges();
        if (controlAutoExposureAvailableTargetFpsRanges != null) {
            for (Range<Integer> range2 : controlAutoExposureAvailableTargetFpsRanges) {
                int iIntValue = ((Integer) range2.getUpper()).intValue();
                if (iIntValue >= 10 && ((range = this.currentSetting) == null || iIntValue > ((Integer) range.getUpper()).intValue())) {
                    this.currentSetting = range2;
                }
            }
        }
    }

    private boolean isPixel4A() {
        String brand = DeviceInfo.getBrand();
        String model = DeviceInfo.getModel();
        return brand != null && brand.equals("google") && model != null && model.equals("Pixel 4a");
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        return true;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    public String getDebugName() {
        return "FpsRangeFeature";
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(@NonNull CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, this.currentSetting);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    @Nullable
    @SuppressLint({"KotlinPropertyAccess"})
    public Range<Integer> getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(@NonNull Range<Integer> range) {
        this.currentSetting = range;
    }
}
