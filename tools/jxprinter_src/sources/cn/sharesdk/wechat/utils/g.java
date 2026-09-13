package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class g extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2368a;
    public String b;
    public String c;

    @Override // cn.sharesdk.wechat.utils.m
    public int a() {
        return 18;
    }

    @Override // cn.sharesdk.wechat.utils.m
    public void b(Bundle bundle) {
        super.b(bundle);
        bundle.putInt("_wxapi_subscribemessage_req_scene", this.f2368a);
        bundle.putString("_wxapi_subscribemessage_req_templateid", this.b);
        bundle.putString("_wxapi_subscribemessage_req_reserved", this.c);
    }

    @Override // cn.sharesdk.wechat.utils.m
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f2368a = bundle.getInt("_wxapi_subscribemessage_req_scene");
        this.b = bundle.getString("_wxapi_subscribemessage_req_templateid");
        this.c = bundle.getString("_wxapi_subscribemessage_req_reserved");
    }

    @Override // cn.sharesdk.wechat.utils.m
    public boolean b() {
        String str = this.b;
        if (str != null && str.length() != 0) {
            if (this.b.length() > 1024) {
                SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, "MicroMsg.SDK.SubscribeMessage.ReqcheckArgs fail, templateID is too long");
                return false;
            }
            String str2 = this.c;
            if (str2 == null || str2.length() <= 1024) {
                return true;
            }
            SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, "MicroMsg.SDK.SubscribeMessage.ReqcheckArgs fail, reserved is too long");
            return false;
        }
        SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, "MicroMsg.SDK.SubscribeMessage.ReqcheckArgs fail, templateID is null");
        return false;
    }
}
