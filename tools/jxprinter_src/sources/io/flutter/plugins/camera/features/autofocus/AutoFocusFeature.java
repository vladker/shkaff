package io.flutter.plugins.camera.features.autofocus;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.features.CameraFeature;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class AutoFocusFeature extends CameraFeature<FocusMode> {

    @NonNull
    private FocusMode currentSetting;
    private final boolean recordingVideo;

    /* JADX INFO: renamed from: io.flutter.plugins.camera.features.autofocus.AutoFocusFeature$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
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

    public AutoFocusFeature(@NonNull CameraProperties cameraProperties, boolean z6) {
        super(cameraProperties);
        this.currentSetting = FocusMode.auto;
        this.recordingVideo = z6;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        int[] controlAutoFocusAvailableModes = this.cameraProperties.getControlAutoFocusAvailableModes();
        Float lensInfoMinimumFocusDistance = this.cameraProperties.getLensInfoMinimumFocusDistance();
        return (lensInfoMinimumFocusDistance == null || lensInfoMinimumFocusDistance.floatValue() == 0.0f || controlAutoFocusAvailableModes.length == 0 || (controlAutoFocusAvailableModes.length == 1 && controlAutoFocusAvailableModes[0] == 0)) ? false : true;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    public String getDebugName() {
        return "AutoFocusFeature";
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(@NonNull CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            int i5 = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$features$autofocus$FocusMode[this.currentSetting.ordinal()];
            if (i5 == 1) {
                builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
            } else {
                if (i5 != 2) {
                    return;
                }
                builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.recordingVideo ? 3 : 4));
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public FocusMode getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(@NonNull FocusMode focusMode) {
        this.currentSetting = focusMode;
    }
}
