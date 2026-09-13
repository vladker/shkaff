package org.apache.poi.xwpf.usermodel;

import A3.AbstractC0157z;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum TableRowAlign {
    LEFT(5),
    CENTER(1),
    RIGHT(2);

    private static Map<Integer, TableRowAlign> imap = new HashMap();
    private final int value;

    static {
        for (TableRowAlign tableRowAlign : values()) {
            imap.put(Integer.valueOf(tableRowAlign.getValue()), tableRowAlign);
        }
    }

    TableRowAlign(int i5) {
        this.value = i5;
    }

    public int getValue() {
        return this.value;
    }

    public static TableRowAlign valueOf(int i5) {
        TableRowAlign tableRowAlign = imap.get(Integer.valueOf(i5));
        if (tableRowAlign != null) {
            return tableRowAlign;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Unknown table row alignment: "));
    }
}
