package cn.fly.tools.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import cn.fly.FlySDK;
import cn.fly.commons.C0396r;
import cn.fly.commons.ac;
import cn.fly.commons.m;
import cn.fly.tools.FlyLog;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes.dex */
public class DH {
    public static final int GPI_STRATEGY_VALIDITY_3_MINUTE = 180000;
    public static final int GPI_STRATEGY_VALIDITY_ALL = 0;

    public interface DHResponder {
        void onResponse(DHResponse dHResponse);
    }

    public static class DHResponse {

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        private ArrayList<HashMap<String, String>> f1830C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        private String f1831D;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        private Object f1833F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        private ArrayList<HashMap<String, Object>> f1834G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        private String f1835H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        private HashMap<String, Object> f1836I;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        private HashMap<String, Object> f1838K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        private String f1839L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        private ArrayList<ArrayList<String>> f1840M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        private String f1841N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        private HashMap<String, HashMap<String, Long>> f1842O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        private HashMap<String, Long> f1843P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        private String f1844Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        private String f1845R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        private boolean f1846S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        private boolean f1847T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        private boolean f1848U;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        private boolean f1849V;

        /* JADX INFO: renamed from: W, reason: collision with root package name */
        private boolean f1850W;

        /* JADX INFO: renamed from: X, reason: collision with root package name */
        private boolean f1851X;

        /* JADX INFO: renamed from: Y, reason: collision with root package name */
        private boolean f1852Y;

        /* JADX INFO: renamed from: Z, reason: collision with root package name */
        private boolean f1853Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1854a;
        private String aA;
        private String aB;
        private long aC;
        private double aD;
        private int aE;
        private boolean aF;
        private String aG;
        private String aH;
        private int aI;
        private int aJ;
        private String aK;
        private int aL;
        private HashMap<String, Object> aN;
        private ArrayList<HashMap<String, Object>> aP;
        private String aQ;
        private String aS;
        private boolean aU;
        private ArrayList<HashMap<String, Object>> aV;
        private boolean aZ;
        private String aa;
        private String ab;
        private String ac;
        private String ad;
        private int ae;
        private int af;
        private String al;
        private String am;
        private String an;
        private String ao;
        private long ap;
        private String aq;
        private String ar;
        private String as;
        private String at;
        private String au;
        private HashMap<String, Object> av;
        private ApplicationInfo aw;
        private String az;
        private String b;
        private ArrayList<HashMap<String, Object>> ba;
        private String bb;
        private String bd;
        private HashMap<String, Long> be;
        private String bg;
        private String d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f1856g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f1857h;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f1860k;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f1863n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private String f1865p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private String f1866q;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f1868s;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private String f1870u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private String f1871v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private String f1872w;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private String f1874y;
        private LinkedList<String> c = new LinkedList<>();
        private LinkedList<String> e = new LinkedList<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private LinkedList<String> f1855f = new LinkedList<>();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private LinkedList<String> f1858i = new LinkedList<>();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private LinkedList<String> f1859j = new LinkedList<>();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private LinkedList<String> f1861l = new LinkedList<>();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private LinkedList<String> f1862m = new LinkedList<>();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private LinkedList<String> f1864o = new LinkedList<>();

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private LinkedList<String> f1867r = new LinkedList<>();

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private LinkedList<Boolean> f1869t = new LinkedList<>();

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private LinkedList<String> f1873x = new LinkedList<>();

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private LinkedList<String> f1875z = new LinkedList<>();

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        private LinkedList<ArrayList<HashMap<String, String>>> f1828A = new LinkedList<>();

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        private LinkedList<ArrayList<HashMap<String, String>>> f1829B = new LinkedList<>();

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        private LinkedList<Location> f1832E = new LinkedList<>();

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private LinkedList<Boolean> f1837J = new LinkedList<>();
        private LinkedList<List<ResolveInfo>> ag = new LinkedList<>();
        private LinkedList<ResolveInfo> ah = new LinkedList<>();
        private LinkedList<PackageInfo> ai = new LinkedList<>();
        private LinkedList<PackageInfo> aj = new LinkedList<>();
        private LinkedList<PackageInfo> ak = new LinkedList<>();
        private LinkedList<ApplicationInfo> ax = new LinkedList<>();
        private LinkedList<ApplicationInfo> ay = new LinkedList<>();
        private LinkedList<List<HashMap<String, Object>>> aM = new LinkedList<>();
        private LinkedList<HashMap<String, Object>> aO = new LinkedList<>();
        private LinkedList<String> aR = new LinkedList<>();
        private LinkedList<String> aT = new LinkedList<>();
        private LinkedList<Object> aW = new LinkedList<>();
        private LinkedList<Object> aX = new LinkedList<>();
        private LinkedList<Object> aY = new LinkedList<>();
        private LinkedList<Long> bc = new LinkedList<>();
        private LinkedList<Set<String>> bf = new LinkedList<>();

        public void a(String str, Object obj) throws Throwable {
            a(str, obj, false);
        }

        public boolean checkDebbing() {
            return this.aZ;
        }

        public boolean checkNetworkAvailable() {
            return this.f1868s;
        }

        public boolean checkNetworkAvailableForce(int... iArr) {
            return ((Boolean) a(this.f1869t, (Object) null, iArr)).booleanValue();
        }

        public boolean checkPad() {
            return this.f1847T;
        }

        public boolean checkUA() {
            return this.f1850W;
        }

        public boolean cx() {
            return this.f1846S;
        }

        public boolean debugable() {
            return this.f1852Y;
        }

        public boolean devEnable() {
            return this.f1849V;
        }

        public ArrayList<HashMap<String, Object>> getACIfo() {
            return this.ba;
        }

        public ApplicationInfo getAInfo() {
            return this.aw;
        }

        public ApplicationInfo getAInfoForPkg(int... iArr) {
            return (ApplicationInfo) a(this.ax, (Object) null, iArr);
        }

        public ApplicationInfo getAInfoForPkgForce(int... iArr) {
            return (ApplicationInfo) a(this.ay, (Object) null, iArr);
        }

        public HashMap<String, Object> getALLD() {
            return this.av;
        }

        public String getAbis() {
            return this.f1839L;
        }

        public String getAdvertisingID() {
            return this.f1831D;
        }

        public long getAppLastUpdateTime() {
            return this.ap;
        }

        public String getAppName() {
            return this.f1874y;
        }

        public String getAppNameForPkg(int... iArr) {
            return (String) a(this.f1875z, (Object) null, iArr);
        }

        public String getBaseband() {
            return this.ab;
        }

        public long getBdT() {
            return this.aC;
        }

        public String getBoardFromSysProperty() {
            return this.ac;
        }

        public String getBoardPlatform() {
            return this.ad;
        }

        public String getBssid() {
            return this.d;
        }

        public String getBssidForce(int... iArr) {
            return (String) a(this.e, (Object) null, iArr);
        }

        public String getBtM() {
            return this.aA;
        }

        public String getCInfo() {
            return this.as;
        }

        public Object getCLoc() {
            return this.f1833F;
        }

