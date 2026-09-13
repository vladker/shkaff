package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ColorKt {
    public static final int component1(@ColorInt int i5) {
        return (i5 >> 24) & 255;
    }

    public static final int component2(@ColorInt int i5) {
        return (i5 >> 16) & 255;
    }

    public static final int component3(@ColorInt int i5) {
        return (i5 >> 8) & 255;
    }

    public static final int component4(@ColorInt int i5) {
        return i5 & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i5, ColorSpace.Named named) {
        return Color.convert(i5, ColorSpace.get(named));
    }

    public static final int getAlpha(@ColorInt int i5) {
        return (i5 >> 24) & 255;
    }

    public static final int getBlue(@ColorInt int i5) {
        return i5 & 255;
    }

    @RequiresApi(26)
    public static final ColorSpace getColorSpace(long j6) {
        return Color.colorSpace(j6);
    }

    public static final int getGreen(@ColorInt int i5) {
        return (i5 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i5) {
        return Color.luminance(i5);
    }

    public static final int getRed(@ColorInt int i5) {
        return (i5 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j6) {
        return Color.isSrgb(j6);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j6) {
        return Color.isWideGamut(j6);
    }

    @RequiresApi(26)
    public static final Color plus(Color color, Color color2) {
        return ColorUtils.compositeColors(color2, color);
    }

    @RequiresApi(26)
    public static final Color toColor(@ColorInt int i5) {
        return Color.valueOf(i5);
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j6) {
        return Color.toArgb(j6);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i5) {
        return Color.pack(i5);
    }

    @RequiresApi(26)
    public static final float component1(Color color) {
        return color.getComponent(0);
    }

    @RequiresApi(26)
    public static final float component2(Color color) {
        return color.getComponent(1);
    }

    @RequiresApi(26)
    public static final float component3(Color color) {
        return color.getComponent(2);
    }

    @RequiresApi(26)
    public static final float component4(Color color) {
        return color.getComponent(3);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i5, ColorSpace colorSpace) {
        return Color.convert(i5, colorSpace);
    }

    @RequiresApi(26)
    public static final float getAlpha(long j6) {
        return Color.alpha(j6);
    }

    @RequiresApi(26)
    public static final float getBlue(long j6) {
        return Color.blue(j6);
    }

    @RequiresApi(26)
    public static final float getGreen(long j6) {
        return Color.green(j6);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j6) {
        return Color.luminance(j6);
    }

    @RequiresApi(26)
    public static final float getRed(long j6) {
        return Color.red(j6);
    }

    @RequiresApi(26)
    public static final Color toColor(long j6) {
        return Color.valueOf(j6);
    }

    @ColorInt
    public static final int toColorInt(String str) {
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    public static final float component1(long j6) {
        return Color.red(j6);
    }

    @RequiresApi(26)
    public static final float component2(long j6) {
        return Color.green(j6);
    }

    @RequiresApi(26)
    public static final float component3(long j6) {
        return Color.blue(j6);
    }

    @RequiresApi(26)
    public static final float component4(long j6) {
        return Color.alpha(j6);
    }

    @RequiresApi(26)
    public static final long convertTo(long j6, ColorSpace.Named named) {
        return Color.convert(j6, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final long convertTo(long j6, ColorSpace colorSpace) {
        return Color.convert(j6, colorSpace);
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace.Named named) {
        return color.convert(ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace colorSpace) {
        return color.convert(colorSpace);
    }
}
