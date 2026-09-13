package cn.sharesdk.wechat.utils;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2414f;

    public abstract int a();

    public void a(Bundle bundle) {
        this.e = n.a(bundle, "_wxapi_basereq_transaction");
        this.f2414f = n.a(bundle, "_wxapi_basereq_openid");
    }

    public void b(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", a());
        bundle.putString("_wxapi_basereq_transaction", this.e);
        bundle.putString("_wxapi_basereq_openid", this.f2414f);
    }

    public abstract boolean b();
}
