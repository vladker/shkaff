package androidx.core.graphics;

import android.graphics.Color;
import android.support.v4.media.MediaDescriptionCompat;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ScatterMapKt;
import androidx.collection.a;
import androidx.core.content.res.CamColor;
import com.google.android.material.color.utilities.Contrast;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static Color compositeColors(Color color, Color color2) {
            if (!Objects.equals(color.getModel(), color2.getModel())) {
                throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
            }
            if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float fAlpha = color.alpha();
            float fAlpha2 = (1.0f - fAlpha) * color2.alpha();
            int componentCount = color2.getComponentCount() - 1;
            float f6 = fAlpha + fAlpha2;
            components2[componentCount] = f6;
            if (f6 > 0.0f) {
                fAlpha /= f6;
                fAlpha2 /= f6;
            }
            for (int i5 = 0; i5 < componentCount; i5++) {
                components2[i5] = (components2[i5] * fAlpha2) + (components[i5] * fAlpha);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
    }

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(float[] fArr) {
        int iRound;
        int iRound2;
        int iRound3;
        float f6 = fArr[0];
        float f7 = fArr[1];
        float f8 = fArr[2];
        float fAbs = (1.0f - Math.abs((f8 * 2.0f) - 1.0f)) * f7;
        float f9 = f8 - (0.5f * fAbs);
        float fAbs2 = (1.0f - Math.abs(((f6 / 60.0f) % 2.0f) - 1.0f)) * fAbs;
        switch (((int) f6) / 60) {
            case 0:
                iRound = Math.round((fAbs + f9) * 255.0f);
                iRound2 = Math.round((fAbs2 + f9) * 255.0f);
                iRound3 = Math.round(f9 * 255.0f);
                break;
            case 1:
                iRound = Math.round((fAbs2 + f9) * 255.0f);
                iRound2 = Math.round((fAbs + f9) * 255.0f);
                iRound3 = Math.round(f9 * 255.0f);
                break;
            case 2:
                iRound = Math.round(f9 * 255.0f);
                iRound2 = Math.round((fAbs + f9) * 255.0f);
                iRound3 = Math.round((fAbs2 + f9) * 255.0f);
                break;
            case 3:
                iRound = Math.round(f9 * 255.0f);
                iRound2 = Math.round((fAbs2 + f9) * 255.0f);
                iRound3 = Math.round((fAbs + f9) * 255.0f);
                break;
            case 4:
                iRound = Math.round((fAbs2 + f9) * 255.0f);
                iRound2 = Math.round(f9 * 255.0f);
                iRound3 = Math.round((fAbs + f9) * 255.0f);
                break;
            case 5:
            case 6:
                iRound = Math.round((fAbs + f9) * 255.0f);
                iRound2 = Math.round(f9 * 255.0f);
                iRound3 = Math.round((fAbs2 + f9) * 255.0f);
                break;
            default:
                iRound3 = 0;
                iRound = 0;
                iRound2 = 0;
                break;
        }
        return Color.rgb(constrain(iRound, 0, 255), constrain(iRound2, 0, 255), constrain(iRound3, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d, @FloatRange(from = -128.0d, to = 127.0d) double d6, @FloatRange(from = -128.0d, to = 127.0d) double d7) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d, d6, d7, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d, @FloatRange(from = -128.0d, to = 127.0d) double d6, @FloatRange(from = -128.0d, to = 127.0d) double d7, double[] dArr) {
        double d8 = (d + 16.0d) / 116.0d;
        double d9 = (d6 / 500.0d) + d8;
        double d10 = d8 - (d7 / 200.0d);
        double dPow = Math.pow(d9, 3.0d);
        if (dPow <= XYZ_EPSILON) {
            dPow = ((d9 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        double dPow2 = d > 7.9996247999999985d ? Math.pow(d8, 3.0d) : d / XYZ_KAPPA;
        double dPow3 = Math.pow(d10, 3.0d);
        if (dPow3 <= XYZ_EPSILON) {
            dPow3 = ((d10 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = dPow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = dPow2 * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = dPow3 * XYZ_WHITE_REFERENCE_Z;
    }

    @ColorInt
    public static int M3HCTToColor(@FloatRange(from = 0.0d, to = 360.0d, toInclusive = false) float f6, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f7, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) float f8) {
        return CamColor.toColor(f6, f7, f8);
    }

    public static void RGBToHSL(@IntRange(from = 0, to = ScatterMapKt.Sentinel) int i5, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i6, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i7, float[] fArr) {
        float f6;
        float fAbs;
        float f7 = i5 / 255.0f;
        float f8 = i6 / 255.0f;
        float f9 = i7 / 255.0f;
        float fMax = Math.max(f7, Math.max(f8, f9));
        float fMin = Math.min(f7, Math.min(f8, f9));
        float f10 = fMax - fMin;
        float f11 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f6 = 0.0f;
            fAbs = 0.0f;
        } else {
            if (fMax == f7) {
                f6 = ((f8 - f9) / f10) % 6.0f;
            } else {
                f6 = fMax == f8 ? ((f9 - f7) / f10) + 2.0f : 4.0f + ((f7 - f8) / f10);
            }
            fAbs = f10 / (1.0f - Math.abs((2.0f * f11) - 1.0f));
        }
        float f12 = (f6 * 60.0f) % 360.0f;
        if (f12 < 0.0f) {
            f12 += 360.0f;
        }
        fArr[0] = constrain(f12, 0.0f, 360.0f);
        fArr[1] = constrain(fAbs, 0.0f, 1.0f);
        fArr[2] = constrain(f11, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = 0, to = ScatterMapKt.Sentinel) int i5, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i6, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i7, double[] dArr) {
        RGBToXYZ(i5, i6, i7, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = 0, to = ScatterMapKt.Sentinel) int i5, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i6, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i7, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = ((double) i5) / 255.0d;
        double dPow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        double d6 = ((double) i6) / 255.0d;
        double dPow2 = d6 < 0.04045d ? d6 / 12.92d : Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
        double d7 = ((double) i7) / 255.0d;
        double dPow3 = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = a.B(dPow3, 0.1805d, (0.3576d * dPow2) + (0.4124d * dPow), XYZ_WHITE_REFERENCE_Y);
        dArr[1] = a.B(dPow3, 0.0722d, (0.7152d * dPow2) + (0.2126d * dPow), XYZ_WHITE_REFERENCE_Y);
        dArr[2] = a.B(dPow3, 0.9505d, (dPow2 * 0.1192d) + (dPow * 0.0193d), XYZ_WHITE_REFERENCE_Y);
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double d, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d6, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double d7) {
        double D6 = a.D(d7, -0.4986d, ((-1.5372d) * d6) + (3.2406d * d), XYZ_WHITE_REFERENCE_Y);
        double D7 = a.D(d7, 0.0415d, (1.8758d * d6) + ((-0.9689d) * d), XYZ_WHITE_REFERENCE_Y);
        double D8 = a.D(d7, 1.057d, ((-0.204d) * d6) + (0.0557d * d), XYZ_WHITE_REFERENCE_Y);
        return Color.rgb(constrain((int) Math.round((D6 > 0.0031308d ? (Math.pow(D6, 0.4166666666666667d) * 1.055d) - 0.055d : D6 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((D7 > 0.0031308d ? (Math.pow(D7, 0.4166666666666667d) * 1.055d) - 0.055d : D7 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((D8 > 0.0031308d ? (Math.pow(D8, 0.4166666666666667d) * 1.055d) - 0.055d : D8 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double d, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d6, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double d7, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }
        double dPivotXyzComponent = pivotXyzComponent(d / XYZ_WHITE_REFERENCE_X);
        double dPivotXyzComponent2 = pivotXyzComponent(d6 / XYZ_WHITE_REFERENCE_Y);
        double dPivotXyzComponent3 = pivotXyzComponent(d7 / XYZ_WHITE_REFERENCE_Z);
        dArr[0] = Math.max(0.0d, (116.0d * dPivotXyzComponent2) - 16.0d);
        dArr[1] = (dPivotXyzComponent - dPivotXyzComponent2) * 500.0d;
        dArr[2] = (dPivotXyzComponent2 - dPivotXyzComponent3) * 200.0d;
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i5, @ColorInt int i6, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6) {
        float f7 = 1.0f - f6;
        return Color.argb((int) ((Color.alpha(i6) * f6) + (Color.alpha(i5) * f7)), (int) ((Color.red(i6) * f6) + (Color.red(i5) * f7)), (int) ((Color.green(i6) * f6) + (Color.green(i5) * f7)), (int) ((Color.blue(i6) * f6) + (Color.blue(i5) * f7)));
    }

    public static void blendHSL(float[] fArr, float[] fArr2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6, float[] fArr3) {
        if (fArr3.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }
        float f7 = 1.0f - f6;
        fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f6);
        fArr3[1] = (fArr2[1] * f6) + (fArr[1] * f7);
        fArr3[2] = (fArr2[2] * f6) + (fArr[2] * f7);
    }

    public static void blendLAB(double[] dArr, double[] dArr2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) double d, double[] dArr3) {
        if (dArr3.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }
        double d6 = 1.0d - d;
        dArr3[0] = (dArr2[0] * d) + (dArr[0] * d6);
        dArr3[1] = (dArr2[1] * d) + (dArr[1] * d6);
        dArr3[2] = (dArr2[2] * d) + (dArr[2] * d6);
    }

    public static double calculateContrast(@ColorInt int i5, @ColorInt int i6) {
        if (Color.alpha(i6) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i6));
        }
        if (Color.alpha(i5) < 255) {
            i5 = compositeColors(i5, i6);
        }
        double dCalculateLuminance = calculateLuminance(i5) + 0.05d;
        double dCalculateLuminance2 = calculateLuminance(i6) + 0.05d;
        return Math.max(dCalculateLuminance, dCalculateLuminance2) / Math.min(dCalculateLuminance, dCalculateLuminance2);
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public static double calculateLuminance(@ColorInt int i5) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i5, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(@ColorInt int i5, @ColorInt int i6, float f6) {
        int i7 = 255;
        if (Color.alpha(i6) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i6));
        }
        double d = f6;
        if (calculateContrast(setAlphaComponent(i5, 255), i6) < d) {
            return -1;
        }
        int i8 = 0;
        for (int i9 = 0; i9 <= 10 && i7 - i8 > 1; i9++) {
            int i10 = (i8 + i7) / 2;
            if (calculateContrast(setAlphaComponent(i5, i10), i6) < d) {
                i8 = i10;
            } else {
                i7 = i10;
            }
        }
        return i7;
    }

    @VisibleForTesting
    public static float circularInterpolate(float f6, float f7, float f8) {
        if (Math.abs(f7 - f6) > 180.0f) {
            if (f7 > f6) {
                f6 += 360.0f;
            } else {
                f7 += 360.0f;
            }
        }
        return (((f7 - f6) * f8) + f6) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int i5, float[] fArr) {
        RGBToHSL(Color.red(i5), Color.green(i5), Color.blue(i5), fArr);
    }

    public static void colorToLAB(@ColorInt int i5, double[] dArr) {
        RGBToLAB(Color.red(i5), Color.green(i5), Color.blue(i5), dArr);
    }

    public static void colorToM3HCT(@ColorInt int i5, @Size(MediaDescriptionCompat.BT_FOLDER_TYPE_ARTISTS) float[] fArr) {
        CamColor.getM3HCTfromColor(i5, fArr);
    }

    public static void colorToXYZ(@ColorInt int i5, double[] dArr) {
        RGBToXYZ(Color.red(i5), Color.green(i5), Color.blue(i5), dArr);
    }

    private static int compositeAlpha(int i5, int i6) {
        return 255 - (((255 - i5) * (255 - i6)) / 255);
    }

    public static int compositeColors(@ColorInt int i5, @ColorInt int i6) {
        int iAlpha = Color.alpha(i6);
        int iAlpha2 = Color.alpha(i5);
        int iCompositeAlpha = compositeAlpha(iAlpha2, iAlpha);
        return Color.argb(iCompositeAlpha, compositeComponent(Color.red(i5), iAlpha2, Color.red(i6), iAlpha, iCompositeAlpha), compositeComponent(Color.green(i5), iAlpha2, Color.green(i6), iAlpha, iCompositeAlpha), compositeComponent(Color.blue(i5), iAlpha2, Color.blue(i6), iAlpha, iCompositeAlpha));
    }

    private static int compositeComponent(int i5, int i6, int i7, int i8, int i9) {
        if (i9 == 0) {
            return 0;
        }
        return (((255 - i6) * (i7 * i8)) + ((i5 * 255) * i6)) / (i9 * 255);
    }

    private static float constrain(float f6, float f7, float f8) {
        return f6 < f7 ? f7 : Math.min(f6, f8);
    }

    public static double distanceEuclidean(double[] dArr, double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[2] - dArr2[2], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[0] - dArr2[0], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d) {
        return d > XYZ_EPSILON ? Math.pow(d, 0.3333333333333333d) : a.D(d, XYZ_KAPPA, 16.0d, 116.0d);
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i5, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i6) {
        if (i6 < 0 || i6 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i5 & 16777215) | (i6 << 24);
    }

    private static int constrain(int i5, int i6, int i7) {
        return i5 < i6 ? i6 : Math.min(i5, i7);
    }

    @RequiresApi(26)
    public static Color compositeColors(Color color, Color color2) {
        return Api26Impl.compositeColors(color, color2);
    }
}
