package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.IterationManager;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class PreconditionedIterativeLinearSolver extends IterativeLinearSolver {
    public PreconditionedIterativeLinearSolver(int i5) {
        super(i5);
    }

    public static void checkParameters(RealLinearOperator realLinearOperator, RealLinearOperator realLinearOperator2, RealVector realVector, RealVector realVector2) {
        IterativeLinearSolver.checkParameters(realLinearOperator, realVector, realVector2);
        if (realLinearOperator2 != null) {
            if (realLinearOperator2.getColumnDimension() != realLinearOperator2.getRowDimension()) {
                throw new NonSquareOperatorException(realLinearOperator2.getColumnDimension(), realLinearOperator2.getRowDimension());
            }
            if (realLinearOperator2.getRowDimension() != realLinearOperator.getRowDimension()) {
                throw new DimensionMismatchException(realLinearOperator2.getRowDimension(), realLinearOperator.getRowDimension());
            }
        }
    }

    public RealVector solve(RealLinearOperator realLinearOperator, RealLinearOperator realLinearOperator2, RealVector realVector, RealVector realVector2) {
        MathUtils.checkNotNull(realVector2);
        return solveInPlace(realLinearOperator, realLinearOperator2, realVector, realVector2.copy());
    }

    public abstract RealVector solveInPlace(RealLinearOperator realLinearOperator, RealLinearOperator realLinearOperator2, RealVector realVector, RealVector realVector2);

    @Override // org.apache.commons.math3.linear.IterativeLinearSolver
    public RealVector solveInPlace(RealLinearOperator realLinearOperator, RealVector realVector, RealVector realVector2) {
        return solveInPlace(realLinearOperator, null, realVector, realVector2);
    }

    public PreconditionedIterativeLinearSolver(IterationManager iterationManager) {
        super(iterationManager);
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolver
    public RealVector solve(RealLinearOperator realLinearOperator, RealVector realVector) {
        MathUtils.checkNotNull(realLinearOperator);
        ArrayRealVector arrayRealVector = new ArrayRealVector(realLinearOperator.getColumnDimension());
        arrayRealVector.set(0.0d);
        return solveInPlace(realLinearOperator, null, realVector, arrayRealVector);
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolver
    public RealVector solve(RealLinearOperator realLinearOperator, RealVector realVector, RealVector realVector2) {
        MathUtils.checkNotNull(realVector2);
        return solveInPlace(realLinearOperator, null, realVector, realVector2.copy());
    }

    public RealVector solve(RealLinearOperator realLinearOperator, RealLinearOperator realLinearOperator2, RealVector realVector) {
        MathUtils.checkNotNull(realLinearOperator);
        return solveInPlace(realLinearOperator, realLinearOperator2, realVector, new ArrayRealVector(realLinearOperator.getColumnDimension()));
    }
}
