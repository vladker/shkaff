package org.apache.commons.math3.stat.descriptive;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.VectorialCovariance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MultivariateSummaryStatistics implements StatisticalMultivariateSummary, Serializable {
    private static final long serialVersionUID = 2271900808994826718L;
    private VectorialCovariance covarianceImpl;
    private StorelessUnivariateStatistic[] geoMeanImpl;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6913k;
    private StorelessUnivariateStatistic[] maxImpl;
    private StorelessUnivariateStatistic[] meanImpl;
    private StorelessUnivariateStatistic[] minImpl;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f6914n = 0;
    private StorelessUnivariateStatistic[] sumImpl;
    private StorelessUnivariateStatistic[] sumLogImpl;
    private StorelessUnivariateStatistic[] sumSqImpl;

    public MultivariateSummaryStatistics(int i5, boolean z6) {
        this.f6913k = i5;
        this.sumImpl = new StorelessUnivariateStatistic[i5];
        this.sumSqImpl = new StorelessUnivariateStatistic[i5];
        this.minImpl = new StorelessUnivariateStatistic[i5];
        this.maxImpl = new StorelessUnivariateStatistic[i5];
        this.sumLogImpl = new StorelessUnivariateStatistic[i5];
        this.geoMeanImpl = new StorelessUnivariateStatistic[i5];
        this.meanImpl = new StorelessUnivariateStatistic[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            this.sumImpl[i6] = new Sum();
            this.sumSqImpl[i6] = new SumOfSquares();
            this.minImpl[i6] = new Min();
            this.maxImpl[i6] = new Max();
            this.sumLogImpl[i6] = new SumOfLogs();
            this.geoMeanImpl[i6] = new GeometricMean();
            this.meanImpl[i6] = new Mean();
        }
        this.covarianceImpl = new VectorialCovariance(i5, z6);
    }

    private void append(StringBuilder sb, double[] dArr, String str, String str2, String str3) {
        sb.append(str);
        for (int i5 = 0; i5 < dArr.length; i5++) {
            if (i5 > 0) {
                sb.append(str2);
            }
            sb.append(dArr[i5]);
        }
        sb.append(str3);
    }

    private void checkDimension(int i5) {
        if (i5 != this.f6913k) {
            throw new DimensionMismatchException(i5, this.f6913k);
        }
    }

    private void checkEmpty() {
        if (this.f6914n > 0) {
            throw new MathIllegalStateException(LocalizedFormats.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, Long.valueOf(this.f6914n));
        }
    }

    private double[] getResults(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        int length = storelessUnivariateStatisticArr.length;
        double[] dArr = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr[i5] = storelessUnivariateStatisticArr[i5].getResult();
        }
        return dArr;
    }

    private void setImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr, StorelessUnivariateStatistic[] storelessUnivariateStatisticArr2) {
        checkEmpty();
        checkDimension(storelessUnivariateStatisticArr.length);
        System.arraycopy(storelessUnivariateStatisticArr, 0, storelessUnivariateStatisticArr2, 0, storelessUnivariateStatisticArr.length);
    }

    public void addValue(double[] dArr) {
        checkDimension(dArr.length);
        for (int i5 = 0; i5 < this.f6913k; i5++) {
            double d = dArr[i5];
            this.sumImpl[i5].increment(d);
            this.sumSqImpl[i5].increment(d);
            this.minImpl[i5].increment(d);
            this.maxImpl[i5].increment(d);
            this.sumLogImpl[i5].increment(d);
            this.geoMeanImpl[i5].increment(d);
            this.meanImpl[i5].increment(d);
        }
        this.covarianceImpl.increment(dArr);
        this.f6914n++;
    }

    public void clear() {
        this.f6914n = 0L;
        for (int i5 = 0; i5 < this.f6913k; i5++) {
            this.minImpl[i5].clear();
            this.maxImpl[i5].clear();
            this.sumImpl[i5].clear();
            this.sumLogImpl[i5].clear();
            this.sumSqImpl[i5].clear();
            this.geoMeanImpl[i5].clear();
            this.meanImpl[i5].clear();
        }
        this.covarianceImpl.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultivariateSummaryStatistics)) {
            return false;
        }
        MultivariateSummaryStatistics multivariateSummaryStatistics = (MultivariateSummaryStatistics) obj;
        return MathArrays.equalsIncludingNaN(multivariateSummaryStatistics.getGeometricMean(), getGeometricMean()) && MathArrays.equalsIncludingNaN(multivariateSummaryStatistics.getMax(), getMax()) && MathArrays.equalsIncludingNaN(multivariateSummaryStatistics.getMean(), getMean()) && MathArrays.equalsIncludingNaN(multivariateSummaryStatistics.getMin(), getMin()) && Precision.equalsIncludingNaN((float) multivariateSummaryStatistics.getN(), (float) getN()) && MathArrays.equalsIncludingNaN(multivariateSummaryStatistics.getSum(), getSum()) && MathArrays.equalsIncludingNaN(multivariateSummaryStatistics.getSumSq(), getSumSq()) && MathArrays.equalsIncludingNaN(multivariateSummaryStatistics.getSumLog(), getSumLog()) && multivariateSummaryStatistics.getCovariance().equals(getCovariance());
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public RealMatrix getCovariance() {
        return this.covarianceImpl.getResult();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public int getDimension() {
        return this.f6913k;
    }

    public StorelessUnivariateStatistic[] getGeoMeanImpl() {
        return (StorelessUnivariateStatistic[]) this.geoMeanImpl.clone();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getGeometricMean() {
        return getResults(this.geoMeanImpl);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getMax() {
        return getResults(this.maxImpl);
    }

    public StorelessUnivariateStatistic[] getMaxImpl() {
        return (StorelessUnivariateStatistic[]) this.maxImpl.clone();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getMean() {
        return getResults(this.meanImpl);
    }

    public StorelessUnivariateStatistic[] getMeanImpl() {
        return (StorelessUnivariateStatistic[]) this.meanImpl.clone();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getMin() {
        return getResults(this.minImpl);
    }

    public StorelessUnivariateStatistic[] getMinImpl() {
        return (StorelessUnivariateStatistic[]) this.minImpl.clone();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public long getN() {
        return this.f6914n;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getStandardDeviation() {
        double[] dArr = new double[this.f6913k];
        if (getN() < 1) {
            Arrays.fill(dArr, Double.NaN);
            return dArr;
        }
        if (getN() < 2) {
            Arrays.fill(dArr, 0.0d);
            return dArr;
        }
        RealMatrix result = this.covarianceImpl.getResult();
        for (int i5 = 0; i5 < this.f6913k; i5++) {
            dArr[i5] = FastMath.sqrt(result.getEntry(i5, i5));
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getSum() {
        return getResults(this.sumImpl);
    }

    public StorelessUnivariateStatistic[] getSumImpl() {
        return (StorelessUnivariateStatistic[]) this.sumImpl.clone();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getSumLog() {
        return getResults(this.sumLogImpl);
    }

    public StorelessUnivariateStatistic[] getSumLogImpl() {
        return (StorelessUnivariateStatistic[]) this.sumLogImpl.clone();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public double[] getSumSq() {
        return getResults(this.sumSqImpl);
    }

    public StorelessUnivariateStatistic[] getSumsqImpl() {
        return (StorelessUnivariateStatistic[]) this.sumSqImpl.clone();
    }

    public int hashCode() {
        return getCovariance().hashCode() + ((MathUtils.hash(getSumLog()) + ((MathUtils.hash(getSumSq()) + ((MathUtils.hash(getSum()) + ((MathUtils.hash(getN()) + ((MathUtils.hash(getMin()) + ((MathUtils.hash(getMean()) + ((MathUtils.hash(getMax()) + ((MathUtils.hash(getGeometricMean()) + ((MathUtils.hash(getGeometricMean()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public void setGeoMeanImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        setImpl(storelessUnivariateStatisticArr, this.geoMeanImpl);
    }

    public void setMaxImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        setImpl(storelessUnivariateStatisticArr, this.maxImpl);
    }

    public void setMeanImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        setImpl(storelessUnivariateStatisticArr, this.meanImpl);
    }

    public void setMinImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        setImpl(storelessUnivariateStatisticArr, this.minImpl);
    }

    public void setSumImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        setImpl(storelessUnivariateStatisticArr, this.sumImpl);
    }

    public void setSumLogImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        setImpl(storelessUnivariateStatisticArr, this.sumLogImpl);
    }

    public void setSumsqImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        setImpl(storelessUnivariateStatisticArr, this.sumSqImpl);
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("MultivariateSummaryStatistics:" + property);
        sb.append("n: " + getN() + property);
        append(sb, getMin(), "min: ", ", ", property);
        append(sb, getMax(), "max: ", ", ", property);
        append(sb, getMean(), "mean: ", ", ", property);
        append(sb, getGeometricMean(), "geometric mean: ", ", ", property);
        append(sb, getSumSq(), "sum of squares: ", ", ", property);
        append(sb, getSumLog(), "sum of logarithms: ", ", ", property);
        append(sb, getStandardDeviation(), "standard deviation: ", ", ", property);
        sb.append("covariance: " + getCovariance().toString() + property);
        return sb.toString();
    }
}
