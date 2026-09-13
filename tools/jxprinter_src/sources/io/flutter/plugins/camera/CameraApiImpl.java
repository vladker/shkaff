package io.flutter.plugins.camera;

import android.app.Activity;
import android.hardware.camera2.CameraAccessException;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.camera.features.CameraFeatureFactoryImpl;
import io.flutter.plugins.camera.features.Point;
import io.flutter.view.TextureRegistry;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class CameraApiImpl implements Messages.CameraApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Activity activity;

    @Nullable
    @VisibleForTesting
    Camera camera;
    private final CameraPermissions cameraPermissions;
    private final EventChannel imageStreamChannel;
    private final BinaryMessenger messenger;
    private final CameraPermissions.PermissionsRegistry permissionsRegistry;
    private final TextureRegistry textureRegistry;

    public CameraApiImpl(Activity activity, BinaryMessenger binaryMessenger, CameraPermissions cameraPermissions, CameraPermissions.PermissionsRegistry permissionsRegistry, TextureRegistry textureRegistry) {
        this.activity = activity;
        this.messenger = binaryMessenger;
        this.cameraPermissions = cameraPermissions;
        this.permissionsRegistry = permissionsRegistry;
        this.textureRegistry = textureRegistry;
        this.imageStreamChannel = new EventChannel(binaryMessenger, "plugins.flutter.io/camera_android/imageStream");
        Messages.CameraApi.setUp(binaryMessenger, this);
    }

    private <T> void handleException(Exception exc, Messages.Result<T> result) {
        if (exc instanceof CameraAccessException) {
            result.error(new Messages.FlutterError("CameraAccess", exc.getMessage(), null));
        } else {
            result.error(new Messages.FlutterError("error", exc.getMessage(), null));
        }
    }

    private Long instantiateCamera(String str, Messages.PlatformMediaSettings platformMediaSettings) {
        TextureRegistry.SurfaceTextureEntry surfaceTextureEntryCreateSurfaceTexture = this.textureRegistry.createSurfaceTexture();
        this.camera = new Camera(this.activity, surfaceTextureEntryCreateSurfaceTexture, new CameraFeatureFactoryImpl(), new DartMessenger(new Handler(Looper.getMainLooper()), new Messages.CameraGlobalEventApi(this.messenger), new Messages.CameraEventApi(this.messenger, String.valueOf(surfaceTextureEntryCreateSurfaceTexture.id()))), new CameraPropertiesImpl(str, CameraUtils.getCameraManager(this.activity)), new Camera.VideoCaptureSettings(CameraUtils.resolutionPresetFromPigeon(platformMediaSettings.getResolutionPreset()), platformMediaSettings.getEnableAudio().booleanValue(), platformMediaSettings.getFps() == null ? null : Integer.valueOf(platformMediaSettings.getFps().intValue()), platformMediaSettings.getVideoBitrate() == null ? null : Integer.valueOf(platformMediaSettings.getVideoBitrate().intValue()), platformMediaSettings.getAudioBitrate() != null ? Integer.valueOf(platformMediaSettings.getAudioBitrate().intValue()) : null));
        return Long.valueOf(surfaceTextureEntryCreateSurfaceTexture.id());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$create$0(Messages.Result result, String str, Messages.PlatformMediaSettings platformMediaSettings, String str2, String str3) {
        if (str2 != null) {
            result.error(new Messages.FlutterError(str2, str3, null));
            return;
        }
        try {
            result.success(instantiateCamera(str, platformMediaSettings));
        } catch (Exception e) {
            handleException(e, result);
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void create(@NonNull final String str, @NonNull final Messages.PlatformMediaSettings platformMediaSettings, @NonNull final Messages.Result<Long> result) {
        Camera camera = this.camera;
        if (camera != null) {
            camera.close();
        }
        this.cameraPermissions.requestPermissions(this.activity, this.permissionsRegistry, platformMediaSettings.getEnableAudio().booleanValue(), new CameraPermissions.ResultCallback() { // from class: io.flutter.plugins.camera.f
            @Override // io.flutter.plugins.camera.CameraPermissions.ResultCallback
            public final void onResult(String str2, String str3) {
                this.f4103a.lambda$create$0(result, str, platformMediaSettings, str2, str3);
            }
        });
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void dispose() {
        Camera camera = this.camera;
        if (camera != null) {
            camera.dispose();
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    @NonNull
    public List<Messages.PlatformCameraDescription> getAvailableCameras() {
        Activity activity = this.activity;
        if (activity == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            return CameraUtils.getAvailableCameras(activity);
        } catch (CameraAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    @NonNull
    public Double getExposureOffsetStepSize() {
        return Double.valueOf(this.camera.getExposureOffsetStepSize());
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    @NonNull
    public Double getMaxExposureOffset() {
        return Double.valueOf(this.camera.getMaxExposureOffset());
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    @NonNull
    public Double getMaxZoomLevel() {
        return Double.valueOf(this.camera.getMaxZoomLevel());
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    @NonNull
    public Double getMinExposureOffset() {
        return Double.valueOf(this.camera.getMinExposureOffset());
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    @NonNull
    public Double getMinZoomLevel() {
        return Double.valueOf(this.camera.getMinZoomLevel());
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void initialize(@NonNull Messages.PlatformImageFormatGroup platformImageFormatGroup) {
        Camera camera = this.camera;
        if (camera == null) {
            throw new Messages.FlutterError("cameraNotFound", "Camera not found. Please call the 'create' method before calling 'initialize'.", null);
        }
        try {
            camera.open(CameraUtils.imageFormatGroupFromPigeon(platformImageFormatGroup));
        } catch (CameraAccessException e) {
            throw new Messages.FlutterError("CameraAccessException", e.getMessage(), null);
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void lockCaptureOrientation(@NonNull Messages.PlatformDeviceOrientation platformDeviceOrientation) {
        this.camera.lockCaptureOrientation(CameraUtils.orientationFromPigeon(platformDeviceOrientation));
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void pausePreview() {
        try {
            this.camera.pausePreview();
        } catch (CameraAccessException e) {
            throw new Messages.FlutterError("CameraAccessException", e.getMessage(), null);
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void pauseVideoRecording() {
        this.camera.pauseVideoRecording();
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void resumePreview() {
        this.camera.resumePreview();
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void resumeVideoRecording() {
        this.camera.resumeVideoRecording();
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void setDescriptionWhileRecording(@NonNull String str) {
        try {
            this.camera.setDescriptionWhileRecording(new CameraPropertiesImpl(str, CameraUtils.getCameraManager(this.activity)));
        } catch (CameraAccessException e) {
            throw new Messages.FlutterError("CameraAccessException", e.getMessage(), null);
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void setExposureMode(@NonNull Messages.PlatformExposureMode platformExposureMode, @NonNull Messages.VoidResult voidResult) {
        try {
            this.camera.setExposureMode(voidResult, CameraUtils.exposureModeFromPigeon(platformExposureMode));
        } catch (Exception e) {
            handleException(e, voidResult);
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void setExposureOffset(@NonNull Double d, @NonNull Messages.Result<Double> result) {
        try {
            this.camera.setExposureOffset(result, d.doubleValue());
        } catch (Exception e) {
            handleException(e, result);
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void setExposurePoint(@Nullable Messages.PlatformPoint platformPoint, @NonNull Messages.VoidResult voidResult) {
        try {
            this.camera.setExposurePoint(voidResult, platformPoint == null ? null : new Point(platformPoint.getX(), platformPoint.getY()));
        } catch (Exception e) {
            handleException(e, voidResult);
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void setFlashMode(@NonNull Messages.PlatformFlashMode platformFlashMode, @NonNull Messages.VoidResult voidResult) {
        try {
            this.camera.setFlashMode(voidResult, CameraUtils.flashModeFromPigeon(platformFlashMode));
        } catch (Exception e) {
            handleException(e, voidResult);
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void setFocusMode(@NonNull Messages.PlatformFocusMode platformFocusMode) {
        this.camera.setFocusMode(CameraUtils.focusModeFromPigeon(platformFocusMode));
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void setFocusPoint(@Nullable Messages.PlatformPoint platformPoint, @NonNull Messages.VoidResult voidResult) {
        try {
            this.camera.setFocusPoint(voidResult, platformPoint == null ? null : new Point(platformPoint.getX(), platformPoint.getY()));
        } catch (Exception e) {
            handleException(e, voidResult);
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void setZoomLevel(@NonNull Double d, @NonNull Messages.VoidResult voidResult) {
        this.camera.setZoomLevel(voidResult, d.floatValue());
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void startImageStream() {
        try {
            this.camera.startPreviewWithImageStream(this.imageStreamChannel);
        } catch (CameraAccessException e) {
            throw new Messages.FlutterError("CameraAccessException", e.getMessage(), null);
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void startVideoRecording(@NonNull Boolean bool) {
        this.camera.startVideoRecording(bool.booleanValue() ? this.imageStreamChannel : null);
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void stopImageStream() {
        try {
            this.camera.startPreview(null);
        } catch (Exception e) {
            throw new Messages.FlutterError(e.getClass().getName(), e.getMessage(), null);
        }
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    @NonNull
    public String stopVideoRecording() {
        return this.camera.stopVideoRecording();
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void takePicture(@NonNull Messages.Result<String> result) {
        this.camera.takePicture(result);
    }

    public void tearDownMessageHandler() {
        Messages.CameraApi.setUp(this.messenger, null);
    }

    @Override // io.flutter.plugins.camera.Messages.CameraApi
    public void unlockCaptureOrientation() {
        this.camera.unlockCaptureOrientation();
    }

    private void handleException(Exception exc, Messages.VoidResult voidResult) {
        if (exc instanceof CameraAccessException) {
            voidResult.error(new Messages.FlutterError("CameraAccess", exc.getMessage(), null));
        } else {
            voidResult.error(new Messages.FlutterError("error", exc.getMessage(), null));
        }
    }
}
