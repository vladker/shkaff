package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr2[0].length;
        this.mSlopeTemp = new double[length];
        this.mT = dArr;
        this.mY = dArr2;
        if (length <= 2) {
            return;
        }
        int i5 = 0;
        double d = 0.0d;
        while (true) {
            double d6 = d;
            if (i5 >= dArr.length) {
                this.mTotalLength = 0.0d;
                return;
            }
            double d7 = dArr2[i5][0];
            if (i5 > 0) {
                Math.hypot(d7 - d, d7 - d6);
            }
            i5++;
            d = d7;
        }
    }

    private double getLength2D(double d) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d <= dArr[0]) {
            return 0.0d;
        }
        int i5 = length - 1;
        if (d >= dArr[i5]) {
            return this.mTotalLength;
        }
        double dHypot = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        int i6 = 0;
        while (i6 < i5) {
            double[] dArr2 = this.mY[i6];
            double d8 = dArr2[0];
            double d9 = dArr2[1];
            if (i6 > 0) {
                dHypot += Math.hypot(d8 - d6, d9 - d7);
            }
            double[] dArr3 = this.mT;
            double d10 = dArr3[i6];
            if (d == d10) {
                return dHypot;
            }
            int i7 = i6 + 1;
            double d11 = dArr3[i7];
            if (d < d11) {
                double d12 = (d - d10) / (d11 - d10);
                double[][] dArr4 = this.mY;
                double[] dArr5 = dArr4[i6];
                double d13 = dArr5[0];
                double[] dArr6 = dArr4[i7];
                double d14 = dArr6[0];
                double d15 = 1.0d - d12;
                return Math.hypot(d9 - ((dArr6[1] * d12) + (dArr5[1] * d15)), d8 - ((d14 * d12) + (d13 * d15))) + dHypot;
            }
            i6 = i7;
            d6 = d8;
            d7 = d9;
        }
        return 0.0d;
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
                double d10 = (d - d9) / (d8 - d9);
                while (i5 < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i5] = (dArr4[i12][i5] * d10) + ((1.0d - d10) * dArr4[i10][i5]);
                    i5++;
                }
                return;
            }
            i10 = i12;
        }
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000f A[PHI: r4
  0x000f: PHI (r4v5 double) = (r4v0 double), (r4v2 double) binds: [B:3:0x000d, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d6 = dArr2[0];
        if (d <= d6) {
            d = d6;
        } else {
            d6 = dArr2[length - 1];
            if (d >= d6) {
                d = d6;
            }
        }
        int i5 = 0;
        while (i5 < length - 1) {
            double[] dArr3 = this.mT;
            int i6 = i5 + 1;
            double d7 = dArr3[i6];
            if (d <= d7) {
                double d8 = d7 - dArr3[i5];
                for (int i7 = 0; i7 < length2; i7++) {
                    double[][] dArr4 = this.mY;
                    dArr[i7] = (dArr4[i6][i7] - dArr4[i5][i7]) / d8;
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

    /* JADX WARN: Code duplicated, block: B:4:0x000a A[PHI: r3
  0x000a: PHI (r3v4 double) = (r3v0 double), (r3v2 double) binds: [B:3:0x0008, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i5) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i6 = 0;
        double d6 = dArr[0];
        if (d < d6) {
            d = d6;
        } else {
            d6 = dArr[length - 1];
            if (d >= d6) {
                d = d6;
            }
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.mT;
            int i7 = i6 + 1;
            double d7 = dArr2[i7];
            if (d <= d7) {
                double d8 = d7 - dArr2[i6];
                double[][] dArr3 = this.mY;
                return (dArr3[i7][i5] - dArr3[i6][i5]) / d8;
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
                double d10 = (d - d9) / (d8 - d9);
                while (i5 < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i5] = (float) ((dArr3[i12][i5] * d10) + ((1.0d - d10) * dArr3[i10][i5]));
                    i5++;
                }
                return;
            }
            i10 = i12;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i5) {
        double d6;
        double d7;
        double slope;
        double[] dArr = this.mT;
        int length = dArr.length;
        int i6 = 0;
        if (this.mExtrapolate) {
            double d8 = dArr[0];
            if (d <= d8) {
                d6 = this.mY[0][i5];
                d7 = d - d8;
                slope = getSlope(d8, i5);
            } else {
                int i7 = length - 1;
                double d9 = dArr[i7];
                if (d >= d9) {
                    d6 = this.mY[i7][i5];
                    d7 = d - d9;
                    slope = getSlope(d9, i5);
                }
            }
            return (slope * d7) + d6;
        }
        if (d <= dArr[0]) {
            return this.mY[0][i5];
        }
        int i8 = length - 1;
        if (d >= dArr[i8]) {
            return this.mY[i8][i5];
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.mT;
            double d10 = dArr2[i6];
            if (d == d10) {
                return this.mY[i6][i5];
            }
            int i9 = i6 + 1;
            double d11 = dArr2[i9];
            if (d < d11) {
                double d12 = (d - d10) / (d11 - d10);
                double[][] dArr3 = this.mY;
                return (dArr3[i9][i5] * d12) + ((1.0d - d12) * dArr3[i6][i5]);
            }
            i6 = i9;
        }
        return 0.0d;
    }
}
