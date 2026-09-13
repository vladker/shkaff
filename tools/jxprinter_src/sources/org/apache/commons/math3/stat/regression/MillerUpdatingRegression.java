package org.apache.commons.math3.stat.regression;

import androidx.collection.a;
import java.util.Arrays;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MillerUpdatingRegression implements UpdatingMultipleLinearRegression {
    private final double[] d;
    private final double epsilon;
    private boolean hasIntercept;
    private final boolean[] lindep;
    private long nobs;
    private final int nvars;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final double[] f6932r;
    private final double[] rhs;
    private final double[] rss;
    private boolean rss_set;
    private double sserr;
    private double sumsqy;
    private double sumy;
    private final double[] tol;
    private boolean tol_set;
    private final int[] vorder;
    private final double[] work_sing;
    private final double[] work_tolset;
    private final double[] x_sing;

    private MillerUpdatingRegression() {
        this(-1, false, Double.NaN);
    }

    private double[] cov(int i5) {
        double d;
        if (this.nobs <= i5) {
            return null;
        }
        int i6 = 0;
        double d6 = 0.0d;
        int i7 = 0;
        while (true) {
            d = 1.0d;
            if (i7 >= i5) {
                break;
            }
            if (!this.lindep[i7]) {
                d6 += 1.0d;
            }
            i7++;
        }
        int i8 = i5 - 1;
        double d7 = this.rss[i8] / (this.nobs - d6);
        int i9 = 2;
        double[] dArr = new double[(i5 * i8) / 2];
        inverse(dArr, i5);
        double[] dArr2 = new double[((i5 + 1) * i5) / 2];
        Arrays.fill(dArr2, Double.NaN);
        int i10 = 0;
        while (i6 < i5) {
            if (!this.lindep[i6]) {
                int i11 = i6;
                int i12 = i10;
                while (i11 < i5) {
                    if (this.lindep[i11]) {
                        i12 = ((i5 - i11) - 1) + i12;
                    } else {
                        int i13 = (i10 + i11) - i6;
                        double d8 = i6 == i11 ? d / this.d[i11] : dArr[i13 - 1] / this.d[i11];
                        int i14 = i11 + 1;
                        int i15 = i14;
                        while (i15 < i5) {
                            if (!this.lindep[i15]) {
                                d8 = ((dArr[i13] * dArr[i12]) / this.d[i15]) + d8;
                            }
                            i13++;
                            i12++;
                            i15++;
                            i9 = 2;
                        }
                        dArr2[a.c(i14, i11, i9, i6)] = d8 * d7;
                    }
                    i11++;
                    d = 1.0d;
                }
            }
            i10 += (i5 - i6) - 1;
            i6++;
            d = 1.0d;
        }
        return dArr2;
    }

    private void include(double[] dArr, double d, double d6) {
        double dSmartAdd;
        int i5;
        this.rss_set = false;
        this.sumy = smartAdd(d6, this.sumy);
        this.sumsqy = smartAdd(this.sumsqy, d6 * d6);
        int i6 = 0;
        int i7 = 0;
        double d7 = d6;
        double d8 = d;
        while (i6 < dArr.length) {
            double d9 = 0.0d;
            if (d8 == 0.0d) {
                return;
            }
            double d10 = dArr[i6];
            if (d10 == 0.0d) {
                i5 = i6;
                i7 = ((this.nvars - i6) - 1) + i7;
            } else {
                double d11 = this.d[i6];
                double d12 = d8 * d10;
                if (d11 != 0.0d) {
                    double d13 = d12 * d10;
                    dSmartAdd = smartAdd(d11, d13);
                    if (FastMath.abs(d13 / d11) > Precision.EPSILON) {
                        d8 = (d8 * d11) / dSmartAdd;
                    }
                    d9 = d8;
                } else {
                    dSmartAdd = d12 * d10;
                }
                this.d[i6] = dSmartAdd;
                int i8 = i6 + 1;
                while (i8 < this.nvars) {
                    int i9 = i8;
                    double d14 = dArr[i9];
                    int i10 = i6;
                    int i11 = i7;
                    dArr[i9] = smartAdd(d14, (-d10) * this.f6932r[i11]);
                    if (d11 != 0.0d) {
                        double[] dArr2 = this.f6932r;
                        dArr2[i11] = smartAdd(dArr2[i11] * d11, d14 * d12) / dSmartAdd;
                    } else {
                        this.f6932r[i11] = d14 / d10;
                    }
                    i7 = i11 + 1;
                    i8 = i9 + 1;
                    dArr = dArr;
                    i6 = i10;
                }
                i5 = i6;
                int i12 = i7;
                double dSmartAdd2 = smartAdd(d7, (-d10) * this.rhs[i5]);
                if (d11 != 0.0d) {
                    double[] dArr3 = this.rhs;
                    dArr3[i5] = smartAdd(d11 * dArr3[i5], d7 * d12) / dSmartAdd;
                } else {
                    this.rhs[i5] = d7 / d10;
                }
                i7 = i12;
                d7 = dSmartAdd2;
                d8 = d9;
            }
            i6 = i5 + 1;
        }
        this.sserr = smartAdd(this.sserr, d8 * d7 * d7);
    }

    private void inverse(double[] dArr, int i5) {
        int i6 = i5 - 1;
        int i7 = ((i5 * i6) / 2) - 1;
        Arrays.fill(dArr, Double.NaN);
        while (i6 > 0) {
            if (this.lindep[i6]) {
                i7 -= i5 - i6;
            } else {
                int i8 = this.nvars;
                int i9 = (((i8 + i8) - i6) * (i6 - 1)) / 2;
                for (int i10 = i5; i10 > i6; i10--) {
                    double d = 0.0d;
                    int i11 = i7;
                    int i12 = i9;
                    for (int i13 = i6; i13 < i10 - 1; i13++) {
                        i11 += (i5 - i13) - 1;
                        if (!this.lindep[i13]) {
                            d = ((-this.f6932r[i12]) * dArr[i11]) + d;
                        }
                        i12++;
                    }
                    dArr[i7] = d - this.f6932r[i12];
                    i7--;
                }
            }
            i6--;
        }
    }

    private double[] regcf(int i5) {
        if (i5 < 1) {
            throw new ModelSpecificationException(LocalizedFormats.NO_REGRESSORS, new Object[0]);
        }
        if (i5 > this.nvars) {
            throw new ModelSpecificationException(LocalizedFormats.TOO_MANY_REGRESSORS, Integer.valueOf(i5), Integer.valueOf(this.nvars));
        }
        if (!this.tol_set) {
            tolset();
        }
        double[] dArr = new double[i5];
        boolean z6 = false;
        for (int i6 = i5 - 1; i6 > -1; i6--) {
            if (FastMath.sqrt(this.d[i6]) < this.tol[i6]) {
                dArr[i6] = 0.0d;
                this.d[i6] = 0.0d;
                z6 = true;
            } else {
                dArr[i6] = this.rhs[i6];
                int i7 = this.nvars;
                int i8 = ((((i7 + i7) - i6) - 1) * i6) / 2;
                for (int i9 = i6 + 1; i9 < i5; i9++) {
                    dArr[i6] = smartAdd(dArr[i6], (-this.f6932r[i8]) * dArr[i9]);
                    i8++;
                }
            }
        }
        if (z6) {
            for (int i10 = 0; i10 < i5; i10++) {
                if (this.lindep[i10]) {
                    dArr[i10] = Double.NaN;
                }
            }
        }
        return dArr;
    }

    private int reorderRegressors(int[] iArr, int i5) {
        if (iArr.length < 1 || iArr.length > (this.nvars + 1) - i5) {
            return -1;
        }
        int i6 = i5;
        int i7 = i6;
        while (i6 < this.nvars) {
            int i8 = this.vorder[i6];
            for (int i9 : iArr) {
                if (i8 == i9 && i6 > i7) {
                    vmove(i6, i7);
                    i7++;
                    if (i7 < iArr.length + i5) {
                        break;
                    }
                    return 0;
                }
            }
            i6++;
        }
        return 0;
    }

    private void singcheck() {
        for (int i5 = 0; i5 < this.nvars; i5++) {
            this.work_sing[i5] = FastMath.sqrt(this.d[i5]);
        }
        for (int i6 = 0; i6 < this.nvars; i6++) {
            double d = this.tol[i6];
            int i7 = i6 - 1;
            int i8 = i7;
            for (int i9 = 0; i9 < i7; i9++) {
                if (FastMath.abs(this.f6932r[i8]) * this.work_sing[i9] < d) {
                    this.f6932r[i8] = 0.0d;
                }
                i8 += (this.nvars - i9) - 2;
            }
            boolean[] zArr = this.lindep;
            zArr[i6] = false;
            if (this.work_sing[i6] < d) {
                zArr[i6] = true;
                if (i6 < this.nvars - 1) {
                    Arrays.fill(this.x_sing, 0.0d);
                    int i10 = this.nvars;
                    int i11 = ((((i10 + i10) - i6) - 1) * i6) / 2;
                    int i12 = i6 + 1;
                    while (i12 < this.nvars) {
                        double[] dArr = this.x_sing;
                        double[] dArr2 = this.f6932r;
                        dArr[i12] = dArr2[i11];
                        dArr2[i11] = 0.0d;
                        i12++;
                        i11++;
                    }
                    double[] dArr3 = this.rhs;
                    double d6 = dArr3[i6];
                    double[] dArr4 = this.d;
                    double d7 = dArr4[i6];
                    dArr4[i6] = 0.0d;
                    dArr3[i6] = 0.0d;
                    include(this.x_sing, d7, d6);
                } else {
                    double d8 = this.sserr;
                    double d9 = this.d[i6];
                    double d10 = this.rhs[i6];
                    this.sserr = a.C(d9, d10, d10, d8);
                }
            }
        }
    }

    private double smartAdd(double d, double d6) {
        double dAbs = FastMath.abs(d);
        double dAbs2 = FastMath.abs(d6);
        if (dAbs > dAbs2) {
            return dAbs2 > dAbs * Precision.EPSILON ? d + d6 : d;
        }
        return dAbs > dAbs2 * Precision.EPSILON ? d + d6 : d6;
    }

    private void ss() {
        double d = this.sserr;
        double[] dArr = this.rss;
        int i5 = this.nvars;
        dArr[i5 - 1] = d;
        double dC = d;
        for (int i6 = i5 - 1; i6 > 0; i6--) {
            double d6 = this.d[i6];
            double d7 = this.rhs[i6];
            dC = a.C(d6, d7, d7, dC);
            this.rss[i6 - 1] = dC;
        }
        this.rss_set = true;
    }

    private void tolset() {
        double d = this.epsilon;
        for (int i5 = 0; i5 < this.nvars; i5++) {
            this.work_tolset[i5] = FastMath.sqrt(this.d[i5]);
        }
        this.tol[0] = this.work_tolset[0] * d;
        for (int i6 = 1; i6 < this.nvars; i6++) {
            int i7 = i6 - 1;
            double dAbs = this.work_tolset[i6];
            for (int i8 = 0; i8 < i6; i8++) {
                dAbs += FastMath.abs(this.f6932r[i7]) * this.work_tolset[i8];
                i7 += (this.nvars - i8) - 2;
            }
            this.tol[i6] = dAbs * d;
        }
        this.tol_set = true;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00de  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f8 A[LOOP:3: B:45:0x00f4->B:47:0x00f8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:50:0x012a  */
    /* JADX WARN: Code duplicated, block: B:52:0x012e A[LOOP:1: B:51:0x012c->B:52:0x012e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x0143 A[SYNTHETIC] */
    private void vmove(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        double d;
        double d6;
        int i10;
        int i11;
        int i12;
        int i13 = i5;
        if (i13 == i6) {
            return;
        }
        if (!this.rss_set) {
            ss();
        }
        int i14 = 1;
        if (i13 < i6) {
            i8 = i6 - i13;
            i7 = 1;
        } else {
            int i15 = i13 - i6;
            i7 = -1;
            i13--;
            i8 = i15;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < i8) {
            int i18 = this.nvars;
            int i19 = ((((i18 + i18) - i13) - i14) * i13) / 2;
            int i20 = ((i18 + i19) - i13) - i14;
            int i21 = i13 + 1;
            double[] dArr = this.d;
            double d7 = dArr[i13];
            double d8 = dArr[i21];
            int i22 = i14;
            int i23 = i8;
            double d9 = this.epsilon;
            if (d7 > d9 || d8 > d9) {
                double d10 = this.f6932r[i19];
                if (FastMath.sqrt(d7) * FastMath.abs(d10) < this.tol[i21]) {
                    d10 = 0.0d;
                }
                if (d7 >= this.epsilon) {
                    double dAbs = FastMath.abs(d10);
                    i9 = i16;
                    double d11 = this.epsilon;
                    if (dAbs >= d11) {
                        if (d8 < d11) {
                            this.d[i13] = d7 * d10 * d10;
                            this.f6932r[i19] = 1.0d / d10;
                            for (int i24 = i19 + 1; i24 < ((this.nvars + i19) - i13) - i22; i24++) {
                                double[] dArr2 = this.f6932r;
                                dArr2[i24] = dArr2[i24] / d10;
                            }
                            double[] dArr3 = this.rhs;
                            dArr3[i13] = dArr3[i13] / d10;
                        } else if (i17 == 0) {
                            double d12 = d7 * d10;
                            double d13 = (d12 * d10) + d8;
                            d = d8 / d13;
                            d6 = d12 / d13;
                            double[] dArr4 = this.d;
                            dArr4[i13] = d13;
                            dArr4[i21] = d7 * d;
                            this.f6932r[i19] = d6;
                            for (i10 = i13 + 2; i10 < this.nvars; i10++) {
                                i19++;
                                double[] dArr5 = this.f6932r;
                                double d14 = dArr5[i19];
                                dArr5[i19] = (d6 * d14) + (dArr5[i20] * d);
                                dArr5[i20] = d14 - (dArr5[i20] * d10);
                                i20++;
                            }
                            double[] dArr6 = this.rhs;
                            double d15 = dArr6[i13];
                            dArr6[i13] = (d6 * d15) + (d * dArr6[i21]);
                            dArr6[i21] = d15 - (d10 * dArr6[i21]);
                        }
                        if (i13 > 0) {
                            i11 = i13;
                            for (i12 = 0; i12 < i13; i12++) {
                                double[] dArr7 = this.f6932r;
                                double d16 = dArr7[i11];
                                int i25 = i11 - 1;
                                dArr7[i11] = dArr7[i25];
                                dArr7[i25] = d16;
                                i11 += (this.nvars - i12) - 2;
                            }
                        }
                        int[] iArr = this.vorder;
                        int i26 = iArr[i13];
                        iArr[i13] = iArr[i21];
                        iArr[i21] = i26;
                        double[] dArr8 = this.tol;
                        double d17 = dArr8[i13];
                        dArr8[i13] = dArr8[i21];
                        dArr8[i21] = d17;
                        double[] dArr9 = this.rss;
                        double d18 = dArr9[i21];
                        double d19 = this.d[i21];
                        double d20 = this.rhs[i21];
                        dArr9[i13] = a.C(d19, d20, d20, d18);
                        i13 += i7;
                        i16 = i9 + 1;
                        i8 = i23;
                        i14 = i22;
                    }
                    i17 = i22;
                    if (i17 == 0) {
                        double d110 = d7 * d10;
                        double d111 = (d110 * d10) + d8;
                        d = d8 / d111;
                        d6 = d110 / d111;
                        double[] dArr10 = this.d;
                        dArr10[i13] = d111;
                        dArr10[i21] = d7 * d;
                        this.f6932r[i19] = d6;
                        while (i10 < this.nvars) {
                            i19++;
                            double[] dArr11 = this.f6932r;
                            double d112 = dArr11[i19];
                            dArr11[i19] = (d6 * d112) + (dArr11[i20] * d);
                            dArr11[i20] = d112 - (dArr11[i20] * d10);
                            i20++;
                        }
                        double[] dArr12 = this.rhs;
                        double d113 = dArr12[i13];
                        dArr12[i13] = (d6 * d113) + (d * dArr12[i21]);
                        dArr12[i21] = d113 - (d10 * dArr12[i21]);
                    }
                    if (i13 > 0) {
                        i11 = i13;
                        while (i12 < i13) {
                            double[] dArr13 = this.f6932r;
                            double d114 = dArr13[i11];
                            int i27 = i11 - 1;
                            dArr13[i11] = dArr13[i27];
                            dArr13[i27] = d114;
                            i11 += (this.nvars - i12) - 2;
                        }
                    }
                    int[] iArr2 = this.vorder;
                    int i28 = iArr2[i13];
                    iArr2[i13] = iArr2[i21];
                    iArr2[i21] = i28;
                    double[] dArr14 = this.tol;
                    double d115 = dArr14[i13];
                    dArr14[i13] = dArr14[i21];
                    dArr14[i21] = d115;
                    double[] dArr15 = this.rss;
                    double d116 = dArr15[i21];
                    double d117 = this.d[i21];
                    double d21 = this.rhs[i21];
                    dArr15[i13] = a.C(d117, d21, d21, d116);
                    i13 += i7;
                    i16 = i9 + 1;
                    i8 = i23;
                    i14 = i22;
                } else {
                    i9 = i16;
                }
                double[] dArr16 = this.d;
                dArr16[i13] = d8;
                dArr16[i21] = d7;
                this.f6932r[i19] = 0.0d;
                for (int i29 = i13 + 2; i29 < this.nvars; i29++) {
                    i19++;
                    double[] dArr17 = this.f6932r;
                    double d22 = dArr17[i19];
                    dArr17[i19] = dArr17[i20];
                    dArr17[i20] = d22;
                    i20++;
                }
                double[] dArr18 = this.rhs;
                d10 = dArr18[i13];
                dArr18[i13] = dArr18[i21];
                dArr18[i21] = d10;
                i17 = i22;
                if (i17 == 0) {
                    double d118 = d7 * d10;
                    double d119 = (d118 * d10) + d8;
                    d = d8 / d119;
                    d6 = d118 / d119;
                    double[] dArr19 = this.d;
                    dArr19[i13] = d119;
                    dArr19[i21] = d7 * d;
                    this.f6932r[i19] = d6;
                    while (i10 < this.nvars) {
                        i19++;
                        double[] dArr110 = this.f6932r;
                        double d1110 = dArr110[i19];
                        dArr110[i19] = (d6 * d1110) + (dArr110[i20] * d);
                        dArr110[i20] = d1110 - (dArr110[i20] * d10);
                        i20++;
                    }
                    double[] dArr111 = this.rhs;
                    double d1111 = dArr111[i13];
                    dArr111[i13] = (d6 * d1111) + (d * dArr111[i21]);
                    dArr111[i21] = d1111 - (d10 * dArr111[i21]);
                }
                if (i13 > 0) {
                    i11 = i13;
                    while (i12 < i13) {
                        double[] dArr112 = this.f6932r;
                        double d1112 = dArr112[i11];
                        int i210 = i11 - 1;
                        dArr112[i11] = dArr112[i210];
                        dArr112[i210] = d1112;
                        i11 += (this.nvars - i12) - 2;
                    }
                }
                int[] iArr3 = this.vorder;
                int i211 = iArr3[i13];
                iArr3[i13] = iArr3[i21];
                iArr3[i21] = i211;
                double[] dArr113 = this.tol;
                double d1113 = dArr113[i13];
                dArr113[i13] = dArr113[i21];
                dArr113[i21] = d1113;
                double[] dArr114 = this.rss;
                double d1114 = dArr114[i21];
                double d1115 = this.d[i21];
                double d23 = this.rhs[i21];
                dArr114[i13] = a.C(d1115, d23, d23, d1114);
                i13 += i7;
                i16 = i9 + 1;
                i8 = i23;
                i14 = i22;
            } else {
                i9 = i16;
            }
            if (i13 > 0) {
                i11 = i13;
                while (i12 < i13) {
                    double[] dArr115 = this.f6932r;
                    double d1116 = dArr115[i11];
                    int i212 = i11 - 1;
                    dArr115[i11] = dArr115[i212];
                    dArr115[i212] = d1116;
                    i11 += (this.nvars - i12) - 2;
                }
            }
            int[] iArr4 = this.vorder;
            int i213 = iArr4[i13];
            iArr4[i13] = iArr4[i21];
            iArr4[i21] = i213;
            double[] dArr116 = this.tol;
            double d1117 = dArr116[i13];
            dArr116[i13] = dArr116[i21];
            dArr116[i21] = d1117;
            double[] dArr117 = this.rss;
            double d1118 = dArr117[i21];
            double d1119 = this.d[i21];
            double d24 = this.rhs[i21];
            dArr117[i13] = a.C(d1119, d24, d24, d1118);
            i13 += i7;
            i16 = i9 + 1;
            i8 = i23;
            i14 = i22;
        }
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public void addObservation(double[] dArr, double d) {
        MillerUpdatingRegression millerUpdatingRegression;
        boolean z6 = this.hasIntercept;
        if ((!z6 && dArr.length != this.nvars) || (z6 && dArr.length + 1 != this.nvars)) {
            throw new ModelSpecificationException(LocalizedFormats.INVALID_REGRESSION_OBSERVATION, Integer.valueOf(dArr.length), Integer.valueOf(this.nvars));
        }
        if (z6) {
            double[] dArr2 = new double[dArr.length + 1];
            System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
            dArr2[0] = 1.0d;
            include(dArr2, 1.0d, d);
            millerUpdatingRegression = this;
        } else {
            millerUpdatingRegression = this;
            millerUpdatingRegression.include(MathArrays.copyOf(dArr, dArr.length), 1.0d, d);
        }
        millerUpdatingRegression.nobs++;
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public void addObservations(double[][] dArr, double[] dArr2) {
        if (dArr == null || dArr2 == null || dArr.length != dArr2.length) {
            throw new ModelSpecificationException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, Integer.valueOf(dArr == null ? 0 : dArr.length), Integer.valueOf(dArr2 != null ? dArr2.length : 0));
        }
        if (dArr.length == 0) {
            throw new ModelSpecificationException(LocalizedFormats.NO_DATA, new Object[0]);
        }
        if (dArr[0].length + 1 > dArr.length) {
            throw new ModelSpecificationException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, Integer.valueOf(dArr.length), Integer.valueOf(dArr[0].length));
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            addObservation(dArr[i5], dArr2[i5]);
        }
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public void clear() {
        Arrays.fill(this.d, 0.0d);
        Arrays.fill(this.rhs, 0.0d);
        Arrays.fill(this.f6932r, 0.0d);
        Arrays.fill(this.tol, 0.0d);
        Arrays.fill(this.rss, 0.0d);
        Arrays.fill(this.work_tolset, 0.0d);
        Arrays.fill(this.work_sing, 0.0d);
        Arrays.fill(this.x_sing, 0.0d);
        Arrays.fill(this.lindep, false);
        for (int i5 = 0; i5 < this.nvars; i5++) {
            this.vorder[i5] = i5;
        }
        this.nobs = 0L;
        this.sserr = 0.0d;
        this.sumy = 0.0d;
        this.sumsqy = 0.0d;
        this.rss_set = false;
        this.tol_set = false;
    }

    public double getDiagonalOfHatMatrix(double[] dArr) {
        double[] dArr2 = dArr;
        int i5 = this.nvars;
        double[] dArr3 = new double[i5];
        if (dArr2.length > i5) {
            return Double.NaN;
        }
        if (this.hasIntercept) {
            double[] dArr4 = new double[dArr2.length + 1];
            dArr4[0] = 1.0d;
            System.arraycopy(dArr2, 0, dArr4, 1, dArr2.length);
            dArr2 = dArr4;
        }
        double dSmartAdd = 0.0d;
        for (int i6 = 0; i6 < dArr2.length; i6++) {
            if (FastMath.sqrt(this.d[i6]) < this.tol[i6]) {
                dArr3[i6] = 0.0d;
            } else {
                int i7 = i6 - 1;
                double dSmartAdd2 = dArr2[i6];
                for (int i8 = 0; i8 < i6; i8++) {
                    dSmartAdd2 = smartAdd(dSmartAdd2, (-dArr3[i8]) * this.f6932r[i7]);
                    i7 += (this.nvars - i8) - 2;
                }
                dArr3[i6] = dSmartAdd2;
                dSmartAdd = smartAdd(dSmartAdd, (dSmartAdd2 * dSmartAdd2) / this.d[i6]);
            }
        }
        return dSmartAdd;
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public long getN() {
        return this.nobs;
    }

    public int[] getOrderOfRegressors() {
        return MathArrays.copyOf(this.vorder);
    }

    public double[] getPartialCorrelations(int i5) {
        int i6;
        int i7 = i5;
        int i8 = this.nvars;
        double[] dArr = new double[((i8 - i7) * ((i8 - i7) + 1)) / 2];
        int i9 = -i7;
        int i10 = i7 + 1;
        int i11 = -i10;
        double[] dArr2 = new double[i8 - i7];
        double[] dArr3 = new double[(i8 - i7) - 1];
        int i12 = (((i8 - i7) - 1) * (i8 - i7)) / 2;
        if (i7 < -1 || i7 >= i8) {
            return null;
        }
        int i13 = (i8 - 1) - i7;
        int length = this.f6932r.length - (((i13 + 1) * i13) / 2);
        double d = this.d[i7];
        double d6 = 0.0d;
        if (d > 0.0d) {
            dArr2[i7 + i9] = 1.0d / FastMath.sqrt(d);
        }
        while (i10 < this.nvars) {
            int i14 = ((length + i10) - 1) - i7;
            double dC = this.d[i10];
            for (int i15 = i7; i15 < i10; i15++) {
                double d7 = this.d[i15];
                double d8 = this.f6932r[i14];
                dC = a.C(d7, d8, d8, dC);
                i14 += (this.nvars - i15) - 2;
            }
            if (dC > 0.0d) {
                dArr2[i10 + i9] = 1.0d / FastMath.sqrt(dC);
            } else {
                dArr2[i10 + i9] = 0.0d;
            }
            i10++;
        }
        double dSqrt = this.sserr;
        for (int i16 = i7; i16 < this.nvars; i16++) {
            double d9 = this.d[i16];
            double d10 = this.rhs[i16];
            dSqrt = a.C(d9, d10, d10, dSqrt);
        }
        if (dSqrt > 0.0d) {
            dSqrt = 1.0d / FastMath.sqrt(dSqrt);
        }
        int i17 = i7;
        while (i17 < this.nvars) {
            Arrays.fill(dArr3, d6);
            int i18 = ((length + i17) - i7) - 1;
            double d11 = d6;
            for (int i19 = i7; i19 < i17; i19++) {
                int i20 = i18 + 1;
                int i21 = i17 + 1;
                while (true) {
                    i6 = this.nvars;
                    if (i21 < i6) {
                        int i22 = i21 + i11;
                        double d12 = dArr3[i22];
                        double d13 = this.d[i19];
                        double[] dArr4 = this.f6932r;
                        dArr3[i22] = (d13 * dArr4[i18] * dArr4[i20]) + d12;
                        i20++;
                        i21++;
                    }
                }
                d11 += this.d[i19] * this.f6932r[i18] * this.rhs[i19];
                i18 += (i6 - i19) - 2;
            }
            int i23 = i18 + 1;
            int i24 = i17 + 1;
            int i25 = i24;
            while (i25 < this.nvars) {
                int i26 = i25 + i11;
                double d14 = (this.d[i17] * this.f6932r[i23]) + dArr3[i26];
                dArr3[i26] = d14;
                i23++;
                dArr[((((i25 - i5) * ((i25 - 1) - i5)) / 2) + i17) - i5] = d14 * dArr2[i17 + i9] * dArr2[i25 + i9];
                i25++;
                i24 = i24;
            }
            int i27 = i24;
            double d15 = (this.d[i17] * this.rhs[i17]) + d11;
            int i28 = i17 + i9;
            dArr[i28 + i12] = d15 * dArr2[i28] * dSqrt;
            i7 = i5;
            i17 = i27;
            d6 = 0.0d;
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public boolean hasIntercept() {
        return this.hasIntercept;
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public RegressionResults regress() {
        return regress(this.nvars);
    }

    public MillerUpdatingRegression(int i5, boolean z6, double d) {
        this.nobs = 0L;
        this.sserr = 0.0d;
        this.rss_set = false;
        this.tol_set = false;
        this.sumy = 0.0d;
        this.sumsqy = 0.0d;
        if (i5 < 1) {
            throw new ModelSpecificationException(LocalizedFormats.NO_REGRESSORS, new Object[0]);
        }
        if (z6) {
            this.nvars = i5 + 1;
        } else {
            this.nvars = i5;
        }
        this.hasIntercept = z6;
        this.nobs = 0L;
        int i6 = this.nvars;
        this.d = new double[i6];
        this.rhs = new double[i6];
        this.f6932r = new double[((i6 - 1) * i6) / 2];
        this.tol = new double[i6];
        this.rss = new double[i6];
        this.vorder = new int[i6];
        this.x_sing = new double[i6];
        this.work_sing = new double[i6];
        this.work_tolset = new double[i6];
        this.lindep = new boolean[i6];
        for (int i7 = 0; i7 < this.nvars; i7++) {
            this.vorder[i7] = i7;
        }
        if (d > 0.0d) {
            this.epsilon = d;
        } else {
            this.epsilon = -d;
        }
    }

    public RegressionResults regress(int i5) {
        if (this.nobs <= i5) {
            throw new ModelSpecificationException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, Long.valueOf(this.nobs), Integer.valueOf(i5));
        }
        if (i5 > this.nvars) {
            throw new ModelSpecificationException(LocalizedFormats.TOO_MANY_REGRESSORS, Integer.valueOf(i5), Integer.valueOf(this.nvars));
        }
        tolset();
        singcheck();
        double[] dArrRegcf = regcf(i5);
        ss();
        double[] dArrCov = cov(i5);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            boolean[] zArr = this.lindep;
            if (i6 >= zArr.length) {
                break;
            }
            if (!zArr[i6]) {
                i7++;
            }
            i6++;
        }
        for (int i8 = 0; i8 < i5; i8++) {
            if (this.vorder[i8] != i8) {
                double[] dArr = new double[dArrRegcf.length];
                double[] dArr2 = new double[dArrCov.length];
                int[] iArr = new int[dArrRegcf.length];
                for (int i9 = 0; i9 < this.nvars; i9++) {
                    for (int i10 = 0; i10 < i5; i10++) {
                        if (this.vorder[i10] == i9) {
                            dArr[i9] = dArrRegcf[i10];
                            iArr[i9] = i10;
                        }
                    }
                }
                int i11 = 0;
                for (int i12 = 0; i12 < dArrRegcf.length; i12++) {
                    int i13 = iArr[i12];
                    int i14 = 0;
                    while (i14 <= i12) {
                        int i15 = iArr[i14];
                        dArr2[i11] = dArrCov[i13 > i15 ? (((i13 + 1) * i13) / 2) + i15 : (((i15 + 1) * i15) / 2) + i13];
                        i14++;
                        i11++;
                    }
                }
                return new RegressionResults(dArr, new double[][]{dArr2}, true, this.nobs, i7, this.sumy, this.sumsqy, this.sserr, this.hasIntercept, false);
            }
        }
        return new RegressionResults(dArrRegcf, new double[][]{dArrCov}, true, this.nobs, i7, this.sumy, this.sumsqy, this.sserr, this.hasIntercept, false);
    }

    public MillerUpdatingRegression(int i5, boolean z6) {
        this(i5, z6, Precision.EPSILON);
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public RegressionResults regress(int[] iArr) {
        int i5;
        int[] iArr2 = iArr;
        int length = iArr2.length;
        int i6 = this.nvars;
        if (length > i6) {
            throw new ModelSpecificationException(LocalizedFormats.TOO_MANY_REGRESSORS, Integer.valueOf(iArr2.length), Integer.valueOf(this.nvars));
        }
        if (this.nobs > i6) {
            Arrays.sort(iArr2);
            int i7 = 0;
            for (int i8 = 0; i8 < iArr2.length; i8++) {
                if (i8 < this.nvars) {
                    if (i8 > 0 && iArr2[i8] == iArr2[i8 - 1]) {
                        iArr2[i8] = -1;
                        i7++;
                    }
                } else {
                    throw new ModelSpecificationException(LocalizedFormats.INDEX_LARGER_THAN_MAX, Integer.valueOf(i8), Integer.valueOf(this.nvars));
                }
            }
            if (i7 > 0) {
                int[] iArr3 = new int[iArr2.length - i7];
                int i9 = 0;
                for (int i10 : iArr2) {
                    if (i10 > -1) {
                        iArr3[i9] = i10;
                        i9++;
                    }
                }
                iArr2 = iArr3;
            }
            reorderRegressors(iArr2, 0);
            tolset();
            singcheck();
            double[] dArrRegcf = regcf(iArr2.length);
            ss();
            double[] dArrCov = cov(iArr2.length);
            int i11 = 0;
            int i12 = 0;
            while (true) {
                boolean[] zArr = this.lindep;
                if (i11 >= zArr.length) {
                    break;
                }
                if (!zArr[i11]) {
                    i12++;
                }
                i11++;
            }
            for (int i13 = 0; i13 < this.nvars; i13++) {
                if (this.vorder[i13] != iArr2[i13]) {
                    double[] dArr = new double[dArrRegcf.length];
                    int[] iArr4 = new int[dArrRegcf.length];
                    for (int i14 = 0; i14 < iArr2.length; i14++) {
                        int i15 = 0;
                        while (true) {
                            int[] iArr5 = this.vorder;
                            if (i15 < iArr5.length) {
                                if (iArr5[i15] == iArr2[i14]) {
                                    dArr[i14] = dArrRegcf[i15];
                                    iArr4[i14] = i15;
                                }
                                i15++;
                            }
                        }
                    }
                    double[] dArr2 = new double[dArrCov.length];
                    int i16 = 0;
                    for (int i17 = 0; i17 < dArrRegcf.length; i17++) {
                        int i18 = iArr4[i17];
                        int i19 = 0;
                        while (i19 <= i17) {
                            int i20 = iArr4[i19];
                            if (i18 > i20) {
                                i5 = (((i18 + 1) * i18) / 2) + i20;
                            } else {
                                i5 = (((i20 + 1) * i20) / 2) + i18;
                            }
                            dArr2[i16] = dArrCov[i5];
                            i19++;
                            i16++;
                        }
                    }
                    return new RegressionResults(dArr, new double[][]{dArr2}, true, this.nobs, i12, this.sumy, this.sumsqy, this.sserr, this.hasIntercept, false);
                }
            }
            return new RegressionResults(dArrRegcf, new double[][]{dArrCov}, true, this.nobs, i12, this.sumy, this.sumsqy, this.sserr, this.hasIntercept, false);
        }
        throw new ModelSpecificationException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, Long.valueOf(this.nobs), Integer.valueOf(this.nvars));
    }
}
