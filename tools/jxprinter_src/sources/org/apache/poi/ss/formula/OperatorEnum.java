package org.apache.poi.ss.formula;

import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
enum OperatorEnum {
    NO_COMPARISON(new c(0), false),
    BETWEEN(new c(1), false),
    NOT_BETWEEN(new c(2), true),
    EQUAL(new c(3), false),
    NOT_EQUAL(new c(4), true),
    GREATER_THAN(new c(5), false),
    LESS_THAN(new c(6), false),
    GREATER_OR_EQUAL(new c(7), false),
    LESS_OR_EQUAL(new c(8), false);

    private final CompareOp compareOp;
    private final boolean validForIncompatibleTypes;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface CompareOp {
        <C extends Comparable<C>> boolean isValid(C c, C c6, C c7);
    }

    OperatorEnum(CompareOp compareOp, boolean z6) {
        this.compareOp = compareOp;
        this.validForIncompatibleTypes = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <C extends Comparable<C>> boolean between(C c, C c6, C c7) {
        if (c6 != null) {
            return c.compareTo(c6) >= 0 && c.compareTo(c7) <= 0;
        }
        if (c instanceof Number) {
            Number number = (Number) c;
            return Double.compare(number.doubleValue(), 0.0d) >= 0 && Double.compare(number.doubleValue(), c7 == 0 ? 0.0d : ((Number) c7).doubleValue()) <= 0;
        }
        if (c instanceof String) {
            String str = c7 == 0 ? "" : (String) c7;
            String str2 = (String) c;
            if (str2.compareToIgnoreCase("") >= 0 && str2.compareToIgnoreCase(str) <= 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <C extends Comparable<C>> boolean equalCheck(C c, C c6, C c7) {
        if (c6 == null) {
            return (c instanceof Number) && Double.compare(((Number) c).doubleValue(), 0.0d) == 0;
        }
        if (c instanceof String) {
            return c.toString().compareToIgnoreCase(c6.toString()) == 0;
        }
        return c.compareTo(c6) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <C extends Comparable<C>> boolean greaterOrEqual(C c, C c6, C c7) {
        if (c6 != null) {
            return c.compareTo(c6) >= 0;
        }
        if (c instanceof Number) {
            return Double.compare(((Number) c).doubleValue(), 0.0d) >= 0;
        }
        if (c instanceof String) {
            return true;
        }
        return c instanceof Boolean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <C extends Comparable<C>> boolean greaterThan(C c, C c6, C c7) {
        if (c6 != null) {
            return c.compareTo(c6) > 0;
        }
        if (c instanceof Number) {
            return Double.compare(((Number) c).doubleValue(), 0.0d) > 0;
        }
        if (c instanceof String) {
            return true;
        }
        return c instanceof Boolean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <C extends Comparable<C>> boolean lessOrEqual(C c, C c6, C c7) {
        if (c6 == null) {
            return (c instanceof Number) && Double.compare(((Number) c).doubleValue(), 0.0d) <= 0;
        }
        return c.compareTo(c6) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <C extends Comparable<C>> boolean lessThan(C c, C c6, C c7) {
        if (c6 == null) {
            return (c instanceof Number) && Double.compare(((Number) c).doubleValue(), 0.0d) < 0;
        }
        return c.compareTo(c6) < 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <C extends Comparable<C>> boolean noComp(C c, C c6, C c7) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <C extends Comparable<C>> boolean notBetween(C c, C c6, C c7) {
        if (c6 != null) {
            return c.compareTo(c6) < 0 || c.compareTo(c7) > 0;
        }
        if (c instanceof Number) {
            Number number = (Number) c;
            return Double.compare(number.doubleValue(), 0.0d) < 0 || Double.compare(number.doubleValue(), c7 == 0 ? 0.0d : ((Number) c7).doubleValue()) > 0;
        }
        if (!(c instanceof String)) {
            return c instanceof Boolean;
        }
        String str = (String) c;
        return str.compareToIgnoreCase("") < 0 || str.compareToIgnoreCase(c7 == 0 ? "" : (String) c7) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <C extends Comparable<C>> boolean notEqual(C c, C c6, C c7) {
        if (c6 == null) {
            return true;
        }
        if (c instanceof String) {
            return c.toString().compareToIgnoreCase(c6.toString()) == 0;
        }
        return c.compareTo(c6) != 0;
    }

    public <C extends Comparable<C>> boolean isValid(C c, C c6, C c7) {
        return this.compareOp.isValid(c, c6, c7);
    }

    public boolean isValidForIncompatibleTypes() {
        return this.validForIncompatibleTypes;
    }
}
