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
public interface CameraFeatureFactory {
    @NonNull
    AutoFocusFeature createAutoFocusFeature(@NonNull CameraProperties cameraProperties, boolean z6);

    @NonNull
    ExposureLockFeature createExposureLockFeature(@NonNull CameraProperties cameraProperties);

    @NonNull
    ExposureOffsetFeature createExposureOffsetFeature(@NonNull CameraProperties cameraProperties);

    @NonNull
    ExposurePointFeature createExposurePointFeature(@NonNull CameraProperties cameraProperties, @NonNull SensorOrientationFeature sensorOrientationFeature);

    @NonNull
    FlashFeature createFlashFeature(@NonNull CameraProperties cameraProperties);

    @NonNull
    FocusPointFeature createFocusPointFeature(@NonNull CameraProperties cameraProperties, @NonNull SensorOrientationFeature sensorOrientationFeature);

    @NonNull
    FpsRangeFeature createFpsRangeFeature(@NonNull CameraProperties cameraProperties);

    @NonNull
    NoiseReductionFeature createNoiseReductionFeature(@NonNull CameraProperties cameraProperties);

    @NonNull
    ResolutionFeature createResolutionFeature(@NonNull CameraProperties cameraProperties, @NonNull ResolutionPreset resolutionPreset, @NonNull String str);

    @NonNull
    SensorOrientationFeature createSensorOrientationFeature(@NonNull CameraProperties cameraProperties, @NonNull Activity activity, @NonNull DartMessenger dartMessenger);

    @NonNull
    ZoomLevelFeature createZoomLevelFeature(@NonNull CameraProperties cameraProperties);
}
