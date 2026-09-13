package com.hjq.permissions;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class A extends z {
    private static Intent getAlarmPermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
        intent.setData(K.getPackageNameUri(context));
        return !K.areActivityIntent(context, intent) ? I.getApplicationDetailsIntent(context) : intent;
    }

    private static boolean isGrantedAlarmPermission(@NonNull Context context) {
        return ((AlarmManager) context.getSystemService(AlarmManager.class)).canScheduleExactAlarms();
    }

    @Override // com.hjq.permissions.z, com.hjq.permissions.w, com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        return K.equalsPermission(str, "android.permission.SCHEDULE_EXACT_ALARM") ? getAlarmPermissionIntent(context) : super.getPermissionIntent(context, str);
    }

    @Override // com.hjq.permissions.z, com.hjq.permissions.y, com.hjq.permissions.x, com.hjq.permissions.w, com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.SCHEDULE_EXACT_ALARM")) {
            return false;
        }
        if (K.equalsPermission(str, "android.permission.BLUETOOTH_SCAN") || K.equalsPermission(str, "android.permission.BLUETOOTH_CONNECT") || K.equalsPermission(str, "android.permission.BLUETOOTH_ADVERTISE")) {
            return (K.checkSelfPermission(activity, str) || K.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        if (activity.getApplicationInfo().targetSdkVersion < 31 || !K.equalsPermission(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            return super.isDoNotAskAgainPermission(activity, str);
        }
        if (K.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") || K.checkSelfPermission(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
            return (K.checkSelfPermission(activity, str) || K.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        return (K.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION") || K.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_COARSE_LOCATION")) ? false : true;
    }

    @Override // com.hjq.permissions.z, com.hjq.permissions.y, com.hjq.permissions.x, com.hjq.permissions.w, com.hjq.permissions.AbstractC0569v, com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.SCHEDULE_EXACT_ALARM")) {
            return isGrantedAlarmPermission(context);
        }
        return (K.equalsPermission(str, "android.permission.BLUETOOTH_SCAN") || K.equalsPermission(str, "android.permission.BLUETOOTH_CONNECT") || K.equalsPermission(str, "android.permission.BLUETOOTH_ADVERTISE")) ? K.checkSelfPermission(context, str) : super.isGrantedPermission(context, str);
    }
}
