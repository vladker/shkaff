package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class UnivariatePeriodicInterpolator implements UnivariateInterpolator {
    public static final int DEFAULT_EXTEND = 5;
    private final int extend;
    private final UnivariateInterpolator interpolator;
    private final double period;

    public UnivariatePeriodicInterpolator(UnivariateInterpolator univariateInterpolator, double d, int i5) {
        this.interpolator = univariateInterpolator;
        this.period = d;
        this.extend = i5;
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public UnivariateFunction interpolate(double[] dArr, double[] dArr2) {
        if (dArr.length < this.extend) {
            throw new NumberIsTooSmallException(Integer.valueOf(dArr.length), Integer.valueOf(this.extend), true);
        }
        MathArrays.checkOrder(dArr);
        int i5 = 0;
        final double d = dArr[0];
        int length = (this.extend * 2) + dArr.length;
        double[] dArr3 = new double[length];
        double[] dArr4 = new double[length];
        for (int i6 = 0; i6 < dArr.length; i6++) {
            int i7 = i6 + this.extend;
            dArr3[i7] = MathUtils.reduce(dArr[i6], this.period, d);
            dArr4[i7] = dArr2[i6];
        }
        while (true) {
            int i8 = this.extend;
            if (i5 >= i8) {
                MathArrays.sortInPlace(dArr3, dArr4);
                final UnivariateFunction univariateFunctionInterpolate = this.interpolator.interpolate(dArr3, dArr4);
                return new UnivariateFunction() { // from class: org.apache.commons.math3.analysis.interpolation.UnivariatePeriodicInterpolator.1
                    @Override // org.apache.commons.math3.analysis.UnivariateFunction
                    public double value(double d6) {
                        return univariateFunctionInterpolate.value(MathUtils.reduce(d6, UnivariatePeriodicInterpolator.this.period, d));
                    }
                };
            }
            int length2 = (dArr.length - i8) + i5;
            double dReduce = MathUtils.reduce(dArr[length2], this.period, d);
            double d6 = this.period;
            dArr3[i5] = dReduce - d6;
            dArr4[i5] = dArr2[length2];
            int i9 = (length - this.extend) + i5;
            dArr3[i9] = MathUtils.reduce(dArr[i5], d6, d) + this.period;
            dArr4[i9] = dArr2[i5];
            i5++;
        }
    }

    public UnivariatePeriodicInterpolator(UnivariateInterpolator univariateInterpolator, double d) {
        this(univariateInterpolator, d, 5);
    }
}
