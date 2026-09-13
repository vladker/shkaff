package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class VectorialCovariance implements Serializable {
    private static final long serialVersionUID = 4118372414238930270L;
    private final boolean isBiasCorrected;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f6923n = 0;
    private final double[] productsSums;
    private final double[] sums;

    public VectorialCovariance(int i5, boolean z6) {
        this.sums = new double[i5];
        this.productsSums = new double[((i5 + 1) * i5) / 2];
        this.isBiasCorrected = z6;
    }

    public void clear() {
        this.f6923n = 0L;
        Arrays.fill(this.sums, 0.0d);
        Arrays.fill(this.productsSums, 0.0d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VectorialCovariance)) {
            return false;
        }
        VectorialCovariance vectorialCovariance = (VectorialCovariance) obj;
        return this.isBiasCorrected == vectorialCovariance.isBiasCorrected && this.f6923n == vectorialCovariance.f6923n && Arrays.equals(this.productsSums, vectorialCovariance.productsSums) && Arrays.equals(this.sums, vectorialCovariance.sums);
    }

    public long getN() {
        return this.f6923n;
    }

    public RealMatrix getResult() {
        int length = this.sums.length;
        RealMatrix realMatrixCreateRealMatrix = MatrixUtils.createRealMatrix(length, length);
        long j6 = this.f6923n;
        if (j6 > 1) {
            double d = 1.0d / (j6 * (this.isBiasCorrected ? j6 - 1 : j6));
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = 0;
                while (i7 <= i6) {
                    int i8 = i5 + 1;
                    double d6 = this.f6923n * this.productsSums[i5];
                    double[] dArr = this.sums;
                    double d7 = (d6 - (dArr[i6] * dArr[i7])) * d;
                    realMatrixCreateRealMatrix.setEntry(i6, i7, d7);
                    realMatrixCreateRealMatrix.setEntry(i7, i6, d7);
                    i7++;
                    i5 = i8;
                }
            }
        }
        return realMatrixCreateRealMatrix;
    }

    public int hashCode() {
        int i5 = this.isBiasCorrected ? 1231 : 1237;
        long j6 = this.f6923n;
        return Arrays.hashCode(this.sums) + ((Arrays.hashCode(this.productsSums) + ((((i5 + 31) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31)) * 31);
    }

    public void increment(double[] dArr) {
        if (dArr.length != this.sums.length) {
            throw new DimensionMismatchException(dArr.length, this.sums.length);
        }
        int i5 = 0;
        for (int i6 = 0; i6 < dArr.length; i6++) {
            double[] dArr2 = this.sums;
            dArr2[i6] = dArr2[i6] + dArr[i6];
            int i7 = 0;
            while (i7 <= i6) {
                double[] dArr3 = this.productsSums;
                dArr3[i5] = (dArr[i6] * dArr[i7]) + dArr3[i5];
                i7++;
                i5++;
            }
        }
        this.f6923n++;
    }
}
