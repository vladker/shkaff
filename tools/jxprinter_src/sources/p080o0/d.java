package p080o0;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.a;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6435a;

    @Nullable
    private Activity activity;
    public HashMap b;

    @NonNull
    private final Context context;

    @Nullable
    private c successCallback;

    public d(@NonNull Context context) {
        this.context = context;
    }

    public final int a(int i5) {
        if (i5 == 17) {
            if (Build.VERSION.SDK_INT < 33) {
                if (!NotificationManagerCompat.from(this.context).areNotificationsEnabled()) {
                    return 0;
                }
            } else if (this.context.checkSelfPermission("android.permission.POST_NOTIFICATIONS") != 0) {
                return e.determineDeniedVariant(this.activity, "android.permission.POST_NOTIFICATIONS");
            }
            return 1;
        }
        if (i5 == 21) {
            List<String> manifestNames = e.getManifestNames(this.context, 21);
            if (manifestNames != null && !manifestNames.isEmpty()) {
                return 1;
            }
            Log.d("permissions_handler", "Bluetooth permission missing in manifest");
            return 0;
        }
        if ((i5 == 30 || i5 == 28 || i5 == 29) && Build.VERSION.SDK_INT < 31) {
            List<String> manifestNames2 = e.getManifestNames(this.context, 21);
            if (manifestNames2 != null && !manifestNames2.isEmpty()) {
                return 1;
            }
            Log.d("permissions_handler", "Bluetooth permission missing in manifest");
            return 0;
        }
        if ((i5 != 37 && i5 != 0) || b()) {
            List<String> manifestNames3 = e.getManifestNames(this.context, i5);
            if (manifestNames3 == null) {
                a.v(i5, "No android specific permissions needed for: ", "permissions_handler");
                return 1;
            }
            if (manifestNames3.size() != 0) {
                if (this.context.getApplicationInfo().targetSdkVersion >= 23) {
                    HashSet hashSet = new HashSet();
                    for (String str : manifestNames3) {
                        if (i5 == 16) {
                            String packageName = this.context.getPackageName();
                            PowerManager powerManager = (PowerManager) this.context.getSystemService("power");
                            if (powerManager == null || !powerManager.isIgnoringBatteryOptimizations(packageName)) {
                                hashSet.add(0);
                            } else {
                                hashSet.add(1);
                            }
                        } else if (i5 == 22) {
                            if (Build.VERSION.SDK_INT < 30) {
                                hashSet.add(2);
                            }
                            hashSet.add(Integer.valueOf(Environment.isExternalStorageManager() ? 1 : 0));
                        } else if (i5 == 23) {
                            hashSet.add(Integer.valueOf(Settings.canDrawOverlays(this.context) ? 1 : 0));
                        } else if (i5 == 24) {
                            hashSet.add(Integer.valueOf(this.context.getPackageManager().canRequestPackageInstalls() ? 1 : 0));
                        } else if (i5 == 27) {
                            hashSet.add(Integer.valueOf(((NotificationManager) this.context.getSystemService("notification")).isNotificationPolicyAccessGranted() ? 1 : 0));
                        } else if (i5 == 34) {
                            if (Build.VERSION.SDK_INT >= 31) {
                                hashSet.add(Integer.valueOf(((AlarmManager) this.context.getSystemService(NotificationCompat.CATEGORY_ALARM)).canScheduleExactAlarms() ? 1 : 0));
                            } else {
                                hashSet.add(1);
                            }
                        } else if (i5 == 9 || i5 == 32) {
                            int iCheckSelfPermission = ContextCompat.checkSelfPermission(this.context, str);
                            if ((Build.VERSION.SDK_INT >= 34 ? ContextCompat.checkSelfPermission(this.context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") : iCheckSelfPermission) == 0 && iCheckSelfPermission == -1) {
                                hashSet.add(3);
                            } else if (iCheckSelfPermission == 0) {
                                hashSet.add(1);
                            } else {
                                hashSet.add(Integer.valueOf(e.determineDeniedVariant(this.activity, str)));
                            }
                        } else if (ContextCompat.checkSelfPermission(this.context, str) != 0) {
                            hashSet.add(Integer.valueOf(e.determineDeniedVariant(this.activity, str)));
                        }
                    }
                    if (!hashSet.isEmpty()) {
                        return e.strictestStatus(hashSet).intValue();
                    }
                }
                return 1;
            }
            Log.d("permissions_handler", "No permissions found in manifest for: " + manifestNames3 + i5);
            if (i5 == 22 && Build.VERSION.SDK_INT < 30) {
                return 2;
            }
        }
        return 0;
    }

    public final boolean b() {
        List<String> manifestNames = e.getManifestNames(this.context, 37);
        boolean z6 = manifestNames != null && manifestNames.contains("android.permission.WRITE_CALENDAR");
        boolean z7 = manifestNames != null && manifestNames.contains("android.permission.READ_CALENDAR");
        if (z6 && z7) {
            return true;
        }
        if (!z6) {
            Log.d("permissions_handler", "android.permission.WRITE_CALENDAR missing in manifest");
        }
        if (!z7) {
            Log.d("permissions_handler", "android.permission.READ_CALENDAR missing in manifest");
        }
        return false;
    }

    public final void c(int i5, String str) {
        if (this.activity == null) {
            return;
        }
        Intent intent = new Intent(str);
        if (!str.equals("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS")) {
            intent.setData(Uri.parse("package:" + this.activity.getPackageName()));
        }
        this.activity.startActivityForResult(intent, i5);
        this.f6435a++;
    }

    public final void d(List list, P1.a aVar, P1.a aVar2) {
        if (this.f6435a > 0) {
            aVar2.a("PermissionHandler.PermissionManager", "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).");
            return;
        }
        if (this.activity == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            aVar2.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        this.successCallback = aVar;
        this.b = new HashMap();
        this.f6435a = 0;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (a(num.intValue()) != 1) {
                List<String> manifestNames = e.getManifestNames(this.activity, num.intValue());
                if (manifestNames != null && !manifestNames.isEmpty()) {
                    int i5 = Build.VERSION.SDK_INT;
                    if (num.intValue() == 16) {
                        c(209, "android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    } else if (i5 >= 30 && num.intValue() == 22) {
                        c(210, "android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                    } else if (num.intValue() == 23) {
                        c(211, "android.settings.action.MANAGE_OVERLAY_PERMISSION");
                    } else if (num.intValue() == 24) {
                        c(212, "android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                    } else if (num.intValue() == 27) {
                        c(213, "android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
                    } else if (i5 >= 31 && num.intValue() == 34) {
                        c(214, "android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
                    } else if (num.intValue() != 37 && num.intValue() != 0) {
                        arrayList.addAll(manifestNames);
                        this.f6435a = manifestNames.size() + this.f6435a;
                    } else if (b()) {
                        arrayList.add("android.permission.WRITE_CALENDAR");
                        arrayList.add("android.permission.READ_CALENDAR");
                        this.f6435a += 2;
                    } else {
                        this.b.put(num, 0);
                    }
                } else if (!this.b.containsKey(num)) {
                    this.b.put(num, 0);
                    if (num.intValue() != 22 || Build.VERSION.SDK_INT >= 30) {
                        this.b.put(num, 0);
                    } else {
                        this.b.put(num, 2);
                    }
                }
            } else if (!this.b.containsKey(num)) {
                this.b.put(num, 1);
            }
        }
        if (arrayList.size() > 0) {
            ActivityCompat.requestPermissions(this.activity, (String[]) arrayList.toArray(new String[0]), 24);
        }
        c cVar = this.successCallback;
        if (cVar == null || this.f6435a != 0) {
            return;
        }
        ((P1.a) cVar).b.success(this.b);
    }

    public final void e(int i5, P1.a aVar, P1.a aVar2) {
        MethodChannel.Result result = aVar.b;
        Activity activity = this.activity;
        if (activity == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            aVar2.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        List<String> manifestNames = e.getManifestNames(activity, i5);
        if (manifestNames == null) {
            a.v(i5, "No android specific permissions needed for: ", "permissions_handler");
            result.success(Boolean.FALSE);
        } else {
            if (!manifestNames.isEmpty()) {
                result.success(Boolean.valueOf(ActivityCompat.shouldShowRequestPermissionRationale(this.activity, manifestNames.get(0))));
                return;
            }
            Log.d("permissions_handler", "No permissions found in manifest for: " + i5 + " no need to show request rationale");
            result.success(Boolean.FALSE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public final boolean onActivityResult(int i5, int i6, Intent intent) {
        int i7;
        int iCanScheduleExactAlarms;
        Activity activity = this.activity;
        boolean z6 = false;
        z6 = false;
        if (activity != null) {
            if (this.b == null) {
                this.f6435a = 0;
                return false;
            }
            if (i5 == 209) {
                String packageName = this.context.getPackageName();
                PowerManager powerManager = (PowerManager) this.context.getSystemService("power");
                if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(packageName)) {
                    z6 = true;
                }
                i7 = 16;
                iCanScheduleExactAlarms = z6;
            } else if (i5 == 210) {
                if (Build.VERSION.SDK_INT >= 30) {
                    i7 = 22;
                    iCanScheduleExactAlarms = Environment.isExternalStorageManager();
                }
            } else if (i5 == 211) {
                i7 = 23;
                iCanScheduleExactAlarms = Settings.canDrawOverlays(activity);
            } else if (i5 == 212) {
                i7 = 24;
                iCanScheduleExactAlarms = activity.getPackageManager().canRequestPackageInstalls();
            } else if (i5 == 213) {
                i7 = 27;
                iCanScheduleExactAlarms = ((NotificationManager) activity.getSystemService("notification")).isNotificationPolicyAccessGranted();
            } else if (i5 == 214) {
                i7 = 34;
                iCanScheduleExactAlarms = Build.VERSION.SDK_INT >= 31 ? ((AlarmManager) activity.getSystemService(NotificationCompat.CATEGORY_ALARM)).canScheduleExactAlarms() : true;
            }
            this.b.put(Integer.valueOf(i7), Integer.valueOf(iCanScheduleExactAlarms));
            int i8 = this.f6435a - 1;
            this.f6435a = i8;
            c cVar = this.successCallback;
            if (cVar != null && i8 == 0) {
                ((P1.a) cVar).b.success(this.b);
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i5, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i6;
        int i7 = 8;
        if (i5 != 24) {
            this.f6435a = 0;
            return false;
        }
        if (this.b == null) {
            return false;
        }
        if (strArr.length == 0 && iArr.length == 0) {
            Log.w("permissions_handler", "onRequestPermissionsResult is called without results. This is probably caused by interfering request codes. If you see this error, please file an issue in flutter-permission-handler, including a list of plugins used by this application: https://github.com/Baseflow/flutter-permission-handler/issues");
            return false;
        }
        List listAsList = Arrays.asList(strArr);
        int iIndexOf = listAsList.indexOf("android.permission.WRITE_CALENDAR");
        if (iIndexOf >= 0) {
            int permissionStatus = e.toPermissionStatus(this.activity, "android.permission.WRITE_CALENDAR", iArr[iIndexOf]);
            this.b.put(36, Integer.valueOf(permissionStatus));
            int iIndexOf2 = listAsList.indexOf("android.permission.READ_CALENDAR");
            if (iIndexOf2 >= 0) {
                Integer numStrictestStatus = e.strictestStatus(Integer.valueOf(permissionStatus), Integer.valueOf(e.toPermissionStatus(this.activity, "android.permission.READ_CALENDAR", iArr[iIndexOf2])));
                numStrictestStatus.getClass();
                this.b.put(37, numStrictestStatus);
                this.b.put(0, numStrictestStatus);
            }
        }
        int i8 = 0;
        while (i8 < strArr.length) {
            String str = strArr[i8];
            if (!str.equals("android.permission.WRITE_CALENDAR") && !str.equals("android.permission.READ_CALENDAR")) {
                int i9 = -1;
                switch (str.hashCode()) {
                    case -2062386608:
                        if (str.equals("android.permission.READ_SMS")) {
                            i9 = 0;
                        }
                        break;
                    case -1928411001:
                        if (str.equals("android.permission.READ_CALENDAR")) {
                            i9 = 1;
                        }
                        break;
                    case -1925850455:
                        if (str.equals("android.permission.POST_NOTIFICATIONS")) {
                            i9 = 2;
                        }
                        break;
                    case -1921431796:
                        if (str.equals("android.permission.READ_CALL_LOG")) {
                            i9 = 3;
                        }
                        break;
                    case -1888586689:
                        if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                            i9 = 4;
                        }
                        break;
                    case -1813079487:
                        if (str.equals("android.permission.MANAGE_EXTERNAL_STORAGE")) {
                            i9 = 5;
                        }
                        break;
                    case -1783097621:
                        if (str.equals("android.permission.ACCESS_NOTIFICATION_POLICY")) {
                            i9 = 6;
                        }
                        break;
                    case -1561629405:
                        if (str.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                            i9 = 7;
                        }
                        break;
                    case -1479758289:
                        if (str.equals("android.permission.RECEIVE_WAP_PUSH")) {
                            i9 = i7;
                        }
                        break;
                    case -1238066820:
                        if (str.equals("android.permission.BODY_SENSORS")) {
                            i9 = 9;
                        }
                        break;
                    case -1164582768:
                        if (str.equals("android.permission.READ_PHONE_NUMBERS")) {
                            i9 = 10;
                        }
                        break;
                    case -909527021:
                        if (str.equals("android.permission.NEARBY_WIFI_DEVICES")) {
                            i9 = 11;
                        }
                        break;
                    case -895679497:
                        if (str.equals("android.permission.RECEIVE_MMS")) {
                            i9 = 12;
                        }
                        break;
                    case -895673731:
                        if (str.equals("android.permission.RECEIVE_SMS")) {
                            i9 = 13;
                        }
                        break;
                    case -798669607:
                        if (str.equals("android.permission.BLUETOOTH_CONNECT")) {
                            i9 = 14;
                        }
                        break;
                    case -406040016:
                        if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                            i9 = 15;
                        }
                        break;
                    case -63024214:
                        if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                            i9 = 16;
                        }
                        break;
                    case -5573545:
                        if (str.equals("android.permission.READ_PHONE_STATE")) {
                            i9 = 17;
                        }
                        break;
                    case 52602690:
                        if (str.equals("android.permission.SEND_SMS")) {
                            i9 = 18;
                        }
                        break;
                    case 112197485:
                        if (str.equals("android.permission.CALL_PHONE")) {
                            i9 = 19;
                        }
                        break;
                    case 175802396:
                        if (str.equals("android.permission.READ_MEDIA_IMAGES")) {
                            i9 = 20;
                        }
                        break;
                    case 214526995:
                        if (str.equals("android.permission.WRITE_CONTACTS")) {
                            i9 = 21;
                        }
                        break;
                    case 361658321:
                        if (str.equals("android.permission.BODY_SENSORS_BACKGROUND")) {
                            i9 = 22;
                        }
                        break;
                    case 463403621:
                        if (str.equals("android.permission.CAMERA")) {
                            i9 = 23;
                        }
                        break;
                    case 603653886:
                        if (str.equals("android.permission.WRITE_CALENDAR")) {
                            i9 = 24;
                        }
                        break;
                    case 610633091:
                        if (str.equals("android.permission.WRITE_CALL_LOG")) {
                            i9 = 25;
                        }
                        break;
                    case 691260818:
                        if (str.equals("android.permission.READ_MEDIA_AUDIO")) {
                            i9 = 26;
                        }
                        break;
                    case 710297143:
                        if (str.equals("android.permission.READ_MEDIA_VIDEO")) {
                            i9 = 27;
                        }
                        break;
                    case 784519842:
                        if (str.equals("android.permission.USE_SIP")) {
                            i9 = 28;
                        }
                        break;
                    case 970694249:
                        if (str.equals("android.permission.SCHEDULE_EXACT_ALARM")) {
                            i9 = 29;
                        }
                        break;
                    case 1166454870:
                        if (str.equals("android.permission.BLUETOOTH_ADVERTISE")) {
                            i9 = 30;
                        }
                        break;
                    case 1271781903:
                        if (str.equals("android.permission.GET_ACCOUNTS")) {
                            i9 = 31;
                        }
                        break;
                    case 1365911975:
                        if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                            i9 = 32;
                        }
                        break;
                    case 1777263169:
                        if (str.equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                            i9 = 33;
                        }
                        break;
                    case 1780337063:
                        if (str.equals("android.permission.ACTIVITY_RECOGNITION")) {
                            i9 = 34;
                        }
                        break;
                    case 1831139720:
                        if (str.equals("android.permission.RECORD_AUDIO")) {
                            i9 = 35;
                        }
                        break;
                    case 1977429404:
                        if (str.equals("android.permission.READ_CONTACTS")) {
                            i9 = 36;
                        }
                        break;
                    case 2024715147:
                        if (str.equals("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                            i9 = 37;
                        }
                        break;
                    case 2062356686:
                        if (str.equals("android.permission.BLUETOOTH_SCAN")) {
                            i9 = 38;
                        }
                        break;
                    case 2114579147:
                        if (str.equals("android.permission.ACCESS_MEDIA_LOCATION")) {
                            i9 = 39;
                        }
                        break;
                    case 2133799037:
                        if (str.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
                            i9 = 40;
                        }
                        break;
                }
                switch (i9) {
                    case 0:
                    case 8:
                    case 12:
                    case 13:
                    case 18:
                        i6 = 13;
                        break;
                    case 1:
                    case 24:
                        i6 = 0;
                        break;
                    case 2:
                        i6 = 17;
                        break;
                    case 3:
                    case 10:
                    case 17:
                    case 19:
                    case 25:
                    case 28:
                    case 40:
                        i6 = i7;
                        break;
                    case 4:
                    case 16:
                        i6 = 3;
                        break;
                    case 5:
                        i6 = 22;
                        break;
                    case 6:
                        i6 = 27;
                        break;
                    case 7:
                        i6 = 23;
                        break;
                    case 9:
                        i6 = 12;
                        break;
                    case 11:
                        i6 = 31;
                        break;
                    case 14:
                        i6 = 30;
                        break;
                    case 15:
                    case 32:
                        i6 = 15;
                        break;
                    case 20:
                        i6 = 9;
                        break;
                    case 21:
                    case 31:
                    case 36:
                        i6 = 2;
                        break;
                    case 22:
                        i6 = 35;
                        break;
                    case 23:
                        i6 = 1;
                        break;
                    case 26:
                        i6 = 33;
                        break;
                    case 27:
                        i6 = 32;
                        break;
                    case 29:
                        i6 = 34;
                        break;
                    case 30:
                        i6 = 29;
                        break;
                    case 33:
                        i6 = 24;
                        break;
                    case 34:
                        i6 = 19;
                        break;
                    case 35:
                        i6 = 7;
                        break;
                    case 37:
                        i6 = 4;
                        break;
                    case 38:
                        i6 = 28;
                        break;
                    case 39:
                        i6 = 18;
                        break;
                    default:
                        i6 = 20;
                        break;
                }
                if (i6 != 20) {
                    int i10 = iArr[i8];
                    if (i6 == i7) {
                        this.b.put(8, e.strictestStatus((Integer) this.b.get(8), Integer.valueOf(e.toPermissionStatus(this.activity, str, i10))));
                    } else if (i6 == 7) {
                        if (!this.b.containsKey(7)) {
                            this.b.put(7, Integer.valueOf(e.toPermissionStatus(this.activity, str, i10)));
                        }
                        if (!this.b.containsKey(14)) {
                            this.b.put(14, Integer.valueOf(e.toPermissionStatus(this.activity, str, i10)));
                        }
                    } else if (i6 == 4) {
                        int permissionStatus2 = e.toPermissionStatus(this.activity, str, i10);
                        if (!this.b.containsKey(4)) {
                            this.b.put(4, Integer.valueOf(permissionStatus2));
                        }
                    } else if (i6 == 3) {
                        int permissionStatus3 = e.toPermissionStatus(this.activity, str, i10);
                        if (Build.VERSION.SDK_INT < 29 && !this.b.containsKey(4)) {
                            this.b.put(4, Integer.valueOf(permissionStatus3));
                        }
                        if (!this.b.containsKey(5)) {
                            this.b.put(5, Integer.valueOf(permissionStatus3));
                        }
                        this.b.put(Integer.valueOf(i6), Integer.valueOf(permissionStatus3));
                    } else if (i6 == 9 || i6 == 32) {
                        this.b.put(Integer.valueOf(i6), Integer.valueOf(a(i6)));
                    } else if (!this.b.containsKey(Integer.valueOf(i6))) {
                        this.b.put(Integer.valueOf(i6), Integer.valueOf(e.toPermissionStatus(this.activity, str, i10)));
                    }
                }
            }
            i8++;
            i7 = 8;
        }
        int length = this.f6435a - iArr.length;
        this.f6435a = length;
        c cVar = this.successCallback;
        if (cVar != null && length == 0) {
            ((P1.a) cVar).b.success(this.b);
        }
        return true;
    }

    public void setActivity(@Nullable Activity activity) {
        this.activity = activity;
    }
}
