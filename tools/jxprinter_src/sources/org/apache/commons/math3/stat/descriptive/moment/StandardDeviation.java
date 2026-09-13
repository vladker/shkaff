package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StandardDeviation extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 5728716329662425188L;
    private Variance variance;

    public StandardDeviation() {
        this.variance = null;
        this.variance = new Variance();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        this.variance.clear();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr) {
        return FastMath.sqrt(this.variance.evaluate(dArr));
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.variance.getN();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        return FastMath.sqrt(this.variance.getResult());
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        this.variance.increment(d);
    }

    public boolean isBiasCorrected() {
        return this.variance.isBiasCorrected();
    }

    public void setBiasCorrected(boolean z6) {
        this.variance.setBiasCorrected(z6);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr, int i5, int i6) {
        return FastMath.sqrt(this.variance.evaluate(dArr, i5, i6));
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public StandardDeviation copy() {
        StandardDeviation standardDeviation = new StandardDeviation();
        copy(this, standardDeviation);
        return standardDeviation;
    }

    public double evaluate(double[] dArr, double d, int i5, int i6) {
        return FastMath.sqrt(this.variance.evaluate(dArr, d, i5, i6));
    }

    public StandardDeviation(SecondMoment secondMoment) {
        this.variance = null;
        this.variance = new Variance(secondMoment);
    }

    public double evaluate(double[] dArr, double d) {
        return FastMath.sqrt(this.variance.evaluate(dArr, d));
    }

    public static void copy(StandardDeviation standardDeviation, StandardDeviation standardDeviation2) {
        MathUtils.checkNotNull(standardDeviation);
        MathUtils.checkNotNull(standardDeviation2);
        standardDeviation2.setData(standardDeviation.getDataRef());
        standardDeviation2.variance = standardDeviation.variance.copy();
    }

    public StandardDeviation(StandardDeviation standardDeviation) {
        this.variance = null;
        copy(standardDeviation, this);
    }

    public StandardDeviation(boolean z6) {
        this.variance = null;
        this.variance = new Variance(z6);
    }

    public StandardDeviation(boolean z6, SecondMoment secondMoment) {
        this.variance = null;
        this.variance = new Variance(z6, secondMoment);
    }
}
