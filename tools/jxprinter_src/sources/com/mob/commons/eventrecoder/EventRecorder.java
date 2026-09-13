package com.mob.commons.eventrecoder;

import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
public final class EventRecorder implements PublicMemberKeeper {
    public static final synchronized void addBegin(String str, String str2) {
        cn.fly.commons.eventrecoder.EventRecorder.addBegin(str, str2);
    }

    public static final synchronized void addEnd(String str, String str2) {
        cn.fly.commons.eventrecoder.EventRecorder.addEnd(str, str2);
    }

    public static final synchronized String checkRecord(String str) {
        return cn.fly.commons.eventrecoder.EventRecorder.checkRecord(str);
    }

    public static final synchronized void clear() {
        cn.fly.commons.eventrecoder.EventRecorder.clear();
    }

    public static final synchronized void prepare() {
        cn.fly.commons.eventrecoder.EventRecorder.prepare();
    }
}
