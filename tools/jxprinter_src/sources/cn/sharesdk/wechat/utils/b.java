package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class b extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2363a;
    public String b;
    public String c;
    public a d;

    @Override // cn.sharesdk.wechat.utils.m
    public int a() {
        return 1;
    }

    @Override // cn.sharesdk.wechat.utils.m
    public void b(Bundle bundle) {
        super.b(bundle);
        bundle.putString("_wxapi_sendauth_req_scope", this.f2363a);
        bundle.putString("_wxapi_sendauth_req_state", this.b);
        bundle.putString("_wxapi_sendauth_req_ext_data", this.c);
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(bundle);
        }
    }

    @Override // cn.sharesdk.wechat.utils.m
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f2363a = bundle.getString("_wxapi_sendauth_req_scope");
        this.b = bundle.getString("_wxapi_sendauth_req_state");
        this.c = bundle.getString("_wxapi_sendauth_req_ext_data");
        a aVar = new a();
        this.d = aVar;
        aVar.b(bundle);
    }

    @Override // cn.sharesdk.wechat.utils.m
    public boolean b() {
        String str = this.f2363a;
        if (str != null && str.length() != 0 && this.f2363a.length() <= 1024) {
            String str2 = this.b;
            if (str2 == null || str2.length() <= 1024) {
                return true;
            }
            SSDKLog.b().a("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, state is invalid");
            return false;
        }
        SSDKLog.b().a("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, scope is invalid");
        return false;
    }
}
