package org.apache.commons.math3.stat.descriptive.moment;

import androidx.collection.a;
import java.io.Serializable;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.WeightedEvaluation;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Variance extends AbstractStorelessUnivariateStatistic implements Serializable, WeightedEvaluation {
    private static final long serialVersionUID = -9111962718267217978L;
    protected boolean incMoment;
    private boolean isBiasCorrected;
    protected SecondMoment moment;

    public Variance() {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
        this.moment = new SecondMoment();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        if (this.incMoment) {
            this.moment.clear();
        }
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr) {
        if (dArr != null) {
            return evaluate(dArr, 0, dArr.length);
        }
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.moment.getN();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        double d;
        double d6;
        SecondMoment secondMoment = this.moment;
        long j6 = secondMoment.f6919n;
        if (j6 == 0) {
            return Double.NaN;
        }
        if (j6 == 1) {
            return 0.0d;
        }
        if (this.isBiasCorrected) {
            d = secondMoment.f6921m2;
            d6 = j6 - 1.0d;
        } else {
            d = secondMoment.f6921m2;
            d6 = j6;
        }
        return d / d6;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        if (this.incMoment) {
            this.moment.increment(d);
        }
    }

    public boolean isBiasCorrected() {
        return this.isBiasCorrected;
    }

    public void setBiasCorrected(boolean z6) {
        this.isBiasCorrected = z6;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public Variance copy() {
        Variance variance = new Variance();
        copy(this, variance);
        return variance;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr, int i5, int i6) {
        if (!test(dArr, i5, i6)) {
            return Double.NaN;
        }
        clear();
        if (i6 == 1) {
            return 0.0d;
        }
        if (i6 > 1) {
            return evaluate(dArr, new Mean().evaluate(dArr, i5, i6), i5, i6);
        }
        return Double.NaN;
    }

    public static void copy(Variance variance, Variance variance2) {
        MathUtils.checkNotNull(variance);
        MathUtils.checkNotNull(variance2);
        variance2.setData(variance.getDataRef());
        variance2.moment = variance.moment.copy();
        variance2.isBiasCorrected = variance.isBiasCorrected;
        variance2.incMoment = variance.incMoment;
    }

    public Variance(SecondMoment secondMoment) {
        this.isBiasCorrected = true;
        this.incMoment = false;
        this.moment = secondMoment;
    }

    @Override // org.apache.commons.math3.stat.descriptive.WeightedEvaluation
    public double evaluate(double[] dArr, double[] dArr2, int i5, int i6) {
        if (!test(dArr, dArr2, i5, i6)) {
            return Double.NaN;
        }
        clear();
        if (i6 == 1) {
            return 0.0d;
        }
        if (i6 > 1) {
            return evaluate(dArr, dArr2, new Mean().evaluate(dArr, dArr2, i5, i6), i5, i6);
        }
        return Double.NaN;
    }

    public Variance(boolean z6) {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
        this.moment = new SecondMoment();
        this.isBiasCorrected = z6;
    }

    @Override // org.apache.commons.math3.stat.descriptive.WeightedEvaluation
    public double evaluate(double[] dArr, double[] dArr2) {
        return evaluate(dArr, dArr2, 0, dArr.length);
    }

    public double evaluate(double[] dArr, double d, int i5, int i6) {
        double d6;
        if (!test(dArr, i5, i6)) {
            return Double.NaN;
        }
        double d7 = 0.0d;
        if (i6 == 1) {
            return 0.0d;
        }
        if (i6 <= 1) {
            return Double.NaN;
        }
        double d8 = 0.0d;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            double d9 = dArr[i7] - d;
            d7 += d9 * d9;
            d8 += d9;
        }
        double d10 = i6;
        if (this.isBiasCorrected) {
            d6 = d7 - ((d8 * d8) / d10);
            d10 -= 1.0d;
        } else {
            d6 = d7 - ((d8 * d8) / d10);
        }
        return d6 / d10;
    }

    public Variance(boolean z6, SecondMoment secondMoment) {
        this.incMoment = false;
        this.moment = secondMoment;
        this.isBiasCorrected = z6;
    }

    public double evaluate(double[] dArr, double d) {
        return evaluate(dArr, d, 0, dArr.length);
    }

    public double evaluate(double[] dArr, double[] dArr2, double d, int i5, int i6) {
        int i7;
        double d6;
        int i8 = i5;
        if (!test(dArr, dArr2, i8, i6)) {
            return Double.NaN;
        }
        double d7 = 0.0d;
        if (i6 == 1) {
            return 0.0d;
        }
        if (i6 <= 1) {
            return Double.NaN;
        }
        int i9 = i8;
        double dC = 0.0d;
        double d8 = 0.0d;
        while (true) {
            i7 = i8 + i6;
            if (i9 >= i7) {
                break;
            }
            double d9 = dArr[i9] - d;
            double d10 = dArr2[i9];
            dC = a.C(d9, d9, d10, dC);
            d8 = (d10 * d9) + d8;
            i9++;
        }
        while (i8 < i7) {
            d7 += dArr2[i8];
            i8++;
        }
        if (this.isBiasCorrected) {
            d6 = dC - ((d8 * d8) / d7);
            d7 -= 1.0d;
        } else {
            d6 = dC - ((d8 * d8) / d7);
        }
        return d6 / d7;
    }

    public Variance(Variance variance) {
        this.moment = null;
        this.incMoment = true;
        this.isBiasCorrected = true;
        copy(variance, this);
    }

    public double evaluate(double[] dArr, double[] dArr2, double d) {
        return evaluate(dArr, dArr2, d, 0, dArr.length);
    }
}
