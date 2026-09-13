package org.apache.commons.math3.stat.inference;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.commons.math3.stat.ranking.NaturalRanking;
import org.apache.commons.math3.stat.ranking.TiesStrategy;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class WilcoxonSignedRankTest {
    private NaturalRanking naturalRanking;

    public WilcoxonSignedRankTest() {
        this.naturalRanking = new NaturalRanking(NaNStrategy.FIXED, TiesStrategy.AVERAGE);
    }

    private double[] calculateAbsoluteDifferences(double[] dArr) {
        if (dArr == null) {
            throw new NullArgumentException();
        }
        if (dArr.length == 0) {
            throw new NoDataException();
        }
        double[] dArr2 = new double[dArr.length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr2[i5] = FastMath.abs(dArr[i5]);
        }
        return dArr2;
    }

    private double calculateAsymptoticPValue(double d, int i5) {
        double d6 = ((double) ((i5 + 1) * i5)) / 4.0d;
        return new NormalDistribution((RandomGenerator) null, 0.0d, 1.0d).cumulativeProbability(((d - d6) - 0.5d) / FastMath.sqrt((((double) ((i5 * 2) + 1)) / 6.0d) * d6)) * 2.0d;
    }

    private double[] calculateDifferences(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[dArr.length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr3[i5] = dArr2[i5] - dArr[i5];
        }
        return dArr3;
    }

    private double calculateExactPValue(double d, int i5) {
        int i6 = 1 << i5;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i5; i10++) {
                if (((i8 >> i10) & 1) == 1) {
                    i9 += i10 + 1;
                }
            }
            if (i9 >= d) {
                i7++;
            }
        }
        return (((double) i7) * 2.0d) / ((double) i6);
    }

    private void ensureDataConformance(double[] dArr, double[] dArr2) {
        if (dArr == null || dArr2 == null) {
            throw new NullArgumentException();
        }
        if (dArr.length == 0 || dArr2.length == 0) {
            throw new NoDataException();
        }
        if (dArr2.length != dArr.length) {
            throw new DimensionMismatchException(dArr2.length, dArr.length);
        }
    }

    public double wilcoxonSignedRank(double[] dArr, double[] dArr2) {
        ensureDataConformance(dArr, dArr2);
        double[] dArrCalculateDifferences = calculateDifferences(dArr, dArr2);
        double[] dArrRank = this.naturalRanking.rank(calculateAbsoluteDifferences(dArrCalculateDifferences));
        double d = 0.0d;
        for (int i5 = 0; i5 < dArrCalculateDifferences.length; i5++) {
            if (dArrCalculateDifferences[i5] > 0.0d) {
                d += dArrRank[i5];
            }
        }
        int length = dArr.length;
        return FastMath.max(d, (((double) ((length + 1) * length)) / 2.0d) - d);
    }

    public double wilcoxonSignedRankTest(double[] dArr, double[] dArr2, boolean z6) {
        ensureDataConformance(dArr, dArr2);
        int length = dArr.length;
        double dWilcoxonSignedRank = wilcoxonSignedRank(dArr, dArr2);
        if (!z6 || length <= 30) {
            return z6 ? calculateExactPValue(dWilcoxonSignedRank, length) : calculateAsymptoticPValue((((double) ((length + 1) * length)) / 2.0d) - dWilcoxonSignedRank, length);
        }
        throw new NumberIsTooLargeException(Integer.valueOf(length), 30, true);
    }

    public WilcoxonSignedRankTest(NaNStrategy naNStrategy, TiesStrategy tiesStrategy) {
        this.naturalRanking = new NaturalRanking(naNStrategy, tiesStrategy);
    }
}
