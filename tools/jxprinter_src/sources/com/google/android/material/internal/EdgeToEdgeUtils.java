package com.google.android.material.internal;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EdgeToEdgeUtils {
    private static final int EDGE_TO_EDGE_BAR_ALPHA = 128;

    private EdgeToEdgeUtils() {
    }

    public static void applyEdgeToEdge(@NonNull Window window, boolean z6) {
        applyEdgeToEdge(window, z6, null, null);
    }

    @TargetApi(21)
    private static int getNavigationBarColor(Context context, boolean z6) {
        if (z6 && Build.VERSION.SDK_INT < 27) {
            return ColorUtils.setAlphaComponent(MaterialColors.getColor(context, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK), 128);
        }
        if (z6) {
            return 0;
        }
        return MaterialColors.getColor(context, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    @TargetApi(21)
    private static int getStatusBarColor(Context context, boolean z6) {
        if (z6) {
            return 0;
        }
        return MaterialColors.getColor(context, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    private static boolean isUsingLightSystemBar(int i5, boolean z6) {
        if (MaterialColors.isColorLight(i5)) {
            return true;
        }
        return i5 == 0 && z6;
    }

    public static void setLightNavigationBar(@NonNull Window window, boolean z6) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars(z6);
    }

    public static void setLightStatusBar(@NonNull Window window, boolean z6) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(z6);
    }

    public static void applyEdgeToEdge(@NonNull Window window, boolean z6, @Nullable @ColorInt Integer num, @Nullable @ColorInt Integer num2) {
        boolean z7 = num == null || num.intValue() == 0;
        boolean z8 = num2 == null || num2.intValue() == 0;
        if (z7 || z8) {
            int color = MaterialColors.getColor(window.getContext(), R.attr.colorBackground, ViewCompat.MEASURED_STATE_MASK);
            if (z7) {
                num = Integer.valueOf(color);
            }
            if (z8) {
                num2 = Integer.valueOf(color);
            }
        }
        WindowCompat.setDecorFitsSystemWindows(window, !z6);
        int statusBarColor = getStatusBarColor(window.getContext(), z6);
        int navigationBarColor = getNavigationBarColor(window.getContext(), z6);
        window.setStatusBarColor(statusBarColor);
        window.setNavigationBarColor(navigationBarColor);
        setLightStatusBar(window, isUsingLightSystemBar(statusBarColor, MaterialColors.isColorLight(num.intValue())));
        setLightNavigationBar(window, isUsingLightSystemBar(navigationBarColor, MaterialColors.isColorLight(num2.intValue())));
    }
}
