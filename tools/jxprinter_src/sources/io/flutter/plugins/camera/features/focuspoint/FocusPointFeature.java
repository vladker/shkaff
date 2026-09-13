package io.flutter.plugins.camera.features.focuspoint;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.CameraRegionUtils;
import io.flutter.plugins.camera.features.CameraFeature;
import io.flutter.plugins.camera.features.Point;
import io.flutter.plugins.camera.features.sensororientation.SensorOrientationFeature;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FocusPointFeature extends CameraFeature<Point> {
    private Size cameraBoundaries;

    @Nullable
    private Point focusPoint;
    private MeteringRectangle focusRectangle;

    @NonNull
    private final SensorOrientationFeature sensorOrientationFeature;

    public FocusPointFeature(@NonNull CameraProperties cameraProperties, @NonNull SensorOrientationFeature sensorOrientationFeature) {
        super(cameraProperties);
        this.sensorOrientationFeature = sensorOrientationFeature;
    }

    private void buildFocusRectangle() {
        if (this.cameraBoundaries == null) {
            throw new AssertionError("The cameraBoundaries should be set (using `FocusPointFeature.setCameraBoundaries(Size)`) before updating the focus point.");
        }
        if (this.focusPoint == null) {
            this.focusRectangle = null;
            return;
        }
        PlatformChannel.DeviceOrientation lockedCaptureOrientation = this.sensorOrientationFeature.getLockedCaptureOrientation();
        if (lockedCaptureOrientation == null) {
            lockedCaptureOrientation = this.sensorOrientationFeature.getDeviceOrientationManager().getLastUIOrientation();
        }
        this.focusRectangle = CameraRegionUtils.convertPointToMeteringRectangle(this.cameraBoundaries, this.focusPoint.f4104x.doubleValue(), this.focusPoint.f4105y.doubleValue(), lockedCaptureOrientation);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        Integer controlMaxRegionsAutoFocus = this.cameraProperties.getControlMaxRegionsAutoFocus();
        return controlMaxRegionsAutoFocus != null && controlMaxRegionsAutoFocus.intValue() > 0;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    public String getDebugName() {
        return "FocusPointFeature";
    }

    public void setCameraBoundaries(@NonNull Size size) {
        this.cameraBoundaries = size;
        buildFocusRectangle();
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(@NonNull CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
            MeteringRectangle meteringRectangle = this.focusRectangle;
            builder.set(key, meteringRectangle == null ? null : new MeteringRectangle[]{meteringRectangle});
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    @Nullable
    @SuppressLint({"KotlinPropertyAccess"})
    public Point getValue() {
        return this.focusPoint;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(@Nullable Point point) {
        if (point == null || point.f4104x == null || point.f4105y == null) {
            point = null;
        }
        this.focusPoint = point;
        buildFocusRectangle();
    }
}
