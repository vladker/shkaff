package cn.fly.tcp.impl;

import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.commons.ac;
import cn.fly.commons.ad;
import cn.fly.commons.ae;
import cn.fly.commons.j;
import cn.fly.commons.o;
import cn.fly.commons.q;
import cn.fly.tools.network.NetworkHelper;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.i;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class PSIDManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PSIDManager f1535a;
    private byte[] d = new byte[0];
    private AtomicBoolean e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f1536f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1537g = 1;
    private String c = ae.b().t();
    private String b = cn.fly.tcp.b.a().f();

    public static class NoPsrdException extends Exception {
        public NoPsrdException() {
            super("No PSRD got from Pu5h");
        }
    }

    private PSIDManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            String strB = b();
            cn.fly.tcp.a.c.a().b("chk migrt, nrd: " + strB + ", ord: " + this.c + ", done: " + this.f1536f);
            if (strB.equals(this.c) || !this.f1536f.compareAndSet(false, true)) {
                return;
            }
            if (TextUtils.isEmpty(this.c)) {
                a(strB);
            } else {
                a(this.c, strB);
            }
            ae.b().g(strB);
            this.c = strB;
        } catch (Throwable unused) {
            cn.fly.tcp.a.c.a().b("migr: f");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (cn.fly.tcp.b.a().d() && this.e.compareAndSet(false, true)) {
            b(cn.fly.tcp.b.a().c(), cn.fly.tcp.b.a().e());
        }
    }

    public String c() {
        return this.b + DH.SyncMtd.getPackageName();
    }

    public String d() {
        String strB = b();
        return !TextUtils.isEmpty(strB) ? strB : c();
    }

    public boolean e() {
        String strB = b();
        boolean z6 = (strB == null || strB.equals(this.c)) ? false : true;
        cn.fly.tcp.a.c.a().b("isRsrdChg: " + z6);
        return z6;
    }

    public void f() {
        ac.f1261a.execute(new i() { // from class: cn.fly.tcp.impl.PSIDManager.1
            @Override // cn.fly.tools.utils.i
            public void a() {
                try {
                    int iD = ad.d();
                    cn.fly.tcp.a.c.a().b("chk migrt, pu5h sta: " + iD);
                    if (iD == 1) {
                        PSIDManager.this.h();
                    } else if (iD == 2) {
                        PSIDManager.this.g();
                    }
                } catch (Throwable unused) {
                    cn.fly.tcp.a.c.a().b("migr: f");
                }
            }
        });
    }

    public static PSIDManager a() {
        if (f1535a == null) {
            synchronized (PSIDManager.class) {
                try {
                    if (f1535a == null) {
                        f1535a = new PSIDManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1535a;
    }

    public String b() {
        String str;
        synchronized (this.d) {
            try {
                Callable<Map<String, Object>> callableC = ad.c();
                str = null;
                if (callableC != null) {
                    cn.fly.tcp.a.c.a().b("getPsrd: Nw PU5H");
                    try {
                        Map<String, Object> mapCall = callableC.call();
                        if (mapCall != null && mapCall.containsKey("psid")) {
                            str = (String) mapCall.get("psid");
                        }
                        cn.fly.tcp.a.c.a().b("getPsrd: " + str);
                        if (TextUtils.isEmpty(str)) {
                            cn.fly.tcp.a.c.a().b("getPsrd: No val frm PU5H");
                            throw new NoPsrdException();
                        }
                    } catch (Throwable unused) {
                        cn.fly.tcp.a.c.a().b("getPsrd: Exc frm PU5H");
                        throw new NoPsrdException();
                    }
                } else {
                    cn.fly.tcp.a.c.a().b("getPsrd: No/Od PU5H");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    private void a(String str, String str2) {
        cn.fly.tcp.a.c.a().b("=> rid chg migrt");
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 5000;
        HashMap<String, Object> map = new HashMap<>();
        map.put(o.a("006djjKeh%fWec"), FlySDK.getAppkey());
        map.put(o.a("003j+ehej"), DH.SyncMtd.getPackageName());
        map.put("ridOld", str);
        map.put("ridNew", str2);
        map.put(o.a("004jgdi"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
        map.put("appVer", String.valueOf(DH.SyncMtd.getAppVersion()));
        String str3 = j.a().a("tcig") + "/tcp/push/pbsr";
        cn.fly.tcp.a.c.a().b("url : " + str3 + " -> bd : " + map);
        String strHttpPostNew = new NetworkHelper().httpPostNew(str3, map, null, networkTimeOut);
        cn.fly.tcp.a.c.a().b("url : " + str3 + " -> rp : " + strHttpPostNew);
        HashonHelper.fromJson(strHttpPostNew);
        cn.fly.tcp.a.c.a().b("<= rid chg migrt");
    }

    private void b(String str, String str2) {
        try {
            cn.fly.tcp.a.c.a().b("=> did chg migrt");
            NetworkHelper networkHelper = new NetworkHelper();
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.connectionTimeout = 2000;
            networkTimeOut.readTimout = 5000;
            HashMap<String, Object> map = new HashMap<>();
            map.put(o.a("006djjReh7f,ec"), q.a());
            map.put(o.a("003j8ehej"), DH.SyncMtd.getPackageName());
            map.put("duidOld", str2);
            map.put("duidNew", str);
            map.put("appVer", DH.SyncMtd.getAppVersionName());
            map.put(o.a("004jgdi"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
            String str3 = j.a().a("tcig") + "/tcp/push/pbsd";
            cn.fly.tcp.a.c.a().b("[Request]TP url = " + str3 + "\nheaders = null\nvalues = " + map);
            String strHttpPostNew = networkHelper.httpPostNew(str3, map, null, networkTimeOut);
            cn.fly.tcp.a.c.a().b("[Response]TP url = " + str3 + "\nresp = " + strHttpPostNew);
            HashMap mapFromJson = HashonHelper.fromJson(strHttpPostNew);
            if (mapFromJson != null && !mapFromJson.isEmpty() && !"200".equals(String.valueOf(mapFromJson.get(o.a("004c<dkdc4f"))))) {
                throw new Throwable("Req failed: " + strHttpPostNew);
            }
            cn.fly.tcp.a.c.a().b("<= did chg migrt");
            this.f1537g = 1;
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().a(th);
            int i5 = this.f1537g;
            if (i5 < 3) {
                try {
                    Thread.sleep(i5 * 1000);
                } catch (InterruptedException unused) {
                    cn.fly.tcp.a.c.a().a(th);
                }
                this.f1537g++;
                b(str, str2);
                return;
            }
            this.f1537g = 1;
        }
    }

    private void a(String str) {
        cn.fly.tcp.a.c.a().b("=> d2r migrt");
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 5000;
        HashMap<String, Object> map = new HashMap<>();
        map.put(o.a("006djjTeh2f^ec"), FlySDK.getAppkey());
        map.put(o.a("003jCehej"), DH.SyncMtd.getPackageName());
        map.put("duidOld", this.b);
        map.put("ridNew", str);
        map.put(o.a("004jgdi"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
        map.put("appVer", String.valueOf(DH.SyncMtd.getAppVersion()));
        String str2 = j.a().a("tcig") + "/tcp/push/pdctr";
        cn.fly.tcp.a.c.a().b("url : " + str2 + " -> bd : " + map);
        String strHttpPostNew = new NetworkHelper().httpPostNew(str2, map, null, networkTimeOut);
        cn.fly.tcp.a.c.a().b("url : " + str2 + " -> rp : " + strHttpPostNew);
        HashonHelper.fromJson(strHttpPostNew);
        cn.fly.tcp.a.c.a().b("<= d2r migrt");
    }
}
