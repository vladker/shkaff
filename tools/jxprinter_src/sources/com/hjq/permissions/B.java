package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class B extends A {
    @Override // com.hjq.permissions.A, com.hjq.permissions.z, com.hjq.permissions.w, com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        return K.equalsPermission(str, "android.permission.POST_NOTIFICATIONS") ? AbstractC0557j.getPermissionIntent(context) : super.getPermissionIntent(context, str);
    }

    @Override // com.hjq.permissions.A, com.hjq.permissions.z, com.hjq.permissions.y, com.hjq.permissions.x, com.hjq.permissions.w, com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
            if (K.checkSelfPermission(activity, "android.permission.BODY_SENSORS")) {
                return (K.checkSelfPermission(activity, str) || K.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return !K.shouldShowRequestPermissionRationale(activity, "android.permission.BODY_SENSORS");
        }
        if (K.equalsPermission(str, "android.permission.POST_NOTIFICATIONS") || K.equalsPermission(str, "android.permission.NEARBY_WIFI_DEVICES") || K.equalsPermission(str, "android.permission.READ_MEDIA_IMAGES") || K.equalsPermission(str, "android.permission.READ_MEDIA_VIDEO") || K.equalsPermission(str, "android.permission.READ_MEDIA_AUDIO")) {
            return (K.checkSelfPermission(activity, str) || K.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        if (activity.getApplicationInfo().targetSdkVersion >= 33) {
            if (K.equalsPermission(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return false;
            }
            if (K.equalsPermission(str, "android.permission.READ_EXTERNAL_STORAGE")) {
                return (K.checkSelfPermission(activity, "android.permission.READ_MEDIA_IMAGES") || K.shouldShowRequestPermissionRationale(activity, "android.permission.READ_MEDIA_IMAGES") || K.checkSelfPermission(activity, "android.permission.READ_MEDIA_VIDEO") || K.shouldShowRequestPermissionRationale(activity, "android.permission.READ_MEDIA_VIDEO") || K.checkSelfPermission(activity, "android.permission.READ_MEDIA_AUDIO") || K.shouldShowRequestPermissionRationale(activity, "android.permission.READ_MEDIA_AUDIO")) ? false : true;
            }
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }

    @Override // com.hjq.permissions.A, com.hjq.permissions.z, com.hjq.permissions.y, com.hjq.permissions.x, com.hjq.permissions.w, com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
            return K.checkSelfPermission(context, "android.permission.BODY_SENSORS") && K.checkSelfPermission(context, "android.permission.BODY_SENSORS_BACKGROUND");
        }
        if (K.equalsPermission(str, "android.permission.POST_NOTIFICATIONS") || K.equalsPermission(str, "android.permission.NEARBY_WIFI_DEVICES") || K.equalsPermission(str, "android.permission.READ_MEDIA_IMAGES") || K.equalsPermission(str, "android.permission.READ_MEDIA_VIDEO") || K.equalsPermission(str, "android.permission.READ_MEDIA_AUDIO")) {
            return K.checkSelfPermission(context, str);
        }
        if (context.getApplicationInfo().targetSdkVersion >= 33) {
            if (K.equalsPermission(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return true;
            }
            if (K.equalsPermission(str, "android.permission.READ_EXTERNAL_STORAGE")) {
                return K.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") && K.checkSelfPermission(context, "android.permission.READ_MEDIA_VIDEO") && K.checkSelfPermission(context, "android.permission.READ_MEDIA_AUDIO");
            }
        }
        return super.isGrantedPermission(context, str);
    }
}
