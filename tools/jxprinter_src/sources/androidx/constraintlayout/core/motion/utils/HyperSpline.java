package androidx.constraintlayout.core.motion.utils;

import androidx.collection.a;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Cubic {
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double d, double d6, double d7, double d8) {
            this.mA = d;
            this.mB = d6;
            this.mC = d7;
            this.mD = d8;
        }

        public double eval(double d) {
            return (((((this.mD * d) + this.mC) * d) + this.mB) * d) + this.mA;
        }

        public double vel(double d) {
            return a.B(this.mC, 2.0d, this.mD * 3.0d * d, d) + this.mB;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public static Cubic[] calcNaturalCubic(int i5, double[] dArr) {
        double[] dArr2 = new double[i5];
        double[] dArr3 = new double[i5];
        double[] dArr4 = new double[i5];
        int i6 = i5 - 1;
        int i7 = 0;
        dArr2[0] = 0.5d;
        int i8 = 1;
        for (int i9 = 1; i9 < i6; i9++) {
            dArr2[i9] = 1.0d / (4.0d - dArr2[i9 - 1]);
        }
        int i10 = i5 - 2;
        dArr2[i6] = 1.0d / (2.0d - dArr2[i10]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i8 < i6) {
            int i11 = i8 + 1;
            int i12 = i8 - 1;
            dArr3[i8] = (((dArr[i11] - dArr[i12]) * 3.0d) - dArr3[i12]) * dArr2[i8];
            i8 = i11;
        }
        double d = (((dArr[i6] - dArr[i10]) * 3.0d) - dArr3[i10]) * dArr2[i6];
        dArr3[i6] = d;
        dArr4[i6] = d;
        while (i10 >= 0) {
            dArr4[i10] = dArr3[i10] - (dArr2[i10] * dArr4[i10 + 1]);
            i10--;
        }
        Cubic[] cubicArr = new Cubic[i6];
        while (i7 < i6) {
            double d6 = dArr[i7];
            double d7 = dArr4[i7];
            int i13 = i7 + 1;
            double d8 = dArr[i13];
            double d9 = dArr4[i13];
            cubicArr[i7] = new Cubic((float) d6, d7, (((d8 - d6) * 3.0d) - (d7 * 2.0d)) - d9, ((d6 - d8) * 2.0d) + d7 + d9);
            i7 = i13;
        }
        return cubicArr;
    }

    public double approxLength(Cubic[] cubicArr) {
        int i5;
        int length = cubicArr.length;
        double[] dArr = new double[length];
        double d = 0.0d;
        double d6 = 0.0d;
        double dSqrt = 0.0d;
        while (true) {
            i5 = 0;
            if (d6 >= 1.0d) {
                break;
            }
            double d7 = 0.0d;
            while (i5 < length) {
                double d8 = dArr[i5];
                double dEval = cubicArr[i5].eval(d6);
                dArr[i5] = dEval;
                double d9 = d8 - dEval;
                d7 += d9 * d9;
                i5++;
            }
            if (d6 > 0.0d) {
                dSqrt += Math.sqrt(d7);
            }
            d6 += 0.1d;
        }
        while (i5 < length) {
            double d10 = dArr[i5];
            double dEval2 = cubicArr[i5].eval(1.0d);
            dArr[i5] = dEval2;
            double d11 = d10 - dEval2;
            d += d11 * d11;
            i5++;
        }
        return Math.sqrt(d) + dSqrt;
    }

    public void getPos(double d, double[] dArr) {
        double d6 = d * this.mTotalLength;
        int i5 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i5 >= dArr2.length - 1) {
                break;
            }
            double d7 = dArr2[i5];
            if (d7 >= d6) {
                break;
            }
            d6 -= d7;
            i5++;
        }
        for (int i6 = 0; i6 < dArr.length; i6++) {
            dArr[i6] = this.mCurve[i6][i5].eval(d6 / this.mCurveLength[i5]);
        }
    }

    public void getVelocity(double d, double[] dArr) {
        double d6 = d * this.mTotalLength;
        int i5 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i5 >= dArr2.length - 1) {
                break;
            }
            double d7 = dArr2[i5];
            if (d7 >= d6) {
                break;
            }
            d6 -= d7;
            i5++;
        }
        for (int i6 = 0; i6 < dArr.length; i6++) {
            dArr[i6] = this.mCurve[i6][i5].vel(d6 / this.mCurveLength[i5]);
        }
    }

    public void setup(double[][] dArr) {
        int i5;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        this.mCtl = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        this.mCurve = new Cubic[this.mDimensionality][];
        for (int i6 = 0; i6 < this.mDimensionality; i6++) {
            for (int i7 = 0; i7 < this.mPoints; i7++) {
                this.mCtl[i6][i7] = dArr[i7][i6];
            }
        }
        int i8 = 0;
        while (true) {
            i5 = this.mDimensionality;
            if (i8 >= i5) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[] dArr2 = this.mCtl[i8];
            cubicArr[i8] = calcNaturalCubic(dArr2.length, dArr2);
            i8++;
        }
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i5];
        for (int i9 = 0; i9 < this.mCurveLength.length; i9++) {
            for (int i10 = 0; i10 < this.mDimensionality; i10++) {
                cubicArr2[i10] = this.mCurve[i10][i9];
            }
            double d = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double dApproxLength = approxLength(cubicArr2);
            dArr3[i9] = dApproxLength;
            this.mTotalLength = d + dApproxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d, float[] fArr) {
        double d6 = d * this.mTotalLength;
        int i5 = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i5 >= dArr.length - 1) {
                break;
            }
            double d7 = dArr[i5];
            if (d7 >= d6) {
                break;
            }
            d6 -= d7;
            i5++;
        }
        for (int i6 = 0; i6 < fArr.length; i6++) {
            fArr[i6] = (float) this.mCurve[i6][i5].eval(d6 / this.mCurveLength[i5]);
        }
    }

    public double getPos(double d, int i5) {
        double[] dArr;
        double d6 = d * this.mTotalLength;
        int i6 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i6 >= dArr.length - 1) {
                break;
            }
            double d7 = dArr[i6];
            if (d7 >= d6) {
                break;
            }
            d6 -= d7;
            i6++;
        }
        return this.mCurve[i5][i6].eval(d6 / dArr[i6]);
    }
}
