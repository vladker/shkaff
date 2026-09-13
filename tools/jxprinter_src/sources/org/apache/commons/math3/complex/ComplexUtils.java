package org.apache.commons.math3.complex;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ComplexUtils {
    private ComplexUtils() {
    }

    public static Complex[] convertToComplex(double[] dArr) {
        Complex[] complexArr = new Complex[dArr.length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            complexArr[i5] = new Complex(dArr[i5], 0.0d);
        }
        return complexArr;
    }

    public static Complex polar2Complex(double d, double d6) {
        if (d >= 0.0d) {
            return new Complex(FastMath.cos(d6) * d, FastMath.sin(d6) * d);
        }
        throw new MathIllegalArgumentException(LocalizedFormats.NEGATIVE_COMPLEX_MODULE, Double.valueOf(d));
    }
}
