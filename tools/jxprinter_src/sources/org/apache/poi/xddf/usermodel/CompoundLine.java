package org.apache.poi.xddf.usermodel;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STCompoundLine;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum CompoundLine {
    DOUBLE(STCompoundLine.DBL),
    SINGLE(STCompoundLine.SNG),
    THICK_THIN(STCompoundLine.THICK_THIN),
    THIN_THICK(STCompoundLine.THIN_THICK),
    TRIPLE(STCompoundLine.TRI);

    private static final HashMap<STCompoundLine.Enum, CompoundLine> reverse = new HashMap<>();
    final STCompoundLine.Enum underlying;

    static {
        for (CompoundLine compoundLine : values()) {
            reverse.put(compoundLine.underlying, compoundLine);
        }
    }

    CompoundLine(STCompoundLine.Enum r6) {
        this.underlying = r6;
    }

    public static CompoundLine valueOf(STCompoundLine.Enum r6) {
        return reverse.get(r6);
    }
}
