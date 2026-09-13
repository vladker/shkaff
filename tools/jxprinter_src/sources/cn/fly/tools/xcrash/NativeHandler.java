package cn.fly.tools.xcrash;

import android.content.Context;
import android.text.TextUtils;
import cn.fly.commons.m;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class NativeHandler {
    private boolean crashRethrow;
    private Context ctx;
    private static final NativeHandler INSTANCE = new NativeHandler();
    private static AtomicBoolean libLoaded = new AtomicBoolean(false);
    private static AtomicBoolean nrInited = new AtomicBoolean(false);
    private static volatile boolean flagNrInit = false;
    private static volatile boolean initNativeLibOk = false;

    private NativeHandler() {
    }

    private static void crashCallback(String str, String str2, boolean z6, boolean z7, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        XCrash.getLogger().a("NCRASH", "isMainThread " + z7 + " tn " + str3);
        if (!TextUtils.isEmpty(str3)) {
            String stacktraceByThreadName = getStacktraceByThreadName(z7, str3);
            if (!TextUtils.isEmpty(stacktraceByThreadName)) {
                c.a(str, "java stacktrace", stacktraceByThreadName);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c.a(str, str2);
    }

    public static native Class<?> fC(String str);

    public static native Object get0(Object obj, String str, boolean z6, String str2);

    public static NativeHandler getInstance() {
        return INSTANCE;
    }

    private static String getStacktraceByThreadName(boolean z6, String str) {
        try {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if ((z6 && key.getName().equals("main")) || (!z6 && key.getName().contains(str))) {
                    StringBuilder sb = new StringBuilder();
                    StackTraceElement[] value = entry.getValue();
                    for (StackTraceElement stackTraceElement : value) {
                        sb.append("    at ");
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                    }
                    return sb.toString();
                }
            }
            return null;
        } catch (Exception e) {
            XCrash.getLogger().a("NCRASH", "NH gsb failed", e);
            return null;
        }
    }

    public static native Object inv0(Object obj, String str, boolean z6, String str2, String[] strArr, Object... objArr);

    public static boolean isInitNativeLibOk() {
        if (libLoaded.compareAndSet(false, true)) {
            try {
                if (isObfuscated()) {
                    throw new RuntimeException("[HH] minifyed");
                }
                System.loadLibrary("fntvcrash");
                initNativeLibOk = true;
            } catch (Throwable th) {
                XCrash.getLogger().b("NCRASH", androidx.exifinterface.media.a.n("[HH] NH init failed -2 t ", th));
            }
        }
        return initNativeLibOk;
    }

    private static boolean isObfuscated() {
        return !TextUtils.equals(m.a("033eg>fngh7i2gefn[kUfmfm9iJhkfngkXe;flDf_hk.jIfngi%fkYfkffAhShmKfg7feVihXfl"), NativeHandler.class.getName());
    }

    private static native int nativeInit(int i5, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z6, boolean z7);

    private static native void nativeNotifyJavaCrashed();

    public static native boolean nrInit();

    public static boolean nrInited() {
        if (isInitNativeLibOk() && nrInited.compareAndSet(false, true)) {
            try {
                flagNrInit = nrInit();
            } catch (Throwable unused) {
                XCrash.getLogger().b("NCRASH", "[HH] NH nrInit failed -2");
                flagNrInit = false;
            }
        }
        return flagNrInit;
    }

    public static native void set0(Object obj, String str, boolean z6, String str2, Object obj2);

    private static void traceCallback(String str, String str2) {
        TextUtils.isEmpty(str);
    }

    private static void traceCallbackBeforeDump() {
        FlyLog.getInstance().d("W anr not initialized", new Object[0]);
    }

    public int initialize(Context context, String str, String str2, String str3, boolean z6, boolean z7) {
        if (!isInitNativeLibOk()) {
            return -2;
        }
        this.ctx = context;
        this.crashRethrow = z7;
        try {
            if (nativeInit(DH.SyncMtd.getOSVersionIntForFly(), DH.SyncMtd.getOSVersionName(), cn.fly.tools.b.c.a(context).d().D(), DH.SyncMtd.getManufacturerForFly(), DH.SyncMtd.getBrandForFly(), cn.fly.tools.b.c.a(context).d().n(), cn.fly.tools.b.c.a(context).d().l(), str, str2, context.getApplicationInfo().nativeLibraryDir, str3, z6, z7) == 0) {
                return 0;
            }
            XCrash.getLogger().b("NCRASH", "NH init failed");
            return -3;
        } catch (Throwable th) {
            XCrash.getLogger().a("NCRASH", "NH init failed", th);
            return -3;
        }
    }

    public void notifyJavaCrashed() {
        if (initNativeLibOk) {
            nativeNotifyJavaCrashed();
        }
    }
}
