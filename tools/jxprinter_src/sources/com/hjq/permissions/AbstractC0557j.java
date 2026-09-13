package com.hjq.permissions;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.hjq.permissions.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0557j {
    public static Intent getPermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        return !K.areActivityIntent(context, intent) ? I.getApplicationDetailsIntent(context) : intent;
    }

    public static boolean isGrantedPermission(@NonNull Context context) {
        return ((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled();
    }
}
