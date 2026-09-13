package cn.fly.tools.b;

import A3.AbstractC0157z;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.os.Process;
import cn.fly.tools.FlyLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<Boolean> f1703a = new ThreadLocal<>();
    private static final Map<a, a> b = new IdentityHashMap();
    private static volatile a c;
    private static final String d;
    private static final List<String> e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final j f1704g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f1705f;

    static {
        String strAM = aM();
        d = strAM;
        f1704g = new j(strAM, 12000, new j.a() { // from class: cn.fly.tools.b.h.1
            @Override // cn.fly.tools.b.j.a
            public Object a(String str, ArrayList<Object> arrayList) {
                if (h.c == null) {
                    throw new IllegalStateException("ipc server delegate not ready");
                }
                h.f1703a.set(Boolean.TRUE);
                try {
                    h.h("ipc local invoke start, from server");
                    return h.b(h.c, str, arrayList);
                } finally {
                    h.f1703a.remove();
                }
            }
        });
        e = Arrays.asList("vnmt", "gstmpts", "cinmnps", "gcrtpcnm", "ciafgd", "gaplcn", "qritsvc", "rsaciy", "ctedebbing", "gpsavlb");
    }

    private h(a aVar) {
        this.f1705f = aVar;
    }

    private static String aM() {
        return AbstractC0157z.n("cn.fly.v1.", Integer.toHexString(Process.myUid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object b(a aVar, String str, ArrayList<Object> arrayList) throws Throwable {
        if (aVar == null) {
            throw new IllegalStateException("ipc local target not ready");
        }
        if ("gmpfis".equals(str)) {
            if (arrayList == null || arrayList.size() != 4) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.b(((Boolean) arrayList.get(0)).booleanValue(), ((Integer) arrayList.get(1)).intValue(), (String) arrayList.get(2), ((Integer) arrayList.get(3)).intValue());
        }
        if ("cird".equals(str)) {
            return Boolean.valueOf(aVar.a());
        }
        if ("cx".equals(str)) {
            return Boolean.valueOf(aVar.b());
        }
        if ("ckpd".equals(str)) {
            return Boolean.valueOf(aVar.c());
        }
        if ("degb".equals(str)) {
            return Boolean.valueOf(aVar.d());
        }
        if ("vnmt".equals(str)) {
            return Boolean.valueOf(aVar.e());
        }
        if ("ckua".equals(str)) {
            return Boolean.valueOf(aVar.f());
        }
        if ("dvenbl".equals(str)) {
            return Boolean.valueOf(aVar.g());
        }
        if ("ubenbl".equals(str)) {
            return Boolean.valueOf(aVar.h());
        }
        if ("iwpxy".equals(str)) {
            return Boolean.valueOf(aVar.i());
        }
        if ("gavti".equals(str)) {
            return aVar.j();
        }
        if ("gsimt".equals(str)) {
            return aVar.a(false);
        }
        if ("gsimtfce".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("gbsi".equals(str)) {
            return aVar.b(false);
        }
        if ("gbsifce".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.b(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("gcrie".equals(str)) {
            return aVar.c(false);
        }
        if ("gcriefce".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.c(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("gcriefcestr".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.d(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("gcrnmfce".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.e(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("gcrnmfcestr".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.f(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("gcrnm".equals(str)) {
            return aVar.e(false);
        }
        if ("gmivsn".equals(str)) {
            return aVar.k();
        }
        if ("gmivsnfly".equals(str)) {
            return aVar.l();
        }
        if ("bgmdl".equals(str)) {
            return aVar.m();
        }
        if ("bgmdlfly".equals(str)) {
            return aVar.n();
        }
        if ("gmnft".equals(str)) {
            return aVar.o();
        }
        if ("gmnftfly".equals(str)) {
            return aVar.p();
        }
        if ("gbrd".equals(str)) {
            return aVar.q();
        }
        if ("gbrdfly".equals(str)) {
            return aVar.r();
        }
        if ("gdvtp".equals(str)) {
            return aVar.s();
        }
        if ("gtecloc".equals(str)) {
            return aVar.t();
        }
        if ("gnbclin".equals(str)) {
            return aVar.u();
        }
        if ("wmcwi".equals(str)) {
            return aVar.g(false);
        }
        if ("wmcwifce".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.g(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("govsit".equals(str)) {
            return Integer.valueOf(aVar.w());
        }
        if ("govsitfly".equals(str)) {
            return Integer.valueOf(aVar.x());
        }
        if ("govsnm".equals(str)) {
            return aVar.y();
        }
        if ("govsnmfly".equals(str)) {
            return aVar.z();
        }
        if ("golgu".equals(str)) {
            return aVar.A();
        }
        if ("gocnty".equals(str)) {
            return aVar.B();
        }
        if ("gcuin".equals(str)) {
            return aVar.C();
        }
        if ("gabis".equals(str)) {
            return aVar.D();
        }
        if ("gtydvin".equals(str)) {
            return aVar.E();
        }
        if ("gqmkn".equals(str)) {
            return aVar.F();
        }
        if ("gszin".equals(str)) {
            return aVar.G();
        }
        if ("gmrin".equals(str)) {
            return aVar.H();
        }
        if ("galgu".equals(str)) {
            return aVar.I();
        }
        if ("gscsz".equals(str)) {
            return aVar.J();
        }
        if ("gneyp".equals(str)) {
            return aVar.h(false);
        }
        if ("gneypnw".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.i(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("gneypfce".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.h(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("gnktpfs".equals(str)) {
            return aVar.K();
        }
        if ("gdtlnktpfs".equals(str)) {
            return aVar.L();
        }
        if ("cknavbl".equals(str)) {
            return Boolean.valueOf(aVar.j(false));
        }
        if ("cknavblfc".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return Boolean.valueOf(aVar.j(((Boolean) arrayList.get(0)).booleanValue()));
        }
        if ("gdntp".equals(str)) {
            return Integer.valueOf(aVar.M());
        }
        if ("gdntpstr".equals(str)) {
            return Integer.valueOf(aVar.N());
        }
        if ("gtmne".equals(str)) {
            return aVar.O();
        }
        if ("gflv".equals(str)) {
            return aVar.P();
        }
        if ("gbsbd".equals(str)) {
            return aVar.Q();
        }
        if ("gbfspy".equals(str)) {
            return aVar.R();
        }
        if ("gbplfo".equals(str)) {
            return aVar.S();
        }
        if ("giads".equals(str)) {
            return aVar.T();
        }
        if ("giadsstr".equals(str)) {
            return aVar.U();
        }
        if ("gia".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a(((Boolean) arrayList.get(0)).booleanValue(), false);
        }
        if ("giafce".equals(str)) {
            if (arrayList == null || arrayList.size() != 2) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a(((Boolean) arrayList.get(0)).booleanValue(), ((Boolean) arrayList.get(1)).booleanValue());
        }
        if ("gal".equals(str)) {
            return aVar.V();
        }
        if ("gsl".equals(str)) {
            return aVar.W();
        }
        if ("glctn".equals(str)) {
            if (arrayList == null || arrayList.size() != 3) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a(((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue(), ((Boolean) arrayList.get(2)).booleanValue());
        }
        if ("gstmpts".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a((String) arrayList.get(0));
        }
        if ("gdvk".equals(str)) {
            return aVar.X();
        }
        if ("gdvkfc".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.l(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("ipgist".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return Boolean.valueOf(aVar.b((String) arrayList.get(0)));
        }
        if ("gscpt".equals(str)) {
            return aVar.Y();
        }
        if ("gsnmd".equals(str)) {
            return aVar.Z();
        }
        if ("gsnmdfp".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.c((String) arrayList.get(0));
        }
        if ("gpgnm".equals(str)) {
            return aVar.aa();
        }
        if ("gpnmmt".equals(str)) {
            return aVar.ab();
        }
        if ("gpnmfp".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.d((String) arrayList.get(0));
        }
        if ("gpvsnm".equals(str)) {
            return Integer.valueOf(aVar.ac());
        }
        if ("gpvsme".equals(str)) {
            return aVar.ad();
        }
        if ("cinmnps".equals(str)) {
            return Boolean.valueOf(aVar.ae());
        }
        if ("gcrtpcnm".equals(str)) {
            return aVar.af();
        }
        if ("ciafgd".equals(str)) {
            return Boolean.valueOf(aVar.ag());
        }
        if ("ckpmsi".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return Boolean.valueOf(aVar.e((String) arrayList.get(0)));
        }
        if ("gaplcn".equals(str)) {
            return aVar.ah();
        }
        if ("qritsvc".equals(str)) {
            if (arrayList == null || arrayList.size() != 2) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a((Intent) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
        }
        if ("rsaciy".equals(str)) {
            if (arrayList == null || arrayList.size() != 2) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.b((Intent) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
        }
        if ("gpgif".equals(str)) {
            if (arrayList == null || arrayList.size() != 2) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a(false, 0, (String) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
        }
        if ("gpgiffcin".equals(str)) {
            if (arrayList == null || arrayList.size() != 3) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a(((Boolean) arrayList.get(0)).booleanValue(), 0, (String) arrayList.get(1), ((Integer) arrayList.get(2)).intValue());
        }
        if ("gpgifstrg".equals(str)) {
            if (arrayList == null || arrayList.size() != 3) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a(false, ((Integer) arrayList.get(0)).intValue(), (String) arrayList.get(1), ((Integer) arrayList.get(2)).intValue());
        }
        if ("gpgiffist".equals(str)) {
            if (arrayList == null || arrayList.size() != 4) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a(((Boolean) arrayList.get(0)).booleanValue(), ((Integer) arrayList.get(1)).intValue(), (String) arrayList.get(2), ((Integer) arrayList.get(3)).intValue());
        }
        if ("gdvda".equals(str)) {
            return aVar.ai();
        }
        if ("gdvdtnas".equals(str)) {
            return aVar.aj();
        }
        if ("galtut".equals(str)) {
            return Long.valueOf(aVar.ak());
        }
        if ("gdvme".equals(str)) {
            return aVar.al();
        }
        if ("gcrup".equals(str)) {
            return aVar.am();
        }
        if ("gcifm".equals(str)) {
            return aVar.an();
        }
        if ("godm".equals(str)) {
            return aVar.ao();
        }
        if ("godhm".equals(str)) {
            return aVar.ap();
        }
        if ("galdm".equals(str)) {
            return aVar.aq();
        }
        if ("gtaif".equals(str)) {
            return aVar.ar();
        }
        if ("gtaifok".equals(str)) {
            return aVar.as();
        }
        if ("gtaifprm".equals(str)) {
            if (arrayList == null || arrayList.size() != 2) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a((String) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
        }
        if ("gtaifprmfce".equals(str)) {
            if (arrayList == null || arrayList.size() != 3) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a(((Boolean) arrayList.get(0)).booleanValue(), (String) arrayList.get(1), ((Integer) arrayList.get(2)).intValue());
        }
        if ("gtdrd".equals(str)) {
            return aVar.at();
        }
        if ("gtbdt".equals(str)) {
            return Long.valueOf(aVar.au());
        }
        if ("gtscnin".equals(str)) {
            return Double.valueOf(aVar.av());
        }
        if ("gtscnppi".equals(str)) {
            return Integer.valueOf(aVar.aw());
        }
        if ("ishmos".equals(str)) {
            return Boolean.valueOf(aVar.ax());
        }
        if ("gthmosv".equals(str)) {
            return aVar.ay();
        }
        if ("gthmosdtlv".equals(str)) {
            return aVar.az();
        }
        if ("gthmpmst".equals(str)) {
            return Integer.valueOf(aVar.aA());
        }
        if ("gthmepmst".equals(str)) {
            return Integer.valueOf(aVar.aB());
        }
        if ("gtinnerlangmt".equals(str)) {
            return aVar.aC();
        }
        if ("gtgramgendt".equals(str)) {
            return Integer.valueOf(aVar.aD());
        }
        if ("ctedebbing".equals(str)) {
            return Boolean.valueOf(aVar.aE());
        }
        if ("gtelcmefce".equals(str)) {
            if (arrayList == null || arrayList.size() != 4) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.a(((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue(), ((Boolean) arrayList.get(2)).booleanValue(), ((Boolean) arrayList.get(3)).booleanValue());
        }
        if ("gteacifo".equals(str)) {
            return aVar.aF();
        }
        if ("gtdm".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.m(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("gtlstactme".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return Long.valueOf(aVar.f((String) arrayList.get(0)));
        }
        if ("gpsavlb".equals(str)) {
            return Boolean.valueOf(aVar.aG());
        }
        if ("isaut".equals(str)) {
            return Boolean.valueOf(aVar.aH());
        }
        if ("gtscrpch".equals(str)) {
            return aVar.aI();
        }
        if ("gtrtmey".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.n(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("gppl".equals(str)) {
            if (arrayList == null || arrayList.size() != 1) {
                throw new Throwable(androidx.exifinterface.media.a.o("array illegal: ", arrayList));
            }
            return aVar.k(((Boolean) arrayList.get(0)).booleanValue());
        }
        if ("gtrddi".equals(str)) {
            return aVar.aJ();
        }
        FlyLog.getInstance().d(AbstractC0157z.n("Not found: ", str), new Object[0]);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(String str) {
    }

    @Override // cn.fly.tools.b.a
    public String A() {
        return (String) a(String.class, a("golgu", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String B() {
        return (String) a(String.class, a("gocnty", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Object> C() {
        return (HashMap) a(HashMap.class, a("gcuin", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String D() {
        return (String) a(String.class, a("gabis", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<ArrayList<String>> E() {
        return (ArrayList) a(ArrayList.class, a("gtydvin", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String F() {
        return (String) a(String.class, a("gqmkn", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, HashMap<String, Long>> G() {
        return (HashMap) a(HashMap.class, a("gszin", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Long> H() {
        return (HashMap) a(HashMap.class, a("gmrin", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String I() {
        return (String) a(String.class, a("galgu", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String J() {
        return (String) a(String.class, a("gscsz", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String K() {
        return (String) a(String.class, a("gnktpfs", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String L() {
        return (String) a(String.class, a("gdtlnktpfs", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public int M() {
        return ((Integer) a(Integer.TYPE, a("gdntp", (ArrayList<Object>) null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public int N() {
        return ((Integer) a(Integer.TYPE, a("gdntpstr", (ArrayList<Object>) null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public String O() {
        return (String) a(String.class, a("gtmne", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String P() {
        return (String) a(String.class, a("gflv", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String Q() {
        return (String) a(String.class, a("gbsbd", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String R() {
        return (String) a(String.class, a("gbfspy", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String S() {
        return (String) a(String.class, a("gbplfo", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String T() {
        return (String) a(String.class, a("giads", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String U() {
        return (String) a(String.class, a("giadsstr", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, String>> V() {
        return (ArrayList) a(ArrayList.class, a("gal", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, String>> W() {
        return (ArrayList) a(ArrayList.class, a("gsl", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String X() {
        return (String) a(String.class, a("gdvk", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String Y() {
        return (String) a(String.class, a("gscpt", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String Z() {
        return (String) a(String.class, a("gsnmd", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public int aA() {
        return ((Integer) a(Integer.TYPE, a("gthmpmst", (ArrayList<Object>) null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public int aB() {
        return ((Integer) a(Integer.TYPE, a("gthmepmst", (ArrayList<Object>) null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public String aC() {
        return (String) a(String.class, a("gtinnerlangmt", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public int aD() {
        return ((Integer) a(Integer.TYPE, a("gtgramgendt", (ArrayList<Object>) null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean aE() {
        return ((Boolean) a(Boolean.TYPE, a("ctedebbing", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, Object>> aF() {
        return (ArrayList) a(ArrayList.class, a("gteacifo", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public boolean aG() {
        return ((Boolean) a(Boolean.TYPE, a("gpsavlb", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean aH() {
        return ((Boolean) a(Boolean.TYPE, a("isaut", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String aI() {
        return (String) a(String.class, a("gtscrpch", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String aJ() {
        return (String) a(String.class, a("gtrddi", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String aa() {
        return (String) a(String.class, a("gpgnm", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String ab() {
        return (String) a(String.class, a("gpnmmt", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public int ac() {
        return ((Integer) a(Integer.TYPE, a("gpvsnm", (ArrayList<Object>) null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public String ad() {
        return (String) a(String.class, a("gpvsme", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public boolean ae() {
        return ((Boolean) a(Boolean.TYPE, a("cinmnps", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String af() {
        return (String) a(String.class, a("gcrtpcnm", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public boolean ag() {
        return ((Boolean) a(Boolean.TYPE, a("ciafgd", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public Context ah() {
        return (Context) a(Context.class, a("gaplcn", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String ai() {
        return (String) a(String.class, a("gdvda", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String aj() {
        return (String) a(String.class, a("gdvdtnas", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public long ak() {
        return ((Long) a(Long.TYPE, a("galtut", (ArrayList<Object>) null))).longValue();
    }

    @Override // cn.fly.tools.b.a
    public String al() {
        return (String) a(String.class, a("gdvme", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String am() {
        return (String) a(String.class, a("gcrup", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String an() {
        return (String) a(String.class, a("gcifm", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String ao() {
        return (String) a(String.class, a("godm", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String ap() {
        return (String) a(String.class, a("godhm", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Object> aq() {
        return (HashMap) a(HashMap.class, a("galdm", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public ApplicationInfo ar() {
        return (ApplicationInfo) a(ApplicationInfo.class, a("gtaif", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, Object>> as() {
        return (ArrayList) a(ArrayList.class, a("gtaifok", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String at() {
        return (String) a(String.class, a("gtdrd", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public long au() {
        return ((Long) a(Long.TYPE, a("gtbdt", (ArrayList<Object>) null))).longValue();
    }

    @Override // cn.fly.tools.b.a
    public double av() {
        return ((Double) a(Double.TYPE, a("gtscnin", (ArrayList<Object>) null))).doubleValue();
    }

    @Override // cn.fly.tools.b.a
    public int aw() {
        return ((Integer) a(Integer.TYPE, a("gtscnppi", (ArrayList<Object>) null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean ax() {
        return ((Boolean) a(Boolean.TYPE, a("ishmos", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String ay() {
        return (String) a(String.class, a("gthmosv", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String az() {
        return (String) a(String.class, a("gthmosdtlv", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public boolean c() {
        return ((Boolean) a(Boolean.TYPE, a("ckpd", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean d() {
        return ((Boolean) a(Boolean.TYPE, a("degb", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean e() {
        return ((Boolean) a(Boolean.TYPE, a("vnmt", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean f() {
        return ((Boolean) a(Boolean.TYPE, a("ckua", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean i() {
        return ((Boolean) a(Boolean.TYPE, a("iwpxy", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String j() {
        return (String) a(String.class, a("gavti", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String k() {
        return (String) a(String.class, a("gmivsn", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String l() {
        return (String) a(String.class, a("gmivsnfly", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String m() {
        return (String) a(String.class, a("bgmdl", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String n() {
        return (String) a(String.class, a("bgmdlfly", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String o() {
        return (String) a(String.class, a("gmnft", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String p() {
        return (String) a(String.class, a("gmnftfly", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String q() {
        return (String) a(String.class, a("gbrd", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String r() {
        return (String) a(String.class, a("gbrdfly", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String s() {
        return (String) a(String.class, a("gdvtp", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public Object t() {
        return a(Object.class, a("gtecloc", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, Object>> u() {
        return (ArrayList) a(ArrayList.class, a("gnbclin", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Object> v() {
        return g(false);
    }

    @Override // cn.fly.tools.b.a
    public int w() {
        return ((Integer) a(Integer.TYPE, a("govsit", (ArrayList<Object>) null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public int x() {
        return ((Integer) a(Integer.TYPE, a("govsitfly", (ArrayList<Object>) null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public String y() {
        return (String) a(String.class, a("govsnm", (ArrayList<Object>) null));
    }

    @Override // cn.fly.tools.b.a
    public String z() {
        return (String) a(String.class, a("govsnmfly", (ArrayList<Object>) null));
    }

    public static a a(a aVar) {
        if (aVar == null) {
            return null;
        }
        c = aVar;
        Map<a, a> map = b;
        synchronized (map) {
            try {
                a aVar2 = map.get(aVar);
                if (aVar2 != null) {
                    return aVar2;
                }
                h hVar = new h(aVar);
                map.put(aVar, hVar);
                return hVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // cn.fly.tools.b.a
    public String c(boolean z6) {
        return (String) a(String.class, a("gcriefce", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String d(boolean z6) {
        return (String) a(String.class, a("gcriefcestr", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String e(boolean z6) {
        return (String) a(String.class, a("gcrnmfce", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String f(boolean z6) {
        return (String) a(String.class, a("gcrnmfcestr", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public boolean g() {
        return ((Boolean) a(Boolean.TYPE, a("dvenbl", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean h() {
        return ((Boolean) a(Boolean.TYPE, a("ubenbl", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String i(boolean z6) {
        return (String) a(String.class, a("gneypnw", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public boolean j(boolean z6) {
        return ((Boolean) a(Boolean.TYPE, a("cknavblfc", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public Set<String> k(boolean z6) {
        return (Set) a(Set.class, a("gppl", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String l(boolean z6) {
        return (String) a(String.class, a("gdvkfc", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String m(boolean z6) {
        return (String) a(String.class, a("gtdm", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Long> n(boolean z6) {
        return (HashMap) a(HashMap.class, a("gtrtmey", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Object> g(boolean z6) {
        return (HashMap) a(HashMap.class, a("wmcwifce", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String h(boolean z6) {
        return (String) a(String.class, a("gneypfce", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String c(String str) {
        return (String) a(String.class, a("gsnmdfp", new ArrayList<>(Arrays.asList(str))));
    }

    @Override // cn.fly.tools.b.a
    public String d(String str) {
        return (String) a(String.class, a("gpnmfp", new ArrayList<>(Arrays.asList(str))));
    }

    @Override // cn.fly.tools.b.a
    public boolean e(String str) {
        return ((Boolean) a(Boolean.TYPE, a("ckpmsi", new ArrayList<>(Arrays.asList(str))))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public long f(String str) {
        return ((Long) a(Long.TYPE, a("gtlstactme", new ArrayList<>(Arrays.asList(str))))).longValue();
    }

    private Object a(String str, ArrayList<Object> arrayList) {
        try {
            if (e.contains(str)) {
                h("ipc local invoke start, no need ipc");
                return b(this.f1705f, str, arrayList);
            }
            if (Boolean.TRUE.equals(f1703a.get())) {
                h("ipc local invoke start, in ipc");
                return b(this.f1705f, str, arrayList);
            }
            j jVar = f1704g;
            if (jVar.c()) {
                h("ipc local invoke start, is server");
                return b(this.f1705f, str, arrayList);
            }
            if (!jVar.b()) {
                h("ipc client not ready: " + str);
            }
            try {
                h("ipc ddapi invoke start, k: " + str);
                return jVar.a(str, arrayList);
            } catch (Throwable th) {
                FlyLog.getInstance().w(th, "ipc ddapi request failed, k: %s", str);
                return null;
            }
        } catch (Throwable th2) {
            FlyLog.getInstance().d(th2);
            return null;
        }
    }

    private <T> T a(Class<T> cls, Object obj) {
        Class<T> cls2 = Double.TYPE;
        Class<T> cls3 = Float.TYPE;
        Class<T> cls4 = Long.TYPE;
        Class<T> cls5 = Short.TYPE;
        Class<T> cls6 = Character.TYPE;
        Class<T> cls7 = Byte.TYPE;
        Class<T> cls8 = Integer.TYPE;
        Class<T> cls9 = Boolean.TYPE;
        T tCast = (T) null;
        if (cls != null && obj != null && cls != Void.class) {
            try {
                if (cls == cls9) {
                    tCast = (T) Boolean.class.cast(obj);
                } else if (cls == cls8) {
                    tCast = (T) Integer.class.cast(obj);
                } else if (cls == cls7) {
                    tCast = (T) Byte.class.cast(obj);
                } else if (cls == cls6) {
                    tCast = (T) Character.class.cast(obj);
                } else if (cls == cls5) {
                    tCast = (T) Short.class.cast(obj);
                } else if (cls == cls4) {
                    tCast = (T) Long.class.cast(obj);
                } else if (cls == cls3) {
                    tCast = (T) Float.class.cast(obj);
                } else if (cls == cls2) {
                    tCast = (T) Double.class.cast(obj);
                } else {
                    tCast = cls.cast(obj);
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        if (tCast != null) {
            return tCast;
        }
        if (cls == cls9) {
            return (T) Boolean.FALSE;
        }
        if (cls == cls8) {
            return (T) (-1);
        }
        if (cls == cls7) {
            return (T) (byte) 0;
        }
        if (cls == cls6) {
            return (T) (char) 0;
        }
        if (cls == cls5) {
            return (T) (short) 0;
        }
        if (cls == cls4) {
            return (T) 0L;
        }
        if (cls == cls3) {
            return (T) Float.valueOf(0.0f);
        }
        return cls == cls2 ? (T) Double.valueOf(0.0d) : tCast;
    }

    @Override // cn.fly.tools.b.a
    public boolean a() {
        return ((Boolean) a(Boolean.TYPE, a("cird", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String a(boolean z6) {
        return (String) a(String.class, a("gsimtfce", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, String>> a(boolean z6, boolean z7) {
        return (ArrayList) a(ArrayList.class, a("giafce", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6), Boolean.valueOf(z7)))));
    }

    @Override // cn.fly.tools.b.a
    public Location a(int i5, int i6, boolean z6) {
        return (Location) a(Location.class, a("glctn", new ArrayList<>(Arrays.asList(Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String a(String str) {
        return (String) a(String.class, a("gstmpts", new ArrayList<>(Arrays.asList(str))));
    }

    @Override // cn.fly.tools.b.a
    public List<ResolveInfo> a(Intent intent, int i5) {
        return (List) a(List.class, a("qritsvc", new ArrayList<>(Arrays.asList(intent, Integer.valueOf(i5)))));
    }

    @Override // cn.fly.tools.b.a
    public PackageInfo a(boolean z6, int i5, String str, int i6) {
        return (PackageInfo) a(PackageInfo.class, a("gpgiffist", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6), Integer.valueOf(i5), str, Integer.valueOf(i6)))));
    }

    @Override // cn.fly.tools.b.a
    public ApplicationInfo a(String str, int i5) {
        return (ApplicationInfo) a(ApplicationInfo.class, a("gtaifprm", new ArrayList<>(Arrays.asList(str, Integer.valueOf(i5)))));
    }

    @Override // cn.fly.tools.b.a
    public ApplicationInfo a(boolean z6, String str, int i5) {
        return (ApplicationInfo) a(ApplicationInfo.class, a("gtaifprmfce", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6), str, Integer.valueOf(i5)))));
    }

    @Override // cn.fly.tools.b.a
    public List<HashMap<String, Object>> a(int i5, int i6, boolean z6, boolean z7) {
        return (List) a(List.class, a("gtelcmefce", new ArrayList<>(Arrays.asList(Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z6), Boolean.valueOf(z7)))));
    }

    @Override // cn.fly.tools.b.a
    public boolean b() {
        return ((Boolean) a(Boolean.TYPE, a("cx", (ArrayList<Object>) null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String b(boolean z6) {
        return (String) a(String.class, a("gbsifce", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public boolean b(String str) {
        return ((Boolean) a(Boolean.TYPE, a("ipgist", new ArrayList<>(Arrays.asList(str))))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public ResolveInfo b(Intent intent, int i5) {
        return (ResolveInfo) a(ResolveInfo.class, a("rsaciy", new ArrayList<>(Arrays.asList(intent, Integer.valueOf(i5)))));
    }

    @Override // cn.fly.tools.b.a
    public Object b(boolean z6, int i5, String str, int i6) {
        return a(PackageInfo.class, a("gmpfis", new ArrayList<>(Arrays.asList(Boolean.valueOf(z6), Integer.valueOf(i5), str, Integer.valueOf(i6)))));
    }
}
