package cn.fly.commons;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static boolean a() {
        return a(n.a("003[bibgRb")) && CSCenter.getInstance().isOaidEnable();
    }

    public static boolean b() {
        return a(n.a("003beb"));
    }

    public static boolean c() {
        return a(n.a("003SdebgXb"));
    }

    public static boolean d() {
        return a(n.a("003HdeXeb"));
    }

    public static boolean e() {
        return a(n.a("002eb")) && CSCenter.getInstance().isLocationDataEnable();
    }

    public static boolean f() {
        return a(n.a("003Mbi-eb")) && CSCenter.getInstance().isLocationDataEnable();
    }

    public static boolean g() {
        return a(n.a("003?cdbi+b")) && CSCenter.getInstance().isLocationDataEnable();
    }

    public static boolean h() {
        return a(n.a("0039dddg%b"));
    }

    public static boolean i() {
        return a("na");
    }

    public static boolean j() {
        return SystemClock.elapsedRealtime() - m.a().c() <= ((long) ((Integer) c.a(n.a("003Cdgbg g"), 600)).intValue()) * 1000;
    }

    private static boolean a(String str) {
        List list = (List) c.a(n.a("003;dgbi1a"), (Object) null);
        if (n.a("003*bibgYb").equals(str)) {
            return list != null && list.contains(n.a("0034bibg-b"));
        }
        if ("na".equals(str)) {
            return list != null && list.contains("na");
        }
        return list == null || list.contains(str);
    }
}
