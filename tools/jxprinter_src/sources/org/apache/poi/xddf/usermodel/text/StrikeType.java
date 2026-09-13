package org.apache.poi.xddf.usermodel.text;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum StrikeType {
    DOUBLE_STRIKE(STTextStrikeType.DBL_STRIKE),
    NO_STRIKE(STTextStrikeType.NO_STRIKE),
    SINGLE_STRIKE(STTextStrikeType.SNG_STRIKE);

    private static final HashMap<STTextStrikeType.Enum, StrikeType> reverse = new HashMap<>();
    final STTextStrikeType.Enum underlying;

    static {
        for (StrikeType strikeType : values()) {
            reverse.put(strikeType.underlying, strikeType);
        }
    }

    StrikeType(STTextStrikeType.Enum r6) {
        this.underlying = r6;
    }

    public static StrikeType valueOf(STTextStrikeType.Enum r6) {
        return reverse.get(r6);
    }
}
