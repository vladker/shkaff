package cn.sharesdk.framework;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.k;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Platform {
    public static final int ACTION_AUTHORIZING = 1;
    protected static final int ACTION_CUSTOMER = 655360;
    public static final int ACTION_FOLLOWING_USER = 6;
    protected static final int ACTION_GETTING_BILATERAL_LIST = 10;
    protected static final int ACTION_GETTING_FOLLOWER_LIST = 11;
    public static final int ACTION_GETTING_FRIEND_LIST = 2;
    public static final int ACTION_SENDING_DIRECT_MESSAGE = 5;
    public static final int ACTION_SHARE = 9;
    public static final int ACTION_TIMELINE = 7;
    public static final int ACTION_USER_INFOR = 8;
    public static final int CUSTOMER_ACTION_MASK = 65535;
    public static final int DY_MIXFILE = 23;
    public static final int GGP_REFUSE = 21;
    public static final int INSTAGRAM_FRIEND = 13;
    public static final int KAKAO_COMMERCE_TEMPLATE = 18;
    public static final int KAKAO_CUSTOM_TEMPLATE = 20;
    public static final int KAKAO_FEED_TEMPLATE = 16;
    public static final int KAKAO_TEXT_TEMPLATE = 19;
    public static final int KAKAO_URL_TEMPLATE = 17;
    public static final int OPEN_QQMINIPROGRAM = 22;
    public static final int OPEN_WXMINIPROGRAM = 12;
    public static final int QQ_MINI_PROGRAM = 15;
    public static final int SHARE_APPS = 7;
    public static final int SHARE_DYIM_IMG = 24;
    public static final int SHARE_DYIM_WEBPAGE = 25;
    public static final int SHARE_EMOJI = 9;
    public static final int SHARE_FILE = 8;
    public static final int SHARE_IMAGE = 2;
    public static final int SHARE_LINKCARD = 14;
    public static final int SHARE_MUSIC = 5;
    public static final int SHARE_TEXT = 1;
    public static final int SHARE_VIDEO = 6;
    public static final int SHARE_WEBPAGE = 4;
    public static final int SHARE_WXMINIPROGRAM = 11;
    public static final int SHARE_ZHIFUBAO = 10;
    private static Platform c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f2067a;
    private final Object b = new Object();
    protected final PlatformDb db;
    protected volatile boolean isClientValid;
    protected PlatformActionListener listener;
    protected boolean needAuthCode;
    protected String pkgName;
    protected final PlatformActionListener uIListener;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ShareParams extends InnerShareParams {
        public ShareParams() {
        }

        public ShareParams(HashMap<String, Object> map) {
            super(map);
        }

        public ShareParams(String str) {
            super(str);
        }
    }

    public Platform() {
        g gVar = new g(this);
        this.f2067a = gVar;
        this.db = gVar.g();
        this.listener = this.f2067a.i();
        this.uIListener = new PlatformActionListener() { // from class: cn.sharesdk.framework.Platform.1
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(final Platform platform, final int i5) {
                if (Platform.this.listener == null) {
                    return;
                }
                try {
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        Platform.this.listener.onCancel(platform, i5);
                    } else {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.framework.Platform.1.3
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                Platform.this.listener.onCancel(platform, i5);
                                return false;
                            }
                        });
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(final Platform platform, final int i5, final HashMap<String, Object> map) {
                if (Platform.this.listener == null) {
                    return;
                }
                try {
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        Platform.this.listener.onComplete(platform, i5, map);
                    } else {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.framework.Platform.1.2
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                Platform.this.listener.onComplete(platform, i5, map);
                                return false;
                            }
                        });
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(th);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(final Platform platform, final int i5, final Throwable th) {
                if (Platform.this.listener == null) {
                    return;
                }
                try {
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        Platform.this.listener.onError(platform, i5, th);
                    } else {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.framework.Platform.1.1
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                Platform.this.listener.onError(platform, i5, th);
                                return false;
                            }
                        });
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                }
            }
        };
    }

    public static Platform getDefaultPlatform() {
        if (c == null) {
            c = new Platform() { // from class: cn.sharesdk.framework.Platform.9

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final Throwable f2080a = new Throwable("Privacy policy is not accepted Use default platform");

                @Override // cn.sharesdk.framework.Platform
                public boolean checkAuthorize(int i5, Object obj) {
                    return true;
                }

                @Override // cn.sharesdk.framework.Platform
                public void doAuthorize(String[] strArr) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onError(this, 1, this.f2080a);
                    }
                }

                @Override // cn.sharesdk.framework.Platform
                public void doShare(ShareParams shareParams) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onError(this, 9, this.f2080a);
                    }
                }

                @Override // cn.sharesdk.framework.Platform
                public HashMap<String, Object> filterFriendshipInfo(int i5, HashMap<String, Object> map) {
                    return null;
                }

                @Override // cn.sharesdk.framework.Platform
                public cn.sharesdk.framework.a.b.j.a filterShareContent(ShareParams shareParams, HashMap<String, Object> map) {
                    return null;
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
                public String getName() {
                    return "default";
                }

                @Override // cn.sharesdk.framework.Platform
                public int getPlatformId() {
                    return -1;
                }

                @Override // cn.sharesdk.framework.Platform
                public int getVersion() {
                    return -1;
                }

                @Override // cn.sharesdk.framework.Platform
                public boolean hasShareCallback() {
                    return false;
                }

                @Override // cn.sharesdk.framework.Platform
                public void userInfor(String str) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onError(this, 8, this.f2080a);
                    }
                }

                @Override // cn.sharesdk.framework.Platform
                public void setNetworkDevinfo() {
                }

                @Override // cn.sharesdk.framework.Platform
                public void follow(String str) {
                }

                @Override // cn.sharesdk.framework.Platform
                public void initDevInfo(String str) {
                }

                @Override // cn.sharesdk.framework.Platform
                public void getFriendList(int i5, int i6, String str) {
                }

                @Override // cn.sharesdk.framework.Platform
                public void timeline(int i5, int i6, String str) {
                }

                @Override // cn.sharesdk.framework.Platform
                public void doCustomerProtocol(String str, String str2, int i5, HashMap<String, Object> map, HashMap<String, String> map2) {
                }
            };
        }
        return c;
    }

    public void SSOSetting(boolean z6) {
        this.f2067a.a(z6);
    }

    public void afterRegister(int i5, Object obj) {
        this.f2067a.b(i5, obj);
    }

    public void authorize() {
        authorize(null);
    }

    public abstract boolean checkAuthorize(int i5, Object obj);

    public void copyDevinfo(String str, String str2) {
        ShareSDK.a(str, str2);
    }

    public void copyNetworkDevinfo(int i5, int i6) {
        ShareSDK.a(i5, i6);
    }

    public void customerProtocol(String str, String str2, short s6, HashMap<String, Object> map, HashMap<String, String> map2) {
        this.f2067a.a(str, str2, s6, map, map2);
    }

    public abstract void doAuthorize(String[] strArr);

    public abstract void doCustomerProtocol(String str, String str2, int i5, HashMap<String, Object> map, HashMap<String, String> map2);

    public abstract void doShare(ShareParams shareParams);

    public abstract HashMap<String, Object> filterFriendshipInfo(int i5, HashMap<String, Object> map);

    public abstract cn.sharesdk.framework.a.b.j.a filterShareContent(ShareParams shareParams, HashMap<String, Object> map);

    public String filterShareContent(ShareParams shareParams) {
        return null;
    }

    public abstract void follow(String str);

    public void followFriend(String str) {
        this.f2067a.b(str);
    }

    public abstract HashMap<String, Object> getBilaterals(int i5, int i6, String str);

    public PlatformDb getDb() {
        return this.db;
    }

    public String getDevinfo(String str) {
        return getDevinfo(getName(), str);
    }

    public abstract HashMap<String, Object> getFollowers(int i5, int i6, String str);

    public abstract HashMap<String, Object> getFollowings(int i5, int i6, String str);

    public abstract void getFriendList(int i5, int i6, String str);

    public int getId() {
        return this.f2067a.a();
    }

    public abstract String getName();

    public String getNetworkDevinfo(String str, String str2) {
        return getNetworkDevinfo(getPlatformId(), str, str2);
    }

    public PlatformActionListener getPlatformActionListener() {
        return this.f2067a.c();
    }

    public abstract int getPlatformId();

    public void getShortLintk(String str, boolean z6, ShareSDKCallback<String> shareSDKCallback) {
        this.f2067a.a(str, z6, shareSDKCallback);
    }

    public int getSortId() {
        return this.f2067a.b();
    }

    public void getTimeLine(String str, int i5, int i6) {
        this.f2067a.a(str, i5, i6);
    }

    public abstract int getVersion();

    public abstract boolean hasShareCallback();

    public abstract void initDevInfo(String str);

    public void innerAuthorize(int i5, Object obj) {
        this.f2067a.a(i5, obj);
    }

    public void innerShowUser(final String str) {
        isClientValid(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.framework.Platform.8
            @Override // cn.sharesdk.framework.ShareSDKCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onCallback(Boolean bool) {
                Platform.this.isClientValid = bool.booleanValue();
                Platform.this.f2067a.c(str);
            }
        });
    }

    public boolean isAuthValid() {
        return this.f2067a.d();
    }

    @Deprecated
    public boolean isClientValid() {
        k.a(new k.a() { // from class: cn.sharesdk.framework.Platform.2
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() {
                Platform.this.isClientValid(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.framework.Platform.2.1
                    @Override // cn.sharesdk.framework.ShareSDKCallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onCallback(Boolean bool) {
                        synchronized (Platform.this.b) {
                            try {
                                Platform.this.isClientValid = bool != null && bool.booleanValue();
                                Platform.this.b.notifyAll();
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            }
        });
        synchronized (this.b) {
            try {
                this.b.wait(1000L);
            } catch (Throwable th) {
                SSDKLog.b().a(th);
            }
        }
        return this.isClientValid;
    }

    public boolean isSSODisable() {
        return this.f2067a.e();
    }

    public void listFriend(int i5, int i6, String str) {
        this.f2067a.a(i5, i6, str);
    }

    public void needAuthCode(boolean z6) {
        this.needAuthCode = z6;
    }

    public void removeAccount(boolean z6) {
        this.f2067a.h();
        ShareSDK.removeCookieOnAuthorize(z6);
    }

    public abstract void setNetworkDevinfo();

    public void setPlatformActionListener(PlatformActionListener platformActionListener) {
        this.f2067a.a(platformActionListener);
    }

    public void share(final ShareParams shareParams) {
        cn.sharesdk.framework.utils.i.a();
        isClientValid(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.framework.Platform.6
            @Override // cn.sharesdk.framework.ShareSDKCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onCallback(Boolean bool) {
                Platform.this.isClientValid = bool.booleanValue();
                Platform.this.f2067a.b(shareParams);
            }
        });
    }

    public void showUser(final String str) {
        isClientValid(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.framework.Platform.7
            @Override // cn.sharesdk.framework.ShareSDKCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onCallback(Boolean bool) {
                Platform.this.isClientValid = bool.booleanValue();
                if ("Wechat".equals(Platform.this.getName())) {
                    Platform platform = Platform.this;
                    if (platform.needAuthCode) {
                        platform.getDb().putAuthCode("");
                    }
                }
                Platform.this.f2067a.c(str);
            }
        });
    }

    public void subscribeAuth(final ShareParams shareParams) {
        isClientValid(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.framework.Platform.5
            @Override // cn.sharesdk.framework.ShareSDKCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onCallback(Boolean bool) {
                Platform.this.isClientValid = bool.booleanValue();
                Platform.this.f2067a.a(shareParams);
            }
        });
    }

    public abstract void timeline(int i5, int i6, String str);

    public String uploadImageToFileServer(String str) {
        return this.f2067a.d(str);
    }

    public abstract void userInfor(String str);

    public void a() {
        this.f2067a.a(false);
        this.f2067a.a(getName());
    }

    public void authorize(final String[] strArr) {
        cn.sharesdk.framework.utils.i.a();
        isClientValid(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.framework.Platform.4
            @Override // cn.sharesdk.framework.ShareSDKCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onCallback(Boolean bool) {
                Platform.this.isClientValid = bool.booleanValue();
                Platform.this.f2067a.a(strArr);
            }
        });
    }

    public boolean b() {
        return this.f2067a.f();
    }

    public String getDevinfo(String str, String str2) {
        return ShareSDK.getDevinfo(str, str2);
    }

    public String getNetworkDevinfo(int i5, String str, String str2) {
        return this.f2067a.a(i5, str, str2);
    }

    public String getShortLintk(String str, boolean z6, HashMap<String, String> map) {
        return this.f2067a.a(str, z6, map);
    }

    public String uploadImageToFileServer(Bitmap bitmap) {
        return this.f2067a.a(bitmap);
    }

    public void isClientValid(final ShareSDKCallback<Boolean> shareSDKCallback) {
        if (shareSDKCallback == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(this.pkgName)) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            } else {
                DH.requester(MobSDK.getContext()).getPInfoForce(true, this.pkgName, 0).request(new DH.DHResponder() { // from class: cn.sharesdk.framework.Platform.3
                    @Override // com.mob.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse) {
                        try {
                            if (dHResponse.getPInfoForce(new int[0]) != null) {
                                shareSDKCallback.onCallback(Boolean.TRUE);
                            } else {
                                shareSDKCallback.onCallback(Boolean.valueOf(cn.sharesdk.framework.utils.i.a(Platform.this.pkgName, 0) != null));
                            }
                        } catch (Throwable th) {
                            SSDKLog.b().a(androidx.exifinterface.media.a.n("isClientValid", th), new Object[0]);
                            shareSDKCallback.onCallback(Boolean.FALSE);
                        }
                    }
                });
            }
        } catch (Throwable unused) {
            shareSDKCallback.onCallback(Boolean.FALSE);
        }
    }
}
