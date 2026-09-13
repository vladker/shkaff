package org.apache.commons.math3.stat.regression;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.InsufficientDataException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.NonSquareMatrixException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractMultipleLinearRegression implements MultipleLinearRegression {
    private boolean noIntercept = false;
    private RealMatrix xMatrix;
    private RealVector yVector;

    public abstract RealVector calculateBeta();

    public abstract RealMatrix calculateBetaVariance();

    public double calculateErrorVariance() {
        RealVector realVectorCalculateResiduals = calculateResiduals();
        return realVectorCalculateResiduals.dotProduct(realVectorCalculateResiduals) / ((double) (this.xMatrix.getRowDimension() - this.xMatrix.getColumnDimension()));
    }

    public RealVector calculateResiduals() {
        return this.yVector.subtract(this.xMatrix.operate(calculateBeta()));
    }

    public double calculateYVariance() {
        return new Variance().evaluate(this.yVector.toArray());
    }

    public double estimateErrorVariance() {
        return calculateErrorVariance();
    }

    @Override // org.apache.commons.math3.stat.regression.MultipleLinearRegression
    public double estimateRegressandVariance() {
        return calculateYVariance();
    }

    @Override // org.apache.commons.math3.stat.regression.MultipleLinearRegression
    public double[] estimateRegressionParameters() {
        return calculateBeta().toArray();
    }

    @Override // org.apache.commons.math3.stat.regression.MultipleLinearRegression
    public double[] estimateRegressionParametersStandardErrors() {
        double[][] dArrEstimateRegressionParametersVariance = estimateRegressionParametersVariance();
        double dCalculateErrorVariance = calculateErrorVariance();
        int length = dArrEstimateRegressionParametersVariance[0].length;
        double[] dArr = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr[i5] = FastMath.sqrt(dArrEstimateRegressionParametersVariance[i5][i5] * dCalculateErrorVariance);
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.stat.regression.MultipleLinearRegression
    public double[][] estimateRegressionParametersVariance() {
        return calculateBetaVariance().getData();
    }

    public double estimateRegressionStandardError() {
        return FastMath.sqrt(estimateErrorVariance());
    }

    @Override // org.apache.commons.math3.stat.regression.MultipleLinearRegression
    public double[] estimateResiduals() {
        return this.yVector.subtract(this.xMatrix.operate(calculateBeta())).toArray();
    }

    public RealMatrix getX() {
        return this.xMatrix;
    }

    public RealVector getY() {
        return this.yVector;
    }

    public boolean isNoIntercept() {
        return this.noIntercept;
    }

    public void newSampleData(double[] dArr, int i5, int i6) {
        if (dArr == null) {
            throw new NullArgumentException();
        }
        int i7 = i6 + 1;
        int i8 = i5 * i7;
        if (dArr.length != i8) {
            throw new DimensionMismatchException(dArr.length, i8);
        }
        if (i5 <= i6) {
            throw new InsufficientDataException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, Integer.valueOf(i5), Integer.valueOf(i7));
        }
        double[] dArr2 = new double[i5];
        if (!this.noIntercept) {
            i6 = i7;
        }
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, i6);
        int i9 = 0;
        int i10 = 0;
        while (i9 < i5) {
            int i11 = i10 + 1;
            dArr2[i9] = dArr[i10];
            boolean z6 = this.noIntercept;
            if (!z6) {
                dArr3[i9][0] = 1.0d;
            }
            int i12 = !z6 ? 1 : 0;
            while (i12 < i6) {
                dArr3[i9][i12] = dArr[i11];
                i12++;
                i11++;
            }
            i9++;
            i10 = i11;
        }
        this.xMatrix = new Array2DRowRealMatrix(dArr3);
        this.yVector = new ArrayRealVector(dArr2);
    }

    public void newXSampleData(double[][] dArr) {
        if (dArr == null) {
            throw new NullArgumentException();
        }
        if (dArr.length == 0) {
            throw new NoDataException();
        }
        if (this.noIntercept) {
            this.xMatrix = new Array2DRowRealMatrix(dArr, true);
            return;
        }
        int length = dArr[0].length;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, dArr.length, length + 1);
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double[] dArr3 = dArr[i5];
            if (dArr3.length != length) {
                throw new DimensionMismatchException(dArr[i5].length, length);
            }
            double[] dArr4 = dArr2[i5];
            dArr4[0] = 1.0d;
            System.arraycopy(dArr3, 0, dArr4, 1, length);
        }
        this.xMatrix = new Array2DRowRealMatrix(dArr2, false);
    }

    public void newYSampleData(double[] dArr) {
        if (dArr == null) {
            throw new NullArgumentException();
        }
        if (dArr.length == 0) {
            throw new NoDataException();
        }
        this.yVector = new ArrayRealVector(dArr);
    }

    public void setNoIntercept(boolean z6) {
        this.noIntercept = z6;
    }

    public void validateCovarianceData(double[][] dArr, double[][] dArr2) {
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        if (dArr2.length > 0 && dArr2.length != dArr2[0].length) {
            throw new NonSquareMatrixException(dArr2.length, dArr2[0].length);
        }
    }

    public void validateSampleData(double[][] dArr, double[] dArr2) {
        if (dArr == null || dArr2 == null) {
            throw new NullArgumentException();
        }
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr2.length, dArr.length);
        }
        if (dArr.length == 0) {
            throw new NoDataException();
        }
        if (dArr[0].length + 1 > dArr.length) {
            throw new MathIllegalArgumentException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, Integer.valueOf(dArr.length), Integer.valueOf(dArr[0].length));
        }
    }
}
