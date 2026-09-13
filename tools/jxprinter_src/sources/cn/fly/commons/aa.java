package cn.fly.commons;

import A3.AbstractC0157z;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.log.NLog;
import cn.fly.tools.network.NetworkHelper;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.HashonHelper;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1243a = true;
    private static AtomicInteger b = new AtomicInteger(-1);
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static y e = new y();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile String f1244f;

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z6, boolean z7) {
        if (!z7) {
            e.a();
        }
        if (!z6) {
            if (z7) {
                return;
            }
            e.b();
            return;
        }
        if (TextUtils.isEmpty(x.f1501a)) {
            String strL = ae.b().l();
            if (TextUtils.isEmpty(strL)) {
                strL = i();
            }
            if (!TextUtils.isEmpty(strL)) {
                x.c = strL;
                ae.b().e(strL);
            }
        } else {
            x.c = x.f1501a;
            ae.b().e(x.f1501a);
        }
        if (TextUtils.isEmpty(x.b)) {
            String strM = ae.b().m();
            if (!TextUtils.isEmpty(strM)) {
                x.d = strM;
            }
        } else {
            x.d = x.b;
            ae.b().f(x.b);
        }
        CountDownLatch countDownLatchG = g();
        FlyLog.getInstance().d(DH.SyncMtd.isInMainProcess() ? "main" : "sub", new Object[0]);
        if (!z7) {
            a(countDownLatchG);
        } else {
            ad.a();
            c.i();
        }
    }

    public static int d() {
        int iC = c();
        return iC != -1 ? iC : e();
    }

    public static int e() {
        int iB = ae.c() ? z.a().b() : -1;
        FlyLog.getInstance().d(AbstractC0157z.k(iB, "get py grtd status cac: "), new Object[0]);
        return iB;
    }

    public static String f() {
        return "ecpgnjvr<1fxsowaktq0{EKhPmziWUVCNdy2uDJFH|LYZQGTXRO:43l87;/6MI>\"@A?\\9[)_]5=.(S'~盺朼-";
    }

    public static CountDownLatch g() {
        return !d.getAndSet(true) ? cn.fly.tools.b.c.a(FlySDK.getContext()).a() : new CountDownLatch(0);
    }

    public static boolean h() {
        String strA = q.a();
        return (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA.trim()) || TextUtils.equals(strA, i())) ? false : true;
    }

    public static String i() {
        if (f1244f == null) {
            try {
                String packageName = DH.SyncMtd.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    String strCRC32 = Data.CRC32(packageName.getBytes("utf-8"));
                    if (!TextUtils.isEmpty(strCRC32)) {
                        String strByteToHex = Data.byteToHex(strCRC32.getBytes());
                        if (!TextUtils.isEmpty(strByteToHex)) {
                            f1244f = "s" + strByteToHex;
                        }
                    }
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        return f1244f;
    }

    private static void k() {
        try {
            ServerSocketChannel serverSocketChannelOpen = ServerSocketChannel.open();
            serverSocketChannelOpen.configureBlocking(false);
            try {
                serverSocketChannelOpen.socket().bind(new InetSocketAddress(37926));
                w.f1490a = false;
                serverSocketChannelOpen.close();
            } catch (Throwable unused) {
                w.f1490a = true;
            }
        } catch (Throwable unused2) {
        }
    }

    private static void l() {
        m.a().a(new l() { // from class: cn.fly.commons.aa.2
            @Override // cn.fly.commons.l
            public void a(boolean z6, boolean z7, long j6) {
                if (z6) {
                    FlyLog.getInstance().d("fg.", new Object[0]);
                    boolean unused = aa.f1243a = true;
                } else {
                    FlyLog.getInstance().d("bg.", new Object[0]);
                    boolean unused2 = aa.f1243a = false;
                }
            }
        });
    }

    public static int c() {
        FlyLog.getInstance().d("get py grtd status mem: " + b.get(), new Object[0]);
        return b.get();
    }

    public static void a(final boolean z6) {
        ac.f1261a.execute(new cn.fly.tools.utils.i() { // from class: cn.fly.commons.aa.1
            @Override // cn.fly.tools.utils.i
            public void a() {
                cn.fly.tools.c.a.b.set(Boolean.TRUE);
                if (!TextUtils.isEmpty("M-")) {
                    Thread.currentThread().setName("M-" + cn.fly.commons.a.l.a("004%hmjmilig"));
                }
                int iB = ae.c() ? z.a().b() : -1;
                if (aa.b.get() == -1) {
                    aa.b.set(iB);
                }
                if (aa.b.get() == 1) {
                    aa.b(true, z6);
                } else {
                    aa.b(false, z6);
                }
                NLog flyLog = FlyLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append(z6 ? cn.fly.commons.a.l.a("002-ek4g") : "");
                sb.append("init cfg over. py ");
                sb.append(aa.b.get());
                flyLog.d(sb.toString(), new Object[0]);
                cn.fly.tools.c.a.b.set(Boolean.FALSE);
            }
        });
    }

    public static void a(CountDownLatch countDownLatch) {
        if (c.compareAndSet(false, true)) {
            if (z.a().d() == 0) {
                z.a().a(System.currentTimeMillis()).h();
            }
            z.a().c();
            x.a(FlySDK.getContext());
            k();
            l();
            ad.a();
            c.a(countDownLatch);
        }
    }

    public static boolean a() {
        return f1243a;
    }

    public static boolean b() {
        return b.get() == 1;
    }

    public static void b(final boolean z6) {
        b.set(z6 ? 1 : 0);
        FlyLog.getInstance().d("submit py: " + z6, new Object[0]);
        new cn.fly.tools.utils.j(cn.fly.commons.a.l.a("004Yhmjmilif")) { // from class: cn.fly.commons.aa.3
            @Override // cn.fly.tools.utils.j
            public void a() {
                int iE = aa.e();
                z.a().a(z6 ? 1 : 0);
                if (!z6 || iE == 1) {
                    return;
                }
                CountDownLatch countDownLatchG = aa.g();
                FlyLog.getInstance().d(DH.SyncMtd.isInMainProcess() ? "main" : "sub", new Object[0]);
                aa.a(countDownLatchG);
                DH.requester(FlySDK.getContext()).getDetailNetworkTypeForStatic().request(new DH.DHResponder() { // from class: cn.fly.commons.aa.3.1
                    @Override // cn.fly.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse) {
                        try {
                            aa.b(z6, dHResponse.getDetailNetworkTypeForStatic());
                        } catch (Throwable th) {
                            FlyLog.getInstance().d(th);
                            try {
                                aa.b(z6, dHResponse.getDetailNetworkTypeForStatic());
                            } catch (Throwable th2) {
                                FlyLog.getInstance().d(th2);
                            }
                        }
                    }
                });
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z6, String str) throws Throwable {
        HashMap<String, Object> mapA = q.a(str);
        mapA.put(cn.fly.commons.a.l.a("0091ejgjgefkek<gg7hm'k"), String.valueOf(z6));
        String str2 = j.a().a("gclg") + cn.fly.commons.a.l.a("036mk:ekejee4ed%fdXmk*el)h)ejEdUfd1me4eh2jiJelekejhe,ej?ejel%fm'gjRjejYehgj");
        HashMap<String, String> map = new HashMap<>();
        map.put(cn.fly.commons.a.l.a("003Yfi gDfd"), q.a());
        map.put(cn.fly.commons.a.l.a("013FflgjHg.ekilffed?gfjPej6jEfd"), ad.h());
        String strHttpGet = new NetworkHelper().httpGet(str2, mapA, map);
        FlyLog.getInstance().d(AbstractC0157z.n("RS sp: ", strHttpGet), new Object[0]);
        HashMap mapFromJson = HashonHelper.fromJson(strHttpGet);
        if (mapFromJson != null) {
            if (!"200".equals(String.valueOf(mapFromJson.get(cn.fly.commons.a.l.a("004dKeledPg"))))) {
                throw new Throwable(AbstractC0157z.n("RS code is not 200: ", strHttpGet));
            }
            return;
        }
        throw new Throwable(AbstractC0157z.n("RS is illegal: ", strHttpGet));
    }
}
