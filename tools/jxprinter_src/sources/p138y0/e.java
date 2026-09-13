package p138y0;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements ExecutorService, AutoCloseable {
    public static final long b = TimeUnit.SECONDS.toMillis(10);
    public static volatile int c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f9031a;

    @VisibleForTesting
    public e(ExecutorService executorService) {
        this.f9031a = executorService;
    }

    public static a a() {
        a aVar = new a(false);
        if (c == 0) {
            c = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        a threadCount = aVar.setThreadCount(c);
        threadCount.d = FirebaseAnalytics.Param.SOURCE;
        return threadCount;
    }

    @Deprecated
    public static e newAnimationExecutor(int i5, d dVar) {
        if (c == 0) {
            c = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        a threadCount = new a(true).setThreadCount(c >= 4 ? 2 : 1);
        threadCount.d = "animation";
        return threadCount.setThreadCount(i5).setUncaughtThrowableStrategy(dVar).a();
    }

    @Deprecated
    public static e newDiskCacheExecutor(int i5, String str, d dVar) {
        a threadCount = new a(true).setThreadCount(1);
        threadCount.d = "disk-cache";
        a threadCount2 = threadCount.setThreadCount(i5);
        threadCount2.d = str;
        return threadCount2.setUncaughtThrowableStrategy(dVar).a();
    }

    @Deprecated
    public static e newSourceExecutor(d dVar) {
        return a().setUncaughtThrowableStrategy(dVar).a();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j6, @NonNull TimeUnit timeUnit) {
        return this.f9031a.awaitTermination(j6, timeUnit);
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        boolean zIsTerminated;
        if (this == ForkJoinPool.commonPool() || (zIsTerminated = isTerminated())) {
            return;
        }
        shutdown();
        boolean z6 = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z6) {
                    shutdownNow();
                    z6 = true;
                }
            }
        }
        if (z6) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f9031a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) {
        return this.f9031a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) {
        return (T) this.f9031a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.f9031a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.f9031a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f9031a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f9031a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f9031a.submit(runnable);
    }

    public final String toString() {
        return this.f9031a.toString();
    }

    @Deprecated
    public static e newSourceExecutor(int i5, String str, d dVar) {
        a threadCount = a().setThreadCount(i5);
        threadCount.d = str;
        return threadCount.setUncaughtThrowableStrategy(dVar).a();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j6, @NonNull TimeUnit timeUnit) {
        return this.f9031a.invokeAll(collection, j6, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j6, @NonNull TimeUnit timeUnit) {
        return (T) this.f9031a.invokeAny(collection, j6, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t6) {
        return this.f9031a.submit(runnable, t6);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f9031a.submit(callable);
    }

    @Deprecated
    public static e newDiskCacheExecutor(d dVar) {
        a threadCount = new a(true).setThreadCount(1);
        threadCount.d = "disk-cache";
        return threadCount.setUncaughtThrowableStrategy(dVar).a();
    }
}
