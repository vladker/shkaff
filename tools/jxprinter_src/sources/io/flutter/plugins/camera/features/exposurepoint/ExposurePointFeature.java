package io.flutter.plugins.camera.features.exposurepoint;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.CameraRegionUtils;
import io.flutter.plugins.camera.features.CameraFeature;
import io.flutter.plugins.camera.features.Point;
import io.flutter.plugins.camera.features.sensororientation.SensorOrientationFeature;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ExposurePointFeature extends CameraFeature<Point> {
    private Size cameraBoundaries;

    @Nullable
    @VisibleForTesting
    public MeteringRectangle[] defaultRegions;
    private boolean defaultRegionsHasBeenSet;

    @Nullable
    private Point exposurePoint;
    private MeteringRectangle exposureRectangle;

    @NonNull
    private final SensorOrientationFeature sensorOrientationFeature;

    public ExposurePointFeature(@NonNull CameraProperties cameraProperties, @NonNull SensorOrientationFeature sensorOrientationFeature) {
        super(cameraProperties);
        this.defaultRegionsHasBeenSet = false;
        this.sensorOrientationFeature = sensorOrientationFeature;
    }

    private void buildExposureRectangle() {
        if (this.cameraBoundaries == null) {
            throw new AssertionError("The cameraBoundaries should be set (using `ExposurePointFeature.setCameraBoundaries(Size)`) before updating the exposure point.");
        }
        if (this.exposurePoint == null) {
            this.exposureRectangle = null;
            return;
        }
        PlatformChannel.DeviceOrientation lockedCaptureOrientation = this.sensorOrientationFeature.getLockedCaptureOrientation();
        if (lockedCaptureOrientation == null) {
            lockedCaptureOrientation = this.sensorOrientationFeature.getDeviceOrientationManager().getLastUIOrientation();
        }
        this.exposureRectangle = CameraRegionUtils.convertPointToMeteringRectangle(this.cameraBoundaries, this.exposurePoint.f4104x.doubleValue(), this.exposurePoint.f4105y.doubleValue(), lockedCaptureOrientation);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        Integer controlMaxRegionsAutoExposure = this.cameraProperties.getControlMaxRegionsAutoExposure();
        return controlMaxRegionsAutoExposure != null && controlMaxRegionsAutoExposure.intValue() > 0;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    public String getDebugName() {
        return "ExposurePointFeature";
    }

    public void setCameraBoundaries(@NonNull Size size) {
        this.cameraBoundaries = size;
        buildExposureRectangle();
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(@NonNull CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            if (!this.defaultRegionsHasBeenSet) {
                this.defaultRegions = (MeteringRectangle[]) builder.get(CaptureRequest.CONTROL_AE_REGIONS);
                this.defaultRegionsHasBeenSet = true;
            }
            MeteringRectangle meteringRectangle = this.exposureRectangle;
            if (meteringRectangle != null) {
                builder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
            } else {
                builder.set(CaptureRequest.CONTROL_AE_REGIONS, this.defaultRegions);
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    @Nullable
    @SuppressLint({"KotlinPropertyAccess"})
    public Point getValue() {
        return this.exposurePoint;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(@Nullable Point point) {
        if (point == null || point.f4104x == null || point.f4105y == null) {
            point = null;
        }
        this.exposurePoint = point;
        buildExposureRectangle();
    }
}
