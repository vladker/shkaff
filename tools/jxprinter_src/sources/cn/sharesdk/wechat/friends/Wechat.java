package cn.sharesdk.wechat.friends;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.b.j;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.wechat.utils.WechatClientNotExistException;
import cn.sharesdk.wechat.utils.h;
import cn.sharesdk.wechat.utils.k;
import cn.sharesdk.wechat.utils.l;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Wechat extends Platform {
    public static final String NAME = "Wechat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2348a;
    private String b;
    private boolean c;
    private String d;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2350g;

    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i5, Object obj) {
        if (i5 == 9 || isAuthValid() || c()) {
            return true;
        }
        String authCode = this.db.getAuthCode();
        if (this.needAuthCode && !TextUtils.isEmpty(authCode)) {
            return true;
        }
        if (!TextUtils.isEmpty(getDb().get("refresh_token"))) {
            try {
                h hVar = new h(this, 22);
                hVar.a(this.f2348a, this.b);
                if (hVar.a()) {
                    return true;
                }
            } catch (Exception e) {
                SSDKLog.b().a(e);
            }
        }
        innerAuthorize(i5, obj);
        return false;
    }

    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        if (TextUtils.isEmpty(this.f2348a) || TextUtils.isEmpty(this.b)) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
                return;
            }
            return;
        }
        l lVarA = l.a();
        lVarA.c(this.f2348a);
        if (!this.isClientValid) {
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 1, new WechatClientNotExistException());
                return;
            }
            return;
        }
        h hVar = new h(this, 22);
        hVar.a(this.f2348a, this.b);
        hVar.a(this.needAuthCode);
        k kVar = new k(this);
        kVar.a(hVar);
        kVar.a(new AuthorizeListener() { // from class: cn.sharesdk.wechat.friends.Wechat.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (((Platform) Wechat.this).listener != null) {
                    ((Platform) Wechat.this).listener.onCancel(Wechat.this, 1);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                if (!((Platform) Wechat.this).needAuthCode) {
                    Wechat.this.afterRegister(1, null);
                } else if (((Platform) Wechat.this).listener != null) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("authCode", ((Platform) Wechat.this).db.getAuthCode());
                    ((Platform) Wechat.this).listener.onComplete(Wechat.this, 1, map);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (((Platform) Wechat.this).listener != null) {
                    ((Platform) Wechat.this).listener.onError(Wechat.this, 1, th);
                }
            }
        });
        try {
            lVarA.a(kVar);
        } catch (Throwable th) {
            if (this.listener != null) {
                this.listener.onError(this, 1, th);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i5, HashMap<String, Object> map, HashMap<String, String> map2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, i5);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        SSDKLog.b().a("Wechat start Share with Appid:" + this.f2348a + "appSecret:" + this.b, new Object[0]);
        SSDKLog sSDKLogB = SSDKLog.b();
        StringBuilder sb = new StringBuilder("Wechat ShareParams:");
        sb.append(shareParams.toString());
        sSDKLogB.a(sb.toString(), new Object[0]);
        if (!this.isClientValid) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 9, new WechatClientNotExistException());
                return;
            }
            return;
        }
        shareParams.set("scene", 0);
        l lVarA = l.a();
        this.e = TextUtils.isEmpty(shareParams.getWxPath()) ? this.e : shareParams.getWxPath();
        this.d = TextUtils.isEmpty(shareParams.getWxUserName()) ? this.d : shareParams.getWxUserName();
        this.f2349f = !shareParams.toMap().containsKey("wxWithShareTicket") ? this.f2349f : shareParams.getWxWithShareTicket();
        this.f2350g = !shareParams.toMap().containsKey("wxMiniProgramType") ? this.f2350g : shareParams.getWxMiniProgramType();
        lVarA.a(this.e);
        lVarA.b(this.d);
        lVarA.a(this.f2349f);
        lVarA.a(this.f2350g);
        lVarA.c(this.f2348a);
        k kVar = new k(this);
        if (this.c) {
            try {
                lVarA.a(kVar, shareParams, this.listener);
                return;
            } catch (Throwable th) {
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this, 9, th);
                    return;
                }
                return;
            }
        }
        kVar.a(shareParams, this.listener);
        try {
            lVarA.c(kVar);
        } catch (Throwable th2) {
            if (this.listener != null) {
                this.listener.onError(this, 9, th2);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> filterFriendshipInfo(int i5, HashMap<String, Object> map) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public j.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        j.a aVar = new j.a();
        String text = shareParams.getText();
        aVar.b = text;
        String imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        Bitmap imageData = shareParams.getImageData();
        if (!TextUtils.isEmpty(imageUrl)) {
            aVar.d.add(imageUrl);
        } else if (imagePath != null) {
            aVar.e.add(imagePath);
        } else if (imageData != null) {
            aVar.f2155f.add(imageData);
        }
        String url = shareParams.getUrl();
        if (url != null) {
            aVar.c.add(url);
        }
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("title", shareParams.getTitle());
        map2.put("url", url);
        map2.put("extInfo", null);
        map2.put(FirebaseAnalytics.Param.CONTENT, text);
        map2.put("image", aVar.d);
        map2.put("musicFileUrl", url);
        aVar.f2156g = map2;
        return aVar;
    }

    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 6);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getBilaterals(int i5, int i6, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowers(int i5, int i6, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowings(int i5, int i6, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i5, int i6, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 2);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 22;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return !this.c;
    }

    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f2348a = getDevinfo("AppId");
        this.b = getDevinfo("AppSecret");
        this.c = "true".equals(getDevinfo("BypassApproval"));
        this.d = getDevinfo(TextUtils.isEmpty(getDevinfo("UserName")) ? "userName" : "UserName");
        this.e = getDevinfo(TextUtils.isEmpty(getDevinfo("Path")) ? "path" : "Path");
        this.f2349f = "true".equals(getDevinfo("WithShareTicket"));
        try {
            this.f2350g = Integer.valueOf(getDevinfo("MiniprogramType")).intValue();
        } catch (Throwable unused) {
            this.f2350g = 0;
        }
        String str2 = this.f2348a;
        if (str2 == null || str2.length() <= 0) {
            this.f2348a = getDevinfo("WechatMoments", "AppId");
            this.c = "true".equals(getDevinfo("WechatMoments", "BypassApproval"));
            String str3 = this.f2348a;
            if (str3 != null && str3.length() > 0) {
                copyDevinfo("WechatMoments", NAME);
                this.f2348a = getDevinfo("AppId");
                this.c = "true".equals(getDevinfo("BypassApproval"));
                SSDKLog.b().a("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
                return;
            }
            String devinfo = getDevinfo("WechatFavorite", "AppId");
            this.f2348a = devinfo;
            if (devinfo == null || devinfo.length() <= 0) {
                return;
            }
            copyDevinfo("WechatFavorite", NAME);
            this.f2348a = getDevinfo("AppId");
            SSDKLog.b().a("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void isClientValid(ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            l lVarA = l.a();
            lVarA.c(this.f2348a);
            lVarA.b(shareSDKCallback);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f2348a = getNetworkDevinfo("app_id", "AppId");
        this.b = getNetworkDevinfo("app_secret", "AppSecret");
        String str = this.f2348a;
        if (str == null || str.length() <= 0) {
            String networkDevinfo = getNetworkDevinfo(23, "app_id", "AppId");
            this.f2348a = networkDevinfo;
            if (networkDevinfo == null || networkDevinfo.length() <= 0) {
                String networkDevinfo2 = getNetworkDevinfo(37, "app_id", "AppId");
                this.f2348a = networkDevinfo2;
                if (networkDevinfo2 != null && networkDevinfo2.length() > 0) {
                    copyNetworkDevinfo(37, 22);
                    this.f2348a = getNetworkDevinfo("app_id", "AppId");
                    SSDKLog.b().a("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
                }
            } else {
                copyNetworkDevinfo(23, 22);
                this.f2348a = getNetworkDevinfo("app_id", "AppId");
                SSDKLog.b().a("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
            }
        }
        String str2 = this.b;
        if (str2 == null || str2.length() <= 0) {
            String networkDevinfo3 = getNetworkDevinfo(23, "app_secret", "AppSecret");
            this.b = networkDevinfo3;
            if (networkDevinfo3 != null && networkDevinfo3.length() > 0) {
                copyNetworkDevinfo(23, 22);
                this.b = getNetworkDevinfo("app_secret", "AppSecret");
                SSDKLog.b().a("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
                return;
            }
            String networkDevinfo4 = getNetworkDevinfo(37, "app_secret", "AppSecret");
            this.b = networkDevinfo4;
            if (networkDevinfo4 == null || networkDevinfo4.length() <= 0) {
                return;
            }
            copyNetworkDevinfo(37, 22);
            this.b = getNetworkDevinfo("app_secret", "AppSecret");
            SSDKLog.b().a("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void subscribeAuth(Platform.ShareParams shareParams) {
        if (TextUtils.isEmpty(this.f2348a) || TextUtils.isEmpty(this.b)) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
                return;
            }
            return;
        }
        l lVarA = l.a();
        lVarA.c(this.f2348a);
        if (!this.isClientValid) {
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 1, new WechatClientNotExistException());
                return;
            }
            return;
        }
        k kVar = new k(this);
        kVar.a(shareParams, this.listener);
        try {
            lVarA.b(kVar);
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onComplete(this, 9, null);
            }
            SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "subscribeAuth start on Wechat");
        } catch (Throwable th) {
            PlatformActionListener platformActionListener4 = this.listener;
            if (platformActionListener4 != null) {
                platformActionListener4.onError(this, 1, th);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void timeline(int i5, int i6, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 7);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void userInfor(String str) {
        if (TextUtils.isEmpty(this.f2348a) || TextUtils.isEmpty(this.b)) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
                return;
            }
            return;
        }
        if (this.needAuthCode) {
            String authCode = this.db.getAuthCode();
            if (TextUtils.isEmpty(authCode)) {
                this.listener.onError(this, 8, new Throwable("code is empty"));
                return;
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("authCode", authCode);
            this.listener.onComplete(this, 8, map);
            return;
        }
        h hVar = new h(this, 22);
        hVar.a(this.f2348a, this.b);
        try {
            hVar.a(this.listener);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 8, th);
            }
        }
    }

    private boolean c() {
        if (TextUtils.isEmpty(getDb().get("refresh_token"))) {
            return false;
        }
        h hVar = new h(this, 22);
        hVar.a(this.f2348a, this.b);
        return hVar.a();
    }
}
