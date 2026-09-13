package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.android.billingclient.api.v1;

/* JADX INFO: renamed from: com.hjq.permissions.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0567t extends AbstractC0566s {
    @Override // com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.SYSTEM_ALERT_WINDOW")) {
            return T.getPermissionIntent(context);
        }
        if (K.equalsPermission(str, "com.android.permission.GET_INSTALLED_APPS")) {
            return AbstractC0555h.getPermissionIntent(context);
        }
        if (K.equalsPermission(str, "android.permission.NOTIFICATION_SERVICE")) {
            return AbstractC0557j.getPermissionIntent(context);
        }
        return (v1.e() || !K.equalsPermission(str, "android.permission.POST_NOTIFICATIONS")) ? super.getPermissionIntent(context, str) : AbstractC0557j.getPermissionIntent(context);
    }

    @Override // com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.SYSTEM_ALERT_WINDOW")) {
            return false;
        }
        if (K.equalsPermission(str, "com.android.permission.GET_INSTALLED_APPS")) {
            return AbstractC0555h.isDoNotAskAgainPermission(activity);
        }
        if (K.equalsPermission(str, "android.permission.NOTIFICATION_SERVICE")) {
            return false;
        }
        if (v1.e() || !K.equalsPermission(str, "android.permission.POST_NOTIFICATIONS")) {
            return super.isDoNotAskAgainPermission(activity, str);
        }
        return false;
    }

    @Override // com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.SYSTEM_ALERT_WINDOW")) {
            return T.isGrantedPermission(context);
        }
        if (K.equalsPermission(str, "com.android.permission.GET_INSTALLED_APPS")) {
            return AbstractC0555h.isGrantedPermission(context);
        }
        if (K.equalsPermission(str, "android.permission.NOTIFICATION_SERVICE")) {
            return AbstractC0557j.isGrantedPermission(context);
        }
        return (v1.e() || !K.equalsPermission(str, "android.permission.POST_NOTIFICATIONS")) ? super.isGrantedPermission(context, str) : AbstractC0557j.isGrantedPermission(context);
    }
}
