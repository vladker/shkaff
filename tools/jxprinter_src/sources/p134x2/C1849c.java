package p134x2;

import org.apache.poi.util.Units;

/* JADX INFO: renamed from: x2.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1849c {
    public static final C1849c INSTANCE = new C1849c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f8893a = 1.0f;
    public static int b = 8;

    public static final int getRatio() {
        return b;
    }

    public static final float getScale() {
        return f8893a;
    }

    public static final int mm2px(float f6) {
        return (int) (f6 * b);
    }

    public static final int mm2pxWithScale(float f6) {
        return (int) (f6 * b * f8893a);
    }

    public static final int mm2pxWithScaleForInt(float f6) {
        return (int) Math.ceil(f6 * b * f8893a);
    }

    public static final float pt2px(float f6) {
        return f6 * 0.352f * b;
    }

    public static final float pt2pxWithScale(float f6) {
        return f6 * 0.352f * b * f8893a;
    }

    public static final float px2mm(float f6) {
        return f6 / b;
    }

    public static final float px2mmWithScale(float f6) {
        return f6 / (b * f8893a);
    }

    public static final void refreshRatio(int i5) {
        b = i5;
    }

    public static final void setScale(float f6) {
        f8893a = f6;
    }

    public static final int text_print_mm2px(float f6) {
        if (Math.abs(f6 - 58) < 0.01d) {
            return 384;
        }
        return Math.abs((double) (f6 - ((float) 80))) < 0.01d ? Units.MASTER_DPI : (int) (f6 * b);
    }

    public static final int mm2pxWithScale(float f6, float f7) {
        return (int) (f6 * b * f7);
    }

    public static final int mm2pxWithScaleForInt(float f6, float f7) {
        return (int) Math.ceil(f6 * b * f7);
    }

    public static final float pt2pxWithScale(float f6, float f7) {
        return f6 * 0.352f * b * f7;
    }

    public static final float px2mmWithScale(float f6, float f7) {
        return f6 / (b * f7);
    }
}
