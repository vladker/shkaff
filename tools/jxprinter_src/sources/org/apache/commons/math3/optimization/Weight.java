package org.apache.commons.math3.optimization;

import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.linear.NonSquareMatrixException;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Weight implements OptimizationData {
    private final RealMatrix weightMatrix;

    public Weight(double[] dArr) {
        this.weightMatrix = new DiagonalMatrix(dArr);
    }

    public RealMatrix getWeight() {
        return this.weightMatrix.copy();
    }

    public Weight(RealMatrix realMatrix) {
        if (realMatrix.getColumnDimension() == realMatrix.getRowDimension()) {
            this.weightMatrix = realMatrix.copy();
            return;
        }
        throw new NonSquareMatrixException(realMatrix.getColumnDimension(), realMatrix.getRowDimension());
    }
}
