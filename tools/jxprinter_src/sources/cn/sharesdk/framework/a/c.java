package cn.sharesdk.framework.a;

import A3.AbstractC0157z;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.a.e;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.math3.optimization.direct.CMAESOptimizer;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static MobCommunicator f2157h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f2158a = e.a();
    private NetworkHelper b = new NetworkHelper();
    private Hashon c = new Hashon();
    private String d;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap<String, String> f2160g;

    public c() {
        try {
            this.f2160g = (HashMap) this.f2158a.l("buffered_server_paths");
        } catch (Throwable unused) {
            this.f2160g = new HashMap<>();
        }
        h();
    }

    private static synchronized MobCommunicator g() {
        try {
            if (f2157h == null) {
                f2157h = new MobCommunicator(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f", "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1");
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2157h;
    }

    private void h() {
        this.d = androidx.collection.a.o(DH.SyncMtd.getPackageName() + PackagingURIHelper.FORWARD_SLASH_STRING + DH.SyncMtd.getAppVersionName(), " ShareSDK/3.10.35 ", "Android/" + DH.SyncMtd.getOSVersionInt());
        try {
            this.e = MobSDK.dynamicModifyUrl("api-share.mob.com");
        } catch (Throwable th) {
            this.e = MobSDK.checkRequestUrl("api-share.mob.com");
            SSDKLog.b().a(androidx.exifinterface.media.a.n("001 dynamicModifyUrl catch, no problem ", th), new Object[0]);
        }
        this.f2159f = true;
    }

    private String i() {
        return AbstractC0157z.s(new StringBuilder(), this.e, "/conn");
    }

    private String j() {
        HashMap<String, String> map = this.f2160g;
        return (map == null || !map.containsKey("/date")) ? AbstractC0157z.s(new StringBuilder(), this.e, "/date") : AbstractC0157z.s(new StringBuilder(), this.f2160g.get("/date"), "/date");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k() {
        return AbstractC0157z.s(new StringBuilder(), this.e, "/conf5");
    }

    private String l() {
        try {
            return MobSDK.dynamicModifyUrl("up.mob.com/upload/image");
        } catch (Throwable th) {
            SSDKLog.b().a(androidx.exifinterface.media.a.n("002 dynamicModifyUrl catch, no problem ", th), new Object[0]);
            return MobSDK.checkRequestUrl("up.mob.com/upload/image");
        }
    }

    private String m() {
        HashMap<String, String> map = this.f2160g;
        return (map == null || !map.containsKey("/log5")) ? AbstractC0157z.s(new StringBuilder(), this.e, "/log5") : AbstractC0157z.s(new StringBuilder(), this.f2160g.get("/log5"), "/log5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n() {
        try {
            return MobSDK.dynamicModifyUrl("l.mob.com/url/shareSdkEncryptMapping.do");
        } catch (Throwable th) {
            SSDKLog.b().a(androidx.exifinterface.media.a.n("003 dynamicModifyUrl catch, no problem ", th), new Object[0]);
            return MobSDK.checkRequestUrl("l.mob.com/url/shareSdkEncryptMapping.do");
        }
    }

    private String o() {
        HashMap<String, String> map = this.f2160g;
        return (map == null || !map.containsKey("/snsconf")) ? AbstractC0157z.s(new StringBuilder(), this.e, "/snsconf") : AbstractC0157z.s(new StringBuilder(), this.f2160g.get("/snsconf"), "/snsconf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized MobCommunicator f() {
        try {
            if (f2157h == null) {
                f2157h = new MobCommunicator(1024, "bb7addd7e33383b74e82aba9b1d274c73aea6c0c71fcc88730270f630dbe490e1d162004f74e9532f98e17004630fbea9b346de63c23e83a7dfad70dd47cebfd", "288e7c44e01569a905386e6341baabfcde63ec37d0f0835cc662c299a5d0072970808a7fa434f0a51fa581d09d5ec4350ba5d548eafbe1fd956fb3afd678c1fb6134c904668652ec5cceb5d85da337a0f2f13ea457cca74a01b3ba0f4c809ad30d382bba2562ec9b996ae44c3700731c1b914997ef826331759e4084a019a03f");
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2157h;
    }

    public void b(String str) {
        this.e = str;
    }

    public HashMap<String, Object> c(String str) {
        KVPair<String> kVPair = new KVPair<>(Constants.FILE, str);
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("User-Identity", cn.sharesdk.framework.network.a.a()));
        String strHttpPost = this.b.httpPost(l(), (ArrayList<KVPair<String>>) null, kVPair, arrayList, (NetworkHelper.NetworkTimeOut) null);
        SSDKLog.b().c("upload file response == %s", strHttpPost);
        return this.c.fromJson(strHttpPost);
    }

    public HashMap<String, Object> d(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("appkey", MobSDK.getAppkey()));
        arrayList.add(new KVPair<>("device", str));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Identity", cn.sharesdk.framework.network.a.a()));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 10000;
        return this.c.fromJson(this.b.httpPost(o(), arrayList, (KVPair<String>) null, arrayList2, networkTimeOut));
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SSDKLog.b().a(AbstractC0157z.n("duid === ", str), new Object[0]);
        this.d = androidx.exifinterface.media.a.r(new StringBuilder(), this.d, " ", str);
    }

    public long b() {
        String strHttpGet;
        if (!this.f2158a.i()) {
            return 0L;
        }
        try {
            strHttpGet = this.b.httpGet(j(), null, null, null);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            strHttpGet = "{}";
        }
        HashMap mapFromJson = this.c.fromJson(strHttpGet);
        if (mapFromJson.containsKey(Constants.TIMESTAMP)) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() - ResHelper.parseLong(String.valueOf(mapFromJson.get(Constants.TIMESTAMP)));
                this.f2158a.a("service_time", Long.valueOf(jCurrentTimeMillis));
                return jCurrentTimeMillis;
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
                return this.f2158a.b();
            }
        }
        return this.f2158a.b();
    }

    public ArrayList<cn.sharesdk.framework.a.a.c> c() {
        ArrayList<cn.sharesdk.framework.a.a.c> arrayListA = cn.sharesdk.framework.a.a.d.a();
        return arrayListA == null ? new ArrayList<>() : arrayListA;
    }

    public HashMap<String, Object> d() {
        return this.c.fromJson(this.f2158a.g());
    }

    public void b(HashMap<String, Object> map) {
        this.f2158a.g(this.c.fromHashMap(map));
    }

    public void a(HashMap<String, String> map) {
        this.f2160g = map;
        this.f2158a.a("buffered_server_paths", map);
    }

    public HashMap<String, Object> a() {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("appkey", MobSDK.getAppkey()));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Identity", cn.sharesdk.framework.network.a.a()));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = CMAESOptimizer.DEFAULT_MAXITERATIONS;
        networkTimeOut.connectionTimeout = CMAESOptimizer.DEFAULT_MAXITERATIONS;
        String strHttpPost = this.b.httpPost(i(), arrayList, (KVPair<String>) null, arrayList2, networkTimeOut);
        SSDKLog.b().c(" isConnectToServer response == %s", strHttpPost);
        return this.c.fromJson(strHttpPost);
    }

    public void a(final ShareSDKCallback<HashMap<String, Object>> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getDeviceKey().getDetailNetworkTypeForStatic().getNetworkType().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.a.c.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String networkType = dHResponse.getNetworkType();
                    if (!"none".equals(networkType) && !TextUtils.isEmpty(networkType)) {
                        String appkey = MobSDK.getAppkey();
                        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                        arrayList.add(new KVPair<>("appkey", appkey));
                        arrayList.add(new KVPair<>("device", dHResponse.getDeviceKey()));
                        arrayList.add(new KVPair<>("plat", String.valueOf(DH.SyncMtd.getPlatformCode())));
                        arrayList.add(new KVPair<>("apppkg", DH.SyncMtd.getPackageName()));
                        arrayList.add(new KVPair<>("appver", String.valueOf(DH.SyncMtd.getAppVersion())));
                        arrayList.add(new KVPair<>("sdkver", String.valueOf(ShareSDK.SDK_VERSION_CODE)));
                        arrayList.add(new KVPair<>("networktype", dHResponse.getDetailNetworkTypeForStatic()));
                        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
                        arrayList2.add(new KVPair<>("User-Identity", cn.sharesdk.framework.network.a.a()));
                        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                        networkTimeOut.readTimout = 10000;
                        networkTimeOut.connectionTimeout = 10000;
                        String strHttpPost = c.this.b.httpPost(c.this.k(), arrayList, (KVPair<String>) null, arrayList2, networkTimeOut);
                        try {
                            HashMap mapFromJson = new Hashon().fromJson(strHttpPost);
                            if (mapFromJson.containsKey("error")) {
                                if (String.valueOf(mapFromJson.get("error")).contains("'appkey' is illegal")) {
                                    if (TextUtils.isEmpty(appkey)) {
                                        cn.sharesdk.framework.b.a().b();
                                    } else {
                                        cn.sharesdk.framework.a.f2122a = true;
                                    }
                                }
                            } else if (!TextUtils.isEmpty(appkey)) {
                                cn.sharesdk.framework.a.b = appkey;
                            }
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                        }
                        SSDKLog.b().c(" get server config response == %s", strHttpPost);
                        shareSDKCallback.onCallback(c.this.c.fromJson(strHttpPost));
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(androidx.exifinterface.media.a.n("getServerConfig", th2), new Object[0]);
                }
            }
        });
    }

    public boolean a(String str, boolean z6) {
        try {
            if (!MobSDK.isMob()) {
                return true;
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("m", str);
            map.put("t", z6 ? "1" : "0");
            String str2 = (String) g().requestSynchronized(map, m(), false);
            SSDKLog.b().c("> Upload All Log  resp: %s", str2);
            return TextUtils.isEmpty(str2) || ((Integer) this.c.fromJson(str2).get(NotificationCompat.CATEGORY_STATUS)).intValue() == 200;
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return false;
        }
    }

    public void a(String str, final ArrayList<String> arrayList, final int i5, final String str2, final ShareSDKCallback<HashMap<String, Object>> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getDeviceKey().getDetailNetworkTypeForStatic().getScreenSize().getCarrier().getNetworkType().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.a.c.2
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                String strEncodeToString;
                try {
                    String networkType = dHResponse.getNetworkType();
                    if (!"none".equals(networkType) && !TextUtils.isEmpty(networkType) && c.this.f2159f) {
                        boolean zC = c.this.f2158a.c();
                        boolean zD = c.this.f2158a.d();
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append(Data.urlEncode(DH.SyncMtd.getPackageName(), "utf-8"));
                            sb.append("|");
                            sb.append(Data.urlEncode(DH.SyncMtd.getAppVersionName(), "utf-8"));
                            sb.append("|");
                            sb.append(Data.urlEncode(String.valueOf(ShareSDK.SDK_VERSION_CODE), "utf-8"));
                            sb.append("|");
                            sb.append(Data.urlEncode(String.valueOf(DH.SyncMtd.getPlatformCode()), "utf-8"));
                            sb.append("|");
                            sb.append(Data.urlEncode(dHResponse.getDetailNetworkTypeForStatic(), "utf-8"));
                            sb.append("|");
                            if (zC) {
                                sb.append(Data.urlEncode(String.valueOf(DH.SyncMtd.getOSVersionInt()), "utf-8"));
                                sb.append("|");
                                sb.append(Data.urlEncode(dHResponse.getScreenSize(), "utf-8"));
                                sb.append("|");
                                sb.append(Data.urlEncode(DH.SyncMtd.getManufacturer(), "utf-8"));
                                sb.append("|");
                                sb.append(Data.urlEncode(DH.SyncMtd.getModel(), "utf-8"));
                                sb.append("|");
                                sb.append(Data.urlEncode(dHResponse.getCarrier(), "utf-8"));
                                sb.append("|");
                            } else {
                                sb.append("|||||");
                            }
                            if (zD) {
                                sb.append(str2);
                            } else {
                                sb.append(str2.split("\\|")[0]);
                                sb.append("|||||");
                            }
                            String string = sb.toString();
                            SSDKLog.b().c("shorLinkMsg ===>>>>", string);
                            strEncodeToString = Base64.encodeToString(Data.AES128Encode(Data.rawMD5(dHResponse.getDeviceKey() + ParameterizedMessage.ERROR_MSG_SEPARATOR + MobSDK.getAppkey()), string), 2);
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                            strEncodeToString = null;
                        }
                        new ArrayList().add(new KVPair("User-Identity", cn.sharesdk.framework.network.a.a()));
                        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                        networkTimeOut.readTimout = 5000;
                        networkTimeOut.connectionTimeout = 5000;
                        HashMap<String, Object> map = new HashMap<>();
                        map.put(Constants.KEY, MobSDK.getAppkey());
                        ArrayList arrayList2 = new ArrayList();
                        for (int i6 = 0; i6 < arrayList.size(); i6++) {
                            arrayList2.add(URLEncoder.encode((String) arrayList.get(i6), "UTF-8"));
                        }
                        map.put("urls", arrayList2);
                        map.put("deviceid", dHResponse.getDeviceKey());
                        map.put("snsplat", Integer.valueOf(i5));
                        if (TextUtils.isEmpty(str2)) {
                            SSDKLog.b().a("shortLinkMsg null", new Object[0]);
                            return;
                        }
                        map.put("m", strEncodeToString);
                        HashMap map2 = (HashMap) c.f().requestSynchronized(map, c.this.n(), false);
                        SSDKLog.b().c("> SERVER_SHORT_LINK_URL  resp: %s", map2);
                        if (map2.size() == 0) {
                            c.this.f2159f = false;
                        } else {
                            if (map2.get("data") == null) {
                                return;
                            }
                            shareSDKCallback.onCallback(map2);
                        }
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(androidx.exifinterface.media.a.n("getShortLink", th2), new Object[0]);
                    ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                    if (shareSDKCallback2 != null) {
                        shareSDKCallback2.onCallback(new HashMap());
                    }
                }
            }
        });
    }

    public void a(cn.sharesdk.framework.a.b.e eVar) {
        cn.sharesdk.framework.a.a.d.a(eVar.toString(), eVar.e);
    }

    public void a(ArrayList<String> arrayList) {
        cn.sharesdk.framework.a.a.d.a(arrayList);
    }

    public HashMap<String, Object> a(String str, String str2) {
        return this.c.fromJson(new String(Data.AES128Decode(Data.rawMD5(MobSDK.getAppkey() + ParameterizedMessage.ERROR_MSG_SEPARATOR + str2), Base64.decode(str, 2)), "UTF-8").trim());
    }

    public HashMap<String, Object> a(String str, ArrayList<String> arrayList, int i5, String str2, HashMap<String, String> map) {
        if (!this.f2159f) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair(Constants.KEY, MobSDK.getAppkey()));
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            arrayList2.add(new KVPair("urls", arrayList.get(i6).toString()));
        }
        arrayList2.add(new KVPair("deviceid", map.get("dk")));
        arrayList2.add(new KVPair("snsplat", String.valueOf(i5)));
        String strA = a(str2, map);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        arrayList2.add(new KVPair("m", strA));
        new ArrayList().add(new KVPair("User-Identity", cn.sharesdk.framework.network.a.a()));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 5000;
        networkTimeOut.connectionTimeout = 5000;
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put(Constants.KEY, MobSDK.getAppkey());
        ArrayList arrayList3 = new ArrayList();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            arrayList3.add(URLEncoder.encode(arrayList.get(i7), "UTF-8"));
        }
        map2.put("urls", arrayList3);
        map2.put("deviceid", map.get("dk"));
        map2.put("snsplat", Integer.valueOf(i5));
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        map2.put("m", strA);
        HashMap<String, Object> map3 = (HashMap) f().requestSynchronized(map2, n(), false);
        SSDKLog.b().c("> SERVER_SHORT_LINK_URL  resp: %s", map3);
        if (map3.size() == 0) {
            this.f2159f = false;
            return null;
        }
        if (map3.get("data") == null) {
            return null;
        }
        return map3;
    }

    private String a(String str, HashMap<String, String> map) {
        boolean zC = this.f2158a.c();
        boolean zD = this.f2158a.d();
        StringBuilder sb = new StringBuilder();
        sb.append(Data.urlEncode(DH.SyncMtd.getPackageName(), "utf-8"));
        sb.append("|");
        sb.append(Data.urlEncode(DH.SyncMtd.getAppVersionName(), "utf-8"));
        sb.append("|");
        sb.append(Data.urlEncode(String.valueOf(ShareSDK.SDK_VERSION_CODE), "utf-8"));
        sb.append("|");
        sb.append(Data.urlEncode(String.valueOf(DH.SyncMtd.getPlatformCode()), "utf-8"));
        sb.append("|");
        sb.append(Data.urlEncode(map.get("dnwktfs"), "utf-8"));
        sb.append("|");
        if (zC) {
            sb.append(Data.urlEncode(String.valueOf(DH.SyncMtd.getOSVersionInt()), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(map.get("srs"), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(DH.SyncMtd.getManufacturer(), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(DH.SyncMtd.getModel(), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(map.get("car"), "utf-8"));
            sb.append("|");
        } else {
            sb.append("|||||");
        }
        if (zD) {
            sb.append(str);
        } else {
            sb.append(str.split("\\|")[0]);
            sb.append("|||||");
        }
        String string = sb.toString();
        SSDKLog.b().c("shorLinkMsg ===>>>>", string);
        return Base64.encodeToString(Data.AES128Encode(Data.rawMD5(map.get("dk") + ParameterizedMessage.ERROR_MSG_SEPARATOR + MobSDK.getAppkey()), string), 2);
    }
}
