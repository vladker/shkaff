package cn.fly.commons;

import android.content.Context;
import android.text.TextUtils;
import cn.fly.tools.FlyLog;
import cn.fly.tools.network.NetCommunicator;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile String f1426a = null;
    private static volatile Boolean b = null;
    private static volatile String c = null;
    private static volatile boolean d = false;
    private static HashSet<String> e = new HashSet<>();

    public static boolean a() {
        return !c.b();
    }

    public static String b() {
        if (a()) {
            return null;
        }
        if (TextUtils.isEmpty(f1426a)) {
            String strD = a.a().d();
            if (!TextUtils.isEmpty(strD) && TextUtils.isEmpty(f1426a)) {
                f1426a = strD;
            }
        }
        return f1426a;
    }

    public static HashMap<String, Object> c() {
        return a.a().f();
    }

    public static a.c d() {
        a.a();
        return a.b();
    }

    public static String a(Context context) {
        return cn.fly.tools.b.c.a(context).d().ap();
    }

    public static String a(FlyProduct flyProduct) {
        HashMap<String, Object> mapB = b(flyProduct);
        if (mapB != null) {
            return (String) mapB.get(NetCommunicator.KEY_DUID);
        }
        return null;
    }

    public static synchronized HashMap<String, Object> b(FlyProduct flyProduct) {
        boolean z6;
        HashMap<String, Object> map;
        if (flyProduct != null) {
            try {
                ad.a(flyProduct);
                boolean zContains = e.contains(flyProduct.getProductTag());
                z6 = !zContains;
                if (!zContains) {
                    e.add(flyProduct.getProductTag());
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            z6 = false;
        }
        if (TextUtils.isEmpty(f1426a)) {
            f1426a = a.a().e();
            z6 = true;
        }
        FlyLog.getInstance().d("aut pro: " + flyProduct + ", ndReg: " + z6 + ", hsReged: " + d, new Object[0]);
        if (z6 || !d) {
            a.a().a(flyProduct, new cn.fly.tools.utils.d<Void>() { // from class: cn.fly.commons.f.1
                @Override // cn.fly.tools.utils.d
                public void a(Void r6) {
                }
            });
            d = true;
        }
        if (b == null) {
            String strB = ae.b().b("key_curr_passed_duid", (String) null);
            c = strB;
            if (!TextUtils.isEmpty(strB) && !strB.equals(f1426a)) {
                b = Boolean.TRUE;
            } else {
                b = Boolean.FALSE;
            }
            ae.b().a("key_curr_passed_duid", f1426a);
        }
        map = new HashMap<>();
        map.put(NetCommunicator.KEY_DUID, f1426a);
        Boolean bool = b;
        bool.booleanValue();
        map.put("isModified", bool);
        map.put("duidPrevious", c);
        return map;
    }
}
