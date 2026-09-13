package cn.fly.commons;

import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.xcrash.XCrash;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1471a = false;

    public static void a(boolean z6) {
        try {
            aa.a(z6);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
        }
    }

    public static int b() {
        int iD = aa.d();
        if (iD == 1) {
            return 1;
        }
        return iD == 0 ? -1 : 0;
    }

    public static boolean c() {
        int iB = b();
        if (iB == 2 || iB == 1) {
            return c.c();
        }
        return false;
    }

    public static boolean d() {
        int iB = b();
        if (iB != 2 && iB != 1) {
            return true;
        }
        aa.g();
        return !c.b();
    }

    public static HashMap<String, Object> e() {
        final HashMap<String, Object>[] mapArr = {new HashMap()};
        DH.requester(FlySDK.getContext()).getCarrierStrict(false).getDetailNetworkTypeForStatic().getMIUIVersionForFly().getSignMD5().getODH().request(new DH.DHResponder() { // from class: cn.fly.commons.q.1
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                mapArr[0] = q.a(dHResponse.getDetailNetworkTypeForStatic());
                mapArr[0].put(n.a("0063dgbacfbb:d8bh"), Integer.valueOf(FlySDK.SDK_VERSION_CODE));
                mapArr[0].put(n.a("004=babebgba"), f.a((FlyProduct) null));
                mapArr[0].put(n.a("006bhh2bbUdZbh"), Integer.valueOf(DH.SyncMtd.getAppVersion()));
                mapArr[0].put(n.a("007ab'bhbhbg-d=bh"), dHResponse.getCarrierStrict(new int[0]));
                mapArr[0].put(n.a("005FbdbibaWde"), DH.SyncMtd.getModelForFly());
                mapArr[0].put(n.a("007KcdHbagGbibhca"), DH.SyncMtd.getManufacturerForFly());
                mapArr[0].put(n.a("006*dgcadgbb<d*bh"), DH.SyncMtd.getOSVersionNameForFly());
                mapArr[0].put(n.a("005XbebgbbOd+bh"), dHResponse.getMIUIVersionForFly());
                mapArr[0].put(n.a("009^dgcadgbb6d bhbg<cg"), Integer.valueOf(DH.SyncMtd.getOSVersionIntForFly()));
                mapArr[0].put(n.a("010ae(bgVdcgEdabgbd,d"), Long.valueOf(System.currentTimeMillis()));
                mapArr[0].put(n.a("006bhh+bdbafg"), dHResponse.getSignMD5());
                mapArr[0].put(n.a("005Iddbh$bcFba"), DH.SyncMtd.getBrandForFly());
                mapArr[0].put("usridt", ad.e());
                mapArr[0].put(n.a("004)bdbibgba"), dHResponse.getODH());
            }
        });
        return mapArr[0];
    }

    public static boolean f() {
        boolean zNrInited;
        try {
            zNrInited = XCrash.nrInited();
        } catch (Throwable unused) {
            FlyLog.getInstance().d("[HH] xc not found", new Object[0]);
            zNrInited = false;
        }
        boolean z6 = ((Integer) c.a("nv", 0)).intValue() == 1;
        FlyLog.getInstance().d("[HH] nrspt-r: " + z6 + " nrspt-i: " + zNrInited, new Object[0]);
        return z6 && zNrInited;
    }

    public static String a() {
        if (TextUtils.isEmpty(x.f1501a) && FlySDK.getContext() != null) {
            x.a(FlySDK.getContext());
        }
        if (TextUtils.isEmpty(x.f1501a)) {
            return x.c;
        }
        return x.f1501a;
    }

    public static HashMap<String, Object> a(String str) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(n.a("006bhhDcfLdYca"), a());
        map.put(n.a("006bhhhCcfch"), DH.SyncMtd.getPackageName());
        map.put(n.a("006bhh=bbPd$bh"), DH.SyncMtd.getAppVersionName());
        map.put(n.a("004hebg"), String.valueOf(DH.SyncMtd.getPlatformCode()));
        map.put(n.a("011cdg-debibhcfXg8ca4hd"), str);
        String strB = f.b();
        if (!TextUtils.isEmpty(strB)) {
            map.put(n.a("004^babebgba"), strB);
        }
        return map;
    }

    public static String a(String str, String str2, String str3, boolean z6) {
        if (d()) {
            FlyLog.getInstance().d("isForb: true", new Object[0]);
            return null;
        }
        return j.a().a(str, str2, str3, z6);
    }
}
