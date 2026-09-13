package org.apache.commons.math3.stat.descriptive;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Skewness;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.ResizableDoubleArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DescriptiveStatistics implements StatisticalSummary, Serializable {
    public static final int INFINITE_WINDOW = -1;
    private static final String SET_QUANTILE_METHOD_NAME = "setQuantile";
    private static final long serialVersionUID = 4133067267405273064L;
    private ResizableDoubleArray eDA;
    private UnivariateStatistic geometricMeanImpl;
    private UnivariateStatistic kurtosisImpl;
    private UnivariateStatistic maxImpl;
    private UnivariateStatistic meanImpl;
    private UnivariateStatistic minImpl;
    private UnivariateStatistic percentileImpl;
    private UnivariateStatistic skewnessImpl;
    private UnivariateStatistic sumImpl;
    private UnivariateStatistic sumsqImpl;
    private UnivariateStatistic varianceImpl;
    protected int windowSize;

    public DescriptiveStatistics() {
        this.windowSize = -1;
        this.eDA = new ResizableDoubleArray();
        this.meanImpl = new Mean();
        this.geometricMeanImpl = new GeometricMean();
        this.kurtosisImpl = new Kurtosis();
        this.maxImpl = new Max();
        this.minImpl = new Min();
        this.percentileImpl = new Percentile();
        this.skewnessImpl = new Skewness();
        this.varianceImpl = new Variance();
        this.sumsqImpl = new SumOfSquares();
        this.sumImpl = new Sum();
    }

    public void addValue(double d) {
        if (this.windowSize == -1) {
            this.eDA.addElement(d);
        } else if (getN() == this.windowSize) {
            this.eDA.addElementRolling(d);
        } else if (getN() < this.windowSize) {
            this.eDA.addElement(d);
        }
    }

    public double apply(UnivariateStatistic univariateStatistic) {
        return this.eDA.compute(univariateStatistic);
    }

    public void clear() {
        this.eDA.clear();
    }

    public DescriptiveStatistics copy() {
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        copy(this, descriptiveStatistics);
        return descriptiveStatistics;
    }

    public double getElement(int i5) {
        return this.eDA.getElement(i5);
    }

    public double getGeometricMean() {
        return apply(this.geometricMeanImpl);
    }

    public synchronized UnivariateStatistic getGeometricMeanImpl() {
        return this.geometricMeanImpl;
    }

    public double getKurtosis() {
        return apply(this.kurtosisImpl);
    }

    public synchronized UnivariateStatistic getKurtosisImpl() {
        return this.kurtosisImpl;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMax() {
        return apply(this.maxImpl);
    }

    public synchronized UnivariateStatistic getMaxImpl() {
        return this.maxImpl;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMean() {
        return apply(this.meanImpl);
    }

    public synchronized UnivariateStatistic getMeanImpl() {
        return this.meanImpl;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMin() {
        return apply(this.minImpl);
    }

    public synchronized UnivariateStatistic getMinImpl() {
        return this.minImpl;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public long getN() {
        return this.eDA.getNumElements();
    }

    public double getPercentile(double d) {
        UnivariateStatistic univariateStatistic = this.percentileImpl;
        if (univariateStatistic instanceof Percentile) {
            ((Percentile) univariateStatistic).setQuantile(d);
        } else {
            try {
                univariateStatistic.getClass().getMethod(SET_QUANTILE_METHOD_NAME, Double.TYPE).invoke(this.percentileImpl, Double.valueOf(d));
            } catch (IllegalAccessException unused) {
                throw new MathIllegalStateException(LocalizedFormats.PERCENTILE_IMPLEMENTATION_CANNOT_ACCESS_METHOD, SET_QUANTILE_METHOD_NAME, this.percentileImpl.getClass().getName());
            } catch (NoSuchMethodException unused2) {
                throw new MathIllegalStateException(LocalizedFormats.PERCENTILE_IMPLEMENTATION_UNSUPPORTED_METHOD, this.percentileImpl.getClass().getName(), SET_QUANTILE_METHOD_NAME);
            } catch (InvocationTargetException e) {
                throw new IllegalStateException(e.getCause());
            }
        }
        return apply(this.percentileImpl);
    }

    public synchronized UnivariateStatistic getPercentileImpl() {
        return this.percentileImpl;
    }

    public double getPopulationVariance() {
        return apply(new Variance(false));
    }

    public double getQuadraticMean() {
        long n6 = getN();
        if (n6 > 0) {
            return FastMath.sqrt(getSumsq() / n6);
        }
        return Double.NaN;
    }

    public double getSkewness() {
        return apply(this.skewnessImpl);
    }

    public synchronized UnivariateStatistic getSkewnessImpl() {
        return this.skewnessImpl;
    }

    public double[] getSortedValues() {
        double[] values = getValues();
        Arrays.sort(values);
        return values;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getStandardDeviation() {
        if (getN() <= 0) {
            return Double.NaN;
        }
        if (getN() > 1) {
            return FastMath.sqrt(getVariance());
        }
        return 0.0d;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getSum() {
        return apply(this.sumImpl);
    }

    public synchronized UnivariateStatistic getSumImpl() {
        return this.sumImpl;
    }

    public double getSumsq() {
        return apply(this.sumsqImpl);
    }

    public synchronized UnivariateStatistic getSumsqImpl() {
        return this.sumsqImpl;
    }

    public double[] getValues() {
        return this.eDA.getElements();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getVariance() {
        return apply(this.varianceImpl);
    }

    public synchronized UnivariateStatistic getVarianceImpl() {
        return this.varianceImpl;
    }

    public int getWindowSize() {
        return this.windowSize;
    }

    public void removeMostRecentValue() {
        try {
            this.eDA.discardMostRecentElements(1);
        } catch (MathIllegalArgumentException unused) {
            throw new MathIllegalStateException(LocalizedFormats.NO_DATA, new Object[0]);
        }
    }

    public double replaceMostRecentValue(double d) {
        return this.eDA.substituteMostRecentElement(d);
    }

    public synchronized void setGeometricMeanImpl(UnivariateStatistic univariateStatistic) {
        this.geometricMeanImpl = univariateStatistic;
    }

    public synchronized void setKurtosisImpl(UnivariateStatistic univariateStatistic) {
        this.kurtosisImpl = univariateStatistic;
    }

    public synchronized void setMaxImpl(UnivariateStatistic univariateStatistic) {
        this.maxImpl = univariateStatistic;
    }

    public synchronized void setMeanImpl(UnivariateStatistic univariateStatistic) {
        this.meanImpl = univariateStatistic;
    }

    public synchronized void setMinImpl(UnivariateStatistic univariateStatistic) {
        this.minImpl = univariateStatistic;
    }

    public synchronized void setPercentileImpl(UnivariateStatistic univariateStatistic) {
        try {
            try {
                univariateStatistic.getClass().getMethod(SET_QUANTILE_METHOD_NAME, Double.TYPE).invoke(univariateStatistic, Double.valueOf(50.0d));
                this.percentileImpl = univariateStatistic;
            } catch (NoSuchMethodException unused) {
                throw new MathIllegalArgumentException(LocalizedFormats.PERCENTILE_IMPLEMENTATION_UNSUPPORTED_METHOD, univariateStatistic.getClass().getName(), SET_QUANTILE_METHOD_NAME);
            }
        } catch (IllegalAccessException unused2) {
            throw new MathIllegalArgumentException(LocalizedFormats.PERCENTILE_IMPLEMENTATION_CANNOT_ACCESS_METHOD, SET_QUANTILE_METHOD_NAME, univariateStatistic.getClass().getName());
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException(e.getCause());
        }
    }

    public synchronized void setSkewnessImpl(UnivariateStatistic univariateStatistic) {
        this.skewnessImpl = univariateStatistic;
    }

    public synchronized void setSumImpl(UnivariateStatistic univariateStatistic) {
        this.sumImpl = univariateStatistic;
    }

    public synchronized void setSumsqImpl(UnivariateStatistic univariateStatistic) {
        this.sumsqImpl = univariateStatistic;
    }

    public synchronized void setVarianceImpl(UnivariateStatistic univariateStatistic) {
        this.varianceImpl = univariateStatistic;
    }

    public void setWindowSize(int i5) {
        if (i5 < 1 && i5 != -1) {
            throw new MathIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_WINDOW_SIZE, Integer.valueOf(i5));
        }
        this.windowSize = i5;
        if (i5 == -1 || i5 >= this.eDA.getNumElements()) {
            return;
        }
        ResizableDoubleArray resizableDoubleArray = this.eDA;
        resizableDoubleArray.discardFrontElements(resizableDoubleArray.getNumElements() - i5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DescriptiveStatistics:\nn: ");
        sb.append(getN());
        sb.append("\nmin: ");
        sb.append(getMin());
        sb.append("\nmax: ");
        sb.append(getMax());
        sb.append("\nmean: ");
        sb.append(getMean());
        sb.append("\nstd dev: ");
        sb.append(getStandardDeviation());
        sb.append("\n");
        try {
            sb.append("median: ");
            sb.append(getPercentile(50.0d));
            sb.append("\n");
        } catch (MathIllegalStateException unused) {
            sb.append("median: unavailable\n");
        }
        sb.append("skewness: ");
        sb.append(getSkewness());
        sb.append("\nkurtosis: ");
        sb.append(getKurtosis());
        sb.append("\n");
        return sb.toString();
    }

    public static void copy(DescriptiveStatistics descriptiveStatistics, DescriptiveStatistics descriptiveStatistics2) {
        MathUtils.checkNotNull(descriptiveStatistics);
        MathUtils.checkNotNull(descriptiveStatistics2);
        descriptiveStatistics2.eDA = descriptiveStatistics.eDA.copy();
        descriptiveStatistics2.windowSize = descriptiveStatistics.windowSize;
        descriptiveStatistics2.maxImpl = descriptiveStatistics.maxImpl.copy();
        descriptiveStatistics2.meanImpl = descriptiveStatistics.meanImpl.copy();
        descriptiveStatistics2.minImpl = descriptiveStatistics.minImpl.copy();
        descriptiveStatistics2.sumImpl = descriptiveStatistics.sumImpl.copy();
        descriptiveStatistics2.varianceImpl = descriptiveStatistics.varianceImpl.copy();
        descriptiveStatistics2.sumsqImpl = descriptiveStatistics.sumsqImpl.copy();
        descriptiveStatistics2.geometricMeanImpl = descriptiveStatistics.geometricMeanImpl.copy();
        descriptiveStatistics2.kurtosisImpl = descriptiveStatistics.kurtosisImpl;
        descriptiveStatistics2.skewnessImpl = descriptiveStatistics.skewnessImpl;
        descriptiveStatistics2.percentileImpl = descriptiveStatistics.percentileImpl;
    }

    public DescriptiveStatistics(int i5) {
        this.windowSize = -1;
        this.eDA = new ResizableDoubleArray();
        this.meanImpl = new Mean();
        this.geometricMeanImpl = new GeometricMean();
        this.kurtosisImpl = new Kurtosis();
        this.maxImpl = new Max();
        this.minImpl = new Min();
        this.percentileImpl = new Percentile();
        this.skewnessImpl = new Skewness();
        this.varianceImpl = new Variance();
        this.sumsqImpl = new SumOfSquares();
        this.sumImpl = new Sum();
        setWindowSize(i5);
    }

    public DescriptiveStatistics(double[] dArr) {
        this.windowSize = -1;
        this.eDA = new ResizableDoubleArray();
        this.meanImpl = new Mean();
        this.geometricMeanImpl = new GeometricMean();
        this.kurtosisImpl = new Kurtosis();
        this.maxImpl = new Max();
        this.minImpl = new Min();
        this.percentileImpl = new Percentile();
        this.skewnessImpl = new Skewness();
        this.varianceImpl = new Variance();
        this.sumsqImpl = new SumOfSquares();
        this.sumImpl = new Sum();
        if (dArr != null) {
            this.eDA = new ResizableDoubleArray(dArr);
        }
    }

    public DescriptiveStatistics(DescriptiveStatistics descriptiveStatistics) {
        this.windowSize = -1;
        this.eDA = new ResizableDoubleArray();
        this.meanImpl = new Mean();
        this.geometricMeanImpl = new GeometricMean();
        this.kurtosisImpl = new Kurtosis();
        this.maxImpl = new Max();
        this.minImpl = new Min();
        this.percentileImpl = new Percentile();
        this.skewnessImpl = new Skewness();
        this.varianceImpl = new Variance();
        this.sumsqImpl = new SumOfSquares();
        this.sumImpl = new Sum();
        copy(descriptiveStatistics, this);
    }
}
