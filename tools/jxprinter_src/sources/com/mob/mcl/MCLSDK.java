package com.mob.mcl;

import com.mob.mgs.OnIdChangeListener;
import com.mob.tools.proguard.EverythingKeeper;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class MCLSDK implements EverythingKeeper {
    public static void addBusinessMessageListener(int i5, BusinessMessageListener businessMessageListener) {
        MobMCL.addBusinessMessageListener(i5, businessMessageListener);
    }

    public static void deleteMsg(String str) {
        MobMCL.deleteMsg(str);
    }

    public static void getClientTcpStatus(BusinessCallBack<Boolean> businessCallBack) {
        MobMCL.getClientTcpStatus(businessCallBack);
    }

    public static void getSuid(OnIdChangeListener onIdChangeListener) {
        MobMCL.getSuid(onIdChangeListener);
    }

    public static void getTcpStatus(BusinessCallBack<Boolean> businessCallBack) {
        MobMCL.getTcpStatus(businessCallBack);
    }
}
