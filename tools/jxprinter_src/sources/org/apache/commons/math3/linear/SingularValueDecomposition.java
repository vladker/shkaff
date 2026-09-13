package org.apache.commons.math3.linear;

import androidx.collection.a;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SingularValueDecomposition {
    private static final double EPS = 2.220446049250313E-16d;
    private static final double TINY = 1.6033346880071782E-291d;
    private RealMatrix cachedS;
    private final RealMatrix cachedU;
    private RealMatrix cachedUt;
    private final RealMatrix cachedV;
    private RealMatrix cachedVt;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f6814m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f6815n;
    private final double[] singularValues;
    private final double tol;
    private final boolean transposed;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Solver implements DecompositionSolver {
        private boolean nonSingular;
        private final RealMatrix pseudoInverse;

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return this.pseudoInverse;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public boolean isNonSingular() {
            return this.nonSingular;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector realVector) {
            return this.pseudoInverse.operate(realVector);
        }

        private Solver(double[] dArr, RealMatrix realMatrix, RealMatrix realMatrix2, boolean z6, double d) {
            double[][] data = realMatrix.getData();
            for (int i5 = 0; i5 < dArr.length; i5++) {
                double d6 = dArr[i5];
                double d7 = d6 > d ? 1.0d / d6 : 0.0d;
                double[] dArr2 = data[i5];
                for (int i6 = 0; i6 < dArr2.length; i6++) {
                    dArr2[i6] = dArr2[i6] * d7;
                }
            }
            this.pseudoInverse = realMatrix2.multiply(new Array2DRowRealMatrix(data, false));
            this.nonSingular = z6;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix realMatrix) {
            return this.pseudoInverse.multiply(realMatrix);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public SingularValueDecomposition(RealMatrix realMatrix) {
        double[][] data;
        double d;
        ?? r6;
        int i5;
        double[][] dArr;
        double d6;
        double[] dArr2;
        double d7;
        boolean z6;
        double[][] dArr3;
        double d8;
        int i6;
        int i7 = 0;
        boolean z7 = true;
        if (realMatrix.getRowDimension() < realMatrix.getColumnDimension()) {
            this.transposed = true;
            data = realMatrix.transpose().getData();
            this.f6814m = realMatrix.getColumnDimension();
            this.f6815n = realMatrix.getRowDimension();
        } else {
            this.transposed = false;
            data = realMatrix.getData();
            this.f6814m = realMatrix.getRowDimension();
            this.f6815n = realMatrix.getColumnDimension();
        }
        int i8 = this.f6815n;
        this.singularValues = new double[i8];
        int[] iArr = {this.f6814m, i8};
        Class cls = Double.TYPE;
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, iArr);
        int i9 = this.f6815n;
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) cls, i9, i9);
        int i10 = this.f6815n;
        double[] dArr6 = new double[i10];
        int i11 = this.f6814m;
        double[] dArr7 = new double[i11];
        int iMin = FastMath.min(i11 - 1, i10);
        int iMax = FastMath.max(0, this.f6815n - 2);
        int i12 = 0;
        while (true) {
            d = 0.0d;
            if (i12 >= FastMath.max(iMin, iMax)) {
                break;
            }
            if (i12 < iMin) {
                this.singularValues[i12] = 0.0d;
                int i13 = i12;
                while (i13 < this.f6814m) {
                    double[] dArr8 = this.singularValues;
                    dArr8[i12] = FastMath.hypot(dArr8[i12], data[i13][i12]);
                    i13++;
                    dArr4 = dArr4;
                    z7 = z7;
                }
                z6 = z7;
                dArr3 = dArr4;
                d8 = 1.0d;
                double[] dArr9 = this.singularValues;
                double d9 = dArr9[i12];
                if (d9 != 0.0d) {
                    if (data[i12][i12] < 0.0d) {
                        dArr9[i12] = -d9;
                    }
                    for (int i14 = i12; i14 < this.f6814m; i14++) {
                        double[] dArr10 = data[i14];
                        dArr10[i12] = dArr10[i12] / this.singularValues[i12];
                    }
                    double[] dArr11 = data[i12];
                    dArr11[i12] = dArr11[i12] + 1.0d;
                }
                double[] dArr12 = this.singularValues;
                dArr12[i12] = -dArr12[i12];
            } else {
                z6 = z7;
                dArr3 = dArr4;
                d8 = 1.0d;
            }
            int i15 = i12 + 1;
            for (int i16 = i15; i16 < this.f6815n; i16++) {
                if (i12 < iMin && this.singularValues[i12] != 0.0d) {
                    double d10 = 0.0d;
                    for (int i17 = i12; i17 < this.f6814m; i17++) {
                        double[] dArr13 = data[i17];
                        d10 = (dArr13[i12] * dArr13[i16]) + d10;
                    }
                    double d11 = (-d10) / data[i12][i12];
                    for (int i18 = i12; i18 < this.f6814m; i18++) {
                        double[] dArr14 = data[i18];
                        dArr14[i16] = (dArr14[i12] * d11) + dArr14[i16];
                    }
                }
                dArr6[i16] = data[i12][i16];
            }
            if (i12 < iMin) {
                for (int i19 = i12; i19 < this.f6814m; i19++) {
                    dArr3[i19][i12] = data[i19][i12];
                }
            }
            if (i12 < iMax) {
                dArr6[i12] = 0.0d;
                int i20 = i15;
                while (i20 < this.f6815n) {
                    dArr6[i12] = FastMath.hypot(dArr6[i12], dArr6[i20]);
                    i20++;
                    iMin = iMin;
                }
                i6 = iMin;
                double d12 = dArr6[i12];
                if (d12 != 0.0d) {
                    if (dArr6[i15] < 0.0d) {
                        dArr6[i12] = -d12;
                    }
                    for (int i21 = i15; i21 < this.f6815n; i21++) {
                        dArr6[i21] = dArr6[i21] / dArr6[i12];
                    }
                    dArr6[i15] = dArr6[i15] + d8;
                }
                double d13 = -dArr6[i12];
                dArr6[i12] = d13;
                if (i15 < this.f6814m && d13 != 0.0d) {
                    for (int i22 = i15; i22 < this.f6814m; i22++) {
                        dArr7[i22] = 0.0d;
                    }
                    for (int i23 = i15; i23 < this.f6815n; i23++) {
                        for (int i24 = i15; i24 < this.f6814m; i24++) {
                            dArr7[i24] = (dArr6[i23] * data[i24][i23]) + dArr7[i24];
                        }
                    }
                    for (int i25 = i15; i25 < this.f6815n; i25++) {
                        double d14 = (-dArr6[i25]) / dArr6[i15];
                        for (int i26 = i15; i26 < this.f6814m; i26++) {
                            double[] dArr15 = data[i26];
                            dArr15[i25] = (dArr7[i26] * d14) + dArr15[i25];
                        }
                    }
                }
                for (int i27 = i15; i27 < this.f6815n; i27++) {
                    dArr5[i27][i12] = dArr6[i27];
                }
            } else {
                i6 = iMin;
            }
            dArr4 = dArr3;
            i12 = i15;
            iMin = i6;
            i7 = i7;
            z7 = z6;
        }
        int i28 = i7;
        boolean z8 = z7;
        double[][] dArr16 = dArr4;
        int i29 = iMin;
        int i30 = this.f6815n;
        if (i29 < i30) {
            this.singularValues[i29] = data[i29][i29];
        }
        if (this.f6814m < i30) {
            this.singularValues[i30 - 1] = 0.0d;
        }
        if (iMax + 1 < i30) {
            dArr6[iMax] = data[iMax][i30 - 1];
        }
        int i31 = i30 - 1;
        dArr6[i31] = 0.0d;
        for (int i32 = i29; i32 < this.f6815n; i32++) {
            for (int i33 = i28; i33 < this.f6814m; i33++) {
                dArr16[i33][i32] = 0.0d;
            }
            dArr16[i32][i32] = 1.0d;
        }
        for (int i34 = i29 - 1; i34 >= 0; i34--) {
            if (this.singularValues[i34] != 0.0d) {
                for (int i35 = i34 + 1; i35 < this.f6815n; i35++) {
                    double d15 = 0.0d;
                    for (int i36 = i34; i36 < this.f6814m; i36++) {
                        double[] dArr17 = dArr16[i36];
                        d15 += dArr17[i34] * dArr17[i35];
                    }
                    double d16 = (-d15) / dArr16[i34][i34];
                    for (int i37 = i34; i37 < this.f6814m; i37++) {
                        double[] dArr18 = dArr16[i37];
                        dArr18[i35] = (dArr18[i34] * d16) + dArr18[i35];
                    }
                }
                for (int i38 = i34; i38 < this.f6814m; i38++) {
                    double[] dArr19 = dArr16[i38];
                    dArr19[i34] = -dArr19[i34];
                }
                double[] dArr20 = dArr16[i34];
                dArr20[i34] = dArr20[i34] + 1.0d;
                for (int i39 = i28; i39 < i34 - 1; i39++) {
                    dArr16[i39][i34] = 0.0d;
                }
            } else {
                for (int i40 = i28; i40 < this.f6814m; i40++) {
                    dArr16[i40][i34] = 0.0d;
                }
                dArr16[i34][i34] = 1.0d;
            }
        }
        for (int i41 = this.f6815n - 1; i41 >= 0; i41--) {
            if (i41 < iMax && dArr6[i41] != 0.0d) {
                int i42 = i41 + 1;
                for (int i43 = i42; i43 < this.f6815n; i43++) {
                    double d17 = 0.0d;
                    for (int i44 = i42; i44 < this.f6815n; i44++) {
                        double[] dArr21 = dArr5[i44];
                        d17 = (dArr21[i41] * dArr21[i43]) + d17;
                    }
                    double d18 = (-d17) / dArr5[i42][i41];
                    for (int i45 = i42; i45 < this.f6815n; i45++) {
                        double[] dArr22 = dArr5[i45];
                        dArr22[i43] = (dArr22[i41] * d18) + dArr22[i43];
                    }
                }
            }
            for (int i46 = i28; i46 < this.f6815n; i46++) {
                dArr5[i46][i41] = 0.0d;
            }
            dArr5[i41][i41] = 1.0d;
        }
        while (i30 > 0) {
            int i47 = i30 - 2;
            int i48 = i47;
            while (i48 >= 0) {
                if (FastMath.abs(dArr6[i48]) <= ((FastMath.abs(this.singularValues[i48 + 1]) + FastMath.abs(this.singularValues[i48])) * EPS) + TINY) {
                    dArr6[i48] = d;
                    break;
                }
                i48--;
            }
            if (i48 == i47) {
                r6 = 4;
            } else {
                int i49 = i30 - 1;
                int i50 = i49;
                while (i50 >= i48 && i50 != i48) {
                    if (FastMath.abs(this.singularValues[i50]) <= (((i50 != i30 ? FastMath.abs(dArr6[i50]) : d) + (i50 != i48 + 1 ? FastMath.abs(dArr6[i50 - 1]) : d)) * EPS) + TINY) {
                        this.singularValues[i50] = d;
                        break;
                    }
                    i50--;
                }
                if (i50 == i48) {
                    r6 = 3;
                } else if (i50 == i49) {
                    r6 = z8;
                } else {
                    i48 = i50;
                    r6 = 2;
                }
            }
            int i51 = i48 + 1;
            boolean z9 = z8;
            if (r6 == z9) {
                i5 = i31;
                dArr = dArr5;
                z8 = z9;
                d6 = d;
                dArr2 = dArr6;
                double d19 = dArr2[i47];
                dArr2[i47] = d6;
                while (i47 >= i51) {
                    double dHypot = FastMath.hypot(this.singularValues[i47], d19);
                    double[] dArr23 = this.singularValues;
                    double d20 = dArr23[i47] / dHypot;
                    double d21 = d19 / dHypot;
                    dArr23[i47] = dHypot;
                    if (i47 != i51) {
                        int i52 = i47 - 1;
                        double d22 = dArr2[i52];
                        d19 = (-d21) * d22;
                        dArr2[i52] = d22 * d20;
                    }
                    int i53 = i28;
                    while (i53 < this.f6815n) {
                        double[] dArr24 = dArr[i53];
                        double d23 = dArr24[i47];
                        int i54 = i30 - 1;
                        double d24 = dArr24[i54];
                        dArr24[i54] = (d24 * d20) + ((-d21) * d23);
                        dArr24[i47] = (d21 * d24) + (d20 * d23);
                        i53++;
                        d19 = d19;
                    }
                    i47--;
                }
            } else if (r6 == 2) {
                i5 = i31;
                dArr = dArr5;
                d6 = d;
                z8 = true;
                dArr2 = dArr6;
                double d25 = dArr2[i48];
                dArr2[i48] = d6;
                while (i51 < i30) {
                    double dHypot2 = FastMath.hypot(this.singularValues[i51], d25);
                    double[] dArr25 = this.singularValues;
                    double d26 = dArr25[i51] / dHypot2;
                    double d27 = d25 / dHypot2;
                    dArr25[i51] = dHypot2;
                    double d28 = -d27;
                    double d29 = dArr2[i51];
                    double d30 = d28 * d29;
                    dArr2[i51] = d29 * d26;
                    for (int i55 = i28; i55 < this.f6814m; i55++) {
                        double[] dArr26 = dArr16[i55];
                        double d31 = dArr26[i51];
                        double d32 = dArr26[i48];
                        dArr26[i48] = (d32 * d26) + (d31 * d28);
                        dArr26[i51] = (d27 * d32) + (d26 * d31);
                    }
                    i51++;
                    d25 = d30;
                }
            } else if (r6 != 3) {
                double[] dArr27 = this.singularValues;
                double d33 = dArr27[i51];
                if (d33 <= d) {
                    dArr27[i51] = d33 < d ? -d33 : d;
                    for (int i56 = i28; i56 <= i31; i56++) {
                        double[] dArr28 = dArr5[i56];
                        dArr28[i51] = -dArr28[i51];
                    }
                }
                while (i51 < i31) {
                    double[] dArr29 = this.singularValues;
                    double d34 = dArr29[i51];
                    int i57 = i51 + 1;
                    double d35 = dArr29[i57];
                    if (d34 >= d35) {
                        break;
                    }
                    dArr29[i51] = d35;
                    dArr29[i57] = d34;
                    if (i51 < this.f6815n - 1) {
                        for (int i58 = i28; i58 < this.f6815n; i58++) {
                            double[] dArr30 = dArr5[i58];
                            double d36 = dArr30[i57];
                            dArr30[i57] = dArr30[i51];
                            dArr30[i51] = d36;
                        }
                    }
                    if (i51 < this.f6814m - 1) {
                        for (int i59 = i28; i59 < this.f6814m; i59++) {
                            double[] dArr31 = dArr16[i59];
                            double d37 = dArr31[i57];
                            dArr31[i57] = dArr31[i51];
                            dArr31[i51] = d37;
                        }
                    }
                    i51 = i57;
                }
                i30--;
                i5 = i31;
                dArr = dArr5;
                d6 = d;
                z8 = true;
                dArr2 = dArr6;
            } else {
                int i60 = i30 - 1;
                double dMax = FastMath.max(FastMath.max(FastMath.max(FastMath.max(FastMath.abs(this.singularValues[i60]), FastMath.abs(this.singularValues[i47])), FastMath.abs(dArr6[i47])), FastMath.abs(this.singularValues[i51])), FastMath.abs(dArr6[i51]));
                double[] dArr32 = this.singularValues;
                double d38 = dArr32[i60] / dMax;
                double d39 = dArr32[i47] / dMax;
                double d40 = dArr6[i47] / dMax;
                double d41 = dArr32[i51] / dMax;
                double d42 = dArr6[i51] / dMax;
                double D6 = a.D(d40, d40, (d39 - d38) * (d39 + d38), 2.0d);
                double d43 = d40 * d38;
                double d44 = d43 * d43;
                if (D6 == d && d44 == d) {
                    d7 = d;
                } else {
                    double dSqrt = FastMath.sqrt((D6 * D6) + d44);
                    d7 = d44 / (D6 + (D6 < d ? -dSqrt : dSqrt));
                }
                double dA = a.a(d41, d38, d41 + d38, d7);
                int i61 = i51;
                double d45 = d41 * d42;
                while (i61 < i60) {
                    double dHypot3 = FastMath.hypot(dA, d45);
                    double d46 = dA / dHypot3;
                    double d47 = d45 / dHypot3;
                    if (i61 != i51) {
                        dArr6[i61 - 1] = dHypot3;
                    }
                    double[] dArr33 = this.singularValues;
                    double d48 = dArr33[i61];
                    double d49 = dArr6[i61];
                    double d50 = (d47 * d49) + (d46 * d48);
                    dArr6[i61] = (d46 * d49) - (d48 * d47);
                    int i62 = i61 + 1;
                    double d51 = dArr33[i62];
                    int i63 = i31;
                    double[][] dArr34 = dArr5;
                    double d52 = d47 * d51;
                    dArr33[i62] = d51 * d46;
                    double d53 = d;
                    int i64 = i28;
                    while (i64 < this.f6815n) {
                        double[] dArr35 = dArr34[i64];
                        double d54 = dArr35[i61];
                        double d55 = dArr35[i62];
                        dArr35[i62] = (d46 * d55) + ((-d47) * d54);
                        dArr35[i61] = (d47 * d55) + (d46 * d54);
                        i64++;
                        dArr6 = dArr6;
                        i60 = i60;
                    }
                    int i65 = i60;
                    double[] dArr36 = dArr6;
                    double dHypot4 = FastMath.hypot(d50, d52);
                    double d56 = d50 / dHypot4;
                    double d57 = d52 / dHypot4;
                    double[] dArr37 = this.singularValues;
                    dArr37[i61] = dHypot4;
                    double d58 = dArr36[i61];
                    double d59 = dArr37[i62];
                    double d60 = (d57 * d59) + (d56 * d58);
                    double d61 = -d57;
                    dArr37[i62] = (d59 * d56) + (d58 * d61);
                    double d62 = dArr36[i62];
                    double d63 = d57 * d62;
                    dArr36[i62] = d62 * d56;
                    if (i61 < this.f6814m - 1) {
                        for (int i66 = i28; i66 < this.f6814m; i66++) {
                            double[] dArr38 = dArr16[i66];
                            double d64 = dArr38[i61];
                            double d65 = dArr38[i62];
                            dArr38[i62] = (d65 * d56) + (d64 * d61);
                            dArr38[i61] = (d57 * d65) + (d56 * d64);
                        }
                    }
                    i61 = i62;
                    dA = d60;
                    dArr6 = dArr36;
                    d = d53;
                    dArr5 = dArr34;
                    i31 = i63;
                    i60 = i65;
                    d45 = d63;
                }
                i5 = i31;
                dArr = dArr5;
                d6 = d;
                z8 = true;
                dArr2 = dArr6;
                dArr2[i47] = dA;
            }
            dArr6 = dArr2;
            d = d6;
            dArr5 = dArr;
            i31 = i5;
        }
        double[][] dArr39 = dArr5;
        this.tol = FastMath.max(((double) this.f6814m) * this.singularValues[i28] * EPS, FastMath.sqrt(Precision.SAFE_MIN));
        if (this.transposed) {
            this.cachedU = MatrixUtils.createRealMatrix(dArr39);
            this.cachedV = MatrixUtils.createRealMatrix(dArr16);
        } else {
            this.cachedU = MatrixUtils.createRealMatrix(dArr16);
            this.cachedV = MatrixUtils.createRealMatrix(dArr39);
        }
    }

    public double getConditionNumber() {
        double[] dArr = this.singularValues;
        return dArr[0] / dArr[this.f6815n - 1];
    }

    public RealMatrix getCovariance(double d) {
        int length = this.singularValues.length;
        int i5 = 0;
        while (i5 < length && this.singularValues[i5] >= d) {
            i5++;
        }
        if (i5 == 0) {
            throw new NumberIsTooLargeException(LocalizedFormats.TOO_LARGE_CUTOFF_SINGULAR_VALUE, Double.valueOf(d), Double.valueOf(this.singularValues[0]), true);
        }
        final double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, length);
        getVT().walkInOptimizedOrder(new DefaultRealMatrixPreservingVisitor() { // from class: org.apache.commons.math3.linear.SingularValueDecomposition.1
            @Override // org.apache.commons.math3.linear.DefaultRealMatrixPreservingVisitor, org.apache.commons.math3.linear.RealMatrixPreservingVisitor
            public void visit(int i6, int i7, double d6) {
                dArr[i6][i7] = d6 / SingularValueDecomposition.this.singularValues[i6];
            }
        }, 0, i5 - 1, 0, length - 1);
        RealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(dArr, false);
        return array2DRowRealMatrix.transpose().multiply(array2DRowRealMatrix);
    }

    public double getInverseConditionNumber() {
        double[] dArr = this.singularValues;
        return dArr[this.f6815n - 1] / dArr[0];
    }

    public double getNorm() {
        return this.singularValues[0];
    }

    public int getRank() {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            double[] dArr = this.singularValues;
            if (i5 >= dArr.length) {
                return i6;
            }
            if (dArr[i5] > this.tol) {
                i6++;
            }
            i5++;
        }
    }

    public RealMatrix getS() {
        if (this.cachedS == null) {
            this.cachedS = MatrixUtils.createRealDiagonalMatrix(this.singularValues);
        }
        return this.cachedS;
    }

    public double[] getSingularValues() {
        return (double[]) this.singularValues.clone();
    }

    public DecompositionSolver getSolver() {
        return new Solver(this.singularValues, getUT(), getV(), getRank() == this.f6814m, this.tol);
    }

    public RealMatrix getU() {
        return this.cachedU;
    }

    public RealMatrix getUT() {
        if (this.cachedUt == null) {
            this.cachedUt = getU().transpose();
        }
        return this.cachedUt;
    }

    public RealMatrix getV() {
        return this.cachedV;
    }

    public RealMatrix getVT() {
        if (this.cachedVt == null) {
            this.cachedVt = getV().transpose();
        }
        return this.cachedVt;
    }
}
