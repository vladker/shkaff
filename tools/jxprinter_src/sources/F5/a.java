package F5;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a {
    public static void a(Context context, boolean z6) {
        Activity activityD = c.d(context);
        if (activityD != null && Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = activityD.getWindow().getAttributes();
            if (z6) {
                attributes.layoutInDisplayCutoutMode = 1;
            } else {
                attributes.layoutInDisplayCutoutMode = 0;
            }
            activityD.getWindow().setAttributes(attributes);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    public static boolean b(Activity activity) {
        boolean zBooleanValue;
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT >= 28) {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || displayCutout.getBoundingRects().size() <= 0) ? false : true;
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            try {
                Class<?> clsLoadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                if (clsLoadClass != null) {
                    zBooleanValue = ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", null).invoke(clsLoadClass, null)).booleanValue();
                } else {
                    zBooleanValue = false;
                }
            } catch (Exception unused) {
            }
        } else {
            zBooleanValue = false;
        }
        if (zBooleanValue) {
            return true;
        }
        return (!Build.MANUFACTURER.equalsIgnoreCase("oppo") ? false : activity.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism")) || hasCutoutVIVO(activity) || hasCutoutXIAOMI(activity);
    }

    @SuppressLint({"PrivateApi"})
    private static boolean hasCutoutVIVO(Activity activity) {
        if (!Build.MANUFACTURER.equalsIgnoreCase("vivo")) {
            return false;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.util.FtFeature");
            if (clsLoadClass != null) {
                return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @SuppressLint({"PrivateApi"})
    private static boolean hasCutoutXIAOMI(Activity activity) {
        if (!Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
            return false;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception unused) {
        }
    }
}
