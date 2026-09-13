package p007a4;

import O3.a;
import androidx.core.location.LocationRequestCompat;
import g4.b;
import g4.c;
import g4.d;
import g4.k;

/* JADX INFO: renamed from: a4.s0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0301s0 {
    public static final AbstractC0288l0 createEventLoop() {
        return new C0269d(Thread.currentThread());
    }

    public static final boolean isIoDispatcherThread(Thread thread) {
        return (thread instanceof b) && ((b) thread).state == c.b;
    }

    public static final void platformAutoreleasePool(a aVar) {
        aVar.invoke();
    }

    public static final long processNextEventInCurrentThread() {
        AbstractC0288l0 abstractC0288l0CurrentOrNull$kotlinx_coroutines_core = p1.INSTANCE.currentOrNull$kotlinx_coroutines_core();
        return abstractC0288l0CurrentOrNull$kotlinx_coroutines_core != null ? abstractC0288l0CurrentOrNull$kotlinx_coroutines_core.g() : LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public static final long runSingleTaskFromCurrentSystemDispatcher() {
        k kVarPollBlocking;
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof b)) {
            throw new IllegalStateException("Expected CoroutineScheduler.Worker, but got " + threadCurrentThread);
        }
        b bVar = (b) threadCurrentThread;
        d dVar = bVar.d;
        boolean z6 = bVar.state == c.f4018a;
        if (z6) {
            kVarPollBlocking = bVar.localQueue.pollCpu();
            if (kVarPollBlocking == null && (kVarPollBlocking = (k) dVar.globalBlockingQueue.removeFirstOrNull()) == null) {
                kVarPollBlocking = bVar.e(2);
            }
        } else {
            kVarPollBlocking = bVar.localQueue.pollBlocking();
            if (kVarPollBlocking == null && (kVarPollBlocking = (k) dVar.globalBlockingQueue.removeFirstOrNull()) == null) {
                kVarPollBlocking = bVar.e(1);
            }
        }
        if (kVarPollBlocking == null) {
            long j6 = bVar.b;
            if (j6 == 0) {
                return -1L;
            }
            return j6;
        }
        dVar.runSafely(kVarPollBlocking);
        if (!z6) {
            d.b.addAndGet(dVar, -2097152L);
        }
        return 0L;
    }
}
