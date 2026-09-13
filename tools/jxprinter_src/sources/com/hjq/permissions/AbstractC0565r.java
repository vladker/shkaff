package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import androidx.annotation.NonNull;
import java.util.Collections;

/* JADX INFO: renamed from: com.hjq.permissions.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0565r implements InterfaceC0564q {
    private static Intent getVpnPermissionIntent(@NonNull Context context) {
        Intent intentPrepare = VpnService.prepare(context);
        return !K.areActivityIntent(context, intentPrepare) ? I.getApplicationDetailsIntent(context) : intentPrepare;
    }

    private static boolean isGrantedVpnPermission(@NonNull Context context) {
        return VpnService.prepare(context) == null;
    }

    @Override // com.hjq.permissions.InterfaceC0564q
    public Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        return K.equalsPermission(str, "android.permission.BIND_VPN_SERVICE") ? getVpnPermissionIntent(context) : I.getApplicationDetailsIntent(context, Collections.singletonList(str));
    }

    @Override // com.hjq.permissions.InterfaceC0564q
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        return false;
    }

    @Override // com.hjq.permissions.InterfaceC0564q
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.BIND_VPN_SERVICE")) {
            return isGrantedVpnPermission(context);
        }
        return true;
    }
}
