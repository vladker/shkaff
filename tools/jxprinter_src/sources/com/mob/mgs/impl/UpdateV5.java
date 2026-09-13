package com.mob.mgs.impl;

import com.mob.mgs.MobMGS;
import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class UpdateV5 implements PublicMemberKeeper {
    public static boolean getDS() {
        return MobMGS.getDS();
    }

    public static void setDS(boolean z6) {
        MobMGS.setDS(z6);
    }
}
