package com.mob.mcl;

import android.content.Context;
import android.os.Bundle;
import cn.fly.mcl.FlyMCL;
import com.mob.mgs.OnIdChangeListener;
import com.mob.tools.proguard.EverythingKeeper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MobMCL implements EverythingKeeper {
    private static Map<TcpStatusListener, cn.fly.mcl.TcpStatusListener> listenerMap = new HashMap();

    public interface ELPMessageListener extends EverythingKeeper {
        boolean messageReceived(Bundle bundle);
    }

    public static void addBusinessMessageListener(int i5, final BusinessMessageListener businessMessageListener) {
        if (businessMessageListener == null) {
            FlyMCL.addBusinessMessageListener(i5, null);
        } else {
            FlyMCL.addBusinessMessageListener(i5, businessMessageListener instanceof BusinessMessageCallback ? new cn.fly.mcl.BusinessMessageCallback() { // from class: com.mob.mcl.MobMCL.4
                @Override // cn.fly.mcl.BusinessMessageCallback
                public void messageReceived(int i6, int i7, String str, String str2) {
                    ((BusinessMessageCallback) businessMessageListener).messageReceived(i6, i7, str, str2);
                }
            } : new cn.fly.mcl.BusinessMessageListener() { // from class: com.mob.mcl.MobMCL.5
                @Override // cn.fly.mcl.BusinessMessageListener
                public void messageReceived(int i6, String str, String str2) {
                    businessMessageListener.messageReceived(i6, str, str2);
                }
            });
        }
    }

    public static void deleteMsg(String str) {
        FlyMCL.deleteMsg(str);
    }

    public static void getClientTcpStatus(final BusinessCallBack<Boolean> businessCallBack) {
        FlyMCL.getClientTcpStatus(new cn.fly.mcl.BusinessCallBack<Boolean>() { // from class: com.mob.mcl.MobMCL.3
            @Override // cn.fly.mcl.BusinessCallBack
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void callback(Boolean bool) {
                BusinessCallBack businessCallBack2 = businessCallBack;
                if (businessCallBack2 != null) {
                    businessCallBack2.callback(bool);
                }
            }
        });
    }

    public static long getCreateSuidTime() {
        return FlyMCL.getCreateSuidTime();
    }

    public static String getSuid() {
        return FlyMCL.getSuid();
    }

    public static void getTcpStatus(final BusinessCallBack<Boolean> businessCallBack) {
        FlyMCL.getTcpStatus(new cn.fly.mcl.BusinessCallBack<Boolean>() { // from class: com.mob.mcl.MobMCL.2
            @Override // cn.fly.mcl.BusinessCallBack
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void callback(Boolean bool) {
                BusinessCallBack businessCallBack2 = businessCallBack;
                if (businessCallBack2 != null) {
                    businessCallBack2.callback(bool);
                }
            }
        });
    }

    public static void registerTcpStatusListener(final TcpStatusListener tcpStatusListener) {
        if (tcpStatusListener == null) {
            FlyMCL.registerTcpStatusListener(null);
            return;
        }
        cn.fly.mcl.TcpStatusListener tcpStatusListener2 = listenerMap.get(tcpStatusListener);
        if (tcpStatusListener2 == null) {
            tcpStatusListener2 = new cn.fly.mcl.TcpStatusListener() { // from class: com.mob.mcl.MobMCL.6
                @Override // cn.fly.mcl.TcpStatusListener
                public void onStatus(cn.fly.mcl.TcpStatus tcpStatus) {
                    TcpStatus tcpStatusObtain = TcpStatus.obtain(10);
                    tcpStatusObtain.code = tcpStatus.code;
                    tcpStatusObtain.msg = tcpStatus.msg;
                    tcpStatusObtain.detailedMsg = tcpStatus.detailedMsg;
                    tcpStatusListener.onStatus(tcpStatusObtain);
                }
            };
            listenerMap.put(tcpStatusListener, tcpStatusListener2);
        }
        FlyMCL.registerTcpStatusListener(tcpStatusListener2);
    }

    public void unregisterTcpStatusListener(TcpStatusListener tcpStatusListener) {
        cn.fly.mcl.TcpStatusListener tcpStatusListenerRemove = listenerMap.remove(tcpStatusListener);
        if (tcpStatusListenerRemove != null) {
            FlyMCL.unregisterTcpStatusListener(tcpStatusListenerRemove);
        }
    }

    public static void getSuid(final OnIdChangeListener onIdChangeListener) {
        FlyMCL.getSuid(new cn.fly.mgs.OnIdChangeListener() { // from class: com.mob.mcl.MobMCL.1
            @Override // cn.fly.mgs.OnIdChangeListener
            public void onChanged(String str, String str2) {
                OnIdChangeListener onIdChangeListener2 = onIdChangeListener;
                if (onIdChangeListener2 != null) {
                    onIdChangeListener2.onChanged(str, str2);
                }
            }
        });
    }

    @Deprecated
    public static void initMCLink(Context context, String str, String str2) {
    }
}