        public HashMap<String, Object> getCPUInfo() {
            return this.f1838K;
        }

        public String getCarrier() {
            return this.f1857h;
        }

        public String getCarrierForce(int... iArr) {
            return (String) a(this.f1858i, StructuredDataId.RESERVED, iArr);
        }

        public String getCarrierName() {
            return this.f1860k;
        }

        public String getCarrierNameForce(int... iArr) {
            return (String) a(this.f1861l, (Object) null, iArr);
        }

        public String getCarrierNameStrict(int... iArr) {
            return (String) a(this.f1862m, (Object) null, iArr);
        }

        public String getCarrierStrict(int... iArr) {
            return (String) a(this.f1859j, StructuredDataId.RESERVED, iArr);
        }

        public String getCgroup() {
            return this.ar;
        }

        public HashMap<String, Object> getCurrentWifiInfo() {
            return this.f1836I;
        }

        public String getDM() {
            return this.bb;
        }

        public int getDataNtType() {
            return this.ae;
        }

        public int getDataNtTypeStrict() {
            return this.af;
        }

        public String getDetailNetworkTypeForStatic() {
            return this.f1871v;
        }

        public String getDeviceData() {
            return this.an;
        }

        public String getDeviceDataNotAES() {
            return this.ao;
        }

        public String getDeviceId() {
            return null;
        }

        public String getDeviceKey() {
            return this.f1872w;
        }

        public String getDeviceKeyFromCache(int... iArr) {
            return (String) a(this.f1873x, (Object) null, iArr);
        }

        public String getDeviceName() {
            return this.aq;
        }

        public String getDeviceType() {
            return this.f1835H;
        }

        public String getDrID() {
            return this.az;
        }

        public String getFlavor() {
            return this.aa;
        }

        public int getGrammaticalGender() {
            return this.aL;
        }

        public int getHmEPMState() {
            return this.aJ;
        }

        public String getHmOsDetailedVer() {
            return this.aH;
        }

        public String getHmOsVer() {
            return this.aG;
        }

        public int getHmPMState() {
            return this.aI;
        }

        public ArrayList<HashMap<String, String>> getIA(int... iArr) {
            return (ArrayList) a(this.f1828A, new ArrayList(), iArr);
        }

        public ArrayList<HashMap<String, String>> getIAForce(int... iArr) {
            return (ArrayList) a(this.f1829B, new ArrayList(), iArr);
        }

        public String getIMEI() {
            return null;
        }

        public String getIMSI() {
            return null;
        }

        public String getIPAddress() {
            return this.al;
        }

        public String getIPAddressStrict() {
            return this.am;
        }

        public String getInnerAppLanguage() {
            return this.aK;
        }

        public long getLATime(int... iArr) {
            return ((Long) a((LinkedList<long>) this.bc, -1L, iArr)).longValue();
        }

        public Location getLocation(int... iArr) {
            return (Location) a(this.f1832E, (Object) null, iArr);
        }

        public String getMIUIVersion() {
            return this.f1844Q;
        }

        public String getMIUIVersionForFly() {
            return this.f1845R;
        }

        public String getMbcdi() {
            return this.aS;
        }

        public String getMbcdiForce(int... iArr) {
            return (String) a(this.aT, (Object) null, iArr);
        }

        public String getMcdi() {
            return this.aQ;
        }

        public String getMcdiForce(int... iArr) {
            return (String) a(this.aR, (Object) null, iArr);
        }

        public HashMap<String, Long> getMemoryInfo() {
            return this.f1843P;
        }

        public ArrayList<HashMap<String, Object>> getMnbclfo() {
            return this.aV;
        }

        public Object getMpfo(int... iArr) {
            return a(this.aW, (Object) null, iArr);
        }

        public Object getMpfof(int... iArr) {
            return a(this.aX, (Object) null, iArr);
        }

        public Object getMpfos(int... iArr) {
            return a(this.aY, (Object) null, iArr);
        }

        public HashMap<String, Object> getMwfo() {
            return this.aN;
        }

        public HashMap<String, Object> getMwfoForce(int... iArr) {
            return (HashMap) a(this.aO, (Object) null, iArr);
        }

        public ArrayList<HashMap<String, Object>> getMwlfo() {
            return this.aP;
        }

        public ArrayList<HashMap<String, Object>> getNeighboringCellInfo() {
            return this.f1834G;
        }

        public String getNetworkType() {
            return this.f1865p;
        }

        public String getNetworkTypeForStatic() {
            return this.f1870u;
        }

        public String getNetworkTypeForce(int... iArr) {
            return (String) a(this.f1867r, m.a("004g<fm3gh"), iArr);
        }

        public String getNetworkTypeNew() {
            return this.f1866q;
        }

        public String getOD() {
            return this.at;
        }

        public String getODH() {
            return this.au;
        }

        public PackageInfo getPInfo(int... iArr) {
            return (PackageInfo) a(this.ai, (Object) null, iArr);
        }

        public PackageInfo getPInfoForce(int... iArr) {
            return (PackageInfo) a(this.aj, (Object) null, iArr);
        }

        public PackageInfo getPInfoStrategy(int... iArr) {
            return (PackageInfo) a(this.ak, (Object) null, iArr);
        }

        public Set<String> getPPL(int... iArr) {
            return (Set) a(this.bf, (Object) null, iArr);
        }

        public List<HashMap<String, Object>> getPosCommForce(int... iArr) {
            return (List) a(this.aM, (Object) null, iArr);
        }

        public String getQemuKernel() {
            return this.f1841N;
        }

        public String getRd() {
            return this.bg;
        }

        public HashMap<String, Long> getRuntimeMemory() {
            return this.be;
        }

        public ArrayList<HashMap<String, String>> getSA() {
            return this.f1830C;
        }

        public String getSSID() {
            return this.b;
        }

        public String getSSIDForce(int... iArr) {
            return (String) a(this.c, (Object) null, iArr);
        }

        public double getScreenInch() {
            return this.aD;
        }

        public int getScreenPpi() {
            return this.aE;
        }

        public String getScreenSize() {
            return this.f1856g;
        }

        public boolean getSdcardState() {
            return false;
        }

        public String getSecurePch() {
            return this.bd;
        }

        public String getSerialno() {
            return null;
        }

        public String getSignMD5() {
            return this.f1863n;
        }

        public String getSignMD5ForPkg(int... iArr) {
            return (String) a(this.f1864o, (Object) null, iArr);
        }

        public String getSimSerialNumber() {
            return null;
        }

        public HashMap<String, HashMap<String, Long>> getSizeInfo() {
            return this.f1842O;
        }

        public String getSystemProperties(int... iArr) {
            return (String) a(this.f1855f, (Object) null, iArr);
        }

        public ArrayList<ArrayList<String>> getTTYDriversInfo() {
            return this.f1840M;
        }

        public Activity getTopActivity() {
            return null;
        }

        public String getUpM() {
            return this.aB;
        }

        public boolean isHmOs() {
            return this.aF;
        }

        public boolean isMwpy() {
            return this.aU;
        }

