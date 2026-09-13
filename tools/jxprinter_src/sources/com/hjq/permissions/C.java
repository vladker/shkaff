package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C extends B {
    @Override // com.hjq.permissions.B, com.hjq.permissions.A, com.hjq.permissions.z, com.hjq.permissions.y, com.hjq.permissions.x, com.hjq.permissions.w, com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED")) {
            return (K.checkSelfPermission(activity, str) || K.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }

    @Override // com.hjq.permissions.B, com.hjq.permissions.A, com.hjq.permissions.z, com.hjq.permissions.y, com.hjq.permissions.x, com.hjq.permissions.w, com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED")) {
            return K.checkSelfPermission(context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
        }
        if (!K.equalsPermission(str, "android.permission.READ_MEDIA_IMAGES") || K.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES")) {
            return (!K.equalsPermission(str, "android.permission.READ_MEDIA_VIDEO") || K.checkSelfPermission(context, "android.permission.READ_MEDIA_VIDEO")) ? super.isGrantedPermission(context, str) : K.checkSelfPermission(context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
        }
        return K.checkSelfPermission(context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
    }
}
