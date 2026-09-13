package cn.sharesdk.framework;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.HashonHelper;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class e implements PlatformActionListener {
    private PlatformActionListener c;
    private int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Pattern f2187a = Pattern.compile("(?:errorCode|code|errCode|error_code)\\s*[=:]\\s*(\\d+)", 2);
    Pattern b = Pattern.compile("(?:errorMsg|msg|errorMessage|errMsg|errStr|errorDesc|message)\\s*[=:]\\s*([^,\\n]+)", 2);
    private HashMap<Platform, Platform.ShareParams> d = new HashMap<>();

    private void b(Platform platform, int i5, HashMap<String, Object> map) {
        HashMap<String, Object> map2;
        Platform platform2;
        Platform.ShareParams shareParamsRemove = this.d.remove(platform);
        if (map != null) {
            shareParamsRemove = (Platform.ShareParams) map.remove("ShareParams");
        }
        try {
            map2 = (HashMap) map.clone();
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            map2 = map;
        }
        if (shareParamsRemove != null) {
            cn.sharesdk.framework.a.b.j jVar = new cn.sharesdk.framework.a.b.j();
            jVar.f2153p = shareParamsRemove.getCustomFlag();
            String userId = platform.getDb().getUserId();
            if (("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(userId)) {
                try {
                    platform2 = ShareSDK.getPlatform("Wechat");
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "InnerPlatformActionListener wechat is null", new Object[0]);
                    platform2 = null;
                }
                if (platform2 != null) {
                    userId = platform2.getDb().getUserId();
                }
            } else if ("TencentWeibo".equals(platform.getName())) {
                userId = platform.getDb().get("name");
            }
            jVar.b = userId;
            jVar.f2151a = platform.getPlatformId();
            String strFilterShareContent = platform.filterShareContent(shareParamsRemove);
            if (TextUtils.isEmpty(strFilterShareContent)) {
                cn.sharesdk.framework.a.b.j.a aVarFilterShareContent = platform.filterShareContent(shareParamsRemove, map2);
                if (aVarFilterShareContent != null) {
                    jVar.c = aVarFilterShareContent.f2154a;
                    jVar.d = aVarFilterShareContent;
                }
            } else {
                try {
                    jVar.d = (cn.sharesdk.framework.a.b.j.a) HashonHelper.fromJson(strFilterShareContent, cn.sharesdk.framework.a.b.j.a.class);
                } catch (Throwable th3) {
                    SSDKLog.b().a(th3);
                }
            }
            jVar.f2152o = b(platform);
            cn.sharesdk.framework.a.d dVarA = cn.sharesdk.framework.a.d.a();
            if (dVarA != null) {
                dVarA.a(jVar);
            }
        }
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            try {
                platformActionListener.onComplete(platform, i5, map);
                this.c = null;
                this.e = 0;
            } catch (Throwable th4) {
                SSDKLog.b().a(th4);
            }
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i5) {
        try {
            a(2, i5, platform, null);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            platformActionListener.onCancel(platform, i5);
            this.c = null;
            this.e = 0;
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i5, HashMap<String, Object> map) {
        if (platform instanceof CustomPlatform) {
            PlatformActionListener platformActionListener = this.c;
            if (platformActionListener != null) {
                platformActionListener.onComplete(platform, i5, map);
                this.c = null;
                this.e = 0;
                return;
            }
            return;
        }
        if (i5 == 1) {
            a(platform, i5, map);
            return;
        }
        if (i5 == 9) {
            b(platform, i5, map);
            return;
        }
        PlatformActionListener platformActionListener2 = this.c;
        if (platformActionListener2 != null) {
            platformActionListener2.onComplete(platform, i5, map);
            if ("Wechat".equals(platform.getName())) {
                return;
            }
            int i6 = this.e;
            if (i6 == 0 || i6 == i5) {
                this.c = null;
                this.e = 0;
            }
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i5, Throwable th) {
        try {
            a(1, i5, platform, th);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            platformActionListener.onError(platform, i5, th);
            this.c = null;
            this.e = 0;
        }
    }

    public void a(PlatformActionListener platformActionListener) {
        this.c = platformActionListener;
    }

    public PlatformActionListener a() {
        return this.c;
    }

    public void a(Platform platform, Platform.ShareParams shareParams) {
        this.d.put(platform, shareParams);
    }

    private void a(int i5, int i6, Platform platform, Throwable th) {
        cn.sharesdk.framework.a.b.d bVar = null;
        cn.sharesdk.framework.a.b.j hVar = null;
        cn.sharesdk.framework.a.b.j jVar = null;
        if (i6 == 1) {
            if (i5 == 1) {
                bVar = new cn.sharesdk.framework.a.b.c();
            } else if (i5 == 2) {
                bVar = new cn.sharesdk.framework.a.b.b();
            }
            a(bVar, platform);
            jVar = bVar;
        } else if (i6 == 9) {
            if (i5 == 1) {
                hVar = new cn.sharesdk.framework.a.b.i();
            } else if (i5 == 2) {
                hVar = new cn.sharesdk.framework.a.b.h();
            }
            a(hVar, platform);
            jVar = hVar;
        }
        if (jVar == null || cn.sharesdk.framework.a.d.a() == null) {
            return;
        }
        if (th != null) {
            String string = TextUtils.isEmpty(th.getMessage()) ? th.toString() : th.getMessage();
            jVar.f2144m = a(string);
            jVar.f2145n = b(string);
        }
        cn.sharesdk.framework.a.d.a().a(jVar);
    }

    private void a(cn.sharesdk.framework.a.b.d dVar, Platform platform) {
        try {
            dVar.f2136a = platform.getPlatformId();
            dVar.b = "TencentWeibo".equals(platform.getName()) ? platform.getDb().get("name") : platform.getDb().getUserId();
            dVar.d = a(platform);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0048 A[Catch: all -> 0x0021, TryCatch #1 {all -> 0x0021, blocks: (B:2:0x0000, B:4:0x0014, B:16:0x0048, B:18:0x0054, B:19:0x005e, B:21:0x0076, B:27:0x009a, B:29:0x00a5, B:26:0x0092, B:9:0x0024, B:15:0x003b, B:23:0x0086, B:11:0x002a, B:13:0x0032), top: B:35:0x0000, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0054 A[Catch: all -> 0x0021, TryCatch #1 {all -> 0x0021, blocks: (B:2:0x0000, B:4:0x0014, B:16:0x0048, B:18:0x0054, B:19:0x005e, B:21:0x0076, B:27:0x009a, B:29:0x00a5, B:26:0x0092, B:9:0x0024, B:15:0x003b, B:23:0x0086, B:11:0x002a, B:13:0x0032), top: B:35:0x0000, inners: #0, #2 }] */
    private void a(cn.sharesdk.framework.a.b.j jVar, Platform platform) {
        try {
            String userId = platform.getDb().getUserId();
            if ("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) {
                if (TextUtils.isEmpty(userId)) {
                    try {
                        Platform platform2 = ShareSDK.getPlatform("Wechat");
                        if (platform2 != null) {
                            userId = platform2.getDb().getUserId();
                        }
                    } catch (Throwable unused) {
                        SSDKLog.b().a("InnerPlatformActionListener wechat is null", new Object[0]);
                    }
                } else if ("TencentWeibo".equals(platform.getName())) {
                    userId = platform.getDb().get("name");
                }
            } else if ("TencentWeibo".equals(platform.getName())) {
                userId = platform.getDb().get("name");
            }
            jVar.f2151a = platform.getPlatformId();
            jVar.b = userId;
            jVar.f2152o = b(platform);
            Platform.ShareParams shareParamsRemove = this.d.remove(platform);
            if (shareParamsRemove != null) {
                jVar.f2153p = shareParamsRemove.getCustomFlag();
                String strFilterShareContent = platform.filterShareContent(shareParamsRemove);
                if (!TextUtils.isEmpty(strFilterShareContent)) {
                    try {
                        jVar.d = (cn.sharesdk.framework.a.b.j.a) HashonHelper.fromJson(strFilterShareContent, cn.sharesdk.framework.a.b.j.a.class);
                        return;
                    } catch (Throwable th) {
                        SSDKLog.b().a(th);
                        return;
                    }
                }
                cn.sharesdk.framework.a.b.j.a aVarFilterShareContent = platform.filterShareContent(shareParamsRemove, new HashMap<>());
                if (aVarFilterShareContent != null) {
                    jVar.c = aVarFilterShareContent.f2154a;
                    jVar.d = aVarFilterShareContent;
                }
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
    }

    private String b(Platform platform) {
        Platform platform2;
        PlatformDb db = platform.getDb();
        if (("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(db.getUserGender())) {
            try {
                platform2 = ShareSDK.getPlatform("Wechat");
            } catch (Throwable th) {
                SSDKLog.b().a(th, "InnerPlatformActionListener getUserDataBrief catch ", new Object[0]);
                platform2 = null;
            }
            if (platform2 != null) {
                db = platform2.getDb();
            }
        }
        try {
            return a(db, new String[]{"gender", "birthday", "secretType", "educationJSONArrayStr", "workJSONArrayStr"});
        } catch (Throwable th2) {
            SSDKLog.b().b(th2);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x007c  */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    private String b(String str) {
        String strTrim = "";
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("errorMsg")) {
                    return jSONObject.optString("errorMsg");
                }
                if (jSONObject.has("errorMessage")) {
                    return jSONObject.optString("errorMessage");
                }
                if (jSONObject.has("errMsg")) {
                    return jSONObject.optString("errMsg");
                }
                if (jSONObject.has("errStr")) {
                    return jSONObject.optString("errStr");
                }
                if (jSONObject.has(NotificationCompat.CATEGORY_MESSAGE)) {
                    return jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                }
                return jSONObject.has("errorDesc") ? jSONObject.optString("errorDesc") : "";
            } catch (Throwable unused) {
                if (TextUtils.isEmpty(strTrim)) {
                    return str;
                }
                return strTrim;
            }
        } catch (Exception unused2) {
            Matcher matcher = this.b.matcher(str);
            if (matcher.find() && !TextUtils.isEmpty(matcher.group(1))) {
                strTrim = matcher.group(1).trim();
            }
            if (TextUtils.isEmpty(strTrim)) {
                return str;
            }
            return strTrim;
        }
    }

    private void a(Platform platform, final int i5, final HashMap<String, Object> map) {
        final PlatformActionListener platformActionListener = this.c;
        this.c = new PlatformActionListener() { // from class: cn.sharesdk.framework.e.1
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform2, int i6) {
                e.this.c = platformActionListener;
                if (e.this.c != null) {
                    e.this.c.onComplete(platform2, i5, map);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform2, int i6, HashMap<String, Object> map2) {
                e.this.c = platformActionListener;
                if (e.this.c != null) {
                    e.this.c.onComplete(platform2, i5, map);
                }
                cn.sharesdk.framework.a.b.d dVar = new cn.sharesdk.framework.a.b.d();
                dVar.f2136a = platform2.getPlatformId();
                dVar.b = "TencentWeibo".equals(platform2.getName()) ? platform2.getDb().get("name") : platform2.getDb().getUserId();
                dVar.c = new Hashon().fromHashMap(map2);
                dVar.d = e.this.a(platform2);
                cn.sharesdk.framework.a.d dVarA = cn.sharesdk.framework.a.d.a();
                if (dVarA != null) {
                    dVarA.a(dVar);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform2, int i6, Throwable th) {
                SSDKLog.b().b(th);
                e.this.c = platformActionListener;
                if (e.this.c != null) {
                    e.this.c.onComplete(platform2, i5, map);
                }
            }
        };
        platform.innerShowUser(null);
    }

    public void a(Platform platform, final int i5, final Object obj) {
        this.e = i5;
        final PlatformActionListener platformActionListener = this.c;
        this.c = new PlatformActionListener() { // from class: cn.sharesdk.framework.e.2
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform2, int i6) {
                e.this.c = platformActionListener;
                if (e.this.c != null) {
                    e.this.c.onCancel(platform2, i5);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform2, int i6, HashMap<String, Object> map) {
                e.this.c = platformActionListener;
                platform2.afterRegister(i5, obj);
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform2, int i6, Throwable th) {
                e.this.c = platformActionListener;
                if (e.this.c != null) {
                    e.this.c.onError(platform2, i6, th);
                }
            }
        };
        platform.doAuthorize(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Platform platform) {
        try {
            try {
                return a(platform.getDb(), new String[]{"nickname", "icon", "gender", "snsUserUrl", "resume", "secretType", "secret", "birthday", "followerCount", "favouriteCount", "shareCount", "snsregat", "snsUserLevel", "educationJSONArrayStr", "workJSONArrayStr"});
            } catch (Throwable th) {
                th = th;
                SSDKLog.b().b(th);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String a(PlatformDb platformDb, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i5 = 0;
        for (String str : strArr) {
            if (i5 > 0) {
                sb2.append('|');
                sb.append('|');
            }
            i5++;
            String str2 = platformDb.get(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
                sb2.append(Data.urlEncode(str2, "utf-8"));
            }
        }
        SSDKLog.b().b("======UserData: " + sb.toString());
        return sb2.toString();
    }

    private String a(String str) {
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("errorCode")) {
                    return jSONObject.optString("errorCode");
                }
                if (jSONObject.has("errCode")) {
                    return jSONObject.optString("errCode");
                }
                if (jSONObject.has("code")) {
                    return jSONObject.optString("code");
                }
                return jSONObject.has("error_code") ? jSONObject.optString("error_code") : "";
            } catch (Exception unused) {
                Matcher matcher = this.f2187a.matcher(str);
                return (!matcher.find() || TextUtils.isEmpty(matcher.group(1))) ? "" : matcher.group(1).trim();
            }
        } catch (Throwable unused2) {
            return "";
        }
    }
}
