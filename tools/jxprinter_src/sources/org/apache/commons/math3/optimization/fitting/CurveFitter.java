package org.apache.commons.math3.optimization.fitting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction;
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;
import org.apache.commons.math3.optimization.MultivariateDifferentiableVectorOptimizer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class CurveFitter<T extends ParametricUnivariateFunction> {
    private final List<WeightedObservedPoint> observations;

    @Deprecated
    private final DifferentiableMultivariateVectorOptimizer oldOptimizer;
    private final MultivariateDifferentiableVectorOptimizer optimizer;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Deprecated
    public class OldTheoreticalValuesFunction implements DifferentiableMultivariateVectorFunction {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ParametricUnivariateFunction f6875f;

        public OldTheoreticalValuesFunction(ParametricUnivariateFunction parametricUnivariateFunction) {
            this.f6875f = parametricUnivariateFunction;
        }

        @Override // org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction
        public MultivariateMatrixFunction jacobian() {
            return new MultivariateMatrixFunction() { // from class: org.apache.commons.math3.optimization.fitting.CurveFitter.OldTheoreticalValuesFunction.1
                @Override // org.apache.commons.math3.analysis.MultivariateMatrixFunction
                public double[][] value(double[] dArr) {
                    double[][] dArr2 = new double[CurveFitter.this.observations.size()][];
                    Iterator it = CurveFitter.this.observations.iterator();
                    int i5 = 0;
                    while (it.hasNext()) {
                        dArr2[i5] = OldTheoreticalValuesFunction.this.f6875f.gradient(((WeightedObservedPoint) it.next()).getX(), dArr);
                        i5++;
                    }
                    return dArr2;
                }
            };
        }

        @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
        public double[] value(double[] dArr) {
            double[] dArr2 = new double[CurveFitter.this.observations.size()];
            Iterator it = CurveFitter.this.observations.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                dArr2[i5] = this.f6875f.value(((WeightedObservedPoint) it.next()).getX(), dArr);
                i5++;
            }
            return dArr2;
        }
    }

    @Deprecated
    public CurveFitter(DifferentiableMultivariateVectorOptimizer differentiableMultivariateVectorOptimizer) {
        this.oldOptimizer = differentiableMultivariateVectorOptimizer;
        this.optimizer = null;
        this.observations = new ArrayList();
    }

    public void addObservedPoint(double d, double d6) {
        addObservedPoint(1.0d, d, d6);
    }

    public void clearObservations() {
        this.observations.clear();
    }

    public double[] fit(T t6, double[] dArr) {
        return fit(Integer.MAX_VALUE, t6, dArr);
    }

    public WeightedObservedPoint[] getObservations() {
        List<WeightedObservedPoint> list = this.observations;
        return (WeightedObservedPoint[]) list.toArray(new WeightedObservedPoint[list.size()]);
    }

    public void addObservedPoint(double d, double d6, double d7) {
        this.observations.add(new WeightedObservedPoint(d, d6, d7));
    }

    public double[] fit(int i5, T t6, double[] dArr) {
        double[] dArr2 = new double[this.observations.size()];
        double[] dArr3 = new double[this.observations.size()];
        int i6 = 0;
        for (WeightedObservedPoint weightedObservedPoint : this.observations) {
            dArr2[i6] = weightedObservedPoint.getY();
            dArr3[i6] = weightedObservedPoint.getWeight();
            i6++;
        }
        MultivariateDifferentiableVectorOptimizer multivariateDifferentiableVectorOptimizer = this.optimizer;
        return (multivariateDifferentiableVectorOptimizer == null ? this.oldOptimizer.optimize(i5, new OldTheoreticalValuesFunction(t6), dArr2, dArr3, dArr) : multivariateDifferentiableVectorOptimizer.optimize(i5, new TheoreticalValuesFunction(t6), dArr2, dArr3, dArr)).getPointRef();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class TheoreticalValuesFunction implements MultivariateDifferentiableVectorFunction {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ParametricUnivariateFunction f6876f;

        public TheoreticalValuesFunction(ParametricUnivariateFunction parametricUnivariateFunction) {
            this.f6876f = parametricUnivariateFunction;
        }

        @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
        public double[] value(double[] dArr) {
            double[] dArr2 = new double[CurveFitter.this.observations.size()];
            Iterator it = CurveFitter.this.observations.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                dArr2[i5] = this.f6876f.value(((WeightedObservedPoint) it.next()).getX(), dArr);
                i5++;
            }
            return dArr2;
        }

        @Override // org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction
        public DerivativeStructure[] value(DerivativeStructure[] derivativeStructureArr) {
            double[] dArr = new double[derivativeStructureArr.length];
            for (int i5 = 0; i5 < derivativeStructureArr.length; i5++) {
                dArr[i5] = derivativeStructureArr[i5].getValue();
            }
            DerivativeStructure[] derivativeStructureArr2 = new DerivativeStructure[CurveFitter.this.observations.size()];
            Iterator it = CurveFitter.this.observations.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                DerivativeStructure derivativeStructure = new DerivativeStructure(derivativeStructureArr.length, 1, this.f6876f.value(((WeightedObservedPoint) it.next()).getX(), dArr));
                for (int i7 = 0; i7 < derivativeStructureArr.length; i7++) {
                    derivativeStructure = derivativeStructure.add(new DerivativeStructure(derivativeStructureArr.length, 1, i7, 0.0d));
                }
                derivativeStructureArr2[i6] = derivativeStructure;
                i6++;
            }
            return derivativeStructureArr2;
        }
    }

    public void addObservedPoint(WeightedObservedPoint weightedObservedPoint) {
        this.observations.add(weightedObservedPoint);
    }

    public CurveFitter(MultivariateDifferentiableVectorOptimizer multivariateDifferentiableVectorOptimizer) {
        this.oldOptimizer = null;
        this.optimizer = multivariateDifferentiableVectorOptimizer;
        this.observations = new ArrayList();
    }
}
