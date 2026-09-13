package com.mob.tools.utils;

import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
public class FileLocker implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cn.fly.tools.utils.FileLocker f3674a = new cn.fly.tools.utils.FileLocker();

    public synchronized boolean lock(boolean z6) {
        return this.f3674a.lock(z6);
    }

    public synchronized void release() {
        this.f3674a.release();
    }

    public synchronized void setLockFile(String str) {
        this.f3674a.setLockFile(str);
    }

    public synchronized void unlock() {
        this.f3674a.unlock();
    }

    public synchronized boolean lock(boolean z6, long j6, long j7) {
        return this.f3674a.lock(z6, j6, j7);
    }

    public synchronized void lock(Runnable runnable, boolean z6) {
        this.f3674a.lock(runnable, z6);
    }
}
