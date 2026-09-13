package com.hjq.permissions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class I {
    @NonNull
    public static Intent getAndroidSettingAppIntent() {
        return new Intent("android.settings.SETTINGS");
    }

    @NonNull
    public static Intent getApplicationDetailsIntent(@NonNull Context context) {
        return getApplicationDetailsIntent(context, null);
    }

    @Nullable
    public static Intent getColorOsWindowPermissionPageIntent(Context context) {
        Intent intent = new Intent("com.oppo.safe.permission.PermissionTopActivity");
        Intent oppoSafeCenterAppIntent = getOppoSafeCenterAppIntent(context);
        if (!K.areActivityIntent(context, intent)) {
            intent = null;
        }
        return K.areActivityIntent(context, oppoSafeCenterAppIntent) ? S.addSubIntentToMainIntent(intent, oppoSafeCenterAppIntent) : intent;
    }

    @Nullable
    public static Intent getEmuiWindowPermissionPageIntent(Context context) throws Throwable {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        Intent intent2 = new Intent();
        intent2.setClassName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
        Intent huaWeiMobileManagerAppIntent = getHuaWeiMobileManagerAppIntent(context);
        String romVersionName = L.getRomVersionName();
        if (romVersionName == null) {
            romVersionName = "";
        }
        if (romVersionName.startsWith("3.0")) {
            if (!K.areActivityIntent(context, intent2)) {
                intent2 = null;
            }
            if (K.areActivityIntent(context, intent)) {
                intent2 = S.addSubIntentToMainIntent(intent2, intent);
            }
        } else {
            if (!K.areActivityIntent(context, intent)) {
                intent = null;
            }
            intent2 = K.areActivityIntent(context, intent2) ? S.addSubIntentToMainIntent(intent, intent2) : intent;
        }
        return K.areActivityIntent(context, huaWeiMobileManagerAppIntent) ? S.addSubIntentToMainIntent(intent2, huaWeiMobileManagerAppIntent) : intent2;
    }

    @Nullable
    public static Intent getHuaWeiMobileManagerAppIntent(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.huawei.systemmanager");
        if (K.areActivityIntent(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    @Nullable
    public static Intent getMiuiPermissionPageIntent(Context context) {
        Intent intentPutExtra = new Intent().setAction("miui.intent.action.APP_PERM_EDITOR").putExtra("extra_pkgname", context.getPackageName());
        Intent xiaoMiMobileManagerAppIntent = getXiaoMiMobileManagerAppIntent(context);
        if (!K.areActivityIntent(context, intentPutExtra)) {
            intentPutExtra = null;
        }
        return K.areActivityIntent(context, xiaoMiMobileManagerAppIntent) ? S.addSubIntentToMainIntent(intentPutExtra, xiaoMiMobileManagerAppIntent) : intentPutExtra;
    }

    @Nullable
    public static Intent getMiuiWindowPermissionPageIntent(Context context) {
        return getMiuiPermissionPageIntent(context);
    }

    @Nullable
    public static Intent getOneUiPermissionPageIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$AppOpsDetailsActivity");
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        intent.putExtra(":settings:show_fragment_args", bundle);
        intent.setData(K.getPackageNameUri(context));
        if (K.areActivityIntent(context, intent)) {
            return intent;
        }
        return null;
    }

    @Nullable
    public static Intent getOneUiWindowPermissionPageIntent(Context context) {
        return getOneUiPermissionPageIntent(context);
    }

    @Nullable
    public static Intent getOppoSafeCenterAppIntent(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.oppo.safe");
        if (K.areActivityIntent(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        Intent launchIntentForPackage2 = context.getPackageManager().getLaunchIntentForPackage("com.color.safecenter");
        if (K.areActivityIntent(context, launchIntentForPackage2)) {
            return launchIntentForPackage2;
        }
        Intent launchIntentForPackage3 = context.getPackageManager().getLaunchIntentForPackage("com.oplus.safecenter");
        if (K.areActivityIntent(context, launchIntentForPackage3)) {
            return launchIntentForPackage3;
        }
        return null;
    }

    @Nullable
    public static Intent getOriginOsPermissionPageIntent(Context context) {
        Intent intent = new Intent("permission.intent.action.softPermissionDetail");
        intent.putExtra("packagename", context.getPackageName());
        if (K.areActivityIntent(context, intent)) {
            return intent;
        }
        return null;
    }

    @Nullable
    public static Intent getOriginOsWindowPermissionPageIntent(Context context) {
        Intent vivoMobileManagerAppIntent = getVivoMobileManagerAppIntent(context);
        if (K.areActivityIntent(context, vivoMobileManagerAppIntent)) {
            return vivoMobileManagerAppIntent;
        }
        return null;
    }

    @Nullable
    public static Intent getVivoMobileManagerAppIntent(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.iqoo.secure");
        if (K.areActivityIntent(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    @Nullable
    public static Intent getXiaoMiMobileManagerAppIntent(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.miui.securitycenter");
        if (K.areActivityIntent(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    @NonNull
    public static Intent getApplicationDetailsIntent(@NonNull Context context, @Nullable List<String> list) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(K.getPackageNameUri(context));
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < 2; i5++) {
                if (!TextUtils.isEmpty(L.a(L.f3540l[i5]))) {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("permissionList", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
                    intent.putExtras(bundle);
                    intent.putExtra("isGetPermission", true);
                    break;
                }
            }
        }
        if (K.areActivityIntent(context, intent)) {
            return intent;
        }
        Intent intent2 = new Intent("android.settings.APPLICATION_SETTINGS");
        if (K.areActivityIntent(context, intent2)) {
            return intent2;
        }
        Intent intent3 = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
        return K.areActivityIntent(context, intent3) ? intent3 : getAndroidSettingAppIntent();
    }
}
