package io.flutter.plugins.camera.features.noisereduction;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public enum NoiseReductionMode {
    off("off"),
    fast("fast"),
    highQuality("highQuality"),
    minimal("minimal"),
    zeroShutterLag("zeroShutterLag");

    private final String strValue;

    NoiseReductionMode(String str) {
        this.strValue = str;
    }

    @Nullable
    public static NoiseReductionMode getValueForString(@NonNull String str) {
        for (NoiseReductionMode noiseReductionMode : values()) {
            if (noiseReductionMode.strValue.equals(str)) {
                return noiseReductionMode;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.strValue;
    }
}
