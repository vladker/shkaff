package org.apache.commons.math3.primes;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class PollardRho {
    private PollardRho() {
    }

    public static int gcdPositive(int i5, int i6) {
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
            iMin = FastMath.min(iNumberOfTrailingZeros2, iMin);
            int iAbs = FastMath.abs(i7);
            iNumberOfTrailingZeros2 = iAbs >> Integer.numberOfTrailingZeros(iAbs);
        }
        return iNumberOfTrailingZeros2 << iMin2;
    }

    public static List<Integer> primeFactors(int i5) {
        ArrayList arrayList = new ArrayList();
        int iSmallTrialDivision = SmallPrimes.smallTrialDivision(i5, arrayList);
        if (1 == iSmallTrialDivision) {
            return arrayList;
        }
        if (SmallPrimes.millerRabinPrimeTest(iSmallTrialDivision)) {
            arrayList.add(Integer.valueOf(iSmallTrialDivision));
            return arrayList;
        }
        int iRhoBrent = rhoBrent(iSmallTrialDivision);
        arrayList.add(Integer.valueOf(iRhoBrent));
        arrayList.add(Integer.valueOf(iSmallTrialDivision / iRhoBrent));
        return arrayList;
    }

    public static int rhoBrent(int i5) {
        int i6 = SmallPrimes.PRIMES_LAST;
        int i7 = 2;
        int i8 = 1;
        while (true) {
            int i9 = 0;
            int i10 = i7;
            for (int i11 = 0; i11 < i8; i11++) {
                long j6 = i10;
                i10 = (int) (((j6 * j6) + ((long) i6)) % ((long) i5));
            }
            do {
                char c = 25;
                int iMin = FastMath.min(25, i8 - i9);
                int i12 = -3;
                int i13 = 1;
                while (i12 < iMin) {
                    long j7 = i10;
                    long j8 = i5;
                    i10 = (int) (((j7 * j7) + ((long) i6)) % j8);
                    long jAbs = FastMath.abs(i7 - i10);
                    if (0 == jAbs) {
                        i6 += SmallPrimes.PRIMES_LAST;
                        i9 = -25;
                        i10 = 2;
                        i8 = 1;
                        break;
                    }
                    char c6 = c;
                    int i14 = i12;
                    i13 = (int) ((((long) i13) * jAbs) % j8);
                    if (i13 == 0) {
                        return gcdPositive(FastMath.abs((int) jAbs), i5);
                    }
                    i12 = i14 + 1;
                    c = c6;
                }
                int iGcdPositive = gcdPositive(FastMath.abs(i13), i5);
                if (1 != iGcdPositive) {
                    return iGcdPositive;
                }
                i9 += 25;
            } while (i9 < i8);
            i8 *= 2;
            i7 = i10;
        }
    }
}
