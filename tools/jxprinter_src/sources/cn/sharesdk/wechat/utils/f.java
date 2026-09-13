package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class f extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WXMediaMessage f2367a;
    public String b;
    public String c;

    public f(Bundle bundle) {
        a(bundle);
    }

    @Override // cn.sharesdk.wechat.utils.m
    public int a() {
        return 4;
    }

    @Override // cn.sharesdk.wechat.utils.m
    public void b(Bundle bundle) {
        Bundle bundleA = WXMediaMessage.a.a(this.f2367a);
        super.b(bundleA);
        bundle.putString("_wxapi_showmessage_req_lang", this.b);
        bundle.putString("_wxapi_showmessage_req_country", this.c);
        bundle.putAll(bundleA);
    }

    @Override // cn.sharesdk.wechat.utils.m
    public void a(Bundle bundle) {
        super.a(bundle);
        this.b = bundle.getString("_wxapi_showmessage_req_lang");
        this.c = bundle.getString("_wxapi_showmessage_req_country");
        this.f2367a = WXMediaMessage.a.a(bundle);
    }

    @Override // cn.sharesdk.wechat.utils.m
    public boolean b() {
        WXMediaMessage wXMediaMessage = this.f2367a;
        if (wXMediaMessage == null) {
            SSDKLog.b().a("checkArgs fail, message is null", new Object[0]);
            return false;
        }
        return wXMediaMessage.a();
    }
}
