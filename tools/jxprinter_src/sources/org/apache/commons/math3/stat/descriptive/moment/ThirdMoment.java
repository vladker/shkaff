package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class ThirdMoment extends SecondMoment implements Serializable {
    private static final long serialVersionUID = -7818711964045118679L;

    /* JADX INFO: renamed from: m3, reason: collision with root package name */
    protected double f6922m3;
    protected double nDevSq;

    public ThirdMoment() {
        this.f6922m3 = Double.NaN;
        this.nDevSq = Double.NaN;
    }

    @Override // org.apache.commons.math3.stat.descriptive.moment.SecondMoment, org.apache.commons.math3.stat.descriptive.moment.FirstMoment, org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        super.clear();
        this.f6922m3 = Double.NaN;
        this.nDevSq = Double.NaN;
    }

    @Override // org.apache.commons.math3.stat.descriptive.moment.SecondMoment, org.apache.commons.math3.stat.descriptive.moment.FirstMoment, org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        return this.f6922m3;
    }

    @Override // org.apache.commons.math3.stat.descriptive.moment.SecondMoment, org.apache.commons.math3.stat.descriptive.moment.FirstMoment, org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        if (this.f6919n < 1) {
            this.f6918m1 = 0.0d;
            this.f6921m2 = 0.0d;
            this.f6922m3 = 0.0d;
        }
        double d6 = this.f6921m2;
        super.increment(d);
        double d7 = this.nDev;
        double d8 = d7 * d7;
        this.nDevSq = d8;
        double d9 = this.f6919n;
        this.f6922m3 = ((d9 - 2.0d) * (d9 - 1.0d) * d8 * this.f6917dev) + (this.f6922m3 - ((d7 * 3.0d) * d6));
    }

    public ThirdMoment(ThirdMoment thirdMoment) {
        copy(thirdMoment, this);
    }

    @Override // org.apache.commons.math3.stat.descriptive.moment.SecondMoment, org.apache.commons.math3.stat.descriptive.moment.FirstMoment, org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public ThirdMoment copy() {
        ThirdMoment thirdMoment = new ThirdMoment();
        copy(this, thirdMoment);
        return thirdMoment;
    }

    public static void copy(ThirdMoment thirdMoment, ThirdMoment thirdMoment2) {
        MathUtils.checkNotNull(thirdMoment);
        MathUtils.checkNotNull(thirdMoment2);
        SecondMoment.copy((SecondMoment) thirdMoment, (SecondMoment) thirdMoment2);
        thirdMoment2.f6922m3 = thirdMoment.f6922m3;
        thirdMoment2.nDevSq = thirdMoment.nDevSq;
    }
}
