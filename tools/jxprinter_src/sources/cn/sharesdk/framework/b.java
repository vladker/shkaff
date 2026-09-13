package cn.sharesdk.framework;

import A3.AbstractC0157z;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f2183a;
    private NetworkHelper b = new NetworkHelper();
    private String c = MobSDK.checkRequestUrl("api-share.mob.com");

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return AbstractC0157z.s(new StringBuilder(), this.c, "/conf5");
    }

    public static b a() {
        synchronized (b.class) {
            try {
                if (f2183a == null) {
                    synchronized (b.class) {
                        try {
                            if (f2183a == null) {
                                f2183a = new b();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f2183a;
    }

    public void b() {
        try {
            DH.requester(MobSDK.getContext()).getDeviceKey().getDetailNetworkTypeForStatic().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.b.1
                @Override // com.mob.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    try {
                        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                        String appkey = MobSDK.getAppkey();
                        if (TextUtils.isEmpty(appkey)) {
                            return;
                        }
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
                        HashMap mapFromJson = new Hashon().fromJson(b.this.b.httpPost(b.this.c(), arrayList, (KVPair<String>) null, arrayList2, networkTimeOut));
                        if (!mapFromJson.containsKey("error")) {
                            a.b = appkey;
                        } else if (String.valueOf(mapFromJson.get("error")).contains("'appkey' is illegal")) {
                            a.f2122a = true;
                        }
                    } catch (Throwable th) {
                        SSDKLog.b().a(androidx.exifinterface.media.a.n("updateServerConfig ", th), new Object[0]);
                    }
                }
            });
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }
}
