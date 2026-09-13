package cn.fly.commons;

import A3.AbstractC0157z;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import com.mob.commons.MOBLINK;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: loaded from: classes.dex */
public class ad {
    private static Callable<Map<String, Object>> b;
    private static int c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f1264a = {n.a("008Ucjdidbehegcjdjga"), n.a("006Fcjfacjcjdjga"), n.a("007'faefdhdccccega"), n.a("0073faefdhejcicjdi"), n.a("009;cjegcbeiegehcceagj"), "FLYVERIFY", "LLUVERIFY"};
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static AtomicBoolean e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HashMap<String, FlyProduct> f1265f = new HashMap<>();

    public static void a() {
        if (aa.b()) {
            j();
            ac.f1261a.execute(new cn.fly.tools.utils.i() { // from class: cn.fly.commons.ad.1
                @Override // cn.fly.tools.utils.i
                public void a() {
                    FlyLog.getInstance().d("init sks start", new Object[0]);
                    ad.b();
                    FlyLog.getInstance().d("init sks over", new Object[0]);
                }
            });
        }
    }

    public static ArrayList<FlyProduct> b() {
        ArrayList<FlyProduct> arrayList;
        HashMap<String, FlyProduct> map = f1265f;
        synchronized (map) {
            try {
                if (aa.b() && aa.h() && d.compareAndSet(false, true)) {
                    map.putAll(k());
                }
                arrayList = new ArrayList<>();
                arrayList.addAll(map.values());
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public static Callable<Map<String, Object>> c() {
        return b;
    }

    public static int d() {
        return c;
    }

    public static synchronized String e() {
        return a(b(), 0);
    }

    public static synchronized String f() {
        return a(b(), 1);
    }

    public static synchronized String g() {
        return a(b(), 2);
    }

    public static synchronized String h() {
        return a(b(), 3);
    }

    public static synchronized String i() {
        return a(b(), 4);
    }

    private static void j() {
        if (aa.h() && e.compareAndSet(false, true)) {
            try {
                MOBLINK moblink = new MOBLINK();
                if (moblink instanceof FlyProduct) {
                    moblink.getProductTag();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static HashMap<String, FlyProduct> k() {
        HashMap<String, FlyProduct> map = new HashMap<>();
        for (Object obj : p.f1470a) {
            try {
                Class<?> cls = obj instanceof String ? Class.forName(String.valueOf(obj).trim()) : (Class) obj;
                if (!FlyProduct.class.isAssignableFrom(cls) || FlyProduct.class.equals(cls)) {
                    cls.newInstance();
                } else {
                    FlyProduct flyProduct = (FlyProduct) cls.newInstance();
                    String productTag = flyProduct.getProductTag();
                    FlyLog.getInstance().d("[INI]ini sks [" + productTag + "] s", new Object[0]);
                    String[] strArr = f1264a;
                    int length = strArr.length;
                    for (int i5 = 0; i5 < length; i5++) {
                        String str = strArr[i5];
                        if (str.equals(productTag)) {
                            map.put(str, flyProduct);
                            break;
                        }
                    }
                    if (n.a("007Mfaefdhejcicjdi").equals(productTag)) {
                        if (flyProduct instanceof Callable) {
                            c = 2;
                            b = (Callable) flyProduct;
                        } else {
                            c = 1;
                        }
                    }
                }
            } catch (Throwable unused) {
                FlyLog.getInstance().d("[INI]ini sks [" + obj + "] f", new Object[0]);
            }
        }
        return map;
    }

    public static void a(FlyProduct flyProduct) {
        HashMap<String, FlyProduct> map = f1265f;
        synchronized (map) {
            if (flyProduct != null) {
                try {
                    if (!map.containsKey(flyProduct.getProductTag())) {
                        map.put(flyProduct.getProductTag(), flyProduct);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static synchronized String a(final ArrayList<FlyProduct> arrayList, final int i5) {
        final String[] strArr;
        try {
            strArr = new String[]{""};
            DH.RequestBuilder carrierStrict = DH.requester(FlySDK.getContext()).getMIUIVersionForFly().getDetailNetworkTypeForStatic().getCarrierStrict(false);
            if (aa.b() && i5 != 3 && i5 != 4) {
                carrierStrict.getDeviceKey();
            } else {
                carrierStrict.getDeviceKeyFromCache(true);
            }
            carrierStrict.request(new DH.DHResponder() { // from class: cn.fly.commons.ad.2
                @Override // cn.fly.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    String str;
                    String str2;
                    int i6;
                    String str3 = "";
                    String strEncode = TextUtils.isEmpty(DH.SyncMtd.getPackageName()) ? "" : URLEncoder.encode(DH.SyncMtd.getPackageName(), "utf-8");
                    String strEncode2 = TextUtils.isEmpty(DH.SyncMtd.getAppVersionName()) ? "" : URLEncoder.encode(DH.SyncMtd.getAppVersionName(), "utf-8");
                    String strEncode3 = TextUtils.isEmpty(DH.SyncMtd.getManufacturerForFly()) ? "" : URLEncoder.encode(DH.SyncMtd.getManufacturerForFly(), "utf-8");
                    String strEncode4 = TextUtils.isEmpty(DH.SyncMtd.getModelForFly()) ? "" : URLEncoder.encode(DH.SyncMtd.getModelForFly(), "utf-8");
                    String strEncode5 = TextUtils.isEmpty(dHResponse.getMIUIVersionForFly()) ? "" : URLEncoder.encode(dHResponse.getMIUIVersionForFly(), "utf-8");
                    String strEncode6 = TextUtils.isEmpty(DH.SyncMtd.getOSVersionNameForFly()) ? "" : URLEncoder.encode(DH.SyncMtd.getOSVersionNameForFly(), "utf-8");
                    HashMap<String, Object> mapB = o.a().b();
                    String str4 = n.a("004OdbejejIj") + strEncode + ";" + strEncode2;
                    String str5 = n.a("012_cjgjcjEj*dbAc7babhbibgbahe") + DH.SyncMtd.getOSVersionIntForFly() + ";" + strEncode6;
                    int i7 = 0;
                    String str6 = n.a("0046cjdjcc+j") + ((!aa.b() || (i6 = i5) == 3 || i6 == 4) ? dHResponse.getDeviceKeyFromCache(new int[0]) : dHResponse.getDeviceKey());
                    String strO = n.a("003%eafa2j") + strEncode3 + ";" + strEncode4;
                    if (!TextUtils.isEmpty(strEncode5)) {
                        strO = androidx.collection.a.o(strO, ";", strEncode5);
                    }
                    String str7 = n.a("003_ceeg<j") + dHResponse.getDetailNetworkTypeForStatic() + ";" + dHResponse.getCarrierStrict(new int[0]);
                    String str8 = n.a("005Ydc3bc)chIj") + Locale.getDefault().toString().replace(n.a("002Bfibh"), ProcessIdUtil.DEFAULT_PROCESSID);
                    String str9 = n.a("004HcbdceiGj") + FlySDK.SDK_VERSION_CODE;
                    String strA = n.a("004)cjdjga%j");
                    if (!arrayList.isEmpty()) {
                        int size = arrayList.size();
                        while (i7 < size) {
                            try {
                                FlyProduct flyProduct = (FlyProduct) arrayList.get(i7);
                                if (i7 != 0) {
                                    str2 = str3;
                                    try {
                                        strA = strA + ",";
                                    } catch (Throwable unused) {
                                    }
                                } else {
                                    str2 = str3;
                                }
                                strA = strA + flyProduct.getProductTag() + ";" + flyProduct.getSdkver() + ";" + mapB.get(flyProduct.getProductTag());
                            } catch (Throwable unused2) {
                                str2 = str3;
                            }
                            i7++;
                            str3 = str2;
                        }
                    }
                    String str10 = str3;
                    String str11 = "DC/" + ad.a(i5);
                    String timezone = DH.SyncMtd.getTimezone();
                    if (TextUtils.isEmpty(timezone)) {
                        str = str10;
                    } else {
                        str = n.a("003Tdaghbf") + timezone;
                    }
                    String strC = af.a().c();
                    String strN = TextUtils.isEmpty(strC) ? "TID/" : AbstractC0157z.n("TID/", strC);
                    int iA = cn.fly.commons.cc.a.a();
                    String strK = AbstractC0157z.k(iA, "SVM/");
                    if (cn.fly.tools.b.d.c()) {
                        if (!n.a("004 cjdjgaJj").equals(strA)) {
                            strA = androidx.collection.a.n(strA, ",");
                        }
                        strA = strA + "CS;" + iA;
                    }
                    String strA2 = i5 == 3 ? ab.a().a(true) : ab.a().a(false);
                    String strN2 = TextUtils.isEmpty(strA2) ? "RD/" : AbstractC0157z.n("RD/", strA2);
                    String[] strArr2 = strArr;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(" ");
                    sb.append(str5);
                    sb.append(" ");
                    sb.append(str6);
                    androidx.collection.a.y(sb, " ", strO, " ", str7);
                    androidx.collection.a.y(sb, " ", str8, " ", str9);
                    androidx.collection.a.y(sb, " ", strA, " ", str11);
                    androidx.collection.a.y(sb, " ", str, " ", strN);
                    strArr2[0] = androidx.exifinterface.media.a.s(sb, " ", strK, " ", strN2);
                }
            });
        } catch (Throwable th) {
            throw th;
        }
        return strArr[0];
    }

    public static String a(int i5) {
        String str;
        if (CSCenter.getInstance().isCusControllerNotNull()) {
            str = "13";
        } else {
            str = "11";
        }
        if (i5 == 1) {
            return "[DC]";
        }
        if (i5 == 2) {
            return "[DC2]";
        }
        return i5 == 4 ? "15" : str;
    }
}
