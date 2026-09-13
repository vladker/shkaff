package org.apache.commons.math3.distribution;

import androidx.collection.a;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ZipfDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = -140627372283420404L;
    private final double exponent;
    private final int numberOfElements;
    private double numericalMean;
    private boolean numericalMeanIsCalculated;
    private double numericalVariance;
    private boolean numericalVarianceIsCalculated;
    private transient ZipfRejectionInversionSampler sampler;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ZipfRejectionInversionSampler {
        private final double exponent;
        private final double hIntegralNumberOfElements;
        private final int numberOfElements;
        private final double hIntegralX1 = hIntegral(1.5d) - 1.0d;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final double f6766s = 2.0d - hIntegralInverse(hIntegral(2.5d) - h(2.0d));

        public ZipfRejectionInversionSampler(int i5, double d) {
            this.exponent = d;
            this.numberOfElements = i5;
            this.hIntegralNumberOfElements = hIntegral(((double) i5) + 0.5d);
        }

        private double h(double d) {
            return FastMath.exp(FastMath.log(d) * (-this.exponent));
        }

        private double hIntegral(double d) {
            double dLog = FastMath.log(d);
            return helper2((1.0d - this.exponent) * dLog) * dLog;
        }

        private double hIntegralInverse(double d) {
            double d6 = (1.0d - this.exponent) * d;
            if (d6 < -1.0d) {
                d6 = -1.0d;
            }
            return FastMath.exp(helper1(d6) * d);
        }

        public static double helper1(double d) {
            return FastMath.abs(d) > 1.0E-8d ? FastMath.log1p(d) / d : 1.0d - ((0.5d - ((0.3333333333333333d - (0.25d * d)) * d)) * d);
        }

        public static double helper2(double d) {
            if (FastMath.abs(d) > 1.0E-8d) {
                return FastMath.expm1(d) / d;
            }
            return (((((d * 0.25d) + 1.0d) * 0.3333333333333333d * d) + 1.0d) * 0.5d * d) + 1.0d;
        }

        public int sample(RandomGenerator randomGenerator) {
            double dA;
            int i5;
            double d;
            do {
                dA = a.a(this.hIntegralX1, this.hIntegralNumberOfElements, randomGenerator.nextDouble(), this.hIntegralNumberOfElements);
                double dHIntegralInverse = hIntegralInverse(dA);
                i5 = (int) (dHIntegralInverse + 0.5d);
                int i6 = 1;
                if (i5 < 1 || i5 > (i6 = this.numberOfElements)) {
                    i5 = i6;
                }
                d = i5;
                if (d - dHIntegralInverse <= this.f6766s) {
                    break;
                }
            } while (dA < hIntegral(0.5d + d) - h(d));
            return i5;
        }
    }

    public ZipfDistribution(int i5, double d) {
        this(new Well19937c(), i5, d);
    }

    private double generalizedHarmonic(int i5, double d) {
        double dPow = 0.0d;
        while (i5 > 0) {
            dPow += 1.0d / FastMath.pow(i5, d);
            i5--;
        }
        return dPow;
    }

    public double calculateNumericalMean() {
        int numberOfElements = getNumberOfElements();
        double exponent = getExponent();
        return generalizedHarmonic(numberOfElements, exponent - 1.0d) / generalizedHarmonic(numberOfElements, exponent);
    }

    public double calculateNumericalVariance() {
        int numberOfElements = getNumberOfElements();
        double exponent = getExponent();
        double dGeneralizedHarmonic = generalizedHarmonic(numberOfElements, exponent - 2.0d);
        double dGeneralizedHarmonic2 = generalizedHarmonic(numberOfElements, exponent - 1.0d);
        double dGeneralizedHarmonic3 = generalizedHarmonic(numberOfElements, exponent);
        return (dGeneralizedHarmonic / dGeneralizedHarmonic3) - ((dGeneralizedHarmonic2 * dGeneralizedHarmonic2) / (dGeneralizedHarmonic3 * dGeneralizedHarmonic3));
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int i5) {
        if (i5 <= 0) {
            return 0.0d;
        }
        if (i5 >= this.numberOfElements) {
            return 1.0d;
        }
        return generalizedHarmonic(i5, this.exponent) / generalizedHarmonic(this.numberOfElements, this.exponent);
    }

    public double getExponent() {
        return this.exponent;
    }

    public int getNumberOfElements() {
        return this.numberOfElements;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        if (!this.numericalMeanIsCalculated) {
            this.numericalMean = calculateNumericalMean();
            this.numericalMeanIsCalculated = true;
        }
        return this.numericalMean;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        if (!this.numericalVarianceIsCalculated) {
            this.numericalVariance = calculateNumericalVariance();
            this.numericalVarianceIsCalculated = true;
        }
        return this.numericalVariance;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        return 1;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        return getNumberOfElements();
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public double logProbability(int i5) {
        if (i5 <= 0 || i5 > this.numberOfElements) {
            return Double.NEGATIVE_INFINITY;
        }
        double d = -FastMath.log(i5);
        double d6 = this.exponent;
        return (d * d6) - FastMath.log(generalizedHarmonic(this.numberOfElements, d6));
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int i5) {
        if (i5 <= 0 || i5 > this.numberOfElements) {
            return 0.0d;
        }
        return (1.0d / FastMath.pow(i5, this.exponent)) / generalizedHarmonic(this.numberOfElements, this.exponent);
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution, org.apache.commons.math3.distribution.IntegerDistribution
    public int sample() {
        if (this.sampler == null) {
            this.sampler = new ZipfRejectionInversionSampler(this.numberOfElements, this.exponent);
        }
        return this.sampler.sample(this.random);
    }

    public ZipfDistribution(RandomGenerator randomGenerator, int i5, double d) {
        super(randomGenerator);
        this.numericalMean = Double.NaN;
        this.numericalMeanIsCalculated = false;
        this.numericalVariance = Double.NaN;
        this.numericalVarianceIsCalculated = false;
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.DIMENSION, Integer.valueOf(i5));
        }
        if (d <= 0.0d) {
            throw new NotStrictlyPositiveException(LocalizedFormats.EXPONENT, Double.valueOf(d));
        }
        this.numberOfElements = i5;
        this.exponent = d;
    }
}
