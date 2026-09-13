package com.hjq.permissions;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.hjq.permissions.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0561n {
    public static int getDangerPermissionFromAndroidVersion(@NonNull String str) {
        if (K.equalsPermission(str, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED")) {
            return 34;
        }
        if (K.equalsPermission(str, "android.permission.POST_NOTIFICATIONS") || K.equalsPermission(str, "android.permission.NEARBY_WIFI_DEVICES") || K.equalsPermission(str, "android.permission.BODY_SENSORS_BACKGROUND") || K.equalsPermission(str, "android.permission.READ_MEDIA_IMAGES") || K.equalsPermission(str, "android.permission.READ_MEDIA_VIDEO") || K.equalsPermission(str, "android.permission.READ_MEDIA_AUDIO")) {
            return 33;
        }
        if (K.equalsPermission(str, "android.permission.BLUETOOTH_SCAN") || K.equalsPermission(str, "android.permission.BLUETOOTH_CONNECT") || K.equalsPermission(str, "android.permission.BLUETOOTH_ADVERTISE")) {
            return 31;
        }
        if (K.equalsPermission(str, "android.permission.ACCESS_BACKGROUND_LOCATION") || K.equalsPermission(str, "android.permission.ACTIVITY_RECOGNITION") || K.equalsPermission(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
            return 29;
        }
        if (K.equalsPermission(str, "android.permission.ACCEPT_HANDOVER")) {
            return 28;
        }
        return (K.equalsPermission(str, "android.permission.ANSWER_PHONE_CALLS") || K.equalsPermission(str, "android.permission.READ_PHONE_NUMBERS")) ? 26 : 23;
    }

    public static int getPermissionFromAndroidVersion(@NonNull String str) {
        return isSpecialPermission(str) ? getSpecialPermissionFromAndroidVersion(str) : getDangerPermissionFromAndroidVersion(str);
    }

    public static int getSpecialPermissionFromAndroidVersion(@NonNull String str) {
        if (K.equalsPermission(str, "android.permission.SCHEDULE_EXACT_ALARM")) {
            return 31;
        }
        if (K.equalsPermission(str, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
            return 30;
        }
        if (K.equalsPermission(str, "android.permission.REQUEST_INSTALL_PACKAGES") || K.equalsPermission(str, "android.permission.PICTURE_IN_PICTURE")) {
            return 26;
        }
        if (K.equalsPermission(str, "android.permission.SYSTEM_ALERT_WINDOW") || K.equalsPermission(str, "android.permission.WRITE_SETTINGS") || K.equalsPermission(str, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") || K.equalsPermission(str, "android.permission.ACCESS_NOTIFICATION_POLICY")) {
            return 23;
        }
        if (K.equalsPermission(str, "android.permission.PACKAGE_USAGE_STATS")) {
            return 21;
        }
        if (K.equalsPermission(str, "android.permission.NOTIFICATION_SERVICE")) {
            return 19;
        }
        if (K.equalsPermission(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE")) {
            return 18;
        }
        K.equalsPermission(str, "android.permission.BIND_VPN_SERVICE");
        return 14;
    }

    public static boolean isMustRegisterInManifestFile(@NonNull String str) {
        return (K.equalsPermission(str, "android.permission.NOTIFICATION_SERVICE") || K.equalsPermission(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") || K.equalsPermission(str, "android.permission.BIND_VPN_SERVICE") || K.equalsPermission(str, "android.permission.PICTURE_IN_PICTURE")) ? false : true;
    }

    public static boolean isSpecialPermission(@NonNull String str) {
        return K.equalsPermission(str, "android.permission.MANAGE_EXTERNAL_STORAGE") || K.equalsPermission(str, "android.permission.REQUEST_INSTALL_PACKAGES") || K.equalsPermission(str, "android.permission.SYSTEM_ALERT_WINDOW") || K.equalsPermission(str, "android.permission.WRITE_SETTINGS") || K.equalsPermission(str, "android.permission.NOTIFICATION_SERVICE") || K.equalsPermission(str, "android.permission.PACKAGE_USAGE_STATS") || K.equalsPermission(str, "android.permission.SCHEDULE_EXACT_ALARM") || K.equalsPermission(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") || K.equalsPermission(str, "android.permission.ACCESS_NOTIFICATION_POLICY") || K.equalsPermission(str, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") || K.equalsPermission(str, "android.permission.BIND_VPN_SERVICE") || K.equalsPermission(str, "android.permission.PICTURE_IN_PICTURE");
    }
}
