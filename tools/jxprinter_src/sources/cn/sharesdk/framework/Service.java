package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Service {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class ServiceEvent {
        private static final int PLATFORM = 1;
        protected Service service;

        public ServiceEvent(Service service) {
            this.service = service;
        }

        public HashMap<String, Object> filterShareContent(int i5, Platform.ShareParams shareParams, HashMap<String, Object> map) {
            Platform platform;
            try {
                platform = ShareSDK.getPlatform(ShareSDK.platformIdToName(i5));
            } catch (Throwable th) {
                SSDKLog.b().a(androidx.exifinterface.media.a.n("ShareSDK Service filterShareContent catch: ", th), new Object[0]);
                platform = null;
            }
            if (platform == null) {
                return null;
            }
            cn.sharesdk.framework.a.b.j.a aVarFilterShareContent = platform.filterShareContent(shareParams, map);
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("shareID", aVarFilterShareContent.f2154a);
            map2.put("shareContent", new Hashon().fromJson(aVarFilterShareContent.toString()));
            SSDKLog.b().c("filterShareContent ==>>%s", map2);
            return map2;
        }

        public final void toString(final ShareSDKCallback<String> shareSDKCallback) {
            DH.requester(MobSDK.getContext()).getDeviceDataNotAES().getDetailNetworkTypeForStatic().getDeviceKey().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.Service.ServiceEvent.1
                @Override // com.mob.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    try {
                        HashMap map = new HashMap();
                        map.put("deviceid", dHResponse.getDeviceKey());
                        map.put("appkey", MobSDK.getAppkey());
                        map.put("apppkg", DH.SyncMtd.getPackageName());
                        map.put("appver", Integer.valueOf(DH.SyncMtd.getAppVersion()));
                        map.put("sdkver", Integer.valueOf(ServiceEvent.this.service.getServiceVersionInt()));
                        map.put("plat", 1);
                        map.put("networktype", dHResponse.getDetailNetworkTypeForStatic());
                        map.put("deviceData", dHResponse.getDeviceDataNotAES());
                        shareSDKCallback.onCallback(new Hashon().fromHashMap(map));
                    } catch (Throwable th) {
                        SSDKLog.b().a(th);
                    }
                }
            });
        }
    }

    @Deprecated
    public String getDeviceKey() {
        return null;
    }

    public abstract int getServiceVersionInt();

    public abstract String getServiceVersionName();

    public void getDeviceKey(final ShareSDKCallback<String> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getDeviceKey().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.Service.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                String deviceKey = dHResponse.getDeviceKey();
                if (TextUtils.isEmpty(deviceKey)) {
                    ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                    if (shareSDKCallback2 != null) {
                        shareSDKCallback2.onCallback(null);
                        return;
                    }
                    return;
                }
                ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                if (shareSDKCallback3 != null) {
                    shareSDKCallback3.onCallback(deviceKey);
                }
            }
        });
    }

    public void onBind() {
    }

    public void onUnbind() {
    }
}
