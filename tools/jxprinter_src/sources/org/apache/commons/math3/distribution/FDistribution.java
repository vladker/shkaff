package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -8516354193418641566L;
    private final double denominatorDegreesOfFreedom;
    private final double numeratorDegreesOfFreedom;
    private double numericalVariance;
    private boolean numericalVarianceIsCalculated;
    private final double solverAbsoluteAccuracy;

    public FDistribution(double d, double d6) {
        this(d, d6, 1.0E-9d);
    }

    public double calculateNumericalVariance() {
        double denominatorDegreesOfFreedom = getDenominatorDegreesOfFreedom();
        if (denominatorDegreesOfFreedom <= 4.0d) {
            return Double.NaN;
        }
        double numeratorDegreesOfFreedom = getNumeratorDegreesOfFreedom();
        double d = denominatorDegreesOfFreedom - 2.0d;
        return (((numeratorDegreesOfFreedom + denominatorDegreesOfFreedom) - 2.0d) * ((denominatorDegreesOfFreedom * denominatorDegreesOfFreedom) * 2.0d)) / ((denominatorDegreesOfFreedom - 4.0d) * ((d * d) * numeratorDegreesOfFreedom));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        double d6 = this.numeratorDegreesOfFreedom;
        double d7 = this.denominatorDegreesOfFreedom;
        double d8 = d * d6;
        return Beta.regularizedBeta(d8 / (d7 + d8), d6 * 0.5d, d7 * 0.5d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double d) {
        return FastMath.exp(logDensity(d));
    }

    public double getDenominatorDegreesOfFreedom() {
        return this.denominatorDegreesOfFreedom;
    }

    public double getNumeratorDegreesOfFreedom() {
        return this.numeratorDegreesOfFreedom;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        double denominatorDegreesOfFreedom = getDenominatorDegreesOfFreedom();
        if (denominatorDegreesOfFreedom > 2.0d) {
            return denominatorDegreesOfFreedom / (denominatorDegreesOfFreedom - 2.0d);
        }
        return Double.NaN;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        if (!this.numericalVarianceIsCalculated) {
            this.numericalVariance = calculateNumericalVariance();
            this.numericalVarianceIsCalculated = true;
        }
        return this.numericalVariance;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return 0.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return Double.POSITIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportLowerBoundInclusive() {
        return false;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportUpperBoundInclusive() {
        return false;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double logDensity(double d) {
        double d6 = this.numeratorDegreesOfFreedom / 2.0d;
        double d7 = this.denominatorDegreesOfFreedom / 2.0d;
        double dLog = FastMath.log(d);
        double dLog2 = FastMath.log(this.numeratorDegreesOfFreedom);
        double dLog3 = FastMath.log(this.denominatorDegreesOfFreedom);
        double dLog4 = FastMath.log((this.numeratorDegreesOfFreedom * d) + this.denominatorDegreesOfFreedom);
        return ((((dLog3 * d7) + (((d6 * dLog) + (dLog2 * d6)) - dLog)) - (d6 * dLog4)) - (dLog4 * d7)) - Beta.logBeta(d6, d7);
    }

    public FDistribution(double d, double d6, double d7) {
        this(new Well19937c(), d, d6, d7);
    }

    public FDistribution(RandomGenerator randomGenerator, double d, double d6) {
        this(randomGenerator, d, d6, 1.0E-9d);
    }

    public FDistribution(RandomGenerator randomGenerator, double d, double d6, double d7) {
        super(randomGenerator);
        this.numericalVariance = Double.NaN;
        this.numericalVarianceIsCalculated = false;
        if (d <= 0.0d) {
            throw new NotStrictlyPositiveException(LocalizedFormats.DEGREES_OF_FREEDOM, Double.valueOf(d));
        }
        if (d6 > 0.0d) {
            this.numeratorDegreesOfFreedom = d;
            this.denominatorDegreesOfFreedom = d6;
            this.solverAbsoluteAccuracy = d7;
            return;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.DEGREES_OF_FREEDOM, Double.valueOf(d6));
    }
}
