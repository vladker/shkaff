package X3;

/* JADX INFO: renamed from: X3.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0240f extends AbstractC0239e {
    public static final boolean b(char c, char c6, boolean z6) {
        if (c == c6) {
            return true;
        }
        if (!z6) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c6);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static final char digitToChar(int i5) {
        if (i5 < 0 || i5 >= 10) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Int ", " is not a decimal digit"));
        }
        return (char) (i5 + 48);
    }

    public static final int digitToInt(char c, int i5) {
        Integer numDigitToIntOrNull = digitToIntOrNull(c, i5);
        if (numDigitToIntOrNull != null) {
            return numDigitToIntOrNull.intValue();
        }
        throw new IllegalArgumentException("Char " + c + " is not a digit in the given radix=" + i5);
    }

    public static Integer digitToIntOrNull(char c, int i5) {
        AbstractC0239e.checkRadix(i5);
        Integer numValueOf = Integer.valueOf(Character.digit((int) c, i5));
        if (numValueOf.intValue() >= 0) {
            return numValueOf;
        }
        return null;
    }

    private static final String plus(char c, String other) {
        kotlin.jvm.internal.E.f(other, "other");
        return c + other;
    }

    public static final String titlecase(char c) {
        return h0.titlecaseImpl(c);
    }

    public static final int digitToInt(char c) {
        int iDigit = Character.digit((int) c, 10);
        if (iDigit >= 0) {
            return iDigit;
        }
        throw new IllegalArgumentException("Char " + c + " is not a decimal digit");
    }

    public static final Integer digitToIntOrNull(char c) {
        Integer numValueOf = Integer.valueOf(Character.digit((int) c, 10));
        if (numValueOf.intValue() >= 0) {
            return numValueOf;
        }
        return null;
    }

    public static final char digitToChar(int i5, int i6) {
        if (2 > i6 || i6 >= 37) {
            throw new IllegalArgumentException(androidx.collection.a.i(i6, "Invalid radix: ", ". Valid radix values are in range 2..36"));
        }
        if (i5 < 0 || i5 >= i6) {
            throw new IllegalArgumentException(androidx.collection.a.h(i5, i6, "Digit ", " does not represent a valid digit in radix "));
        }
        return (char) (i5 < 10 ? i5 + 48 : ((char) (i5 + 65)) - '\n');
    }
}
