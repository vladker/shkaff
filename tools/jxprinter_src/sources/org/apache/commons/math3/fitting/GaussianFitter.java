package org.apache.commons.math3.fitting;

import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.analysis.function.Gaussian;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class GaussianFitter extends CurveFitter<Gaussian.Parametric> {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ParameterGuesser {
        private final double mean;
        private final double norm;
        private final double sigma;

        public ParameterGuesser(WeightedObservedPoint[] weightedObservedPointArr) {
            if (weightedObservedPointArr == null) {
                throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
            }
            if (weightedObservedPointArr.length < 3) {
                throw new NumberIsTooSmallException(Integer.valueOf(weightedObservedPointArr.length), 3, true);
            }
            double[] dArrBasicGuess = basicGuess(sortObservations(weightedObservedPointArr));
            this.norm = dArrBasicGuess[0];
            this.mean = dArrBasicGuess[1];
            this.sigma = dArrBasicGuess[2];
        }

        private double[] basicGuess(WeightedObservedPoint[] weightedObservedPointArr) {
            double x6;
            int iFindMaxY = findMaxY(weightedObservedPointArr);
            double y6 = weightedObservedPointArr[iFindMaxY].getY();
            double x7 = weightedObservedPointArr[iFindMaxY].getX();
            double d = ((x7 - y6) / 2.0d) + y6;
            try {
                x6 = interpolateXAtY(weightedObservedPointArr, iFindMaxY, 1, d) - interpolateXAtY(weightedObservedPointArr, iFindMaxY, -1, d);
            } catch (OutOfRangeException unused) {
                x6 = weightedObservedPointArr[weightedObservedPointArr.length - 1].getX() - weightedObservedPointArr[0].getX();
            }
            return new double[]{y6, x7, x6 / (FastMath.sqrt(FastMath.log(2.0d) * 2.0d) * 2.0d)};
        }

        private int findMaxY(WeightedObservedPoint[] weightedObservedPointArr) {
            int i5 = 0;
            for (int i6 = 1; i6 < weightedObservedPointArr.length; i6++) {
                if (weightedObservedPointArr[i6].getY() > weightedObservedPointArr[i5].getY()) {
                    i5 = i6;
                }
            }
            return i5;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0025  */
        /* JADX WARN: Code duplicated, block: B:15:0x002a  */
        /* JADX WARN: Code duplicated, block: B:17:0x002f A[LOOP:0: B:3:0x0002->B:17:0x002f, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:24:0x0023 A[SYNTHETIC] */
        private WeightedObservedPoint[] getInterpolationPointsForY(WeightedObservedPoint[] weightedObservedPointArr, int i5, int i6, double d) {
            WeightedObservedPoint weightedObservedPoint;
            WeightedObservedPoint weightedObservedPoint2;
            double d6;
            if (i6 == 0) {
                throw new ZeroException();
            }
            while (true) {
                int i7 = i5 + i6;
                if (i6 < 0) {
                    if (i7 < 0) {
                        break;
                    }
                    weightedObservedPoint = weightedObservedPointArr[i5];
                    i5 += i6;
                    weightedObservedPoint2 = weightedObservedPointArr[i5];
                    d6 = d;
                    if (isBetween(d6, weightedObservedPoint.getY(), weightedObservedPoint2.getY())) {
                        return i6 < 0 ? new WeightedObservedPoint[]{weightedObservedPoint2, weightedObservedPoint} : new WeightedObservedPoint[]{weightedObservedPoint, weightedObservedPoint2};
                    }
                    d = d6;
                } else {
                    if (i7 >= weightedObservedPointArr.length) {
                        break;
                    }
                    weightedObservedPoint = weightedObservedPointArr[i5];
                    i5 += i6;
                    weightedObservedPoint2 = weightedObservedPointArr[i5];
                    d6 = d;
                    if (isBetween(d6, weightedObservedPoint.getY(), weightedObservedPoint2.getY())) {
                        if (i6 < 0) {
                        }
                    }
                    d = d6;
                }
            }
            throw new OutOfRangeException(Double.valueOf(d), Double.valueOf(Double.NEGATIVE_INFINITY), Double.valueOf(Double.POSITIVE_INFINITY));
        }

        private double interpolateXAtY(WeightedObservedPoint[] weightedObservedPointArr, int i5, int i6, double d) {
            if (i6 == 0) {
                throw new ZeroException();
            }
            WeightedObservedPoint[] interpolationPointsForY = getInterpolationPointsForY(weightedObservedPointArr, i5, i6, d);
            WeightedObservedPoint weightedObservedPoint = interpolationPointsForY[0];
            WeightedObservedPoint weightedObservedPoint2 = interpolationPointsForY[1];
            if (weightedObservedPoint.getY() == d) {
                return weightedObservedPoint.getX();
            }
            if (weightedObservedPoint2.getY() == d) {
                return weightedObservedPoint2.getX();
            }
            return (((weightedObservedPoint2.getX() - weightedObservedPoint.getX()) * (d - weightedObservedPoint.getY())) / (weightedObservedPoint2.getY() - weightedObservedPoint.getY())) + weightedObservedPoint.getX();
        }

        private boolean isBetween(double d, double d6, double d7) {
            if (d < d6 || d > d7) {
                return d >= d7 && d <= d6;
            }
            return true;
        }

        private WeightedObservedPoint[] sortObservations(WeightedObservedPoint[] weightedObservedPointArr) {
            WeightedObservedPoint[] weightedObservedPointArr2 = (WeightedObservedPoint[]) weightedObservedPointArr.clone();
            Arrays.sort(weightedObservedPointArr2, new Comparator<WeightedObservedPoint>() { // from class: org.apache.commons.math3.fitting.GaussianFitter.ParameterGuesser.1
                @Override // java.util.Comparator
                public int compare(WeightedObservedPoint weightedObservedPoint, WeightedObservedPoint weightedObservedPoint2) {
                    if (weightedObservedPoint == null && weightedObservedPoint2 == null) {
                        return 0;
                    }
                    if (weightedObservedPoint == null) {
                        return -1;
                    }
                    if (weightedObservedPoint2 == null) {
                        return 1;
                    }
                    int iCompare = Double.compare(weightedObservedPoint.getX(), weightedObservedPoint2.getX());
                    if (iCompare < 0) {
                        return -1;
                    }
                    if (iCompare > 0) {
                        return 1;
                    }
                    int iCompare2 = Double.compare(weightedObservedPoint.getY(), weightedObservedPoint2.getY());
                    if (iCompare2 < 0) {
                        return -1;
                    }
                    if (iCompare2 > 0) {
                        return 1;
                    }
                    int iCompare3 = Double.compare(weightedObservedPoint.getWeight(), weightedObservedPoint2.getWeight());
                    if (iCompare3 < 0) {
                        return -1;
                    }
                    return iCompare3 > 0 ? 1 : 0;
                }
            });
            return weightedObservedPointArr2;
        }

        public double[] guess() {
            return new double[]{this.norm, this.mean, this.sigma};
        }
    }

    public GaussianFitter(MultivariateVectorOptimizer multivariateVectorOptimizer) {
        super(multivariateVectorOptimizer);
    }

    public double[] fit(double[] dArr) {
        return fit(new Gaussian.Parametric() { // from class: org.apache.commons.math3.fitting.GaussianFitter.1
            @Override // org.apache.commons.math3.analysis.function.Gaussian.Parametric, org.apache.commons.math3.analysis.ParametricUnivariateFunction
            public double[] gradient(double d, double... dArr2) {
                try {
                    return super.gradient(d, dArr2);
                } catch (NotStrictlyPositiveException unused) {
                    return new double[]{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
                }
            }

            @Override // org.apache.commons.math3.analysis.function.Gaussian.Parametric, org.apache.commons.math3.analysis.ParametricUnivariateFunction
            public double value(double d, double... dArr2) {
                try {
                    return super.value(d, dArr2);
                } catch (NotStrictlyPositiveException unused) {
                    return Double.POSITIVE_INFINITY;
                }
            }
        }, dArr);
    }

    public double[] fit() {
        return fit(new ParameterGuesser(getObservations()).guess());
    }
}
