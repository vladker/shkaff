package com.google.android.material.math;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static float dist(float f6, float f7, float f8, float f9) {
        return (float) Math.hypot(f8 - f6, f9 - f7);
    }

    public static float distanceToFurthestCorner(float f6, float f7, float f8, float f9, float f10, float f11) {
        return max(dist(f6, f7, f8, f9), dist(f6, f7, f10, f9), dist(f6, f7, f10, f11), dist(f6, f7, f8, f11));
    }

    public static float floorMod(float f6, int i5) {
        float f7 = i5;
        int i6 = (int) (f6 / f7);
        if (Math.signum(f6) * f7 < 0.0f && i6 * i5 != f6) {
            i6--;
        }
        return f6 - (i6 * i5);
    }

    public static boolean geq(float f6, float f7, float f8) {
        return f6 + f8 >= f7;
    }

    public static float lerp(float f6, float f7, float f8) {
        return (f8 * f7) + ((1.0f - f8) * f6);
    }

    private static float max(float f6, float f7, float f8, float f9) {
        if (f6 > f7 && f6 > f8 && f6 > f9) {
            return f6;
        }
        if (f7 <= f8 || f7 <= f9) {
            return f8 > f9 ? f8 : f9;
        }
        return f7;
    }

    public static int floorMod(int i5, int i6) {
        int i7 = i5 / i6;
        if ((i5 ^ i6) < 0 && i7 * i6 != i5) {
            i7--;
        }
        return i5 - (i7 * i6);
    }
}
