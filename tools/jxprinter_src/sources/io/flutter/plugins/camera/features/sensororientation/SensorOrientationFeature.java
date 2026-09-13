package io.flutter.plugins.camera.features.sensororientation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.DartMessenger;
import io.flutter.plugins.camera.features.CameraFeature;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class SensorOrientationFeature extends CameraFeature<Integer> {

    @NonNull
    private Integer currentSetting;

    @NonNull
    private final DeviceOrientationManager deviceOrientationListener;

    @Nullable
    private PlatformChannel.DeviceOrientation lockedCaptureOrientation;

    public SensorOrientationFeature(@NonNull CameraProperties cameraProperties, @NonNull Activity activity, @NonNull DartMessenger dartMessenger) {
        super(cameraProperties);
        this.currentSetting = 0;
        setValue(Integer.valueOf(cameraProperties.getSensorOrientation()));
        DeviceOrientationManager deviceOrientationManagerCreate = DeviceOrientationManager.create(activity, dartMessenger, cameraProperties.getLensFacing() == 0, this.currentSetting.intValue());
        this.deviceOrientationListener = deviceOrientationManagerCreate;
        deviceOrientationManagerCreate.start();
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        return true;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    public String getDebugName() {
        return "SensorOrientationFeature";
    }

    @NonNull
    public DeviceOrientationManager getDeviceOrientationManager() {
        return this.deviceOrientationListener;
    }

    @Nullable
    public PlatformChannel.DeviceOrientation getLockedCaptureOrientation() {
        return this.lockedCaptureOrientation;
    }

    public void lockCaptureOrientation(@NonNull PlatformChannel.DeviceOrientation deviceOrientation) {
        this.lockedCaptureOrientation = deviceOrientation;
    }

    public void unlockCaptureOrientation() {
        this.lockedCaptureOrientation = null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public Integer getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(@NonNull Integer num) {
        this.currentSetting = num;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(@NonNull CaptureRequest.Builder builder) {
    }
}
