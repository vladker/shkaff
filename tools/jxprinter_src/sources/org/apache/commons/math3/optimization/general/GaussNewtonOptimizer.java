package org.apache.commons.math3.optimization.general;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.SimpleVectorValueChecker;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class GaussNewtonOptimizer extends AbstractLeastSquaresOptimizer {
    private final boolean useLU;

    @Deprecated
    public GaussNewtonOptimizer() {
        this(true);
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer
    public PointVectorValuePair doOptimize() {
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
        int i7 = 0;
        while (!zConverged) {
            i7++;
            double[] dArrComputeObjectiveValue = computeObjectiveValue(startPoint);
            double[] dArrComputeResiduals = computeResiduals(dArrComputeObjectiveValue);
            RealMatrix realMatrixComputeWeightedJacobian = computeWeightedJacobian(startPoint);
            PointVectorValuePair pointVectorValuePair2 = new PointVectorValuePair(startPoint, dArrComputeObjectiveValue);
            double[] dArr2 = new double[length2];
            int[] iArr = new int[2];
            iArr[1] = length2;
            iArr[i5] = length2;
            double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr);
            int i8 = i5;
            while (i8 < length) {
                double[] row = realMatrixComputeWeightedJacobian.getRow(i8);
                double d = dArr[i8];
                double d6 = dArrComputeResiduals[i8] * d;
                while (i5 < length2) {
                    dArr2[i5] = (row[i5] * d6) + dArr2[i5];
                    i5++;
                }
                int i9 = 0;
                while (i9 < length2) {
                    double[] dArr4 = dArr3[i9];
                    double d7 = row[i9] * d;
                    int i10 = length;
                    for (int i11 = 0; i11 < length2; i11++) {
                        dArr4[i11] = (row[i11] * d7) + dArr4[i11];
                    }
                    i9++;
                    length = i10;
                }
                i8++;
                i5 = 0;
            }
            int i12 = length;
            try {
                BlockRealMatrix blockRealMatrix = new BlockRealMatrix(dArr3);
                double[] array = (this.useLU ? new LUDecomposition(blockRealMatrix).getSolver() : new QRDecomposition(blockRealMatrix).getSolver()).solve(new ArrayRealVector(dArr2, false)).toArray();
                for (int i13 = 0; i13 < length2; i13++) {
                    startPoint[i13] = startPoint[i13] + array[i13];
                }
                if (pointVectorValuePair != null && (zConverged = convergenceChecker.converged(i7, pointVectorValuePair, pointVectorValuePair2))) {
                    this.cost = computeCost(dArrComputeResiduals);
                    this.point = pointVectorValuePair2.getPoint();
                    return pointVectorValuePair2;
                }
                pointVectorValuePair = pointVectorValuePair2;
                length = i12;
                i5 = 0;
            } catch (SingularMatrixException unused) {
                throw new ConvergenceException(LocalizedFormats.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, new Object[0]);
            }
        }
        throw new MathInternalError();
    }

    public GaussNewtonOptimizer(ConvergenceChecker<PointVectorValuePair> convergenceChecker) {
        this(true, convergenceChecker);
    }

    @Deprecated
    public GaussNewtonOptimizer(boolean z6) {
        this(z6, new SimpleVectorValueChecker());
    }

    public GaussNewtonOptimizer(boolean z6, ConvergenceChecker<PointVectorValuePair> convergenceChecker) {
        super(convergenceChecker);
        this.useLU = z6;
    }
}
