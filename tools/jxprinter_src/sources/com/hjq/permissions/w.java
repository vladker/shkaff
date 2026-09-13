package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class w extends AbstractC0569v {
    private static Intent getInstallPermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        intent.setData(K.getPackageNameUri(context));
        return !K.areActivityIntent(context, intent) ? I.getApplicationDetailsIntent(context) : intent;
    }

    private static Intent getPictureInPicturePermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS");
        intent.setData(K.getPackageNameUri(context));
        return !K.areActivityIntent(context, intent) ? I.getApplicationDetailsIntent(context) : intent;
    }

    private static boolean isGrantedInstallPermission(@NonNull Context context) {
        return context.getPackageManager().canRequestPackageInstalls();
    }

    private static boolean isGrantedPictureInPicturePermission(@NonNull Context context) {
        return K.checkOpNoThrow(context, "android:picture_in_picture");
    }

    @Override // com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.REQUEST_INSTALL_PACKAGES")) {
            return getInstallPermissionIntent(context);
        }
        return K.equalsPermission(str, "android.permission.PICTURE_IN_PICTURE") ? getPictureInPicturePermissionIntent(context) : super.getPermissionIntent(context, str);
    }

    @Override // com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.REQUEST_INSTALL_PACKAGES") || K.equalsPermission(str, "android.permission.PICTURE_IN_PICTURE")) {
            return false;
        }
        if (K.equalsPermission(str, "android.permission.READ_PHONE_NUMBERS") || K.equalsPermission(str, "android.permission.ANSWER_PHONE_CALLS")) {
            return (K.checkSelfPermission(activity, str) || K.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }

    @Override // com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.REQUEST_INSTALL_PACKAGES")) {
            return isGrantedInstallPermission(context);
        }
        if (K.equalsPermission(str, "android.permission.PICTURE_IN_PICTURE")) {
            return isGrantedPictureInPicturePermission(context);
        }
        return (K.equalsPermission(str, "android.permission.READ_PHONE_NUMBERS") || K.equalsPermission(str, "android.permission.ANSWER_PHONE_CALLS")) ? K.checkSelfPermission(context, str) : super.isGrantedPermission(context, str);
    }
}
