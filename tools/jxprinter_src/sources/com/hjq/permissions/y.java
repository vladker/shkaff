package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import com.android.billingclient.api.v1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class y extends x {
    private boolean hasReadStoragePermission(@NonNull Context context) {
        if (v1.e() && context.getApplicationInfo().targetSdkVersion >= 33) {
            return K.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") || isGrantedPermission(context, "android.permission.MANAGE_EXTERNAL_STORAGE");
        }
        if (!v1.d() || context.getApplicationInfo().targetSdkVersion < 30) {
            return K.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE");
        }
        return K.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") || isGrantedPermission(context, "android.permission.MANAGE_EXTERNAL_STORAGE");
    }

    @Override // com.hjq.permissions.x, com.hjq.permissions.w, com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            if (K.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION")) {
                return (K.checkSelfPermission(activity, str) || K.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return !K.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION");
        }
        if (K.equalsPermission(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
            return (!hasReadStoragePermission(activity) || K.checkSelfPermission(activity, str) || K.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        if (K.equalsPermission(str, "android.permission.ACTIVITY_RECOGNITION")) {
            return (K.checkSelfPermission(activity, str) || K.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        if (v1.d() || !K.equalsPermission(str, "android.permission.MANAGE_EXTERNAL_STORAGE") || Environment.isExternalStorageLegacy()) {
            return super.isDoNotAskAgainPermission(activity, str);
        }
        return true;
    }

    @Override // com.hjq.permissions.x, com.hjq.permissions.w, com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
            return hasReadStoragePermission(context) && K.checkSelfPermission(context, "android.permission.ACCESS_MEDIA_LOCATION");
        }
        if (K.equalsPermission(str, "android.permission.ACCESS_BACKGROUND_LOCATION") || K.equalsPermission(str, "android.permission.ACTIVITY_RECOGNITION")) {
            return K.checkSelfPermission(context, str);
        }
        if (v1.d() || !K.equalsPermission(str, "android.permission.MANAGE_EXTERNAL_STORAGE") || Environment.isExternalStorageLegacy()) {
            return super.isGrantedPermission(context, str);
        }
        return false;
    }
}
