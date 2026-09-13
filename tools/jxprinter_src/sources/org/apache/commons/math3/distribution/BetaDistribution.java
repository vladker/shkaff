package org.apache.commons.math3.distribution;

import androidx.collection.a;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BetaDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -1221965979403477668L;
    private final double alpha;
    private final double beta;
    private final double solverAbsoluteAccuracy;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private double f6762z;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ChengBetaSampler {
        private ChengBetaSampler() {
        }

        private static double algorithmBB(RandomGenerator randomGenerator, double d, double d6, double d7) {
            double dExp;
            double d8;
            double dLog;
            double d9 = d6 + d7;
            double dSqrt = FastMath.sqrt((d9 - 2.0d) / (((2.0d * d6) * d7) - d9));
            double d10 = (1.0d / dSqrt) + d6;
            do {
                double dNextDouble = randomGenerator.nextDouble();
                double dNextDouble2 = randomGenerator.nextDouble();
                double dLog2 = (FastMath.log(dNextDouble) - FastMath.log1p(-dNextDouble)) * dSqrt;
                dExp = FastMath.exp(dLog2) * d6;
                double d11 = dNextDouble * dNextDouble * dNextDouble2;
                d8 = (dLog2 * d10) - 1.3862944d;
                double d12 = (d6 + d8) - dExp;
                if (d12 + 2.609438d >= 5.0d * d11) {
                    break;
                }
                dLog = FastMath.log(d11);
                if (d12 >= dLog) {
                    break;
                }
            } while (((FastMath.log(d9) - FastMath.log(d7 + dExp)) * d9) + d8 < dLog);
            double dMin = FastMath.min(dExp, Double.MAX_VALUE);
            return Precision.equals(d6, d) ? dMin / (d7 + dMin) : d7 / (d7 + dMin);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x00af  */
        /* JADX WARN: Code duplicated, block: B:27:0x0094 A[SYNTHETIC] */
        private static double algorithmBC(RandomGenerator randomGenerator, double d, double d6, double d7) {
            double dExp;
            double dLog;
            double dExp2;
            double d8 = d6 + d7;
            double d9 = 1.0d / d7;
            double d10 = (1.0d + d6) - d7;
            double dB = a.B(d7, 0.0416667d, 0.0138889d, d10) / ((d6 * d9) - 0.777778d);
            double d11 = (((0.25d / d10) + 0.5d) * d7) + 0.25d;
            while (true) {
                double dNextDouble = randomGenerator.nextDouble();
                double dNextDouble2 = randomGenerator.nextDouble();
                double d12 = dNextDouble * dNextDouble2;
                double d13 = dNextDouble * d12;
                if (dNextDouble < 0.5d) {
                    if (((dNextDouble2 * 0.25d) + d13) - d12 >= dB) {
                        continue;
                    } else {
                        dLog = (FastMath.log(dNextDouble) - FastMath.log1p(-dNextDouble)) * d9;
                        dExp2 = FastMath.exp(dLog) * d6;
                        if ((((FastMath.log(d8) - FastMath.log(d7 + dExp2)) + dLog) * d8) - 1.3862944d >= FastMath.log(d13)) {
                            dExp = dExp2;
                            break;
                        }
                    }
                } else {
                    if (d13 <= 0.25d) {
                        dExp = FastMath.exp((FastMath.log(dNextDouble) - FastMath.log1p(-dNextDouble)) * d9) * d6;
                        break;
                    }
                    if (d13 >= d11) {
                        continue;
                    } else {
                        dLog = (FastMath.log(dNextDouble) - FastMath.log1p(-dNextDouble)) * d9;
                        dExp2 = FastMath.exp(dLog) * d6;
                        if ((((FastMath.log(d8) - FastMath.log(d7 + dExp2)) + dLog) * d8) - 1.3862944d >= FastMath.log(d13)) {
                            dExp = dExp2;
                            break;
                        }
                    }
                }
            }
            double dMin = FastMath.min(dExp, Double.MAX_VALUE);
            return Precision.equals(d6, d) ? dMin / (d7 + dMin) : d7 / (d7 + dMin);
        }

        public static double sample(RandomGenerator randomGenerator, double d, double d6) {
            double dMin = FastMath.min(d, d6);
            double dMax = FastMath.max(d, d6);
            return dMin > 1.0d ? algorithmBB(randomGenerator, d, dMin, dMax) : algorithmBC(randomGenerator, d, dMax, dMin);
        }
    }

    public BetaDistribution(double d, double d6) {
        this(d, d6, 1.0E-9d);
    }

    private void recomputeZ() {
        if (Double.isNaN(this.f6762z)) {
            this.f6762z = (Gamma.logGamma(this.beta) + Gamma.logGamma(this.alpha)) - Gamma.logGamma(this.alpha + this.beta);
        }
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        return Beta.regularizedBeta(d, this.alpha, this.beta);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double d) {
        double dLogDensity = logDensity(d);
        if (dLogDensity == Double.NEGATIVE_INFINITY) {
            return 0.0d;
        }
        return FastMath.exp(dLogDensity);
    }

    public double getAlpha() {
        return this.alpha;
    }

    public double getBeta() {
        return this.beta;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        double alpha = getAlpha();
        return alpha / (getBeta() + alpha);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double alpha = getAlpha();
        double beta = getBeta();
        double d = alpha + beta;
        return (alpha * beta) / ((d + 1.0d) * (d * d));
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
        return 1.0d;
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
        recomputeZ();
        if (d < 0.0d || d > 1.0d) {
            return Double.NEGATIVE_INFINITY;
        }
        if (d == 0.0d) {
            if (this.alpha >= 1.0d) {
                return Double.NEGATIVE_INFINITY;
            }
            throw new NumberIsTooSmallException(LocalizedFormats.CANNOT_COMPUTE_BETA_DENSITY_AT_0_FOR_SOME_ALPHA, Double.valueOf(this.alpha), 1, false);
        }
        if (d == 1.0d) {
            if (this.beta >= 1.0d) {
                return Double.NEGATIVE_INFINITY;
            }
            throw new NumberIsTooSmallException(LocalizedFormats.CANNOT_COMPUTE_BETA_DENSITY_AT_1_FOR_SOME_BETA, Double.valueOf(this.beta), 1, false);
        }
        double dLog = FastMath.log(d);
        return a.a(this.beta, 1.0d, FastMath.log1p(-d), (this.alpha - 1.0d) * dLog) - this.f6762z;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double sample() {
        return ChengBetaSampler.sample(this.random, this.alpha, this.beta);
    }

    public BetaDistribution(double d, double d6, double d7) {
        this(new Well19937c(), d, d6, d7);
    }

    public BetaDistribution(RandomGenerator randomGenerator, double d, double d6) {
        this(randomGenerator, d, d6, 1.0E-9d);
    }

    public BetaDistribution(RandomGenerator randomGenerator, double d, double d6, double d7) {
        super(randomGenerator);
        this.alpha = d;
        this.beta = d6;
        this.f6762z = Double.NaN;
        this.solverAbsoluteAccuracy = d7;
    }
}
