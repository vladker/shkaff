package org.apache.commons.math3.stat.descriptive.moment;

import androidx.collection.a;
import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.WeightedEvaluation;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Mean extends AbstractStorelessUnivariateStatistic implements Serializable, WeightedEvaluation {
    private static final long serialVersionUID = -1296043746617791564L;
    protected boolean incMoment;
    protected FirstMoment moment;

    public Mean() {
        this.incMoment = true;
        this.moment = new FirstMoment();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        if (this.incMoment) {
            this.moment.clear();
        }
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr, int i5, int i6) {
        if (!test(dArr, i5, i6)) {
            return Double.NaN;
        }
        double d = i6;
        double dEvaluate = new Sum().evaluate(dArr, i5, i6) / d;
        double d6 = 0.0d;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            d6 += dArr[i7] - dEvaluate;
        }
        return (d6 / d) + dEvaluate;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.moment.getN();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        return this.moment.f6918m1;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        if (this.incMoment) {
            this.moment.increment(d);
        }
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public Mean copy() {
        Mean mean = new Mean();
        copy(this, mean);
        return mean;
    }

    public Mean(FirstMoment firstMoment) {
        this.moment = firstMoment;
        this.incMoment = false;
    }

    public static void copy(Mean mean, Mean mean2) {
        MathUtils.checkNotNull(mean);
        MathUtils.checkNotNull(mean2);
        mean2.setData(mean.getDataRef());
        mean2.incMoment = mean.incMoment;
        mean2.moment = mean.moment.copy();
    }

    @Override // org.apache.commons.math3.stat.descriptive.WeightedEvaluation
    public double evaluate(double[] dArr, double[] dArr2, int i5, int i6) {
        if (!test(dArr, dArr2, i5, i6)) {
            return Double.NaN;
        }
        Sum sum = new Sum();
        double dEvaluate = sum.evaluate(dArr2, i5, i6);
        double dEvaluate2 = sum.evaluate(dArr, dArr2, i5, i6) / dEvaluate;
        double dA = 0.0d;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            dA = a.a(dArr[i7], dEvaluate2, dArr2[i7], dA);
        }
        return (dA / dEvaluate) + dEvaluate2;
    }

    public Mean(Mean mean) {
        copy(mean, this);
    }

    @Override // org.apache.commons.math3.stat.descriptive.WeightedEvaluation
    public double evaluate(double[] dArr, double[] dArr2) {
        return evaluate(dArr, dArr2, 0, dArr.length);
    }
}
