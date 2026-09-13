package org.apache.poi.xddf.usermodel;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum BlackWhiteMode {
    AUTO(STBlackWhiteMode.AUTO),
    BLACK(STBlackWhiteMode.BLACK),
    BLACK_GRAY(STBlackWhiteMode.BLACK_GRAY),
    BLACK_WHITE(STBlackWhiteMode.BLACK_WHITE);

    private static final HashMap<STBlackWhiteMode.Enum, BlackWhiteMode> reverse = new HashMap<>();
    final STBlackWhiteMode.Enum underlying;

    static {
        for (BlackWhiteMode blackWhiteMode : values()) {
            reverse.put(blackWhiteMode.underlying, blackWhiteMode);
        }
    }

    BlackWhiteMode(STBlackWhiteMode.Enum r6) {
        this.underlying = r6;
    }

    public static BlackWhiteMode valueOf(STBlackWhiteMode.Enum r6) {
        return reverse.get(r6);
    }
}
