package org.apache.commons.math3.stat;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class StatUtils {
    private static final UnivariateStatistic SUM = new Sum();
    private static final UnivariateStatistic SUM_OF_SQUARES = new SumOfSquares();
    private static final UnivariateStatistic PRODUCT = new Product();
    private static final UnivariateStatistic SUM_OF_LOGS = new SumOfLogs();
    private static final UnivariateStatistic MIN = new Min();
    private static final UnivariateStatistic MAX = new Max();
    private static final UnivariateStatistic MEAN = new Mean();
    private static final Variance VARIANCE = new Variance();
    private static final Percentile PERCENTILE = new Percentile();
    private static final GeometricMean GEOMETRIC_MEAN = new GeometricMean();

    private StatUtils() {
    }

    public static double geometricMean(double[] dArr) {
        return GEOMETRIC_MEAN.evaluate(dArr);
    }

    private static double[] getMode(double[] dArr, int i5, int i6) {
        Frequency frequency = new Frequency();
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            double d = dArr[i7];
            if (!Double.isNaN(d)) {
                frequency.addValue(Double.valueOf(d));
            }
        }
        List<Comparable<?>> mode = frequency.getMode();
        double[] dArr2 = new double[mode.size()];
        Iterator<Comparable<?>> it = mode.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            dArr2[i8] = ((Double) it.next()).doubleValue();
            i8++;
        }
        return dArr2;
    }

    public static double max(double[] dArr) {
        return MAX.evaluate(dArr);
    }

    public static double mean(double[] dArr) {
        return MEAN.evaluate(dArr);
    }

    public static double meanDifference(double[] dArr, double[] dArr2) {
        return sumDifference(dArr, dArr2) / ((double) dArr.length);
    }

    public static double min(double[] dArr) {
        return MIN.evaluate(dArr);
    }

    public static double[] mode(double[] dArr) {
        if (dArr != null) {
            return getMode(dArr, 0, dArr.length);
        }
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    public static double[] normalize(double[] dArr) {
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        for (double d : dArr) {
            descriptiveStatistics.addValue(d);
        }
        double mean = descriptiveStatistics.getMean();
        double standardDeviation = descriptiveStatistics.getStandardDeviation();
        double[] dArr2 = new double[dArr.length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr2[i5] = (dArr[i5] - mean) / standardDeviation;
        }
        return dArr2;
    }

    public static double percentile(double[] dArr, double d) {
        return PERCENTILE.evaluate(dArr, d);
    }

    public static double populationVariance(double[] dArr) {
        return new Variance(false).evaluate(dArr);
    }

    public static double product(double[] dArr) {
        return PRODUCT.evaluate(dArr);
    }

    public static double sum(double[] dArr) {
        return SUM.evaluate(dArr);
    }

    public static double sumDifference(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        if (length != dArr2.length) {
            throw new DimensionMismatchException(length, dArr2.length);
        }
        if (length <= 0) {
            throw new NoDataException(LocalizedFormats.INSUFFICIENT_DIMENSION);
        }
        double d = 0.0d;
        for (int i5 = 0; i5 < length; i5++) {
            d += dArr[i5] - dArr2[i5];
        }
        return d;
    }

    public static double sumLog(double[] dArr) {
        return SUM_OF_LOGS.evaluate(dArr);
    }

    public static double sumSq(double[] dArr) {
        return SUM_OF_SQUARES.evaluate(dArr);
    }

    public static double variance(double[] dArr) {
        return VARIANCE.evaluate(dArr);
    }

    public static double varianceDifference(double[] dArr, double[] dArr2, double d) {
        int length = dArr.length;
        if (length != dArr2.length) {
            throw new DimensionMismatchException(length, dArr2.length);
        }
        if (length < 2) {
            throw new NumberIsTooSmallException(Integer.valueOf(length), 2, true);
        }
        double d6 = 0.0d;
        double d7 = 0.0d;
        for (int i5 = 0; i5 < length; i5++) {
            double d8 = (dArr[i5] - dArr2[i5]) - d;
            d6 += d8 * d8;
            d7 += d8;
        }
        return (d6 - ((d7 * d7) / ((double) length))) / ((double) (length - 1));
    }

    public static double geometricMean(double[] dArr, int i5, int i6) {
        return GEOMETRIC_MEAN.evaluate(dArr, i5, i6);
    }

    public static double max(double[] dArr, int i5, int i6) {
        return MAX.evaluate(dArr, i5, i6);
    }

    public static double mean(double[] dArr, int i5, int i6) {
        return MEAN.evaluate(dArr, i5, i6);
    }

    public static double min(double[] dArr, int i5, int i6) {
        return MIN.evaluate(dArr, i5, i6);
    }

    public static double percentile(double[] dArr, int i5, int i6, double d) {
        return PERCENTILE.evaluate(dArr, i5, i6, d);
    }

    public static double populationVariance(double[] dArr, int i5, int i6) {
        return new Variance(false).evaluate(dArr, i5, i6);
    }

    public static double product(double[] dArr, int i5, int i6) {
        return PRODUCT.evaluate(dArr, i5, i6);
    }

    public static double sum(double[] dArr, int i5, int i6) {
        return SUM.evaluate(dArr, i5, i6);
    }

    public static double sumLog(double[] dArr, int i5, int i6) {
        return SUM_OF_LOGS.evaluate(dArr, i5, i6);
    }

    public static double sumSq(double[] dArr, int i5, int i6) {
        return SUM_OF_SQUARES.evaluate(dArr, i5, i6);
    }

    public static double variance(double[] dArr, int i5, int i6) {
        return VARIANCE.evaluate(dArr, i5, i6);
    }

    public static double[] mode(double[] dArr, int i5, int i6) {
        if (dArr == null) {
            throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
        }
        if (i5 < 0) {
            throw new NotPositiveException(LocalizedFormats.START_POSITION, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return getMode(dArr, i5, i6);
        }
        throw new NotPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(i6));
    }

    public static double populationVariance(double[] dArr, double d, int i5, int i6) {
        return new Variance(false).evaluate(dArr, d, i5, i6);
    }

    public static double variance(double[] dArr, double d, int i5, int i6) {
        return VARIANCE.evaluate(dArr, d, i5, i6);
    }

    public static double populationVariance(double[] dArr, double d) {
        return new Variance(false).evaluate(dArr, d);
    }

    public static double variance(double[] dArr, double d) {
        return VARIANCE.evaluate(dArr, d);
    }
}
