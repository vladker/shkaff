package cn.fly.tools.a;

import A3.AbstractC0157z;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.commons.C0396r;
import cn.fly.commons.CSCenter;
import cn.fly.commons.m;
import cn.fly.tools.FlyLog;
import cn.fly.tools.log.NLog;
import cn.fly.tools.utils.DH;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f1681a = null;
    private static long c = 0;
    private static String d = "not_inited";
    private static String e;
    private a b;

    private f(Context context) {
        String str;
        String str2;
        Context context2;
        String str3 = "1";
        String strF = f();
        try {
            c = System.currentTimeMillis();
            e = g();
            boolean zC = c();
            boolean zA = a();
            boolean zB = b();
            boolean zD = d();
            boolean zIsDREnable = CSCenter.getInstance().isDREnable();
            int i5 = cn.fly.tools.b.c.a(context).d().ar().targetSdkVersion;
            int oSVersionIntForFly = DH.SyncMtd.getOSVersionIntForFly();
            try {
                boolean zE = C0396r.e();
                try {
                    try {
                        boolean z6 = true;
                        boolean z7 = Looper.getMainLooper() == Looper.myLooper();
                        a("inMa " + z7 + " 3nv " + zC + " 3xu: " + zB + ", 3xd: " + zA + ", dre: " + zIsDREnable + ", obf: " + zD + ", tar: " + i5 + ", api: " + oSVersionIntForFly + ", ovBklv: " + zE, strF, "constructor", "env");
                        if (i5 < 30 || oSVersionIntForFly < 30) {
                            a("2x", new String[0]);
                            d = "29nm";
                            this.b = new g();
                        } else {
                            a("3xx", new String[0]);
                            if (!z7 && zC) {
                                a("30nv", new String[0]);
                                this.b = e.a();
                                d = "30nv";
                            }
                            if (this.b == null && zIsDREnable && zA) {
                                b bVar = new b();
                                context2 = context;
                                if (bVar.a(context2)) {
                                    a("3xd", new String[0]);
                                    d = "30df";
                                    this.b = bVar;
                                }
                            } else {
                                context2 = context;
                            }
                            if (!zB || zD) {
                                z6 = false;
                            }
                            if (this.b == null && z6) {
                                if (zE) {
                                    d dVar = new d();
                                    if (dVar.a(context2)) {
                                        a("36u", new String[0]);
                                        d = "36us";
                                        this.b = dVar;
                                    }
                                } else {
                                    c cVar = new c();
                                    if (cVar.a(context2)) {
                                        a("3xu", new String[0]);
                                        d = "30us";
                                        this.b = cVar;
                                    }
                                }
                            }
                        }
                        if (this.b != null) {
                            a("1", strF, "constructor", "inited");
                        } else {
                            a("0", strF, "constructor", "inited");
                        }
                    } catch (Throwable th) {
                        th = th;
                        str = "0";
                        str3 = "1";
                        str2 = "inited";
                        if (this.b != null) {
                            a(str3, strF, "constructor", str2);
                        } else {
                            a(str, th, strF, "constructor", str2);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str2 = "inited";
                    str = "0";
                    str3 = "1";
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = "inited";
                str = "0";
            }
        } catch (Throwable th4) {
            th = th4;
            str = "0";
            str2 = "inited";
        }
    }

    private static void a(HashMap<String, Object> map) {
    }

    private boolean c() {
        return ((Integer) cn.fly.commons.c.a("nv", 0)).intValue() == 1;
    }

    private boolean d() {
        return e();
    }

    private boolean e() {
        boolean z6 = true;
        try {
            if ("cn.fly.FlySDK".equals(FlySDK.class.getName()) && m.a("023eg]fnghPi;gefn=eJfmfhfhfm1g8hkfngfgngf-hgkh^fl").equals(CSCenter.class.getName())) {
                z6 = false;
            }
        } catch (Throwable th) {
            a(th);
        }
        a("ck-cn: " + z6, new String[0]);
        return z6;
    }

    private String f() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable unused) {
            return "00000000-0000-0000-0000-000000000000";
        }
    }

    private String g() {
        String str = "";
        try {
            final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            DH.requester(FlySDK.getContext()).getSecurePch().request(new DH.DHResponder() { // from class: cn.fly.tools.a.f.1
                @Override // cn.fly.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    linkedBlockingQueue.offer(dHResponse.getSecurePch());
                }
            });
            try {
                str = (String) linkedBlockingQueue.poll(1000L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                FlyLog.getInstance().e(th);
            }
        } catch (Throwable th2) {
            FlyLog.getInstance().e(th2);
        }
        return str;
    }

    public boolean b(Context context) {
        return b.b(context);
    }

    public static synchronized f a(Context context) {
        try {
            if (f1681a == null && context != null) {
                f1681a = new f(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1681a;
    }

    private static String c(Throwable th) {
        try {
            String name = th.getClass().getName();
            String strD = d(th);
            String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
            Throwable cause = th;
            while (cause != null && cause.getCause() != null) {
                cause = cause.getCause();
            }
            if (cause == null || cause == th) {
                return NLog.getStackTraceString(th);
            }
            return name + ParameterizedMessage.ERROR_MSG_SEPARATOR + strD + "\n" + string + "\n......\nCaused by:\n" + NLog.getStackTraceString(cause);
        } catch (Throwable unused) {
            return NLog.getStackTraceString(th);
        }
    }

    private static String d(Throwable th) {
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            return "";
        }
        if (message.length() <= 200) {
            return message;
        }
        return message.substring(0, 200) + "\n[Message over limit size:200, cut!]";
    }

    public Class b(String str) {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.b(str);
        }
        return null;
    }

    private boolean b() {
        return ((Integer) cn.fly.commons.c.a(m.a("002.fihk"), 0)).intValue() == 1;
    }

    private static String b(Throwable th) {
        try {
            String strC = c(th);
            if (!TextUtils.isEmpty(strC)) {
                return strC.substring(0, Math.min(strC.length(), 512));
            }
            return "";
        } catch (Throwable th2) {
            return androidx.exifinterface.media.a.t(th2, new StringBuilder("lmt stack err. msg: "));
        }
    }

    public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr, Class<?> cls2, T t6) {
        String strConcat;
        String str2;
        String string;
        if (this.b == null) {
            return t6;
        }
        String strF = f();
        String str3 = "|";
        if (cls == null) {
            strConcat = "|";
        } else {
            try {
                strConcat = "|clz:".concat(cls.getName());
            } catch (Throwable unused) {
                str2 = str;
                string = str3;
                a("start" + string, strF, m.a("012 fk>g5fffmgjBh9hmhfinggfjgf"), "step");
                T t7 = (T) this.b.a(cls, obj, str2, clsArr, objArr, cls2);
                a("end", strF, m.a("012SfkTg8fffmgj@hIhmhfinggfjgf"), "step");
                return t7;
            }
        }
        try {
            str3 = strConcat + "|";
            if (obj != null) {
                str3 = str3 + "rcv:" + obj.getClass().getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append("|mn:");
            str2 = str;
            try {
                sb.append(str2);
                string = sb.toString();
            } catch (Throwable unused2) {
                string = str3;
            }
        } catch (Throwable unused3) {
            str2 = str;
            str3 = strConcat;
        }
        try {
            a("start" + string, strF, m.a("012 fk>g5fffmgjBh9hmhfinggfjgf"), "step");
            T t8 = (T) this.b.a(cls, obj, str2, clsArr, objArr, cls2);
            a("end", strF, m.a("012SfkTg8fffmgj@hIhmhfinggfjgf"), "step");
            return t8;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a(AbstractC0157z.n(Constants.EXCEPTION, string), th, strF, m.a("012Lfk4gQfffmgj[hGhmhfinggfjgf"), "step");
                throw th2;
            }
        }
    }

    public <T> T a(String str, Object obj, String str2, Class[] clsArr, Object[] objArr, Class<?> cls, T t6) {
        String str3;
        String string = "|";
        if (this.b == null) {
            return t6;
        }
        String strF = f();
        try {
            String str4 = "|cn:" + str;
            try {
                string = str4 + "|";
                if (obj != null) {
                    string = string + "rcv:" + obj.getClass().getName();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append("|mn:");
                str3 = str2;
                try {
                    sb.append(str3);
                    string = sb.toString();
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str3 = str2;
                string = str4;
            }
        } catch (Throwable unused3) {
            str3 = str2;
        }
        String str5 = string;
        try {
            a("start" + str5, strF, m.a("012Ifk)g_fffmgjDhDhmhfinggfjgn"), "step");
            T t7 = (T) this.b.a(str, obj, str3, clsArr, objArr, cls);
            a("end", strF, m.a("012Hfk2g<fffmgjGhAhmhfinggfjgn"), "step");
            return t7;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a(AbstractC0157z.n(Constants.EXCEPTION, str5), th, strF, m.a("0121fk gEfffmgj'h^hmhfinggfjgn"), "step");
                throw th2;
            }
        }
    }

    public <T> T a(String str) {
        if (this.b == null) {
            return null;
        }
        String strF = f();
        String strN = AbstractC0157z.n("|cn:", str);
        try {
            a("start" + strN, strF, m.a("012gh[hihmgg;gWhkTkfgeh"), "step");
            T t6 = (T) this.b.a(str);
            a("end", strF, m.a("012gh3hihmggVgOhk8kfgeh"), "step");
            return t6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a(AbstractC0157z.n(Constants.EXCEPTION, strN), th, strF, m.a("012ghDhihmgg>g$hk$kfgeh"), "step");
                throw th2;
            }
        }
    }

    public <T> T a(String str, String str2, Object obj, Class<?> cls, T t6) {
        String str3 = "|";
        if (this.b == null) {
            return t6;
        }
        String strF = f();
        try {
            String str4 = "|cn:" + str;
            try {
                str4 = str4 + "|fn:" + str2;
                str3 = str4 + "|";
                if (obj != null) {
                    str3 = str3 + "rcv:" + obj.getClass().getName();
                }
            } catch (Throwable unused) {
                str3 = str4;
            }
        } catch (Throwable unused2) {
        }
        try {
            a("start" + str3, strF, m.a("009Vgl=hk.hmiefk+hiNfe"), "step");
            T t7 = (T) this.b.a(str, str2, obj, cls);
            a("end", strF, m.a("0098glVhkHhmiefk9hiOfe"), "step");
            return t7;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a(AbstractC0157z.n(Constants.EXCEPTION, str3), th, strF, m.a("0091glUhk-hmiefkThi1fe"), "step");
                throw th2;
            }
        }
    }

    public <T> T a(String str, Class[] clsArr, Object[] objArr) {
        if (this.b == null) {
            return null;
        }
        String strF = f();
        String strN = AbstractC0157z.n("|cn:", str);
        try {
            a("start" + strN, strF, m.a("014gh<hihmgg*gQhk.kfgehXfjin"), "step");
            T t6 = (T) this.b.a(str, clsArr, objArr);
            a("end", strF, m.a("014ghLhihmgg3gChkTkfgehVfjin"), "step");
            return t6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a(AbstractC0157z.n(Constants.EXCEPTION, strN), th, strF, m.a("014ghWhihmgg^g6hkRkfgehGfjin"), "step");
                throw th2;
            }
        }
    }

    public static void a(String str, String... strArr) {
        if (strArr != null) {
            HashMap map = new HashMap();
            int length = strArr.length;
            if (length > 0) {
                NLog flyLog = FlyLog.getInstance();
                StringBuilder sb = new StringBuilder("[HH][BT] ");
                sb.append(strArr[1]);
                sb.append(" ");
                flyLog.d(androidx.exifinterface.media.a.r(sb, strArr[0], " ", str), new Object[0]);
                map.put("uid", strArr[0]);
                if (length > 1) {
                    map.put("method", strArr[1]);
                }
                if (length > 2) {
                    map.put(strArr[2], str);
                }
                a((HashMap<String, Object>) map);
                return;
            }
            FlyLog.getInstance().d(AbstractC0157z.n("[HH] ", str), new Object[0]);
            return;
        }
        FlyLog.getInstance().d(AbstractC0157z.n("[HH] ", str), new Object[0]);
    }

    public static void a(String str, Throwable th, String... strArr) {
        if (strArr != null) {
            HashMap map = new HashMap();
            int length = strArr.length;
            if (length > 0) {
                String message = "";
                String strB = th != null ? b(th) : "";
                NLog flyLog = FlyLog.getInstance();
                StringBuilder sb = new StringBuilder("[HH][BT] ");
                sb.append(strArr[1]);
                sb.append(" ");
                androidx.collection.a.y(sb, strArr[0], " ", str, "\nexcMsg: ");
                if (th != null) {
                    message = th.getMessage();
                }
                flyLog.d(androidx.exifinterface.media.a.r(sb, message, "\nexcStk: ", strB), new Object[0]);
                map.put("uid", strArr[0]);
                if (length > 1) {
                    map.put("method", strArr[1]);
                }
                if (length > 2) {
                    map.put(strArr[2], str);
                }
                if (th != null) {
                    map.put("excClz", th.getClass().getName());
                    map.put("excMsg", th.getMessage());
                    map.put("excStk", strB);
                }
                a((HashMap<String, Object>) map);
                return;
            }
            FlyLog.getInstance().d(AbstractC0157z.n("[HH] ", str), new Object[0]);
            return;
        }
        FlyLog.getInstance().d(AbstractC0157z.n("[HH] ", str), new Object[0]);
    }

    public static void a(Throwable th) {
        FlyLog.getInstance().d(th, "[HH] ", new Object[0]);
    }

    private boolean a() {
        return ((Integer) cn.fly.commons.c.a(m.a("002Xfegh"), 0)).intValue() == 1;
    }
}
