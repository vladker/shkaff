package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.xmlbeans.SchemaType;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class IntMath {

    @VisibleForTesting
    static final int FLOOR_SQRT_MAX_INT = 46340;

    @VisibleForTesting
    static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;

    @VisibleForTesting
    static final int MAX_SIGNED_POWER_OF_TWO = 1073741824;

    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    @VisibleForTesting
    static final int[] powersOf10 = {1, 10, 100, 1000, 10000, BZip2Constants.BASEBLOCKSIZE, SchemaType.SIZE_BIG_INTEGER, PoissonDistribution.DEFAULT_MAX_ITERATIONS, 100000000, 1000000000};

    @VisibleForTesting
    static final int[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    private static final int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    @VisibleForTesting
    static int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, Videoio.CAP_PROP_XI_GAMMAC, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* JADX INFO: renamed from: com.google.common.math.IntMath$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private IntMath() {
    }

    public static int binomial(int i5, int i6) {
        MathPreconditions.checkNonNegative("n", i5);
        MathPreconditions.checkNonNegative("k", i6);
        int i7 = 0;
        Preconditions.checkArgument(i6 <= i5, "k (%s) > n (%s)", i6, i5);
        if (i6 > (i5 >> 1)) {
            i6 = i5 - i6;
        }
        int[] iArr = biggestBinomials;
        if (i6 >= iArr.length || i5 > iArr[i6]) {
            return Integer.MAX_VALUE;
        }
        if (i6 == 0) {
            return 1;
        }
        if (i6 == 1) {
            return i5;
        }
        long j6 = 1;
        while (i7 < i6) {
            long j7 = j6 * ((long) (i5 - i7));
            i7++;
            j6 = j7 / ((long) i7);
        }
        return (int) j6;
    }

    @Beta
    public static int ceilingPowerOfTwo(int i5) {
        MathPreconditions.checkPositive("x", i5);
        if (i5 <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i5 - 1));
        }
        StringBuilder sb = new StringBuilder(58);
        sb.append("ceilingPowerOfTwo(");
        sb.append(i5);
        sb.append(") not representable as an int");
        throw new ArithmeticException(sb.toString());
    }

    public static int checkedAdd(int i5, int i6) {
        long j6 = ((long) i5) + ((long) i6);
        int i7 = (int) j6;
        MathPreconditions.checkNoOverflow(j6 == ((long) i7), "checkedAdd", i5, i6);
        return i7;
    }

    public static int checkedMultiply(int i5, int i6) {
        long j6 = ((long) i5) * ((long) i6);
        int i7 = (int) j6;
        MathPreconditions.checkNoOverflow(j6 == ((long) i7), "checkedMultiply", i5, i6);
        return i7;
    }

    public static int checkedPow(int i5, int i6) {
        MathPreconditions.checkNonNegative("exponent", i6);
        if (i5 == -2) {
            MathPreconditions.checkNoOverflow(i6 < 32, "checkedPow", i5, i6);
            return (i6 & 1) == 0 ? 1 << i6 : (-1) << i6;
        }
        if (i5 == -1) {
            return (i6 & 1) == 0 ? 1 : -1;
        }
        if (i5 == 0) {
            return i6 == 0 ? 1 : 0;
        }
        if (i5 == 1) {
            return 1;
        }
        if (i5 == 2) {
            MathPreconditions.checkNoOverflow(i6 < 31, "checkedPow", i5, i6);
            return 1 << i6;
        }
        int iCheckedMultiply = 1;
        while (i6 != 0) {
            if (i6 == 1) {
                return checkedMultiply(iCheckedMultiply, i5);
            }
            if ((i6 & 1) != 0) {
                iCheckedMultiply = checkedMultiply(iCheckedMultiply, i5);
            }
            i6 >>= 1;
            if (i6 > 0) {
                MathPreconditions.checkNoOverflow((-46340 <= i5) & (i5 <= FLOOR_SQRT_MAX_INT), "checkedPow", i5, i6);
                i5 *= i5;
            }
        }
        return iCheckedMultiply;
    }

    public static int checkedSubtract(int i5, int i6) {
        long j6 = ((long) i5) - ((long) i6);
        int i7 = (int) j6;
        MathPreconditions.checkNoOverflow(j6 == ((long) i7), "checkedSubtract", i5, i6);
        return i7;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int divide(int i5, int i6, RoundingMode roundingMode) {
        Preconditions.checkNotNull(roundingMode);
        if (i6 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i7 = i5 / i6;
        int i8 = i5 - (i6 * i7);
        if (i8 == 0) {
            return i7;
        }
        int i9 = ((i5 ^ i6) >> 31) | 1;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(i8 == 0);
                return i7;
            case 2:
                return i7;
            case 3:
                if (i9 >= 0) {
                    return i7;
                }
                return i7 + i9;
            case 4:
                return i7 + i9;
            case 5:
                if (i9 <= 0) {
                    return i7;
                }
                return i7 + i9;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i8);
                int iAbs2 = iAbs - (Math.abs(i6) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if (!((roundingMode == RoundingMode.HALF_EVEN) & ((i7 & 1) != 0))) {
                            return i7;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    return i7;
                }
                return i7 + i9;
            default:
                throw new AssertionError();
        }
    }

    public static int factorial(int i5) {
        MathPreconditions.checkNonNegative("n", i5);
        int[] iArr = factorials;
        if (i5 < iArr.length) {
            return iArr[i5];
        }
        return Integer.MAX_VALUE;
    }

    @Beta
    public static int floorPowerOfTwo(int i5) {
        MathPreconditions.checkPositive("x", i5);
        return Integer.highestOneBit(i5);
    }

    public static int gcd(int i5, int i6) {
        MathPreconditions.checkNonNegative("a", i5);
        MathPreconditions.checkNonNegative("b", i6);
        if (i5 == 0) {
            return i6;
        }
        if (i6 == 0) {
            return i5;
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i5);
        int iNumberOfTrailingZeros2 = i5 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros3 = Integer.numberOfTrailingZeros(i6);
        int i7 = i6 >> iNumberOfTrailingZeros3;
        while (iNumberOfTrailingZeros2 != i7) {
            int i8 = iNumberOfTrailingZeros2 - i7;
            int i9 = (i8 >> 31) & i8;
            int i10 = (i8 - i9) - i9;
            i7 += i9;
            iNumberOfTrailingZeros2 = i10 >> Integer.numberOfTrailingZeros(i10);
        }
        return iNumberOfTrailingZeros2 << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros3);
    }

    public static boolean isPowerOfTwo(int i5) {
        return (i5 > 0) & ((i5 & (i5 + (-1))) == 0);
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(int i5) {
        return LongMath.isPrime(i5);
    }

    @VisibleForTesting
    public static int lessThanBranchFree(int i5, int i6) {
        return (~(~(i5 - i6))) >>> 31;
    }

    @GwtIncompatible
    public static int log10(int i5, RoundingMode roundingMode) {
        int iLessThanBranchFree;
        MathPreconditions.checkPositive("x", i5);
        int iLog10Floor = log10Floor(i5);
        int i6 = powersOf10[iLog10Floor];
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(i5 == i6);
                return iLog10Floor;
            case 2:
            case 3:
                return iLog10Floor;
            case 4:
            case 5:
                iLessThanBranchFree = lessThanBranchFree(i6, i5);
                break;
            case 6:
            case 7:
            case 8:
                iLessThanBranchFree = lessThanBranchFree(halfPowersOf10[iLog10Floor], i5);
                break;
            default:
                throw new AssertionError();
        }
        return iLessThanBranchFree + iLog10Floor;
    }

    private static int log10Floor(int i5) {
        byte b = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(i5)];
        return b - lessThanBranchFree(i5, powersOf10[b]);
    }

    public static int log2(int i5, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", i5);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(i5));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i5 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i5);
                return lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> iNumberOfLeadingZeros, i5) + (31 - iNumberOfLeadingZeros);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i5);
    }

    public static int mean(int i5, int i6) {
        return (i5 & i6) + ((i5 ^ i6) >> 1);
    }

    public static int mod(int i5, int i6) {
        if (i6 > 0) {
            int i7 = i5 % i6;
            return i7 >= 0 ? i7 : i7 + i6;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("Modulus ");
        sb.append(i6);
        sb.append(" must be > 0");
        throw new ArithmeticException(sb.toString());
    }

    @GwtIncompatible
    public static int pow(int i5, int i6) {
        MathPreconditions.checkNonNegative("exponent", i6);
        if (i5 == -2) {
            if (i6 < 32) {
                return (i6 & 1) == 0 ? 1 << i6 : -(1 << i6);
            }
            return 0;
        }
        if (i5 == -1) {
            return (i6 & 1) == 0 ? 1 : -1;
        }
        if (i5 == 0) {
            return i6 == 0 ? 1 : 0;
        }
        if (i5 == 1) {
            return 1;
        }
        if (i5 == 2) {
            if (i6 < 32) {
                return 1 << i6;
            }
            return 0;
        }
        int i7 = 1;
        while (i6 != 0) {
            if (i6 == 1) {
                return i5 * i7;
            }
            i7 *= (i6 & 1) == 0 ? 1 : i5;
            i5 *= i5;
            i6 >>= 1;
        }
        return i7;
    }

    @Beta
    public static int saturatedAdd(int i5, int i6) {
        return Ints.saturatedCast(((long) i5) + ((long) i6));
    }

    @Beta
    public static int saturatedMultiply(int i5, int i6) {
        return Ints.saturatedCast(((long) i5) * ((long) i6));
    }

    @Beta
    public static int saturatedPow(int i5, int i6) {
        MathPreconditions.checkNonNegative("exponent", i6);
        if (i5 == -2) {
            if (i6 >= 32) {
                return (i6 & 1) + Integer.MAX_VALUE;
            }
            return (i6 & 1) == 0 ? 1 << i6 : (-1) << i6;
        }
        if (i5 == -1) {
            return (i6 & 1) == 0 ? 1 : -1;
        }
        if (i5 == 0) {
            return i6 == 0 ? 1 : 0;
        }
        if (i5 == 1) {
            return 1;
        }
        if (i5 == 2) {
            if (i6 >= 31) {
                return Integer.MAX_VALUE;
            }
            return 1 << i6;
        }
        int i7 = ((i5 >>> 31) & i6 & 1) + Integer.MAX_VALUE;
        int iSaturatedMultiply = 1;
        while (i6 != 0) {
            if (i6 == 1) {
                return saturatedMultiply(iSaturatedMultiply, i5);
            }
            if ((i6 & 1) != 0) {
                iSaturatedMultiply = saturatedMultiply(iSaturatedMultiply, i5);
            }
            i6 >>= 1;
            if (i6 > 0) {
                if ((-46340 > i5) || (i5 > FLOOR_SQRT_MAX_INT)) {
                    return i7;
                }
                i5 *= i5;
            }
        }
        return iSaturatedMultiply;
    }

    @Beta
    public static int saturatedSubtract(int i5, int i6) {
        return Ints.saturatedCast(((long) i5) - ((long) i6));
    }

    @GwtIncompatible
    public static int sqrt(int i5, RoundingMode roundingMode) {
        int iLessThanBranchFree;
        MathPreconditions.checkNonNegative("x", i5);
        int iSqrtFloor = sqrtFloor(i5);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(iSqrtFloor * iSqrtFloor == i5);
                return iSqrtFloor;
            case 2:
            case 3:
                return iSqrtFloor;
            case 4:
            case 5:
                iLessThanBranchFree = lessThanBranchFree(iSqrtFloor * iSqrtFloor, i5);
                break;
            case 6:
            case 7:
            case 8:
                iLessThanBranchFree = lessThanBranchFree((iSqrtFloor * iSqrtFloor) + iSqrtFloor, i5);
                break;
            default:
                throw new AssertionError();
        }
        return iLessThanBranchFree + iSqrtFloor;
    }

    private static int sqrtFloor(int i5) {
        return (int) Math.sqrt(i5);
    }
}
