package cn.sharesdk.google;

import A3.AbstractC0157z;
import android.content.Intent;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.network.SSDKNetworkHelper;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.android.gms.common.Scopes;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class a extends f {
    private static a b;
    private SSDKNetworkHelper c;
    private ShareActivity d;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f2274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String[] f2276i;

    private a(Platform platform) {
        super(platform);
        this.f2276i = new String[]{Scopes.OPEN_ID, Scopes.PROFILE, "email"};
        this.d = new ShareActivity();
        this.c = SSDKNetworkHelper.getInstance();
    }

    public static synchronized a a(Platform platform) {
        try {
            if (b == null) {
                b = new a(platform);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public String b(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("code", str));
        arrayList.add(new KVPair<>("client_id", this.e));
        arrayList.add(new KVPair<>("redirect_uri", this.f2274g));
        arrayList.add(new KVPair<>("client_secret", this.f2273f));
        arrayList.add(new KVPair<>("grant_type", "authorization_code"));
        return this.c.httpPost("https://www.googleapis.com/oauth2/v4/token", arrayList, "/oauth2/v4/token", b());
    }

    public void c(String str) {
        this.f2275h = str;
    }

    public HashMap<String, Object> d(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(this.f2275h)) {
            SSDKLog.b().a("GoogleHelper getUserInfo access_token is null");
        } else {
            arrayList.add(new KVPair<>("access_token", this.f2275h));
        }
        String strHttpGet = this.c.httpGet("https://www.googleapis.com/oauth2/v3/userinfo", arrayList, "/oauth2/v3/userinfo", b());
        if (strHttpGet != null) {
            return new Hashon().fromJson(strHttpGet);
        }
        return null;
    }

    public HashMap<String, Object> e(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        String str2 = this.f2275h;
        if (str2 != null) {
            arrayList.add(new KVPair<>("access_token", str2));
        }
        String strHttpGet = this.c.httpGet(AbstractC0157z.o("https://www.googleapis.com/plus/v1/people/", str, "/people/visible"), arrayList, "/people/visible", b());
        if (strHttpGet != null) {
            return new Hashon().fromJson(strHttpGet);
        }
        return null;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair("response_type", "code"));
        arrayList.add(new KVPair("client_id", this.e));
        arrayList.add(new KVPair("redirect_uri", this.f2274g));
        String[] strArr = this.f2276i;
        if (strArr != null && strArr.length > 0) {
            arrayList.add(new KVPair("scope", TextUtils.join(" ", strArr)));
        }
        return "https://accounts.google.com/o/oauth2/auth?" + ResHelper.encodeUrl((ArrayList<KVPair<String>>) arrayList);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(WebAuthorizeActivity webAuthorizeActivity) {
        return new GooglePlusAuthorizeWebviewClient(webAuthorizeActivity);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return this.f2274g;
    }

    public void c() {
        ShareActivity shareActivity = this.d;
        if (shareActivity != null) {
            shareActivity.finish();
        }
    }

    public void a(String str, String str2) {
        this.e = str;
        this.f2273f = str2;
    }

    public void a(String str) {
        this.f2274g = str;
    }

    public void a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.f2276i = strArr;
    }

    public void a(AuthorizeListener authorizeListener) {
        b(authorizeListener);
    }

    public void a(String[] strArr, PlatformActionListener platformActionListener, PlatformDb platformDb) {
        Intent intent = new Intent();
        intent.putExtra("action", 0);
        this.d.setPlatformActionListener(this.f2190a, platformActionListener, platformDb);
        this.d.show(MobSDK.getContext(), intent);
    }

    public void a() {
        Intent intent = new Intent();
        intent.putExtra("action", 2);
        this.d.show(MobSDK.getContext(), intent);
    }
}
