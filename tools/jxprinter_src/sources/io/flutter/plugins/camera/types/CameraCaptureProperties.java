package io.flutter.plugins.camera.types;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CameraCaptureProperties {
    private Float lastLensAperture;
    private Long lastSensorExposureTime;
    private Integer lastSensorSensitivity;

    @Nullable
    public Float getLastLensAperture() {
        return this.lastLensAperture;
    }

    @Nullable
    public Long getLastSensorExposureTime() {
        return this.lastSensorExposureTime;
    }

    @Nullable
    public Integer getLastSensorSensitivity() {
        return this.lastSensorSensitivity;
    }

    public void setLastLensAperture(@NonNull Float f6) {
        this.lastLensAperture = f6;
    }

    public void setLastSensorExposureTime(@NonNull Long l6) {
        this.lastSensorExposureTime = l6;
    }

    public void setLastSensorSensitivity(@NonNull Integer num) {
        this.lastSensorSensitivity = num;
    }
}
