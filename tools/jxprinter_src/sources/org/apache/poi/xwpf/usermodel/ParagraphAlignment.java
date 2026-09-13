package org.apache.poi.xwpf.usermodel;

import A3.AbstractC0157z;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum ParagraphAlignment {
    START(1),
    CENTER(2),
    END(3),
    BOTH(4),
    MEDIUM_KASHIDA(5),
    DISTRIBUTE(6),
    NUM_TAB(7),
    HIGH_KASHIDA(8),
    LOW_KASHIDA(9),
    THAI_DISTRIBUTE(10),
    LEFT(11),
    RIGHT(12);

    private static final Map<Integer, ParagraphAlignment> imap = new HashMap();
    private final int value;

    static {
        for (ParagraphAlignment paragraphAlignment : values()) {
            imap.put(Integer.valueOf(paragraphAlignment.getValue()), paragraphAlignment);
        }
    }

    ParagraphAlignment(int i5) {
        this.value = i5;
    }

    public int getValue() {
        return this.value;
    }

    public static ParagraphAlignment valueOf(int i5) {
        ParagraphAlignment paragraphAlignment = imap.get(Integer.valueOf(i5));
        if (paragraphAlignment != null) {
            return paragraphAlignment;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Unknown paragraph alignment: "));
    }
}
