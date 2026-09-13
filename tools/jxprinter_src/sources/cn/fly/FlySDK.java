package cn.fly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import cn.fly.commons.C0396r;
import cn.fly.commons.CSCenter;
import cn.fly.commons.FlyProduct;
import cn.fly.commons.InternationalDomain;
import cn.fly.commons.aa;
import cn.fly.commons.c;
import cn.fly.commons.o;
import cn.fly.commons.q;
import cn.fly.commons.x;
import cn.fly.tools.FlyLog;
import cn.fly.tools.proguard.PublicMemberKeeper;
import com.alibaba.android.arouter.utils.Consts;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: loaded from: classes.dex */
public class FlySDK implements PublicMemberKeeper {
    public static final int CHANNEL_APICLOUD = 5;
    public static final int CHANNEL_COCOS = 1;
    public static final int CHANNEL_FLUTTER = 4;
    public static final int CHANNEL_JS = 3;
    public static final int CHANNEL_NATIVE = 0;
    public static final int CHANNEL_QUICKSDK = 6;
    public static final int CHANNEL_REACT_NATIVE = 8;
    public static final int CHANNEL_UNIAPP = 7;
    public static final int CHANNEL_UNITY = 2;
    public static final int SDK_VERSION_CODE;
    public static final String SDK_VERSION_NAME;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f1195a;

    static {
        int i5;
        String strReplace = "1.0.0";
        try {
            strReplace = "2026-07-23".replace(ProcessIdUtil.DEFAULT_PROCESSID, Consts.DOT);
            i5 = Integer.parseInt("2026-07-23".replace(ProcessIdUtil.DEFAULT_PROCESSID, ""));
        } catch (Throwable unused) {
            i5 = 1;
        }
        SDK_VERSION_CODE = i5;
        SDK_VERSION_NAME = strReplace;
    }

    public static boolean checkFH(boolean z6) {
        if (z6) {
            return x.f1503g;
        }
        if (x.f1502f) {
            return x.f1502f;
        }
        return ((Integer) c.a("hs", 1)).intValue() == 1;
    }

    public static boolean checkForceHttps() {
        return checkFH(false);
    }

    public static boolean checkV6() {
        return x.f1504h;
    }

    public static String getAppSecret() {
        if (TextUtils.isEmpty(x.b)) {
            return x.d == null ? "" : x.d;
        }
        return x.b == null ? "" : x.b;
    }

    public static String getAppkey() {
        if (aa.h()) {
            return q.a();
        }
        return null;
    }

    public static Context getContext() {
        if (f1195a == null) {
            try {
                Context contextA = C0396r.a();
                if (contextA != null) {
                    init(contextA);
                }
            } catch (Throwable unused) {
            }
        }
        return f1195a;
    }

    public static Context getContextSafely() {
        return f1195a;
    }

    public static boolean getDefaultPrivacy() {
        return true;
    }

    public static InternationalDomain getDmn() {
        return x.e == null ? InternationalDomain.DEFAULT : x.e;
    }

    public static int getPrivacyGrantedStatus() {
        return aa.c();
    }

    public static synchronized void init(Context context) {
        init(context, null, null);
    }

    public static final int isAuth() {
        return q.b();
    }

    public static final boolean isFly() {
        return q.c();
    }

    public static final boolean isForb() {
        return q.d();
    }

    public static final boolean isGppVer() {
        return x.f1506j;
    }

    public static void setChannel(FlyProduct flyProduct, int i5) {
        if (isForb()) {
            FlyLog.getInstance().d("isForb: true", new Object[0]);
        } else {
            o.a().a(flyProduct, i5);
        }
    }

    public static void submitPolicyGrantResult(boolean z6) {
        aa.b(z6);
    }

    public static String syncGetBSDM(String str, String str2, String str3, boolean z6) {
        return q.a(str, str2, str3, z6);
    }

    public static void updateFlyCustomController(FlyCustomController flyCustomController) {
        CSCenter.getInstance().updateCustomController(flyCustomController);
    }

    public static void submitPolicyGrantResult(FlyCustomController flyCustomController, boolean z6) {
        submitPolicyGrantResult(z6);
        updateFlyCustomController(flyCustomController);
    }

    public static synchronized void init(Context context, String str) {
        init(context, str, null);
    }

    public static synchronized void init(Context context, String str, String str2) {
        try {
            if (context == null) {
                Log.e("SDK", "Init error, context is null");
                return;
            }
            if (f1195a == null) {
                f1195a = context.getApplicationContext();
                x.f1501a = str;
                x.b = str2;
                q.a(false);
            } else if (!TextUtils.isEmpty(str) && !str.equals(x.f1501a)) {
                x.f1501a = str;
                x.b = str2;
                q.a(true);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
