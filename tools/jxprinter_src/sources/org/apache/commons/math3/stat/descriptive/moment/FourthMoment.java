package org.apache.commons.math3.stat.descriptive.moment;

import androidx.collection.a;
import java.io.Serializable;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class FourthMoment extends ThirdMoment implements Serializable {
    private static final long serialVersionUID = 4763990447117157611L;

    /* JADX INFO: renamed from: m4, reason: collision with root package name */
    private double f6920m4;

    public FourthMoment() {
        this.f6920m4 = Double.NaN;
    }

    @Override // org.apache.commons.math3.stat.descriptive.moment.ThirdMoment, org.apache.commons.math3.stat.descriptive.moment.SecondMoment, org.apache.commons.math3.stat.descriptive.moment.FirstMoment, org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        super.clear();
        this.f6920m4 = Double.NaN;
    }

    @Override // org.apache.commons.math3.stat.descriptive.moment.ThirdMoment, org.apache.commons.math3.stat.descriptive.moment.SecondMoment, org.apache.commons.math3.stat.descriptive.moment.FirstMoment, org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        return this.f6920m4;
    }

    @Override // org.apache.commons.math3.stat.descriptive.moment.ThirdMoment, org.apache.commons.math3.stat.descriptive.moment.SecondMoment, org.apache.commons.math3.stat.descriptive.moment.FirstMoment, org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        if (this.f6919n < 1) {
            this.f6920m4 = 0.0d;
            this.f6922m3 = 0.0d;
            this.f6921m2 = 0.0d;
            this.f6918m1 = 0.0d;
        }
        double d6 = this.f6922m3;
        double d7 = this.f6921m2;
        super.increment(d);
        double d8 = this.f6919n;
        double d9 = this.f6920m4 - ((this.nDev * 4.0d) * d6);
        double d10 = this.nDevSq;
        double dC = a.C(d10, 6.0d, d7, d9);
        double d11 = d8 - 1.0d;
        this.f6920m4 = (d10 * d10 * d11 * d8 * ((d8 * d8) - (3.0d * d11))) + dC;
    }

    public FourthMoment(FourthMoment fourthMoment) {
        copy(fourthMoment, this);
    }

    @Override // org.apache.commons.math3.stat.descriptive.moment.ThirdMoment, org.apache.commons.math3.stat.descriptive.moment.SecondMoment, org.apache.commons.math3.stat.descriptive.moment.FirstMoment, org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public FourthMoment copy() {
        FourthMoment fourthMoment = new FourthMoment();
        copy(this, fourthMoment);
        return fourthMoment;
    }

    public static void copy(FourthMoment fourthMoment, FourthMoment fourthMoment2) {
        MathUtils.checkNotNull(fourthMoment);
        MathUtils.checkNotNull(fourthMoment2);
        ThirdMoment.copy((ThirdMoment) fourthMoment, (ThirdMoment) fourthMoment2);
        fourthMoment2.f6920m4 = fourthMoment.f6920m4;
    }
}
