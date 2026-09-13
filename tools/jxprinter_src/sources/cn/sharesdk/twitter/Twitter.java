package cn.sharesdk.twitter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.b.j;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Twitter extends Platform {
    public static final String NAME = "Twitter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2328a;
    private String b;
    private String c;
    private boolean d;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ShareParams extends Platform.ShareParams {
    }

    public Twitter() {
        this.pkgName = "com.twitter.android";
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i5, Object obj) {
        if (isAuthValid()) {
            c cVarA = c.a(this);
            cVarA.a(this.f2328a, this.b, this.c);
            String token = this.db.getToken();
            String tokenSecret = this.db.getTokenSecret();
            if (token != null || tokenSecret != null) {
                cVarA.a(token, tokenSecret);
                return true;
            }
        }
        if (i5 == 9 && this.d) {
            SSDKLog.b().a("twitter checkAuthorize ACTION_SHARE return true");
            return true;
        }
        if (i5 == 9 && this.isClientValid && this.d) {
            SSDKLog.b().a("twitter checkAuthorize ACTION_SHARE return true");
            return true;
        }
        innerAuthorize(i5, obj);
        return false;
    }

    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        final c cVarA = c.a(this);
        cVarA.a(this.f2328a, this.b, this.c);
        cVarA.a(new AuthorizeListener() { // from class: cn.sharesdk.twitter.Twitter.2
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (((Platform) Twitter.this).listener != null) {
                    ((Platform) Twitter.this).listener.onCancel(Twitter.this, 1);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                try {
                    String string = bundle.getString("oauth_token");
                    String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
                    String string3 = bundle.getString("access_token");
                    if (string == null || string.equals("")) {
                        String string4 = bundle.getString("tk");
                        String string5 = bundle.getString("ts");
                        String strValueOf = String.valueOf(bundle.getLong("user_id", 0L));
                        if (!TextUtils.isEmpty(string3)) {
                            ((Platform) Twitter.this).db.putToken(string3);
                        } else if (!TextUtils.isEmpty(string4)) {
                            ((Platform) Twitter.this).db.putToken(string4);
                            SSDKLog.b().a("IS USEv1 OR accessToken empty");
                        }
                        ((Platform) Twitter.this).db.putTokenSecret(string5);
                        ((Platform) Twitter.this).db.putUserId(strValueOf);
                        ((Platform) Twitter.this).db.put("nickname", string2);
                    } else {
                        String string6 = bundle.getString("oauth_token_secret");
                        String string7 = bundle.getString("user_id");
                        if (!TextUtils.isEmpty(string3)) {
                            ((Platform) Twitter.this).db.putToken(string3);
                        }
                        ((Platform) Twitter.this).db.putTokenSecret(string6);
                        ((Platform) Twitter.this).db.putUserId(string7);
                        ((Platform) Twitter.this).db.put("nickname", string2);
                        cVarA.a(string, string6);
                    }
                    Twitter.this.afterRegister(1, null);
                } catch (Exception e) {
                    SSDKLog.b().a(e);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (((Platform) Twitter.this).listener != null) {
                    ((Platform) Twitter.this).listener.onError(Twitter.this, 1, th);
                }
            }
        }, isSSODisable());
    }

    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i5, HashMap<String, Object> map, HashMap<String, String> map2) {
        try {
            HashMap<String, Object> mapA = c.a(this).a(str, str2, map, map2);
            if (mapA != null && mapA.size() > 0) {
                if (!mapA.containsKey("error_code") && !mapA.containsKey("error")) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, i5, mapA);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, i5, new Throwable(new Hashon().fromHashMap(mapA)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, i5, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, i5, th);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void doShare(final Platform.ShareParams shareParams) {
        Twitter twitter;
        Throwable th;
        final c cVarA = c.a(this);
        try {
            final String[] imageArray = shareParams.getImageArray();
            final String imagePath = shareParams.getImagePath();
            final String imageUrl = shareParams.getImageUrl();
            final String text = shareParams.getText();
            final String filePath = shareParams.getFilePath();
            final int shareType = shareParams.getShareType();
            if (this.d) {
                try {
                    SSDKLog.b().a("Twitter bypassApproval ", new Object[0]);
                    if (imageArray != null && imageArray.length > 0) {
                        cVarA.a(text, imageArray, this.listener, shareParams);
                        return;
                    }
                    if (TextUtils.isEmpty(imagePath) && TextUtils.isEmpty(imageUrl)) {
                        if (!TextUtils.isEmpty(text)) {
                            cVarA.a(text, this.listener, shareParams);
                            return;
                        }
                        PlatformActionListener platformActionListener = this.listener;
                        if (platformActionListener != null) {
                            platformActionListener.onError(this, 9, new Throwable("Please set params"));
                            return;
                        }
                        return;
                    }
                    cVarA.a(text, imagePath, imageUrl, this.listener, shareParams);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    twitter = this;
                }
            } else {
                final String url = shareParams.getUrl();
                twitter = this;
                try {
                    getShortLintk(url, false, new ShareSDKCallback<String>() { // from class: cn.sharesdk.twitter.Twitter.1
                        @Override // cn.sharesdk.framework.ShareSDKCallback
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onCallback(String str) {
                            HashMap<String, Object> mapD;
                            try {
                                if (TextUtils.isEmpty(str)) {
                                    str = url;
                                }
                                if (shareType != 6 || TextUtils.isEmpty(filePath)) {
                                    String[] strArr = imageArray;
                                    if (strArr != null && strArr.length > 0) {
                                        mapD = cVarA.a(text, strArr);
                                    } else if (!TextUtils.isEmpty(imagePath) && new File(imagePath).exists()) {
                                        mapD = cVarA.e(text, imagePath);
                                    } else if (TextUtils.isEmpty(imageUrl)) {
                                        mapD = !TextUtils.isEmpty(str) ? cVarA.d(str) : cVarA.d(text);
                                    } else {
                                        String strDownloadBitmap = BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl);
                                        mapD = new File(strDownloadBitmap).exists() ? cVarA.e(text, strDownloadBitmap) : null;
                                    }
                                } else {
                                    mapD = cVarA.f(text, filePath);
                                }
                                if (mapD == null) {
                                    if (((Platform) Twitter.this).listener != null) {
                                        ((Platform) Twitter.this).listener.onError(Twitter.this, 8, new Throwable("response is null"));
                                    }
                                } else if (mapD.containsKey("error_code") || mapD.containsKey("error")) {
                                    if (((Platform) Twitter.this).listener != null) {
                                        ((Platform) Twitter.this).listener.onError(Twitter.this, 8, new Throwable(new Hashon().fromHashMap(mapD)));
                                    }
                                } else {
                                    mapD.put("ShareParams", shareParams);
                                    if (((Platform) Twitter.this).listener != null) {
                                        ((Platform) Twitter.this).listener.onComplete(Twitter.this, 9, mapD);
                                    }
                                }
                            } catch (Throwable th3) {
                                if (((Platform) Twitter.this).listener != null) {
                                    ((Platform) Twitter.this).listener.onError(Twitter.this, 9, th3);
                                }
                            }
                        }
                    });
                    return;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            twitter = this;
        }
        th = th;
        PlatformActionListener platformActionListener2 = twitter.listener;
        if (platformActionListener2 != null) {
            platformActionListener2.onError(this, 9, th);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> filterFriendshipInfo(int i5, HashMap<String, Object> map) {
        HashMap<String, Object> map2 = new HashMap<>();
        if (i5 == 2) {
            map2.put("type", "FOLLOWING");
        } else if (i5 == 10) {
            map2.put("type", "FRIENDS");
        } else {
            if (i5 != 11) {
                return null;
            }
            map2.put("type", "FOLLOWERS");
        }
        map2.put("snsplat", Integer.valueOf(getPlatformId()));
        map2.put("snsuid", this.db.getUserId());
        String strValueOf = map.containsKey("next_cursor") ? String.valueOf(map.get("next_cursor")) : null;
        Object obj = map.get("users");
        if (obj == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) obj;
        if (arrayList2.size() <= 0) {
            return null;
        }
        int size = arrayList2.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                break;
            }
            Object obj2 = arrayList2.get(i6);
            i6++;
            HashMap map3 = (HashMap) obj2;
            if (map3 != null) {
                HashMap map4 = new HashMap();
                map4.put("snsuid", String.valueOf(map3.get("id")));
                map4.put("nickname", String.valueOf(map3.get(FirebaseAnalytics.Param.SCREEN_NAME)));
                map4.put("icon", String.valueOf(map3.get("profile_image_url")));
                map4.put("gender", ExifInterface.GPS_MEASUREMENT_2D);
                map4.put("resume", String.valueOf(map3.get("description")));
                map4.put("secretType", "true".equals(String.valueOf(map3.get("verified"))) ? "1" : "0");
                map4.put("followerCount", String.valueOf(map3.get("followers_count")));
                map4.put("favouriteCount", String.valueOf(map3.get("friends_count")));
                map4.put("shareCount", String.valueOf(map3.get("statuses_count")));
                map4.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(map3.get("created_at")))));
                map4.put("snsUserUrl", "https://twitter.com/" + map3.get(FirebaseAnalytics.Param.SCREEN_NAME));
                arrayList.add(map4);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        String strN = androidx.collection.a.n(strValueOf, "_false");
        if (TextUtils.isEmpty(strValueOf) || "0".equals(strValueOf)) {
            strN = "0_true";
        }
        map2.put("nextCursor", strN);
        map2.put(XmlErrorCodes.LIST, arrayList);
        return map2;
    }

    @Override // cn.sharesdk.framework.Platform
    public j.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        ArrayList arrayList;
        j.a aVar = new j.a();
        aVar.b = shareParams.getText();
        if (map != null) {
            HashMap map2 = (HashMap) map.get("entities");
            if (map2 != null && (arrayList = (ArrayList) map2.get("media")) != null && arrayList.size() > 0 && ((HashMap) arrayList.get(0)) != null) {
                aVar.d.add(String.valueOf(map.get("media_url")));
            }
            aVar.f2154a = String.valueOf(map.get("id"));
            aVar.f2156g = map;
        }
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
        String userId = TextUtils.isEmpty(null) ? this.db.getUserId() : null;
        if (TextUtils.isEmpty(userId)) {
            userId = this.db.getUserName();
        }
        if (TextUtils.isEmpty(userId)) {
            return null;
        }
        c cVarA = c.a(this);
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            HashMap<String, Object> mapC = cVarA.c(userId, str);
            if (mapC != null && mapC.size() > 0 && !mapC.containsKey("error_code") && !mapC.containsKey("error")) {
                return filterFriendshipInfo(11, mapC);
            }
            return null;
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowings(int i5, int i6, String str) {
        String userId = TextUtils.isEmpty(null) ? this.db.getUserId() : null;
        if (TextUtils.isEmpty(userId)) {
            userId = this.db.getUserName();
        }
        if (TextUtils.isEmpty(userId)) {
            return null;
        }
        c cVarA = c.a(this);
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            HashMap<String, Object> mapB = cVarA.b(userId, str);
            if (mapB != null && mapB.size() > 0 && !mapB.containsKey("error_code") && !mapB.containsKey("error")) {
                return filterFriendshipInfo(2, mapB);
            }
            return null;
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i5, int i6, String str) {
        PlatformActionListener platformActionListener;
        String userId = TextUtils.isEmpty(null) ? this.db.getUserId() : null;
        if (TextUtils.isEmpty(userId)) {
            userId = this.db.getUserName();
        }
        if (TextUtils.isEmpty(userId) && (platformActionListener = this.listener) != null) {
            platformActionListener.onError(this, 2, new Throwable("The account do not authorize!"));
        }
        c cVarA = c.a(this);
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            HashMap<String, Object> mapB = cVarA.b(userId, str);
            if (mapB != null && mapB.size() > 0) {
                if (!mapB.containsKey("error_code") && !mapB.containsKey("error")) {
                    PlatformActionListener platformActionListener2 = this.listener;
                    if (platformActionListener2 != null) {
                        platformActionListener2.onComplete(this, 2, mapB);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(mapB)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, 2, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener4 = this.listener;
            if (platformActionListener4 != null) {
                platformActionListener4.onError(this, 2, th);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 11;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 2;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return true;
    }

    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f2328a = getDevinfo("ConsumerKey");
        this.b = getDevinfo("ConsumerSecret");
        this.c = getDevinfo("CallbackUrl");
        this.d = "true".equals(getDevinfo("BypassApproval"));
    }

    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f2328a = getNetworkDevinfo("consumer_key", "ConsumerKey");
        this.b = getNetworkDevinfo("consumer_secret", "ConsumerSecret");
        this.c = getNetworkDevinfo("redirect_uri", "CallbackUrl");
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
        try {
            HashMap<String, Object> mapC = c.a(this).c(str);
            if (mapC != null && mapC.size() > 0) {
                if (!mapC.containsKey("error_code") && !mapC.containsKey("error") && !mapC.containsKey("errors")) {
                    if (str == null) {
                        this.db.put("nickname", String.valueOf(mapC.get(FirebaseAnalytics.Param.SCREEN_NAME)));
                        this.db.put("icon", String.valueOf(mapC.get("profile_image_url")));
                        this.db.put("gender", ExifInterface.GPS_MEASUREMENT_2D);
                        this.db.put("resume", String.valueOf(mapC.get("description")));
                        this.db.put("secretType", "true".equals(String.valueOf(mapC.get("verified"))) ? "1" : "0");
                        this.db.put("followerCount", String.valueOf(mapC.get("followers_count")));
                        this.db.put("favouriteCount", String.valueOf(mapC.get("friends_count")));
                        this.db.put("shareCount", String.valueOf(mapC.get("statuses_count")));
                        this.db.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(mapC.get("created_at")))));
                        this.db.put("snsUserUrl", "https://twitter.com/" + mapC.get(FirebaseAnalytics.Param.SCREEN_NAME));
                        HashMap map = (HashMap) mapC.get("data");
                        if (map != null && !map.isEmpty()) {
                            this.db.put("name", String.valueOf(map.get("name")));
                            this.db.put("id", String.valueOf(map.get("id")));
                            this.db.put("username", String.valueOf(map.get("username")));
                        }
                    }
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, 8, mapC);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(mapC)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 8, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, 8, th);
            }
        }
    }
}
