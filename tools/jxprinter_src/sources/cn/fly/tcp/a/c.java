package cn.fly.tcp.a;

import A3.AbstractC0157z;
import cn.fly.tools.FlyLog;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f1530a = new c();

    private c() {
    }

    public static c a() {
        return f1530a;
    }

    public void b(String str) {
        FlyLog.getInstance().d(AbstractC0157z.n("[TP]", str), new Object[0]);
    }

    public void a(String str) {
        FlyLog.getInstance().d(AbstractC0157z.n("[TP]", str), new Object[0]);
    }

    public void a(Throwable th) {
        FlyLog.getInstance().d(th, "%s", "[TP]");
    }

    public void a(String str, Throwable th) {
        FlyLog.getInstance().d(th, "%s", AbstractC0157z.n("[TP]", str));
    }
}
