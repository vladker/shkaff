package org.apache.poi.xddf.usermodel;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STRectAlignment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum RectangleAlignment {
    BOTTOM(STRectAlignment.f7709B),
    BOTTOM_LEFT(STRectAlignment.BL),
    BOTTOM_RIGHT(STRectAlignment.BR),
    CENTER(STRectAlignment.CTR),
    LEFT(STRectAlignment.f7710L),
    RIGHT(STRectAlignment.f7711R),
    TOP(STRectAlignment.f7712T),
    TOP_LEFT(STRectAlignment.TL),
    TOP_RIGHT(STRectAlignment.TR);

    private static final HashMap<STRectAlignment.Enum, RectangleAlignment> reverse = new HashMap<>();
    final STRectAlignment.Enum underlying;

    static {
        for (RectangleAlignment rectangleAlignment : values()) {
            reverse.put(rectangleAlignment.underlying, rectangleAlignment);
        }
    }

    RectangleAlignment(STRectAlignment.Enum r6) {
        this.underlying = r6;
    }

    public static RectangleAlignment valueOf(STRectAlignment.Enum r6) {
        return reverse.get(r6);
    }
}
