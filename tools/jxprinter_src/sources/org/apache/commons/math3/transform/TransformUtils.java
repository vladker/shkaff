package org.apache.commons.math3.transform;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TransformUtils {
    private static final int[] POWERS_OF_TWO = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL, 134217728, 268435456, 536870912, 1073741824};

    private TransformUtils() {
    }

    public static Complex[] createComplexArray(double[][] dArr) {
        if (dArr.length != 2) {
            throw new DimensionMismatchException(dArr.length, 2);
        }
        double[] dArr2 = dArr[0];
        double[] dArr3 = dArr[1];
        if (dArr2.length != dArr3.length) {
            throw new DimensionMismatchException(dArr3.length, dArr2.length);
        }
        int length = dArr2.length;
        Complex[] complexArr = new Complex[length];
        for (int i5 = 0; i5 < length; i5++) {
            complexArr[i5] = new Complex(dArr2[i5], dArr3[i5]);
        }
        return complexArr;
    }

    public static double[][] createRealImaginaryArray(Complex[] complexArr) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 2, complexArr.length);
        double[] dArr2 = dArr[0];
        double[] dArr3 = dArr[1];
        for (int i5 = 0; i5 < complexArr.length; i5++) {
            Complex complex = complexArr[i5];
            dArr2[i5] = complex.getReal();
            dArr3[i5] = complex.getImaginary();
        }
        return dArr;
    }

    public static int exactLog2(int i5) {
        int iBinarySearch = Arrays.binarySearch(POWERS_OF_TWO, i5);
        if (iBinarySearch >= 0) {
            return iBinarySearch;
        }
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_CONSIDER_PADDING, Integer.valueOf(i5));
    }

    public static double[] scaleArray(double[] dArr, double d) {
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr[i5] = dArr[i5] * d;
        }
        return dArr;
    }

    public static Complex[] scaleArray(Complex[] complexArr, double d) {
        for (int i5 = 0; i5 < complexArr.length; i5++) {
            complexArr[i5] = new Complex(complexArr[i5].getReal() * d, complexArr[i5].getImaginary() * d);
        }
        return complexArr;
    }
}
