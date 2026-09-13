package org.apache.poi.xddf.usermodel.text;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum UnderlineType {
    DASH(STTextUnderlineType.DASH),
    DASH_HEAVY(STTextUnderlineType.DASH_HEAVY),
    DASH_LONG(STTextUnderlineType.DASH_LONG),
    DASH_LONG_HEAVY(STTextUnderlineType.DASH_LONG_HEAVY),
    DOUBLE(STTextUnderlineType.DBL),
    DOT_DASH(STTextUnderlineType.DOT_DASH),
    DOT_DASH_HEAVY(STTextUnderlineType.DOT_DASH_HEAVY),
    DOT_DOT_DASH(STTextUnderlineType.DOT_DOT_DASH),
    DOT_DOT_DASH_HEAVY(STTextUnderlineType.DOT_DOT_DASH_HEAVY),
    DOTTED(STTextUnderlineType.DOTTED),
    DOTTED_HEAVY(STTextUnderlineType.DOTTED_HEAVY),
    HEAVY(STTextUnderlineType.HEAVY),
    NONE(STTextUnderlineType.NONE),
    SINGLE(STTextUnderlineType.SNG),
    WAVY(STTextUnderlineType.WAVY),
    WAVY_DOUBLE(STTextUnderlineType.WAVY_DBL),
    WAVY_HEAVY(STTextUnderlineType.WAVY_HEAVY),
    WORDS(STTextUnderlineType.WORDS);

    private static final HashMap<STTextUnderlineType.Enum, UnderlineType> reverse = new HashMap<>();
    final STTextUnderlineType.Enum underlying;

    static {
        for (UnderlineType underlineType : values()) {
            reverse.put(underlineType.underlying, underlineType);
        }
    }

    UnderlineType(STTextUnderlineType.Enum r6) {
        this.underlying = r6;
    }

    public static UnderlineType valueOf(STTextUnderlineType.Enum r6) {
        return reverse.get(r6);
    }
}
