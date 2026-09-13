package org.apache.commons.math3.optimization.direct;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class MultivariateFunctionPenaltyAdapter implements MultivariateFunction {
    private final MultivariateFunction bounded;
    private final double[] lower;
    private final double offset;
    private final double[] scale;
    private final double[] upper;

    public MultivariateFunctionPenaltyAdapter(MultivariateFunction multivariateFunction, double[] dArr, double[] dArr2, double d, double[] dArr3) {
        MathUtils.checkNotNull(dArr);
        MathUtils.checkNotNull(dArr2);
        MathUtils.checkNotNull(dArr3);
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        if (dArr.length != dArr3.length) {
            throw new DimensionMismatchException(dArr.length, dArr3.length);
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            if (dArr2[i5] < dArr[i5]) {
                throw new NumberIsTooSmallException(Double.valueOf(dArr2[i5]), Double.valueOf(dArr[i5]), true);
            }
        }
        this.bounded = multivariateFunction;
        this.lower = (double[]) dArr.clone();
        this.upper = (double[]) dArr2.clone();
        this.offset = d;
        this.scale = (double[]) dArr3.clone();
    }

    @Override // org.apache.commons.math3.analysis.MultivariateFunction
    public double value(double[] dArr) {
        double d;
        int i5 = 0;
        while (i5 < this.scale.length) {
            double d6 = dArr[i5];
            if (d6 < this.lower[i5] || d6 > this.upper[i5]) {
                double dSqrt = 0.0d;
                while (true) {
                    double[] dArr2 = this.scale;
                    if (i5 >= dArr2.length) {
                        return this.offset + dSqrt;
                    }
                    double d7 = dArr[i5];
                    double d8 = this.lower[i5];
                    if (d7 < d8) {
                        d = (d8 - d7) * dArr2[i5];
                    } else {
                        double d9 = this.upper[i5];
                        if (d7 > d9) {
                            d = (d7 - d9) * dArr2[i5];
                        } else {
                            d = 0.0d;
                        }
                    }
                    dSqrt += FastMath.sqrt(d);
                    i5++;
                }
            } else {
                i5++;
            }
        }
        return this.bounded.value(dArr);
    }
}
