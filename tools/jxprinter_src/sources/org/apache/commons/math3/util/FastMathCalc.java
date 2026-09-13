package org.apache.commons.math3.util;

import java.io.PrintStream;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class FastMathCalc {
    private static final long HEX_40000000 = 1073741824;
    private static final String TABLE_END_DECL = "    };";
    private static final String TABLE_START_DECL = "    {";
    private static final double[] FACT = {1.0d, 1.0d, 2.0d, 6.0d, 24.0d, 120.0d, 720.0d, 5040.0d, 40320.0d, 362880.0d, 3628800.0d, 3.99168E7d, 4.790016E8d, 6.2270208E9d, 8.71782912E10d, 1.307674368E12d, 2.0922789888E13d, 3.55687428096E14d, 6.402373705728E15d, 1.21645100408832E17d};
    private static final double[][] LN_SPLIT_COEF = {new double[]{2.0d, 0.0d}, new double[]{0.6666666269302368d, 3.9736429850260626E-8d}, new double[]{0.3999999761581421d, 2.3841857910019882E-8d}, new double[]{0.2857142686843872d, 1.7029898543501842E-8d}, new double[]{0.2222222089767456d, 1.3245471311735498E-8d}, new double[]{0.1818181574344635d, 2.4384203044354907E-8d}, new double[]{0.1538461446762085d, 9.140260083262505E-9d}, new double[]{0.13333332538604736d, 9.220590270857665E-9d}, new double[]{0.11764700710773468d, 1.2393345855018391E-8d}, new double[]{0.10526403784751892d, 8.251545029714408E-9d}, new double[]{0.0952233225107193d, 1.2675934823758863E-8d}, new double[]{0.08713622391223907d, 1.1430250008909141E-8d}, new double[]{0.07842259109020233d, 2.404307984052299E-9d}, new double[]{0.08371849358081818d, 1.176342548272881E-8d}, new double[]{0.030589580535888672d, 1.2958646899018938E-9d}, new double[]{0.14982303977012634d, 1.225743062930824E-8d}};

    private FastMathCalc() {
    }

    private static void buildSinCosTables(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, int i5, double[] dArr5, double[] dArr6) {
        int i6;
        double[] dArr7 = new double[2];
        int i7 = 0;
        while (true) {
            if (i7 >= 7) {
                break;
            }
            double d = ((double) i7) / 8.0d;
            slowSin(d, dArr7);
            dArr[i7] = dArr7[0];
            dArr2[i7] = dArr7[1];
            slowCos(d, dArr7);
            dArr3[i7] = dArr7[0];
            dArr4[i7] = dArr7[1];
            i7++;
        }
        for (i6 = 7; i6 < i5; i6++) {
            double[] dArr8 = new double[2];
            double[] dArr9 = new double[2];
            double[] dArr10 = new double[2];
            double[] dArr11 = new double[2];
            if ((i6 & 1) == 0) {
                int i8 = i6 / 2;
                dArr8[0] = dArr[i8];
                dArr8[1] = dArr2[i8];
                dArr9[0] = dArr3[i8];
                dArr9[1] = dArr4[i8];
                splitMult(dArr8, dArr9, dArr7);
                dArr[i6] = dArr7[0] * 2.0d;
                dArr2[i6] = dArr7[1] * 2.0d;
                splitMult(dArr9, dArr9, dArr10);
                splitMult(dArr8, dArr8, dArr11);
                dArr11[0] = -dArr11[0];
                dArr11[1] = -dArr11[1];
                splitAdd(dArr10, dArr11, dArr7);
                dArr3[i6] = dArr7[0];
                dArr4[i6] = dArr7[1];
            } else {
                int i9 = i6 / 2;
                dArr8[0] = dArr[i9];
                dArr8[1] = dArr2[i9];
                dArr9[0] = dArr3[i9];
                dArr9[1] = dArr4[i9];
                int i10 = i9 + 1;
                dArr10[0] = dArr[i10];
                dArr10[1] = dArr2[i10];
                double[] dArr12 = {dArr3[i10], dArr4[i10]};
                splitMult(dArr8, dArr12, dArr11);
                splitMult(dArr9, dArr10, dArr7);
                splitAdd(dArr7, dArr11, dArr7);
                dArr[i6] = dArr7[0];
                dArr2[i6] = dArr7[1];
                splitMult(dArr9, dArr12, dArr7);
                splitMult(dArr8, dArr10, dArr11);
                dArr11[0] = -dArr11[0];
                dArr11[1] = -dArr11[1];
                splitAdd(dArr7, dArr11, dArr7);
                dArr3[i6] = dArr7[0];
                dArr4[i6] = dArr7[1];
            }
        }
        for (int i11 = 0; i11 < i5; i11++) {
            double[] dArr13 = new double[2];
            double[] dArr14 = {dArr3[i11], dArr4[i11]};
            splitReciprocal(dArr14, dArr13);
            splitMult(new double[]{dArr[i11], dArr2[i11]}, dArr13, dArr14);
            dArr5[i11] = dArr14[0];
            dArr6[i11] = dArr14[1];
        }
    }

    private static void checkLen(int i5, int i6) {
        if (i5 != i6) {
            throw new DimensionMismatchException(i6, i5);
        }
    }

    public static double expint(int i5, double[] dArr) {
        double[] dArr2 = new double[2];
        double[] dArr3 = new double[2];
        double[] dArr4 = {2.718281828459045d, 1.4456468917292502E-16d};
        split(1.0d, dArr3);
        while (i5 > 0) {
            if ((i5 & 1) != 0) {
                quadMult(dArr3, dArr4, dArr2);
                dArr3[0] = dArr2[0];
                dArr3[1] = dArr2[1];
            }
            quadMult(dArr4, dArr4, dArr2);
            dArr4[0] = dArr2[0];
            dArr4[1] = dArr2[1];
            i5 >>= 1;
        }
        if (dArr != null) {
            dArr[0] = dArr3[0];
            dArr[1] = dArr3[1];
            resplit(dArr);
        }
        return dArr3[0] + dArr3[1];
    }

    public static String format(double d) {
        if (d != d) {
            return "Double.NaN,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d >= 0.0d ? "+" : "");
        sb.append(Double.toString(d));
        sb.append("d,");
        return sb.toString();
    }

    public static void printarray(PrintStream printStream, String str, int i5, double[][] dArr) {
        printStream.println(str);
        checkLen(i5, dArr.length);
        printStream.println("    { ");
        int length = dArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            double[] dArr2 = dArr[i6];
            printStream.print("        {");
            for (double d : dArr2) {
                printStream.printf("%-25.25s", format(d));
            }
            printStream.println("}, // " + i7);
            i6++;
            i7++;
        }
        printStream.println(TABLE_END_DECL);
    }

    private static void quadMult(double[] dArr, double[] dArr2, double[] dArr3) {
        double[] dArr4 = new double[2];
        double[] dArr5 = new double[2];
        double[] dArr6 = new double[2];
        split(dArr[0], dArr4);
        split(dArr2[0], dArr5);
        splitMult(dArr4, dArr5, dArr6);
        dArr3[0] = dArr6[0];
        dArr3[1] = dArr6[1];
        split(dArr2[1], dArr5);
        splitMult(dArr4, dArr5, dArr6);
        double d = dArr3[0];
        double d6 = dArr6[0];
        double d7 = d + d6;
        double d8 = dArr3[1] - ((d7 - d) - d6);
        dArr3[1] = d8;
        dArr3[0] = d7;
        double d9 = dArr6[1];
        double d10 = d7 + d9;
        dArr3[1] = d8 - ((d10 - d7) - d9);
        dArr3[0] = d10;
        split(dArr[1], dArr4);
        split(dArr2[0], dArr5);
        splitMult(dArr4, dArr5, dArr6);
        double d11 = dArr3[0];
        double d12 = dArr6[0];
        double d13 = d11 + d12;
        double d14 = dArr3[1] - ((d13 - d11) - d12);
        dArr3[1] = d14;
        dArr3[0] = d13;
        double d15 = dArr6[1];
        double d16 = d13 + d15;
        dArr3[1] = d14 - ((d16 - d13) - d15);
        dArr3[0] = d16;
        split(dArr[1], dArr4);
        split(dArr2[1], dArr5);
        splitMult(dArr4, dArr5, dArr6);
        double d17 = dArr3[0];
        double d18 = dArr6[0];
        double d19 = d17 + d18;
        double d20 = dArr3[1] - ((d19 - d17) - d18);
        dArr3[1] = d20;
        dArr3[0] = d19;
        double d21 = dArr6[1];
        double d22 = d19 + d21;
        dArr3[1] = d20 - ((d22 - d19) - d21);
        dArr3[0] = d22;
    }

    private static void resplit(double[] dArr) {
        double d = dArr[0];
        double d6 = dArr[1];
        double d7 = d + d6;
        double d8 = -((d7 - d) - d6);
        if (d7 >= 8.0E298d || d7 <= -8.0E298d) {
            double d9 = (((9.313225746154785E-10d * d7) + d7) - d7) * 1.073741824E9d;
            dArr[0] = d9;
            dArr[1] = (d7 - d9) + d8;
        } else {
            double d10 = 1.073741824E9d * d7;
            double d11 = (d7 + d10) - d10;
            dArr[0] = d11;
            dArr[1] = (d7 - d11) + d8;
        }
    }

    public static double slowCos(double d, double[] dArr) {
        double[] dArr2 = new double[2];
        double[] dArr3 = new double[2];
        double[] dArr4 = new double[2];
        split(d, dArr2);
        double[] dArr5 = {0.0d, 0.0d};
        for (int length = FACT.length - 1; length >= 0; length--) {
            splitMult(dArr2, dArr5, dArr4);
            dArr5[0] = dArr4[0];
            dArr5[1] = dArr4[1];
            if ((length & 1) == 0) {
                split(FACT[length], dArr4);
                splitReciprocal(dArr4, dArr3);
                if ((length & 2) != 0) {
                    dArr3[0] = -dArr3[0];
                    dArr3[1] = -dArr3[1];
                }
                splitAdd(dArr5, dArr3, dArr4);
                dArr5[0] = dArr4[0];
                dArr5[1] = dArr4[1];
            }
        }
        if (dArr != null) {
            dArr[0] = dArr5[0];
            dArr[1] = dArr5[1];
        }
        return dArr5[0] + dArr5[1];
    }

    public static double[] slowLog(double d) {
        double[] dArr = new double[2];
        double[] dArr2 = new double[2];
        double[] dArr3 = new double[2];
        split(d, dArr);
        dArr[0] = dArr[0] + 1.0d;
        resplit(dArr);
        splitReciprocal(dArr, dArr3);
        dArr[0] = dArr[0] - 2.0d;
        resplit(dArr);
        double[] dArr4 = {dArr[dArr.length - 1][0], dArr[dArr.length - 1][1]};
        splitMult(dArr, dArr3, dArr4);
        dArr[0] = dArr4[0];
        dArr[1] = dArr4[1];
        splitMult(dArr, dArr, dArr2);
        double[][] dArr5 = LN_SPLIT_COEF;
        for (int length = dArr5.length - 2; length >= 0; length--) {
            splitMult(dArr4, dArr2, dArr3);
            dArr4[0] = dArr3[0];
            dArr4[1] = dArr3[1];
            splitAdd(dArr4, LN_SPLIT_COEF[length], dArr3);
            dArr4[0] = dArr3[0];
            dArr4[1] = dArr3[1];
        }
        splitMult(dArr4, dArr, dArr3);
        dArr4[0] = dArr3[0];
        dArr4[1] = dArr3[1];
        return dArr4;
    }

    public static double slowSin(double d, double[] dArr) {
        double[] dArr2 = new double[2];
        double[] dArr3 = new double[2];
        double[] dArr4 = new double[2];
        split(d, dArr2);
        double[] dArr5 = {0.0d, 0.0d};
        for (int length = FACT.length - 1; length >= 0; length--) {
            splitMult(dArr2, dArr5, dArr4);
            dArr5[0] = dArr4[0];
            dArr5[1] = dArr4[1];
            if ((length & 1) != 0) {
                split(FACT[length], dArr4);
                splitReciprocal(dArr4, dArr3);
                if ((length & 2) != 0) {
                    dArr3[0] = -dArr3[0];
                    dArr3[1] = -dArr3[1];
                }
                splitAdd(dArr5, dArr3, dArr4);
                dArr5[0] = dArr4[0];
                dArr5[1] = dArr4[1];
            }
        }
        if (dArr != null) {
            dArr[0] = dArr5[0];
            dArr[1] = dArr5[1];
        }
        return dArr5[0] + dArr5[1];
    }

    public static double slowexp(double d, double[] dArr) {
        double[] dArr2 = new double[2];
        double[] dArr3 = new double[2];
        double[] dArr4 = new double[2];
        split(d, dArr2);
        double[] dArr5 = {0.0d, 0.0d};
        for (int length = FACT.length - 1; length >= 0; length--) {
            splitMult(dArr2, dArr5, dArr4);
            dArr5[0] = dArr4[0];
            dArr5[1] = dArr4[1];
            split(FACT[length], dArr4);
            splitReciprocal(dArr4, dArr3);
            splitAdd(dArr5, dArr3, dArr4);
            dArr5[0] = dArr4[0];
            dArr5[1] = dArr4[1];
        }
        if (dArr != null) {
            dArr[0] = dArr5[0];
            dArr[1] = dArr5[1];
        }
        return dArr5[0] + dArr5[1];
    }

    private static void split(double d, double[] dArr) {
        if (d >= 8.0E298d || d <= -8.0E298d) {
            double d6 = (((9.313225746154785E-10d * d) + d) - d) * 1.073741824E9d;
            dArr[0] = d6;
            dArr[1] = d - d6;
        } else {
            double d7 = 1.073741824E9d * d;
            double d8 = (d + d7) - d7;
            dArr[0] = d8;
            dArr[1] = d - d8;
        }
    }

    private static void splitAdd(double[] dArr, double[] dArr2, double[] dArr3) {
        dArr3[0] = dArr[0] + dArr2[0];
        dArr3[1] = dArr[1] + dArr2[1];
        resplit(dArr3);
    }

    private static void splitMult(double[] dArr, double[] dArr2, double[] dArr3) {
        dArr3[0] = dArr[0] * dArr2[0];
        double d = dArr[0];
        double d6 = dArr2[1];
        double d7 = dArr[1];
        double d8 = dArr2[0] * d7;
        dArr3[1] = (d7 * d6) + d8 + (d * d6);
        resplit(dArr3);
    }

    public static void splitReciprocal(double[] dArr, double[] dArr2) {
        if (dArr[0] == 0.0d) {
            dArr[0] = dArr[1];
            dArr[1] = 0.0d;
        }
        dArr2[0] = 0.9999997615814209d / dArr[0];
        double d = dArr[0];
        double d6 = dArr[1];
        double d7 = ((2.384185791015625E-7d * d) - (0.9999997615814209d * d6)) / ((d * d6) + (d * d));
        dArr2[1] = d7;
        if (d7 != d7) {
            dArr2[1] = 0.0d;
        }
        resplit(dArr2);
        for (int i5 = 0; i5 < 2; i5++) {
            double d8 = dArr2[0];
            double d9 = dArr[0];
            double d10 = dArr[1];
            double d11 = dArr2[1];
            dArr2[1] = ((d8 + d11) * ((((1.0d - (d8 * d9)) - (d8 * d10)) - (d9 * d11)) - (d10 * d11))) + d11;
        }
    }

    public static void printarray(PrintStream printStream, String str, int i5, double[] dArr) {
        printStream.println(str + "=");
        checkLen(i5, dArr.length);
        printStream.println(TABLE_START_DECL);
        for (double d : dArr) {
            printStream.printf("        %s%n", format(d));
        }
        printStream.println(TABLE_END_DECL);
    }
}
