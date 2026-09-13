package io.flutter.plugins.camera.features.flash;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.features.CameraFeature;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FlashFeature extends CameraFeature<FlashMode> {

    @NonNull
    private FlashMode currentSetting;

    /* JADX INFO: renamed from: io.flutter.plugins.camera.features.flash.FlashFeature$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$features$flash$FlashMode;

        static {
            int[] iArr = new int[FlashMode.values().length];
            $SwitchMap$io$flutter$plugins$camera$features$flash$FlashMode = iArr;
            try {
                iArr[FlashMode.off.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$flash$FlashMode[FlashMode.always.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$flash$FlashMode[FlashMode.torch.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$flash$FlashMode[FlashMode.auto.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FlashFeature(@NonNull CameraProperties cameraProperties) {
        super(cameraProperties);
        this.currentSetting = FlashMode.auto;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        Boolean flashInfoAvailable = this.cameraProperties.getFlashInfoAvailable();
        return flashInfoAvailable != null && flashInfoAvailable.booleanValue();
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    public String getDebugName() {
        return "FlashFeature";
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(@NonNull CaptureRequest.Builder builder) {
        if (checkIsSupported()) {
            int i5 = AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$features$flash$FlashMode[this.currentSetting.ordinal()];
            if (i5 == 1) {
                builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                builder.set(CaptureRequest.FLASH_MODE, 0);
                return;
            }
            if (i5 == 2) {
                builder.set(CaptureRequest.CONTROL_AE_MODE, 3);
                builder.set(CaptureRequest.FLASH_MODE, 0);
            } else if (i5 == 3) {
                builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                builder.set(CaptureRequest.FLASH_MODE, 2);
            } else {
                if (i5 != 4) {
                    return;
                }
                builder.set(CaptureRequest.CONTROL_AE_MODE, 2);
                builder.set(CaptureRequest.FLASH_MODE, 0);
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public FlashMode getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(@NonNull FlashMode flashMode) {
        this.currentSetting = flashMode;
    }
}
