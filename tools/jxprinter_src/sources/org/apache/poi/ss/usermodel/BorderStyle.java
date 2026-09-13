package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum BorderStyle {
    NONE(0),
    THIN(1),
    MEDIUM(2),
    DASHED(3),
    DOTTED(4),
    THICK(5),
    DOUBLE(6),
    HAIR(7),
    MEDIUM_DASHED(8),
    DASH_DOT(9),
    MEDIUM_DASH_DOT(10),
    DASH_DOT_DOT(11),
    MEDIUM_DASH_DOT_DOT(12),
    SLANTED_DASH_DOT(13);

    private static final BorderStyle[] _table = new BorderStyle[14];
    private final short code;

    static {
        for (BorderStyle borderStyle : values()) {
            _table[borderStyle.getCode()] = borderStyle;
        }
    }

    BorderStyle(int i5) {
        this.code = (short) i5;
    }

    public short getCode() {
        return this.code;
    }

    public static BorderStyle valueOf(short s6) {
        return _table[s6];
    }
}
