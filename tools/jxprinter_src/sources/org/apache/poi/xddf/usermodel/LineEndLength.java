package org.apache.poi.xddf.usermodel;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum LineEndLength {
    LARGE(STLineEndLength.LG),
    MEDIUM(STLineEndLength.MED),
    SMALL(STLineEndLength.SM);

    private static final HashMap<STLineEndLength.Enum, LineEndLength> reverse = new HashMap<>();
    final STLineEndLength.Enum underlying;

    static {
        for (LineEndLength lineEndLength : values()) {
            reverse.put(lineEndLength.underlying, lineEndLength);
        }
    }

    LineEndLength(STLineEndLength.Enum r6) {
        this.underlying = r6;
    }

    public static LineEndLength valueOf(STLineEndLength.Enum r6) {
        return reverse.get(r6);
    }
}
