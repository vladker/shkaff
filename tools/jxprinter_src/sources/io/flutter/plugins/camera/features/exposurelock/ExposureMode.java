package io.flutter.plugins.camera.features.exposurelock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public enum ExposureMode {
    auto("auto"),
    locked(CellUtil.LOCKED);

    private final String strValue;

    ExposureMode(String str) {
        this.strValue = str;
    }

    @Nullable
    public static ExposureMode getValueForString(@NonNull String str) {
        for (ExposureMode exposureMode : values()) {
            if (exposureMode.strValue.equals(str)) {
                return exposureMode;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.strValue;
    }
}
