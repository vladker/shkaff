package cn.sharesdk.wechat.utils;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class c extends WechatResp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2364a;
    public String b;
    public String c;
    public String d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2365f = false;

    public c(Bundle bundle) {
        a(bundle);
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    public int a() {
        return 1;
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    public void b(Bundle bundle) {
        super.b(bundle);
        bundle.putString("_wxapi_sendauth_resp_token", this.f2364a);
        bundle.putString("_wxapi_sendauth_resp_state", this.b);
        bundle.putString("_wxapi_sendauth_resp_url", this.c);
        bundle.putString("_wxapi_sendauth_resp_lang", this.d);
        bundle.putString("_wxapi_sendauth_resp_country", this.e);
        bundle.putBoolean("_wxapi_sendauth_resp_auth_result", this.f2365f);
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f2364a = bundle.getString("_wxapi_sendauth_resp_token");
        this.b = bundle.getString("_wxapi_sendauth_resp_state");
        this.c = bundle.getString("_wxapi_sendauth_resp_url");
        this.d = bundle.getString("_wxapi_sendauth_resp_lang");
        this.e = bundle.getString("_wxapi_sendauth_resp_country");
        this.f2365f = bundle.getBoolean("_wxapi_sendauth_resp_auth_result");
    }
}
