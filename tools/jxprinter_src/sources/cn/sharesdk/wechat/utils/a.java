package cn.sharesdk.wechat.utils;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2362a;
    public int b = -1;

    public void a(Bundle bundle) {
        bundle.putString("_wxapi_sendauth_options_callback_classname", this.f2362a);
        bundle.putInt("_wxapi_sendauth_options_callback_flags", this.b);
    }

    public void b(Bundle bundle) {
        this.f2362a = n.a(bundle, "_wxapi_sendauth_options_callback_classname");
        this.b = n.a(bundle, "_wxapi_sendauth_options_callback_flags", -1);
    }
}
