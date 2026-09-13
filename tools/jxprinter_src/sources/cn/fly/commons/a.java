package cn.fly.commons;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.lifecycle.CoroutineLiveDataKt;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.network.NetCommunicator;
import cn.fly.tools.network.NetworkHelper;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.FileLocker;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.ResHelper;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.math3.optimization.direct.CMAESOptimizer;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
final class a {
    private static final a d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1201a = false;
    private final byte[] b = new byte[0];
    private final byte[] c = new byte[0];

    private a() {
    }

    private String g() {
        return m.a("016JhkfegjfnRe(fmfhfhfmNgfl9fnhkfegj");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File h() {
        return ResHelper.getDataCacheFile(FlySDK.getContext(), n.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        ae aeVarB = ae.b();
        String str = ae.f1267a;
        long jB = aeVarB.b(str, -1L);
        if (jB != -1) {
            return System.currentTimeMillis() >= (((Long) cn.fly.commons.c.a(m.a("005*fefkglAfl"), 2592000L)).longValue() * 1000) + jB;
        }
        ae.b().a(str, System.currentTimeMillis());
        return false;
    }

    public synchronized String e() {
        String strD;
        Throwable th;
        try {
            strD = d();
            try {
                if (!TextUtils.isEmpty(strD) && !TextUtils.equals(AbstractC1127c.NULL, strD)) {
                    return strD;
                }
                C0011a c0011aA = new b().a();
                if (c0011aA != null) {
                    strD = c0011aA.c();
                }
            } catch (Throwable th2) {
                th = th2;
                FlyLog.getInstance().d(th);
            }
        } catch (Throwable th3) {
            strD = null;
            th = th3;
        }
        return strD;
    }

    public HashMap<String, Object> f() {
        synchronized (this.c) {
            try {
                final byte[][] bArr = new byte[1][];
                try {
                    v.a(v.a(v.c), new u() { // from class: cn.fly.commons.a.2
                        @Override // cn.fly.commons.u
                        public boolean a(FileLocker fileLocker) {
                            bArr[0] = ResHelper.readFromFileNoCompress(a.this.h());
                            return false;
                        }
                    });
                    if (bArr[0] != null) {
                        return a(DH.SyncMtd.getModelForFly(), bArr[0]);
                    }
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                }
                return new HashMap<>();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final List<String> f1207a = Arrays.asList("4c5f81a0-4728-476f-a57f-b46fa44f07d3", "f6af99e2-2b64-4eb6-aba6-4d44fb935939", "00000000-0000-0000-0000-000000000000");
        private List<String> b;

        private b() {
        }

        private void c() {
            c cVarB = FlySDK.SDK_VERSION_CODE + 30 >= d() ? a.b() : e();
            if (cVarB != null && cVarB.c() != null) {
                this.b = cVarB.c();
            }
            if (this.b == null) {
                this.b = f1207a;
            }
        }

        private int d() {
            return Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        }

        private c e() {
            try {
                NetworkHelper networkHelper = new NetworkHelper();
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.connectionTimeout = 2000;
                networkTimeOut.readTimout = 5000;
                String strHttpPostNew = networkHelper.httpPostNew(j.a().a("dg") + "/getDuidBlacklist", null, null, networkTimeOut);
                HashMap mapFromJson = HashonHelper.fromJson(strHttpPostNew);
                if (mapFromJson != null && !mapFromJson.isEmpty()) {
                    if (!"200".equals(String.valueOf(mapFromJson.get(m.a("006GhkOkfkUfihk"))))) {
                        throw new Throwable("RS is illegal: " + strHttpPostNew);
                    }
                    String strValueOf = String.valueOf(mapFromJson.get(m.a("004=feRfkf")));
                    if (!TextUtils.isEmpty(strValueOf)) {
                        c cVarA = c.a(Data.AES128Decode(f(), Base64.decode(strValueOf, 0)));
                        a.b(cVarA);
                        return cVarA;
                    }
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
            return null;
        }

        private String f() {
            String[] strArr = {"QvxJJ", "FYsAX", "cvWe", "MqlWJL"};
            return strArr[1] + strArr[3] + new String[]{"akuRE", "wbMqR", "uBs", "CDpnc"}[3];
        }

        public C0011a a() {
            c();
            return b();
        }

        public C0011a b() {
            String strByteToHex;
            try {
                String modelForFly = DH.SyncMtd.getModelForFly();
                String strTrim = modelForFly == null ? null : modelForFly.trim();
                boolean z6 = false;
                String strM = cn.fly.tools.b.c.a(FlySDK.getContext()).d().m(false);
                if (TextUtils.isEmpty(strM)) {
                    strM = cn.fly.tools.b.c.a(FlySDK.getContext()).d().j();
                    if (TextUtils.isEmpty(strM) || this.b.contains(strM)) {
                        strM = null;
                    } else {
                        FlyLog.getInstance().d("ddsrc: " + m.a("002fAfe"), new Object[0]);
                    }
                } else {
                    FlyLog.getInstance().d("ddsrc: ".concat("dd"), new Object[0]);
                }
                if (TextUtils.isEmpty(strM)) {
                    strM = a(SystemClock.elapsedRealtime());
                    FlyLog.getInstance().d("ddsrc: " + m.a("002Jfife"), new Object[0]);
                    z6 = true;
                }
                String str = strTrim + ParameterizedMessage.ERROR_MSG_SEPARATOR + strM + ":null:null";
                try {
                    strByteToHex = !TextUtils.isEmpty(str) ? Data.byteToHex(Data.SHA1(str)) : null;
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                }
                if (z6) {
                    strByteToHex = "s_" + strByteToHex;
                }
                C0011a c0011a = new C0011a(strByteToHex, System.currentTimeMillis(), "client", 0L, Base64.encodeToString(str.getBytes(), 2));
                a.b(c0011a);
                return c0011a;
            } catch (Throwable th2) {
                FlyLog.getInstance().d(th2);
                return null;
            }
        }

        private String a(long j6) {
            String string = UUID.randomUUID().toString();
            return TextUtils.isEmpty(string) ? b(j6) : string;
        }

        private String b(long j6) {
            ByteArrayOutputStream byteArrayOutputStream;
            DataOutputStream dataOutputStream;
            try {
                long jNextLong = new SecureRandom().nextLong();
                long jCurrentTimeMillis = j6 + System.currentTimeMillis();
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    try {
                        dataOutputStream.writeLong(jNextLong);
                        dataOutputStream.writeLong(jCurrentTimeMillis);
                        String strByteToHex = Data.byteToHex(byteArrayOutputStream.toByteArray());
                        C0396r.a(dataOutputStream, byteArrayOutputStream);
                        return strByteToHex;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            FlyLog.getInstance().d(th);
                            C0396r.a(dataOutputStream, byteArrayOutputStream);
                            return null;
                        } catch (Throwable th2) {
                            C0396r.a(dataOutputStream, byteArrayOutputStream);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                dataOutputStream = null;
            }
        }
    }

    public static c b() {
        return c.a(ae.b().b("key_duid_param_blacklist", (String) null));
    }

    public static C0011a c() {
        try {
            String strB = ae.b().b("key_duid_entity", (String) null);
            if (!TextUtils.isEmpty(strB)) {
                return C0011a.a(Data.AES128Decode(DH.SyncMtd.getModelForFly(), Base64.decode(strB, 0)));
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
        return null;
    }

    public synchronized String d() {
        C0011a c0011aC = c();
        if (c0011aC == null || TextUtils.isEmpty(c0011aC.c())) {
            return null;
        }
        return c0011aC.c();
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<String> f1208a;
        private List<String> b;

        public c(List<String> list, List<String> list2) {
            this.f1208a = list;
            this.b = list2;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0027  */
        /* JADX WARN: Code duplicated, block: B:23:0x0042  */
        public static c a(String str) {
            List<String> listB;
            List<String> listB2;
            if (!TextUtils.isEmpty(str)) {
                try {
                    HashMap mapFromJson = HashonHelper.fromJson(str);
                    Object obj = mapFromJson.get("idfas");
                    if (obj == null) {
                        listB = null;
                    } else if (obj instanceof String) {
                        listB = b((String) obj);
                    } else if (obj instanceof List) {
                        listB = (List) obj;
                    } else {
                        listB = null;
                    }
                    Object obj2 = mapFromJson.get("oiid");
                    if (obj2 == null) {
                        listB2 = null;
                    } else if (obj2 instanceof String) {
                        listB2 = b((String) obj2);
                    } else if (obj2 instanceof List) {
                        listB2 = (List) obj2;
                    } else {
                        listB2 = null;
                    }
                    return new c(listB, listB2);
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                }
            }
            return null;
        }

        public HashMap<String, Object> b() {
            HashMap<String, Object> map = new HashMap<>();
            map.put("idfas", this.f1208a);
            map.put("oiid", this.b);
            return map;
        }

        public List<String> c() {
            return this.f1208a;
        }

        public List<String> d() {
            return this.b;
        }

        private static List<String> b(String str) {
            String[] strArrSplit;
            if (!TextUtils.isEmpty(str) && (strArrSplit = str.split(",")) != null && strArrSplit.length > 0) {
                return new ArrayList(Arrays.asList(strArrSplit));
            }
            return new ArrayList();
        }

        public String a() {
            return HashonHelper.fromHashMap(b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c cVar) {
        ae.b().a("key_duid_param_blacklist", cVar != null ? cVar.a() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(C0011a c0011a) {
        String strA;
        if (c0011a != null) {
            try {
                strA = c0011a.a();
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
                return;
            }
        } else {
            strA = null;
        }
        ae.b().a("key_duid_entity", Base64.encodeToString(Data.EncodeNoPadding(DH.SyncMtd.getModelForFly(), strA), 0));
    }

    public static a a() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(String str, HashMap<String, Object> map) {
        String strFromHashMap = HashonHelper.fromHashMap(map);
        try {
            return Data.AES128Encode(str, strFromHashMap);
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return strFromHashMap.getBytes();
        }
    }

    public void a(final FlyProduct flyProduct, final cn.fly.tools.utils.d<Void> dVar) {
        ac.f1261a.execute(new cn.fly.tools.utils.i() { // from class: cn.fly.commons.a.1
            @Override // cn.fly.tools.utils.i
            public void a() {
                if (cn.fly.commons.c.a(m.a("0027fefk"))) {
                    if (!cn.fly.commons.c.e()) {
                        int i5 = 0;
                        while (i5 < 5) {
                            i5++;
                            try {
                                Thread.sleep(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                                if (cn.fly.commons.c.e()) {
                                    break;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    if (cn.fly.commons.c.e()) {
                        FlyLog.getInstance().d("di init", new Object[0]);
                        DH.RequestBuilder dm = DH.requester(FlySDK.getContext()).getAdvertisingID().getCarrierStrict(false).getMemoryInfo().getSizeInfo().cx().isRooted().getDeviceType().checkPad().getScreenSize().getDetailNetworkTypeForStatic().getODH().getOD().getAppLastUpdateTime().getMIUIVersionForFly().getInnerAppLanguage().getGrammaticalGender().getDM(false);
                        if (((Integer) cn.fly.commons.c.a("ndi", 0)).intValue() == 1) {
                            dm.getLATime(m.a("028nBfe*fkfn.hkgehk0kh(fh6nifWhk[k2jmHjhf;feEh3flfn<k^gkPk")).getLATime(m.a("035nAfeMfkfnOhkgehkVkh(fh3n^hi4fkejiXfkhk@k'fjhk3hkkNfkMg5glhkfngkfh.i")).getLATime(m.a("028n[feQfkfn!hkgehkHkhQfh$ni6fm:e3gjhk3hkkGfk>gZglhkfnfehh")).getLATime(m.a("005n;feWfkf")).getLATime(m.a("012n(feYfkfnYhkgehk_kh+fh")).getLATime(m.a("018nUfeNfkfn7hkgehkKkh2fh4n'fihk=hLflhk")).getLATime(m.a("045nNfe5fkfnPhkgehk+kh,fh<n<fihk3hCflhkOn'hj*n.hk;hkkFfk$g]glhkfjghfkRg=glQhDfl?lMflfk gkOfngkfhOi"));
                        }
                        dm.request(new DH.DHResponder() { // from class: cn.fly.commons.a.1.1
                            @Override // cn.fly.tools.utils.DH.DHResponder
                            public void onResponse(DH.DHResponse dHResponse) {
                                try {
                                    synchronized (a.this.b) {
                                        try {
                                            String strA = a.this.a(f.f1426a, dHResponse);
                                            HashMap<String, Object> mapF = a.this.f();
                                            boolean zA = a.this.a(mapF, dHResponse);
                                            boolean zI = a.this.i();
                                            a.this.f1201a = zA || zI;
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            boolean zA2 = a.this.a(mapF, flyProduct, dHResponse);
                                            FlyLog.getInstance().d("map: " + mapF + "\nisCh: " + zA + ", isG: " + zI + ", isReg: " + zA2, ", udif:" + a.this.f1201a);
                                            if (a.this.f1201a) {
                                                if (TextUtils.isEmpty(strA)) {
                                                    strA = f.f1426a;
                                                }
                                                a.this.a(mapF, strA, dHResponse);
                                            }
                                            if (zA || zA2) {
                                                a.this.a(mapF);
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                    dVar.a(null);
                                } catch (Throwable th2) {
                                    dVar.a(null);
                                    throw th2;
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, DH.DHResponse dHResponse) {
        try {
            if (!cn.fly.commons.c.d()) {
                return null;
            }
            C0011a c0011aC = c();
            if (c0011aC != null && !c0011aC.a(ae.b().b("key_request_duid_time", 0L)) && !ab.a().d()) {
                return null;
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put(m.a("004lifk"), 1);
            map.put(m.a("005)fhfmfeDhi"), DH.SyncMtd.getModelForFly());
            map.put(m.a("007>ghRfek%fmflge"), DH.SyncMtd.getManufacturerForFly());
            map.put("admt", dHResponse.getAdvertisingID());
            map.put("oamt", cn.fly.tools.b.c.a(FlySDK.getContext()).d().ao());
            map.put("btt", Long.valueOf(SystemClock.elapsedRealtime()));
            map.put(m.a("004@flfefkfe"), ab.a().e());
            map.put("v", ab.a().b());
            map.put(m.a("004lFfifkfe"), ab.a().f());
            map.put(m.a("005Wfeflfhfkfe"), dHResponse.getDM());
            map.put(m.a("008kQfm[lBfjfeflfhhk"), ab.a().i());
            if (c0011aC == null) {
                map.put(m.a("004-fefifkfe"), str);
                map.put("genType", "common");
            } else {
                map.put(m.a("004Sfefifkfe"), c0011aC.c());
                map.put("gt", Long.valueOf(c0011aC.d()));
                map.put("genType", c0011aC.e());
                map.put("expTime", Long.valueOf(c0011aC.f()));
                map.put(m.a("002WglUl"), c0011aC.g());
            }
            HashMap map2 = (HashMap) new NetCommunicator(1024, "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd").requestWithoutEncode(true, null, map, j.a().a("dg") + "/v4/dgen", true);
            if (map2 != null) {
                ae.b().a("key_request_duid_time", System.currentTimeMillis());
                String str2 = (String) map2.get(m.a("004)flfefkfe"));
                if (!TextUtils.isEmpty(str2)) {
                    ab.a().a(str2);
                }
                C0011a c0011aA = C0011a.a(HashonHelper.fromHashMap(map2));
                if (c0011aA != null) {
                    b(c0011aA);
                    return c0011aA.c();
                }
            }
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
        }
        return null;
    }

    /* JADX INFO: renamed from: cn.fly.commons.a$a, reason: collision with other inner class name */
    public static class C0011a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1206a;
        private long b;
        private String c;
        private long d;
        private String e;

        public C0011a(String str, long j6, String str2, long j7, String str3) {
            this.f1206a = str;
            this.b = j6;
            this.c = str2;
            this.d = j7;
            this.e = str3;
        }

        /* JADX WARN: Code duplicated, block: B:33:0x007e  */
        public static C0011a a(String str) {
            long jIntValue;
            if (!TextUtils.isEmpty(str)) {
                try {
                    HashMap mapFromJson = HashonHelper.fromJson(str);
                    String str2 = (String) mapFromJson.get(m.a("004@fefifkfe"));
                    if (TextUtils.isEmpty(str2) || TextUtils.equals(AbstractC1127c.NULL, str2)) {
                        str2 = null;
                    }
                    String str3 = (String) mapFromJson.get("genType");
                    String str4 = (TextUtils.isEmpty(str3) || TextUtils.equals(AbstractC1127c.NULL, str3)) ? null : str3;
                    String str5 = (String) mapFromJson.get(m.a("002Sgl!l"));
                    String str6 = (TextUtils.isEmpty(str5) || TextUtils.equals(AbstractC1127c.NULL, str5)) ? null : str5;
                    Object obj = mapFromJson.get("gt");
                    long jIntValue2 = 0;
                    if (obj == null) {
                        jIntValue = 0;
                    } else if (obj instanceof Long) {
                        jIntValue = ((Long) obj).longValue();
                    } else if (obj instanceof Integer) {
                        jIntValue = ((Integer) obj).intValue();
                    } else {
                        jIntValue = 0;
                    }
                    Object obj2 = mapFromJson.get("expTime");
                    if (obj2 != null) {
                        if (obj2 instanceof Long) {
                            jIntValue2 = ((Long) obj2).longValue();
                        } else if (obj2 instanceof Integer) {
                            jIntValue2 = ((Integer) obj2).intValue();
                        }
                    }
                    return new C0011a(str2, jIntValue, str4, jIntValue2, str6);
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                }
            }
            return null;
        }

        public HashMap<String, Object> b() {
            HashMap<String, Object> map = new HashMap<>();
            map.put(m.a("0042fefifkfe"), this.f1206a);
            map.put("gt", Long.valueOf(this.b));
            map.put("genType", this.c);
            map.put("expTime", Long.valueOf(this.d));
            map.put(m.a("002*gl>l"), this.e);
            return map;
        }

        public String c() {
            return this.f1206a;
        }

        public long d() {
            return this.b;
        }

        public String e() {
            return this.c;
        }

        public long f() {
            return this.d;
        }

        public String g() {
            return this.e;
        }

        public String a() {
            return HashonHelper.fromHashMap(b());
        }

        public boolean a(long j6) {
            long j7 = this.d;
            return j7 == 0 || (j7 * 1000) + j6 <= System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(HashMap<String, Object> map, FlyProduct flyProduct, DH.DHResponse dHResponse) {
        if (flyProduct == null) {
            flyProduct = new FlyProduct() { // from class: cn.fly.commons.Authorizer$2
                @Override // cn.fly.commons.FlyProduct
                public String getProductTag() {
                    return m.a("006%gfijjejeijgi");
                }

                @Override // cn.fly.commons.FlyProduct
                public int getSdkver() {
                    return FlySDK.SDK_VERSION_CODE;
                }
            };
        }
        boolean z6 = false;
        try {
            HashMap map2 = (HashMap) map.get(m.a("007fllQgg.g,ghfm"));
            if (map2 == null) {
                map2 = new HashMap();
                map.put(m.a("007fll;gg gXghfm"), map2);
                z6 = true;
            }
            HashMap map3 = (HashMap) map2.get(DH.SyncMtd.getPackageName());
            String str = map3 != null ? (String) map3.get(flyProduct.getProductTag()) : null;
            String strA = q.a();
            if ((str == null || !str.equals(strA)) && a(flyProduct, map, dHResponse)) {
                return true;
            }
            return z6;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return z6;
        }
    }

    private boolean a(FlyProduct flyProduct, HashMap<String, Object> map, DH.DHResponse dHResponse) {
        if (!cn.fly.commons.c.d()) {
            return false;
        }
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put(m.a("007lXflfmfefiQek"), flyProduct.getProductTag());
        C0011a c0011aC = c();
        String strC = c0011aC != null ? c0011aC.c() : null;
        String strValueOf = String.valueOf(DH.SyncMtd.getPackageName());
        map2.put(m.a("006fllDgjDh^ge"), q.a());
        map2.put(m.a("004Qfefifkfe"), strC);
        map2.put(m.a("006flll(gjgl"), strValueOf);
        map2.put(m.a("006fllJff,h7fl"), String.valueOf(DH.SyncMtd.getAppVersion()));
        map2.put(m.a("006IhkfegjffEhEfl"), String.valueOf(flyProduct.getSdkver()));
        map2.put(m.a("007ghk=hifmflgj"), String.valueOf(dHResponse.getDetailNetworkTypeForStatic()));
        String str = j.a().a("dg") + m.a("006nHfehkfkglBg");
        HashMap<String, String> map3 = new HashMap<>();
        map3.put(m.a("013 gmhkShHfljmggfe3hgkPfk0k4ge"), ad.e());
        map3.put(m.a("004Cfhfmfkfe"), dHResponse.getODH());
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 10000;
        HashMap mapFromJson = HashonHelper.fromJson(new NetworkHelper().httpPostNew(str, map2, map3, networkTimeOut));
        if (m.a("004k%flfi8h").equals(String.valueOf(mapFromJson.get(m.a("004]flHhKfi@l"))))) {
            this.f1201a = true;
        }
        if (!"200".equals(String.valueOf(mapFromJson.get(m.a("006?hk6kfk<fihk"))))) {
            return false;
        }
        HashMap map4 = (HashMap) map.get(m.a("007fll?ggZgZghfm"));
        HashMap map5 = (HashMap) map4.get(strValueOf);
        if (map5 == null) {
            map5 = new HashMap();
        }
        map5.put(flyProduct.getProductTag(), q.a());
        map4.put(strValueOf, map5);
        map.put(m.a("007fll@ggNg$ghfm"), map4);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, Object> map, String str, DH.DHResponse dHResponse) {
        try {
            if (cn.fly.commons.c.d()) {
                HashMap map2 = (HashMap) map.get(m.a("0107feLh0fffkYehXgg%g_ghfm"));
                HashMap map3 = new HashMap();
                map3.put(m.a("005kCfmgj^hg"), af.a().b());
                for (Map.Entry entry : map2.entrySet()) {
                    map3.put(entry.getKey(), entry.getValue());
                }
                try {
                    map3.put(m.a("007efKflflfkDh0fl"), Integer.valueOf(Integer.parseInt(String.valueOf(map3.get(m.a("007ef)flflfkCh4fl"))))));
                } catch (Throwable unused) {
                }
                map3.put(m.a("004Rfefifkfe"), str);
                HashMap<String, Long> memoryInfo = dHResponse.getMemoryInfo();
                HashMap<String, HashMap<String, Long>> sizeInfo = dHResponse.getSizeInfo();
                if (memoryInfo != null) {
                    map3.put(m.a("003Jfl.f1fh"), memoryInfo.get(m.a("005k=fmKkfi")));
                }
                if (sizeInfo != null) {
                    HashMap<String, Long> map4 = sizeInfo.get(m.a("006$hkfeIefPflfe"));
                    if (map4 != null) {
                        map3.put(m.a("013$hkfeJef!flfegnSkSfmfl*f;glRh"), map4.get(m.a("005k4fm+kfi")));
                    }
                    HashMap<String, Long> map5 = sizeInfo.get(m.a("004Qfe4fkf"));
                    if (map5 != null) {
                        map3.put(m.a("011%feVfkf,gn*k8fmflEfHgl=h"), map5.get(m.a("005kLfmUkfi")));
                    }
                }
                try {
                    String str2 = (String) map3.get("fsuud");
                    if (!TextUtils.isEmpty(str2)) {
                        map3.put("fsuud", HashonHelper.fromJson(str2));
                    }
                } catch (Throwable unused2) {
                }
                map3.put(m.a("0068flfmfhggfhgl"), dHResponse.getMIUIVersionForFly());
                String strEncodeToString = Base64.encodeToString(Data.AES128Encode(g(), HashonHelper.fromHashMap(map3)), 2);
                HashMap<String, Object> map6 = new HashMap<>();
                map6.put("m", strEncodeToString);
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.readTimout = CMAESOptimizer.DEFAULT_MAXITERATIONS;
                networkTimeOut.connectionTimeout = CMAESOptimizer.DEFAULT_MAXITERATIONS;
                NetworkHelper networkHelper = new NetworkHelper();
                String str3 = j.a().a("dg") + m.a("006nZfefkHgOghfm");
                HashMap<String, String> map7 = new HashMap<>();
                map7.put(m.a("0138gmhkIh3fljmggfeVhgk fk>k]ge"), ad.e());
                map7.put(m.a("004+fhfmfkfe"), cn.fly.tools.b.c.a(FlySDK.getContext()).d().ap());
                if ("200".equals(String.valueOf(HashonHelper.fromJson(networkHelper.httpPostNew(str3, map6, map7, networkTimeOut)).get(m.a("006Phk.kfkFfihk"))))) {
                    ae.b().a(ae.f1267a, System.currentTimeMillis());
                }
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    public void a(final HashMap<String, Object> map) {
        if (map != null) {
            synchronized (this.c) {
                v.a(v.a(v.c), new u() { // from class: cn.fly.commons.a.3
                    @Override // cn.fly.commons.u
                    public boolean a(FileLocker fileLocker) {
                        ResHelper.writeToFileNoCompress(a.this.h(), a.b(DH.SyncMtd.getModelForFly(), map));
                        return false;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:114:0x0317  */
    public boolean a(HashMap<String, Object> map, DH.DHResponse dHResponse) {
        boolean z6;
        boolean z7;
        int i5;
        boolean z8;
        boolean z9 = true;
        if (map == null) {
            map = new HashMap<>();
            z6 = true;
        } else {
            z6 = false;
        }
        HashMap map2 = (HashMap) map.get(m.a("0107feThHfffk=ehDggLg?ghfm"));
        if (map2 == null) {
            map2 = new HashMap();
            map.put(m.a("010MfeDh6fffkRehYggAg>ghfm"), map2);
            z6 = true;
        }
        Object obj = map2.get("admt");
        String advertisingID = dHResponse.getAdvertisingID();
        if (advertisingID == null || advertisingID.equals(obj)) {
            z7 = false;
        } else {
            map2.put("admt", advertisingID);
            z7 = true;
        }
        Object obj2 = map2.get(m.a("004>fmLfIfkfe"));
        String od = dHResponse.getOD();
        if ((obj2 != null || TextUtils.isEmpty(od)) && (obj2 == null || TextUtils.isEmpty(od) || String.valueOf(obj2).equals(od))) {
            i5 = 0;
            z8 = z7;
        } else {
            map2.put(m.a("004Wfm:f?fkfe"), od);
            z8 = true;
            i5 = 1;
        }
        Object obj3 = map2.get(m.a("004Uflfefkfe"));
        String strC = ab.a().c();
        if ((obj3 == null && !TextUtils.isEmpty(strC)) || (obj3 != null && !TextUtils.isEmpty(strC) && !String.valueOf(obj3).equals(strC))) {
            map2.put(m.a("004Aflfefkfe"), strC);
            i5 |= 2;
            z8 = true;
        }
        Object obj4 = map2.get(m.a("005Yfeflfhfkfe"));
        String dm = dHResponse.getDM();
        if ((obj4 == null && !TextUtils.isEmpty(dm)) || (obj4 != null && !TextUtils.isEmpty(dm) && !String.valueOf(obj4).equals(dm))) {
            map2.put(m.a("005>feflfhfkfe"), dm);
            i5 |= 4;
            z8 = true;
        }
        Object obj5 = map2.get(m.a("004lYfifkfe"));
        String strF = ab.a().f();
        if ((obj5 == null && !TextUtils.isEmpty(strF)) || (obj5 != null && !TextUtils.isEmpty(strF) && !String.valueOf(obj5).equals(strF))) {
            map2.put(m.a("004l$fifkfe"), strF);
            i5 |= 8;
            z8 = true;
        }
        Object obj6 = map2.get("v");
        String strB = ab.a().b();
        if ((obj6 == null && !TextUtils.isEmpty(strB)) || (obj6 != null && !TextUtils.isEmpty(strB) && !String.valueOf(obj6).equals(strB))) {
            map2.put("v", strB);
            z8 = true;
        }
        map2.put("cid_modify", Integer.valueOf(i5));
        if (z8) {
            z6 = true;
        }
        Object obj7 = map2.get(m.a("0053fhfmfe_hi"));
        String modelForFly = DH.SyncMtd.getModelForFly();
        if (modelForFly != null && !modelForFly.equals(obj7)) {
            map2.put(m.a("005=fhfmfeBhi"), modelForFly);
            z6 = true;
        }
        Object obj8 = map2.get(m.a("007Ggh*fek]fmflge"));
        String manufacturerForFly = DH.SyncMtd.getManufacturerForFly();
        if (manufacturerForFly != null && !manufacturerForFly.equals(obj8)) {
            map2.put(m.a("007$ghJfekPfmflge"), manufacturerForFly);
            z6 = true;
        }
        Object obj9 = map2.get(m.a("007efZflflfk$h$fl"));
        String carrierStrict = dHResponse.getCarrierStrict(new int[0]);
        if (carrierStrict != null && !carrierStrict.equals(obj9)) {
            map2.put(m.a("007ef flflfkPhDfl"), carrierStrict);
            z6 = true;
        }
        Object obj10 = map2.get(m.a("006DhkgehkffShGfl"));
        String oSVersionNameForFly = DH.SyncMtd.getOSVersionNameForFly();
        if (oSVersionNameForFly != null && !oSVersionNameForFly.equals(obj10)) {
            map2.put(m.a("0068hkgehkffLh fl"), oSVersionNameForFly);
            z6 = true;
        }
        Object obj11 = map2.get(m.a("0021gk@l"));
        boolean zCx = dHResponse.cx();
        if (obj11 == null || !String.valueOf(zCx ? 1 : 0).equals(String.valueOf(obj11))) {
            map2.put(m.a("002Mgk$l"), Integer.valueOf(zCx ? 1 : 0));
            z6 = true;
        }
        Object obj12 = map2.get(m.a("007Zhhfl3hf9gj?h(fe"));
        boolean zIsRooted = dHResponse.isRooted();
        map2.put(m.a("007!hhflChf6gj;h.fe"), Boolean.valueOf(zIsRooted));
        if ((obj12 == null && zIsRooted) || (obj12 != null && !String.valueOf(obj12).equals(String.valueOf(zIsRooted)))) {
            z6 = true;
        }
        String strValueOf = String.valueOf(map2.get("prelangmt"));
        String strValueOf2 = String.valueOf(dHResponse.getInnerAppLanguage());
        if (!TextUtils.equals(strValueOf, strValueOf2)) {
            map2.put("prelangmt", strValueOf2);
            z6 = true;
        }
        Object obj13 = map2.get("gramgendt");
        int grammaticalGender = dHResponse.getGrammaticalGender();
        if (obj13 == null || !TextUtils.equals(String.valueOf(obj13), String.valueOf(grammaticalGender))) {
            map2.put("gramgendt", Integer.valueOf(grammaticalGender));
            z6 = true;
        }
        if (((Integer) cn.fly.commons.c.a("ndi", 0)).intValue() == 1) {
            String str = (String) map2.get("fsuud");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("fbt", Long.valueOf(dHResponse.getLATime(0)));
            linkedHashMap.put("fwt", Long.valueOf(dHResponse.getLATime(1)));
            linkedHashMap.put("fls", Long.valueOf(dHResponse.getLATime(2)));
            linkedHashMap.put("fda", Long.valueOf(dHResponse.getLATime(3)));
            linkedHashMap.put("fsm", Long.valueOf(dHResponse.getLATime(4)));
            linkedHashMap.put("fus", Long.valueOf(dHResponse.getLATime(5)));
            linkedHashMap.put("fsf", Long.valueOf(dHResponse.getLATime(6)));
            String strFromHashMap = HashonHelper.fromHashMap(linkedHashMap);
            if (TextUtils.equals(str, strFromHashMap)) {
                z9 = z6;
            } else {
                map2.put("fsuud", strFromHashMap);
            }
        } else {
            z9 = z6;
        }
        map2.put(m.a("004lifk"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
        map2.put(m.a("010Ffe,h-fffk,eh1hege lh"), dHResponse.getDeviceType());
        map2.put(m.a("003lfTfe"), Integer.valueOf(dHResponse.checkPad() ? 1 : 0));
        map2.put(m.a("010Vhk@eLfl;hhgEhkfkifWh"), dHResponse.getScreenSize());
        HashMap<String, Object> mapA = cn.fly.commons.c.d.a(FlySDK.getContext());
        if (mapA != null && mapA.size() > 0) {
            map2.putAll(mapA);
        }
        return z9;
    }

    private static HashMap<String, Object> a(String str, byte[] bArr) {
        return HashonHelper.fromJson(Data.AES128Decode(str, bArr));
    }
}
