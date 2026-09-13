package org.apache.commons.math3.optimization.general;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleValueChecker;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class NonLinearConjugateGradientOptimizer extends AbstractScalarDifferentiableOptimizer {
    private double initialStep;
    private double[] point;
    private final Preconditioner preconditioner;
    private final UnivariateSolver solver;
    private final ConjugateGradientFormula updateFormula;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class IdentityPreconditioner implements Preconditioner {
        @Override // org.apache.commons.math3.optimization.general.Preconditioner
        public double[] precondition(double[] dArr, double[] dArr2) {
            return (double[]) dArr2.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class LineSearchFunction implements UnivariateFunction {
        private final double[] searchDirection;

        public LineSearchFunction(double[] dArr) {
            this.searchDirection = dArr;
        }

        @Override // org.apache.commons.math3.analysis.UnivariateFunction
        public double value(double d) {
            double[] dArr = (double[]) NonLinearConjugateGradientOptimizer.this.point.clone();
            for (int i5 = 0; i5 < dArr.length; i5++) {
                dArr[i5] = (this.searchDirection[i5] * d) + dArr[i5];
            }
            double[] dArrComputeObjectiveGradient = NonLinearConjugateGradientOptimizer.this.computeObjectiveGradient(dArr);
            double d6 = 0.0d;
            for (int i6 = 0; i6 < dArrComputeObjectiveGradient.length; i6++) {
                d6 += dArrComputeObjectiveGradient[i6] * this.searchDirection[i6];
            }
            return d6;
        }
    }

    @Deprecated
    public NonLinearConjugateGradientOptimizer(ConjugateGradientFormula conjugateGradientFormula) {
        this(conjugateGradientFormula, new SimpleValueChecker());
    }

    private double findUpperBound(UnivariateFunction univariateFunction, double d, double d6) {
        double dValue = univariateFunction.value(d);
        while (d6 < Double.MAX_VALUE) {
            double d7 = d + d6;
            double dValue2 = univariateFunction.value(d7);
            if (dValue * dValue2 <= 0.0d) {
                return d7;
            }
            d6 *= FastMath.max(2.0d, dValue / dValue2);
        }
        throw new MathIllegalStateException(LocalizedFormats.UNABLE_TO_BRACKET_OPTIMUM_IN_LINE_SEARCH, new Object[0]);
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    public PointValuePair doOptimize() {
        double[] dArr;
        double d;
        ConvergenceChecker<PointValuePair> convergenceChecker = getConvergenceChecker();
        this.point = getStartPoint();
        GoalType goalType = getGoalType();
        double[] dArr2 = this.point;
        int length = dArr2.length;
        double[] dArrComputeObjectiveGradient = computeObjectiveGradient(dArr2);
        if (goalType == GoalType.MINIMIZE) {
            for (int i5 = 0; i5 < length; i5++) {
                dArrComputeObjectiveGradient[i5] = -dArrComputeObjectiveGradient[i5];
            }
        }
        double[] dArrPrecondition = this.preconditioner.precondition(this.point, dArrComputeObjectiveGradient);
        double[] dArr3 = (double[]) dArrPrecondition.clone();
        double d6 = 0.0d;
        for (int i6 = 0; i6 < length; i6++) {
            d6 += dArrComputeObjectiveGradient[i6] * dArr3[i6];
        }
        PointValuePair pointValuePair = null;
        int maxEvaluations = getMaxEvaluations();
        double d7 = d6;
        int i7 = 0;
        double[] dArr4 = dArrPrecondition;
        double[] dArr5 = dArr3;
        while (true) {
            int i8 = i7 + 1;
            PointValuePair pointValuePair2 = new PointValuePair(this.point, computeObjectiveValue(this.point));
            if (pointValuePair != null && convergenceChecker.converged(i8, pointValuePair, pointValuePair2)) {
                return pointValuePair2;
            }
            LineSearchFunction lineSearchFunction = new LineSearchFunction(dArr5);
            double dFindUpperBound = findUpperBound(lineSearchFunction, 0.0d, this.initialStep);
            i7 = i8;
            double dSolve = this.solver.solve(maxEvaluations, lineSearchFunction, 0.0d, dFindUpperBound, 1.0E-15d);
            maxEvaluations -= this.solver.getEvaluations();
            int i9 = 0;
            while (true) {
                dArr = this.point;
                if (i9 >= dArr.length) {
                    break;
                }
                dArr[i9] = (dArr5[i9] * dSolve) + dArr[i9];
                i9++;
            }
            double[] dArrComputeObjectiveGradient2 = computeObjectiveGradient(dArr);
            if (goalType == GoalType.MINIMIZE) {
                for (int i10 = 0; i10 < length; i10++) {
                    dArrComputeObjectiveGradient2[i10] = -dArrComputeObjectiveGradient2[i10];
                }
            }
            double[] dArrPrecondition2 = this.preconditioner.precondition(this.point, dArrComputeObjectiveGradient2);
            double d8 = 0.0d;
            for (int i11 = 0; i11 < length; i11++) {
                d8 = (dArrComputeObjectiveGradient2[i11] * dArrPrecondition2[i11]) + d8;
            }
            if (this.updateFormula == ConjugateGradientFormula.FLETCHER_REEVES) {
                d = d8 / d7;
            } else {
                double d9 = 0.0d;
                for (int i12 = 0; i12 < dArrComputeObjectiveGradient2.length; i12++) {
                    d9 = (dArrComputeObjectiveGradient2[i12] * dArr4[i12]) + d9;
                }
                d = (d8 - d9) / d7;
            }
            if (i7 % length == 0 || d < 0.0d) {
                dArr5 = (double[]) dArrPrecondition2.clone();
            } else {
                for (int i13 = 0; i13 < length; i13++) {
                    dArr5[i13] = (dArr5[i13] * d) + dArrPrecondition2[i13];
                }
            }
            dArr4 = dArrPrecondition2;
            d7 = d8;
            pointValuePair = pointValuePair2;
        }
    }

    public void setInitialStep(double d) {
        if (d <= 0.0d) {
            this.initialStep = 1.0d;
        } else {
            this.initialStep = d;
        }
    }

    public NonLinearConjugateGradientOptimizer(ConjugateGradientFormula conjugateGradientFormula, ConvergenceChecker<PointValuePair> convergenceChecker) {
        this(conjugateGradientFormula, convergenceChecker, new BrentSolver(), new IdentityPreconditioner());
    }

    public NonLinearConjugateGradientOptimizer(ConjugateGradientFormula conjugateGradientFormula, ConvergenceChecker<PointValuePair> convergenceChecker, UnivariateSolver univariateSolver) {
        this(conjugateGradientFormula, convergenceChecker, univariateSolver, new IdentityPreconditioner());
    }

    public NonLinearConjugateGradientOptimizer(ConjugateGradientFormula conjugateGradientFormula, ConvergenceChecker<PointValuePair> convergenceChecker, UnivariateSolver univariateSolver, Preconditioner preconditioner) {
        super(convergenceChecker);
        this.updateFormula = conjugateGradientFormula;
        this.solver = univariateSolver;
        this.preconditioner = preconditioner;
        this.initialStep = 1.0d;
    }
}
