package io.flutter.plugins.camera.features;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import io.flutter.plugins.camera.CameraProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraFeature<T> {
    protected final CameraProperties cameraProperties;

    public CameraFeature(@NonNull CameraProperties cameraProperties) {
        this.cameraProperties = cameraProperties;
    }

    public abstract boolean checkIsSupported();

    @NonNull
    public abstract String getDebugName();

    public abstract T getValue();

    public abstract void setValue(T t6);

    public abstract void updateBuilder(@NonNull CaptureRequest.Builder builder);
}
