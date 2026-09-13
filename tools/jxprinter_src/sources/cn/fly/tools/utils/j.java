package cn.fly.tools.utils;

import android.text.TextUtils;
import cn.fly.tools.FlyLog;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends Thread {
    public j() {
    }

    public abstract void a();

    public void a(Throwable th) {
        FlyLog.getInstance().d(th);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            a(th);
        }
    }

    public j(String str) {
        if (TextUtils.isEmpty("M-")) {
            return;
        }
        setName("M-" + str);
    }
}
