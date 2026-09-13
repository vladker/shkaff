package com.hjq.permissions;

import A3.AbstractC0157z;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.billingclient.api.v1;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.hjq.permissions.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0563p {
    public static boolean checkActivityStatus(@Nullable Activity activity, boolean z6) {
        if (activity == null) {
            if (z6) {
                throw new IllegalArgumentException("The instance of the context must be an activity object");
            }
            return false;
        }
        if (activity.isFinishing()) {
            if (z6) {
                throw new IllegalStateException("The activity has been finishing, please manually determine the status of the activity");
            }
            return false;
        }
        if (!activity.isDestroyed()) {
            return true;
        }
        if (z6) {
            throw new IllegalStateException("The activity has been destroyed, please manually determine the status of the activity");
        }
        return false;
    }

    public static void checkBodySensorsPermission(@NonNull List<String> list) {
        if (K.containsPermission(list, "android.permission.BODY_SENSORS_BACKGROUND")) {
            if (K.containsPermission(list, "android.permission.BODY_SENSORS_BACKGROUND") && !K.containsPermission(list, "android.permission.BODY_SENSORS")) {
                throw new IllegalArgumentException("Applying for background sensor permissions must contain android.permission.BODY_SENSORS");
            }
            for (String str : list) {
                if (K.equalsPermission(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    throw new IllegalArgumentException("Applying for permissions android.permission.BODY_SENSORS_BACKGROUND and android.permission.ACCESS_BACKGROUND_LOCATION at the same time is not supported");
                }
                if (K.equalsPermission(str, "android.permission.ACCESS_MEDIA_LOCATION")) {
                    throw new IllegalArgumentException("Applying for permissions android.permission.BODY_SENSORS_BACKGROUND and android.permission.ACCESS_MEDIA_LOCATION at the same time is not supported");
                }
            }
        }
    }

    public static void checkLocationPermission(@NonNull List<String> list) {
        if (K.containsPermission(list, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            if (K.containsPermission(list, "android.permission.ACCESS_COARSE_LOCATION") && !K.containsPermission(list, "android.permission.ACCESS_FINE_LOCATION")) {
                throw new IllegalArgumentException("Applying for background positioning permissions must include android.permission.ACCESS_FINE_LOCATION");
            }
            for (String str : list) {
                if (!K.equalsPermission(str, "android.permission.ACCESS_FINE_LOCATION") && !K.equalsPermission(str, "android.permission.ACCESS_COARSE_LOCATION") && !K.equalsPermission(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    throw new IllegalArgumentException("Because it includes background location permissions, do not apply for permissions unrelated to location");
                }
            }
        }
    }

    public static void checkManifestPermission(@NonNull List<C0550c> list, String str) {
        checkManifestPermission(list, str, Integer.MAX_VALUE);
    }

    public static void checkManifestPermissions(@NonNull Context context, @NonNull List<String> list, @Nullable C0553f c0553f) {
        if (c0553f == null) {
            return;
        }
        List<C0550c> list2 = c0553f.permissionInfoList;
        if (list2.isEmpty()) {
            throw new IllegalStateException("No permissions are registered in the AndroidManifest.xml file");
        }
        int i5 = context.getApplicationInfo().minSdkVersion;
        for (String str : list) {
            if (AbstractC0561n.isMustRegisterInManifestFile(str)) {
                checkManifestPermission(list2, str);
                if (K.equalsPermission(str, "android.permission.BODY_SENSORS_BACKGROUND")) {
                    checkManifestPermission(list2, "android.permission.BODY_SENSORS");
                } else if (K.equalsPermission(str, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    if (context.getApplicationInfo().targetSdkVersion >= 31) {
                        checkManifestPermission(list2, "android.permission.ACCESS_FINE_LOCATION", 30);
                        checkManifestPermission(list2, "android.permission.ACCESS_COARSE_LOCATION");
                    } else {
                        checkManifestPermission(list2, "android.permission.ACCESS_FINE_LOCATION");
                    }
                } else if (K.equalsPermission(str, "com.android.permission.GET_INSTALLED_APPS")) {
                    checkManifestPermission(list2, "android.permission.QUERY_ALL_PACKAGES");
                } else {
                    if (i5 >= AbstractC0561n.getPermissionFromAndroidVersion(str)) {
                        return;
                    }
                    if (K.equalsPermission(str, "android.permission.READ_MEDIA_IMAGES") || K.equalsPermission(str, "android.permission.READ_MEDIA_VIDEO") || K.equalsPermission(str, "android.permission.READ_MEDIA_AUDIO")) {
                        checkManifestPermission(list2, "android.permission.READ_EXTERNAL_STORAGE", 32);
                    } else if (K.equalsPermission(str, "android.permission.NEARBY_WIFI_DEVICES")) {
                        checkManifestPermission(list2, "android.permission.ACCESS_FINE_LOCATION", 32);
                    } else if (K.equalsPermission(str, "android.permission.BLUETOOTH_SCAN")) {
                        checkManifestPermission(list2, "android.permission.BLUETOOTH_ADMIN", 30);
                        checkManifestPermission(list2, "android.permission.ACCESS_FINE_LOCATION", 30);
                    } else if (K.equalsPermission(str, "android.permission.BLUETOOTH_CONNECT")) {
                        checkManifestPermission(list2, "android.permission.BLUETOOTH", 30);
                    } else if (K.equalsPermission(str, "android.permission.BLUETOOTH_ADVERTISE")) {
                        checkManifestPermission(list2, "android.permission.BLUETOOTH_ADMIN", 30);
                    } else if (K.equalsPermission(str, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                        checkManifestPermission(list2, "android.permission.READ_EXTERNAL_STORAGE", 29);
                        checkManifestPermission(list2, "android.permission.WRITE_EXTERNAL_STORAGE", 29);
                    } else if (K.equalsPermission(str, "android.permission.READ_PHONE_NUMBERS")) {
                        checkManifestPermission(list2, "android.permission.READ_PHONE_STATE", 25);
                    }
                }
            }
        }
    }

    public static void checkMediaLocationPermission(@NonNull Context context, @NonNull List<String> list) {
        if (K.containsPermission(list, "android.permission.ACCESS_MEDIA_LOCATION")) {
            for (String str : list) {
                if (!K.equalsPermission(str, "android.permission.ACCESS_MEDIA_LOCATION") && !K.equalsPermission(str, "android.permission.READ_MEDIA_IMAGES") && !K.equalsPermission(str, "android.permission.READ_MEDIA_VIDEO") && !K.equalsPermission(str, "android.permission.READ_EXTERNAL_STORAGE") && !K.equalsPermission(str, "android.permission.WRITE_EXTERNAL_STORAGE") && !K.equalsPermission(str, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    throw new IllegalArgumentException("Because it includes access media location permissions, do not apply for permissions unrelated to access media location");
                }
            }
            if (context.getApplicationInfo().targetSdkVersion < 33) {
                if (!K.containsPermission(list, "android.permission.READ_EXTERNAL_STORAGE") && !K.containsPermission(list, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    throw new IllegalArgumentException("You must add android.permission.READ_EXTERNAL_STORAGE or android.permission.MANAGE_EXTERNAL_STORAGE rights to apply for android.permission.ACCESS_MEDIA_LOCATION rights");
                }
            } else if (!K.containsPermission(list, "android.permission.READ_MEDIA_IMAGES") && !K.containsPermission(list, "android.permission.READ_MEDIA_VIDEO") && !K.containsPermission(list, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                throw new IllegalArgumentException("You must add android.permission.READ_MEDIA_IMAGES or android.permission.READ_MEDIA_VIDEO or android.permission.MANAGE_EXTERNAL_STORAGE rights to apply for android.permission.ACCESS_MEDIA_LOCATION rights");
            }
        }
    }

    public static void checkNearbyDevicesPermission(@NonNull List<String> list, @Nullable C0553f c0553f) {
        if ((!K.containsPermission(list, "android.permission.BLUETOOTH_SCAN") && !K.containsPermission(list, "android.permission.NEARBY_WIFI_DEVICES")) || K.containsPermission(list, "android.permission.ACCESS_FINE_LOCATION") || c0553f == null) {
            return;
        }
        for (C0550c c0550c : c0553f.permissionInfoList) {
            if (K.equalsPermission(c0550c.f3549a, "android.permission.BLUETOOTH_SCAN") || K.equalsPermission(c0550c.f3549a, "android.permission.NEARBY_WIFI_DEVICES")) {
                if ((c0550c.c & C0550c.d) == 0) {
                    String strL = c0550c.b != Integer.MAX_VALUE ? AbstractC0157z.l("\" ", c0550c.b, new StringBuilder("android:maxSdkVersion=\"")) : "";
                    StringBuilder sb = new StringBuilder("If your app doesn't use ");
                    sb.append(c0550c.f3549a);
                    sb.append(" to get physical location, please change the <uses-permission android:name=\"");
                    androidx.collection.a.y(sb, c0550c.f3549a, "\" ", strL, "/> node in the manifest file to <uses-permission android:name=\"");
                    androidx.collection.a.y(sb, c0550c.f3549a, "\" android:usesPermissionFlags=\"neverForLocation\" ", strL, "/> node, if your app need use ");
                    throw new IllegalArgumentException(AbstractC0157z.s(sb, c0550c.f3549a, " to get physical location, also need to add android.permission.ACCESS_FINE_LOCATION permissions"));
                }
            }
        }
    }

    public static void checkNotificationListenerPermission(@NonNull List<String> list, @Nullable C0553f c0553f) {
        if (K.containsPermission(list, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") && c0553f != null) {
            List<C0551d> list2 = c0553f.serviceInfoList;
            for (int i5 = 0; i5 < list2.size(); i5++) {
                if (TextUtils.equals(list2.get(i5).b, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE")) {
                    return;
                }
            }
            throw new IllegalArgumentException("No service registered permission attribute, please register <service android:permission=\"android.permission.BIND_NOTIFICATION_LISTENER_SERVICE\" > in AndroidManifest.xml");
        }
    }

    public static boolean checkPermissionArgument(@Nullable List<String> list, boolean z6) {
        if (list == null || list.isEmpty()) {
            if (z6) {
                throw new IllegalArgumentException("The requested permission cannot be empty");
            }
            return false;
        }
        if (Build.VERSION.SDK_INT <= 33 && z6) {
            ArrayList arrayList = new ArrayList();
            Field[] declaredFields = AbstractC0561n.class.getDeclaredFields();
            if (declaredFields.length == 0) {
                return true;
            }
            for (Field field : declaredFields) {
                if (String.class.equals(field.getType())) {
                    try {
                        arrayList.add((String) field.get(null));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            for (String str : list) {
                if (!K.containsPermission(arrayList, str)) {
                    throw new IllegalArgumentException(AbstractC0157z.o("The ", str, " is not a dangerous permission or special permission, please do not request dynamically"));
                }
            }
        }
        return true;
    }

    public static void checkPictureInPicturePermission(@NonNull Activity activity, @NonNull List<String> list, @Nullable C0553f c0553f) {
        if (K.containsPermission(list, "android.permission.PICTURE_IN_PICTURE") && c0553f != null) {
            List<C0548a> list2 = c0553f.activityInfoList;
            for (int i5 = 0; i5 < list2.size(); i5++) {
                if (list2.get(i5).f3547a) {
                    return;
                }
            }
            throw new IllegalArgumentException(AbstractC0157z.o("No activity registered supportsPictureInPicture attribute, please register \n<activity android:name=\"", activity.getClass().getName().replace(activity.getPackageName(), ""), "\" android:supportsPictureInPicture=\"true\" > in AndroidManifest.xml"));
        }
    }

    public static void checkReadMediaVisualUserSelectedPermission(@NonNull List<String> list) {
        if (K.containsPermission(list, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") && !K.containsPermission(list, "android.permission.READ_MEDIA_IMAGES") && !K.containsPermission(list, "android.permission.READ_MEDIA_VIDEO")) {
            throw new IllegalArgumentException("You cannot request the android.permission.READ_MEDIA_VISUAL_USER_SELECTED permission alone. must add either android.permission.READ_MEDIA_IMAGES or android.permission.READ_MEDIA_VIDEO permission, or maybe both");
        }
    }

    public static void checkStoragePermission(@NonNull Context context, @NonNull List<String> list, @Nullable C0553f c0553f) {
        C0549b c0549b;
        if (K.containsPermission(list, "android.permission.READ_MEDIA_IMAGES") || K.containsPermission(list, "android.permission.READ_MEDIA_VIDEO") || K.containsPermission(list, "android.permission.READ_MEDIA_AUDIO") || K.containsPermission(list, "android.permission.MANAGE_EXTERNAL_STORAGE") || K.containsPermission(list, "android.permission.READ_EXTERNAL_STORAGE") || K.containsPermission(list, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (context.getApplicationInfo().targetSdkVersion >= 33 && K.containsPermission(list, "android.permission.READ_EXTERNAL_STORAGE")) {
                throw new IllegalArgumentException("When targetSdkVersion >= 33 should use android.permission.READ_MEDIA_IMAGES, android.permission.READ_MEDIA_VIDEO, android.permission.READ_MEDIA_AUDIO instead of android.permission.READ_EXTERNAL_STORAGE");
            }
            if (K.containsPermission(list, "android.permission.READ_MEDIA_IMAGES") || K.containsPermission(list, "android.permission.READ_MEDIA_VIDEO") || K.containsPermission(list, "android.permission.READ_MEDIA_AUDIO")) {
                if (K.containsPermission(list, "android.permission.READ_EXTERNAL_STORAGE")) {
                    throw new IllegalArgumentException("If you have applied for media permissions, do not apply for the READ_EXTERNAL_STORAGE and WRITE_EXTERNAL_STORAGE permissions");
                }
                if (K.containsPermission(list, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    throw new IllegalArgumentException("Because the MANAGE_EXTERNAL_STORAGE permission range is very large, you can read media files with it, and there is no need to apply for additional media permissions.");
                }
                return;
            }
            if (K.containsPermission(list, "android.permission.MANAGE_EXTERNAL_STORAGE") && (K.containsPermission(list, "android.permission.READ_EXTERNAL_STORAGE") || K.containsPermission(list, "android.permission.WRITE_EXTERNAL_STORAGE"))) {
                throw new IllegalArgumentException("If you have applied for MANAGE_EXTERNAL_STORAGE permissions, do not apply for the READ_EXTERNAL_STORAGE and WRITE_EXTERNAL_STORAGE permissions");
            }
            if (K.containsPermission(list, "android.permission.ACCESS_MEDIA_LOCATION") || c0553f == null || (c0549b = c0553f.applicationInfo) == null) {
                return;
            }
            boolean zIsScopedStorage = K.isScopedStorage(context);
            int i5 = context.getApplicationInfo().targetSdkVersion;
            boolean z6 = c0549b.f3548a;
            if (i5 >= 29 && !z6 && (K.containsPermission(list, "android.permission.MANAGE_EXTERNAL_STORAGE") || !zIsScopedStorage)) {
                throw new IllegalStateException("Please register the android:requestLegacyExternalStorage=\"true\" attribute in the AndroidManifest.xml file, otherwise it will cause incompatibility with the old version");
            }
            if (i5 >= 30 && !K.containsPermission(list, "android.permission.MANAGE_EXTERNAL_STORAGE") && !zIsScopedStorage) {
                throw new IllegalArgumentException("The storage permission application is abnormal. If you have adapted the scope storage, please register the <meta-data android:name=\"ScopedStorage\" android:value=\"true\" /> attribute in the AndroidManifest.xml file. If there is no adaptation scope storage, please use android.permission.MANAGE_EXTERNAL_STORAGE to apply for permission");
            }
        }
    }

    public static void checkTargetSdkVersion(@NonNull Context context, @NonNull List<String> list) {
        for (String str : list) {
            int permissionFromAndroidVersion = K.equalsPermission(str, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") ? 33 : K.equalsPermission(str, "android.permission.BLUETOOTH_SCAN") ? 23 : AbstractC0561n.getPermissionFromAndroidVersion(str);
            if (context.getApplicationInfo().targetSdkVersion < permissionFromAndroidVersion) {
                throw new IllegalStateException("Request " + str + " permission, The targetSdkVersion SDK must be " + permissionFromAndroidVersion + " or more, if you do not want to upgrade targetSdkVersion, please apply with the old permission");
            }
        }
    }

    public static void optimizeDeprecatedPermission(@NonNull List<String> list) {
        if (!v1.e()) {
            if (K.containsPermission(list, "android.permission.POST_NOTIFICATIONS") && !K.containsPermission(list, "android.permission.NOTIFICATION_SERVICE")) {
                list.add("android.permission.NOTIFICATION_SERVICE");
            }
            if (K.containsPermission(list, "android.permission.NEARBY_WIFI_DEVICES") && !K.containsPermission(list, "android.permission.ACCESS_FINE_LOCATION")) {
                list.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if ((K.containsPermission(list, "android.permission.READ_MEDIA_IMAGES") || K.containsPermission(list, "android.permission.READ_MEDIA_VIDEO") || K.containsPermission(list, "android.permission.READ_MEDIA_AUDIO")) && !K.containsPermission(list, "android.permission.READ_EXTERNAL_STORAGE")) {
                list.add("android.permission.READ_EXTERNAL_STORAGE");
            }
        }
        if (Build.VERSION.SDK_INT < 31 && K.containsPermission(list, "android.permission.BLUETOOTH_SCAN") && !K.containsPermission(list, "android.permission.ACCESS_FINE_LOCATION")) {
            list.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if (K.containsPermission(list, "android.permission.MANAGE_EXTERNAL_STORAGE") && !v1.d()) {
            if (!K.containsPermission(list, "android.permission.READ_EXTERNAL_STORAGE")) {
                list.add("android.permission.READ_EXTERNAL_STORAGE");
            }
            if (!K.containsPermission(list, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                list.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
        }
        if (v1.c() || !K.containsPermission(list, "android.permission.ACTIVITY_RECOGNITION") || K.containsPermission(list, "android.permission.BODY_SENSORS")) {
            return;
        }
        list.add("android.permission.BODY_SENSORS");
    }

    public static void checkManifestPermission(@NonNull List<C0550c> list, String str, int i5) {
        C0550c next;
        Iterator<C0550c> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!TextUtils.equals(next.f3549a, str));
        if (next == null) {
            throw new IllegalStateException(AbstractC0157z.o("Please register permissions in the AndroidManifest.xml file <uses-permission android:name=\"", str, "\" />"));
        }
        int i6 = next.b;
        if (i6 < i5) {
            StringBuilder sb = new StringBuilder("The AndroidManifest.xml file <uses-permission android:name=\"");
            sb.append(str);
            sb.append("\" android:maxSdkVersion=\"");
            sb.append(i6);
            sb.append("\" /> does not meet the requirements, ");
            sb.append(i5 != Integer.MAX_VALUE ? AbstractC0157z.k(i5, "the minimum requirement for maxSdkVersion is ") : androidx.collection.a.i(i6, "please delete the android:maxSdkVersion=\"", "\" attribute"));
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
