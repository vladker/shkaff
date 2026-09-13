package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class SchurTransformer {
    private static final int MAX_ITERATIONS = 100;
    private RealMatrix cachedP;
    private RealMatrix cachedPt;
    private RealMatrix cachedT;
    private final double epsilon = Precision.EPSILON;
    private final double[][] matrixP;
    private final double[][] matrixT;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ShiftInfo {
        double exShift;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        double f6811w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        double f6812x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        double f6813y;

        private ShiftInfo() {
        }
    }

    public SchurTransformer(RealMatrix realMatrix) {
        if (!realMatrix.isSquare()) {
            throw new NonSquareMatrixException(realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        }
        HessenbergTransformer hessenbergTransformer = new HessenbergTransformer(realMatrix);
        this.matrixT = hessenbergTransformer.getH().getData();
        this.matrixP = hessenbergTransformer.getP().getData();
        this.cachedT = null;
        this.cachedP = null;
        this.cachedPt = null;
        transform();
    }

    private void computeShift(int i5, int i6, int i7, ShiftInfo shiftInfo) {
        double[][] dArr = this.matrixT;
        double[] dArr2 = dArr[i6];
        double d = dArr2[i6];
        shiftInfo.f6812x = d;
        shiftInfo.f6811w = 0.0d;
        shiftInfo.f6813y = 0.0d;
        if (i5 < i6) {
            int i8 = i6 - 1;
            double[] dArr3 = dArr[i8];
            shiftInfo.f6813y = dArr3[i8];
            shiftInfo.f6811w = dArr2[i8] * dArr3[i6];
        }
        if (i7 == 10) {
            shiftInfo.exShift += d;
            for (int i9 = 0; i9 <= i6; i9++) {
                double[] dArr4 = this.matrixT[i9];
                dArr4[i9] = dArr4[i9] - shiftInfo.f6812x;
            }
            int i10 = i6 - 1;
            double dAbs = FastMath.abs(this.matrixT[i10][i6 - 2]) + FastMath.abs(this.matrixT[i6][i10]);
            double d6 = 0.75d * dAbs;
            shiftInfo.f6812x = d6;
            shiftInfo.f6813y = d6;
            shiftInfo.f6811w = (-0.4375d) * dAbs * dAbs;
        }
        if (i7 == 30) {
            double d7 = (shiftInfo.f6813y - shiftInfo.f6812x) / 2.0d;
            double d8 = (d7 * d7) + shiftInfo.f6811w;
            if (d8 > 0.0d) {
                double dSqrt = FastMath.sqrt(d8);
                double d9 = shiftInfo.f6813y;
                double d10 = shiftInfo.f6812x;
                if (d9 < d10) {
                    dSqrt = -dSqrt;
                }
                double d11 = d10 - (shiftInfo.f6811w / (((d9 - d10) / 2.0d) + dSqrt));
                for (int i11 = 0; i11 <= i6; i11++) {
                    double[] dArr5 = this.matrixT[i11];
                    dArr5[i11] = dArr5[i11] - d11;
                }
                shiftInfo.exShift += d11;
                shiftInfo.f6811w = 0.964d;
                shiftInfo.f6813y = 0.964d;
                shiftInfo.f6812x = 0.964d;
            }
        }
    }

    private int findSmallSubDiagonalElement(int i5, double d) {
        while (i5 > 0) {
            int i6 = i5 - 1;
            double dAbs = FastMath.abs(this.matrixT[i5][i5]) + FastMath.abs(this.matrixT[i6][i6]);
            if (dAbs == 0.0d) {
                dAbs = d;
            }
            if (FastMath.abs(this.matrixT[i5][i6]) < this.epsilon * dAbs) {
                break;
            }
            i5--;
        }
        return i5;
    }

    private double getNorm() {
        double dAbs = 0.0d;
        for (int i5 = 0; i5 < this.matrixT.length; i5++) {
            int iMax = FastMath.max(i5 - 1, 0);
            while (true) {
                double[][] dArr = this.matrixT;
                if (iMax < dArr.length) {
                    dAbs += FastMath.abs(dArr[i5][iMax]);
                    iMax++;
                }
            }
        }
        return dAbs;
    }

    private int initQRStep(int i5, int i6, ShiftInfo shiftInfo, double[] dArr) {
        char c = 2;
        int i7 = i6 - 2;
        while (i7 >= i5) {
            double[][] dArr2 = this.matrixT;
            double[] dArr3 = dArr2[i7];
            double d = dArr3[i7];
            double d6 = shiftInfo.f6812x - d;
            double d7 = shiftInfo.f6813y - d;
            char c6 = c;
            int i8 = i7;
            double d8 = (d6 * d7) - shiftInfo.f6811w;
            int i9 = i8 + 1;
            double[] dArr4 = dArr2[i9];
            dArr[0] = (d8 / dArr4[i8]) + dArr3[i9];
            dArr[1] = ((dArr4[i9] - d) - d6) - d7;
            dArr[c6] = dArr2[i8 + 2][i9];
            if (i8 == i5) {
                return i8;
            }
            int i10 = i8 - 1;
            if ((FastMath.abs(dArr[c6]) + FastMath.abs(dArr[1])) * FastMath.abs(dArr3[i10]) < this.epsilon * (FastMath.abs(this.matrixT[i9][i9]) + FastMath.abs(d) + FastMath.abs(this.matrixT[i10][i10])) * FastMath.abs(dArr[0])) {
                return i8;
            }
            i7 = i8 - 1;
            c = c6;
        }
        return i7;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0088  */
    /* JADX WARN: Code duplicated, block: B:22:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x008f  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:36:0x011f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0133  */
    /* JADX WARN: Code duplicated, block: B:42:0x015b  */
    /* JADX WARN: Code duplicated, block: B:44:0x0172  */
    /* JADX WARN: Code duplicated, block: B:47:0x019f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0182 A[SYNTHETIC] */
    private void performDoubleQRStep(int i5, int i6, int i7, ShiftInfo shiftInfo, double[] dArr) {
        boolean z6;
        double d;
        double dSqrt;
        int i8;
        boolean z7;
        char c;
        double d6;
        char c6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        int i9;
        double d12;
        int i10;
        int length;
        int i11;
        double[] dArr2;
        double d13;
        double[] dArr3;
        double[][] dArr4;
        double d14;
        int length2 = this.matrixT.length;
        boolean z8 = false;
        double d15 = dArr[0];
        boolean z9 = true;
        double d16 = dArr[1];
        char c7 = 2;
        double d17 = dArr[2];
        int i12 = i6;
        while (true) {
            int i13 = i7 - 1;
            if (i12 > i13) {
                break;
            }
            boolean z10 = i12 != i13 ? z9 : z8;
            if (i12 != i6) {
                double[][] dArr5 = this.matrixT;
                int i14 = i12 - 1;
                double d18 = dArr5[i12][i14];
                double d19 = dArr5[i12 + 1][i14];
                double d20 = z10 ? dArr5[i12 + 2][i14] : 0.0d;
                double dAbs = FastMath.abs(d20) + FastMath.abs(d19) + FastMath.abs(d18);
                shiftInfo.f6812x = dAbs;
                if (Precision.equals(dAbs, 0.0d, this.epsilon)) {
                    i8 = length2;
                    z7 = z9;
                    c = c7;
                    d15 = d18;
                    d17 = d20;
                    d16 = d19;
                } else {
                    double d21 = shiftInfo.f6812x;
                    double d22 = d18 / d21;
                    d17 = d20 / d21;
                    d15 = d22;
                    d16 = d19 / d21;
                    z6 = z9;
                    d = d16;
                    dSqrt = FastMath.sqrt((d17 * d17) + (d16 * d16) + (d15 * d15));
                    if (d15 < 0.0d) {
                        dSqrt = -dSqrt;
                    }
                    if (dSqrt != 0.0d) {
                        if (i12 != i6) {
                            z7 = z6;
                            d6 = d15;
                            c6 = c7;
                            d7 = d17;
                            this.matrixT[i12][i12 - 1] = (-dSqrt) * shiftInfo.f6812x;
                        } else {
                            z7 = z6;
                            d6 = d15;
                            c6 = c7;
                            d7 = d17;
                            if (i5 != i6) {
                                double[] dArr6 = this.matrixT[i12];
                                int i15 = i12 - 1;
                                dArr6[i15] = -dArr6[i15];
                            }
                        }
                        d8 = d6 + dSqrt;
                        shiftInfo.f6812x = d8 / dSqrt;
                        shiftInfo.f6813y = d / dSqrt;
                        d9 = d7 / dSqrt;
                        d10 = d / d8;
                        d11 = d7 / d8;
                        i9 = i12;
                        while (i9 < length2) {
                            dArr4 = this.matrixT;
                            double[] dArr7 = dArr4[i12];
                            double d23 = dArr7[i9];
                            double[] dArr8 = dArr4[i12 + 1];
                            d14 = (dArr8[i9] * d10) + d23;
                            if (z10) {
                                double[] dArr9 = dArr4[i12 + 2];
                                double d24 = dArr9[i9];
                                double d25 = (d11 * d24) + d14;
                                dArr9[i9] = d24 - (d25 * d9);
                                d14 = d25;
                            }
                            dArr7[i9] = dArr7[i9] - (shiftInfo.f6812x * d14);
                            dArr8[i9] = dArr8[i9] - (shiftInfo.f6813y * d14);
                            i9++;
                            d8 = d14;
                            c6 = c6;
                            d10 = d10;
                        }
                        c = c6;
                        d12 = d10;
                        for (i10 = 0; i10 <= FastMath.min(i7, i12 + 3); i10++) {
                            double d26 = shiftInfo.f6812x;
                            dArr3 = this.matrixT[i10];
                            int i16 = i12 + 1;
                            d8 = (shiftInfo.f6813y * dArr3[i16]) + (d26 * dArr3[i12]);
                            if (z10) {
                                int i17 = i12 + 2;
                                double d27 = dArr3[i17];
                                double d28 = (d9 * d27) + d8;
                                dArr3[i17] = d27 - (d28 * d11);
                                d8 = d28;
                            }
                            dArr3[i12] = dArr3[i12] - d8;
                            dArr3[i16] = dArr3[i16] - (d8 * d12);
                        }
                        length = this.matrixT.length - 1;
                        i11 = 0;
                        while (i11 <= length) {
                            double d29 = shiftInfo.f6812x;
                            dArr2 = this.matrixP[i11];
                            int i18 = length2;
                            int i19 = i12 + 1;
                            d13 = (shiftInfo.f6813y * dArr2[i19]) + (d29 * dArr2[i12]);
                            if (z10) {
                                int i20 = i12 + 2;
                                double d30 = dArr2[i20];
                                double d31 = (d9 * d30) + d13;
                                dArr2[i20] = d30 - (d31 * d11);
                                d13 = d31;
                            }
                            dArr2[i12] = dArr2[i12] - d13;
                            dArr2[i19] = dArr2[i19] - (d13 * d12);
                            i11++;
                            d8 = d13;
                            length2 = i18;
                        }
                        i8 = length2;
                        d15 = d8;
                        d17 = d11;
                        d16 = d12;
                    } else {
                        i8 = length2;
                        z7 = z6;
                        c = c7;
                        d16 = d;
                    }
                }
            } else {
                z6 = z9;
                d = d16;
                dSqrt = FastMath.sqrt((d17 * d17) + (d16 * d16) + (d15 * d15));
                if (d15 < 0.0d) {
                    dSqrt = -dSqrt;
                }
                if (dSqrt != 0.0d) {
                    if (i12 != i6) {
                        z7 = z6;
                        d6 = d15;
                        c6 = c7;
                        d7 = d17;
                        this.matrixT[i12][i12 - 1] = (-dSqrt) * shiftInfo.f6812x;
                    } else {
                        z7 = z6;
                        d6 = d15;
                        c6 = c7;
                        d7 = d17;
                        if (i5 != i6) {
                            double[] dArr10 = this.matrixT[i12];
                            int i110 = i12 - 1;
                            dArr10[i110] = -dArr10[i110];
                        }
                    }
                    d8 = d6 + dSqrt;
                    shiftInfo.f6812x = d8 / dSqrt;
                    shiftInfo.f6813y = d / dSqrt;
                    d9 = d7 / dSqrt;
                    d10 = d / d8;
                    d11 = d7 / d8;
                    i9 = i12;
                    while (i9 < length2) {
                        dArr4 = this.matrixT;
                        double[] dArr11 = dArr4[i12];
                        double d210 = dArr11[i9];
                        double[] dArr12 = dArr4[i12 + 1];
                        d14 = (dArr12[i9] * d10) + d210;
                        if (z10) {
                            double[] dArr13 = dArr4[i12 + 2];
                            double d211 = dArr13[i9];
                            double d212 = (d11 * d211) + d14;
                            dArr13[i9] = d211 - (d212 * d9);
                            d14 = d212;
                        }
                        dArr11[i9] = dArr11[i9] - (shiftInfo.f6812x * d14);
                        dArr12[i9] = dArr12[i9] - (shiftInfo.f6813y * d14);
                        i9++;
                        d8 = d14;
                        c6 = c6;
                        d10 = d10;
                    }
                    c = c6;
                    d12 = d10;
                    while (i10 <= FastMath.min(i7, i12 + 3)) {
                        double d213 = shiftInfo.f6812x;
                        dArr3 = this.matrixT[i10];
                        int i111 = i12 + 1;
                        d8 = (shiftInfo.f6813y * dArr3[i111]) + (d213 * dArr3[i12]);
                        if (z10) {
                            int i112 = i12 + 2;
                            double d214 = dArr3[i112];
                            double d215 = (d9 * d214) + d8;
                            dArr3[i112] = d214 - (d215 * d11);
                            d8 = d215;
                        }
                        dArr3[i12] = dArr3[i12] - d8;
                        dArr3[i111] = dArr3[i111] - (d8 * d12);
                    }
                    length = this.matrixT.length - 1;
                    i11 = 0;
                    while (i11 <= length) {
                        double d216 = shiftInfo.f6812x;
                        dArr2 = this.matrixP[i11];
                        int i113 = length2;
                        int i114 = i12 + 1;
                        d13 = (shiftInfo.f6813y * dArr2[i114]) + (d216 * dArr2[i12]);
                        if (z10) {
                            int i21 = i12 + 2;
                            double d32 = dArr2[i21];
                            double d33 = (d9 * d32) + d13;
                            dArr2[i21] = d32 - (d33 * d11);
                            d13 = d33;
                        }
                        dArr2[i12] = dArr2[i12] - d13;
                        dArr2[i114] = dArr2[i114] - (d13 * d12);
                        i11++;
                        d8 = d13;
                        length2 = i113;
                    }
                    i8 = length2;
                    d15 = d8;
                    d17 = d11;
                    d16 = d12;
                } else {
                    i8 = length2;
                    z7 = z6;
                    c = c7;
                    d16 = d;
                }
            }
            i12++;
            z9 = z7;
            c7 = c;
            length2 = i8;
            z8 = false;
        }
        int i22 = i6 + 2;
        for (int i23 = i22; i23 <= i7; i23++) {
            double[] dArr14 = this.matrixT[i23];
            dArr14[i23 - 2] = 0.0d;
            if (i23 > i22) {
                dArr14[i23 - 3] = 0.0d;
            }
        }
    }

    private void transform() {
        SchurTransformer schurTransformer = this;
        int length = schurTransformer.matrixT.length;
        double norm = schurTransformer.getNorm();
        ShiftInfo shiftInfo = new ShiftInfo();
        int i5 = length - 1;
        int i6 = i5;
        int i7 = 0;
        while (i6 >= 0) {
            int iFindSmallSubDiagonalElement = schurTransformer.findSmallSubDiagonalElement(i6, norm);
            if (iFindSmallSubDiagonalElement == i6) {
                double[] dArr = schurTransformer.matrixT[i6];
                dArr[i6] = dArr[i6] + shiftInfo.exShift;
                i6--;
            } else {
                int i8 = i6 - 1;
                if (iFindSmallSubDiagonalElement == i8) {
                    double[][] dArr2 = schurTransformer.matrixT;
                    double[] dArr3 = dArr2[i8];
                    double d = dArr3[i8];
                    double[] dArr4 = dArr2[i6];
                    double d6 = dArr4[i6];
                    double d7 = (d - d6) / 2.0d;
                    double d8 = (dArr4[i8] * dArr3[i6]) + (d7 * d7);
                    double d9 = shiftInfo.exShift;
                    dArr4[i6] = d6 + d9;
                    dArr3[i8] = dArr3[i8] + d9;
                    if (d8 >= 0.0d) {
                        double dSqrt = FastMath.sqrt(FastMath.abs(d8));
                        double d10 = d7 >= 0.0d ? d7 + dSqrt : d7 - dSqrt;
                        double d11 = schurTransformer.matrixT[i6][i8];
                        double dAbs = FastMath.abs(d10) + FastMath.abs(d11);
                        double d12 = d11 / dAbs;
                        double d13 = d10 / dAbs;
                        double dSqrt2 = FastMath.sqrt((d13 * d13) + (d12 * d12));
                        double d14 = d12 / dSqrt2;
                        double d15 = d13 / dSqrt2;
                        for (int i9 = i8; i9 < length; i9++) {
                            double[][] dArr5 = schurTransformer.matrixT;
                            double[] dArr6 = dArr5[i8];
                            double d16 = dArr6[i9];
                            double[] dArr7 = dArr5[i6];
                            dArr6[i9] = (dArr7[i9] * d14) + (d15 * d16);
                            dArr7[i9] = (dArr7[i9] * d15) - (d16 * d14);
                        }
                        for (int i10 = 0; i10 <= i6; i10++) {
                            double[] dArr8 = schurTransformer.matrixT[i10];
                            double d17 = dArr8[i8];
                            dArr8[i8] = (dArr8[i6] * d14) + (d15 * d17);
                            dArr8[i6] = (dArr8[i6] * d15) - (d17 * d14);
                        }
                        for (int i11 = 0; i11 <= i5; i11++) {
                            double[] dArr9 = schurTransformer.matrixP[i11];
                            double d18 = dArr9[i8];
                            dArr9[i8] = (dArr9[i6] * d14) + (d15 * d18);
                            dArr9[i6] = (dArr9[i6] * d15) - (d18 * d14);
                        }
                    }
                    i6 -= 2;
                } else {
                    schurTransformer.computeShift(iFindSmallSubDiagonalElement, i6, i7, shiftInfo);
                    int i12 = i7 + 1;
                    if (i12 > 100) {
                        throw new MaxCountExceededException(LocalizedFormats.CONVERGENCE_FAILED, 100, new Object[0]);
                    }
                    double[] dArr10 = new double[3];
                    schurTransformer.performDoubleQRStep(iFindSmallSubDiagonalElement, schurTransformer.initQRStep(iFindSmallSubDiagonalElement, i6, shiftInfo, dArr10), i6, shiftInfo, dArr10);
                    i7 = i12;
                }
                schurTransformer = this;
            }
            i7 = 0;
            schurTransformer = this;
        }
    }

    public RealMatrix getP() {
        if (this.cachedP == null) {
            this.cachedP = MatrixUtils.createRealMatrix(this.matrixP);
        }
        return this.cachedP;
    }

    public RealMatrix getPT() {
        if (this.cachedPt == null) {
            this.cachedPt = getP().transpose();
        }
        return this.cachedPt;
    }

    public RealMatrix getT() {
        if (this.cachedT == null) {
            this.cachedT = MatrixUtils.createRealMatrix(this.matrixT);
        }
        return this.cachedT;
    }
}
