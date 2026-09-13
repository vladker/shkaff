package cn.sharesdk.wechat.utils;

import A3.AbstractC0157z;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.network.SSDKNetworkHelper;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.android.gms.common.Scopes;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2369a;
    private String b;
    private SSDKNetworkHelper c = SSDKNetworkHelper.getInstance();
    private Platform d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2370f;

    public h(Platform platform, int i5) {
        this.d = platform;
        this.e = i5;
    }

    public void a(String str, String str2) {
        this.f2369a = str;
        this.b = str2;
    }

    public void a(boolean z6) {
        this.f2370f = z6;
    }

    public void a(Bundle bundle, AuthorizeListener authorizeListener) {
        String string = bundle.getString("_wxapi_sendauth_resp_url");
        if (TextUtils.isEmpty(string)) {
            if (authorizeListener != null) {
                authorizeListener.onError(null);
                return;
            }
            return;
        }
        int iIndexOf = string.indexOf("://oauth?");
        if (iIndexOf >= 0) {
            string = string.substring(iIndexOf + 1);
        }
        String string2 = ResHelper.urlToBundle(string).getString("code");
        if (this.f2370f) {
            this.d.getDb().putAuthCode(string2);
            authorizeListener.onComplete(null);
            return;
        }
        try {
            a(string2, authorizeListener);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            if (authorizeListener != null) {
                authorizeListener.onError(th);
            }
        }
    }

    private void a(final String str, final AuthorizeListener authorizeListener) {
        SSDKLog.b().a(AbstractC0157z.n("getAuthorizeToken ==>> ", str), new Object[0]);
        new Thread() { // from class: cn.sharesdk.wechat.utils.h.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                    arrayList.add(new KVPair<>("appid", h.this.f2369a));
                    arrayList.add(new KVPair<>("secret", h.this.b));
                    arrayList.add(new KVPair<>("code", str));
                    arrayList.add(new KVPair<>("grant_type", "authorization_code"));
                    try {
                        String strHttpGet = h.this.c.httpGet("https://api.weixin.qq.com/sns/oauth2/access_token", arrayList, "/sns/oauth2/access_token", h.this.e);
                        if (TextUtils.isEmpty(strHttpGet)) {
                            authorizeListener.onError(new Throwable("Authorize token is empty"));
                            return;
                        }
                        if (!strHttpGet.contains("errcode")) {
                            h.this.a(strHttpGet);
                            authorizeListener.onComplete(null);
                        } else {
                            AuthorizeListener authorizeListener2 = authorizeListener;
                            if (authorizeListener2 != null) {
                                authorizeListener2.onError(new Throwable(strHttpGet));
                            }
                        }
                    } catch (Throwable th) {
                        authorizeListener.onError(th);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                }
            }
        }.start();
    }

    public boolean a() {
        String str = this.d.getDb().get("refresh_token");
        if (!TextUtils.isEmpty(this.f2369a) && !TextUtils.isEmpty(str)) {
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("appid", this.f2369a));
            arrayList.add(new KVPair<>("refresh_token", str));
            arrayList.add(new KVPair<>("grant_type", "refresh_token"));
            try {
                String strHttpGet = this.c.httpGet("https://api.weixin.qq.com/sns/oauth2/refresh_token", arrayList, "/sns/oauth2/refresh_token", this.e);
                if (TextUtils.isEmpty(strHttpGet) || strHttpGet.contains("errcode")) {
                    return false;
                }
                a(strHttpGet);
                return true;
            } catch (Throwable th) {
                SSDKLog.b().a(th);
            }
        }
        return false;
    }

    public void a(final PlatformActionListener platformActionListener) {
        new Thread() { // from class: cn.sharesdk.wechat.utils.h.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                int i5;
                HashMap<String, Object> map;
                try {
                    ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                    arrayList.add(new KVPair<>("access_token", h.this.d.getDb().getToken()));
                    arrayList.add(new KVPair<>(Scopes.OPEN_ID, h.this.d.getDb().get(Scopes.OPEN_ID)));
                    arrayList.add(new KVPair<>("lang", "zh_CN"));
                    String strHttpGet = h.this.c.httpGet("https://api.weixin.qq.com/sns/userinfo", arrayList, "/sns/userinfo", h.this.e);
                    if (TextUtils.isEmpty(strHttpGet)) {
                        PlatformActionListener platformActionListener2 = platformActionListener;
                        if (platformActionListener2 != null) {
                            platformActionListener2.onError(h.this.d, 8, new Throwable());
                            return;
                        }
                        return;
                    }
                    SSDKLog.b().a("getUserInfo ==>>" + strHttpGet, new Object[0]);
                    HashMap<String, Object> mapFromJson = new Hashon().fromJson(strHttpGet);
                    if (mapFromJson.containsKey("errcode") && ((Integer) mapFromJson.get("errcode")).intValue() != 0) {
                        if (platformActionListener != null) {
                            platformActionListener.onError(h.this.d, 8, new Throwable(new Hashon().fromHashMap(mapFromJson)));
                            return;
                        }
                        return;
                    }
                    String strValueOf = String.valueOf(mapFromJson.get(Scopes.OPEN_ID));
                    String strValueOf2 = String.valueOf(mapFromJson.get("nickname"));
                    try {
                        i5 = ResHelper.parseInt(String.valueOf(mapFromJson.get("sex")));
                    } catch (Throwable th) {
                        SSDKLog.b().a(th);
                        i5 = 2;
                    }
                    String strValueOf3 = String.valueOf(mapFromJson.get("province"));
                    String strValueOf4 = String.valueOf(mapFromJson.get("city"));
                    String strValueOf5 = String.valueOf(mapFromJson.get("country"));
                    String strValueOf6 = String.valueOf(mapFromJson.get("headimgurl"));
                    String strValueOf7 = String.valueOf(mapFromJson.get("unionid"));
                    h.this.d.getDb().put("nickname", strValueOf2);
                    if (i5 == 1) {
                        h.this.d.getDb().put("gender", "0");
                    } else if (i5 == 2) {
                        h.this.d.getDb().put("gender", "1");
                    } else {
                        h.this.d.getDb().put("gender", ExifInterface.GPS_MEASUREMENT_2D);
                    }
                    h.this.d.getDb().putUserId(strValueOf);
                    h.this.d.getDb().put("icon", strValueOf6);
                    h.this.d.getDb().put("province", strValueOf3);
                    h.this.d.getDb().put("city", strValueOf4);
                    h.this.d.getDb().put("country", strValueOf5);
                    h.this.d.getDb().put(Scopes.OPEN_ID, strValueOf);
                    h.this.d.getDb().put("unionid", strValueOf7);
                    if (h.this.d.getDb().get("userTags") != null) {
                        map = mapFromJson;
                        map.put("userTags", h.this.d.getDb().get("userTags"));
                    } else {
                        map = mapFromJson;
                    }
                    platformActionListener.onComplete(h.this.d, 8, map);
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        SSDKLog.b().a(AbstractC0157z.n("wechat getAuthorizeToken ==>>", str), new Object[0]);
        HashMap mapFromJson = new Hashon().fromJson(str);
        String strValueOf = String.valueOf(mapFromJson.get("access_token"));
        String strValueOf2 = String.valueOf(mapFromJson.get("refresh_token"));
        String strValueOf3 = String.valueOf(mapFromJson.get("expires_in"));
        this.d.getDb().put(Scopes.OPEN_ID, String.valueOf(mapFromJson.get(Scopes.OPEN_ID)));
        this.d.getDb().putExpiresIn(Long.valueOf(strValueOf3).longValue());
        this.d.getDb().putToken(strValueOf);
        this.d.getDb().put("refresh_token", strValueOf2);
    }
}
