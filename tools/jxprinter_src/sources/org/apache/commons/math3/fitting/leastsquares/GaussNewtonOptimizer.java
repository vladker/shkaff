package org.apache.commons.math3.fitting.leastsquares;

import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.CholeskyDecomposition;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.NonPositiveDefiniteMatrixException;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.linear.SingularValueDecomposition;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.util.Incrementor;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GaussNewtonOptimizer implements LeastSquaresOptimizer {
    private static final double SINGULARITY_THRESHOLD = 1.0E-11d;
    private final Decomposition decomposition;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Decomposition {
        LU { // from class: org.apache.commons.math3.fitting.leastsquares.GaussNewtonOptimizer.Decomposition.1
            @Override // org.apache.commons.math3.fitting.leastsquares.GaussNewtonOptimizer.Decomposition
            public RealVector solve(RealMatrix realMatrix, RealVector realVector) {
                try {
                    Pair pairComputeNormalMatrix = GaussNewtonOptimizer.computeNormalMatrix(realMatrix, realVector);
                    RealMatrix realMatrix2 = (RealMatrix) pairComputeNormalMatrix.getFirst();
                    return new LUDecomposition(realMatrix2, GaussNewtonOptimizer.SINGULARITY_THRESHOLD).getSolver().solve((RealVector) pairComputeNormalMatrix.getSecond());
                } catch (SingularMatrixException e) {
                    throw new ConvergenceException(LocalizedFormats.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, e);
                }
            }
        },
        QR { // from class: org.apache.commons.math3.fitting.leastsquares.GaussNewtonOptimizer.Decomposition.2
            @Override // org.apache.commons.math3.fitting.leastsquares.GaussNewtonOptimizer.Decomposition
            public RealVector solve(RealMatrix realMatrix, RealVector realVector) {
                try {
                    return new QRDecomposition(realMatrix, GaussNewtonOptimizer.SINGULARITY_THRESHOLD).getSolver().solve(realVector);
                } catch (SingularMatrixException e) {
                    throw new ConvergenceException(LocalizedFormats.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, e);
                }
            }
        },
        CHOLESKY { // from class: org.apache.commons.math3.fitting.leastsquares.GaussNewtonOptimizer.Decomposition.3
            @Override // org.apache.commons.math3.fitting.leastsquares.GaussNewtonOptimizer.Decomposition
            public RealVector solve(RealMatrix realMatrix, RealVector realVector) {
                try {
                    Pair pairComputeNormalMatrix = GaussNewtonOptimizer.computeNormalMatrix(realMatrix, realVector);
                    RealMatrix realMatrix2 = (RealMatrix) pairComputeNormalMatrix.getFirst();
                    return new CholeskyDecomposition(realMatrix2, GaussNewtonOptimizer.SINGULARITY_THRESHOLD, GaussNewtonOptimizer.SINGULARITY_THRESHOLD).getSolver().solve((RealVector) pairComputeNormalMatrix.getSecond());
                } catch (NonPositiveDefiniteMatrixException e) {
                    throw new ConvergenceException(LocalizedFormats.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, e);
                }
            }
        },
        SVD { // from class: org.apache.commons.math3.fitting.leastsquares.GaussNewtonOptimizer.Decomposition.4
            @Override // org.apache.commons.math3.fitting.leastsquares.GaussNewtonOptimizer.Decomposition
            public RealVector solve(RealMatrix realMatrix, RealVector realVector) {
                return new SingularValueDecomposition(realMatrix).getSolver().solve(realVector);
            }
        };

        public abstract RealVector solve(RealMatrix realMatrix, RealVector realVector);
    }

    public GaussNewtonOptimizer() {
        this(Decomposition.QR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Pair<RealMatrix, RealVector> computeNormalMatrix(RealMatrix realMatrix, RealVector realVector) {
        int rowDimension = realMatrix.getRowDimension();
        int columnDimension = realMatrix.getColumnDimension();
        RealMatrix realMatrixCreateRealMatrix = MatrixUtils.createRealMatrix(columnDimension, columnDimension);
        ArrayRealVector arrayRealVector = new ArrayRealVector(columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                arrayRealVector.setEntry(i6, (realMatrix.getEntry(i5, i6) * realVector.getEntry(i5)) + arrayRealVector.getEntry(i6));
            }
            for (int i7 = 0; i7 < columnDimension; i7++) {
                for (int i8 = i7; i8 < columnDimension; i8++) {
                    realMatrixCreateRealMatrix.setEntry(i7, i8, (realMatrix.getEntry(i5, i8) * realMatrix.getEntry(i5, i7)) + realMatrixCreateRealMatrix.getEntry(i7, i8));
                }
            }
        }
        for (int i9 = 0; i9 < columnDimension; i9++) {
            for (int i10 = 0; i10 < i9; i10++) {
                realMatrixCreateRealMatrix.setEntry(i9, i10, realMatrixCreateRealMatrix.getEntry(i10, i9));
            }
        }
        return new Pair<>(realMatrixCreateRealMatrix, arrayRealVector);
    }

    public Decomposition getDecomposition() {
        return this.decomposition;
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer
    public LeastSquaresOptimizer.Optimum optimize(LeastSquaresProblem leastSquaresProblem) {
        Incrementor evaluationCounter = leastSquaresProblem.getEvaluationCounter();
        Incrementor iterationCounter = leastSquaresProblem.getIterationCounter();
        ConvergenceChecker<LeastSquaresProblem.Evaluation> convergenceChecker = leastSquaresProblem.getConvergenceChecker();
        if (convergenceChecker == null) {
            throw new NullArgumentException();
        }
        RealVector start = leastSquaresProblem.getStart();
        LeastSquaresProblem.Evaluation evaluation = null;
        while (true) {
            iterationCounter.incrementCount();
            evaluationCounter.incrementCount();
            LeastSquaresProblem.Evaluation evaluationEvaluate = leastSquaresProblem.evaluate(start);
            RealVector residuals = evaluationEvaluate.getResiduals();
            RealMatrix jacobian = evaluationEvaluate.getJacobian();
            RealVector point = evaluationEvaluate.getPoint();
            if (evaluation != null && convergenceChecker.converged(iterationCounter.getCount(), evaluation, evaluationEvaluate)) {
                return new OptimumImpl(evaluationEvaluate, evaluationCounter.getCount(), iterationCounter.getCount());
            }
            evaluation = evaluationEvaluate;
            start = point.add(this.decomposition.solve(jacobian, residuals));
        }
    }

    public String toString() {
        return "GaussNewtonOptimizer{decomposition=" + this.decomposition + '}';
    }

    public GaussNewtonOptimizer withDecomposition(Decomposition decomposition) {
        return new GaussNewtonOptimizer(decomposition);
    }

    public GaussNewtonOptimizer(Decomposition decomposition) {
        this.decomposition = decomposition;
    }
}
