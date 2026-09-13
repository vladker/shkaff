package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class AbstractDifferentiableUnivariateSolver extends BaseAbstractUnivariateSolver<DifferentiableUnivariateFunction> implements DifferentiableUnivariateSolver {
    private UnivariateFunction functionDerivative;

    public AbstractDifferentiableUnivariateSolver(double d) {
        super(d);
    }

    public double computeDerivativeObjectiveValue(double d) {
        incrementEvaluationCount();
        return this.functionDerivative.value(d);
    }

    public AbstractDifferentiableUnivariateSolver(double d, double d6, double d7) {
        super(d, d6, d7);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public void setup(int i5, DifferentiableUnivariateFunction differentiableUnivariateFunction, double d, double d6, double d7) {
        super.setup(i5, differentiableUnivariateFunction, d, d6, d7);
        this.functionDerivative = differentiableUnivariateFunction.derivative();
    }
}
