package org.apache.commons.math3.stat.regression;

import androidx.collection.a;
import java.io.Serializable;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SimpleRegression implements Serializable, UpdatingMultipleLinearRegression {
    private static final long serialVersionUID = -3004689053607543335L;
    private final boolean hasIntercept;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f6933n;
    private double sumX;
    private double sumXX;
    private double sumXY;
    private double sumY;
    private double sumYY;
    private double xbar;
    private double ybar;

    public SimpleRegression() {
        this(true);
    }

    public void addData(double d, double d6) {
        long j6 = this.f6933n;
        if (j6 == 0) {
            this.xbar = d;
            this.ybar = d6;
        } else if (this.hasIntercept) {
            double d7 = j6 + 1.0d;
            double d8 = j6 / (j6 + 1.0d);
            double d9 = this.xbar;
            double d10 = d - d9;
            double d11 = this.ybar;
            double d12 = d6 - d11;
            this.sumXX = a.C(d10, d10, d8, this.sumXX);
            this.sumYY = a.C(d12, d12, d8, this.sumYY);
            this.sumXY = a.C(d10, d12, d8, this.sumXY);
            this.xbar = (d10 / d7) + d9;
            this.ybar = (d12 / d7) + d11;
        }
        if (!this.hasIntercept) {
            this.sumXX = (d * d) + this.sumXX;
            this.sumYY = (d6 * d6) + this.sumYY;
            this.sumXY = (d * d6) + this.sumXY;
        }
        this.sumX += d;
        this.sumY += d6;
        this.f6933n = j6 + 1;
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public void addObservation(double[] dArr, double d) {
        if (dArr == null || dArr.length == 0) {
            throw new ModelSpecificationException(LocalizedFormats.INVALID_REGRESSION_OBSERVATION, Integer.valueOf(dArr != null ? dArr.length : 0), 1);
        }
        addData(dArr[0], d);
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public void addObservations(double[][] dArr, double[] dArr2) {
        if (dArr == null || dArr2 == null || dArr.length != dArr2.length) {
            throw new ModelSpecificationException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, Integer.valueOf(dArr == null ? 0 : dArr.length), Integer.valueOf(dArr2 != null ? dArr2.length : 0));
        }
        boolean z6 = true;
        for (double[] dArr3 : dArr) {
            if (dArr3 == null || dArr3.length == 0) {
                z6 = false;
            }
        }
        if (!z6) {
            throw new ModelSpecificationException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, 0, 1);
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            addData(dArr[i5][0], dArr2[i5]);
        }
    }

    public void append(SimpleRegression simpleRegression) {
        long j6 = this.f6933n;
        if (j6 == 0) {
            this.xbar = simpleRegression.xbar;
            this.ybar = simpleRegression.ybar;
            this.sumXX = simpleRegression.sumXX;
            this.sumYY = simpleRegression.sumYY;
            this.sumXY = simpleRegression.sumXY;
        } else if (this.hasIntercept) {
            long j7 = simpleRegression.f6933n;
            double d = j7 / (j7 + j6);
            double d6 = (j6 * j7) / (j7 + j6);
            double d7 = simpleRegression.xbar;
            double d8 = this.xbar;
            double d9 = d7 - d8;
            double d10 = simpleRegression.ybar;
            double d11 = this.ybar;
            double d12 = d10 - d11;
            this.sumXX = (d9 * d9 * d6) + simpleRegression.sumXX + this.sumXX;
            this.sumYY = (d12 * d12 * d6) + simpleRegression.sumYY + this.sumYY;
            this.sumXY = (d9 * d12 * d6) + simpleRegression.sumXY + this.sumXY;
            this.xbar = (d9 * d) + d8;
            this.ybar = (d12 * d) + d11;
        } else {
            this.sumXX += simpleRegression.sumXX;
            this.sumYY += simpleRegression.sumYY;
            this.sumXY += simpleRegression.sumXY;
        }
        this.sumX += simpleRegression.sumX;
        this.sumY += simpleRegression.sumY;
        this.f6933n = j6 + simpleRegression.f6933n;
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public void clear() {
        this.sumX = 0.0d;
        this.sumXX = 0.0d;
        this.sumY = 0.0d;
        this.sumYY = 0.0d;
        this.sumXY = 0.0d;
        this.f6933n = 0L;
    }

    public double getIntercept() {
        if (this.hasIntercept) {
            return getIntercept(getSlope());
        }
        return 0.0d;
    }

    public double getInterceptStdErr() {
        if (!this.hasIntercept) {
            return Double.NaN;
        }
        double meanSquareError = getMeanSquareError();
        double d = 1.0d / this.f6933n;
        double d6 = this.xbar;
        return FastMath.sqrt((((d6 * d6) / this.sumXX) + d) * meanSquareError);
    }

    public double getMeanSquareError() {
        double sumSquaredErrors;
        long j6;
        long j7;
        if (this.f6933n < 3) {
            return Double.NaN;
        }
        if (this.hasIntercept) {
            sumSquaredErrors = getSumSquaredErrors();
            j6 = this.f6933n;
            j7 = 2;
        } else {
            sumSquaredErrors = getSumSquaredErrors();
            j6 = this.f6933n;
            j7 = 1;
        }
        return sumSquaredErrors / (j6 - j7);
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public long getN() {
        return this.f6933n;
    }

    public double getR() {
        double slope = getSlope();
        double dSqrt = FastMath.sqrt(getRSquare());
        return slope < 0.0d ? -dSqrt : dSqrt;
    }

    public double getRSquare() {
        double totalSumSquares = getTotalSumSquares();
        return (totalSumSquares - getSumSquaredErrors()) / totalSumSquares;
    }

    public double getRegressionSumSquares() {
        return getRegressionSumSquares(getSlope());
    }

    public double getSignificance() {
        long j6 = this.f6933n;
        if (j6 < 3) {
            return Double.NaN;
        }
        return (1.0d - new TDistribution(j6 - 2).cumulativeProbability(FastMath.abs(getSlope()) / getSlopeStdErr())) * 2.0d;
    }

    public double getSlope() {
        if (this.f6933n >= 2 && FastMath.abs(this.sumXX) >= 4.9E-323d) {
            return this.sumXY / this.sumXX;
        }
        return Double.NaN;
    }

    public double getSlopeConfidenceInterval() {
        return getSlopeConfidenceInterval(0.05d);
    }

    public double getSlopeStdErr() {
        return FastMath.sqrt(getMeanSquareError() / this.sumXX);
    }

    public double getSumOfCrossProducts() {
        return this.sumXY;
    }

    public double getSumSquaredErrors() {
        double d = this.sumYY;
        double d6 = this.sumXY;
        return FastMath.max(0.0d, d - ((d6 * d6) / this.sumXX));
    }

    public double getTotalSumSquares() {
        if (this.f6933n < 2) {
            return Double.NaN;
        }
        return this.sumYY;
    }

    public double getXSumSquares() {
        if (this.f6933n < 2) {
            return Double.NaN;
        }
        return this.sumXX;
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public boolean hasIntercept() {
        return this.hasIntercept;
    }

    public double predict(double d) {
        double slope = getSlope();
        if (!this.hasIntercept) {
            return slope * d;
        }
        return (slope * d) + getIntercept(slope);
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public RegressionResults regress() {
        if (!this.hasIntercept) {
            if (this.f6933n < 2) {
                throw new NoDataException(LocalizedFormats.NOT_ENOUGH_DATA_REGRESSION);
            }
            if (Double.isNaN(this.sumXX)) {
                return new RegressionResults(new double[]{Double.NaN}, new double[][]{new double[]{Double.NaN}}, true, this.f6933n, 1, Double.NaN, Double.NaN, Double.NaN, false, false);
            }
            double meanSquareError = getMeanSquareError();
            double d = this.sumXX;
            return new RegressionResults(new double[]{this.sumXY / d}, new double[][]{new double[]{meanSquareError / d}}, true, this.f6933n, 1, this.sumY, this.sumYY, getSumSquaredErrors(), false, false);
        }
        if (this.f6933n < 3) {
            throw new NoDataException(LocalizedFormats.NOT_ENOUGH_DATA_REGRESSION);
        }
        if (FastMath.abs(this.sumXX) <= Precision.SAFE_MIN) {
            double d6 = this.sumY;
            long j6 = this.f6933n;
            return new RegressionResults(new double[]{d6 / j6, Double.NaN}, new double[][]{new double[]{this.ybar / (j6 - 1.0d), Double.NaN, Double.NaN}}, true, j6, 1, d6, this.sumYY, getSumSquaredErrors(), true, false);
        }
        double[] dArr = {getIntercept(), getSlope()};
        double meanSquareError2 = getMeanSquareError();
        double d7 = this.sumYY;
        double d8 = this.sumY;
        long j7 = this.f6933n;
        double d9 = ((d8 * d8) / j7) + d7;
        double d10 = this.xbar;
        double d11 = this.sumXX;
        return new RegressionResults(dArr, new double[][]{new double[]{((1.0d / j7) + ((d10 * d10) / d11)) * meanSquareError2, ((-d10) * meanSquareError2) / d11, meanSquareError2 / d11}}, true, j7, 2, d8, d9, getSumSquaredErrors(), true, false);
    }

    public void removeData(double d, double d6) {
        long j6 = this.f6933n;
        if (j6 > 0) {
            if (this.hasIntercept) {
                double d7 = j6 - 1.0d;
                double d8 = j6 / (j6 - 1.0d);
                double d9 = this.xbar;
                double d10 = d - d9;
                double d11 = this.ybar;
                double d12 = d6 - d11;
                this.sumXX -= (d10 * d10) * d8;
                this.sumYY -= (d12 * d12) * d8;
                this.sumXY -= (d10 * d12) * d8;
                this.xbar = d9 - (d10 / d7);
                this.ybar = d11 - (d12 / d7);
            } else {
                double d13 = j6 - 1.0d;
                this.sumXX -= d * d;
                this.sumYY -= d6 * d6;
                this.sumXY -= d * d6;
                this.xbar -= d / d13;
                this.ybar -= d6 / d13;
            }
            this.sumX -= d;
            this.sumY -= d6;
            this.f6933n = j6 - 1;
        }
    }

    public SimpleRegression(boolean z6) {
        this.sumX = 0.0d;
        this.sumXX = 0.0d;
        this.sumY = 0.0d;
        this.sumYY = 0.0d;
        this.sumXY = 0.0d;
        this.f6933n = 0L;
        this.xbar = 0.0d;
        this.ybar = 0.0d;
        this.hasIntercept = z6;
    }

    private double getIntercept(double d) {
        if (this.hasIntercept) {
            return (this.sumY - (d * this.sumX)) / this.f6933n;
        }
        return 0.0d;
    }

    private double getRegressionSumSquares(double d) {
        return d * d * this.sumXX;
    }

    public double getSlopeConfidenceInterval(double d) {
        long j6 = this.f6933n;
        if (j6 < 3) {
            return Double.NaN;
        }
        if (d >= 1.0d || d <= 0.0d) {
            throw new OutOfRangeException(LocalizedFormats.SIGNIFICANCE_LEVEL, Double.valueOf(d), 0, 1);
        }
        return new TDistribution(j6 - 2).inverseCumulativeProbability(1.0d - (d / 2.0d)) * getSlopeStdErr();
    }

    public void removeData(double[][] dArr) {
        for (int i5 = 0; i5 < dArr.length && this.f6933n > 0; i5++) {
            double[] dArr2 = dArr[i5];
            removeData(dArr2[0], dArr2[1]);
        }
    }

    public void addData(double[][] dArr) {
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double[] dArr2 = dArr[i5];
            if (dArr2.length >= 2) {
                addData(dArr2[0], dArr2[1]);
            } else {
                throw new ModelSpecificationException(LocalizedFormats.INVALID_REGRESSION_OBSERVATION, Integer.valueOf(dArr[i5].length), 2);
            }
        }
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public RegressionResults regress(int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            int i5 = 2;
            if (iArr.length <= 2 && (iArr.length <= 1 || this.hasIntercept)) {
                if (this.hasIntercept) {
                    if (iArr.length == 2) {
                        int i6 = iArr[0];
                        if (i6 == 1) {
                            throw new ModelSpecificationException(LocalizedFormats.NOT_INCREASING_SEQUENCE, new Object[0]);
                        }
                        if (i6 == 0) {
                            if (iArr[1] == 1) {
                                return regress();
                            }
                            throw new OutOfRangeException(Integer.valueOf(iArr[0]), 0, 1);
                        }
                        throw new OutOfRangeException(Integer.valueOf(iArr[0]), 0, 1);
                    }
                    int i7 = iArr[0];
                    if (i7 != 1 && i7 != 0) {
                        throw new OutOfRangeException(Integer.valueOf(iArr[0]), 0, 1);
                    }
                    double d = this.sumY;
                    long j6 = this.f6933n;
                    double d6 = (d * d) / j6;
                    double d7 = this.sumYY;
                    double d8 = d7 + d6;
                    if (i7 == 0) {
                        return new RegressionResults(new double[]{this.ybar}, new double[][]{new double[]{d7 / ((j6 - 1) * j6)}}, true, j6, 1, d, d8 + d6, d7, true, false);
                    }
                    if (i7 != 1) {
                        return null;
                    }
                    double d9 = this.sumXX;
                    double d10 = this.sumX;
                    double d11 = ((d10 * d10) / j6) + d9;
                    double d12 = ((d10 * d) / j6) + this.sumXY;
                    double dMax = FastMath.max(0.0d, d8 - ((d12 * d12) / d11));
                    double d13 = dMax / (this.f6933n - 1);
                    if (!Double.isNaN(d11)) {
                        return new RegressionResults(new double[]{d12 / d11}, new double[][]{new double[]{d13 / d11}}, true, this.f6933n, 1, this.sumY, d8, dMax, false, false);
                    }
                    return new RegressionResults(new double[]{Double.NaN}, new double[][]{new double[]{Double.NaN}}, true, this.f6933n, 1, Double.NaN, Double.NaN, Double.NaN, false, false);
                }
                if (iArr[0] == 0) {
                    return regress();
                }
                throw new OutOfRangeException(Integer.valueOf(iArr[0]), 0, 0);
            }
            LocalizedFormats localizedFormats = LocalizedFormats.ARRAY_SIZE_EXCEEDS_MAX_VARIABLES;
            if (iArr.length > 1 && !this.hasIntercept) {
                i5 = 1;
            }
            throw new ModelSpecificationException(localizedFormats, Integer.valueOf(i5));
        }
        throw new MathIllegalArgumentException(LocalizedFormats.ARRAY_ZERO_LENGTH_OR_NULL_NOT_ALLOWED, new Object[0]);
    }
}
