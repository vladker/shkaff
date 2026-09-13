package io.flutter.plugins.camera.features.exposureoffset;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.annotation.NonNull;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.features.CameraFeature;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ExposureOffsetFeature extends CameraFeature<Double> {
    private double currentSetting;

    public ExposureOffsetFeature(@NonNull CameraProperties cameraProperties) {
        super(cameraProperties);
        this.currentSetting = 0.0d;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        return true;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    public String getDebugName() {
        return "ExposureOffsetFeature";
    }

    public double getExposureOffsetStepSize() {
        return this.cameraProperties.getControlAutoExposureCompensationStep();
    }

    public double getMaxExposureOffset() {
        Range<Integer> controlAutoExposureCompensationRange = this.cameraProperties.getControlAutoExposureCompensationRange();
        return getExposureOffsetStepSize() * (controlAutoExposureCompensationRange == null ? 0.0d : ((Integer) controlAutoExposureCompensationRange.getUpper()).intValue());
    }

    public double getMinExposureOffset() {
        Range<Integer> controlAutoExposureCompensationRange = this.cameraProperties.getControlAutoExposureCompensationRange();
        return getExposureOffsetStepSize() * (controlAutoExposureCompensationRange == null ? 0.0d : ((Integer) controlAutoExposureCompensationRange.getLower()).intValue());
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(@NonNull CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf((int) this.currentSetting));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public Double getValue() {
        return Double.valueOf(this.currentSetting);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(@NonNull Double d) {
        this.currentSetting = d.doubleValue() / getExposureOffsetStepSize();
    }
}
