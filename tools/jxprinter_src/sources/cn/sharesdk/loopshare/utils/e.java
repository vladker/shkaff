package cn.sharesdk.loopshare.utils;

import A3.AbstractC0157z;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.sharesdk.loopshare.MobLink;
import cn.sharesdk.loopshare.beans.ConfigData;
import cn.sharesdk.loopshare.beans.LinkData;
import cn.sharesdk.loopshare.beans.LogData;
import cn.sharesdk.loopshare.beans.SceneData;
import cn.sharesdk.loopshare.beans.ServerData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.RxMob;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2326a;
    private static Hashon b;
    private static ConfigData c;
    private static final String d;
    private static final String e;

    static {
        a(MobSDK.getContext());
        d = "http://api.applink.mob.com";
        e = "http://api.applink.mob.com";
    }

    private static String e() {
        return androidx.collection.a.n(c(a()), "/client/link");
    }

    private static String f() {
        return androidx.collection.a.n(c(a()), "/client/reco");
    }

    private static String g() {
        return androidx.collection.a.n(d(a()), "/client/log");
    }

    private static String h() {
        return androidx.collection.a.n(d(a()), "/client/ul");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i() {
        if (TextUtils.isEmpty(f2326a)) {
            synchronized (e.class) {
                TextUtils.isEmpty(f2326a);
            }
        }
        return f2326a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(boolean z6) {
        return androidx.collection.a.n(z6 ? d : c(a()), "/client/conf");
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0027  */
    private static String c(ConfigData configData) {
        String strM;
        if (e(configData)) {
            String strB = configData.b();
            String strValueOf = String.valueOf(configData.c());
            if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strValueOf)) {
                strM = null;
            } else {
                strM = androidx.exifinterface.media.a.m("http://", strB, ParameterizedMessage.ERROR_MSG_SEPARATOR, strValueOf);
            }
        } else {
            strM = null;
        }
        return TextUtils.isEmpty(strM) ? d : strM;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0027  */
    private static String d(ConfigData configData) {
        String strM;
        if (e(configData)) {
            String strF = configData.f();
            String strValueOf = String.valueOf(configData.g());
            if (TextUtils.isEmpty(strF) || !TextUtils.isEmpty(strValueOf)) {
                strM = null;
            } else {
                strM = androidx.exifinterface.media.a.m("http://", strF, ParameterizedMessage.ERROR_MSG_SEPARATOR, strValueOf);
            }
        } else {
            strM = null;
        }
        return TextUtils.isEmpty(strM) ? e : strM;
    }

    public static void a(Context context) {
        b = new Hashon();
    }

    public static LinkData a(String str, HashMap<String, Object> map) {
        HashMap map2 = new HashMap();
        map2.put("appkey", MobSDK.getAppkey());
        map2.put("plat", 1);
        map2.put("sysver", DH.SyncMtd.getOSVersionName());
        map2.put("appver", DH.SyncMtd.getAppVersionName());
        map2.put(NetCommunicator.KEY_DUID, i());
        map2.put("path", str);
        map2.put("params", map);
        return (LinkData) b(map2, b(e()), LinkData.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(ConfigData configData) {
        return configData != null && ServerData.a(configData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends ServerData> T b(HashMap<String, Object> map, String str, Class<T> cls) {
        HashMap map2 = new HashMap();
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, AbstractC0157z.n("url:", str));
        try {
            Object objRequestSynchronized = new MobCommunicator(1024, "d6c42369216f886092bea6cc42977ec0b917508b9d21e2e3b3447d47f500551ddcf1b41a294f081da5fad98b270fd8b99479a5958db8528f9231a4156742b847", "160cb541521f5eafde6138e6c1a3583f529cba9c06618f373e7923460ec5adf715b1d49fda021d6f227e6c7f1c456d4914988d6748b6aab17226f91be6825a730dd0b6aed2f06c877d655bd8c165f60792c518280a46c1695da131f8e4a6c0d5bd1b1ab34f2ec96bae2d796272d1f099a05af736a81b1c6a5969b5a0618abde5").requestSynchronized(map, str, false);
            map2.put(NotificationCompat.CATEGORY_STATUS, 200);
            map2.put("res", objRequestSynchronized);
        } catch (Throwable th) {
            if (!(th instanceof MobCommunicator.NetworkError)) {
                map2.put(NotificationCompat.CATEGORY_STATUS, 10000);
                map2.put("error", th.getMessage());
            } else {
                map2 = b.fromJson(th.getMessage());
            }
        }
        return (T) b.fromJson(b.fromHashMap(map2), cls);
    }

    public static SceneData a(int i5) {
        HashMap map = new HashMap();
        map.put("appkey", MobSDK.getAppkey());
        map.put("plat", "1");
        map.put("sysver", DH.SyncMtd.getOSVersionName());
        map.put("sdkver", Integer.valueOf(MobLink.getSdkVersion()));
        map.put("appver", DH.SyncMtd.getAppVersionName());
        map.put("model", DH.SyncMtd.getModel());
        map.put(NetCommunicator.KEY_DUID, i());
        map.put("run", Integer.valueOf(Math.min(2, i5)));
        return (SceneData) b(map, b(f()), SceneData.class);
    }

    public static LogData a(String str, int i5, int i6) {
        HashMap map = new HashMap();
        map.put("appkey", MobSDK.getAppkey());
        map.put("plat", 1);
        map.put("link", str);
        map.put("sysver", DH.SyncMtd.getOSVersionName());
        map.put("sdkver", Integer.valueOf(MobLink.getSdkVersion()));
        map.put("appver", DH.SyncMtd.getAppVersionName());
        map.put("apppkg", DH.SyncMtd.getPackageName());
        map.put("model", DH.SyncMtd.getModel());
        map.put(NetCommunicator.KEY_DUID, i());
        map.put(FirebaseAnalytics.Param.SOURCE, Integer.valueOf(i5));
        map.put(FirebaseAnalytics.Param.SOURCE, Integer.valueOf(i6));
        return (LogData) b(map, b(g()), LogData.class);
    }

    public static ConfigData b() {
        return c;
    }

    public static String b(String str) {
        try {
            return MobSDK.checkRequestUrl(str);
        } catch (Throwable unused) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "checkHttpRequestUrl method of MobSDK is exception");
            return "";
        }
    }

    public static ConfigData a() {
        if (c == null) {
            final String sdkTag = MobLink.getSdkTag();
            if ("event_id_config".equals(EventRecorder.checkRecord(sdkTag))) {
                f.a("");
            }
            EventRecorder.prepare();
            EventRecorder.clear();
            EventRecorder.addBegin(sdkTag, "event_id_config");
            String strB = f.b();
            ConfigData configData = !TextUtils.isEmpty(strB) ? (ConfigData) b.fromJson(strB, ConfigData.class) : null;
            c = configData;
            boolean zE = e(configData);
            final boolean z6 = !zE;
            RxMob.Subscribable subscribableCreate = RxMob.create(new RxMob.QuickSubscribe<ConfigData>() { // from class: cn.sharesdk.loopshare.utils.Protocol$1
                @Override // com.mob.tools.RxMob.QuickSubscribe
                public void doNext(RxMob.Subscriber<ConfigData> subscriber) {
                    boolean zB = AppStatus.a().b();
                    HashMap map = new HashMap();
                    map.put("appkey", MobSDK.getAppkey());
                    map.put("plat", "1");
                    map.put("sysver", DH.SyncMtd.getOSVersionName());
                    map.put("appver", DH.SyncMtd.getAppVersionName());
                    map.put("apppkg", DH.SyncMtd.getPackageName());
                    map.put("model", DH.SyncMtd.getModel());
                    map.put(NetCommunicator.KEY_DUID, e.i());
                    map.put(NotificationCompat.CATEGORY_STATUS, String.valueOf(zB));
                    subscriber.onNext((ConfigData) e.b(map, e.b(e.b(z6)), ConfigData.class));
                }
            });
            subscribableCreate.subscribeOn(!zE ? RxMob.Thread.IMMEDIATE : RxMob.Thread.NEW_THREAD);
            subscribableCreate.observeOn(RxMob.Thread.IMMEDIATE);
            subscribableCreate.subscribe(new RxMob.Subscriber<ConfigData>() { // from class: cn.sharesdk.loopshare.utils.Protocol$2
                @Override // com.mob.tools.RxMob.Subscriber
                public void onNext(ConfigData configData2) {
                    if (e.e(configData2)) {
                        f.a(e.b.fromObject(configData2));
                    }
                    EventRecorder.addEnd(sdkTag, "event_id_config");
                    ConfigData unused = e.c = configData2;
                }
            });
        }
        return c;
    }

    public static SceneData a(String str) {
        HashMap map = new HashMap();
        map.put("appkey", MobSDK.getAppkey());
        map.put("plat", 1);
        map.put("link", str);
        map.put("sysver", DH.SyncMtd.getOSVersionName());
        map.put("appver", DH.SyncMtd.getAppVersionName());
        map.put(NetCommunicator.KEY_DUID, i());
        return (SceneData) b(map, b(h()), SceneData.class);
    }
}
