package com.hjq.permissions;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: com.hjq.permissions.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0555h {
    public static void a() {
        try {
            Class.forName(AppOpsManager.class.getName()).getDeclaredField("OP_GET_INSTALLED_APPS");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e6) {
            e6.printStackTrace();
        }
    }

    public static Intent getPermissionIntent(@NonNull Context context) {
        if (L.c()) {
            return S.addSubIntentToMainIntent(L.isMiuiOptimization() ? I.getMiuiPermissionPageIntent(context) : null, I.getApplicationDetailsIntent(context));
        }
        return I.getApplicationDetailsIntent(context);
    }

    public static boolean isDoNotAskAgainPermission(@NonNull Activity activity) {
        if (isSupportGetInstalledAppsPermission(activity)) {
            return (K.checkSelfPermission(activity, "com.android.permission.GET_INSTALLED_APPS") || K.shouldShowRequestPermissionRationale(activity, "com.android.permission.GET_INSTALLED_APPS")) ? false : true;
        }
        if (!L.c()) {
            return false;
        }
        a();
        if (L.isMiuiOptimization()) {
            return !isGrantedPermission(activity);
        }
        return false;
    }

    public static boolean isGrantedPermission(@NonNull Context context) {
        if (isSupportGetInstalledAppsPermission(context)) {
            return K.checkSelfPermission(context, "com.android.permission.GET_INSTALLED_APPS");
        }
        if (!L.c()) {
            return true;
        }
        a();
        if (L.isMiuiOptimization()) {
            return K.checkOpNoThrow(context, "OP_GET_INSTALLED_APPS", 10022);
        }
        return true;
    }

    @RequiresApi(api = 23)
    private static boolean isSupportGetInstalledAppsPermission(Context context) {
        try {
            PermissionInfo permissionInfo = context.getPackageManager().getPermissionInfo("com.android.permission.GET_INSTALLED_APPS", 0);
            if (permissionInfo != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (permissionInfo.getProtection() == 1) {
                    }
                }
                return (permissionInfo.protectionLevel & 15) == 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "oem_installed_apps_runtime_permission_enable") == 1;
        } catch (Settings.SettingNotFoundException e6) {
            e6.printStackTrace();
            return false;
        }
    }
}
