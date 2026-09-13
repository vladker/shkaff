package io.flutter.plugins.camera;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugins.camera.features.autofocus.FocusMode;
import io.flutter.plugins.camera.features.exposurelock.ExposureMode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class DartMessenger {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Messages.CameraEventApi eventApi;
    Messages.CameraGlobalEventApi globalEventApi;

    @NonNull
    private final Handler handler;

    public DartMessenger(@NonNull Handler handler, Messages.CameraGlobalEventApi cameraGlobalEventApi, Messages.CameraEventApi cameraEventApi) {
        this.handler = handler;
        this.globalEventApi = cameraGlobalEventApi;
        this.eventApi = cameraEventApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$error$5(Messages.Result result, String str, String str2, Object obj) {
        result.error(new Messages.FlutterError(str, str2, obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendCameraClosingEvent$2() {
        this.eventApi.closed(new NoOpVoidResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendCameraErrorEvent$3(String str) {
        this.eventApi.error(str, new NoOpVoidResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendCameraInitializedEvent$1(Integer num, Integer num2, Boolean bool, Boolean bool2, ExposureMode exposureMode, FocusMode focusMode) {
        this.eventApi.initialized(new Messages.PlatformCameraState.Builder().setPreviewSize(new Messages.PlatformSize.Builder().setWidth(Double.valueOf(num.doubleValue())).setHeight(Double.valueOf(num2.doubleValue())).build()).setExposurePointSupported(bool).setFocusPointSupported(bool2).setExposureMode(CameraUtils.exposureModeToPigeon(exposureMode)).setFocusMode(CameraUtils.focusModeToPigeon(focusMode)).build(), new NoOpVoidResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendDeviceOrientationChangeEvent$0(PlatformChannel.DeviceOrientation deviceOrientation) {
        this.globalEventApi.deviceOrientationChanged(CameraUtils.orientationToPigeon(deviceOrientation), new NoOpVoidResult());
    }

    public <T> void error(@NonNull final Messages.Result<T> result, @NonNull final String str, @Nullable final String str2, @Nullable final Object obj) {
        this.handler.post(new Runnable() { // from class: io.flutter.plugins.camera.i
            @Override // java.lang.Runnable
            public final void run() {
                DartMessenger.lambda$error$5(result, str, str2, obj);
            }
        });
    }

    public <T> void finish(@NonNull Messages.Result<T> result, @NonNull T t6) {
        this.handler.post(new b(result, t6, 3));
    }

    public void sendCameraClosingEvent() {
        this.handler.post(new e(this, 2));
    }

    public void sendCameraErrorEvent(@NonNull String str) {
        this.handler.post(new b(this, str, 4));
    }

    public void sendCameraInitializedEvent(final Integer num, final Integer num2, final ExposureMode exposureMode, final FocusMode focusMode, final Boolean bool, final Boolean bool2) {
        this.handler.post(new Runnable() { // from class: io.flutter.plugins.camera.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f4107a.lambda$sendCameraInitializedEvent$1(num, num2, bool, bool2, exposureMode, focusMode);
            }
        });
    }

    public void sendDeviceOrientationChangeEvent(@NonNull PlatformChannel.DeviceOrientation deviceOrientation) {
        this.handler.post(new b(this, deviceOrientation, 2));
    }
}
