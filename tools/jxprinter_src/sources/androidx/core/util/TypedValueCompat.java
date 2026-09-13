package androidx.core.util;

import A3.AbstractC0157z;
import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        public static float deriveDimension(int i5, float f6, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i5, f6, displayMetrics);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static float deriveDimension(int i5, float f6, DisplayMetrics displayMetrics) {
        float f7;
        float f8;
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.deriveDimension(i5, f6, displayMetrics);
        }
        if (i5 == 0) {
            return f6;
        }
        if (i5 == 1) {
            float f9 = displayMetrics.density;
            if (f9 == 0.0f) {
                return 0.0f;
            }
            return f6 / f9;
        }
        if (i5 == 2) {
            float f10 = displayMetrics.scaledDensity;
            if (f10 == 0.0f) {
                return 0.0f;
            }
            return f6 / f10;
        }
        if (i5 == 3) {
            float f11 = displayMetrics.xdpi;
            if (f11 == 0.0f) {
                return 0.0f;
            }
            f7 = f6 / f11;
            f8 = INCHES_PER_PT;
        } else {
            if (i5 == 4) {
                float f12 = displayMetrics.xdpi;
                if (f12 == 0.0f) {
                    return 0.0f;
                }
                return f6 / f12;
            }
            if (i5 != 5) {
                throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid unitToConvertTo "));
            }
            float f13 = displayMetrics.xdpi;
            if (f13 == 0.0f) {
                return 0.0f;
            }
            f7 = f6 / f13;
            f8 = INCHES_PER_MM;
        }
        return f7 / f8;
    }

    public static float dpToPx(float f6, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f6, displayMetrics);
    }

    @SuppressLint({"WrongConstant"})
    public static int getUnitFromComplexDimension(int i5) {
        return i5 & 15;
    }

    public static float pxToDp(float f6, DisplayMetrics displayMetrics) {
        return deriveDimension(1, f6, displayMetrics);
    }

    public static float pxToSp(float f6, DisplayMetrics displayMetrics) {
        return deriveDimension(2, f6, displayMetrics);
    }

    public static float spToPx(float f6, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f6, displayMetrics);
    }
}
