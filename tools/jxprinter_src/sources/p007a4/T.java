package p007a4;

import E3.q;
import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T extends AbstractC0298q0 implements Runnable {
    public static final T INSTANCE;
    public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f945g;

    static {
        Long l6;
        T t6 = new T();
        INSTANCE = t6;
        t6.d(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l6 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l6 = 1000L;
        }
        f945g = timeUnit.toNanos(l6.longValue());
    }

    @Override // p007a4.AbstractC0298q0
    public void enqueue(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.enqueue(runnable);
    }

    @Override // p007a4.AbstractC0299r0
    public Thread getThread() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, THREAD_NAME);
                _thread = thread;
                thread.setContextClassLoader(INSTANCE.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // p007a4.AbstractC0298q0, p007a4.Y
    public InterfaceC0280h0 invokeOnTimeout(long j6, Runnable runnable, q qVar) {
        return scheduleInvokeOnTimeout(j6, runnable);
    }

    public final synchronized void l() {
        int i5 = debugStatus;
        if (i5 == 2 || i5 == 3) {
            debugStatus = 3;
            AbstractC0298q0.d.set(this, null);
            AbstractC0298q0.e.set(this, null);
            notifyAll();
        }
    }

    @Override // p007a4.AbstractC0299r0
    public void reschedule(long j6, AbstractRunnableC0294o0 abstractRunnableC0294o0) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public final void run() {
        p1.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        try {
            synchronized (this) {
                int i5 = debugStatus;
                if (i5 == 2 || i5 == 3) {
                    _thread = null;
                    l();
                    if (k()) {
                        return;
                    }
                    getThread();
                    return;
                }
                debugStatus = 1;
                notifyAll();
                long j6 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jG = g();
                    if (jG == LocationRequestCompat.PASSIVE_INTERVAL) {
                        long jNanoTime = System.nanoTime();
                        if (j6 == LocationRequestCompat.PASSIVE_INTERVAL) {
                            j6 = f945g + jNanoTime;
                        }
                        long j7 = j6 - jNanoTime;
                        if (j7 <= 0) {
                            _thread = null;
                            l();
                            if (k()) {
                                return;
                            }
                            getThread();
                            return;
                        }
                        if (jG > j7) {
                            jG = j7;
                        }
                    } else {
                        j6 = Long.MAX_VALUE;
                    }
                    if (jG > 0) {
                        int i6 = debugStatus;
                        if (i6 == 2 || i6 == 3) {
                            _thread = null;
                            l();
                            if (k()) {
                                return;
                            }
                            getThread();
                            return;
                        }
                        LockSupport.parkNanos(this, jG);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            l();
            if (!k()) {
                getThread();
            }
            throw th;
        }
    }

    @Override // p007a4.AbstractC0298q0, p007a4.AbstractC0288l0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // p007a4.F
    public String toString() {
        return "DefaultExecutor";
    }
}
