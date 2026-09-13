package com.hjq.permissions;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import androidx.annotation.NonNull;
import com.android.billingclient.api.v1;

/* JADX INFO: renamed from: com.hjq.permissions.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0569v extends AbstractC0568u {
    private static Intent getIgnoreBatteryPermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(K.getPackageNameUri(context));
        if (!K.areActivityIntent(context, intent)) {
            intent = new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
        }
        return !K.areActivityIntent(context, intent) ? I.getApplicationDetailsIntent(context) : intent;
    }

    private static Intent getNotDisturbPermissionIntent(@NonNull Context context) {
        Intent intent;
        if (v1.c()) {
            intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_DETAIL_SETTINGS");
            intent.setData(K.getPackageNameUri(context));
            if (L.b() || L.d(Build.BRAND.toLowerCase(), Build.MANUFACTURER.toLowerCase(), L.f3539k)) {
                intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
            }
        } else {
            intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
        }
        return !K.areActivityIntent(context, intent) ? I.getApplicationDetailsIntent(context) : intent;
    }

    private static Intent getSettingPermissionIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(K.getPackageNameUri(context));
        return !K.areActivityIntent(context, intent) ? I.getApplicationDetailsIntent(context) : intent;
    }

    private static boolean isGrantedIgnoreBatteryPermission(@NonNull Context context) {
        return ((PowerManager) context.getSystemService(PowerManager.class)).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    private static boolean isGrantedNotDisturbPermission(@NonNull Context context) {
        return ((NotificationManager) context.getSystemService(NotificationManager.class)).isNotificationPolicyAccessGranted();
    }

    private static boolean isGrantedSettingPermission(@NonNull Context context) {
        return Settings.System.canWrite(context);
    }

    @Override // com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        if (K.equalsPermission(str, "android.permission.WRITE_SETTINGS")) {
            return getSettingPermissionIntent(context);
        }
        if (K.equalsPermission(str, "android.permission.ACCESS_NOTIFICATION_POLICY")) {
            return getNotDisturbPermissionIntent(context);
        }
        return K.equalsPermission(str, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") ? getIgnoreBatteryPermissionIntent(context) : super.getPermissionIntent(context, str);
    }

    @Override // com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        if (AbstractC0561n.getPermissionFromAndroidVersion(str) > Build.VERSION.SDK_INT) {
            if (K.equalsPermission(str, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED")) {
                return false;
            }
            if (K.equalsPermission(str, "android.permission.POST_NOTIFICATIONS")) {
                return super.isDoNotAskAgainPermission(activity, str);
            }
            if (K.equalsPermission(str, "android.permission.NEARBY_WIFI_DEVICES")) {
                return (K.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") || K.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION")) ? false : true;
            }
            if (K.equalsPermission(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
                return (K.checkSelfPermission(activity, "android.permission.BODY_SENSORS") || K.shouldShowRequestPermissionRationale(activity, "android.permission.BODY_SENSORS")) ? false : true;
            }
            if (K.equalsPermission(str, "android.permission.READ_MEDIA_IMAGES") || K.equalsPermission(str, "android.permission.READ_MEDIA_VIDEO") || K.equalsPermission(str, "android.permission.READ_MEDIA_AUDIO")) {
                return (K.checkSelfPermission(activity, "android.permission.READ_EXTERNAL_STORAGE") || K.shouldShowRequestPermissionRationale(activity, "android.permission.READ_EXTERNAL_STORAGE")) ? false : true;
            }
            if (K.equalsPermission(str, "android.permission.BLUETOOTH_SCAN")) {
                return (K.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") || K.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION")) ? false : true;
            }
            if (!K.equalsPermission(str, "android.permission.BLUETOOTH_CONNECT") && !K.equalsPermission(str, "android.permission.BLUETOOTH_ADVERTISE")) {
                if (K.equalsPermission(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    return (K.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") || K.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION")) ? false : true;
                }
                if (K.equalsPermission(str, "android.permission.ACTIVITY_RECOGNITION")) {
                    return false;
                }
                if (K.equalsPermission(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
                    return (K.checkSelfPermission(activity, "android.permission.READ_EXTERNAL_STORAGE") || K.shouldShowRequestPermissionRationale(activity, "android.permission.READ_EXTERNAL_STORAGE")) ? false : true;
                }
                if (K.equalsPermission(str, "android.permission.ACCEPT_HANDOVER") || K.equalsPermission(str, "android.permission.ANSWER_PHONE_CALLS")) {
                    return false;
                }
                if (K.equalsPermission(str, "android.permission.READ_PHONE_NUMBERS")) {
                    if (!K.checkSelfPermission(activity, "android.permission.READ_PHONE_STATE") && !K.shouldShowRequestPermissionRationale(activity, "android.permission.READ_PHONE_STATE")) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (K.equalsPermission(str, "com.android.permission.GET_INSTALLED_APPS") || K.equalsPermission(str, "android.permission.POST_NOTIFICATIONS")) {
            return super.isDoNotAskAgainPermission(activity, str);
        }
        return (AbstractC0561n.isSpecialPermission(str) || K.checkSelfPermission(activity, str) || K.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
    }

    @Override // com.hjq.permissions.AbstractC0568u, com.hjq.permissions.AbstractC0567t, com.hjq.permissions.AbstractC0566s, com.hjq.permissions.AbstractC0565r, com.hjq.permissions.InterfaceC0564q
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (AbstractC0561n.getPermissionFromAndroidVersion(str) > Build.VERSION.SDK_INT) {
            if (K.equalsPermission(str, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED")) {
                return true;
            }
            if (K.equalsPermission(str, "android.permission.POST_NOTIFICATIONS")) {
                return super.isGrantedPermission(context, str);
            }
            if (K.equalsPermission(str, "android.permission.NEARBY_WIFI_DEVICES")) {
                return K.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION");
            }
            if (K.equalsPermission(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
                return K.checkSelfPermission(context, "android.permission.BODY_SENSORS");
            }
            if (K.equalsPermission(str, "android.permission.READ_MEDIA_IMAGES") || K.equalsPermission(str, "android.permission.READ_MEDIA_VIDEO") || K.equalsPermission(str, "android.permission.READ_MEDIA_AUDIO")) {
                return K.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE");
            }
            if (K.equalsPermission(str, "android.permission.BLUETOOTH_SCAN")) {
                return K.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION");
            }
            if (K.equalsPermission(str, "android.permission.BLUETOOTH_CONNECT") || K.equalsPermission(str, "android.permission.BLUETOOTH_ADVERTISE")) {
                return true;
            }
            if (K.equalsPermission(str, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                return K.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") && K.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (K.equalsPermission(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                return K.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION");
            }
            if (K.equalsPermission(str, "android.permission.ACTIVITY_RECOGNITION")) {
                return true;
            }
            if (K.equalsPermission(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
                return K.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE");
            }
            if (K.equalsPermission(str, "android.permission.ACCEPT_HANDOVER") || K.equalsPermission(str, "android.permission.ANSWER_PHONE_CALLS")) {
                return true;
            }
            if (K.equalsPermission(str, "android.permission.READ_PHONE_NUMBERS")) {
                return K.checkSelfPermission(context, "android.permission.READ_PHONE_STATE");
            }
        }
        if (K.equalsPermission(str, "com.android.permission.GET_INSTALLED_APPS") || K.equalsPermission(str, "android.permission.POST_NOTIFICATIONS")) {
            return super.isGrantedPermission(context, str);
        }
        if (!AbstractC0561n.isSpecialPermission(str)) {
            return K.checkSelfPermission(context, str);
        }
        if (K.equalsPermission(str, "android.permission.WRITE_SETTINGS")) {
            return isGrantedSettingPermission(context);
        }
        if (K.equalsPermission(str, "android.permission.ACCESS_NOTIFICATION_POLICY")) {
            return isGrantedNotDisturbPermission(context);
        }
        return K.equalsPermission(str, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") ? isGrantedIgnoreBatteryPermission(context) : super.isGrantedPermission(context, str);
    }
}
