package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HypergeometricDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = -436928820673516179L;
    private final int numberOfSuccesses;
    private double numericalVariance;
    private boolean numericalVarianceIsCalculated;
    private final int populationSize;
    private final int sampleSize;

    public HypergeometricDistribution(int i5, int i6, int i7) {
        this(new Well19937c(), i5, i6, i7);
    }

    private int[] getDomain(int i5, int i6, int i7) {
        return new int[]{getLowerDomain(i5, i6, i7), getUpperDomain(i6, i7)};
    }

    private int getLowerDomain(int i5, int i6, int i7) {
        return FastMath.max(0, i6 - (i5 - i7));
    }

    private int getUpperDomain(int i5, int i6) {
        return FastMath.min(i6, i5);
    }

    private double innerCumulativeProbability(int i5, int i6, int i7) {
        double dProbability = probability(i5);
        while (i5 != i6) {
            i5 += i7;
            dProbability += probability(i5);
        }
        return dProbability;
    }

    public double calculateNumericalVariance() {
        double populationSize = getPopulationSize();
        double numberOfSuccesses = getNumberOfSuccesses();
        double sampleSize = getSampleSize();
        return ((populationSize - numberOfSuccesses) * ((populationSize - sampleSize) * (sampleSize * numberOfSuccesses))) / ((populationSize - 1.0d) * (populationSize * populationSize));
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int i5) {
        int[] domain = getDomain(this.populationSize, this.numberOfSuccesses, this.sampleSize);
        int i6 = domain[0];
        if (i5 < i6) {
            return 0.0d;
        }
        if (i5 >= domain[1]) {
            return 1.0d;
        }
        return innerCumulativeProbability(i6, i5, 1);
    }

    public int getNumberOfSuccesses() {
        return this.numberOfSuccesses;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        return (((double) getNumberOfSuccesses()) / ((double) getPopulationSize())) * ((double) getSampleSize());
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        if (!this.numericalVarianceIsCalculated) {
            this.numericalVariance = calculateNumericalVariance();
            this.numericalVarianceIsCalculated = true;
        }
        return this.numericalVariance;
    }

    public int getPopulationSize() {
        return this.populationSize;
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        return FastMath.max(0, (getNumberOfSuccesses() + getSampleSize()) - getPopulationSize());
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        return FastMath.min(getNumberOfSuccesses(), getSampleSize());
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public double logProbability(int i5) {
        int[] domain = getDomain(this.populationSize, this.numberOfSuccesses, this.sampleSize);
        if (i5 < domain[0] || i5 > domain[1]) {
            return Double.NEGATIVE_INFINITY;
        }
        int i6 = this.sampleSize;
        int i7 = this.populationSize;
        double d = ((double) i6) / ((double) i7);
        double d6 = ((double) (i7 - i6)) / ((double) i7);
        return (SaddlePointExpansion.logBinomialProbability(i5, this.numberOfSuccesses, d, d6) + SaddlePointExpansion.logBinomialProbability(this.sampleSize - i5, this.populationSize - this.numberOfSuccesses, d, d6)) - SaddlePointExpansion.logBinomialProbability(this.sampleSize, this.populationSize, d, d6);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int i5) {
        double dLogProbability = logProbability(i5);
        if (dLogProbability == Double.NEGATIVE_INFINITY) {
            return 0.0d;
        }
        return FastMath.exp(dLogProbability);
    }

    public double upperCumulativeProbability(int i5) {
        int[] domain = getDomain(this.populationSize, this.numberOfSuccesses, this.sampleSize);
        if (i5 <= domain[0]) {
            return 1.0d;
        }
        int i6 = domain[1];
        if (i5 > i6) {
            return 0.0d;
        }
        return innerCumulativeProbability(i6, i5, -1);
    }

    public HypergeometricDistribution(RandomGenerator randomGenerator, int i5, int i6, int i7) {
        super(randomGenerator);
        this.numericalVariance = Double.NaN;
        this.numericalVarianceIsCalculated = false;
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.POPULATION_SIZE, Integer.valueOf(i5));
        }
        if (i6 < 0) {
            throw new NotPositiveException(LocalizedFormats.NUMBER_OF_SUCCESSES, Integer.valueOf(i6));
        }
        if (i7 < 0) {
            throw new NotPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(i7));
        }
        if (i6 > i5) {
            throw new NumberIsTooLargeException(LocalizedFormats.NUMBER_OF_SUCCESS_LARGER_THAN_POPULATION_SIZE, Integer.valueOf(i6), Integer.valueOf(i5), true);
        }
        if (i7 > i5) {
            throw new NumberIsTooLargeException(LocalizedFormats.SAMPLE_SIZE_LARGER_THAN_POPULATION_SIZE, Integer.valueOf(i7), Integer.valueOf(i5), true);
        }
        this.numberOfSuccesses = i6;
        this.populationSize = i5;
        this.sampleSize = i7;
    }
}
