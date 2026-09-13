package io.flutter.plugins.camera.types;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public enum FlashMode {
    off("off"),
    auto("auto"),
    always("always"),
    torch("torch");

    private final String strValue;

    FlashMode(String str) {
        this.strValue = str;
    }

    @Nullable
    public static FlashMode getValueForString(@NonNull String str) {
        for (FlashMode flashMode : values()) {
            if (flashMode.strValue.equals(str)) {
                return flashMode;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.strValue;
    }
}
