package org.apache.commons.math3.optim.nonlinear.scalar.gradient;

import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.GradientMultivariateOptimizer;
import org.apache.commons.math3.optim.nonlinear.scalar.LineSearch;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NonLinearConjugateGradientOptimizer extends GradientMultivariateOptimizer {
    private final LineSearch line;
    private final Preconditioner preconditioner;
    private final Formula updateFormula;

    /* JADX INFO: renamed from: org.apache.commons.math3.optim.nonlinear.scalar.gradient.NonLinearConjugateGradientOptimizer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$optim$nonlinear$scalar$gradient$NonLinearConjugateGradientOptimizer$Formula;

        static {
            int[] iArr = new int[Formula.values().length];
            $SwitchMap$org$apache$commons$math3$optim$nonlinear$scalar$gradient$NonLinearConjugateGradientOptimizer$Formula = iArr;
            try {
                iArr[Formula.FLETCHER_REEVES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$optim$nonlinear$scalar$gradient$NonLinearConjugateGradientOptimizer$Formula[Formula.POLAK_RIBIERE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Deprecated
    public static class BracketingStep implements OptimizationData {
        private final double initialStep;

        public BracketingStep(double d) {
            this.initialStep = d;
        }

        public double getBracketingStep() {
            return this.initialStep;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Formula {
        FLETCHER_REEVES,
        POLAK_RIBIERE
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class IdentityPreconditioner implements Preconditioner {
        @Override // org.apache.commons.math3.optim.nonlinear.scalar.gradient.Preconditioner
        public double[] precondition(double[] dArr, double[] dArr2) {
            return (double[]) dArr2.clone();
        }
    }

    public NonLinearConjugateGradientOptimizer(Formula formula, ConvergenceChecker<PointValuePair> convergenceChecker) {
        this(formula, convergenceChecker, 1.0E-8d, 1.0E-8d, 1.0E-8d, new IdentityPreconditioner());
    }

    private void checkParameters() {
        if (getLowerBound() != null || getUpperBound() != null) {
            throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT, new Object[0]);
        }
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.GradientMultivariateOptimizer, org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public void parseOptimizationData(OptimizationData... optimizationDataArr) {
        super.parseOptimizationData(optimizationDataArr);
        checkParameters();
    }

    @Deprecated
    public NonLinearConjugateGradientOptimizer(Formula formula, ConvergenceChecker<PointValuePair> convergenceChecker, UnivariateSolver univariateSolver) {
        this(formula, convergenceChecker, univariateSolver, new IdentityPreconditioner());
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair doOptimize() {
        double d;
        ConvergenceChecker<PointValuePair> convergenceChecker = getConvergenceChecker();
        double[] startPoint = getStartPoint();
        GoalType goalType = getGoalType();
        int length = startPoint.length;
        double[] dArrComputeObjectiveGradient = computeObjectiveGradient(startPoint);
        if (goalType == GoalType.MINIMIZE) {
            for (int i5 = 0; i5 < length; i5++) {
                dArrComputeObjectiveGradient[i5] = -dArrComputeObjectiveGradient[i5];
            }
        }
        double[] dArrPrecondition = this.preconditioner.precondition(startPoint, dArrComputeObjectiveGradient);
        double[] dArr = (double[]) dArrPrecondition.clone();
        double d6 = 0.0d;
        for (int i6 = 0; i6 < length; i6++) {
            d6 += dArrComputeObjectiveGradient[i6] * dArr[i6];
        }
        PointValuePair pointValuePair = null;
        while (true) {
            incrementIterationCount();
            PointValuePair pointValuePair2 = new PointValuePair(startPoint, computeObjectiveValue(startPoint));
            if (pointValuePair != null && convergenceChecker.converged(getIterations(), pointValuePair, pointValuePair2)) {
                return pointValuePair2;
            }
            double point = this.line.search(startPoint, dArr).getPoint();
            for (int i7 = 0; i7 < startPoint.length; i7++) {
                startPoint[i7] = (dArr[i7] * point) + startPoint[i7];
            }
            double[] dArrComputeObjectiveGradient2 = computeObjectiveGradient(startPoint);
            if (goalType == GoalType.MINIMIZE) {
                for (int i8 = 0; i8 < length; i8++) {
                    dArrComputeObjectiveGradient2[i8] = -dArrComputeObjectiveGradient2[i8];
                }
            }
            double[] dArrPrecondition2 = this.preconditioner.precondition(startPoint, dArrComputeObjectiveGradient2);
            double d7 = 0.0d;
            for (int i9 = 0; i9 < length; i9++) {
                d7 = (dArrComputeObjectiveGradient2[i9] * dArrPrecondition2[i9]) + d7;
            }
            int i10 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$optim$nonlinear$scalar$gradient$NonLinearConjugateGradientOptimizer$Formula[this.updateFormula.ordinal()];
            if (i10 == 1) {
                d = d7 / d6;
            } else {
                if (i10 != 2) {
                    throw new MathInternalError();
                }
                double d8 = 0.0d;
                for (int i11 = 0; i11 < dArrComputeObjectiveGradient2.length; i11++) {
                    d8 = (dArrComputeObjectiveGradient2[i11] * dArrPrecondition[i11]) + d8;
                }
                d = (d7 - d8) / d6;
            }
            if (getIterations() % length == 0 || d < 0.0d) {
                dArr = (double[]) dArrPrecondition2.clone();
            } else {
                for (int i12 = 0; i12 < length; i12++) {
                    dArr[i12] = (dArr[i12] * d) + dArrPrecondition2[i12];
                }
            }
            dArrPrecondition = dArrPrecondition2;
            pointValuePair = pointValuePair2;
            d6 = d7;
        }
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.GradientMultivariateOptimizer, org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair optimize(OptimizationData... optimizationDataArr) {
        return super.optimize(optimizationDataArr);
    }

    public NonLinearConjugateGradientOptimizer(Formula formula, ConvergenceChecker<PointValuePair> convergenceChecker, double d, double d6, double d7) {
        this(formula, convergenceChecker, d, d6, d7, new IdentityPreconditioner());
    }

    @Deprecated
    public NonLinearConjugateGradientOptimizer(Formula formula, ConvergenceChecker<PointValuePair> convergenceChecker, UnivariateSolver univariateSolver, Preconditioner preconditioner) {
        this(formula, convergenceChecker, univariateSolver.getRelativeAccuracy(), univariateSolver.getAbsoluteAccuracy(), univariateSolver.getAbsoluteAccuracy(), preconditioner);
    }

    public NonLinearConjugateGradientOptimizer(Formula formula, ConvergenceChecker<PointValuePair> convergenceChecker, double d, double d6, double d7, Preconditioner preconditioner) {
        super(convergenceChecker);
        this.updateFormula = formula;
        this.preconditioner = preconditioner;
        this.line = new LineSearch(this, d, d6, d7);
    }
}
