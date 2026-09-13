package com.google.common.math;

import androidx.core.location.LocationRequestCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import io.flutter.embedding.android.KeyboardMap;
import java.math.RoundingMode;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class LongMath {

    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;

    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;

    @VisibleForTesting
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;

    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    @VisibleForTesting
    @GwtIncompatible
    static final long[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    @VisibleForTesting
    @GwtIncompatible
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, Videoio.CAP_PROP_XI_SENSOR_OUTPUT_CHANNEL_COUNT, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    @VisibleForTesting
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, Videoio.CAP_PROP_XI_AEAG_LEVEL, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{LocationRequestCompat.PASSIVE_INTERVAL, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* JADX INFO: renamed from: com.google.common.math.LongMath$1, reason: invalid class name */
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

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum MillerRabinTester {
        SMALL { // from class: com.google.common.math.LongMath.MillerRabinTester.1
            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j6, long j7, long j8) {
                return (j6 * j7) % j8;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j6, long j7) {
                return (j6 * j6) % j7;
            }
        },
        LARGE { // from class: com.google.common.math.LongMath.MillerRabinTester.2
            private long plusMod(long j6, long j7, long j8) {
                long j9 = j6 + j7;
                return j6 >= j8 - j7 ? j9 - j8 : j9;
            }

            private long times2ToThe32Mod(long j6, long j7) {
                int i5 = 32;
                do {
                    int iMin = Math.min(i5, Long.numberOfLeadingZeros(j6));
                    j6 = UnsignedLongs.remainder(j6 << iMin, j7);
                    i5 -= iMin;
                } while (i5 > 0);
                return j6;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j6, long j7, long j8) {
                long j9 = j6 >>> 32;
                long j10 = j7 >>> 32;
                long j11 = j6 & KeyboardMap.kValueMask;
                long j12 = j7 & KeyboardMap.kValueMask;
                long jTimes2ToThe32Mod = (j9 * j12) + times2ToThe32Mod(j9 * j10, j8);
                if (jTimes2ToThe32Mod < 0) {
                    jTimes2ToThe32Mod = UnsignedLongs.remainder(jTimes2ToThe32Mod, j8);
                }
                return plusMod(times2ToThe32Mod((j10 * j11) + jTimes2ToThe32Mod, j8), UnsignedLongs.remainder(j11 * j12, j8), j8);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j6, long j7) {
                long j8 = j6 >>> 32;
                long j9 = j6 & KeyboardMap.kValueMask;
                long jTimes2ToThe32Mod = times2ToThe32Mod(j8 * j8, j7);
                long jRemainder = j8 * j9 * 2;
                if (jRemainder < 0) {
                    jRemainder = UnsignedLongs.remainder(jRemainder, j7);
                }
                return plusMod(times2ToThe32Mod(jTimes2ToThe32Mod + jRemainder, j7), UnsignedLongs.remainder(j9 * j9, j7), j7);
            }
        };

        private long powMod(long j6, long j7, long j8) {
            long jSquareMod = j6;
            long jMulMod = 1;
            while (j7 != 0) {
                long j9 = j8;
                if ((j7 & 1) != 0) {
                    jMulMod = mulMod(jMulMod, jSquareMod, j9);
                }
                jSquareMod = squareMod(jSquareMod, j9);
                j7 >>= 1;
                j8 = j9;
            }
            return jMulMod;
        }

        public static boolean test(long j6, long j7) {
            return (j7 <= LongMath.FLOOR_SQRT_MAX_LONG ? SMALL : LARGE).testWitness(j6, j7);
        }

        private boolean testWitness(long j6, long j7) {
            long j8 = j7 - 1;
            int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j8);
            long j9 = j8 >> iNumberOfTrailingZeros;
            long j10 = j6 % j7;
            if (j10 == 0) {
                return true;
            }
            long jPowMod = powMod(j10, j9, j7);
            if (jPowMod == 1) {
                return true;
            }
            int i5 = 0;
            while (jPowMod != j8) {
                i5++;
                if (i5 == iNumberOfTrailingZeros) {
                    return false;
                }
                jPowMod = squareMod(jPowMod, j7);
            }
            return true;
        }

        public abstract long mulMod(long j6, long j7, long j8);

        public abstract long squareMod(long j6, long j7);

        /* synthetic */ MillerRabinTester(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private LongMath() {
    }

    public static long binomial(int i5, int i6) {
        MathPreconditions.checkNonNegative("n", i5);
        MathPreconditions.checkNonNegative("k", i6);
        Preconditions.checkArgument(i6 <= i5, "k (%s) > n (%s)", i6, i5);
        if (i6 > (i5 >> 1)) {
            i6 = i5 - i6;
        }
        long jMultiplyFraction = 1;
        if (i6 == 0) {
            return 1L;
        }
        if (i6 == 1) {
            return i5;
        }
        long[] jArr = factorials;
        if (i5 < jArr.length) {
            return jArr[i5] / (jArr[i6] * jArr[i5 - i6]);
        }
        int[] iArr = biggestBinomials;
        if (i6 >= iArr.length || i5 > iArr[i6]) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        int[] iArr2 = biggestSimpleBinomials;
        if (i6 < iArr2.length && i5 <= iArr2[i6]) {
            int i7 = i5 - 1;
            long j6 = i5;
            for (int i8 = 2; i8 <= i6; i8++) {
                j6 = (j6 * ((long) i7)) / ((long) i8);
                i7--;
            }
            return j6;
        }
        long j7 = i5;
        int iLog2 = log2(j7, RoundingMode.CEILING);
        int i9 = i5 - 1;
        int i10 = iLog2;
        int i11 = 2;
        long j8 = j7;
        long j9 = 1;
        while (i11 <= i6) {
            i10 += iLog2;
            if (i10 < 63) {
                j8 *= (long) i9;
                j9 *= (long) i11;
            } else {
                jMultiplyFraction = multiplyFraction(jMultiplyFraction, j8, j9);
                j8 = i9;
                j9 = i11;
                i10 = iLog2;
            }
            i11++;
            i9--;
        }
        return multiplyFraction(jMultiplyFraction, j8, j9);
    }

    @Beta
    public static long ceilingPowerOfTwo(long j6) {
        MathPreconditions.checkPositive("x", j6);
        if (j6 <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j6 - 1));
        }
        StringBuilder sb = new StringBuilder(70);
        sb.append("ceilingPowerOfTwo(");
        sb.append(j6);
        sb.append(") is not representable as a long");
        throw new ArithmeticException(sb.toString());
    }

    @GwtIncompatible
    public static long checkedAdd(long j6, long j7) {
        long j8 = j6 + j7;
        MathPreconditions.checkNoOverflow(((j6 ^ j7) < 0) | ((j6 ^ j8) >= 0), "checkedAdd", j6, j7);
        return j8;
    }

    public static long checkedMultiply(long j6, long j7) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j7) + Long.numberOfLeadingZeros(j7) + Long.numberOfLeadingZeros(~j6) + Long.numberOfLeadingZeros(j6);
        if (iNumberOfLeadingZeros > 65) {
            return j6 * j7;
        }
        MathPreconditions.checkNoOverflow(iNumberOfLeadingZeros >= 64, "checkedMultiply", j6, j7);
        MathPreconditions.checkNoOverflow((j6 >= 0) | (j7 != Long.MIN_VALUE), "checkedMultiply", j6, j7);
        long j8 = j6 * j7;
        MathPreconditions.checkNoOverflow(j6 == 0 || j8 / j6 == j7, "checkedMultiply", j6, j7);
        return j8;
    }

    @GwtIncompatible
    public static long checkedPow(long j6, int i5) {
        int i6 = i5;
        MathPreconditions.checkNonNegative("exponent", i6);
        long jCheckedMultiply = 1;
        if (!(j6 >= -2) || !(j6 <= 2)) {
            long j7 = j6;
            while (i6 != 0) {
                if (i6 == 1) {
                    return checkedMultiply(jCheckedMultiply, j7);
                }
                if ((i6 & 1) != 0) {
                    jCheckedMultiply = checkedMultiply(jCheckedMultiply, j7);
                }
                i6 >>= 1;
                if (i6 > 0) {
                    MathPreconditions.checkNoOverflow(-3037000499L <= j7 && j7 <= FLOOR_SQRT_MAX_LONG, "checkedPow", j7, i6);
                    j7 *= j7;
                }
            }
            return jCheckedMultiply;
        }
        int i7 = (int) j6;
        if (i7 == -2) {
            MathPreconditions.checkNoOverflow(i6 < 64, "checkedPow", j6, i6);
            return (i6 & 1) == 0 ? 1 << i6 : (-1) << i6;
        }
        if (i7 == -1) {
            return (i6 & 1) == 0 ? 1L : -1L;
        }
        if (i7 == 0) {
            return i6 == 0 ? 1L : 0L;
        }
        if (i7 == 1) {
            return 1L;
        }
        if (i7 != 2) {
            throw new AssertionError();
        }
        MathPreconditions.checkNoOverflow(i6 < 63, "checkedPow", j6, i6);
        return 1 << i6;
    }

    @GwtIncompatible
    public static long checkedSubtract(long j6, long j7) {
        long j8 = j6 - j7;
        MathPreconditions.checkNoOverflow(((j6 ^ j7) >= 0) | ((j6 ^ j8) >= 0), "checkedSubtract", j6, j7);
        return j8;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @GwtIncompatible
    public static long divide(long j6, long j7, RoundingMode roundingMode) {
        Preconditions.checkNotNull(roundingMode);
        long j8 = j6 / j7;
        long j9 = j6 - (j7 * j8);
        if (j9 == 0) {
            return j8;
        }
        int i5 = ((int) ((j6 ^ j7) >> 63)) | 1;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j9 == 0);
                return j8;
            case 2:
                return j8;
            case 3:
                if (i5 >= 0) {
                    return j8;
                }
                return j8 + ((long) i5);
            case 4:
                return j8 + ((long) i5);
            case 5:
                if (i5 <= 0) {
                    return j8;
                }
                return j8 + ((long) i5);
            case 6:
            case 7:
            case 8:
                long jAbs = Math.abs(j9);
                long jAbs2 = jAbs - (Math.abs(j7) - jAbs);
                if (jAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP && (roundingMode != RoundingMode.HALF_EVEN || (1 & j8) == 0)) {
                        return j8;
                    }
                } else if (jAbs2 <= 0) {
                    return j8;
                }
                return j8 + ((long) i5);
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static long factorial(int i5) {
        MathPreconditions.checkNonNegative("n", i5);
        long[] jArr = factorials;
        return i5 < jArr.length ? jArr[i5] : LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public static boolean fitsInInt(long j6) {
        return ((long) ((int) j6)) == j6;
    }

    @Beta
    public static long floorPowerOfTwo(long j6) {
        MathPreconditions.checkPositive("x", j6);
        return 1 << (63 - Long.numberOfLeadingZeros(j6));
    }

    public static long gcd(long j6, long j7) {
        MathPreconditions.checkNonNegative("a", j6);
        MathPreconditions.checkNonNegative("b", j7);
        if (j6 == 0) {
            return j7;
        }
        if (j7 == 0) {
            return j6;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j6);
        long jNumberOfTrailingZeros = j6 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j7);
        long j8 = j7 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j8) {
            long j9 = jNumberOfTrailingZeros - j8;
            long j10 = (j9 >> 63) & j9;
            long j11 = (j9 - j10) - j10;
            j8 += j10;
            jNumberOfTrailingZeros = j11 >> Long.numberOfTrailingZeros(j11);
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j6) {
        return (j6 > 0) & ((j6 & (j6 - 1)) == 0);
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(long j6) {
        if (j6 < 2) {
            MathPreconditions.checkNonNegative("n", j6);
            return false;
        }
        if (j6 < 66) {
            return ((722865708377213483 >> (((int) j6) + (-2))) & 1) != 0;
        }
        if (((1 << ((int) (j6 % 30))) & SIEVE_30) != 0 || j6 % 7 == 0 || j6 % 11 == 0 || j6 % 13 == 0) {
            return false;
        }
        if (j6 < 289) {
            return true;
        }
        for (long[] jArr : millerRabinBaseSets) {
            if (j6 <= jArr[0]) {
                for (int i5 = 1; i5 < jArr.length; i5++) {
                    if (!MillerRabinTester.test(jArr[i5], j6)) {
                        return false;
                    }
                }
                return true;
            }
        }
        throw new AssertionError();
    }

    @VisibleForTesting
    public static int lessThanBranchFree(long j6, long j7) {
        return (int) ((~(~(j6 - j7))) >>> 63);
    }

    @GwtIncompatible
    public static int log10(long j6, RoundingMode roundingMode) {
        int iLessThanBranchFree;
        MathPreconditions.checkPositive("x", j6);
        int iLog10Floor = log10Floor(j6);
        long j7 = powersOf10[iLog10Floor];
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j6 == j7);
                return iLog10Floor;
            case 2:
            case 3:
                return iLog10Floor;
            case 4:
            case 5:
                iLessThanBranchFree = lessThanBranchFree(j7, j6);
                break;
            case 6:
            case 7:
            case 8:
                iLessThanBranchFree = lessThanBranchFree(halfPowersOf10[iLog10Floor], j6);
                break;
            default:
                throw new AssertionError();
        }
        return iLessThanBranchFree + iLog10Floor;
    }

    @GwtIncompatible
    public static int log10Floor(long j6) {
        byte b = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j6)];
        return b - lessThanBranchFree(j6, powersOf10[b]);
    }

    public static int log2(long j6, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", j6);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(j6));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j6 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j6);
                return lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> iNumberOfLeadingZeros, j6) + (63 - iNumberOfLeadingZeros);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j6);
    }

    public static long mean(long j6, long j7) {
        return (j6 & j7) + ((j6 ^ j7) >> 1);
    }

    @GwtIncompatible
    public static int mod(long j6, int i5) {
        return (int) mod(j6, i5);
    }

    public static long multiplyFraction(long j6, long j7, long j8) {
        if (j6 == 1) {
            return j7 / j8;
        }
        long jGcd = gcd(j6, j8);
        return (j7 / (j8 / jGcd)) * (j6 / jGcd);
    }

    @GwtIncompatible
    public static long pow(long j6, int i5) {
        MathPreconditions.checkNonNegative("exponent", i5);
        if (-2 > j6 || j6 > 2) {
            long j7 = 1;
            while (i5 != 0) {
                if (i5 == 1) {
                    return j7 * j6;
                }
                j7 *= (i5 & 1) == 0 ? 1L : j6;
                j6 *= j6;
                i5 >>= 1;
            }
            return j7;
        }
        int i6 = (int) j6;
        if (i6 == -2) {
            if (i5 < 64) {
                return (i5 & 1) == 0 ? 1 << i5 : -(1 << i5);
            }
            return 0L;
        }
        if (i6 == -1) {
            return (i5 & 1) == 0 ? 1L : -1L;
        }
        if (i6 == 0) {
            return i5 == 0 ? 1L : 0L;
        }
        if (i6 == 1) {
            return 1L;
        }
        if (i6 != 2) {
            throw new AssertionError();
        }
        if (i5 < 64) {
            return 1 << i5;
        }
        return 0L;
    }

    @GwtIncompatible
    public static double roundToDouble(long j6, RoundingMode roundingMode) {
        double dNextUp;
        long jCeil;
        double d = j6;
        long j7 = (long) d;
        int iCompare = j7 == LocationRequestCompat.PASSIVE_INTERVAL ? -1 : Longs.compare(j6, j7);
        int[] iArr = AnonymousClass1.$SwitchMap$java$math$RoundingMode;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(iCompare == 0);
                return d;
            case 2:
                if (j6 >= 0) {
                    if (iCompare < 0) {
                        return DoubleUtils.nextDown(d);
                    }
                } else if (iCompare > 0) {
                    return Math.nextUp(d);
                }
                return d;
            case 3:
                if (iCompare < 0) {
                    return DoubleUtils.nextDown(d);
                }
                return d;
            case 4:
                if (j6 >= 0) {
                    if (iCompare > 0) {
                        return Math.nextUp(d);
                    }
                } else if (iCompare < 0) {
                    return DoubleUtils.nextDown(d);
                }
                return d;
            case 5:
                if (iCompare > 0) {
                    return Math.nextUp(d);
                }
                return d;
            case 6:
            case 7:
            case 8:
                if (iCompare >= 0) {
                    dNextUp = Math.nextUp(d);
                    jCeil = (long) Math.ceil(dNextUp);
                } else {
                    double dNextDown = DoubleUtils.nextDown(d);
                    long jFloor = (long) Math.floor(dNextDown);
                    dNextUp = d;
                    d = dNextDown;
                    jCeil = j7;
                    j7 = jFloor;
                }
                long j8 = j6 - j7;
                long j9 = jCeil - j6;
                if (jCeil == 9223372036854775807) {
                    j9++;
                }
                int iCompare2 = Longs.compare(j8, j9);
                if (iCompare2 >= 0) {
                    if (iCompare2 <= 0) {
                        int i5 = iArr[roundingMode.ordinal()];
                        if (i5 != 6) {
                            if (i5 != 7) {
                                if (i5 != 8) {
                                    throw new AssertionError("impossible");
                                }
                                if ((DoubleUtils.getSignificand(d) & 1) == 0) {
                                }
                            } else if (j6 >= 0) {
                            }
                        } else if (j6 >= 0) {
                        }
                    }
                    return dNextUp;
                }
                return d;
            default:
                throw new AssertionError("impossible");
        }
    }

    @Beta
    public static long saturatedAdd(long j6, long j7) {
        long j8 = j6 + j7;
        return (((j7 ^ j6) > 0L ? 1 : ((j7 ^ j6) == 0L ? 0 : -1)) < 0) | ((j6 ^ j8) >= 0) ? j8 : ((j8 >>> 63) ^ 1) + LocationRequestCompat.PASSIVE_INTERVAL;
    }

    @Beta
    public static long saturatedMultiply(long j6, long j7) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j7) + Long.numberOfLeadingZeros(j7) + Long.numberOfLeadingZeros(~j6) + Long.numberOfLeadingZeros(j6);
        if (iNumberOfLeadingZeros > 65) {
            return j6 * j7;
        }
        long j8 = ((j6 ^ j7) >>> 63) + LocationRequestCompat.PASSIVE_INTERVAL;
        if (!((iNumberOfLeadingZeros < 64) | ((j7 == Long.MIN_VALUE) & (j6 < 0)))) {
            long j9 = j6 * j7;
            if (j6 == 0 || j9 / j6 == j7) {
                return j9;
            }
        }
        return j8;
    }

    @Beta
    public static long saturatedPow(long j6, int i5) {
        MathPreconditions.checkNonNegative("exponent", i5);
        long jSaturatedMultiply = 1;
        if (!(j6 >= -2) || !(j6 <= 2)) {
            long j7 = ((j6 >>> 63) & ((long) (i5 & 1))) + LocationRequestCompat.PASSIVE_INTERVAL;
            while (i5 != 0) {
                if (i5 == 1) {
                    return saturatedMultiply(jSaturatedMultiply, j6);
                }
                if ((i5 & 1) != 0) {
                    jSaturatedMultiply = saturatedMultiply(jSaturatedMultiply, j6);
                }
                i5 >>= 1;
                if (i5 > 0) {
                    if ((-3037000499L > j6) || (j6 > FLOOR_SQRT_MAX_LONG)) {
                        return j7;
                    }
                    j6 *= j6;
                }
            }
            return jSaturatedMultiply;
        }
        int i6 = (int) j6;
        if (i6 == -2) {
            if (i5 >= 64) {
                return ((long) (i5 & 1)) + LocationRequestCompat.PASSIVE_INTERVAL;
            }
            return (i5 & 1) == 0 ? 1 << i5 : (-1) << i5;
        }
        if (i6 == -1) {
            return (i5 & 1) == 0 ? 1L : -1L;
        }
        if (i6 == 0) {
            return i5 == 0 ? 1L : 0L;
        }
        if (i6 == 1) {
            return 1L;
        }
        if (i6 == 2) {
            return i5 >= 63 ? LocationRequestCompat.PASSIVE_INTERVAL : 1 << i5;
        }
        throw new AssertionError();
    }

    @Beta
    public static long saturatedSubtract(long j6, long j7) {
        long j8 = j6 - j7;
        return (((j7 ^ j6) > 0L ? 1 : ((j7 ^ j6) == 0L ? 0 : -1)) >= 0) | ((j6 ^ j8) >= 0) ? j8 : ((j8 >>> 63) ^ 1) + LocationRequestCompat.PASSIVE_INTERVAL;
    }

    @GwtIncompatible
    public static long sqrt(long j6, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", j6);
        if (fitsInInt(j6)) {
            return IntMath.sqrt((int) j6, roundingMode);
        }
        long jSqrt = (long) Math.sqrt(j6);
        long j7 = jSqrt * jSqrt;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j7 == j6);
                return jSqrt;
            case 2:
            case 3:
                return j6 < j7 ? jSqrt - 1 : jSqrt;
            case 4:
            case 5:
                return j6 > j7 ? jSqrt + 1 : jSqrt;
            case 6:
            case 7:
            case 8:
                long j8 = jSqrt - ((long) (j6 < j7 ? 1 : 0));
                return j8 + ((long) lessThanBranchFree((j8 * j8) + j8, j6));
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static long mod(long j6, long j7) {
        if (j7 <= 0) {
            throw new ArithmeticException("Modulus must be positive");
        }
        long j8 = j6 % j7;
        return j8 >= 0 ? j8 : j8 + j7;
    }
}
