package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class UniformIntegerDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 20120109;
    private final int lower;
    private final int upper;

    public UniformIntegerDistribution(int i5, int i6) {
        this(new Well19937c(), i5, i6);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int i5) {
        int i6 = this.lower;
        if (i5 < i6) {
            return 0.0d;
        }
        int i7 = this.upper;
        if (i5 > i7) {
            return 1.0d;
        }
        return (((double) (i5 - i6)) + 1.0d) / (((double) (i7 - i6)) + 1.0d);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        return ((double) (this.lower + this.upper)) * 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        double d = (this.upper - this.lower) + 1;
        return ((d * d) - 1.0d) / 12.0d;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        return this.lower;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        return this.upper;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int i5) {
        int i6;
        int i7 = this.lower;
        if (i5 < i7 || i5 > (i6 = this.upper)) {
            return 0.0d;
        }
        return 1.0d / ((double) ((i6 - i7) + 1));
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution, org.apache.commons.math3.distribution.IntegerDistribution
    public int sample() {
        int i5 = this.upper;
        int i6 = this.lower;
        int i7 = (i5 - i6) + 1;
        if (i7 > 0) {
            return this.random.nextInt(i7) + i6;
        }
        while (true) {
            int iNextInt = this.random.nextInt();
            if (iNextInt >= this.lower && iNextInt <= this.upper) {
                return iNextInt;
            }
        }
    }

    public UniformIntegerDistribution(RandomGenerator randomGenerator, int i5, int i6) {
        super(randomGenerator);
        if (i5 > i6) {
            throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Integer.valueOf(i5), Integer.valueOf(i6), true);
        }
        this.lower = i5;
        this.upper = i6;
    }
}
