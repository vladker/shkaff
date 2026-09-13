package io.flutter.plugins.camera.features.zoomlevel;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.SdkCapabilityChecker;
import io.flutter.plugins.camera.features.CameraFeature;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ZoomLevelFeature extends CameraFeature<Float> {
    private static final Float DEFAULT_ZOOM_LEVEL = Float.valueOf(1.0f);

    @NonNull
    private Float currentSetting;
    private final boolean hasSupport;
    private final Float maximumZoomLevel;
    private Float minimumZoomLevel;
    private final Rect sensorArraySize;

    public ZoomLevelFeature(@NonNull CameraProperties cameraProperties) {
        super(cameraProperties);
        Float f6 = DEFAULT_ZOOM_LEVEL;
        this.currentSetting = f6;
        this.minimumZoomLevel = f6;
        Rect sensorInfoActiveArraySize = cameraProperties.getSensorInfoActiveArraySize();
        this.sensorArraySize = sensorInfoActiveArraySize;
        if (sensorInfoActiveArraySize == null) {
            this.maximumZoomLevel = this.minimumZoomLevel;
            this.hasSupport = false;
            return;
        }
        if (SdkCapabilityChecker.supportsZoomRatio()) {
            this.minimumZoomLevel = cameraProperties.getScalerMinZoomRatio();
            this.maximumZoomLevel = cameraProperties.getScalerMaxZoomRatio();
        } else {
            this.minimumZoomLevel = f6;
            Float scalerAvailableMaxDigitalZoom = cameraProperties.getScalerAvailableMaxDigitalZoom();
            this.maximumZoomLevel = (scalerAvailableMaxDigitalZoom == null || scalerAvailableMaxDigitalZoom.floatValue() < this.minimumZoomLevel.floatValue()) ? this.minimumZoomLevel : scalerAvailableMaxDigitalZoom;
        }
        this.hasSupport = Float.compare(this.maximumZoomLevel.floatValue(), this.minimumZoomLevel.floatValue()) > 0;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        return this.hasSupport;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    public String getDebugName() {
        return "ZoomLevelFeature";
    }

    public float getMaximumZoomLevel() {
        return this.maximumZoomLevel.floatValue();
    }

    public float getMinimumZoomLevel() {
        return this.minimumZoomLevel.floatValue();
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(@NonNull CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            if (SdkCapabilityChecker.supportsZoomRatio()) {
                builder.set(CaptureRequest.CONTROL_ZOOM_RATIO, ZoomUtils.computeZoomRatio(this.currentSetting.floatValue(), this.minimumZoomLevel.floatValue(), this.maximumZoomLevel.floatValue()));
            } else {
                builder.set(CaptureRequest.SCALER_CROP_REGION, ZoomUtils.computeZoomRect(this.currentSetting.floatValue(), this.sensorArraySize, this.minimumZoomLevel.floatValue(), this.maximumZoomLevel.floatValue()));
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public Float getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(@NonNull Float f6) {
        this.currentSetting = f6;
    }
}
