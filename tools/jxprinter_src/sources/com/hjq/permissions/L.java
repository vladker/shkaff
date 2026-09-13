package com.hjq.permissions;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.billingclient.api.v1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f3533a = {"huawei"};
    public static final String[] b = {"vivo"};
    public static final String[] c = {"xiaomi"};
    public static final String[] d = {"oppo"};
    public static final String[] e = {"leeco", "letv"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f3534f = {"360", "qiku"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f3535g = {"zte"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f3536h = {"oneplus"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f3537i = {"nubia"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f3538j = {"samsung"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f3539k = {"honor"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f3540l = {"ro.build.version.opporom", "ro.build.version.oplusrom.display"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f3541m = {"msc.config.magic.version", "ro.build.version.magic"};

    /* JADX WARN: Code duplicated, block: B:64:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    public static String a(String str) throws Throwable {
        String line;
        String property = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                    try {
                        line = bufferedReader2.readLine();
                        if (line != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        } else {
                            bufferedReader2.close();
                            line = "";
                        }
                    } catch (IOException e7) {
                        e = e7;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        line = "";
                        if (!TextUtils.isEmpty(line)) {
                            return line;
                        }
                        try {
                            Properties properties = new Properties();
                            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
                            property = properties.getProperty(str, "");
                        } catch (FileNotFoundException e8) {
                            e8.printStackTrace();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                        if (TextUtils.isEmpty(property)) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            } catch (IOException e12) {
                e = e12;
            }
            if (!TextUtils.isEmpty(line)) {
                return line;
            }
            Properties properties2 = new Properties();
            properties2.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            property = properties2.getProperty(str, "");
            return (TextUtils.isEmpty(property) && Build.VERSION.SDK_INT < 28) ? getSystemPropertyByReflect(str) : property;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean b() {
        if (!v1.c()) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "Harmony".equalsIgnoreCase(String.valueOf(cls.getMethod("getOsBrand", null).invoke(cls, null)));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean c() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name"));
    }

    public static boolean d(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static String getRomVersionName() throws Throwable {
        String lowerCase = Build.BRAND.toLowerCase();
        String lowerCase2 = Build.MANUFACTURER.toLowerCase();
        if (d(lowerCase, lowerCase2, f3533a)) {
            String strA = a("ro.build.version.emui");
            String[] strArrSplit = strA.split("_");
            if (strArrSplit.length > 1) {
                return strArrSplit[1];
            }
            return strA.contains("EmotionUI") ? strA.replaceFirst("EmotionUI\\s*", "") : strA;
        }
        if (d(lowerCase, lowerCase2, b)) {
            return a("ro.vivo.os.build.display.id");
        }
        if (d(lowerCase, lowerCase2, c)) {
            return a("ro.build.version.incremental");
        }
        int i5 = 0;
        if (d(lowerCase, lowerCase2, d)) {
            while (i5 < 2) {
                String str = f3540l[i5];
                String strA2 = a(str);
                if (!TextUtils.isEmpty(str)) {
                    return strA2;
                }
                i5++;
            }
            return "";
        }
        if (d(lowerCase, lowerCase2, e)) {
            return a("ro.letv.release.version");
        }
        if (d(lowerCase, lowerCase2, f3534f)) {
            return a("ro.build.uiversion");
        }
        if (d(lowerCase, lowerCase2, f3535g)) {
            return a("ro.build.MiFavor_version");
        }
        if (d(lowerCase, lowerCase2, f3536h)) {
            return a("ro.rom.version");
        }
        if (d(lowerCase, lowerCase2, f3537i)) {
            return a("ro.build.rom.id");
        }
        if (!d(lowerCase, lowerCase2, f3539k)) {
            return a("");
        }
        while (i5 < 2) {
            String str2 = f3541m[i5];
            String strA3 = a(str2);
            if (!TextUtils.isEmpty(str2)) {
                return strA3;
            }
            i5++;
        }
        return "";
    }

    @SuppressLint({"PrivateApi"})
    private static String getSystemPropertyByReflect(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (ClassNotFoundException e6) {
            e6.printStackTrace();
            return "";
        } catch (IllegalAccessException e7) {
            e7.printStackTrace();
            return "";
        } catch (NoSuchMethodException e8) {
            e8.printStackTrace();
            return "";
        } catch (InvocationTargetException e9) {
            e9.printStackTrace();
            return "";
        }
    }

    @SuppressLint({"PrivateApi"})
    public static boolean isMiuiOptimization() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return Boolean.parseBoolean(String.valueOf(cls.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(cls, "persist.sys.miui_optimization", Boolean.valueOf(!"1".equals(String.valueOf(cls.getMethod("get", String.class, String.class).invoke(cls, "ro.miui.cts", "")))))));
        } catch (ClassNotFoundException e6) {
            e6.printStackTrace();
            return true;
        } catch (IllegalAccessException e7) {
            e7.printStackTrace();
            return true;
        } catch (NoSuchMethodException e8) {
            e8.printStackTrace();
            return true;
        } catch (InvocationTargetException e9) {
            e9.printStackTrace();
            return true;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static boolean isOneUi() {
        return d(Build.BRAND.toLowerCase(), Build.MANUFACTURER.toLowerCase(), f3538j);
    }
}
