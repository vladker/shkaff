package com.mob.commons.authorize;

import android.content.Context;
import cn.fly.tools.deprecated.DeprecatedCompat;
import com.mob.commons.MobProduct;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class DeviceAuthorizer implements PublicMemberKeeper {
    public static synchronized String authorize(MobProduct mobProduct) {
        return NetCommunicator.getDUID(mobProduct);
    }

    public static String authorizeForOnce() {
        return DeprecatedCompat.authorizeForOnce();
    }

    public static String getMString(Context context) {
        return DeprecatedCompat.getMString(context);
    }

    public static boolean isClear() {
        return DeprecatedCompat.isClear();
    }

    public static boolean isFor() {
        return DeprecatedCompat.isFor();
    }
}
