package org.apache.commons.math3.stat.descriptive.moment;

import androidx.collection.a;
import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Skewness extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 7101857578996691352L;
    protected boolean incMoment;
    protected ThirdMoment moment;

    public Skewness() {
        this.moment = null;
        this.incMoment = true;
        this.moment = new ThirdMoment();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        if (this.incMoment) {
            this.moment.clear();
        }
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr, int i5, int i6) {
        int i7;
        int i8 = i5;
        if (!test(dArr, i5, i6) || i6 <= 2) {
            return Double.NaN;
        }
        double dEvaluate = new Mean().evaluate(dArr, i8, i6);
        int i9 = i8;
        double d = 0.0d;
        double d6 = 0.0d;
        while (true) {
            i7 = i8 + i6;
            if (i9 >= i7) {
                break;
            }
            double d7 = dArr[i9] - dEvaluate;
            d += d7 * d7;
            d6 += d7;
            i9++;
        }
        double d8 = i6;
        double d9 = (d - ((d6 * d6) / d8)) / ((double) (i6 - 1));
        double dC = 0.0d;
        while (i8 < i7) {
            double d10 = dArr[i8] - dEvaluate;
            dC = a.C(d10, d10, d10, dC);
            i8++;
        }
        return (d8 / ((d8 - 2.0d) * (d8 - 1.0d))) * (dC / (FastMath.sqrt(d9) * d9));
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.moment.getN();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        ThirdMoment thirdMoment = this.moment;
        long j6 = thirdMoment.f6919n;
        if (j6 < 3) {
            return Double.NaN;
        }
        double d = thirdMoment.f6921m2 / (j6 - 1);
        if (d < 1.0E-19d) {
            return 0.0d;
        }
        double n6 = thirdMoment.getN();
        return (this.moment.f6922m3 * n6) / ((FastMath.sqrt(d) * ((n6 - 2.0d) * (n6 - 1.0d))) * d);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        if (this.incMoment) {
            this.moment.increment(d);
        }
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public Skewness copy() {
        Skewness skewness = new Skewness();
        copy(this, skewness);
        return skewness;
    }

    public Skewness(ThirdMoment thirdMoment) {
        this.incMoment = false;
        this.moment = thirdMoment;
    }

    public static void copy(Skewness skewness, Skewness skewness2) {
        MathUtils.checkNotNull(skewness);
        MathUtils.checkNotNull(skewness2);
        skewness2.setData(skewness.getDataRef());
        skewness2.moment = new ThirdMoment(skewness.moment.copy());
        skewness2.incMoment = skewness.incMoment;
    }

    public Skewness(Skewness skewness) {
        this.moment = null;
        copy(skewness, this);
    }
}
