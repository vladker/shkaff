package cn.fly.commons;

import android.content.pm.ApplicationInfo;
import android.media.MediaDrm;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class ab {
    private static volatile ab e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<String, Integer> f1249f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile String f1248a = null;
    private volatile String b = null;
    private volatile String c = null;
    private volatile String d = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f1250g = new byte[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f1251h = new byte[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicBoolean f1252i = new AtomicBoolean(false);

    private ab() {
    }

    private String j() {
        if (!TextUtils.isEmpty(g())) {
            return "12" + c(g());
        }
        if (!TextUtils.isEmpty(f())) {
            return "22" + c(f());
        }
        if (TextUtils.isEmpty(k())) {
            return "42" + c(UUID.randomUUID().toString());
        }
        return "32" + c(this.d);
    }

    private String k() {
        DH.requester(FlySDK.getContext()).getOD().request(new DH.DHResponder() { // from class: cn.fly.commons.ab.2
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                String od = dHResponse.getOD();
                List<String> listAsList = Arrays.asList("00000000-0000-0000-0000-000000000000", "00000000000000000000000000000000");
                a.c cVarD = f.d();
                if (cVarD != null && cVarD.d() != null) {
                    listAsList = cVarD.d();
                }
                if (TextUtils.isEmpty(od) || listAsList.contains(od)) {
                    return;
                }
                ab.this.d = od;
            }
        });
        return this.d;
    }

    private String l() throws InterruptedException {
        if (DH.SyncMtd.getOSVersionIntForFly() < 18) {
            return null;
        }
        String brandForFly = DH.SyncMtd.getBrandForFly();
        String manufacturerForFly = DH.SyncMtd.getManufacturerForFly();
        if ("SMARTISAN".equalsIgnoreCase(brandForFly) || "SMARTISAN".equalsIgnoreCase(manufacturerForFly)) {
            return null;
        }
        final String[] strArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ac.f1261a.execute(new cn.fly.tools.utils.i() { // from class: cn.fly.commons.ab.5
            @Override // cn.fly.tools.utils.i
            public void a() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strA = cn.fly.commons.a.l.a("061h=fjkgeeiigiiiHg$fgjlikRgdUemeeHh5iigjCdg8fgedimemejfkejggjliikgjlieemUj]fkfj7dPfjijggEd7ggemelgjfkijedifigifMdNiiigigjljl6d>iggi");
                UUID uuid = new UUID(-1301668207276963122L, -6645017420763422227L);
                MediaDrm mediaDrm = null;
                try {
                    try {
                        MediaDrm mediaDrm2 = new MediaDrm(uuid);
                        try {
                            cn.fly.tools.a.f.a(FlySDK.getContext()).a(mediaDrm2.getClass(), mediaDrm2, cn.fly.commons.a.l.a("012fej@ejeeWg@eigj$gj'eh)k"), new Class[]{Object.class, byte[].class, String.class}, new Object[]{new WeakReference(mediaDrm2), ab.this.a(uuid), strA}, (Class<?>) null, (Object) null);
                            byte[] propertyByteArray = mediaDrm2.getPropertyByteArray(cn.fly.commons.a.l.a("014Ded<g[eeej2dg:flEfDejefeh[gVffed"));
                            strArr[0] = Data.byteToHex(propertyByteArray, 0, propertyByteArray.length);
                            FlyLog.getInstance().d("rddd wv c " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                            countDownLatch.countDown();
                            if (DH.SyncMtd.getOSVersionIntForFly() >= 28) {
                                mediaDrm2.release();
                            } else {
                                mediaDrm2.release();
                            }
                        } catch (Throwable th) {
                            th = th;
                            mediaDrm = mediaDrm2;
                            try {
                                FlyLog.getInstance().d(th);
                                countDownLatch.countDown();
                                if (DH.SyncMtd.getOSVersionIntForFly() >= 28) {
                                    if (mediaDrm != null) {
                                        mediaDrm.release();
                                    }
                                } else if (mediaDrm != null) {
                                    mediaDrm.release();
                                }
                            } catch (Throwable th2) {
                                try {
                                    countDownLatch.countDown();
                                    if (DH.SyncMtd.getOSVersionIntForFly() >= 28) {
                                        if (mediaDrm != null) {
                                            mediaDrm.release();
                                        }
                                    } else if (mediaDrm != null) {
                                        mediaDrm.release();
                                    }
                                    throw th2;
                                } catch (Throwable th3) {
                                    FlyLog.getInstance().d(th3);
                                    throw th2;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        FlyLog.getInstance().d(th4);
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        });
        countDownLatch.await(1L, TimeUnit.SECONDS);
        return strArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m() {
        long j6;
        final String[] strArr = new String[1];
        if (c.a(cn.fly.commons.a.l.a("003ehh"))) {
            try {
                String strB = ae.b().b("key_pddt", (String) null);
                strArr[0] = strB;
                if (!TextUtils.isEmpty(strB)) {
                    long jB = ae.b().b("key_lgpdt", 0L);
                    try {
                        j6 = Long.parseLong(String.valueOf(c.a(cn.fly.commons.a.l.a("006KgjfdgjfkZek"), 604800))) * 1000;
                    } catch (Throwable unused) {
                        j6 = 604800000;
                    }
                    if (System.currentTimeMillis() - jB < j6) {
                        FlyLog.getInstance().d("rddd che p useable", new Object[0]);
                        return strArr[0];
                    }
                }
                if ((cn.fly.commons.a.l.a("004[eeejeeel").equalsIgnoreCase(DH.SyncMtd.getManufacturerForFly()) && DH.SyncMtd.getOSVersionIntForFly() <= 25) || (cn.fly.commons.a.l.a("006i[eh;e<gh^g0ej").equalsIgnoreCase(DH.SyncMtd.getManufacturerForFly()) && DH.SyncMtd.getOSVersionIntForFly() <= 22)) {
                    return null;
                }
                final List<String> listN = n();
                if (!listN.isEmpty()) {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    final StringBuilder sb = new StringBuilder();
                    DH.RequestBuilder requestBuilderRequester = DH.requester(FlySDK.getContext());
                    Iterator<String> it = listN.iterator();
                    while (it.hasNext()) {
                        requestBuilderRequester.getAInfoForPkg(it.next(), 1);
                    }
                    requestBuilderRequester.request(new DH.DHResponder() { // from class: cn.fly.commons.ab.6
                        @Override // cn.fly.tools.utils.DH.DHResponder
                        public void onResponse(DH.DHResponse dHResponse) {
                            int i5 = 0;
                            for (int i6 = 0; i6 < listN.size(); i6++) {
                                try {
                                    ApplicationInfo aInfoForPkg = dHResponse.getAInfoForPkg(i6);
                                    if (aInfoForPkg != null) {
                                        sb.append((String) listN.get(i6));
                                        sb.append(cn.fly.tools.c.a(aInfoForPkg, (String) listN.get(i6)));
                                        i5++;
                                    }
                                } catch (Throwable th) {
                                    countDownLatch.countDown();
                                    throw th;
                                }
                            }
                            if (i5 > 0) {
                                StringBuilder sb2 = sb;
                                String str = Build.BRAND;
                                Locale locale = Locale.ROOT;
                                sb2.append(str.toUpperCase(locale));
                                sb2.append(Build.MODEL.toUpperCase(locale));
                                sb2.append(Build.MANUFACTURER.toUpperCase(locale));
                                sb.append(i5);
                                strArr[0] = Data.MD5(sb.toString());
                                ae.b().a("key_pddt", strArr[0]);
                                ae.b().a("key_lgpdt", System.currentTimeMillis());
                            }
                            countDownLatch.countDown();
                        }
                    });
                    try {
                        countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        return strArr[0];
    }

    private List<String> n() {
        final ArrayList arrayList = new ArrayList();
        DH.requester(FlySDK.getContext()).getSA().request(new DH.DHResponder() { // from class: cn.fly.commons.ab.7
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                if (dHResponse.getSA() == null || dHResponse.getSA().isEmpty()) {
                    return;
                }
                ArrayList<HashMap<String, String>> sa = dHResponse.getSA();
                int size = sa.size();
                int i5 = 0;
                while (i5 < size) {
                    HashMap<String, String> map = sa.get(i5);
                    i5++;
                    String str = map.get(cn.fly.commons.a.l.a("003k8fifk"));
                    if (str != null && !str.contains("com.google.android") && !str.contains("com.miui.packageinstaller")) {
                        arrayList.add(str);
                    }
                }
                Collections.sort(arrayList);
            }
        });
        return arrayList;
    }

    public String c() {
        if (TextUtils.isEmpty(this.b)) {
            String strB = ae.b().b("key_rdt2", (String) null);
            if (!TextUtils.isEmpty(strB)) {
                this.b = strB;
            }
        }
        return this.b;
    }

    public boolean d() {
        if (!TextUtils.isEmpty(this.b)) {
            return false;
        }
        synchronized (this) {
            try {
                if (!TextUtils.isEmpty(this.b)) {
                    return false;
                }
                return TextUtils.isEmpty(ae.b().b("key_rdt2", (String) null));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized String e() {
        String strC;
        strC = c();
        if (TextUtils.isEmpty(strC)) {
            strC = j();
            this.b = strC;
            if (!TextUtils.isEmpty(strC)) {
                ae.b().a("key_rdt2", strC);
            }
        }
        return strC;
    }

    public String f() {
        if (TextUtils.isEmpty(this.c)) {
            synchronized (this.f1251h) {
                try {
                    if (TextUtils.isEmpty(this.c)) {
                        if (c.a()) {
                            this.c = m();
                        } else if (this.f1252i.compareAndSet(false, true)) {
                            c.a(new c.b() { // from class: cn.fly.commons.ab.1
                                @Override // cn.fly.commons.c.b
                                public void a() {
                                    ab abVar = ab.this;
                                    abVar.c = abVar.m();
                                }
                            }, new boolean[0]);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.c;
    }

    public String g() {
        if (TextUtils.isEmpty(this.f1248a)) {
            synchronized (this.f1250g) {
                try {
                    if (TextUtils.isEmpty(this.f1248a)) {
                        if (c.a()) {
                            try {
                                this.f1248a = l();
                                b(this.f1248a);
                            } catch (Throwable th) {
                                FlyLog.getInstance().d(th);
                            }
                        } else {
                            c.a(new c.b() { // from class: cn.fly.commons.ab.3
                                @Override // cn.fly.commons.c.b
                                public void a() {
                                    DH.requester(FlySDK.getContext()).getDM(true).request(new DH.DHResponder() { // from class: cn.fly.commons.ab.3.1
                                        @Override // cn.fly.tools.utils.DH.DHResponder
                                        public void onResponse(DH.DHResponse dHResponse) {
                                            dHResponse.getDM();
                                        }
                                    });
                                    c.a(this);
                                }
                            }, new boolean[0]);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f1248a;
    }

    public String h() {
        if (!TextUtils.isEmpty(this.f1248a)) {
            return this.f1248a;
        }
        LinkedHashMap linkedHashMap = (LinkedHashMap) ae.b().a("key_drds");
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return null;
        }
        return (String) linkedHashMap.keySet().iterator().next();
    }

    public HashMap<String, Integer> i() {
        return this.f1249f;
    }

    public String b() {
        return ExifInterface.GPS_MEASUREMENT_2D;
    }

    private String b(boolean z6) {
        String strG;
        if (z6) {
            strG = h();
        } else {
            strG = g();
        }
        if (!TextUtils.isEmpty(strG)) {
            return "12" + c(strG);
        }
        return "42" + c(UUID.randomUUID().toString());
    }

    public static ab a() {
        if (e == null) {
            synchronized (ab.class) {
                try {
                    if (e == null) {
                        e = new ab();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    private String c(String str) {
        StringBuilder sb = new StringBuilder(str);
        String manufacturerForFly = DH.SyncMtd.getManufacturerForFly();
        String modelForFly = DH.SyncMtd.getModelForFly();
        if (!TextUtils.isEmpty(manufacturerForFly)) {
            sb.append(manufacturerForFly.trim().toUpperCase());
        }
        if (!TextUtils.isEmpty(modelForFly)) {
            sb.append(modelForFly.trim().toUpperCase());
        }
        return Data.MD5(sb.toString());
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap map = (HashMap) ae.b().a("key_drds");
            if (map == null) {
                map = new HashMap();
            }
            if (map.containsKey(str)) {
                int iIntValue = ((Integer) map.get(str)).intValue();
                if (iIntValue < 100000) {
                    map.put(str, Integer.valueOf(iIntValue + 1));
                }
            } else {
                map.put(str, 1);
            }
            ArrayList arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: cn.fly.commons.ab.4
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                    return entry2.getValue().compareTo(entry.getValue());
                }
            });
            for (int size = arrayList.size(); size > 7; size--) {
                arrayList.remove(size - 1);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size2 = arrayList.size();
            int i5 = 0;
            while (i5 < size2) {
                Object obj = arrayList.get(i5);
                i5++;
                Map.Entry entry = (Map.Entry) obj;
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            ae.b().a("key_drds", linkedHashMap);
            this.f1249f = new LinkedHashMap();
            int iMin = Math.min(3, arrayList.size());
            for (int i6 = 0; i6 < iMin; i6++) {
                Map.Entry entry2 = (Map.Entry) arrayList.get(i6);
                this.f1249f.put((String) entry2.getKey(), (Integer) entry2.getValue());
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    public String a(boolean z6) {
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        String strB = b(z6);
        this.b = strB;
        if (!TextUtils.isEmpty(strB)) {
            ae.b().a("key_rdt2", strB);
        }
        return strB;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.b)) {
            return;
        }
        FlyLog.getInstance().d(androidx.exifinterface.media.a.r(new StringBuilder("rddd saveRD pre is "), this.b, " cur is ", str), new Object[0]);
        ae.b().a("key_rdt2", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(UUID uuid) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        byte[] bArr = new byte[16];
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = (7 - i5) * 8;
            bArr[i5] = (byte) (mostSignificantBits >>> i6);
            bArr[i5 + 8] = (byte) (leastSignificantBits >>> i6);
        }
        return bArr;
    }
}
