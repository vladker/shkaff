package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.IterationManager;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class IterativeLinearSolver {
    private final IterationManager manager;

    public IterativeLinearSolver(int i5) {
        this.manager = new IterationManager(i5);
    }

    public static void checkParameters(RealLinearOperator realLinearOperator, RealVector realVector, RealVector realVector2) {
        MathUtils.checkNotNull(realLinearOperator);
        MathUtils.checkNotNull(realVector);
        MathUtils.checkNotNull(realVector2);
        if (realLinearOperator.getRowDimension() != realLinearOperator.getColumnDimension()) {
            throw new NonSquareOperatorException(realLinearOperator.getRowDimension(), realLinearOperator.getColumnDimension());
        }
        if (realVector.getDimension() != realLinearOperator.getRowDimension()) {
            throw new DimensionMismatchException(realVector.getDimension(), realLinearOperator.getRowDimension());
        }
        if (realVector2.getDimension() != realLinearOperator.getColumnDimension()) {
            throw new DimensionMismatchException(realVector2.getDimension(), realLinearOperator.getColumnDimension());
        }
    }

    public IterationManager getIterationManager() {
        return this.manager;
    }

    public RealVector solve(RealLinearOperator realLinearOperator, RealVector realVector) {
        MathUtils.checkNotNull(realLinearOperator);
        ArrayRealVector arrayRealVector = new ArrayRealVector(realLinearOperator.getColumnDimension());
        arrayRealVector.set(0.0d);
        return solveInPlace(realLinearOperator, realVector, arrayRealVector);
    }

    public abstract RealVector solveInPlace(RealLinearOperator realLinearOperator, RealVector realVector, RealVector realVector2);

    public IterativeLinearSolver(IterationManager iterationManager) {
        MathUtils.checkNotNull(iterationManager);
        this.manager = iterationManager;
    }

    public RealVector solve(RealLinearOperator realLinearOperator, RealVector realVector, RealVector realVector2) {
        MathUtils.checkNotNull(realVector2);
        return solveInPlace(realLinearOperator, realVector, realVector2.copy());
    }
}