        public boolean isPackageInstalled(int... iArr) {
            return ((Boolean) a(this.f1837J, Boolean.FALSE, iArr)).booleanValue();
        }

        public boolean isRooted() {
            return this.f1854a;
        }

        public boolean isWifiProxy() {
            return this.f1853Z;
        }

        public String[] queryIMEI() {
            return null;
        }

        public String[] queryIMSI() {
            return null;
        }

        public List<ResolveInfo> queryIntentServices(int... iArr) {
            return (List) a(this.ag, (Object) null, iArr);
        }

        public ResolveInfo resolveActivity(int... iArr) {
            return (ResolveInfo) a(this.ah, (Object) null, iArr);
        }

        public boolean usbEnable() {
            return this.f1848U;
        }

        public boolean vpn() {
            return this.f1851X;
        }

        public void a(String str, Object obj, boolean z6) throws Throwable {
            if ("gmpfo".equals(str)) {
                LinkedList<Object> linkedList = this.aW;
                if (z6) {
                    obj = null;
                }
                linkedList.add(obj);
                return;
            }
            if ("gmpfofce".equals(str)) {
                LinkedList<Object> linkedList2 = this.aX;
                if (z6) {
                    obj = null;
                }
                linkedList2.add(obj);
                return;
            }
            if ("getMpfos".equals(str)) {
                LinkedList<Object> linkedList3 = this.aY;
                if (z6) {
                    obj = null;
                }
                linkedList3.add(obj);
                return;
            }
            boolean z7 = false;
            z7 = false;
            if ("cird".equals(str)) {
                this.f1854a = z6 ? false : ((Boolean) obj).booleanValue();
                return;
            }
            if ("gsimt".equals(str)) {
                this.b = z6 ? null : (String) obj;
                return;
            }
            if ("gsimtfce".equals(str)) {
                this.c.add(z6 ? null : (String) obj);
                return;
            }
            if ("gbsi".equals(str)) {
                this.d = z6 ? null : (String) obj;
                return;
            }
            if ("gbsifce".equals(str)) {
                this.e.add(z6 ? null : (String) obj);
                return;
            }
            if ("gstmpts".equals(str)) {
                this.f1855f.add(z6 ? null : (String) obj);
                return;
            }
            if ("gscsz".equals(str)) {
                this.f1856g = z6 ? null : (String) obj;
                return;
            }
            if ("gcrie".equals(str)) {
                this.f1857h = z6 ? null : (String) obj;
                return;
            }
            if ("gcriefce".equals(str)) {
                this.f1858i.add(z6 ? null : (String) obj);
                return;
            }
            if ("gcriefcestr".equals(str)) {
                this.f1859j.add(z6 ? null : (String) obj);
                return;
            }
            if ("gcrnm".equals(str)) {
                this.f1860k = z6 ? null : (String) obj;
                return;
            }
            if ("gcrnmfce".equals(str)) {
                this.f1861l.add(z6 ? null : (String) obj);
                return;
            }
            if ("gcrnmfcestr".equals(str)) {
                this.f1862m.add(z6 ? null : (String) obj);
                return;
            }
            if ("gsnmd".equals(str)) {
                this.f1863n = z6 ? null : (String) obj;
                return;
            }
            if ("gsnmdfp".equals(str)) {
                this.f1864o.add(z6 ? null : (String) obj);
                return;
            }
            if ("gneyp".equals(str)) {
                this.f1865p = z6 ? null : (String) obj;
                return;
            }
            if ("gneypnw".equals(str)) {
                this.f1866q = z6 ? null : (String) obj;
                return;
            }
            if ("gneypfce".equals(str)) {
                this.f1867r.add(z6 ? null : (String) obj);
                return;
            }
            if ("cknavbl".equals(str)) {
                this.f1868s = z6 ? false : ((Boolean) obj).booleanValue();
                return;
            }
            if ("cknavblfc".equals(str)) {
                this.f1869t.add(Boolean.valueOf(z6 ? false : ((Boolean) obj).booleanValue()));
                return;
            }
            if ("gnktpfs".equals(str)) {
                this.f1870u = z6 ? null : (String) obj;
                return;
            }
            if ("gdtlnktpfs".equals(str)) {
                this.f1871v = z6 ? null : (String) obj;
                return;
            }
            if ("gdvk".equals(str)) {
                this.f1872w = z6 ? null : (String) obj;
                return;
            }
            if ("gdvkfc".equals(str)) {
                this.f1873x.add(z6 ? null : (String) obj);
                return;
            }
            if ("gpnmmt".equals(str)) {
                this.f1874y = z6 ? null : (String) obj;
                return;
            }
            if ("gpnmfp".equals(str)) {
                this.f1875z.add(z6 ? null : (String) obj);
                return;
            }
            if ("gia".equals(str)) {
                this.f1828A.add(z6 ? null : (ArrayList) obj);
                return;
            }
            if ("giafce".equals(str)) {
                this.f1829B.add(z6 ? null : (ArrayList) obj);
                return;
            }
            if ("gsl".equals(str)) {
                this.f1830C = z6 ? null : (ArrayList) obj;
                return;
            }
            if ("gavti".equals(str)) {
                this.f1831D = z6 ? null : (String) obj;
                return;
            }
            if ("glctn".equals(str)) {
                this.f1832E.add(z6 ? null : (Location) obj);
                return;
            }
            if ("gtecloc".equals(str)) {
                if (z6) {
                    obj = null;
                }
                this.f1833F = obj;
                return;
            }
            if ("gnbclin".equals(str)) {
                this.f1834G = z6 ? null : (ArrayList) obj;
                return;
            }
            if ("gdvtp".equals(str)) {
                this.f1835H = z6 ? null : (String) obj;
                return;
            }
            if ("wmcwi".equals(str)) {
                this.f1836I = z6 ? null : (HashMap) obj;
                return;
            }
            if ("ipgist".equals(str)) {
                this.f1837J.add(Boolean.valueOf(z6 ? false : ((Boolean) obj).booleanValue()));
                return;
            }
            if ("gcuin".equals(str)) {
                this.f1838K = z6 ? null : (HashMap) obj;
                return;
            }
            if ("gabis".equals(str)) {
                this.f1839L = z6 ? null : (String) obj;
                return;
            }
            if ("gtydvin".equals(str)) {
                this.f1840M = z6 ? null : (ArrayList) obj;
                return;
            }
            if ("gqmkn".equals(str)) {
                this.f1841N = z6 ? null : (String) obj;
                return;
            }
            if ("gszin".equals(str)) {
                this.f1842O = z6 ? null : (HashMap) obj;
                return;
            }
            if ("gmrin".equals(str)) {
                this.f1843P = z6 ? null : (HashMap) obj;
                return;
            }
            if ("gmivsn".equals(str)) {
                this.f1844Q = z6 ? null : (String) obj;
                return;
            }
            if ("gmivsnfly".equals(str)) {
                this.f1845R = z6 ? null : (String) obj;
                return;
            }
            if ("cx".equals(str)) {
                this.f1846S = z6 ? false : ((Boolean) obj).booleanValue();
                return;
            }
            if ("ckpd".equals(str)) {
                this.f1847T = z6 ? false : ((Boolean) obj).booleanValue();
                return;
            }
            if ("ubenbl".equals(str)) {
                this.f1848U = z6 ? false : ((Boolean) obj).booleanValue();
                return;
            }
            if ("dvenbl".equals(str)) {
                this.f1849V = z6 ? false : ((Boolean) obj).booleanValue();
                return;
            }
            if ("ckua".equals(str)) {
                this.f1850W = z6 ? false : ((Boolean) obj).booleanValue();
                return;
            }
            if ("vnmt".equals(str)) {
                this.f1851X = z6 ? false : ((Boolean) obj).booleanValue();
                return;
            }
            if ("degb".equals(str)) {
                this.f1852Y = z6 ? false : ((Boolean) obj).booleanValue();
                return;
            }
            if ("iwpxy".equals(str)) {
                this.f1853Z = z6 ? false : ((Boolean) obj).booleanValue();
                return;
            }
            if ("gflv".equals(str)) {
                this.aa = z6 ? null : (String) obj;
                return;
            }
            if ("gbsbd".equals(str)) {
                this.ab = z6 ? null : (String) obj;
                return;
            }
            if ("gbfspy".equals(str)) {
                this.ac = z6 ? null : (String) obj;
                return;
            }
            if ("gbplfo".equals(str)) {
                this.ad = z6 ? null : (String) obj;
                return;
            }
            if ("gdntp".equals(str)) {
                this.ae = z6 ? 0 : ((Integer) obj).intValue();
                return;
            }
            if ("gdntpstr".equals(str)) {
                this.af = z6 ? 0 : ((Integer) obj).intValue();
                return;
            }
            if ("qritsvc".equals(str)) {
                this.ag.add(z6 ? null : (List) obj);
                return;
            }
            if ("rsaciy".equals(str)) {
                this.ah.add(z6 ? null : (ResolveInfo) obj);
                return;
            }
            if ("gpgif".equals(str)) {
                this.ai.add(z6 ? null : (PackageInfo) obj);
                return;
            }
            if ("gpgiffcin".equals(str)) {
                this.aj.add(z6 ? null : (PackageInfo) obj);
                return;
            }
            if ("gpgifstrg".equals(str)) {
                this.ak.add(z6 ? null : (PackageInfo) obj);
                return;
            }
            if ("giads".equals(str)) {
                this.al = z6 ? null : (String) obj;
                return;
            }
            if ("giadsstr".equals(str)) {
                this.am = z6 ? null : (String) obj;
                return;
            }
            if ("gdvda".equals(str)) {
                this.an = z6 ? null : (String) obj;
                return;
            }
            if ("gdvdtnas".equals(str)) {
                this.ao = z6 ? null : (String) obj;
                return;
            }
            if ("galtut".equals(str)) {
                this.ap = z6 ? 0L : ((Long) obj).longValue();
                return;
            }
            if ("gdvme".equals(str)) {
                this.aq = z6 ? null : (String) obj;
                return;
            }
            if ("gcrup".equals(str)) {
                this.ar = z6 ? null : (String) obj;
                return;
            }
            if ("gcifm".equals(str)) {
                this.as = z6 ? null : (String) obj;
                return;
            }
            if ("godm".equals(str)) {
                this.at = z6 ? null : (String) obj;
                return;
            }
            if ("godhm".equals(str)) {
                this.au = z6 ? null : (String) obj;
                return;
            }
            if ("galdm".equals(str)) {
                this.av = z6 ? null : (HashMap) obj;
                return;
            }
            if ("gtaif".equals(str)) {
                this.aw = z6 ? null : (ApplicationInfo) obj;
                return;
            }
            if ("gtaifprm".equals(str)) {
                this.ax.add(z6 ? null : (ApplicationInfo) obj);
                return;
            }
            if ("gtaifprmfce".equals(str)) {
                this.ay.add(z6 ? null : (ApplicationInfo) obj);
                return;
            }
            if ("gtdrd".equals(str)) {
                this.az = z6 ? null : (String) obj;
                return;
            }
            if ("gtbdt".equals(str)) {
                this.aC = z6 ? 0L : ((Long) obj).longValue();
                return;
            }
            if ("gtscnin".equals(str)) {
                this.aD = z6 ? 0.0d : ((Double) obj).doubleValue();
                return;
            }
            if ("gtscnppi".equals(str)) {
                this.aE = z6 ? 0 : ((Integer) obj).intValue();
                return;
            }
            if ("ishmos".equals(str)) {
                this.aF = z6 ? false : ((Boolean) obj).booleanValue();
                return;
            }
            if ("gthmosv".equals(str)) {
                this.aG = z6 ? null : (String) obj;
                return;
            }
            if ("gthmosdtlv".equals(str)) {
                this.aH = z6 ? null : (String) obj;
                return;
            }
            if ("gthmpmst".equals(str)) {
                this.aI = z6 ? -1 : ((Integer) obj).intValue();
                return;
            }
            if ("gthmepmst".equals(str)) {
                this.aJ = z6 ? -1 : ((Integer) obj).intValue();
                return;
            }
            if ("gtinnerlangmt".equals(str)) {
                this.aK = z6 ? null : (String) obj;
                return;
            }
            if ("gtgramgendt".equals(str)) {
                this.aL = z6 ? 0 : ((Integer) obj).intValue();
                return;
            }
            if ("gtelcmefce".equals(str)) {
                this.aM.add(z6 ? null : (List) obj);
                return;
            }
            if ("gtmwfo".equals(str)) {
                this.aN = z6 ? null : (HashMap) obj;
                return;
            }
            if ("wmcwifce".equals(str)) {
                this.aO.add(z6 ? null : (HashMap) obj);
                return;
            }
            if ("gtaifok".equals(str)) {
                this.aP = z6 ? null : (ArrayList) obj;
                return;
            }
            if ("gtmcdi".equals(str)) {
                this.aQ = z6 ? null : (String) obj;
                return;
            }
            if ("gtmcdifce".equals(str)) {
                this.aR.add(z6 ? null : (String) obj);
                return;
            }
            if ("gtmbcdi".equals(str)) {
                this.aS = z6 ? null : (String) obj;
                return;
            }
            if ("gtmbcdifce".equals(str)) {
                this.aT.add(z6 ? null : (String) obj);
                return;
            }
            if ("miwpy".equals(str)) {
                this.aU = z6 ? false : ((Boolean) obj).booleanValue();
                return;
            }
            if ("gtmnbclfo".equals(str)) {
                this.aV = z6 ? null : (ArrayList) obj;
                return;
            }
            if ("ctedebbing".equals(str)) {
                if (!z6 && ((Boolean) obj).booleanValue()) {
                    z7 = true;
                }
                this.aZ = z7;
                return;
            }
            if ("gteacifo".equals(str)) {
                this.ba = z6 ? null : (ArrayList) obj;
                return;
            }
            if ("gtdm".equals(str)) {
                this.bb = z6 ? null : (String) obj;
                return;
            }
            if ("gtlstactme".equals(str)) {
                this.bc.add(Long.valueOf(z6 ? -1L : ((Long) obj).longValue()));
                return;
            }
            if ("gtscrpch".equals(str)) {
                this.bd = z6 ? null : (String) obj;
                return;
            }
            if ("gtrtmey".equals(str)) {
                this.be = z6 ? null : (HashMap) obj;
                return;
            }
            if ("gppl".equals(str)) {
                this.bf.add(z6 ? new HashSet<>() : (Set) obj);
                return;
            }
            if ("gtrddi".equals(str)) {
                this.bg = z6 ? null : (String) obj;
                return;
            }
            throw new Throwable("Unknown name to set: " + str + ", value: " + obj);
        }

