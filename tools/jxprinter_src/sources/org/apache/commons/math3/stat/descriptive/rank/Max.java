package org.apache.commons.math3.stat.descriptive.rank;

import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Max extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -5593383832225844641L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f6924n;
    private double value;

    public Max() {
        this.f6924n = 0L;
        this.value = Double.NaN;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        this.value = Double.NaN;
        this.f6924n = 0L;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr, int i5, int i6) {
        if (!test(dArr, i5, i6)) {
            return Double.NaN;
        }
        double d = dArr[i5];
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            if (!Double.isNaN(dArr[i7])) {
                double d6 = dArr[i7];
                if (d <= d6) {
                    d = d6;
                }
            }
        }
        return d;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.f6924n;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        return this.value;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        double d6 = this.value;
        if (d > d6 || Double.isNaN(d6)) {
            this.value = d;
        }
        this.f6924n++;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public Max copy() {
        Max max = new Max();
        copy(this, max);
        return max;
    }

    public Max(Max max) {
        copy(max, this);
    }

    public static void copy(Max max, Max max2) {
        MathUtils.checkNotNull(max);
        MathUtils.checkNotNull(max2);
        max2.setData(max.getDataRef());
        max2.f6924n = max.f6924n;
        max2.value = max.value;
    }
}
