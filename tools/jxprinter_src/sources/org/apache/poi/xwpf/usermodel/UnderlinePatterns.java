package org.apache.poi.xwpf.usermodel;

import A3.AbstractC0157z;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum UnderlinePatterns {
    SINGLE(1),
    WORDS(2),
    DOUBLE(3),
    THICK(4),
    DOTTED(5),
    DOTTED_HEAVY(6),
    DASH(7),
    DASHED_HEAVY(8),
    DASH_LONG(9),
    DASH_LONG_HEAVY(10),
    DOT_DASH(11),
    DASH_DOT_HEAVY(12),
    DOT_DOT_DASH(13),
    DASH_DOT_DOT_HEAVY(14),
    WAVE(15),
    WAVY_HEAVY(16),
    WAVY_DOUBLE(17),
    NONE(18);

    private static Map<Integer, UnderlinePatterns> imap = new HashMap();
    private final int value;

    static {
        for (UnderlinePatterns underlinePatterns : values()) {
            imap.put(Integer.valueOf(underlinePatterns.getValue()), underlinePatterns);
        }
    }

    UnderlinePatterns(int i5) {
        this.value = i5;
    }

    public int getValue() {
        return this.value;
    }

    public static UnderlinePatterns valueOf(int i5) {
        UnderlinePatterns underlinePatterns = imap.get(Integer.valueOf(i5));
        if (underlinePatterns != null) {
            return underlinePatterns;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Unknown underline pattern: "));
    }
}
