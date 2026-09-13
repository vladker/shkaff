package org.apache.poi.ss.usermodel;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum FillPatternType {
    NO_FILL(0),
    SOLID_FOREGROUND(1),
    FINE_DOTS(2),
    ALT_BARS(3),
    SPARSE_DOTS(4),
    THICK_HORZ_BANDS(5),
    THICK_VERT_BANDS(6),
    THICK_BACKWARD_DIAG(7),
    THICK_FORWARD_DIAG(8),
    BIG_SPOTS(9),
    BRICKS(10),
    THIN_HORZ_BANDS(11),
    THIN_VERT_BANDS(12),
    THIN_BACKWARD_DIAG(13),
    THIN_FORWARD_DIAG(14),
    SQUARES(15),
    DIAMONDS(16),
    LESS_DOTS(17),
    LEAST_DOTS(18);

    private static final int length = values().length;
    private final short code;

    FillPatternType(int i5) {
        this.code = (short) i5;
    }

    public static FillPatternType forInt(int i5) {
        if (i5 < 0 || i5 > length) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid FillPatternType code: "));
        }
        return values()[i5];
    }

    public short getCode() {
        return this.code;
    }
}
