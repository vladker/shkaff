package cn.sharesdk.wechat.utils;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile n f2415a;

    public static n a() {
        if (f2415a == null) {
            synchronized (n.class) {
                try {
                    if (f2415a == null) {
                        f2415a = new n();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f2415a;
    }

    public int a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists()) {
            if (MobSDK.getContext() != null && str.startsWith(FirebaseAnalytics.Param.CONTENT)) {
                try {
                    return a(MobSDK.getContext().getContentResolver(), Uri.parse(str));
                } catch (Exception unused) {
                }
            }
            return 0;
        }
        return (int) file.length();
    }

    private static int a(ContentResolver contentResolver, Uri uri) {
        SSDKLog.b().a("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver != null && uri != null) {
            InputStream inputStream = null;
            try {
                try {
                    InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    if (inputStreamOpenInputStream == null) {
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                                return 0;
                            } catch (IOException e) {
                                SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "WechatTools exception" + e);
                            }
                        }
                        return 0;
                    }
                    int iAvailable = inputStreamOpenInputStream.available();
                    try {
                        inputStreamOpenInputStream.close();
                        return iAvailable;
                    } catch (IOException e6) {
                        SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "WechatTools exception" + e6);
                        return iAvailable;
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e7) {
                            SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "WechatTools exception" + e7);
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                SSDKLog.b().a("MicroMsg.SDK.Util", "getFileSize fail, " + e8.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e9) {
                        SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "WechatTools exception" + e9);
                    }
                }
                return 0;
            }
        }
        SSDKLog.b().a("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
        return 0;
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            SSDKLog.b().a("getStringExtra exception:" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static int a(Bundle bundle, String str, int i5) {
        if (bundle == null) {
            return i5;
        }
        try {
            return bundle.getInt(str, i5);
        } catch (Exception e) {
            SSDKLog.b().a("getIntExtra exception:" + e.getMessage(), new Object[0]);
            return i5;
        }
    }
}
