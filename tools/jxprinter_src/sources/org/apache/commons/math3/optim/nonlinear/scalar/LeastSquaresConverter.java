package org.apache.commons.math3.optim.nonlinear.scalar;

import androidx.collection.a;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LeastSquaresConverter implements MultivariateFunction {
    private final MultivariateVectorFunction function;
    private final double[] observations;
    private final RealMatrix scale;
    private final double[] weights;

    public LeastSquaresConverter(MultivariateVectorFunction multivariateVectorFunction, double[] dArr) {
        this.function = multivariateVectorFunction;
        this.observations = (double[]) dArr.clone();
        this.weights = null;
        this.scale = null;
    }

    @Override // org.apache.commons.math3.analysis.MultivariateFunction
    public double value(double[] dArr) {
        double[] dArrValue = this.function.value(dArr);
        if (dArrValue.length != this.observations.length) {
            throw new DimensionMismatchException(dArrValue.length, this.observations.length);
        }
        int i5 = 0;
        for (int i6 = 0; i6 < dArrValue.length; i6++) {
            dArrValue[i6] = dArrValue[i6] - this.observations[i6];
        }
        double d = 0.0d;
        if (this.weights != null) {
            double dC = 0.0d;
            while (i5 < dArrValue.length) {
                double d6 = dArrValue[i5];
                dC = a.C(this.weights[i5], d6, d6, dC);
                i5++;
            }
            return dC;
        }
        RealMatrix realMatrix = this.scale;
        if (realMatrix == null) {
            int length = dArrValue.length;
            while (i5 < length) {
                double d7 = dArrValue[i5];
                d += d7 * d7;
                i5++;
            }
            return d;
        }
        double[] dArrOperate = realMatrix.operate(dArrValue);
        int length2 = dArrOperate.length;
        while (i5 < length2) {
            double d8 = dArrOperate[i5];
            d += d8 * d8;
            i5++;
        }
        return d;
    }

    public LeastSquaresConverter(MultivariateVectorFunction multivariateVectorFunction, double[] dArr, double[] dArr2) {
        if (dArr.length == dArr2.length) {
            this.function = multivariateVectorFunction;
            this.observations = (double[]) dArr.clone();
            this.weights = (double[]) dArr2.clone();
            this.scale = null;
            return;
        }
        throw new DimensionMismatchException(dArr.length, dArr2.length);
    }

    public LeastSquaresConverter(MultivariateVectorFunction multivariateVectorFunction, double[] dArr, RealMatrix realMatrix) {
        if (dArr.length == realMatrix.getColumnDimension()) {
            this.function = multivariateVectorFunction;
            this.observations = (double[]) dArr.clone();
            this.weights = null;
            this.scale = realMatrix.copy();
            return;
        }
        throw new DimensionMismatchException(dArr.length, realMatrix.getColumnDimension());
    }
}
