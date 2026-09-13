package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.MobLink;
import com.mob.MobSDK;
import com.mob.tools.utils.SharePrefrenceHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f2327a = MobLink.getSdkVersion();
    private static SharePrefrenceHelper b;

    public static synchronized boolean a() {
        c();
        return b.getBoolean("appInstall");
    }

    public static synchronized String b() {
        c();
        if (b.getBoolean("debuggable")) {
            return "";
        }
        return b.getString("config_data");
    }

    private static void c() {
        if (b == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
            b = sharePrefrenceHelper;
            sharePrefrenceHelper.open(MobLink.getSdkTag(), f2327a);
        }
    }

    public static synchronized void a(boolean z6) {
        c();
        b.putBoolean("appInstall", Boolean.valueOf(z6));
    }

    public static synchronized void a(String str) {
        c();
        b.putString("config_data", str);
        b.putBoolean("debuggable", Boolean.FALSE);
    }
}
