package org.apache.poi.xwpf.usermodel;

import A3.AbstractC0157z;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum BreakClear {
    NONE(1),
    LEFT(2),
    RIGHT(3),
    ALL(4);

    private static final Map<Integer, BreakClear> imap = new HashMap();
    private final int value;

    static {
        for (BreakClear breakClear : values()) {
            imap.put(Integer.valueOf(breakClear.getValue()), breakClear);
        }
    }

    BreakClear(int i5) {
        this.value = i5;
    }

    public int getValue() {
        return this.value;
    }

    public static BreakClear valueOf(int i5) {
        BreakClear breakClear = imap.get(Integer.valueOf(i5));
        if (breakClear != null) {
            return breakClear;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Unknown break clear type: "));
    }
}
