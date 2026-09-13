package org.apache.commons.math3.primes;

import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Primes {
    private Primes() {
    }

    public static boolean isPrime(int i5) {
        if (i5 < 2) {
            return false;
        }
        int[] iArr = SmallPrimes.PRIMES;
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = iArr[i6];
            if (i5 % i7 == 0) {
                return i5 == i7;
            }
        }
        return SmallPrimes.millerRabinPrimeTest(i5);
    }

    public static int nextPrime(int i5) {
        int i6;
        if (i5 < 0) {
            throw new MathIllegalArgumentException(LocalizedFormats.NUMBER_TOO_SMALL, Integer.valueOf(i5), 0);
        }
        if (i5 == 2 || (i6 = i5 | 1) == 1) {
            return 2;
        }
        if (isPrime(i6)) {
            return i6;
        }
        int i7 = i6 % 3;
        if (i7 == 0) {
            i6 += 2;
        } else if (1 == i7) {
            i6 += 4;
        }
        while (!isPrime(i6)) {
            int i8 = i6 + 2;
            if (isPrime(i8)) {
                return i8;
            }
            i6 += 6;
        }
        return i6;
    }

    public static List<Integer> primeFactors(int i5) {
        if (i5 >= 2) {
            return SmallPrimes.trialDivision(i5);
        }
        throw new MathIllegalArgumentException(LocalizedFormats.NUMBER_TOO_SMALL, Integer.valueOf(i5), 2);
    }
}
