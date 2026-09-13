package cn.fly.commons;

import android.text.TextUtils;
import android.util.Base64;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.SharePrefrenceHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1267a = cn.fly.commons.a.l.a("009^fiNgWfdeiedejfkCek");
    public static final String b = cn.fly.commons.a.l.a("010Xfi<g+fdei4f?ehLk(ek?d6ed");
    public static final String c = cn.fly.commons.a.l.a("009Zfi$g,fdei4f;ehWheh");
    public static final String d = cn.fly.commons.a.l.a("010KfiAg3fdeigj<f+eh.heh");
    public static final String e = cn.fly.commons.a.l.a("0117fi*gJfdeiTkk[eifkekTj,ed");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f1268f = cn.fly.commons.a.l.a("031$fiMg;fdei2fg,fj@jYeieh]kh2el5e1edeiBekk<ei2edj(ejeeUgTeiOj1ejeg-g");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f1269g = cn.fly.commons.a.l.a("025YfiJg<fdeiggehfgfg%g]ek^gGedeiFhSelNdej%ejelEf[eiegedij");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f1270h = cn.fly.commons.a.l.a("038Ifi-g(fdeiAfgWfj(j3eiehHkhQel)eIedeiggehfgfg g]ek9gJedeiDh:elDdej%ejel_fNei_jMejeg6g");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f1271i = cn.fly.commons.a.l.a("014+ghejfgejei,heZgj]j)eiej3fKfgel");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f1272j = cn.fly.commons.a.l.a("018LfiZgWfdeighejfgejei[h-ejgj_j2ei$ieNgj=i");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f1273k = cn.fly.commons.a.l.a("0302fi-g7fdeiDfgKfj0jJeiehBkhAelYe5edeighejfgejei<h0ejgjIjWeiPj<ejeg?g");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f1274l = cn.fly.commons.a.l.a("012PfiCgCfdeigjghej4jdigTgj");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f1275m = cn.fly.commons.a.l.a("022!fi!g5fdeigjghej:jdigMgjeiZjMejegLgRgjLjeVegIk");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f1276n = cn.fly.commons.a.l.a("019Tfi1g0fdei@ekk.eiUedjBejee;g1ei1jFejeg g");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f1277o = cn.fly.commons.a.l.a("012^fiVg;fdei]dieffgh1gj");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static AtomicBoolean f1278p = new AtomicBoolean(false);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static AtomicBoolean f1279q = new AtomicBoolean(false);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static AtomicBoolean f1280r = new AtomicBoolean(false);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static ae f1281s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private SharePrefrenceHelper f1282t;

    private ae() {
        if (this.f1282t == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(FlySDK.getContext());
            this.f1282t = sharePrefrenceHelper;
            sharePrefrenceHelper.open("fvv_cms", 1);
        }
    }

    public static String a() {
        return "fvv_cms_1";
    }

    public static synchronized ae b() {
        try {
            if (f1281s == null) {
                f1281s = new ae();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1281s;
    }

    public static boolean c() {
        if (FlySDK.getContext() == null) {
            return false;
        }
        if (SharePrefrenceHelper.isMpfFileExist(FlySDK.getContext(), "fvv_cms", 1)) {
            return true;
        }
        boolean zIsMbSpFileExist = SharePrefrenceHelper.isMbSpFileExist(FlySDK.getContext(), "fvv_cms", 1);
        if (zIsMbSpFileExist) {
            return zIsMbSpFileExist;
        }
        return cn.fly.tools.utils.b.a() || cn.fly.tools.utils.b.b();
    }

    public static void u() {
        if (f1278p.compareAndSet(false, true)) {
            new cn.fly.tools.utils.j(cn.fly.commons.a.l.a("004:gmjmilhg")) { // from class: cn.fly.commons.ae.1
                @Override // cn.fly.tools.utils.j
                public void a() {
                    Object obj = v.f1484k;
                    synchronized (obj) {
                        try {
                            obj.wait(600000L);
                            i.a().a(11);
                            ConcurrentHashMap<String, Object> concurrentHashMapF = c.f();
                            if (concurrentHashMapF != null && concurrentHashMapF.size() > 0) {
                                i.a().a(12);
                                Object obj2 = concurrentHashMapF.get("h");
                                Object obj3 = concurrentHashMapF.get("k");
                                Object obj4 = concurrentHashMapF.get("b");
                                Object obj5 = concurrentHashMapF.get("s");
                                Object obj6 = concurrentHashMapF.get("cn");
                                Object obj7 = concurrentHashMapF.get("fn");
                                concurrentHashMapF.clear();
                                d.a(obj2, obj3, obj4, obj5, obj6, obj7);
                            }
                        } catch (Throwable th) {
                            i.a().a(3, th);
                        }
                    }
                }
            }.start();
        }
        w();
    }

    private static String v() {
        return Data.MD5(DH.SyncMtd.getModelForFly());
    }

    private static void w() {
        if (f1279q.compareAndSet(false, true)) {
            new cn.fly.tools.utils.j("DS-W") { // from class: cn.fly.commons.ae.2
                @Override // cn.fly.tools.utils.j
                public void a() {
                    Object obj = v.f1485l;
                    synchronized (obj) {
                        try {
                            obj.wait();
                            ConcurrentHashMap<String, Object> concurrentHashMapG = c.g();
                            ArrayList arrayList = (ArrayList) concurrentHashMapG.get(cn.fly.commons.a.l.a("002hj"));
                            concurrentHashMapG.clear();
                            d.a((ArrayList<HashMap<String, Object>>) arrayList, new cn.fly.tools.utils.d<Void>() { // from class: cn.fly.commons.ae.2.1
                                @Override // cn.fly.tools.utils.d
                                public void a(Void r6) {
                                }
                            });
                        } catch (Throwable th) {
                            FlyLog.getInstance().d(th);
                        }
                    }
                }
            }.start();
        }
        x();
    }

    private static void x() {
        if (f1280r.compareAndSet(false, true)) {
            new cn.fly.tools.utils.j("DS-F") { // from class: cn.fly.commons.ae.3
                @Override // cn.fly.tools.utils.j
                public void a() {
                    Object obj = v.f1486m;
                    synchronized (obj) {
                        try {
                            obj.wait();
                            d.b();
                        } catch (Throwable th) {
                            FlyLog.getInstance().d(th);
                        }
                    }
                }
            }.start();
        }
    }

    public String d() {
        String strB = b(f1274l, (String) null);
        if (!TextUtils.isEmpty(strB)) {
            try {
                String strV = v();
                return Data.AES128PaddingDecode(strV.getBytes("UTF-8"), Base64.decode(strB, 0));
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        return strB;
    }

    public String e() {
        String strB = b("key_gfrt", (String) null);
        if (!TextUtils.isEmpty(strB)) {
            try {
                String strV = v();
                return Data.AES128PaddingDecode(strV.getBytes("UTF-8"), Base64.decode(strB, 0));
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        return strB;
    }

    public void f() {
        c((String) null);
        d((String) null);
    }

    public HashMap<String, Object> g() {
        String strB = b(f1277o, (String) null);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return HashonHelper.fromJson(strB);
    }

    public int h() {
        return b("key_mstrgy", 0);
    }

    @Deprecated
    public long i() {
        return b("key_a_rmt_tm", 0L);
    }

    @Deprecated
    public int j() {
        return b("key_lch_tms", 0);
    }

    @Deprecated
    public boolean k() {
        return b("keyR_drt_lch", false);
    }

    public String l() {
        return b("key_chd_ak", (String) null);
    }

    public String m() {
        return b("key_chd_as", (String) null);
    }

    public HashMap<String, HashMap<String, ArrayList<String>>> n() {
        return HashonHelper.fromJson(b("key_chd_busi_dm", (String) null));
    }

    public HashMap<String, HashMap<String, ArrayList<String>>> o() {
        return HashonHelper.fromJson(b("key_chd_ckd_busi_dm", (String) null));
    }

    public HashMap<String, String> p() {
        return HashonHelper.fromJson(b("key_ckd_busi_dm", (String) null));
    }

    public ArrayList<String> q() {
        HashMap mapFromJson = HashonHelper.fromJson(b("key_chd_prx_dm", (String) null));
        return (mapFromJson == null || mapFromJson.isEmpty()) ? new ArrayList<>() : (ArrayList) mapFromJson.get(cn.fly.commons.a.l.a("008Sfg$e6fi*gh7ejgjBj"));
    }

    public Long r() {
        return Long.valueOf(b("key_dm_lit", 0L));
    }

    @Deprecated
    public long s() {
        return b("key_fst_lnch_tm", 0L);
    }

    public String t() {
        return b("key_rid", (String) null);
    }

    public void a(String str, long j6) {
        this.f1282t.putLong(str, Long.valueOf(j6));
    }

    public void a(String str, int i5) {
        this.f1282t.putInt(str, Integer.valueOf(i5));
    }

    public void f(String str) {
        a("key_chd_as", str);
    }

    public void a(String str, boolean z6) {
        this.f1282t.putBoolean(str, Boolean.valueOf(z6));
    }

    public long b(String str, long j6) {
        return this.f1282t.getLong(str, j6);
    }

    public void g(String str) {
        a("key_rid", str);
    }

    public void a(String str, String str2) {
        if (str2 == null) {
            this.f1282t.remove(str);
        } else {
            this.f1282t.putString(str, str2);
        }
    }

    public int b(String str, int i5) {
        return this.f1282t.getInt(str, i5);
    }

    public Object c(String str, Object obj) {
        return this.f1282t.get(str, obj);
    }

    public boolean b(String str, boolean z6) {
        return this.f1282t.getBoolean(str, z6);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = Base64.encodeToString(Data.AES128Encode(v(), str), 0);
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        a(f1274l, str);
    }

    public void a(String str, Object obj) {
        this.f1282t.put(str, obj);
    }

    public String b(String str, String str2) {
        return this.f1282t.getString(str, str2);
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = Base64.encodeToString(Data.AES128Encode(v(), str), 0);
                a(f1275m, System.currentTimeMillis());
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        a("key_gfrt", str);
    }

    public void e(String str) {
        a("key_chd_ak", str);
    }

    public Object a(String str) {
        return this.f1282t.get(str);
    }

    public void b(String str, Object obj) {
        this.f1282t.put(str, obj);
    }

    public void a(HashMap<String, Object> map) {
        a(f1277o, HashonHelper.fromHashMap(map));
    }

    public void b(String str) {
        this.f1282t.remove(str);
    }

    public void a(int i5) {
        if (i5 >= 0) {
            a("key_mstrgy", i5);
        }
    }

    @Deprecated
    public int b(int i5) {
        return b("key_wt_dys", i5);
    }

    public void a(ArrayList<String> arrayList) {
        a("key_chd_prx_dm", (arrayList == null || arrayList.isEmpty()) ? null : HashonHelper.fromObject(arrayList));
    }

    public void b(HashMap<String, HashMap<String, ArrayList<String>>> map) {
        a("key_chd_busi_dm", HashonHelper.fromHashMap(map));
    }

    public int c(int i5) {
        return b("key_wt_tms", i5);
    }

    public void c(HashMap<String, HashMap<String, ArrayList<String>>> map) {
        a("key_chd_ckd_busi_dm", HashonHelper.fromHashMap(map));
    }

    public void a(Long l6) {
        a("key_dm_lit", l6.longValue());
    }

    public void d(HashMap<String, String> map) {
        a("key_ckd_busi_dm", HashonHelper.fromHashMap(map));
    }
}
