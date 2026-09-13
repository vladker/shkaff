package cn.fly.commons;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.MDP;
import cn.fly.tools.network.NetCommunicator;
import cn.fly.tools.network.NetworkHelper;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.FileLocker;
import cn.fly.tools.utils.FileUtils;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.ResHelper;
import cn.fly.tools.utils.SQLiteHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.math3.optimization.direct.CMAESOptimizer;
import org.apache.logging.log4j.message.StructuredDataId;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.xddf.usermodel.Angles;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f1410a;
    private static volatile SQLiteHelper.SingleTableDB b;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a[] f1417a = new a[3];
        private long b;
        private HashMap<String, Object> c;

        private a(long j6, HashMap<String, Object> map) {
            this.b = j6;
            this.c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                v.a(v.a(v.b), new u() { // from class: cn.fly.commons.d.a.1
                    @Override // cn.fly.commons.u
                    public boolean a(FileLocker fileLocker) {
                        DH.requester(FlySDK.getContext()).getDetailNetworkTypeForStatic().request(new DH.DHResponder() { // from class: cn.fly.commons.d.a.1.1
                            @Override // cn.fly.tools.utils.DH.DHResponder
                            public void onResponse(DH.DHResponse dHResponse) {
                                b bVarB;
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(o.a("004iVdidf]f"), String.valueOf(a.this.b));
                                if (a.this.c != null) {
                                    a.this.c.put(o.a("006djjMehVf ec"), q.a());
                                    a.this.c.put(o.a("006djjjBehej"), DH.SyncMtd.getPackageName());
                                    a.this.c.put(o.a("006djj_ddQfFdj"), DH.SyncMtd.getAppVersionName());
                                    Long l6 = (Long) c.a(o.a("010!fi+i)djVdif%ejeceedc"), 0L);
                                    if (l6.longValue() != 0) {
                                        a.this.c.put(o.a("010Afi+i%djJdif6ejeceedc"), l6);
                                    }
                                }
                                contentValues.put(o.a("004Wdc!did"), Base64.encodeToString(Data.AES128Encode(Data.rawMD5(DH.SyncMtd.getManufacturerForFly()), HashonHelper.fromHashMap(a.this.c).getBytes("utf-8")), 2));
                                SQLiteHelper.insert(d.b, contentValues);
                                long jLongValue = ((Long) c.a(o.a("004Ddc.fPdg)j"), 2L)).longValue();
                                if (o.a("004e@dkBef").equals(dHResponse.getDetailNetworkTypeForStatic())) {
                                    jLongValue = 120;
                                }
                                if (!c.d() || (bVarB = b.b()) == null) {
                                    return;
                                }
                                if (jLongValue <= 0) {
                                    bVarB.run();
                                } else {
                                    if (cn.fly.commons.a.l.a().a(jLongValue, bVarB)) {
                                        return;
                                    }
                                    bVarB.c();
                                }
                            }
                        });
                        return false;
                    }
                });
                a();
            } catch (Throwable th) {
                try {
                    FlyLog.getInstance().d(th);
                } finally {
                    a();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a b(long j6, HashMap<String, Object> map) {
            a[] aVarArr = f1417a;
            synchronized (aVarArr) {
                for (int i5 = 0; i5 < 3; i5++) {
                    try {
                        a aVar = aVarArr[i5];
                        if (aVar != null) {
                            aVar.b = j6;
                            HashMap<String, Object> map2 = aVar.c;
                            if (map2 != null) {
                                map2.clear();
                            }
                            aVar.c = map;
                            aVarArr[i5] = null;
                            return aVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return new a(j6, map);
            }
        }

        private void a() {
            try {
                a[] aVarArr = f1417a;
                synchronized (aVarArr) {
                    for (int i5 = 0; i5 < 3; i5++) {
                        try {
                            if (aVarArr[i5] == null) {
                                this.b = 0L;
                                HashMap<String, Object> map = this.c;
                                if (map != null) {
                                    map.clear();
                                }
                                this.c = null;
                                aVarArr[i5] = this;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static class b implements Runnable {
        private static final b[] b = {new b()};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1420a = false;

        /* JADX INFO: Access modifiers changed from: private */
        public static b b() {
            b[] bVarArr = b;
            synchronized (bVarArr) {
                try {
                    b bVar = bVarArr[0];
                    if (bVar == null) {
                        return null;
                    }
                    bVarArr[0] = null;
                    if (bVar.f1420a) {
                        bVar.f1420a = false;
                    }
                    return bVar;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            b[] bVarArr = b;
            synchronized (bVarArr) {
                try {
                    if (bVarArr[0] == null) {
                        bVarArr[0] = this;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f1420a = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.a(v.a(v.b), new u() { // from class: cn.fly.commons.d.b.1
                @Override // cn.fly.commons.u
                public boolean a(FileLocker fileLocker) {
                    DH.requester(FlySDK.getContext()).getDeviceKey().getDetailNetworkTypeForStatic().getDataNtTypeStrict().request(new DH.DHResponder() { // from class: cn.fly.commons.d.b.1.1
                        @Override // cn.fly.tools.utils.DH.DHResponder
                        public void onResponse(DH.DHResponse dHResponse) {
                            try {
                                String[][] strArr = new String[50][];
                                int iA = b.this.a(strArr);
                                while (iA > 0) {
                                    SparseArray sparseArrayA = b.this.a(strArr, iA, dHResponse);
                                    if (sparseArrayA.size() == 0 && b.this.f1420a) {
                                        cn.fly.commons.a.l.a().d();
                                        break;
                                    }
                                    if (sparseArrayA.size() > 0) {
                                        b.this.a((SparseArray<String>) sparseArrayA);
                                    }
                                    if (iA < 50) {
                                        break;
                                    } else {
                                        iA = b.this.a(strArr);
                                    }
                                }
                            } finally {
                                b.this.c();
                            }
                        }
                    });
                    return false;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a(String[][] strArr) {
            long j6;
            int i5 = 0;
            Cursor cursorQuery = null;
            try {
                cursorQuery = SQLiteHelper.query(d.b, new String[]{o.a("004i6didfTf"), o.a("004(dcZdid")}, null, null, "time desc");
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return 0;
                }
                if (!cursorQuery.moveToFirst()) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused2) {
                    }
                    return 0;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i6 = 0;
                do {
                    try {
                        String[] strArr2 = {cursorQuery.getString(0), cursorQuery.getString(1)};
                        try {
                            j6 = Long.parseLong(strArr2[0]);
                        } catch (Throwable unused3) {
                            j6 = -1;
                        }
                        if (j6 <= jCurrentTimeMillis) {
                            strArr[i6] = strArr2;
                            i6++;
                        }
                        if (i6 >= strArr.length) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        i5 = i6;
                    }
                } while (cursorQuery.moveToNext());
                try {
                    cursorQuery.close();
                    return i6;
                } catch (Throwable unused4) {
                    return i6;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                FlyLog.getInstance().w(th);
                return i5;
            } finally {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused5) {
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a(SparseArray<String> sparseArray) {
            try {
                StringBuilder sb = new StringBuilder();
                int size = sparseArray.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(Chars.QUOTE);
                    sb.append(sparseArray.valueAt(i5));
                    sb.append(Chars.QUOTE);
                }
                try {
                    return SQLiteHelper.delete(d.b, "time in (" + sb.toString() + ")", null);
                } catch (Throwable th) {
                    FlyLog.getInstance().w(th);
                    return SQLiteHelper.delete(d.b, "time in (" + sb.toString() + ")", null);
                }
            } catch (Throwable th2) {
                FlyLog.getInstance().w(th2);
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SparseArray<String> a(String[][] strArr, int i5, DH.DHResponse dHResponse) {
            SparseArray<String> sparseArray = new SparseArray<>();
            try {
                HashMap<String, Object> map = new HashMap<>();
                map.put(o.a("004jgdi"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
                map.put(o.a("006.dcBf2dddiIcf"), dHResponse.getDeviceKey());
                map.put(o.a("005JdfdkdcEfg"), DH.SyncMtd.getModelForFly());
                map.put(o.a("004!dcdgdidc"), f.a((FlyProduct) null));
                map.put(o.a("011efiIfgdkdjehHi[ec;jf"), dHResponse.getDetailNetworkTypeForStatic());
                map.put(o.a("015_dcOdid@eg5fi4fgdkdjehfcec,jf"), Integer.valueOf(dHResponse.getDataNtTypeStrict()));
                ArrayList arrayList = new ArrayList();
                byte[] bArrRawMD5 = Data.rawMD5(DH.SyncMtd.getManufacturerForFly());
                for (int i6 = 0; i6 < i5; i6++) {
                    String[] strArr2 = strArr[i6];
                    try {
                        HashMap mapFromJson = HashonHelper.fromJson(new String(Data.AES128Decode(bArrRawMD5, Base64.decode(strArr2[1], 2)), "utf-8").trim());
                        sparseArray.put(i6, strArr2[0]);
                        String str = (String) mapFromJson.get(o.a("004i)ecDjf"));
                        if (TextUtils.equals(str, "ALSAMT") || TextUtils.equals(str, "LCMT") || TextUtils.equals(str, "O_LCMT") || TextUtils.equals(str, "WIMT") || TextUtils.equals(str, "WLMT") || TextUtils.equals(str, "BSIOMT")) {
                            cn.fly.commons.b.a().a(str, mapFromJson);
                        }
                        arrayList.add(mapFromJson);
                    } catch (Throwable th) {
                        FlyLog.getInstance().w(th);
                    }
                }
                if (arrayList.isEmpty()) {
                    return new SparseArray<>();
                }
                map.put(o.a("005RdcDdid.fi"), arrayList);
                map.put(o.a("005i+dkeh,fe"), af.a().b());
                HashMap<String, String> map2 = new HashMap<>();
                map2.put(o.a("013Sekfi!f djhkeedcVfei8di,i'ec"), ad.e());
                map2.put(o.a("004Fdfdkdidc"), cn.fly.tools.b.c.a(FlySDK.getContext()).d().ap());
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.readTimout = CMAESOptimizer.DEFAULT_MAXITERATIONS;
                networkTimeOut.connectionTimeout = CMAESOptimizer.DEFAULT_MAXITERATIONS;
                if (!"200".equals(String.valueOf(HashonHelper.fromJson((String) new NetCommunicator(1024, "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", networkTimeOut).requestWithoutEncode(false, map2, map, j.a().a("gclg") + "/v6/gcl", false)).get(o.a("006Ifi:idi-dgfi"))))) {
                    sparseArray.clear();
                }
                return sparseArray;
            } catch (Throwable th2) {
                FlyLog.getInstance().w(th2);
            }
        }
    }

    private d() {
        try {
            Context context = FlySDK.getContext();
            String str = n.f1467a;
            File dataCacheFile = ResHelper.getDataCacheFile(context, str, true);
            if (dataCacheFile.exists() && dataCacheFile.length() > 209715200) {
                dataCacheFile.delete();
                dataCacheFile = ResHelper.getDataCacheFile(FlySDK.getContext(), str, true);
            }
            b = SQLiteHelper.getDatabase(dataCacheFile.getAbsolutePath(), o.a("0086fl'didXfk)fdj") + "_1");
            b.addField(o.a("004i.didfUf"), o.a("004ifGei7i"), true);
            b.addField(o.a("004]dcDdid"), o.a("004if[eiZi"), true);
            b bVarB = b.b();
            if (bVarB != null) {
                cn.fly.commons.a.l.a().a(0L, 180, bVarB);
            }
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0109 -> B:68:0x00fc). Please report as a decompilation issue!!! */
    private static File b(Object... objArr) throws Throwable {
        int i5;
        InputStream fileInputStream;
        File file;
        FileOutputStream fileOutputStream;
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        String str3 = (String) objArr[4];
        String str4 = (String) objArr[5];
        InputStream inputStream = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            File file2 = new File(FlySDK.getContext().getFilesDir(), o.a("0035fi(cc"));
            byte[] bArr = (byte[]) objArr[2];
            try {
                i5 = Integer.parseInt(String.valueOf(objArr[3]));
            } catch (Throwable unused) {
                i5 = 0;
            }
            if (bArr == null || i5 <= 0 || bArr.length < i5 || !str.equals(Data.MD5(bArr, 0, i5))) {
                File file3 = new File(file2, o.a("008c@dk3e5efdlfi%cc"));
                if (file3.exists() && str.equals(Data.MD5(file3))) {
                    fileInputStream = new FileInputStream(file3);
                } else {
                    i.a().a(20);
                    file3.delete();
                    fileInputStream = null;
                }
            } else {
                fileInputStream = new ByteArrayInputStream(bArr, 0, i5);
            }
            if (fileInputStream != null) {
                try {
                    file = new File(file2, String.valueOf(System.currentTimeMillis()));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file4 = new File(file, file.getName() + o.a("004<dlgddi?j"));
                    try {
                        fileOutputStream = new FileOutputStream(file4);
                        try {
                            Data.AES128Decode(str2, fileInputStream, fileOutputStream);
                            C0396r.a(fileInputStream, fileOutputStream);
                            try {
                                if (k.a().b()) {
                                    i.a().a(14);
                                    cn.fly.commons.a.c.a(str, file4, str3, str4);
                                } else {
                                    i.a().a(19);
                                }
                            } catch (Throwable th) {
                                try {
                                    i.a().a(6, th);
                                } catch (Throwable th2) {
                                    try {
                                        ResHelper.deleteFileAndFolder(file);
                                    } catch (Throwable th3) {
                                        i.a().a(4, th3);
                                    }
                                    throw th2;
                                }
                            }
                            try {
                                ResHelper.deleteFileAndFolder(file);
                            } catch (Throwable th4) {
                                i.a().a(4, th4);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            C0396r.a(fileInputStream, fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileOutputStream = null;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    inputStream = fileInputStream;
                    C0396r.a(inputStream);
                    throw th;
                }
            } else {
                file = null;
                inputStream = fileInputStream;
            }
            C0396r.a(inputStream);
            return file;
        } catch (Throwable th8) {
            th = th8;
            C0396r.a(inputStream);
            throw th;
        }
    }

    public static synchronized d a() {
        try {
            if (f1410a == null) {
                f1410a = new d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1410a;
    }

    public void a(long j6, HashMap<String, Object> map) {
        boolean zB = c.b();
        FlyLog.getInstance().d("DH PD: " + map.get(o.a("004i7ec.jf")) + ", to: " + zB, new Object[0]);
        if (zB) {
            ac.b.execute(a.b(j6, map));
        }
    }

    public static void a(Object... objArr) {
        try {
            try {
                i.a().a(13);
                ResHelper.deleteFileAndFolder(b(objArr));
            } catch (Throwable th) {
                i.a().a(4, th);
            }
        } catch (Throwable th2) {
            try {
                i.a().a(5, th2);
                ResHelper.deleteFileAndFolder(null);
            } catch (Throwable th3) {
                try {
                    ResHelper.deleteFileAndFolder(null);
                } catch (Throwable th4) {
                    i.a().a(4, th4);
                }
                throw th3;
            }
        }
    }

    public static void a(final ArrayList<HashMap<String, Object>> arrayList, final cn.fly.tools.utils.d<Void> dVar) {
        if (arrayList != null && !arrayList.isEmpty()) {
            DH.requester(FlySDK.getContext()).getDeviceKey().getMIUIVersionForFly().getAdvertisingID().request(new DH.DHResponder() { // from class: cn.fly.commons.d.1
                @Override // cn.fly.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    int i5;
                    FlyProduct flyProduct = null;
                    try {
                        File file = new File(FlySDK.getContext().getFilesDir(), o.a("003>fiff(g"));
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        final ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = arrayList;
                        int size = arrayList3.size();
                        int i6 = 0;
                        while (i6 < size) {
                            int i7 = i6 + 1;
                            HashMap map = (HashMap) arrayList3.get(i6);
                            try {
                                Boolean bool = (Boolean) map.get(o.a("002d5fi"));
                                boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                                String str = (String) map.get(o.a("002%ef=g"));
                                String str2 = (String) map.get("m");
                                String str3 = (String) map.get("args");
                                Object obj = map.get(o.a("002Rdidc"));
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                                    i5 = -1;
                                    try {
                                        String strA = f.a(flyProduct);
                                        HashMap map2 = new HashMap();
                                        map2.put(o.a("004Ldcdgdidc"), strA);
                                        map2.put(o.a("005iXdkehIfe"), af.a().b());
                                        map2.put(o.a("004)dfdkdidc"), cn.fly.tools.b.c.a(FlySDK.getContext()).d().ao());
                                        map2.put(o.a("010Gfidcehgk(fVdjfididk(e"), Integer.valueOf(FlySDK.SDK_VERSION_CODE));
                                        map2.put(o.a("006djj'ehQfTec"), q.a());
                                        map2.put(o.a("009djj:el fcSdjNfi"), FlySDK.getAppSecret());
                                        map2.put(o.a("006PdcdkdfTdMdi1e"), FlySDK.getDmn().getDomain());
                                        map2.put(o.a("010:efdkdj=cfOfk$iij$fi"), Boolean.valueOf(FlySDK.checkForceHttps()));
                                        map2.put(o.a("009Cefdkdj7cf]ee(j2ddhh"), Boolean.valueOf(FlySDK.checkV6()));
                                        Long l6 = (Long) c.a(o.a("004fcfOei"), 5L);
                                        l6.longValue();
                                        map2.put(o.a("004fcf+ei"), l6);
                                        map2.put(o.a("002cFdc"), (String) c.a(o.a("002c.dc"), o.a("006%hehehfhfhfhf")));
                                        map2.put("usridt", ad.g());
                                        map2.put(o.a("0022didc"), obj);
                                        if (!TextUtils.isEmpty(str3)) {
                                            map2.put("args", HashonHelper.fromJson(str3));
                                        }
                                        map2.put(o.a("008ZdcLfKdddi-cfNeedc"), dHResponse.getDeviceKey());
                                        map2.put("imei", null);
                                        map2.put("imsi", null);
                                        map2.put("sno", null);
                                        map2.put("ssno", null);
                                        map2.put("miui", dHResponse.getMIUIVersionForFly());
                                        map2.put(o.a("005-dfdkdcZfg"), DH.SyncMtd.getModelForFly());
                                        map2.put(o.a("007Aef6dci;dkdjec"), DH.SyncMtd.getManufacturerForFly());
                                        map2.put(o.a("005HffdjHde?dc"), DH.SyncMtd.getBrandForFly());
                                        map2.put(o.a("005d?dcfididc"), dHResponse.getAdvertisingID());
                                        map2.put(o.a("006djjSdd1fNdj"), DH.SyncMtd.getAppVersionName());
                                        map2.put("appVerCode", Integer.valueOf(DH.SyncMtd.getAppVersion()));
                                        map2.put(o.a("011jdcZehCdXej(f9eg,d[df-f"), DH.SyncMtd.getPackageName());
                                        map2.put(o.a("005Ifffifididc"), null);
                                        map2.put("osint", Integer.valueOf(DH.SyncMtd.getOSVersionIntForFly()));
                                        map2.put("osname", DH.SyncMtd.getOSVersionNameForFly());
                                        map2.put("mdpName", MDP.class.getName());
                                        String strFromHashMap = HashonHelper.fromHashMap(map2);
                                        String strCheckHttpRequestUrl = NetCommunicator.checkHttpRequestUrl(str);
                                        if (!TextUtils.isEmpty(str2)) {
                                            File file2 = new File(file, str2);
                                            if (zBooleanValue) {
                                                arrayList2.add(file2.getAbsolutePath());
                                            }
                                            d.b(String.valueOf(obj), file2, zBooleanValue, strCheckHttpRequestUrl, str2, strFromHashMap);
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            h.a().a(2, 50, th, ResHelper.forceCast(map.get(o.a("002Rdidc")), Integer.valueOf(i5)) + "");
                                        } catch (Throwable th2) {
                                            th = th2;
                                            try {
                                                h.a().a(2, i5, th, StructuredDataId.RESERVED);
                                                FlyLog.getInstance().d(th);
                                            } finally {
                                                dVar.a(false);
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                i5 = -1;
                            }
                            i6 = i7;
                            flyProduct = null;
                        }
                        i5 = -1;
                        FileUtils.deleteFilesInDirWithFilter(file, new FileFilter() { // from class: cn.fly.commons.d.1.1
                            @Override // java.io.FileFilter
                            public boolean accept(File file3) {
                                return !arrayList2.contains(file3.getAbsolutePath());
                            }
                        });
                    } catch (Throwable th4) {
                        th = th4;
                        i5 = -1;
                    }
                }
            });
        } else {
            dVar.a(null);
        }
    }

    public static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < iArr.length; i5++) {
            String strF = aa.f();
            if (iArr[i5] < strF.length()) {
                sb.append((char) (strF.charAt(iArr[i5]) - 2));
            }
        }
        return sb.toString();
    }

    public static void a(HashMap<String, String> map) {
        boolean zEquals;
        FileFilter fileFilter;
        try {
            File file = new File(FlySDK.getContext().getFilesDir(), "sblf");
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = map.get(o.a("002$ef3g"));
            String str2 = map.get("m");
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                return;
            }
            final ArrayList arrayList = new ArrayList();
            File file2 = new File(file, str2);
            arrayList.add(file2.getAbsolutePath());
            if (file2.exists() && str2.equals(Data.MD5(file2))) {
                return;
            }
            String strCheckHttpRequestUrl = NetCommunicator.checkHttpRequestUrl(str);
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                    networkTimeOut.readTimout = Angles.OOXML_DEGREE;
                    networkTimeOut.connectionTimeout = 15000;
                    new NetworkHelper().download(strCheckHttpRequestUrl, fileOutputStream2, networkTimeOut);
                    C0396r.a(fileOutputStream2);
                    if (file2.length() <= 0 || !TextUtils.equals(str2, Data.MD5(file2))) {
                        return;
                    }
                    fileFilter = new FileFilter() { // from class: cn.fly.commons.d.3
                        @Override // java.io.FileFilter
                        public boolean accept(File file3) {
                            return !arrayList.contains(file3.getAbsolutePath());
                        }
                    };
                    FileUtils.deleteFilesInDirWithFilter(file, fileFilter);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        h.a().a(6, -1, th, "-10");
                        C0396r.a(fileOutputStream);
                        if (file2.length() <= 0) {
                            return;
                        }
                        if (!zEquals) {
                        } else {
                            fileFilter = new FileFilter() { // from class: cn.fly.commons.d.3
                                @Override // java.io.FileFilter
                                public boolean accept(File file3) {
                                    return !arrayList.contains(file3.getAbsolutePath());
                                }
                            };
                        }
                    } finally {
                        C0396r.a(fileOutputStream);
                        if (file2.length() > 0 && TextUtils.equals(str2, Data.MD5(file2))) {
                            FileUtils.deleteFilesInDirWithFilter(file, new FileFilter() { // from class: cn.fly.commons.d.3
                                @Override // java.io.FileFilter
                                public boolean accept(File file3) {
                                    return !arrayList.contains(file3.getAbsolutePath());
                                }
                            });
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            h.a().a(5, -1, th3, "-10");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final String str, final File file, final boolean z6, final String str2, final String str3, final String str4) {
        new Thread(new Runnable() { // from class: cn.fly.commons.d.2
            @Override // java.lang.Runnable
            public void run() {
                int i5;
                Throwable th;
                FileOutputStream fileOutputStream;
                try {
                    ByteArrayOutputStream byteArrayOutputStream = null;
                    if (z6) {
                        try {
                            if (file.exists() && str3.equals(Data.MD5(file))) {
                                if (d.b(str, 5, file.getAbsolutePath(), null, str4)) {
                                    return;
                                }
                                file.delete();
                                return;
                                h.a().a(5, i5, th, str);
                                FlyLog.getInstance().d(th);
                                return;
                            }
                            if (file.exists()) {
                                file.delete();
                            }
                            i5 = 7;
                            try {
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                                        networkTimeOut.readTimout = Angles.OOXML_DEGREE;
                                        networkTimeOut.connectionTimeout = 15000;
                                        new NetworkHelper().download(str2, fileOutputStream, networkTimeOut);
                                        C0396r.a(fileOutputStream);
                                        if (file.length() <= 0 || !TextUtils.equals(str3, Data.MD5(file))) {
                                            if (file.exists()) {
                                                file.delete();
                                            }
                                        } else {
                                            if (d.b(str, 7, file.getAbsolutePath(), null, str4)) {
                                                return;
                                            }
                                            file.delete();
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        C0396r.a(fileOutputStream);
                                        if (file.length() <= 0 || !TextUtils.equals(str3, Data.MD5(file))) {
                                            if (file.exists()) {
                                                file.delete();
                                            }
                                        } else if (!d.b(str, 7, file.getAbsolutePath(), null, str4)) {
                                            file.delete();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fileOutputStream = null;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            i5 = 5;
                        }
                    } else {
                        if (file.exists()) {
                            file.delete();
                        }
                        try {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                NetworkHelper.NetworkTimeOut networkTimeOut2 = new NetworkHelper.NetworkTimeOut();
                                networkTimeOut2.readTimout = Angles.OOXML_DEGREE;
                                networkTimeOut2.connectionTimeout = 15000;
                                new NetworkHelper().download(str2, byteArrayOutputStream2, networkTimeOut2);
                                C0396r.a(byteArrayOutputStream2);
                                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                if (byteArray.length <= 0 || !TextUtils.equals(str3, Data.MD5(byteArray))) {
                                    return;
                                }
                                d.b(str, 9, null, byteArray, str4);
                            } catch (Throwable th6) {
                                th = th6;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                C0396r.a(byteArrayOutputStream);
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    }
                } catch (Throwable th8) {
                    i5 = 13;
                    th = th8;
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, int i5, String str2, byte[] bArr, String str3) {
        try {
            Method method = null;
            boolean z6 = false;
            for (Method method2 : cn.fly.tools.c.a.class.getMethods()) {
                Annotation[] annotations = method2.getAnnotations();
                if (annotations != null) {
                    for (Annotation annotation : annotations) {
                        if (annotation != null && annotation.annotationType() == cn.fly.tools.c.b.class) {
                            z6 = true;
                            method = method2;
                            break;
                        }
                    }
                    if (z6) {
                        break;
                    }
                }
            }
            if (bArr != null) {
                cn.fly.commons.cc.a.a(FlySDK.getContext(), bArr, str3, method);
            } else {
                cn.fly.commons.cc.a.a(FlySDK.getContext(), str2, str3, method);
            }
            return true;
        } catch (Throwable th) {
            try {
                h.a().a(6, i5, th, str);
                FlyLog.getInstance().d(th);
            } catch (Throwable unused) {
            }
            return false;
        }
    }

    public static void b() {
        File[] fileArrListFiles;
        try {
            File file = new File(FlySDK.getContext().getFilesDir(), "sblf");
            File file2 = null;
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles(new FileFilter() { // from class: cn.fly.commons.d.4
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    return file3.isFile();
                }
            })) != null && fileArrListFiles.length > 0) {
                long j6 = 0;
                for (File file3 : fileArrListFiles) {
                    long jLastModified = file3.lastModified();
                    if (jLastModified > j6) {
                        file2 = file3;
                        j6 = jLastModified;
                    }
                }
            }
            if (file2 != null) {
                if (file2.getName().equals(Data.MD5(file2))) {
                    final String absolutePath = file2.getAbsolutePath();
                    DH.requester(FlySDK.getContext()).getDeviceKey().getMIUIVersionForFly().getAdvertisingID().request(new DH.DHResponder() { // from class: cn.fly.commons.d.5
                        @Override // cn.fly.tools.utils.DH.DHResponder
                        public void onResponse(DH.DHResponse dHResponse) {
                            try {
                                boolean z6 = false;
                                Method method = null;
                                for (Method method2 : cn.fly.tools.c.a.class.getMethods()) {
                                    Annotation[] annotations = method2.getAnnotations();
                                    if (annotations != null) {
                                        for (Annotation annotation : annotations) {
                                            if (annotation != null && annotation.annotationType() == cn.fly.tools.c.b.class) {
                                                z6 = true;
                                                method = method2;
                                                break;
                                            }
                                        }
                                        if (z6) {
                                            break;
                                        }
                                    }
                                }
                                String strA = f.a((FlyProduct) null);
                                HashMap map = new HashMap();
                                map.put(o.a("004Wdcdgdidc"), strA);
                                map.put(o.a("005i%dkeh;fe"), af.a().b());
                                map.put(o.a("004Kdfdkdidc"), cn.fly.tools.b.c.a(FlySDK.getContext()).d().ao());
                                map.put(o.a("010Ufidcehgk8fHdjfididkUe"), Integer.valueOf(FlySDK.SDK_VERSION_CODE));
                                map.put(o.a("006djj%eh'fSec"), q.a());
                                map.put(o.a("009djj$elSfc dj%fi"), FlySDK.getAppSecret());
                                map.put(o.a("006*dcdkdfDd9di'e"), FlySDK.getDmn().getDomain());
                                map.put(o.a("010^efdkdjLcf;fk iij4fi"), Boolean.valueOf(FlySDK.checkForceHttps()));
                                map.put(o.a("009$efdkdjIcfOee2j;ddhh"), Boolean.valueOf(FlySDK.checkV6()));
                                Long l6 = (Long) c.a(o.a("004fcfXei"), 5L);
                                l6.longValue();
                                map.put(o.a("004fcfRei"), l6);
                                map.put(o.a("002c2dc"), (String) c.a(o.a("002c[dc"), o.a("0063hehehfhfhfhf")));
                                map.put("usridt", ad.g());
                                map.put(o.a("002%didc"), "-10");
                                map.put(o.a("0080dc^f,dddiTcf0eedc"), dHResponse.getDeviceKey());
                                map.put("imei", null);
                                map.put("imsi", null);
                                map.put("sno", null);
                                map.put("ssno", null);
                                map.put("miui", dHResponse.getMIUIVersionForFly());
                                map.put(o.a("0055dfdkdcHfg"), DH.SyncMtd.getModelForFly());
                                map.put(o.a("007-ef@dci*dkdjec"), DH.SyncMtd.getManufacturerForFly());
                                map.put(o.a("005$ffdj9deVdc"), DH.SyncMtd.getBrandForFly());
                                map.put(o.a("005d8dcfididc"), dHResponse.getAdvertisingID());
                                map.put(o.a("006djjEddEf6dj"), DH.SyncMtd.getAppVersionName());
                                map.put("appVerCode", Integer.valueOf(DH.SyncMtd.getAppVersion()));
                                map.put(o.a("011jdc2eh1d0ejHf,egEd]df8f"), DH.SyncMtd.getPackageName());
                                map.put(o.a("005Yfffifididc"), null);
                                map.put("osint", Integer.valueOf(DH.SyncMtd.getOSVersionIntForFly()));
                                map.put("osname", DH.SyncMtd.getOSVersionNameForFly());
                                map.put("mdpName", MDP.class.getName());
                                cn.fly.commons.cc.a.a(FlySDK.getContext(), absolutePath, HashonHelper.fromHashMap(map), method);
                            } catch (Throwable th) {
                                try {
                                    h.a().a(6, -1, th, "-10");
                                    FlyLog.getInstance().d(th);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    });
                } else {
                    file2.delete();
                }
            }
        } catch (Throwable th) {
            h.a().a(6, -1, th, "-10");
        }
    }
}
