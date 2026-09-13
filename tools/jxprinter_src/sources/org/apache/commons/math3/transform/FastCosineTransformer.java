package org.apache.commons.math3.transform;

import java.io.Serializable;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FastCosineTransformer implements RealTransformer, Serializable {
    static final long serialVersionUID = 20120212;
    private final DctNormalization normalization;

    public FastCosineTransformer(DctNormalization dctNormalization) {
        this.normalization = dctNormalization;
    }

    public double[] fct(double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        int i5 = 1;
        int length = dArr.length - 1;
        if (!ArithmeticUtils.isPowerOfTwo(length)) {
            throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_PLUS_ONE, Integer.valueOf(dArr.length));
        }
        double d = 0.5d;
        boolean z6 = false;
        if (length == 1) {
            double d6 = dArr[0];
            double d7 = dArr[1];
            dArr2[0] = (d6 + d7) * 0.5d;
            dArr2[1] = (dArr[0] - d7) * 0.5d;
            return dArr2;
        }
        double[] dArr3 = new double[length];
        dArr3[0] = (dArr[0] + dArr[length]) * 0.5d;
        int i6 = length >> 1;
        dArr3[i6] = dArr[i6];
        double d8 = (dArr[0] - dArr[length]) * 0.5d;
        int i7 = 1;
        while (i7 < i6) {
            int i8 = length - i7;
            double d9 = (dArr[i7] + dArr[i8]) * d;
            int i9 = i5;
            boolean z7 = z6;
            double[] dArr4 = dArr3;
            double d10 = (((double) i7) * 3.141592653589793d) / ((double) length);
            double dSin = (dArr[i7] - dArr[i8]) * FastMath.sin(d10);
            double dCos = (dArr[i7] - dArr[i8]) * FastMath.cos(d10);
            dArr4[i7] = d9 - dSin;
            dArr4[i8] = d9 + dSin;
            d8 += dCos;
            i7++;
            z6 = z7;
            i5 = i9;
            dArr3 = dArr4;
            d = 0.5d;
        }
        int i10 = i5;
        boolean z8 = z6;
        Complex[] complexArrTransform = new FastFourierTransformer(DftNormalization.STANDARD).transform(dArr3, TransformType.FORWARD);
        dArr2[z8 ? 1 : 0] = complexArrTransform[z8 ? 1 : 0].getReal();
        dArr2[i10] = d8;
        for (int i11 = i10; i11 < i6; i11++) {
            int i12 = i11 * 2;
            dArr2[i12] = complexArrTransform[i11].getReal();
            dArr2[i12 + 1] = dArr2[i12 - i10] - complexArrTransform[i11].getImaginary();
        }
        dArr2[length] = complexArrTransform[i6].getReal();
        return dArr2;
    }

    @Override // org.apache.commons.math3.transform.RealTransformer
    public double[] transform(double[] dArr, TransformType transformType) {
        if (transformType == TransformType.FORWARD) {
            if (this.normalization != DctNormalization.ORTHOGONAL_DCT_I) {
                return fct(dArr);
            }
            return TransformUtils.scaleArray(fct(dArr), FastMath.sqrt(2.0d / ((double) (dArr.length - 1))));
        }
        double length = 2.0d / ((double) (dArr.length - 1));
        if (this.normalization == DctNormalization.ORTHOGONAL_DCT_I) {
            length = FastMath.sqrt(length);
        }
        return TransformUtils.scaleArray(fct(dArr), length);
    }

    @Override // org.apache.commons.math3.transform.RealTransformer
    public double[] transform(UnivariateFunction univariateFunction, double d, double d6, int i5, TransformType transformType) {
        return transform(FunctionUtils.sample(univariateFunction, d, d6, i5), transformType);
    }
}
