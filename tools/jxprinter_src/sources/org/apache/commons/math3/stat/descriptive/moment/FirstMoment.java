package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FirstMoment extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 6112755307178490473L;

    /* JADX INFO: renamed from: dev, reason: collision with root package name */
    protected double f6917dev;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    protected double f6918m1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected long f6919n;
    protected double nDev;

    public FirstMoment() {
        this.f6919n = 0L;
        this.f6918m1 = Double.NaN;
        this.f6917dev = Double.NaN;
        this.nDev = Double.NaN;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        this.f6918m1 = Double.NaN;
        this.f6919n = 0L;
        this.f6917dev = Double.NaN;
        this.nDev = Double.NaN;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.f6919n;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        return this.f6918m1;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        long j6 = this.f6919n;
        if (j6 == 0) {
            this.f6918m1 = 0.0d;
        }
        long j7 = j6 + 1;
        this.f6919n = j7;
        double d6 = this.f6918m1;
        double d7 = d - d6;
        this.f6917dev = d7;
        double d8 = d7 / j7;
        this.nDev = d8;
        this.f6918m1 = d6 + d8;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public FirstMoment copy() {
        FirstMoment firstMoment = new FirstMoment();
        copy(this, firstMoment);
        return firstMoment;
    }

    public static void copy(FirstMoment firstMoment, FirstMoment firstMoment2) {
        MathUtils.checkNotNull(firstMoment);
        MathUtils.checkNotNull(firstMoment2);
        firstMoment2.setData(firstMoment.getDataRef());
        firstMoment2.f6919n = firstMoment.f6919n;
        firstMoment2.f6918m1 = firstMoment.f6918m1;
        firstMoment2.f6917dev = firstMoment.f6917dev;
        firstMoment2.nDev = firstMoment.nDev;
    }

    public FirstMoment(FirstMoment firstMoment) {
        copy(firstMoment, this);
    }
}
