package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Kurtosis extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 2784465764798260919L;
    protected boolean incMoment;
    protected FourthMoment moment;

    public Kurtosis() {
        this.incMoment = true;
        this.moment = new FourthMoment();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        if (this.incMoment) {
            this.moment.clear();
        }
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr, int i5, int i6) {
        if (!test(dArr, i5, i6) || i6 <= 3) {
            return Double.NaN;
        }
        Variance variance = new Variance();
        variance.incrementAll(dArr, i5, i6);
        double d = variance.moment.f6918m1;
        double dSqrt = FastMath.sqrt(variance.getResult());
        double dPow = 0.0d;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            dPow += FastMath.pow(dArr[i7] - d, 4.0d);
        }
        double d6 = i6;
        double d7 = (d6 + 1.0d) * d6;
        double d8 = d6 - 1.0d;
        double d9 = d6 - 2.0d;
        double d10 = d6 - 3.0d;
        return ((d7 / ((d8 * d9) * d10)) * (dPow / FastMath.pow(dSqrt, 4.0d))) - ((FastMath.pow(d8, 2.0d) * 3.0d) / (d9 * d10));
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.moment.getN();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        if (this.moment.getN() <= 3) {
            return Double.NaN;
        }
        FourthMoment fourthMoment = this.moment;
        double d = fourthMoment.f6921m2;
        long j6 = fourthMoment.f6919n;
        double d6 = d / (j6 - 1);
        if (j6 <= 3 || d6 < 1.0E-19d) {
            return 0.0d;
        }
        double d7 = j6;
        double result = (d7 + 1.0d) * d7 * fourthMoment.getResult();
        double d8 = this.moment.f6921m2;
        double d9 = d7 - 1.0d;
        return (result - (((d8 * 3.0d) * d8) * d9)) / ((((d7 - 3.0d) * ((d7 - 2.0d) * d9)) * d6) * d6);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        if (this.incMoment) {
            this.moment.increment(d);
        }
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public Kurtosis copy() {
        Kurtosis kurtosis = new Kurtosis();
        copy(this, kurtosis);
        return kurtosis;
    }

    public Kurtosis(FourthMoment fourthMoment) {
        this.incMoment = false;
        this.moment = fourthMoment;
    }

    public static void copy(Kurtosis kurtosis, Kurtosis kurtosis2) {
        MathUtils.checkNotNull(kurtosis);
        MathUtils.checkNotNull(kurtosis2);
        kurtosis2.setData(kurtosis.getDataRef());
        kurtosis2.moment = kurtosis.moment.copy();
        kurtosis2.incMoment = kurtosis.incMoment;
    }

    public Kurtosis(Kurtosis kurtosis) {
        copy(kurtosis, this);
    }
}
