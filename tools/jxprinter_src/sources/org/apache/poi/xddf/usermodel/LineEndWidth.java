package org.apache.poi.xddf.usermodel;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum LineEndWidth {
    LARGE(STLineEndWidth.LG),
    MEDIUM(STLineEndWidth.MED),
    SMALL(STLineEndWidth.SM);

    private static final HashMap<STLineEndWidth.Enum, LineEndWidth> reverse = new HashMap<>();
    final STLineEndWidth.Enum underlying;

    static {
        for (LineEndWidth lineEndWidth : values()) {
            reverse.put(lineEndWidth.underlying, lineEndWidth);
        }
    }

    LineEndWidth(STLineEndWidth.Enum r6) {
        this.underlying = r6;
    }

    public static LineEndWidth valueOf(STLineEndWidth.Enum r6) {
        return reverse.get(r6);
    }
}
