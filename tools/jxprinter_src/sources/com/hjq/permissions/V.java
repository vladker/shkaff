package com.hjq.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static U f3546a;
    public static Boolean b;

    @Nullable
    private Boolean mCheckMode;

    @Nullable
    private final Context mContext;

    @Nullable
    private InterfaceC0559l mInterceptor;

    @NonNull
    private final List<String> mPermissions = new ArrayList();

    private V(@Nullable Context context) {
        this.mContext = context;
    }

    public static boolean containsSpecial(@NonNull String... strArr) {
        return containsSpecial(K.asArrayList(strArr));
    }

    public static List<String> getDenied(@NonNull Context context, @NonNull String... strArr) {
        return getDenied(context, K.asArrayList(strArr));
    }

    private boolean isCheckMode(@NonNull Context context) {
        if (this.mCheckMode == null) {
            if (b == null) {
                b = Boolean.valueOf(K.isDebugMode(context));
            }
            this.mCheckMode = b;
        }
        return this.mCheckMode.booleanValue();
    }

    public static boolean isDoNotAskAgainPermissions(@NonNull Activity activity, @NonNull String... strArr) {
        return isDoNotAskAgainPermissions(activity, K.asArrayList(strArr));
    }

    public static boolean isGranted(@NonNull Context context, @NonNull String... strArr) {
        return isGranted(context, K.asArrayList(strArr));
    }

    public static boolean isSpecial(@NonNull String str) {
        return AbstractC0562o.isSpecialPermission(str);
    }

    public static void startPermissionActivity(@NonNull Context context) {
        startPermissionActivity(context, new ArrayList(0));
    }

    public static V with(@NonNull Context context) {
        return new V(context);
    }

    public V interceptor(@Nullable InterfaceC0559l interfaceC0559l) {
        this.mInterceptor = interfaceC0559l;
        return this;
    }

    public V permission(@Nullable String str) {
        if (str == null || K.containsPermission(this.mPermissions, str)) {
            return this;
        }
        this.mPermissions.add(str);
        return this;
    }

    public void request(@Nullable InterfaceC0558k interfaceC0558k) {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        if (this.mInterceptor == null) {
            if (f3546a == null) {
                f3546a = new U();
            }
            this.mInterceptor = f3546a;
        }
        InterfaceC0559l interfaceC0559l = this.mInterceptor;
        ArrayList arrayList = new ArrayList(this.mPermissions);
        boolean zIsCheckMode = isCheckMode(context);
        Activity activityFindActivity = K.findActivity(context);
        if (AbstractC0563p.checkActivityStatus(activityFindActivity, zIsCheckMode) && AbstractC0563p.checkPermissionArgument(arrayList, zIsCheckMode)) {
            if (zIsCheckMode) {
                C0553f androidManifestInfo = K.getAndroidManifestInfo(context);
                AbstractC0563p.checkMediaLocationPermission(context, arrayList);
                AbstractC0563p.checkStoragePermission(context, arrayList, androidManifestInfo);
                AbstractC0563p.checkBodySensorsPermission(arrayList);
                AbstractC0563p.checkLocationPermission(arrayList);
                AbstractC0563p.checkPictureInPicturePermission(activityFindActivity, arrayList, androidManifestInfo);
                AbstractC0563p.checkNotificationListenerPermission(arrayList, androidManifestInfo);
                AbstractC0563p.checkNearbyDevicesPermission(arrayList, androidManifestInfo);
                AbstractC0563p.checkReadMediaVisualUserSelectedPermission(arrayList);
                AbstractC0563p.checkTargetSdkVersion(context, arrayList);
                AbstractC0563p.checkManifestPermissions(context, arrayList, androidManifestInfo);
            }
            AbstractC0563p.optimizeDeprecatedPermission(arrayList);
            if (!AbstractC0562o.isGrantedPermissions(context, arrayList)) {
                interfaceC0559l.launchPermissionRequest(activityFindActivity, arrayList, interfaceC0558k);
            } else if (interfaceC0558k != null) {
                interfaceC0559l.grantedPermissionRequest(activityFindActivity, arrayList, arrayList, true, interfaceC0558k);
                interfaceC0559l.finishPermissionRequest(activityFindActivity, arrayList, true, interfaceC0558k);
            }
        }
    }

    public static boolean containsSpecial(@NonNull List<String> list) {
        return AbstractC0562o.a(list);
    }

    public static List<String> getDenied(@NonNull Context context, @NonNull String[]... strArr) {
        return getDenied(context, K.asArrayLists(strArr));
    }

    public static boolean isDoNotAskAgainPermissions(@NonNull Activity activity, @NonNull String[]... strArr) {
        return isDoNotAskAgainPermissions(activity, K.asArrayLists(strArr));
    }

    public static boolean isGranted(@NonNull Context context, @NonNull String[]... strArr) {
        return isGranted(context, K.asArrayLists(strArr));
    }

    public static void startPermissionActivity(@NonNull Context context, @NonNull String... strArr) {
        startPermissionActivity(context, K.asArrayList(strArr));
    }

    public static V with(@NonNull Fragment fragment) {
        return with(fragment.getActivity());
    }

    public static List<String> getDenied(@NonNull Context context, @NonNull List<String> list) {
        return AbstractC0562o.getDeniedPermissions(context, list);
    }

    public static boolean isDoNotAskAgainPermissions(@NonNull Activity activity, @NonNull List<String> list) {
        return AbstractC0562o.isDoNotAskAgainPermissions(activity, list);
    }

    public static boolean isGranted(@NonNull Context context, @NonNull List<String> list) {
        return AbstractC0562o.isGrantedPermissions(context, list);
    }

    public static void startPermissionActivity(@NonNull Context context, @NonNull String[]... strArr) {
        startPermissionActivity(context, K.asArrayLists(strArr));
    }

    public static V with(@NonNull androidx.fragment.app.Fragment fragment) {
        return with(fragment.getActivity());
    }

    public V permission(@Nullable String... strArr) {
        return permission(K.asArrayList(strArr));
    }

    public static void startPermissionActivity(@NonNull Context context, @NonNull List<String> list) {
        Activity activityFindActivity = K.findActivity(context);
        if (activityFindActivity != null) {
            startPermissionActivity(activityFindActivity, list);
            return;
        }
        Intent smartPermissionIntent = K.getSmartPermissionIntent(context, list);
        if (!(context instanceof Activity)) {
            smartPermissionIntent.addFlags(268435456);
        }
        S.startActivity(context, smartPermissionIntent);
    }

    public V permission(@Nullable String[]... strArr) {
        return permission(K.asArrayLists(strArr));
    }

    public V permission(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (!K.containsPermission(this.mPermissions, str)) {
                    this.mPermissions.add(str);
                }
            }
        }
        return this;
    }

    public static void startPermissionActivity(@NonNull Activity activity) {
        startPermissionActivity(activity, (List<String>) new ArrayList(0));
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull String... strArr) {
        startPermissionActivity(activity, (List<String>) K.asArrayList(strArr));
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull String[]... strArr) {
        startPermissionActivity(activity, (List<String>) K.asArrayLists(strArr));
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull List<String> list) {
        startPermissionActivity(activity, list, InputDeviceCompat.SOURCE_GAMEPAD);
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull List<String> list, int i5) {
        S.startActivityForResult(activity, K.getSmartPermissionIntent(activity, list), i5);
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull String str, @Nullable InterfaceC0560m interfaceC0560m) {
        startPermissionActivity(activity, K.asArrayList(str), interfaceC0560m);
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull String[] strArr, @Nullable InterfaceC0560m interfaceC0560m) {
        startPermissionActivity(activity, K.asArrayLists(strArr), interfaceC0560m);
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull List<String> list, @Nullable InterfaceC0560m interfaceC0560m) {
        if (list.isEmpty()) {
            S.startActivity(activity, I.getApplicationDetailsIntent(activity));
        } else {
            J.launch(activity, list, interfaceC0560m);
        }
    }

    public static void startPermissionActivity(@NonNull Fragment fragment) {
        startPermissionActivity(fragment, new ArrayList(0));
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull String... strArr) {
        startPermissionActivity(fragment, K.asArrayList(strArr));
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull String[]... strArr) {
        startPermissionActivity(fragment, K.asArrayLists(strArr));
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull List<String> list) {
        startPermissionActivity(fragment, list, InputDeviceCompat.SOURCE_GAMEPAD);
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull List<String> list, int i5) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        if (list.isEmpty()) {
            S.startActivity(fragment, I.getApplicationDetailsIntent(activity));
        } else {
            S.startActivityForResult(fragment, K.getSmartPermissionIntent(activity, list), i5);
        }
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull String str, @Nullable InterfaceC0560m interfaceC0560m) {
        startPermissionActivity(fragment, K.asArrayList(str), interfaceC0560m);
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull String[] strArr, @Nullable InterfaceC0560m interfaceC0560m) {
        startPermissionActivity(fragment, K.asArrayLists(strArr), interfaceC0560m);
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull List<String> list, @Nullable InterfaceC0560m interfaceC0560m) {
        Activity activity = fragment.getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        if (list.isEmpty()) {
            S.startActivity(fragment, I.getApplicationDetailsIntent(activity));
        } else {
            J.launch(activity, list, interfaceC0560m);
        }
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment) {
        startPermissionActivity(fragment, new ArrayList());
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull String... strArr) {
        startPermissionActivity(fragment, K.asArrayList(strArr));
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull String[]... strArr) {
        startPermissionActivity(fragment, K.asArrayLists(strArr));
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull List<String> list) {
        startPermissionActivity(fragment, list, InputDeviceCompat.SOURCE_GAMEPAD);
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull List<String> list, int i5) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        if (list.isEmpty()) {
            S.startActivity(fragment, I.getApplicationDetailsIntent(activity));
        } else {
            S.startActivityForResult(fragment, K.getSmartPermissionIntent(activity, list), i5);
        }
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull String str, @Nullable InterfaceC0560m interfaceC0560m) {
        startPermissionActivity(fragment, K.asArrayList(str), interfaceC0560m);
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull String[] strArr, @Nullable InterfaceC0560m interfaceC0560m) {
        startPermissionActivity(fragment, K.asArrayLists(strArr), interfaceC0560m);
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull List<String> list, @Nullable InterfaceC0560m interfaceC0560m) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        if (list.isEmpty()) {
            S.startActivity(fragment, I.getApplicationDetailsIntent(activity));
        } else {
            J.launch(activity, list, interfaceC0560m);
        }
    }
}
