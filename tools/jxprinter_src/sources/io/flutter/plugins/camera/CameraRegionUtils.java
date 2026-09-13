package io.flutter.plugins.camera;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraRegionUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: io.flutter.plugins.camera.CameraRegionUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;

        static {
            int[] iArr = new int[PlatformChannel.DeviceOrientation.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = iArr;
            try {
                iArr[PlatformChannel.DeviceOrientation.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MeteringRectangleFactory {
        @VisibleForTesting
        public static MeteringRectangle create(int i5, int i6, int i7, int i8, int i9) {
            return new MeteringRectangle(i5, i6, i7, i8, i9);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SizeFactory {
        @VisibleForTesting
        public static Size create(int i5, int i6) {
            return new Size(i5, i6);
        }
    }

    @NonNull
    public static MeteringRectangle convertPointToMeteringRectangle(@NonNull Size size, double d, double d6, @NonNull PlatformChannel.DeviceOrientation deviceOrientation) {
        int i5 = AnonymousClass1.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[deviceOrientation.ordinal()];
        if (i5 == 1) {
            d6 = 1.0d - d;
            d = d6;
        } else if (i5 == 2) {
            double d7 = 1.0d - d6;
            d6 = d;
            d = d7;
        } else if (i5 == 4) {
            d = 1.0d - d;
            d6 = 1.0d - d6;
        }
        int iRound = (int) Math.round(d * ((double) (size.getWidth() - 1)));
        int iRound2 = (int) Math.round(d6 * ((double) (size.getHeight() - 1)));
        int iRound3 = (int) Math.round(((double) size.getWidth()) / 10.0d);
        int iRound4 = (int) Math.round(((double) size.getHeight()) / 10.0d);
        int i6 = iRound - (iRound3 / 2);
        int i7 = iRound2 - (iRound4 / 2);
        if (i6 < 0) {
            i6 = 0;
        }
        if (i7 < 0) {
            i7 = 0;
        }
        int width = (size.getWidth() - 1) - iRound3;
        int height = (size.getHeight() - 1) - iRound4;
        if (i6 > width) {
            i6 = width;
        }
        if (i7 > height) {
            i7 = height;
        }
        return MeteringRectangleFactory.create(i6, i7, iRound3, iRound4, 1);
    }

    @NonNull
    public static Size getCameraBoundaries(@NonNull CameraProperties cameraProperties, @NonNull CaptureRequest.Builder builder) {
        if (!SdkCapabilityChecker.supportsDistortionCorrection() || !supportsDistortionCorrection(cameraProperties)) {
            return cameraProperties.getSensorInfoPixelArraySize();
        }
        Integer num = (Integer) builder.get(CaptureRequest.DISTORTION_CORRECTION_MODE);
        Rect sensorInfoPreCorrectionActiveArraySize = (num == null || num.intValue() == 0) ? cameraProperties.getSensorInfoPreCorrectionActiveArraySize() : cameraProperties.getSensorInfoActiveArraySize();
        return SizeFactory.create(sensorInfoPreCorrectionActiveArraySize.width(), sensorInfoPreCorrectionActiveArraySize.height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$supportsDistortionCorrection$0(int i5) {
        return i5 != 0;
    }

    @SuppressLint({"UseRequiresApi"})
    @TargetApi(28)
    private static boolean supportsDistortionCorrection(CameraProperties cameraProperties) {
        int[] distortionCorrectionAvailableModes = cameraProperties.getDistortionCorrectionAvailableModes();
        if (distortionCorrectionAvailableModes == null) {
            distortionCorrectionAvailableModes = new int[0];
        }
        return Arrays.stream(distortionCorrectionAvailableModes).filter(new g(0)).count() > 0;
    }
}
