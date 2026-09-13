package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.hjq.permissions.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0566s extends AbstractC0565r {
    @Override // com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        return K.equalsPermission(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") ? AbstractC0556i.getPermissionIntent(context) : super.getPermissionIntent(context, str);
    }

    @Override // com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE")) {
            return false;
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }

    @Override // com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        return K.equalsPermission(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") ? AbstractC0556i.isGrantedPermission(context) : super.isGrantedPermission(context, str);
    }
}
