package cn.fly.tools.xcrash;

import cn.fly.tools.FlyLog;

/* JADX INFO: loaded from: classes.dex */
class a {
    public void a(String str, String str2) {
        FlyLog.getInstance().d("[%s] %s", str, str2);
    }

    public void b(String str, String str2) {
        FlyLog.getInstance().d("[%s] %s", str, str2);
    }

    public void a(String str, String str2, Throwable th) {
        FlyLog.getInstance().d(th, "[%s] %s", str, str2);
    }
}
