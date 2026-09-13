package org.apache.commons.math3.stat.descriptive.summary;

import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Sum extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -8231831954703408316L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f6928n;
    private double value;

    public Sum() {
        this.f6928n = 0L;
        this.value = 0.0d;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        this.value = 0.0d;
        this.f6928n = 0L;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr, int i5, int i6) {
        if (!test(dArr, i5, i6, true)) {
            return Double.NaN;
        }
        double d = 0.0d;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            d += dArr[i7];
        }
        return d;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.f6928n;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        return this.value;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        this.value += d;
        this.f6928n++;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public Sum copy() {
        Sum sum = new Sum();
        copy(this, sum);
        return sum;
    }

    public double evaluate(double[] dArr, double[] dArr2, int i5, int i6) {
        if (!test(dArr, dArr2, i5, i6, true)) {
            return Double.NaN;
        }
        double d = 0.0d;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            d += dArr[i7] * dArr2[i7];
        }
        return d;
    }

    public Sum(Sum sum) {
        copy(sum, this);
    }

    public static void copy(Sum sum, Sum sum2) {
        MathUtils.checkNotNull(sum);
        MathUtils.checkNotNull(sum2);
        sum2.setData(sum.getDataRef());
        sum2.f6928n = sum.f6928n;
        sum2.value = sum.value;
    }

    public double evaluate(double[] dArr, double[] dArr2) {
        return evaluate(dArr, dArr2, 0, dArr.length);
    }
}
