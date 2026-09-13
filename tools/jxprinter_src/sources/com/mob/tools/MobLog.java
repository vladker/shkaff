package com.mob.tools;

import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.EverythingKeeper;

/* JADX INFO: loaded from: classes3.dex */
public class MobLog implements EverythingKeeper {
    public static synchronized NLog getInstance() {
        return NLog.getInstance("FlySDK", MobSDK.SDK_VERSION_CODE, "");
    }
}
