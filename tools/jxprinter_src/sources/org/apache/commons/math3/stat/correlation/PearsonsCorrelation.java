package org.apache.commons.math3.stat.correlation;

import java.lang.reflect.Array;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PearsonsCorrelation {
    private final RealMatrix correlationMatrix;
    private final int nObs;

    public PearsonsCorrelation() {
        this.correlationMatrix = null;
        this.nObs = 0;
    }

    private void checkSufficientData(RealMatrix realMatrix) {
        int rowDimension = realMatrix.getRowDimension();
        int columnDimension = realMatrix.getColumnDimension();
        if (rowDimension < 2 || columnDimension < 2) {
            throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_ROWS_AND_COLUMNS, Integer.valueOf(rowDimension), Integer.valueOf(columnDimension));
        }
    }

    public RealMatrix computeCorrelationMatrix(RealMatrix realMatrix) {
        checkSufficientData(realMatrix);
        int columnDimension = realMatrix.getColumnDimension();
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(columnDimension, columnDimension);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < i5; i6++) {
                double dCorrelation = correlation(realMatrix.getColumn(i5), realMatrix.getColumn(i6));
                blockRealMatrix.setEntry(i5, i6, dCorrelation);
                blockRealMatrix.setEntry(i6, i5, dCorrelation);
            }
            blockRealMatrix.setEntry(i5, i5, 1.0d);
        }
        return blockRealMatrix;
    }

    public double correlation(double[] dArr, double[] dArr2) {
        SimpleRegression simpleRegression = new SimpleRegression();
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        if (dArr.length < 2) {
            throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, Integer.valueOf(dArr.length), 2);
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            simpleRegression.addData(dArr[i5], dArr2[i5]);
        }
        return simpleRegression.getR();
    }

    public RealMatrix covarianceToCorrelation(RealMatrix realMatrix) {
        int columnDimension = realMatrix.getColumnDimension();
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(columnDimension, columnDimension);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            double dSqrt = FastMath.sqrt(realMatrix.getEntry(i5, i5));
            blockRealMatrix.setEntry(i5, i5, 1.0d);
            for (int i6 = 0; i6 < i5; i6++) {
                double entry = realMatrix.getEntry(i5, i6) / (FastMath.sqrt(realMatrix.getEntry(i6, i6)) * dSqrt);
                blockRealMatrix.setEntry(i5, i6, entry);
                blockRealMatrix.setEntry(i6, i5, entry);
            }
        }
        return blockRealMatrix;
    }

    public RealMatrix getCorrelationMatrix() {
        return this.correlationMatrix;
    }

    public RealMatrix getCorrelationPValues() {
        TDistribution tDistribution = new TDistribution(this.nObs - 2);
        int columnDimension = this.correlationMatrix.getColumnDimension();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, columnDimension, columnDimension);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                if (i5 == i6) {
                    dArr[i5][i6] = 0.0d;
                } else {
                    double entry = this.correlationMatrix.getEntry(i5, i6);
                    dArr[i5][i6] = tDistribution.cumulativeProbability(-FastMath.abs(FastMath.sqrt(((double) (this.nObs - 2)) / (1.0d - (entry * entry))) * entry)) * 2.0d;
                }
            }
        }
        return new BlockRealMatrix(dArr);
    }

    public RealMatrix getCorrelationStandardErrors() {
        int columnDimension = this.correlationMatrix.getColumnDimension();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, columnDimension, columnDimension);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                double entry = this.correlationMatrix.getEntry(i5, i6);
                dArr[i5][i6] = FastMath.sqrt((1.0d - (entry * entry)) / ((double) (this.nObs - 2)));
            }
        }
        return new BlockRealMatrix(dArr);
    }

    public PearsonsCorrelation(double[][] dArr) {
        this(new BlockRealMatrix(dArr));
    }

    public PearsonsCorrelation(RealMatrix realMatrix) {
        this.nObs = realMatrix.getRowDimension();
        this.correlationMatrix = computeCorrelationMatrix(realMatrix);
    }

    public PearsonsCorrelation(Covariance covariance) {
        RealMatrix covarianceMatrix = covariance.getCovarianceMatrix();
        if (covarianceMatrix != null) {
            this.nObs = covariance.getN();
            this.correlationMatrix = covarianceToCorrelation(covarianceMatrix);
            return;
        }
        throw new NullArgumentException(LocalizedFormats.COVARIANCE_MATRIX, new Object[0]);
    }

    public RealMatrix computeCorrelationMatrix(double[][] dArr) {
        return computeCorrelationMatrix(new BlockRealMatrix(dArr));
    }

    public PearsonsCorrelation(RealMatrix realMatrix, int i5) {
        this.nObs = i5;
        this.correlationMatrix = covarianceToCorrelation(realMatrix);
    }
}
