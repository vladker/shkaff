package org.apache.commons.math3.stat.correlation;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Covariance {
    private final RealMatrix covarianceMatrix;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f6911n;

    public Covariance() {
        this.covarianceMatrix = null;
        this.f6911n = 0;
    }

    private void checkSufficientData(RealMatrix realMatrix) {
        int rowDimension = realMatrix.getRowDimension();
        int columnDimension = realMatrix.getColumnDimension();
        if (rowDimension < 2 || columnDimension < 1) {
            throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_ROWS_AND_COLUMNS, Integer.valueOf(rowDimension), Integer.valueOf(columnDimension));
        }
    }

    public RealMatrix computeCovarianceMatrix(RealMatrix realMatrix, boolean z6) {
        int columnDimension = realMatrix.getColumnDimension();
        Variance variance = new Variance(z6);
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(columnDimension, columnDimension);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < i5; i6++) {
                double dCovariance = covariance(realMatrix.getColumn(i5), realMatrix.getColumn(i6), z6);
                blockRealMatrix.setEntry(i5, i6, dCovariance);
                blockRealMatrix.setEntry(i6, i5, dCovariance);
            }
            blockRealMatrix.setEntry(i5, i5, variance.evaluate(realMatrix.getColumn(i5)));
        }
        return blockRealMatrix;
    }

    public double covariance(double[] dArr, double[] dArr2, boolean z6) {
        Mean mean = new Mean();
        int length = dArr.length;
        if (length != dArr2.length) {
            throw new MathIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, Integer.valueOf(length), Integer.valueOf(dArr2.length));
        }
        if (length < 2) {
            throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, Integer.valueOf(length), 2);
        }
        double dEvaluate = mean.evaluate(dArr);
        double dEvaluate2 = mean.evaluate(dArr2);
        double d = 0.0d;
        int i5 = 0;
        while (i5 < length) {
            double d6 = ((dArr2[i5] - dEvaluate2) * (dArr[i5] - dEvaluate)) - d;
            i5++;
            d += d6 / ((double) i5);
        }
        return z6 ? (((double) length) / ((double) (length - 1))) * d : d;
    }

    public RealMatrix getCovarianceMatrix() {
        return this.covarianceMatrix;
    }

    public int getN() {
        return this.f6911n;
    }

    public Covariance(double[][] dArr, boolean z6) {
        this(new BlockRealMatrix(dArr), z6);
    }

    public Covariance(double[][] dArr) {
        this(dArr, true);
    }

    public Covariance(RealMatrix realMatrix, boolean z6) {
        checkSufficientData(realMatrix);
        this.f6911n = realMatrix.getRowDimension();
        this.covarianceMatrix = computeCovarianceMatrix(realMatrix, z6);
    }

    public RealMatrix computeCovarianceMatrix(RealMatrix realMatrix) {
        return computeCovarianceMatrix(realMatrix, true);
    }

    public RealMatrix computeCovarianceMatrix(double[][] dArr, boolean z6) {
        return computeCovarianceMatrix(new BlockRealMatrix(dArr), z6);
    }

    public Covariance(RealMatrix realMatrix) {
        this(realMatrix, true);
    }

    public RealMatrix computeCovarianceMatrix(double[][] dArr) {
        return computeCovarianceMatrix(dArr, true);
    }

    public double covariance(double[] dArr, double[] dArr2) {
        return covariance(dArr, dArr2, true);
    }
}
