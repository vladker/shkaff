package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NewtonRaphsonSolver extends AbstractUnivariateDifferentiableSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    public NewtonRaphsonSolver() {
        this(1.0E-6d);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public double doSolve() {
        double startValue = getStartValue();
        double absoluteAccuracy = getAbsoluteAccuracy();
        while (true) {
            DerivativeStructure derivativeStructureComputeObjectiveValueAndDerivative = computeObjectiveValueAndDerivative(startValue);
            double value = startValue - (derivativeStructureComputeObjectiveValueAndDerivative.getValue() / derivativeStructureComputeObjectiveValueAndDerivative.getPartialDerivative(1));
            if (FastMath.abs(value - startValue) <= absoluteAccuracy) {
                return value;
            }
            startValue = value;
        }
    }

    public NewtonRaphsonSolver(double d) {
        super(d);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver, org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double solve(int i5, UnivariateDifferentiableFunction univariateDifferentiableFunction, double d, double d6) {
        return super.solve(i5, univariateDifferentiableFunction, UnivariateSolverUtils.midpoint(d, d6));
    }
}
