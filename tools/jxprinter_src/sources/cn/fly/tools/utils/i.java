package cn.fly.tools.utils;

import cn.fly.tools.FlyLog;

/* JADX INFO: loaded from: classes.dex */
public abstract class i implements Runnable {
    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }
}
