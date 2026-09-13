package cn.fly.tools.deprecated;

import android.content.Context;
import cn.fly.commons.ad;
import cn.fly.commons.f;
import cn.fly.commons.k;
import cn.fly.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DeprecatedCompat implements PublicMemberKeeper {
    public static String authorizeForOnce() {
        return f.b();
    }

    public static String getMString(Context context) {
        return f.a(context);
    }

    public static String getUserIdentity() {
        return ad.e();
    }

    public static boolean isClear() {
        return k.a().b();
    }

    public static boolean isFor() {
        return f.a();
    }
}
