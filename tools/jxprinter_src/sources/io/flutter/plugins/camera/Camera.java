package io.flutter.plugins.camera;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.camera.features.CameraFeature;
import io.flutter.plugins.camera.features.CameraFeatureFactory;
import io.flutter.plugins.camera.features.CameraFeatures;
import io.flutter.plugins.camera.features.Point;
import io.flutter.plugins.camera.features.autofocus.AutoFocusFeature;
import io.flutter.plugins.camera.features.autofocus.FocusMode;
import io.flutter.plugins.camera.features.exposurelock.ExposureLockFeature;
import io.flutter.plugins.camera.features.exposurelock.ExposureMode;
import io.flutter.plugins.camera.features.exposureoffset.ExposureOffsetFeature;
import io.flutter.plugins.camera.features.exposurepoint.ExposurePointFeature;
import io.flutter.plugins.camera.features.flash.FlashFeature;
import io.flutter.plugins.camera.features.flash.FlashMode;
import io.flutter.plugins.camera.features.focuspoint.FocusPointFeature;
import io.flutter.plugins.camera.features.fpsrange.FpsRangeFeature;
import io.flutter.plugins.camera.features.resolution.ResolutionFeature;
import io.flutter.plugins.camera.features.resolution.ResolutionPreset;
import io.flutter.plugins.camera.features.sensororientation.DeviceOrientationManager;
import io.flutter.plugins.camera.features.zoomlevel.ZoomLevelFeature;
import io.flutter.plugins.camera.media.ImageStreamReader;
import io.flutter.plugins.camera.media.MediaRecorderBuilder;
import io.flutter.plugins.camera.types.CameraCaptureProperties;
import io.flutter.plugins.camera.types.CaptureTimeoutsWrapper;
import io.flutter.view.TextureRegistry;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class Camera implements CameraCaptureCallback.CameraCaptureStateListener, ImageReader.OnImageAvailableListener {
    private static final String TAG = "Camera";
    private final Activity activity;
    private final Context applicationContext;
    Handler backgroundHandler;
    private HandlerThread backgroundHandlerThread;
    private final CameraCaptureCallback cameraCaptureCallback;
    CameraDeviceWrapper cameraDevice;
    private final CameraFeatureFactory cameraFeatureFactory;
    CameraFeatures cameraFeatures;
    private CameraProperties cameraProperties;
    private File captureFile;
    private CameraCaptureProperties captureProps;
    CameraCaptureSession captureSession;
    private CaptureTimeoutsWrapper captureTimeouts;
    final DartMessenger dartMessenger;
    Messages.Result<String> flutterResult;

    @VisibleForTesting
    final TextureRegistry.SurfaceTextureEntry flutterTexture;
    private int imageFormatGroup;
    ImageStreamReader imageStreamReader;

    @VisibleForTesting
    int initialCameraFacing;

    @VisibleForTesting
    MediaRecorder mediaRecorder;

    @VisibleForTesting
    boolean pausedPreview;

    @VisibleForTesting
    ImageReader pictureImageReader;
    CaptureRequest.Builder previewRequestBuilder;
    boolean recordingVideo;
    private final VideoCaptureSettings videoCaptureSettings;

    @VisibleForTesting
    VideoRenderer videoRenderer;

    /* JADX INFO: renamed from: io.flutter.plugins.camera.Camera$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass1 extends CameraDevice.StateCallback {
        final /* synthetic */ ResolutionFeature val$resolutionFeature;

        public AnonymousClass1(ResolutionFeature resolutionFeature) {
            this.val$resolutionFeature = resolutionFeature;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOpened$0(ResolutionFeature resolutionFeature) {
            Camera.this.dartMessenger.sendCameraInitializedEvent(Integer.valueOf(resolutionFeature.getPreviewSize().getWidth()), Integer.valueOf(resolutionFeature.getPreviewSize().getHeight()), Camera.this.cameraFeatures.getExposureLock().getValue(), Camera.this.cameraFeatures.getAutoFocus().getValue(), Boolean.valueOf(Camera.this.cameraFeatures.getExposurePoint().checkIsSupported()), Boolean.valueOf(Camera.this.cameraFeatures.getFocusPoint().checkIsSupported()));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(@NonNull CameraDevice cameraDevice) {
            Log.i(Camera.TAG, "open | onClosed");
            Camera camera = Camera.this;
            camera.cameraDevice = null;
            camera.closeCaptureSession();
            Camera.this.dartMessenger.sendCameraClosingEvent();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            Log.i(Camera.TAG, "open | onDisconnected");
            Camera.this.close();
            Camera.this.dartMessenger.sendCameraErrorEvent("The camera was disconnected.");
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i5) {
            String str;
            Log.i(Camera.TAG, "open | onError");
            Camera.this.close();
            if (i5 == 1) {
                str = "The camera device is in use already.";
            } else if (i5 == 2) {
                str = "Max cameras in use";
            } else if (i5 == 3) {
                str = "The camera device could not be opened due to a device policy.";
            } else if (i5 != 4) {
                str = i5 != 5 ? "Unknown camera error" : "The camera service has encountered a fatal error.";
            } else {
                str = "The camera device has encountered a fatal error";
            }
            Camera.this.dartMessenger.sendCameraErrorEvent(str);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            Camera camera = Camera.this;
            camera.cameraDevice = camera.new DefaultCameraDeviceWrapper(cameraDevice);
            try {
                Camera camera2 = Camera.this;
                camera2.startPreview(camera2.recordingVideo ? null : new b(this, this.val$resolutionFeature, 1));
            } catch (Exception e) {
                Camera.this.dartMessenger.sendCameraErrorEvent(e.getMessage() == null ? e.getClass().getName().concat(" occurred while opening camera.") : e.getMessage());
                Camera.this.close();
            }
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.camera.Camera$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass2 extends CameraCaptureSession.StateCallback {
        boolean captureSessionClosed = false;
        final /* synthetic */ Runnable val$onSuccessCallback;

        public AnonymousClass2(Runnable runnable) {
            this.val$onSuccessCallback = runnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onConfigured$0(String str, String str2) {
            Camera.this.dartMessenger.sendCameraErrorEvent(str2);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
            Log.i(Camera.TAG, "CameraCaptureSession onClosed");
            this.captureSessionClosed = true;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            Log.i(Camera.TAG, "CameraCaptureSession onConfigureFailed");
            Camera.this.dartMessenger.sendCameraErrorEvent("Failed to configure camera session.");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            Log.i(Camera.TAG, "CameraCaptureSession onConfigured");
            Camera camera = Camera.this;
            if (camera.cameraDevice == null || this.captureSessionClosed) {
                camera.dartMessenger.sendCameraErrorEvent("The camera was closed during configuration.");
                return;
            }
            camera.captureSession = cameraCaptureSession;
            Log.i(Camera.TAG, "Updating builder settings");
            Camera camera2 = Camera.this;
            camera2.updateBuilderSettings(camera2.previewRequestBuilder);
            Camera.this.refreshPreviewCaptureSession(this.val$onSuccessCallback, new c(this, 1));
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugins.camera.Camera$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode;

        static {
            int[] iArr = new int[FocusMode.values().length];
            $SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode = iArr;
            try {
                iArr[FocusMode.locked.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode[FocusMode.auto.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class DefaultCameraDeviceWrapper implements CameraDeviceWrapper {
        private final CameraDevice cameraDevice;

        public DefaultCameraDeviceWrapper(CameraDevice cameraDevice) {
            this.cameraDevice = cameraDevice;
        }

        @Override // io.flutter.plugins.camera.CameraDeviceWrapper
        public void close() {
            this.cameraDevice.close();
        }

        @Override // io.flutter.plugins.camera.CameraDeviceWrapper
        @NonNull
        public CaptureRequest.Builder createCaptureRequest(int i5) {
            return this.cameraDevice.createCaptureRequest(i5);
        }

        @Override // io.flutter.plugins.camera.CameraDeviceWrapper
        @SuppressLint({"UseRequiresApi"})
        @TargetApi(28)
        public void createCaptureSession(SessionConfiguration sessionConfiguration) throws CameraAccessException {
            this.cameraDevice.createCaptureSession(sessionConfiguration);
        }

        @Override // io.flutter.plugins.camera.CameraDeviceWrapper
        public void createCaptureSession(@NonNull List<Surface> list, @NonNull CameraCaptureSession.StateCallback stateCallback, @Nullable Handler handler) throws CameraAccessException {
            this.cameraDevice.createCaptureSession(list, stateCallback, Camera.this.backgroundHandler);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class HandlerFactory {
        @VisibleForTesting
        public static Handler create(Looper looper) {
            return new Handler(looper);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class HandlerThreadFactory {
        @VisibleForTesting
        public static HandlerThread create(String str) {
            return new HandlerThread(str);
        }
    }

    public Camera(Activity activity, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, CameraFeatureFactory cameraFeatureFactory, DartMessenger dartMessenger, CameraProperties cameraProperties, VideoCaptureSettings videoCaptureSettings) {
        if (activity == null) {
            throw new IllegalStateException("No activity available!");
        }
        this.activity = activity;
        this.flutterTexture = surfaceTextureEntry;
        this.dartMessenger = dartMessenger;
        this.applicationContext = activity.getApplicationContext();
        this.cameraProperties = cameraProperties;
        this.cameraFeatureFactory = cameraFeatureFactory;
        this.videoCaptureSettings = videoCaptureSettings;
        this.cameraFeatures = CameraFeatures.init(cameraFeatureFactory, cameraProperties, activity, dartMessenger, videoCaptureSettings.resolutionPreset);
        this.captureTimeouts = new CaptureTimeoutsWrapper(3000L, 3000L);
        CameraCaptureProperties cameraCaptureProperties = new CameraCaptureProperties();
        this.captureProps = cameraCaptureProperties;
        this.cameraCaptureCallback = CameraCaptureCallback.create(this, this.captureTimeouts, cameraCaptureProperties);
        startBackgroundThread();
    }

    private void closeRenderer() {
        VideoRenderer videoRenderer = this.videoRenderer;
        if (videoRenderer != null) {
            videoRenderer.close();
            this.videoRenderer = null;
        }
    }

    @SuppressLint({"UseRequiresApi"})
    @TargetApi(28)
    private void createCaptureSessionWithSessionConfig(List<OutputConfiguration> list, CameraCaptureSession.StateCallback stateCallback) {
        CameraDeviceWrapper cameraDeviceWrapper = this.cameraDevice;
        com.google.firebase.crashlytics.internal.common.a.l();
        cameraDeviceWrapper.createCaptureSession(com.google.firebase.crashlytics.internal.common.a.j(list, Executors.newSingleThreadExecutor(), stateCallback));
    }

    private Display getDefaultDisplay() {
        return this.activity.getWindowManager().getDefaultDisplay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resumePreview$10(String str, String str2) {
        this.dartMessenger.sendCameraErrorEvent(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runPrecaptureSequence$1(String str, String str2) {
        this.dartMessenger.error(this.flutterResult, "cameraAccess", str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setExposureMode$4(Messages.VoidResult voidResult, String str, String str2) {
        voidResult.error(new Messages.FlutterError("setExposureModeFailed", "Could not set exposure mode.", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setExposureOffset$7(Messages.Result result, ExposureOffsetFeature exposureOffsetFeature) {
        result.success(exposureOffsetFeature.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setExposureOffset$8(Messages.Result result, String str, String str2) {
        result.error(new Messages.FlutterError("setExposureOffsetFailed", "Could not set exposure offset.", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setExposurePoint$5(Messages.VoidResult voidResult, String str, String str2) {
        voidResult.error(new Messages.FlutterError("setExposurePointFailed", "Could not set exposure point.", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setFlashMode$3(Messages.VoidResult voidResult, String str, String str2) {
        voidResult.error(new Messages.FlutterError("setFlashModeFailed", "Could not set flash mode.", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setFocusPoint$6(Messages.VoidResult voidResult, String str, String str2) {
        voidResult.error(new Messages.FlutterError("setFocusPointFailed", "Could not set focus point.", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setZoomLevel$9(Messages.VoidResult voidResult, String str, String str2) {
        voidResult.error(new Messages.FlutterError("setZoomLevelFailed", "Could not set zoom level.", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCapture$0() {
        this.mediaRecorder.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unlockAutoFocus$2(String str, String str2) {
        this.dartMessenger.error(this.flutterResult, str, str2, null);
    }

    private void lockAutoFocus() {
        Log.i(TAG, "lockAutoFocus");
        if (this.captureSession == null) {
            Log.i(TAG, "[unlockAutoFocus] captureSession null, returning");
            return;
        }
        this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        try {
            this.captureSession.capture(this.previewRequestBuilder.build(), null, this.backgroundHandler);
        } catch (CameraAccessException e) {
            this.dartMessenger.sendCameraErrorEvent(e.getMessage() == null ? "CameraAccessException occurred while locking autofocus." : e.getMessage());
        }
    }

    private void prepareMediaRecorder(String str) {
        MediaRecorderBuilder mediaRecorderBuilder;
        Log.i(TAG, "prepareMediaRecorder");
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.release();
        }
        closeRenderer();
        PlatformChannel.DeviceOrientation lockedCaptureOrientation = this.cameraFeatures.getSensorOrientation().getLockedCaptureOrientation();
        if (!SdkCapabilityChecker.supportsEncoderProfiles() || getRecordingProfile() == null) {
            CamcorderProfile recordingProfileLegacy = getRecordingProfileLegacy();
            VideoCaptureSettings videoCaptureSettings = this.videoCaptureSettings;
            mediaRecorderBuilder = new MediaRecorderBuilder(recordingProfileLegacy, new MediaRecorderBuilder.RecordingParameters(str, videoCaptureSettings.fps, videoCaptureSettings.videoBitrate, videoCaptureSettings.audioBitrate));
        } else {
            EncoderProfiles recordingProfile = getRecordingProfile();
            VideoCaptureSettings videoCaptureSettings2 = this.videoCaptureSettings;
            mediaRecorderBuilder = new MediaRecorderBuilder(recordingProfile, new MediaRecorderBuilder.RecordingParameters(str, videoCaptureSettings2.fps, videoCaptureSettings2.videoBitrate, videoCaptureSettings2.audioBitrate));
        }
        this.mediaRecorder = mediaRecorderBuilder.setEnableAudio(this.videoCaptureSettings.enableAudio).setMediaOrientation(lockedCaptureOrientation == null ? getDeviceOrientationManager().getVideoOrientation() : getDeviceOrientationManager().getVideoOrientation(lockedCaptureOrientation)).build();
    }

    private void prepareVideoRenderer() {
        if (this.videoRenderer != null) {
            return;
        }
        ResolutionFeature resolution = this.cameraFeatures.getResolution();
        this.videoRenderer = new VideoRenderer(this.mediaRecorder.getSurface(), resolution.getCaptureSize().getWidth(), resolution.getCaptureSize().getHeight(), new Thread.UncaughtExceptionHandler() { // from class: io.flutter.plugins.camera.Camera.6
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                Camera.this.dartMessenger.sendCameraErrorEvent("Failed to process frames after camera was flipped.");
            }
        });
    }

    private void runPictureAutoFocus() {
        Log.i(TAG, "runPictureAutoFocus");
        this.cameraCaptureCallback.setCameraState(CameraState.STATE_WAITING_FOCUS);
        lockAutoFocus();
    }

    private void runPrecaptureSequence() {
        Log.i(TAG, "runPrecaptureSequence");
        try {
            CaptureRequest.Builder builder = this.previewRequestBuilder;
            CaptureRequest.Key key = CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER;
            builder.set(key, 0);
            this.captureSession.capture(this.previewRequestBuilder.build(), this.cameraCaptureCallback, this.backgroundHandler);
            refreshPreviewCaptureSession(null, new d(this, 1));
            this.cameraCaptureCallback.setCameraState(CameraState.STATE_WAITING_PRECAPTURE_START);
            this.previewRequestBuilder.set(key, 1);
            this.captureSession.capture(this.previewRequestBuilder.build(), this.cameraCaptureCallback, this.backgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    private void setFpsCameraFeatureForRecording(CameraProperties cameraProperties) {
        Integer numValueOf;
        Integer num = this.videoCaptureSettings.fps;
        if (num != null && num.intValue() > 0) {
            numValueOf = this.videoCaptureSettings.fps;
        } else if (SdkCapabilityChecker.supportsEncoderProfiles()) {
            EncoderProfiles recordingProfile = getRecordingProfile();
            if (recordingProfile == null || recordingProfile.getVideoProfiles().size() <= 0) {
                numValueOf = null;
            } else {
                numValueOf = Integer.valueOf(io.flutter.plugin.platform.f.f(recordingProfile.getVideoProfiles().get(0)).getFrameRate());
            }
        } else {
            CamcorderProfile recordingProfileLegacy = getRecordingProfileLegacy();
            if (recordingProfileLegacy != null) {
                numValueOf = Integer.valueOf(recordingProfileLegacy.videoFrameRate);
            } else {
                numValueOf = null;
            }
        }
        if (numValueOf == null || numValueOf.intValue() <= 0) {
            return;
        }
        FpsRangeFeature fpsRangeFeature = new FpsRangeFeature(cameraProperties);
        fpsRangeFeature.setValue(new Range<>(numValueOf, numValueOf));
        this.cameraFeatures.setFpsRange(fpsRangeFeature);
    }

    private void setStreamHandler(EventChannel eventChannel) {
        eventChannel.setStreamHandler(new EventChannel.StreamHandler() { // from class: io.flutter.plugins.camera.Camera.5
            @Override // io.flutter.plugin.common.EventChannel.StreamHandler
            public void onCancel(Object obj) {
                Camera camera = Camera.this;
                ImageStreamReader imageStreamReader = camera.imageStreamReader;
                if (imageStreamReader == null) {
                    return;
                }
                imageStreamReader.removeListener(camera.backgroundHandler);
            }

            @Override // io.flutter.plugin.common.EventChannel.StreamHandler
            public void onListen(Object obj, EventChannel.EventSink eventSink) {
                Camera.this.setImageStreamImageAvailableListener(eventSink);
            }
        });
    }

    private void startCapture(boolean z6, boolean z7) {
        e eVar;
        ImageStreamReader imageStreamReader;
        ArrayList arrayList = new ArrayList();
        if (z6) {
            arrayList.add(this.mediaRecorder.getSurface());
            eVar = new e(this, 0);
        } else {
            eVar = null;
        }
        if (z7 && (imageStreamReader = this.imageStreamReader) != null) {
            arrayList.add(imageStreamReader.getSurface());
        }
        arrayList.add(this.pictureImageReader.getSurface());
        createCaptureSession(3, eVar, (Surface[]) arrayList.toArray(new Surface[0]));
    }

    private void startPreviewWithVideoRendererStream(@Nullable Runnable runnable) {
        int videoOrientation;
        if (this.videoRenderer == null) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        PlatformChannel.DeviceOrientation lockedCaptureOrientation = this.cameraFeatures.getSensorOrientation().getLockedCaptureOrientation();
        DeviceOrientationManager deviceOrientationManager = this.cameraFeatures.getSensorOrientation().getDeviceOrientationManager();
        if (deviceOrientationManager != null) {
            videoOrientation = lockedCaptureOrientation == null ? deviceOrientationManager.getVideoOrientation() : deviceOrientationManager.getVideoOrientation(lockedCaptureOrientation);
        } else {
            videoOrientation = 0;
        }
        if (this.cameraProperties.getLensFacing() != this.initialCameraFacing) {
            videoOrientation = (videoOrientation + 180) % 360;
        }
        this.videoRenderer.setRotation(videoOrientation);
        createCaptureSession(3, runnable, this.videoRenderer.getInputSurface());
    }

    private void startRegularPreview(@Nullable Runnable runnable) {
        ImageReader imageReader = this.pictureImageReader;
        if (imageReader != null && imageReader.getSurface() != null) {
            Log.i(TAG, "startPreview");
            createCaptureSession(1, runnable, this.pictureImageReader.getSurface());
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void stopAndReleaseCamera() {
        CameraDeviceWrapper cameraDeviceWrapper = this.cameraDevice;
        if (cameraDeviceWrapper == null) {
            closeCaptureSession();
            return;
        }
        cameraDeviceWrapper.close();
        this.cameraDevice = null;
        this.captureSession = null;
    }

    private void takePictureAfterPrecapture() {
        Log.i(TAG, "captureStillPicture");
        this.cameraCaptureCallback.setCameraState(CameraState.STATE_CAPTURING);
        CameraDeviceWrapper cameraDeviceWrapper = this.cameraDevice;
        if (cameraDeviceWrapper == null) {
            return;
        }
        try {
            CaptureRequest.Builder builderCreateCaptureRequest = cameraDeviceWrapper.createCaptureRequest(2);
            builderCreateCaptureRequest.addTarget(this.pictureImageReader.getSurface());
            CaptureRequest.Key key = CaptureRequest.SCALER_CROP_REGION;
            builderCreateCaptureRequest.set(key, (Rect) this.previewRequestBuilder.get(key));
            updateBuilderSettings(builderCreateCaptureRequest);
            PlatformChannel.DeviceOrientation lockedCaptureOrientation = this.cameraFeatures.getSensorOrientation().getLockedCaptureOrientation();
            builderCreateCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(lockedCaptureOrientation == null ? getDeviceOrientationManager().getPhotoOrientation() : getDeviceOrientationManager().getPhotoOrientation(lockedCaptureOrientation)));
            CameraCaptureSession.CaptureCallback captureCallback = new CameraCaptureSession.CaptureCallback() { // from class: io.flutter.plugins.camera.Camera.3
                @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                    Camera.this.unlockAutoFocus();
                }
            };
            try {
                Log.i(TAG, "sending capture request");
                this.captureSession.capture(builderCreateCaptureRequest.build(), captureCallback, this.backgroundHandler);
            } catch (CameraAccessException e) {
                this.dartMessenger.error(this.flutterResult, "cameraAccess", e.getMessage(), null);
            }
        } catch (CameraAccessException e6) {
            this.dartMessenger.error(this.flutterResult, "cameraAccess", e6.getMessage(), null);
        }
    }

    public void close() {
        Log.i(TAG, "close");
        stopAndReleaseCamera();
        ImageReader imageReader = this.pictureImageReader;
        if (imageReader != null) {
            imageReader.close();
            this.pictureImageReader = null;
        }
        ImageStreamReader imageStreamReader = this.imageStreamReader;
        if (imageStreamReader != null) {
            imageStreamReader.close();
            this.imageStreamReader = null;
        }
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.reset();
            this.mediaRecorder.release();
            this.mediaRecorder = null;
        }
        stopBackgroundThread();
    }

    public void closeCaptureSession() {
        if (this.captureSession != null) {
            Log.i(TAG, "closeCaptureSession");
            this.captureSession.close();
            this.captureSession = null;
        }
    }

    @VisibleForTesting
    public void createCaptureSession(int i5, Surface... surfaceArr) {
        createCaptureSession(i5, null, surfaceArr);
    }

    public void dispose() {
        Log.i(TAG, "dispose");
        close();
        this.flutterTexture.release();
        getDeviceOrientationManager().stop();
    }

    public DeviceOrientationManager getDeviceOrientationManager() {
        return this.cameraFeatures.getSensorOrientation().getDeviceOrientationManager();
    }

    public double getExposureOffsetStepSize() {
        return this.cameraFeatures.getExposureOffset().getExposureOffsetStepSize();
    }

    public double getMaxExposureOffset() {
        return this.cameraFeatures.getExposureOffset().getMaxExposureOffset();
    }

    public float getMaxZoomLevel() {
        return this.cameraFeatures.getZoomLevel().getMaximumZoomLevel();
    }

    public double getMinExposureOffset() {
        return this.cameraFeatures.getExposureOffset().getMinExposureOffset();
    }

    public float getMinZoomLevel() {
        return this.cameraFeatures.getZoomLevel().getMinimumZoomLevel();
    }

    public EncoderProfiles getRecordingProfile() {
        return this.cameraFeatures.getResolution().getRecordingProfile();
    }

    public CamcorderProfile getRecordingProfileLegacy() {
        return this.cameraFeatures.getResolution().getRecordingProfileLegacy();
    }

    public void lockCaptureOrientation(PlatformChannel.DeviceOrientation deviceOrientation) {
        this.cameraFeatures.getSensorOrientation().lockCaptureOrientation(deviceOrientation);
    }

    @Override // io.flutter.plugins.camera.CameraCaptureCallback.CameraCaptureStateListener
    public void onConverged() {
        takePictureAfterPrecapture();
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) {
        Log.i(TAG, "onImageAvailable");
        Image imageAcquireNextImage = imageReader.acquireNextImage();
        if (imageAcquireNextImage == null) {
            return;
        }
        this.backgroundHandler.post(new ImageSaver(imageAcquireNextImage, this.captureFile, new ImageSaver.Callback() { // from class: io.flutter.plugins.camera.Camera.4
            @Override // io.flutter.plugins.camera.ImageSaver.Callback
            public void onComplete(@NonNull String str) {
                Camera camera = Camera.this;
                camera.dartMessenger.finish(camera.flutterResult, str);
            }

            @Override // io.flutter.plugins.camera.ImageSaver.Callback
            public void onError(@NonNull String str, @NonNull String str2) {
                Camera camera = Camera.this;
                camera.dartMessenger.error(camera.flutterResult, str, str2, null);
            }
        }));
        this.cameraCaptureCallback.setCameraState(CameraState.STATE_PREVIEW);
    }

    @Override // io.flutter.plugins.camera.CameraCaptureCallback.CameraCaptureStateListener
    public void onPrecapture() {
        runPrecaptureSequence();
    }

    @SuppressLint({"MissingPermission"})
    public void open(Integer num) throws CameraAccessException {
        this.imageFormatGroup = num.intValue();
        ResolutionFeature resolution = this.cameraFeatures.getResolution();
        if (resolution.checkIsSupported()) {
            this.pictureImageReader = ImageReader.newInstance(resolution.getCaptureSize().getWidth(), resolution.getCaptureSize().getHeight(), 256, 1);
            this.imageStreamReader = new ImageStreamReader(resolution.getPreviewSize().getWidth(), resolution.getPreviewSize().getHeight(), this.imageFormatGroup, 1);
            CameraUtils.getCameraManager(this.activity).openCamera(this.cameraProperties.getCameraName(), new AnonymousClass1(resolution), this.backgroundHandler);
        } else {
            this.dartMessenger.sendCameraErrorEvent("Camera with name \"" + this.cameraProperties.getCameraName() + "\" is not supported by this plugin.");
        }
    }

    public void pausePreview() throws CameraAccessException {
        if (this.pausedPreview) {
            return;
        }
        this.pausedPreview = true;
        CameraCaptureSession cameraCaptureSession = this.captureSession;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.stopRepeating();
        }
    }

    public void pauseVideoRecording() {
        if (this.recordingVideo) {
            try {
                if (!SdkCapabilityChecker.supportsVideoPause()) {
                    throw new Messages.FlutterError("videoRecordingFailed", "pauseVideoRecording requires Android API +24.", null);
                }
                this.mediaRecorder.pause();
            } catch (IllegalStateException e) {
                throw new Messages.FlutterError("videoRecordingFailed", e.getMessage(), null);
            }
        }
    }

    @VisibleForTesting
    public void prepareRecording() {
        try {
            File fileCreateTempFile = File.createTempFile("REC", ".mp4", this.applicationContext.getCacheDir());
            this.captureFile = fileCreateTempFile;
            try {
                prepareMediaRecorder(fileCreateTempFile.getAbsolutePath());
                this.cameraFeatures.setAutoFocus(this.cameraFeatureFactory.createAutoFocusFeature(this.cameraProperties, true));
                setFpsCameraFeatureForRecording(this.cameraProperties);
            } catch (IOException e) {
                this.recordingVideo = false;
                this.captureFile = null;
                throw new Messages.FlutterError("videoRecordingFailed", e.getMessage(), null);
            }
        } catch (IOException | SecurityException e6) {
            throw new Messages.FlutterError("cannotCreateFile", e6.getMessage(), null);
        }
    }

    public void refreshPreviewCaptureSession(@Nullable Runnable runnable, @NonNull ErrorCallback errorCallback) {
        Log.i(TAG, "refreshPreviewCaptureSession");
        CameraCaptureSession cameraCaptureSession = this.captureSession;
        if (cameraCaptureSession == null) {
            Log.i(TAG, "refreshPreviewCaptureSession: captureSession not yet initialized, skipping preview capture session refresh.");
            return;
        }
        try {
            if (!this.pausedPreview) {
                cameraCaptureSession.setRepeatingRequest(this.previewRequestBuilder.build(), this.cameraCaptureCallback, this.backgroundHandler);
            }
            if (runnable != null) {
                runnable.run();
            }
        } catch (CameraAccessException e) {
            errorCallback.onError("cameraAccess", e.getMessage());
        } catch (IllegalStateException e6) {
            errorCallback.onError("cameraAccess", "Camera is closed: " + e6.getMessage());
        }
    }

    public void resumePreview() {
        this.pausedPreview = false;
        refreshPreviewCaptureSession(null, new d(this, 0));
    }

    public void resumeVideoRecording() {
        if (this.recordingVideo) {
            try {
                if (!SdkCapabilityChecker.supportsVideoPause()) {
                    throw new Messages.FlutterError("videoRecordingFailed", "resumeVideoRecording requires Android API +24.", null);
                }
                this.mediaRecorder.resume();
            } catch (IllegalStateException e) {
                throw new Messages.FlutterError("videoRecordingFailed", e.getMessage(), null);
            }
        }
    }

    public void setDescriptionWhileRecording(CameraProperties cameraProperties) {
        if (!this.recordingVideo) {
            throw new Messages.FlutterError("setDescriptionWhileRecordingFailed", "Device was not recording", null);
        }
        if (!SdkCapabilityChecker.supportsEglRecordableAndroid()) {
            throw new Messages.FlutterError("setDescriptionWhileRecordingFailed", "Device does not support switching the camera while recording", null);
        }
        stopAndReleaseCamera();
        prepareVideoRenderer();
        this.cameraProperties = cameraProperties;
        CameraFeatures cameraFeaturesInit = CameraFeatures.init(this.cameraFeatureFactory, cameraProperties, this.activity, this.dartMessenger, this.videoCaptureSettings.resolutionPreset);
        this.cameraFeatures = cameraFeaturesInit;
        cameraFeaturesInit.setAutoFocus(this.cameraFeatureFactory.createAutoFocusFeature(this.cameraProperties, true));
        setFpsCameraFeatureForRecording(this.cameraProperties);
        try {
            open(Integer.valueOf(this.imageFormatGroup));
        } catch (CameraAccessException e) {
            throw new Messages.FlutterError("setDescriptionWhileRecordingFailed", e.getMessage(), null);
        }
    }

    public void setExposureMode(@NonNull Messages.VoidResult voidResult, @NonNull ExposureMode exposureMode) {
        ExposureLockFeature exposureLock = this.cameraFeatures.getExposureLock();
        exposureLock.setValue(exposureMode);
        exposureLock.updateBuilder(this.previewRequestBuilder);
        Objects.requireNonNull(voidResult);
        refreshPreviewCaptureSession(new e(voidResult, 1), new a(voidResult, 1));
    }

    public void setExposureOffset(@NonNull Messages.Result<Double> result, double d) {
        ExposureOffsetFeature exposureOffset = this.cameraFeatures.getExposureOffset();
        exposureOffset.setValue(Double.valueOf(d));
        exposureOffset.updateBuilder(this.previewRequestBuilder);
        refreshPreviewCaptureSession(new b(result, exposureOffset, 0), new c(result, 0));
    }

    public void setExposurePoint(@NonNull Messages.VoidResult voidResult, @Nullable Point point) {
        ExposurePointFeature exposurePoint = this.cameraFeatures.getExposurePoint();
        exposurePoint.setValue(point);
        exposurePoint.updateBuilder(this.previewRequestBuilder);
        Objects.requireNonNull(voidResult);
        refreshPreviewCaptureSession(new e(voidResult, 1), new a(voidResult, 3));
    }

    public void setFlashMode(@NonNull Messages.VoidResult voidResult, @NonNull FlashMode flashMode) {
        FlashFeature flash = this.cameraFeatures.getFlash();
        flash.setValue(flashMode);
        flash.updateBuilder(this.previewRequestBuilder);
        Objects.requireNonNull(voidResult);
        refreshPreviewCaptureSession(new e(voidResult, 1), new a(voidResult, 2));
    }

    public void setFocusMode(@NonNull FocusMode focusMode) {
        AutoFocusFeature autoFocus = this.cameraFeatures.getAutoFocus();
        autoFocus.setValue(focusMode);
        autoFocus.updateBuilder(this.previewRequestBuilder);
        if (this.pausedPreview) {
            return;
        }
        int i5 = AnonymousClass7.$SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode[focusMode.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                return;
            }
            unlockAutoFocus();
        } else {
            if (this.captureSession == null) {
                Log.i(TAG, "[unlockAutoFocus] captureSession null, returning");
                return;
            }
            lockAutoFocus();
            this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            try {
                this.captureSession.setRepeatingRequest(this.previewRequestBuilder.build(), null, this.backgroundHandler);
            } catch (CameraAccessException e) {
                throw new Messages.FlutterError("setFocusModeFailed", "Error setting focus mode: " + e.getMessage(), null);
            }
        }
    }

    public void setFocusPoint(@NonNull Messages.VoidResult voidResult, @Nullable Point point) {
        FocusPointFeature focusPoint = this.cameraFeatures.getFocusPoint();
        focusPoint.setValue(point);
        focusPoint.updateBuilder(this.previewRequestBuilder);
        Objects.requireNonNull(voidResult);
        refreshPreviewCaptureSession(new e(voidResult, 1), new a(voidResult, 0));
        setFocusMode(this.cameraFeatures.getAutoFocus().getValue());
    }

    public void setImageStreamImageAvailableListener(EventChannel.EventSink eventSink) {
        ImageStreamReader imageStreamReader = this.imageStreamReader;
        if (imageStreamReader == null) {
            return;
        }
        imageStreamReader.subscribeListener(this.captureProps, eventSink, this.backgroundHandler);
    }

    public void setZoomLevel(@NonNull Messages.VoidResult voidResult, float f6) {
        ZoomLevelFeature zoomLevel = this.cameraFeatures.getZoomLevel();
        float maximumZoomLevel = zoomLevel.getMaximumZoomLevel();
        float minimumZoomLevel = zoomLevel.getMinimumZoomLevel();
        if (f6 > maximumZoomLevel || f6 < minimumZoomLevel) {
            voidResult.error(new Messages.FlutterError("ZOOM_ERROR", String.format(Locale.ENGLISH, "Zoom level out of bounds (zoom level should be between %f and %f).", Float.valueOf(minimumZoomLevel), Float.valueOf(maximumZoomLevel)), null));
            return;
        }
        zoomLevel.setValue(Float.valueOf(f6));
        zoomLevel.updateBuilder(this.previewRequestBuilder);
        Objects.requireNonNull(voidResult);
        refreshPreviewCaptureSession(new e(voidResult, 1), new a(voidResult, 4));
    }

    public void startBackgroundThread() {
        if (this.backgroundHandlerThread != null) {
            return;
        }
        HandlerThread handlerThreadCreate = HandlerThreadFactory.create("CameraBackground");
        this.backgroundHandlerThread = handlerThreadCreate;
        try {
            handlerThreadCreate.start();
        } catch (IllegalThreadStateException unused) {
        }
        this.backgroundHandler = HandlerFactory.create(this.backgroundHandlerThread.getLooper());
    }

    public void startPreview(@Nullable Runnable runnable) {
        if (this.recordingVideo) {
            startPreviewWithVideoRendererStream(runnable);
        } else {
            startRegularPreview(runnable);
        }
    }

    public void startPreviewWithImageStream(EventChannel eventChannel) {
        setStreamHandler(eventChannel);
        startCapture(false, true);
        Log.i(TAG, "startPreviewWithImageStream");
    }

    public void startVideoRecording(@Nullable EventChannel eventChannel) {
        prepareRecording();
        if (eventChannel != null) {
            setStreamHandler(eventChannel);
        }
        this.initialCameraFacing = this.cameraProperties.getLensFacing();
        this.recordingVideo = true;
        try {
            startCapture(true, eventChannel != null);
        } catch (CameraAccessException e) {
            this.recordingVideo = false;
            this.captureFile = null;
            throw new Messages.FlutterError("videoRecordingFailed", e.getMessage(), null);
        }
    }

    public void stopBackgroundThread() {
        HandlerThread handlerThread = this.backgroundHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.backgroundHandlerThread = null;
        this.backgroundHandler = null;
    }

    public String stopVideoRecording() {
        if (!this.recordingVideo) {
            return "";
        }
        this.cameraFeatures.setAutoFocus(this.cameraFeatureFactory.createAutoFocusFeature(this.cameraProperties, false));
        this.cameraFeatures.setFpsRange(this.cameraFeatureFactory.createFpsRangeFeature(this.cameraProperties));
        this.recordingVideo = false;
        try {
            closeRenderer();
            this.captureSession.abortCaptures();
            this.mediaRecorder.stop();
        } catch (CameraAccessException | IllegalStateException unused) {
        }
        this.mediaRecorder.reset();
        try {
            startPreview(null);
            String absolutePath = this.captureFile.getAbsolutePath();
            this.captureFile = null;
            return absolutePath;
        } catch (CameraAccessException | IllegalStateException | InterruptedException e) {
            throw new Messages.FlutterError("videoRecordingFailed", e.getMessage(), null);
        }
    }

    public void takePicture(@NonNull Messages.Result<String> result) {
        if (this.cameraCaptureCallback.getCameraState() != CameraState.STATE_PREVIEW) {
            result.error(new Messages.FlutterError("captureAlreadyActive", "Picture is currently already being captured", null));
            return;
        }
        this.flutterResult = result;
        try {
            this.captureFile = File.createTempFile("CAP", ".jpg", this.applicationContext.getCacheDir());
            this.captureTimeouts.reset();
            this.pictureImageReader.setOnImageAvailableListener(this, this.backgroundHandler);
            AutoFocusFeature autoFocus = this.cameraFeatures.getAutoFocus();
            if (autoFocus.checkIsSupported() && autoFocus.getValue() == FocusMode.auto) {
                runPictureAutoFocus();
            } else {
                runPrecaptureSequence();
            }
        } catch (IOException | SecurityException e) {
            this.dartMessenger.error(this.flutterResult, "cannotCreateFile", e.getMessage(), null);
        }
    }

    public void unlockAutoFocus() {
        Log.i(TAG, "unlockAutoFocus");
        if (this.captureSession == null) {
            Log.i(TAG, "[unlockAutoFocus] captureSession null, returning");
            return;
        }
        try {
            CaptureRequest.Builder builder = this.previewRequestBuilder;
            CaptureRequest.Key key = CaptureRequest.CONTROL_AF_TRIGGER;
            builder.set(key, 2);
            this.captureSession.capture(this.previewRequestBuilder.build(), null, this.backgroundHandler);
            this.previewRequestBuilder.set(key, 0);
            this.captureSession.capture(this.previewRequestBuilder.build(), null, this.backgroundHandler);
            refreshPreviewCaptureSession(null, new d(this, 2));
        } catch (CameraAccessException e) {
            this.dartMessenger.sendCameraErrorEvent(e.getMessage() == null ? "CameraAccessException occurred while unlocking autofocus." : e.getMessage());
        }
    }

    public void unlockCaptureOrientation() {
        this.cameraFeatures.getSensorOrientation().unlockCaptureOrientation();
    }

    public void updateBuilderSettings(CaptureRequest.Builder builder) {
        Iterator<CameraFeature<?>> it = this.cameraFeatures.getAllFeatures().iterator();
        while (it.hasNext()) {
            it.next().updateBuilder(builder);
        }
    }

    private void createCaptureSession(int i5, Runnable runnable, Surface... surfaceArr) {
        this.captureSession = null;
        this.previewRequestBuilder = this.cameraDevice.createCaptureRequest(i5);
        ResolutionFeature resolution = this.cameraFeatures.getResolution();
        SurfaceTexture surfaceTexture = this.flutterTexture.surfaceTexture();
        surfaceTexture.setDefaultBufferSize(resolution.getPreviewSize().getWidth(), resolution.getPreviewSize().getHeight());
        Surface surface = new Surface(surfaceTexture);
        this.previewRequestBuilder.addTarget(surface);
        List<Surface> listAsList = Arrays.asList(surfaceArr);
        if (i5 != 1) {
            Surface surface2 = this.pictureImageReader.getSurface();
            for (Surface surface3 : listAsList) {
                if (surface3 != surface2) {
                    this.previewRequestBuilder.addTarget(surface3);
                }
            }
        }
        Size cameraBoundaries = CameraRegionUtils.getCameraBoundaries(this.cameraProperties, this.previewRequestBuilder);
        this.cameraFeatures.getExposurePoint().setCameraBoundaries(cameraBoundaries);
        this.cameraFeatures.getFocusPoint().setCameraBoundaries(cameraBoundaries);
        CameraCaptureSession.StateCallback anonymousClass2 = new AnonymousClass2(runnable);
        if (!SdkCapabilityChecker.supportsSessionConfiguration()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(surface);
            arrayList.addAll(listAsList);
            createCaptureSession(arrayList, anonymousClass2);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new OutputConfiguration(surface));
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new OutputConfiguration((Surface) it.next()));
        }
        createCaptureSessionWithSessionConfig(arrayList2, anonymousClass2);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class VideoCaptureSettings {

        @Nullable
        public final Integer audioBitrate;
        public final boolean enableAudio;

        @Nullable
        public final Integer fps;

        @NonNull
        public final ResolutionPreset resolutionPreset;

        @Nullable
        public final Integer videoBitrate;

        public VideoCaptureSettings(@NonNull ResolutionPreset resolutionPreset, boolean z6, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
            this.resolutionPreset = resolutionPreset;
            this.enableAudio = z6;
            this.fps = num;
            this.videoBitrate = num2;
            this.audioBitrate = num3;
        }

        public VideoCaptureSettings(@NonNull ResolutionPreset resolutionPreset, boolean z6) {
            this(resolutionPreset, z6, null, null, null);
        }
    }

    private void createCaptureSession(List<Surface> list, CameraCaptureSession.StateCallback stateCallback) {
        this.cameraDevice.createCaptureSession(list, stateCallback, this.backgroundHandler);
    }
}
