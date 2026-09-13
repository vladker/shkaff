package org.apache.commons.math3.optim.nonlinear.vector.jacobian;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.PointVectorValuePair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class GaussNewtonOptimizer extends AbstractLeastSquaresOptimizer {
    private final boolean useLU;

    public GaussNewtonOptimizer(ConvergenceChecker<PointVectorValuePair> convergenceChecker) {
        this(true, convergenceChecker);
    }

    private void checkParameters() {
        if (getLowerBound() != null || getUpperBound() != null) {
            throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT, new Object[0]);
        }
    }

    public GaussNewtonOptimizer(boolean z6, ConvergenceChecker<PointVectorValuePair> convergenceChecker) {
        super(convergenceChecker);
        this.useLU = z6;
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public PointVectorValuePair doOptimize() {
        checkParameters();
        ConvergenceChecker<PointVectorValuePair> convergenceChecker = getConvergenceChecker();
        if (convergenceChecker == null) {
            throw new NullArgumentException();
        }
        int length = getTarget().length;
        RealMatrix weight = getWeight();
        double[] dArr = new double[length];
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            dArr[i6] = weight.getEntry(i6, i6);
        }
        double[] startPoint = getStartPoint();
        int length2 = startPoint.length;
        PointVectorValuePair pointVectorValuePair = null;
        boolean zConverged = false;
        while (!zConverged) {
            incrementIterationCount();
            double[] dArrComputeObjectiveValue = computeObjectiveValue(startPoint);
            double[] dArrComputeResiduals = computeResiduals(dArrComputeObjectiveValue);
            RealMatrix realMatrixComputeWeightedJacobian = computeWeightedJacobian(startPoint);
            PointVectorValuePair pointVectorValuePair2 = new PointVectorValuePair(startPoint, dArrComputeObjectiveValue);
            double[] dArr2 = new double[length2];
            int[] iArr = new int[2];
            iArr[1] = length2;
            iArr[i5] = length2;
            double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr);
            int i7 = i5;
            while (i7 < length) {
                double[] row = realMatrixComputeWeightedJacobian.getRow(i7);
                double d = dArr[i7];
                double d6 = dArrComputeResiduals[i7] * d;
                while (i5 < length2) {
                    dArr2[i5] = (row[i5] * d6) + dArr2[i5];
                    i5++;
                }
                int i8 = 0;
                while (i8 < length2) {
                    double[] dArr4 = dArr3[i8];
                    double d7 = row[i8] * d;
                    int i9 = length;
                    for (int i10 = 0; i10 < length2; i10++) {
                        dArr4[i10] = (row[i10] * d7) + dArr4[i10];
                    }
                    i8++;
                    length = i9;
                }
                i7++;
                i5 = 0;
            }
            int i11 = length;
            if (pointVectorValuePair != null && (zConverged = convergenceChecker.converged(getIterations(), pointVectorValuePair, pointVectorValuePair2))) {
                setCost(computeCost(dArrComputeResiduals));
                return pointVectorValuePair2;
            }
            try {
                BlockRealMatrix blockRealMatrix = new BlockRealMatrix(dArr3);
                double[] array = (this.useLU ? new LUDecomposition(blockRealMatrix).getSolver() : new QRDecomposition(blockRealMatrix).getSolver()).solve(new ArrayRealVector(dArr2, false)).toArray();
                for (int i12 = 0; i12 < length2; i12++) {
                    startPoint[i12] = startPoint[i12] + array[i12];
                }
                pointVectorValuePair = pointVectorValuePair2;
                length = i11;
                i5 = 0;
            } catch (SingularMatrixException unused) {
                throw new ConvergenceException(LocalizedFormats.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, new Object[0]);
            }
        }
        throw new MathInternalError();
    }
}
