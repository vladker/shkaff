package org.apache.commons.math3.analysis.differentiation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DSCompiler {
    private static AtomicReference<DSCompiler[][]> compilers = new AtomicReference<>(null);
    private final int[][][] compIndirection;
    private final int[][] derivativesIndirection;
    private final int[] lowerIndirection;
    private final int[][][] multIndirection;
    private final int order;
    private final int parameters;
    private final int[][] sizes;

    private DSCompiler(int i5, int i6, DSCompiler dSCompiler, DSCompiler dSCompiler2) {
        this.parameters = i5;
        this.order = i6;
        int[][] iArrCompileSizes = compileSizes(i5, i6, dSCompiler);
        this.sizes = iArrCompileSizes;
        int[][] iArrCompileDerivativesIndirection = compileDerivativesIndirection(i5, i6, dSCompiler, dSCompiler2);
        this.derivativesIndirection = iArrCompileDerivativesIndirection;
        int[] iArrCompileLowerIndirection = compileLowerIndirection(i5, i6, dSCompiler, dSCompiler2);
        this.lowerIndirection = iArrCompileLowerIndirection;
        this.multIndirection = compileMultiplicationIndirection(i5, i6, dSCompiler, dSCompiler2, iArrCompileLowerIndirection);
        this.compIndirection = compileCompositionIndirection(i5, i6, dSCompiler, dSCompiler2, iArrCompileSizes, iArrCompileDerivativesIndirection);
    }

    private static int[][][] compileCompositionIndirection(int i5, int i6, DSCompiler dSCompiler, DSCompiler dSCompiler2, int[][] iArr, int[][] iArr2) {
        int i7 = i5;
        int i8 = i6;
        DSCompiler dSCompiler3 = dSCompiler2;
        int[][] iArr3 = iArr;
        int i9 = 0;
        int i10 = 1;
        if (i7 == 0 || i8 == 0) {
            return new int[][][]{new int[][]{new int[]{1, 0}}};
        }
        int[][][] iArr4 = dSCompiler.compIndirection;
        int length = iArr4.length;
        int length2 = dSCompiler3.compIndirection.length;
        int[][][] iArr5 = new int[length + length2][][];
        System.arraycopy(iArr4, 0, iArr5, 0, length);
        int i11 = 0;
        while (i11 < length2) {
            ArrayList arrayList = new ArrayList();
            int[][] iArr6 = dSCompiler3.compIndirection[i11];
            int length3 = iArr6.length;
            int i12 = i9;
            while (i12 < length3) {
                int[] iArr7 = iArr6[i12];
                int length4 = iArr7.length + i10;
                int i13 = i10;
                int[] iArr8 = new int[length4];
                iArr8[i9] = iArr7[i9];
                iArr8[i13] = iArr7[i13] + 1;
                int i14 = i9;
                int[] iArr9 = new int[i7];
                int i15 = i7 - 1;
                iArr9[i15] = i13;
                int i16 = i12;
                iArr8[iArr7.length] = getPartialDerivativeIndex(i7, i8, iArr3, iArr9);
                int i17 = length;
                int i18 = 2;
                while (i18 < iArr7.length) {
                    int i19 = i18;
                    iArr8[i19] = convertIndex(iArr7[i18], i7, dSCompiler3.derivativesIndirection, i5, i8, iArr3);
                    i7 = i5;
                    i8 = i6;
                    iArr3 = iArr;
                    i18 = i19 + 1;
                    length4 = length4;
                    length2 = length2;
                    iArr7 = iArr7;
                }
                int i20 = length2;
                int i21 = 2;
                Arrays.sort(iArr8, 2, length4);
                arrayList.add(iArr8);
                int i22 = 2;
                int[] iArr10 = iArr7;
                while (i22 < iArr10.length) {
                    int length5 = iArr10.length;
                    int[] iArr11 = new int[length5];
                    iArr11[i14] = iArr10[i14];
                    iArr11[i13] = iArr10[i13];
                    int i23 = i21;
                    while (i23 < iArr10.length) {
                        int i24 = length5;
                        int i25 = i23;
                        int[] iArr12 = iArr11;
                        int[] iArr13 = iArr10;
                        int iConvertIndex = convertIndex(iArr10[i23], i5, dSCompiler3.derivativesIndirection, i5, i6, iArr);
                        iArr12[i25] = iConvertIndex;
                        if (i25 == i22) {
                            int i26 = i14;
                            System.arraycopy(iArr2[iConvertIndex], i26, iArr9, i26, i5);
                            iArr9[i15] = iArr9[i15] + 1;
                            iArr12[i25] = getPartialDerivativeIndex(i5, i6, iArr, iArr9);
                        }
                        i23 = i25 + 1;
                        length5 = i24;
                        iArr11 = iArr12;
                        iArr10 = iArr13;
                        i21 = 2;
                        i14 = 0;
                        dSCompiler3 = dSCompiler2;
                    }
                    int i27 = length5;
                    int i28 = i21;
                    int[] iArr14 = iArr11;
                    Arrays.sort(iArr14, i28, i27);
                    arrayList.add(iArr14);
                    i22++;
                    dSCompiler3 = dSCompiler2;
                    i21 = i28;
                    i14 = 0;
                }
                i7 = i5;
                i8 = i6;
                iArr3 = iArr;
                i12 = i16 + 1;
                dSCompiler3 = dSCompiler2;
                i10 = i13;
                length = i17;
                length2 = i20;
                i9 = 0;
            }
            int i29 = i10;
            int i30 = length;
            int i31 = length2;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            for (int i32 = 0; i32 < arrayList.size(); i32++) {
                int[] iArr15 = (int[]) arrayList.get(i32);
                if (iArr15[0] > 0) {
                    for (int i33 = i32 + 1; i33 < arrayList.size(); i33++) {
                        int[] iArr16 = (int[]) arrayList.get(i33);
                        int i34 = iArr15.length == iArr16.length ? i29 : 0;
                        for (int i35 = i29; i34 != 0 && i35 < iArr15.length; i35++) {
                            i34 &= iArr15[i35] == iArr16[i35] ? i29 : 0;
                        }
                        if (i34 != 0) {
                            iArr15[0] = iArr15[0] + iArr16[0];
                            iArr16[0] = 0;
                        }
                    }
                    arrayList2.add(iArr15);
                }
            }
            iArr5[i30 + i11] = (int[][]) arrayList2.toArray(new int[arrayList2.size()][]);
            i11++;
            dSCompiler3 = dSCompiler2;
            i10 = i29;
            length = i30;
            length2 = i31;
            i9 = 0;
        }
        return iArr5;
    }

    private static int[][] compileDerivativesIndirection(int i5, int i6, DSCompiler dSCompiler, DSCompiler dSCompiler2) {
        Class cls = Integer.TYPE;
        if (i5 == 0 || i6 == 0) {
            return (int[][]) Array.newInstance((Class<?>) cls, 1, i5);
        }
        int length = dSCompiler.derivativesIndirection.length;
        int length2 = dSCompiler2.derivativesIndirection.length;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, length + length2, i5);
        for (int i7 = 0; i7 < length; i7++) {
            System.arraycopy(dSCompiler.derivativesIndirection[i7], 0, iArr[i7], 0, i5 - 1);
        }
        for (int i8 = 0; i8 < length2; i8++) {
            int i9 = length + i8;
            System.arraycopy(dSCompiler2.derivativesIndirection[i8], 0, iArr[i9], 0, i5);
            int[] iArr2 = iArr[i9];
            int i10 = i5 - 1;
            iArr2[i10] = iArr2[i10] + 1;
        }
        return iArr;
    }

    private static int[] compileLowerIndirection(int i5, int i6, DSCompiler dSCompiler, DSCompiler dSCompiler2) {
        if (i5 == 0 || i6 <= 1) {
            return new int[]{0};
        }
        int[] iArr = dSCompiler.lowerIndirection;
        int length = iArr.length;
        int length2 = dSCompiler2.lowerIndirection.length;
        int[] iArr2 = new int[length + length2];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        for (int i7 = 0; i7 < length2; i7++) {
            iArr2[length + i7] = dSCompiler.getSize() + dSCompiler2.lowerIndirection[i7];
        }
        return iArr2;
    }

    private static int[][][] compileMultiplicationIndirection(int i5, int i6, DSCompiler dSCompiler, DSCompiler dSCompiler2, int[] iArr) {
        if (i5 == 0 || i6 == 0) {
            return new int[][][]{new int[][]{new int[]{1, 0, 0}}};
        }
        int[][][] iArr2 = dSCompiler.multIndirection;
        int length = iArr2.length;
        int length2 = dSCompiler2.multIndirection.length;
        int[][][] iArr3 = new int[length + length2][][];
        System.arraycopy(iArr2, 0, iArr3, 0, length);
        for (int i7 = 0; i7 < length2; i7++) {
            int[][] iArr4 = dSCompiler2.multIndirection[i7];
            ArrayList arrayList = new ArrayList(iArr4.length * 2);
            for (int i8 = 0; i8 < iArr4.length; i8++) {
                int[] iArr5 = iArr4[i8];
                arrayList.add(new int[]{iArr5[0], iArr[iArr5[1]], iArr5[2] + length});
                int[] iArr6 = iArr4[i8];
                arrayList.add(new int[]{iArr6[0], iArr6[1] + length, iArr[iArr6[2]]});
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                int[] iArr7 = (int[]) arrayList.get(i9);
                if (iArr7[0] > 0) {
                    for (int i10 = i9 + 1; i10 < arrayList.size(); i10++) {
                        int[] iArr8 = (int[]) arrayList.get(i10);
                        if (iArr7[1] == iArr8[1] && iArr7[2] == iArr8[2]) {
                            iArr7[0] = iArr7[0] + iArr8[0];
                            iArr8[0] = 0;
                        }
                    }
                    arrayList2.add(iArr7);
                }
            }
            iArr3[length + i7] = (int[][]) arrayList2.toArray(new int[arrayList2.size()][]);
        }
        return iArr3;
    }

    private static int[][] compileSizes(int i5, int i6, DSCompiler dSCompiler) {
        int i7 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i5 + 1, i6 + 1);
        if (i5 == 0) {
            Arrays.fill(iArr[0], 1);
            return iArr;
        }
        System.arraycopy(dSCompiler.sizes, 0, iArr, 0, i5);
        iArr[i5][0] = 1;
        while (i7 < i6) {
            int[] iArr2 = iArr[i5];
            int i8 = i7 + 1;
            iArr2[i8] = iArr2[i7] + iArr[i5 - 1][i8];
            i7 = i8;
        }
        return iArr;
    }

    private static int convertIndex(int i5, int i6, int[][] iArr, int i7, int i8, int[][] iArr2) {
        int[] iArr3 = new int[i7];
        System.arraycopy(iArr[i5], 0, iArr3, 0, FastMath.min(i6, i7));
        return getPartialDerivativeIndex(i7, i8, iArr2, iArr3);
    }

    public static DSCompiler getCompiler(int i5, int i6) {
        DSCompiler dSCompiler;
        DSCompiler[][] dSCompilerArr = compilers.get();
        if (dSCompilerArr != null && dSCompilerArr.length > i5) {
            DSCompiler[] dSCompilerArr2 = dSCompilerArr[i5];
            if (dSCompilerArr2.length > i6 && (dSCompiler = dSCompilerArr2[i6]) != null) {
                return dSCompiler;
            }
        }
        DSCompiler[][] dSCompilerArr3 = (DSCompiler[][]) Array.newInstance((Class<?>) DSCompiler.class, FastMath.max(i5, dSCompilerArr == null ? 0 : dSCompilerArr.length) + 1, FastMath.max(i6, dSCompilerArr == null ? 0 : dSCompilerArr[0].length) + 1);
        if (dSCompilerArr != null) {
            for (int i7 = 0; i7 < dSCompilerArr.length; i7++) {
                DSCompiler[] dSCompilerArr4 = dSCompilerArr[i7];
                System.arraycopy(dSCompilerArr4, 0, dSCompilerArr3[i7], 0, dSCompilerArr4.length);
            }
        }
        for (int i8 = 0; i8 <= i5 + i6; i8++) {
            int iMax = FastMath.max(0, i8 - i5);
            while (iMax <= FastMath.min(i6, i8)) {
                int i9 = i8 - iMax;
                DSCompiler[] dSCompilerArr5 = dSCompilerArr3[i9];
                if (dSCompilerArr5[iMax] == null) {
                    dSCompilerArr5[iMax] = new DSCompiler(i9, iMax, i9 == 0 ? null : dSCompilerArr3[i9 - 1][iMax], iMax != 0 ? dSCompilerArr5[iMax - 1] : null);
                }
                iMax++;
            }
        }
        AtomicReference<DSCompiler[][]> atomicReference = compilers;
        while (!atomicReference.compareAndSet(dSCompilerArr, dSCompilerArr3) && atomicReference.get() == dSCompilerArr) {
        }
        return dSCompilerArr3[i5][i6];
    }

    public void acos(double[] dArr, int i5, double[] dArr2, int i6) {
        double d;
        int i7;
        DSCompiler dSCompiler = this;
        char c = 1;
        double[] dArr3 = new double[dSCompiler.order + 1];
        double d6 = dArr[i5];
        char c6 = 0;
        dArr3[0] = FastMath.acos(d6);
        int i8 = dSCompiler.order;
        if (i8 > 0) {
            double[] dArr4 = new double[i8];
            dArr4[0] = -1.0d;
            double d7 = d6 * d6;
            double d8 = 1.0d / (1.0d - d7);
            double dSqrt = FastMath.sqrt(d8);
            dArr3[1] = dArr4[0] * dSqrt;
            int i9 = 2;
            int i10 = 2;
            while (i10 <= dSCompiler.order) {
                int i11 = i10 - 1;
                char c7 = c6;
                char c8 = c;
                dArr4[i11] = ((double) i11) * dArr4[i10 - 2];
                double d9 = 0.0d;
                while (i11 >= 0) {
                    double d10 = (d9 * d7) + dArr4[i11];
                    if (i11 > i9) {
                        int i12 = i11 - 1;
                        d = d10;
                        dArr4[i11 - 2] = (((double) ((i10 * 2) - i11)) * dArr4[i11 - 3]) + (((double) i12) * dArr4[i12]);
                        i7 = 2;
                    } else {
                        d = d10;
                        i7 = i9;
                        if (i11 == i7) {
                            dArr4[c7] = dArr4[c8];
                        }
                    }
                    i11 -= 2;
                    i9 = i7;
                    d9 = d;
                }
                int i13 = i9;
                if ((i10 & 1) == 0) {
                    d9 *= d6;
                }
                dSqrt *= d8;
                dArr3[i10] = d9 * dSqrt;
                i10++;
                i9 = i13;
                c = c8;
                c6 = c7;
                dSCompiler = this;
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void acosh(double[] dArr, int i5, double[] dArr2, int i6) {
        double d;
        int i7;
        DSCompiler dSCompiler = this;
        char c = 1;
        double[] dArr3 = new double[dSCompiler.order + 1];
        double d6 = dArr[i5];
        char c6 = 0;
        dArr3[0] = FastMath.acosh(d6);
        int i8 = dSCompiler.order;
        if (i8 > 0) {
            double[] dArr4 = new double[i8];
            dArr4[0] = 1.0d;
            double d7 = d6 * d6;
            double d8 = 1.0d / (d7 - 1.0d);
            double dSqrt = FastMath.sqrt(d8);
            dArr3[1] = dArr4[0] * dSqrt;
            int i9 = 2;
            int i10 = 2;
            while (i10 <= dSCompiler.order) {
                int i11 = i10 - 1;
                char c7 = c6;
                char c8 = c;
                double[] dArr5 = dArr3;
                dArr4[i11] = ((double) (1 - i10)) * dArr4[i10 - 2];
                double d9 = 0.0d;
                while (i11 >= 0) {
                    double d10 = (d9 * d7) + dArr4[i11];
                    if (i11 > i9) {
                        d = d10;
                        dArr4[i11 - 2] = (((double) (i11 - (i10 * 2))) * dArr4[i11 - 3]) + (((double) (1 - i11)) * dArr4[i11 - 1]);
                        i7 = 2;
                    } else {
                        d = d10;
                        i7 = i9;
                        if (i11 == i7) {
                            dArr4[c7] = -dArr4[c8];
                        }
                    }
                    i11 -= 2;
                    i9 = i7;
                    d9 = d;
                }
                int i12 = i9;
                if ((i10 & 1) == 0) {
                    d9 *= d6;
                }
                dSqrt *= d8;
                dArr5[i10] = d9 * dSqrt;
                i10++;
                i9 = i12;
                c6 = c7;
                c = c8;
                dArr3 = dArr5;
                dSCompiler = this;
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void add(double[] dArr, int i5, double[] dArr2, int i6, double[] dArr3, int i7) {
        for (int i8 = 0; i8 < getSize(); i8++) {
            dArr3[i7 + i8] = dArr[i5 + i8] + dArr2[i6 + i8];
        }
    }

    public void asin(double[] dArr, int i5, double[] dArr2, int i6) {
        double d;
        int i7;
        DSCompiler dSCompiler = this;
        char c = 1;
        double[] dArr3 = new double[dSCompiler.order + 1];
        double d6 = dArr[i5];
        char c6 = 0;
        dArr3[0] = FastMath.asin(d6);
        int i8 = dSCompiler.order;
        if (i8 > 0) {
            double[] dArr4 = new double[i8];
            dArr4[0] = 1.0d;
            double d7 = d6 * d6;
            double d8 = 1.0d / (1.0d - d7);
            double dSqrt = FastMath.sqrt(d8);
            dArr3[1] = dArr4[0] * dSqrt;
            int i9 = 2;
            int i10 = 2;
            while (i10 <= dSCompiler.order) {
                int i11 = i10 - 1;
                char c7 = c6;
                char c8 = c;
                dArr4[i11] = ((double) i11) * dArr4[i10 - 2];
                double d9 = 0.0d;
                while (i11 >= 0) {
                    double d10 = (d9 * d7) + dArr4[i11];
                    if (i11 > i9) {
                        int i12 = i11 - 1;
                        d = d10;
                        dArr4[i11 - 2] = (((double) ((i10 * 2) - i11)) * dArr4[i11 - 3]) + (((double) i12) * dArr4[i12]);
                        i7 = 2;
                    } else {
                        d = d10;
                        i7 = i9;
                        if (i11 == i7) {
                            dArr4[c7] = dArr4[c8];
                        }
                    }
                    i11 -= 2;
                    i9 = i7;
                    d9 = d;
                }
                int i13 = i9;
                if ((i10 & 1) == 0) {
                    d9 *= d6;
                }
                dSqrt *= d8;
                dArr3[i10] = d9 * dSqrt;
                i10++;
                i9 = i13;
                c = c8;
                c6 = c7;
                dSCompiler = this;
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void asinh(double[] dArr, int i5, double[] dArr2, int i6) {
        double d;
        int i7;
        DSCompiler dSCompiler = this;
        char c = 1;
        double[] dArr3 = new double[dSCompiler.order + 1];
        double d6 = dArr[i5];
        char c6 = 0;
        dArr3[0] = FastMath.asinh(d6);
        int i8 = dSCompiler.order;
        if (i8 > 0) {
            double[] dArr4 = new double[i8];
            dArr4[0] = 1.0d;
            double d7 = d6 * d6;
            double d8 = 1.0d / (d7 + 1.0d);
            double dSqrt = FastMath.sqrt(d8);
            dArr3[1] = dArr4[0] * dSqrt;
            int i9 = 2;
            int i10 = 2;
            while (i10 <= dSCompiler.order) {
                int i11 = i10 - 1;
                char c7 = c6;
                char c8 = c;
                double[] dArr5 = dArr3;
                dArr4[i11] = ((double) (1 - i10)) * dArr4[i10 - 2];
                double d9 = 0.0d;
                while (i11 >= 0) {
                    double d10 = (d9 * d7) + dArr4[i11];
                    if (i11 > i9) {
                        int i12 = i11 - 1;
                        d = d10;
                        dArr4[i11 - 2] = (((double) (i11 - (i10 * 2))) * dArr4[i11 - 3]) + (((double) i12) * dArr4[i12]);
                        i7 = 2;
                    } else {
                        d = d10;
                        i7 = i9;
                        if (i11 == i7) {
                            dArr4[c7] = dArr4[c8];
                        }
                    }
                    i11 -= 2;
                    i9 = i7;
                    d9 = d;
                }
                int i13 = i9;
                if ((i10 & 1) == 0) {
                    d9 *= d6;
                }
                dSqrt *= d8;
                dArr5[i10] = d9 * dSqrt;
                i10++;
                i9 = i13;
                c6 = c7;
                c = c8;
                dArr3 = dArr5;
                dSCompiler = this;
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void atan(double[] dArr, int i5, double[] dArr2, int i6) {
        double d;
        int i7;
        DSCompiler dSCompiler = this;
        char c = 1;
        double[] dArr3 = new double[dSCompiler.order + 1];
        double d6 = dArr[i5];
        char c6 = 0;
        dArr3[0] = FastMath.atan(d6);
        int i8 = dSCompiler.order;
        if (i8 > 0) {
            double[] dArr4 = new double[i8];
            dArr4[0] = 1.0d;
            double d7 = d6 * d6;
            double d8 = 1.0d / (d7 + 1.0d);
            dArr3[1] = 1.0d * d8;
            int i9 = 2;
            int i10 = 2;
            double d9 = d8;
            while (i10 <= dSCompiler.order) {
                int i11 = i10 - 1;
                char c7 = c6;
                char c8 = c;
                double[] dArr5 = dArr3;
                dArr4[i11] = ((double) (-i10)) * dArr4[i10 - 2];
                double d10 = 0.0d;
                while (i11 >= 0) {
                    double d11 = (d10 * d7) + dArr4[i11];
                    if (i11 > i9) {
                        int i12 = i11 - 1;
                        d = d11;
                        dArr4[i11 - 2] = (((double) (i12 - (i10 * 2))) * dArr4[i11 - 3]) + (((double) i12) * dArr4[i12]);
                        i7 = 2;
                    } else {
                        d = d11;
                        i7 = i9;
                        if (i11 == i7) {
                            dArr4[c7] = dArr4[c8];
                        }
                    }
                    i11 -= 2;
                    i9 = i7;
                    d10 = d;
                }
                int i13 = i9;
                if ((i10 & 1) == 0) {
                    d10 *= d6;
                }
                d9 *= d8;
                dArr5[i10] = d10 * d9;
                i10++;
                i9 = i13;
                c6 = c7;
                c = c8;
                dArr3 = dArr5;
                dSCompiler = this;
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void atan2(double[] dArr, int i5, double[] dArr2, int i6, double[] dArr3, int i7) {
        double[] dArr4 = new double[getSize()];
        multiply(dArr2, i6, dArr2, i6, dArr4, 0);
        int size = getSize();
        double[] dArr5 = new double[size];
        multiply(dArr, i5, dArr, i5, dArr5, 0);
        add(dArr4, 0, dArr5, 0, dArr5, 0);
        rootN(dArr5, 0, 2, dArr4, 0);
        if (dArr2[i6] >= 0.0d) {
            add(dArr4, 0, dArr2, i6, dArr5, 0);
            divide(dArr, i5, dArr5, 0, dArr4, 0);
            atan(dArr4, 0, dArr5, 0);
            for (int i8 = 0; i8 < size; i8++) {
                dArr3[i7 + i8] = dArr5[i8] * 2.0d;
            }
        } else {
            subtract(dArr4, 0, dArr2, i6, dArr5, 0);
            divide(dArr, i5, dArr5, 0, dArr4, 0);
            atan(dArr4, 0, dArr5, 0);
            double d = dArr5[0];
            dArr3[i7] = (d <= 0.0d ? -3.141592653589793d : 3.141592653589793d) - (d * 2.0d);
            for (int i9 = 1; i9 < size; i9++) {
                dArr3[i7 + i9] = dArr5[i9] * (-2.0d);
            }
        }
        dArr3[i7] = FastMath.atan2(dArr[i5], dArr2[i6]);
    }

    public void atanh(double[] dArr, int i5, double[] dArr2, int i6) {
        double d;
        int i7;
        DSCompiler dSCompiler = this;
        char c = 1;
        double[] dArr3 = new double[dSCompiler.order + 1];
        double d6 = dArr[i5];
        char c6 = 0;
        dArr3[0] = FastMath.atanh(d6);
        int i8 = dSCompiler.order;
        if (i8 > 0) {
            double[] dArr4 = new double[i8];
            dArr4[0] = 1.0d;
            double d7 = d6 * d6;
            double d8 = 1.0d / (1.0d - d7);
            dArr3[1] = 1.0d * d8;
            int i9 = 2;
            int i10 = 2;
            double d9 = d8;
            while (i10 <= dSCompiler.order) {
                int i11 = i10 - 1;
                char c7 = c6;
                char c8 = c;
                dArr4[i11] = ((double) i10) * dArr4[i10 - 2];
                double d10 = 0.0d;
                while (i11 >= 0) {
                    double d11 = (d10 * d7) + dArr4[i11];
                    if (i11 > i9) {
                        int i12 = i11 - 1;
                        d = d11;
                        dArr4[i11 - 2] = (((double) (((i10 * 2) - i11) + 1)) * dArr4[i11 - 3]) + (((double) i12) * dArr4[i12]);
                        i7 = 2;
                    } else {
                        d = d11;
                        i7 = i9;
                        if (i11 == i7) {
                            dArr4[c7] = dArr4[c8];
                        }
                    }
                    i11 -= 2;
                    i9 = i7;
                    d10 = d;
                }
                int i13 = i9;
                if ((i10 & 1) == 0) {
                    d10 *= d6;
                }
                d9 *= d8;
                dArr3[i10] = d10 * d9;
                i10++;
                i9 = i13;
                c = c8;
                c6 = c7;
                dSCompiler = this;
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void checkCompatibility(DSCompiler dSCompiler) {
        if (this.parameters != dSCompiler.parameters) {
            throw new DimensionMismatchException(this.parameters, dSCompiler.parameters);
        }
        if (this.order != dSCompiler.order) {
            throw new DimensionMismatchException(this.order, dSCompiler.order);
        }
    }

    public void compose(double[] dArr, int i5, double[] dArr2, double[] dArr3, int i6) {
        int i7 = 0;
        while (true) {
            int[][][] iArr = this.compIndirection;
            if (i7 >= iArr.length) {
                return;
            }
            double d = 0.0d;
            for (int[] iArr2 : iArr[i7]) {
                double d6 = ((double) iArr2[0]) * dArr2[iArr2[1]];
                for (int i8 = 2; i8 < iArr2.length; i8++) {
                    d6 *= dArr[iArr2[i8] + i5];
                }
                d += d6;
            }
            dArr3[i6 + i7] = d;
            i7++;
        }
    }

    public void cos(double[] dArr, int i5, double[] dArr2, int i6) {
        double[] dArr3 = new double[this.order + 1];
        dArr3[0] = FastMath.cos(dArr[i5]);
        if (this.order > 0) {
            dArr3[1] = -FastMath.sin(dArr[i5]);
            for (int i7 = 2; i7 <= this.order; i7++) {
                dArr3[i7] = -dArr3[i7 - 2];
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void cosh(double[] dArr, int i5, double[] dArr2, int i6) {
        double[] dArr3 = new double[this.order + 1];
        dArr3[0] = FastMath.cosh(dArr[i5]);
        if (this.order > 0) {
            dArr3[1] = FastMath.sinh(dArr[i5]);
            for (int i7 = 2; i7 <= this.order; i7++) {
                dArr3[i7] = dArr3[i7 - 2];
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void divide(double[] dArr, int i5, double[] dArr2, int i6, double[] dArr3, int i7) {
        double[] dArr4 = new double[getSize()];
        pow(dArr2, i5, -1, dArr4, 0);
        multiply(dArr, i5, dArr4, 0, dArr3, i7);
    }

    public void exp(double[] dArr, int i5, double[] dArr2, int i6) {
        double[] dArr3 = new double[this.order + 1];
        Arrays.fill(dArr3, FastMath.exp(dArr[i5]));
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void expm1(double[] dArr, int i5, double[] dArr2, int i6) {
        double[] dArr3 = new double[this.order + 1];
        dArr3[0] = FastMath.expm1(dArr[i5]);
        Arrays.fill(dArr3, 1, this.order + 1, FastMath.exp(dArr[i5]));
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public int getFreeParameters() {
        return this.parameters;
    }

    public int getOrder() {
        return this.order;
    }

    public int getPartialDerivativeIndex(int... iArr) {
        if (iArr.length == getFreeParameters()) {
            return getPartialDerivativeIndex(this.parameters, this.order, this.sizes, iArr);
        }
        throw new DimensionMismatchException(iArr.length, getFreeParameters());
    }

    public int[] getPartialDerivativeOrders(int i5) {
        return this.derivativesIndirection[i5];
    }

    public int getSize() {
        return this.sizes[this.parameters][this.order];
    }

    public void linearCombination(double d, double[] dArr, int i5, double d6, double[] dArr2, int i6, double[] dArr3, int i7) {
        for (int i8 = 0; i8 < getSize(); i8++) {
            dArr3[i7 + i8] = MathArrays.linearCombination(d, dArr[i5 + i8], d6, dArr2[i6 + i8]);
        }
    }

    public void log(double[] dArr, int i5, double[] dArr2, int i6) {
        double[] dArr3 = new double[this.order + 1];
        dArr3[0] = FastMath.log(dArr[i5]);
        if (this.order > 0) {
            double d = 1.0d / dArr[i5];
            double d6 = d;
            for (int i7 = 1; i7 <= this.order; i7++) {
                dArr3[i7] = d6;
                d6 *= ((double) (-i7)) * d;
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void log10(double[] dArr, int i5, double[] dArr2, int i6) {
        double[] dArr3 = new double[this.order + 1];
        dArr3[0] = FastMath.log10(dArr[i5]);
        if (this.order > 0) {
            double d = 1.0d / dArr[i5];
            double dLog = d / FastMath.log(10.0d);
            for (int i7 = 1; i7 <= this.order; i7++) {
                dArr3[i7] = dLog;
                dLog *= ((double) (-i7)) * d;
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void log1p(double[] dArr, int i5, double[] dArr2, int i6) {
        double[] dArr3 = new double[this.order + 1];
        dArr3[0] = FastMath.log1p(dArr[i5]);
        if (this.order > 0) {
            double d = 1.0d / (dArr[i5] + 1.0d);
            double d6 = d;
            for (int i7 = 1; i7 <= this.order; i7++) {
                dArr3[i7] = d6;
                d6 *= ((double) (-i7)) * d;
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void multiply(double[] dArr, int i5, double[] dArr2, int i6, double[] dArr3, int i7) {
        int i8 = 0;
        while (true) {
            int[][][] iArr = this.multIndirection;
            if (i8 >= iArr.length) {
                return;
            }
            double d = 0.0d;
            for (int[] iArr2 : iArr[i8]) {
                d += ((double) iArr2[0]) * dArr[iArr2[1] + i5] * dArr2[iArr2[2] + i6];
            }
            dArr3[i7 + i8] = d;
            i8++;
        }
    }

    public void pow(double d, double[] dArr, int i5, double[] dArr2, int i6) {
        int i7 = 1;
        int i8 = this.order + 1;
        double[] dArr3 = new double[i8];
        if (d == 0.0d) {
            double d6 = dArr[i5];
            if (d6 == 0.0d) {
                dArr3[0] = 1.0d;
                double d7 = Double.POSITIVE_INFINITY;
                while (i7 < i8) {
                    d7 = -d7;
                    dArr3[i7] = d7;
                    i7++;
                }
            } else if (d6 < 0.0d) {
                Arrays.fill(dArr3, Double.NaN);
            }
        } else {
            dArr3[0] = FastMath.pow(d, dArr[i5]);
            double dLog = FastMath.log(d);
            while (i7 < i8) {
                dArr3[i7] = dArr3[i7 - 1] * dLog;
                i7++;
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void remainder(double[] dArr, int i5, double[] dArr2, int i6, double[] dArr3, int i7) {
        double dIEEEremainder = FastMath.IEEEremainder(dArr[i5], dArr2[i6]);
        double dRint = FastMath.rint((dArr[i5] - dIEEEremainder) / dArr2[i6]);
        dArr3[i7] = dIEEEremainder;
        for (int i8 = 1; i8 < getSize(); i8++) {
            dArr3[i7 + i8] = dArr[i5 + i8] - (dArr2[i6 + i8] * dRint);
        }
    }

    public void rootN(double[] dArr, int i5, int i6, double[] dArr2, int i7) {
        double dPow;
        double[] dArr3 = new double[this.order + 1];
        if (i6 == 2) {
            double dSqrt = FastMath.sqrt(dArr[i5]);
            dArr3[0] = dSqrt;
            dPow = 0.5d / dSqrt;
        } else if (i6 == 3) {
            double dCbrt = FastMath.cbrt(dArr[i5]);
            dArr3[0] = dCbrt;
            dPow = 1.0d / ((3.0d * dCbrt) * dCbrt);
        } else {
            double d = i6;
            double dPow2 = FastMath.pow(dArr[i5], 1.0d / d);
            dArr3[0] = dPow2;
            dPow = 1.0d / (FastMath.pow(dPow2, i6 - 1) * d);
        }
        double d6 = 1.0d / ((double) i6);
        double d7 = 1.0d / dArr[i5];
        for (int i8 = 1; i8 <= this.order; i8++) {
            dArr3[i8] = dPow;
            dPow *= (d6 - ((double) i8)) * d7;
        }
        compose(dArr, i5, dArr3, dArr2, i7);
    }

    public void sin(double[] dArr, int i5, double[] dArr2, int i6) {
        double[] dArr3 = new double[this.order + 1];
        dArr3[0] = FastMath.sin(dArr[i5]);
        if (this.order > 0) {
            dArr3[1] = FastMath.cos(dArr[i5]);
            for (int i7 = 2; i7 <= this.order; i7++) {
                dArr3[i7] = -dArr3[i7 - 2];
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void sinh(double[] dArr, int i5, double[] dArr2, int i6) {
        double[] dArr3 = new double[this.order + 1];
        dArr3[0] = FastMath.sinh(dArr[i5]);
        if (this.order > 0) {
            dArr3[1] = FastMath.cosh(dArr[i5]);
            for (int i7 = 2; i7 <= this.order; i7++) {
                dArr3[i7] = dArr3[i7 - 2];
            }
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void subtract(double[] dArr, int i5, double[] dArr2, int i6, double[] dArr3, int i7) {
        for (int i8 = 0; i8 < getSize(); i8++) {
            dArr3[i7 + i8] = dArr[i5 + i8] - dArr2[i6 + i8];
        }
    }

    public void tan(double[] dArr, int i5, double[] dArr2, int i6) {
        char c;
        char c6;
        double[] dArr3;
        int i7;
        double d;
        char c7 = 1;
        double[] dArr4 = new double[this.order + 1];
        double dTan = FastMath.tan(dArr[i5]);
        char c8 = 0;
        dArr4[0] = dTan;
        int i8 = this.order;
        if (i8 > 0) {
            int i9 = 2;
            double[] dArr5 = new double[i8 + 2];
            dArr5[1] = 1.0d;
            double d6 = dTan * dTan;
            int i10 = 1;
            while (i10 <= this.order) {
                int i11 = i10 + 1;
                dArr5[i11] = ((double) i10) * dArr5[i10];
                double d7 = 0.0d;
                int i12 = i11;
                while (i12 >= 0) {
                    d7 = (d7 * d6) + dArr5[i12];
                    if (i12 > i9) {
                        c = c8;
                        int i13 = i12 - 1;
                        c6 = c7;
                        dArr3 = dArr4;
                        double d8 = ((double) i13) * dArr5[i13];
                        int i14 = i12 - 3;
                        d = d6;
                        dArr5[i12 - 2] = (((double) i14) * dArr5[i14]) + d8;
                        i7 = 2;
                    } else {
                        c = c8;
                        c6 = c7;
                        dArr3 = dArr4;
                        i7 = i9;
                        d = d6;
                        if (i12 == i7) {
                            dArr5[c] = dArr5[c6];
                        }
                    }
                    i12 -= 2;
                    i9 = i7;
                    c8 = c;
                    c7 = c6;
                    dArr4 = dArr3;
                    d6 = d;
                }
                char c9 = c8;
                char c10 = c7;
                double[] dArr6 = dArr4;
                int i15 = i9;
                double d9 = d6;
                if ((i10 & 1) == 0) {
                    d7 *= dTan;
                }
                dArr6[i10] = d7;
                i9 = i15;
                i10 = i11;
                c8 = c9;
                c7 = c10;
                dArr4 = dArr6;
                d6 = d9;
            }
        }
        compose(dArr, i5, dArr4, dArr2, i6);
    }

    public void tanh(double[] dArr, int i5, double[] dArr2, int i6) {
        char c;
        char c6;
        double[] dArr3;
        int i7;
        double d;
        char c7 = 1;
        double[] dArr4 = new double[this.order + 1];
        double dTanh = FastMath.tanh(dArr[i5]);
        char c8 = 0;
        dArr4[0] = dTanh;
        int i8 = this.order;
        if (i8 > 0) {
            int i9 = 2;
            double[] dArr5 = new double[i8 + 2];
            dArr5[1] = 1.0d;
            double d6 = dTanh * dTanh;
            int i10 = 1;
            while (i10 <= this.order) {
                int i11 = i10 + 1;
                dArr5[i11] = ((double) (-i10)) * dArr5[i10];
                double d7 = 0.0d;
                int i12 = i11;
                while (i12 >= 0) {
                    d7 = (d7 * d6) + dArr5[i12];
                    if (i12 > i9) {
                        c = c8;
                        int i13 = i12 - 1;
                        c6 = c7;
                        dArr3 = dArr4;
                        double d8 = ((double) i13) * dArr5[i13];
                        int i14 = i12 - 3;
                        d = d6;
                        dArr5[i12 - 2] = d8 - (((double) i14) * dArr5[i14]);
                        i7 = 2;
                    } else {
                        c = c8;
                        c6 = c7;
                        dArr3 = dArr4;
                        i7 = i9;
                        d = d6;
                        if (i12 == i7) {
                            dArr5[c] = dArr5[c6];
                        }
                    }
                    i12 -= 2;
                    i9 = i7;
                    c8 = c;
                    c7 = c6;
                    dArr4 = dArr3;
                    d6 = d;
                }
                char c9 = c8;
                char c10 = c7;
                double[] dArr6 = dArr4;
                int i15 = i9;
                double d9 = d6;
                if ((i10 & 1) == 0) {
                    d7 *= dTanh;
                }
                dArr6[i10] = d7;
                i9 = i15;
                i10 = i11;
                c8 = c9;
                c7 = c10;
                dArr4 = dArr6;
                d6 = d9;
            }
        }
        compose(dArr, i5, dArr4, dArr2, i6);
    }

    public double taylor(double[] dArr, int i5, double... dArr2) {
        double d = 0.0d;
        for (int size = getSize() - 1; size >= 0; size--) {
            int[] partialDerivativeOrders = getPartialDerivativeOrders(size);
            double dPow = dArr[i5 + size];
            for (int i6 = 0; i6 < partialDerivativeOrders.length; i6++) {
                int i7 = partialDerivativeOrders[i6];
                if (i7 > 0) {
                    try {
                        dPow = (FastMath.pow(dArr2[i6], i7) / CombinatoricsUtils.factorial(partialDerivativeOrders[i6])) * dPow;
                    } catch (NotPositiveException e) {
                        throw new MathInternalError(e);
                    }
                }
            }
            d += dPow;
        }
        return d;
    }

    public void linearCombination(double d, double[] dArr, int i5, double d6, double[] dArr2, int i6, double d7, double[] dArr3, int i7, double[] dArr4, int i8) {
        for (int i9 = 0; i9 < getSize(); i9++) {
            dArr4[i8 + i9] = MathArrays.linearCombination(d, dArr[i5 + i9], d6, dArr2[i6 + i9], d7, dArr3[i7 + i9]);
        }
    }

    private static int getPartialDerivativeIndex(int i5, int i6, int[][] iArr, int... iArr2) {
        int i7 = 0;
        int i8 = i6;
        int i9 = 0;
        for (int i10 = i5 - 1; i10 >= 0; i10--) {
            int i11 = iArr2[i10];
            i9 += i11;
            if (i9 > i6) {
                throw new NumberIsTooLargeException(Integer.valueOf(i9), Integer.valueOf(i6), true);
            }
            while (true) {
                int i12 = i11 - 1;
                if (i11 > 0) {
                    i7 += iArr[i10][i8];
                    i11 = i12;
                    i8--;
                }
            }
        }
        return i7;
    }

    public void linearCombination(double d, double[] dArr, int i5, double d6, double[] dArr2, int i6, double d7, double[] dArr3, int i7, double d8, double[] dArr4, int i8, double[] dArr5, int i9) {
        for (int i10 = 0; i10 < getSize(); i10++) {
            dArr5[i9 + i10] = MathArrays.linearCombination(d, dArr[i5 + i10], d6, dArr2[i6 + i10], d7, dArr3[i7 + i10], d8, dArr4[i8 + i10]);
        }
    }

    public void pow(double[] dArr, int i5, double d, double[] dArr2, int i6) {
        int i7 = this.order;
        double[] dArr3 = new double[i7 + 1];
        double dPow = FastMath.pow(dArr[i5], d - ((double) i7));
        for (int i8 = this.order; i8 > 0; i8--) {
            dArr3[i8] = dPow;
            dPow *= dArr[i5];
        }
        dArr3[0] = dPow;
        double d6 = d;
        for (int i9 = 1; i9 <= this.order; i9++) {
            dArr3[i9] = dArr3[i9] * d6;
            d6 *= d - ((double) i9);
        }
        compose(dArr, i5, dArr3, dArr2, i6);
    }

    public void pow(double[] dArr, int i5, int i6, double[] dArr2, int i7) {
        if (i6 == 0) {
            dArr2[i7] = 1.0d;
            Arrays.fill(dArr2, i7 + 1, getSize() + i7, 0.0d);
            return;
        }
        int i8 = this.order;
        double[] dArr3 = new double[i8 + 1];
        if (i6 > 0) {
            int iMin = FastMath.min(i8, i6);
            double dPow = FastMath.pow(dArr[i5], i6 - iMin);
            while (iMin > 0) {
                dArr3[iMin] = dPow;
                dPow *= dArr[i5];
                iMin--;
            }
            dArr3[0] = dPow;
        } else {
            double d = 1.0d / dArr[i5];
            double dPow2 = FastMath.pow(d, -i6);
            for (int i9 = 0; i9 <= this.order; i9++) {
                dArr3[i9] = dPow2;
                dPow2 *= d;
            }
        }
        double d6 = i6;
        for (int i10 = 1; i10 <= this.order; i10++) {
            dArr3[i10] = dArr3[i10] * d6;
            d6 *= (double) (i6 - i10);
        }
        compose(dArr, i5, dArr3, dArr2, i7);
    }

    public void pow(double[] dArr, int i5, double[] dArr2, int i6, double[] dArr3, int i7) {
        double[] dArr4 = new double[getSize()];
        log(dArr, i5, dArr4, 0);
        double[] dArr5 = new double[getSize()];
        multiply(dArr4, 0, dArr2, i6, dArr5, 0);
        exp(dArr5, 0, dArr3, i7);
    }
}
