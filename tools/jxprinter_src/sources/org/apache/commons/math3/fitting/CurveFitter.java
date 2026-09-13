package org.apache.commons.math3.fitting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.optim.InitialGuess;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.nonlinear.vector.ModelFunction;
import org.apache.commons.math3.optim.nonlinear.vector.ModelFunctionJacobian;
import org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer;
import org.apache.commons.math3.optim.nonlinear.vector.Target;
import org.apache.commons.math3.optim.nonlinear.vector.Weight;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class CurveFitter<T extends ParametricUnivariateFunction> {
    private final List<WeightedObservedPoint> observations = new ArrayList();
    private final MultivariateVectorOptimizer optimizer;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class TheoreticalValuesFunction {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ParametricUnivariateFunction f6768f;

        public TheoreticalValuesFunction(ParametricUnivariateFunction parametricUnivariateFunction) {
            this.f6768f = parametricUnivariateFunction;
        }

        public ModelFunction getModelFunction() {
            return new ModelFunction(new MultivariateVectorFunction() { // from class: org.apache.commons.math3.fitting.CurveFitter.TheoreticalValuesFunction.1
                @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
                public double[] value(double[] dArr) {
                    double[] dArr2 = new double[CurveFitter.this.observations.size()];
                    Iterator it = CurveFitter.this.observations.iterator();
                    int i5 = 0;
                    while (it.hasNext()) {
                        dArr2[i5] = TheoreticalValuesFunction.this.f6768f.value(((WeightedObservedPoint) it.next()).getX(), dArr);
                        i5++;
                    }
                    return dArr2;
                }
            });
        }

        public ModelFunctionJacobian getModelFunctionJacobian() {
            return new ModelFunctionJacobian(new MultivariateMatrixFunction() { // from class: org.apache.commons.math3.fitting.CurveFitter.TheoreticalValuesFunction.2
                @Override // org.apache.commons.math3.analysis.MultivariateMatrixFunction
                public double[][] value(double[] dArr) {
                    double[][] dArr2 = new double[CurveFitter.this.observations.size()][];
                    Iterator it = CurveFitter.this.observations.iterator();
                    int i5 = 0;
                    while (it.hasNext()) {
                        dArr2[i5] = TheoreticalValuesFunction.this.f6768f.gradient(((WeightedObservedPoint) it.next()).getX(), dArr);
                        i5++;
                    }
                    return dArr2;
                }
            });
        }
    }

    public CurveFitter(MultivariateVectorOptimizer multivariateVectorOptimizer) {
        this.optimizer = multivariateVectorOptimizer;
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
        TheoreticalValuesFunction theoreticalValuesFunction = new TheoreticalValuesFunction(t6);
        return this.optimizer.optimize(new MaxEval(i5), theoreticalValuesFunction.getModelFunction(), theoreticalValuesFunction.getModelFunctionJacobian(), new Target(dArr2), new Weight(dArr3), new InitialGuess(dArr)).getPointRef();
    }

    public void addObservedPoint(WeightedObservedPoint weightedObservedPoint) {
        this.observations.add(weightedObservedPoint);
    }
}
