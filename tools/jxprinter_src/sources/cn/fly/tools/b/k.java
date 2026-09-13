package cn.fly.tools.b;

import A3.AbstractC0157z;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import cn.fly.commons.CSCenter;
import cn.fly.commons.aa;
import cn.fly.commons.ab;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.FileUtils;
import cn.fly.tools.utils.FlyPersistence;
import java.io.File;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes.dex */
public class k implements cn.fly.tools.b.a {
    private Context d;
    private b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Set<String> f1721f = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f1720a = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> c = new ConcurrentHashMap<>();

    public static abstract class a<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public T f1800g;

        public a(T t6) {
            this.f1800g = t6;
        }

        public long a(T t6) {
            return 0L;
        }

        public abstract T b();
    }

    public k(Context context) {
        this.d = context;
        this.e = b.a(context);
        cn.fly.tools.utils.g.a();
        FlyLog.getInstance().d("[DH] nml imp loaded", new Object[0]);
    }

    private void h(String str) {
    }

    @Override // cn.fly.tools.b.a
    public String A() {
        return (String) b("ole", new a<String>(null) { // from class: cn.fly.tools.b.k.15
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 3600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.h();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String B() {
        return (String) b("ocy", new a<String>(null) { // from class: cn.fly.tools.b.k.16
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 3600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.j();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Object> C() {
        return (HashMap) b("cio0", new a<HashMap<String, Object>>(null) { // from class: cn.fly.tools.b.k.17
            @Override // cn.fly.tools.b.k.a
            public long a(HashMap<String, Object> map) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, Object> b() {
                return k.this.e.A();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String D() {
        return (String) b("gabis", new a<String>(null) { // from class: cn.fly.tools.b.k.18
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.ay();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<ArrayList<String>> E() {
        return (ArrayList) b("tdio", new a<ArrayList<ArrayList<String>>>(null) { // from class: cn.fly.tools.b.k.19
            @Override // cn.fly.tools.b.k.a
            public long a(ArrayList<ArrayList<String>> arrayList) {
                return DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList<ArrayList<String>> b() {
                return k.this.e.B();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String F() {
        return (String) b("qkl", new a<String>(null) { // from class: cn.fly.tools.b.k.20
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                if ("0".equals(str)) {
                    return DateUtil.DAY_MILLISECONDS;
                }
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.C();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, HashMap<String, Long>> G() {
        return (HashMap) b("siio", new a<HashMap<String, HashMap<String, Long>>>(null) { // from class: cn.fly.tools.b.k.21
            @Override // cn.fly.tools.b.k.a
            public long a(HashMap<String, HashMap<String, Long>> map) {
                return DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, HashMap<String, Long>> b() {
                return k.this.e.D();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Long> H() {
        return (HashMap) b("meio", new a<HashMap<String, Long>>(null) { // from class: cn.fly.tools.b.k.22
            @Override // cn.fly.tools.b.k.a
            public long a(HashMap<String, Long> map) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, Long> b() {
                return k.this.e.E();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String I() {
        return (String) b("ale", new a<String>(null) { // from class: cn.fly.tools.b.k.24
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.i();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String J() {
        return (String) b("sse", new a<String>(null) { // from class: cn.fly.tools.b.k.25
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.k();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String K() {
        return o(false);
    }

    @Override // cn.fly.tools.b.a
    public String L() {
        String lowerCase = i(false).toLowerCase();
        if (TextUtils.isEmpty(lowerCase) || cn.fly.commons.a.l.a("004fSelMfg").equals(lowerCase)) {
            return cn.fly.commons.a.l.a("004fBel2fg");
        }
        if (lowerCase.startsWith(cn.fly.commons.a.l.a("004Pghejfgej"))) {
            return cn.fly.commons.a.l.a("004-ghejfgej");
        }
        if (lowerCase.startsWith(cn.fly.commons.a.l.a("002Fijfk"))) {
            return cn.fly.commons.a.l.a("002 ijfk");
        }
        if (lowerCase.startsWith(cn.fly.commons.a.l.a("002Limfk"))) {
            return cn.fly.commons.a.l.a("002Zimfk");
        }
        if (lowerCase.startsWith(cn.fly.commons.a.l.a("002Ukgfk"))) {
            return cn.fly.commons.a.l.a("002Vkgfk");
        }
        if (lowerCase.startsWith(cn.fly.commons.a.l.a("002Qiffk"))) {
            return cn.fly.commons.a.l.a("0020iffk");
        }
        return lowerCase.startsWith(cn.fly.commons.a.l.a("009AggPhWehRgj>elelYji")) ? cn.fly.commons.a.l.a("009;ggHh2eh>gjCelel?ji") : lowerCase;
    }

    @Override // cn.fly.tools.b.a
    public int M() {
        return p(true);
    }

    @Override // cn.fly.tools.b.a
    public int N() {
        return p(cn.fly.commons.e.i());
    }

    @Override // cn.fly.tools.b.a
    public String O() {
        return (String) b("tize", new a<String>(null) { // from class: cn.fly.tools.b.k.28
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 3600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.P();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String P() {
        return (String) b("flvr", new a<String>(null) { // from class: cn.fly.tools.b.k.29
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 3600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.Q();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String Q() {
        return (String) b("babd", new a<String>(null) { // from class: cn.fly.tools.b.k.30
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.R();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String R() {
        return (String) b("bfsp", new a<String>(null) { // from class: cn.fly.tools.b.k.31
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.S();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String S() {
        return (String) b("bopm", new a<String>(null) { // from class: cn.fly.tools.b.k.32
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.T();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String T() {
        return q(true);
    }

    @Override // cn.fly.tools.b.a
    public String U() {
        return q(cn.fly.commons.e.i());
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, String>> V() {
        return r(false);
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, String>> W() {
        ArrayList<HashMap<String, String>> arrayListA;
        synchronized ("gsl") {
            arrayListA = this.e.a(r(false), 2);
        }
        return arrayListA;
    }

    @Override // cn.fly.tools.b.a
    public String X() {
        return (String) b("deky", new a<String>(null) { // from class: cn.fly.tools.b.k.36
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.b(false);
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String Y() {
        return (String) b("scph", new a<String>(null) { // from class: cn.fly.tools.b.k.37
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.s();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String Z() {
        return this.e.b(aa());
    }

    @Override // cn.fly.tools.b.a
    public int aA() {
        return ((Integer) b("hmpmst", new a<Integer>(-1) { // from class: cn.fly.tools.b.k.60
            @Override // cn.fly.tools.b.k.a
            public long a(Integer num) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() {
                return Integer.valueOf(k.this.e.am());
            }
        })).intValue();
    }

    @Override // cn.fly.tools.b.a
    public int aB() {
        return ((Integer) b("hmepmst", new a<Integer>(-1) { // from class: cn.fly.tools.b.k.61
            @Override // cn.fly.tools.b.k.a
            public long a(Integer num) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() {
                return Integer.valueOf(k.this.e.aq());
            }
        })).intValue();
    }

    @Override // cn.fly.tools.b.a
    public String aC() {
        return (String) b("gtinnerlangmt", new a<String>(null) { // from class: cn.fly.tools.b.k.62
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.as();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public int aD() {
        return ((Integer) b("gtgramgendt", new a<Integer>(0) { // from class: cn.fly.tools.b.k.63
            @Override // cn.fly.tools.b.k.a
            public long a(Integer num) {
                return DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() {
                return Integer.valueOf(k.this.e.at());
            }
        })).intValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean aE() {
        return ((Boolean) a("debbing", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.64
            @Override // cn.fly.tools.b.k.a
            public long a(Boolean bool) {
                return 60000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.aw());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, Object>> aF() {
        return (ArrayList) b("gteacifo", new a<ArrayList<HashMap<String, Object>>>(null) { // from class: cn.fly.tools.b.k.68
            @Override // cn.fly.tools.b.k.a
            public long a(ArrayList<HashMap<String, Object>> arrayList) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList<HashMap<String, Object>> b() {
                return k.this.e.av();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public boolean aG() {
        return ((Boolean) a("gpsavlbmt", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.71
            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.ax());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean aH() {
        return ((Boolean) a("isaut", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.72
            @Override // cn.fly.tools.b.k.a
            public long a(Boolean bool) {
                return 600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.ad());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String aI() {
        return (String) b("gtscrpch", new a<String>(null) { // from class: cn.fly.tools.b.k.73
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.an();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String aJ() {
        return (String) a("gtrddi", new a<String>(null) { // from class: cn.fly.tools.b.k.75
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.ap();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String aa() {
        return (String) b("pne", new a<String>(null) { // from class: cn.fly.tools.b.k.38
            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.n();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String ab() {
        return this.e.o();
    }

    @Override // cn.fly.tools.b.a
    public int ac() {
        return this.e.p();
    }

    @Override // cn.fly.tools.b.a
    public String ad() {
        return this.e.q();
    }

    @Override // cn.fly.tools.b.a
    public boolean ae() {
        return ((Boolean) a("imp", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.39
            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.W());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String af() {
        return (String) a("cpne", new a<String>(null) { // from class: cn.fly.tools.b.k.40
            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.X();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public boolean ag() {
        return aa.a();
    }

    @Override // cn.fly.tools.b.a
    public Context ah() {
        return (Context) a("galct", new a<Context>(null) { // from class: cn.fly.tools.b.k.41
            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Context b() {
                if (k.this.d != null) {
                    return k.this.d;
                }
                Context contextW = b.w();
                if (contextW != null) {
                    k.this.d = contextW;
                }
                return contextW;
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String ai() {
        return this.e.d();
    }

    @Override // cn.fly.tools.b.a
    public String aj() {
        return this.e.e();
    }

    @Override // cn.fly.tools.b.a
    public long ak() {
        return this.e.Y();
    }

    @Override // cn.fly.tools.b.a
    public String al() {
        return (String) b("dvcnm", new a<String>(null) { // from class: cn.fly.tools.b.k.43
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 3600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.Z();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String am() {
        return (String) b("cgrp", new a<String>(null) { // from class: cn.fly.tools.b.k.44
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.aa();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String an() {
        return (String) b("cinfo", new a<String>(null) { // from class: cn.fly.tools.b.k.46
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.ab();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String ao() {
        if (!CSCenter.getInstance().isOaidEnable()) {
            return CSCenter.getInstance().getOaid();
        }
        String str = null;
        if (cn.fly.commons.e.a()) {
            return (String) b("odmt", new a<String>(str) { // from class: cn.fly.tools.b.k.47
                @Override // cn.fly.tools.b.k.a
                public long a(String str2) {
                    return TextUtils.isEmpty(str2) ? -1L : 604800000L;
                }

                @Override // cn.fly.tools.b.k.a
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String b() {
                    return k.this.e.ac();
                }
            });
        }
        return null;
    }

    @Override // cn.fly.tools.b.a
    public String ap() {
        String strAo = c.a(this.d).d().ao();
        if (!TextUtils.isEmpty(strAo)) {
            try {
                return Base64.encodeToString(Data.AES128Encode(Data.MD5(DH.SyncMtd.getManufacturerForFly()), strAo), 2);
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        return strAo;
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Object> aq() {
        return (HashMap) b("alldmt", new a<HashMap<String, Object>>(null) { // from class: cn.fly.tools.b.k.48
            @Override // cn.fly.tools.b.k.a
            public long a(HashMap<String, Object> map) {
                return DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, Object> b() {
                return k.this.e.ae();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public ApplicationInfo ar() {
        final boolean zA = cn.fly.tools.c.a("1009", this.d.getPackageName());
        return (ApplicationInfo) b("gtaif", new a<ApplicationInfo>(null) { // from class: cn.fly.tools.b.k.49
            @Override // cn.fly.tools.b.k.a
            public long a(ApplicationInfo applicationInfo) {
                if (zA) {
                    return 0L;
                }
                return DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ApplicationInfo b() {
                return e.a(k.this.d).d();
            }
        }, a(zA, "gtaif", aa()));
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, Object>> as() {
        return (ArrayList) b("gtwflok", new a<ArrayList<HashMap<String, Object>>>(null) { // from class: cn.fly.tools.b.k.50
            @Override // cn.fly.tools.b.k.a
            public long a(ArrayList<HashMap<String, Object>> arrayList) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList<HashMap<String, Object>> b() {
                Boolean bool;
                if (!cn.fly.commons.e.d() || !k.this.e(cn.fly.commons.a.l.a("036ef0edekelejedemBkg%ekegejgjgjejel[f[emfeglgefhjehjeihgffhdffeifmgdgegdhj")) || !k.this.e(cn.fly.commons.a.l.a("036efAedekelejedemTkgKekegejgjgjejel[f%emgefefehjfmfmeihgffhdffeifmgdgegdhj"))) {
                    return null;
                }
                LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                k.this.e.a((BlockingQueue<Boolean>) linkedBlockingQueue);
                k.this.e.z();
                try {
                    bool = (Boolean) linkedBlockingQueue.poll(20000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                    bool = null;
                }
                if (bool == null || !bool.booleanValue()) {
                    return null;
                }
                return k.this.e.y();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String at() {
        return (String) b("gtdrd", new a<String>(null) { // from class: cn.fly.tools.b.k.52
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.af();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public long au() {
        return ((Long) b("gtbdt", new a<Long>(0L) { // from class: cn.fly.tools.b.k.53
            @Override // cn.fly.tools.b.k.a
            public long a(Long l6) {
                return 3600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Long b() {
                return Long.valueOf(k.this.e.ag());
            }
        })).longValue();
    }

    @Override // cn.fly.tools.b.a
    public double av() {
        return ((Double) b("gtscnin", new a<Double>(Double.valueOf(0.0d)) { // from class: cn.fly.tools.b.k.54
            @Override // cn.fly.tools.b.k.a
            public long a(Double d) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Double b() {
                return Double.valueOf(k.this.e.ah());
            }
        })).doubleValue();
    }

    @Override // cn.fly.tools.b.a
    public int aw() {
        return ((Integer) b("gtscnppi", new a<Integer>(0) { // from class: cn.fly.tools.b.k.55
            @Override // cn.fly.tools.b.k.a
            public long a(Integer num) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() {
                return Integer.valueOf(k.this.e.ai());
            }
        })).intValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean ax() {
        return ((Boolean) b("ishmos", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.57
            @Override // cn.fly.tools.b.k.a
            public long a(Boolean bool) {
                return 3600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.aj());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String ay() {
        return (String) b("gthmosv", new a<String>(null) { // from class: cn.fly.tools.b.k.58
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 3600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.ak();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String az() {
        return (String) b("gthmosdtlv", new a<String>(null) { // from class: cn.fly.tools.b.k.59
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 3600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.al();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public boolean c() {
        return ((Boolean) b("pd0", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.23
            @Override // cn.fly.tools.b.k.a
            public long a(Boolean bool) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.H());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean d() {
        return ((Boolean) a("dee", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.34
            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.M());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean e() {
        return this.e.L();
    }

    @Override // cn.fly.tools.b.a
    public boolean f() {
        return ((Boolean) a("ua0", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.45
            @Override // cn.fly.tools.b.k.a
            public long a(Boolean bool) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.K());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean g() {
        return ((Boolean) a("dee1", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.56
            @Override // cn.fly.tools.b.k.a
            public long a(Boolean bool) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.J());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public boolean i() {
        return ((Boolean) a("wpy", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.76
            @Override // cn.fly.tools.b.k.a
            public long a(Boolean bool) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.N());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String j() {
        return (String) b("agi", new a<String>(null) { // from class: cn.fly.tools.b.k.77
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.t();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String k() {
        return (String) b("mvn", new a<String>(null) { // from class: cn.fly.tools.b.k.4
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.F();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String l() {
        if (CSCenter.getInstance().isSystemInfoAvailable()) {
            return k();
        }
        String strB = cn.fly.tools.utils.g.a().b("mvn", "");
        if (TextUtils.isEmpty(strB)) {
            strB = CSCenter.getInstance().getROMVersion();
        }
        return TextUtils.isEmpty(strB) ? "" : strB;
    }

    @Override // cn.fly.tools.b.a
    public String m() {
        return (String) b("mol", new a<String>(null) { // from class: cn.fly.tools.b.k.5
            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.b();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String n() {
        if (CSCenter.getInstance().isModelAvailable()) {
            return m();
        }
        String strB = cn.fly.tools.utils.g.a().b("mol", "");
        if (TextUtils.isEmpty(strB)) {
            strB = CSCenter.getInstance().getModel();
        }
        return TextUtils.isEmpty(strB) ? "" : strB;
    }

    @Override // cn.fly.tools.b.a
    public String o() {
        return (String) b("mar", new a<String>(null) { // from class: cn.fly.tools.b.k.6
            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.c();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String p() {
        if (CSCenter.getInstance().isManufacturerAvailable()) {
            return o();
        }
        String strB = cn.fly.tools.utils.g.a().b("mar", "");
        if (TextUtils.isEmpty(strB)) {
            strB = CSCenter.getInstance().getManufacturer();
        }
        return TextUtils.isEmpty(strB) ? "" : strB;
    }

    @Override // cn.fly.tools.b.a
    public String q() {
        return (String) b("brd", new a<String>(null) { // from class: cn.fly.tools.b.k.7
            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.V();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String r() {
        if (CSCenter.getInstance().isManufacturerAvailable()) {
            return q();
        }
        String strA = cn.fly.tools.utils.g.a().a("brd");
        if (TextUtils.isEmpty(strA)) {
            strA = CSCenter.getInstance().getBrand();
        }
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    @Override // cn.fly.tools.b.a
    public String s() {
        return (String) b("dte", new a<String>(null) { // from class: cn.fly.tools.b.k.8
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.v();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public Object t() {
        return b("gtecloc", new a<Object>(null) { // from class: cn.fly.tools.b.k.9
            @Override // cn.fly.tools.b.k.a
            public long a(Object obj) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            public Object b() {
                return k.this.e.ar();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, Object>> u() {
        return (ArrayList) b("bsnbcl", new a<ArrayList<HashMap<String, Object>>>(null) { // from class: cn.fly.tools.b.k.10
            @Override // cn.fly.tools.b.k.a
            public long a(ArrayList<HashMap<String, Object>> arrayList) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList<HashMap<String, Object>> b() {
                return k.this.e.u();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Object> v() {
        return g(false);
    }

    @Override // cn.fly.tools.b.a
    public int w() {
        return ((Integer) b("ovit", new a<Integer>(-1) { // from class: cn.fly.tools.b.k.13
            @Override // cn.fly.tools.b.k.a
            public long a(Integer num) {
                return DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() {
                return Integer.valueOf(k.this.e.f());
            }
        })).intValue();
    }

    @Override // cn.fly.tools.b.a
    public int x() {
        if (CSCenter.getInstance().isSystemInfoAvailable()) {
            return w();
        }
        int iA = cn.fly.tools.utils.g.a().a("ovit", 0);
        if (iA >= 1 || (iA = CSCenter.getInstance().getSystemVersionCode()) >= 1) {
            return iA;
        }
        return 0;
    }

    @Override // cn.fly.tools.b.a
    public String y() {
        return (String) b("ovne", new a<String>(null) { // from class: cn.fly.tools.b.k.14
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.g();
            }
        });
    }

    @Override // cn.fly.tools.b.a
    public String z() {
        if (CSCenter.getInstance().isSystemInfoAvailable()) {
            return y();
        }
        String strB = cn.fly.tools.utils.g.a().b("ovne", "");
        if (TextUtils.isEmpty(strB)) {
            strB = CSCenter.getInstance().getSystemVersionName();
        }
        return TextUtils.isEmpty(strB) ? "" : strB;
    }

    private String o(boolean z6) {
        String lowerCase = i(z6).toLowerCase();
        if (TextUtils.isEmpty(lowerCase) || cn.fly.commons.a.l.a("004f-elFfg").equals(lowerCase)) {
            return cn.fly.commons.a.l.a("004f)el,fg");
        }
        if (lowerCase.startsWith(cn.fly.commons.a.l.a("002Xijfk")) || lowerCase.startsWith(cn.fly.commons.a.l.a("002Iimfk")) || lowerCase.startsWith(cn.fly.commons.a.l.a("002(kgfk")) || lowerCase.startsWith(cn.fly.commons.a.l.a("002Kiffk"))) {
            return cn.fly.commons.a.l.a("004dghh");
        }
        return (lowerCase.startsWith(cn.fly.commons.a.l.a("004Rghejfgej")) || "forbid".equals(lowerCase)) ? cn.fly.commons.a.l.a("004Kghejfgej") : cn.fly.commons.a.l.a("005AelNjigNek");
    }

    private String q(boolean z6) {
        if (!CSCenter.getInstance().isIpAddressEnable()) {
            return CSCenter.getInstance().getIpAddress();
        }
        if (!z6) {
            return "0.0.0.0";
        }
        try {
            Enumeration<NetworkInterface> enumerationA = e.a(this.d).a();
            while (enumerationA.hasMoreElements()) {
                Enumeration<InetAddress> enumerationA2 = e.a(this.d).a(enumerationA.nextElement());
                while (enumerationA2.hasMoreElements()) {
                    InetAddress inetAddressNextElement = enumerationA2.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    @Override // cn.fly.tools.b.a
    public boolean b() {
        return ((Boolean) b("cx0", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.12
            @Override // cn.fly.tools.b.k.a
            public long a(Boolean bool) {
                if (bool == null || !bool.booleanValue()) {
                    return 180000L;
                }
                return DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.G());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String c(boolean z6) {
        return b(z6, true);
    }

    @Override // cn.fly.tools.b.a
    public String d(boolean z6) {
        return b(z6, cn.fly.commons.e.i());
    }

    @Override // cn.fly.tools.b.a
    public String e(boolean z6) {
        return c(z6, true);
    }

    @Override // cn.fly.tools.b.a
    public String f(boolean z6) {
        return c(z6, cn.fly.commons.e.i());
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Object> g(boolean z6) {
        return (HashMap) b("crtwfo", new a<HashMap<String, Object>>(null) { // from class: cn.fly.tools.b.k.11
            @Override // cn.fly.tools.b.k.a
            public long a(HashMap<String, Object> map) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, Object> b() {
                return k.this.e.x();
            }
        }, z6);
    }

    @Override // cn.fly.tools.b.a
    public boolean h() {
        return ((Boolean) a("uee", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.67
            @Override // cn.fly.tools.b.k.a
            public long a(Boolean bool) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.I());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String i(boolean z6) {
        return d(z6, cn.fly.commons.e.i());
    }

    @Override // cn.fly.tools.b.a
    public boolean j(boolean z6) {
        String strO = o(z6);
        return cn.fly.commons.a.l.a("004Mghejfgej").equals(strO) || cn.fly.commons.a.l.a("004dghh").equals(strO);
    }

    @Override // cn.fly.tools.b.a
    public Set<String> k(boolean z6) {
        return (Set) b("gppl", new a<Set<String>>(null) { // from class: cn.fly.tools.b.k.35
            @Override // cn.fly.tools.b.k.a
            public long a(Set<String> set) {
                Calendar calendar = Calendar.getInstance();
                long jA = k.this.a(calendar) - calendar.getTimeInMillis();
                return jA > 0 ? jA : DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Set<String> b() {
                return k.this.e.r();
            }
        }, z6);
    }

    @Override // cn.fly.tools.b.a
    public String m(boolean z6) {
        return (String) b("gtdm", new a<String>(null) { // from class: cn.fly.tools.b.k.69
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return ab.a().g();
            }
        }, z6);
    }

    private String c(boolean z6, boolean z7) {
        return (String) a("cne", new a<String>(null) { // from class: cn.fly.tools.b.k.3
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.m();
            }
        }, z6, z7);
    }

    private String d(final boolean z6, boolean z7) {
        if (!z7) {
            FlyLog.getInstance().d("net type W: forb as na=0 probably", new Object[0]);
        }
        String str = (String) a("nte", new a<String>(null) { // from class: cn.fly.tools.b.k.26
            @Override // cn.fly.tools.b.k.a
            public long a(String str2) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.a(z6);
            }
        }, z6, z7);
        return (str != null || z7) ? str : "forbid";
    }

    private long g(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        ApplicationInfo applicationInfoA = a(true, str, 0);
        String str2 = applicationInfoA != null ? applicationInfoA.sourceDir : null;
        if (TextUtils.isEmpty(str2)) {
            return 0L;
        }
        return new File(str2).lastModified();
    }

    @Override // cn.fly.tools.b.a
    public String b(boolean z6) {
        HashMap<String, Object> mapG = g(z6);
        if (mapG != null) {
            return (String) mapG.get("bsmt");
        }
        return null;
    }

    @Override // cn.fly.tools.b.a
    public boolean e(String str) {
        try {
            return this.e.d(str);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return false;
        }
    }

    @Override // cn.fly.tools.b.a
    public long f(final String str) {
        return ((Long) b(AbstractC0157z.n("gtlstact-", str), new a<Long>(-1L) { // from class: cn.fly.tools.b.k.70
            @Override // cn.fly.tools.b.k.a
            public long a(Long l6) {
                return 604800000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Long b() {
                return Long.valueOf(FileUtils.getLATime(str));
            }
        })).longValue();
    }

    @Override // cn.fly.tools.b.a
    public String h(boolean z6) {
        return d(z6, true);
    }

    @Override // cn.fly.tools.b.a
    public String c(String str) {
        return this.e.b(str);
    }

    private String b(boolean z6, boolean z7) {
        return (String) a("car", new a<String>(null) { // from class: cn.fly.tools.b.k.2
            @Override // cn.fly.tools.b.k.a
            public long a(String str) {
                return 600000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() {
                return k.this.e.l();
            }
        }, z6, z7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T c(String str, a<T> aVar) throws FlyPersistence.NoValidDataException {
        Type typeA = a((a) aVar);
        int iA = a(typeA);
        try {
            if (iA == 1) {
                return (T) cn.fly.tools.utils.g.a().a(str, (Class) ((GenericArrayType) typeA).getGenericComponentType(), (Parcelable[]) aVar.f1800g);
            }
            if (iA == 2 || iA == 4) {
                return (T) cn.fly.tools.utils.g.a().b(str, aVar.f1800g);
            }
            if (iA == 3) {
                ParameterizedType parameterizedType = (ParameterizedType) typeA;
                Class cls = (Class) parameterizedType.getRawType();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type type = actualTypeArguments[0];
                if (actualTypeArguments.length == 2) {
                    type = actualTypeArguments[1];
                }
                if (type instanceof Class) {
                    Class cls2 = (Class) type;
                    if (Parcelable.class.isAssignableFrom(cls2)) {
                        if (cls != List.class && cls != LinkedList.class && cls != ArrayList.class) {
                            if (cls == Map.class || cls == HashMap.class || cls == TreeMap.class || cls == Hashtable.class) {
                                return (T) cn.fly.tools.utils.g.a().b(str, cls2);
                            }
                        }
                        return (T) cn.fly.tools.utils.g.a().c(str, cls2);
                    }
                }
            } else if (iA == 9) {
                Class<T> cls3 = (Class) typeA;
                if (cls3 != null) {
                    if (cls3 == Integer.class) {
                        return (T) Integer.valueOf(cn.fly.tools.utils.g.a().b(str, ((Integer) aVar.f1800g).intValue()));
                    }
                    if (cls3 == Long.class) {
                        return (T) Long.valueOf(cn.fly.tools.utils.g.a().b(str, ((Long) aVar.f1800g).longValue()));
                    }
                    if (cls3 == Double.class) {
                        return (T) Double.valueOf(cn.fly.tools.utils.g.a().a(str, ((Double) aVar.f1800g).doubleValue()));
                    }
                    if (cls3 == Boolean.class) {
                        return (T) Boolean.valueOf(cn.fly.tools.utils.g.a().a(str, ((Boolean) aVar.f1800g).booleanValue()));
                    }
                    if (cls3 == String.class) {
                        return (T) cn.fly.tools.utils.g.a().c(str, (String) aVar.f1800g);
                    }
                    if (Parcelable.class.isAssignableFrom(cls3)) {
                        return (T) cn.fly.tools.utils.g.a().a(str, cls3, aVar.f1800g);
                    }
                    return (T) cn.fly.tools.utils.g.a().b(str, aVar.f1800g);
                }
            } else {
                return (T) cn.fly.tools.utils.g.a().b(str, aVar.f1800g);
            }
            return null;
        } catch (FlyPersistence.NoValidDataException e) {
            throw e;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    @Override // cn.fly.tools.b.a
    public boolean a() {
        return ((Boolean) b("ird", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.tools.b.k.1
            @Override // cn.fly.tools.b.k.a
            public long a(Boolean bool) {
                if (bool == null || !bool.booleanValue()) {
                    return 180000L;
                }
                return DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(k.this.e.a());
            }
        })).booleanValue();
    }

    @Override // cn.fly.tools.b.a
    public String a(boolean z6) {
        HashMap<String, Object> mapG = g(z6);
        if (mapG != null) {
            return (String) mapG.get("ssmt");
        }
        return null;
    }

    @Override // cn.fly.tools.b.a
    public boolean b(String str) {
        return this.e.e(str);
    }

    @Override // cn.fly.tools.b.a
    public String d(String str) {
        return this.e.c(str);
    }

    private int p(boolean z6) {
        return ((Integer) a("dtnttp", (a) new a<Integer>(-1) { // from class: cn.fly.tools.b.k.27
            @Override // cn.fly.tools.b.k.a
            public long a(Integer num) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() {
                return Integer.valueOf(k.this.e.U());
            }
        }, false, z6)).intValue();
    }

    private ArrayList<HashMap<String, String>> r(final boolean z6) {
        ArrayList<HashMap<String, String>> arrayList;
        synchronized ("gal") {
            arrayList = (ArrayList) b("gal", new a<ArrayList<HashMap<String, String>>>(null) { // from class: cn.fly.tools.b.k.33
                @Override // cn.fly.tools.b.k.a
                public long a(ArrayList<HashMap<String, String>> arrayList2) {
                    Calendar calendar = Calendar.getInstance();
                    long jA = k.this.a(calendar) - calendar.getTimeInMillis();
                    return jA > 0 ? jA : DateUtil.DAY_MILLISECONDS;
                }

                @Override // cn.fly.tools.b.k.a
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public ArrayList<HashMap<String, String>> b() {
                    return k.this.e.c(z6);
                }
            }, z6);
        }
        return arrayList;
    }

    @Override // cn.fly.tools.b.a
    public ResolveInfo b(Intent intent, int i5) {
        return e.a(this.d).b(intent, i5);
    }

    @Override // cn.fly.tools.b.a
    public String l(boolean z6) {
        return this.e.b(z6);
    }

    @Override // cn.fly.tools.b.a
    public HashMap<String, Long> n(boolean z6) {
        return (HashMap) b("gtrtmey", new a<HashMap<String, Long>>(null) { // from class: cn.fly.tools.b.k.74
            @Override // cn.fly.tools.b.k.a
            public long a(HashMap<String, Long> map) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, Long> b() {
                return k.this.e.ao();
            }
        }, z6);
    }

    @Override // cn.fly.tools.b.a
    public ArrayList<HashMap<String, String>> a(boolean z6, boolean z7) {
        synchronized ("giafce") {
            try {
                ArrayList<HashMap<String, String>> arrayListR = r(z7);
                if (z6) {
                    return this.e.a(arrayListR, 0);
                }
                return this.e.a(arrayListR, 1);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // cn.fly.tools.b.a
    public Object b(boolean z6, int i5, String str, int i6) {
        return b(z6, i5, str, i6, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List b(final int i5, final int i6, final boolean z6, final boolean z7) {
        StringBuilder sbS = androidx.collection.a.s("gtelcmefce-", i5, i6, ProcessIdUtil.DEFAULT_PROCESSID, ProcessIdUtil.DEFAULT_PROCESSID);
        sbS.append(z6);
        return (List) b(sbS.toString(), new a<List<Location>>(null) { // from class: cn.fly.tools.b.k.65
            @Override // cn.fly.tools.b.k.a
            public long a(List<Location> list) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Location> b() {
                return k.this.e.a(i5, i6, z6, z7);
            }
        }, z7);
    }

    @Override // cn.fly.tools.b.a
    public Location a(int i5, int i6, boolean z6) {
        List listB = b(i5, i6, z6, false);
        if (listB == null || listB.isEmpty()) {
            return null;
        }
        return (Location) AbstractC0157z.f(1, listB);
    }

    private PackageInfo b(boolean z6, int i5, String str, int i6, boolean z7) {
        if (str.equals(DH.SyncMtd.getPackageName())) {
            int i7 = (i6 == 0 || i6 == 1 || i6 == 128 || i6 == 64) ? 193 : i6;
            PackageInfo packageInfoA = a(z6, i5, str, i7, z7);
            return (packageInfoA == null && i7 == 193) ? a(z6, i5, str, i6, z7) : packageInfoA;
        }
        return a(z6, i5, str, i6, z7);
    }

    @Override // cn.fly.tools.b.a
    public String a(String str) {
        return this.e.a(str);
    }

    @Override // cn.fly.tools.b.a
    public List<ResolveInfo> a(Intent intent, int i5) {
        return e.a(this.d).a(intent, i5);
    }

    @Override // cn.fly.tools.b.a
    public PackageInfo a(boolean z6, int i5, String str, int i6) {
        return b(z6, i5, str, i6, true);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x005d  */
    private PackageInfo a(boolean z6, final int i5, final String str, final int i6, final boolean z7) {
        boolean z8;
        final boolean zA = cn.fly.tools.c.a("1009", str);
        String str2 = "gpi-" + i5 + ProcessIdUtil.DEFAULT_PROCESSID + str + ProcessIdUtil.DEFAULT_PROCESSID + i6 + ProcessIdUtil.DEFAULT_PROCESSID + z7;
        a<PackageInfo> aVar = new a<PackageInfo>(null) { // from class: cn.fly.tools.b.k.42
            @Override // cn.fly.tools.b.k.a
            public long a(PackageInfo packageInfo) {
                return zA ? i5 : DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PackageInfo b() {
                return (PackageInfo) e.a(k.this.d).a(str, i6, z7);
            }
        };
        if (z6) {
            z8 = true;
        } else {
            if (a(zA, "gpi-" + i5 + ProcessIdUtil.DEFAULT_PROCESSID + str + ProcessIdUtil.DEFAULT_PROCESSID + i6 + ProcessIdUtil.DEFAULT_PROCESSID + z7, str)) {
                z8 = true;
            } else {
                z8 = false;
            }
        }
        return (PackageInfo) b(str2, aVar, z8);
    }

    private <T> T b(String str, a<T> aVar) {
        return (T) b(str, aVar, false);
    }

    private <T> T b(String str, a<T> aVar, boolean z6) {
        return (T) a(str, (a) aVar, z6, true);
    }

    @Override // cn.fly.tools.b.a
    public ApplicationInfo a(String str, int i5) {
        return a(false, str, i5);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0042  */
    @Override // cn.fly.tools.b.a
    public ApplicationInfo a(boolean z6, final String str, final int i5) {
        boolean z7;
        final boolean zA = cn.fly.tools.c.a("1009", str);
        String str2 = "gtaiffce-" + str + ProcessIdUtil.DEFAULT_PROCESSID + i5;
        a<ApplicationInfo> aVar = new a<ApplicationInfo>(null) { // from class: cn.fly.tools.b.k.51
            @Override // cn.fly.tools.b.k.a
            public long a(ApplicationInfo applicationInfo) {
                if (zA) {
                    return 0L;
                }
                return DateUtil.DAY_MILLISECONDS;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ApplicationInfo b() {
                return e.a(k.this.d).a(str, i5);
            }
        };
        if (z6) {
            z7 = true;
        } else {
            if (a(zA, "gtaiffce-" + str + ProcessIdUtil.DEFAULT_PROCESSID + i5, str)) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return (ApplicationInfo) b(str2, aVar, z7);
    }

    @Override // cn.fly.tools.b.a
    public List<HashMap<String, Object>> a(final int i5, final int i6, final boolean z6, final boolean z7) {
        StringBuilder sbS = androidx.collection.a.s("gtepcommfce-", i5, i6, ProcessIdUtil.DEFAULT_PROCESSID, ProcessIdUtil.DEFAULT_PROCESSID);
        sbS.append(z6);
        return (List) b(sbS.toString(), new a<List<HashMap<String, Object>>>(null) { // from class: cn.fly.tools.b.k.66
            @Override // cn.fly.tools.b.k.a
            public long a(List<HashMap<String, Object>> list) {
                return 180000L;
            }

            @Override // cn.fly.tools.b.k.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<HashMap<String, Object>> b() {
                ArrayList arrayList = null;
                try {
                    List listB = k.this.b(i5, i6, z6, z7);
                    if (listB == null || listB.isEmpty()) {
                        return null;
                    }
                    int i7 = 0;
                    while (i7 < listB.size()) {
                        ArrayList arrayList2 = new ArrayList();
                        try {
                            HashMap<String, Object> mapL = new i.a(listB.get(i7)).l();
                            if (mapL != null) {
                                arrayList2.add(mapL);
                            }
                            i7++;
                            arrayList = arrayList2;
                        } catch (Throwable unused) {
                            return arrayList2;
                        }
                    }
                    return arrayList;
                } catch (Throwable unused2) {
                    return arrayList;
                }
            }
        }, z7);
    }

    private boolean a(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == -1;
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue() == -1;
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        return false;
    }

    private <T> T a(String str, a<T> aVar) {
        return (T) a(str, (a) aVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0037: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:15:0x0037 */
    private <T> T a(String str, a<T> aVar, boolean z6) {
        T tB;
        T t6;
        Object obj;
        T tB2 = null;
        String strA = null;
        try {
            if (str == null) {
                h("M|A, key: " + str);
                tB = aVar.b();
            } else {
                Integer num = this.b.get(str);
                try {
                    if (num != null) {
                        obj = this.f1720a.get(str);
                        if (obj == null && !z6) {
                            return aVar.f1800g;
                        }
                    } else {
                        obj = null;
                    }
                    Long l6 = this.c.get(str);
                    boolean z7 = false;
                    Object[] objArr = l6 != null && System.currentTimeMillis() >= l6.longValue();
                    if (objArr == false && a(obj) && !this.f1721f.contains(str)) {
                        z7 = true;
                    }
                    if (!z6 && obj != null && objArr == false && !z7) {
                        h("M|C, key: ".concat(str));
                        tB = (T) obj;
                    } else {
                        StringBuilder sb = new StringBuilder("M|A, key: ");
                        sb.append(str);
                        sb.append("|");
                        if (z6) {
                            strA = "FC";
                        } else if (obj == null || objArr == true) {
                            strA = "NVC";
                        } else if (z7) {
                            strA = cn.fly.commons.a.l.a("0029fhhk");
                        }
                        sb.append(strA);
                        h(sb.toString());
                        tB2 = aVar.b();
                        this.f1721f.add(str);
                        if (tB2 != null) {
                            this.f1720a.put(str, tB2);
                            if (aVar.a(tB2) > 0) {
                                this.c.put(str, Long.valueOf(System.currentTimeMillis() + aVar.a(tB2)));
                            }
                        }
                        if (num == null) {
                            this.b.put(str, 1);
                        } else {
                            this.b.put(str, Integer.valueOf(num.intValue() + 1));
                        }
                        tB = tB2;
                    }
                } catch (Throwable th) {
                    th = th;
                    tB2 = t6;
                    if (th instanceof PackageManager.NameNotFoundException) {
                        FlyLog.getInstance().w("Exception: " + th.getClass().getName() + ": " + th.getMessage());
                    } else {
                        FlyLog.getInstance().w(th);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return tB == null ? aVar.f1800g : tB;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0074 A[Catch: all -> 0x0047, TryCatch #4 {all -> 0x0047, blocks: (B:52:0x00ac, B:56:0x00be, B:35:0x005d, B:42:0x007a, B:41:0x0074, B:23:0x003e), top: B:77:0x003e }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0097 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0099 A[Catch: all -> 0x00a3, TryCatch #2 {all -> 0x00a3, blocks: (B:43:0x0088, B:46:0x0099, B:50:0x00a6), top: B:75:0x0088 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:64:0x010a  */
    /* JADX WARN: Code duplicated, block: B:66:0x010e  */
    /* JADX WARN: Code duplicated, block: B:67:0x0134  */
    /* JADX WARN: Code duplicated, block: B:70:0x013e  */
    /* JADX WARN: Code duplicated, block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:66:0x010e, please report this as an issue */
    private <T> T a(String str, a<T> aVar, boolean z6, boolean z7) {
        T tB;
        String name;
        String message;
        Throwable cause;
        Object objC;
        boolean z8;
        T tB2;
        long jA;
        T t6 = null;
        String strA = null;
        try {
            if (TextUtils.isEmpty(str)) {
                h("F|A, key: " + str);
                tB = aVar.b();
            } else {
                boolean z9 = false;
                if (z6) {
                    objC = null;
                } else {
                    z8 = true;
                    try {
                        objC = c(str, aVar);
                        try {
                            if (!a(objC) || this.f1721f.contains(str)) {
                            }
                        } catch (FlyPersistence.NoValidDataException unused) {
                            z9 = true;
                            z8 = false;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                FlyLog.getInstance().d(th);
                            } catch (Throwable th2) {
                                th = th2;
                                t6 = objC;
                                if (th instanceof InvocationTargetException) {
                                    name = th.getClass().getName();
                                    message = th.getMessage();
                                    cause = th.getCause();
                                    if (cause != null) {
                                        name = cause.getClass().getName();
                                        message = cause.getMessage();
                                    }
                                    FlyLog.getInstance().w("Exception: " + name + ": " + message);
                                } else if (th instanceof PackageManager.NameNotFoundException) {
                                    FlyLog.getInstance().w("Exception: " + th.getClass().getName() + ": " + th.getMessage());
                                } else {
                                    FlyLog.getInstance().w(th);
                                }
                                tB = t6;
                                if (tB == null) {
                                    return aVar.f1800g;
                                }
                                return tB;
                            }
                        }
                    } catch (FlyPersistence.NoValidDataException unused2) {
                        objC = null;
                    } catch (Throwable th3) {
                        th = th3;
                        objC = null;
                    }
                    if ((!z6 || z9 || z8) && z7) {
                        StringBuilder sb = new StringBuilder("F|A, key: ");
                        sb.append(str);
                        sb.append("|");
                        if (z6) {
                            strA = "FC";
                        } else if (z9) {
                            strA = "NVC";
                        } else if (z8) {
                            strA = cn.fly.commons.a.l.a("002,fhhk");
                        }
                        sb.append(strA);
                        h(sb.toString());
                        tB2 = aVar.b();
                        try {
                            this.f1721f.add(str);
                            jA = aVar.a(tB2);
                            if (jA >= 0) {
                                a(str, tB2, jA > 0 ? System.currentTimeMillis() + jA : 0L, aVar);
                            }
                            tB = tB2;
                        } catch (Throwable th4) {
                            th = th4;
                            t6 = tB2;
                            if (th instanceof InvocationTargetException) {
                                name = th.getClass().getName();
                                message = th.getMessage();
                                cause = th.getCause();
                                if (cause != null) {
                                    name = cause.getClass().getName();
                                    message = cause.getMessage();
                                }
                                FlyLog.getInstance().w("Exception: " + name + ": " + message);
                            } else if (th instanceof PackageManager.NameNotFoundException) {
                                FlyLog.getInstance().w("Exception: " + th.getClass().getName() + ": " + th.getMessage());
                            } else {
                                FlyLog.getInstance().w(th);
                            }
                            tB = t6;
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder("F|C, key: ");
                        sb2.append(str);
                        sb2.append("|");
                        sb2.append(z7 ? "AA" : "OC");
                        h(sb2.toString());
                        tB = (T) objC;
                    }
                }
                z8 = false;
                if (!z6) {
                    StringBuilder sb3 = new StringBuilder("F|A, key: ");
                    sb3.append(str);
                    sb3.append("|");
                    if (z6) {
                        strA = "FC";
                    } else if (z9) {
                        strA = "NVC";
                    } else if (z8) {
                        strA = cn.fly.commons.a.l.a("002,fhhk");
                    }
                    sb3.append(strA);
                    h(sb3.toString());
                    tB2 = aVar.b();
                    this.f1721f.add(str);
                    jA = aVar.a(tB2);
                    if (jA >= 0) {
                        a(str, tB2, jA > 0 ? System.currentTimeMillis() + jA : 0L, aVar);
                    }
                    tB = tB2;
                } else {
                    StringBuilder sb4 = new StringBuilder("F|A, key: ");
                    sb4.append(str);
                    sb4.append("|");
                    if (z6) {
                        strA = "FC";
                    } else if (z9) {
                        strA = "NVC";
                    } else if (z8) {
                        strA = cn.fly.commons.a.l.a("002,fhhk");
                    }
                    sb4.append(strA);
                    h(sb4.toString());
                    tB2 = aVar.b();
                    this.f1721f.add(str);
                    jA = aVar.a(tB2);
                    if (jA >= 0) {
                        a(str, tB2, jA > 0 ? System.currentTimeMillis() + jA : 0L, aVar);
                    }
                    tB = tB2;
                }
            }
        } catch (Throwable th5) {
            th = th5;
        }
        if (tB == null) {
            return aVar.f1800g;
        }
        return tB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void a(String str, T t6, long j6, a<T> aVar) {
        try {
            Type typeA = a((a) aVar);
            int iA = a(typeA);
            if (iA == 1) {
                cn.fly.tools.utils.g.a().a(str, (Parcelable[]) t6, j6);
                return;
            }
            if (iA != 2 && iA != 4) {
                if (iA == 3) {
                    Class cls = (Class) ((ParameterizedType) typeA).getRawType();
                    if (cls != List.class && cls != LinkedList.class && cls != ArrayList.class) {
                        if (cls == Map.class || cls == HashMap.class || cls == TreeMap.class || cls == Hashtable.class) {
                            cn.fly.tools.utils.g.a().a(str, (Map) t6, j6);
                            return;
                        }
                        return;
                    }
                    cn.fly.tools.utils.g.a().a(str, (List) t6, j6);
                    return;
                }
                if (iA == 9) {
                    Class cls2 = (Class) typeA;
                    if (cls2 != null) {
                        if (cls2 == Integer.class) {
                            cn.fly.tools.utils.g.a().a(str, (Integer) t6, j6);
                            return;
                        }
                        if (cls2 == Long.class) {
                            cn.fly.tools.utils.g.a().a(str, (Long) t6, j6);
                            return;
                        }
                        if (cls2 == Double.class) {
                            cn.fly.tools.utils.g.a().a(str, (Double) t6, j6);
                            return;
                        }
                        if (cls2 == Boolean.class) {
                            cn.fly.tools.utils.g.a().a(str, (Boolean) t6, j6);
                            return;
                        }
                        if (cls2 == String.class) {
                            cn.fly.tools.utils.g.a().a(str, (String) t6, j6);
                            return;
                        } else if (Parcelable.class.isAssignableFrom(cls2)) {
                            cn.fly.tools.utils.g.a().a(str, (Parcelable) t6, j6);
                            return;
                        } else {
                            cn.fly.tools.utils.g.a().a(str, t6, j6);
                            return;
                        }
                    }
                    return;
                }
                cn.fly.tools.utils.g.a().a(str, t6, j6);
                return;
            }
            cn.fly.tools.utils.g.a().a(str, t6, j6);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    private <T> Type a(a<T> aVar) {
        try {
            return ((ParameterizedType) aVar.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    private int a(Type type) {
        if (type instanceof GenericArrayType) {
            return Parcelable.class.isAssignableFrom((Class) ((GenericArrayType) type).getGenericComponentType()) ? 1 : 2;
        }
        if (!(type instanceof ParameterizedType)) {
            return 9;
        }
        try {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type type2 = actualTypeArguments[0];
            if (actualTypeArguments.length == 2) {
                type2 = actualTypeArguments[1];
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                Type type3 = actualTypeArguments2[0];
                if (actualTypeArguments2.length == 2) {
                    Type type4 = actualTypeArguments2[1];
                }
                return 4;
            }
            if (type2 instanceof Class) {
                return Parcelable.class.isAssignableFrom((Class) type2) ? 3 : 4;
            }
            return -1;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(Calendar calendar) {
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private boolean a(boolean z6, String str, String str2) {
        String strK = AbstractC0157z.k(TextUtils.equals(str2, DH.SyncMtd.getPackageName()) ? 1 : 0, "sdir_able_");
        if (cn.fly.tools.utils.g.a().a(strK, -1) != z6) {
            cn.fly.tools.utils.g.a().a(strK, Integer.valueOf(z6 ? 1 : 0));
            if (!z6) {
                return true;
            }
        }
        if (!z6 || TextUtils.isEmpty(str2)) {
            return false;
        }
        String strM = androidx.exifinterface.media.a.m("key_almdf-", str, ProcessIdUtil.DEFAULT_PROCESSID, str2);
        long jD = cn.fly.tools.utils.g.a().d(strM);
        long jG = g(str2);
        if (jG == jD) {
            return false;
        }
        cn.fly.tools.utils.g.a().a(strM, Long.valueOf(jG));
        return true;
    }
}
