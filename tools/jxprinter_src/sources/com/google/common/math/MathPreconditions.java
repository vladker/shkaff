package com.google.common.math;

import androidx.exifinterface.media.a;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@CanIgnoreReturnValue
@GwtCompatible
final class MathPreconditions {
    private MathPreconditions() {
    }

    public static void checkInRangeForRoundingInputs(boolean z6, double d, RoundingMode roundingMode) {
        if (z6) {
            return;
        }
        String strValueOf = String.valueOf(roundingMode);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 83);
        sb.append("rounded value is out of range for input ");
        sb.append(d);
        sb.append(" and rounding mode ");
        sb.append(strValueOf);
        throw new ArithmeticException(sb.toString());
    }

    public static void checkNoOverflow(boolean z6, String str, int i5, int i6) {
        if (z6) {
            return;
        }
        StringBuilder sb = new StringBuilder(a.b(36, str));
        sb.append("overflow: ");
        sb.append(str);
        sb.append("(");
        sb.append(i5);
        sb.append(", ");
        sb.append(i6);
        sb.append(")");
        throw new ArithmeticException(sb.toString());
    }

    public static int checkNonNegative(String str, int i5) {
        if (i5 >= 0) {
            return i5;
        }
        StringBuilder sb = new StringBuilder(a.b(27, str));
        sb.append(str);
        sb.append(" (");
        sb.append(i5);
        sb.append(") must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }

    public static int checkPositive(String str, int i5) {
        if (i5 > 0) {
            return i5;
        }
        StringBuilder sb = new StringBuilder(a.b(26, str));
        sb.append(str);
        sb.append(" (");
        sb.append(i5);
        sb.append(") must be > 0");
        throw new IllegalArgumentException(sb.toString());
    }

    public static void checkRoundingUnnecessary(boolean z6) {
        if (!z6) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    public static void checkNoOverflow(boolean z6, String str, long j6, long j7) {
        if (z6) {
            return;
        }
        StringBuilder sb = new StringBuilder(a.b(54, str));
        sb.append("overflow: ");
        sb.append(str);
        sb.append("(");
        sb.append(j6);
        sb.append(", ");
        sb.append(j7);
        sb.append(")");
        throw new ArithmeticException(sb.toString());
    }

    public static long checkNonNegative(String str, long j6) {
        if (j6 >= 0) {
            return j6;
        }
        StringBuilder sb = new StringBuilder(a.b(36, str));
        sb.append(str);
        sb.append(" (");
        sb.append(j6);
        sb.append(") must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }

    public static long checkPositive(String str, long j6) {
        if (j6 > 0) {
            return j6;
        }
        StringBuilder sb = new StringBuilder(a.b(35, str));
        sb.append(str);
        sb.append(" (");
        sb.append(j6);
        sb.append(") must be > 0");
        throw new IllegalArgumentException(sb.toString());
    }

    public static BigInteger checkNonNegative(String str, BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            return bigInteger;
        }
        String strValueOf = String.valueOf(bigInteger);
        throw new IllegalArgumentException(com.google.android.gms.auth.api.accounttransfer.a.j(strValueOf.length() + a.b(16, str), str, " (", strValueOf, ") must be >= 0"));
    }

    public static BigInteger checkPositive(String str, BigInteger bigInteger) {
        if (bigInteger.signum() > 0) {
            return bigInteger;
        }
        String strValueOf = String.valueOf(bigInteger);
        throw new IllegalArgumentException(com.google.android.gms.auth.api.accounttransfer.a.j(strValueOf.length() + a.b(15, str), str, " (", strValueOf, ") must be > 0"));
    }

    public static double checkNonNegative(String str, double d) {
        if (d >= 0.0d) {
            return d;
        }
        StringBuilder sb = new StringBuilder(a.b(40, str));
        sb.append(str);
        sb.append(" (");
        sb.append(d);
        sb.append(") must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }
}
