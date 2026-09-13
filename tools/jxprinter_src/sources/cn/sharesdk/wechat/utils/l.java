package cn.sharesdk.wechat.utils;

import A3.AbstractC0157z;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import com.mob.MobSDK;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ResHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static l f2379a;
    private j b = new j();
    private k c;
    private String d;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2381g;

    private l() {
    }

    public boolean b() {
        return true;
    }

    public boolean c() {
        return true;
    }

    public void d(final ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            DH.requester(MobSDK.getContext()).getPInfoForce(true, "com.tencent.mm", 0).request(new DH.DHResponder() { // from class: cn.sharesdk.wechat.utils.l.8
                @Override // com.mob.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    String str;
                    try {
                        str = dHResponse.getPInfoForce(new int[0]).versionName;
                        SSDKLog.b().b("wechat versionName ==>> " + str);
                    } catch (Throwable th) {
                        SSDKLog.b().a(th);
                        str = "0";
                    }
                    String[] strArrSplit = str.split("_")[0].split("\\.");
                    int length = strArrSplit.length;
                    int[] iArr = new int[length];
                    for (int i5 = 0; i5 < length; i5++) {
                        try {
                            iArr[i5] = ResHelper.parseInt(strArrSplit[i5]);
                        } catch (Throwable th2) {
                            SSDKLog.b().a(th2);
                            iArr[i5] = 0;
                        }
                    }
                    if (length < 3) {
                        ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                        if (shareSDKCallback2 != null) {
                            shareSDKCallback2.onCallback(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    int i6 = iArr[0];
                    if (i6 == 7 && iArr[1] == 0 && iArr[2] >= 13) {
                        ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                        if (shareSDKCallback3 != null) {
                            shareSDKCallback3.onCallback(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    if (i6 >= 8) {
                        ShareSDKCallback shareSDKCallback4 = shareSDKCallback;
                        if (shareSDKCallback4 != null) {
                            shareSDKCallback4.onCallback(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    ShareSDKCallback shareSDKCallback5 = shareSDKCallback;
                    if (shareSDKCallback5 != null) {
                        shareSDKCallback5.onCallback(Boolean.FALSE);
                    }
                }
            });
        } catch (Throwable unused) {
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    public void c(final k kVar) {
        final Platform.ShareParams shareParamsA = kVar.a();
        final int shareType = shareParamsA.getShareType();
        final PlatformActionListener platformActionListenerC = kVar.c();
        c(new ShareSDKCallback<Integer>() { // from class: cn.sharesdk.wechat.utils.l.1
            @Override // cn.sharesdk.framework.ShareSDKCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onCallback(Integer num) {
                try {
                    if (shareType != 11 || num.intValue() >= 620756993) {
                        l.this.a(kVar, shareType, shareParamsA, platformActionListenerC);
                    } else {
                        SSDKLog.b().a("not support share miniprogram", new Object[0]);
                        l.this.a(kVar, 4, shareParamsA, platformActionListenerC);
                    }
                } catch (Throwable th) {
                    SSDKLog.b().a(androidx.exifinterface.media.a.n("wx share ", th), new Object[0]);
                    PlatformActionListener platformActionListener = platformActionListenerC;
                    if (platformActionListener != null) {
                        platformActionListener.onError(kVar.b(), 9, th);
                    }
                }
            }
        });
    }

    public void b(String str) {
        this.d = str;
    }

    private void c(Context context, String str, String str2, String str3, String str4, int i5, k kVar) throws Throwable {
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.filePath = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        if (!TextUtils.isEmpty(str)) {
            wXMediaMessage.title = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            wXMediaMessage.description = str2;
        }
        wXMediaMessage.mediaObject = wXFileObject;
        if (!TextUtils.isEmpty(str4)) {
            wXMediaMessage.thumbData = a(context, str4, false);
        }
        a(wXMediaMessage, "filedata", i5, kVar);
    }

    public void b(k kVar) {
        this.c = kVar;
        g gVar = new g();
        Platform.ShareParams shareParamsA = kVar.a();
        String strValueOf = String.valueOf(shareParamsA.getWxTemplateid());
        String strValueOf2 = String.valueOf(shareParamsA.getWxReserved());
        int scence = shareParamsA.getScence();
        gVar.b = strValueOf;
        gVar.f2368a = scence;
        gVar.c = strValueOf2;
        this.b.a(gVar);
    }

    public static l a() {
        if (f2379a == null) {
            f2379a = new l();
        }
        return f2379a;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(boolean z6) {
        this.f2380f = z6;
    }

    private void b(Context context, String str, String str2, String str3, int i5, k kVar, Platform.ShareParams shareParams) throws Throwable {
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.imagePath = a(new File(str3));
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        if (i5 != 0) {
            wXMediaMessage.title = str;
            wXMediaMessage.description = str2;
        } else {
            if (!TextUtils.isEmpty(shareParams.getEntranceMiniProgramUsername())) {
                wXImageObject.entranceMiniProgramUsername = shareParams.getEntranceMiniProgramUsername();
            }
            if (!TextUtils.isEmpty(shareParams.getEntranceMiniProgramPath())) {
                wXImageObject.entranceMiniProgramPath = shareParams.getEntranceMiniProgramPath();
            }
        }
        wXMediaMessage.thumbData = a(context, str3, false);
        a(wXMediaMessage, "img", i5, kVar);
    }

    public void a(int i5) {
        this.f2381g = i5;
    }

    private void c(Context context, String str, String str2, String str3, Bitmap bitmap, int i5, k kVar) throws Throwable {
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.filePath = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.thumbData = a(context, bitmap, false);
        a(wXMediaMessage, "filedata", i5, kVar);
    }

    public void a(k kVar) throws Throwable {
        this.c = kVar;
        b bVar = new b();
        bVar.f2363a = "snsapi_userinfo";
        bVar.b = "sharesdk_wechat_auth";
        this.b.a((m) bVar, false);
    }

    public void a(ShareSDKCallback<Boolean> shareSDKCallback) {
        this.b.a(shareSDKCallback);
    }

    public void a(k kVar, Platform.ShareParams shareParams, PlatformActionListener platformActionListener) {
        Platform platformB = kVar.b();
        String str = ((Integer) shareParams.get("scene", Integer.class)).intValue() == 1 ? "com.tencent.mm.ui.tools.ShareToTimeLineUI" : "com.tencent.mm.ui.tools.ShareImgUI";
        cn.sharesdk.framework.utils.g gVar = new cn.sharesdk.framework.utils.g();
        gVar.a("com.tencent.mm", str);
        gVar.a(shareParams, platformB);
        HashMap<String, Object> map = new HashMap<>();
        map.put("ShareParams", shareParams);
        platformActionListener.onComplete(platformB, 9, map);
    }

    public boolean c(String str) {
        return this.b.a(str);
    }

    @SuppressLint({"WrongConstant"})
    public void c(final ShareSDKCallback<Integer> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getAInfoForPkg("com.tencent.mm", 128).request(new DH.DHResponder() { // from class: cn.sharesdk.wechat.utils.l.7
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    shareSDKCallback.onCallback(Integer.valueOf(dHResponse.getAInfoForPkg(new int[0]).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0)));
                } catch (Throwable th) {
                    SSDKLog.b().a(androidx.exifinterface.media.a.n("WechatHelper getWXAppSupportAPI() get from metaData failed : ", th), new Object[0]);
                    shareSDKCallback.onCallback(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, String str2, String str3, String str4, int i5, k kVar) throws Throwable {
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXWebpageObject;
        if (str4 != null && new File(str4).exists()) {
            byte[] bArrA = a(context, str4, false);
            wXMediaMessage.thumbData = bArrA;
            if (bArrA != null) {
                if (bArrA.length > 32768) {
                    throw new RuntimeException(AbstractC0157z.l(" > 32768", wXMediaMessage.thumbData.length, new StringBuilder("checkArgs fail, thumbData is too large: ")));
                }
            } else {
                throw new RuntimeException("checkArgs fail, thumbData is null");
            }
        }
        a(wXMediaMessage, "webpage", i5, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final k kVar, int i5, Platform.ShareParams shareParams, final PlatformActionListener platformActionListener) throws Throwable {
        File parentFile;
        final Platform platformB = kVar.b();
        final String title = shareParams.getTitle();
        final String text = shareParams.getText();
        final int scence = shareParams.getScence();
        final String imagePath = shareParams.getImagePath();
        String imageFileProviderPath = shareParams.getImageFileProviderPath();
        final String imageUrl = shareParams.getImageUrl();
        final Bitmap imageData = shareParams.getImageData();
        String musicUrl = shareParams.getMusicUrl();
        String url = shareParams.getUrl();
        String filePath = shareParams.getFilePath();
        String extInfo = shareParams.getExtInfo();
        switch (i5) {
            case 1:
                a(title, text, scence, kVar);
                return;
            case 2:
                if (imagePath != null && imagePath.length() > 0) {
                    b(MobSDK.getContext(), title, text, imagePath, scence, kVar, shareParams);
                    return;
                }
                if (imageFileProviderPath != null && imageFileProviderPath.length() > 0) {
                    a(MobSDK.getContext(), title, text, imageFileProviderPath, scence, kVar, shareParams);
                    return;
                }
                if (imageData != null && !imageData.isRecycled()) {
                    a(MobSDK.getContext(), title, text, imageData, scence, kVar, shareParams);
                    return;
                }
                if (imageUrl != null && imageUrl.length() > 0) {
                    String strDownloadBitmap = BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl);
                    try {
                        if (!TextUtils.isEmpty(strDownloadBitmap) && (parentFile = new File(strDownloadBitmap).getParentFile()) != null && parentFile.isDirectory()) {
                            File file = new File(parentFile.getAbsolutePath(), ".nomedia");
                            if (!file.exists() || !file.isFile()) {
                                file.createNewFile();
                            }
                        }
                        break;
                    } catch (Throwable th) {
                        SSDKLog.b().a(androidx.exifinterface.media.a.n("when share iamge wechat that create nomedia catch ", th), new Object[0]);
                    }
                    b(MobSDK.getContext(), title, text, strDownloadBitmap, scence, kVar, shareParams);
                    return;
                }
                b(MobSDK.getContext(), title, text, "", scence, kVar, shareParams);
                return;
            case 3:
            case 10:
            default:
                if (platformActionListener != null) {
                    platformActionListener.onError(platformB, 9, new IllegalArgumentException(AbstractC0157z.k(i5, "shareType = ")));
                    return;
                }
                return;
            case 4:
                platformB.getShortLintk(url, false, new ShareSDKCallback<String>() { // from class: cn.sharesdk.wechat.utils.l.4
                    @Override // cn.sharesdk.framework.ShareSDKCallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onCallback(String str) {
                        try {
                            kVar.a().setUrl(str);
                            String str2 = imagePath;
                            if (str2 != null && str2.length() > 0) {
                                l.this.b(MobSDK.getContext(), title, text, str, imagePath, scence, kVar);
                                return;
                            }
                            Bitmap bitmap = imageData;
                            if (bitmap != null && !bitmap.isRecycled()) {
                                l.this.b(MobSDK.getContext(), title, text, str, imageData, scence, kVar);
                                return;
                            }
                            String str3 = imageUrl;
                            if (str3 == null || str3.length() <= 0) {
                                l.this.b(MobSDK.getContext(), title, text, str, "", scence, kVar);
                            } else {
                                l.this.b(MobSDK.getContext(), title, text, str, BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl), scence, kVar);
                            }
                        } catch (Throwable th2) {
                            PlatformActionListener platformActionListener2 = platformActionListener;
                            if (platformActionListener2 != null) {
                                platformActionListener2.onError(platformB, 9, th2);
                            }
                        }
                    }
                });
                return;
            case 5:
                platformB.getShortLintk(androidx.collection.a.o(musicUrl, " ", url), false, new ShareSDKCallback<String>() { // from class: cn.sharesdk.wechat.utils.l.2
                    @Override // cn.sharesdk.framework.ShareSDKCallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onCallback(String str) {
                        try {
                            String str2 = str.split(" ")[0];
                            String str3 = str.split(" ")[1];
                            String str4 = imagePath;
                            if (str4 != null && str4.length() > 0) {
                                l.this.a(MobSDK.getContext(), title, text, str2, str3, imagePath, scence, kVar);
                                return;
                            }
                            Bitmap bitmap = imageData;
                            if (bitmap != null && !bitmap.isRecycled()) {
                                l.this.a(MobSDK.getContext(), title, text, str2, str3, imageData, scence, kVar);
                                return;
                            }
                            String str5 = imageUrl;
                            if (str5 == null || str5.length() <= 0) {
                                l.this.a(MobSDK.getContext(), title, text, str2, str3, "", scence, kVar);
                            } else {
                                l.this.a(MobSDK.getContext(), title, text, str2, str3, BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl), scence, kVar);
                            }
                        } catch (Throwable th2) {
                            PlatformActionListener platformActionListener2 = platformActionListener;
                            if (platformActionListener2 != null) {
                                platformActionListener2.onError(platformB, 9, th2);
                            }
                        }
                    }
                });
                return;
            case 6:
                platformB.getShortLintk(url, false, new ShareSDKCallback<String>() { // from class: cn.sharesdk.wechat.utils.l.3
                    @Override // cn.sharesdk.framework.ShareSDKCallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onCallback(String str) {
                        try {
                            kVar.a().setUrl(str);
                            String str2 = imagePath;
                            if (str2 != null && str2.length() > 0) {
                                l.this.a(MobSDK.getContext(), title, text, str, imagePath, scence, kVar);
                                return;
                            }
                            Bitmap bitmap = imageData;
                            if (bitmap != null && !bitmap.isRecycled()) {
                                l.this.a(MobSDK.getContext(), title, text, str, imageData, scence, kVar);
                                return;
                            }
                            String str3 = imageUrl;
                            if (str3 == null || str3.length() <= 0) {
                                l.this.a(MobSDK.getContext(), title, text, str, "", scence, kVar);
                            } else {
                                l.this.a(MobSDK.getContext(), title, text, str, BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl), scence, kVar);
                            }
                        } catch (Throwable th2) {
                            PlatformActionListener platformActionListener2 = platformActionListener;
                            if (platformActionListener2 != null) {
                                platformActionListener2.onError(platformB, 9, th2);
                            }
                        }
                    }
                });
                return;
            case 7:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SAHRE_APP");
                }
                if (scence != 2) {
                    if (imagePath != null && imagePath.length() > 0) {
                        b(MobSDK.getContext(), title, text, filePath, extInfo, imagePath, scence, kVar);
                        return;
                    }
                    if (imageData != null && !imageData.isRecycled()) {
                        b(MobSDK.getContext(), title, text, filePath, extInfo, imageData, scence, kVar);
                        return;
                    } else if (imageUrl != null && imageUrl.length() > 0) {
                        b(MobSDK.getContext(), title, text, filePath, extInfo, BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl), scence, kVar);
                        return;
                    } else {
                        b(MobSDK.getContext(), title, text, filePath, extInfo, "", scence, kVar);
                        return;
                    }
                }
                throw new Throwable("WechatFavorite does not support SAHRE_APP");
            case 8:
                if (scence != 1) {
                    if (imagePath != null && imagePath.length() > 0) {
                        c(MobSDK.getContext(), title, text, filePath, imagePath, scence, kVar);
                        return;
                    }
                    if (imageData != null && !imageData.isRecycled()) {
                        c(MobSDK.getContext(), title, text, filePath, imageData, scence, kVar);
                        return;
                    } else if (imageUrl != null && imageUrl.length() > 0) {
                        c(MobSDK.getContext(), title, text, filePath, BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl), scence, kVar);
                        return;
                    } else {
                        c(MobSDK.getContext(), title, text, a(new File(filePath)), "", scence, kVar);
                        return;
                    }
                }
                throw new Throwable("WechatMoments does not support SHARE_FILE");
            case 9:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SHARE_EMOJI");
                }
                if (scence != 2) {
                    if (imagePath != null && imagePath.length() > 0) {
                        a(MobSDK.getContext(), title, text, imagePath, scence, kVar);
                        return;
                    }
                    if (imageUrl != null && imageUrl.length() > 0) {
                        a(MobSDK.getContext(), title, text, new NetworkHelper().downloadCache(MobSDK.getContext(), imageUrl, "images", true, null), scence, kVar);
                        return;
                    } else if (imageData != null && !imageData.isRecycled()) {
                        a(MobSDK.getContext(), title, text, imageData, scence, kVar);
                        return;
                    } else {
                        a(MobSDK.getContext(), title, text, "", scence, kVar);
                        return;
                    }
                }
                throw new Throwable("WechatFavorite does not support SHARE_EMOJI");
            case 11:
                if (scence != 2) {
                    if (!TextUtils.isEmpty(this.d)) {
                        platformB.getShortLintk(url, false, new ShareSDKCallback<String>() { // from class: cn.sharesdk.wechat.utils.l.5
                            @Override // cn.sharesdk.framework.ShareSDKCallback
                            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                            public void onCallback(String str) {
                                try {
                                    kVar.a().setUrl(str);
                                    String str2 = imagePath;
                                    if (str2 != null && str2.length() > 0) {
                                        l.this.a(MobSDK.getContext(), str, l.this.d, l.this.e, title, text, imagePath, scence, kVar);
                                        return;
                                    }
                                    Bitmap bitmap = imageData;
                                    if (bitmap != null && !bitmap.isRecycled()) {
                                        l.this.a(MobSDK.getContext(), str, l.this.d, l.this.e, title, text, imageData, scence, kVar);
                                        return;
                                    }
                                    String str3 = imageUrl;
                                    if (str3 == null || str3.length() <= 0) {
                                        l.this.a(MobSDK.getContext(), str, l.this.d, l.this.e, title, text, "", scence, kVar);
                                    } else {
                                        l.this.a(MobSDK.getContext(), str, l.this.d, l.this.e, title, text, BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl), scence, kVar);
                                    }
                                } catch (Throwable th2) {
                                    PlatformActionListener platformActionListener2 = platformActionListener;
                                    if (platformActionListener2 != null) {
                                        platformActionListener2.onError(platformB, 9, th2);
                                    }
                                }
                            }
                        });
                        return;
                    } else {
                        if (platformActionListener != null) {
                            platformActionListener.onError(platformB, 9, new Throwable("checkArgs fail, UserName or Path is invalid"));
                            return;
                        }
                        return;
                    }
                }
                throw new Throwable("WechatFavorite does not support SAHRE_WXMINIPROGRAM");
            case 12:
                if (!TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(this.e)) {
                    a(this.d, this.e);
                    return;
                } else {
                    if (platformActionListener != null) {
                        platformActionListener.onError(platformB, 9, new Throwable("checkArgs fail, UserName or Path is invalid"));
                        return;
                    }
                    return;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, String str2, String str3, Bitmap bitmap, int i5, k kVar) throws Throwable {
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXWebpageObject;
        if (bitmap != null && !bitmap.isRecycled()) {
            byte[] bArrA = a(context, bitmap, false);
            wXMediaMessage.thumbData = bArrA;
            if (bArrA != null) {
                if (bArrA.length > 32768) {
                    throw new RuntimeException(AbstractC0157z.l(" > 32768", wXMediaMessage.thumbData.length, new StringBuilder("checkArgs fail, thumbData is too large: ")));
                }
            } else {
                throw new RuntimeException("checkArgs fail, thumbData is null");
            }
        }
        a(wXMediaMessage, "webpage", i5, kVar);
    }

    private void b(Context context, String str, String str2, String str3, String str4, String str5, int i5, k kVar) throws Throwable {
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.filePath = str3;
        wXAppExtendObject.extInfo = str4;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXAppExtendObject;
        wXMediaMessage.thumbData = a(context, str5, false);
        a(wXMediaMessage, "appdata", i5, kVar);
    }

    private void b(Context context, String str, String str2, String str3, String str4, Bitmap bitmap, int i5, k kVar) throws Throwable {
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.filePath = str3;
        wXAppExtendObject.extInfo = str4;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXAppExtendObject;
        wXMediaMessage.thumbData = a(context, bitmap, false);
        a(wXMediaMessage, "appdata", i5, kVar);
    }

    public void b(ShareSDKCallback<Boolean> shareSDKCallback) {
        this.b.b(shareSDKCallback);
    }

    private void a(String str, String str2, int i5, k kVar) throws Throwable {
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = str2;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = str2;
        a(wXMediaMessage, "text", i5, kVar);
    }

    private void a(final Context context, final String str, final String str2, final String str3, final int i5, final k kVar, final Platform.ShareParams shareParams) {
        try {
            final WXImageObject wXImageObject = new WXImageObject();
            d(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.wechat.utils.l.6
                @Override // cn.sharesdk.framework.ShareSDKCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onCallback(Boolean bool) {
                    try {
                        if (bool.booleanValue()) {
                            if (l.this.c()) {
                                String strA = l.this.a(new File(str3));
                                wXImageObject.imagePath = strA;
                                SSDKLog.b().a("ShareSDK share file with FileProvider path is: " + strA);
                            }
                        } else if (kVar.c() != null) {
                            kVar.c().onError(kVar.b(), 9, new Throwable("Wecaht Version is not new"));
                        }
                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                        wXMediaMessage.mediaObject = wXImageObject;
                        if (i5 != 0) {
                            wXMediaMessage.title = str;
                            wXMediaMessage.description = str2;
                        } else {
                            if (!TextUtils.isEmpty(shareParams.getEntranceMiniProgramUsername())) {
                                wXImageObject.entranceMiniProgramUsername = shareParams.getEntranceMiniProgramUsername();
                            }
                            if (!TextUtils.isEmpty(shareParams.getEntranceMiniProgramPath())) {
                                wXImageObject.entranceMiniProgramPath = shareParams.getEntranceMiniProgramPath();
                            }
                        }
                        wXMediaMessage.thumbData = l.this.a(context, str3, false);
                        l.this.a(wXMediaMessage, "img", i5, kVar);
                    } catch (Throwable th) {
                        SSDKLog.b().a(th);
                    }
                }
            });
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }

    private void a(Context context, String str, String str2, Bitmap bitmap, int i5, k kVar, Platform.ShareParams shareParams) throws Throwable {
        WXImageObject wXImageObject = new WXImageObject();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        wXImageObject.imageData = byteArrayOutputStream.toByteArray();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        if (i5 != 0) {
            wXMediaMessage.title = str;
            wXMediaMessage.description = str2;
        } else {
            if (!TextUtils.isEmpty(shareParams.getEntranceMiniProgramUsername())) {
                wXImageObject.entranceMiniProgramUsername = shareParams.getEntranceMiniProgramUsername();
            }
            if (!TextUtils.isEmpty(shareParams.getEntranceMiniProgramPath())) {
                wXImageObject.entranceMiniProgramPath = shareParams.getEntranceMiniProgramPath();
            }
        }
        wXMediaMessage.thumbData = a(context, bitmap, false);
        a(wXMediaMessage, "img", i5, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, String str3, String str4, String str5, int i5, k kVar) throws Throwable {
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = str4;
        wXMusicObject.musicDataUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.thumbData = a(context, str5, false);
        a(wXMediaMessage, "music", i5, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, String str3, String str4, Bitmap bitmap, int i5, k kVar) throws Throwable {
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = str4;
        wXMusicObject.musicDataUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.thumbData = a(context, bitmap, false);
        a(wXMediaMessage, "music", i5, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, String str3, String str4, int i5, k kVar) throws Throwable {
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXVideoObject;
        wXMediaMessage.thumbData = a(context, str4, false);
        a(wXMediaMessage, "video", i5, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, String str3, Bitmap bitmap, int i5, k kVar) throws Throwable {
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXVideoObject;
        wXMediaMessage.thumbData = a(context, bitmap, false);
        a(wXMediaMessage, "video", i5, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, String str3, String str4, String str5, Bitmap bitmap, int i5, k kVar) throws Throwable {
        String strS;
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = str;
        if (!TextUtils.isEmpty(str2) && str2.endsWith("@app")) {
            wXMiniProgramObject.userName = str2;
        } else {
            wXMiniProgramObject.userName = androidx.collection.a.n(str2, "@app");
        }
        if (!TextUtils.isEmpty(str3)) {
            String[] strArrSplit = str3.split("\\?");
            if (strArrSplit.length > 1) {
                strS = strArrSplit[0] + ".html?" + strArrSplit[1];
            } else {
                strS = AbstractC0157z.s(new StringBuilder(), strArrSplit[0], ".html");
            }
            wXMiniProgramObject.path = strS;
            wXMiniProgramObject.withShareTicket = this.f2380f;
            wXMiniProgramObject.miniprogramType = this.f2381g;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str4;
        wXMediaMessage.mediaObject = wXMiniProgramObject;
        wXMediaMessage.description = str5;
        if (bitmap != null && !bitmap.isRecycled()) {
            byte[] bArrA = a(context, bitmap, true);
            wXMediaMessage.thumbData = bArrA;
            if (bArrA != null) {
                if (bArrA.length > 131072) {
                    throw new RuntimeException(AbstractC0157z.l(" > 131072", wXMediaMessage.thumbData.length, new StringBuilder("checkArgs fail, thumbData is too large: ")));
                }
            } else {
                throw new RuntimeException("checkArgs fail, thumbData is null");
            }
        }
        a(wXMediaMessage, "webpage", i5, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i5, k kVar) throws Throwable {
        String strS;
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.miniprogramType = this.f2381g;
        wXMiniProgramObject.webpageUrl = str;
        if (!TextUtils.isEmpty(str2) && str2.endsWith("@app")) {
            wXMiniProgramObject.userName = str2;
        } else {
            wXMiniProgramObject.userName = androidx.collection.a.n(str2, "@app");
        }
        if (!TextUtils.isEmpty(str3)) {
            String[] strArrSplit = str3.split("\\?");
            if (strArrSplit.length > 1) {
                strS = strArrSplit[0] + ".html?" + strArrSplit[1];
            } else {
                strS = AbstractC0157z.s(new StringBuilder(), strArrSplit[0], ".html");
            }
            wXMiniProgramObject.path = strS;
            wXMiniProgramObject.withShareTicket = this.f2380f;
            wXMiniProgramObject.miniprogramType = this.f2381g;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str4;
        wXMediaMessage.mediaObject = wXMiniProgramObject;
        wXMediaMessage.description = str5;
        wXMediaMessage.thumbData = a(context, str6, true);
        a(wXMediaMessage, "miniProgram", i5, kVar);
    }

    private void a(String str, String str2) {
        i.a aVar = new i.a();
        aVar.f2373a = str;
        aVar.b = str2;
        aVar.c = this.f2381g;
        this.b.b(aVar);
    }

    private void a(Context context, String str, String str2, String str3, int i5, k kVar) throws Throwable {
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = a(new File(str3));
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = a(context, str3, false);
        a(wXMediaMessage, "emoji", i5, kVar);
    }

    private void a(Context context, String str, String str2, Bitmap bitmap, int i5, k kVar) throws Throwable {
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        byte[] bArrA = a(context, bitmap, false);
        wXEmojiObject.emojiData = bArrA;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = bArrA;
        a(wXMediaMessage, "emoji", i5, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(Context context, String str, boolean z6) throws Throwable {
        if (new File(str).exists()) {
            return a(context, BitmapHelper.getBitmap(str), BitmapHelper.getBmpFormat(str), z6);
        }
        throw new FileNotFoundException();
    }

    private byte[] a(Context context, Bitmap bitmap, boolean z6) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                return a(context, bitmap, Bitmap.CompressFormat.PNG, z6);
            }
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
        throw new RuntimeException("checkArgs fail, thumbData is null");
    }

    private byte[] a(Context context, Bitmap bitmap, Bitmap.CompressFormat compressFormat, boolean z6) throws IOException {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(compressFormat, 100, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                int length = byteArray.length;
                int i5 = z6 ? 131072 : 32768;
                while (length > i5) {
                    bitmap = a(bitmap, ((double) length) / ((double) i5));
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bitmap.compress(compressFormat, 100, byteArrayOutputStream2);
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    byteArray = byteArrayOutputStream2.toByteArray();
                    length = byteArray.length;
                }
                return byteArray;
            }
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
        throw new RuntimeException("checkArgs fail, thumbData is null");
    }

    private Bitmap a(Bitmap bitmap, double d) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double dSqrt = Math.sqrt(d);
        return Bitmap.createScaledBitmap(bitmap, (int) (((double) width) / dSqrt), (int) (((double) height) / dSqrt), true);
    }

    public boolean a(WechatHandlerActivity wechatHandlerActivity) {
        return this.b.a(wechatHandlerActivity, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WXMediaMessage wXMediaMessage, String str, int i5, k kVar) throws Throwable {
        Class<?> cls;
        String str2 = DH.SyncMtd.getPackageName() + ".wxapi.WXEntryActivity";
        try {
            cls = Class.forName(str2);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            cls = null;
        }
        if (cls != null && !WechatHandlerActivity.class.isAssignableFrom(cls)) {
            StringBuilder sbX = AbstractC0157z.x(str2, " does not extend from ");
            sbX.append(WechatHandlerActivity.class.getName());
            new Throwable(sbX.toString()).printStackTrace();
        }
        SendMessageReq sendMessageReq = new SendMessageReq();
        StringBuilder sbR = androidx.collection.a.r(str);
        sbR.append(System.currentTimeMillis());
        sendMessageReq.e = sbR.toString();
        sendMessageReq.f2357a = wXMediaMessage;
        sendMessageReq.b = i5;
        this.c = kVar;
        this.b.a(sendMessageReq, wXMediaMessage.mediaObject instanceof WXMiniProgramObject);
    }

    public String a(File file) {
        String packageName;
        if (file != null && file.exists()) {
            try {
                packageName = MobSDK.getContext().getPackageName();
            } catch (Throwable th) {
                SSDKLog.b().a(androidx.exifinterface.media.a.n("get packagename is catch: ", th), new Object[0]);
                packageName = null;
            }
            if (packageName != null) {
                Uri uriA = ShareSDKFileProvider.a(MobSDK.getContext(), packageName.concat(".cn.sharesdk.ShareSDKFileProvider"), file);
                MobSDK.getContext().grantUriPermission("com.tencent.mm", uriA, 1);
                return uriA.toString();
            }
        }
        return null;
    }
}
