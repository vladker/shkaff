package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PoissonDistribution extends AbstractIntegerDistribution {
    public static final double DEFAULT_EPSILON = 1.0E-12d;
    public static final int DEFAULT_MAX_ITERATIONS = 10000000;
    private static final long serialVersionUID = -3349935121172596109L;
    private final double epsilon;
    private final ExponentialDistribution exponential;
    private final int maxIterations;
    private final double mean;
    private final NormalDistribution normal;

    public PoissonDistribution(double d) {
        this(d, 1.0E-12d, DEFAULT_MAX_ITERATIONS);
    }

    private long nextPoisson(double d) {
        double d6;
        long j6;
        double dSample;
        double d7;
        double d8;
        PoissonDistribution poissonDistribution = this;
        long jNextPoisson = 0;
        double dNextDouble = 1.0d;
        if (d < 40.0d) {
            double dExp = FastMath.exp(-d);
            while (jNextPoisson < 1000.0d * d) {
                dNextDouble *= poissonDistribution.random.nextDouble();
                if (dNextDouble < dExp) {
                    break;
                }
                jNextPoisson++;
            }
            return jNextPoisson;
        }
        double dFloor = FastMath.floor(d);
        double d9 = d - dFloor;
        double dLog = FastMath.log(dFloor);
        double dFactorialLog = CombinatoricsUtils.factorialLog((int) dFloor);
        jNextPoisson = d9 >= Double.MIN_VALUE ? poissonDistribution.nextPoisson(d9) : 0L;
        double dSqrt = FastMath.sqrt(FastMath.log(((32.0d * dFloor) / 3.141592653589793d) + 1.0d) * dFloor);
        double d10 = dSqrt / 2.0d;
        double d11 = dFloor * 2.0d;
        double d12 = d11 + dSqrt;
        double d13 = 1.0d / (8.0d * dFloor);
        double dExp2 = FastMath.exp(d13) * FastMath.sqrt(3.141592653589793d * d12);
        double d14 = d12 / dSqrt;
        double dExp3 = FastMath.exp(((dSqrt + 1.0d) * (-dSqrt)) / d12) * d14;
        double d15 = dExp2 + dExp3 + 1.0d;
        double d16 = dExp2 / d15;
        double d17 = dExp3 / d15;
        while (true) {
            double dNextDouble2 = poissonDistribution.random.nextDouble();
            if (dNextDouble2 <= d16) {
                double dNextGaussian = poissonDistribution.random.nextGaussian();
                dSample = (FastMath.sqrt(dFloor + d10) * dNextGaussian) - 0.5d;
                if (dSample <= dSqrt) {
                    d6 = dSqrt;
                    if (dSample < (-dFloor)) {
                        dSqrt = d6;
                    } else {
                        double dFloor2 = dSample < 0.0d ? FastMath.floor(dSample) : FastMath.ceil(dSample);
                        d7 = ((-poissonDistribution.exponential.sample()) - ((dNextGaussian * dNextGaussian) / 2.0d)) + d13;
                        d8 = dFloor2;
                    }
                } else {
                    continue;
                }
            } else {
                d6 = dSqrt;
                if (dNextDouble2 > d16 + d17) {
                    j6 = jNextPoisson;
                    break;
                }
                dSample = (poissonDistribution.exponential.sample() * d14) + d6;
                double dCeil = FastMath.ceil(dSample);
                d7 = (-poissonDistribution.exponential.sample()) - (((dSample + 1.0d) * d6) / d12);
                d8 = dCeil;
            }
            int i5 = dSample < 0.0d ? 1 : 0;
            double d18 = d8 + 1.0d;
            double d19 = d8;
            double d20 = (d8 * d18) / d11;
            j6 = jNextPoisson;
            if (d7 >= (-d20) || i5 != 0) {
                double d21 = ((((d19 * 2.0d) + 1.0d) / (6.0d * dFloor)) - 1.0d) * d20;
                if (d7 >= d21 - ((d20 * d20) / (((((double) i5) * d18) + dFloor) * 3.0d))) {
                    if (d7 <= d21) {
                        double d22 = d19 + dFloor;
                        if (d7 < ((d19 * dLog) - CombinatoricsUtils.factorialLog((int) d22)) + dFactorialLog) {
                            dFloor = d22;
                            break;
                        }
                    }
                    poissonDistribution = this;
                    dSqrt = d6;
                    jNextPoisson = j6;
                }
            }
            dFloor += d19;
            break;
        }
        return j6 + ((long) dFloor);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int i5) {
        if (i5 < 0) {
            return 0.0d;
        }
        if (i5 == Integer.MAX_VALUE) {
            return 1.0d;
        }
        return Gamma.regularizedGammaQ(((double) i5) + 1.0d, this.mean, this.epsilon, this.maxIterations);
    }

    public double getMean() {
        return this.mean;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        return getMean();
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        return getMean();
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        return 0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        return Integer.MAX_VALUE;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public double logProbability(int i5) {
        if (i5 < 0 || i5 == Integer.MAX_VALUE) {
            return Double.NEGATIVE_INFINITY;
        }
        if (i5 == 0) {
            return -this.mean;
        }
        double d = i5;
        return (((-SaddlePointExpansion.getStirlingError(d)) - SaddlePointExpansion.getDeviancePart(d, this.mean)) - (FastMath.log(6.283185307179586d) * 0.5d)) - (FastMath.log(d) * 0.5d);
    }

    public double normalApproximateProbability(int i5) {
        return this.normal.cumulativeProbability(((double) i5) + 0.5d);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int i5) {
        double dLogProbability = logProbability(i5);
        if (dLogProbability == Double.NEGATIVE_INFINITY) {
            return 0.0d;
        }
        return FastMath.exp(dLogProbability);
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution, org.apache.commons.math3.distribution.IntegerDistribution
    public int sample() {
        return (int) FastMath.min(nextPoisson(this.mean), 2147483647L);
    }

    public PoissonDistribution(double d, double d6, int i5) {
        this(new Well19937c(), d, d6, i5);
    }

    public PoissonDistribution(RandomGenerator randomGenerator, double d, double d6, int i5) {
        super(randomGenerator);
        if (d > 0.0d) {
            this.mean = d;
            this.epsilon = d6;
            this.maxIterations = i5;
            this.normal = new NormalDistribution(randomGenerator, d, FastMath.sqrt(d), 1.0E-9d);
            this.exponential = new ExponentialDistribution(randomGenerator, 1.0d, 1.0E-9d);
            return;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.MEAN, Double.valueOf(d));
    }

    public PoissonDistribution(double d, double d6) {
        this(d, d6, DEFAULT_MAX_ITERATIONS);
    }

    public PoissonDistribution(double d, int i5) {
        this(d, 1.0E-12d, i5);
    }
}
