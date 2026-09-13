package org.apache.poi.ss.format;

import A3.AbstractC0157z;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CellFormatCondition {
    private static final int EQ = 4;
    private static final int GE = 3;
    private static final int GT = 2;
    private static final int LE = 1;
    private static final int LT = 0;
    private static final int NE = 5;
    private static final Map<String, Integer> TESTS;

    static {
        HashMap map = new HashMap();
        TESTS = map;
        map.put("<", 0);
        map.put("<=", 1);
        map.put(">", 2);
        map.put(">=", 3);
        map.put("=", 4);
        map.put("==", 4);
        map.put("!=", 5);
        map.put("<>", 5);
    }

    public static CellFormatCondition getInstance(String str, String str2) {
        Map<String, Integer> map = TESTS;
        if (!map.containsKey(str)) {
            throw new IllegalArgumentException(AbstractC0157z.n("Unknown test: ", str));
        }
        int iIntValue = map.get(str).intValue();
        final double d = Double.parseDouble(str2);
        if (iIntValue == 0) {
            return new CellFormatCondition() { // from class: org.apache.poi.ss.format.CellFormatCondition.1
                @Override // org.apache.poi.ss.format.CellFormatCondition
                public boolean pass(double d6) {
                    return d6 < d;
                }
            };
        }
        if (iIntValue == 1) {
            return new CellFormatCondition() { // from class: org.apache.poi.ss.format.CellFormatCondition.2
                @Override // org.apache.poi.ss.format.CellFormatCondition
                public boolean pass(double d6) {
                    return d6 <= d;
                }
            };
        }
        if (iIntValue == 2) {
            return new CellFormatCondition() { // from class: org.apache.poi.ss.format.CellFormatCondition.3
                @Override // org.apache.poi.ss.format.CellFormatCondition
                public boolean pass(double d6) {
                    return d6 > d;
                }
            };
        }
        if (iIntValue == 3) {
            return new CellFormatCondition() { // from class: org.apache.poi.ss.format.CellFormatCondition.4
                @Override // org.apache.poi.ss.format.CellFormatCondition
                public boolean pass(double d6) {
                    return d6 >= d;
                }
            };
        }
        if (iIntValue == 4) {
            return new CellFormatCondition() { // from class: org.apache.poi.ss.format.CellFormatCondition.5
                @Override // org.apache.poi.ss.format.CellFormatCondition
                public boolean pass(double d6) {
                    return d6 == d;
                }
            };
        }
        if (iIntValue == 5) {
            return new CellFormatCondition() { // from class: org.apache.poi.ss.format.CellFormatCondition.6
                @Override // org.apache.poi.ss.format.CellFormatCondition
                public boolean pass(double d6) {
                    return d6 != d;
                }
            };
        }
        throw new IllegalArgumentException("Cannot create for test number " + iIntValue + "(\"" + str + "\")");
    }

    public abstract boolean pass(double d);
}
