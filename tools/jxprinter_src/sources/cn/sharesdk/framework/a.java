package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.k;
import com.mob.MobSDK;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f2122a = false;
    public static String b;

    public static boolean a() {
        String appkey = MobSDK.getAppkey();
        if (f2122a || TextUtils.isEmpty(appkey)) {
            return false;
        }
        if (!TextUtils.isEmpty(b)) {
            SSDKLog.b().a("CheckAppKeyDetermine whether successAppKey is equal to mobsdk.getappkey", new Object[0]);
            return appkey.equals(b);
        }
        SSDKLog.b().a("CheckAppKeyAsynchronously verify the appkey", new Object[0]);
        k.a(new k.a() { // from class: cn.sharesdk.framework.a.1
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() {
                b.a().b();
            }
        });
        return true;
    }
}
