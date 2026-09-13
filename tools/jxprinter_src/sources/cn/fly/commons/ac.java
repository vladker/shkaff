package cn.fly.commons;

import A3.AbstractC0157z;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: loaded from: classes.dex */
public class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f1261a;
    public static final ThreadPoolExecutor b;
    public static final ExecutorService c;
    public static final ExecutorService d;
    public static final ExecutorService e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ScheduledExecutorService f1262f;

    public static class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                cn.fly.commons.a.l.a().b(500L, runnable);
            } catch (Throwable unused) {
            }
        }
    }

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AtomicInteger f1263a = new AtomicInteger(1);
        private final ThreadGroup b;
        private final AtomicInteger c = new AtomicInteger(1);
        private final String d;

        public b(int i5) {
            SecurityManager securityManager = System.getSecurityManager();
            this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            if (!TextUtils.isEmpty("M-")) {
                StringBuilder sbT = AbstractC0157z.t(i5, "M-PL-", ProcessIdUtil.DEFAULT_PROCESSID);
                sbT.append(f1263a.getAndIncrement());
                sbT.append(ProcessIdUtil.DEFAULT_PROCESSID);
                this.d = sbT.toString();
                return;
            }
            this.d = cn.fly.commons.a.l.a("005kEelel%h=il") + f1263a.getAndIncrement() + cn.fly.commons.a.l.a("008Nil6jiKekHge7edil");
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static {
        int iMax = Math.max(2, 5);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f1261a = new ThreadPoolExecutor(2, iMax, 60L, timeUnit, new SynchronousQueue(), new b(0), new a());
        b = new ThreadPoolExecutor(1, 1, 120L, timeUnit, new LinkedBlockingQueue(), new b(1));
        c = Executors.newCachedThreadPool(new b(2));
        d = Executors.newCachedThreadPool(new b(3));
        e = Executors.newCachedThreadPool(new b(4));
        f1262f = Executors.newScheduledThreadPool(1, new b(5));
    }
}
