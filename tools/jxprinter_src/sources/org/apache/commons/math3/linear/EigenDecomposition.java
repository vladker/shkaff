package org.apache.commons.math3.linear;

import androidx.collection.a;
import java.lang.reflect.Array;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EigenDecomposition {
    private static final double EPSILON = 1.0E-12d;
    private RealMatrix cachedD;
    private RealMatrix cachedV;
    private RealMatrix cachedVt;
    private ArrayRealVector[] eigenvectors;
    private double[] imagEigenvalues;
    private final boolean isSymmetric;
    private double[] main;
    private byte maxIter;
    private double[] realEigenvalues;
    private double[] secondary;
    private TriDiagonalTransformer transformer;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Solver implements DecompositionSolver {
        private final ArrayRealVector[] eigenvectors;
        private double[] imagEigenvalues;
        private double[] realEigenvalues;

        private double eigenvalueNorm(int i5) {
            double d = this.realEigenvalues[i5];
            double d6 = this.imagEigenvalues[i5];
            return FastMath.sqrt((d6 * d6) + (d * d));
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            if (!isNonSingular()) {
                throw new SingularMatrixException();
            }
            int length = this.realEigenvalues.length;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
            for (int i5 = 0; i5 < length; i5++) {
                double[] dArr2 = dArr[i5];
                for (int i6 = 0; i6 < length; i6++) {
                    double d = 0.0d;
                    for (int i7 = 0; i7 < length; i7++) {
                        double[] dataRef = this.eigenvectors[i7].getDataRef();
                        d += (dataRef[i5] * dataRef[i6]) / this.realEigenvalues[i7];
                    }
                    dArr2[i6] = d;
                }
            }
            return MatrixUtils.createRealMatrix(dArr);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public boolean isNonSingular() {
            double dMax = 0.0d;
            for (int i5 = 0; i5 < this.realEigenvalues.length; i5++) {
                dMax = FastMath.max(dMax, eigenvalueNorm(i5));
            }
            if (dMax == 0.0d) {
                return false;
            }
            for (int i6 = 0; i6 < this.realEigenvalues.length; i6++) {
                if (Precision.equals(eigenvalueNorm(i6) / dMax, 0.0d, 1.0E-12d)) {
                    return false;
                }
            }
            return true;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector realVector) {
            if (!isNonSingular()) {
                throw new SingularMatrixException();
            }
            int length = this.realEigenvalues.length;
            if (realVector.getDimension() != length) {
                throw new DimensionMismatchException(realVector.getDimension(), length);
            }
            double[] dArr = new double[length];
            for (int i5 = 0; i5 < length; i5++) {
                ArrayRealVector arrayRealVector = this.eigenvectors[i5];
                double[] dataRef = arrayRealVector.getDataRef();
                double dDotProduct = arrayRealVector.dotProduct(realVector) / this.realEigenvalues[i5];
                for (int i6 = 0; i6 < length; i6++) {
                    dArr[i6] = (dataRef[i6] * dDotProduct) + dArr[i6];
                }
            }
            return new ArrayRealVector(dArr, false);
        }

        private Solver(double[] dArr, double[] dArr2, ArrayRealVector[] arrayRealVectorArr) {
            this.realEigenvalues = dArr;
            this.imagEigenvalues = dArr2;
            this.eigenvectors = arrayRealVectorArr;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix realMatrix) {
            if (isNonSingular()) {
                int length = this.realEigenvalues.length;
                if (realMatrix.getRowDimension() == length) {
                    int columnDimension = realMatrix.getColumnDimension();
                    double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, columnDimension);
                    double[] dArr2 = new double[length];
                    for (int i5 = 0; i5 < columnDimension; i5++) {
                        for (int i6 = 0; i6 < length; i6++) {
                            dArr2[i6] = realMatrix.getEntry(i6, i5);
                            dArr[i6][i5] = 0.0d;
                        }
                        for (int i7 = 0; i7 < length; i7++) {
                            ArrayRealVector arrayRealVector = this.eigenvectors[i7];
                            double[] dataRef = arrayRealVector.getDataRef();
                            double entry = 0.0d;
                            for (int i8 = 0; i8 < length; i8++) {
                                entry = (arrayRealVector.getEntry(i8) * dArr2[i8]) + entry;
                            }
                            double d = entry / this.realEigenvalues[i7];
                            for (int i9 = 0; i9 < length; i9++) {
                                double[] dArr3 = dArr[i9];
                                dArr3[i5] = (dataRef[i9] * d) + dArr3[i5];
                            }
                        }
                    }
                    return new Array2DRowRealMatrix(dArr, false);
                }
                throw new DimensionMismatchException(realMatrix.getRowDimension(), length);
            }
            throw new SingularMatrixException();
        }
    }

    public EigenDecomposition(RealMatrix realMatrix) {
        this.maxIter = (byte) 30;
        boolean zIsSymmetric = MatrixUtils.isSymmetric(realMatrix, ((double) (realMatrix.getColumnDimension() * realMatrix.getRowDimension() * 10)) * Precision.EPSILON);
        this.isSymmetric = zIsSymmetric;
        if (!zIsSymmetric) {
            findEigenVectorsFromSchur(transformToSchur(realMatrix));
        } else {
            transformToTridiagonal(realMatrix);
            findEigenVectors(this.transformer.getQ().getData());
        }
    }

    private Complex cdiv(double d, double d6, double d7, double d8) {
        return new Complex(d, d6).divide(new Complex(d7, d8));
    }

    private void findEigenVectors(double[][] dArr) {
        int i5;
        double d;
        double d6;
        double d7;
        double d8;
        double dSqrt;
        double d9;
        double[][] dArr2 = (double[][]) dArr.clone();
        int length = this.main.length;
        this.realEigenvalues = new double[length];
        this.imagEigenvalues = new double[length];
        double[] dArr3 = new double[length];
        int i6 = 0;
        while (true) {
            i5 = length - 1;
            if (i6 >= i5) {
                break;
            }
            this.realEigenvalues[i6] = this.main[i6];
            dArr3[i6] = this.secondary[i6];
            i6++;
        }
        this.realEigenvalues[i5] = this.main[i5];
        double d10 = 0.0d;
        dArr3[i5] = 0.0d;
        double dAbs = 0.0d;
        for (int i7 = 0; i7 < length; i7++) {
            if (FastMath.abs(this.realEigenvalues[i7]) > dAbs) {
                dAbs = FastMath.abs(this.realEigenvalues[i7]);
            }
            if (FastMath.abs(dArr3[i7]) > dAbs) {
                dAbs = FastMath.abs(dArr3[i7]);
            }
        }
        if (dAbs != 0.0d) {
            for (int i8 = 0; i8 < length; i8++) {
                double dAbs2 = FastMath.abs(this.realEigenvalues[i8]);
                double d11 = Precision.EPSILON;
                if (dAbs2 <= d11 * dAbs) {
                    this.realEigenvalues[i8] = 0.0d;
                }
                if (FastMath.abs(dArr3[i8]) <= d11 * dAbs) {
                    dArr3[i8] = 0.0d;
                }
            }
        }
        int i9 = 0;
        while (i9 < length) {
            int i10 = 0;
            while (true) {
                int i11 = i9;
                while (i11 < i5) {
                    int i12 = i11 + 1;
                    double dAbs3 = FastMath.abs(this.realEigenvalues[i12]) + FastMath.abs(this.realEigenvalues[i11]);
                    if (FastMath.abs(dArr3[i11]) + dAbs3 == dAbs3) {
                        break;
                    } else {
                        i11 = i12;
                    }
                }
                if (i11 == i9) {
                    d = d10;
                } else {
                    if (i10 == this.maxIter) {
                        throw new MaxCountExceededException(LocalizedFormats.CONVERGENCE_FAILED, Byte.valueOf(this.maxIter), new Object[0]);
                    }
                    i10++;
                    double[] dArr4 = this.realEigenvalues;
                    double d12 = (dArr4[i9 + 1] - dArr4[i9]) / (dArr3[i9] * 2.0d);
                    double dSqrt2 = FastMath.sqrt((d12 * d12) + 1.0d);
                    if (d12 < d10) {
                        double[] dArr5 = this.realEigenvalues;
                        d6 = dArr5[i11] - dArr5[i9];
                        d7 = dArr3[i9];
                        d8 = d12 - dSqrt2;
                    } else {
                        double[] dArr6 = this.realEigenvalues;
                        d6 = dArr6[i11] - dArr6[i9];
                        d7 = dArr3[i9];
                        d8 = d12 + dSqrt2;
                    }
                    double d13 = (d7 / d8) + d6;
                    int i13 = i11 - 1;
                    double d14 = d10;
                    double d15 = 1.0d;
                    double d16 = 1.0d;
                    while (i13 >= i9) {
                        double d17 = dArr3[i13];
                        double d18 = d15 * d17;
                        double d19 = d16 * d17;
                        if (FastMath.abs(d18) >= FastMath.abs(d13)) {
                            double d20 = d13 / d18;
                            dSqrt = FastMath.sqrt((d20 * d20) + 1.0d);
                            dArr3[i13 + 1] = d18 * dSqrt;
                            d15 = 1.0d / dSqrt;
                            d9 = d20 * d15;
                        } else {
                            double d21 = d18 / d13;
                            double dSqrt3 = FastMath.sqrt((d21 * d21) + 1.0d);
                            dArr3[i13 + 1] = d13 * dSqrt3;
                            double d22 = 1.0d / dSqrt3;
                            d15 = d21 * d22;
                            dSqrt = dSqrt3;
                            d9 = d22;
                        }
                        int i14 = i13 + 1;
                        if (dArr3[i14] == d10) {
                            double[] dArr7 = this.realEigenvalues;
                            dArr7[i14] = dArr7[i14] - d14;
                            dArr3[i11] = d10;
                            dSqrt2 = dSqrt;
                            break;
                        }
                        double d23 = d10;
                        double[] dArr8 = this.realEigenvalues;
                        double d24 = dArr8[i14] - d14;
                        d16 = d9;
                        dSqrt2 = a.C(d16, 2.0d, d19, (dArr8[i13] - d24) * d15);
                        d14 = d15 * dSqrt2;
                        dArr8[i14] = d24 + d14;
                        d13 = (d16 * dSqrt2) - d19;
                        for (int i15 = 0; i15 < length; i15++) {
                            double[] dArr9 = dArr2[i15];
                            double d25 = dArr9[i14];
                            dArr9[i14] = (d16 * d25) + (dArr9[i13] * d15);
                            dArr9[i13] = (dArr9[i13] * d16) - (d25 * d15);
                        }
                        i13--;
                        d10 = d23;
                    }
                    d = d10;
                    if (dSqrt2 != d || i13 < i9) {
                        double[] dArr10 = this.realEigenvalues;
                        dArr10[i9] = dArr10[i9] - d14;
                        dArr3[i9] = d13;
                        dArr3[i11] = d;
                    }
                }
                if (i11 == i9) {
                    break;
                } else {
                    d10 = d;
                }
            }
            i9++;
            d10 = d;
        }
        double d26 = d10;
        int i16 = 0;
        while (i16 < length) {
            double d27 = this.realEigenvalues[i16];
            int i17 = i16 + 1;
            int i18 = i16;
            for (int i19 = i17; i19 < length; i19++) {
                double d28 = this.realEigenvalues[i19];
                if (d28 > d27) {
                    i18 = i19;
                    d27 = d28;
                }
            }
            if (i18 != i16) {
                double[] dArr11 = this.realEigenvalues;
                dArr11[i18] = dArr11[i16];
                dArr11[i16] = d27;
                for (int i20 = 0; i20 < length; i20++) {
                    double[] dArr12 = dArr2[i20];
                    double d29 = dArr12[i16];
                    dArr12[i16] = dArr12[i18];
                    dArr12[i18] = d29;
                }
            }
            i16 = i17;
        }
        double dAbs4 = d26;
        for (int i21 = 0; i21 < length; i21++) {
            if (FastMath.abs(this.realEigenvalues[i21]) > dAbs4) {
                dAbs4 = FastMath.abs(this.realEigenvalues[i21]);
            }
        }
        if (dAbs4 != d26) {
            for (int i22 = 0; i22 < length; i22++) {
                if (FastMath.abs(this.realEigenvalues[i22]) < Precision.EPSILON * dAbs4) {
                    this.realEigenvalues[i22] = d26;
                }
            }
        }
        this.eigenvectors = new ArrayRealVector[length];
        double[] dArr13 = new double[length];
        for (int i23 = 0; i23 < length; i23++) {
            for (int i24 = 0; i24 < length; i24++) {
                dArr13[i24] = dArr2[i24][i23];
            }
            this.eigenvectors[i23] = new ArrayRealVector(dArr13);
        }
    }

    private void findEigenVectorsFromSchur(SchurTransformer schurTransformer) {
        double d;
        int i5;
        int i6;
        double[][] dArr;
        double[][] dArr2;
        int i7;
        double[][] dArr3;
        double[][] dArr4;
        int i8;
        int i9;
        double d6;
        int i10;
        int i11;
        double d7;
        double d8;
        EigenDecomposition eigenDecomposition = this;
        double[][] data = schurTransformer.getT().getData();
        double[][] data2 = schurTransformer.getP().getData();
        int length = data.length;
        double d9 = 0.0d;
        double dAbs = 0.0d;
        for (int i12 = 0; i12 < length; i12++) {
            for (int iMax = FastMath.max(i12 - 1, 0); iMax < length; iMax++) {
                dAbs += FastMath.abs(data[i12][iMax]);
            }
        }
        double d10 = dAbs;
        if (Precision.equals(dAbs, 0.0d, 1.0E-12d)) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
        }
        int i13 = length - 1;
        int i14 = i13;
        double d11 = 0.0d;
        double d12 = 0.0d;
        double d13 = 0.0d;
        while (i14 >= 0) {
            double d14 = eigenDecomposition.realEigenvalues[i14];
            double d15 = eigenDecomposition.imagEigenvalues[i14];
            if (Precision.equals(d15, d9)) {
                data[i14][i14] = 1.0d;
                int i15 = i14 - 1;
                int i16 = i14;
                double d16 = d11;
                double d17 = d12;
                while (i15 >= 0) {
                    double d18 = data[i15][i15] - d14;
                    double d19 = d10;
                    double d20 = d9;
                    for (int i17 = i16; i17 <= i14; i17++) {
                        d20 = (data[i15][i17] * data[i17][i14]) + d20;
                    }
                    if (Precision.compareTo(eigenDecomposition.imagEigenvalues[i15], 0.0d, 1.0E-12d) < 0) {
                        d16 = d20;
                        d17 = d18;
                    } else {
                        if (!Precision.equals(eigenDecomposition.imagEigenvalues[i15], d9)) {
                            double[] dArr5 = data[i15];
                            int i18 = i15 + 1;
                            double d21 = dArr5[i18];
                            double d22 = data[i18][i15];
                            double d23 = eigenDecomposition.realEigenvalues[i15];
                            double d24 = eigenDecomposition.imagEigenvalues[i15];
                            double d25 = d20;
                            double d26 = d17;
                            double dA = com.google.android.gms.auth.api.accounttransfer.a.a(d26, d25, d21 * d16, (d24 * d24) + ((d23 - d14) * (d23 - d14)));
                            d17 = d26;
                            dArr5[i14] = dA;
                            if (FastMath.abs(d21) > FastMath.abs(d17)) {
                                data[i18][i14] = com.google.android.gms.auth.api.accounttransfer.a.a(d18, dA, -d20, d21);
                            } else {
                                data[i18][i14] = com.google.android.gms.auth.api.accounttransfer.a.a(d22, dA, -d16, d17);
                            }
                        } else if (d18 != d9) {
                            data[i15][i14] = (-d20) / d18;
                        } else {
                            data[i15][i14] = (-d20) / (Precision.EPSILON * d19);
                        }
                        double dAbs2 = FastMath.abs(data[i15][i14]);
                        if (Precision.EPSILON * dAbs2 * dAbs2 > 1.0d) {
                            for (int i19 = i15; i19 <= i14; i19++) {
                                double[] dArr6 = data[i19];
                                dArr6[i14] = dArr6[i14] / dAbs2;
                            }
                        }
                        i16 = i15;
                    }
                    i15--;
                    d13 = d20;
                    d10 = d19;
                }
                d = d10;
                i5 = i13;
                i6 = i14;
                d11 = d16;
                dArr = data;
                dArr2 = data2;
                i7 = length;
                d12 = d17;
            } else {
                d = d10;
                if (d15 < d9) {
                    int i20 = i14 - 1;
                    if (FastMath.abs(data[i14][i20]) > FastMath.abs(data[i20][i14])) {
                        double[] dArr7 = data[i20];
                        double[] dArr8 = data[i14];
                        dArr7[i20] = d15 / dArr8[i20];
                        dArr7[i14] = (-(dArr8[i14] - d14)) / dArr8[i20];
                        i5 = i13;
                        i6 = i14;
                    } else {
                        double[] dArr9 = data[i20];
                        i6 = i14;
                        i5 = i13;
                        Complex complexCdiv = eigenDecomposition.cdiv(0.0d, -dArr9[i14], dArr9[i20] - d14, d15);
                        data[i20][i20] = complexCdiv.getReal();
                        data[i20][i6] = complexCdiv.getImaginary();
                    }
                    double[] dArr10 = data[i6];
                    dArr10[i20] = d9;
                    dArr10[i6] = 1.0d;
                    int i21 = i6 - 2;
                    int i22 = i20;
                    while (i21 >= 0) {
                        double d27 = d9;
                        double d28 = d27;
                        for (int i23 = i22; i23 <= i6; i23++) {
                            double d29 = data[i21][i23];
                            double[] dArr11 = data[i23];
                            d27 = (dArr11[i20] * d29) + d27;
                            d28 = (d29 * dArr11[i6]) + d28;
                        }
                        double d30 = data[i21][i21] - d14;
                        if (Precision.compareTo(eigenDecomposition.imagEigenvalues[i21], 0.0d, 1.0E-12d) < 0) {
                            d13 = d27;
                            dArr3 = data;
                            dArr4 = data2;
                            i10 = length;
                            i9 = i21;
                            i8 = i20;
                            d12 = d30;
                        } else {
                            double d31 = d15;
                            if (Precision.equals(eigenDecomposition.imagEigenvalues[i21], d9)) {
                                eigenDecomposition = this;
                                dArr3 = data;
                                dArr4 = data2;
                                i8 = i20;
                                d7 = d11;
                                d15 = d31;
                                i9 = i21;
                                d6 = d13;
                                Complex complexCdiv2 = eigenDecomposition.cdiv(-d27, -d28, d30, d15);
                                dArr3[i9][i8] = complexCdiv2.getReal();
                                dArr3[i9][i6] = complexCdiv2.getImaginary();
                                i10 = length;
                                i11 = i6;
                                d8 = d12;
                            } else {
                                dArr3 = data;
                                dArr4 = data2;
                                i8 = i20;
                                double d32 = d11;
                                i9 = i21;
                                d6 = d13;
                                int i24 = i9 + 1;
                                double d33 = dArr3[i9][i24];
                                double d34 = dArr3[i24][i9];
                                double d35 = this.realEigenvalues[i9];
                                double d36 = this.imagEigenvalues[i9];
                                double dAbs3 = ((d36 * d36) + ((d35 - d14) * (d35 - d14))) - (d31 * d31);
                                double d37 = (d35 - d14) * 2.0d * d31;
                                i10 = length;
                                i11 = i6;
                                if (Precision.equals(dAbs3, 0.0d) && Precision.equals(d37, 0.0d)) {
                                    dAbs3 = Precision.EPSILON * d * (FastMath.abs(d12) + FastMath.abs(d34) + FastMath.abs(d33) + FastMath.abs(d31) + FastMath.abs(d30));
                                }
                                double d38 = d28;
                                double d39 = d27;
                                Complex complexCdiv3 = cdiv((d31 * d28) + ((d33 * d6) - (d12 * d27)), ((d33 * d32) - (d12 * d28)) - (d31 * d27), dAbs3, d37);
                                dArr3[i9][i8] = complexCdiv3.getReal();
                                dArr3[i9][i11] = complexCdiv3.getImaginary();
                                if (FastMath.abs(d33) > FastMath.abs(d31) + FastMath.abs(d12)) {
                                    double[] dArr12 = dArr3[i24];
                                    double[] dArr13 = dArr3[i9];
                                    d15 = d31;
                                    dArr12[i8] = a.D(d31, dArr13[i11], (-d39) - (dArr13[i8] * d30), d33);
                                    dArr12[i11] = com.google.android.gms.auth.api.accounttransfer.a.a(d15, dArr13[i8], (-d38) - (d30 * dArr13[i11]), d33);
                                    eigenDecomposition = this;
                                    d8 = d12;
                                    d7 = d32;
                                } else {
                                    d15 = d31;
                                    double[] dArr14 = dArr3[i9];
                                    d7 = d32;
                                    d8 = d12;
                                    eigenDecomposition = this;
                                    Complex complexCdiv4 = eigenDecomposition.cdiv((-d6) - (dArr14[i8] * d34), (-d7) - (d34 * dArr14[i11]), d8, d15);
                                    dArr3[i24][i8] = complexCdiv4.getReal();
                                    dArr3[i24][i11] = complexCdiv4.getImaginary();
                                }
                            }
                            double dMax = FastMath.max(FastMath.abs(dArr3[i9][i8]), FastMath.abs(dArr3[i9][i11]));
                            if (Precision.EPSILON * dMax * dMax > 1.0d) {
                                i6 = i11;
                                for (int i25 = i9; i25 <= i6; i25++) {
                                    double[] dArr15 = dArr3[i25];
                                    dArr15[i8] = dArr15[i8] / dMax;
                                    dArr15[i6] = dArr15[i6] / dMax;
                                }
                            } else {
                                i6 = i11;
                            }
                            d12 = d8;
                            d28 = d7;
                            d13 = d6;
                            i22 = i9;
                        }
                        i21 = i9 - 1;
                        d11 = d28;
                        data = dArr3;
                        data2 = dArr4;
                        i20 = i8;
                        length = i10;
                        d9 = 0.0d;
                    }
                    dArr = data;
                    dArr2 = data2;
                    i7 = length;
                } else {
                    i5 = i13;
                    i6 = i14;
                    dArr = data;
                    dArr2 = data2;
                    i7 = length;
                }
            }
            i14 = i6 - 1;
            i13 = i5;
            data = dArr;
            data2 = dArr2;
            length = i7;
            d10 = d;
            d9 = 0.0d;
        }
        int i26 = i13;
        double[][] dArr16 = data;
        double[][] dArr17 = data2;
        int i27 = length;
        while (i13 >= 0) {
            for (int i28 = 0; i28 <= i26; i28++) {
                double d40 = 0.0d;
                for (int i29 = 0; i29 <= FastMath.min(i13, i26); i29++) {
                    d40 += dArr17[i28][i29] * dArr16[i29][i13];
                }
                dArr17[i28][i13] = d40;
            }
            i13--;
        }
        eigenDecomposition.eigenvectors = new ArrayRealVector[i27];
        double[] dArr18 = new double[i27];
        for (int i30 = 0; i30 < i27; i30++) {
            for (int i31 = 0; i31 < i27; i31++) {
                dArr18[i31] = dArr17[i31][i30];
            }
            eigenDecomposition.eigenvectors[i30] = new ArrayRealVector(dArr18);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0066  */
    private SchurTransformer transformToSchur(RealMatrix realMatrix) {
        SchurTransformer schurTransformer = new SchurTransformer(realMatrix);
        double[][] data = schurTransformer.getT().getData();
        this.realEigenvalues = new double[data.length];
        this.imagEigenvalues = new double[data.length];
        int i5 = 0;
        while (true) {
            double[] dArr = this.realEigenvalues;
            if (i5 >= dArr.length) {
                return schurTransformer;
            }
            if (i5 != dArr.length - 1) {
                int i6 = i5 + 1;
                if (Precision.equals(data[i6][i5], 0.0d, 1.0E-12d)) {
                    this.realEigenvalues[i5] = data[i5][i5];
                } else {
                    double[] dArr2 = data[i6];
                    double d = dArr2[i6];
                    double[] dArr3 = data[i5];
                    double d6 = (dArr3[i5] - d) * 0.5d;
                    double dSqrt = FastMath.sqrt(FastMath.abs((dArr2[i5] * dArr3[i6]) + (d6 * d6)));
                    double[] dArr4 = this.realEigenvalues;
                    double d7 = d + d6;
                    dArr4[i5] = d7;
                    double[] dArr5 = this.imagEigenvalues;
                    dArr5[i5] = dSqrt;
                    dArr4[i6] = d7;
                    dArr5[i6] = -dSqrt;
                    i5 = i6;
                }
            } else {
                this.realEigenvalues[i5] = data[i5][i5];
            }
            i5++;
        }
    }

    private void transformToTridiagonal(RealMatrix realMatrix) {
        TriDiagonalTransformer triDiagonalTransformer = new TriDiagonalTransformer(realMatrix);
        this.transformer = triDiagonalTransformer;
        this.main = triDiagonalTransformer.getMainDiagonalRef();
        this.secondary = this.transformer.getSecondaryDiagonalRef();
    }

    public RealMatrix getD() {
        if (this.cachedD == null) {
            this.cachedD = MatrixUtils.createRealDiagonalMatrix(this.realEigenvalues);
            int i5 = 0;
            while (true) {
                double[] dArr = this.imagEigenvalues;
                if (i5 >= dArr.length) {
                    break;
                }
                if (Precision.compareTo(dArr[i5], 0.0d, 1.0E-12d) > 0) {
                    this.cachedD.setEntry(i5, i5 + 1, this.imagEigenvalues[i5]);
                } else if (Precision.compareTo(this.imagEigenvalues[i5], 0.0d, 1.0E-12d) < 0) {
                    this.cachedD.setEntry(i5, i5 - 1, this.imagEigenvalues[i5]);
                }
                i5++;
            }
        }
        return this.cachedD;
    }

    public double getDeterminant() {
        double d = 1.0d;
        for (double d6 : this.realEigenvalues) {
            d *= d6;
        }
        return d;
    }

    public RealVector getEigenvector(int i5) {
        return this.eigenvectors[i5].copy();
    }

    public double getImagEigenvalue(int i5) {
        return this.imagEigenvalues[i5];
    }

    public double[] getImagEigenvalues() {
        return (double[]) this.imagEigenvalues.clone();
    }

    public double getRealEigenvalue(int i5) {
        return this.realEigenvalues[i5];
    }

    public double[] getRealEigenvalues() {
        return (double[]) this.realEigenvalues.clone();
    }

    public DecompositionSolver getSolver() {
        if (hasComplexEigenvalues()) {
            throw new MathUnsupportedOperationException();
        }
        return new Solver(this.realEigenvalues, this.imagEigenvalues, this.eigenvectors);
    }

    public RealMatrix getSquareRoot() {
        if (!this.isSymmetric) {
            throw new MathUnsupportedOperationException();
        }
        double[] dArr = new double[this.realEigenvalues.length];
        int i5 = 0;
        while (true) {
            double[] dArr2 = this.realEigenvalues;
            if (i5 >= dArr2.length) {
                RealMatrix realMatrixCreateRealDiagonalMatrix = MatrixUtils.createRealDiagonalMatrix(dArr);
                RealMatrix v6 = getV();
                return v6.multiply(realMatrixCreateRealDiagonalMatrix).multiply(getVT());
            }
            double d = dArr2[i5];
            if (d <= 0.0d) {
                throw new MathUnsupportedOperationException();
            }
            dArr[i5] = FastMath.sqrt(d);
            i5++;
        }
    }

    public RealMatrix getV() {
        if (this.cachedV == null) {
            int length = this.eigenvectors.length;
            this.cachedV = MatrixUtils.createRealMatrix(length, length);
            for (int i5 = 0; i5 < length; i5++) {
                this.cachedV.setColumnVector(i5, this.eigenvectors[i5]);
            }
        }
        return this.cachedV;
    }

    public RealMatrix getVT() {
        if (this.cachedVt == null) {
            int length = this.eigenvectors.length;
            this.cachedVt = MatrixUtils.createRealMatrix(length, length);
            for (int i5 = 0; i5 < length; i5++) {
                this.cachedVt.setRowVector(i5, this.eigenvectors[i5]);
            }
        }
        return this.cachedVt;
    }

    public boolean hasComplexEigenvalues() {
        int i5 = 0;
        while (true) {
            double[] dArr = this.imagEigenvalues;
            if (i5 >= dArr.length) {
                return false;
            }
            if (!Precision.equals(dArr[i5], 0.0d, 1.0E-12d)) {
                return true;
            }
            i5++;
        }
    }

    @Deprecated
    public EigenDecomposition(RealMatrix realMatrix, double d) {
        this(realMatrix);
    }

    public EigenDecomposition(double[] dArr, double[] dArr2) {
        this.maxIter = (byte) 30;
        this.isSymmetric = true;
        this.main = (double[]) dArr.clone();
        this.secondary = (double[]) dArr2.clone();
        this.transformer = null;
        int length = dArr.length;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
        for (int i5 = 0; i5 < length; i5++) {
            dArr3[i5][i5] = 1.0d;
        }
        findEigenVectors(dArr3);
    }

    @Deprecated
    public EigenDecomposition(double[] dArr, double[] dArr2, double d) {
        this(dArr, dArr2);
    }
}
