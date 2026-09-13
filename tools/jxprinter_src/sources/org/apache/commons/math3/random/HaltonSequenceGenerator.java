package org.apache.commons.math3.random;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HaltonSequenceGenerator implements RandomVectorGenerator {
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173};
    private static final int[] WEIGHTS = {1, 2, 3, 3, 8, 11, 12, 14, 7, 18, 12, 13, 17, 18, 29, 14, 18, 43, 41, 44, 40, 30, 47, 65, 71, 28, 40, 60, 79, 89, 56, 50, 52, 61, 108, 56, 66, 63, 60, 66};
    private final int[] base;
    private int count;
    private final int dimension;
    private final int[] weight;

    public HaltonSequenceGenerator(int i5) {
        this(i5, PRIMES, WEIGHTS);
    }

    public int getNextIndex() {
        return this.count;
    }

    @Override // org.apache.commons.math3.random.RandomVectorGenerator
    public double[] nextVector() {
        double[] dArr = new double[this.dimension];
        for (int i5 = 0; i5 < this.dimension; i5++) {
            int i6 = this.count;
            double d = this.base[i5];
            double d6 = 1.0d;
            while (true) {
                d6 /= d;
                if (i6 > 0) {
                    int i7 = this.base[i5];
                    dArr[i5] = (((double) scramble(i5, 0, i7, i6 % i7)) * d6) + dArr[i5];
                    int i8 = this.base[i5];
                    i6 /= i8;
                    d = i8;
                }
            }
        }
        this.count++;
        return dArr;
    }

    public int scramble(int i5, int i6, int i7, int i8) {
        int[] iArr = this.weight;
        return iArr != null ? (iArr[i5] * i8) % i7 : i8;
    }

    public double[] skipTo(int i5) {
        this.count = i5;
        return nextVector();
    }

    public HaltonSequenceGenerator(int i5, int[] iArr, int[] iArr2) {
        this.count = 0;
        MathUtils.checkNotNull(iArr);
        if (i5 < 1 || i5 > iArr.length) {
            throw new OutOfRangeException(Integer.valueOf(i5), 1, Integer.valueOf(PRIMES.length));
        }
        if (iArr2 != null && iArr2.length != iArr.length) {
            throw new DimensionMismatchException(iArr2.length, iArr.length);
        }
        this.dimension = i5;
        this.base = (int[]) iArr.clone();
        this.weight = iArr2 == null ? null : (int[]) iArr2.clone();
        this.count = 0;
    }
}
