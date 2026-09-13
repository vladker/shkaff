package org.apache.poi.xddf.usermodel;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum LineCap {
    FLAT(STLineCap.FLAT),
    ROUND(STLineCap.RND),
    SQUARE(STLineCap.SQ);

    private static final HashMap<STLineCap.Enum, LineCap> reverse = new HashMap<>();
    final STLineCap.Enum underlying;

    static {
        for (LineCap lineCap : values()) {
            reverse.put(lineCap.underlying, lineCap);
        }
    }

    LineCap(STLineCap.Enum r6) {
        this.underlying = r6;
    }

    public static LineCap valueOf(STLineCap.Enum r6) {
        return reverse.get(r6);
    }
}
