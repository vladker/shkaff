package org.apache.commons.math3.transform;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FastFourierTransformer implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long serialVersionUID = 20120210;
    private final DftNormalization normalization;
    private static final double[] W_SUB_N_R = {1.0d, -1.0d, 6.123233995736766E-17d, 0.7071067811865476d, 0.9238795325112867d, 0.9807852804032304d, 0.9951847266721969d, 0.9987954562051724d, 0.9996988186962042d, 0.9999247018391445d, 0.9999811752826011d, 0.9999952938095762d, 0.9999988234517019d, 0.9999997058628822d, 0.9999999264657179d, 0.9999999816164293d, 0.9999999954041073d, 0.9999999988510269d, 0.9999999997127567d, 0.9999999999281892d, 0.9999999999820472d, 0.9999999999955118d, 0.999999999998878d, 0.9999999999997194d, 0.9999999999999298d, 0.9999999999999825d, 0.9999999999999957d, 0.9999999999999989d, 0.9999999999999998d, 0.9999999999999999d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d};
    private static final double[] W_SUB_N_I = {2.4492935982947064E-16d, -1.2246467991473532E-16d, -1.0d, -0.7071067811865475d, -0.3826834323650898d, -0.19509032201612825d, -0.0980171403295606d, -0.049067674327418015d, -0.024541228522912288d, -0.012271538285719925d, -0.006135884649154475d, -0.003067956762965976d, -0.0015339801862847655d, -7.669903187427045E-4d, -3.8349518757139556E-4d, -1.917475973107033E-4d, -9.587379909597734E-5d, -4.793689960306688E-5d, -2.396844980841822E-5d, -1.1984224905069705E-5d, -5.9921124526424275E-6d, -2.996056226334661E-6d, -1.4980281131690111E-6d, -7.490140565847157E-7d, -3.7450702829238413E-7d, -1.8725351414619535E-7d, -9.362675707309808E-8d, -4.681337853654909E-8d, -2.340668926827455E-8d, -1.1703344634137277E-8d, -5.8516723170686385E-9d, -2.9258361585343192E-9d, -1.4629180792671596E-9d, -7.314590396335798E-10d, -3.657295198167899E-10d, -1.8286475990839495E-10d, -9.143237995419748E-11d, -4.571618997709874E-11d, -2.285809498854937E-11d, -1.1429047494274685E-11d, -5.714523747137342E-12d, -2.857261873568671E-12d, -1.4286309367843356E-12d, -7.143154683921678E-13d, -3.571577341960839E-13d, -1.7857886709804195E-13d, -8.928943354902097E-14d, -4.4644716774510487E-14d, -2.2322358387255243E-14d, -1.1161179193627622E-14d, -5.580589596813811E-15d, -2.7902947984069054E-15d, -1.3951473992034527E-15d, -6.975736996017264E-16d, -3.487868498008632E-16d, -1.743934249004316E-16d, -8.71967124502158E-17d, -4.35983562251079E-17d, -2.179917811255395E-17d, -1.0899589056276974E-17d, -5.449794528138487E-18d, -2.7248972640692436E-18d, -1.3624486320346218E-18d};

    /* JADX INFO: renamed from: org.apache.commons.math3.transform.FastFourierTransformer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$transform$DftNormalization;

        static {
            int[] iArr = new int[DftNormalization.values().length];
            $SwitchMap$org$apache$commons$math3$transform$DftNormalization = iArr;
            try {
                iArr[DftNormalization.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$transform$DftNormalization[DftNormalization.UNITARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public FastFourierTransformer(DftNormalization dftNormalization) {
        this.normalization = dftNormalization;
    }

    private static void bitReversalShuffle2(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        int i5 = length >> 1;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (i7 < i6) {
                double d = dArr[i7];
                dArr[i7] = dArr[i6];
                dArr[i6] = d;
                double d6 = dArr2[i7];
                dArr2[i7] = dArr2[i6];
                dArr2[i6] = d6;
            }
            int i8 = i5;
            while (i8 <= i6 && i8 > 0) {
                i6 -= i8;
                i8 >>= 1;
            }
            i6 += i8;
        }
    }

    private static void normalizeTransformedData(double[][] dArr, DftNormalization dftNormalization, TransformType transformType) {
        int i5 = 0;
        double[] dArr2 = dArr[0];
        double[] dArr3 = dArr[1];
        int length = dArr2.length;
        int i6 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$transform$DftNormalization[dftNormalization.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                throw new MathIllegalStateException();
            }
            double dSqrt = 1.0d / FastMath.sqrt(length);
            while (i5 < length) {
                dArr2[i5] = dArr2[i5] * dSqrt;
                dArr3[i5] = dArr3[i5] * dSqrt;
                i5++;
            }
            return;
        }
        if (transformType == TransformType.INVERSE) {
            double d = 1.0d / ((double) length);
            while (i5 < length) {
                dArr2[i5] = dArr2[i5] * d;
                dArr3[i5] = dArr3[i5] * d;
                i5++;
            }
        }
    }

    public static void transformInPlace(double[][] dArr, DftNormalization dftNormalization, TransformType transformType) {
        int i5 = 2;
        if (dArr.length != 2) {
            throw new DimensionMismatchException(dArr.length, 2);
        }
        int i6 = 0;
        double[] dArr2 = dArr[0];
        double[] dArr3 = dArr[1];
        if (dArr2.length != dArr3.length) {
            throw new DimensionMismatchException(dArr3.length, dArr2.length);
        }
        int length = dArr2.length;
        if (!ArithmeticUtils.isPowerOfTwo(length)) {
            throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_CONSIDER_PADDING, Integer.valueOf(length));
        }
        if (length == 1) {
            return;
        }
        if (length == 2) {
            double d = dArr2[0];
            double d6 = dArr3[0];
            double d7 = dArr2[1];
            double d8 = dArr3[1];
            dArr2[0] = d + d7;
            dArr3[0] = d6 + d8;
            dArr2[1] = d - d7;
            dArr3[1] = d6 - d8;
            normalizeTransformedData(dArr, dftNormalization, transformType);
            return;
        }
        bitReversalShuffle2(dArr2, dArr3);
        if (transformType == TransformType.INVERSE) {
            for (int i7 = 0; i7 < length; i7 += 4) {
                int i8 = i7 + 1;
                int i9 = i7 + 2;
                int i10 = i7 + 3;
                double d9 = dArr2[i7];
                double d10 = dArr3[i7];
                double d11 = dArr2[i9];
                double d12 = dArr3[i9];
                double d13 = dArr2[i8];
                double d14 = dArr3[i8];
                double d15 = dArr2[i10];
                double d16 = dArr3[i10];
                dArr2[i7] = d9 + d11 + d13 + d15;
                dArr3[i7] = d10 + d12 + d14 + d16;
                double d17 = d9 - d13;
                dArr2[i8] = (d16 - d12) + d17;
                double d18 = d10 - d14;
                dArr3[i8] = (d11 - d15) + d18;
                dArr2[i9] = ((d9 - d11) + d13) - d15;
                dArr3[i9] = ((d10 - d12) + d14) - d16;
                dArr2[i10] = (d12 - d16) + d17;
                dArr3[i10] = (d15 - d11) + d18;
            }
        } else {
            for (int i11 = 0; i11 < length; i11 += 4) {
                int i12 = i11 + 1;
                int i13 = i11 + 2;
                int i14 = i11 + 3;
                double d19 = dArr2[i11];
                double d20 = dArr3[i11];
                double d21 = dArr2[i13];
                double d22 = dArr3[i13];
                double d23 = dArr2[i12];
                double d24 = dArr3[i12];
                double d25 = dArr2[i14];
                double d26 = dArr3[i14];
                dArr2[i11] = d19 + d21 + d23 + d25;
                dArr3[i11] = d20 + d22 + d24 + d26;
                double d27 = d19 - d23;
                dArr2[i12] = (d22 - d26) + d27;
                double d28 = d20 - d24;
                dArr3[i12] = (d25 - d21) + d28;
                dArr2[i13] = ((d19 - d21) + d23) - d25;
                dArr3[i13] = ((d20 - d22) + d24) - d26;
                dArr2[i14] = (d26 - d22) + d27;
                dArr3[i14] = (d21 - d25) + d28;
            }
        }
        int i15 = 4;
        while (i15 < length) {
            int i16 = i15 << 1;
            i5++;
            double d29 = W_SUB_N_R[i5];
            double d30 = W_SUB_N_I[i5];
            if (transformType == TransformType.INVERSE) {
                d30 = -d30;
            }
            int i17 = i6;
            while (i17 < length) {
                int i18 = i17 + i15;
                double d31 = 1.0d;
                double d32 = 0.0d;
                while (i6 < i15) {
                    int i19 = i17 + i6;
                    double d33 = dArr2[i19];
                    double d34 = dArr3[i19];
                    int i20 = i18 + i6;
                    double d35 = dArr2[i20];
                    double d36 = dArr3[i20];
                    double d37 = d31 * d35;
                    double d38 = d32 * d36;
                    dArr2[i19] = (d33 + d37) - d38;
                    double d39 = d36 * d31;
                    double d40 = d35 * d32;
                    dArr3[i19] = d34 + d39 + d40;
                    dArr2[i20] = d33 - (d37 - d38);
                    dArr3[i20] = d34 - (d39 + d40);
                    double d41 = (d31 * d29) - (d32 * d30);
                    d32 = (d32 * d29) + (d31 * d30);
                    i6++;
                    d31 = d41;
                }
                i17 += i16;
                i6 = 0;
            }
            i15 = i16;
        }
        normalizeTransformedData(dArr, dftNormalization, transformType);
    }

    @Deprecated
    public Object mdfft(Object obj, TransformType transformType) {
        MultiDimensionalComplexMatrix multiDimensionalComplexMatrix = (MultiDimensionalComplexMatrix) new MultiDimensionalComplexMatrix(obj).clone();
        int[] dimensionSizes = multiDimensionalComplexMatrix.getDimensionSizes();
        for (int i5 = 0; i5 < dimensionSizes.length; i5++) {
            mdfft(multiDimensionalComplexMatrix, transformType, i5, new int[0]);
        }
        return multiDimensionalComplexMatrix.getArray();
    }

    public Complex[] transform(double[] dArr, TransformType transformType) {
        double[][] dArr2 = {MathArrays.copyOf(dArr, dArr.length), new double[dArr.length]};
        transformInPlace(dArr2, this.normalization, transformType);
        return TransformUtils.createComplexArray(dArr2);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Deprecated
    public static class MultiDimensionalComplexMatrix implements Cloneable {
        protected int[] dimensionSize;
        protected Object multiDimensionalComplexArray;

        public MultiDimensionalComplexMatrix(Object obj) {
            this.multiDimensionalComplexArray = obj;
            int i5 = 0;
            for (Object obj2 = obj; obj2 instanceof Object[]; obj2 = obj2[0]) {
                i5++;
            }
            this.dimensionSize = new int[i5];
            int i6 = 0;
            while (obj instanceof Object[]) {
                Object[] objArr = obj;
                this.dimensionSize[i6] = objArr.length;
                obj = objArr[0];
                i6++;
            }
        }

        public Object clone() {
            MultiDimensionalComplexMatrix multiDimensionalComplexMatrix = new MultiDimensionalComplexMatrix(Array.newInstance((Class<?>) Complex.class, this.dimensionSize));
            clone(multiDimensionalComplexMatrix);
            return multiDimensionalComplexMatrix;
        }

        public Complex get(int... iArr) {
            if (iArr == null) {
                if (this.dimensionSize.length <= 0) {
                    return null;
                }
                throw new DimensionMismatchException(0, this.dimensionSize.length);
            }
            if (iArr.length != this.dimensionSize.length) {
                throw new DimensionMismatchException(iArr.length, this.dimensionSize.length);
            }
            Object obj = this.multiDimensionalComplexArray;
            for (int i5 = 0; i5 < this.dimensionSize.length; i5++) {
                obj = ((Object[]) obj)[iArr[i5]];
            }
            return (Complex) obj;
        }

        public Object getArray() {
            return this.multiDimensionalComplexArray;
        }

        public int[] getDimensionSizes() {
            return (int[]) this.dimensionSize.clone();
        }

        public Complex set(Complex complex, int... iArr) {
            int i5 = 0;
            if (iArr == null) {
                if (this.dimensionSize.length <= 0) {
                    return null;
                }
                throw new DimensionMismatchException(0, this.dimensionSize.length);
            }
            if (iArr.length != this.dimensionSize.length) {
                throw new DimensionMismatchException(iArr.length, this.dimensionSize.length);
            }
            Object[] objArr = (Object[]) this.multiDimensionalComplexArray;
            while (true) {
                int[] iArr2 = this.dimensionSize;
                if (i5 >= iArr2.length - 1) {
                    Complex complex2 = (Complex) objArr[iArr[iArr2.length - 1]];
                    objArr[iArr[iArr2.length - 1]] = complex;
                    return complex2;
                }
                objArr = (Object[]) objArr[iArr[i5]];
                i5++;
            }
        }

        private void clone(MultiDimensionalComplexMatrix multiDimensionalComplexMatrix) {
            int[] iArr;
            int[] iArr2 = new int[this.dimensionSize.length];
            int i5 = 1;
            int i6 = 0;
            while (true) {
                iArr = this.dimensionSize;
                if (i6 >= iArr.length) {
                    break;
                }
                i5 *= iArr[i6];
                i6++;
            }
            int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i5, iArr.length);
            for (int[] iArr4 : iArr3) {
                System.arraycopy(iArr2, 0, iArr4, 0, this.dimensionSize.length);
                int i7 = 0;
                while (true) {
                    int[] iArr5 = this.dimensionSize;
                    if (i7 >= iArr5.length) {
                        break;
                    }
                    int i8 = iArr2[i7] + 1;
                    iArr2[i7] = i8;
                    if (i8 < iArr5[i7]) {
                        break;
                    }
                    iArr2[i7] = 0;
                    i7++;
                }
            }
            for (int[] iArr6 : iArr3) {
                multiDimensionalComplexMatrix.set(get(iArr6), iArr6);
            }
        }
    }

    public Complex[] transform(UnivariateFunction univariateFunction, double d, double d6, int i5, TransformType transformType) {
        return transform(FunctionUtils.sample(univariateFunction, d, d6, i5), transformType);
    }

    @Deprecated
    private void mdfft(MultiDimensionalComplexMatrix multiDimensionalComplexMatrix, TransformType transformType, int i5, int[] iArr) {
        int[] dimensionSizes = multiDimensionalComplexMatrix.getDimensionSizes();
        int i6 = 0;
        if (iArr.length == dimensionSizes.length) {
            Complex[] complexArr = new Complex[dimensionSizes[i5]];
            for (int i7 = 0; i7 < dimensionSizes[i5]; i7++) {
                iArr[i5] = i7;
                complexArr[i7] = multiDimensionalComplexMatrix.get(iArr);
            }
            Complex[] complexArrTransform = transform(complexArr, transformType);
            while (i6 < dimensionSizes[i5]) {
                iArr[i5] = i6;
                multiDimensionalComplexMatrix.set(complexArrTransform[i6], iArr);
                i6++;
            }
            return;
        }
        int[] iArr2 = new int[iArr.length + 1];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        if (iArr.length == i5) {
            iArr2[i5] = 0;
            mdfft(multiDimensionalComplexMatrix, transformType, i5, iArr2);
        } else {
            while (i6 < dimensionSizes[iArr.length]) {
                iArr2[iArr.length] = i6;
                mdfft(multiDimensionalComplexMatrix, transformType, i5, iArr2);
                i6++;
            }
        }
    }

    public Complex[] transform(Complex[] complexArr, TransformType transformType) {
        double[][] dArrCreateRealImaginaryArray = TransformUtils.createRealImaginaryArray(complexArr);
        transformInPlace(dArrCreateRealImaginaryArray, this.normalization, transformType);
        return TransformUtils.createComplexArray(dArrCreateRealImaginaryArray);
    }
}
