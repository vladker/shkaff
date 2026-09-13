package io.flutter.plugins.camera.features;

import android.app.Activity;
import androidx.annotation.NonNull;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.DartMessenger;
import io.flutter.plugins.camera.features.autofocus.AutoFocusFeature;
import io.flutter.plugins.camera.features.exposurelock.ExposureLockFeature;
import io.flutter.plugins.camera.features.exposureoffset.ExposureOffsetFeature;
import io.flutter.plugins.camera.features.exposurepoint.ExposurePointFeature;
import io.flutter.plugins.camera.features.flash.FlashFeature;
import io.flutter.plugins.camera.features.focuspoint.FocusPointFeature;
import io.flutter.plugins.camera.features.fpsrange.FpsRangeFeature;
import io.flutter.plugins.camera.features.noisereduction.NoiseReductionFeature;
import io.flutter.plugins.camera.features.resolution.ResolutionFeature;
import io.flutter.plugins.camera.features.resolution.ResolutionPreset;
import io.flutter.plugins.camera.features.sensororientation.SensorOrientationFeature;
import io.flutter.plugins.camera.features.zoomlevel.ZoomLevelFeature;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CameraFeatureFactoryImpl implements CameraFeatureFactory {
    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    @NonNull
    public AutoFocusFeature createAutoFocusFeature(@NonNull CameraProperties cameraProperties, boolean z6) {
        return new AutoFocusFeature(cameraProperties, z6);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    @NonNull
    public ExposureLockFeature createExposureLockFeature(@NonNull CameraProperties cameraProperties) {
        return new ExposureLockFeature(cameraProperties);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    @NonNull
    public ExposureOffsetFeature createExposureOffsetFeature(@NonNull CameraProperties cameraProperties) {
        return new ExposureOffsetFeature(cameraProperties);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    @NonNull
    public ExposurePointFeature createExposurePointFeature(@NonNull CameraProperties cameraProperties, @NonNull SensorOrientationFeature sensorOrientationFeature) {
        return new ExposurePointFeature(cameraProperties, sensorOrientationFeature);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    @NonNull
    public FlashFeature createFlashFeature(@NonNull CameraProperties cameraProperties) {
        return new FlashFeature(cameraProperties);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    @NonNull
    public FocusPointFeature createFocusPointFeature(@NonNull CameraProperties cameraProperties, @NonNull SensorOrientationFeature sensorOrientationFeature) {
        return new FocusPointFeature(cameraProperties, sensorOrientationFeature);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    @NonNull
    public FpsRangeFeature createFpsRangeFeature(@NonNull CameraProperties cameraProperties) {
        return new FpsRangeFeature(cameraProperties);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    @NonNull
    public NoiseReductionFeature createNoiseReductionFeature(@NonNull CameraProperties cameraProperties) {
        return new NoiseReductionFeature(cameraProperties);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    @NonNull
    public ResolutionFeature createResolutionFeature(@NonNull CameraProperties cameraProperties, @NonNull ResolutionPreset resolutionPreset, @NonNull String str) {
        return new ResolutionFeature(cameraProperties, resolutionPreset, str);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    @NonNull
    public SensorOrientationFeature createSensorOrientationFeature(@NonNull CameraProperties cameraProperties, @NonNull Activity activity, @NonNull DartMessenger dartMessenger) {
        return new SensorOrientationFeature(cameraProperties, activity, dartMessenger);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeatureFactory
    @NonNull
    public ZoomLevelFeature createZoomLevelFeature(@NonNull CameraProperties cameraProperties) {
        return new ZoomLevelFeature(cameraProperties);
    }
}
