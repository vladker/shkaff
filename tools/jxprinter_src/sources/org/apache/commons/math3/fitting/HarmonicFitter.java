package org.apache.commons.math3.fitting;

import androidx.collection.a;
import org.apache.commons.math3.analysis.function.HarmonicOscillator;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class HarmonicFitter extends CurveFitter<HarmonicOscillator.Parametric> {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ParameterGuesser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final double f6770a;
        private final double omega;
        private final double phi;

        public ParameterGuesser(WeightedObservedPoint[] weightedObservedPointArr) {
            if (weightedObservedPointArr.length < 4) {
                throw new NumberIsTooSmallException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, Integer.valueOf(weightedObservedPointArr.length), 4, true);
            }
            WeightedObservedPoint[] weightedObservedPointArrSortObservations = sortObservations(weightedObservedPointArr);
            double[] dArrGuessAOmega = guessAOmega(weightedObservedPointArrSortObservations);
            this.f6770a = dArrGuessAOmega[0];
            this.omega = dArrGuessAOmega[1];
            this.phi = guessPhi(weightedObservedPointArrSortObservations);
        }

        private double[] guessAOmega(WeightedObservedPoint[] weightedObservedPointArr) {
            double[] dArr = new double[2];
            double x6 = weightedObservedPointArr[0].getX();
            double y6 = weightedObservedPointArr[0].getY();
            double d = x6;
            int i5 = 1;
            double d6 = 0.0d;
            double d7 = 0.0d;
            double d8 = 0.0d;
            double d9 = 0.0d;
            double d10 = 0.0d;
            double d11 = 0.0d;
            double d12 = 0.0d;
            while (i5 < weightedObservedPointArr.length) {
                double x7 = weightedObservedPointArr[i5].getX();
                double y7 = weightedObservedPointArr[i5].getY();
                double d13 = x7 - d;
                double d14 = y7 - y6;
                double d15 = (((y7 * y7) + ((y6 * y7) + (y6 * y6))) * d13) / 3.0d;
                double d16 = x7 - x6;
                d11 += d15;
                d12 += (d14 * d14) / d13;
                d10 = (d16 * d16) + d10;
                d6 = (d11 * d11) + d6;
                d8 = (d16 * d11) + d8;
                d7 += d16 * d12;
                d9 = (d11 * d12) + d9;
                i5++;
                d = x7;
                y6 = y7;
            }
            double d17 = (d6 * d7) - (d8 * d9);
            double d18 = (d7 * d8) - (d9 * d10);
            double d19 = (d10 * d6) - (d8 * d8);
            double d20 = d17 / d18;
            if (d20 >= 0.0d) {
                double d21 = d18 / d19;
                if (d21 >= 0.0d) {
                    if (d18 == 0.0d) {
                        throw new MathIllegalStateException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
                    }
                    dArr[0] = FastMath.sqrt(d20);
                    dArr[1] = FastMath.sqrt(d21);
                    return dArr;
                }
            }
            double x8 = weightedObservedPointArr[weightedObservedPointArr.length - 1].getX() - weightedObservedPointArr[0].getX();
            if (x8 == 0.0d) {
                throw new ZeroException();
            }
            dArr[1] = 6.283185307179586d / x8;
            double d22 = Double.POSITIVE_INFINITY;
            double d23 = Double.NEGATIVE_INFINITY;
            for (int i6 = 1; i6 < weightedObservedPointArr.length; i6++) {
                double y8 = weightedObservedPointArr[i6].getY();
                if (y8 < d22) {
                    d22 = y8;
                }
                if (y8 > d23) {
                    d23 = y8;
                }
            }
            dArr[0] = (d23 - d22) * 0.5d;
            return dArr;
        }

        private double guessPhi(WeightedObservedPoint[] weightedObservedPointArr) {
            double x6 = weightedObservedPointArr[0].getX();
            double y6 = weightedObservedPointArr[0].getY();
            double d = 0.0d;
            int i5 = 1;
            double dA = 0.0d;
            while (i5 < weightedObservedPointArr.length) {
                double x7 = weightedObservedPointArr[i5].getX();
                double y7 = weightedObservedPointArr[i5].getY();
                double d6 = (y7 - y6) / (x7 - x6);
                double d7 = this.omega * x7;
                double dCos = FastMath.cos(d7);
                double dSin = FastMath.sin(d7);
                double d8 = this.omega;
                double d9 = (((d8 * y7) * dCos) - (d6 * dSin)) + d;
                dA = a.A(d6, dCos, d8 * y7 * dSin, dA);
                i5++;
                x6 = x7;
                y6 = y7;
                d = d9;
            }
            return FastMath.atan2(-dA, d);
        }

        private WeightedObservedPoint[] sortObservations(WeightedObservedPoint[] weightedObservedPointArr) {
            WeightedObservedPoint[] weightedObservedPointArr2 = (WeightedObservedPoint[]) weightedObservedPointArr.clone();
            WeightedObservedPoint weightedObservedPoint = weightedObservedPointArr2[0];
            for (int i5 = 1; i5 < weightedObservedPointArr2.length; i5++) {
                WeightedObservedPoint weightedObservedPoint2 = weightedObservedPointArr2[i5];
                if (weightedObservedPoint2.getX() < weightedObservedPoint.getX()) {
                    int i6 = i5 - 1;
                    WeightedObservedPoint weightedObservedPoint3 = weightedObservedPointArr2[i6];
                    while (i6 >= 0 && weightedObservedPoint2.getX() < weightedObservedPoint3.getX()) {
                        weightedObservedPointArr2[i6 + 1] = weightedObservedPoint3;
                        int i7 = i6 - 1;
                        if (i6 != 0) {
                            weightedObservedPoint3 = weightedObservedPointArr2[i7];
                        }
                        i6 = i7;
                    }
                    weightedObservedPointArr2[i6 + 1] = weightedObservedPoint2;
                    weightedObservedPoint = weightedObservedPointArr2[i5];
                } else {
                    weightedObservedPoint = weightedObservedPoint2;
                }
            }
            return weightedObservedPointArr2;
        }

        public double[] guess() {
            return new double[]{this.f6770a, this.omega, this.phi};
        }
    }

    public HarmonicFitter(MultivariateVectorOptimizer multivariateVectorOptimizer) {
        super(multivariateVectorOptimizer);
    }

    public double[] fit(double[] dArr) {
        return fit(new HarmonicOscillator.Parametric(), dArr);
    }

    public double[] fit() {
        return fit(new ParameterGuesser(getObservations()).guess());
    }
}
