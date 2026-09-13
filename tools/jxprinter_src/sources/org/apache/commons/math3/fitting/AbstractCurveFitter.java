package org.apache.commons.math3.fitting;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractCurveFitter {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TheoreticalValuesFunction {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ParametricUnivariateFunction f6767f;
        private final double[] points;

        public TheoreticalValuesFunction(ParametricUnivariateFunction parametricUnivariateFunction, Collection<WeightedObservedPoint> collection) {
            this.f6767f = parametricUnivariateFunction;
            this.points = new double[collection.size()];
            Iterator<WeightedObservedPoint> it = collection.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                this.points[i5] = it.next().getX();
                i5++;
            }
        }

        public MultivariateVectorFunction getModelFunction() {
            return new MultivariateVectorFunction() { // from class: org.apache.commons.math3.fitting.AbstractCurveFitter.TheoreticalValuesFunction.1
                @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
                public double[] value(double[] dArr) {
                    int length = TheoreticalValuesFunction.this.points.length;
                    double[] dArr2 = new double[length];
                    for (int i5 = 0; i5 < length; i5++) {
                        dArr2[i5] = TheoreticalValuesFunction.this.f6767f.value(TheoreticalValuesFunction.this.points[i5], dArr);
                    }
                    return dArr2;
                }
            };
        }

        public MultivariateMatrixFunction getModelFunctionJacobian() {
            return new MultivariateMatrixFunction() { // from class: org.apache.commons.math3.fitting.AbstractCurveFitter.TheoreticalValuesFunction.2
                @Override // org.apache.commons.math3.analysis.MultivariateMatrixFunction
                public double[][] value(double[] dArr) {
                    int length = TheoreticalValuesFunction.this.points.length;
                    double[][] dArr2 = new double[length][];
                    for (int i5 = 0; i5 < length; i5++) {
                        dArr2[i5] = TheoreticalValuesFunction.this.f6767f.gradient(TheoreticalValuesFunction.this.points[i5], dArr);
                    }
                    return dArr2;
                }
            };
        }
    }

    public double[] fit(Collection<WeightedObservedPoint> collection) {
        return getOptimizer().optimize(getProblem(collection)).getPoint().toArray();
    }

    public LeastSquaresOptimizer getOptimizer() {
        return new LevenbergMarquardtOptimizer();
    }

    public abstract LeastSquaresProblem getProblem(Collection<WeightedObservedPoint> collection);
}
