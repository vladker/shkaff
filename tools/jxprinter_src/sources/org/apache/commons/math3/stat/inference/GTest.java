package org.apache.commons.math3.stat.inference;

import java.lang.reflect.Array;
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
public class GTest {
    private double entropy(long[][] jArr) {
        double dLog = 0.0d;
        double d = 0.0d;
        for (long[] jArr2 : jArr) {
            int i5 = 0;
            while (true) {
                if (i5 < jArr2.length) {
                    d += jArr2[i5];
                    i5++;
                }
            }
        }
        for (long[] jArr3 : jArr) {
            int i6 = 0;
            while (true) {
                if (i6 < jArr3.length) {
                    long j6 = jArr3[i6];
                    if (j6 != 0) {
                        double d6 = j6 / d;
                        dLog += FastMath.log(d6) * d6;
                    }
                    i6++;
                }
            }
        }
        return -dLog;
    }

    public double g(double[] dArr, long[] jArr) {
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
        double dLog = 0.0d;
        double d8 = 0.0d;
        double d9 = 0.0d;
        for (int i5 = 0; i5 < jArr.length; i5++) {
            d8 += dArr[i5];
            d9 += jArr[i5];
        }
        if (FastMath.abs(d8 - d9) > 1.0E-5d) {
            d = d9 / d8;
            z6 = true;
        } else {
            d = 1.0d;
            z6 = false;
        }
        for (int i6 = 0; i6 < jArr.length; i6++) {
            if (z6) {
                d6 = jArr[i6];
                d7 = dArr[i6] * d;
            } else {
                d6 = jArr[i6];
                d7 = dArr[i6];
            }
            dLog += jArr[i6] * FastMath.log(d6 / d7);
        }
        return dLog * 2.0d;
    }

    public double gDataSetsComparison(long[] jArr, long[] jArr2) {
        if (jArr.length < 2) {
            throw new DimensionMismatchException(jArr.length, 2);
        }
        if (jArr.length != jArr2.length) {
            throw new DimensionMismatchException(jArr.length, jArr2.length);
        }
        MathArrays.checkNonNegative(jArr);
        MathArrays.checkNonNegative(jArr2);
        long[] jArr3 = new long[jArr.length];
        long[][] jArr4 = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 2, jArr.length);
        long j6 = 0;
        long j7 = 0;
        for (int i5 = 0; i5 < jArr.length; i5++) {
            long j8 = jArr[i5];
            if (j8 == 0 && jArr2[i5] == 0) {
                throw new ZeroException(LocalizedFormats.OBSERVED_COUNTS_BOTTH_ZERO_FOR_ENTRY, Integer.valueOf(i5));
            }
            j6 += j8;
            long j9 = jArr2[i5];
            j7 += j9;
            jArr3[i5] = j8 + j9;
            jArr4[0][i5] = jArr[i5];
            jArr4[1][i5] = jArr2[i5];
        }
        if (j6 == 0 || j7 == 0) {
            throw new ZeroException();
        }
        return ((entropy(new long[]{j6, j7}) + entropy(jArr3)) - entropy(jArr4)) * (j6 + j7) * 2.0d;
    }

    public double gTest(double[] dArr, long[] jArr) {
        return 1.0d - new ChiSquaredDistribution((RandomGenerator) null, ((double) dArr.length) - 1.0d).cumulativeProbability(g(dArr, jArr));
    }

    public double gTestDataSetsComparison(long[] jArr, long[] jArr2) {
        return 1.0d - new ChiSquaredDistribution((RandomGenerator) null, ((double) jArr.length) - 1.0d).cumulativeProbability(gDataSetsComparison(jArr, jArr2));
    }

    public double gTestIntrinsic(double[] dArr, long[] jArr) {
        return 1.0d - new ChiSquaredDistribution((RandomGenerator) null, ((double) dArr.length) - 2.0d).cumulativeProbability(g(dArr, jArr));
    }

    public double rootLogLikelihoodRatio(long j6, long j7, long j8, long j9) {
        double dSqrt = FastMath.sqrt(gDataSetsComparison(new long[]{j6, j7}, new long[]{j8, j9}));
        return ((double) j6) / ((double) (j6 + j7)) < ((double) j8) / ((double) (j8 + j9)) ? -dSqrt : dSqrt;
    }

    public boolean gTest(double[] dArr, long[] jArr, double d) {
        if (d <= 0.0d || d > 0.5d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(d), 0, Double.valueOf(0.5d));
        }
        return gTest(dArr, jArr) < d;
    }

    public boolean gTestDataSetsComparison(long[] jArr, long[] jArr2, double d) {
        if (d <= 0.0d || d > 0.5d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(d), 0, Double.valueOf(0.5d));
        }
        return gTestDataSetsComparison(jArr, jArr2) < d;
    }

    private double entropy(long[] jArr) {
        double dLog = 0.0d;
        double d = 0.0d;
        for (long j6 : jArr) {
            d += j6;
        }
        for (long j7 : jArr) {
            if (j7 != 0) {
                double d6 = j7 / d;
                dLog = (FastMath.log(d6) * d6) + dLog;
            }
        }
        return -dLog;
    }
}
