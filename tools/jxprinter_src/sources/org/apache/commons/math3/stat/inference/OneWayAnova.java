package org.apache.commons.math3.stat.inference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OneWayAnova {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AnovaStats {

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        private final double f6931F;
        private final int dfbg;
        private final int dfwg;

        private AnovaStats(int i5, int i6, double d) {
            this.dfbg = i5;
            this.dfwg = i6;
            this.f6931F = d;
        }
    }

    private AnovaStats anovaStats(Collection<double[]> collection) {
        MathUtils.checkNotNull(collection);
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<double[]> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                return anovaStats(arrayList, false);
            }
            double[] next = it.next();
            SummaryStatistics summaryStatistics = new SummaryStatistics();
            arrayList.add(summaryStatistics);
            for (double d : next) {
                summaryStatistics.addValue(d);
            }
        }
    }

    public double anovaFValue(Collection<double[]> collection) {
        return anovaStats(collection).f6931F;
    }

    public double anovaPValue(Collection<double[]> collection) {
        AnovaStats anovaStats = anovaStats(collection);
        return 1.0d - new FDistribution((RandomGenerator) null, anovaStats.dfbg, anovaStats.dfwg).cumulativeProbability(anovaStats.f6931F);
    }

    public boolean anovaTest(Collection<double[]> collection, double d) {
        if (d <= 0.0d || d > 0.5d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(d), 0, Double.valueOf(0.5d));
        }
        return anovaPValue(collection) < d;
    }

    public double anovaPValue(Collection<SummaryStatistics> collection, boolean z6) {
        AnovaStats anovaStats = anovaStats(collection, z6);
        return 1.0d - new FDistribution((RandomGenerator) null, anovaStats.dfbg, anovaStats.dfwg).cumulativeProbability(anovaStats.f6931F);
    }

    private AnovaStats anovaStats(Collection<SummaryStatistics> collection, boolean z6) {
        MathUtils.checkNotNull(collection);
        if (!z6) {
            if (collection.size() >= 2) {
                for (SummaryStatistics summaryStatistics : collection) {
                    if (summaryStatistics.getN() <= 1) {
                        throw new DimensionMismatchException(LocalizedFormats.TWO_OR_MORE_VALUES_IN_CATEGORY_REQUIRED, (int) summaryStatistics.getN(), 2);
                    }
                }
            } else {
                throw new DimensionMismatchException(LocalizedFormats.TWO_OR_MORE_CATEGORIES_REQUIRED, collection.size(), 2);
            }
        }
        int i5 = 0;
        double d = 0.0d;
        int i6 = 0;
        double d6 = 0.0d;
        double d7 = 0.0d;
        for (SummaryStatistics summaryStatistics2 : collection) {
            double sum = summaryStatistics2.getSum();
            double sumsq = summaryStatistics2.getSumsq();
            int n6 = (int) summaryStatistics2.getN();
            i5 += n6;
            d6 += sum;
            d += sumsq;
            i6 += n6 - 1;
            d7 += sumsq - ((sum * sum) / ((double) n6));
        }
        double d8 = (d - ((d6 * d6) / ((double) i5))) - d7;
        int size = collection.size() - 1;
        return new AnovaStats(size, i6, (d8 / ((double) size)) / (d7 / ((double) i6)));
    }
}
