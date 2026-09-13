package com.hjq.permissions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.android.billingclient.api.v1;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f3532a = new Handler(Looper.getMainLooper());

    public static boolean areActivityIntent(@NonNull Context context, @Nullable Intent intent) {
        if (intent == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return !(v1.e() ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)).isEmpty() : packageManager.queryIntentActivities(intent, 65536).isEmpty());
    }

    @NonNull
    public static <T> ArrayList<T> asArrayList(@Nullable T... tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr != null ? tArr.length : 0);
        if (tArr != null && tArr.length != 0) {
            for (T t6 : tArr) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    @NonNull
    @SafeVarargs
    public static <T> ArrayList<T> asArrayLists(@Nullable T[]... tArr) {
        ArrayList<T> arrayList = new ArrayList<>();
        if (tArr != null && tArr.length != 0) {
            for (T[] tArr2 : tArr) {
                arrayList.addAll(asArrayList(tArr2));
            }
        }
        return arrayList;
    }

    @RequiresApi(19)
    public static boolean checkOpNoThrow(Context context, String str, int i5) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i6 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            try {
                i5 = ((Integer) cls.getDeclaredField(str).get(Integer.class)).intValue();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            Class cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(i5), Integer.valueOf(i6), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    @RequiresApi(api = 23)
    public static boolean checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return context.checkSelfPermission(str) == 0;
    }

    public static boolean containsPermission(@NonNull Collection<String> collection, @NonNull String str) {
        if (collection.isEmpty()) {
            return false;
        }
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            if (equalsPermission(it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean equalsPermission(@NonNull String str, @NonNull String str2) {
        int length = str.length();
        if (length != str2.length()) {
            return false;
        }
        for (int i5 = length - 1; i5 >= 0; i5--) {
            if (str.charAt(i5) != str2.charAt(i5)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static Activity findActivity(@NonNull Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper) || (context = ((ContextWrapper) context).getBaseContext()) == null) {
                return null;
            }
        }
        return (Activity) context;
    }

    @SuppressLint({"PrivateApi"})
    public static int findApkPathCookie(@NonNull Context context, @NonNull String str) {
        int i5;
        AssetManager assets = context.getAssets();
        try {
            if (context.getApplicationInfo().targetSdkVersion >= 28 && (i5 = Build.VERSION.SDK_INT) >= 28 && i5 < 30) {
                Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                declaredMethod.setAccessible(true);
                Method method = (Method) declaredMethod.invoke(AssetManager.class, "findCookieForPath", new Class[]{String.class});
                if (method != null) {
                    method.setAccessible(true);
                    Integer num = (Integer) method.invoke(context.getAssets(), str);
                    if (num != null) {
                        return num.intValue();
                    }
                }
            }
            Integer num2 = (Integer) assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, str);
            if (num2 != null) {
                return num2.intValue();
            }
            return 0;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
            return 0;
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
            return 0;
        }
    }

    @Nullable
    public static C0553f getAndroidManifestInfo(Context context) {
        int iFindApkPathCookie = findApkPathCookie(context, context.getApplicationInfo().sourceDir);
        C0553f c0553f = null;
        if (iFindApkPathCookie == 0) {
            return null;
        }
        try {
            C0553f androidManifest = AbstractC0554g.parseAndroidManifest(context, iFindApkPathCookie);
            try {
                if (TextUtils.equals(context.getPackageName(), androidManifest.f3551a)) {
                    return androidManifest;
                }
                return null;
            } catch (IOException | XmlPullParserException e) {
                e = e;
                c0553f = androidManifest;
                e.printStackTrace();
                return c0553f;
            }
        } catch (IOException e6) {
            e = e6;
        } catch (XmlPullParserException e7) {
            e = e7;
        }
    }

    public static Uri getPackageNameUri(@NonNull Context context) {
        return Uri.parse("package:" + context.getPackageName());
    }

    public static Intent getSmartPermissionIntent(@NonNull Context context, @Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            return I.getApplicationDetailsIntent(context);
        }
        if (!AbstractC0562o.a(list)) {
            return list.size() == 1 ? AbstractC0562o.getPermissionIntent(context, list.get(0)) : I.getApplicationDetailsIntent(context, list);
        }
        int size = list.size();
        if (size == 1) {
            return AbstractC0562o.getPermissionIntent(context, list.get(0));
        }
        if (size != 2) {
            if (size == 3 && v1.d() && containsPermission(list, "android.permission.MANAGE_EXTERNAL_STORAGE") && containsPermission(list, "android.permission.READ_EXTERNAL_STORAGE") && containsPermission(list, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return AbstractC0562o.getPermissionIntent(context, "android.permission.MANAGE_EXTERNAL_STORAGE");
            }
        } else if (!v1.e() && containsPermission(list, "android.permission.NOTIFICATION_SERVICE") && containsPermission(list, "android.permission.POST_NOTIFICATIONS")) {
            return AbstractC0562o.getPermissionIntent(context, "android.permission.NOTIFICATION_SERVICE");
        }
        return I.getApplicationDetailsIntent(context);
    }

    public static boolean isActivityReverse(@NonNull Activity activity) {
        Display defaultDisplay;
        if (v1.d()) {
            defaultDisplay = activity.getDisplay();
        } else {
            WindowManager windowManager = activity.getWindowManager();
            defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        }
        if (defaultDisplay == null) {
            return false;
        }
        int rotation = defaultDisplay.getRotation();
        return rotation == 2 || rotation == 3;
    }

    public static boolean isDebugMode(@NonNull Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean isScopedStorage(@NonNull Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null || !bundle.containsKey("ScopedStorage")) {
                return false;
            }
            return bundle.getBoolean("ScopedStorage");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"SwitchIntDef"})
    public static void lockActivityOrientation(@NonNull Activity activity) {
        try {
            int i5 = activity.getResources().getConfiguration().orientation;
            if (i5 == 1) {
                activity.setRequestedOrientation(isActivityReverse(activity) ? 9 : 1);
            } else {
                if (i5 != 2) {
                    return;
                }
                activity.setRequestedOrientation(isActivityReverse(activity) ? 8 : 0);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public static void optimizePermissionResults(Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        for (int i5 = 0; i5 < strArr.length; i5++) {
            String str = strArr[i5];
            if (AbstractC0562o.isSpecialPermission(str)) {
                iArr[i5] = AbstractC0562o.getPermissionResult(activity, str);
            } else if (equalsPermission(str, "com.android.permission.GET_INSTALLED_APPS")) {
                iArr[i5] = AbstractC0562o.getPermissionResult(activity, str);
            } else {
                int i6 = Build.VERSION.SDK_INT;
                if (i6 >= 34 && (equalsPermission(str, "android.permission.READ_MEDIA_IMAGES") || equalsPermission(str, "android.permission.READ_MEDIA_VIDEO"))) {
                    iArr[i5] = AbstractC0562o.getPermissionResult(activity, str);
                } else if (v1.e() && activity.getApplicationInfo().targetSdkVersion >= 33 && equalsPermission(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    iArr[i5] = AbstractC0562o.getPermissionResult(activity, str);
                } else if (AbstractC0561n.getDangerPermissionFromAndroidVersion(str) > i6) {
                    iArr[i5] = AbstractC0562o.getPermissionResult(activity, str);
                }
            }
        }
    }

    public static void postActivityResult(@NonNull List<String> list, @NonNull Runnable runnable) {
        long j6 = 300;
        long j7 = v1.d() ? 200L : 300L;
        if (TextUtils.isEmpty(L.a("ro.build.version.emui")) && !L.b()) {
            j6 = (L.c() && v1.d() && containsPermission(list, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")) ? 1000L : j7;
        }
        postDelayed(runnable, j6);
    }

    public static void postDelayed(@NonNull Runnable runnable, long j6) {
        f3532a.postDelayed(runnable, j6);
    }

    @RequiresApi(api = 23)
    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity activity, @NonNull String str) {
        if (Build.VERSION.SDK_INT == 31) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return activity.shouldShowRequestPermissionRationale(str);
    }

    @RequiresApi(19)
    public static boolean checkOpNoThrow(Context context, String str) {
        int iCheckOpNoThrow;
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        if (v1.c()) {
            iCheckOpNoThrow = appOpsManager.unsafeCheckOpNoThrow(str, context.getApplicationInfo().uid, context.getPackageName());
        } else {
            iCheckOpNoThrow = appOpsManager.checkOpNoThrow(str, context.getApplicationInfo().uid, context.getPackageName());
        }
        return iCheckOpNoThrow == 0;
    }
}
