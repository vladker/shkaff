package org.apache.commons.math3.stat.descriptive;

import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.SecondMoment;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SummaryStatistics implements StatisticalSummary, Serializable {
    private static final long serialVersionUID = -2021321786743555871L;
    private GeometricMean geoMean;
    private StorelessUnivariateStatistic geoMeanImpl;
    private StorelessUnivariateStatistic maxImpl;
    private Mean mean;
    private StorelessUnivariateStatistic meanImpl;
    private StorelessUnivariateStatistic minImpl;
    private StorelessUnivariateStatistic sumImpl;
    private SumOfLogs sumLog;
    private StorelessUnivariateStatistic sumLogImpl;
    private StorelessUnivariateStatistic sumsqImpl;
    private Variance variance;
    private StorelessUnivariateStatistic varianceImpl;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f6916n = 0;
    private SecondMoment secondMoment = new SecondMoment();
    private Sum sum = new Sum();
    private SumOfSquares sumsq = new SumOfSquares();
    private Min min = new Min();
    private Max max = new Max();

    public SummaryStatistics() {
        SumOfLogs sumOfLogs = new SumOfLogs();
        this.sumLog = sumOfLogs;
        this.geoMean = new GeometricMean(sumOfLogs);
        this.mean = new Mean(this.secondMoment);
        Variance variance = new Variance(this.secondMoment);
        this.variance = variance;
        this.sumImpl = this.sum;
        this.sumsqImpl = this.sumsq;
        this.minImpl = this.min;
        this.maxImpl = this.max;
        this.sumLogImpl = this.sumLog;
        this.geoMeanImpl = this.geoMean;
        this.meanImpl = this.mean;
        this.varianceImpl = variance;
    }

    private void checkEmpty() {
        if (this.f6916n > 0) {
            throw new MathIllegalStateException(LocalizedFormats.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, Long.valueOf(this.f6916n));
        }
    }

    public void addValue(double d) {
        this.sumImpl.increment(d);
        this.sumsqImpl.increment(d);
        this.minImpl.increment(d);
        this.maxImpl.increment(d);
        this.sumLogImpl.increment(d);
        this.secondMoment.increment(d);
        StorelessUnivariateStatistic storelessUnivariateStatistic = this.meanImpl;
        if (storelessUnivariateStatistic != this.mean) {
            storelessUnivariateStatistic.increment(d);
        }
        StorelessUnivariateStatistic storelessUnivariateStatistic2 = this.varianceImpl;
        if (storelessUnivariateStatistic2 != this.variance) {
            storelessUnivariateStatistic2.increment(d);
        }
        StorelessUnivariateStatistic storelessUnivariateStatistic3 = this.geoMeanImpl;
        if (storelessUnivariateStatistic3 != this.geoMean) {
            storelessUnivariateStatistic3.increment(d);
        }
        this.f6916n++;
    }

    public void clear() {
        this.f6916n = 0L;
        this.minImpl.clear();
        this.maxImpl.clear();
        this.sumImpl.clear();
        this.sumLogImpl.clear();
        this.sumsqImpl.clear();
        this.geoMeanImpl.clear();
        this.secondMoment.clear();
        StorelessUnivariateStatistic storelessUnivariateStatistic = this.meanImpl;
        if (storelessUnivariateStatistic != this.mean) {
            storelessUnivariateStatistic.clear();
        }
        StorelessUnivariateStatistic storelessUnivariateStatistic2 = this.varianceImpl;
        if (storelessUnivariateStatistic2 != this.variance) {
            storelessUnivariateStatistic2.clear();
        }
    }

    public SummaryStatistics copy() {
        SummaryStatistics summaryStatistics = new SummaryStatistics();
        copy(this, summaryStatistics);
        return summaryStatistics;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SummaryStatistics)) {
            return false;
        }
        SummaryStatistics summaryStatistics = (SummaryStatistics) obj;
        return Precision.equalsIncludingNaN(summaryStatistics.getGeometricMean(), getGeometricMean()) && Precision.equalsIncludingNaN(summaryStatistics.getMax(), getMax()) && Precision.equalsIncludingNaN(summaryStatistics.getMean(), getMean()) && Precision.equalsIncludingNaN(summaryStatistics.getMin(), getMin()) && Precision.equalsIncludingNaN((float) summaryStatistics.getN(), (float) getN()) && Precision.equalsIncludingNaN(summaryStatistics.getSum(), getSum()) && Precision.equalsIncludingNaN(summaryStatistics.getSumsq(), getSumsq()) && Precision.equalsIncludingNaN(summaryStatistics.getVariance(), getVariance());
    }

    public StorelessUnivariateStatistic getGeoMeanImpl() {
        return this.geoMeanImpl;
    }

    public double getGeometricMean() {
        return this.geoMeanImpl.getResult();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMax() {
        return this.maxImpl.getResult();
    }

    public StorelessUnivariateStatistic getMaxImpl() {
        return this.maxImpl;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMean() {
        return this.meanImpl.getResult();
    }

    public StorelessUnivariateStatistic getMeanImpl() {
        return this.meanImpl;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMin() {
        return this.minImpl.getResult();
    }

    public StorelessUnivariateStatistic getMinImpl() {
        return this.minImpl;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public long getN() {
        return this.f6916n;
    }

    public double getPopulationVariance() {
        Variance variance = new Variance(this.secondMoment);
        variance.setBiasCorrected(false);
        return variance.getResult();
    }

    public double getQuadraticMean() {
        long n6 = getN();
        if (n6 > 0) {
            return FastMath.sqrt(getSumsq() / n6);
        }
        return Double.NaN;
    }

    public double getSecondMoment() {
        return this.secondMoment.getResult();
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
        return this.sumImpl.getResult();
    }

    public StorelessUnivariateStatistic getSumImpl() {
        return this.sumImpl;
    }

    public StorelessUnivariateStatistic getSumLogImpl() {
        return this.sumLogImpl;
    }

    public double getSumOfLogs() {
        return this.sumLogImpl.getResult();
    }

    public StatisticalSummary getSummary() {
        return new StatisticalSummaryValues(getMean(), getVariance(), getN(), getMax(), getMin(), getSum());
    }

    public double getSumsq() {
        return this.sumsqImpl.getResult();
    }

    public StorelessUnivariateStatistic getSumsqImpl() {
        return this.sumsqImpl;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getVariance() {
        return this.varianceImpl.getResult();
    }

    public StorelessUnivariateStatistic getVarianceImpl() {
        return this.varianceImpl;
    }

    public int hashCode() {
        return MathUtils.hash(getVariance()) + ((MathUtils.hash(getSumsq()) + ((MathUtils.hash(getSum()) + ((MathUtils.hash(getN()) + ((MathUtils.hash(getMin()) + ((MathUtils.hash(getMean()) + ((MathUtils.hash(getMax()) + ((MathUtils.hash(getGeometricMean()) + ((MathUtils.hash(getGeometricMean()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public void setGeoMeanImpl(StorelessUnivariateStatistic storelessUnivariateStatistic) {
        checkEmpty();
        this.geoMeanImpl = storelessUnivariateStatistic;
    }

    public void setMaxImpl(StorelessUnivariateStatistic storelessUnivariateStatistic) {
        checkEmpty();
        this.maxImpl = storelessUnivariateStatistic;
    }

    public void setMeanImpl(StorelessUnivariateStatistic storelessUnivariateStatistic) {
        checkEmpty();
        this.meanImpl = storelessUnivariateStatistic;
    }

    public void setMinImpl(StorelessUnivariateStatistic storelessUnivariateStatistic) {
        checkEmpty();
        this.minImpl = storelessUnivariateStatistic;
    }

    public void setSumImpl(StorelessUnivariateStatistic storelessUnivariateStatistic) {
        checkEmpty();
        this.sumImpl = storelessUnivariateStatistic;
    }

    public void setSumLogImpl(StorelessUnivariateStatistic storelessUnivariateStatistic) {
        checkEmpty();
        this.sumLogImpl = storelessUnivariateStatistic;
        this.geoMean.setSumLogImpl(storelessUnivariateStatistic);
    }

    public void setSumsqImpl(StorelessUnivariateStatistic storelessUnivariateStatistic) {
        checkEmpty();
        this.sumsqImpl = storelessUnivariateStatistic;
    }

    public void setVarianceImpl(StorelessUnivariateStatistic storelessUnivariateStatistic) {
        checkEmpty();
        this.varianceImpl = storelessUnivariateStatistic;
    }

    public String toString() {
        return "SummaryStatistics:\nn: " + getN() + "\nmin: " + getMin() + "\nmax: " + getMax() + "\nsum: " + getSum() + "\nmean: " + getMean() + "\ngeometric mean: " + getGeometricMean() + "\nvariance: " + getVariance() + "\npopulation variance: " + getPopulationVariance() + "\nsecond moment: " + getSecondMoment() + "\nsum of squares: " + getSumsq() + "\nstandard deviation: " + getStandardDeviation() + "\nsum of logs: " + getSumOfLogs() + "\n";
    }

    public static void copy(SummaryStatistics summaryStatistics, SummaryStatistics summaryStatistics2) {
        MathUtils.checkNotNull(summaryStatistics);
        MathUtils.checkNotNull(summaryStatistics2);
        summaryStatistics2.maxImpl = summaryStatistics.maxImpl.copy();
        summaryStatistics2.minImpl = summaryStatistics.minImpl.copy();
        summaryStatistics2.sumImpl = summaryStatistics.sumImpl.copy();
        summaryStatistics2.sumLogImpl = summaryStatistics.sumLogImpl.copy();
        summaryStatistics2.sumsqImpl = summaryStatistics.sumsqImpl.copy();
        summaryStatistics2.secondMoment = summaryStatistics.secondMoment.copy();
        summaryStatistics2.f6916n = summaryStatistics.f6916n;
        if (summaryStatistics.getVarianceImpl() instanceof Variance) {
            summaryStatistics2.varianceImpl = new Variance(summaryStatistics2.secondMoment);
        } else {
            summaryStatistics2.varianceImpl = summaryStatistics.varianceImpl.copy();
        }
        StorelessUnivariateStatistic storelessUnivariateStatistic = summaryStatistics.meanImpl;
        if (storelessUnivariateStatistic instanceof Mean) {
            summaryStatistics2.meanImpl = new Mean(summaryStatistics2.secondMoment);
        } else {
            summaryStatistics2.meanImpl = storelessUnivariateStatistic.copy();
        }
        if (summaryStatistics.getGeoMeanImpl() instanceof GeometricMean) {
            summaryStatistics2.geoMeanImpl = new GeometricMean((SumOfLogs) summaryStatistics2.sumLogImpl);
        } else {
            summaryStatistics2.geoMeanImpl = summaryStatistics.geoMeanImpl.copy();
        }
        GeometricMean geometricMean = summaryStatistics.geoMean;
        if (geometricMean == summaryStatistics.geoMeanImpl) {
            summaryStatistics2.geoMean = (GeometricMean) summaryStatistics2.geoMeanImpl;
        } else {
            GeometricMean.copy(geometricMean, summaryStatistics2.geoMean);
        }
        Max max = summaryStatistics.max;
        if (max == summaryStatistics.maxImpl) {
            summaryStatistics2.max = (Max) summaryStatistics2.maxImpl;
        } else {
            Max.copy(max, summaryStatistics2.max);
        }
        Mean mean = summaryStatistics.mean;
        if (mean == summaryStatistics.meanImpl) {
            summaryStatistics2.mean = (Mean) summaryStatistics2.meanImpl;
        } else {
            Mean.copy(mean, summaryStatistics2.mean);
        }
        Min min = summaryStatistics.min;
        if (min == summaryStatistics.minImpl) {
            summaryStatistics2.min = (Min) summaryStatistics2.minImpl;
        } else {
            Min.copy(min, summaryStatistics2.min);
        }
        Sum sum = summaryStatistics.sum;
        if (sum == summaryStatistics.sumImpl) {
            summaryStatistics2.sum = (Sum) summaryStatistics2.sumImpl;
        } else {
            Sum.copy(sum, summaryStatistics2.sum);
        }
        Variance variance = summaryStatistics.variance;
        if (variance == summaryStatistics.varianceImpl) {
            summaryStatistics2.variance = (Variance) summaryStatistics2.varianceImpl;
        } else {
            Variance.copy(variance, summaryStatistics2.variance);
        }
        SumOfLogs sumOfLogs = summaryStatistics.sumLog;
        if (sumOfLogs == summaryStatistics.sumLogImpl) {
            summaryStatistics2.sumLog = (SumOfLogs) summaryStatistics2.sumLogImpl;
        } else {
            SumOfLogs.copy(sumOfLogs, summaryStatistics2.sumLog);
        }
        SumOfSquares sumOfSquares = summaryStatistics.sumsq;
        if (sumOfSquares == summaryStatistics.sumsqImpl) {
            summaryStatistics2.sumsq = (SumOfSquares) summaryStatistics2.sumsqImpl;
        } else {
            SumOfSquares.copy(sumOfSquares, summaryStatistics2.sumsq);
        }
    }

    public SummaryStatistics(SummaryStatistics summaryStatistics) {
        SumOfLogs sumOfLogs = new SumOfLogs();
        this.sumLog = sumOfLogs;
        this.geoMean = new GeometricMean(sumOfLogs);
        this.mean = new Mean(this.secondMoment);
        Variance variance = new Variance(this.secondMoment);
        this.variance = variance;
        this.sumImpl = this.sum;
        this.sumsqImpl = this.sumsq;
        this.minImpl = this.min;
        this.maxImpl = this.max;
        this.sumLogImpl = this.sumLog;
        this.geoMeanImpl = this.geoMean;
        this.meanImpl = this.mean;
        this.varianceImpl = variance;
        copy(summaryStatistics, this);
    }
}
