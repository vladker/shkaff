package org.apache.poi.xddf.usermodel;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathShadeType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum PathShadeType {
    CIRCLE(STPathShadeType.CIRCLE),
    RECTANGLE(STPathShadeType.RECT),
    SHAPE(STPathShadeType.SHAPE);

    private static final HashMap<STPathShadeType.Enum, PathShadeType> reverse = new HashMap<>();
    final STPathShadeType.Enum underlying;

    static {
        for (PathShadeType pathShadeType : values()) {
            reverse.put(pathShadeType.underlying, pathShadeType);
        }
    }

    PathShadeType(STPathShadeType.Enum r6) {
        this.underlying = r6;
    }

    public static PathShadeType valueOf(STPathShadeType.Enum r6) {
        return reverse.get(r6);
    }
}
