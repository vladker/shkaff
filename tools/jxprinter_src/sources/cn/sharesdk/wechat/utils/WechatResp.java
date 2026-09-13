package cn.sharesdk.wechat.utils;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WechatResp {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f2359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f2361j;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ErrCode {
        public static final int ERR_AUTH_DENIED = -4;
        public static final int ERR_BAN = -6;
        public static final int ERR_COMM = -1;
        public static final int ERR_OK = 0;
        public static final int ERR_SENT_FAILED = -3;
        public static final int ERR_UNSUPPORT = -5;
        public static final int ERR_USER_CANCEL = -2;
    }

    public abstract int a();

    public void a(Bundle bundle) {
        this.f2358g = bundle.getInt("_wxapi_baseresp_errcode");
        this.f2359h = bundle.getString("_wxapi_baseresp_errstr");
        this.f2360i = bundle.getString("_wxapi_baseresp_transaction");
        this.f2361j = bundle.getString("_wxapi_baseresp_openId");
    }

    public void b(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", a());
        bundle.putInt("_wxapi_baseresp_errcode", this.f2358g);
        bundle.putString("_wxapi_baseresp_errstr", this.f2359h);
        bundle.putString("_wxapi_baseresp_transaction", this.f2360i);
        bundle.putString("_wxapi_baseresp_openId", this.f2361j);
    }
}
