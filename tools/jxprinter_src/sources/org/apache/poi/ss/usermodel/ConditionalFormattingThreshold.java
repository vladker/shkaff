package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ConditionalFormattingThreshold {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum RangeType {
        NUMBER(1, "num"),
        MIN(2, "min"),
        MAX(3, "max"),
        PERCENT(4, "percent"),
        PERCENTILE(5, "percentile"),
        UNALLOCATED(6, null),
        FORMULA(7, "formula");

        public final int id;
        public final String name;

        RangeType(int i5, String str) {
            this.id = i5;
            this.name = str;
        }

        public static RangeType byId(int i5) {
            if (i5 <= 0 || i5 > values().length) {
                return null;
            }
            return values()[i5 - 1];
        }

        public static RangeType byName(String str) {
            for (RangeType rangeType : values()) {
                String str2 = rangeType.name;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return rangeType;
                }
            }
            return null;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.id + " - " + this.name;
        }
    }

    String getFormula();

    RangeType getRangeType();

    Double getValue();

    void setFormula(String str);

    void setRangeType(RangeType rangeType);

    void setValue(Double d);
}
