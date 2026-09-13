package com.mob.commons.logcollector;

import com.mob.tools.log.LogCollector;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class DefaultLogsCollector implements LogCollector, PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static DefaultLogsCollector f3622a;
    private final HashMap<String, Integer> b = new HashMap<>();

    private DefaultLogsCollector() {
    }

    public static synchronized DefaultLogsCollector get() {
        try {
            if (f3622a == null) {
                f3622a = new DefaultLogsCollector();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3622a;
    }

    public void addSDK(String str, int i5) {
        synchronized (this.b) {
            this.b.put(str, Integer.valueOf(i5));
        }
    }

    public final void log(String str, int i5, int i6, String str2, String str3) {
        Integer num = this.b.get(str);
        if (num == null) {
            num = -1;
        }
        NLog.getInstance(str, num.intValue(), str).log(i5, str3, new Object[0]);
    }
}
