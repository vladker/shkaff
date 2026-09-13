package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Platform f2378a;
    private Platform.ShareParams b;
    private PlatformActionListener c;
    private AuthorizeListener d;
    private h e;

    public k(Platform platform) {
        this.f2378a = platform;
    }

    public void a(AuthorizeListener authorizeListener) {
        this.d = authorizeListener;
    }

    public Platform b() {
        return this.f2378a;
    }

    public PlatformActionListener c() {
        return this.c;
    }

    public void a(Platform.ShareParams shareParams, PlatformActionListener platformActionListener) {
        this.b = shareParams;
        this.c = platformActionListener;
    }

    public void a(h hVar) {
        this.e = hVar;
    }

    public void a(WechatResp wechatResp) {
        AuthorizeListener authorizeListener;
        PlatformActionListener platformActionListener;
        PlatformActionListener platformActionListener2;
        int i5 = wechatResp.f2358g;
        if (i5 == -4) {
            HashMap map = new HashMap();
            map.put("errCode", Integer.valueOf(wechatResp.f2358g));
            map.put("errStr", wechatResp.f2359h);
            map.put("transaction", wechatResp.f2360i);
            Throwable th = new Throwable(new Hashon().fromHashMap(map));
            if (wechatResp.a() == 1 && (authorizeListener = this.d) != null) {
                authorizeListener.onError(th);
                return;
            }
            return;
        }
        if (i5 == -3) {
            HashMap map2 = new HashMap();
            map2.put("errCode", Integer.valueOf(wechatResp.f2358g));
            map2.put("errStr", wechatResp.f2359h);
            map2.put("transaction", wechatResp.f2360i);
            Throwable th2 = new Throwable(new Hashon().fromHashMap(map2));
            int iA = wechatResp.a();
            if (iA != 1) {
                if (iA == 2 && (platformActionListener = this.c) != null) {
                    platformActionListener.onError(this.f2378a, 9, th2);
                    return;
                }
                return;
            }
            AuthorizeListener authorizeListener2 = this.d;
            if (authorizeListener2 != null) {
                authorizeListener2.onError(th2);
                return;
            }
            return;
        }
        if (i5 == -2) {
            int iA2 = wechatResp.a();
            if (iA2 != 1) {
                if (iA2 == 2 && (platformActionListener2 = this.c) != null) {
                    platformActionListener2.onCancel(this.f2378a, 9);
                    return;
                }
                return;
            }
            AuthorizeListener authorizeListener3 = this.d;
            if (authorizeListener3 != null) {
                authorizeListener3.onCancel();
                return;
            }
            return;
        }
        if (i5 != 0) {
            HashMap map3 = new HashMap();
            map3.put("req", wechatResp.getClass().getSimpleName());
            map3.put("errCode", Integer.valueOf(wechatResp.f2358g));
            map3.put("errStr", wechatResp.f2359h);
            map3.put("transaction", wechatResp.f2360i);
            Throwable th3 = new Throwable(new Hashon().fromHashMap(map3));
            PlatformActionListener platformActionListener3 = this.c;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this.f2378a, 9, th3);
            }
            AuthorizeListener authorizeListener4 = this.d;
            if (authorizeListener4 != null) {
                authorizeListener4.onError(th3);
                return;
            }
            return;
        }
        int iA3 = wechatResp.a();
        if (iA3 != 1) {
            if (iA3 == 2 && this.c != null) {
                HashMap<String, Object> map4 = new HashMap<>();
                map4.put("ShareParams", this.b);
                this.c.onComplete(this.f2378a, 9, map4);
                return;
            }
            return;
        }
        if (this.d != null) {
            Bundle bundle = new Bundle();
            wechatResp.b(bundle);
            this.e.a(bundle, this.d);
        }
    }

    public Platform.ShareParams a() {
        return this.b;
    }
}
