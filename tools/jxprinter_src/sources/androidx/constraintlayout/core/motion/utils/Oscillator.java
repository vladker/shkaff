package androidx.constraintlayout.core.motion.utils;

import androidx.collection.a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double mPI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d, float f6) {
        int length = this.mPeriod.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.mPosition[iBinarySearch] = d;
        this.mPeriod[iBinarySearch] = f6;
        this.mNormalized = false;
    }

    public double getDP(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = this.mPeriod;
        float f6 = fArr[iBinarySearch];
        int i5 = iBinarySearch - 1;
        float f7 = fArr[i5];
        double d6 = f6 - f7;
        double[] dArr = this.mPosition;
        double d7 = dArr[iBinarySearch];
        double d8 = dArr[i5];
        double d9 = d6 / (d7 - d8);
        return (((double) f7) - (d9 * d8)) + (d * d9);
    }

    public double getP(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = this.mPeriod;
        float f6 = fArr[iBinarySearch];
        int i5 = iBinarySearch - 1;
        float f7 = fArr[i5];
        double d6 = f6 - f7;
        double[] dArr = this.mPosition;
        double d7 = dArr[iBinarySearch];
        double d8 = dArr[i5];
        double d9 = d6 / (d7 - d8);
        return ((((d * d) - (d8 * d8)) * d9) / 2.0d) + a.a(d, d8, ((double) f7) - (d9 * d8), this.mArea[i5]);
    }

    public double getSlope(double d, double d6, double d7) {
        double d8;
        double dSignum;
        double p6 = getP(d) + d6;
        double dp = getDP(d) + d7;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                d8 = dp * 4.0d;
                dSignum = Math.signum((((p6 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return dp * 2.0d;
            case 4:
                return (-dp) * 2.0d;
            case 5:
                double d9 = this.mPI2;
                return Math.sin(d9 * p6) * (-d9) * dp;
            case 6:
                return ((((p6 * 4.0d) + 2.0d) % 4.0d) - 2.0d) * dp * 4.0d;
            case 7:
                return this.mCustomCurve.getSlope(p6 % 1.0d, 0);
            default:
                double d10 = this.mPI2;
                d8 = dp * d10;
                dSignum = Math.cos(d10 * p6);
                break;
        }
        return dSignum * d8;
    }

    public double getValue(double d, double d6) {
        double dAbs;
        double p6 = getP(d) + d6;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (p6 % 1.0d));
            case 2:
                dAbs = Math.abs((((p6 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((p6 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                dAbs = ((p6 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos((d6 + p6) * this.mPI2);
            case 6:
                double dAbs2 = 1.0d - Math.abs(((p6 * 4.0d) % 4.0d) - 2.0d);
                dAbs = dAbs2 * dAbs2;
                break;
            case 7:
                return this.mCustomCurve.getPos(p6 % 1.0d, 0);
            default:
                return Math.sin(this.mPI2 * p6);
        }
        return 1.0d - dAbs;
    }

    public void normalize() {
        double d = 0.0d;
        int i5 = 0;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i5 >= fArr.length) {
                break;
            }
            d += (double) fArr[i5];
            i5++;
        }
        double d6 = 0.0d;
        int i6 = 1;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i6 >= fArr2.length) {
                break;
            }
            int i7 = i6 - 1;
            float f6 = (fArr2[i7] + fArr2[i6]) / 2.0f;
            double[] dArr = this.mPosition;
            d6 += (dArr[i6] - dArr[i7]) * ((double) f6);
            i6++;
        }
        int i8 = 0;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i8 >= fArr3.length) {
                break;
            }
            fArr3[i8] = fArr3[i8] * ((float) (d / d6));
            i8++;
        }
        this.mArea[0] = 0.0d;
        int i9 = 1;
        while (true) {
            float[] fArr4 = this.mPeriod;
            if (i9 >= fArr4.length) {
                this.mNormalized = true;
                return;
            }
            int i10 = i9 - 1;
            float f7 = (fArr4[i10] + fArr4[i9]) / 2.0f;
            double[] dArr2 = this.mPosition;
            double d7 = dArr2[i9] - dArr2[i10];
            double[] dArr3 = this.mArea;
            dArr3[i9] = (d7 * ((double) f7)) + dArr3[i10];
            i9++;
        }
    }

    public void setType(int i5, String str) {
        this.mType = i5;
        this.mCustomType = str;
        if (str != null) {
            this.mCustomCurve = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
