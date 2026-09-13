package org.apache.commons.math3.analysis.function;

import java.util.Arrays;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StepFunction implements UnivariateFunction {
    private final double[] abscissa;
    private final double[] ordinate;

    public StepFunction(double[] dArr, double[] dArr2) {
        if (dArr == null || dArr2 == null) {
            throw new NullArgumentException();
        }
        if (dArr.length == 0 || dArr2.length == 0) {
            throw new NoDataException();
        }
        if (dArr2.length != dArr.length) {
            throw new DimensionMismatchException(dArr2.length, dArr.length);
        }
        MathArrays.checkOrder(dArr);
        this.abscissa = MathArrays.copyOf(dArr);
        this.ordinate = MathArrays.copyOf(dArr2);
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double d) {
        int iBinarySearch = Arrays.binarySearch(this.abscissa, d);
        if (iBinarySearch < -1) {
            return this.ordinate[(-iBinarySearch) - 2];
        }
        return iBinarySearch >= 0 ? this.ordinate[iBinarySearch] : this.ordinate[0];
    }
}
