package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2.0f;
    private static final int OVERLAY_ACCENT_COLOR_ALPHA = (int) Math.round(5.1000000000000005d);
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayAccentColor;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(@NonNull Context context) {
        this(MaterialAttributes.resolveBoolean(context, R.attr.elevationOverlayEnabled, false), MaterialColors.getColor(context, R.attr.elevationOverlayColor, 0), MaterialColors.getColor(context, R.attr.elevationOverlayAccentColor, 0), MaterialColors.getColor(context, R.attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean isThemeSurfaceColor(@ColorInt int i5) {
        return ColorUtils.setAlphaComponent(i5, 255) == this.colorSurface;
    }

    public int calculateOverlayAlpha(float f6) {
        return Math.round(calculateOverlayAlphaFraction(f6) * 255.0f);
    }

    public float calculateOverlayAlphaFraction(float f6) {
        float f7 = this.displayDensity;
        if (f7 <= 0.0f || f6 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f6 / f7)) * FORMULA_MULTIPLIER) + FORMULA_OFFSET) / 100.0f, 1.0f);
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int i5, float f6, @NonNull View view) {
        return compositeOverlay(i5, getParentAbsoluteElevation(view) + f6);
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int i5, float f6, @NonNull View view) {
        return compositeOverlayIfNeeded(i5, getParentAbsoluteElevation(view) + f6);
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f6, @NonNull View view) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(getParentAbsoluteElevation(view) + f6);
    }

    public float getParentAbsoluteElevation(@NonNull View view) {
        return ViewUtils.getParentAbsoluteElevation(view);
    }

    @ColorInt
    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    @ColorInt
    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int i5, float f6) {
        int i6;
        float fCalculateOverlayAlphaFraction = calculateOverlayAlphaFraction(f6);
        int iAlpha = Color.alpha(i5);
        int iLayer = MaterialColors.layer(ColorUtils.setAlphaComponent(i5, 255), this.elevationOverlayColor, fCalculateOverlayAlphaFraction);
        if (fCalculateOverlayAlphaFraction > 0.0f && (i6 = this.elevationOverlayAccentColor) != 0) {
            iLayer = MaterialColors.layer(iLayer, ColorUtils.setAlphaComponent(i6, OVERLAY_ACCENT_COLOR_ALPHA));
        }
        return ColorUtils.setAlphaComponent(iLayer, iAlpha);
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int i5, float f6) {
        return (this.elevationOverlayEnabled && isThemeSurfaceColor(i5)) ? compositeOverlay(i5, f6) : i5;
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f6) {
        return compositeOverlayIfNeeded(this.colorSurface, f6);
    }

    public ElevationOverlayProvider(boolean z6, @ColorInt int i5, @ColorInt int i6, @ColorInt int i7, float f6) {
        this.elevationOverlayEnabled = z6;
        this.elevationOverlayColor = i5;
        this.elevationOverlayAccentColor = i6;
        this.colorSurface = i7;
        this.displayDensity = f6;
    }
}
