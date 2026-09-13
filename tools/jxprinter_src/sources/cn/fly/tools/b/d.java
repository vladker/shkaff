package cn.fly.tools.b;

import android.content.Context;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.commons.C0396r;
import cn.fly.commons.ac;
import cn.fly.commons.ae;
import cn.fly.commons.n;
import cn.fly.tools.FlyLog;
import cn.fly.tools.network.NetworkHelper;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.ResHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f1688a = null;
    private static volatile boolean d = false;
    private Context b;
    private HashMap<String, Object> c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile File f1690g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f1694k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f1695l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f1696m;
    private final byte[] e = new byte[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f1689f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ConcurrentLinkedQueue<CountDownLatch> f1691h = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile String f1692i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile int f1693j = -1;

    private d(Context context) {
        this.b = context;
    }

    private String e() {
        try {
            String str = (String) cn.fly.commons.c.b(n.a("002Mdgdg"), null);
            return str == null ? (String) cn.fly.commons.c.b(n.a("009:dgddbhcjdebg>gaf"), null) : str;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    public static boolean c() {
        return d;
    }

    public CountDownLatch d() {
        ConcurrentLinkedQueue<CountDownLatch> concurrentLinkedQueue = this.f1691h;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return null;
        }
        return this.f1691h.peek();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split("#")) == null || strArrSplit.length != 2) {
            return null;
        }
        return strArrSplit[1];
    }

    public int b() {
        return this.f1693j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split("#")) == null || strArrSplit.length != 2) {
            return null;
        }
        return strArrSplit[0];
    }

    private void d(String str) {
        File dataCacheFile = ResHelper.getDataCacheFile(this.b, str);
        if (!dataCacheFile.exists() || dataCacheFile.length() <= 0) {
            return;
        }
        dataCacheFile.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        return (TextUtils.isEmpty(b(str)) || TextUtils.isEmpty(c(str))) ? false : true;
    }

    public static d a(Context context) {
        if (f1688a == null) {
            synchronized (d.class) {
                try {
                    if (f1688a == null) {
                        f1688a = new d(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1688a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File b(File file, String str) {
        if (!file.exists()) {
            file.mkdirs();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d(str);
        return new File(file, str);
    }

    public final CountDownLatch a() {
        return a(e());
    }

    public void a(int i5) {
        this.f1693j = i5;
    }

    public final CountDownLatch a(final String str) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        FlyLog.getInstance().d("dhs ofr: " + countDownLatch, new Object[0]);
        this.f1691h.offer(countDownLatch);
        ac.d.execute(new Runnable() { // from class: cn.fly.tools.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                cn.fly.commons.h hVarA;
                Throwable th;
                StringBuilder sb;
                String str2;
                String strA;
                cn.fly.commons.h hVarA2;
                Throwable th2;
                String string;
                int i5;
                int i6;
                synchronized (d.this.e) {
                    try {
                        cn.fly.tools.c.a.c.set(Boolean.TRUE);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        try {
                            FlyLog.getInstance().d("dhs stch: " + d.this.e(str), new Object[0]);
                            File file = new File(FlySDK.getContext().getFilesDir(), n.a("0036baba2f"));
                            if (d.this.e(str)) {
                                d.this.a(0);
                                String strB = d.this.b(str);
                                if (!TextUtils.isEmpty(strB)) {
                                    try {
                                        if (DH.SyncMtd.isInMainProcess()) {
                                            str2 = strB;
                                        } else {
                                            String strReplace = DH.SyncMtd.getCurrentProcessName() + "";
                                            String packageName = DH.SyncMtd.getPackageName();
                                            if (strReplace.contains(packageName)) {
                                                strReplace = strReplace.replace(packageName, "");
                                            }
                                            str2 = strB + "_" + strReplace.replace(ParameterizedMessage.ERROR_MSG_SEPARATOR, "");
                                            try {
                                                FlyLog.getInstance().d("dhs cld nm " + str2, new Object[0]);
                                            } catch (Throwable unused) {
                                            }
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                    File fileB = d.this.b(file, str2);
                                    boolean z6 = fileB != null && fileB.exists() && fileB.isFile();
                                    FlyLog.getInstance().d("dhs cac: " + z6, new Object[0]);
                                    String strMD5 = Data.MD5(fileB);
                                    if (z6) {
                                        d.this.a(5);
                                        boolean zEquals = strB.equals(strMD5);
                                        FlyLog.getInstance().d("dhs m5: " + zEquals, new Object[0]);
                                        if (zEquals) {
                                            FlyLog.getInstance().d("dhs tbm: " + d.this.f1689f.get(), new Object[0]);
                                            if (!d.this.f1689f.compareAndSet(false, true)) {
                                                strMD5 = "";
                                            }
                                            strA = strMD5;
                                        } else {
                                            d.this.a(6);
                                            d dVar = d.this;
                                            strA = dVar.a(dVar.c(str), fileB, strB);
                                        }
                                    } else {
                                        d.this.a(8);
                                        d dVar2 = d.this;
                                        strA = dVar2.a(dVar2.c(str), fileB, strB);
                                    }
                                    FlyLog.getInstance().d("dhs cl:  tm5: " + strA + ", cm5: " + d.this.f1692i, new Object[0]);
                                    if (!TextUtils.isEmpty(strA) && !strA.equals(d.this.f1692i)) {
                                        d.this.a(fileB);
                                        HashMap mapA = d.this.a(fileB, strA);
                                        if (mapA == null || mapA.isEmpty()) {
                                            try {
                                                if (fileB.exists()) {
                                                    fileB.delete();
                                                }
                                            } catch (Throwable unused3) {
                                            }
                                            FlyLog.getInstance().d("dhs l fail", new Object[0]);
                                        } else {
                                            FlyLog.getInstance().d("dhs l succ", new Object[0]);
                                            f fVar = new f(mapA);
                                            d.this.f1692i = Data.MD5(fileB);
                                            boolean unused4 = d.d = c.a(d.this.b).a(fVar);
                                            d.this.a(16);
                                            FlyLog.getInstance().d("dhs fin", new Object[0]);
                                        }
                                    }
                                    d.this.f1696m = System.currentTimeMillis() - jCurrentTimeMillis;
                                    FlyLog.getInstance().d("dhs ctd: " + countDownLatch, new Object[0]);
                                    countDownLatch.countDown();
                                    d.this.f1691h.remove(countDownLatch);
                                    FlyLog.getInstance().d("dhs tt " + d.this.f1696m, new Object[0]);
                                    if (d.this.f1696m > 3500 && d.this.b() == 16) {
                                        hVarA = cn.fly.commons.h.a();
                                        th = new Throwable(("-t-" + d.this.f1696m) + "-d-" + d.this.f1695l + "-l-" + d.this.f1694k + " ");
                                        sb = new StringBuilder("");
                                        sb.append(d.this.f1692i);
                                        hVarA.a(3, 11, th, sb.toString());
                                    }
                                    cn.fly.tools.c.a.c.set(Boolean.FALSE);
                                    return;
                                }
                                boolean unused5 = d.d = false;
                                cn.fly.commons.h.a().a(-1, 4, "", "");
                                d.this.f1696m = System.currentTimeMillis() - jCurrentTimeMillis;
                                FlyLog.getInstance().d("dhs ctd: " + countDownLatch, new Object[0]);
                                countDownLatch.countDown();
                                d.this.f1691h.remove(countDownLatch);
                                FlyLog.getInstance().d("dhs tt " + d.this.f1696m, new Object[0]);
                                if (d.this.f1696m > 3500 && d.this.b() == 16) {
                                    hVarA2 = cn.fly.commons.h.a();
                                    th2 = new Throwable(("-t-" + d.this.f1696m) + "-d-" + d.this.f1695l + "-l-" + d.this.f1694k + " ");
                                    StringBuilder sb2 = new StringBuilder("");
                                    sb2.append(d.this.f1692i);
                                    string = sb2.toString();
                                    i5 = 11;
                                    i6 = 3;
                                    hVarA2.a(i6, i5, th2, string);
                                }
                            } else {
                                boolean unused6 = d.d = false;
                                ResHelper.deleteFileAndFolder(file);
                                d.this.f1696m = System.currentTimeMillis() - jCurrentTimeMillis;
                                FlyLog.getInstance().d("dhs ctd: " + countDownLatch, new Object[0]);
                                countDownLatch.countDown();
                                d.this.f1691h.remove(countDownLatch);
                                FlyLog.getInstance().d("dhs tt " + d.this.f1696m, new Object[0]);
                                if (d.this.f1696m > 3500 && d.this.b() == 16) {
                                    hVarA2 = cn.fly.commons.h.a();
                                    th2 = new Throwable(("-t-" + d.this.f1696m) + "-d-" + d.this.f1695l + "-l-" + d.this.f1694k + " ");
                                    StringBuilder sb3 = new StringBuilder("");
                                    sb3.append(d.this.f1692i);
                                    string = sb3.toString();
                                    i5 = 11;
                                    i6 = 3;
                                    hVarA2.a(i6, i5, th2, string);
                                }
                            }
                        } catch (Throwable th3) {
                            try {
                                FlyLog.getInstance().d("dhs oops: " + th3.getMessage(), new Object[0]);
                                FlyLog.getInstance().d(th3);
                                d.this.f1696m = System.currentTimeMillis() - jCurrentTimeMillis;
                                FlyLog.getInstance().d("dhs ctd: " + countDownLatch, new Object[0]);
                                countDownLatch.countDown();
                                d.this.f1691h.remove(countDownLatch);
                                FlyLog.getInstance().d("dhs tt " + d.this.f1696m, new Object[0]);
                                if (d.this.f1696m > 3500 && d.this.b() == 16) {
                                    hVarA = cn.fly.commons.h.a();
                                    th = new Throwable(("-t-" + d.this.f1696m) + "-d-" + d.this.f1695l + "-l-" + d.this.f1694k + " ");
                                    sb = new StringBuilder("");
                                    sb.append(d.this.f1692i);
                                }
                            } catch (Throwable th4) {
                                d.this.f1696m = System.currentTimeMillis() - jCurrentTimeMillis;
                                FlyLog.getInstance().d("dhs ctd: " + countDownLatch, new Object[0]);
                                countDownLatch.countDown();
                                d.this.f1691h.remove(countDownLatch);
                                FlyLog.getInstance().d("dhs tt " + d.this.f1696m, new Object[0]);
                                if (d.this.f1696m > 3500 && d.this.b() == 16) {
                                    cn.fly.commons.h hVarA3 = cn.fly.commons.h.a();
                                    Throwable th5 = new Throwable(("-t-" + d.this.f1696m) + "-d-" + d.this.f1695l + "-l-" + d.this.f1694k + " ");
                                    StringBuilder sb4 = new StringBuilder("");
                                    sb4.append(d.this.f1692i);
                                    hVarA3.a(3, 11, th5, sb4.toString());
                                }
                                throw th4;
                            }
                        }
                    } catch (Throwable th6) {
                        throw th6;
                    }
                }
            }
        });
        return countDownLatch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        if (this.f1690g != null && this.f1690g.exists()) {
            if (this.f1690g.delete()) {
                FlyLog.getInstance().d("dhs dof succ", new Object[0]);
            } else {
                FlyLog.getInstance().d("dhs dof fail", new Object[0]);
            }
        }
        this.f1690g = file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(File file, String str) {
        HashMap map = new HashMap();
        String strD = ae.b().d();
        if (TextUtils.isEmpty(strD)) {
            strD = HashonHelper.fromHashMap(map);
        }
        HashMap<String, Object> map2 = new HashMap<>();
        if (this.c == null) {
            HashMap<String, Object> map3 = new HashMap<>();
            this.c = map3;
            map3.put("cacheMap", new ConcurrentHashMap());
            this.c.put("invokeTimesMap", new ConcurrentHashMap());
            this.c.put("expireTimeMap", new ConcurrentHashMap());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = null;
        try {
            cn.fly.commons.cc.a.a(FlySDK.getContext(), file.getAbsolutePath(), strD, map2, this.c);
            this.f1694k = System.currentTimeMillis() - jCurrentTimeMillis;
            FlyLog.getInstance().d(TextUtils.isEmpty(null) ? String.format("dhs l %d", Long.valueOf(this.f1694k)) : null, new Object[0]);
            return map2;
        } catch (Throwable th) {
            try {
                str2 = "dhs l e: " + th.getMessage();
                map2.clear();
                cn.fly.commons.h.a().a(5, b(), th, "" + str);
                FlyLog.getInstance().d(th);
            } catch (Throwable unused) {
            }
            this.f1694k = System.currentTimeMillis() - jCurrentTimeMillis;
            if (TextUtils.isEmpty(str2)) {
                str2 = String.format("dhs l %d", Long.valueOf(this.f1694k));
            }
            FlyLog.getInstance().d(str2, new Object[0]);
            return map2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, File file, String str2) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str) && file != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str3 = null;
            try {
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    FlyLog.getInstance().d("dhs d...", new Object[0]);
                    new NetworkHelper().download(str, fileOutputStream, null);
                    String strMD5 = Data.MD5(file);
                    if (!TextUtils.equals(str2, strMD5)) {
                        cn.fly.commons.h.a().a(-1, 20, "", str2);
                        if (file.exists()) {
                            file.delete();
                        }
                        C0396r.a(fileOutputStream);
                        if (TextUtils.isEmpty(null)) {
                            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                            this.f1695l = jCurrentTimeMillis2;
                            str3 = String.format("dhs d %d", Long.valueOf(jCurrentTimeMillis2));
                        }
                        FlyLog.getInstance().d(str3, new Object[0]);
                        return "";
                    }
                    C0396r.a(fileOutputStream);
                    if (TextUtils.isEmpty(null)) {
                        long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                        this.f1695l = jCurrentTimeMillis3;
                        str3 = String.format("dhs d %d", Long.valueOf(jCurrentTimeMillis3));
                    }
                    FlyLog.getInstance().d(str3, new Object[0]);
                    return strMD5;
                } catch (Throwable th) {
                    th = th;
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                        str3 = "dhs d e: " + th.getMessage();
                        FlyLog.getInstance().d(th);
                        cn.fly.commons.h.a().a(2, b(), th, "" + str2);
                        C0396r.a(fileOutputStream);
                        if (TextUtils.isEmpty(str3)) {
                            long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis;
                            this.f1695l = jCurrentTimeMillis4;
                            str3 = String.format("dhs d %d", Long.valueOf(jCurrentTimeMillis4));
                        }
                        FlyLog.getInstance().d(str3, new Object[0]);
                        return "";
                    } catch (Throwable th2) {
                        C0396r.a(fileOutputStream);
                        if (TextUtils.isEmpty(str3)) {
                            long jCurrentTimeMillis5 = System.currentTimeMillis() - jCurrentTimeMillis;
                            this.f1695l = jCurrentTimeMillis5;
                            str3 = String.format("dhs d %d", Long.valueOf(jCurrentTimeMillis5));
                        }
                        FlyLog.getInstance().d(str3, new Object[0]);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }
        return "";
    }
}