        private static <T> T a(LinkedList<T> linkedList, T t6, int... iArr) {
            if (linkedList != null) {
                try {
                    if (iArr.length == 0) {
                        return linkedList.get(0);
                    }
                    if (iArr[0] < linkedList.size()) {
                        return linkedList.get(iArr[0]);
                    }
                    FlyLog.getInstance().w("WARNING: " + iArr[0] + " out of bound, size: " + linkedList.size());
                    return t6;
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                }
            }
            return t6;
        }
    }

    public static class RequestBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f1876a;
        private final LinkedList<a> b;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f1879a;
            public final Object[] b;

            private a(String str, Object... objArr) {
                this.f1879a = str;
                this.b = objArr;
            }
        }

        public RequestBuilder checkDebbing() {
            this.b.add(new a("ctedebbing", new Object[0]));
            return this;
        }

        public RequestBuilder checkNetworkAvailable() {
            this.b.add(new a("cknavbl", new Object[0]));
            return this;
        }

        public RequestBuilder checkNetworkAvailableForce(boolean z6) {
            this.b.add(new a("cknavblfc", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder checkPad() {
            this.b.add(new a("ckpd", new Object[0]));
            return this;
        }

        public RequestBuilder checkUA() {
            this.b.add(new a("ckua", new Object[0]));
            return this;
        }

        public RequestBuilder cx() {
            this.b.add(new a("cx", new Object[0]));
            return this;
        }

        public RequestBuilder debugable() {
            this.b.add(new a("degb", new Object[0]));
            return this;
        }

        public RequestBuilder devEnable() {
            this.b.add(new a("dvenbl", new Object[0]));
            return this;
        }

        public RequestBuilder getACIfo() {
            this.b.add(new a("gteacifo", new Object[0]));
            return this;
        }

        public RequestBuilder getAInfo() {
            this.b.add(new a("gtaif", new Object[0]));
            return this;
        }

        public RequestBuilder getAInfoForPkg(String str, int i5) {
            this.b.add(new a("gtaifprm", new Object[]{str, Integer.valueOf(i5)}));
            return this;
        }

        public RequestBuilder getAInfoForPkgForce(boolean z6, String str, int i5) {
            this.b.add(new a("gtaifprmfce", new Object[]{Boolean.valueOf(z6), str, Integer.valueOf(i5)}));
            return this;
        }

        public RequestBuilder getALLD() {
            this.b.add(new a("galdm", new Object[0]));
            return this;
        }

        public RequestBuilder getAbis() {
            this.b.add(new a("gabis", new Object[0]));
            return this;
        }

        public RequestBuilder getAdvertisingID() {
            this.b.add(new a("gavti", new Object[0]));
            return this;
        }

        public RequestBuilder getAppLastUpdateTime() {
            this.b.add(new a("galtut", new Object[0]));
            return this;
        }

        public RequestBuilder getAppName() {
            this.b.add(new a("gpnmmt", new Object[0]));
            return this;
        }

        public RequestBuilder getAppNameForPkg(String str) {
            this.b.add(new a("gpnmfp", new Object[]{str}));
            return this;
        }

        public RequestBuilder getBaseband() {
            this.b.add(new a("gbsbd", new Object[0]));
            return this;
        }

        public RequestBuilder getBdT() {
            this.b.add(new a("gtbdt", new Object[0]));
            return this;
        }

        public RequestBuilder getBoardFromSysProperty() {
            this.b.add(new a("gbfspy", new Object[0]));
            return this;
        }

        public RequestBuilder getBoardPlatform() {
            this.b.add(new a("gbplfo", new Object[0]));
            return this;
        }

        public RequestBuilder getBssid() {
            this.b.add(new a("gbsi", new Object[0]));
            return this;
        }

        public RequestBuilder getBssidForce(boolean z6) {
            this.b.add(new a("gbsifce", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getCInfo() {
            this.b.add(new a("gcifm", new Object[0]));
            return this;
        }

        public RequestBuilder getCLoc() {
            this.b.add(new a("gtecloc", new Object[0]));
            return this;
        }

        public RequestBuilder getCPUInfo() {
            this.b.add(new a("gcuin", new Object[0]));
            return this;
        }

        public RequestBuilder getCarrier() {
            this.b.add(new a("gcrie", new Object[0]));
            return this;
        }

        public RequestBuilder getCarrierForce(boolean z6) {
            this.b.add(new a("gcriefce", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getCarrierName() {
            this.b.add(new a("gcrnm", new Object[0]));
            return this;
        }

        public RequestBuilder getCarrierNameForce(boolean z6) {
            this.b.add(new a("gcrnmfce", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getCarrierNameStrict(boolean z6) {
            this.b.add(new a("gcrnmfcestr", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getCarrierStrict(boolean z6) {
            this.b.add(new a("gcriefcestr", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getCgroup() {
            this.b.add(new a("gcrup", new Object[0]));
            return this;
        }

        public RequestBuilder getCurrentWifiInfo() {
            this.b.add(new a("wmcwi", new Object[0]));
            return this;
        }

        public RequestBuilder getDM(boolean z6) {
            this.b.add(new a("gtdm", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getDataNtType() {
            this.b.add(new a("gdntp", new Object[0]));
            return this;
        }

        public RequestBuilder getDataNtTypeStrict() {
            this.b.add(new a("gdntpstr", new Object[0]));
            return this;
        }

        public RequestBuilder getDetailNetworkTypeForStatic() {
            this.b.add(new a("gdtlnktpfs", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceData() {
            this.b.add(new a("gdvda", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceDataNotAES() {
            this.b.add(new a("gdvdtnas", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceKey() {
            this.b.add(new a("gdvk", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceKeyFromCache(boolean z6) {
            this.b.add(new a("gdvkfc", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getDeviceName() {
            this.b.add(new a("gdvme", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceType() {
            this.b.add(new a("gdvtp", new Object[0]));
            return this;
        }

        public RequestBuilder getDrID() {
            this.b.add(new a("gtdrd", new Object[0]));
            return this;
        }

        public RequestBuilder getFlavor() {
            this.b.add(new a("gflv", new Object[0]));
            return this;
        }

        public RequestBuilder getGrammaticalGender() {
            this.b.add(new a("gtgramgendt", new Object[0]));
            return this;
        }

        public RequestBuilder getHmEPMState() {
            this.b.add(new a("gthmepmst", new Object[0]));
            return this;
        }

        public RequestBuilder getHmOsDetailedVer() {
            this.b.add(new a("gthmosdtlv", new Object[0]));
            return this;
        }

        public RequestBuilder getHmOsVer() {
            this.b.add(new a("gthmosv", new Object[0]));
            return this;
        }

        public RequestBuilder getHmPMState() {
            this.b.add(new a("gthmpmst", new Object[0]));
            return this;
        }

        public RequestBuilder getIA(boolean z6) {
            this.b.add(new a("gia", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getIAForce(boolean z6, boolean z7) {
            this.b.add(new a("giafce", new Object[]{Boolean.valueOf(z6), Boolean.valueOf(z7)}));
            return this;
        }

        public RequestBuilder getIPAddress() {
            this.b.add(new a("giads", new Object[0]));
            return this;
        }

        public RequestBuilder getIPAddressStrict() {
            this.b.add(new a("giadsstr", new Object[0]));
            return this;
        }

        public RequestBuilder getInnerAppLanguage() {
            this.b.add(new a("gtinnerlangmt", new Object[0]));
            return this;
        }

        public RequestBuilder getLATime(String str) {
            this.b.add(new a("gtlstactme", new Object[]{str}));
            return this;
        }

        public RequestBuilder getLocation(int i5, int i6, boolean z6) {
            this.b.add(new a("glctn", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getMIUIVersion() {
            this.b.add(new a("gmivsn", new Object[0]));
            return this;
        }

        public RequestBuilder getMIUIVersionForFly() {
            this.b.add(new a("gmivsnfly", new Object[0]));
            return this;
        }

        public RequestBuilder getMbcdi() {
            this.b.add(new a("gtmbcdi", new Object[0]));
            return this;
        }

        public RequestBuilder getMbcdiForce(boolean z6) {
            this.b.add(new a("gtmbcdifce", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getMcdi() {
            this.b.add(new a("gtmcdi", new Object[0]));
            return this;
        }

        public RequestBuilder getMcdiForce(boolean z6) {
            this.b.add(new a("gtmcdifce", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getMemoryInfo() {
            this.b.add(new a("gmrin", new Object[0]));
            return this;
        }

        public RequestBuilder getMnbclfo() {
            this.b.add(new a("gtmnbclfo", new Object[0]));
            return this;
        }

        public RequestBuilder getMpfo(String str, int i5) {
            this.b.add(new a("gmpfo", new Object[]{str, Integer.valueOf(i5)}));
            return this;
        }

        public RequestBuilder getMpfof(boolean z6, String str, int i5) {
            this.b.add(new a("gmpfofce", new Object[]{Boolean.valueOf(z6), str, Integer.valueOf(i5)}));
            return this;
        }

        public RequestBuilder getMpfos(int i5, String str, int i6) {
            this.b.add(new a("getMpfos", new Object[]{Integer.valueOf(i5), str, Integer.valueOf(i6)}));
            return this;
        }

        public RequestBuilder getMwfo() {
            this.b.add(new a("gtmwfo", new Object[0]));
            return this;
        }

        public RequestBuilder getMwfoForce(boolean z6) {
            this.b.add(new a("wmcwifce", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getMwlfo() {
            this.b.add(new a("gtaifok", new Object[0]));
            return this;
        }

        public RequestBuilder getNeighboringCellInfo() {
            this.b.add(new a("gnbclin", new Object[0]));
            return this;
        }

        public RequestBuilder getNetworkType() {
            this.b.add(new a("gneyp", new Object[0]));
            return this;
        }

        public RequestBuilder getNetworkTypeForStatic() {
            this.b.add(new a("gnktpfs", new Object[0]));
            return this;
        }

        public RequestBuilder getNetworkTypeForce(boolean z6) {
            this.b.add(new a("gneypfce", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getNetworkTypeNew() {
            this.b.add(new a("gneypnw", new Object[0]));
            return this;
        }

        public RequestBuilder getOD() {
            this.b.add(new a("godm", new Object[0]));
            return this;
        }

        public RequestBuilder getODH() {
            this.b.add(new a("godhm", new Object[0]));
            return this;
        }

        public RequestBuilder getPInfo(String str, int i5) {
            this.b.add(new a("gpgif", new Object[]{str, Integer.valueOf(i5)}));
            return this;
        }

        public RequestBuilder getPInfoForce(boolean z6, String str, int i5) {
            this.b.add(new a("gpgiffcin", new Object[]{Boolean.valueOf(z6), str, Integer.valueOf(i5)}));
            return this;
        }

        public RequestBuilder getPInfoStrategy(int i5, String str, int i6) {
            this.b.add(new a("gpgifstrg", new Object[]{Integer.valueOf(i5), str, Integer.valueOf(i6)}));
            return this;
        }

        public RequestBuilder getPPL(boolean z6) {
            this.b.add(new a("gppl", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getPosCommForce(int i5, int i6, boolean z6, boolean z7) {
            this.b.add(new a("gtelcmefce", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z6), Boolean.valueOf(z7)}));
            return this;
        }

        public RequestBuilder getQemuKernel() {
            this.b.add(new a("gqmkn", new Object[0]));
            return this;
        }

        public RequestBuilder getRd() {
            this.b.add(new a("gtrddi", new Object[0]));
            return this;
        }

        public RequestBuilder getRuntimeMemory(boolean z6) {
            this.b.add(new a("gtrtmey", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getSA() {
            this.b.add(new a("gsl", new Object[0]));
            return this;
        }

        public RequestBuilder getSSID() {
            this.b.add(new a("gsimt", new Object[0]));
            return this;
        }

        public RequestBuilder getSSIDForce(boolean z6) {
            this.b.add(new a("gsimtfce", new Object[]{Boolean.valueOf(z6)}));
            return this;
        }

        public RequestBuilder getScreenInch() {
            this.b.add(new a("gtscnin", new Object[0]));
            return this;
        }

        public RequestBuilder getScreenPpi() {
            this.b.add(new a("gtscnppi", new Object[0]));
            return this;
        }

        public RequestBuilder getScreenSize() {
            this.b.add(new a("gscsz", new Object[0]));
            return this;
        }

        public RequestBuilder getSecurePch() {
            this.b.add(new a("gtscrpch", new Object[0]));
            return this;
        }

        public RequestBuilder getSignMD5() {
            this.b.add(new a("gsnmd", new Object[0]));
            return this;
        }

        public RequestBuilder getSignMD5ForPkg(String str) {
            this.b.add(new a("gsnmdfp", new Object[]{str}));
            return this;
        }

        public RequestBuilder getSizeInfo() {
            this.b.add(new a("gszin", new Object[0]));
            return this;
        }

        public RequestBuilder getSystemProperties(String str) {
            this.b.add(new a("gstmpts", new Object[]{str}));
            return this;
        }

        public RequestBuilder getTTYDriversInfo() {
            this.b.add(new a("gtydvin", new Object[0]));
            return this;
        }

        public RequestBuilder isHmOs() {
            this.b.add(new a("ishmos", new Object[0]));
            return this;
        }

        public RequestBuilder isMwpy() {
            this.b.add(new a("miwpy", new Object[0]));
            return this;
        }

        public RequestBuilder isPackageInstalled(String str) {
            this.b.add(new a("ipgist", new Object[]{str}));
            return this;
        }

        public RequestBuilder isRooted() {
            this.b.add(new a("cird", new Object[0]));
            return this;
        }

        public RequestBuilder isWifiProxy() {
            this.b.add(new a("iwpxy", new Object[0]));
            return this;
        }

        public RequestBuilder queryIntentServices(Intent intent, int i5) {
            this.b.add(new a("qritsvc", new Object[]{intent, Integer.valueOf(i5)}));
            return this;
        }

        public void request(DHResponder dHResponder) {
            final DHResponder dHResponder2;
            try {
                final boolean z6 = Looper.getMainLooper() == Looper.myLooper();
                final Boolean bool = cn.fly.tools.c.a.b.get();
                final Boolean bool2 = cn.fly.tools.c.a.c.get();
                dHResponder2 = dHResponder;
                try {
                    Runnable runnable = new Runnable() { // from class: cn.fly.tools.utils.DH.RequestBuilder.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                cn.fly.tools.c.a.f1803a.set(Boolean.TRUE);
                                cn.fly.tools.c.a.b.set(bool);
                                cn.fly.tools.c.a.c.set(bool2);
                                final DHResponse dHResponseA = RequestBuilder.this.a();
                                DHResponder dHResponder3 = dHResponder2;
                                if (dHResponder3 != null) {
                                    if (z6) {
                                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.fly.tools.utils.DH.RequestBuilder.1.1
                                            @Override // android.os.Handler.Callback
                                            public boolean handleMessage(Message message) {
                                                try {
                                                    dHResponder2.onResponse(dHResponseA);
                                                } catch (Throwable th) {
                                                    FlyLog.getInstance().d(th, "Error from caller", new Object[0]);
                                                }
                                                return false;
                                            }
                                        });
                                    } else {
                                        try {
                                            dHResponder3.onResponse(dHResponseA);
                                        } catch (Throwable th) {
                                            FlyLog.getInstance().d(th, "Error from caller", new Object[0]);
                                        }
                                    }
                                }
                                ThreadLocal<Boolean> threadLocal = cn.fly.tools.c.a.f1803a;
                                Boolean bool3 = Boolean.FALSE;
                                threadLocal.set(bool3);
                                cn.fly.tools.c.a.b.set(bool3);
                                cn.fly.tools.c.a.c.set(bool3);
                            } catch (Throwable th2) {
                                FlyLog.getInstance().d(th2);
                                RequestBuilder.this.a(dHResponder2);
                            }
                        }
                    };
                    if (z6) {
                        ac.e.execute(runnable);
                    } else {
                        runnable.run();
                    }
                } catch (Throwable th) {
                    th = th;
                    FlyLog.getInstance().d(th);
                    if (dHResponder2 != null) {
                        a(dHResponder2);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                dHResponder2 = dHResponder;
            }
        }

        public RequestBuilder resolveActivity(Intent intent, int i5) {
            this.b.add(new a("rsaciy", new Object[]{intent, Integer.valueOf(i5)}));
            return this;
        }

        public RequestBuilder usbEnable() {
            this.b.add(new a("ubenbl", new Object[0]));
            return this;
        }

        public RequestBuilder vpn() {
            this.b.add(new a("vnmt", new Object[0]));
            return this;
        }

        private RequestBuilder(Context context) {
            this.b = new LinkedList<>();
            this.f1876a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(DHResponder dHResponder) {
            if (dHResponder != null) {
                try {
                    dHResponder.onResponse(new DHResponse());
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th, "Error from caller", new Object[0]);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DHResponse a() {
            DHResponse dHResponse = new DHResponse();
            for (int i5 = 0; i5 < this.b.size(); i5++) {
                a aVar = this.b.get(i5);
                try {
                    String str = aVar.f1879a;
                    dHResponse.a(str, a(str, aVar.b));
                } catch (Throwable th) {
                    try {
                        FlyLog.getInstance().d(th);
                        dHResponse.a(aVar.f1879a, (Object) null, true);
                    } catch (Throwable th2) {
                        FlyLog.getInstance().d(th2);
                    }
                }
            }
            return dHResponse;
        }

        private Object a(String str, Object[] objArr) throws Throwable {
            if ("gmpfo".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().b(false, 0, (String) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gmpfofce".equals(str)) {
                if (objArr != null && objArr.length == 3) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().b(((Boolean) objArr[0]).booleanValue(), 0, (String) objArr[1], ((Integer) objArr[2]).intValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("getMpfos".equals(str)) {
                if (objArr != null && objArr.length == 3) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().b(false, ((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("cird".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().a());
            }
            if ("gsimt".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().a(false);
            }
            if ("gsimtfce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().a(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gbsi".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().b(false);
            }
            if ("gbsifce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().b(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gstmpts".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().a((String) objArr[0]);
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gscsz".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().J();
            }
            if ("gcrie".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().c(false);
            }
            if ("gcriefce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().c(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gcriefcestr".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().d(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gcrnm".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().e(false);
            }
            if ("gcrnmfce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().e(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gcrnmfcestr".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().f(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gsnmd".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().Z();
            }
            if ("gsnmdfp".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().c((String) objArr[0]);
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gneyp".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().h(false);
            }
            if ("gneypnw".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().i(false);
            }
            if ("gneypfce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().h(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("cknavbl".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().j(false));
            }
            if ("cknavblfc".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().j(((Boolean) objArr[0]).booleanValue()));
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gnktpfs".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().K();
            }
            if ("gdtlnktpfs".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().L();
            }
            if ("gdvk".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().X();
            }
            if ("gdvkfc".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().l(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gpnmmt".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().ab();
            }
            if ("gpnmfp".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().d((String) objArr[0]);
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gia".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().a(((Boolean) objArr[0]).booleanValue(), false);
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("giafce".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().a(((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gsl".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().W();
            }
            if ("gscpt".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().Y();
            }
            if ("gavti".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().j();
            }
            if ("glctn".equals(str)) {
                if (objArr != null && objArr.length == 3) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gtecloc".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().t();
            }
            if ("gnbclin".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().u();
            }
            if ("gdvtp".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().s();
            }
            if ("wmcwi".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().v();
            }
            if ("ipgist".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().b((String) objArr[0]));
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gcuin".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().C();
            }
            if ("gabis".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().D();
            }
            if ("gtydvin".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().E();
            }
            if ("gqmkn".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().F();
            }
            if ("gszin".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().G();
            }
            if ("gmrin".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().H();
            }
            if ("gmivsn".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().k();
            }
            if ("gmivsnfly".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().l();
            }
            if ("cx".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().b());
            }
            if ("ckpd".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().c());
            }
            if ("ubenbl".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().h());
            }
            if ("dvenbl".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().g());
            }
            if ("ckua".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().f());
            }
            if ("vnmt".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().e());
            }
            if ("degb".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().d());
            }
            if ("iwpxy".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().i());
            }
            if ("gflv".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().P();
            }
            if ("gbsbd".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().Q();
            }
            if ("gbfspy".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().R();
            }
            if ("gbplfo".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().S();
            }
            if ("gdntp".equals(str)) {
                return Integer.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().M());
            }
            if ("gdntpstr".equals(str)) {
                return Integer.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().N());
            }
            if ("qritsvc".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().a((Intent) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("rsaciy".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().b((Intent) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gpgif".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().a(false, 0, (String) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gpgiffcin".equals(str)) {
                if (objArr != null && objArr.length == 3) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().a(((Boolean) objArr[0]).booleanValue(), 0, (String) objArr[1], ((Integer) objArr[2]).intValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gpgifstrg".equals(str)) {
                if (objArr != null && objArr.length == 3) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().a(false, ((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("giads".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().T();
            }
            if ("giadsstr".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().U();
            }
            if ("gdvda".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().ai();
            }
            if ("gdvdtnas".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().aj();
            }
            if ("galtut".equals(str)) {
                return Long.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().ak());
            }
            if ("gdvme".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().al();
            }
            if ("gcrup".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().am();
            }
            if ("gcifm".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().an();
            }
            if ("godm".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().ao();
            }
            if ("godhm".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().ap();
            }
            if ("galdm".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().aq();
            }
            if ("gtaif".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().ar();
            }
            if ("gtaifprm".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().a((String) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gtaifprmfce".equals(str)) {
                if (objArr != null && objArr.length == 3) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().a(((Boolean) objArr[0]).booleanValue(), (String) objArr[1], ((Integer) objArr[2]).intValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gtdrd".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().at();
            }
            if ("gtbdt".equals(str)) {
                return Long.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().au());
            }
            if ("gtscnin".equals(str)) {
                return Double.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().av());
            }
            if ("gtscnppi".equals(str)) {
                return Integer.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().aw());
            }
            if ("ishmos".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().ax());
            }
            if ("gthmosv".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().ay();
            }
            if ("gthmosdtlv".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().az();
            }
            if ("gthmpmst".equals(str)) {
                return Integer.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().aA());
            }
            if ("gthmepmst".equals(str)) {
                return Integer.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().aB());
            }
            if ("gtinnerlangmt".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().aC();
            }
            if ("gtgramgendt".equals(str)) {
                return Integer.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().aD());
            }
            if ("gtelcmefce".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
            }
            if ("gtmwfo".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().g(false);
            }
            if ("wmcwifce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().g(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gtaifok".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().as();
            }
            if ("gtmcdi".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().a(false);
            }
            if ("gtmcdifce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().a(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gtmbcdi".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().b(false);
            }
            if ("gtmbcdifce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().b(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("miwpy".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().i());
            }
            if ("gtmnbclfo".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().u();
            }
            if ("ctedebbing".equals(str)) {
                return Boolean.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().aE());
            }
            if ("gteacifo".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().aF();
            }
            if ("gtdm".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().m(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gtlstactme".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return Long.valueOf(cn.fly.tools.b.c.a(this.f1876a).d().f((String) objArr[0]));
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gtscrpch".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().aI();
            }
            if ("gtrtmey".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().n(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gppl".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return cn.fly.tools.b.c.a(this.f1876a).d().k(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable(androidx.exifinterface.media.a.p("params illegal: ", objArr));
            }
            if ("gtrddi".equals(str)) {
                return cn.fly.tools.b.c.a(this.f1876a).d().aJ();
            }
            return null;
        }

        public RequestBuilder getBtM() {
            return this;
        }

        public RequestBuilder getDeviceId() {
            return this;
        }

        public RequestBuilder getIMEI() {
            return this;
        }

        public RequestBuilder getIMSI() {
            return this;
        }

        public RequestBuilder getSdcardState() {
            return this;
        }

        public RequestBuilder getSerialno() {
            return this;
        }

        public RequestBuilder getSimSerialNumber() {
            return this;
        }

        public RequestBuilder getTopActivity() {
            return this;
        }

        public RequestBuilder getUpM() {
            return this;
        }

        public RequestBuilder queryIMEI() {
            return this;
        }

        public RequestBuilder queryIMSI() {
            return this;
        }
    }

    public static final class SyncMtd {
        public static String Base64AES(String str, String str2) {
            return Data.Base64AES(str, str2);
        }

        public static boolean checkPermission(String str) {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().e(str);
        }

        public static Object currentActivityThread() {
            return C0396r.b();
        }

        public static String getAppLanguage() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().I();
        }

        public static int getAppVersion() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().ac();
        }

        public static String getAppVersionName() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().ad();
        }

        public static Context getApplication() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().ah();
        }

        public static String getBrand() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().q();
        }

        public static String getBrandForFly() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().r();
        }

        public static String getCurrentProcessName() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().af();
        }

        public static String getManufacturer() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().o();
        }

        public static String getManufacturerForFly() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().p();
        }

        public static String getModel() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().m();
        }

        public static String getModelForFly() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().n();
        }

        public static String getOSCountry() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().B();
        }

        public static String getOSLanguage() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().A();
        }

        public static int getOSVersionInt() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().w();
        }

        public static int getOSVersionIntForFly() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().x();
        }

        public static String getOSVersionName() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().y();
        }

        public static String getOSVersionNameForFly() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().z();
        }

        public static String getPackageName() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().aa();
        }

        public static int getPlatformCode() {
            return 1;
        }

        public static String getSandboxPath() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().Y();
        }

        public static String getSystemProperties(String str) {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().a(str);
        }

        public static Object getSystemServiceSafe(String str) {
            return C0396r.d(str);
        }

        public static String getTimezone() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().O();
        }

        public static void hideSoftInput(View view) {
            C0396r.a(view);
        }

        public static <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) {
            return (T) ReflectHelper.invokeInstanceMethodNoThrow(obj, str, null, objArr);
        }

        public static boolean isAut() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().aH();
        }

        public static boolean isGooglePlayServicesAvailable() {
            return false;
        }

        public static boolean isInMainProcess() {
            return cn.fly.tools.b.c.a(FlySDK.getContext()).d().ae();
        }

        public static boolean isSupportPushRid() {
            return true;
        }

        public static void showSoftInput(View view) {
            C0396r.b(view);
        }

        public static <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
            try {
                return (T) ReflectHelper.invokeInstanceMethod(obj, str, objArr, clsArr);
            } catch (Throwable th) {
                if (th instanceof InvocationTargetException) {
                    String name = th.getClass().getName();
                    String message = th.getMessage();
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        name = cause.getClass().getName();
                        message = cause.getMessage();
                    }
                    FlyLog.getInstance().d(androidx.exifinterface.media.a.m("Exception: ", name, ": ", message), new Object[0]);
                    return null;
                }
                if (!(th instanceof PackageManager.NameNotFoundException)) {
                    FlyLog.getInstance().d(th);
                    return null;
                }
                FlyLog.getInstance().d("Exception: " + th.getClass().getName() + ": " + th.getMessage(), new Object[0]);
                return null;
            }
        }
    }

    public static RequestBuilder requester(Context context) {
        return new RequestBuilder(context);
    }
}
