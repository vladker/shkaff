package org.apache.poi.xddf.usermodel.text;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontAlignType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum FontAlignment {
    AUTOMATIC(STTextFontAlignType.AUTO),
    BOTTOM(STTextFontAlignType.f7717B),
    BASELINE(STTextFontAlignType.BASE),
    CENTER(STTextFontAlignType.CTR),
    TOP(STTextFontAlignType.f7718T);

    private static final HashMap<STTextFontAlignType.Enum, FontAlignment> reverse = new HashMap<>();
    final STTextFontAlignType.Enum underlying;

    static {
        for (FontAlignment fontAlignment : values()) {
            reverse.put(fontAlignment.underlying, fontAlignment);
        }
    }

    FontAlignment(STTextFontAlignType.Enum r6) {
        this.underlying = r6;
    }

    public static FontAlignment valueOf(STTextFontAlignType.Enum r6) {
        return reverse.get(r6);
    }
}
