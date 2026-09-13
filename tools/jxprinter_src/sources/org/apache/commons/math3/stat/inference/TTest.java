package org.apache.commons.math3.stat.inference;

import androidx.collection.a;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TTest {
    private void checkSampleData(double[] dArr) {
        if (dArr == null) {
            throw new NullArgumentException();
        }
        if (dArr.length < 2) {
            throw new NumberIsTooSmallException(LocalizedFormats.INSUFFICIENT_DATA_FOR_T_STATISTIC, Integer.valueOf(dArr.length), 2, true);
        }
    }

    private void checkSignificanceLevel(double d) {
        if (d <= 0.0d || d > 0.5d) {
            throw new OutOfRangeException(LocalizedFormats.SIGNIFICANCE_LEVEL, Double.valueOf(d), Double.valueOf(0.0d), Double.valueOf(0.5d));
        }
    }

    public double df(double d, double d6, double d7, double d8) {
        double d9 = (d6 / d8) + (d / d7);
        return (d9 * d9) / (((d6 * d6) / ((d8 - 1.0d) * (d8 * d8))) + ((d * d) / ((d7 - 1.0d) * (d7 * d7))));
    }

    public double homoscedasticT(double[] dArr, double[] dArr2) {
        checkSampleData(dArr);
        checkSampleData(dArr2);
        return homoscedasticT(StatUtils.mean(dArr), StatUtils.mean(dArr2), StatUtils.variance(dArr), StatUtils.variance(dArr2), dArr.length, dArr2.length);
    }

    public double homoscedasticTTest(double[] dArr, double[] dArr2) {
        checkSampleData(dArr);
        checkSampleData(dArr2);
        return homoscedasticTTest(StatUtils.mean(dArr), StatUtils.mean(dArr2), StatUtils.variance(dArr), StatUtils.variance(dArr2), dArr.length, dArr2.length);
    }

    public double pairedT(double[] dArr, double[] dArr2) {
        checkSampleData(dArr);
        checkSampleData(dArr2);
        double dMeanDifference = StatUtils.meanDifference(dArr, dArr2);
        return t(dMeanDifference, 0.0d, StatUtils.varianceDifference(dArr, dArr2, dMeanDifference), dArr.length);
    }

    public double pairedTTest(double[] dArr, double[] dArr2) {
        double dMeanDifference = StatUtils.meanDifference(dArr, dArr2);
        return tTest(dMeanDifference, 0.0d, StatUtils.varianceDifference(dArr, dArr2, dMeanDifference), dArr.length);
    }

    public double t(double d, double[] dArr) {
        checkSampleData(dArr);
        return t(StatUtils.mean(dArr), d, StatUtils.variance(dArr), dArr.length);
    }

    public double tTest(double d, double[] dArr) {
        checkSampleData(dArr);
        return tTest(StatUtils.mean(dArr), d, StatUtils.variance(dArr), dArr.length);
    }

    public boolean pairedTTest(double[] dArr, double[] dArr2, double d) {
        checkSignificanceLevel(d);
        return pairedTTest(dArr, dArr2) < d;
    }

    public double t(double d, StatisticalSummary statisticalSummary) {
        checkSampleData(statisticalSummary);
        return t(statisticalSummary.getMean(), d, statisticalSummary.getVariance(), statisticalSummary.getN());
    }

    public boolean tTest(double d, double[] dArr, double d6) {
        checkSignificanceLevel(d6);
        return tTest(d, dArr) < d6;
    }

    private void checkSampleData(StatisticalSummary statisticalSummary) {
        if (statisticalSummary == null) {
            throw new NullArgumentException();
        }
        if (statisticalSummary.getN() < 2) {
            throw new NumberIsTooSmallException(LocalizedFormats.INSUFFICIENT_DATA_FOR_T_STATISTIC, Long.valueOf(statisticalSummary.getN()), 2, true);
        }
    }

    public double homoscedasticT(StatisticalSummary statisticalSummary, StatisticalSummary statisticalSummary2) {
        checkSampleData(statisticalSummary);
        checkSampleData(statisticalSummary2);
        return homoscedasticT(statisticalSummary.getMean(), statisticalSummary2.getMean(), statisticalSummary.getVariance(), statisticalSummary2.getVariance(), statisticalSummary.getN(), statisticalSummary2.getN());
    }

    public boolean homoscedasticTTest(double[] dArr, double[] dArr2, double d) {
        checkSignificanceLevel(d);
        return homoscedasticTTest(dArr, dArr2) < d;
    }

    public double t(double[] dArr, double[] dArr2) {
        checkSampleData(dArr);
        checkSampleData(dArr2);
        return t(StatUtils.mean(dArr), StatUtils.mean(dArr2), StatUtils.variance(dArr), StatUtils.variance(dArr2), dArr.length, dArr2.length);
    }

    public double tTest(double d, StatisticalSummary statisticalSummary) {
        checkSampleData(statisticalSummary);
        return tTest(statisticalSummary.getMean(), d, statisticalSummary.getVariance(), statisticalSummary.getN());
    }

    public double homoscedasticTTest(StatisticalSummary statisticalSummary, StatisticalSummary statisticalSummary2) {
        checkSampleData(statisticalSummary);
        checkSampleData(statisticalSummary2);
        return homoscedasticTTest(statisticalSummary.getMean(), statisticalSummary2.getMean(), statisticalSummary.getVariance(), statisticalSummary2.getVariance(), statisticalSummary.getN(), statisticalSummary2.getN());
    }

    public double homoscedasticT(double d, double d6, double d7, double d8, double d9, double d10) {
        return (d - d6) / FastMath.sqrt(((1.0d / d10) + (1.0d / d9)) * (a.a(d10, 1.0d, d8, (d9 - 1.0d) * d7) / ((d9 + d10) - 2.0d)));
    }

    public boolean tTest(double d, StatisticalSummary statisticalSummary, double d6) {
        checkSignificanceLevel(d6);
        return tTest(d, statisticalSummary) < d6;
    }

    public double t(StatisticalSummary statisticalSummary, StatisticalSummary statisticalSummary2) {
        checkSampleData(statisticalSummary);
        checkSampleData(statisticalSummary2);
        return t(statisticalSummary.getMean(), statisticalSummary2.getMean(), statisticalSummary.getVariance(), statisticalSummary2.getVariance(), statisticalSummary.getN(), statisticalSummary2.getN());
    }

    public double homoscedasticTTest(double d, double d6, double d7, double d8, double d9, double d10) {
        return new TDistribution((RandomGenerator) null, (d9 + d10) - 2.0d).cumulativeProbability(-FastMath.abs(homoscedasticT(d, d6, d7, d8, d9, d10))) * 2.0d;
    }

    public double tTest(double[] dArr, double[] dArr2) {
        checkSampleData(dArr);
        checkSampleData(dArr2);
        return tTest(StatUtils.mean(dArr), StatUtils.mean(dArr2), StatUtils.variance(dArr), StatUtils.variance(dArr2), dArr.length, dArr2.length);
    }

    public double t(double d, double d6, double d7, double d8) {
        return (d - d6) / FastMath.sqrt(d7 / d8);
    }

    public double t(double d, double d6, double d7, double d8, double d9, double d10) {
        return (d - d6) / FastMath.sqrt((d8 / d10) + (d7 / d9));
    }

    public boolean tTest(double[] dArr, double[] dArr2, double d) {
        checkSignificanceLevel(d);
        return tTest(dArr, dArr2) < d;
    }

    public double tTest(StatisticalSummary statisticalSummary, StatisticalSummary statisticalSummary2) {
        checkSampleData(statisticalSummary);
        checkSampleData(statisticalSummary2);
        return tTest(statisticalSummary.getMean(), statisticalSummary2.getMean(), statisticalSummary.getVariance(), statisticalSummary2.getVariance(), statisticalSummary.getN(), statisticalSummary2.getN());
    }

    public boolean tTest(StatisticalSummary statisticalSummary, StatisticalSummary statisticalSummary2, double d) {
        checkSignificanceLevel(d);
        return tTest(statisticalSummary, statisticalSummary2) < d;
    }

    public double tTest(double d, double d6, double d7, double d8) {
        return new TDistribution((RandomGenerator) null, d8 - 1.0d).cumulativeProbability(-FastMath.abs(t(d, d6, d7, d8))) * 2.0d;
    }

    public double tTest(double d, double d6, double d7, double d8, double d9, double d10) {
        return new TDistribution((RandomGenerator) null, df(d7, d8, d9, d10)).cumulativeProbability(-FastMath.abs(t(d, d6, d7, d8, d9, d10))) * 2.0d;
    }
}
