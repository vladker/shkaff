package org.apache.commons.math3.transform;

import java.io.Serializable;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FastHadamardTransformer implements RealTransformer, Serializable {
    static final long serialVersionUID = 20120211;

    public double[] fht(double[] dArr) {
        int length = dArr.length;
        int i5 = length / 2;
        if (!ArithmeticUtils.isPowerOfTwo(length)) {
            throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO, Integer.valueOf(length));
        }
        double[] dArr2 = (double[]) dArr.clone();
        double[] dArr3 = new double[length];
        int i6 = 1;
        while (i6 < length) {
            for (int i7 = 0; i7 < i5; i7++) {
                int i8 = i7 * 2;
                dArr3[i7] = dArr2[i8] + dArr2[i8 + 1];
            }
            for (int i9 = i5; i9 < length; i9++) {
                int i10 = (i9 * 2) - length;
                dArr3[i9] = dArr2[i10] - dArr2[i10 + 1];
            }
            i6 <<= 1;
            double[] dArr4 = dArr2;
            dArr2 = dArr3;
            dArr3 = dArr4;
        }
        return dArr2;
    }

    @Override // org.apache.commons.math3.transform.RealTransformer
    public double[] transform(double[] dArr, TransformType transformType) {
        return transformType == TransformType.FORWARD ? fht(dArr) : TransformUtils.scaleArray(fht(dArr), 1.0d / ((double) dArr.length));
    }

    @Override // org.apache.commons.math3.transform.RealTransformer
    public double[] transform(UnivariateFunction univariateFunction, double d, double d6, int i5, TransformType transformType) {
        return transform(FunctionUtils.sample(univariateFunction, d, d6, i5), transformType);
    }

    public int[] transform(int[] iArr) {
        return fht(iArr);
    }

    public int[] fht(int[] iArr) {
        int length = iArr.length;
        int i5 = length / 2;
        if (ArithmeticUtils.isPowerOfTwo(length)) {
            int[] iArr2 = (int[]) iArr.clone();
            int[] iArr3 = new int[length];
            int i6 = 1;
            while (i6 < length) {
                for (int i7 = 0; i7 < i5; i7++) {
                    int i8 = i7 * 2;
                    iArr3[i7] = iArr2[i8] + iArr2[i8 + 1];
                }
                for (int i9 = i5; i9 < length; i9++) {
                    int i10 = (i9 * 2) - length;
                    iArr3[i9] = iArr2[i10] - iArr2[i10 + 1];
                }
                i6 <<= 1;
                int[] iArr4 = iArr2;
                iArr2 = iArr3;
                iArr3 = iArr4;
            }
            return iArr2;
        }
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO, Integer.valueOf(length));
    }
}
