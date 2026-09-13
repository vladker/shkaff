package cn.fly.commons;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.network.NetCommunicator;
import cn.fly.tools.network.NetworkHelper;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.FileLocker;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.ResHelper;
import cn.fly.tools.xcrash.XCrash;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.message.StructuredDataId;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static long c;
    private static AtomicBoolean e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static AtomicBoolean f1294f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static AtomicBoolean f1295g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile HashMap<String, Object> f1296h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static ConcurrentHashMap<String, Object> f1297i = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ConcurrentHashMap<String, Object> f1298j = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static CountDownLatch f1299k = new CountDownLatch(1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static CountDownLatch f1300l = new CountDownLatch(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f1293a = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile boolean f1301m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final AtomicBoolean f1302n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile boolean f1303o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static AtomicInteger f1304p = new AtomicInteger(2);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static volatile int f1305q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static AtomicBoolean f1306r = new AtomicBoolean(false);
    public static long b = 0;
    public static AtomicBoolean d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static ConcurrentHashMap<b, Boolean> f1307s = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static volatile boolean f1308t = false;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile AtomicBoolean f1321a = new AtomicBoolean(false);

        private a() {
        }

        private static void c() {
            new cn.fly.tools.utils.j("PY-CB") { // from class: cn.fly.commons.c.a.1
                @Override // cn.fly.tools.utils.j
                public void a() {
                    FlyLog.getInstance().d("b enter:" + Process.myPid() + ", lbms: " + c.f1301m, new Object[0]);
                    if (!c.f1301m) {
                        FlyLog.getInstance().d("b lk st: " + Process.myPid(), new Object[0]);
                        v.a(v.a(v.f1479f), new u() { // from class: cn.fly.commons.c.a.1.1
                            @Override // cn.fly.commons.u
                            public boolean a(FileLocker fileLocker) {
                                boolean unused = c.f1301m = true;
                                FlyLog.getInstance().d("b lk: " + Process.myPid() + ", proc st", new Object[0]);
                                a.d();
                                c.t();
                                FlyLog.getInstance().d("b lk: " + Process.myPid() + ", proc ed", new Object[0]);
                                return true;
                            }
                        });
                        return;
                    }
                    FlyLog.getInstance().d("b lked already: " + Process.myPid(), new Object[0]);
                    a.d();
                    c.t();
                }
            }.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void d() {
            w.a().b();
            cn.fly.tools.xcrash.c.c();
            if (c.c()) {
                FlyLog.getInstance().d("b db st", new Object[0]);
                f.a((FlyProduct) null);
                cn.fly.commons.a.d.a().b();
                new cn.fly.commons.b.a(FlySDK.getContext()).a();
            }
        }

        public void a() {
            if (((Integer) c.a("dm", 1)).intValue() != 1) {
                j.a().b();
            } else if (f1321a.compareAndSet(false, true)) {
                j.a().c();
            }
            if (!c.f1303o) {
                c.A();
            }
            CountDownLatch countDownLatchD = cn.fly.tools.b.d.a(FlySDK.getContext()).d();
            if (countDownLatchD == null) {
                countDownLatchD = cn.fly.tools.b.d.a(FlySDK.getContext()).a();
            }
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                FlyLog.getInstance().d("ge dhs_w cdl: " + countDownLatchD, new Object[0]);
                countDownLatchD.await(3500L, TimeUnit.MILLISECONDS);
                FlyLog.getInstance().d("ge dhs_w end, dur: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A() {
        if (aa.h() && f1302n.compareAndSet(false, true)) {
            try {
                cn.fly.mgs.impl.b.a();
            } catch (Throwable unused) {
            }
            try {
                cn.fly.tcp.d.a();
            } catch (Throwable unused2) {
            }
        }
    }

    private static void B() {
        if (f1306r.compareAndSet(false, true)) {
            try {
                int iIntValue = ((Integer) a("xerr", 1)).intValue();
                FlyLog.getInstance().d("[NCRASH] meta " + x.f1507k + " nsw " + iIntValue, new Object[0]);
                if (x.f1507k && iIntValue == 1) {
                    String str = FlySDK.getContext().getFilesDir() + cn.fly.commons.a.l.a("001m") + "fvv/fly_tombstones";
                    ResHelper.checkAndCreateDir(str);
                    String strD = cn.fly.tools.b.c.a(FlySDK.getContext()).d().D();
                    if (TextUtils.isEmpty(strD) || !strD.contains("arm64-v8a")) {
                        return;
                    }
                    cn.fly.tools.xcrash.c.b(str);
                    int iInit = XCrash.init(FlySDK.getContext(), new XCrash.a().a(FlySDK.SDK_VERSION_NAME).a(true).d(10).h(4).b(true).i(1).f(1).e(1).g(5).b(str).b(1).c(128).a(1000));
                    FlyLog.getInstance().d("[ncrash] init " + iInit, new Object[0]);
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(androidx.exifinterface.media.a.n("[NCRASH] init error ", th), new Object[0]);
            }
        }
    }

    public static boolean e() {
        return d();
    }

    public static ConcurrentHashMap<String, Object> f() {
        return f1297i;
    }

    public static ConcurrentHashMap<String, Object> g() {
        return f1298j;
    }

    public static ArrayList<String> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(cn.fly.commons.a.l.a("004Nfmfmffgm"));
        arrayList.add(cn.fly.commons.a.l.a("005Zgkfmfmffgm"));
        arrayList.add(cn.fly.commons.a.l.a("005hgFeeSgh"));
        arrayList.add(cn.fly.commons.a.l.a("009Cfgek^gVefehUgfd-fd"));
        arrayList.add(cn.fly.commons.a.l.a("010Keieiei[d)ehekfeel*ff"));
        return (ArrayList) a(cn.fly.commons.a.l.a("004;ghejgj7d"), arrayList);
    }

    public static void i() {
        if (b()) {
            f1308t = true;
            b(false);
        }
    }

    public static void j() {
        f1303o = true;
    }

    private static void s() {
        if (f1305q == -1) {
            HashMap mapFromJson = HashonHelper.fromJson(ae.b().d());
            if (d((HashMap<String, Object>) mapFromJson)) {
                ae.b().f();
                mapFromJson = null;
            }
            if (mapFromJson == null || mapFromJson.isEmpty()) {
                f1305q = 1;
                return;
            }
            f1305q = 0;
            if (b((HashMap<String, Object>) mapFromJson)) {
                a((HashMap<String, Object>) mapFromJson, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t() {
        FlyLog.getInstance().d("b ob st", new Object[0]);
        if (!b() || !c()) {
            if (f1308t || aa.b()) {
                x();
            }
            w();
            return;
        }
        final String str = (String) a(cn.fly.commons.a.l.a("003=fg5fd"), (Object) null);
        if (TextUtils.isEmpty(str)) {
            if (f1308t || aa.b()) {
                x();
            }
            w();
        } else if (f1308t || e.compareAndSet(false, true)) {
            new cn.fly.tools.utils.j("DY") { // from class: cn.fly.commons.c.3
                @Override // cn.fly.tools.utils.j
                public void a() {
                    v.a(v.a(v.d), false, new u() { // from class: cn.fly.commons.c.3.1
                        @Override // cn.fly.commons.u
                        public boolean a(FileLocker fileLocker) {
                            synchronized (c.f1297i) {
                                c.g(str);
                            }
                            return false;
                        }
                    });
                }
            }.start();
        }
        if (!b() || !c()) {
            y();
            u();
            return;
        }
        final String str2 = (String) a("sbr", (Object) null);
        if (TextUtils.isEmpty(str2)) {
            u();
            y();
        } else if (f1308t || f1294f.compareAndSet(false, true)) {
            new cn.fly.tools.utils.j("DS") { // from class: cn.fly.commons.c.4
                @Override // cn.fly.tools.utils.j
                public void a() {
                    v.a(v.a(v.e), false, new u() { // from class: cn.fly.commons.c.4.1
                        @Override // cn.fly.commons.u
                        public boolean a(FileLocker fileLocker) {
                            synchronized (c.f1298j) {
                                c.h(str2);
                            }
                            return false;
                        }
                    });
                }
            }.start();
        }
    }

    private static void u() {
        a(cn.fly.commons.a.l.a("003<gjggWh"), cn.fly.commons.a.l.a("007!emekgj[h;ggek>d"));
    }

    private static void v() {
        new cn.fly.tools.utils.j("PY-NBNG") { // from class: cn.fly.commons.c.5
            @Override // cn.fly.tools.utils.j
            public void a() {
                FlyLog.getInstance().d("b enter:" + Process.myPid() + ", lbms: " + c.f1301m, new Object[0]);
                if (c.f1301m) {
                    FlyLog.getInstance().d("b lked already: " + Process.myPid(), new Object[0]);
                    c.t();
                    return;
                }
                FlyLog.getInstance().d("b lk st: " + Process.myPid(), new Object[0]);
                v.a(v.a(v.f1479f), new u() { // from class: cn.fly.commons.c.5.1
                    @Override // cn.fly.commons.u
                    public boolean a(FileLocker fileLocker) {
                        boolean unused = c.f1301m = true;
                        FlyLog.getInstance().d("b lk: " + Process.myPid() + ", proc st", new Object[0]);
                        c.t();
                        FlyLog.getInstance().d("b lk: " + Process.myPid() + ", proc ed", new Object[0]);
                        return true;
                    }
                });
            }
        }.start();
    }

    private static void w() {
        a(cn.fly.commons.a.l.a("003(gjXdd"), cn.fly.commons.a.l.a("009UidelggXmEemegegOdd"), cn.fly.commons.a.l.a("016Qidelgg3md<elegeg%mSedgggj6m-eged7d"), cn.fly.commons.a.l.a("005Bidehgm!hKee"), cn.fly.commons.a.l.a("012ZemfiBjSigiiiejlifijjlgiie"));
    }

    private static void x() {
        Object obj = v.f1484k;
        synchronized (obj) {
            i.a().a(10);
            obj.notifyAll();
        }
    }

    private static void y() {
        Object obj = v.f1485l;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    private static void z() {
        cn.fly.tools.utils.g.a().a(cn.fly.commons.a.l.a("004Lel'eHejed"), (Integer) 1);
        cn.fly.tools.utils.g.a().a(cn.fly.commons.a.l.a("003ehh"), (Integer) 1);
        cn.fly.tools.utils.g.a().a(cn.fly.commons.a.l.a("003h3elFd"), (Integer) 1);
        cn.fly.tools.utils.g.a().a(cn.fly.commons.a.l.a("002Oghej"), (Integer) 1);
        cn.fly.tools.utils.g.a().a(cn.fly.commons.a.l.a("002Bgggj"), (Integer) 1);
    }

    public static <T> T c(String str, T t6) {
        return (T) a(f1296h, str, t6);
    }

    public static <T> T d(String str, T t6) {
        return (T) a((HashMap<String, Object>) HashonHelper.fromJson(ae.b().d()), str, t6);
    }

    private static boolean e(String str) {
        List list = (List) a(cn.fly.commons.a.l.a("002dh"), (Object) null);
        return (list == null || list.size() == 0 || !list.contains(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static cn.fly.tools.utils.i f(final String str) {
        return new cn.fly.tools.utils.i() { // from class: cn.fly.commons.c.6
            @Override // cn.fly.tools.utils.i
            public void a() {
                cn.fly.tools.c.a.b.set(Boolean.TRUE);
                if (!TextUtils.isEmpty("M-")) {
                    Thread.currentThread().setName("M-" + str);
                }
                c.b(new cn.fly.tools.utils.d<HashMap<String, Object>>() { // from class: cn.fly.commons.c.6.1
                    @Override // cn.fly.tools.utils.d
                    public void a(HashMap<String, Object> map) {
                        try {
                            c.c(map);
                            if (map == null) {
                                cn.fly.commons.a.l.a().c(300000L, c.f(str));
                            }
                        } finally {
                            c.f1295g.set(false);
                        }
                    }
                });
                cn.fly.tools.c.a.b.set(Boolean.FALSE);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(String str) {
        File file = null;
        Closeable closeable = null;
        Closeable closeable2 = null;
        try {
            i.a().a(0);
            String strB = C0396r.b(str);
            File file2 = new File(FlySDK.getContext().getFilesDir(), cn.fly.commons.a.l.a("003Cgj'dd"));
            try {
                if (!k.a().b()) {
                    i.a().a(18);
                    w();
                    return;
                }
                if (TextUtils.isEmpty(strB)) {
                    i.a().a(1);
                    return;
                }
                try {
                    if (d()) {
                        i.a().a(2);
                        HashMap map = (HashMap) new NetCommunicator(1024, "9e87e8d4b8f52f2916d0fb4342aa6b54a81a05666d0bdb23cc5ebf3a07440bc3976adff1ce11c64ddcdbfc017920648217196d51e3165e780e58b5460c525ee9", "13bda4b87eb42ab9e64e6b4f3d17cf8005a4ae94af37bc9fd76ebd91a828f017c81bd63cbe2924e361e20003b9e5f47cdac1f5fba5fca05730a32c5c65869590287207e79a604a2aac429e55f0d35c211367bd226dd5e57df7810f036071854aa1061a0f34b418b9178895a531107c652a428cfa6ecfa65333580ae7e0edf0e1").requestSynchronized(q.e(), strB, false);
                        i.a().a(3);
                        String str2 = (String) map.get(cn.fly.commons.a.l.a("002AfgIh"));
                        String str3 = (String) map.get("m");
                        Boolean bool = (Boolean) map.get(cn.fly.commons.a.l.a("002e:gj"));
                        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                        String str4 = (String) map.get(cn.fly.commons.a.l.a("002eOfi"));
                        String str5 = (String) map.get("cn");
                        String str6 = (String) map.get("fn");
                        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
                            i.a().a(4);
                            ResHelper.deleteFileAndFolder(file2);
                        } else {
                            synchronized (v.f1484k) {
                                try {
                                    f1297i.clear();
                                    f1297i.put("h", str3);
                                    f1297i.put("k", str4);
                                    f1297i.put("cn", str5);
                                    f1297i.put("fn", str6);
                                    String strCheckHttpRequestUrl = NetCommunicator.checkHttpRequestUrl(str2);
                                    if (zBooleanValue) {
                                        i.a().a(5);
                                        File file3 = new File(file2, cn.fly.commons.a.l.a("008d:el^f5fgemgj dd"));
                                        if (!file3.exists() || !str3.equals(Data.MD5(file3))) {
                                            i.a().a(6);
                                            ResHelper.deleteFileAndFolder(file2);
                                            file2.mkdirs();
                                            try {
                                                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                                                try {
                                                    new NetworkHelper().download(strCheckHttpRequestUrl, fileOutputStream, null);
                                                    i.a().a(7);
                                                    C0396r.a(fileOutputStream);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    closeable = fileOutputStream;
                                                    C0396r.a(closeable);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        }
                                    } else {
                                        i.a().a(8);
                                        ResHelper.deleteFileAndFolder(file2);
                                        final byte[][] bArr = new byte[1][];
                                        final int[] iArr = new int[1];
                                        try {
                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream() { // from class: cn.fly.commons.c.8
                                                @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                                                public void close() throws IOException {
                                                    super.close();
                                                    bArr[0] = ((ByteArrayOutputStream) this).buf;
                                                    iArr[0] = ((ByteArrayOutputStream) this).count;
                                                }
                                            };
                                            try {
                                                new NetworkHelper().download(strCheckHttpRequestUrl, byteArrayOutputStream, null);
                                                i.a().a(9);
                                                C0396r.a(byteArrayOutputStream);
                                                f1297i.put("b", bArr[0]);
                                                f1297i.put("s", Integer.valueOf(iArr[0]));
                                            } catch (Throwable th3) {
                                                th = th3;
                                                closeable2 = byteArrayOutputStream;
                                                C0396r.a(closeable2);
                                                throw th;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    throw th5;
                                }
                            }
                        }
                    }
                    x();
                } catch (Throwable th6) {
                    x();
                    throw th6;
                }
            } catch (Throwable th7) {
                th = th7;
                file = file2;
                ResHelper.deleteFileAndFolder(file);
                i.a().a(2, th);
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static <T> T b(String str, T t6) {
        if (TextUtils.isEmpty(str)) {
            return t6;
        }
        if (f1296h != null) {
            return (T) c(str, t6);
        }
        return (T) d(str, t6);
    }

    public static boolean c() {
        return ((Integer) a(cn.fly.commons.a.l.a("004d_elBff"), 0)).intValue() == 1;
    }

    public static boolean d() {
        return ((Integer) a(cn.fly.commons.a.l.a("002fYek"), 0)).intValue() == 1 || aa.a();
    }

    private static CountDownLatch e(HashMap<String, Object> map) {
        HashMap<String, Object> map2;
        CountDownLatch countDownLatchA = cn.fly.tools.b.d.a(FlySDK.getContext()).a((String) ResHelper.forceCast(map.get(cn.fly.commons.a.l.a("002Kgjgj")), null));
        try {
            HashMap<String, Object> map3 = (HashMap) map.get(cn.fly.commons.a.l.a("002g4eg"));
            String str = (String) ResHelper.forceCast((String) map.get(cn.fly.commons.a.l.a("002dVed")), cn.fly.commons.a.l.a("006Nififigigigig"));
            HashMap<String, Object> map4 = (HashMap) map.get(cn.fly.commons.a.l.a("0021fkIk"));
            HashMap map5 = (HashMap) map.get(cn.fly.commons.a.l.a("0048fk3kd>ed"));
            Integer num = (Integer) map.get(cn.fly.commons.a.l.a("004Kfk?g7elEj"));
            if (map3 == null || map3.size() <= 0 || TextUtils.isEmpty(str)) {
                if (map4 == null || map4.size() <= 0 || map5 == null || map5.size() <= 0) {
                    map2 = map;
                } else {
                    map2 = map;
                    a(map2, map3, map4, map5, num, countDownLatchA);
                    k.a().a(map2, map3, map4);
                }
            } else {
                map2 = map;
                a(map2, map3, map4, map5, num, countDownLatchA);
                k.a().a(map2, map3, map4);
            }
            map2.remove(cn.fly.commons.a.l.a("002^fk*k"));
            map2.remove(cn.fly.commons.a.l.a("002gReg"));
            map2.put(cn.fly.commons.a.l.a("010$edEgReeej<dgVgdejeg6g"), Long.valueOf(System.currentTimeMillis()));
            ae.b().c(HashonHelper.fromHashMap(map2));
            z();
            return countDownLatchA;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return countDownLatchA;
        }
    }

    public static void a(final CountDownLatch countDownLatch) {
        s();
        B();
        new cn.fly.tools.utils.j("PY-C") { // from class: cn.fly.commons.c.1
            @Override // cn.fly.tools.utils.j
            public void a() {
                cn.fly.tools.c.a.b.set(Boolean.TRUE);
                FlyLog.getInstance().d("g lk st: " + Process.myPid(), new Object[0]);
                boolean zA = v.a(v.a(v.f1480g), new u() { // from class: cn.fly.commons.c.1.1
                    @Override // cn.fly.commons.u
                    public boolean a(FileLocker fileLocker) {
                        FlyLog.getInstance().d("g lk pd: " + Process.myPid() + ", proc st", new Object[0]);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ae.u();
                        c.c(countDownLatch);
                        FlyLog.getInstance().d("g lk pd: " + Process.myPid() + ", proc ed, dur: " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", release: y", new Object[0]);
                        return false;
                    }
                });
                FlyLog.getInstance().d("g lk res: " + zA + Process.myPid(), new Object[0]);
                cn.fly.tools.c.a.b.set(Boolean.FALSE);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(CountDownLatch countDownLatch) {
        if (b()) {
            a(new b() { // from class: cn.fly.commons.c.2
                @Override // cn.fly.commons.c.b
                public void a() {
                    new a().a();
                }
            }, true);
            if (f1305q == 1) {
                FlyLog.getInstance().d("g ch: n", new Object[0]);
                b(false);
                return;
            }
            FlyLog.getInstance().d("g ch: y", new Object[0]);
            boolean z6 = System.currentTimeMillis() - ae.b().b(ae.f1275m, 0L) < 2000;
            FlyLog.getInstance().d("g ch fre: " + z6, new Object[0]);
            if (z6) {
                if (countDownLatch != null) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        FlyLog.getInstance().d("g dhs_w cdl: " + countDownLatch, new Object[0]);
                        countDownLatch.await(3500L, TimeUnit.MILLISECONDS);
                        FlyLog.getInstance().d("g dhs_w end, dur: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                    } catch (Throwable th) {
                        FlyLog.getInstance().d(th);
                    }
                }
                v();
                return;
            }
            b(true);
        }
    }

    private static boolean d(HashMap<String, Object> map) {
        if (map != null) {
            long jLongValue = ((Long) ResHelper.forceCast(map.get(cn.fly.commons.a.l.a("010Ded)g6eeej_dgNgdejeg_g")), 0L)).longValue();
            long jIntValue = ((long) ((Integer) ResHelper.forceCast(map.get(cn.fly.commons.a.l.a("004BekfkEdLfg")), Integer.valueOf(DateUtil.SECONDS_PER_DAY))).intValue()) * 1000;
            if (jLongValue != 0) {
                if (jIntValue > 0) {
                    return System.currentTimeMillis() - jLongValue >= jIntValue;
                }
                if (jIntValue == 0) {
                    return System.currentTimeMillis() - jLongValue >= DateUtil.DAY_MILLISECONDS;
                }
                return !C0396r.a(System.currentTimeMillis(), jLongValue);
            }
        }
        return false;
    }

    private static boolean b(HashMap<String, Object> map) {
        return map == null || ((Integer) ResHelper.forceCast(map.get(cn.fly.commons.a.l.a("002j5el")), 0)).intValue() == 0;
    }

    public static boolean b() {
        return ((Integer) a(cn.fly.commons.a.l.a("002j(el"), 0)).intValue() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(String str) {
        File file = null;
        try {
            String strB = C0396r.b(str);
            File file2 = new File(FlySDK.getContext().getFilesDir(), cn.fly.commons.a.l.a("0033gjgg$h"));
            try {
                File file3 = new File(FlySDK.getContext().getFilesDir(), cn.fly.commons.a.l.a("007UemekgjCh(ggek=d"));
                if (!k.a().b()) {
                    ResHelper.deleteFileAndFolder(file2);
                    ResHelper.deleteFileAndFolder(file3);
                } else if (TextUtils.isEmpty(strB)) {
                    ResHelper.deleteFileAndFolder(file2);
                } else {
                    if (!d()) {
                        y();
                        return;
                    }
                    HashMap<String, Object> mapE = q.e();
                    mapE.put(cn.fly.commons.a.l.a("0078eeBg%ekgjejel f"), String.valueOf(cn.fly.commons.cc.a.a()));
                    ArrayList arrayList = (ArrayList) ((HashMap) new NetCommunicator(1024, "9e87e8d4b8f52f2916d0fb4342aa6b54a81a05666d0bdb23cc5ebf3a07440bc3976adff1ce11c64ddcdbfc017920648217196d51e3165e780e58b5460c525ee9", "13bda4b87eb42ab9e64e6b4f3d17cf8005a4ae94af37bc9fd76ebd91a828f017c81bd63cbe2924e361e20003b9e5f47cdac1f5fba5fca05730a32c5c65869590287207e79a604a2aac429e55f0d35c211367bd226dd5e57df7810f036071854aa1061a0f34b418b9178895a531107c652a428cfa6ecfa65333580ae7e0edf0e1").requestWithoutEncode(false, NetCommunicator.getCommonDefaultHeaders(), mapE, strB, true)).get(cn.fly.commons.a.l.a("004hZejgj j"));
                    if (arrayList != null && !arrayList.isEmpty()) {
                        synchronized (v.f1485l) {
                            f1298j.clear();
                            f1298j.put(cn.fly.commons.a.l.a("002hj"), arrayList);
                        }
                    }
                    ResHelper.deleteFileAndFolder(file2);
                    ResHelper.deleteFileAndFolder(file3);
                    y();
                    return;
                }
                y();
            } catch (Throwable th) {
                th = th;
                file = file2;
                try {
                    h.a().a(9, -1, th, StructuredDataId.RESERVED);
                    ResHelper.deleteFileAndFolder(file);
                } finally {
                    y();
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a() {
        return d.get();
    }

    public static <T> T a(String str, T t6) {
        if (TextUtils.isEmpty(str) || f1296h == null || !CSCenter.getInstance().isConfigEnable()) {
            return t6;
        }
        if (d(f1296h)) {
            f1296h.clear();
            f1296h = new HashMap<>();
            b(true);
        }
        return (T) ResHelper.forceCast(f1296h.get(str), t6);
    }

    private static void b(boolean z6) {
        if (f1295g.compareAndSet(false, true)) {
            String str = String.format(cn.fly.commons.a.l.a("005(fehdilklgj"), z6 ? ExifInterface.GPS_MEASUREMENT_IN_PROGRESS : ExifInterface.LATITUDE_SOUTH);
            if (z6) {
                ac.f1261a.execute(f(str));
            } else {
                f(str).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final cn.fly.tools.utils.d<HashMap<String, Object>> dVar) {
        cn.fly.tools.c.a.b.set(Boolean.TRUE);
        DH.requester(FlySDK.getContext()).getDetailNetworkTypeForStatic().getODH().request(new DH.DHResponder() { // from class: cn.fly.commons.c.7
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                cn.fly.tools.c.a.b.set(Boolean.TRUE);
                try {
                    HashMap mapB = c.b(dHResponse);
                    while (c.f1304p.get() > 0 && (mapB == null || mapB.isEmpty())) {
                        try {
                            Thread.sleep(30000L);
                        } catch (Throwable th) {
                            FlyLog.getInstance().d(th);
                        }
                        mapB = c.b(dHResponse);
                        if (mapB == null || mapB.isEmpty()) {
                            c.f1304p.getAndDecrement();
                        }
                    }
                    dVar.a(mapB);
                } catch (Throwable th2) {
                    FlyLog.getInstance().d(th2);
                    dVar.a(null);
                }
            }
        });
    }

    private static <T> T a(HashMap<String, Object> map, String str, T t6) {
        return (map == null || TextUtils.isEmpty(str) || d(map) || !b(map)) ? t6 : (T) ResHelper.forceCast(map.get(str), t6);
    }

    public static abstract class b {
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, Object> b(DH.DHResponse dHResponse) {
        try {
            String packageName = DH.SyncMtd.getPackageName();
            String strA = q.a();
            HashMap<String, String> map = new HashMap<>();
            map.put(cn.fly.commons.a.l.a("003Afi:g*fd"), strA);
            map.put(cn.fly.commons.a.l.a("013Qflgj)gOekilffed@gfj]ej5j]fd"), ad.h());
            map.put(cn.fly.commons.a.l.a("004Zegelejed"), dHResponse.getODH());
            HashMap<String, Object> mapA = q.a(dHResponse.getDetailNetworkTypeForStatic());
            mapA.put(cn.fly.commons.a.l.a("002j4gj"), String.valueOf(System.currentTimeMillis()));
            int i5 = 1;
            mapA.put("nbs", 1);
            int privacyGrantedStatus = FlySDK.getPrivacyGrantedStatus();
            if (privacyGrantedStatus != -1) {
                mapA.put(cn.fly.commons.a.l.a("009Dejgjgefkek%gg[hm!k"), String.valueOf(privacyGrantedStatus == 1));
            }
            String strA2 = cn.fly.commons.a.l.a("002(eeii");
            if (!FlySDK.checkV6()) {
                i5 = -1;
            }
            mapA.put(strA2, String.valueOf(i5));
            mapA.put("ait", Long.valueOf(z.a().d()));
            if (ad.d() == 2) {
                FlyLog.getInstance().d("g*f chk PU5H: Nw, psrd", new Object[0]);
                String strT = ae.b().t();
                if (!TextUtils.isEmpty(strT)) {
                    mapA.put("psid", strT);
                }
            } else {
                FlyLog.getInstance().d("g*f chk PU5H: No/Od, psid", new Object[0]);
                String strB = f.b();
                if (!TextUtils.isEmpty(strB)) {
                    mapA.put("psid", strB + packageName);
                }
            }
            String strHttpGet = new NetworkHelper().httpGet(j.a().a("gcfg") + "/v6/gcf", mapA, map);
            HashMap mapFromJson = HashonHelper.fromJson(strHttpGet);
            if (mapFromJson.isEmpty()) {
                return null;
            }
            if ("200".equals(String.valueOf(mapFromJson.get(cn.fly.commons.a.l.a("006@gj'jejHehgj"))))) {
                b = ((Long) mapFromJson.get(cn.fly.commons.a.l.a("009j@ejegEgWgjAje_egNk"))).longValue();
                c = SystemClock.elapsedRealtime();
                byte[] bArrRawMD5 = Data.rawMD5((strA + ParameterizedMessage.ERROR_MSG_SEPARATOR + packageName + ParameterizedMessage.ERROR_MSG_SEPARATOR + b).getBytes("utf-8"));
                String str = (String) ResHelper.forceCast(mapFromJson.get(cn.fly.commons.a.l.a("002,gjEd")));
                if (str != null) {
                    String str2 = new String(Data.AES128Decode(bArrRawMD5, Base64.decode(str, 2)), "utf-8");
                    FlyLog.getInstance().d("sw: ".concat(str2), new Object[0]);
                    HashMap<String, Object> mapFromJson2 = HashonHelper.fromJson(str2);
                    if (!mapFromJson2.isEmpty()) {
                        mapFromJson2.put(cn.fly.commons.a.l.a("010Ted4g5eeej+dgVgdejeg%g"), Long.valueOf(System.currentTimeMillis()));
                        ae.b().d(HashonHelper.fromHashMap(mapFromJson2));
                        return mapFromJson2;
                    }
                    throw new Throwable("RS is illegal: " + strHttpGet);
                }
                throw new Throwable("RS is illegal: " + strHttpGet);
            }
            throw new Throwable("RS is illegal: " + strHttpGet);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    public static <T> T a(String str, T t6, long j6) {
        try {
            if (f1296h == null || f1296h.isEmpty()) {
                if (f1299k.getCount() > 0) {
                    if (j6 > 0) {
                        f1299k.await(j6, TimeUnit.MILLISECONDS);
                    } else {
                        f1299k.await();
                    }
                }
            }
            if (!e(str) && f1300l.getCount() > 0) {
                if (j6 > 0) {
                    f1300l.await(j6, TimeUnit.MILLISECONDS);
                } else {
                    f1300l.await();
                }
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
        return (T) a(str, t6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(HashMap<String, Object> map) {
        if (map == null) {
            HashMap<String, Object> mapFromJson = HashonHelper.fromJson(ae.b().e());
            if (!d(mapFromJson)) {
                map = mapFromJson;
            }
            ae.b().f();
        }
        if (map != null && !map.isEmpty()) {
            e(map);
            FlyLog.getInstance().d("sw fin: " + HashonHelper.fromHashMap(map), new Object[0]);
        }
        a(map, true);
        q.f();
        cn.fly.tools.c.a.b.set(Boolean.FALSE);
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && b() && c() && ((Integer) a(str, 0)).intValue() != 0;
    }

    private static void a(HashMap<String, Object> map, boolean z6) {
        f1296h = new HashMap<>();
        if (map != null) {
            f1296h.putAll(map);
            cn.fly.tools.b.a();
            if (z6) {
                d.set(true);
                ConcurrentHashMap<b, Boolean> concurrentHashMap = f1307s;
                if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                    for (Map.Entry<b, Boolean> entry : f1307s.entrySet()) {
                        a(entry.getKey(), entry.getValue().booleanValue());
                    }
                }
                FlyLog.getInstance().d("olCfLd done", new Object[0]);
            }
        }
        try {
            if (z6) {
                f1299k.countDown();
                f1300l.countDown();
            } else {
                f1299k.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(HashMap<String, Object> map, HashMap<String, Object> map2, HashMap<String, Object> map3, HashMap<String, Object> map4, Integer num, CountDownLatch countDownLatch) {
        if (num != null && num.intValue() == 2) {
            cn.fly.tools.c.a.b.set(Boolean.FALSE);
            try {
                countDownLatch.await(3500L, TimeUnit.MILLISECONDS);
                FlyLog.getInstance().d("dhs wt geot.2 ovr", new Object[0]);
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        boolean zA = k.a().a(true);
        k.a().c().put(cn.fly.commons.a.l.a("006g2egeiekXg5gj"), Boolean.valueOf(zA));
        if (map2 != null && map2.size() > 0 && !zA) {
            FlyLog.getInstance().d("dhs em dg", new Object[0]);
            map.putAll(map2);
        } else {
            if (map3 == null || map3.size() <= 0 || k.a().a(map4)) {
                return;
            }
            FlyLog.getInstance().d("dhs gpe dg", new Object[0]);
            map.putAll(map3);
        }
    }

    private static void a(String... strArr) {
        File filesDir = FlySDK.getContext().getFilesDir();
        for (String str : strArr) {
            try {
                C0396r.a(new File(filesDir, str));
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
    }

    public static void a(b bVar, boolean... zArr) {
        if (bVar != null) {
            synchronized (f1307s) {
                boolean z6 = false;
                if (zArr != null) {
                    try {
                        if (zArr.length > 0 && zArr[0]) {
                            z6 = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (a()) {
                    a(bVar, z6);
                } else {
                    f1307s.put(bVar, Boolean.valueOf(z6));
                }
            }
        }
    }

    private static void a(final b bVar, boolean z6) {
        if (z6) {
            try {
                bVar.a();
                return;
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
                return;
            }
        }
        ac.f1261a.execute(new cn.fly.tools.utils.i() { // from class: cn.fly.commons.c.9
            @Override // cn.fly.tools.utils.i
            public void a() {
                bVar.a();
            }
        });
    }

    public static void a(b bVar) {
        if (bVar != null) {
            synchronized (f1307s) {
                f1307s.remove(bVar);
            }
        }
    }
}
