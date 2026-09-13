package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.TrivariateFunction;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class TricubicSplineFunction implements TrivariateFunction {

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final short f6746N = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double[][][] f6747a = (double[][][]) Array.newInstance((Class<?>) Double.TYPE, 4, 4, 4);

    public TricubicSplineFunction(double[] dArr) {
        for (int i5 = 0; i5 < 4; i5++) {
            for (int i6 = 0; i6 < 4; i6++) {
                for (int i7 = 0; i7 < 4; i7++) {
                    this.f6747a[i5][i6][i7] = dArr[(((i7 * 4) + i6) * 4) + i5];
                }
            }
        }
    }

    @Override // org.apache.commons.math3.analysis.TrivariateFunction
    public double value(double d, double d6, double d7) {
        double d8 = 0.0d;
        if (d < 0.0d || d > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d), 0, 1);
        }
        if (d6 < 0.0d || d6 > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d6), 0, 1);
        }
        if (d7 < 0.0d || d7 > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d7), 0, 1);
        }
        double d9 = d * d;
        double[] dArr = {1.0d, d, d9, d9 * d};
        double d10 = d6 * d6;
        double[] dArr2 = {1.0d, d6, d10, d10 * d6};
        double d11 = d7 * d7;
        double[] dArr3 = {1.0d, d7, d11, d11 * d7};
        for (int i5 = 0; i5 < 4; i5++) {
            for (int i6 = 0; i6 < 4; i6++) {
                for (int i7 = 0; i7 < 4; i7++) {
                    d8 += this.f6747a[i5][i6][i7] * dArr[i5] * dArr2[i6] * dArr3[i7];
                }
            }
        }
        return d8;
    }
}
