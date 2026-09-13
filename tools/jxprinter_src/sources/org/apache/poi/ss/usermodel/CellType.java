package org.apache.poi.ss.usermodel;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum CellType {
    _NONE(-1),
    NUMERIC(0),
    STRING(1),
    FORMULA(2),
    BLANK(3),
    BOOLEAN(4),
    ERROR(5);


    @Deprecated
    private final int code;

    CellType(int i5) {
        this.code = i5;
    }

    @Deprecated
    public static CellType forInt(int i5) {
        for (CellType cellType : values()) {
            if (cellType.code == i5) {
                return cellType;
            }
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid CellType code: "));
    }

    @Deprecated
    public int getCode() {
        return this.code;
    }
}
