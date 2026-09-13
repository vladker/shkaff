package cn.fly.commons;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import java.io.Closeable;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f1501a = null;
    public static volatile String b = null;
    public static volatile String c = null;
    public static volatile String d = null;
    public static volatile InternationalDomain e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f1502f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f1503g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f1504h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f1505i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f1506j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile boolean f1507k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile String f1508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static AtomicBoolean f1509m = new AtomicBoolean(false);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f1510n = b("0112dkUgc5ci0eFdkekhbckce-h");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f1511o = b("010Kgbcjeefkcfeh[gUckce)h");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f1512p = b("012*dkSebFfjTe'cichdedbckceVh");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f1513q = b("009@dkgbdkdkekhbckcePh");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f1514r = b("010Bgbcjeeedch-dVdgckce.h");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static HashMap<String, HashMap<String, Object>> f1515s = new HashMap<>();

    public static void a(Context context) {
        try {
            if (f1509m.compareAndSet(false, true)) {
                try {
                    if (f1501a == null) {
                        String str = (String) FlyMeta.get(null, "custom-AppKey", String.class, null);
                        if (TextUtils.isEmpty(str)) {
                            str = (String) FlyMeta.get(null, b("010+gbcjeegjec!iiIhb^e6db"), String.class, null);
                        }
                        if (TextUtils.isEmpty(str)) {
                            String strL = ae.b().l();
                            if (TextUtils.isEmpty(strL)) {
                                strL = aa.i();
                            }
                            if (!TextUtils.isEmpty(strL)) {
                                c = strL;
                                ae.b().e(strL);
                            }
                        } else {
                            f1501a = str;
                            c = str;
                            ae.b().e(str);
                        }
                    }
                    if (b == null) {
                        String str2 = (String) FlyMeta.get(null, "custom-AppSecret", String.class, null);
                        if (TextUtils.isEmpty(str2)) {
                            str2 = (String) FlyMeta.get(null, b("013PgbcjeegjecBii?dkNeb;ci9eh"), String.class, null);
                        }
                        if (TextUtils.isEmpty(str2)) {
                            str2 = (String) FlyMeta.get(null, b("0125gbcjeegjec!ii+dkBeMciBeh"), String.class, null);
                        }
                        if (TextUtils.isEmpty(str2)) {
                            String strM = ae.b().m();
                            if (!TextUtils.isEmpty(strM)) {
                                d = strM;
                            }
                        } else {
                            b = str2;
                            d = str2;
                            ae.b().f(str2);
                        }
                    }
                } catch (Throwable unused) {
                }
                try {
                    String str3 = (String) FlyMeta.get(null, "custom-Domain", String.class, null);
                    if (TextUtils.isEmpty(str3)) {
                        str3 = (String) FlyMeta.get(null, b("006)ekcjceGc:chKd"), String.class, null);
                    }
                    if (str3 != null) {
                        e = InternationalDomain.domainOf(str3);
                    }
                } catch (Throwable unused2) {
                    e = InternationalDomain.DEFAULT;
                }
                f1508l = (String) FlyMeta.get(null, "custom-OdVivoAppId", String.class, null);
                if (TextUtils.isEmpty(f1508l)) {
                    f1508l = (String) FlyMeta.get(null, b("015RgbcjeegjfgcbfjchcccjecOii1ddcb"), String.class, null);
                }
                Class cls = Boolean.TYPE;
                Boolean bool = Boolean.FALSE;
                f1502f = ((Boolean) FlyMeta.get(null, "custom-Https", cls, bool)).booleanValue();
                f1503g = ((Boolean) FlyMeta.get(null, b("009,gbcjeegjej5hhi%eh"), cls, bool)).booleanValue();
                Object obj = FlyMeta.get(null, "custom-V6", cls);
                if (obj != null) {
                    f1504h = ((Boolean) obj).booleanValue();
                } else {
                    f1504h = ((Boolean) FlyMeta.get(null, b("006 gbcjeegjfjgg"), cls, bool)).booleanValue();
                }
                Object obj2 = FlyMeta.get(null, "custom-elog", cls);
                if (obj2 != null) {
                    f1505i = ((Boolean) obj2).booleanValue();
                } else {
                    f1505i = ((Boolean) FlyMeta.get(null, b("008.gbcjeegjJefPcjdi"), cls, Boolean.TRUE)).booleanValue();
                }
                Object obj3 = FlyMeta.get(null, "custom-GPP", cls);
                if (obj3 != null) {
                    f1506j = ((Boolean) obj3).booleanValue();
                } else {
                    f1506j = ((Boolean) FlyMeta.get(null, b("0078gbcjeegjhcfkfk"), cls, bool)).booleanValue();
                }
                Object obj4 = FlyMeta.get(null, "custom-Nerr", cls);
                if (obj4 != null) {
                    f1507k = ((Boolean) obj4).booleanValue();
                }
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    public static String b(String str) {
        return C0396r.a(str, 98);
    }

    /* JADX WARN: Code duplicated, block: B:114:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x005f A[Catch: all -> 0x0098, TryCatch #2 {all -> 0x0098, blocks: (B:22:0x0059, B:24:0x005f, B:27:0x0071, B:29:0x0075, B:31:0x0085, B:39:0x009e), top: B:114:0x0059 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b2 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00b6 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00c2 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00ca A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ce A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00d2 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00db A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00e3 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00e7 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00eb A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00f4 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00fc A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0100 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0104 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:71:0x010a A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0112 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0116 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:76:0x011a A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0122 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0129 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:80:0x012d A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0131 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0139 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0140 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0144 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0148 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0150 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0157 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:92:0x015b A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:94:0x015f A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0167 A[Catch: all -> 0x00bf, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:96:0x016e A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #8 {all -> 0x00bf, blocks: (B:46:0x00ae, B:48:0x00b2, B:50:0x00b6, B:53:0x00c2, B:54:0x00ca, B:56:0x00ce, B:58:0x00d2, B:59:0x00db, B:60:0x00e3, B:62:0x00e7, B:64:0x00eb, B:65:0x00f4, B:66:0x00fc, B:68:0x0100, B:70:0x0104, B:71:0x010a, B:72:0x0112, B:74:0x0116, B:76:0x011a, B:77:0x0122, B:78:0x0129, B:80:0x012d, B:82:0x0131, B:83:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x0148, B:89:0x0150, B:90:0x0157, B:92:0x015b, B:94:0x015f, B:95:0x0167, B:96:0x016e), top: B:127:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:99:0x017a  */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(String str, Class<T> cls, FlyProduct flyProduct) {
        Object obj;
        GZIPInputStream gZIPInputStream;
        HashMap<String, Object> map;
        Closeable closeable;
        Class<T> cls2;
        T tCast = null;
        try {
            String strA = a(flyProduct);
            if (f1515s.containsKey(strA)) {
                map = f1515s.get(strA);
                gZIPInputStream = null;
            } else {
                try {
                    gZIPInputStream = new GZIPInputStream(FlySDK.getContext().getResources().getAssets().open(strA));
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(gZIPInputStream);
                        try {
                            HashMap<String, Object> map2 = (HashMap) objectInputStream.readObject();
                            if (map2 != null) {
                                try {
                                    if (!map2.isEmpty()) {
                                        f1515s.put(strA, map2);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                            map = map2;
                            closeable = objectInputStream;
                        } catch (Throwable unused2) {
                            map = null;
                            closeable = objectInputStream;
                        }
                    } catch (Throwable unused3) {
                        map = null;
                        closeable = null;
                    }
                } catch (Throwable unused4) {
                    map = null;
                    gZIPInputStream = null;
                    closeable = gZIPInputStream;
                }
                if (map != null) {
                    try {
                        if (!map.isEmpty()) {
                            obj = map.get(str);
                            if (!b("009AgbcjeegjejVhhiAeh").equals(str) && obj != null && (obj instanceof String)) {
                                tCast = (T) Boolean.valueOf(b("003Edb9e+eh").equalsIgnoreCase(String.valueOf(obj)) || b("004h2cicfEe").equalsIgnoreCase(String.valueOf(obj)));
                            } else if (obj != null) {
                                if (cls == null) {
                                    tCast = (T) obj;
                                } else if (cls != Void.class) {
                                    try {
                                        if (cls == Boolean.TYPE) {
                                            if (obj instanceof String) {
                                                tCast = (T) Boolean.valueOf((String) obj);
                                            } else {
                                                tCast = (T) Boolean.class.cast(obj);
                                            }
                                        } else if (cls == Integer.TYPE) {
                                            if (obj instanceof String) {
                                                tCast = (T) Integer.valueOf((String) obj);
                                            } else {
                                                tCast = (T) Integer.class.cast(obj);
                                            }
                                        } else if (cls == Byte.TYPE) {
                                            if (obj instanceof String) {
                                                tCast = (T) Byte.valueOf((String) obj);
                                            } else {
                                                tCast = (T) Byte.class.cast(obj);
                                            }
                                        } else {
                                            cls2 = Character.TYPE;
                                            if (cls == cls2) {
                                                if (obj instanceof String) {
                                                    tCast = cls2.cast(obj);
                                                } else {
                                                    tCast = (T) Character.class.cast(obj);
                                                }
                                            } else if (cls == Short.TYPE) {
                                                if (obj instanceof String) {
                                                    tCast = (T) Short.valueOf((String) obj);
                                                } else {
                                                    tCast = (T) Short.class.cast(obj);
                                                }
                                            } else if (cls == Long.TYPE) {
                                                if (obj instanceof String) {
                                                    tCast = (T) Long.valueOf((String) obj);
                                                } else {
                                                    tCast = (T) Long.class.cast(obj);
                                                }
                                            } else if (cls == Float.TYPE) {
                                                if (obj instanceof String) {
                                                    tCast = (T) Float.valueOf((String) obj);
                                                } else {
                                                    tCast = (T) Float.class.cast(obj);
                                                }
                                            } else if (cls == Double.TYPE) {
                                                if (obj instanceof String) {
                                                    tCast = (T) Double.valueOf((String) obj);
                                                } else {
                                                    tCast = (T) Double.class.cast(obj);
                                                }
                                            } else {
                                                tCast = cls.cast(obj);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            FlyLog.getInstance().d(th);
                                            tCast = (T) obj;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            tCast = (T) closeable;
                                            try {
                                                FlyLog.getInstance().d(th);
                                                C0396r.a(tCast, gZIPInputStream);
                                                return (T) obj;
                                            } catch (Throwable th3) {
                                                C0396r.a(tCast, gZIPInputStream);
                                                throw th3;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        obj = null;
                    }
                }
                C0396r.a(closeable, gZIPInputStream);
                return tCast;
            }
            closeable = gZIPInputStream;
            if (map != null) {
                if (!map.isEmpty()) {
                    obj = map.get(str);
                    if (!b("009AgbcjeegjejVhhiAeh").equals(str)) {
                        if (obj != null) {
                            if (cls == null) {
                                tCast = (T) obj;
                            } else if (cls != Void.class) {
                                if (cls == Boolean.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Boolean.valueOf((String) obj);
                                    } else {
                                        tCast = (T) Boolean.class.cast(obj);
                                    }
                                } else if (cls == Integer.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Integer.valueOf((String) obj);
                                    } else {
                                        tCast = (T) Integer.class.cast(obj);
                                    }
                                } else if (cls == Byte.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Byte.valueOf((String) obj);
                                    } else {
                                        tCast = (T) Byte.class.cast(obj);
                                    }
                                } else {
                                    cls2 = Character.TYPE;
                                    if (cls == cls2) {
                                        if (obj instanceof String) {
                                            tCast = cls2.cast(obj);
                                        } else {
                                            tCast = (T) Character.class.cast(obj);
                                        }
                                    } else if (cls == Short.TYPE) {
                                        if (obj instanceof String) {
                                            tCast = (T) Short.valueOf((String) obj);
                                        } else {
                                            tCast = (T) Short.class.cast(obj);
                                        }
                                    } else if (cls == Long.TYPE) {
                                        if (obj instanceof String) {
                                            tCast = (T) Long.valueOf((String) obj);
                                        } else {
                                            tCast = (T) Long.class.cast(obj);
                                        }
                                    } else if (cls == Float.TYPE) {
                                        if (obj instanceof String) {
                                            tCast = (T) Float.valueOf((String) obj);
                                        } else {
                                            tCast = (T) Float.class.cast(obj);
                                        }
                                    } else if (cls == Double.TYPE) {
                                        if (obj instanceof String) {
                                            tCast = (T) Double.valueOf((String) obj);
                                        } else {
                                            tCast = (T) Double.class.cast(obj);
                                        }
                                    } else {
                                        tCast = cls.cast(obj);
                                    }
                                }
                            }
                        }
                    } else if (obj != null) {
                        if (cls == null) {
                            tCast = (T) obj;
                        } else if (cls != Void.class) {
                            if (cls == Boolean.TYPE) {
                                if (obj instanceof String) {
                                    tCast = (T) Boolean.valueOf((String) obj);
                                } else {
                                    tCast = (T) Boolean.class.cast(obj);
                                }
                            } else if (cls == Integer.TYPE) {
                                if (obj instanceof String) {
                                    tCast = (T) Integer.valueOf((String) obj);
                                } else {
                                    tCast = (T) Integer.class.cast(obj);
                                }
                            } else if (cls == Byte.TYPE) {
                                if (obj instanceof String) {
                                    tCast = (T) Byte.valueOf((String) obj);
                                } else {
                                    tCast = (T) Byte.class.cast(obj);
                                }
                            } else {
                                cls2 = Character.TYPE;
                                if (cls == cls2) {
                                    if (obj instanceof String) {
                                        tCast = cls2.cast(obj);
                                    } else {
                                        tCast = (T) Character.class.cast(obj);
                                    }
                                } else if (cls == Short.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Short.valueOf((String) obj);
                                    } else {
                                        tCast = (T) Short.class.cast(obj);
                                    }
                                } else if (cls == Long.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Long.valueOf((String) obj);
                                    } else {
                                        tCast = (T) Long.class.cast(obj);
                                    }
                                } else if (cls == Float.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Float.valueOf((String) obj);
                                    } else {
                                        tCast = (T) Float.class.cast(obj);
                                    }
                                } else if (cls == Double.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Double.valueOf((String) obj);
                                    } else {
                                        tCast = (T) Double.class.cast(obj);
                                    }
                                } else {
                                    tCast = cls.cast(obj);
                                }
                            }
                        }
                    }
                }
            }
            C0396r.a(closeable, gZIPInputStream);
            return tCast;
        } catch (Throwable th5) {
            th = th5;
            obj = null;
            gZIPInputStream = null;
        }
    }

    public static <T> T a(String str) {
        try {
            Bundle bundle = cn.fly.tools.b.c.a(FlySDK.getContext()).d().a(FlySDK.getContext().getPackageName(), 128).metaData;
            if (bundle != null) {
                T t6 = (T) bundle.get(str);
                if (b("009Ugbcjeegjej,hhi<eh").equals(str) && t6 != null && (t6 instanceof String)) {
                    return (T) Boolean.valueOf(b("003Cdb[eHeh").equalsIgnoreCase(String.valueOf(t6)));
                }
                if (t6 != null) {
                    return t6;
                }
            }
            return null;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    private static String a(FlyProduct flyProduct) {
        if (flyProduct != null) {
            try {
                String productTag = flyProduct.getProductTag();
                if (b("008Wdkejecfifhdkekhb").equals(productTag)) {
                    return f1510n;
                }
                if (b("006,dkgbdkdkekhb").equals(productTag)) {
                    return f1513q;
                }
                if (b("007Ogbfgeieddddfhb").equals(productTag)) {
                    return f1514r;
                }
                if (b("007Sgbfgeifkdjdkej").equals(productTag)) {
                    return f1511o;
                }
                if (b("009Fdkfhdcfjfhfiddfbhk").equals(productTag)) {
                    return f1512p;
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        return "FlySDK.mt";
    }
}
