package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PiecewiseBicubicSplineInterpolator implements BivariateGridInterpolator {
    @Override // org.apache.commons.math3.analysis.interpolation.BivariateGridInterpolator
    public PiecewiseBicubicSplineInterpolatingFunction interpolate(double[] dArr, double[] dArr2, double[][] dArr3) {
        if (dArr == null || dArr2 == null || dArr3 == null || dArr3[0] == null) {
            throw new NullArgumentException();
        }
        if (dArr.length == 0 || dArr2.length == 0 || dArr3.length == 0) {
            throw new NoDataException();
        }
        MathArrays.checkOrder(dArr);
        MathArrays.checkOrder(dArr2);
        return new PiecewiseBicubicSplineInterpolatingFunction(dArr, dArr2, dArr3);
    }
}
