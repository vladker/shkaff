package X3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class U extends T {
    private static final BigDecimal toBigDecimal(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return new BigDecimal(str);
    }

    public static final BigDecimal toBigDecimalOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        try {
            if (L.value.matches(str)) {
                return new BigDecimal(str);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    private static final BigInteger toBigInteger(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return new BigInteger(str);
    }

    public static final BigInteger toBigIntegerOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return toBigIntegerOrNull(str, 10);
    }

    private static final boolean toBoolean(String str) {
        return Boolean.parseBoolean(str);
    }

    private static final byte toByte(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return Byte.parseByte(str);
    }

    private static final double toDouble(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return Double.parseDouble(str);
    }

    public static Double toDoubleOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        try {
            if (L.value.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    private static final float toFloat(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return Float.parseFloat(str);
    }

    public static Float toFloatOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        try {
            if (L.value.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    private static final int toInt(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return Integer.parseInt(str);
    }

    private static final long toLong(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return Long.parseLong(str);
    }

    private static final short toShort(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return Short.parseShort(str);
    }

    private static final String toString(byte b, int i5) {
        String string = Integer.toString(b, AbstractC0239e.checkRadix(i5));
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    private static final BigDecimal toBigDecimal(String str, MathContext mathContext) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    private static final BigInteger toBigInteger(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return new BigInteger(str, AbstractC0239e.checkRadix(i5));
    }

    public static final BigInteger toBigIntegerOrNull(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        AbstractC0239e.checkRadix(i5);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i6 = str.charAt(0) == '-' ? 1 : 0; i6 < length; i6++) {
                if (Character.digit((int) str.charAt(i6), i5) < 0) {
                    return null;
                }
            }
        } else if (Character.digit((int) str.charAt(0), i5) < 0) {
            return null;
        }
        return new BigInteger(str, AbstractC0239e.checkRadix(i5));
    }

    private static final byte toByte(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return Byte.parseByte(str, AbstractC0239e.checkRadix(i5));
    }

    private static final int toInt(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return Integer.parseInt(str, AbstractC0239e.checkRadix(i5));
    }

    private static final long toLong(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return Long.parseLong(str, AbstractC0239e.checkRadix(i5));
    }

    private static final short toShort(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return Short.parseShort(str, AbstractC0239e.checkRadix(i5));
    }

    private static final String toString(short s6, int i5) {
        String string = Integer.toString(s6, AbstractC0239e.checkRadix(i5));
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    private static final String toString(int i5, int i6) {
        String string = Integer.toString(i5, AbstractC0239e.checkRadix(i6));
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public static final BigDecimal toBigDecimalOrNull(String str, MathContext mathContext) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(mathContext, "mathContext");
        try {
            if (L.value.matches(str)) {
                return new BigDecimal(str, mathContext);
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    private static final String toString(long j6, int i5) {
        String string = Long.toString(j6, AbstractC0239e.checkRadix(i5));
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }
}
