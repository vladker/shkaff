package okhttp3;

import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: okhttp3.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1369o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f6670a = new ArrayDeque();
    public final ArrayDeque b = new ArrayDeque();
    public final ArrayDeque c = new ArrayDeque();
    private ExecutorService executorService;
    private Runnable idleCallback;

    private J findExistingCallWithHost(String str) {
        for (J j6 : this.b) {
            if (j6.d.c.f6539a.d.equals(str)) {
                return j6;
            }
        }
        for (J j7 : this.f6670a) {
            if (j7.d.c.f6539a.d.equals(str)) {
                return j7;
            }
        }
        return null;
    }

    public final void a(J j6) {
        synchronized (this) {
            this.f6670a.add(j6);
            J jFindExistingCallWithHost = findExistingCallWithHost(j6.d.c.f6539a.d);
            if (jFindExistingCallWithHost != null) {
                j6.c = jFindExistingCallWithHost.c;
            }
        }
        d();
    }

    public final void b(ArrayDeque arrayDeque, Object obj) {
        Runnable runnable;
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.idleCallback;
        }
        if (d() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public final void c(J j6) {
        j6.c.decrementAndGet();
        b(this.b, j6);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005f  */
    /* JADX WARN: Code duplicated, block: B:31:0x006b A[Catch: all -> 0x0089, TryCatch #2 {all -> 0x0089, blocks: (B:29:0x0067, B:31:0x006b, B:34:0x008b), top: B:59:0x0067 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final boolean d() {
        int size;
        int size2;
        int i5;
        J j6;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.f6670a.iterator();
                while (it.hasNext()) {
                    J j7 = (J) it.next();
                    if (this.b.size() >= 64) {
                        break;
                    }
                    if (j7.c.get() < 5) {
                        it.remove();
                        j7.c.incrementAndGet();
                        arrayList.add(j7);
                        this.b.add(j7);
                    }
                }
                synchronized (this) {
                    size = this.b.size() + this.c.size();
                }
                size2 = arrayList.size();
                for (i5 = 0; i5 < size2; i5++) {
                    j6 = (J) arrayList.get(i5);
                    synchronized (this) {
                        try {
                            if (this.executorService == null) {
                                TimeUnit timeUnit = TimeUnit.SECONDS;
                                SynchronousQueue synchronousQueue = new SynchronousQueue();
                                byte[] bArr = p107s4.d.f8235a;
                                this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new p107s4.c("OkHttp Dispatcher", false));
                            }
                            ExecutorService executorService = this.executorService;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    K k6 = j6.d;
                    try {
                        try {
                            executorService.execute(j6);
                        } catch (Throwable th2) {
                            k6.f6537a.f6512a.c(j6);
                            throw th2;
                        }
                    } catch (RejectedExecutionException e) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                        interruptedIOException.initCause(e);
                        k6.b.noMoreExchanges(interruptedIOException);
                        j6.b.f(interruptedIOException);
                        k6.f6537a.f6512a.c(j6);
                    }
                }
                return z;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        boolean z6 = size > 0;
        size2 = arrayList.size();
        while (i5 < size2) {
            j6 = (J) arrayList.get(i5);
            synchronized (this) {
                if (this.executorService == null) {
                    TimeUnit timeUnit2 = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue2 = new SynchronousQueue();
                    byte[] bArr2 = p107s4.d.f8235a;
                    this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit2, synchronousQueue2, new p107s4.c("OkHttp Dispatcher", false));
                }
                ExecutorService executorService2 = this.executorService;
                K k7 = j6.d;
                executorService2.execute(j6);
            }
        }
        return z6;
    }

    public synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }
}
