package cn.fly.commons;

import android.os.Process;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.FileLocker;
import cn.fly.tools.utils.ResHelper;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1478a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f1479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f1480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f1481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f1482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f1483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f1484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f1485l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f1486m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f1487n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Map<String, FileLocker> f1488o = new ConcurrentHashMap();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f1489p;

    static {
        String strA = n.a("011aTbibdbdRjeWbiMa;cfdg;j");
        f1489p = strA;
        f1478a = androidx.collection.a.n(strA, ".mrlock");
        StringBuilder sbR = androidx.collection.a.r(strA);
        sbR.append(n.a("007EbjbaWfe>biMa6cf"));
        b = sbR.toString();
        StringBuilder sbR2 = androidx.collection.a.r(strA);
        sbR2.append(n.a("011:bjch<e(biddObeIdcbi^aKcf"));
        c = sbR2.toString();
        StringBuilder sbR3 = androidx.collection.a.r(strA);
        sbR3.append(n.a("008^bjbacabf^e9biTa9cf"));
        d = sbR3.toString();
        StringBuilder sbR4 = androidx.collection.a.r(strA);
        sbR4.append(n.a("008@bjbadgbfDeMbi?a=cf"));
        e = sbR4.toString();
        f1479f = androidx.collection.a.n(strA, ".cl_lock");
        f1480g = androidx.collection.a.n(strA, ".gcf_lock");
        f1481h = androidx.collection.a.n(strA, ".mp_lock");
        f1482i = androidx.collection.a.n(strA, ".dmf_lock");
        f1483j = androidx.collection.a.n(strA, ".xc_lock");
        f1484k = new Object();
        f1485l = new Object();
        f1486m = new Object();
        f1487n = androidx.collection.a.n(strA, ".pv_lock");
    }

    public static synchronized File a(String str) {
        return ResHelper.getDataCacheFile(FlySDK.getContext(), str, true);
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = c;
            if (str.endsWith(str2)) {
                return str2;
            }
            String str3 = b;
            if (str.endsWith(str3)) {
                return str3;
            }
            String str4 = d;
            if (str.endsWith(str4)) {
                return str4;
            }
            String str5 = e;
            if (str.endsWith(str5)) {
                return str5;
            }
            String str6 = f1479f;
            if (str.endsWith(str6)) {
                return str6;
            }
            String str7 = f1480g;
            if (str.endsWith(str7)) {
                return str7;
            }
            String str8 = f1482i;
            if (str.endsWith(str8)) {
                return str8;
            }
            String str9 = f1483j;
            if (str.endsWith(str9)) {
                return str9;
            }
        }
        return str;
    }

    public static boolean a(File file, u uVar) {
        return a(file, true, uVar);
    }

    public static boolean a(File file, boolean z6, u uVar) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            String absolutePath = file.getAbsolutePath();
            synchronized (b(absolutePath)) {
                try {
                    FileLocker fileLocker = new FileLocker();
                    fileLocker.setLockFile(absolutePath);
                    if (!fileLocker.lock(z6)) {
                        return false;
                    }
                    try {
                        if (!uVar.a(fileLocker)) {
                            fileLocker.release();
                        } else {
                            FlyLog.getInstance().d("lked & hold: " + Process.myPid(), new Object[0]);
                            f1488o.put(absolutePath, fileLocker);
                        }
                    } catch (Throwable unused) {
                        fileLocker.release();
                    }
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            FlyLog.getInstance().w(th2);
            return true;
        }
    }
}
