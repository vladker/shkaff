package com.hjq.permissions;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.billingclient.api.v1;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: renamed from: com.hjq.permissions.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0556i {
    public static Intent getPermissionIntent(@NonNull Context context) {
        C0551d c0551d;
        Intent intent = null;
        if (v1.d()) {
            C0553f androidManifestInfo = K.getAndroidManifestInfo(context);
            if (androidManifestInfo == null) {
                c0551d = null;
                break;
            }
            c0551d = null;
            for (C0551d c0551d2 : androidManifestInfo.serviceInfoList) {
                if (TextUtils.equals(c0551d2.b, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE")) {
                    if (c0551d != null) {
                        c0551d = null;
                        break;
                    }
                    c0551d = c0551d2;
                }
            }
            if (c0551d != null) {
                Intent intent2 = new Intent("android.settings.NOTIFICATION_LISTENER_DETAIL_SETTINGS");
                intent2.putExtra("android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME", new ComponentName(context, c0551d.f3550a).flattenToString());
                if (K.areActivityIntent(context, intent2)) {
                    intent = intent2;
                }
            }
        }
        if (intent == null) {
            intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
        }
        return !K.areActivityIntent(context, intent) ? I.getApplicationDetailsIntent(context) : intent;
    }

    public static boolean isGrantedPermission(@NonNull Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        for (String str : string.split(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
            if (componentNameUnflattenFromString != null && TextUtils.equals(componentNameUnflattenFromString.getPackageName(), context.getPackageName())) {
                try {
                    Class.forName(componentNameUnflattenFromString.getClassName());
                    return true;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
