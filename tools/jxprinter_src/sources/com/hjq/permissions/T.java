package com.hjq.permissions;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import androidx.annotation.NonNull;
import com.android.billingclient.api.v1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class T {
    public static Intent getPermissionIntent(@NonNull Context context) {
        if (v1.d() && L.c() && L.isMiuiOptimization()) {
            return S.addSubIntentToMainIntent(I.getMiuiPermissionPageIntent(context), I.getApplicationDetailsIntent(context));
        }
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(K.getPackageNameUri(context));
        return K.areActivityIntent(context, intent) ? intent : I.getApplicationDetailsIntent(context);
    }

    public static boolean isGrantedPermission(@NonNull Context context) {
        return Settings.canDrawOverlays(context);
    }
}
