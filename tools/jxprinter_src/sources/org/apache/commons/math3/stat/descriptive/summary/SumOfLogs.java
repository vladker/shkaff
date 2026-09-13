package org.apache.commons.math3.stat.descriptive.summary;

import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SumOfLogs extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -370076995648386763L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f6929n;
    private double value;

    public SumOfLogs() {
        this.value = 0.0d;
        this.f6929n = 0;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        this.value = 0.0d;
        this.f6929n = 0;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr, int i5, int i6) {
        if (!test(dArr, i5, i6, true)) {
            return Double.NaN;
        }
        double dLog = 0.0d;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            dLog += FastMath.log(dArr[i7]);
        }
        return dLog;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.f6929n;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        return this.value;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        this.value = FastMath.log(d) + this.value;
        this.f6929n++;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public SumOfLogs copy() {
        SumOfLogs sumOfLogs = new SumOfLogs();
        copy(this, sumOfLogs);
        return sumOfLogs;
    }

    public SumOfLogs(SumOfLogs sumOfLogs) {
        copy(sumOfLogs, this);
    }

    public static void copy(SumOfLogs sumOfLogs, SumOfLogs sumOfLogs2) {
        MathUtils.checkNotNull(sumOfLogs);
        MathUtils.checkNotNull(sumOfLogs2);
        sumOfLogs2.setData(sumOfLogs.getDataRef());
        sumOfLogs2.f6929n = sumOfLogs.f6929n;
        sumOfLogs2.value = sumOfLogs.value;
    }
}
