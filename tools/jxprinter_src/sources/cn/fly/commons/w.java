package cn.fly.commons;

import A3.AbstractC0157z;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.network.NetworkHelper;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.FileLocker;
import cn.fly.tools.utils.FlyRSA;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.ReflectHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f1490a = false;
    private static w b;
    private File c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f1491f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile List<Pair<Integer, String>> f1492g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicInteger f1493h = new AtomicInteger(100);
    private BigInteger d = new BigInteger("f53c224aefb38daa0825c1b8ea691b16d2e16db10880548afddd780c6670a091a11dafa954ea4a9483797fda1045d2693a08daa48cf9cedce1e8733b857304cb", 16);
    private BigInteger e = new BigInteger("27749621e6ca022469645faed16e8261acf6af822467382d55c24bb9bc02356ab16e76ddc799dc8ba6b4f110411996eeb63505c9dcf969d3fc085d712f0f1a9713b67aa1128d7cc41bda363afb0ec7ade60e542a4e22869395331cc0096de412034551e98bb2629ae1b7168b8bc82006d064ab335d8567283e70beb6a49e9423", 16);

    public static class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (cn.fly.commons.c.d()) {
                    DH.requester(FlySDK.getContext()).getDetailNetworkTypeForStatic().request(new DH.DHResponder() { // from class: cn.fly.commons.w.c.1
                        @Override // cn.fly.tools.utils.DH.DHResponder
                        public void onResponse(DH.DHResponse dHResponse) {
                            if (cn.fly.commons.a.l.a("004f[el9fg").equals(dHResponse.getDetailNetworkTypeForStatic())) {
                                return;
                            }
                            w.a().a(new cn.fly.tools.utils.i() { // from class: cn.fly.commons.w.c.1.1
                                @Override // cn.fly.tools.utils.i
                                public void a() {
                                    FlyLog.getInstance().d("[LGSM] UCLR", new Object[0]);
                                    w.b(1).a(new b());
                                    w.b(4).a(new b());
                                }
                            });
                        }
                    });
                } else {
                    FlyLog.getInstance().d("[LGSM] ULR Ck nt: FBDN", new Object[0]);
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
    }

    private w() {
    }

    public void b() {
        if (this.f1491f.compareAndSet(false, true)) {
            FlyLog.getInstance().d("[LGSM] Sd last", new Object[0]);
            ac.b.execute(new c());
        }
    }

    public static synchronized w a() {
        try {
            if (b == null) {
                b = new w();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static cn.fly.tools.a b(int i5) {
        return new cn.fly.tools.a(cn.fly.commons.a.l.a("005Gemeg_dh=fk"), cn.fly.commons.a.l.a("005Gemeg_dh=fk") + ProcessIdUtil.DEFAULT_PROCESSID + i5, 50);
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1495a;
        private int b;
        private String c;
        private String d;
        private List<String> e;

        private a() {
        }

        public a a(int i5, int i6, String str, String str2, List<String> list) {
            this.f1495a = i5;
            this.b = i6;
            this.c = str;
            this.d = str2;
            this.e = list;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                List<String> list = this.e;
                if (list != null && !list.isEmpty()) {
                    a(this.f1495a, this.b, this.c, this.e);
                }
                if (TextUtils.isEmpty(this.d)) {
                    return;
                }
                a(this.f1495a, this.b, this.c, this.d);
            } catch (Throwable th) {
                FlyLog.getInstance().w(th);
            }
        }

        private void a(final int i5, final int i6, final String str, final String str2) {
            FlyLog.getInstance().d("[LGSM] SLR: onL", new Object[0]);
            if (w.a().a(new cn.fly.tools.utils.i() { // from class: cn.fly.commons.w.a.1
                @Override // cn.fly.tools.utils.i
                public void a() {
                    FlyLog.getInstance().d("[LGSM] SLR: Ins", new Object[0]);
                    HashMap map = new HashMap();
                    map.put(cn.fly.commons.a.l.a("010BgjedfihlIg9ekgjejel8f"), Integer.valueOf(i5));
                    map.put(cn.fly.commons.a.l.a("006[gjedfigd9eTfk"), str);
                    map.put(cn.fly.commons.a.l.a("004j fdCkg"), Integer.valueOf(i6));
                    map.put(cn.fly.commons.a.l.a("005g?ekek=ej"), Long.valueOf(System.currentTimeMillis()));
                    String strEncode = URLEncoder.encode(str2);
                    if (TextUtils.isEmpty(strEncode)) {
                        strEncode = str2;
                    }
                    map.put(cn.fly.commons.a.l.a("003:eggjfk"), Base64.encodeToString(strEncode.getBytes("utf-8"), 2));
                    map.put(cn.fly.commons.a.l.a("005j_ejeg-g6gj"), 1);
                    FlyLog.getInstance().d("[LGSM] W l " + map, new Object[0]);
                    w.b(i6).a(HashonHelper.fromHashMap(map));
                }
            }) && aa.b()) {
                FlyLog.getInstance().d("[LGSM] SLR: U", new Object[0]);
                ac.b.execute(new c());
            }
        }

        private void a(final int i5, final int i6, final String str, final List<String> list) {
            FlyLog.getInstance().d("[LGSM] SLR: onL", new Object[0]);
            if (w.a().a(new cn.fly.tools.utils.i() { // from class: cn.fly.commons.w.a.2
                @Override // cn.fly.tools.utils.i
                public void a() {
                    FlyLog.getInstance().d("[LGSM] SLR: Ins", new Object[0]);
                    for (String str2 : list) {
                        HashMap map = new HashMap();
                        map.put(cn.fly.commons.a.l.a("010'gjedfihlVgNekgjejel<f"), Integer.valueOf(i5));
                        map.put(cn.fly.commons.a.l.a("006PgjedfigdReZfk"), str);
                        map.put(cn.fly.commons.a.l.a("004j7fd@kg"), Integer.valueOf(i6));
                        map.put(cn.fly.commons.a.l.a("005gCekek.ej"), Long.valueOf(System.currentTimeMillis()));
                        String strEncode = URLEncoder.encode(str2);
                        if (!TextUtils.isEmpty(strEncode)) {
                            str2 = strEncode;
                        }
                        map.put(cn.fly.commons.a.l.a("003Meggjfk"), Base64.encodeToString(str2.getBytes("utf-8"), 2));
                        map.put(cn.fly.commons.a.l.a("005j]ejegIgBgj"), 1);
                        FlyLog.getInstance().d("[LGSM] W l " + map, new Object[0]);
                        w.b(i6).a(HashonHelper.fromHashMap(map));
                    }
                }
            }) && aa.b()) {
                FlyLog.getInstance().d("[LGSM] SLR: U", new Object[0]);
                ac.b.execute(new c());
            }
        }
    }

    private void b(int i5, String str) {
        Intent intent = new Intent();
        intent.setPackage(cn.fly.commons.a.l.a("015df0emgj>ie)ek$g;gjedfiem7hLelfk"));
        intent.putExtra(cn.fly.commons.a.l.a("007ked=fiSe.fk3g"), FlySDK.getContext().getPackageName());
        intent.putExtra(cn.fly.commons.a.l.a("008k ekejelekejQj!fd"), i5);
        intent.putExtra("ver", FlySDK.SDK_VERSION_CODE);
        intent.putExtra(cn.fly.commons.a.l.a("003$eggjfk"), a(str));
        ReflectHelper.invokeInstanceMethod(FlySDK.getContextSafely(), cn.fly.commons.a.l.a("0130gjSgf2edgkekelDeZed<de3gj8j"), new Object[]{intent}, new Class[]{Intent.class}, 0);
    }

    public void a(int i5, String str, int i6, String str2) {
        FlyLog.getInstance().d("[LGSM] Sd curr", new Object[0]);
        new a().a(i6, i5, str, str2, null).run();
    }

    public void a(int i5, String str, int i6, List<String> list) {
        FlyLog.getInstance().d("[LGSM] Sd curr", new Object[0]);
        if (list != null) {
            new a().a(i6, i5, str, null, new ArrayList(list)).run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(final Runnable runnable) {
        if (this.c == null) {
            File file = new File(FlySDK.getContext().getFilesDir(), cn.fly.commons.a.l.a("0052emFhYelVdLfi"));
            this.c = file;
            if (!file.exists()) {
                try {
                    this.c.createNewFile();
                } catch (Throwable unused) {
                }
            }
        }
        return v.a(this.c, new u() { // from class: cn.fly.commons.w.1
            @Override // cn.fly.commons.u
            public boolean a(FileLocker fileLocker) {
                runnable.run();
                return false;
            }
        });
    }

    public static class b implements cn.fly.tools.a.InterfaceC0024a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArrayList<HashMap<String, Object>> f1498a;
        int b;
        String c;

        private b() {
            this.f1498a = new ArrayList<>();
            this.b = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private String b(String str) throws Throwable {
            ByteArrayInputStream byteArrayInputStream;
            Throwable th;
            byte[] bytes;
            GZIPOutputStream gZIPOutputStream;
            Throwable th2;
            try {
                bytes = str.getBytes();
                byteArrayInputStream = new ByteArrayInputStream(bytes);
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i5 = byteArrayInputStream.read(bArr, 0, 1024);
                                    if (i5 == -1) {
                                        gZIPOutputStream.flush();
                                        C0396r.a(gZIPOutputStream);
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        byteArrayOutputStream.flush();
                                        String strEncodeToString = Base64.encodeToString(byteArray, 2);
                                        C0396r.a(byteArrayOutputStream, byteArrayInputStream);
                                        return strEncodeToString;
                                    }
                                    gZIPOutputStream.write(bArr, 0, i5);
                                }
                            } catch (Throwable th3) {
                                th2 = th3;
                                C0396r.a(gZIPOutputStream);
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            gZIPOutputStream = null;
                            th2 = th4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bytes = null;
                        C0396r.a(bytes, byteArrayInputStream);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    C0396r.a(bytes, byteArrayInputStream);
                    throw th;
                }
            } catch (Throwable th7) {
                byteArrayInputStream = null;
                th = th7;
                bytes = null;
            }
        }

        @Override // cn.fly.tools.a.InterfaceC0024a
        public void a(String str) {
            FlyLog.getInstance().d(AbstractC0157z.n("[LGSM] ULL onRd ", str), new Object[0]);
            HashMap<String, Object> mapFromJson = HashonHelper.fromJson(str);
            try {
                this.b = Integer.parseInt(String.valueOf(mapFromJson.get(cn.fly.commons.a.l.a("010Ggjedfihl@g^ekgjejel%f"))));
            } catch (Throwable unused) {
            }
            this.c = (String) mapFromJson.get(cn.fly.commons.a.l.a("006Kgjedfigd:e+fk"));
            this.f1498a.add(mapFromJson);
        }

        @Override // cn.fly.tools.a.InterfaceC0024a
        public boolean a(DH.DHResponse dHResponse) {
            FlyLog.getInstance().d("[LGSM] ULL onUd", new Object[0]);
            HashMap<String, Object> mapA = a(dHResponse, this.b, this.c);
            mapA.put(cn.fly.commons.a.l.a("006gKekekeggjfk"), this.f1498a);
            try {
                String strB = b(HashonHelper.fromHashMap(mapA));
                this.f1498a.clear();
                HashMap<String, Object> map = new HashMap<>();
                map.put("m", strB);
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.readTimout = 10000;
                networkTimeOut.connectionTimeout = 10000;
                HashMap<String, String> map2 = new HashMap<>();
                map2.put(cn.fly.commons.a.l.a("0139flgjEg,ekilffedRgfjFej[jZfd"), ad.e());
                map2.put(cn.fly.commons.a.l.a("0048egelejed"), dHResponse.getODH());
                String str = j.a().a("el") + "/errlog";
                FlyLog.getInstance().d("[LGSM] ULL onUd: Req", new Object[0]);
                String strHttpPostNew = new NetworkHelper().httpPostNew(str, map, map2, networkTimeOut);
                FlyLog.getInstance().d("[LGSM] ULL onUd: ".concat("Resp(" + str + "): " + strHttpPostNew), new Object[0]);
                Object obj = HashonHelper.fromJson(strHttpPostNew).get(cn.fly.commons.a.l.a("006Dgj=jejBehgj"));
                return (obj != null ? ((Integer) obj).intValue() : 0) == 200;
            } catch (Throwable th) {
                FlyLog.getInstance().d("[LGSM] ULL onUd: E", new Object[0]);
                FlyLog.getInstance().d(th);
            }
        }

        private HashMap<String, Object> a(DH.DHResponse dHResponse, int i5, String str) {
            HashMap<String, Object> map = new HashMap<>();
            map.put(cn.fly.commons.a.l.a("003 fiFg,fd"), q.a());
            map.put(cn.fly.commons.a.l.a("004=edehejed"), f.a((FlyProduct) null));
            map.put(cn.fly.commons.a.l.a("004khej"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
            map.put(cn.fly.commons.a.l.a("003)gjedfi"), str);
            map.put(cn.fly.commons.a.l.a("006Egjedfiee@g*ek"), Integer.valueOf(i5));
            map.put(cn.fly.commons.a.l.a("007ekkfe0eg3g"), dHResponse.getAppName());
            map.put(cn.fly.commons.a.l.a("006ekkk'fifk"), DH.SyncMtd.getPackageName());
            map.put(cn.fly.commons.a.l.a("006ekkKee5g7ek"), String.valueOf(DH.SyncMtd.getAppVersion()));
            map.put(cn.fly.commons.a.l.a("005.egeled*gh"), DH.SyncMtd.getModelForFly());
            if (cn.fly.commons.c.c()) {
                map.put(cn.fly.commons.a.l.a("008Ued)gJeeej2dg)ejed"), dHResponse.getDeviceKey());
            }
            map.put(cn.fly.commons.a.l.a("006 gjfdgjeeTgOek"), String.valueOf(DH.SyncMtd.getOSVersionIntForFly()));
            map.put(cn.fly.commons.a.l.a("011fgjWghelekfi3j2fdKkg"), dHResponse.getDetailNetworkTypeForStatic());
            return map;
        }
    }

    public int a(int i5, String str) {
        if (FlySDK.getContextSafely() == null) {
            return 0;
        }
        if (!f1490a) {
            if (this.f1493h.get() < 0) {
                return 0;
            }
            if (this.f1493h.getAndDecrement() > 0) {
                this.f1492g.add(new Pair<>(Integer.valueOf(i5), str));
                return 0;
            }
            this.f1492g.clear();
            return 0;
        }
        if (!this.f1492g.isEmpty()) {
            synchronized (this.f1492g) {
                try {
                    if (!this.f1492g.isEmpty()) {
                        for (Pair<Integer, String> pair : this.f1492g) {
                            b(((Integer) pair.first).intValue(), (String) pair.second);
                        }
                        this.f1492g.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        b(i5, str);
        return 0;
    }

    private String a(String str) {
        DataOutputStream dataOutputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrC = C0396r.c();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    byte[] bArrEncode = new FlyRSA(1024).encode(bArrC, this.d, this.e);
                    dataOutputStream.writeInt(bArrEncode.length);
                    dataOutputStream.write(bArrEncode);
                    byte[] bArrAES128Encode = Data.AES128Encode(bArrC, str.getBytes("utf-8"));
                    dataOutputStream.writeInt(bArrAES128Encode.length);
                    dataOutputStream.write(bArrAES128Encode);
                    dataOutputStream.flush();
                    C0396r.a(dataOutputStream, byteArrayOutputStream);
                    return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                } catch (Throwable th) {
                    th = th;
                    C0396r.a(dataOutputStream, byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
            }
        } catch (Throwable th3) {
            FlyLog.getInstance().d(th3);
            return null;
        }
    }
}
