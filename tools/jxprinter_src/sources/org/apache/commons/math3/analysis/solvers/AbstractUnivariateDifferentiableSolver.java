package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractUnivariateDifferentiableSolver extends BaseAbstractUnivariateSolver<UnivariateDifferentiableFunction> implements UnivariateDifferentiableSolver {
    private UnivariateDifferentiableFunction function;

    public AbstractUnivariateDifferentiableSolver(double d) {
        super(d);
    }

    public DerivativeStructure computeObjectiveValueAndDerivative(double d) {
        incrementEvaluationCount();
        return this.function.value(new DerivativeStructure(1, 1, 0, d));
    }

    public AbstractUnivariateDifferentiableSolver(double d, double d6, double d7) {
        super(d, d6, d7);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public void setup(int i5, UnivariateDifferentiableFunction univariateDifferentiableFunction, double d, double d6, double d7) {
        super.setup(i5, univariateDifferentiableFunction, d, d6, d7);
        this.function = univariateDifferentiableFunction;
    }
}
