package io.flutter.plugins.camera.features.autofocus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public enum FocusMode {
    auto("auto"),
    locked(CellUtil.LOCKED);

    private final String strValue;

    FocusMode(String str) {
        this.strValue = str;
    }

    @Nullable
    public static FocusMode getValueForString(@NonNull String str) {
        for (FocusMode focusMode : values()) {
            if (focusMode.strValue.equals(str)) {
                return focusMode;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.strValue;
    }
}
