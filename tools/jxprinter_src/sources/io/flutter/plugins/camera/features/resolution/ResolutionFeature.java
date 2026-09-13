package io.flutter.plugins.camera.features.resolution;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.hardware.camera2.CaptureRequest;
import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.platform.f;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.SdkCapabilityChecker;
import io.flutter.plugins.camera.features.CameraFeature;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ResolutionFeature extends CameraFeature<ResolutionPreset> {
    private int cameraId;

    @Nullable
    private Size captureSize;

    @NonNull
    private ResolutionPreset currentSetting;

    @Nullable
    private Size previewSize;
    private EncoderProfiles recordingProfile;
    private CamcorderProfile recordingProfileLegacy;

    /* JADX INFO: renamed from: io.flutter.plugins.camera.features.resolution.ResolutionFeature$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$camera$features$resolution$ResolutionPreset;

        static {
            int[] iArr = new int[ResolutionPreset.values().length];
            $SwitchMap$io$flutter$plugins$camera$features$resolution$ResolutionPreset = iArr;
            try {
                iArr[ResolutionPreset.max.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$resolution$ResolutionPreset[ResolutionPreset.ultraHigh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$resolution$ResolutionPreset[ResolutionPreset.veryHigh.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$resolution$ResolutionPreset[ResolutionPreset.high.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$resolution$ResolutionPreset[ResolutionPreset.medium.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$flutter$plugins$camera$features$resolution$ResolutionPreset[ResolutionPreset.low.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ResolutionFeature(@NonNull CameraProperties cameraProperties, @NonNull ResolutionPreset resolutionPreset, @NonNull String str) {
        super(cameraProperties);
        this.currentSetting = resolutionPreset;
        try {
            int i5 = Integer.parseInt(str, 10);
            this.cameraId = i5;
            configureResolution(resolutionPreset, i5);
        } catch (NumberFormatException unused) {
            this.cameraId = -1;
        }
    }

    @VisibleForTesting
    public static Size computeBestPreviewSize(int i5, ResolutionPreset resolutionPreset) {
        EncoderProfiles.VideoProfile videoProfileF;
        int iOrdinal = resolutionPreset.ordinal();
        ResolutionPreset resolutionPreset2 = ResolutionPreset.high;
        if (iOrdinal > resolutionPreset2.ordinal()) {
            resolutionPreset = resolutionPreset2;
        }
        if (SdkCapabilityChecker.supportsEncoderProfiles() && (videoProfileF = f.f(getBestAvailableCamcorderProfileForResolutionPreset(i5, resolutionPreset).getVideoProfiles().get(0))) != null) {
            return new Size(videoProfileF.getWidth(), videoProfileF.getHeight());
        }
        CamcorderProfile bestAvailableCamcorderProfileForResolutionPresetLegacy = getBestAvailableCamcorderProfileForResolutionPresetLegacy(i5, resolutionPreset);
        return new Size(bestAvailableCamcorderProfileForResolutionPresetLegacy.videoFrameWidth, bestAvailableCamcorderProfileForResolutionPresetLegacy.videoFrameHeight);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0035  */
    private void configureResolution(ResolutionPreset resolutionPreset, int i5) {
        if (checkIsSupported()) {
            if (SdkCapabilityChecker.supportsEncoderProfiles()) {
                this.recordingProfileLegacy = null;
                EncoderProfiles bestAvailableCamcorderProfileForResolutionPreset = getBestAvailableCamcorderProfileForResolutionPreset(i5, resolutionPreset);
                this.recordingProfile = bestAvailableCamcorderProfileForResolutionPreset;
                EncoderProfiles.VideoProfile videoProfileF = f.f(bestAvailableCamcorderProfileForResolutionPreset.getVideoProfiles().get(0));
                if (videoProfileF != null) {
                    this.captureSize = new Size(videoProfileF.getWidth(), videoProfileF.getHeight());
                } else {
                    this.recordingProfile = null;
                    this.recordingProfileLegacy = getBestAvailableCamcorderProfileForResolutionPresetLegacy(i5, resolutionPreset);
                    CamcorderProfile camcorderProfile = this.recordingProfileLegacy;
                    this.captureSize = new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
                }
            } else {
                this.recordingProfile = null;
                this.recordingProfileLegacy = getBestAvailableCamcorderProfileForResolutionPresetLegacy(i5, resolutionPreset);
                CamcorderProfile camcorderProfile2 = this.recordingProfileLegacy;
                this.captureSize = new Size(camcorderProfile2.videoFrameWidth, camcorderProfile2.videoFrameHeight);
            }
            this.previewSize = computeBestPreviewSize(i5, resolutionPreset);
        }
    }

    @NonNull
    @SuppressLint({"UseRequiresApi"})
    @TargetApi(31)
    public static EncoderProfiles getBestAvailableCamcorderProfileForResolutionPreset(int i5, @NonNull ResolutionPreset resolutionPreset) {
        if (i5 < 0) {
            throw new AssertionError("getBestAvailableCamcorderProfileForResolutionPreset can only be used with valid (>=0) camera identifiers.");
        }
        String string = Integer.toString(i5);
        switch (AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$features$resolution$ResolutionPreset[resolutionPreset.ordinal()]) {
            case 1:
                if (CamcorderProfile.hasProfile(i5, 1)) {
                    return CamcorderProfile.getAll(string, 1);
                }
            case 2:
                if (CamcorderProfile.hasProfile(i5, 8)) {
                    return CamcorderProfile.getAll(string, 8);
                }
            case 3:
                if (CamcorderProfile.hasProfile(i5, 6)) {
                    return CamcorderProfile.getAll(string, 6);
                }
            case 4:
                if (CamcorderProfile.hasProfile(i5, 5)) {
                    return CamcorderProfile.getAll(string, 5);
                }
            case 5:
                if (CamcorderProfile.hasProfile(i5, 4)) {
                    return CamcorderProfile.getAll(string, 4);
                }
            case 6:
                if (CamcorderProfile.hasProfile(i5, 7)) {
                    return CamcorderProfile.getAll(string, 7);
                }
            default:
                if (CamcorderProfile.hasProfile(i5, 0)) {
                    return CamcorderProfile.getAll(string, 0);
                }
                throw new IllegalArgumentException("No capture session available for current capture session.");
        }
    }

    @NonNull
    @SuppressLint({"UseRequiresApi"})
    @TargetApi(30)
    public static CamcorderProfile getBestAvailableCamcorderProfileForResolutionPresetLegacy(int i5, @NonNull ResolutionPreset resolutionPreset) {
        if (i5 < 0) {
            throw new AssertionError("getBestAvailableCamcorderProfileForResolutionPreset can only be used with valid (>=0) camera identifiers.");
        }
        switch (AnonymousClass1.$SwitchMap$io$flutter$plugins$camera$features$resolution$ResolutionPreset[resolutionPreset.ordinal()]) {
            case 1:
                if (CamcorderProfile.hasProfile(i5, 1)) {
                    return CamcorderProfile.get(i5, 1);
                }
            case 2:
                if (CamcorderProfile.hasProfile(i5, 8)) {
                    return CamcorderProfile.get(i5, 8);
                }
            case 3:
                if (CamcorderProfile.hasProfile(i5, 6)) {
                    return CamcorderProfile.get(i5, 6);
                }
            case 4:
                if (CamcorderProfile.hasProfile(i5, 5)) {
                    return CamcorderProfile.get(i5, 5);
                }
            case 5:
                if (CamcorderProfile.hasProfile(i5, 4)) {
                    return CamcorderProfile.get(i5, 4);
                }
            case 6:
                if (CamcorderProfile.hasProfile(i5, 7)) {
                    return CamcorderProfile.get(i5, 7);
                }
            default:
                if (CamcorderProfile.hasProfile(i5, 0)) {
                    return CamcorderProfile.get(i5, 0);
                }
                throw new IllegalArgumentException("No capture session available for current capture session.");
        }
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public boolean checkIsSupported() {
        return this.cameraId >= 0;
    }

    @Nullable
    public Size getCaptureSize() {
        return this.captureSize;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    public String getDebugName() {
        return "ResolutionFeature";
    }

    @Nullable
    public Size getPreviewSize() {
        return this.previewSize;
    }

    @Nullable
    public EncoderProfiles getRecordingProfile() {
        return this.recordingProfile;
    }

    @Nullable
    public CamcorderProfile getRecordingProfileLegacy() {
        return this.recordingProfileLegacy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.flutter.plugins.camera.features.CameraFeature
    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public ResolutionPreset getValue() {
        return this.currentSetting;
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void setValue(@NonNull ResolutionPreset resolutionPreset) {
        this.currentSetting = resolutionPreset;
        configureResolution(resolutionPreset, this.cameraId);
    }

    @Override // io.flutter.plugins.camera.features.CameraFeature
    public void updateBuilder(@NonNull CaptureRequest.Builder builder) {
    }
}
