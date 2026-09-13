package cn.fly.mcl;

import cn.fly.tools.proguard.EverythingKeeper;

/* JADX INFO: loaded from: classes.dex */
public interface TcpStatusListener extends EverythingKeeper {
    void onStatus(TcpStatus tcpStatus);
}
