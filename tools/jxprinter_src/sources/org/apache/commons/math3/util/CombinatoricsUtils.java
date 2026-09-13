package org.apache.commons.math3.util;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CombinatoricsUtils {
    static final long[] FACTORIALS = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    static final AtomicReference<long[][]> STIRLING_S2 = new AtomicReference<>(null);

    private CombinatoricsUtils() {
    }

    public static long binomialCoefficient(int i5, int i6) {
        checkBinomial(i5, i6);
        long jMulAndCheck = 1;
        if (i5 == i6 || i6 == 0) {
            return 1L;
        }
        if (i6 == 1 || i6 == i5 - 1) {
            return i5;
        }
        if (i6 > i5 / 2) {
            return binomialCoefficient(i5, i5 - i6);
        }
        if (i5 <= 61) {
            int i7 = (i5 - i6) + 1;
            for (int i8 = 1; i8 <= i6; i8++) {
                jMulAndCheck = (jMulAndCheck * ((long) i7)) / ((long) i8);
                i7++;
            }
            return jMulAndCheck;
        }
        if (i5 <= 66) {
            int i9 = (i5 - i6) + 1;
            for (int i10 = 1; i10 <= i6; i10++) {
                long jGcd = ArithmeticUtils.gcd(i9, i10);
                jMulAndCheck = (jMulAndCheck / (((long) i10) / jGcd)) * (((long) i9) / jGcd);
                i9++;
            }
            return jMulAndCheck;
        }
        int i11 = (i5 - i6) + 1;
        for (int i12 = 1; i12 <= i6; i12++) {
            long jGcd2 = ArithmeticUtils.gcd(i11, i12);
            jMulAndCheck = ArithmeticUtils.mulAndCheck(jMulAndCheck / (((long) i12) / jGcd2), ((long) i11) / jGcd2);
            i11++;
        }
        return jMulAndCheck;
    }

    public static double binomialCoefficientDouble(int i5, int i6) {
        checkBinomial(i5, i6);
        double d = 1.0d;
        if (i5 == i6 || i6 == 0) {
            return 1.0d;
        }
        if (i6 == 1 || i6 == i5 - 1) {
            return i5;
        }
        if (i6 > i5 / 2) {
            return binomialCoefficientDouble(i5, i5 - i6);
        }
        if (i5 < 67) {
            return binomialCoefficient(i5, i6);
        }
        for (int i7 = 1; i7 <= i6; i7++) {
            d *= ((double) ((i5 - i6) + i7)) / ((double) i7);
        }
        return FastMath.floor(d + 0.5d);
    }

    public static double binomialCoefficientLog(int i5, int i6) {
        checkBinomial(i5, i6);
        double dLog = 0.0d;
        if (i5 == i6 || i6 == 0) {
            return 0.0d;
        }
        if (i6 == 1 || i6 == i5 - 1) {
            return FastMath.log(i5);
        }
        if (i5 < 67) {
            return FastMath.log(binomialCoefficient(i5, i6));
        }
        if (i5 < 1030) {
            return FastMath.log(binomialCoefficientDouble(i5, i6));
        }
        if (i6 > i5 / 2) {
            return binomialCoefficientLog(i5, i5 - i6);
        }
        for (int i7 = (i5 - i6) + 1; i7 <= i5; i7++) {
            dLog += FastMath.log(i7);
        }
        for (int i8 = 2; i8 <= i6; i8++) {
            dLog -= FastMath.log(i8);
        }
        return dLog;
    }

    public static void checkBinomial(int i5, int i6) {
        if (i5 < i6) {
            throw new NumberIsTooLargeException(LocalizedFormats.BINOMIAL_INVALID_PARAMETERS_ORDER, Integer.valueOf(i6), Integer.valueOf(i5), true);
        }
        if (i5 < 0) {
            throw new NotPositiveException(LocalizedFormats.BINOMIAL_NEGATIVE_PARAMETER, Integer.valueOf(i5));
        }
    }

    public static Iterator<int[]> combinationsIterator(int i5, int i6) {
        return new Combinations(i5, i6).iterator();
    }

    public static long factorial(int i5) {
        if (i5 < 0) {
            throw new NotPositiveException(LocalizedFormats.FACTORIAL_NEGATIVE_PARAMETER, Integer.valueOf(i5));
        }
        if (i5 <= 20) {
            return FACTORIALS[i5];
        }
        throw new MathArithmeticException();
    }

    public static double factorialDouble(int i5) {
        if (i5 >= 0) {
            return i5 < 21 ? FACTORIALS[i5] : FastMath.floor(FastMath.exp(factorialLog(i5)) + 0.5d);
        }
        throw new NotPositiveException(LocalizedFormats.FACTORIAL_NEGATIVE_PARAMETER, Integer.valueOf(i5));
    }

    public static double factorialLog(int i5) {
        if (i5 < 0) {
            throw new NotPositiveException(LocalizedFormats.FACTORIAL_NEGATIVE_PARAMETER, Integer.valueOf(i5));
        }
        if (i5 < 21) {
            return FastMath.log(FACTORIALS[i5]);
        }
        double dLog = 0.0d;
        for (int i6 = 2; i6 <= i5; i6++) {
            dLog += FastMath.log(i6);
        }
        return dLog;
    }

    public static long stirlingS2(int i5, int i6) {
        int i7;
        long j6;
        if (i6 < 0) {
            throw new NotPositiveException(Integer.valueOf(i6));
        }
        if (i6 > i5) {
            throw new NumberIsTooLargeException(Integer.valueOf(i6), Integer.valueOf(i5), true);
        }
        long[][] jArr = STIRLING_S2.get();
        int i8 = 0;
        long j7 = 0;
        if (jArr == null) {
            long[][] jArr2 = new long[26][];
            jArr2[0] = new long[]{1};
            int i9 = 1;
            while (i9 < 26) {
                int i10 = i9 + 1;
                long[] jArr3 = new long[i10];
                jArr2[i9] = jArr3;
                jArr3[i8] = j7;
                jArr3[1] = 1;
                jArr3[i9] = 1;
                int i11 = 2;
                while (i11 < i9) {
                    long[] jArr4 = jArr2[i9];
                    long[] jArr5 = jArr2[i9 - 1];
                    jArr4[i11] = (((long) i11) * jArr5[i11]) + jArr5[i11 - 1];
                    i11++;
                    i8 = i8;
                    j7 = j7;
                }
                i9 = i10;
            }
            i7 = i8;
            j6 = j7;
            AtomicReference<long[][]> atomicReference = STIRLING_S2;
            while (!atomicReference.compareAndSet(null, jArr2) && atomicReference.get() == null) {
            }
            jArr = jArr2;
        } else {
            i7 = 0;
            j6 = 0;
        }
        if (i5 < jArr.length) {
            return jArr[i5][i6];
        }
        if (i6 == 0) {
            return j6;
        }
        if (i6 == 1 || i6 == i5) {
            return 1L;
        }
        if (i6 == 2) {
            return (1 << (i5 - 1)) - 1;
        }
        if (i6 == i5 - 1) {
            return binomialCoefficient(i5, 2);
        }
        long j8 = (i6 & 1) != 0 ? -1L : 1L;
        long jBinomialCoefficient = j6;
        for (int i12 = 1; i12 <= i6; i12++) {
            j8 = -j8;
            jBinomialCoefficient += binomialCoefficient(i6, i12) * j8 * ((long) ArithmeticUtils.pow(i12, i5));
            if (jBinomialCoefficient < j6) {
                throw new MathArithmeticException(LocalizedFormats.ARGUMENT_OUTSIDE_DOMAIN, Integer.valueOf(i5), Integer.valueOf(i7), Integer.valueOf(jArr.length - 1));
            }
        }
        return jBinomialCoefficient / factorial(i6);
    }
}
