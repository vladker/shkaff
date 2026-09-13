package cn.fly.tools.utils;

import android.text.TextUtils;
import cn.fly.commons.a.l;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: cn.fly.tools.utils.a$a, reason: collision with other inner class name */
    public static class C0033a {
        public static int A(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, "getDbm", -1, new Object[0])).intValue();
        }

        public static boolean a(Object obj) {
            return ((Boolean) ReflectHelper.invokeInstanceMethodNoThrow(obj, "isRegistered", Boolean.FALSE, new Object[0])).booleanValue();
        }

        public static boolean b(Object obj) {
            return a.a(obj, l.a("029ef-edekelejedemZjghgkiZelPf]fdemfe.ghh!ff?f<fgeljegjeg"));
        }

        public static boolean c(Object obj) {
            return a.a(obj, l.a("030ef8edekelejedem]jghgkiGel.f@fdemfeCghh-ff^fBfgelfeedeg.e"));
        }

        public static boolean d(Object obj) {
            return a.a(obj, l.a("031ef)edekelejedem'jghgkiTelMf3fdemfeJghh'ffGf-fgelhgCd)edeg3e"));
        }

        public static boolean e(Object obj) {
            return a.a(obj, l.a("029efIedekelejedemGjghgki-el@fSfdemfe!ghhDff>f=fgelgf%jg"));
        }

        public static boolean f(Object obj) {
            return a.a(obj, l.a("028ef=edekelejedemQjghgkiEel5f4fdemfeNghhEffFf_fgelfhek"));
        }

        public static Object g(Object obj) {
            return ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("0151fk*gjBfeSghh;ffedHgfj9ej[jVfd"), null, new Object[0]);
        }

        public static int h(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("006.fk gj9id(dd"), -1, new Object[0])).intValue();
        }

        public static int i(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("006UfkGgjQidWfd"), -1, new Object[0])).intValue();
        }

        public static int j(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("006]fk[gj;gfNed"), -1, new Object[0])).intValue();
        }

        public static int k(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("006Ffk5gj6feejed"), -1, new Object[0])).intValue();
        }

        public static int l(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("0063fkWgj)hmgj3d"), -1, new Object[0])).intValue();
        }

        public static int m(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("011Ofk%gjXfmfdgjGjgQegffed"), -1, new Object[0])).intValue();
        }

        public static int n(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("012Ofk0gj@fh:gjJghelekfiffed"), -1, new Object[0])).intValue();
        }

        public static int o(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("011.fkAgj6gfOejUej^j5ehedLg"), -1, new Object[0])).intValue();
        }

        public static int p(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("012NfkEgj7gfel^f$fkejCj)ehed9g"), -1, new Object[0])).intValue();
        }

        public static int q(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, "getBasestationId", -1, new Object[0])).intValue();
        }

        public static int r(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("006 fkCgj7gdPed"), -1, new Object[0])).intValue();
        }

        public static int s(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("005Hfk+gjRfeej"), -1, new Object[0])).intValue();
        }

        public static int t(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("006Xfk<gjRhmXdSej"), -1, new Object[0])).intValue();
        }

        public static int u(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("0094fk*gjThjMe>ekfgIdf"), -1, new Object[0])).intValue();
        }

        public static String v(Object obj) {
            return (String) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("012=fkOgjWidYdd5fmOj+ekej;f2fk"), null, new Object[0]);
        }

        public static String w(Object obj) {
            return (String) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("012]fkMgjTid0fdYfmSj1ekej=f.fk"), null, new Object[0]);
        }

        public static long x(Object obj) {
            return ((Long) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("006Xfk-gj<fhYd8ej"), -1L, new Object[0])).longValue();
        }

        public static int y(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("010YfkJgjEfhek,eVekfg%df"), -1, new Object[0])).intValue();
        }

        public static Object z(Object obj) {
            return ReflectHelper.invokeInstanceMethodNoThrow(obj, "getCellSignalStrength", null, new Object[0]);
        }
    }

    public static boolean a(Object obj, String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(obj.getClass().getName());
    }
}
