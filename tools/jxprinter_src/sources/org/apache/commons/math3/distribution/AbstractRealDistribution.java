package org.apache.commons.math3.distribution;

import java.io.Serializable;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.UnivariateSolverUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomDataImpl;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractRealDistribution implements RealDistribution, Serializable {
    public static final double SOLVER_DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;
    private static final long serialVersionUID = -38038050983108802L;
    protected final RandomGenerator random;

    @Deprecated
    protected RandomDataImpl randomData;
    private double solverAbsoluteAccuracy;

    @Deprecated
    public AbstractRealDistribution() {
        this.randomData = new RandomDataImpl();
        this.solverAbsoluteAccuracy = 1.0E-6d;
        this.random = null;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    @Deprecated
    public double cumulativeProbability(double d, double d6) {
        return probability(d, d6);
    }

    public double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(final double d) {
        double d6;
        boolean z6 = false;
        if (d >= 0.0d) {
            double d7 = 1.0d;
            if (d <= 1.0d) {
                double supportLowerBound = getSupportLowerBound();
                if (d == 0.0d) {
                    return supportLowerBound;
                }
                double supportUpperBound = getSupportUpperBound();
                if (d == 1.0d) {
                    return supportUpperBound;
                }
                double numericalMean = getNumericalMean();
                double dSqrt = FastMath.sqrt(getNumericalVariance());
                if (!Double.isInfinite(numericalMean) && !Double.isNaN(numericalMean) && !Double.isInfinite(dSqrt) && !Double.isNaN(dSqrt)) {
                    z6 = true;
                }
                if (supportLowerBound == Double.NEGATIVE_INFINITY) {
                    if (z6) {
                        supportLowerBound = numericalMean - (FastMath.sqrt((1.0d - d) / d) * dSqrt);
                    } else {
                        supportLowerBound = -1.0d;
                        while (cumulativeProbability(supportLowerBound) >= d) {
                            supportLowerBound *= 2.0d;
                        }
                    }
                }
                double d8 = supportLowerBound;
                if (supportUpperBound != Double.POSITIVE_INFINITY) {
                    d6 = supportUpperBound;
                } else if (z6) {
                    supportUpperBound = (FastMath.sqrt(d / (1.0d - d)) * dSqrt) + numericalMean;
                    d6 = supportUpperBound;
                } else {
                    while (cumulativeProbability(d7) < d) {
                        d7 *= 2.0d;
                    }
                    d6 = d7;
                }
                double dSolve = UnivariateSolverUtils.solve(new UnivariateFunction() { // from class: org.apache.commons.math3.distribution.AbstractRealDistribution.1
                    @Override // org.apache.commons.math3.analysis.UnivariateFunction
                    public double value(double d9) {
                        return AbstractRealDistribution.this.cumulativeProbability(d9) - d;
                    }
                }, d8, d6, getSolverAbsoluteAccuracy());
                if (!isSupportConnected()) {
                    double solverAbsoluteAccuracy = getSolverAbsoluteAccuracy();
                    double d9 = dSolve - solverAbsoluteAccuracy;
                    if (d9 >= getSupportLowerBound()) {
                        double dCumulativeProbability = cumulativeProbability(dSolve);
                        if (cumulativeProbability(d9) == dCumulativeProbability) {
                            while (dSolve - d8 > solverAbsoluteAccuracy) {
                                double d10 = (d8 + dSolve) * 0.5d;
                                if (cumulativeProbability(d10) < dCumulativeProbability) {
                                    d8 = d10;
                                } else {
                                    dSolve = d10;
                                }
                            }
                        }
                    }
                }
                return dSolve;
            }
        }
        throw new OutOfRangeException(Double.valueOf(d), 0, 1);
    }

    public double logDensity(double d) {
        return FastMath.log(density(d));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double probability(double d) {
        return 0.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public void reseedRandomGenerator(long j6) {
        this.random.setSeed(j6);
        this.randomData.reSeed(j6);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double sample() {
        return inverseCumulativeProbability(this.random.nextDouble());
    }

    public double probability(double d, double d6) {
        if (d <= d6) {
            return cumulativeProbability(d6) - cumulativeProbability(d);
        }
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, Double.valueOf(d), Double.valueOf(d6), true);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double[] sample(int i5) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(i5));
        }
        double[] dArr = new double[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            dArr[i6] = sample();
        }
        return dArr;
    }

    public AbstractRealDistribution(RandomGenerator randomGenerator) {
        this.randomData = new RandomDataImpl();
        this.solverAbsoluteAccuracy = 1.0E-6d;
        this.random = randomGenerator;
    }
}
