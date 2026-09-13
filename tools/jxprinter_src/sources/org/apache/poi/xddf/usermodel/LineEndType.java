package org.apache.poi.xddf.usermodel;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum LineEndType {
    ARROW(STLineEndType.ARROW),
    DIAMOND(STLineEndType.DIAMOND),
    NONE(STLineEndType.NONE),
    OVAL(STLineEndType.OVAL),
    STEALTH(STLineEndType.STEALTH),
    TRIANGLE(STLineEndType.TRIANGLE);

    private static final HashMap<STLineEndType.Enum, LineEndType> reverse = new HashMap<>();
    final STLineEndType.Enum underlying;

    static {
        for (LineEndType lineEndType : values()) {
            reverse.put(lineEndType.underlying, lineEndType);
        }
    }

    LineEndType(STLineEndType.Enum r6) {
        this.underlying = r6;
    }

    public static LineEndType valueOf(STLineEndType.Enum r6) {
        return reverse.get(r6);
    }
}
