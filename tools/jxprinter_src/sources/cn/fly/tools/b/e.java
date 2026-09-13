package cn.fly.tools.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import android.text.TextUtils;
import cn.fly.commons.CSCenter;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.ReflectHelper;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static e b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1698a;
    private Object c;
    private PackageManager d;
    private ConcurrentHashMap<String, Object> e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f1699f = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f1700g = new ConcurrentHashMap<>();

    private e(Context context) {
        this.f1698a = context;
        FlyLog.getInstance().d("[DH] def syi loaded", new Object[0]);
    }

    public static e a(Context context) {
        if (b == null) {
            synchronized (e.class) {
                try {
                    if (b == null) {
                        b = new e(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public ResolveInfo b(Intent intent, int i5) {
        if (cn.fly.commons.e.b()) {
            return (ResolveInfo) ReflectHelper.invokeInstanceMethod(this.f1698a.getPackageManager(), cn.fly.commons.a.l.a("015SekYgWgjel4h7ee*g[ge3dj]ejeeejGjFfd"), new Object[]{intent, Integer.valueOf(i5)}, new Class[]{Intent.class, Integer.TYPE}, null);
        }
        return null;
    }

    public int c() {
        if (DH.SyncMtd.getOSVersionIntForFly() < 24 || !DH.SyncMtd.checkPermission(cn.fly.commons.a.l.a("035ef]edekelejedem>kg$ekegejgjgjejel(f*emhkhjgegmeihmglhifhhjeifmgdgegdhj"))) {
            return -1;
        }
        if (!CSCenter.getInstance().isPhoneStateDataEnable()) {
            return CSCenter.getInstance().getNetworkType();
        }
        if (this.c == null) {
            this.c = DH.SyncMtd.getSystemServiceSafe(cn.fly.commons.a.l.a("005ki'el3fg"));
        }
        return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(this.c, cn.fly.commons.a.l.a("018'fk:gj8gmWejeFfhUgjYghelekfigdfd4kg"), -1, new Object[0])).intValue();
    }

    public ApplicationInfo d() {
        return this.f1698a.getApplicationInfo();
    }

    public Object b(String str) {
        Object systemServiceSafe;
        if (cn.fly.commons.e.f() && cn.fly.tools.utils.e.a().a(str) && (systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(cn.fly.commons.a.l.a("008h9elOdejOejel$f"))) != null) {
            return ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, cn.fly.commons.a.l.a("020UfkSgj?gfSe[gj]jIjd!fJelgh,fRgfel dej+ejel_f"), null, str);
        }
        return null;
    }

    public String a(String str) {
        return a(str, "");
    }

    public String a(String str, String str2) {
        Object objInvokeStaticMethodNoThrow = ReflectHelper.invokeStaticMethodNoThrow(ReflectHelper.importClassNoThrow(cn.fly.commons.a.l.a("027ef]edekelejedemelgjemfmfdgj=jg1eghmekelTkg'ekOj(ejLg*gj"), null), cn.fly.commons.a.l.a("003Ofk*gj"), str2, str);
        return objInvokeStaticMethodNoThrow != null ? String.valueOf(objInvokeStaticMethodNoThrow) : str2;
    }

    public int b() {
        if (!c.a(this.f1698a).d().e(cn.fly.commons.a.l.a("035ef$edekelejedemHkgLekegejgjgjejel)fMemhkhjgegmeihmglhifhhjeifmgdgegdhj"))) {
            return -1;
        }
        if (CSCenter.getInstance().isPhoneStateDataEnable()) {
            if (this.c == null) {
                this.c = DH.SyncMtd.getSystemServiceSafe(cn.fly.commons.a.l.a("005ki>el!fg"));
            }
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(this.c, cn.fly.commons.a.l.a("014.fkDgjZfh!gjQghelekfigdfd-kg"), -1, new Object[0])).intValue();
        }
        return CSCenter.getInstance().getNetworkType();
    }

    public Enumeration<NetworkInterface> a() {
        try {
            return NetworkInterface.getNetworkInterfaces();
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    public List<ResolveInfo> a(Intent intent, int i5) {
        if (cn.fly.commons.e.b()) {
            return (List) ReflectHelper.invokeInstanceMethod(this.f1698a.getPackageManager(), cn.fly.commons.a.l.a("019XefehLgKekfdffAfjgfj-fmHg]ekeeej'dg^gj"), new Object[]{intent, Integer.valueOf(i5)}, new Class[]{Intent.class, Integer.TYPE}, null);
        }
        return null;
    }

    public Object a(String str, int i5, boolean z6) {
        if (this.d == null) {
            this.d = this.f1698a.getPackageManager();
        }
        Class cls = Integer.TYPE;
        if (z6) {
            return DH.SyncMtd.invokeInstanceMethod(this.d, cn.fly.commons.a.l.a("014-fk:gjWhmSed8fi?eMfk0g2ff2fLfgel"), new Object[]{str, Integer.valueOf(i5)}, new Class[]{String.class, cls});
        }
        boolean zEquals = str.equals(DH.SyncMtd.getPackageName());
        if (!zEquals && !cn.fly.commons.e.b()) {
            return null;
        }
        if (DH.SyncMtd.getOSVersionIntForFly() > 25 && !zEquals) {
            Object objA = l.a(this.f1698a, str, i5);
            return objA == null ? DH.SyncMtd.invokeInstanceMethod(this.d, cn.fly.commons.a.l.a("014Ofk:gj>hm%edDfi*e;fk'g(ffWf)fgel"), new Object[]{str, Integer.valueOf(i5)}, new Class[]{String.class, cls}) : objA;
        }
        return DH.SyncMtd.invokeInstanceMethod(this.d, cn.fly.commons.a.l.a("014CfkCgjFhm+edLfi2e=fk0g>ff2f:fgel"), new Object[]{str, Integer.valueOf(i5)}, new Class[]{String.class, cls});
    }

    public void a(String str, long j6, float f6, Object obj) {
        if (cn.fly.commons.e.e()) {
            try {
                if (cn.fly.tools.utils.e.a().a(str)) {
                    Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(cn.fly.commons.a.l.a("008h]el(dejLejel<f"));
                    Class<?> cls = Class.forName(cn.fly.commons.a.l.a("033ef+edekelejedem)hHelNdej9ejelHfWemgfelWdejVejel7f,gfejgjZjgfg5ek"));
                    if (systemServiceSafe != null) {
                        ReflectHelper.invokeInstanceMethod(systemServiceSafe, cn.fly.commons.a.l.a("022>ek%gCefehJg gj%jAgfelJdejGejel1f7fl@k!edBejg4gj"), new Object[]{str, Long.valueOf(j6), Float.valueOf(f6), obj, cn.fly.commons.a.l.a().c()}, new Class[]{String.class, Long.TYPE, Float.TYPE, cls, Looper.class});
                    }
                }
            } catch (Throwable th) {
                FlyLog.getInstance().w(th);
            }
        }
    }

    public Enumeration<InetAddress> a(NetworkInterface networkInterface) {
        return (Enumeration) ReflectHelper.invokeInstanceMethodNoThrow(networkInterface, cn.fly.commons.a.l.a("016:fk[gjXffLfgj9geededek[gDgjgj0gKgj"), null, new Object[0]);
    }

    public ApplicationInfo a(String str, int i5) {
        if (this.d == null) {
            this.d = this.f1698a.getPackageManager();
        }
        if (TextUtils.equals(str, this.f1698a.getPackageName()) || cn.fly.commons.e.b()) {
            return this.d.getApplicationInfo(str, i5);
        }
        return null;
    }
}
