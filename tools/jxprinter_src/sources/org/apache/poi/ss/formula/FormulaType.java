package org.apache.poi.ss.formula;

import A3.AbstractC0157z;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public enum FormulaType {
    CELL(true),
    SHARED(true),
    ARRAY(false),
    CONDFORMAT(true),
    NAMEDRANGE(false),
    DATAVALIDATION_LIST(false);

    private final boolean isSingleValue;

    FormulaType(boolean z6) {
        this.isSingleValue = z6;
    }

    public static FormulaType forInt(int i5) {
        if (i5 < 0 || i5 >= values().length) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid FormulaType code: "));
        }
        return values()[i5];
    }

    public boolean isSingleValue() {
        return this.isSingleValue;
    }
}
