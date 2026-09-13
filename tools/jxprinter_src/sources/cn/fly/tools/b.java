package cn.fly.tools;

import cn.fly.commons.x;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f1683a = null;
    private static volatile boolean b = false;
    private static AtomicBoolean c = new AtomicBoolean(false);

    private b() {
    }

    public static synchronized void a() {
        if (!b && x.f1505i && c.compareAndSet(false, true)) {
            FlyLog.getInstance().d("reg UEH", new Object[0]);
            f1683a = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new b());
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            FlyLog.getInstance().d("UE handled, processing...", new Object[0]);
            FlyLog.getInstance().crash(th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f1683a;
            if (uncaughtExceptionHandler == null || (uncaughtExceptionHandler instanceof b)) {
                return;
            }
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } catch (Throwable th2) {
            try {
                FlyLog.getInstance().d(th2);
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = f1683a;
                if (uncaughtExceptionHandler2 != null && !(uncaughtExceptionHandler2 instanceof b)) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        }
    }
}
