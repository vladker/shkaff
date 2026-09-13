package io.flutter.plugins.camera.features.noisereduction;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.SdkCapabilityChecker;
import io.flutter.plugins.camera.features.CameraFeature;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class NoiseReductionFeature extends CameraFeature<NoiseReductionMode> {
    private final HashMap<NoiseReductionMode, Integer> NOISE_REDUCTION_MODES;

    @NonNull
    private NoiseReductionMode currentSetting;

    public NoiseReductionFeature(@NonNull CameraProperties cameraProperties) {
        super(cameraProperties);
        NoiseReductionMode noiseReductionMode = NoiseReductionMode.fast;
        this.currentSetting = noiseReductionMode;
        HashMap<NoiseReductionMode, Integer> map = new HashMap<>();
        this.NOISE_REDUCTION_MODES = map;
        map.put(NoiseReductionMode.off, 0);
        map.put(noiseReductionMode, 1);
        map.put(NoiseReductionMode.highQuality, 2);
        if (SdkCapabilityChecker.supportsMarshmallowNoiseReductionModes()) {
            map.put(NoiseReductionMode.minimal, 3);
            map.put(NoiseReductionMode.zeroShutterLag, 4);
        }
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        int[] availableNoiseReductionModes = this.cameraProperties.getAvailableNoiseReductionModes();
        return availableNoiseReductionModes != null && availableNoiseReductionModes.length > 0;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    public String getDebugName() {
        return "NoiseReductionFeature";
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(@NonNull CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            builder.set(CaptureRequest.NOISE_REDUCTION_MODE, this.NOISE_REDUCTION_MODES.get(this.currentSetting));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public NoiseReductionMode getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(@NonNull NoiseReductionMode noiseReductionMode) {
        this.currentSetting = noiseReductionMode;
    }
}
