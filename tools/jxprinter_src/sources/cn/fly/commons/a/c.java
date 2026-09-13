package cn.fly.commons.a;

import A3.AbstractC0157z;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import cn.fly.FlySDK;
import cn.fly.commons.C0396r;
import cn.fly.commons.FlyProduct;
import cn.fly.commons.ac;
import cn.fly.commons.ad;
import cn.fly.commons.q;
import cn.fly.tools.FlyLog;
import cn.fly.tools.MDP;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.ReflectHelper;
import cn.fly.tools.utils.ResHelper;
import cn.fly.tools.utils.UIHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Runnable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final WeakHashMap<String, Object> f1210k = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Object f1211a;
    private final AtomicInteger b;
    private final String c;
    private final String d;
    private final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f1212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f1213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f1214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1215i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f1216j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f1217l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1218m;

    public c(String str, String str2, long j6) {
        this(str, 0L, str2, 0L, j6);
    }

    private void n() {
        long jB = b();
        if (jB > 0) {
            this.f1213g = (jB * 1000) + System.currentTimeMillis();
        } else {
            this.f1213g = LocationRequestCompat.PASSIVE_INTERVAL;
            this.f1216j = true;
        }
    }

    public c a(Object obj) {
        this.f1211a = obj;
        return this;
    }

    public abstract void a();

    public long b() {
        try {
            String str = this.d;
            if (str != null) {
                return Long.parseLong(String.valueOf(cn.fly.commons.c.a(str, Long.valueOf(this.f1212f))));
            }
            return 0L;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return 0L;
        }
    }

    public void c() {
        this.f1216j = true;
        this.f1217l = 0L;
        this.f1213g = LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public String e() {
        return this.c;
    }

    public boolean f() {
        return !this.f1216j && System.currentTimeMillis() > this.f1213g;
    }

    public boolean g() {
        return ((Long) cn.fly.commons.c.a(this.c, Long.valueOf(this.e))).longValue() != 0 && h();
    }

    public final boolean h() {
        if ("bs,l,ol,wi,wl,ext,aa,".contains(this.c + ",")) {
            return cn.fly.commons.k.a().b();
        }
        return true;
    }

    public boolean i() {
        return this.b.get() == 0;
    }

    public boolean j() {
        if (!g()) {
            return false;
        }
        ac.f1261a.execute(this);
        return true;
    }

    public boolean k() {
        boolean zB = cn.fly.commons.c.b();
        boolean zC = cn.fly.commons.c.c();
        if (!zB || !zC) {
            FlyLog.getInstance().d("slt: " + e() + ", to: " + zB + ", conn: " + zC, new Object[0]);
            return false;
        }
        boolean zG = g();
        FlyLog.getInstance().d("slt : " + getClass().getSimpleName() + ", to: " + zB + ", conn: " + zC + ", " + this.c + ": " + zG + ", key: " + a(this.c, 0) + ", gp: " + b() + " , oce " + this.f1216j + " , tt " + this.b.get(), new Object[0]);
        return zG;
    }

    public int l() {
        return this.f1214h;
    }

    public void m() {
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        cn.fly.tools.utils.g.a().a("fcs_" + this.c, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1217l > 0) {
            l.a().a(this.f1217l, this, this.f1215i);
            this.f1217l = 0L;
            return;
        }
        try {
            if (i()) {
                d();
            }
            if (k() && a(this.c)) {
                a();
            }
            n();
            this.b.incrementAndGet();
        } catch (Throwable th) {
            try {
                FlyLog.getInstance().d(th);
            } finally {
                n();
                this.b.incrementAndGet();
            }
        }
    }

    public c(String str, long j6, String str2, long j7, long j8) {
        this.b = new AtomicInteger(0);
        this.f1215i = 0;
        this.f1216j = false;
        this.f1218m = 0;
        this.c = str;
        this.d = str2;
        this.e = j6;
        this.f1212f = j7;
        this.f1214h = getClass().hashCode();
        this.f1217l = j8;
        this.f1213g = System.currentTimeMillis();
        this.f1218m = ((Integer) cn.fly.commons.c.a("sclt", 0)).intValue();
    }

    public boolean a(String str) {
        if (this.f1218m != 1) {
            return true;
        }
        cn.fly.tools.utils.g gVarA = cn.fly.tools.utils.g.a();
        StringBuilder sb = new StringBuilder("fcs_");
        sb.append(str);
        return System.currentTimeMillis() - gVarA.a(sb.toString(), 1199116800000L) >= b() * 1000;
    }

    public TreeMap<String, Object> b(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            HashMap map = (HashMap) obj;
            TreeMap<String, Object> treeMap = new TreeMap<>();
            treeMap.put("ltdmt", map.get("ltdmt"));
            treeMap.put("lndmt", map.get("lndmt"));
            return treeMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(int i5) {
        this.f1215i = i5;
    }

    public <T> T a(String str, T t6) {
        return (T) cn.fly.commons.c.a(str, t6);
    }

    public void a(final cn.fly.tools.utils.d<HashMap<String, Object>> dVar) {
        if (((Integer) a(cn.fly.commons.o.a("0021dkGg"), 0)).intValue() == 1) {
            DH.requester(FlySDK.getContext()).getPosCommForce(0, 0, true, false).request(new DH.DHResponder() { // from class: cn.fly.commons.a.c.1
                @Override // cn.fly.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    List<HashMap<String, Object>> posCommForce = dHResponse.getPosCommForce(new int[0]);
                    if (posCommForce == null || posCommForce.isEmpty()) {
                        dVar.a(null);
                    } else {
                        dVar.a(posCommForce.get(posCommForce.size() - 1));
                    }
                }
            });
        } else {
            dVar.a(null);
        }
    }

    public void a(long j6, String str, Object obj) {
        a(j6, str, obj, false);
    }

    public void a(long j6, String str, Object obj, boolean z6) {
        a(j6, str, obj, null, z6);
    }

    public void a(long j6, String str, Object obj, HashMap<String, Object> map, boolean z6) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        final long j7 = j6 > 0 ? (j6 * 1000) + jCurrentTimeMillis : jCurrentTimeMillis;
        final HashMap<String, Object> map2 = new HashMap<>();
        map2.put(cn.fly.commons.o.a("004iRecFjf"), str);
        map2.put(cn.fly.commons.o.a("004gJdifi3i"), obj);
        map2.put(cn.fly.commons.o.a("008Xdc>difi%didf6f"), Long.valueOf(jCurrentTimeMillis));
        m();
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        if (z6) {
            a(new cn.fly.tools.utils.d<HashMap<String, Object>>() { // from class: cn.fly.commons.a.c.2
                @Override // cn.fly.tools.utils.d
                public void a(HashMap<String, Object> map3) {
                    map2.put(cn.fly.commons.o.a("002cg"), map3);
                    c.this.a(map3, map2);
                    cn.fly.commons.d.a().a(j7, map2);
                }
            });
        } else {
            cn.fly.commons.d.a().a(j7, map2);
        }
    }

    public void d() {
    }

    public void a(HashMap<String, Object> map, final HashMap<String, Object> map2) {
        if (map == null || C0396r.a(((Long) ResHelper.forceCast(map.get(cn.fly.commons.g.f1427a), Long.valueOf(System.currentTimeMillis()))).longValue(), System.currentTimeMillis())) {
            return;
        }
        DH.requester(FlySDK.getContext()).getPosCommForce(0, 15, false, true).request(new DH.DHResponder() { // from class: cn.fly.commons.a.c.3
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                if (dHResponse.getPosCommForce(new int[0]) == null || dHResponse.getPosCommForce(new int[0]).isEmpty()) {
                    return;
                }
                HashMap map3 = (HashMap) AbstractC0157z.f(1, dHResponse.getPosCommForce(new int[0]));
                map3.put("pt", 2);
                map2.put("nl", map3);
            }
        });
    }

    public void a(String str, HashMap<String, Object> map) {
        a(str, map, false);
    }

    public void a(String str, HashMap<String, Object> map, boolean z6) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final HashMap<String, Object> map2 = new HashMap<>();
        map2.put(cn.fly.commons.o.a("004iPecSjf"), str);
        if (map != null) {
            map2.put(cn.fly.commons.o.a("004]dcAdid"), map);
        }
        map2.put(cn.fly.commons.o.a("008@dcTdifi=didfZf"), Long.valueOf(jCurrentTimeMillis));
        m();
        if (z6) {
            a(new cn.fly.tools.utils.d<HashMap<String, Object>>() { // from class: cn.fly.commons.a.c.4
                @Override // cn.fly.tools.utils.d
                public void a(HashMap<String, Object> map3) {
                    map2.put(cn.fly.commons.o.a("002cg"), map3);
                    c.this.a(map3, map2);
                    cn.fly.commons.d.a().a(jCurrentTimeMillis, map2);
                }
            });
        } else {
            cn.fly.commons.d.a().a(jCurrentTimeMillis, map2);
        }
    }

    public static void a(String str, File file, String str2, String str3) throws Throwable {
        Object objNewInstance;
        Object objInvokeInstanceMethod = ReflectHelper.invokeInstanceMethod(FlySDK.getContext(), cn.fly.commons.o.a("014;ej_fi6ed$gd3fififedkZd:dcIfSdj"), new Object[0]);
        ReflectHelper.importClass(cn.fly.commons.o.a("0280dc dgGdddiehdlfiecfi_if dfdlflMfXeiedGgdZfififedk@d=dc5f!dj"), cn.fly.commons.o.a("0280dc dgGdddiehdlfiecfi_if dfdlflMfXeiedGgdZfififedk@d=dc5f!dj"));
        file.setReadOnly();
        File parentFile = file.getParentFile();
        WeakHashMap<String, Object> weakHashMap = f1210k;
        synchronized (weakHashMap) {
            try {
                objNewInstance = weakHashMap.get(str);
                if (objNewInstance == null) {
                    objNewInstance = ReflectHelper.newInstance(cn.fly.commons.o.a("028%dcZdg+dddiehdlfiecfiKifHdfdlflAfEeied1gdRfififedkDd)dcLf0dj"), file.getAbsolutePath(), parentFile.getAbsolutePath(), parentFile.getAbsolutePath(), objInvokeInstanceMethod);
                    weakHashMap.put(str, objNewInstance);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ResHelper.deleteFileAndFolder(parentFile);
        String strA = cn.fly.commons.f.a((FlyProduct) null);
        final Object objInvokeInstanceMethod2 = ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(objNewInstance, cn.fly.commons.o.a("009g'dkQdNdcedGgd!fifi"), str2), cn.fly.commons.o.a("009.ej0fiMhcRfih'dkdc"), str3, String.class);
        HashMap map = new HashMap();
        map.put(cn.fly.commons.o.a("004Tdcdgdidc"), strA);
        map.put(cn.fly.commons.o.a("004'dfdkdidc"), cn.fly.tools.b.c.a(FlySDK.getContext()).d().ao());
        map.put(cn.fly.commons.o.a("010Sfidcehgk4fAdjfididkPe"), Integer.valueOf(FlySDK.SDK_VERSION_CODE));
        map.put(cn.fly.commons.o.a("006djj@ic<f@ec"), q.a());
        map.put(cn.fly.commons.o.a("009djj)el7fc%djGfi"), FlySDK.getAppSecret());
        map.put(cn.fly.commons.o.a("006[dcdkdf<d?diAe"), FlySDK.getDmn().getDomain());
        map.put(cn.fly.commons.o.a("0108efdkdj2cf*fk>iij[fi"), Boolean.valueOf(FlySDK.checkForceHttps()));
        map.put(cn.fly.commons.o.a("009)efdkdjHcf_ee*j8ddhh"), Boolean.valueOf(FlySDK.checkV6()));
        Long l6 = (Long) cn.fly.commons.c.a(cn.fly.commons.o.a("004fcf^ei"), 5L);
        l6.longValue();
        map.put(cn.fly.commons.o.a("004fcfBei"), l6);
        map.put(cn.fly.commons.o.a("002cIdc"), (String) cn.fly.commons.c.a(cn.fly.commons.o.a("002cCdc"), cn.fly.commons.o.a("0062hehehfhfhfhf")));
        map.put("usridt", ad.f());
        map.put("mdp", MDP.class.getName());
        final String strFromHashMap = HashonHelper.fromHashMap(map);
        ReflectHelper.invokeInstanceMethod(objInvokeInstanceMethod2, cn.fly.commons.o.a("013%fi-fiVfd*ccf]fifidiff?gf"), Boolean.TRUE);
        cn.fly.commons.i.a().a(15);
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.fly.commons.a.c.5
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    cn.fly.commons.i.a().a(16);
                    ReflectHelper.invokeInstanceMethod(objInvokeInstanceMethod2, cn.fly.commons.o.a("006Tdi9eDdddkeh-f"), null, new Object[]{strFromHashMap});
                    cn.fly.commons.i.a().a(17);
                    return false;
                } catch (Throwable th2) {
                    cn.fly.commons.i.a().a(7, th2);
                    return false;
                }
            }
        });
    }

    public static long a(String str, Long l6) {
        Map map = (Map) cn.fly.commons.c.a(cn.fly.commons.o.a("005-fi;g'diQiHfi"), (Object) null);
        if (map == null) {
            return 0L;
        }
        return ((Long) ResHelper.forceCast(map.get(str), l6)).longValue();
    }
}
