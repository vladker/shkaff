package org.apache.commons.math3.stat.correlation;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StorelessCovariance extends Covariance {
    private StorelessBivariateCovariance[] covMatrix;
    private int dimension;

    public StorelessCovariance(int i5) {
        this(i5, true);
    }

    private StorelessBivariateCovariance getElement(int i5, int i6) {
        return this.covMatrix[indexOf(i5, i6)];
    }

    private int indexOf(int i5, int i6) {
        return i6 < i5 ? (((i5 + 1) * i5) / 2) + i6 : (((i6 + 1) * i6) / 2) + i5;
    }

    private void initializeMatrix(boolean z6) {
        for (int i5 = 0; i5 < this.dimension; i5++) {
            for (int i6 = 0; i6 < this.dimension; i6++) {
                setElement(i5, i6, new StorelessBivariateCovariance(z6));
            }
        }
    }

    private void setElement(int i5, int i6, StorelessBivariateCovariance storelessBivariateCovariance) {
        this.covMatrix[indexOf(i5, i6)] = storelessBivariateCovariance;
    }

    public void append(StorelessCovariance storelessCovariance) {
        if (storelessCovariance.dimension != this.dimension) {
            throw new DimensionMismatchException(storelessCovariance.dimension, this.dimension);
        }
        for (int i5 = 0; i5 < this.dimension; i5++) {
            for (int i6 = i5; i6 < this.dimension; i6++) {
                getElement(i5, i6).append(storelessCovariance.getElement(i5, i6));
            }
        }
    }

    public double getCovariance(int i5, int i6) {
        return getElement(i5, i6).getResult();
    }

    @Override // org.apache.commons.math3.stat.correlation.Covariance
    public RealMatrix getCovarianceMatrix() {
        return MatrixUtils.createRealMatrix(getData());
    }

    public double[][] getData() {
        int i5 = this.dimension;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, i5);
        for (int i6 = 0; i6 < this.dimension; i6++) {
            for (int i7 = 0; i7 < this.dimension; i7++) {
                dArr[i6][i7] = getElement(i6, i7).getResult();
            }
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.stat.correlation.Covariance
    public int getN() {
        throw new MathUnsupportedOperationException();
    }

    public void increment(double[] dArr) {
        int length = dArr.length;
        if (length != this.dimension) {
            throw new DimensionMismatchException(length, this.dimension);
        }
        for (int i5 = 0; i5 < length; i5++) {
            for (int i6 = i5; i6 < length; i6++) {
                getElement(i5, i6).increment(dArr[i5], dArr[i6]);
            }
        }
    }

    public StorelessCovariance(int i5, boolean z6) {
        this.dimension = i5;
        this.covMatrix = new StorelessBivariateCovariance[((i5 + 1) * i5) / 2];
        initializeMatrix(z6);
    }
}
