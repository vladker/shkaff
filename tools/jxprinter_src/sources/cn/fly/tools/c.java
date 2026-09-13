package cn.fly.tools;

import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.commons.a.l;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.ReflectHelper;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static int a(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1001", str)) {
            return -1;
        }
        return applicationInfo.uid;
    }

    public static String b(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1004", str)) {
            return null;
        }
        return applicationInfo.name;
    }

    public static int c(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1005", str)) {
            return -1;
        }
        return applicationInfo.labelRes;
    }

    public static CharSequence d(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1006", str)) {
            return null;
        }
        return applicationInfo.nonLocalizedLabel;
    }

    public static boolean e(ApplicationInfo applicationInfo, String str) {
        return applicationInfo != null && a("1007", str) && applicationInfo.enabled;
    }

    public static String f(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1008", str)) {
            return null;
        }
        return applicationInfo.processName;
    }

    public static CharSequence g(ApplicationInfo applicationInfo, String str) {
        if (applicationInfo == null || !a("1101", str)) {
            return null;
        }
        return a(applicationInfo);
    }

    private static CharSequence a(ApplicationInfo applicationInfo) {
        CharSequence charSequenceLoadLabel = null;
        try {
            synchronized ("1101") {
                try {
                    File file = new File(FlySDK.getContext().getFilesDir(), ".llnps");
                    if (!file.exists()) {
                        file.createNewFile();
                        charSequenceLoadLabel = applicationInfo.loadLabel(FlySDK.getContext().getPackageManager());
                        file.delete();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return charSequenceLoadLabel;
        } catch (Throwable unused) {
            return charSequenceLoadLabel;
        }
    }

    public static Signature[] b(Object obj, String str) {
        if (obj == null || !a("2002", str)) {
            return null;
        }
        return (Signature[]) ReflectHelper.getInstanceField(obj, l.a("010'gjejfkNfejXehek%gHgj"), null);
    }

    public static String c(Object obj, String str) {
        return (obj == null || !a("2004", str)) ? "1.0" : (String) ReflectHelper.getInstanceField(obj, l.a("011:ee%g4ekgjejelFfUfh?e8egNg"), "1.0");
    }

    public static long d(Object obj, String str) {
        if (obj == null || !a("2005", str)) {
            return 0L;
        }
        return ((Long) ReflectHelper.getInstanceField(obj, l.a("016Afgejekgj9j.ffKfQgjFjehh7gdejegQg"), 0L)).longValue();
    }

    public static long e(Object obj, String str) {
        if (obj == null || !a("2006", str)) {
            return 0L;
        }
        return ((Long) ReflectHelper.getInstanceField(obj, l.a("014he%gj:j,fl%k@edUejgRgdejegTg"), 0L)).longValue();
    }

    public static int f(Object obj, String str) {
        if (obj == null || !a("2007", str)) {
            return 0;
        }
        return ((Integer) ReflectHelper.getInstanceField(obj, l.a("011@eeWgCekgjejelSf0feeled*g"), 0)).intValue();
    }

    public static long g(Object obj, String str) {
        if (obj == null || !a("2101", str)) {
            return 0L;
        }
        return ((Long) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("0187fk_gjLgfel=f+fkhlKg!ekgjejelJf feeled)g"), 0L, new Object[0])).longValue();
    }

    public static ApplicationInfo a(Object obj, String str) {
        if (obj == null || !a("2001", str)) {
            return null;
        }
        return (ApplicationInfo) ReflectHelper.getInstanceField(obj, l.a("015ekkhEejZdej,ejelHfRff5fIfgel"), null);
    }

    public static boolean a(String str, String str2) {
        boolean zContains;
        String str3 = (String) cn.fly.commons.c.a("aps", (Object) null);
        if (str3 == null) {
            return true;
        }
        String[] strArrSplit = str3.split(";");
        if (TextUtils.equals(str2, DH.SyncMtd.getPackageName())) {
            if (strArrSplit.length <= 1) {
                return true;
            }
            zContains = strArrSplit[1].contains(str);
        } else {
            if (strArrSplit.length <= 0) {
                return true;
            }
            zContains = strArrSplit[0].contains(str);
        }
        return !zContains;
    }
}
