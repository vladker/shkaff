package org.apache.commons.math3.stat.descriptive.summary;

import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SumOfSquares extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 1460986908574398008L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f6930n;
    private double value;

    public SumOfSquares() {
        this.f6930n = 0L;
        this.value = 0.0d;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        this.value = 0.0d;
        this.f6930n = 0L;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr, int i5, int i6) {
        if (!test(dArr, i5, i6, true)) {
            return Double.NaN;
        }
        double d = 0.0d;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            double d6 = dArr[i7];
            d += d6 * d6;
        }
        return d;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.f6930n;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        return this.value;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        this.value = (d * d) + this.value;
        this.f6930n++;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public SumOfSquares copy() {
        SumOfSquares sumOfSquares = new SumOfSquares();
        copy(this, sumOfSquares);
        return sumOfSquares;
    }

    public SumOfSquares(SumOfSquares sumOfSquares) {
        copy(sumOfSquares, this);
    }

    public static void copy(SumOfSquares sumOfSquares, SumOfSquares sumOfSquares2) {
        MathUtils.checkNotNull(sumOfSquares);
        MathUtils.checkNotNull(sumOfSquares2);
        sumOfSquares2.setData(sumOfSquares.getDataRef());
        sumOfSquares2.f6930n = sumOfSquares.f6930n;
        sumOfSquares2.value = sumOfSquares.value;
    }
}
