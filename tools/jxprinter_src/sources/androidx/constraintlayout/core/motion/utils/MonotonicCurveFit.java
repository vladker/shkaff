package androidx.constraintlayout.core.motion.utils;

import androidx.collection.a;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        int i5 = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i5, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i6 = 0; i6 < length2; i6++) {
            int i7 = 0;
            while (i7 < i5) {
                int i8 = i7 + 1;
                double d = dArr[i8] - dArr[i7];
                double[] dArr5 = dArr3[i7];
                double d6 = (dArr2[i8][i6] - dArr2[i7][i6]) / d;
                dArr5[i6] = d6;
                if (i7 == 0) {
                    dArr4[i7][i6] = d6;
                } else {
                    dArr4[i7][i6] = (dArr3[i7 - 1][i6] + d6) * 0.5d;
                }
                i7 = i8;
            }
            dArr4[i5][i6] = dArr3[length - 2][i6];
        }
        for (int i9 = 0; i9 < i5; i9++) {
            for (int i10 = 0; i10 < length2; i10++) {
                double d7 = dArr3[i9][i10];
                if (d7 == 0.0d) {
                    dArr4[i9][i10] = 0.0d;
                    dArr4[i9 + 1][i10] = 0.0d;
                } else {
                    double d8 = dArr4[i9][i10] / d7;
                    int i11 = i9 + 1;
                    double d9 = dArr4[i11][i10] / d7;
                    double dHypot = Math.hypot(d8, d9);
                    if (dHypot > 9.0d) {
                        double d10 = 3.0d / dHypot;
                        double[] dArr6 = dArr4[i9];
                        double[] dArr7 = dArr3[i9];
                        dArr6[i10] = d8 * d10 * dArr7[i10];
                        dArr4[i11][i10] = d10 * d9 * dArr7[i10];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    public static MonotonicCurveFit buildWave(String str) {
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i5 = 0;
        while (iIndexOf2 != -1) {
            dArr[i5] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i5++;
        }
        dArr[i5] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        return buildWave(Arrays.copyOf(dArr, i5 + 1));
    }

    private static double diff(double d, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d6 * d6;
        double d12 = d6 * 6.0d;
        double d13 = d * 3.0d;
        return (d * d9) + ((a.C(d13, d9, d11, a.C(d13, d10, d11, a.C(d11, 6.0d, d7, (d12 * d8) + (((-6.0d) * d11) * d8)) - (d12 * d7))) - (((2.0d * d) * d10) * d6)) - (((4.0d * d) * d9) * d6));
    }

    private static double interpolate(double d, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d6 * d6;
        double d12 = d11 * d6;
        double d13 = d11 * 3.0d;
        double dC = (a.C(d12, 2.0d, d7, (d13 * d8) + (((-2.0d) * d12) * d8)) - (d13 * d7)) + d7;
        double d14 = d * d10;
        double d15 = (d14 * d12) + dC;
        double d16 = d * d9;
        return (d16 * d6) + ((((d12 * d16) + d15) - (d14 * d11)) - (((d * 2.0d) * d9) * d11));
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i5 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d6 = dArr2[0];
            if (d <= d6) {
                getSlope(d6, this.mSlopeTemp);
                for (int i6 = 0; i6 < length2; i6++) {
                    dArr[i6] = ((d - this.mT[0]) * this.mSlopeTemp[i6]) + this.mY[0][i6];
                }
                return;
            }
            int i7 = length - 1;
            double d7 = dArr2[i7];
            if (d >= d7) {
                getSlope(d7, this.mSlopeTemp);
                while (i5 < length2) {
                    dArr[i5] = ((d - this.mT[i7]) * this.mSlopeTemp[i5]) + this.mY[i7][i5];
                    i5++;
                }
                return;
            }
        } else {
            if (d <= dArr2[0]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = this.mY[0][i8];
                }
                return;
            }
            int i9 = length - 1;
            if (d >= dArr2[i9]) {
                while (i5 < length2) {
                    dArr[i5] = this.mY[i9][i5];
                    i5++;
                }
                return;
            }
        }
        int i10 = 0;
        while (i10 < length - 1) {
            if (d == this.mT[i10]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    dArr[i11] = this.mY[i10][i11];
                }
            }
            double[] dArr3 = this.mT;
            int i12 = i10 + 1;
            double d8 = dArr3[i12];
            if (d < d8) {
                double d9 = dArr3[i10];
                double d10 = d8 - d9;
                double d11 = (d - d9) / d10;
                while (i5 < length2) {
                    double[][] dArr4 = this.mY;
                    double d12 = dArr4[i10][i5];
                    double d13 = dArr4[i12][i5];
                    double[][] dArr5 = this.mTangent;
                    dArr[i5] = interpolate(d10, d11, d12, d13, dArr5[i10][i5], dArr5[i12][i5]);
                    i5++;
                }
                return;
            }
            i10 = i12;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d6 = dArr2[0];
        if (d > d6) {
            d6 = dArr2[length - 1];
            if (d < d6) {
                d6 = d;
            }
        }
        int i5 = 0;
        while (i5 < length - 1) {
            double[] dArr3 = this.mT;
            int i6 = i5 + 1;
            double d7 = dArr3[i6];
            if (d6 <= d7) {
                double d8 = dArr3[i5];
                double d9 = d7 - d8;
                double d10 = (d6 - d8) / d9;
                for (int i7 = 0; i7 < length2; i7++) {
                    double[][] dArr4 = this.mY;
                    double d11 = dArr4[i5][i7];
                    double d12 = dArr4[i6][i7];
                    double[][] dArr5 = this.mTangent;
                    dArr[i7] = diff(d9, d10, d11, d12, dArr5[i5][i7], dArr5[i6][i7]) / d9;
                }
                return;
            }
            i5 = i6;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    private static MonotonicCurveFit buildWave(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d = 1.0d / ((double) length2);
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double d6 = dArr[i5];
            int i6 = i5 + length2;
            dArr2[i6][0] = d6;
            double d7 = ((double) i5) * d;
            dArr3[i6] = d7;
            if (i5 > 0) {
                int i7 = (length2 * 2) + i5;
                dArr2[i7][0] = d6 + 1.0d;
                dArr3[i7] = d7 + 1.0d;
                int i8 = i5 - 1;
                dArr2[i8][0] = (d6 - 1.0d) - d;
                dArr3[i8] = (d7 - 1.0d) - d;
            }
        }
        return new MonotonicCurveFit(dArr3, dArr2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i5) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i6 = 0;
        double d6 = dArr[0];
        if (d >= d6) {
            d6 = dArr[length - 1];
            if (d < d6) {
                d6 = d;
            }
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.mT;
            int i7 = i6 + 1;
            double d7 = dArr2[i7];
            if (d6 <= d7) {
                double d8 = dArr2[i6];
                double d9 = d7 - d8;
                double[][] dArr3 = this.mY;
                double d10 = dArr3[i6][i5];
                double d11 = dArr3[i7][i5];
                double[][] dArr4 = this.mTangent;
                return diff(d9, (d6 - d8) / d9, d10, d11, dArr4[i6][i5], dArr4[i7][i5]) / d9;
            }
            i6 = i7;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i5 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d6 = dArr[0];
            if (d <= d6) {
                getSlope(d6, this.mSlopeTemp);
                for (int i6 = 0; i6 < length2; i6++) {
                    fArr[i6] = (float) (((d - this.mT[0]) * this.mSlopeTemp[i6]) + this.mY[0][i6]);
                }
                return;
            }
            int i7 = length - 1;
            double d7 = dArr[i7];
            if (d >= d7) {
                getSlope(d7, this.mSlopeTemp);
                while (i5 < length2) {
                    fArr[i5] = (float) (((d - this.mT[i7]) * this.mSlopeTemp[i5]) + this.mY[i7][i5]);
                    i5++;
                }
                return;
            }
        } else {
            if (d <= dArr[0]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) this.mY[0][i8];
                }
                return;
            }
            int i9 = length - 1;
            if (d >= dArr[i9]) {
                while (i5 < length2) {
                    fArr[i5] = (float) this.mY[i9][i5];
                    i5++;
                }
                return;
            }
        }
        int i10 = 0;
        while (i10 < length - 1) {
            if (d == this.mT[i10]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr[i11] = (float) this.mY[i10][i11];
                }
            }
            double[] dArr2 = this.mT;
            int i12 = i10 + 1;
            double d8 = dArr2[i12];
            if (d < d8) {
                double d9 = dArr2[i10];
                double d10 = d8 - d9;
                double d11 = (d - d9) / d10;
                while (i5 < length2) {
                    double[][] dArr3 = this.mY;
                    double d12 = dArr3[i10][i5];
                    double d13 = dArr3[i12][i5];
                    double[][] dArr4 = this.mTangent;
                    fArr[i5] = (float) interpolate(d10, d11, d12, d13, dArr4[i10][i5], dArr4[i12][i5]);
                    i5++;
                }
                return;
            }
            i10 = i12;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i5) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i6 = 0;
        if (this.mExtrapolate) {
            double d6 = dArr[0];
            if (d <= d6) {
                return (getSlope(d6, i5) * (d - d6)) + this.mY[0][i5];
            }
            int i7 = length - 1;
            double d7 = dArr[i7];
            if (d >= d7) {
                return (getSlope(d7, i5) * (d - d7)) + this.mY[i7][i5];
            }
        } else {
            if (d <= dArr[0]) {
                return this.mY[0][i5];
            }
            int i8 = length - 1;
            if (d >= dArr[i8]) {
                return this.mY[i8][i5];
            }
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.mT;
            double d8 = dArr2[i6];
            if (d == d8) {
                return this.mY[i6][i5];
            }
            int i9 = i6 + 1;
            double d9 = dArr2[i9];
            if (d < d9) {
                double d10 = d9 - d8;
                double d11 = (d - d8) / d10;
                double[][] dArr3 = this.mY;
                double d12 = dArr3[i6][i5];
                double d13 = dArr3[i9][i5];
                double[][] dArr4 = this.mTangent;
                return interpolate(d10, d11, d12, d13, dArr4[i6][i5], dArr4[i9][i5]);
            }
            i6 = i9;
        }
        return 0.0d;
    }
}
