package com.mob.tools.utils;

import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
public final class ExecutorDispatcher implements PublicMemberKeeper, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ExecutorDispatcher f3673a;

    public static abstract class SafeRunnable extends cn.fly.tools.utils.ExecutorDispatcher.SafeRunnable {
    }

    public static a getInstance() {
        if (f3673a == null) {
            synchronized (ExecutorDispatcher.class) {
                try {
                    if (f3673a == null) {
                        f3673a = new ExecutorDispatcher();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3673a;
    }

    @Override // com.mob.tools.utils.a
    public <T extends SafeRunnable> void executeDelayed(T t6, long j6) {
        cn.fly.tools.utils.ExecutorDispatcher.getInstance().executeDelayed(t6, j6);
    }

    @Override // com.mob.tools.utils.a
    public <T extends SafeRunnable> void executeDuctile(T t6) {
        cn.fly.tools.utils.ExecutorDispatcher.getInstance().executeDuctile(t6);
    }

    @Override // com.mob.tools.utils.a
    public <T extends SafeRunnable> void executeImmediately(T t6) {
        cn.fly.tools.utils.ExecutorDispatcher.getInstance().executeImmediately(t6);
    }

    @Override // com.mob.tools.utils.a
    public <T extends SafeRunnable> void executeSerial(T t6) {
        cn.fly.tools.utils.ExecutorDispatcher.getInstance().executeSerial(t6);
    }
}
