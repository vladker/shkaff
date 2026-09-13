package cn.sharesdk.facebook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.b.j;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import cn.sharesdk.framework.utils.g;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Facebook extends Platform {
    public static final String NAME = "Facebook";
    public static final String PARAMS_HASHTAG = "params_Hashtag";
    public static final String PARAMS_LINKURL = "params_linkurl";
    public static final String PARAMS_QUOTE = "params_Quote";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2036a;
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2037f;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ShareParams extends Platform.ShareParams {
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i5, Object obj) {
        SSDKLog.b().a("Facebook checkAuthorize ");
        SSDKLog.b().a("Facebook checkAuthorize action == " + String.valueOf(i5));
        SSDKLog.b().a("Facebook checkAuthorize shareByAppClient == " + String.valueOf(this.c));
        SSDKLog.b().a("Facebook checkAuthorize isClientValid == " + String.valueOf(this.isClientValid));
        if (i5 == 9 && this.c && this.isClientValid) {
            SSDKLog.b().a("Facebook checkAuthorize ACTION_SHARE return true");
            return true;
        }
        if (i5 == 6) {
            SSDKLog.b().a("Facebook checkAuthorize ACTION_FOLLOWING_USER return true");
            return true;
        }
        if (isAuthValid()) {
            SSDKLog.b().a("Facebook checkAuthorize isAuthValid return true");
            d dVarA = d.a(this);
            dVarA.a(this.f2036a);
            String token = this.db.getToken();
            String strValueOf = String.valueOf(this.db.getExpiresIn());
            if (token != null && strValueOf != null) {
                dVarA.a(token, strValueOf);
                if (dVarA.a()) {
                    return true;
                }
            }
        } else if ((obj instanceof Platform.ShareParams) && ((Platform.ShareParams) obj).getShareType() == 4) {
            SSDKLog.b().a("Facebook checkAuthorize SHARE_WEBPAGE return true");
            return true;
        }
        innerAuthorize(i5, obj);
        SSDKLog.b().a("Facebook checkAuthorize return false");
        return false;
    }

    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        if (!this.d) {
            SSDKLog.b().a("Facebook doAuthorize by origianl");
            final d dVarA = d.a(this);
            dVarA.a(this.f2036a);
            dVarA.b(this.b);
            dVarA.a(strArr);
            dVarA.a(new AuthorizeListener() { // from class: cn.sharesdk.facebook.Facebook.1
                @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                public void onCancel() {
                    if (((Platform) Facebook.this).listener != null) {
                        ((Platform) Facebook.this).listener.onCancel(Facebook.this, 1);
                    }
                    SSDKLog.b().a("Facebook doAuthorize by origianl onCancel ");
                }

                @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                public void onComplete(Bundle bundle) {
                    SSDKLog.b().a("Facebook doAuthorize by origianl onComplete ");
                    String string = bundle.getString("oauth_token");
                    int i5 = bundle.getInt("oauth_token_expires");
                    if (i5 == 0) {
                        try {
                            i5 = ResHelper.parseInt(String.valueOf(bundle.get("expires_in")));
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                            i5 = 0;
                        }
                    }
                    if (TextUtils.isEmpty(string)) {
                        string = bundle.getString("access_token");
                    }
                    ((Platform) Facebook.this).db.putToken(string);
                    ((Platform) Facebook.this).db.putExpiresIn(i5);
                    dVarA.a(string, String.valueOf(i5));
                    Facebook.this.afterRegister(1, null);
                }

                @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                public void onError(Throwable th) {
                    if (((Platform) Facebook.this).listener != null) {
                        ((Platform) Facebook.this).listener.onError(Facebook.this, 1, th);
                    }
                    SSDKLog.b().a("Facebook doAuthorize by origianl onError " + th);
                }
            }, isSSODisable());
            return;
        }
        try {
            SSDKLog.b().a("Facebook doAuthorize by official");
            new FacebookOfficialAuth(this.listener, this).show(MobSDK.getContext(), null);
            SSDKLog.b().a("Facebook doAuthorize ");
        } catch (Throwable th) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 1, th);
            }
            SSDKLog.b().a("Facebook doAuthorize catch: " + th);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i5, HashMap<String, Object> map, HashMap<String, String> map2) {
        try {
            HashMap<String, Object> mapA = d.a(this).a(str, str2, map, map2);
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

    /* JADX WARN: Code duplicated, block: B:185:0x056c  */
    /* JADX WARN: Code duplicated, block: B:205:? A[RETURN, SYNTHETIC] */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(final Platform.ShareParams shareParams) {
        PlatformActionListener platformActionListener;
        int i5 = 0;
        SSDKLog.b().a("Facebook doShare with consumerKey:" + this.f2036a + "redirectUrl" + this.b + "official" + this.d, new Object[0]);
        SSDKLog sSDKLogB = SSDKLog.b();
        StringBuilder sb = new StringBuilder("FaceBook ShareParams:");
        sb.append(shareParams.toString());
        sSDKLogB.a(sb.toString(), new Object[0]);
        d dVarA = d.a(this);
        dVarA.a(this.f2036a);
        try {
            String imagePath = shareParams.getImagePath();
            String imageUrl = shareParams.getImageUrl();
            String url = shareParams.getUrl();
            List<String> arrayList = new ArrayList();
            if (shareParams.getImageArray() != null) {
                arrayList = Arrays.asList(shareParams.getImageArray());
            }
            if (this.e) {
                if (this.c) {
                    SSDKLog.b().a("Facebook bypassApproval ", new Object[0]);
                    a(this, shareParams, this.listener);
                    return;
                } else {
                    if (this.listener != null) {
                        this.listener.onError(this, 9, new Throwable("Set share bypassApproval but no client or ShareByAppClient is false"));
                    }
                    SSDKLog.b().a("Set share bypassApproval but no client or ShareByAppClient is false", new Object[0]);
                    return;
                }
            }
            if (this.c) {
                SSDKLog.b().a("Facebook doShare 应用邀请功能");
                if (shareParams.getShareType() == 7) {
                    InviteActivity inviteActivity = new InviteActivity();
                    inviteActivity.setPlatformActionListener(this.listener, this, shareParams);
                    inviteActivity.setInviteParams(this.f2036a);
                    inviteActivity.show(MobSDK.getContext(), null);
                    return;
                }
                if (!this.d) {
                    SSDKLog.b().a("Facebook share by primordial", new Object[0]);
                    if (arrayList == null || arrayList.size() <= 0) {
                        if (TextUtils.isEmpty(imagePath) || !new File(imagePath).exists()) {
                            Bitmap imageData = shareParams.getImageData();
                            if (imageData != null && !imageData.isRecycled()) {
                                File file = new File(ResHelper.getCachePath(MobSDK.getContext(), "images"), System.currentTimeMillis() + ".png");
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                imageData.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                imagePath = file.getAbsolutePath();
                                SSDKLog.b().a("Facebook share by primordial imagepath: " + imagePath, new Object[0]);
                            } else if (!TextUtils.isEmpty(imageUrl)) {
                                imagePath = BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl);
                                SSDKLog.b().a("Facebook share by primordial dowanload imagepath: " + imagePath, new Object[0]);
                            }
                        }
                        if (!TextUtils.isEmpty(imagePath)) {
                            arrayList.add(imagePath);
                            shareParams.setImageArray((String[]) arrayList.toArray(new String[arrayList.size()]));
                        }
                    } else {
                        for (String strDownloadBitmap : arrayList) {
                            if (strDownloadBitmap.startsWith(ProxyConfig.MATCH_HTTP)) {
                                strDownloadBitmap = BitmapHelper.downloadBitmap(MobSDK.getContext(), strDownloadBitmap);
                                arrayList.set(i5, strDownloadBitmap);
                            }
                            File file2 = new File(strDownloadBitmap);
                            if (file2.exists() && strDownloadBitmap.startsWith("/data/")) {
                                arrayList.remove(strDownloadBitmap);
                                File file3 = new File(ResHelper.getCachePath(MobSDK.getContext(), "images"), System.currentTimeMillis() + file2.getName());
                                String absolutePath = file3.getAbsolutePath();
                                file3.createNewFile();
                                if (ResHelper.copyFile(strDownloadBitmap, absolutePath)) {
                                    arrayList.add(file2.getAbsolutePath());
                                }
                            }
                            i5++;
                        }
                    }
                    dVarA.a(this.listener, shareParams);
                    return;
                }
                SSDKLog.b().a("Facebook FacebookOfficialHelper shareImageOfficiall");
                FacebookSdk.sdkInitialize(MobSDK.getContext());
                if (shareParams.getShareType() == 2) {
                    SSDKLog.b().a("Facebook share by official SHARE_IMAGE", new Object[0]);
                    Bitmap imageData2 = shareParams.getImageData();
                    String hashtag = shareParams.getHashtag();
                    String imagePath2 = shareParams.getImagePath();
                    if (imageData2 != null) {
                        SSDKLog.b().a("Facebook share by official that picImageData", new Object[0]);
                        FacebookOfficialShareImage facebookOfficialShareImage = new FacebookOfficialShareImage(this, this.listener);
                        facebookOfficialShareImage.setBitmapParams(imageData2);
                        facebookOfficialShareImage.setHashTag(hashtag);
                        facebookOfficialShareImage.show(MobSDK.getContext(), null);
                        return;
                    }
                    if (!TextUtils.isEmpty(imagePath2)) {
                        try {
                            SSDKLog.b().a("Facebook share by official that ImagePath", new Object[0]);
                            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new FileInputStream(imagePath2));
                            FacebookOfficialShareImage facebookOfficialShareImage2 = new FacebookOfficialShareImage(this, this.listener);
                            facebookOfficialShareImage2.setBitmapParams(bitmapDecodeStream);
                            facebookOfficialShareImage2.setHashTag(hashtag);
                            facebookOfficialShareImage2.show(MobSDK.getContext(), null);
                            return;
                        } catch (Throwable th) {
                            if (this.listener != null) {
                                SSDKLog.b().a("Facebook share image by imagePath catch: " + th, new Object[0]);
                                this.listener.onError(this, 9, th);
                                return;
                            }
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(imageUrl)) {
                        try {
                            SSDKLog.b().a("Facebook share by official that imageUrl", new Object[0]);
                            try {
                                Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(new FileInputStream(BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl)));
                                FacebookOfficialShareImage facebookOfficialShareImage3 = new FacebookOfficialShareImage(this, this.listener);
                                facebookOfficialShareImage3.setBitmapParams(bitmapDecodeStream2);
                                facebookOfficialShareImage3.setHashTag(hashtag);
                                facebookOfficialShareImage3.show(MobSDK.getContext(), null);
                                return;
                            } catch (Throwable th2) {
                                if (this.listener != null) {
                                    this.listener.onError(this, 9, new Throwable("Picture download catch: " + th2));
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th3) {
                            SSDKLog.b().a("Facebook share image by imageUrl catch: " + th3, new Object[0]);
                            PlatformActionListener platformActionListener2 = this.listener;
                            if (platformActionListener2 != null) {
                                platformActionListener2.onError(this, 9, th3);
                                return;
                            }
                            return;
                        }
                    }
                    if (this.listener != null) {
                        SSDKLog.b().a("Facebook doShare official please set imageData params");
                        this.listener.onError(this, 9, new Throwable("please set imageData or imagePath or imageUrl params"));
                        return;
                    }
                    platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onError(this, 9, th);
                    }
                }
                if (shareParams.getShareType() == 6) {
                    SSDKLog.b().a("Facebook share by official that SHARE_VIDEO", new Object[0]);
                    Uri videoUri = shareParams.getVideoUri();
                    if (videoUri == null) {
                        String filePath = shareParams.getFilePath();
                        if (TextUtils.isEmpty(filePath)) {
                            SSDKLog.b().a("filePath file is not exists", new Object[0]);
                        } else {
                            File file4 = new File(filePath);
                            if (file4.exists()) {
                                videoUri = ShareSDKFileProvider.a(MobSDK.getContext(), MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file4);
                                MobSDK.getContext().grantUriPermission("com.facebook.katana", videoUri, 3);
                            }
                        }
                    }
                    String hashtag2 = shareParams.getHashtag();
                    if (videoUri != null) {
                        FacebookOfficialShareVideo facebookOfficialShareVideo = new FacebookOfficialShareVideo(this, this.listener);
                        facebookOfficialShareVideo.setVideoUri(videoUri);
                        facebookOfficialShareVideo.setHashTag(hashtag2);
                        facebookOfficialShareVideo.show(MobSDK.getContext(), null);
                        return;
                    }
                    if (this.listener != null) {
                        SSDKLog.b().a("Facebook doShare official please set video uri");
                        this.listener.onError(this, 9, new Throwable("please set video uri"));
                        return;
                    }
                } else if (shareParams.getShareType() == 4) {
                    SSDKLog.b().a("Facebook share by official that SHARE_WEBPAGE", new Object[0]);
                    String url2 = shareParams.getUrl();
                    String quote = shareParams.getQuote();
                    String hashtag3 = shareParams.getHashtag();
                    if (!TextUtils.isEmpty(url2)) {
                        FacebookOfficialShareWebPage facebookOfficialShareWebPage = new FacebookOfficialShareWebPage(this, this.listener);
                        Intent intent = new Intent();
                        intent.putExtra(PARAMS_LINKURL, url2);
                        intent.putExtra(PARAMS_QUOTE, quote);
                        intent.putExtra(PARAMS_HASHTAG, hashtag3);
                        facebookOfficialShareWebPage.show(MobSDK.getContext(), intent);
                        return;
                    }
                    if (this.listener != null) {
                        SSDKLog.b().a("Facebook doShare official please set webpage url");
                        this.listener.onError(this, 9, new Throwable("please set webpage url"));
                        return;
                    }
                } else if (shareParams.getShareType() == 1) {
                    SSDKLog.b().a("Facebook share by official that SHARE_TEXT", new Object[0]);
                    String text = shareParams.getText();
                    if (!TextUtils.isEmpty(text)) {
                        FacebookOfficialShareWebPage facebookOfficialShareWebPage2 = new FacebookOfficialShareWebPage(this, this.listener);
                        Intent intent2 = new Intent();
                        intent2.putExtra(PARAMS_LINKURL, "https://");
                        intent2.putExtra(PARAMS_QUOTE, "");
                        intent2.putExtra(PARAMS_HASHTAG, text);
                        facebookOfficialShareWebPage2.show(MobSDK.getContext(), intent2);
                        return;
                    }
                    if (this.listener != null) {
                        SSDKLog.b().a("Facebook doShare official please set text");
                        this.listener.onError(this, 9, new Throwable("please set text"));
                        return;
                    }
                } else if (this.listener != null) {
                    SSDKLog.b().a("Facebook doShare official please set share Type");
                    this.listener.onError(this, 9, new Throwable("please set share Type"));
                    return;
                }
            }
            if (!TextUtils.isEmpty(url)) {
                if (TextUtils.isEmpty(imageUrl) && !TextUtils.isEmpty(imagePath) && new File(imagePath).exists()) {
                    shareParams.setImageUrl(uploadImageToFileServer(imagePath));
                }
                dVarA.a(shareParams, new PlatformActionListener() { // from class: cn.sharesdk.facebook.Facebook.2
                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onCancel(Platform platform, int i6) {
                        if (((Platform) Facebook.this).listener != null) {
                            ((Platform) Facebook.this).listener.onCancel(Facebook.this, 9);
                        }
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onComplete(Platform platform, int i6, HashMap<String, Object> map) {
                        if (((Platform) Facebook.this).listener != null) {
                            map.put("ShareParams", shareParams);
                            ((Platform) Facebook.this).listener.onComplete(Facebook.this, 9, map);
                        }
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onError(Platform platform, int i6, Throwable th4) {
                        if (((Platform) Facebook.this).listener != null) {
                            ((Platform) Facebook.this).listener.onError(Facebook.this, 9, th4);
                        }
                    }
                });
                return;
            }
            if (!TextUtils.isEmpty(imagePath) && new File(imagePath).exists()) {
                PlatformActionListener platformActionListener3 = this.listener;
                if (platformActionListener3 != null) {
                    platformActionListener3.onError(this, 9, new Throwable("Please install the facebook client"));
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(imageUrl)) {
                PlatformActionListener platformActionListener4 = this.listener;
                if (platformActionListener4 != null) {
                    platformActionListener4.onError(this, 9, new Throwable("Please install the facebook client"));
                    return;
                }
            } else if (TextUtils.isEmpty(shareParams.getFilePath())) {
                PlatformActionListener platformActionListener5 = this.listener;
                if (platformActionListener5 != null) {
                    platformActionListener5.onError(this, 9, new Throwable("Share parameter error, please check"));
                    return;
                }
            } else {
                PlatformActionListener platformActionListener6 = this.listener;
                if (platformActionListener6 != null) {
                    platformActionListener6.onError(this, 9, new Throwable("Share video only supports facebook client, please install facebook client"));
                    return;
                }
            }
            PlatformActionListener platformActionListener7 = this.listener;
            if (platformActionListener7 != null) {
                platformActionListener7.onError(this, 9, new Throwable("response is null"));
            }
        } catch (Throwable th4) {
            platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 9, th4);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> filterFriendshipInfo(int i5, HashMap<String, Object> map) {
        String str;
        String str2;
        String str3;
        String str4 = "year";
        String str5 = "birthday";
        String str6 = "data";
        Object obj = map.get("data");
        if (obj == null) {
            return null;
        }
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("type", "FOLLOWING");
        map2.put("snsplat", Integer.valueOf(getPlatformId()));
        String str7 = "snsuid";
        map2.put("snsuid", this.db.getUserId());
        int iIntValue = ((Integer) map.get("current_cursor")).intValue();
        int iIntValue2 = ((Integer) map.get("current_limit")).intValue();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) obj;
        if (arrayList2.size() <= 0) {
            return null;
        }
        int size = arrayList2.size();
        int i6 = 0;
        while (i6 < size) {
            i6++;
            size = size;
            HashMap map3 = (HashMap) arrayList2.get(i6);
            if (map3 != null) {
                ArrayList arrayList3 = arrayList2;
                HashMap map4 = new HashMap();
                map4.put(str7, String.valueOf(map3.get("id")));
                int i7 = iIntValue;
                map4.put("nickname", String.valueOf(map3.get("name")));
                String str8 = str7;
                map4.put("gender", "male".equals(String.valueOf(map3.get("gender"))) ? "0" : "1");
                map4.put("secretType", "true".equals(String.valueOf(map3.get("verified"))) ? "1" : "0");
                map4.put("snsUserUrl", String.valueOf(map3.get("link")));
                map4.put("resume", String.valueOf(map3.get("link")));
                HashMap map5 = map3.containsKey("picture") ? (HashMap) map3.get("picture") : null;
                if (map5 != null) {
                    HashMap map6 = map5.containsKey(str6) ? (HashMap) map5.get(str6) : null;
                    if (map6 != null) {
                        map4.put("icon", String.valueOf(map6.get("url")));
                    }
                }
                try {
                    if (map3.containsKey(str5)) {
                        String[] strArrSplit = String.valueOf(map3.get(str5)).split(PackagingURIHelper.FORWARD_SLASH_STRING);
                        Calendar calendar = Calendar.getInstance();
                        str = str6;
                        try {
                            calendar.set(1, ResHelper.parseInt(strArrSplit[2]));
                            calendar.set(2, ResHelper.parseInt(strArrSplit[0]) - 1);
                            calendar.set(5, ResHelper.parseInt(strArrSplit[1]));
                            map4.put(str5, String.valueOf(calendar.getTimeInMillis()));
                        } catch (Throwable th) {
                            th = th;
                            SSDKLog.b().a(th);
                        }
                    } else {
                        str = str6;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str = str6;
                }
                ArrayList arrayList4 = map3.containsKey("education") ? (ArrayList) map3.get("education") : null;
                if (arrayList4 != null) {
                    ArrayList arrayList5 = new ArrayList();
                    int size2 = arrayList4.size();
                    int i8 = 0;
                    while (i8 < size2) {
                        int i9 = i8 + 1;
                        HashMap map7 = (HashMap) arrayList4.get(i8);
                        String str9 = str5;
                        HashMap map8 = new HashMap();
                        ArrayList arrayList6 = arrayList4;
                        map8.put("school_type", 0);
                        int i10 = size2;
                        HashMap map9 = (HashMap) map7.get("school");
                        if (map9 != null) {
                            map8.put("school", String.valueOf(map9.get("name")));
                        }
                        try {
                            map8.put(str4, Integer.valueOf(ResHelper.parseInt(String.valueOf(((HashMap) map7.get(str4)).get("name")))));
                        } catch (Throwable th3) {
                            SSDKLog.b().a(th3);
                        }
                        map8.put("background", 0);
                        arrayList5.add(map8);
                        str5 = str9;
                        i8 = i9;
                        arrayList4 = arrayList6;
                        size2 = i10;
                    }
                    str2 = str5;
                    HashMap map10 = new HashMap();
                    map10.put(XmlErrorCodes.LIST, arrayList5);
                    String strFromHashMap = new Hashon().fromHashMap(map10);
                    map4.put("educationJSONArrayStr", strFromHashMap.substring(8, strFromHashMap.length() - 1));
                } else {
                    str2 = str5;
                }
                ArrayList arrayList7 = map3.containsKey("work") ? (ArrayList) map3.get("work") : null;
                if (arrayList7 != null) {
                    ArrayList arrayList8 = new ArrayList();
                    int size3 = arrayList7.size();
                    int i11 = 0;
                    while (i11 < size3) {
                        int i12 = i11 + 1;
                        HashMap map11 = (HashMap) arrayList7.get(i11);
                        String str10 = str4;
                        HashMap map12 = new HashMap();
                        HashMap map13 = (HashMap) map11.get("employer");
                        if (map13 != null) {
                            map12.put("company", String.valueOf(map13.get("name")));
                        }
                        HashMap map14 = (HashMap) map11.get("position");
                        if (map14 != null) {
                            map12.put("position", String.valueOf(map14.get("name")));
                        }
                        try {
                            String[] strArrSplit2 = String.valueOf(map11.get(FirebaseAnalytics.Param.START_DATE)).split(ProcessIdUtil.DEFAULT_PROCESSID);
                            map12.put(FirebaseAnalytics.Param.START_DATE, Integer.valueOf((ResHelper.parseInt(strArrSplit2[0]) * 100) + ResHelper.parseInt(strArrSplit2[1])));
                        } catch (Throwable th4) {
                            SSDKLog.b().a(th4);
                        }
                        try {
                            String[] strArrSplit3 = String.valueOf(map11.get(FirebaseAnalytics.Param.END_DATE)).split(ProcessIdUtil.DEFAULT_PROCESSID);
                            map12.put(FirebaseAnalytics.Param.END_DATE, Integer.valueOf((ResHelper.parseInt(strArrSplit3[0]) * 100) + ResHelper.parseInt(strArrSplit3[1])));
                        } catch (Throwable th5) {
                            SSDKLog.b().a(th5);
                            map12.put(FirebaseAnalytics.Param.END_DATE, 0);
                        }
                        arrayList8.add(map12);
                        i11 = i12;
                        str4 = str10;
                        arrayList7 = arrayList7;
                    }
                    str3 = str4;
                    HashMap map15 = new HashMap();
                    map15.put(XmlErrorCodes.LIST, arrayList8);
                    String strFromHashMap2 = new Hashon().fromHashMap(map15);
                    map4.put("workJSONArrayStr", strFromHashMap2.substring(8, strFromHashMap2.length() - 1));
                } else {
                    str3 = str4;
                }
                arrayList.add(map4);
                arrayList2 = arrayList3;
                iIntValue = i7;
                str7 = str8;
                str6 = str;
                str5 = str2;
                str4 = str3;
            }
        }
        int i13 = iIntValue;
        if (arrayList.size() <= 0) {
            return null;
        }
        map2.put("nextCursor", (arrayList.size() + i13) + (iIntValue2 >= arrayList.size() ? "_true" : "_false"));
        map2.put(XmlErrorCodes.LIST, arrayList);
        return map2;
    }

    @Override // cn.sharesdk.framework.Platform
    public j.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        j.a aVar = new j.a();
        aVar.b = shareParams.getText();
        if (map != null) {
            if (map.containsKey(FirebaseAnalytics.Param.SOURCE)) {
                aVar.d.add(String.valueOf(map.get(FirebaseAnalytics.Param.SOURCE)));
            } else if (4 == shareParams.getShareType()) {
                aVar.d.add(shareParams.getImageUrl());
                String titleUrl = shareParams.getTitleUrl();
                if (TextUtils.isEmpty(titleUrl)) {
                    titleUrl = shareParams.getUrl();
                }
                aVar.c.add(titleUrl);
            }
            Object obj = map.get("post_id");
            aVar.f2154a = obj == null ? null : String.valueOf(obj);
            aVar.f2156g = map;
        }
        return aVar;
    }

    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 7);
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
        try {
            HashMap<String, Object> mapA = d.a(this).a(i5, i6, str);
            if (mapA != null && mapA.size() > 0 && !mapA.containsKey("error_code") && !mapA.containsKey("error")) {
                mapA.put("current_limit", Integer.valueOf(i5));
                mapA.put("current_cursor", Integer.valueOf(i6));
                return filterFriendshipInfo(2, mapA);
            }
            return null;
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i5, int i6, String str) {
        try {
            HashMap<String, Object> mapA = d.a(this).a(i5, i6 * i5, str);
            if (mapA != null && mapA.size() > 0) {
                if (!mapA.containsKey("error_code") && !mapA.containsKey("error")) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, 2, mapA);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(mapA)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 2, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, 2, th);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 10;
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
        this.f2036a = getDevinfo("ConsumerKey");
        this.b = getDevinfo("RedirectUrl");
        this.c = "true".equals(getDevinfo("ShareByAppClient"));
        this.e = "true".equals(getDevinfo("BypassApproval"));
        SSDKLog.b().a("Facebook initDevInfo ShareByAppClient value is: " + getDevinfo("ShareByAppClient"));
        if (TextUtils.isEmpty(getDevinfo("FaceBookAppType"))) {
            this.f2037f = false;
        } else {
            this.f2037f = true;
            SSDKLog.b().a("Facebook AppType is: " + getDevinfo("Official"));
        }
        if (TextUtils.isEmpty(getDevinfo("OfficialVersion"))) {
            this.d = false;
            return;
        }
        this.d = true;
        SSDKLog.b().a("Facebook Official value is: " + getDevinfo("Official"));
    }

    @Override // cn.sharesdk.framework.Platform
    public void isClientValid(ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            d dVarA = d.a(this);
            dVarA.a(this.f2036a);
            dVarA.a(shareSDKCallback);
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
        if (this.d) {
            LoginManager.getInstance().logOut();
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f2036a = getNetworkDevinfo("api_key", "ConsumerKey");
        String networkDevinfo = getNetworkDevinfo("redirect_uri", "RedirectUrl");
        this.b = networkDevinfo;
        if (TextUtils.isEmpty(networkDevinfo)) {
            this.b = "fbconnect://success";
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
        String str2;
        HashMap map;
        Object obj = FirebaseAnalytics.Param.END_DATE;
        String str3 = ProcessIdUtil.DEFAULT_PROCESSID;
        d dVarA = d.a(this);
        Object obj2 = FirebaseAnalytics.Param.START_DATE;
        try {
            HashMap<String, Object> mapA = dVarA.a(str, Boolean.valueOf(this.f2037f));
            if (mapA != null && mapA.size() > 0) {
                if (!mapA.containsKey("error_code") && !mapA.containsKey("error")) {
                    if (str == null) {
                        this.db.putUserId(String.valueOf(mapA.get("id")));
                        Object obj3 = "position";
                        this.db.put("nickname", String.valueOf(mapA.get("name")));
                        String str4 = "1";
                        this.db.put("gender", "male".equals(String.valueOf(mapA.get("gender"))) ? "0" : "1");
                        this.db.put("token_for_business", (String) mapA.get("token_for_business"));
                        HashMap map2 = mapA.containsKey("picture") ? (HashMap) mapA.get("picture") : null;
                        if (map2 != null && (map = (HashMap) map2.get("data")) != null) {
                            this.db.put("icon", String.valueOf(map.get("url")));
                        }
                        char c = 1;
                        try {
                            if (mapA.containsKey("birthday")) {
                                String[] strArrSplit = String.valueOf(mapA.get("birthday")).split(PackagingURIHelper.FORWARD_SLASH_STRING);
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(1, ResHelper.parseInt(strArrSplit[2]));
                                calendar.set(2, ResHelper.parseInt(strArrSplit[0]) - 1);
                                calendar.set(5, ResHelper.parseInt(strArrSplit[1]));
                                this.db.put("birthday", String.valueOf(calendar.getTimeInMillis()));
                            }
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                        }
                        PlatformDb platformDb = this.db;
                        if (!"true".equals(String.valueOf(mapA.get("verified")))) {
                            str4 = "0";
                        }
                        platformDb.put("secretType", str4);
                        this.db.put("snsUserUrl", String.valueOf(mapA.get("link")));
                        this.db.put("resume", String.valueOf(mapA.get("link")));
                        ArrayList arrayList = mapA.containsKey("education") ? (ArrayList) mapA.get("education") : null;
                        if (arrayList != null) {
                            ArrayList arrayList2 = new ArrayList();
                            int size = arrayList.size();
                            int i5 = 0;
                            while (i5 < size) {
                                int i6 = i5 + 1;
                                HashMap map3 = (HashMap) arrayList.get(i5);
                                HashMap map4 = new HashMap();
                                map4.put("school_type", 0);
                                HashMap map5 = map3.containsKey("school") ? (HashMap) map3.get("school") : null;
                                if (map5 != null) {
                                    map4.put("school", String.valueOf(map5.get("name")));
                                }
                                try {
                                    map4.put("year", Integer.valueOf(ResHelper.parseInt(String.valueOf((map3.containsKey("year") ? (HashMap) map3.get("year") : null).get("name")))));
                                } catch (Throwable th2) {
                                    SSDKLog.b().a(th2);
                                }
                                map4.put("background", 0);
                                arrayList2.add(map4);
                                i5 = i6;
                            }
                            HashMap map6 = new HashMap();
                            map6.put(XmlErrorCodes.LIST, arrayList2);
                            String strFromHashMap = new Hashon().fromHashMap(map6);
                            this.db.put("educationJSONArrayStr", strFromHashMap.substring(8, strFromHashMap.length() - 1));
                        }
                        ArrayList arrayList3 = mapA.containsKey("work") ? (ArrayList) mapA.get("work") : null;
                        if (arrayList3 != null) {
                            ArrayList arrayList4 = new ArrayList();
                            int size2 = arrayList3.size();
                            int i7 = 0;
                            while (i7 < size2) {
                                int i8 = i7 + 1;
                                HashMap map7 = (HashMap) arrayList3.get(i7);
                                HashMap map8 = new HashMap();
                                HashMap map9 = (HashMap) map7.get("employer");
                                if (map9 != null) {
                                    map8.put("company", String.valueOf(map9.get("name")));
                                }
                                Object obj4 = obj3;
                                HashMap map10 = (HashMap) map7.get(obj4);
                                if (map10 != null) {
                                    map8.put(obj4, String.valueOf(map10.get("name")));
                                }
                                Object obj5 = obj2;
                                try {
                                    str2 = str3;
                                    try {
                                        String[] strArrSplit2 = String.valueOf(map7.get(obj5)).split(str2);
                                        map8.put(obj5, Integer.valueOf((ResHelper.parseInt(strArrSplit2[0]) * 100) + ResHelper.parseInt(strArrSplit2[c])));
                                    } catch (Throwable th3) {
                                        th = th3;
                                        SSDKLog.b().a(th);
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    str2 = str3;
                                }
                                Object obj6 = obj;
                                try {
                                    String[] strArrSplit3 = String.valueOf(map7.get(obj6)).split(str2);
                                    map8.put(obj6, Integer.valueOf((ResHelper.parseInt(strArrSplit3[0]) * 100) + ResHelper.parseInt(strArrSplit3[c])));
                                } catch (Throwable th5) {
                                    SSDKLog.b().a(th5);
                                    map8.put(obj6, 0);
                                }
                                arrayList4.add(map8);
                                obj = obj6;
                                i7 = i8;
                                obj3 = obj4;
                                obj2 = obj5;
                                str3 = str2;
                                c = c;
                            }
                            HashMap map11 = new HashMap();
                            map11.put(XmlErrorCodes.LIST, arrayList4);
                            String strFromHashMap2 = new Hashon().fromHashMap(map11);
                            this.db.put("workJSONArrayStr", strFromHashMap2.substring(8, strFromHashMap2.length() - 1));
                        }
                    }
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, 8, mapA);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(mapA)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 8, new Throwable("response is null"));
            }
        } catch (Throwable th6) {
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, 8, th6);
            }
        }
    }

    private void a(Platform platform, Platform.ShareParams shareParams, PlatformActionListener platformActionListener) {
        try {
            g gVar = new g();
            gVar.a("com.facebook.katana", "com.facebook.composer.shareintent.ImplicitShareIntentHandlerDefaultAlias");
            if (shareParams.getShareType() == 6) {
                if (TextUtils.isEmpty(shareParams.getFilePath())) {
                    if (platformActionListener != null) {
                        platformActionListener.onError(platform, 9, new Throwable("Share type is VIDEO, But FilePath is null"));
                        return;
                    }
                    return;
                }
                gVar.a(shareParams.getFilePath(), platform, platformActionListener);
            } else {
                gVar.a(shareParams, platform);
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("ShareParams", shareParams);
            platformActionListener.onComplete(platform, 9, map);
        } catch (Throwable th) {
            if (platformActionListener != null) {
                platformActionListener.onError(platform, 9, th);
            }
            SSDKLog.b().a(th, "Facebook share byPassShare catch ", new Object[0]);
        }
    }
}
