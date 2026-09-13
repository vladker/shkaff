package com.mob.commons;

import cn.fly.tools.deprecated.DeprecatedCompat;
import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class MobProductCollector implements PublicMemberKeeper {
    public static String getUserIdentity() {
        return DeprecatedCompat.getUserIdentity();
    }
}
