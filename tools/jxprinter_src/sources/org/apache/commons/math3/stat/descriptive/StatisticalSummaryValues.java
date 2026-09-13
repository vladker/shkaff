package org.apache.commons.math3.stat.descriptive;

import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StatisticalSummaryValues implements Serializable, StatisticalSummary {
    private static final long serialVersionUID = -5108854841843722536L;
    private final double max;
    private final double mean;
    private final double min;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f6915n;
    private final double sum;
    private final double variance;

    public StatisticalSummaryValues(double d, double d6, long j6, double d7, double d8, double d9) {
        this.mean = d;
        this.variance = d6;
        this.f6915n = j6;
        this.max = d7;
        this.min = d8;
        this.sum = d9;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StatisticalSummaryValues)) {
            return false;
        }
        StatisticalSummaryValues statisticalSummaryValues = (StatisticalSummaryValues) obj;
        return Precision.equalsIncludingNaN(statisticalSummaryValues.getMax(), getMax()) && Precision.equalsIncludingNaN(statisticalSummaryValues.getMean(), getMean()) && Precision.equalsIncludingNaN(statisticalSummaryValues.getMin(), getMin()) && Precision.equalsIncludingNaN((float) statisticalSummaryValues.getN(), (float) getN()) && Precision.equalsIncludingNaN(statisticalSummaryValues.getSum(), getSum()) && Precision.equalsIncludingNaN(statisticalSummaryValues.getVariance(), getVariance());
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMax() {
        return this.max;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMean() {
        return this.mean;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getMin() {
        return this.min;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public long getN() {
        return this.f6915n;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getStandardDeviation() {
        return FastMath.sqrt(this.variance);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getSum() {
        return this.sum;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StatisticalSummary
    public double getVariance() {
        return this.variance;
    }

    public int hashCode() {
        return MathUtils.hash(getVariance()) + ((MathUtils.hash(getSum()) + ((MathUtils.hash(getN()) + ((MathUtils.hash(getMin()) + ((MathUtils.hash(getMean()) + ((MathUtils.hash(getMax()) + 31) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("StatisticalSummaryValues:\nn: ");
        stringBuffer.append(getN());
        stringBuffer.append("\nmin: ");
        stringBuffer.append(getMin());
        stringBuffer.append("\nmax: ");
        stringBuffer.append(getMax());
        stringBuffer.append("\nmean: ");
        stringBuffer.append(getMean());
        stringBuffer.append("\nstd dev: ");
        stringBuffer.append(getStandardDeviation());
        stringBuffer.append("\nvariance: ");
        stringBuffer.append(getVariance());
        stringBuffer.append("\nsum: ");
        stringBuffer.append(getSum());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }
}
