package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class BicubicFunction implements BivariateFunction {

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final short f6740N = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double[][] f6741a = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 4, 4);

    public BicubicFunction(double[] dArr) {
        for (int i5 = 0; i5 < 4; i5++) {
            double[] dArr2 = this.f6741a[i5];
            for (int i6 = 0; i6 < 4; i6++) {
                dArr2[i6] = dArr[(i6 * 4) + i5];
            }
        }
    }

    private double apply(double[] dArr, double[] dArr2, double[][] dArr3) {
        double dLinearCombination = 0.0d;
        for (int i5 = 0; i5 < 4; i5++) {
            dLinearCombination += MathArrays.linearCombination(dArr3[i5], dArr2) * dArr[i5];
        }
        return dLinearCombination;
    }

    @Override // org.apache.commons.math3.analysis.BivariateFunction
    public double value(double d, double d6) {
        if (d < 0.0d || d > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d), 0, 1);
        }
        if (d6 < 0.0d || d6 > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d6), 0, 1);
        }
        double d7 = d * d;
        double[] dArr = {1.0d, d, d7, d7 * d};
        double d8 = d6 * d6;
        return apply(dArr, new double[]{1.0d, d6, d8, d8 * d6}, this.f6741a);
    }
}
