package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.hjq.permissions.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0564q {
    Intent getPermissionIntent(@NonNull Context context, @NonNull String str);

    boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str);

    boolean isGrantedPermission(@NonNull Context context, @NonNull String str);
}
