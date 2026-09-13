package cn.fly.commons;

import A3.AbstractC0157z;
import android.text.TextUtils;
import android.util.Base64;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.log.NLog;
import cn.fly.tools.network.NetworkHelper;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.FileLocker;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.ResHelper;
import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j {
    private static volatile j d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile ArrayList<String> f1442g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<String> f1443h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ReentrantReadWriteLock f1444i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ScheduledExecutorService f1448m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f1449n;
    private static final CountDownLatch c = new CountDownLatch(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, String> f1440a = new HashMap<>();
    private static final ArrayList<String> b = new ArrayList<>(Arrays.asList("cfgc.zztfly.com"));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile CountDownLatch f1445j = c;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f1446k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AtomicBoolean f1447l = new AtomicBoolean(false);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f1450o = "1/AHtA5SU4S98A+xZeKe64Gh3JIq961UY1+qEpKPZ+k=,niSzpNQDCJiJro9C6C+GneOoUjWk70xX1KLHPpNB9Nc=,ENwvHToz6w+XCZAmjNfqU3VuOyh/Ss2zb3+H65LBFuo=,WiR8mRXE8y0bUCBXb5ANHm6FxZc88IkTfazvI4W1xEI=,o49gWtV4hzbcs49d8AZNHkmSuZgJzeVA6xzi0UvfYV4=,Dg4ufHH1m2l1ciTqHX9C64n/ck/WQuYF28F9TYx0nFU=,IPXH1AK0hdLdtpo1cpFKjhaO57Sa0ltYg1rPQw3KxhY=,gjbOGpHpQjcKECAVdj2APwUZFeHIk0W9phwI2ldEJZo=,rSGUi5gypYk5upy3k46aciTvh+HztGIDmfs99pr7tb8=,ju2QK9VWinXtv6vWLwfj1n6RSVxbfFyU4rMUuyLW1uU=,lQHPokrqL9VDRkQn8+Lipyy34Q458Ej+inousRqw/LA=,OD7M5KRKKIKwj33r+CkGWY/8uTQGFkfVbf0gtEkNJm8=,uacHev2j7Cz6UmfQBKQk2MPmNgWnoxFH693vr8ubGAc=,V+fPpvjbDqW7yWki/gLvfJY5chlN8MDo9vRkktzB2Ls=,tXVPXd36IOCjqd/wtwxqSWWT/awmw+T4qMZoeEhgT1M=";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f1451p = "ezqF9qISN8ShdhR2agxPrZukVky3cdvFDIGa38SQmb0=,A3YEcd462Jz9Q/qaKF6dX/X7zxwiGzqrzV6JMLRFR6o=,3jxEu1sdMQq3HBHxXguwhyLSvJvM4EIHgF5Zv9MUE9U=,BNlrrD3MVpkIOwPn0nIMjHomP+yzbg1eGLh0Bifzuhg=,DQ9m4i6OwE3Ox4rtEbBj/1ycI8MYMRqWS5e8Ggmn1LM=,LN0Qtw/zlINc/6ZsffuwUZXqnu9VYk0CkhzekIbpNJE=,6uGthZL9XlaMUBrffAhZQWHmrYX8cbavo+HOtFc8sk4=,oC4zi6fe8JbZBHXHwGcPXeBEfWeQ+3v4tPStXOU9v9Y=,axdtozQ1KvV6GYJ5/JnVqzqVuLmzyYScUWJoOzD5bmM=,kZ4B2pbpNP38dU4qkHo2xvCX0Km3UIU/eK7+GJva/go=,9FnPiuPbw6uEux20ekcYp9QYLBJAsd7e7DCx2tgaUKE=,I/pGSfVmP68clpkMjeumvF991FtKZXiAwM0sNwq4MGI=,/CSbPmuBBhYaOEf1tspQF6NpHYsS3VRJeq+D6vJo3M0=,f/uKR9QlIpBApIcBfm4rhc4SpdJWuSdJfN4O1tj8pKk=,i1l9ocj9Rzep1zQWi6RwCuav0M1+v4isP/sCESvtyMI=";
    private volatile HashMap<String, HashMap<String, ArrayList<String>>> e = ae.b().n();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile HashMap<String, HashMap<String, ArrayList<String>>> f1441f = ae.b().o();

    public class a implements Runnable {
        private ArrayList<String> b;
        private long c;

        private long a(long j6) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jMax = Math.max(jCurrentTimeMillis, j6 + 10800000);
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
            calendar.setTimeInMillis(jMax);
            int i5 = calendar.get(11);
            if ((i5 < 0 || i5 >= 8) && (i5 < 20 || i5 > 23)) {
                calendar.set(11, 20);
                calendar.set(12, 0);
                calendar.set(13, 0);
                calendar.set(14, 0);
                jMax = calendar.getTimeInMillis();
            }
            return Math.max(0L, jMax - jCurrentTimeMillis);
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            long jA;
            long j6 = 300000;
            try {
                jA = a(this.c);
                try {
                    if (jA == 0) {
                        j.this.a(this.b);
                        if (j.this.f1445j.getCount() > 0) {
                            j.this.f1445j.await();
                        }
                        if (!j.this.f1449n) {
                            ae.b().a((Long) 0L);
                        }
                    } else {
                        j.this.f1449n = true;
                        j6 = jA;
                    }
                    try {
                        if (j.this.f1449n) {
                            j.this.f1448m.schedule(this, j6, TimeUnit.MILLISECONDS);
                        }
                    } catch (Throwable th2) {
                        FlyLog.getInstance().d(th2, androidx.exifinterface.media.a.t(th2, new StringBuilder("DM ")), new Object[0]);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        FlyLog.getInstance().d(th, "DM " + th.getMessage(), new Object[0]);
                        try {
                            if (j.this.f1449n) {
                            }
                        } catch (Throwable th4) {
                            FlyLog.getInstance().d(th4, androidx.exifinterface.media.a.t(th4, new StringBuilder("DM ")), new Object[0]);
                        }
                    } finally {
                        try {
                            if (j.this.f1449n) {
                                j.this.f1448m.schedule(this, jA, TimeUnit.MILLISECONDS);
                            }
                        } catch (Throwable th5) {
                            FlyLog.getInstance().d(th5, androidx.exifinterface.media.a.t(th5, new StringBuilder("DM ")), new Object[0]);
                        }
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                jA = 300000;
            }
        }

        private a(ArrayList<String> arrayList, long j6) {
            this.b = arrayList;
            this.c = j6;
        }
    }

    public class b {
        private b() {
        }

        private HashMap<String, String> b() {
            HashMap<String, String> map = (HashMap) ae.b().c("key_bnd_hst", null);
            NLog flyLog = FlyLog.getInstance();
            StringBuilder sb = new StringBuilder("DM HSB r bnd hst buf. sz: ");
            sb.append((map == null || map.isEmpty()) ? 0 : map.size());
            flyLog.d(sb.toString(), new Object[0]);
            if (map != null && map.containsKey("sdkVer")) {
                String str = map.get("sdkVer");
                NLog flyLog2 = FlyLog.getInstance();
                StringBuilder sbY = AbstractC0157z.y("DM HSB hst_v: ", str, ", sdk_v: ");
                String str2 = FlySDK.SDK_VERSION_NAME;
                sbY.append(str2);
                flyLog2.d(sbY.toString(), new Object[0]);
                if (str2.equals(str)) {
                    map.remove("sdkVer");
                    return map;
                }
            }
            return null;
        }

        private HashMap<String, String> c(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            try {
                String strAES128PaddingDecode = Data.AES128PaddingDecode(str, str2);
                if (a(strAES128PaddingDecode)) {
                    return HashonHelper.fromJson(strAES128PaddingDecode);
                }
                FlyLog.getInstance().d("DM HSB bnd hst NOT hit: not json", new Object[0]);
                return null;
            } catch (Throwable th) {
                FlyLog.getInstance().d(androidx.exifinterface.media.a.t(th, new StringBuilder("DM HSB bnd hst NOT hit: ")), new Object[0]);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            try {
                FlyLog.getInstance().d("DM HSB =====> start. ehp-len: " + j.this.f1450o.length() + ", ehk-len: " + j.this.f1451p.length(), new Object[0]);
                if (TextUtils.isEmpty(j.this.f1450o) || AbstractC1127c.NULL.equals(j.this.f1450o)) {
                    if (!TextUtils.isEmpty(j.this.f1451p)) {
                        if (AbstractC1127c.NULL.equals(j.this.f1451p)) {
                        }
                    }
                    FlyLog.getInstance().d("DM HSB =====> end", new Object[0]);
                    return;
                }
                HashMap<String, String> mapB = b();
                NLog flyLog = FlyLog.getInstance();
                StringBuilder sb = new StringBuilder("DM HSB found bnd hst: ");
                sb.append(mapB != null ? mapB.size() : 0);
                flyLog.d(sb.toString(), new Object[0]);
                if (mapB == null || mapB.isEmpty()) {
                    FlyLog.getInstance().d("DM HSB try hit bnd hst by 'p'", new Object[0]);
                    HashMap<String, String> mapB2 = b(DH.SyncMtd.getPackageName(), j.this.f1450o);
                    if (mapB2 == null || mapB2.isEmpty()) {
                        FlyLog.getInstance().d("DM HSB try hit bnd hst by 'k'", new Object[0]);
                        mapB2 = b(FlySDK.getAppkey(), j.this.f1451p);
                    }
                    if (mapB2 == null || mapB2.isEmpty()) {
                        FlyLog.getInstance().d("DM HSB bnd hst not hit, use def", new Object[0]);
                        mapB2 = new HashMap<>();
                        mapB2.putAll(j.f1440a);
                    }
                    mapB = mapB2;
                    FlyLog.getInstance().d("DM HSB w bnd hst buf. sz: " + mapB.size(), new Object[0]);
                    mapB.put("sdkVer", FlySDK.SDK_VERSION_NAME);
                    a(new HashMap<>(mapB));
                }
                b(mapB);
                FlyLog.getInstance().d("DM HSB =====> end", new Object[0]);
            } catch (Throwable th) {
                try {
                    FlyLog.getInstance().d(th, "DM HSB " + n.a("005d]bhbhbibh"), new Object[0]);
                    FlyLog.getInstance().d("DM HSB =====> end", new Object[0]);
                } catch (Throwable th2) {
                    FlyLog.getInstance().d("DM HSB =====> end", new Object[0]);
                    throw th2;
                }
            }
        }

        private void b(HashMap<String, String> map) {
            int iA;
            if (map != null) {
                map.remove("sdkVer");
                iA = 0;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    iA += a(entry.getKey(), entry.getValue());
                }
            } else {
                iA = 0;
            }
            FlyLog.getInstance().d(AbstractC0157z.k(iA, "DM HSB def hst replaced: "), new Object[0]);
        }

        private HashMap<String, String> b(String str, String str2) {
            HashMap<String, String> mapC = null;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String[] strArrSplit = str2.split(",");
                FlyLog.getInstance().d("DM HSB enTxt sz: " + strArrSplit.length, new Object[0]);
                int length = strArrSplit.length;
                for (int i5 = 0; i5 < length; i5++) {
                    mapC = c(str, strArrSplit[i5]);
                    if (mapC != null) {
                        FlyLog.getInstance().d(AbstractC0157z.n("DM HSB bnd hst hit by: ", str), new Object[0]);
                        return mapC;
                    }
                }
            }
            return mapC;
        }

        private void a(HashMap<String, String> map) {
            ae.b().b("key_bnd_hst", map);
        }

        private int a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    if ("gcfg".equals(str)) {
                        j.b.clear();
                        j.b.add(str2);
                    }
                    j.f1440a.put(str, str2);
                    return 1;
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th, "DM HSB replace def hst error", new Object[0]);
                }
            }
            return 0;
        }

        private boolean a(String str) {
            if (str != null && !str.trim().isEmpty()) {
                String strTrim = str.trim();
                if ((strTrim.startsWith(VectorFormat.DEFAULT_PREFIX) && strTrim.endsWith(VectorFormat.DEFAULT_SUFFIX)) || (strTrim.startsWith("[") && strTrim.endsWith("]"))) {
                    try {
                        try {
                            new JSONObject(strTrim);
                            return true;
                        } catch (JSONException unused) {
                        }
                    } catch (JSONException unused2) {
                        new JSONArray(strTrim);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static {
        f1440a.put("gcfg", "cfgc.zztfly.com");
        f1440a.put("gclg", "upc.zztfly.com");
        f1440a.put("el", "errc.zztfly.com");
        f1440a.put("dg", "devc.zztfly.com");
        f1440a.put("dtc", "fdl.zztfly.com");
        f1440a.put("tcig", "tgc.zztfly.com");
        f1440a.put("gdg", "gd.zztfly.com");
    }

    private j() {
        a(this.f1441f);
        ArrayList<String> arrayListQ = ae.b().q();
        this.f1443h = arrayListQ;
        if (arrayListQ == null || arrayListQ.isEmpty()) {
            this.f1443h = b;
        }
        this.f1444i = new ReentrantReadWriteLock();
        new b().a();
    }

    private ArrayList<String> f() {
        if (this.f1442g != null && !this.f1442g.isEmpty()) {
            return this.f1442g;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File dataCacheFile = ResHelper.getDataCacheFile(FlySDK.getContext(), ".dmfbd");
            if (!dataCacheFile.exists() || dataCacheFile.length() <= 0) {
                return arrayList;
            }
            arrayList.addAll((ArrayList) C0396r.a(dataCacheFile, Data.rawMD5(DH.SyncMtd.getPackageName())));
            return arrayList;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th, androidx.exifinterface.media.a.t(th, new StringBuilder("DM ")), new Object[0]);
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        File[] fileArrListFiles;
        try {
            ArrayList arrayList = new ArrayList();
            File file = new File(FlySDK.getContext().getFilesDir(), "sblf");
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
                arrayList.add(file);
                v.a(v.a(v.f1482i), new u() { // from class: cn.fly.commons.j.4
                    /* JADX WARN: Bottom block not found for handler: all -> 0x000b */
                    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
                    
                        return true;
                     */
                    @Override // cn.fly.commons.u
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public boolean a(cn.fly.tools.utils.FileLocker r4) {
                        /*
                            r3 = this;
                            java.lang.Object r4 = cn.fly.commons.v.f1486m     // Catch: java.lang.Throwable -> Lb
                            monitor-enter(r4)     // Catch: java.lang.Throwable -> Lb
                            r4.notifyAll()     // Catch: java.lang.Throwable -> L8
                            monitor-exit(r4)     // Catch: java.lang.Throwable -> L8
                            goto L21
                        L8:
                            r0 = move-exception
                            monitor-exit(r4)     // Catch: java.lang.Throwable -> L8
                            throw r0     // Catch: java.lang.Throwable -> Lb
                        Lb:
                            r4 = move-exception
                            cn.fly.tools.log.NLog r0 = cn.fly.tools.FlyLog.getInstance()
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            java.lang.String r2 = "DM "
                            r1.<init>(r2)
                            java.lang.String r1 = androidx.exifinterface.media.a.t(r4, r1)
                            r2 = 0
                            java.lang.Object[] r2 = new java.lang.Object[r2]
                            r0.d(r4, r1, r2)
                        L21:
                            r4 = 1
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: cn.fly.commons.j.AnonymousClass4.a(cn.fly.tools.utils.FileLocker):boolean");
                    }
                });
            }
            if (arrayList.isEmpty()) {
                long jLongValue = ae.b().r().longValue();
                if (jLongValue == 0) {
                    jLongValue = System.currentTimeMillis();
                    ae.b().a(Long.valueOf(jLongValue));
                }
                long j6 = jLongValue;
                ArrayList<String> arrayListF = f();
                if (arrayListF == null || arrayListF.isEmpty()) {
                    return;
                }
                ScheduledExecutorService scheduledExecutorService = ac.f1262f;
                this.f1448m = scheduledExecutorService;
                scheduledExecutorService.schedule(new a(arrayListF, j6), 0L, TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th, androidx.exifinterface.media.a.t(th, new StringBuilder("DM ")), new Object[0]);
        }
    }

    public void b() {
        this.f1446k = false;
    }

    public void c() {
        a(this.f1443h);
    }

    public void d() {
        try {
            if (this.f1447l.compareAndSet(false, true)) {
                ac.f1261a.execute(new Runnable() { // from class: cn.fly.commons.j.3
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z6;
                        boolean z7;
                        boolean z8;
                        try {
                            FlyLog.getInstance().d("DM ck start", new Object[0]);
                            if (j.this.e == null || j.this.e.isEmpty()) {
                                z6 = true;
                            } else {
                                HashMap map = new HashMap();
                                z6 = true;
                                for (Map.Entry entry : j.this.e.entrySet()) {
                                    String str = (String) entry.getKey();
                                    HashMap map2 = (HashMap) entry.getValue();
                                    HashMap map3 = new HashMap();
                                    if (map2 != null && !map2.isEmpty()) {
                                        for (Map.Entry entry2 : map2.entrySet()) {
                                            String str2 = (String) entry2.getKey();
                                            ArrayList arrayList = (ArrayList) entry2.getValue();
                                            ArrayList arrayList2 = new ArrayList();
                                            if (arrayList != null && !arrayList.isEmpty()) {
                                                int size = arrayList.size();
                                                int i5 = 0;
                                                while (i5 < size) {
                                                    Object obj = arrayList.get(i5);
                                                    i5++;
                                                    String str3 = (String) obj;
                                                    if (j.this.b(str3)) {
                                                        arrayList2.add(str3);
                                                    }
                                                }
                                            }
                                            if (!arrayList2.isEmpty()) {
                                                map3.put(str2, arrayList2);
                                            } else if (str2.equals("gcfg") && str.equals("FCOMMON")) {
                                                z6 = false;
                                            }
                                        }
                                    }
                                    if (!map3.isEmpty()) {
                                        map.put(str, map3);
                                    }
                                }
                                if (map.isEmpty()) {
                                    FlyLog.getInstance().d("DM busi no avai dm", new Object[0]);
                                } else {
                                    try {
                                        FlyLog.getInstance().d("DM busi w 2 cac: " + map, new Object[0]);
                                        if (j.this.f1444i.writeLock().tryLock(3000L, TimeUnit.MILLISECONDS)) {
                                            j.this.f1441f.clear();
                                            j.this.f1441f.putAll(map);
                                            ae.b().c(j.this.f1441f);
                                        }
                                        try {
                                            j.this.f1444i.writeLock().unlock();
                                        } catch (Throwable th) {
                                            FlyLog.getInstance().d(th, "DM " + th.getMessage(), new Object[0]);
                                        }
                                    } catch (Throwable th2) {
                                        try {
                                            FlyLog.getInstance().d(th2, "DM " + th2.getMessage(), new Object[0]);
                                            try {
                                                j.this.f1444i.writeLock().unlock();
                                            } catch (Throwable th3) {
                                                FlyLog.getInstance().d(th3, "DM " + th3.getMessage(), new Object[0]);
                                            }
                                        } catch (Throwable th4) {
                                            try {
                                                j.this.f1444i.writeLock().unlock();
                                                throw th4;
                                            } catch (Throwable th5) {
                                                FlyLog.getInstance().d(th5, "DM " + th5.getMessage(), new Object[0]);
                                                throw th4;
                                            }
                                        }
                                    }
                                }
                            }
                            try {
                                if (j.this.f1443h == null || j.this.f1443h.isEmpty()) {
                                    z8 = true;
                                } else {
                                    ArrayList arrayList3 = new ArrayList();
                                    ArrayList arrayList4 = j.this.f1443h;
                                    int size2 = arrayList4.size();
                                    int i6 = 0;
                                    while (i6 < size2) {
                                        Object obj2 = arrayList4.get(i6);
                                        i6++;
                                        String str4 = (String) obj2;
                                        if (j.this.b(str4)) {
                                            arrayList3.add(str4);
                                        }
                                    }
                                    if (arrayList3.isEmpty()) {
                                        try {
                                            FlyLog.getInstance().d("DM prx no avai dm", new Object[0]);
                                            z8 = false;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            z7 = false;
                                            FlyLog.getInstance().d(th, "DM " + th.getMessage(), new Object[0]);
                                            z8 = z7;
                                        }
                                    } else {
                                        FlyLog.getInstance().d("DM prx w 2 cac: " + arrayList3, new Object[0]);
                                        j.this.f1443h.clear();
                                        j.this.f1443h.addAll(arrayList3);
                                        ae.b().a(j.this.f1443h);
                                        z8 = true;
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                z7 = true;
                            }
                            if (z6 || z8) {
                                ae.b().a((Long) 0L);
                            } else {
                                j.this.f1449n = true;
                                j.this.g();
                            }
                        } catch (Throwable th8) {
                            FlyLog.getInstance().d(th8, androidx.exifinterface.media.a.t(th8, new StringBuilder("DM ")), new Object[0]);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th, androidx.exifinterface.media.a.t(th, new StringBuilder("DM ")), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        InetAddress[] allByName;
        if (!TextUtils.isEmpty(str)) {
            try {
                synchronized (j.class) {
                    allByName = InetAddress.getAllByName(str);
                }
                if (allByName != null) {
                    for (InetAddress inetAddress : allByName) {
                        if (!c(inetAddress.getHostAddress())) {
                            FlyLog.getInstance().d("DM ck ht: " + str + ", fai", new Object[0]);
                            return false;
                        }
                    }
                }
                FlyLog.getInstance().d("DM ck ht: " + str + ", suc", new Object[0]);
                return true;
            } catch (Throwable th) {
                FlyLog.getInstance().d(th, androidx.exifinterface.media.a.t(th, new StringBuilder("DM ")), new Object[0]);
            }
        }
        FlyLog.getInstance().d(AbstractC0157z.o("DM ck ht: ", str, ", fai_emp|exp"), new Object[0]);
        return false;
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str) || str.equals("127.0.0.1") || str.startsWith("10.") || str.startsWith("192.168")) {
            return false;
        }
        if (str.startsWith("172.")) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length > 1) {
                try {
                    int i5 = Integer.parseInt(strArrSplit[1]);
                    return i5 < 16 || i5 > 31;
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th, androidx.exifinterface.media.a.t(th, new StringBuilder("DM ")), new Object[0]);
                }
            }
        }
        return true;
    }

    private void a(HashMap<String, HashMap<String, ArrayList<String>>> map) {
        try {
            HashMap<String, String> mapP = ae.b().p();
            if ((map == null || map.isEmpty()) && mapP != null && !mapP.isEmpty()) {
                HashMap<String, HashMap<String, ArrayList<String>>> map2 = new HashMap<>();
                Set<String> setKeySet = mapP.keySet();
                if (setKeySet != null) {
                    for (String str : setKeySet) {
                        if (!TextUtils.isEmpty(str) && str.contains(ProcessIdUtil.DEFAULT_PROCESSID)) {
                            HashMap<String, ArrayList<String>> map3 = new HashMap<>();
                            String strSubstring = str.substring(0, str.indexOf(ProcessIdUtil.DEFAULT_PROCESSID));
                            String strSubstring2 = str.substring(str.indexOf(ProcessIdUtil.DEFAULT_PROCESSID) + 1);
                            if (!TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strSubstring2)) {
                                ArrayList<String> arrayList = new ArrayList<>();
                                arrayList.add(mapP.get(str));
                                map3.put(strSubstring2, arrayList);
                                map2.put(strSubstring, map3);
                            }
                        }
                    }
                }
                if (map2.isEmpty()) {
                    ae.b().c(map2);
                    ae.b().d((HashMap<String, String>) null);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static j a() {
        if (d == null) {
            synchronized (j.class) {
                try {
                    if (d == null) {
                        d = new j();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    private void b(ArrayList<String> arrayList) {
        try {
            File dataCacheFile = ResHelper.getDataCacheFile(FlySDK.getContext(), ".dmfbd", true);
            if (dataCacheFile.exists()) {
                C0396r.a(dataCacheFile, Data.rawMD5(DH.SyncMtd.getPackageName()), arrayList);
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th, androidx.exifinterface.media.a.t(th, new StringBuilder("DM ")), new Object[0]);
        }
    }

    public String a(String str) {
        return C0396r.a(a().a("FCOMMON", str, f1440a.get(str), false));
    }

    public String a(String str, String str2, String str3, boolean z6) {
        HashMap<String, ArrayList<String>> map;
        ArrayList<String> arrayList;
        NLog flyLog = FlyLog.getInstance();
        StringBuilder sbU = androidx.collection.a.u("DM get: ", str, ProcessIdUtil.DEFAULT_PROCESSID, str2, ProcessIdUtil.DEFAULT_PROCESSID);
        sbU.append(str3);
        sbU.append(ProcessIdUtil.DEFAULT_PROCESSID);
        sbU.append(z6);
        flyLog.d(sbU.toString(), new Object[0]);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.f1446k) {
            try {
                if (this.f1444i.readLock().tryLock(3000L, TimeUnit.MILLISECONDS)) {
                    if (this.e != null && this.e.containsKey(str)) {
                        HashMap<String, ArrayList<String>> map2 = this.e.get(str);
                        if (map2 != null && map2.containsKey(str2)) {
                            ArrayList<String> arrayList2 = map2.get(str2);
                            if (arrayList2 != null && !arrayList2.isEmpty()) {
                                if (this.f1441f != null && this.f1441f.containsKey(str) && (map = this.f1441f.get(str)) != null && map.containsKey(str2) && (arrayList = map.get(str2)) != null) {
                                    int size = arrayList.size();
                                    int i5 = 0;
                                    while (i5 < size) {
                                        String str4 = arrayList.get(i5);
                                        i5++;
                                        String str5 = str4;
                                        if (arrayList2.contains(str5)) {
                                            try {
                                                this.f1444i.readLock().unlock();
                                                return str5;
                                            } catch (Throwable th) {
                                                FlyLog.getInstance().d(th, androidx.exifinterface.media.a.t(th, new StringBuilder("DM ")), new Object[0]);
                                                return str5;
                                            }
                                        }
                                    }
                                }
                                String str6 = arrayList2.get(0);
                                try {
                                    this.f1444i.readLock().unlock();
                                    return str6;
                                } catch (Throwable th2) {
                                    FlyLog.getInstance().d(th2, androidx.exifinterface.media.a.t(th2, new StringBuilder("DM ")), new Object[0]);
                                    return str6;
                                }
                            }
                            try {
                                this.f1444i.readLock().unlock();
                                return str3;
                            } catch (Throwable th3) {
                                FlyLog.getInstance().d(th3, androidx.exifinterface.media.a.t(th3, new StringBuilder("DM ")), new Object[0]);
                                return str3;
                            }
                        }
                        try {
                            this.f1444i.readLock().unlock();
                            return str3;
                        } catch (Throwable th4) {
                            FlyLog.getInstance().d(th4, androidx.exifinterface.media.a.t(th4, new StringBuilder("DM ")), new Object[0]);
                            return str3;
                        }
                    }
                    try {
                        this.f1444i.readLock().unlock();
                        return str3;
                    } catch (Throwable th5) {
                        FlyLog.getInstance().d(th5, androidx.exifinterface.media.a.t(th5, new StringBuilder("DM ")), new Object[0]);
                        return str3;
                    }
                }
                try {
                    this.f1444i.readLock().unlock();
                    return str3;
                } catch (Throwable th6) {
                    FlyLog.getInstance().d(th6, androidx.exifinterface.media.a.t(th6, new StringBuilder("DM ")), new Object[0]);
                }
            } catch (Throwable th7) {
                try {
                    FlyLog.getInstance().d(th7, "DM " + th7.getMessage(), new Object[0]);
                    try {
                        this.f1444i.readLock().unlock();
                    } catch (Throwable th8) {
                        FlyLog.getInstance().d(th8, androidx.exifinterface.media.a.t(th8, new StringBuilder("DM ")), new Object[0]);
                    }
                } catch (Throwable th9) {
                    try {
                        this.f1444i.readLock().unlock();
                    } catch (Throwable th10) {
                        FlyLog.getInstance().d(th10, androidx.exifinterface.media.a.t(th10, new StringBuilder("DM ")), new Object[0]);
                    }
                    throw th9;
                }
            }
            return str3;
        }
        FlyLog.getInstance().d("DM Params 'sName' or 'aName' is null", new Object[0]);
        return str3;
    }

    public void a(final ArrayList<String> arrayList) {
        if (this.f1445j != c && this.f1445j.getCount() != 0) {
            FlyLog.getInstance().d("DM obt abort", new Object[0]);
            return;
        }
        FlyLog.getInstance().d("DM obt start", new Object[0]);
        this.f1445j = new CountDownLatch(1);
        ac.f1261a.execute(new Runnable() { // from class: cn.fly.commons.j.1
            @Override // java.lang.Runnable
            public void run() {
                j jVar = j.this;
                jVar.a(jVar.f1445j, 0, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:128:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:138:0x0423 A[Catch: all -> 0x0467, TryCatch #6 {all -> 0x0467, blocks: (B:129:0x03f4, B:131:0x0404, B:133:0x0408, B:135:0x040c, B:136:0x041d, B:138:0x0423, B:140:0x043c, B:141:0x0444, B:143:0x044a, B:145:0x045e, B:148:0x0469), top: B:191:0x03f4, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x043c A[Catch: all -> 0x0467, TryCatch #6 {all -> 0x0467, blocks: (B:129:0x03f4, B:131:0x0404, B:133:0x0408, B:135:0x040c, B:136:0x041d, B:138:0x0423, B:140:0x043c, B:141:0x0444, B:143:0x044a, B:145:0x045e, B:148:0x0469), top: B:191:0x03f4, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x044a A[Catch: all -> 0x0467, TryCatch #6 {all -> 0x0467, blocks: (B:129:0x03f4, B:131:0x0404, B:133:0x0408, B:135:0x040c, B:136:0x041d, B:138:0x0423, B:140:0x043c, B:141:0x0444, B:143:0x044a, B:145:0x045e, B:148:0x0469), top: B:191:0x03f4, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0543 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:213:0x0469 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x045e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:217:0x0444 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:228:? A[RETURN, SYNTHETIC] */
    public void a(CountDownLatch countDownLatch, int i5, ArrayList<String> arrayList) {
        long j6;
        Object obj;
        HashMap<String, ArrayList<String>> value;
        HashMap<String, ArrayList<String>> map;
        String key;
        ArrayList<String> value2;
        try {
            if (arrayList == null) {
                j6 = 0;
                if (this.f1444i.writeLock().tryLock(3000L, TimeUnit.MILLISECONDS)) {
                    this.e = new HashMap<>();
                    for (Map.Entry<String, HashMap<String, ArrayList<String>>> entry : this.f1441f.entrySet()) {
                        String key2 = entry.getKey();
                        value = entry.getValue();
                        map = new HashMap<>();
                        if (value != null) {
                            for (Map.Entry<String, ArrayList<String>> entry2 : value.entrySet()) {
                                key = entry2.getKey();
                                value2 = entry2.getValue();
                                if (value2 != null) {
                                    map.put(key, new ArrayList<>(value2));
                                }
                            }
                        }
                        this.e.put(key2, map);
                    }
                }
                this.f1444i.writeLock().unlock();
                FlyLog.getInstance().w("DM No pdm");
                if (countDownLatch.getCount() <= j6) {
                }
            } else {
                try {
                    if (i5 < arrayList.size()) {
                        String strA = C0396r.a(arrayList.get(i5) + "/nndm");
                        HashMap<String, Object> map2 = new HashMap<>();
                        map2.put(n.a("006bhh=cfKd8ca"), q.a());
                        map2.put(n.a("007RbbAd$bhdgbgbiOc"), Integer.valueOf(cn.fly.commons.cc.a.a()));
                        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                        networkTimeOut.connectionTimeout = 3000;
                        networkTimeOut.readTimout = 5000;
                        j6 = 0;
                        String strHttpGetNew = new NetworkHelper().httpGetNew(strA, map2, null, networkTimeOut);
                        FlyLog.getInstance().d("DM resp: " + strHttpGetNew, new Object[0]);
                        HashMap mapFromJson = HashonHelper.fromJson(strHttpGetNew);
                        if (mapFromJson != null && !mapFromJson.isEmpty() && (obj = mapFromJson.get(n.a("004a:bibaZd"))) != null && ((Integer) obj).intValue() == 200) {
                            String str = (String) mapFromJson.get(n.a("004VbaGbgb"));
                            if (!TextUtils.isEmpty(str)) {
                                final HashMap mapFromJson2 = HashonHelper.fromJson(new String(Data.AES128Decode(Data.byteToHex(Data.rawMD5(q.a())).getBytes("UTF-8"), Base64.decode(str, 2), false), "utf-8"));
                                if (mapFromJson2 != null && !mapFromJson2.isEmpty()) {
                                    this.f1449n = false;
                                    ae.b().a((Long) 0L);
                                    try {
                                        HashMap map3 = (HashMap) mapFromJson2.get(n.a("004Eba?bgb"));
                                        if (map3 != null && !map3.isEmpty()) {
                                            HashMap map4 = new HashMap();
                                            for (Map.Entry entry3 : map3.entrySet()) {
                                                String str2 = (String) entry3.getKey();
                                                HashMap map5 = (HashMap) entry3.getValue();
                                                HashMap map6 = new HashMap();
                                                if (map5 != null && !map5.isEmpty()) {
                                                    for (Map.Entry entry4 : map5.entrySet()) {
                                                        String str3 = (String) entry4.getKey();
                                                        ArrayList arrayList2 = (ArrayList) entry4.getValue();
                                                        ArrayList arrayList3 = new ArrayList();
                                                        if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                            arrayList3.addAll(arrayList2);
                                                        }
                                                        if (!arrayList3.isEmpty()) {
                                                            map6.put(str3, arrayList3);
                                                        }
                                                    }
                                                }
                                                if (!map6.isEmpty()) {
                                                    map4.put(str2, map6);
                                                }
                                            }
                                            if (!map4.isEmpty()) {
                                                try {
                                                    FlyLog.getInstance().d("DM busi w 2 cac: " + map4, new Object[0]);
                                                    if (this.f1444i.writeLock().tryLock(3000L, TimeUnit.MILLISECONDS)) {
                                                        this.e.clear();
                                                        this.e.putAll(map4);
                                                        ae.b().b(this.e);
                                                    }
                                                    try {
                                                        this.f1444i.writeLock().unlock();
                                                    } catch (Throwable th) {
                                                        FlyLog.getInstance().d(th, "DM " + th.getMessage(), new Object[0]);
                                                    }
                                                } catch (Throwable th2) {
                                                    try {
                                                        FlyLog.getInstance().d(th2, "DM " + th2.getMessage(), new Object[0]);
                                                        try {
                                                            this.f1444i.writeLock().unlock();
                                                        } catch (Throwable th3) {
                                                            FlyLog.getInstance().d(th3, "DM " + th3.getMessage(), new Object[0]);
                                                        }
                                                    } catch (Throwable th4) {
                                                        try {
                                                            this.f1444i.writeLock().unlock();
                                                            throw th4;
                                                        } catch (Throwable th5) {
                                                            FlyLog.getInstance().d(th5, "DM " + th5.getMessage(), new Object[0]);
                                                            throw th4;
                                                        }
                                                    }
                                                }
                                            } else {
                                                FlyLog.getInstance().d("DM busi no avai dm", new Object[0]);
                                            }
                                        } else {
                                            ae.b().b((HashMap<String, HashMap<String, ArrayList<String>>>) null);
                                        }
                                        try {
                                            ArrayList arrayList4 = (ArrayList) mapFromJson2.get("p");
                                            if (arrayList4 != null && !arrayList4.isEmpty()) {
                                                ArrayList arrayList5 = new ArrayList();
                                                arrayList5.addAll(arrayList4);
                                                if (arrayList5.isEmpty()) {
                                                    FlyLog.getInstance().d("DM prx no avai dm", new Object[0]);
                                                } else {
                                                    FlyLog.getInstance().d("DM prx w 2 cac: " + arrayList5, new Object[0]);
                                                    this.f1443h.clear();
                                                    this.f1443h.addAll(arrayList5);
                                                    ae.b().a(this.f1443h);
                                                }
                                            } else {
                                                ae.b().a((ArrayList<String>) null);
                                            }
                                        } catch (Throwable th6) {
                                            FlyLog.getInstance().d(th6, "DM " + th6.getMessage(), new Object[0]);
                                        }
                                        try {
                                            ArrayList arrayList6 = (ArrayList) mapFromJson2.get("f");
                                            if (arrayList6 != null && !arrayList6.isEmpty()) {
                                                ArrayList arrayList7 = new ArrayList();
                                                arrayList7.addAll(arrayList6);
                                                if (arrayList7.isEmpty()) {
                                                    FlyLog.getInstance().d("DM prx no avai dm", new Object[0]);
                                                } else {
                                                    FlyLog.getInstance().d("DM fil w 2 cac: " + arrayList7, new Object[0]);
                                                    if (this.f1442g == null) {
                                                        this.f1442g = new ArrayList<>();
                                                    }
                                                    this.f1442g.clear();
                                                    this.f1442g.addAll(arrayList7);
                                                    b(this.f1442g);
                                                }
                                            }
                                        } catch (Throwable th7) {
                                            FlyLog.getInstance().d(th7, "DM " + th7.getMessage(), new Object[0]);
                                        }
                                        try {
                                            v.a(v.a(v.f1482i), false, new u() { // from class: cn.fly.commons.j.2
                                                @Override // cn.fly.commons.u
                                                public boolean a(FileLocker fileLocker) {
                                                    try {
                                                        File file = new File(FlySDK.getContext().getFilesDir(), "sblf");
                                                        HashMap map7 = (HashMap) mapFromJson2.get("t");
                                                        if (map7 != null && !map7.isEmpty() && map7.containsKey(n.a("002?cd6e")) && map7.containsKey("m")) {
                                                            synchronized (v.f1486m) {
                                                                d.a((HashMap<String, String>) map7);
                                                            }
                                                            return false;
                                                        }
                                                        C0396r.a(file);
                                                        return false;
                                                    } catch (Throwable th8) {
                                                        FlyLog.getInstance().d(th8, androidx.exifinterface.media.a.t(th8, new StringBuilder("DM ")), new Object[0]);
                                                    }
                                                }
                                            });
                                        } catch (Throwable th8) {
                                            FlyLog.getInstance().d(th8, "DM " + th8.getMessage(), new Object[0]);
                                        }
                                    } catch (Throwable th9) {
                                        try {
                                            FlyLog.getInstance().d(th9, "DM " + th9.getMessage(), new Object[0]);
                                        } catch (Throwable th10) {
                                            countDownLatch.countDown();
                                            throw th10;
                                        }
                                    }
                                    countDownLatch.countDown();
                                } else {
                                    ae.b().a((ArrayList<String>) null);
                                    ae.b().b((HashMap<String, HashMap<String, ArrayList<String>>>) null);
                                }
                            }
                        } else {
                            a(countDownLatch, i5 + 1, arrayList);
                        }
                    } else {
                        j6 = 0;
                        try {
                            if (this.f1444i.writeLock().tryLock(3000L, TimeUnit.MILLISECONDS) && this.e == null && this.f1441f != null) {
                                this.e = new HashMap<>();
                                while (r0.hasNext()) {
                                    String key3 = entry.getKey();
                                    value = entry.getValue();
                                    map = new HashMap<>();
                                    if (value != null) {
                                        while (r5.hasNext()) {
                                            key = entry2.getKey();
                                            value2 = entry2.getValue();
                                            if (value2 != null) {
                                                map.put(key, new ArrayList<>(value2));
                                            }
                                        }
                                    }
                                    this.e.put(key3, map);
                                }
                            }
                            try {
                                this.f1444i.writeLock().unlock();
                            } catch (Throwable th11) {
                                FlyLog.getInstance().d(th11, "DM " + th11.getMessage(), new Object[0]);
                            }
                        } catch (Throwable th12) {
                            try {
                                FlyLog.getInstance().d(th12, "DM " + th12.getMessage(), new Object[0]);
                                try {
                                    this.f1444i.writeLock().unlock();
                                } catch (Throwable th13) {
                                    FlyLog.getInstance().d(th13, "DM " + th13.getMessage(), new Object[0]);
                                }
                            } catch (Throwable th14) {
                                try {
                                    this.f1444i.writeLock().unlock();
                                    throw th14;
                                } catch (Throwable th15) {
                                    FlyLog.getInstance().d(th15, "DM " + th15.getMessage(), new Object[0]);
                                    throw th14;
                                }
                            }
                        }
                        FlyLog.getInstance().w("DM No pdm");
                    }
                    if (countDownLatch.getCount() <= j6) {
                    }
                } catch (Throwable th16) {
                    th = th16;
                    j6 = 0;
                    try {
                        FlyLog.getInstance().d(th, "DM " + th.getMessage(), new Object[0]);
                        a(countDownLatch, i5 + 1, arrayList);
                    } finally {
                        if (countDownLatch.getCount() > j6) {
                            countDownLatch.countDown();
                        }
                    }
                }
            }
        } catch (Throwable th17) {
            th = th17;
            FlyLog.getInstance().d(th, "DM " + th.getMessage(), new Object[0]);
            a(countDownLatch, i5 + 1, arrayList);
        }
    }
}
