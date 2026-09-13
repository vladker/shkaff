package com.mob.commons.logcollector;

import com.mob.tools.log.LogCollector;
import com.mob.tools.proguard.ProtectedMemberKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class LogsCollector implements LogCollector, ProtectedMemberKeeper, PublicMemberKeeper {
    public LogsCollector() {
        DefaultLogsCollector.get().addSDK(getSDKTag(), getSDKVersion());
    }

    public abstract String getSDKTag();

    public abstract int getSDKVersion();

    public final void log(String str, int i5, int i6, String str2, String str3) {
        DefaultLogsCollector.get().log(str, i5, i6, str2, str3);
    }
}
