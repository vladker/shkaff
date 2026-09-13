package cn.sharesdk.google;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.b.j;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class GooglePlus extends Platform {
    public static final String NAME = "GooglePlus";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f2238a = a.a(this);
    private String b;
    private String c;
    private String d;
    private boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2239f;

    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i5, Object obj) {
        if (i5 == 9) {
            return true;
        }
        if (super.isAuthValid()) {
            this.f2238a.a(this.b, this.d);
            this.f2238a.a(this.c);
            this.f2238a.c(this.db.getToken());
            String token = this.db.getToken();
            if (!TextUtils.isEmpty(token)) {
                this.f2238a.c(token);
                return true;
            }
        } else if (this.isClientValid && this.db.get("isSigin").equals("true")) {
            return true;
        }
        innerAuthorize(i5, obj);
        return false;
    }

    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        if (!this.isClientValid || isSSODisable()) {
            doWebAuthorize(strArr);
            return;
        }
        if (!this.f2239f) {
            this.f2238a.a(strArr, new PlatformActionListener() { // from class: cn.sharesdk.google.GooglePlus.1
                @Override // cn.sharesdk.framework.PlatformActionListener
                public void onCancel(Platform platform, int i5) {
                    if (((Platform) GooglePlus.this).listener != null) {
                        ((Platform) GooglePlus.this).listener.onCancel(platform, i5);
                    }
                    GooglePlus.this.f2238a.c();
                }

                @Override // cn.sharesdk.framework.PlatformActionListener
                public void onComplete(Platform platform, int i5, HashMap<String, Object> map) {
                    try {
                        String str = map.containsKey("DisplayName") ? (String) map.get("DisplayName") : "";
                        String str2 = map.containsKey("image") ? (String) map.get("image") : "";
                        String strValueOf = map.containsKey("gender") ? String.valueOf(map.get("gender")) : "";
                        String str3 = map.containsKey("url") ? (String) map.get("url") : "";
                        String str4 = map.containsKey("birthday") ? (String) map.get("birthday") : "";
                        GooglePlus.this.a(map, "Tagline");
                        GooglePlus.this.a(map, "isVerified");
                        GooglePlus.this.a(map, "Language");
                        GooglePlus.this.a(map, "Emails");
                        ((Platform) GooglePlus.this).db.putUserId((String) map.get("id"));
                        ((Platform) GooglePlus.this).db.put("nickname", str);
                        ((Platform) GooglePlus.this).db.put("icon", str2);
                        ((Platform) GooglePlus.this).db.put("gender", strValueOf);
                        ((Platform) GooglePlus.this).db.put("snsUserUrl", str3);
                        ((Platform) GooglePlus.this).db.put("birthday", str4);
                        ((Platform) GooglePlus.this).db.put("isSigin", "true");
                        if (((Platform) GooglePlus.this).listener != null) {
                            ((Platform) GooglePlus.this).listener.onComplete(platform, i5, map);
                        }
                        GooglePlus.this.f2238a.c();
                    } catch (Throwable th) {
                        SSDKLog.b().a(androidx.exifinterface.media.a.n("Googleplus doAuthorize() onComplete catch", th), new Object[0]);
                    }
                }

                @Override // cn.sharesdk.framework.PlatformActionListener
                public void onError(Platform platform, int i5, Throwable th) {
                    if (((Platform) GooglePlus.this).listener != null) {
                        ((Platform) GooglePlus.this).listener.onError(platform, i5, th);
                    }
                    GooglePlus.this.f2238a.c();
                }
            }, this.db);
            return;
        }
        try {
            new GoogleOfficialHelper(this.listener, this).show(MobSDK.getContext(), null);
        } catch (Throwable th) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 1, th);
            }
            SSDKLog.b().a(androidx.exifinterface.media.a.n("Googleplus GoogleOfficialHelper catch: ", th), new Object[0]);
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
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 9);
        }
    }

    public void doWebAuthorize(String[] strArr) {
        this.f2238a.a(this.b, this.d);
        this.f2238a.a(this.c);
        this.f2238a.a(strArr);
        this.f2238a.a(new AuthorizeListener() { // from class: cn.sharesdk.google.GooglePlus.2
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (((Platform) GooglePlus.this).listener != null) {
                    ((Platform) GooglePlus.this).listener.onCancel(GooglePlus.this, 1);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                long j6;
                String string = bundle.getString("access_token");
                String string2 = bundle.getString("expires_in");
                String string3 = bundle.getString("token_type");
                String string4 = bundle.getString("refresh_token");
                String string5 = bundle.getString("id_token");
                ((Platform) GooglePlus.this).db.putToken(string);
                ((Platform) GooglePlus.this).db.put("token_type", string3);
                ((Platform) GooglePlus.this).db.put("refresh_token", string4);
                ((Platform) GooglePlus.this).db.put("id_token", string5);
                try {
                    j6 = ResHelper.parseLong(string2);
                } catch (Throwable unused) {
                    j6 = 0;
                }
                ((Platform) GooglePlus.this).db.putExpiresIn(j6);
                GooglePlus.this.f2238a.c(string);
                GooglePlus.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (((Platform) GooglePlus.this).listener != null) {
                    ((Platform) GooglePlus.this).listener.onError(GooglePlus.this, 1, th);
                }
            }
        });
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> filterFriendshipInfo(int i5, HashMap<String, Object> map) {
        Object obj;
        int i6;
        String str;
        ArrayList arrayList;
        String str2;
        int i7 = 0;
        HashMap<String, Object> map2 = new HashMap<>();
        String str3 = "type";
        HashMap<String, Object> map3 = null;
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
        String str4 = "snsuid";
        map2.put("snsuid", this.db.getUserId());
        if (Integer.parseInt(String.valueOf(map.get("totalItems"))) == 0 || (obj = map.get(FirebaseAnalytics.Param.ITEMS)) == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = (ArrayList) obj;
        if (arrayList3.size() <= 0) {
            return null;
        }
        int size = arrayList3.size();
        int i8 = 0;
        while (i8 < size) {
            i8++;
            HashMap map4 = (HashMap) arrayList3.get(i8);
            if (map4 != null) {
                HashMap<String, Object> map5 = map3;
                HashMap map6 = new HashMap();
                map6.put(str4, String.valueOf(map4.get("id")));
                int i9 = i7;
                map6.put("nickname", String.valueOf(map4.get("displayName")));
                HashMap<String, Object> map7 = map4.containsKey("image") ? (HashMap) map4.get("image") : map5;
                if (map7 != null) {
                    map6.put("icon", String.valueOf(map7.get("url")));
                }
                if (String.valueOf(map4.get("verified")).equals("true")) {
                    map6.put("secretType", "1");
                } else {
                    map6.put("secretType", "0");
                }
                String str5 = str4;
                ArrayList arrayList4 = arrayList3;
                if (String.valueOf(map4.get("gender")).equals("male")) {
                    map6.put("gender", "0");
                } else {
                    map6.put("gender", "1");
                }
                map6.put("snsUserUrl", String.valueOf(map4.get("url")));
                map6.put("resume", String.valueOf(map4.get("aboutMe")));
                boolean z6 = true;
                if (map4.containsKey("birthday")) {
                    try {
                        String[] strArrSplit = String.valueOf(map4.get("birthday")).split(ProcessIdUtil.DEFAULT_PROCESSID);
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(1, ResHelper.parseInt(strArrSplit[i9]));
                        calendar.set(2, ResHelper.parseInt(strArrSplit[1]) - 1);
                        calendar.set(5, ResHelper.parseInt(strArrSplit[2]));
                        map6.put("birthday", String.valueOf(calendar.getTimeInMillis()));
                    } catch (Throwable th) {
                        i6 = i9;
                        SSDKLog.b().a("Googleplus userInfo get birthday catch", new Object[i6]);
                        SSDKLog.b().a(th);
                    }
                }
                i6 = i9;
                if (!map4.containsKey("organizations") || (arrayList = (ArrayList) map4.get("organizations")) == null || arrayList.size() <= 0) {
                    str = str3;
                } else {
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    int size2 = arrayList.size();
                    int i10 = i6;
                    while (i10 < size2) {
                        Object obj2 = arrayList.get(i10);
                        i10++;
                        boolean z7 = z6;
                        HashMap map8 = (HashMap) obj2;
                        String str6 = (String) map8.get(str3);
                        ArrayList arrayList7 = arrayList;
                        if (Pattern.compile("school|college|university").matcher(str6.toLowerCase()).find()) {
                            HashMap map9 = new HashMap();
                            str2 = str3;
                            map9.put("school_type", 0);
                            map9.put("school", String.valueOf(map8.get("name")));
                            map9.put("background", 0);
                            arrayList5.add(map9);
                        } else {
                            str2 = str3;
                            if (Pattern.compile("work|company|firm|enterprise").matcher(str6.toLowerCase()).find()) {
                                HashMap map10 = new HashMap();
                                map10.put("company", String.valueOf(map8.get("name")));
                                map10.put("dept", String.valueOf(map8.get("department")));
                                map10.put("position", String.valueOf(map8.get("title")));
                                arrayList6.add(map10);
                            }
                        }
                        z6 = z7;
                        arrayList = arrayList7;
                        str3 = str2;
                    }
                    str = str3;
                    if (arrayList5.size() > 0) {
                        HashMap map11 = new HashMap();
                        map11.put(XmlErrorCodes.LIST, arrayList5);
                        String strFromHashMap = new Hashon().fromHashMap(map11);
                        map6.put("educationJSONArrayStr", strFromHashMap.substring(8, strFromHashMap.length() - 1));
                    }
                    if (arrayList6.size() > 0) {
                        HashMap map12 = new HashMap();
                        map12.put(XmlErrorCodes.LIST, arrayList6);
                        String strFromHashMap2 = new Hashon().fromHashMap(map12);
                        map6.put("workJSONArrayStr", strFromHashMap2.substring(8, strFromHashMap2.length() - 1));
                    }
                }
                arrayList2.add(map6);
                map3 = map5;
                arrayList3 = arrayList4;
                str4 = str5;
                str3 = str;
                i7 = 0;
            }
        }
        HashMap<String, Object> map13 = map3;
        if (arrayList2.size() <= 0) {
            return map13;
        }
        if (2 == i5) {
            map2.put("nextPageToken", map.get("nextPageToken"));
        }
        map2.put(XmlErrorCodes.LIST, arrayList2);
        return map2;
    }

    @Override // cn.sharesdk.framework.Platform
    public j.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        j.a aVar = new j.a();
        aVar.b = shareParams.getText();
        String imagePath = shareParams.getImagePath();
        String imageUrl = shareParams.getImageUrl();
        if (!TextUtils.isEmpty(imagePath)) {
            aVar.e.add(imagePath);
            return aVar;
        }
        if (!TextUtils.isEmpty(imageUrl)) {
            aVar.d.add(imageUrl);
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
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowings(int i5, int i6, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i5, int i6, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = "me";
        }
        try {
            HashMap<String, Object> mapE = this.f2238a.e(str);
            if (mapE == null) {
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this, 2, new Throwable());
                    return;
                }
                return;
            }
            if (!mapE.containsKey("error_code") || ((Integer) mapE.get("error_code")).intValue() == 0) {
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onComplete(this, 2, mapE);
                    return;
                }
                return;
            }
            if (this.listener != null) {
                this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(mapE)));
            }
        } catch (Throwable th) {
            this.listener.onError(this, 2, th);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 14;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return false;
    }

    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.b = getDevinfo("ClientID");
        this.c = getDevinfo("RedirectUrl");
        this.d = getDevinfo("AppSecret");
        this.e = "true".equals(getDevinfo("ShareByAppClient"));
        if (TextUtils.isEmpty(getDevinfo("OfficialVersion"))) {
            this.f2239f = false;
            return;
        }
        this.f2239f = true;
        SSDKLog.b().a("Googleplus Official value: " + getDevinfo("Official"));
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isAuthValid() {
        if (super.isAuthValid()) {
            return true;
        }
        return this.isClientValid && this.db.get("isSigin").equals("true");
    }

    @Override // cn.sharesdk.framework.Platform
    public void isClientValid(ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            c.a(shareSDKCallback);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void removeAccount(boolean z6) {
        super.removeAccount(z6);
        try {
            this.db.put("isSigin", "false");
            if (this.f2239f) {
                new b().a();
            } else {
                this.f2238a.a();
            }
        } catch (Throwable th) {
            SSDKLog.b().a("Googleplus removeAccount catch", new Object[0]);
            SSDKLog.b().a(th);
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
        Object obj;
        Integer num = 0;
        if (this.isClientValid && this.db.get("isSigin").equals("true")) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("DisplayName", this.db.get("nickname"));
            map.put("image", this.db.get("icon"));
            map.put("gender", this.db.get("gender"));
            map.put("url", this.db.get("snsUserUrl"));
            map.put("birthday", this.db.get("birthday"));
            map.put("id", this.db.getUserId());
            map.put("token", this.db.getToken());
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onComplete(this, 8, map);
                return;
            }
            return;
        }
        if (this.f2239f && this.isClientValid && !isSSODisable()) {
            String str2 = this.db.get("nickname");
            String str3 = this.db.get("email");
            String str4 = this.db.get("family_name");
            String str5 = this.db.get("given_name");
            String str6 = this.db.get("requestedScopes");
            String str7 = this.db.get("picture");
            String userId = this.db.getUserId();
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("nickname", str2);
            map2.put("email", str3);
            map2.put("family_name", str4);
            map2.put("given_name", str5);
            map2.put("requestedScopes", str6);
            map2.put("picture", str7);
            map2.put("id", userId);
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onComplete(this, 8, map2);
                return;
            }
        }
        String userId2 = TextUtils.isEmpty(str) ? this.db.getUserId() : str;
        if (TextUtils.isEmpty(userId2)) {
            userId2 = "me";
        }
        try {
            HashMap<String, Object> mapD = this.f2238a.d(userId2);
            if (mapD == null || mapD.size() <= 0) {
                return;
            }
            this.db.putUserId(String.valueOf(mapD.get("id")));
            this.db.put("nickname", String.valueOf(mapD.get("displayName")));
            HashMap map3 = mapD.containsKey("image") ? (HashMap) mapD.get("image") : null;
            if (map3 != null) {
                obj = "url";
                this.db.put("icon", String.valueOf(map3.get(obj)));
            } else {
                obj = r8;
            }
            this.db.put("gender", "male".equals(String.valueOf(mapD.get("gender"))) ? "0" : "1");
            this.db.put("snsUserUrl", String.valueOf(mapD.get(obj)));
            this.db.put("resume", String.valueOf(mapD.get("aboutMe")));
            if (String.valueOf(mapD.get("verified")).equals("true")) {
                this.db.put("secretType", "1");
            } else {
                this.db.put("secretType", "0");
            }
            boolean z6 = true;
            if (mapD.containsKey("birthday") && mapD.get("birthday") != null) {
                try {
                    String[] strArrSplit = String.valueOf(mapD.get("birthday")).split(ProcessIdUtil.DEFAULT_PROCESSID);
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(1, ResHelper.parseInt(strArrSplit[0]));
                    calendar.set(2, ResHelper.parseInt(strArrSplit[1]) - 1);
                    calendar.set(5, ResHelper.parseInt(strArrSplit[2]));
                    this.db.put("birthday", String.valueOf(calendar.getTimeInMillis()));
                } catch (Throwable th) {
                    SSDKLog.b().a("Googleplus userInfo catct ", new Object[0]);
                    SSDKLog.b().a(th);
                }
            }
            if (mapD.containsKey("organizations")) {
                try {
                    ArrayList arrayList = (ArrayList) mapD.get("organizations");
                    if (arrayList != null && arrayList.size() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        int size = arrayList.size();
                        int i5 = 0;
                        while (i5 < size) {
                            Object obj2 = arrayList.get(i5);
                            i5++;
                            HashMap map4 = (HashMap) obj2;
                            String str8 = (String) map4.get("type");
                            z6 = z6;
                            if (Pattern.compile("school|college|university").matcher(str8.toLowerCase()).find()) {
                                HashMap map5 = new HashMap();
                                Integer num2 = num;
                                map5.put("school_type", num2);
                                map5.put("school", String.valueOf(map4.get("name")));
                                map5.put("background", num2);
                                arrayList2.add(map5);
                                num = num2;
                            } else {
                                Integer num3 = num;
                                if (Pattern.compile("work|company|firm|enterprise").matcher(str8.toLowerCase()).find()) {
                                    HashMap map6 = new HashMap();
                                    map6.put("company", String.valueOf(map4.get("name")));
                                    map6.put("dept", String.valueOf(map4.get("department")));
                                    map6.put("position", String.valueOf(map4.get("title")));
                                    arrayList3.add(map6);
                                }
                                num = num3;
                                arrayList = arrayList;
                            }
                        }
                        if (arrayList2.size() > 0) {
                            HashMap map7 = new HashMap();
                            map7.put(XmlErrorCodes.LIST, arrayList2);
                            String strFromHashMap = new Hashon().fromHashMap(map7);
                            this.db.put("educationJSONArrayStr", strFromHashMap.substring(8, strFromHashMap.length() - 1));
                        }
                        if (arrayList3.size() > 0) {
                            HashMap map8 = new HashMap();
                            map8.put(XmlErrorCodes.LIST, arrayList3);
                            String strFromHashMap2 = new Hashon().fromHashMap(map8);
                            this.db.put("workJSONArrayStr", strFromHashMap2.substring(8, strFromHashMap2.length() - 1));
                        }
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a("Googleplus userInfo get organizations catch", new Object[0]);
                    SSDKLog.b().a(th2);
                }
            }
            if (mapD.containsKey("sub")) {
                this.db.putUserId(String.valueOf(mapD.get("sub")));
            }
            if (mapD.containsKey("email_verified")) {
                this.db.put("email_verified", String.valueOf(mapD.get("email_verified")));
            }
            if (mapD.containsKey("name")) {
                this.db.put("name", String.valueOf(mapD.get("name")));
            }
            if (mapD.containsKey("given_name")) {
                this.db.put("given_name", String.valueOf(mapD.get("given_name")));
            }
            if (mapD.containsKey("locale")) {
                this.db.put("locale", String.valueOf(mapD.get("locale")));
            }
            if (mapD.containsKey("family_name")) {
                this.db.put("family_name", String.valueOf(mapD.get("family_name")));
            }
            if (mapD.containsKey("picture")) {
                this.db.put("picture", String.valueOf(mapD.get("picture")));
            }
            if (mapD.containsKey("email")) {
                this.db.put("email", String.valueOf(mapD.get("email")));
            }
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onComplete(this, 8, mapD);
            }
        } catch (Throwable th3) {
            PlatformActionListener platformActionListener4 = this.listener;
            if (platformActionListener4 != null) {
                platformActionListener4.onError(this, 8, th3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, Object> map, String str) {
        if (map.containsKey(str)) {
            String strValueOf = String.valueOf(map.get(str));
            if (TextUtils.isEmpty(strValueOf)) {
                return;
            }
            this.db.put(str, strValueOf);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
    }
}
