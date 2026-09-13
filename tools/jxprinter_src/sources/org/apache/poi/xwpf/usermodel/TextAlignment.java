package org.apache.poi.xwpf.usermodel;

import A3.AbstractC0157z;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum TextAlignment {
    TOP(1),
    CENTER(2),
    BASELINE(3),
    BOTTOM(4),
    AUTO(5);

    private static Map<Integer, TextAlignment> imap = new HashMap();
    private final int value;

    static {
        for (TextAlignment textAlignment : values()) {
            imap.put(Integer.valueOf(textAlignment.getValue()), textAlignment);
        }
    }

    TextAlignment(int i5) {
        this.value = i5;
    }

    public int getValue() {
        return this.value;
    }

    public static TextAlignment valueOf(int i5) {
        TextAlignment textAlignment = imap.get(Integer.valueOf(i5));
        if (textAlignment != null) {
            return textAlignment;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Unknown text alignment: "));
    }
}
