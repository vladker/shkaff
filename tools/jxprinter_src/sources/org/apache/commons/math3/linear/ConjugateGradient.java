package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.util.IterationManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ConjugateGradient extends PreconditionedIterativeLinearSolver {
    public static final String OPERATOR = "operator";
    public static final String VECTOR = "vector";
    private boolean check;
    private final double delta;

    public ConjugateGradient(int i5, double d, boolean z6) {
        super(i5);
        this.delta = d;
        this.check = z6;
    }

    public final boolean getCheck() {
        return this.check;
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver
    public RealVector solveInPlace(RealLinearOperator realLinearOperator, RealLinearOperator realLinearOperator2, RealVector realVector, RealVector realVector2) {
        RealVector realVector3;
        PreconditionedIterativeLinearSolver.checkParameters(realLinearOperator, realLinearOperator2, realVector, realVector2);
        IterationManager iterationManager = getIterationManager();
        iterationManager.resetIterationCount();
        double norm = realVector.getNorm() * this.delta;
        RealVector realVectorUnmodifiableRealVector = RealVector.unmodifiableRealVector(realVector);
        iterationManager.incrementIterationCount();
        RealVector realVectorUnmodifiableRealVector2 = RealVector.unmodifiableRealVector(realVector2);
        RealVector realVectorCopy = realVector2.copy();
        RealVector realVectorCombine = realVector.combine(1.0d, -1.0d, realLinearOperator.operate(realVectorCopy));
        RealVector realVectorUnmodifiableRealVector3 = RealVector.unmodifiableRealVector(realVectorCombine);
        double norm2 = realVectorCombine.getNorm();
        RealVector realVectorOperate = realLinearOperator2 == null ? realVectorCombine : null;
        DefaultIterativeLinearSolverEvent defaultIterativeLinearSolverEvent = new DefaultIterativeLinearSolverEvent(this, iterationManager.getIterations(), realVectorUnmodifiableRealVector2, realVectorUnmodifiableRealVector, realVectorUnmodifiableRealVector3, norm2);
        iterationManager.fireInitializationEvent(defaultIterativeLinearSolverEvent);
        if (norm2 <= norm) {
            iterationManager.fireTerminationEvent(defaultIterativeLinearSolverEvent);
            return realVector2;
        }
        double d = 0.0d;
        while (true) {
            iterationManager.incrementIterationCount();
            iterationManager.fireIterationStartedEvent(new DefaultIterativeLinearSolverEvent(this, iterationManager.getIterations(), realVectorUnmodifiableRealVector2, realVectorUnmodifiableRealVector, realVectorUnmodifiableRealVector3, norm2));
            if (realLinearOperator2 != null) {
                realVectorOperate = realLinearOperator2.operate(realVectorCombine);
            }
            double dDotProduct = realVectorCombine.dotProduct(realVectorOperate);
            if (this.check && dDotProduct <= 0.0d) {
                NonPositiveDefiniteOperatorException nonPositiveDefiniteOperatorException = new NonPositiveDefiniteOperatorException();
                ExceptionContext context = nonPositiveDefiniteOperatorException.getContext();
                context.setValue(OPERATOR, realLinearOperator2);
                context.setValue(VECTOR, realVectorCombine);
                throw nonPositiveDefiniteOperatorException;
            }
            if (iterationManager.getIterations() == 2) {
                realVectorCopy.setSubVector(0, realVectorOperate);
                realVector3 = realVectorOperate;
            } else {
                RealVector realVector4 = realVectorOperate;
                realVectorCopy.combineToSelf(dDotProduct / d, 1.0d, realVector4);
                realVector3 = realVector4;
            }
            RealVector realVectorOperate2 = realLinearOperator.operate(realVectorCopy);
            double dDotProduct2 = realVectorCopy.dotProduct(realVectorOperate2);
            if (this.check && dDotProduct2 <= 0.0d) {
                NonPositiveDefiniteOperatorException nonPositiveDefiniteOperatorException2 = new NonPositiveDefiniteOperatorException();
                ExceptionContext context2 = nonPositiveDefiniteOperatorException2.getContext();
                context2.setValue(OPERATOR, realLinearOperator);
                context2.setValue(VECTOR, realVectorCopy);
                throw nonPositiveDefiniteOperatorException2;
            }
            double d6 = dDotProduct / dDotProduct2;
            RealVector realVector5 = realVectorCopy;
            realVector2.combineToSelf(1.0d, d6, realVector5);
            realVectorCopy = realVector5;
            realVectorCombine.combineToSelf(1.0d, -d6, realVectorOperate2);
            norm2 = realVectorCombine.getNorm();
            DefaultIterativeLinearSolverEvent defaultIterativeLinearSolverEvent2 = new DefaultIterativeLinearSolverEvent(this, iterationManager.getIterations(), realVectorUnmodifiableRealVector2, realVectorUnmodifiableRealVector, realVectorUnmodifiableRealVector3, norm2);
            iterationManager.fireIterationPerformedEvent(defaultIterativeLinearSolverEvent2);
            if (norm2 <= norm) {
                iterationManager.fireTerminationEvent(defaultIterativeLinearSolverEvent2);
                return realVector2;
            }
            realVectorOperate = realVector3;
            realVectorCombine = realVectorCombine;
            d = dDotProduct;
        }
    }

    public ConjugateGradient(IterationManager iterationManager, double d, boolean z6) {
        super(iterationManager);
        this.delta = d;
        this.check = z6;
    }
}
