package cn.fly.commons;

import android.text.TextUtils;
import android.util.Base64;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.network.NetworkHelper;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.HashonHelper;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledExecutorService f1516a = ac.f1262f;

    private boolean c() {
        final boolean[] zArr = {false};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        DH.requester(FlySDK.getContext()).debugable().checkDebbing().isRooted().request(new DH.DHResponder() { // from class: cn.fly.commons.y.1
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                FlyLog.getInstance().d("[PRE] ckDb: " + dHResponse.checkDebbing() + ", db: " + dHResponse.debugable() + ", iRt: " + dHResponse.isRooted(), new Object[0]);
                if (dHResponse.checkDebbing() || dHResponse.debugable() || dHResponse.isRooted()) {
                    zArr[0] = true;
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(300L, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
        }
        return zArr[0] || e() || d() || f();
    }

    private boolean d() {
        String manufacturer = DH.SyncMtd.getManufacturer();
        String brand = DH.SyncMtd.getBrand();
        if (TextUtils.isEmpty(manufacturer) || !manufacturer.toLowerCase().contains(n.a("006'chbibich7ed"))) {
            return !TextUtils.isEmpty(brand) && brand.toLowerCase().contains(n.a("006>chbibichOed"));
        }
        return true;
    }

    private boolean e() {
        try {
            return Class.forName(FlySDK.getContext().getPackageName() + n.a("012Rbjdhbebg%eDbacbbi2c(cdbgch")).getField(n.a("005Ldjegdhcigb")).getBoolean(null);
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean f() {
        try {
            FlySDK.getContext().getClassLoader().loadClass(n.a("021edbUcf9abcb9bhcabjdc9dbJcfcbUbcb.bhca"));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            CountDownLatch countDownLatchG = aa.g();
            FlyLog.getInstance().d(DH.SyncMtd.isInMainProcess() ? "[PRE] main" : "[PRE] sub", new Object[0]);
            c.j();
            aa.a(countDownLatchG);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    private int h() {
        int iIntValue = ((Integer) z.a().b("key_cdt", -1)).intValue();
        return iIntValue != -1 ? iIntValue : new SecureRandom().nextInt(30) + 270;
    }

    private long i() {
        long jLongValue = ((Long) z.a().b("key_nat", 0L)).longValue();
        if (jLongValue != 0) {
            return jLongValue;
        }
        long jD = z.a().d();
        if (jD == 0) {
            jD = System.currentTimeMillis();
            z.a().a(jD);
        }
        long jB = (((long) z.a().b(15)) * DateUtil.DAY_MILLISECONDS) + jD;
        z.a().a("key_nat", Long.valueOf(jB)).h();
        return jB;
    }

    private int j() {
        try {
            int iC = z.a().c(Integer.MIN_VALUE);
            if (iC != Integer.MIN_VALUE) {
                return iC;
            }
            return 0;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return 0;
        }
    }

    private boolean k() {
        try {
            int iB = z.a().b(Integer.MIN_VALUE);
            int iJ = j();
            return (iB == Integer.MIN_VALUE || iB >= 0) && (iJ == Integer.MIN_VALUE || iJ >= 0);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return false;
        }
    }

    public void b() {
        try {
            if (DH.SyncMtd.isAut()) {
                if (!k()) {
                    FlyLog.getInstance().d("[PRE] esc", new Object[0]);
                    return;
                }
                FlyLog.getInstance().d("[PRE] try", new Object[0]);
                boolean z6 = z.a().e() >= j();
                boolean z7 = System.currentTimeMillis() > i();
                boolean zG = z.a().g();
                if (!z7 || !z6) {
                    if (zG) {
                        g();
                    }
                } else {
                    if (c() || DH.SyncMtd.getOSVersionInt() < 17) {
                        return;
                    }
                    a(h());
                }
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    public void a() {
        if (DH.SyncMtd.isAut()) {
            z.a().e(z.a().e() + 1).h();
        }
    }

    private void a(long j6) {
        try {
            cn.fly.tools.utils.i iVar = new cn.fly.tools.utils.i() { // from class: cn.fly.commons.y.2
                @Override // cn.fly.tools.utils.i
                public void a() {
                    try {
                        long jD = z.a().d();
                        HashMap<String, Object> map = new HashMap<>();
                        map.put(n.a("004hebg"), "1");
                        map.put(n.a("006bhhCcf4d^ca"), q.a());
                        map.put(n.a("006=dgcadgbbBd$bh"), String.valueOf(DH.SyncMtd.getOSVersionInt()));
                        map.put(n.a("007Icd4bag=bibhca"), DH.SyncMtd.getManufacturer());
                        map.put(n.a("005!bdbibaGde"), DH.SyncMtd.getModel());
                        map.put(n.a("006bhhh9cfch"), DH.SyncMtd.getPackageName());
                        map.put(n.a("002gRdg"), Long.valueOf(System.currentTimeMillis()));
                        map.put("ait", Long.valueOf(jD));
                        map.put("dc", ad.a(0));
                        map.put("clv", Integer.valueOf(FlySDK.SDK_VERSION_CODE));
                        long jF = z.a().f();
                        if (jF > 0) {
                            map.put("acv", DH.SyncMtd.getAppVersionName());
                            map.put("cvit", Long.valueOf(jF));
                        }
                        String strB = ae.b().b("key_ched_od", (String) null);
                        if (!TextUtils.isEmpty(strB)) {
                            try {
                                strB = Base64.encodeToString(Data.AES128Encode(Data.MD5(DH.SyncMtd.getManufacturer()), strB), 2);
                                map.put(n.a("004Ubdbibgba"), strB);
                            } catch (Throwable th) {
                                FlyLog.getInstance().d(th);
                            }
                        }
                        String strB2 = f.b();
                        if (!TextUtils.isEmpty(strB2)) {
                            map.put(n.a("004Sbabebgba"), strB2);
                        }
                        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                        networkTimeOut.connectionTimeout = 5000;
                        networkTimeOut.readTimout = 3000;
                        String strJsonPost = new NetworkHelper().jsonPost(j.a().a("gcfg") + n.a("007jhbjUchKa(cd"), map, null, networkTimeOut);
                        HashMap mapFromJson = HashonHelper.fromJson(strJsonPost);
                        if (!"200".equals(String.valueOf(mapFromJson.get(n.a("004a*bibaOd"))))) {
                            throw new Throwable("response is illegal: " + strJsonPost);
                        }
                        HashMap map2 = (HashMap) mapFromJson.get(n.a("004TbaJbgb"));
                        if (map2 == null || map2.isEmpty()) {
                            throw new Throwable("data is illegal: " + map2);
                        }
                        z.a().e(0);
                        Object obj = map2.get("wd");
                        int iIntValue = obj != null ? ((Integer) obj).intValue() : 0;
                        Object obj2 = map2.get("wf");
                        int iIntValue2 = obj2 != null ? ((Integer) obj2).intValue() : 0;
                        Object obj3 = map2.get("ds");
                        boolean zBooleanValue = obj3 != null ? ((Boolean) obj3).booleanValue() : false;
                        Object obj4 = map2.get("cdt");
                        int iIntValue3 = obj4 != null ? ((Integer) obj4).intValue() : new SecureRandom().nextInt(30) + 270;
                        Object obj5 = map2.get("ait");
                        if (obj5 instanceof Long) {
                            long jLongValue = ((Long) obj5).longValue();
                            z.a().a("key_nat", Long.valueOf(jD == jLongValue ? (((long) iIntValue) * DateUtil.DAY_MILLISECONDS) + System.currentTimeMillis() : (((long) iIntValue) * DateUtil.DAY_MILLISECONDS) + jLongValue)).a(jLongValue);
                        }
                        Object obj6 = map2.get("ccd");
                        int iIntValue4 = obj6 instanceof Integer ? ((Integer) obj6).intValue() : 0;
                        z.a().d(iIntValue).a("key_wt_tms", Integer.valueOf(iIntValue2)).a("key_iksccd", Integer.valueOf(iIntValue4)).a(zBooleanValue).a("key_cdt", Integer.valueOf(iIntValue3)).h();
                        if (zBooleanValue) {
                            FlyLog.getInstance().d("[PRE] ds", new Object[0]);
                            y.this.g();
                        } else if (iIntValue4 == 1) {
                            b.a().a(strB, strB2);
                        }
                    } catch (Throwable th2) {
                        FlyLog.getInstance().d(th2);
                    }
                }
            };
            FlyLog.getInstance().d("[PRE] dy: " + j6, new Object[0]);
            this.f1516a.schedule(iVar, j6, TimeUnit.SECONDS);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }
}
