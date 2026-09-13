package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SynchronizedMultivariateSummaryStatistics extends MultivariateSummaryStatistics {
    private static final long serialVersionUID = 7099834153347155363L;

    public SynchronizedMultivariateSummaryStatistics(int i5, boolean z6) {
        super(i5, z6);
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void addValue(double[] dArr) {
        super.addValue(dArr);
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void clear() {
        super.clear();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public synchronized RealMatrix getCovariance() {
        return super.getCovariance();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public synchronized int getDimension() {
        return super.getDimension();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getGeoMeanImpl() {
        return super.getGeoMeanImpl();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getGeometricMean() {
        return super.getGeometricMean();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getMax() {
        return super.getMax();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getMaxImpl() {
        return super.getMaxImpl();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getMean() {
        return super.getMean();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getMeanImpl() {
        return super.getMeanImpl();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getMin() {
        return super.getMin();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getMinImpl() {
        return super.getMinImpl();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public synchronized long getN() {
        return super.getN();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getStandardDeviation() {
        return super.getStandardDeviation();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getSum() {
        return super.getSum();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getSumImpl() {
        return super.getSumImpl();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getSumLog() {
        return super.getSumLog();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getSumLogImpl() {
        return super.getSumLogImpl();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics, org.apache.commons.math3.stat.descriptive.StatisticalMultivariateSummary
    public synchronized double[] getSumSq() {
        return super.getSumSq();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized StorelessUnivariateStatistic[] getSumsqImpl() {
        return super.getSumsqImpl();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized int hashCode() {
        return super.hashCode();
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setGeoMeanImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        super.setGeoMeanImpl(storelessUnivariateStatisticArr);
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setMaxImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        super.setMaxImpl(storelessUnivariateStatisticArr);
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setMeanImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        super.setMeanImpl(storelessUnivariateStatisticArr);
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setMinImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        super.setMinImpl(storelessUnivariateStatisticArr);
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setSumImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        super.setSumImpl(storelessUnivariateStatisticArr);
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setSumLogImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        super.setSumLogImpl(storelessUnivariateStatisticArr);
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized void setSumsqImpl(StorelessUnivariateStatistic[] storelessUnivariateStatisticArr) {
        super.setSumsqImpl(storelessUnivariateStatisticArr);
    }

    @Override // org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics
    public synchronized String toString() {
        return super.toString();
    }
}
