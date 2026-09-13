package cn.sharesdk.twitter;

import A3.AbstractC0157z;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import androidx.webkit.ProxyConfig;
import androidx.webkit.internal.AssetHelper;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.a.a.e;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOAuthorizeActivity;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.network.SSDKNetworkHelper;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class c extends f {
    private static c b;
    private cn.sharesdk.framework.utils.b c;
    private SSDKNetworkHelper d;
    private MappedFileReader e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f2340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2341h;

    private c(Platform platform) {
        super(platform);
        this.f2339f = 0;
        this.c = new cn.sharesdk.framework.utils.b();
        this.d = SSDKNetworkHelper.getInstance();
    }

    public void b(String str) {
        this.f2341h = str;
    }

    public String c() {
        return this.f2341h;
    }

    public HashMap<String, Object> d(String str) {
        return d(str, null);
    }

    public HashMap<String, Object> e(String str, String str2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        ArrayList<KVPair<String>> arrayListA = this.c.a(this.c.a("https://api.twitter.com/1.1/statuses/update_with_media.json", arrayList));
        arrayListA.remove(1);
        arrayList.add(new KVPair<>(NotificationCompat.CATEGORY_STATUS, str));
        String strHttpPost = this.d.httpPost("https://api.twitter.com/1.1/statuses/update_with_media.json", arrayList, new KVPair<>("media[]", str2), arrayListA, "/1.1/statuses/update_with_media.json", b());
        if (strHttpPost == null || strHttpPost.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpPost);
    }

    public HashMap<String, Object> f(String str, String str2) {
        long fileSize = ResHelper.getFileSize(str2);
        this.f2339f = 0;
        HashMap<String, Object> mapA = a(str, str2, fileSize);
        if (mapA == null) {
            return null;
        }
        String str3 = (String) mapA.get("media_id_string");
        if (TextUtils.isEmpty(str3) || b(str2, str3, fileSize) == null) {
            return null;
        }
        return a(str3, fileSize, str);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        try {
            return "https://twitter.com/i/oauth2/authorize?response_type=code&client_id=" + this.c.a().f2228a + "&redirect_uri=" + this.c.a().e + "&scope=tweet.read%20users.read%20tweet.write&state=state&code_challenge=challenge&code_challenge_method=plain";
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(WebAuthorizeActivity webAuthorizeActivity) {
        b bVar = new b(webAuthorizeActivity);
        String strH = e.a().h("twitter_auth_url");
        if (TextUtils.isEmpty(strH)) {
            strH = "https://twitter.com/home";
        }
        bVar.a(strH);
        return bVar;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return this.c.a().e;
    }

    @Override // cn.sharesdk.framework.f, cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.c getSSOProcessor(SSOAuthorizeActivity sSOAuthorizeActivity) {
        d dVar = new d(sSOAuthorizeActivity);
        dVar.a(this.f2340g);
        dVar.b(this.f2341h);
        return dVar;
    }

    public HashMap<String, Object> b(String str, String str2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("nextCursor", str2));
        try {
            ResHelper.parseLong(str);
            arrayList.add(new KVPair<>("user_id", str));
        } catch (Throwable unused) {
            arrayList.add(new KVPair<>(FirebaseAnalytics.Param.SCREEN_NAME, str));
        }
        String strHttpGet = this.d.httpGet("https://api.twitter.com/1.1/friends/list.json", arrayList, this.c.a(this.c.b("https://api.twitter.com/1.1/friends/list.json", arrayList)), null, "/1.1/friends/list.json", b());
        if (strHttpGet == null || strHttpGet.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpGet);
    }

    public HashMap<String, Object> c(String str) {
        String token = this.f2190a.getDb().getToken();
        if (TextUtils.isEmpty(token)) {
            SSDKLog.b().b("tw token null");
            return null;
        }
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(HttpHeaders.AUTHORIZATION, AbstractC0157z.n("Bearer ", token)));
        String strHttpGet = this.d.httpGet("https://api.twitter.com/2/users/me", arrayList, arrayList2, null, "/2/users/", b());
        if (strHttpGet == null || strHttpGet.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpGet);
    }

    public HashMap<String, Object> d(String str, String str2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(NotificationCompat.CATEGORY_STATUS, str));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new KVPair<>("media_ids", str2));
        }
        String strHttpPost = this.d.httpPost("https://api.twitter.com/1.1/statuses/update.json", arrayList, null, this.c.a(this.c.a("https://api.twitter.com/1.1/statuses/update.json", arrayList)), "/1.1/statuses/update.json", b());
        if (strHttpPost == null || strHttpPost.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpPost);
    }

    public static c a(Platform platform) {
        if (b == null) {
            b = new c(platform);
        }
        return b;
    }

    public void a(String str) {
        this.f2340g = str;
    }

    public String a() {
        return this.f2340g;
    }

    public void a(String str, String str2, String str3) {
        this.c.a(str, str2, str3);
        a(str);
        b(str2);
    }

    private HashMap<String, Object> e(String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("command", "FINALIZE"));
        arrayList.add(new KVPair<>("media_id", str));
        ArrayList<KVPair<String>> arrayListA = this.c.a(this.c.a("https://upload.twitter.com/1.1/media/upload.json", arrayList));
        arrayListA.remove(1);
        String strHttpPost = this.d.httpPost("https://upload.twitter.com/1.1/media/upload.json", arrayList, null, arrayListA, "/1.1/media/upload.json", b());
        if (strHttpPost == null || strHttpPost.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpPost);
    }

    private String b(String str, final String str2, final long j6) {
        MappedFileReader mappedFileReader = new MappedFileReader(str, 524288);
        this.e = mappedFileReader;
        byte[] bArrA = a(mappedFileReader);
        if (bArrA == null) {
            return null;
        }
        a(MappedFileReader.byteToBase64(bArrA), true, new UpLoadViewCallBack() { // from class: cn.sharesdk.twitter.c.1
            @Override // cn.sharesdk.twitter.UpLoadViewCallBack
            public void onResule(String str3) throws IOException {
                c cVar = c.this;
                byte[] bArrA2 = cVar.a(cVar.e);
                if (bArrA2 != null) {
                    c.this.a(MappedFileReader.byteToBase64(bArrA2), true, (UpLoadViewCallBack) this, str2, j6);
                } else if (c.this.e != null) {
                    c.this.e.close();
                }
            }
        }, str2, j6);
        return "Done";
    }

    public void a(String str, String str2) {
        this.c.a(str, str2);
    }

    public void a(AuthorizeListener authorizeListener, boolean z6) {
        try {
            b(authorizeListener);
        } catch (Throwable th) {
            SSDKLog.b().b(th);
        }
    }

    public HashMap<String, Object> a(String str, String[] strArr) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        ArrayList<KVPair<String>> arrayListA = this.c.a(this.c.a("https://upload.twitter.com/1.1/media/upload.json", arrayList));
        arrayListA.remove(1);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < strArr.length && arrayList2.size() <= 3; i5++) {
            try {
                String strDownloadBitmap = strArr[i5];
                if (strDownloadBitmap.startsWith(ProxyConfig.MATCH_HTTP)) {
                    strDownloadBitmap = BitmapHelper.downloadBitmap(MobSDK.getContext(), strDownloadBitmap);
                } else {
                    if (!TextUtils.isEmpty(strDownloadBitmap) && new File(strDownloadBitmap).exists()) {
                    }
                }
                String strHttpPost = this.d.httpPost("https://upload.twitter.com/1.1/media/upload.json", arrayList, new KVPair<>("media", strDownloadBitmap), arrayListA, "/1.1/media/upload.json", b());
                sb.append(strArr[i5]);
                sb.append(": ");
                sb.append(strHttpPost);
                sb.append("\n");
                if (strHttpPost != null && strHttpPost.length() > 0) {
                    arrayList2.add(new Hashon().fromJson(strHttpPost));
                }
            } catch (Exception unused) {
                SSDKLog.b().a(sb.toString(), new Object[0]);
            }
        }
        sb.setLength(0);
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            if (((HashMap) arrayList2.get(i6)).containsKey("image")) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(String.valueOf(((HashMap) arrayList2.get(i6)).get("media_id")));
            }
        }
        return d(str, sb.toString());
    }

    public HashMap<String, Object> c(String str, String str2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("nextCursor", str2));
        try {
            ResHelper.parseLong(str);
            arrayList.add(new KVPair<>("user_id", str));
        } catch (Throwable unused) {
            arrayList.add(new KVPair<>(FirebaseAnalytics.Param.SCREEN_NAME, str));
        }
        String strHttpGet = this.d.httpGet("https://api.twitter.com/1.1/followers/list.json", arrayList, this.c.a(this.c.b("https://api.twitter.com/1.1/followers/list.json", arrayList)), null, "/1.1/followers/list.json", b());
        if (strHttpGet == null || strHttpGet.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpGet);
    }

    private HashMap<String, Object> a(String str, long j6, String str2) {
        HashMap<String, Object> mapE = e(str);
        if (mapE == null || !((String) mapE.get("media_id_string")).equals(str)) {
            return null;
        }
        return d(str2, str);
    }

    private HashMap<String, Object> a(String str, String str2, long j6) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("command", "INIT"));
        arrayList.add(new KVPair<>("media_type", "video/mp4"));
        arrayList.add(new KVPair<>("total_bytes", String.valueOf(j6)));
        ArrayList<KVPair<String>> arrayListA = this.c.a(this.c.a("https://upload.twitter.com/1.1/media/upload.json", arrayList));
        arrayListA.remove(1);
        String strHttpPost = this.d.httpPost("https://upload.twitter.com/1.1/media/upload.json", arrayList, null, arrayListA, "/1.1/media/upload.json", b());
        if (strHttpPost == null || strHttpPost.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpPost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z6, UpLoadViewCallBack upLoadViewCallBack, String str2, long j6) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("command", "APPEND"));
        arrayList.add(new KVPair<>("media_id", str2));
        if (z6) {
            arrayList.add(new KVPair<>("media_data", str));
        } else {
            arrayList.add(new KVPair<>("media", str));
        }
        arrayList.add(new KVPair<>("segment_index", AbstractC0157z.l("", this.f2339f, new StringBuilder())));
        this.f2339f++;
        String strHttpPost = this.d.httpPost("https://upload.twitter.com/1.1/media/upload.json", arrayList, null, this.c.a(this.c.a("https://upload.twitter.com/1.1/media/upload.json", arrayList)), "/1.1/media/upload.json", b());
        if (upLoadViewCallBack != null) {
            upLoadViewCallBack.onResule(strHttpPost);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(MappedFileReader mappedFileReader) {
        if (mappedFileReader == null || mappedFileReader.read() == -1) {
            return null;
        }
        return mappedFileReader.getArray();
    }

    public HashMap<String, Object> a(String str, String str2, HashMap<String, Object> map, HashMap<String, String> map2) {
        KVPair<String> kVPair;
        String strHttpPost;
        ArrayList<KVPair<String>> arrayListA;
        if (str2 == null) {
            return null;
        }
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                arrayList.add(new KVPair<>(entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        if (map2 == null || map2.size() <= 0) {
            kVPair = null;
        } else {
            KVPair<String> kVPair2 = null;
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                kVPair2 = new KVPair<>(entry2.getKey(), entry2.getValue());
            }
            kVPair = kVPair2;
        }
        if (ShareTarget.METHOD_GET.equals(str2.toUpperCase())) {
            strHttpPost = this.d.httpGet(str, arrayList, this.c.a(this.c.b(str, arrayList)), (NetworkHelper.NetworkTimeOut) null);
        } else if (ShareTarget.METHOD_POST.equals(str2.toUpperCase())) {
            if (map2 != null && map2.size() > 0) {
                arrayListA = this.c.a(this.c.a(str, new ArrayList<>()));
                arrayListA.remove(1);
            } else {
                arrayListA = this.c.a(this.c.a(str, arrayList));
            }
            strHttpPost = this.d.httpPost(str, arrayList, kVPair, arrayListA, (NetworkHelper.NetworkTimeOut) null);
        } else {
            strHttpPost = null;
        }
        if (strHttpPost == null || strHttpPost.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(strHttpPost);
    }

    public void a(String str, String[] strArr, PlatformActionListener platformActionListener, Platform.ShareParams shareParams) {
        try {
            List<String> listAsList = Arrays.asList(strArr);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (String strDownloadBitmap : listAsList) {
                if (strDownloadBitmap.startsWith(ProxyConfig.MATCH_HTTP) || strDownloadBitmap.startsWith(ProxyConfig.MATCH_HTTPS)) {
                    strDownloadBitmap = BitmapHelper.downloadBitmap(MobSDK.getContext(), strDownloadBitmap);
                }
                File file = new File(strDownloadBitmap);
                if (file.exists()) {
                    File file2 = new File(ResHelper.getCachePath(MobSDK.getContext(), "images"), System.currentTimeMillis() + file.getName());
                    String absolutePath = file2.getAbsolutePath();
                    file2.createNewFile();
                    if (ResHelper.copyFile(strDownloadBitmap, absolutePath)) {
                        file = file2;
                    }
                    Uri uriA = ShareSDKFileProvider.a(MobSDK.getContext(), MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                    MobSDK.getContext().grantUriPermission("com.twitter.android", uriA, 3);
                    arrayList.add(uriA);
                }
            }
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setPackage("com.twitter.android");
            intent.setClassName("com.twitter.android", "com.twitter.composer.ComposerActivity");
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("android.intent.extra.TEXT", str);
            }
            if (arrayList.size() <= 0) {
                intent.setAction("android.intent.action.SEND");
                intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            } else {
                String str2 = "image/*";
                if (arrayList.size() == 1 && arrayList.get(0) != null) {
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.STREAM", arrayList.get(0));
                    String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(((Uri) arrayList.get(0)).toString());
                    if (contentTypeFor != null && contentTypeFor.length() > 0) {
                        str2 = contentTypeFor;
                    }
                    intent.setType(str2);
                } else {
                    intent.setAction("android.intent.action.SEND_MULTIPLE");
                    intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                    intent.setType("image/*");
                }
            }
            MobSDK.getContext().startActivity(intent);
            HashMap<String, Object> map = new HashMap<>();
            map.put("ShareParams", shareParams);
            platformActionListener.onComplete(this.f2190a, 9, map);
        } catch (Throwable th) {
            if (platformActionListener != null) {
                SSDKLog.b().a("Twitter system share multiple image catch: " + th);
                platformActionListener.onError(getPlatform(), 9, th);
            }
        }
    }

    public void a(String str, String str2, String str3, PlatformActionListener platformActionListener, Platform.ShareParams shareParams) {
        try {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str3)) {
                    str2 = null;
                } else {
                    try {
                        str2 = BitmapHelper.downloadBitmap(MobSDK.getContext(), str3);
                    } catch (Throwable th) {
                        if (platformActionListener != null) {
                            platformActionListener.onError(getPlatform(), 9, new Throwable("used imageUrl but download image catch: " + th.getMessage()));
                            return;
                        }
                        str2 = null;
                    }
                }
            }
            SSDKLog.b().a("shareImage bypassApproval and resultPath is: " + str2);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.addFlags(268435456);
            intent.setPackage("com.twitter.android");
            intent.setClassName("com.twitter.android", "com.twitter.composer.ComposerActivity");
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("android.intent.extra.TEXT", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    File file = new File(str2);
                    Uri uriA = ShareSDKFileProvider.a(MobSDK.getContext(), MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                    MobSDK.getContext().grantUriPermission("com.twitter.android", uriA, 3);
                    intent.putExtra("android.intent.extra.STREAM", uriA);
                } catch (Exception e) {
                    SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "doShareToQQ() getUriForFile exception:" + e);
                }
            }
            intent.setType("image/*");
            MobSDK.getContext().startActivity(intent);
            HashMap<String, Object> map = new HashMap<>();
            map.put("ShareParams", shareParams);
            platformActionListener.onComplete(this.f2190a, 9, map);
        } catch (Throwable th2) {
            if (platformActionListener != null) {
                SSDKLog.b().a("Twitter system share image catch: " + th2);
                platformActionListener.onError(getPlatform(), 9, th2);
            }
        }
    }

    public void a(String str, PlatformActionListener platformActionListener, Platform.ShareParams shareParams) {
        try {
            if (TextUtils.isEmpty(str) && platformActionListener != null) {
                platformActionListener.onError(getPlatform(), 9, new Throwable("share text but text is null"));
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.addFlags(268435456);
            intent.setPackage("com.twitter.android");
            intent.setClassName("com.twitter.android", "com.twitter.composer.ComposerActivity");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            MobSDK.getContext().startActivity(intent);
            HashMap<String, Object> map = new HashMap<>();
            map.put("ShareParams", shareParams);
            platformActionListener.onComplete(this.f2190a, 9, map);
        } catch (Throwable th) {
            if (platformActionListener != null) {
                SSDKLog.b().a("Twitter system share text catch: " + th);
                platformActionListener.onError(getPlatform(), 9, th);
            }
        }
    }
}
