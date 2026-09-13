package org.apache.poi.xddf.usermodel.text;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum TextAlignment {
    CENTER(STTextAlignType.CTR),
    DISTRIBUTED(STTextAlignType.DIST),
    JUSTIFIED(STTextAlignType.JUST),
    JUSTIFIED_LOW(STTextAlignType.JUST_LOW),
    LEFT(STTextAlignType.f7713L),
    RIGHT(STTextAlignType.f7714R),
    THAI_DISTRIBUTED(STTextAlignType.THAI_DIST);

    private static final HashMap<STTextAlignType.Enum, TextAlignment> reverse = new HashMap<>();
    final STTextAlignType.Enum underlying;

    static {
        for (TextAlignment textAlignment : values()) {
            reverse.put(textAlignment.underlying, textAlignment);
        }
    }

    TextAlignment(STTextAlignType.Enum r6) {
        this.underlying = r6;
    }

    public static TextAlignment valueOf(STTextAlignType.Enum r6) {
        return reverse.get(r6);
    }
}
