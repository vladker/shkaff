package org.apache.commons.math3.stat.inference;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.commons.math3.stat.ranking.NaturalRanking;
import org.apache.commons.math3.stat.ranking.TiesStrategy;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MannWhitneyUTest {
    private NaturalRanking naturalRanking;

    public MannWhitneyUTest() {
        this.naturalRanking = new NaturalRanking(NaNStrategy.FIXED, TiesStrategy.AVERAGE);
    }

    private double calculateAsymptoticPValue(double d, int i5, int i6) {
        long j6 = ((long) i5) * ((long) i6);
        return new NormalDistribution((RandomGenerator) null, 0.0d, 1.0d).cumulativeProbability((d - (j6 / 2.0d)) / FastMath.sqrt((j6 * ((long) ((i5 + i6) + 1))) / 12.0d)) * 2.0d;
    }

    private double[] concatenateSamples(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[dArr.length + dArr2.length];
        System.arraycopy(dArr, 0, dArr3, 0, dArr.length);
        System.arraycopy(dArr2, 0, dArr3, dArr.length, dArr2.length);
        return dArr3;
    }

    private void ensureDataConformance(double[] dArr, double[] dArr2) {
        if (dArr == null || dArr2 == null) {
            throw new NullArgumentException();
        }
        if (dArr.length == 0 || dArr2.length == 0) {
            throw new NoDataException();
        }
    }

    public double mannWhitneyU(double[] dArr, double[] dArr2) {
        ensureDataConformance(dArr, dArr2);
        double[] dArrRank = this.naturalRanking.rank(concatenateSamples(dArr, dArr2));
        double d = 0.0d;
        for (int i5 = 0; i5 < dArr.length; i5++) {
            d += dArrRank[i5];
        }
        double length = d - ((((long) dArr.length) * ((long) (dArr.length + 1))) / 2);
        return FastMath.max(length, (((long) dArr.length) * ((long) dArr2.length)) - length);
    }

    public double mannWhitneyUTest(double[] dArr, double[] dArr2) {
        ensureDataConformance(dArr, dArr2);
        return calculateAsymptoticPValue((((long) dArr.length) * ((long) dArr2.length)) - mannWhitneyU(dArr, dArr2), dArr.length, dArr2.length);
    }

    public MannWhitneyUTest(NaNStrategy naNStrategy, TiesStrategy tiesStrategy) {
        this.naturalRanking = new NaturalRanking(naNStrategy, tiesStrategy);
    }
}
