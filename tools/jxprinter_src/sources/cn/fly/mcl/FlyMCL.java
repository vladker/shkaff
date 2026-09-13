package cn.fly.mcl;

import cn.fly.mgs.OnIdChangeListener;
import cn.fly.tcp.impl.h;
import cn.fly.tools.proguard.EverythingKeeper;

/* JADX INFO: loaded from: classes.dex */
public class FlyMCL implements EverythingKeeper {
    public static final String SDK_TAG = "FlyMCL";

    public static void addBusinessMessageListener(int i5, BusinessMessageListener businessMessageListener) {
        h.b().a(i5, businessMessageListener);
    }

    public static void deleteMsg(String str) {
        h.b().a(str);
    }

    public static void getClientTcpStatus(BusinessCallBack<Boolean> businessCallBack) {
        h.b().a(businessCallBack);
    }

    public static long getCreateSuidTime() {
        h.b().g();
        return h.b().f1562k;
    }

    public static String getSuid() {
        h.b().g();
        return h.b().f1561j;
    }

    public static void getTcpStatus(BusinessCallBack<Boolean> businessCallBack) {
        h.b().b(businessCallBack);
    }

    public static void registerTcpStatusListener(TcpStatusListener tcpStatusListener) {
        h.b().a(tcpStatusListener);
    }

    public static void unregisterTcpStatusListener(TcpStatusListener tcpStatusListener) {
        h.b().b(tcpStatusListener);
    }

    public static void getSuid(OnIdChangeListener onIdChangeListener) {
        h.b().a(onIdChangeListener);
        h.b().g();
    }
}
