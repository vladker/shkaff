package org.apache.commons.math3.stat.regression;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RegressionResults implements Serializable {
    private static final int ADJRSQ_IDX = 4;
    private static final int MSE_IDX = 3;
    private static final int RSQ_IDX = 2;
    private static final int SSE_IDX = 0;
    private static final int SST_IDX = 1;
    private static final long serialVersionUID = 1;
    private final boolean containsConstant;
    private final double[] globalFitInfo;
    private final boolean isSymmetricVCD;
    private final long nobs;
    private final double[] parameters;
    private final int rank;
    private final double[][] varCovData;

    private RegressionResults() {
        this.parameters = null;
        this.varCovData = null;
        this.rank = -1;
        this.nobs = -1L;
        this.containsConstant = false;
        this.isSymmetricVCD = false;
        this.globalFitInfo = null;
    }

    private double getVcvElement(int i5, int i6) {
        if (!this.isSymmetricVCD) {
            return this.varCovData[i5][i6];
        }
        double[][] dArr = this.varCovData;
        if (dArr.length <= 1) {
            return i5 > i6 ? dArr[0][(((i5 + 1) * i5) / 2) + i6] : dArr[0][(((i6 + 1) * i6) / 2) + i5];
        }
        if (i5 == i6) {
            return dArr[i5][i5];
        }
        double[] dArr2 = dArr[i6];
        return i5 >= dArr2.length ? dArr[i5][i6] : dArr2[i5];
    }

    public double getAdjustedRSquared() {
        return this.globalFitInfo[4];
    }

    public double getCovarianceOfParameters(int i5, int i6) {
        double[] dArr = this.parameters;
        if (dArr == null) {
            return Double.NaN;
        }
        if (i5 < 0 || i5 >= dArr.length) {
            throw new OutOfRangeException(Integer.valueOf(i5), 0, Integer.valueOf(this.parameters.length - 1));
        }
        if (i6 < 0 || i6 >= dArr.length) {
            throw new OutOfRangeException(Integer.valueOf(i6), 0, Integer.valueOf(this.parameters.length - 1));
        }
        return getVcvElement(i5, i6);
    }

    public double getErrorSumSquares() {
        return this.globalFitInfo[0];
    }

    public double getMeanSquareError() {
        return this.globalFitInfo[3];
    }

    public long getN() {
        return this.nobs;
    }

    public int getNumberOfParameters() {
        double[] dArr = this.parameters;
        if (dArr == null) {
            return -1;
        }
        return dArr.length;
    }

    public double getParameterEstimate(int i5) {
        double[] dArr = this.parameters;
        if (dArr == null) {
            return Double.NaN;
        }
        if (i5 < 0 || i5 >= dArr.length) {
            throw new OutOfRangeException(Integer.valueOf(i5), 0, Integer.valueOf(this.parameters.length - 1));
        }
        return dArr[i5];
    }

    public double[] getParameterEstimates() {
        double[] dArr = this.parameters;
        if (dArr == null) {
            return null;
        }
        return MathArrays.copyOf(dArr);
    }

    public double getRSquared() {
        return this.globalFitInfo[2];
    }

    public double getRegressionSumSquares() {
        double[] dArr = this.globalFitInfo;
        return dArr[1] - dArr[0];
    }

    public double getStdErrorOfEstimate(int i5) {
        double[] dArr = this.parameters;
        if (dArr == null) {
            return Double.NaN;
        }
        if (i5 < 0 || i5 >= dArr.length) {
            throw new OutOfRangeException(Integer.valueOf(i5), 0, Integer.valueOf(this.parameters.length - 1));
        }
        double vcvElement = getVcvElement(i5, i5);
        if (Double.isNaN(vcvElement) || vcvElement <= Double.MIN_VALUE) {
            return Double.NaN;
        }
        return FastMath.sqrt(vcvElement);
    }

    public double[] getStdErrorOfEstimates() {
        double[] dArr = this.parameters;
        if (dArr == null) {
            return null;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i5 = 0; i5 < this.parameters.length; i5++) {
            double vcvElement = getVcvElement(i5, i5);
            if (Double.isNaN(vcvElement) || vcvElement <= Double.MIN_VALUE) {
                dArr2[i5] = Double.NaN;
            } else {
                dArr2[i5] = FastMath.sqrt(vcvElement);
            }
        }
        return dArr2;
    }

    public double getTotalSumSquares() {
        return this.globalFitInfo[1];
    }

    public boolean hasIntercept() {
        return this.containsConstant;
    }

    public RegressionResults(double[] dArr, double[][] dArr2, boolean z6, long j6, int i5, double d, double d6, double d7, boolean z7, boolean z8) {
        if (z8) {
            this.parameters = MathArrays.copyOf(dArr);
            this.varCovData = new double[dArr2.length][];
            for (int i6 = 0; i6 < dArr2.length; i6++) {
                this.varCovData[i6] = MathArrays.copyOf(dArr2[i6]);
            }
        } else {
            this.parameters = dArr;
            this.varCovData = dArr2;
        }
        this.isSymmetricVCD = z6;
        this.nobs = j6;
        this.rank = i5;
        this.containsConstant = z7;
        double[] dArr3 = new double[5];
        this.globalFitInfo = dArr3;
        Arrays.fill(dArr3, Double.NaN);
        if (i5 > 0) {
            dArr3[1] = z7 ? d6 - ((d * d) / j6) : d6;
        }
        dArr3[0] = d7;
        double d8 = j6 - ((long) i5);
        dArr3[3] = d7 / d8;
        double d9 = dArr3[1];
        double d10 = 1.0d - (d7 / d9);
        dArr3[2] = d10;
        if (!z7) {
            dArr3[4] = 1.0d - ((j6 / d8) * (1.0d - d10));
        } else {
            dArr3[4] = 1.0d - (((j6 - 1.0d) * d7) / (d9 * d8));
        }
    }
}
