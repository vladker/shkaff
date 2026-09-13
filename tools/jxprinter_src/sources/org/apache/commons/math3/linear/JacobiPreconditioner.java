package org.apache.commons.math3.linear;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Sqrt;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class JacobiPreconditioner extends RealLinearOperator {
    private final ArrayRealVector diag;

    public JacobiPreconditioner(double[] dArr, boolean z6) {
        this.diag = new ArrayRealVector(dArr, z6);
    }

    public static JacobiPreconditioner create(RealLinearOperator realLinearOperator) {
        int columnDimension = realLinearOperator.getColumnDimension();
        if (realLinearOperator.getRowDimension() != columnDimension) {
            throw new NonSquareOperatorException(realLinearOperator.getRowDimension(), columnDimension);
        }
        double[] dArr = new double[columnDimension];
        if (realLinearOperator instanceof AbstractRealMatrix) {
            AbstractRealMatrix abstractRealMatrix = (AbstractRealMatrix) realLinearOperator;
            for (int i5 = 0; i5 < columnDimension; i5++) {
                dArr[i5] = abstractRealMatrix.getEntry(i5, i5);
            }
        } else {
            ArrayRealVector arrayRealVector = new ArrayRealVector(columnDimension);
            for (int i6 = 0; i6 < columnDimension; i6++) {
                arrayRealVector.set(0.0d);
                arrayRealVector.setEntry(i6, 1.0d);
                dArr[i6] = realLinearOperator.operate(arrayRealVector).getEntry(i6);
            }
        }
        return new JacobiPreconditioner(dArr, false);
    }

    @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.diag.getDimension();
    }

    @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.diag.getDimension();
    }

    @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.RealMatrix
    public RealVector operate(RealVector realVector) {
        return new ArrayRealVector(MathArrays.ebeDivide(realVector.toArray(), this.diag.toArray()), false);
    }

    public RealLinearOperator sqrt() {
        final ArrayRealVector map = this.diag.map((UnivariateFunction) new Sqrt());
        return new RealLinearOperator() { // from class: org.apache.commons.math3.linear.JacobiPreconditioner.1
            @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
            public int getColumnDimension() {
                return map.getDimension();
            }

            @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
            public int getRowDimension() {
                return map.getDimension();
            }

            @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.RealMatrix
            public RealVector operate(RealVector realVector) {
                return new ArrayRealVector(MathArrays.ebeDivide(realVector.toArray(), map.toArray()), false);
            }
        };
    }
}
