package io.flutter.plugins.camera;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CameraPropertiesImpl implements CameraProperties {
    private final CameraCharacteristics cameraCharacteristics;
    private final String cameraName;

    public CameraPropertiesImpl(@NonNull String str, @NonNull CameraManager cameraManager) {
        this.cameraName = str;
        this.cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @NonNull
    public int[] getAvailableNoiseReductionModes() {
        return (int[]) this.cameraCharacteristics.get(CameraCharacteristics.NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @NonNull
    public String getCameraName() {
        return this.cameraName;
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @NonNull
    public Range<Integer>[] getControlAutoExposureAvailableTargetFpsRanges() {
        return (Range[]) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @NonNull
    public Range<Integer> getControlAutoExposureCompensationRange() {
        return (Range) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    public double getControlAutoExposureCompensationStep() {
        Rational rational = (Rational) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (rational == null) {
            return 0.0d;
        }
        return rational.doubleValue();
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @NonNull
    public int[] getControlAutoFocusAvailableModes() {
        return (int[]) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @NonNull
    public Integer getControlMaxRegionsAutoExposure() {
        return (Integer) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @NonNull
    public Integer getControlMaxRegionsAutoFocus() {
        return (Integer) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @Nullable
    @RequiresApi(api = 28)
    public int[] getDistortionCorrectionAvailableModes() {
        return (int[]) this.cameraCharacteristics.get(CameraCharacteristics.DISTORTION_CORRECTION_AVAILABLE_MODES);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @NonNull
    public Boolean getFlashInfoAvailable() {
        return (Boolean) this.cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    public int getHardwareLevel() {
        return ((Integer) this.cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    public int getLensFacing() {
        return ((Integer) this.cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @Nullable
    public Float getLensInfoMinimumFocusDistance() {
        return (Float) this.cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @NonNull
    public Float getScalerAvailableMaxDigitalZoom() {
        return (Float) this.cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @Nullable
    @RequiresApi(api = 30)
    public Float getScalerMaxZoomRatio() {
        Range range = (Range) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        if (range != null) {
            return (Float) range.getUpper();
        }
        return null;
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @Nullable
    @RequiresApi(api = 30)
    public Float getScalerMinZoomRatio() {
        Range range = (Range) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        if (range != null) {
            return (Float) range.getLower();
        }
        return null;
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @NonNull
    public Rect getSensorInfoActiveArraySize() {
        return (Rect) this.cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @NonNull
    public Size getSensorInfoPixelArraySize() {
        return (Size) this.cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    @NonNull
    @RequiresApi(api = 23)
    public Rect getSensorInfoPreCorrectionActiveArraySize() {
        return (Rect) this.cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE);
    }

    @Override // io.flutter.plugins.camera.CameraProperties
    public int getSensorOrientation() {
        return ((Integer) this.cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    }
}
