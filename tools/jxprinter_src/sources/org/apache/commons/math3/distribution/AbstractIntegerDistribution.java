package org.apache.commons.math3.distribution;

import A3.AbstractC0157z;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomDataImpl;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractIntegerDistribution implements IntegerDistribution, Serializable {
    private static final long serialVersionUID = -1146319659338487221L;
    protected final RandomGenerator random;

    @Deprecated
    protected final RandomDataImpl randomData;

    @Deprecated
    public AbstractIntegerDistribution() {
        this.randomData = new RandomDataImpl();
        this.random = null;
    }

    private double checkedCumulativeProbability(int i5) {
        double dCumulativeProbability = cumulativeProbability(i5);
        if (Double.isNaN(dCumulativeProbability)) {
            throw new MathInternalError(LocalizedFormats.DISCRETE_CUMULATIVE_PROBABILITY_RETURNED_NAN, Integer.valueOf(i5));
        }
        return dCumulativeProbability;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int i5, int i6) {
        if (i6 >= i5) {
            return cumulativeProbability(i6) - cumulativeProbability(i5);
        }
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, Integer.valueOf(i5), Integer.valueOf(i6), true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        if (checkedCumulativeProbability(r9) >= r20) goto L13;
     */
    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int inverseCumulativeProbability(double r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L86
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r5 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r5 > 0) goto L86
            int r9 = r0.getSupportLowerBound()
            int r10 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r10 != 0) goto L19
            goto L25
        L19:
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r9 != r10) goto L26
            double r10 = r0.checkedCumulativeProbability(r9)
            int r10 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r10 < 0) goto L28
        L25:
            return r9
        L26:
            int r9 = r9 + (-1)
        L28:
            int r10 = r0.getSupportUpperBound()
            if (r5 != 0) goto L2f
            return r10
        L2f:
            double r11 = r0.getNumericalMean()
            double r13 = r0.getNumericalVariance()
            double r13 = org.apache.commons.math3.util.FastMath.sqrt(r13)
            boolean r5 = java.lang.Double.isInfinite(r11)
            if (r5 != 0) goto L81
            boolean r5 = java.lang.Double.isNaN(r11)
            if (r5 != 0) goto L81
            boolean r5 = java.lang.Double.isInfinite(r13)
            if (r5 != 0) goto L81
            boolean r5 = java.lang.Double.isNaN(r13)
            if (r5 != 0) goto L81
            int r3 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r3 == 0) goto L81
            double r3 = r7 - r1
            double r3 = r3 / r1
            double r3 = org.apache.commons.math3.util.FastMath.sqrt(r3)
            double r15 = r3 * r13
            double r15 = r11 - r15
            r17 = r7
            r5 = 1
            double r6 = (double) r9
            int r6 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r6 <= 0) goto L71
            double r6 = org.apache.commons.math3.util.FastMath.ceil(r15)
            int r6 = (int) r6
            int r9 = r6 + (-1)
        L71:
            double r7 = r17 / r3
            double r7 = r7 * r13
            double r7 = r7 + r11
            double r3 = (double) r10
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 >= 0) goto L81
            double r3 = org.apache.commons.math3.util.FastMath.ceil(r7)
            int r3 = (int) r3
            int r10 = r3 + (-1)
        L81:
            int r1 = r0.solveInverseCumulativeProbability(r1, r9, r10)
            return r1
        L86:
            r5 = 1
            org.apache.commons.math3.exception.OutOfRangeException r3 = new org.apache.commons.math3.exception.OutOfRangeException
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r3.<init>(r1, r2, r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.math3.distribution.AbstractIntegerDistribution.inverseCumulativeProbability(double):int");
    }

    public double logProbability(int i5) {
        return FastMath.log(probability(i5));
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public void reseedRandomGenerator(long j6) {
        this.random.setSeed(j6);
        this.randomData.reSeed(j6);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int sample() {
        return inverseCumulativeProbability(this.random.nextDouble());
    }

    public int solveInverseCumulativeProbability(double d, int i5, int i6) {
        while (i5 + 1 < i6) {
            int iB = (i5 + i6) / 2;
            if (iB < i5 || iB > i6) {
                iB = AbstractC0157z.b(i6, i5, 2, i5);
            }
            if (checkedCumulativeProbability(iB) >= d) {
                i6 = iB;
            } else {
                i5 = iB;
            }
        }
        return i6;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int[] sample(int i5) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(i5));
        }
        int[] iArr = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            iArr[i6] = sample();
        }
        return iArr;
    }

    public AbstractIntegerDistribution(RandomGenerator randomGenerator) {
        this.randomData = new RandomDataImpl();
        this.random = randomGenerator;
    }
}
