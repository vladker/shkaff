package org.apache.commons.math3.stat.regression;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GLSMultipleLinearRegression extends AbstractMultipleLinearRegression {
    private RealMatrix Omega;
    private RealMatrix OmegaInverse;

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    public RealVector calculateBeta() {
        RealMatrix omegaInverse = getOmegaInverse();
        RealMatrix realMatrixTranspose = getX().transpose();
        return new LUDecomposition(realMatrixTranspose.multiply(omegaInverse).multiply(getX())).getSolver().getInverse().multiply(realMatrixTranspose).multiply(omegaInverse).operate(getY());
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    public RealMatrix calculateBetaVariance() {
        return new LUDecomposition(getX().transpose().multiply(getOmegaInverse()).multiply(getX())).getSolver().getInverse();
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    public double calculateErrorVariance() {
        RealVector realVectorCalculateResiduals = calculateResiduals();
        return realVectorCalculateResiduals.dotProduct(getOmegaInverse().operate(realVectorCalculateResiduals)) / ((double) (getX().getRowDimension() - getX().getColumnDimension()));
    }

    public RealMatrix getOmegaInverse() {
        if (this.OmegaInverse == null) {
            this.OmegaInverse = new LUDecomposition(this.Omega).getSolver().getInverse();
        }
        return this.OmegaInverse;
    }

    public void newCovarianceData(double[][] dArr) {
        this.Omega = new Array2DRowRealMatrix(dArr);
        this.OmegaInverse = null;
    }

    public void newSampleData(double[] dArr, double[][] dArr2, double[][] dArr3) {
        validateSampleData(dArr2, dArr);
        newYSampleData(dArr);
        newXSampleData(dArr2);
        validateCovarianceData(dArr2, dArr3);
        newCovarianceData(dArr3);
    }
}
