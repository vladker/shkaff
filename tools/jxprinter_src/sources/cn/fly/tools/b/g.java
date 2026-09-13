package cn.fly.tools.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import cn.fly.tools.FlyLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1702a;

    public g(Context context) {
        this.f1702a = context;
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
                } else {
                    tCast = cls == cls2 ? (T) Double.class.cast(obj) : cls.cast(obj);
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
    public String A() {
        return (String) a(String.class, cn.fly.tools.c.a.a("golgu", null));
    }

    @Override // cn.fly.tools.b.a
    public String B() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gocnty", null));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Object> C() {
        return (HashMap) a(HashMap.class, cn.fly.tools.c.a.a("gcuin", null));
    }

    @Override // cn.fly.tools.b.a
    public String D() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gabis", null));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<ArrayList<String>> E() {
        return (ArrayList) a(ArrayList.class, cn.fly.tools.c.a.a("gtydvin", null));
    }

    @Override // cn.fly.tools.b.a
    public String F() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gqmkn", null));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, HashMap<String, Long>> G() {
        return (HashMap) a(HashMap.class, cn.fly.tools.c.a.a("gszin", null));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Long> H() {
        return (HashMap) a(HashMap.class, cn.fly.tools.c.a.a("gmrin", null));
    }

    @Override // cn.fly.tools.b.a
    public String I() {
        return (String) a(String.class, cn.fly.tools.c.a.a("galgu", null));
    }

    @Override // cn.fly.tools.b.a
    public String J() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gscsz", null));
    }

    @Override // cn.fly.tools.b.a
    public String K() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gnktpfs", null));
    }

    @Override // cn.fly.tools.b.a
    public String L() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gdtlnktpfs", null));
    }

    @Override // cn.fly.tools.b.a
    public int M() {
        return ((Integer) a(Integer.TYPE, cn.fly.tools.c.a.a("gdntp", null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public int N() {
        return ((Integer) a(Integer.TYPE, cn.fly.tools.c.a.a("gdntpstr", null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public String O() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gtmne", null));
    }

    @Override // cn.fly.tools.b.a
    public String P() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gflv", null));
    }

    @Override // cn.fly.tools.b.a
    public String Q() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gbsbd", null));
    }

    @Override // cn.fly.tools.b.a
    public String R() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gbfspy", null));
    }

    @Override // cn.fly.tools.b.a
    public String S() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gbplfo", null));
    }

    @Override // cn.fly.tools.b.a
    public String T() {
        return (String) a(String.class, cn.fly.tools.c.a.a("giads", null));
    }

    @Override // cn.fly.tools.b.a
    public String U() {
        return (String) a(String.class, cn.fly.tools.c.a.a("giadsstr", null));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, String>> V() {
        return (ArrayList) a(ArrayList.class, cn.fly.tools.c.a.a("gal", null));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, String>> W() {
        return (ArrayList) a(ArrayList.class, cn.fly.tools.c.a.a("gsl", null));
    }

    @Override // cn.fly.tools.b.a
    public String X() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gdvk", null));
    }

    @Override // cn.fly.tools.b.a
    public String Y() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gscpt", null));
    }

    @Override // cn.fly.tools.b.a
    public String Z() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gsnmd", null));
    }

    @Override // cn.fly.tools.b.a
    public int aA() {
        return ((Integer) a(Integer.TYPE, cn.fly.tools.c.a.a("gthmpmst", null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public int aB() {
        return ((Integer) a(Integer.TYPE, cn.fly.tools.c.a.a("gthmepmst", null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public String aC() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gtinnerlangmt", null));
    }

    @Override // cn.fly.tools.b.a
    public int aD() {
        return ((Integer) a(Integer.TYPE, cn.fly.tools.c.a.a("gtgramgendt", null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean aE() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("ctedebbing", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, Object>> aF() {
        return (ArrayList) a(ArrayList.class, cn.fly.tools.c.a.a("gteacifo", null));
    }

    @Override // cn.fly.tools.b.a
    public boolean aG() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("gpsavlb", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean aH() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("isaut", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String aI() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gtscrpch", null));
    }

    @Override // cn.fly.tools.b.a
    public String aJ() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gtrddi", null));
    }

    @Override // cn.fly.tools.b.a
    public String aa() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gpgnm", null));
    }

    @Override // cn.fly.tools.b.a
    public String ab() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gpnmmt", null));
    }

    @Override // cn.fly.tools.b.a
    public int ac() {
        return ((Integer) a(Integer.TYPE, cn.fly.tools.c.a.a("gpvsnm", null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public String ad() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gpvsme", null));
    }

    @Override // cn.fly.tools.b.a
    public boolean ae() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("cinmnps", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String af() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gcrtpcnm", null));
    }

    @Override // cn.fly.tools.b.a
    public boolean ag() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("ciafgd", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public Context ah() {
        return (Context) a(Context.class, cn.fly.tools.c.a.a("gaplcn", null));
    }

    @Override // cn.fly.tools.b.a
    public String ai() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gdvda", null));
    }

    @Override // cn.fly.tools.b.a
    public String aj() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gdvdtnas", null));
    }

    @Override // cn.fly.tools.b.a
    public long ak() {
        return ((Long) a(Long.TYPE, cn.fly.tools.c.a.a("galtut", null))).longValue();
    }

    @Override // cn.fly.tools.b.a
    public String al() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gdvme", null));
    }

    @Override // cn.fly.tools.b.a
    public String am() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gcrup", null));
    }

    @Override // cn.fly.tools.b.a
    public String an() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gcifm", null));
    }

    @Override // cn.fly.tools.b.a
    public String ao() {
        return (String) a(String.class, cn.fly.tools.c.a.a("godm", null));
    }

    @Override // cn.fly.tools.b.a
    public String ap() {
        return (String) a(String.class, cn.fly.tools.c.a.a("godhm", null));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Object> aq() {
        return (HashMap) a(HashMap.class, cn.fly.tools.c.a.a("galdm", null));
    }

    @Override // cn.fly.tools.b.a
    public ApplicationInfo ar() {
        return (ApplicationInfo) a(ApplicationInfo.class, cn.fly.tools.c.a.a("gtaif", null));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, Object>> as() {
        return (ArrayList) a(ArrayList.class, cn.fly.tools.c.a.a("gtaifok", null));
    }

    @Override // cn.fly.tools.b.a
    public String at() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gtdrd", null));
    }

    @Override // cn.fly.tools.b.a
    public long au() {
        return ((Long) a(Long.TYPE, cn.fly.tools.c.a.a("gtbdt", null))).longValue();
    }

    @Override // cn.fly.tools.b.a
    public double av() {
        return ((Double) a(Double.TYPE, cn.fly.tools.c.a.a("gtscnin", null))).doubleValue();
    }

    @Override // cn.fly.tools.b.a
    public int aw() {
        return ((Integer) a(Integer.TYPE, cn.fly.tools.c.a.a("gtscnppi", null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean ax() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("ishmos", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String ay() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gthmosv", null));
    }

    @Override // cn.fly.tools.b.a
    public String az() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gthmosdtlv", null));
    }

    @Override // cn.fly.tools.b.a
    public boolean b() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("cx", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean c() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("ckpd", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean d() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("degb", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean e() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("vnmt", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean f() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("ckua", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean g() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("dvenbl", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean h() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("ubenbl", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean i() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("iwpxy", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String j() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gavti", null));
    }

    @Override // cn.fly.tools.b.a
    public String k() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gmivsn", null));
    }

    @Override // cn.fly.tools.b.a
    public String l() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gmivsnfly", null));
    }

    @Override // cn.fly.tools.b.a
    public String m() {
        return (String) a(String.class, cn.fly.tools.c.a.a("bgmdl", null));
    }

    @Override // cn.fly.tools.b.a
    public String n() {
        return (String) a(String.class, cn.fly.tools.c.a.a("bgmdlfly", null));
    }

    @Override // cn.fly.tools.b.a
    public String o() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gmnft", null));
    }

    @Override // cn.fly.tools.b.a
    public String p() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gmnftfly", null));
    }

    @Override // cn.fly.tools.b.a
    public String q() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gbrd", null));
    }

    @Override // cn.fly.tools.b.a
    public String r() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gbrdfly", null));
    }

    @Override // cn.fly.tools.b.a
    public String s() {
        return (String) a(String.class, cn.fly.tools.c.a.a("gdvtp", null));
    }

    @Override // cn.fly.tools.b.a
    public Object t() {
        return a(Object.class, cn.fly.tools.c.a.a("gtecloc", null));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, Object>> u() {
        return (ArrayList) a(ArrayList.class, cn.fly.tools.c.a.a("gnbclin", null));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Object> v() {
        return g(false);
    }

    @Override // cn.fly.tools.b.a
    public int w() {
        return ((Integer) a(Integer.TYPE, cn.fly.tools.c.a.a("govsit", null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public int x() {
        return ((Integer) a(Integer.TYPE, cn.fly.tools.c.a.a("govsitfly", null))).intValue();
    }

    @Override // cn.fly.tools.b.a
    public String y() {
        return (String) a(String.class, cn.fly.tools.c.a.a("govsnm", null));
    }

    @Override // cn.fly.tools.b.a
    public String z() {
        return (String) a(String.class, cn.fly.tools.c.a.a("govsnmfly", null));
    }

    @Override // cn.fly.tools.b.a
    public String b(boolean z6) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gbsifce", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String c(boolean z6) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gcriefce", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String d(boolean z6) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gcriefcestr", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String e(boolean z6) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gcrnmfce", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String f(boolean z6) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gcrnmfcestr", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Object> g(boolean z6) {
        return (HashMap) a(HashMap.class, cn.fly.tools.c.a.a("wmcwifce", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String h(boolean z6) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gneypfce", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String i(boolean z6) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gneypnw", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public boolean j(boolean z6) {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("cknavblfc", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public Set<String> k(boolean z6) {
        return (Set) a(Set.class, cn.fly.tools.c.a.a("gppl", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String l(boolean z6) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gdvkfc", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String m(boolean z6) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gtdm", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Long> n(boolean z6) {
        return (HashMap) a(HashMap.class, cn.fly.tools.c.a.a("gtrtmey", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public boolean b(String str) {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("ipgist", new ArrayList(Arrays.asList(str))))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String c(String str) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gsnmdfp", new ArrayList(Arrays.asList(str))));
    }

    @Override // cn.fly.tools.b.a
    public String d(String str) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gpnmfp", new ArrayList(Arrays.asList(str))));
    }

    @Override // cn.fly.tools.b.a
    public boolean e(String str) {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("ckpmsi", new ArrayList(Arrays.asList(str))))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public long f(String str) {
        return ((Long) a(Long.TYPE, cn.fly.tools.c.a.a("gtlstactme", new ArrayList(Arrays.asList(str))))).longValue();
    }

    @Override // cn.fly.tools.b.a
    public ResolveInfo b(Intent intent, int i5) {
        return (ResolveInfo) a(ResolveInfo.class, cn.fly.tools.c.a.a("rsaciy", new ArrayList(Arrays.asList(intent, Integer.valueOf(i5)))));
    }

    @Override // cn.fly.tools.b.a
    public Object b(boolean z6, int i5, String str, int i6) {
        return a(PackageInfo.class, cn.fly.tools.c.a.a("gmpfis", new ArrayList(Arrays.asList(Boolean.valueOf(z6), Integer.valueOf(i5), str, Integer.valueOf(i6)))));
    }

    @Override // cn.fly.tools.b.a
    public boolean a() {
        return ((Boolean) a(Boolean.TYPE, cn.fly.tools.c.a.a("cird", null))).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String a(boolean z6) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gsimtfce", new ArrayList(Arrays.asList(Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, String>> a(boolean z6, boolean z7) {
        return (ArrayList) a(ArrayList.class, cn.fly.tools.c.a.a("giafce", new ArrayList(Arrays.asList(Boolean.valueOf(z6), Boolean.valueOf(z7)))));
    }

    @Override // cn.fly.tools.b.a
    public Location a(int i5, int i6, boolean z6) {
        return (Location) a(Location.class, cn.fly.tools.c.a.a("glctn", new ArrayList(Arrays.asList(Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z6)))));
    }

    @Override // cn.fly.tools.b.a
    public String a(String str) {
        return (String) a(String.class, cn.fly.tools.c.a.a("gstmpts", new ArrayList(Arrays.asList(str))));
    }

    @Override // cn.fly.tools.b.a
    public List<ResolveInfo> a(Intent intent, int i5) {
        return (List) a(List.class, cn.fly.tools.c.a.a("qritsvc", new ArrayList(Arrays.asList(intent, Integer.valueOf(i5)))));
    }

    @Override // cn.fly.tools.b.a
    public PackageInfo a(boolean z6, int i5, String str, int i6) {
        return (PackageInfo) a(PackageInfo.class, cn.fly.tools.c.a.a("gpgiffist", new ArrayList(Arrays.asList(Boolean.valueOf(z6), Integer.valueOf(i5), str, Integer.valueOf(i6)))));
    }

    @Override // cn.fly.tools.b.a
    public ApplicationInfo a(String str, int i5) {
        return (ApplicationInfo) a(ApplicationInfo.class, cn.fly.tools.c.a.a("gtaifprm", new ArrayList(Arrays.asList(str, Integer.valueOf(i5)))));
    }

    @Override // cn.fly.tools.b.a
    public ApplicationInfo a(boolean z6, String str, int i5) {
        return (ApplicationInfo) a(ApplicationInfo.class, cn.fly.tools.c.a.a("gtaifprmfce", new ArrayList(Arrays.asList(Boolean.valueOf(z6), str, Integer.valueOf(i5)))));
    }

    @Override // cn.fly.tools.b.a
    public List<HashMap<String, Object>> a(int i5, int i6, boolean z6, boolean z7) {
        return (List) a(List.class, cn.fly.tools.c.a.a("gtelcmefce", new ArrayList(Arrays.asList(Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z6), Boolean.valueOf(z7)))));
    }
}
