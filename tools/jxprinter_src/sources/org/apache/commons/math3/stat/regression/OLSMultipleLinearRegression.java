package org.apache.commons.math3.stat.regression;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.SecondMoment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OLSMultipleLinearRegression extends AbstractMultipleLinearRegression {
    private QRDecomposition qr;
    private final double threshold;

    public OLSMultipleLinearRegression() {
        this(0.0d);
    }

    public double calculateAdjustedRSquared() {
        double rowDimension = getX().getRowDimension();
        if (isNoIntercept()) {
            return 1.0d - ((rowDimension / (rowDimension - ((double) getX().getColumnDimension()))) * (1.0d - calculateRSquared()));
        }
        return 1.0d - (((rowDimension - 1.0d) * calculateResidualSumOfSquares()) / ((rowDimension - ((double) getX().getColumnDimension())) * calculateTotalSumOfSquares()));
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    public RealVector calculateBeta() {
        return this.qr.getSolver().solve(getY());
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    public RealMatrix calculateBetaVariance() {
        int columnDimension = getX().getColumnDimension() - 1;
        RealMatrix inverse = new LUDecomposition(this.qr.getR().getSubMatrix(0, columnDimension, 0, columnDimension)).getSolver().getInverse();
        return inverse.multiply(inverse.transpose());
    }

    public RealMatrix calculateHat() {
        RealMatrix q6 = this.qr.getQ();
        int columnDimension = this.qr.getR().getColumnDimension();
        int columnDimension2 = q6.getColumnDimension();
        Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(columnDimension2, columnDimension2);
        double[][] dataRef = array2DRowRealMatrix.getDataRef();
        for (int i5 = 0; i5 < columnDimension2; i5++) {
            for (int i6 = 0; i6 < columnDimension2; i6++) {
                if (i5 != i6 || i5 >= columnDimension) {
                    dataRef[i5][i6] = 0.0d;
                } else {
                    dataRef[i5][i6] = 1.0d;
                }
            }
        }
        return q6.multiply(array2DRowRealMatrix).multiply(q6.transpose());
    }

    public double calculateRSquared() {
        return 1.0d - (calculateResidualSumOfSquares() / calculateTotalSumOfSquares());
    }

    public double calculateResidualSumOfSquares() {
        RealVector realVectorCalculateResiduals = calculateResiduals();
        return realVectorCalculateResiduals.dotProduct(realVectorCalculateResiduals);
    }

    public double calculateTotalSumOfSquares() {
        return isNoIntercept() ? StatUtils.sumSq(getY().toArray()) : new SecondMoment().evaluate(getY().toArray());
    }

    public void newSampleData(double[] dArr, double[][] dArr2) {
        validateSampleData(dArr2, dArr);
        newYSampleData(dArr);
        newXSampleData(dArr2);
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    public void newXSampleData(double[][] dArr) {
        super.newXSampleData(dArr);
        this.qr = new QRDecomposition(getX(), this.threshold);
    }

    public OLSMultipleLinearRegression(double d) {
        this.qr = null;
        this.threshold = d;
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    public void newSampleData(double[] dArr, int i5, int i6) {
        super.newSampleData(dArr, i5, i6);
        this.qr = new QRDecomposition(getX(), this.threshold);
    }
}
