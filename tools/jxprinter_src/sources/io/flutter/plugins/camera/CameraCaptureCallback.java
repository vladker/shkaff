package io.flutter.plugins.camera;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugins.camera.types.CameraCaptureProperties;
import io.flutter.plugins.camera.types.CaptureTimeoutsWrapper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class CameraCaptureCallback extends CameraCaptureSession.CaptureCallback {
    private static final String TAG = "CameraCaptureCallback";

    @NonNull
    @VisibleForTesting
    CaptureResult.Key<Integer> aeStateKey = CaptureResult.CONTROL_AE_STATE;

    @NonNull
    @VisibleForTesting
    CaptureResult.Key<Integer> afStateKey = CaptureResult.CONTROL_AF_STATE;
    private CameraState cameraState = CameraState.STATE_PREVIEW;
    private final CameraCaptureStateListener cameraStateListener;
    private final CameraCaptureProperties captureProps;
    private final CaptureTimeoutsWrapper captureTimeouts;

    /* JADX INFO: renamed from: io.flutter.plugins.camera.CameraCaptureCallback$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$CameraState;

        static {
            int[] iArr = new int[CameraState.values().length];
            $SwitchMap$io$flutter$plugins$camera$CameraState = iArr;
            try {
                iArr[CameraState.STATE_PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$CameraState[CameraState.STATE_WAITING_FOCUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$CameraState[CameraState.STATE_WAITING_PRECAPTURE_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$CameraState[CameraState.STATE_WAITING_PRECAPTURE_DONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface CameraCaptureStateListener {
        void onConverged();

        void onPrecapture();
    }

    private CameraCaptureCallback(@NonNull CameraCaptureStateListener cameraCaptureStateListener, @NonNull CaptureTimeoutsWrapper captureTimeoutsWrapper, @NonNull CameraCaptureProperties cameraCaptureProperties) {
        this.cameraStateListener = cameraCaptureStateListener;
        this.captureTimeouts = captureTimeoutsWrapper;
        this.captureProps = cameraCaptureProperties;
    }

    public static CameraCaptureCallback create(@NonNull CameraCaptureStateListener cameraCaptureStateListener, @NonNull CaptureTimeoutsWrapper captureTimeoutsWrapper, @NonNull CameraCaptureProperties cameraCaptureProperties) {
        return new CameraCaptureCallback(cameraCaptureStateListener, captureTimeoutsWrapper, cameraCaptureProperties);
    }

    private void handleWaitingFocusState(Integer num) {
        if (num == null || num.intValue() == 2) {
            this.cameraStateListener.onConverged();
        } else {
            this.cameraStateListener.onPrecapture();
        }
    }

    private void process(CaptureResult captureResult) {
        Integer num = (Integer) captureResult.get(this.aeStateKey);
        Integer num2 = (Integer) captureResult.get(this.afStateKey);
        if (captureResult instanceof TotalCaptureResult) {
            Float f6 = (Float) captureResult.get(CaptureResult.LENS_APERTURE);
            Long l6 = (Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
            Integer num3 = (Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
            this.captureProps.setLastLensAperture(f6);
            this.captureProps.setLastSensorExposureTime(l6);
            this.captureProps.setLastSensorSensitivity(num3);
        }
        if (this.cameraState != CameraState.STATE_PREVIEW) {
            Log.d(TAG, "CameraCaptureCallback | state: " + this.cameraState + " | afState: " + num2 + " | aeState: " + num);
        }
        int i5 = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$CameraState[this.cameraState.ordinal()];
        if (i5 == 2) {
            if (num2 == null) {
                return;
            }
            if (num2.intValue() == 4 || num2.intValue() == 5) {
                handleWaitingFocusState(num);
                return;
            } else {
                if (this.captureTimeouts.getPreCaptureFocusing().getIsExpired()) {
                    Log.w(TAG, "Focus timeout, moving on with capture");
                    handleWaitingFocusState(num);
                    return;
                }
                return;
            }
        }
        if (i5 != 3) {
            if (i5 != 4) {
                return;
            }
            if (num == null || num.intValue() != 5) {
                this.cameraStateListener.onConverged();
                return;
            } else {
                if (this.captureTimeouts.getPreCaptureMetering().getIsExpired()) {
                    Log.w(TAG, "Metering timeout waiting for pre-capture to finish, moving on with capture");
                    this.cameraStateListener.onConverged();
                    return;
                }
                return;
            }
        }
        if (num == null || num.intValue() == 2 || num.intValue() == 5 || num.intValue() == 4) {
            setCameraState(CameraState.STATE_WAITING_PRECAPTURE_DONE);
        } else if (this.captureTimeouts.getPreCaptureMetering().getIsExpired()) {
            Log.w(TAG, "Metering timeout waiting for pre-capture to start, moving on with capture");
            setCameraState(CameraState.STATE_WAITING_PRECAPTURE_DONE);
        }
    }

    public CameraState getCameraState() {
        return this.cameraState;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        process(totalCaptureResult);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        process(captureResult);
    }

    public void setCameraState(@NonNull CameraState cameraState) {
        this.cameraState = cameraState;
    }
}
