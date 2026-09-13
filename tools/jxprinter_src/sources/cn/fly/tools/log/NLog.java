package cn.fly.tools.log;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import cn.fly.commons.c;
import cn.fly.commons.m;
import cn.fly.commons.w;
import cn.fly.tools.FlyLog;
import cn.fly.tools.proguard.ClassKeeper;
import cn.fly.tools.proguard.PublicMemberKeeper;
import java.util.HashMap;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: loaded from: classes.dex */
public class NLog implements ClassKeeper, PublicMemberKeeper {
    public static final int LEVEL_CRASH = 1;
    public static final int LEVEL_NATIVE_CRASH = 4;
    public static final int LEVEL_NORMAL = 0;
    private static final HashMap<String, NLog> b = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f1804a;
    private String c;
    private int d;

    private NLog() {
        this.f1804a = false;
        this.c = null;
        this.d = -1;
    }

    private int a(int i5, int i6, String str) {
        try {
            String str2 = Process.myPid() + ProcessIdUtil.DEFAULT_PROCESSID + Process.myTid() + "(" + Thread.currentThread().getName() + ") " + str;
            boolean z6 = true;
            if (i6 == 1 || i6 == 4) {
                if (((Integer) c.c(m.a("004eh^flfl"), 1)).intValue() != 1) {
                    z6 = false;
                }
                FlyLog.getInstance().d("[LGSM] Ck cerr: " + z6, new Object[0]);
                if (z6) {
                    w.a().a(i6, this.c, this.d, str2);
                }
            }
            w.a().a(i5, str2);
        } catch (Throwable unused) {
        }
        return 0;
    }

    private static String b(Throwable th) {
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, cut!]";
    }

    public static NLog getInstance(String str, int i5, String str2) {
        NLog nLog;
        HashMap<String, NLog> map = b;
        synchronized (map) {
            try {
                nLog = map.get(str);
                if (nLog == null) {
                    nLog = new NLog(str, i5);
                    map.put(str, nLog);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nLog;
    }

    public static String getStackTraceString(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Throwable th2) {
            return th2 instanceof OutOfMemoryError ? m.a("023Vgl7hk$gnKkfe'gjheflUfehDgn7k3flfk.g0glkhfmfmfh") : th2.getMessage();
        }
    }

    public final void crash(Throwable th) {
        a(6, 1, a(th));
    }

    public final int d(Throwable th) {
        return log(3, th);
    }

    public final void dg() {
        this.f1804a = true;
    }

    public final int e(Throwable th) {
        return log(6, th);
    }

    public final void error(Throwable th) {
        error(getStackTraceString(th));
    }

    public final int i(Throwable th) {
        return log(4, th);
    }

    public final int log(int i5, Throwable th) {
        return a(i5, 0, getStackTraceString(th));
    }

    public final int v(Throwable th) {
        return log(2, th);
    }

    public final int w(Throwable th) {
        return log(5, th);
    }

    public final void crash(int i5, String str) {
        a(6, i5, str);
    }

    public final int d(Object obj, Object... objArr) {
        return log(3, obj, objArr);
    }

    public final int e(Throwable th, Object obj, Object... objArr) {
        return log(6, th, obj, objArr);
    }

    public final void error(String str) {
        e(str);
    }

    public final int i(Throwable th, Object obj, Object... objArr) {
        return log(4, th, obj, objArr);
    }

    public final int log(int i5, Object obj, Object... objArr) {
        String string = obj.toString();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        return a(i5, 0, string);
    }

    public final int v(Object obj, Object... objArr) {
        return log(2, obj, objArr);
    }

    public final int w(Object obj, Object... objArr) {
        return log(5, obj, objArr);
    }

    public final int d(Throwable th, Object obj, Object... objArr) {
        return log(3, th, obj, objArr);
    }

    public final int e(Object obj, Object... objArr) {
        return log(6, obj, objArr);
    }

    public final int i(Object obj, Object... objArr) {
        return log(4, obj, objArr);
    }

    public final int v(Throwable th, Object obj, Object... objArr) {
        return log(2, th, obj, objArr);
    }

    public final int w(Throwable th, Object obj, Object... objArr) {
        return log(5, th, obj, objArr);
    }

    public final int e(String str) {
        return log(6, str, new Object[0]);
    }

    public final int i(String str) {
        return log(4, str, new Object[0]);
    }

    public final int w(String str) {
        return log(5, str, new Object[0]);
    }

    private NLog(String str, int i5) {
        this.f1804a = false;
        this.c = str;
        this.d = i5;
    }

    public final int log(int i5, Throwable th, Object obj, Object... objArr) {
        String string = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        sb.append(string);
        sb.append('\n');
        sb.append(getStackTraceString(th));
        return a(i5, 0, sb.toString());
    }

    private String a(Throwable th) {
        try {
            String name = th.getClass().getName();
            String strB = b(th);
            String string = "";
            if (th.getStackTrace().length > 0) {
                string = th.getStackTrace()[0].toString();
            }
            Throwable cause = th;
            while (cause != null && cause.getCause() != null) {
                cause = cause.getCause();
            }
            if (cause != null && cause != th) {
                return name + ParameterizedMessage.ERROR_MSG_SEPARATOR + strB + "\n" + string + "\n......\nCaused by:\n" + getStackTraceString(cause);
            }
            return getStackTraceString(th);
        } catch (Throwable unused) {
            return getStackTraceString(th);
        }
    }
}
