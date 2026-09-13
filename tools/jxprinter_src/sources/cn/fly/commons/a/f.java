package cn.fly.commons.a;

import A3.AbstractC0157z;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.commons.ae;
import cn.fly.commons.x;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends c {
    private static volatile a b;

    public class a {
        private long b;
        private long c;
        private AtomicInteger d;

        private a() {
            this.d = new AtomicInteger(0);
            cn.fly.tools.utils.e.a().a(new cn.fly.tools.utils.e.a() { // from class: cn.fly.commons.a.f.a.1
                @Override // cn.fly.tools.utils.e.a
                public void a() {
                    if (cn.fly.commons.c.d()) {
                        if (System.currentTimeMillis() - a.this.b >= ((Integer) cn.fly.commons.c.a("gpdi", 120)).intValue() * 1000) {
                            FlyLog.getInstance().d("[cl] tme > ", new Object[0]);
                            a.this.a();
                            a.this.b = System.currentTimeMillis();
                        }
                        a.this.b();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.d.get() >= 3 || System.currentTimeMillis() - this.c < ((Integer) cn.fly.commons.c.a("gpdi", 120)).intValue() * 1000) {
                return;
            }
            c();
        }

        private void c() {
            float fA;
            Object objC = cn.fly.tools.utils.e.a().c();
            this.d.getAndIncrement();
            this.c = System.currentTimeMillis();
            Object objB = cn.fly.tools.utils.e.a().b();
            if (objC == null || objB == null) {
                fA = 0.0f;
            } else {
                try {
                    fA = new cn.fly.tools.b.i.a(objC).a(objB);
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                    return;
                }
            }
            if (objC != null) {
                if (objB == null || fA > ((Float) cn.fly.commons.c.a("gped", Float.valueOf(10.0f))).floatValue()) {
                    FlyLog.getInstance().d("[cl] cur != las", new Object[0]);
                    cn.fly.tools.utils.e.a().a(objC);
                    f.this.a(objC);
                    d.a().a(f.this, 0L, 0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.d.getAndSet(0);
        }
    }

    public f() {
        super(x.b("002ZcjFf"), 0L, x.b("006Mcj<f di)cig"), 60L, c.a(x.b("002ZcjFf"), (Long) 0L));
    }

    private void n() {
        DH.requester(FlySDK.getContext()).getPosCommForce(0, 0, true, false).getMbcdi().getMcdi().request(new DH.DHResponder() { // from class: cn.fly.commons.a.f.1
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                List<HashMap<String, Object>> posCommForce;
                JSONObject jSONObject;
                if (dHResponse.getPosCommForce(new int[0]) == null || dHResponse.getPosCommForce(new int[0]).isEmpty() || (posCommForce = dHResponse.getPosCommForce(new int[0])) == null || posCommForce.isEmpty()) {
                    return;
                }
                int i5 = 1;
                HashMap<String, Object> map = (HashMap) AbstractC0157z.f(1, posCommForce);
                if (map == null || map.isEmpty()) {
                    return;
                }
                f.this.a(map, map);
                HashMap map2 = map.get("nl") != null ? (HashMap) map.get("nl") : null;
                String mcdi = dHResponse.getMcdi();
                String mbcdi = dHResponse.getMbcdi();
                if (!TextUtils.isEmpty(mbcdi)) {
                    map.put("cbsmt", mbcdi);
                }
                if (!TextUtils.isEmpty(mcdi)) {
                    map.put("cssmt", mcdi);
                }
                if (map2 == null || map2.isEmpty()) {
                    jSONObject = new JSONObject(f.this.b(posCommForce.get(posCommForce.size() - 1)));
                } else {
                    TreeMap treeMap = new TreeMap();
                    treeMap.put("ltdmt", map2.get("ltdmt"));
                    treeMap.put("lndmt", map2.get("lndmt"));
                    jSONObject = new JSONObject(treeMap);
                }
                String strMD5 = Data.MD5(jSONObject.toString());
                ae aeVarB = ae.b();
                String str = ae.f1269g;
                String strB = aeVarB.b(str, (String) null);
                ae aeVarB2 = ae.b();
                String str2 = ae.f1270h;
                long jB = aeVarB2.b(str2, 0L);
                long jLongValue = ((Long) f.this.a(x.b("006Ocj4fWdiNcif"), 3600L)).longValue() * 1000;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(strB) || !strB.equals(strMD5) || jCurrentTimeMillis - jB >= jLongValue) {
                    if (!f.this.i()) {
                        i5 = jCurrentTimeMillis - jB >= jLongValue ? 2 : 3;
                    }
                    map.put("pt", Integer.valueOf(i5));
                    if (map2 != null && !map2.isEmpty()) {
                        map2.put("pt", Integer.valueOf(i5));
                    }
                    f.this.a("O_LCMT", map);
                    ae.b().a(str, strMD5);
                    ae.b().a(str2, jCurrentTimeMillis);
                }
            }
        });
    }

    @Override // cn.fly.commons.a.c
    public void a() {
        if (this.f1211a == null) {
            n();
            return;
        }
        FlyLog.getInstance().d("[cl] paramObj not null", new Object[0]);
        HashMap<String, Object> mapL = new cn.fly.tools.b.i.a(this.f1211a).l();
        if (mapL == null || mapL.isEmpty()) {
            return;
        }
        mapL.put("pt", 4);
        a("O_LCMT", mapL);
    }

    @Override // cn.fly.commons.a.c
    public void d() {
        if (b == null) {
            b = new a();
        }
    }
}
