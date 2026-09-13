package org.apache.commons.math3.analysis.interpolation;

import java.util.Arrays;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.InsufficientDataException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PiecewiseBicubicSplineInterpolatingFunction implements BivariateFunction {
    private static final int MIN_NUM_POINTS = 5;
    private final double[][] fval;
    private final double[] xval;
    private final double[] yval;

    public PiecewiseBicubicSplineInterpolatingFunction(double[] dArr, double[] dArr2, double[][] dArr3) {
        double[] dArr4;
        if (dArr == null || dArr2 == null || dArr3 == null || (dArr4 = dArr3[0]) == null) {
            throw new NullArgumentException();
        }
        int length = dArr.length;
        int length2 = dArr2.length;
        if (length == 0 || length2 == 0 || dArr3.length == 0 || dArr4.length == 0) {
            throw new NoDataException();
        }
        if (length < 5 || length2 < 5 || dArr3.length < 5 || dArr4.length < 5) {
            throw new InsufficientDataException();
        }
        if (length != dArr3.length) {
            throw new DimensionMismatchException(length, dArr3.length);
        }
        if (length2 != dArr4.length) {
            throw new DimensionMismatchException(length2, dArr3[0].length);
        }
        MathArrays.checkOrder(dArr);
        MathArrays.checkOrder(dArr2);
        this.xval = (double[]) dArr.clone();
        this.yval = (double[]) dArr2.clone();
        this.fval = (double[][]) dArr3.clone();
    }

    private int searchIndex(double d, double[] dArr, int i5, int i6) {
        int iBinarySearch = Arrays.binarySearch(dArr, d);
        if (iBinarySearch == -1 || iBinarySearch == (-dArr.length) - 1) {
            throw new OutOfRangeException(Double.valueOf(d), Double.valueOf(dArr[0]), Double.valueOf(dArr[dArr.length - 1]));
        }
        int i7 = iBinarySearch < 0 ? ((-iBinarySearch) - i5) - 1 : iBinarySearch - i5;
        int i8 = i7 >= 0 ? i7 : 0;
        return i8 + i6 >= dArr.length ? dArr.length - i6 : i8;
    }

    public boolean isValidPoint(double d, double d6) {
        double[] dArr = this.xval;
        if (d >= dArr[0] && d <= dArr[dArr.length - 1]) {
            double[] dArr2 = this.yval;
            if (d6 >= dArr2[0] && d6 <= dArr2[dArr2.length - 1]) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.math3.analysis.BivariateFunction
    public double value(double d, double d6) {
        AkimaSplineInterpolator akimaSplineInterpolator = new AkimaSplineInterpolator();
        int iSearchIndex = searchIndex(d, this.xval, 2, 5);
        int iSearchIndex2 = searchIndex(d6, this.yval, 2, 5);
        double[] dArr = new double[5];
        double[] dArr2 = new double[5];
        double[] dArr3 = new double[5];
        double[] dArr4 = new double[5];
        for (int i5 = 0; i5 < 5; i5++) {
            dArr[i5] = this.xval[iSearchIndex + i5];
            dArr2[i5] = this.yval[iSearchIndex2 + i5];
        }
        for (int i6 = 0; i6 < 5; i6++) {
            for (int i7 = 0; i7 < 5; i7++) {
                dArr3[i7] = this.fval[iSearchIndex + i7][iSearchIndex2 + i6];
            }
            dArr4[i6] = akimaSplineInterpolator.interpolate(dArr, dArr3).value(d);
        }
        return akimaSplineInterpolator.interpolate(dArr2, dArr4).value(d6);
    }
}
