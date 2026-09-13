package org.apache.commons.math3.stat.inference;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ChiSquareTest {
    private void checkArray(long[][] jArr) {
        if (jArr.length < 2) {
            throw new DimensionMismatchException(jArr.length, 2);
        }
        if (jArr[0].length < 2) {
            throw new DimensionMismatchException(jArr[0].length, 2);
        }
        MathArrays.checkRectangular(jArr);
        MathArrays.checkNonNegative(jArr);
    }

    public double chiSquare(double[] dArr, long[] jArr) {
        double d;
        boolean z6;
        double d6;
        double d7;
        if (dArr.length < 2) {
            throw new DimensionMismatchException(dArr.length, 2);
        }
        if (dArr.length != jArr.length) {
            throw new DimensionMismatchException(dArr.length, jArr.length);
        }
        MathArrays.checkPositive(dArr);
        MathArrays.checkNonNegative(jArr);
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        for (int i5 = 0; i5 < jArr.length; i5++) {
            d9 += dArr[i5];
            d10 += jArr[i5];
        }
        if (FastMath.abs(d9 - d10) > 1.0E-5d) {
            d = d10 / d9;
            z6 = true;
        } else {
            d = 1.0d;
            z6 = false;
        }
        for (int i6 = 0; i6 < jArr.length; i6++) {
            if (z6) {
                double d11 = jArr[i6];
                double d12 = dArr[i6];
                double d13 = d11 - (d * d12);
                d7 = d13 * d13;
                d6 = d12 * d;
            } else {
                double d14 = jArr[i6];
                d6 = dArr[i6];
                double d15 = d14 - d6;
                d7 = d15 * d15;
            }
            d8 = (d7 / d6) + d8;
        }
        return d8;
    }

    public double chiSquareDataSetsComparison(long[] jArr, long[] jArr2) {
        if (jArr.length < 2) {
            throw new DimensionMismatchException(jArr.length, 2);
        }
        if (jArr.length != jArr2.length) {
            throw new DimensionMismatchException(jArr.length, jArr2.length);
        }
        MathArrays.checkNonNegative(jArr);
        MathArrays.checkNonNegative(jArr2);
        long j6 = 0;
        long j7 = 0;
        for (int i5 = 0; i5 < jArr.length; i5++) {
            j6 += jArr[i5];
            j7 += jArr2[i5];
        }
        if (j6 == 0 || j7 == 0) {
            throw new ZeroException();
        }
        boolean z6 = j6 != j7;
        double d = 0.0d;
        double dSqrt = z6 ? FastMath.sqrt(j6 / j7) : 0.0d;
        for (int i6 = 0; i6 < jArr.length; i6++) {
            long j8 = jArr[i6];
            if (j8 == 0 && jArr2[i6] == 0) {
                throw new ZeroException(LocalizedFormats.OBSERVED_COUNTS_BOTTH_ZERO_FOR_ENTRY, Integer.valueOf(i6));
            }
            double d6 = j8;
            double d7 = jArr2[i6];
            double d8 = z6 ? (d6 / dSqrt) - (d7 * dSqrt) : d6 - d7;
            d += (d8 * d8) / (d6 + d7);
        }
        return d;
    }

    public double chiSquareTest(double[] dArr, long[] jArr) {
        return 1.0d - new ChiSquaredDistribution((RandomGenerator) null, ((double) dArr.length) - 1.0d).cumulativeProbability(chiSquare(dArr, jArr));
    }

    public double chiSquareTestDataSetsComparison(long[] jArr, long[] jArr2) {
        return 1.0d - new ChiSquaredDistribution((RandomGenerator) null, ((double) jArr.length) - 1.0d).cumulativeProbability(chiSquareDataSetsComparison(jArr, jArr2));
    }

    public boolean chiSquareTest(double[] dArr, long[] jArr, double d) {
        if (d <= 0.0d || d > 0.5d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(d), 0, Double.valueOf(0.5d));
        }
        return chiSquareTest(dArr, jArr) < d;
    }

    public boolean chiSquareTestDataSetsComparison(long[] jArr, long[] jArr2, double d) {
        if (d <= 0.0d || d > 0.5d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(d), 0, Double.valueOf(0.5d));
        }
        return chiSquareTestDataSetsComparison(jArr, jArr2) < d;
    }

    public double chiSquareTest(long[][] jArr) {
        checkArray(jArr);
        return 1.0d - new ChiSquaredDistribution((((double) jArr[0].length) - 1.0d) * (((double) jArr.length) - 1.0d)).cumulativeProbability(chiSquare(jArr));
    }

    public boolean chiSquareTest(long[][] jArr, double d) {
        if (d <= 0.0d || d > 0.5d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(d), 0, Double.valueOf(0.5d));
        }
        return chiSquareTest(jArr) < d;
    }

    public double chiSquare(long[][] jArr) {
        long[][] jArr2 = jArr;
        checkArray(jArr);
        int length = jArr2.length;
        int i5 = 0;
        int length2 = jArr2[0].length;
        double[] dArr = new double[length];
        double[] dArr2 = new double[length2];
        int i6 = 0;
        double d = 0.0d;
        while (i6 < length) {
            int i7 = i5;
            while (i7 < length2) {
                double d6 = dArr[i6];
                long j6 = jArr2[i6][i7];
                dArr[i6] = d6 + j6;
                dArr2[i7] = dArr2[i7] + j6;
                d += j6;
                i7++;
                length2 = length2;
            }
            i6++;
            i5 = 0;
        }
        int i8 = 0;
        double d7 = 0.0d;
        while (true) {
            int i9 = length2;
            if (i8 >= length) {
                return d7;
            }
            length2 = i9;
            int i10 = 0;
            while (i10 < length2) {
                double d8 = (dArr[i8] * dArr2[i10]) / d;
                long j7 = jArr2[i8][i10];
                d7 += ((j7 - d8) * (j7 - d8)) / d8;
                i10++;
                jArr2 = jArr;
                length = length;
            }
            i8++;
            jArr2 = jArr;
        }
    }
}
