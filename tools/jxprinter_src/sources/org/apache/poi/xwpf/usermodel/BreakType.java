package org.apache.poi.xwpf.usermodel;

import A3.AbstractC0157z;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum BreakType {
    PAGE(1),
    COLUMN(2),
    TEXT_WRAPPING(3);

    private static Map<Integer, BreakType> imap = new HashMap();
    private final int value;

    static {
        for (BreakType breakType : values()) {
            imap.put(Integer.valueOf(breakType.getValue()), breakType);
        }
    }

    BreakType(int i5) {
        this.value = i5;
    }

    public int getValue() {
        return this.value;
    }

    public static BreakType valueOf(int i5) {
        BreakType breakType = imap.get(Integer.valueOf(i5));
        if (breakType != null) {
            return breakType;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Unknown break type: "));
    }
}
