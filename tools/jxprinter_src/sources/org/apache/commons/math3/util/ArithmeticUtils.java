package org.apache.commons.math3.util;

import androidx.core.location.LocationRequestCompat;
import java.math.BigInteger;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ArithmeticUtils {
    private ArithmeticUtils() {
    }

    public static int addAndCheck(int i5, int i6) {
        long j6 = ((long) i5) + ((long) i6);
        if (j6 < -2147483648L || j6 > 2147483647L) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        return (int) j6;
    }

    @Deprecated
    public static long binomialCoefficient(int i5, int i6) {
        return CombinatoricsUtils.binomialCoefficient(i5, i6);
    }

    @Deprecated
    public static double binomialCoefficientDouble(int i5, int i6) {
        return CombinatoricsUtils.binomialCoefficientDouble(i5, i6);
    }

    @Deprecated
    public static double binomialCoefficientLog(int i5, int i6) {
        return CombinatoricsUtils.binomialCoefficientLog(i5, i6);
    }

    @Deprecated
    public static long factorial(int i5) {
        return CombinatoricsUtils.factorial(i5);
    }

    @Deprecated
    public static double factorialDouble(int i5) {
        return CombinatoricsUtils.factorialDouble(i5);
    }

    @Deprecated
    public static double factorialLog(int i5) {
        return CombinatoricsUtils.factorialLog(i5);
    }

    public static int gcd(int i5, int i6) {
        int i7;
        int i8;
        if (i5 == 0 || i6 == 0) {
            if (i5 == Integer.MIN_VALUE || i6 == Integer.MIN_VALUE) {
                throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_32_BITS, Integer.valueOf(i5), Integer.valueOf(i6));
            }
            return FastMath.abs(i5 + i6);
        }
        long j6 = i5;
        long j7 = i6;
        boolean z6 = true;
        boolean z7 = false;
        if (i5 < 0) {
            if (Integer.MIN_VALUE == i5) {
                i7 = i5;
                z7 = true;
            } else {
                i7 = -i5;
            }
            j6 = -j6;
        } else {
            i7 = i5;
        }
        if (i6 < 0) {
            if (Integer.MIN_VALUE == i6) {
                i8 = i6;
            } else {
                i8 = -i6;
                z6 = z7;
            }
            j7 = -j7;
            z7 = z6;
        } else {
            i8 = i6;
        }
        if (z7) {
            if (j6 == j7) {
                throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_32_BITS, Integer.valueOf(i5), Integer.valueOf(i6));
            }
            long j8 = j7 % j6;
            if (j8 == 0) {
                if (j6 <= 2147483647L) {
                    return (int) j6;
                }
                throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_32_BITS, Integer.valueOf(i5), Integer.valueOf(i6));
            }
            i8 = (int) j8;
            i7 = (int) (j6 % j8);
        }
        return gcdPositive(i7, i8);
    }

    private static int gcdPositive(int i5, int i6) {
        if (i5 == 0) {
            return i6;
        }
        if (i6 == 0) {
            return i5;
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i5);
        int iNumberOfTrailingZeros2 = i5 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros3 = Integer.numberOfTrailingZeros(i6);
        int iMin = i6 >> iNumberOfTrailingZeros3;
        int iMin2 = FastMath.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros3);
        while (iNumberOfTrailingZeros2 != iMin) {
            int i7 = iNumberOfTrailingZeros2 - iMin;
            iMin = Math.min(iNumberOfTrailingZeros2, iMin);
            int iAbs = Math.abs(i7);
            iNumberOfTrailingZeros2 = iAbs >> Integer.numberOfTrailingZeros(iAbs);
        }
        return iNumberOfTrailingZeros2 << iMin2;
    }

    public static boolean isPowerOfTwo(long j6) {
        return j6 > 0 && (j6 & (j6 - 1)) == 0;
    }

    public static int lcm(int i5, int i6) {
        if (i5 == 0 || i6 == 0) {
            return 0;
        }
        int iAbs = FastMath.abs(mulAndCheck(i5 / gcd(i5, i6), i6));
        if (iAbs != Integer.MIN_VALUE) {
            return iAbs;
        }
        throw new MathArithmeticException(LocalizedFormats.LCM_OVERFLOW_32_BITS, Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static int mulAndCheck(int i5, int i6) {
        long j6 = ((long) i5) * ((long) i6);
        if (j6 < -2147483648L || j6 > 2147483647L) {
            throw new MathArithmeticException();
        }
        return (int) j6;
    }

    public static int pow(int i5, int i6) {
        if (i6 < 0) {
            throw new NotPositiveException(LocalizedFormats.EXPONENT, Integer.valueOf(i6));
        }
        int iMulAndCheck = 1;
        int iMulAndCheck2 = i5;
        int i7 = i6;
        while (true) {
            if ((i7 & 1) != 0) {
                try {
                    iMulAndCheck = mulAndCheck(iMulAndCheck, iMulAndCheck2);
                } catch (MathArithmeticException e) {
                    e.getContext().addMessage(LocalizedFormats.OVERFLOW, new Object[0]);
                    e.getContext().addMessage(LocalizedFormats.BASE, Integer.valueOf(i5));
                    e.getContext().addMessage(LocalizedFormats.EXPONENT, Integer.valueOf(i6));
                    throw e;
                }
            }
            i7 >>= 1;
            if (i7 == 0) {
                return iMulAndCheck;
            }
            iMulAndCheck2 = mulAndCheck(iMulAndCheck2, iMulAndCheck2);
        }
    }

    @Deprecated
    public static long stirlingS2(int i5, int i6) {
        return CombinatoricsUtils.stirlingS2(i5, i6);
    }

    public static int subAndCheck(int i5, int i6) {
        long j6 = ((long) i5) - ((long) i6);
        if (j6 < -2147483648L || j6 > 2147483647L) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        return (int) j6;
    }

    public static long addAndCheck(long j6, long j7) {
        return addAndCheck(j6, j7, LocalizedFormats.OVERFLOW_IN_ADDITION);
    }

    public static long mulAndCheck(long j6, long j7) {
        if (j6 > j7) {
            return mulAndCheck(j7, j6);
        }
        if (j6 >= 0) {
            if (j6 <= 0) {
                return 0L;
            }
            if (j6 <= LocationRequestCompat.PASSIVE_INTERVAL / j7) {
                return j6 * j7;
            }
            throw new MathArithmeticException();
        }
        if (j7 < 0) {
            if (j6 >= LocationRequestCompat.PASSIVE_INTERVAL / j7) {
                return j6 * j7;
            }
            throw new MathArithmeticException();
        }
        if (j7 <= 0) {
            return 0L;
        }
        if (Long.MIN_VALUE / j7 <= j6) {
            return j6 * j7;
        }
        throw new MathArithmeticException();
    }

    public static long subAndCheck(long j6, long j7) {
        if (j7 != Long.MIN_VALUE) {
            return addAndCheck(j6, -j7, LocalizedFormats.OVERFLOW_IN_ADDITION);
        }
        if (j6 < 0) {
            return j6 - j7;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, Long.valueOf(j6), Long.valueOf(-j7));
    }

    private static long addAndCheck(long j6, long j7, Localizable localizable) {
        long j8 = j6 + j7;
        if (((j6 ^ j7) < 0) || ((j6 ^ j8) >= 0)) {
            return j8;
        }
        throw new MathArithmeticException(localizable, Long.valueOf(j6), Long.valueOf(j7));
    }

    public static long lcm(long j6, long j7) {
        if (j6 == 0 || j7 == 0) {
            return 0L;
        }
        long jAbs = FastMath.abs(mulAndCheck(j6 / gcd(j6, j7), j7));
        if (jAbs != Long.MIN_VALUE) {
            return jAbs;
        }
        throw new MathArithmeticException(LocalizedFormats.LCM_OVERFLOW_64_BITS, Long.valueOf(j6), Long.valueOf(j7));
    }

    public static long gcd(long j6, long j7) {
        long j8;
        long j9;
        long j10 = 0;
        if (j6 == 0 || j7 == 0) {
            if (j6 == Long.MIN_VALUE || j7 == Long.MIN_VALUE) {
                throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_64_BITS, Long.valueOf(j6), Long.valueOf(j7));
            }
            return FastMath.abs(j7) + FastMath.abs(j6);
        }
        long j11 = j6 > 0 ? -j6 : j6;
        long j12 = j7 > 0 ? -j7 : j7;
        int i5 = 0;
        while (true) {
            j8 = j11 & 1;
            j9 = j10;
            if (j8 != j10 || (j12 & 1) != j9 || i5 >= 63) {
                break;
            }
            j11 /= 2;
            j12 /= 2;
            i5++;
            j10 = j9;
        }
        if (i5 != 63) {
            long j13 = j8 == 1 ? j12 : -(j11 / 2);
            while (true) {
                if ((j13 & 1) == j9) {
                    j13 /= 2;
                } else {
                    if (j13 > j9) {
                        j11 = -j13;
                    } else {
                        j12 = j13;
                    }
                    j13 = (j12 - j11) / 2;
                    if (j13 == j9) {
                        return (-j11) * (1 << i5);
                    }
                }
            }
        } else {
            throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_64_BITS, Long.valueOf(j6), Long.valueOf(j7));
        }
    }

    @Deprecated
    public static int pow(int i5, long j6) {
        if (j6 < 0) {
            throw new NotPositiveException(LocalizedFormats.EXPONENT, Long.valueOf(j6));
        }
        int i6 = 1;
        while (j6 != 0) {
            if ((1 & j6) != 0) {
                i6 *= i5;
            }
            i5 *= i5;
            j6 >>= 1;
        }
        return i6;
    }

    public static long pow(long j6, int i5) {
        if (i5 < 0) {
            throw new NotPositiveException(LocalizedFormats.EXPONENT, Integer.valueOf(i5));
        }
        long jMulAndCheck = 1;
        long jMulAndCheck2 = j6;
        int i6 = i5;
        while (true) {
            if ((i6 & 1) != 0) {
                try {
                    jMulAndCheck = mulAndCheck(jMulAndCheck, jMulAndCheck2);
                } catch (MathArithmeticException e) {
                    e.getContext().addMessage(LocalizedFormats.OVERFLOW, new Object[0]);
                    e.getContext().addMessage(LocalizedFormats.BASE, Long.valueOf(j6));
                    e.getContext().addMessage(LocalizedFormats.EXPONENT, Integer.valueOf(i5));
                    throw e;
                }
            }
            i6 >>= 1;
            if (i6 == 0) {
                return jMulAndCheck;
            }
            jMulAndCheck2 = mulAndCheck(jMulAndCheck2, jMulAndCheck2);
        }
    }

    @Deprecated
    public static long pow(long j6, long j7) {
        if (j7 < 0) {
            throw new NotPositiveException(LocalizedFormats.EXPONENT, Long.valueOf(j7));
        }
        long j8 = 1;
        while (j7 != 0) {
            if ((j7 & 1) != 0) {
                j8 *= j6;
            }
            j6 *= j6;
            j7 >>= 1;
        }
        return j8;
    }

    public static BigInteger pow(BigInteger bigInteger, int i5) {
        if (i5 >= 0) {
            return bigInteger.pow(i5);
        }
        throw new NotPositiveException(LocalizedFormats.EXPONENT, Integer.valueOf(i5));
    }

    public static BigInteger pow(BigInteger bigInteger, long j6) {
        if (j6 >= 0) {
            BigInteger bigIntegerMultiply = BigInteger.ONE;
            while (j6 != 0) {
                if ((1 & j6) != 0) {
                    bigIntegerMultiply = bigIntegerMultiply.multiply(bigInteger);
                }
                bigInteger = bigInteger.multiply(bigInteger);
                j6 >>= 1;
            }
            return bigIntegerMultiply;
        }
        throw new NotPositiveException(LocalizedFormats.EXPONENT, Long.valueOf(j6));
    }

    public static BigInteger pow(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger2.compareTo(BigInteger.ZERO) >= 0) {
            BigInteger bigIntegerMultiply = BigInteger.ONE;
            while (!BigInteger.ZERO.equals(bigInteger2)) {
                if (bigInteger2.testBit(0)) {
                    bigIntegerMultiply = bigIntegerMultiply.multiply(bigInteger);
                }
                bigInteger = bigInteger.multiply(bigInteger);
                bigInteger2 = bigInteger2.shiftRight(1);
            }
            return bigIntegerMultiply;
        }
        throw new NotPositiveException(LocalizedFormats.EXPONENT, bigInteger2);
    }
}
