package cn.fly.tools.xcrash;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.commons.m;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.ResHelper;

/* JADX INFO: loaded from: classes.dex */
public final class XCrash {
    private static String appId = null;
    private static String appVersion = null;
    private static boolean initialized = false;
    private static String logDir;
    private static final cn.fly.tools.xcrash.a LOGGER = new cn.fly.tools.xcrash.a();
    public static String nativeLibDir = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f1994a = null;
        String b = null;
        int c = 5000;
        int d = 0;
        int e = 128;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1995f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f1996g = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f1997h = 10;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f1998i = 10;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f1999j = 10;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f2000k = 30;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f2001l = false;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f2002m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f2003n = true;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f2004o = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        String[] f2005p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        ICrashCallback f2006q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f2007r = true;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        boolean f2008s = true;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f2009t = 10;

        public a a(String str) {
            this.f1994a = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(int i5) {
            if (i5 < 0) {
                i5 = 0;
            }
            this.e = i5;
            return this;
        }

        public a d(int i5) {
            if (i5 < 1) {
                i5 = 1;
            }
            this.f1997h = i5;
            return this;
        }

        public a e(int i5) {
            this.f1998i = i5;
            return this;
        }

        public a f(int i5) {
            this.f1999j = i5;
            return this;
        }

        public a g(int i5) {
            this.f2000k = i5;
            return this;
        }

        public a h(int i5) {
            if (i5 < 0) {
                i5 = 0;
            }
            this.f2004o = i5;
            return this;
        }

        public a i(int i5) {
            if (i5 < 1) {
                i5 = 1;
            }
            this.f2009t = i5;
            return this;
        }

        public a a(int i5) {
            if (i5 < 0) {
                i5 = 0;
            }
            this.c = i5;
            return this;
        }

        public a b(int i5) {
            if (i5 < 0) {
                i5 = 0;
            }
            this.d = i5;
            return this;
        }

        public a a(boolean z6) {
            this.f1996g = z6;
            return this;
        }

        public a b(boolean z6) {
            this.f2008s = z6;
            return this;
        }
    }

    private XCrash() {
    }

    public static Class<?> fC(String str) {
        if (NativeHandler.nrInited()) {
            return NativeHandler.fC(str);
        }
        return null;
    }

    public static Object get0(Object obj, String str, boolean z6, String str2) {
        if (NativeHandler.nrInited()) {
            return NativeHandler.get0(obj, str, z6, str2);
        }
        return null;
    }

    public static String getAppId() {
        return appId;
    }

    public static String getAppVersion() {
        return appVersion;
    }

    public static String getLogDir() {
        return logDir;
    }

    public static cn.fly.tools.xcrash.a getLogger() {
        return LOGGER;
    }

    public static int init(Context context) {
        return init(context, null);
    }

    public static Object inv0(Object obj, String str, boolean z6, String str2, String[] strArr, Object... objArr) {
        if (NativeHandler.nrInited()) {
            return NativeHandler.inv0(obj, str, z6, str2, strArr, objArr);
        }
        return null;
    }

    public static boolean nrInited() {
        int oSVersionIntForFly = DH.SyncMtd.getOSVersionIntForFly();
        int i5 = cn.fly.tools.b.c.a(FlySDK.getContext()).d().ar().targetSdkVersion;
        FlyLog.getInstance().d(androidx.collection.a.h(oSVersionIntForFly, i5, "[HH] nrIni. a: ", ", tgV: "), new Object[0]);
        if (oSVersionIntForFly < 30 || i5 < 30) {
            return false;
        }
        return NativeHandler.nrInited();
    }

    public static void set0(Object obj, String str, boolean z6, String str2, Object obj2) {
        if (NativeHandler.nrInited()) {
            NativeHandler.set0(obj, str, z6, str2, obj2);
        }
    }

    public static synchronized int init(Context context, a aVar) {
        try {
            if (initialized) {
                return 0;
            }
            initialized = true;
            if (context == null) {
                return -1;
            }
            Context applicationContext = context.getApplicationContext();
            Context context2 = applicationContext != null ? applicationContext : context;
            if (aVar == null) {
                aVar = new a();
            }
            String packageName = context2.getPackageName();
            appId = packageName;
            if (TextUtils.isEmpty(packageName)) {
                appId = m.a("007+fi6gDgj5g6fmhi8g");
            }
            if (TextUtils.isEmpty(aVar.f1994a)) {
                aVar.f1994a = FlySDK.SDK_VERSION_NAME;
            }
            appVersion = aVar.f1994a;
            nativeLibDir = context2.getApplicationInfo().nativeLibraryDir;
            if (TextUtils.isEmpty(aVar.b)) {
                String str = context2.getFilesDir() + m.a("001n") + "fvv/fly_tombstones";
                ResHelper.checkAndCreateDir(str);
                aVar.b = str;
            }
            logDir = aVar.b;
            Process.myPid();
            DH.SyncMtd.getCurrentProcessName();
            b.a().a(aVar.b, aVar.f1997h, aVar.f2009t, aVar.d, aVar.e, aVar.c);
            int iInitialize = aVar.f2007r ? NativeHandler.getInstance().initialize(context2, appId, aVar.f1994a, aVar.b, aVar.f2007r, aVar.f2008s) : 0;
            b.a().b();
            return iInitialize;
        } catch (Throwable th) {
            throw th;
        }
    }
}
