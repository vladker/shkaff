package org.apache.poi.xwpf.usermodel;

import A3.AbstractC0157z;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum LineSpacingRule {
    AUTO(1),
    EXACT(2),
    AT_LEAST(3);

    private static Map<Integer, LineSpacingRule> imap = new HashMap();
    private final int value;

    static {
        for (LineSpacingRule lineSpacingRule : values()) {
            imap.put(Integer.valueOf(lineSpacingRule.getValue()), lineSpacingRule);
        }
    }

    LineSpacingRule(int i5) {
        this.value = i5;
    }

    public int getValue() {
        return this.value;
    }

    public static LineSpacingRule valueOf(int i5) {
        LineSpacingRule lineSpacingRule = imap.get(Integer.valueOf(i5));
        if (lineSpacingRule != null) {
            return lineSpacingRule;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Unknown line type: "));
    }
}
