package com.google.zxing.common.detector;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class MathUtils {
    private MathUtils() {
    }

    public static float distance(float f6, float f7, float f8, float f9) {
        float f10 = f6 - f8;
        float f11 = f7 - f9;
        return (float) Math.sqrt((f11 * f11) + (f10 * f10));
    }

    public static int round(float f6) {
        return (int) (f6 + (f6 < 0.0f ? -0.5f : 0.5f));
    }

    public static int sum(int[] iArr) {
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += i6;
        }
        return i5;
    }

    public static float distance(int i5, int i6, int i7, int i8) {
        int i9 = i5 - i7;
        int i10 = i6 - i8;
        return (float) Math.sqrt((i10 * i10) + (i9 * i9));
    }
}
