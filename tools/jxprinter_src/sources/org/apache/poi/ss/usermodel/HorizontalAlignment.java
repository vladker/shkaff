package org.apache.poi.ss.usermodel;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum HorizontalAlignment {
    GENERAL,
    LEFT,
    CENTER,
    RIGHT,
    FILL,
    JUSTIFY,
    CENTER_SELECTION,
    DISTRIBUTED;

    public static HorizontalAlignment forInt(int i5) {
        if (i5 < 0 || i5 >= values().length) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid HorizontalAlignment code: "));
        }
        return values()[i5];
    }

    public short getCode() {
        return (short) ordinal();
    }
}
