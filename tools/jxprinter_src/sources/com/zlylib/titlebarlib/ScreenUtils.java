package com.zlylib.titlebarlib;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ScreenUtils {
    public static float density(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float dp2Px(Context context, float f6) {
        if (context == null) {
            return -1.0f;
        }
        return density(context) * f6;
    }

    public static int dp2PxInt(Context context, float f6) {
        return (int) (dp2Px(context, f6) + 0.5f);
    }

    public static int getAppInScreenheight(Context context) {
        return getScreenHeight(context) - getStatusBarHeight(context);
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        Activity activity = ((context instanceof Activity) || !(context instanceof ContextWrapper)) ? (Activity) context : (Activity) ((ContextWrapper) context).getBaseContext();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int[] getScreenPixelSize(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void hideSoftInputKeyBoard(Context context, View view) {
        IBinder windowToken;
        if (view == null || (windowToken = view.getWindowToken()) == null) {
            return;
        }
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(windowToken, 1);
    }

    public static float px2Dp(Context context, float f6) {
        if (context == null) {
            return -1.0f;
        }
        return f6 / density(context);
    }

    public static float px2DpCeilInt(Context context, float f6) {
        return (int) (px2Dp(context, f6) + 0.5f);
    }

    public static int px2sp(Context context, float f6) {
        return (int) ((f6 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void showSoftInputKeyBoard(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 2);
    }

    public static int sp2px(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
