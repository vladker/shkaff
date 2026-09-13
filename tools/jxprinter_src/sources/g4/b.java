package g4;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.T;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends Thread {
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4017a;
    public long b;
    public int c;
    public final /* synthetic */ d d;
    private volatile int indexInArray;
    public final o localQueue;
    public boolean mayHaveLocalTasks;
    private volatile Object nextParkedWorker;
    public c state;
    private final T stolenTask;
    private volatile /* synthetic */ int workerCtl$volatile;

    public b(d dVar, int i5) {
        this.d = dVar;
        setDaemon(true);
        setContextClassLoader(d.class.getClassLoader());
        this.localQueue = new o();
        this.stolenTask = new T();
        this.state = c.d;
        this.nextParkedWorker = d.NOT_IN_STACK;
        int iNanoTime = (int) System.nanoTime();
        this.c = iNanoTime == 0 ? 42 : iNanoTime;
        d(i5);
    }

    public final int a() {
        return this.indexInArray;
    }

    public final int b(int i5) {
        int i6 = this.c;
        int i7 = i6 ^ (i6 << 13);
        int i8 = i7 ^ (i7 >> 17);
        int i9 = i8 ^ (i8 << 5);
        this.c = i9;
        int i10 = i5 - 1;
        return (i10 & i5) == 0 ? i9 & i10 : (i9 & Integer.MAX_VALUE) % i5;
    }

    public final k c() {
        int iB = b(2);
        d dVar = this.d;
        if (iB == 0) {
            k kVar = (k) dVar.globalCpuQueue.removeFirstOrNull();
            return kVar != null ? kVar : (k) dVar.globalBlockingQueue.removeFirstOrNull();
        }
        k kVar2 = (k) dVar.globalBlockingQueue.removeFirstOrNull();
        return kVar2 != null ? kVar2 : (k) dVar.globalCpuQueue.removeFirstOrNull();
    }

    public final void d(int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.schedulerName);
        sb.append("-worker-");
        sb.append(i5 == 0 ? "TERMINATED" : String.valueOf(i5));
        setName(sb.toString());
        this.indexInArray = i5;
    }

    public final k e(int i5) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = d.b;
        d dVar = this.d;
        int i6 = (int) (atomicLongFieldUpdater.get(dVar) & TarConstants.MAXID);
        if (i6 < 2) {
            return null;
        }
        int iB = b(i6);
        long jMin = Long.MAX_VALUE;
        for (int i7 = 0; i7 < i6; i7++) {
            iB++;
            if (iB > i6) {
                iB = 1;
            }
            b bVar = (b) dVar.workers.get(iB);
            if (bVar != null && bVar != this) {
                long jTrySteal = bVar.localQueue.trySteal(i5, this.stolenTask);
                if (jTrySteal == -1) {
                    T t6 = this.stolenTask;
                    k kVar = (k) t6.f5689a;
                    t6.f5689a = null;
                    return kVar;
                }
                if (jTrySteal > 0) {
                    jMin = Math.min(jMin, jTrySteal);
                }
            }
        }
        if (jMin == LocationRequestCompat.PASSIVE_INTERVAL) {
            jMin = 0;
        }
        this.b = jMin;
        return null;
    }

    public final k findTask(boolean z6) {
        k kVarC;
        k kVarC2;
        long j6;
        c cVar = this.state;
        c cVar2 = c.f4018a;
        d dVar = this.d;
        if (cVar != cVar2) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = d.b;
            do {
                j6 = atomicLongFieldUpdater.get(dVar);
                if (((int) ((9223367638808264704L & j6) >> 42)) == 0) {
                    k kVarPollBlocking = this.localQueue.pollBlocking();
                    if (kVarPollBlocking != null) {
                        return kVarPollBlocking;
                    }
                    k kVar = (k) dVar.globalBlockingQueue.removeFirstOrNull();
                    return kVar == null ? e(1) : kVar;
                }
            } while (!d.b.compareAndSet(dVar, j6, j6 - 4398046511104L));
            this.state = c.f4018a;
        }
        if (z6) {
            boolean z7 = b(dVar.corePoolSize * 2) == 0;
            if (z7 && (kVarC2 = c()) != null) {
                return kVarC2;
            }
            k kVarPoll = this.localQueue.poll();
            if (kVarPoll != null) {
                return kVarPoll;
            }
            if (!z7 && (kVarC = c()) != null) {
                return kVarC;
            }
        } else {
            k kVarC3 = c();
            if (kVarC3 != null) {
                return kVarC3;
            }
        }
        return e(3);
    }

    public final Object getNextParkedWorker() {
        return this.nextParkedWorker;
    }

    public final d getScheduler() {
        return this.d;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        loop0: while (true) {
            boolean z6 = false;
            while (true) {
                if (d.c.get(this.d) == 0) {
                    c cVar = this.state;
                    c cVar2 = c.e;
                    if (cVar == cVar2) {
                        break loop0;
                    }
                    k kVarFindTask = findTask(this.mayHaveLocalTasks);
                    if (kVarFindTask != null) {
                        this.b = 0L;
                        d dVar = this.d;
                        this.f4017a = 0L;
                        if (this.state == c.c) {
                            this.state = c.b;
                        }
                        if (!kVarFindTask.taskContext) {
                            dVar.runSafely(kVarFindTask);
                            break;
                        }
                        if (tryReleaseCpu(c.b) && !dVar.d() && !dVar.c(d.b.get(dVar))) {
                            dVar.d();
                        }
                        dVar.runSafely(kVarFindTask);
                        d.b.addAndGet(dVar, -2097152L);
                        if (this.state == cVar2) {
                            break;
                        }
                        this.state = c.d;
                        break;
                    }
                    this.mayHaveLocalTasks = false;
                    if (this.b != 0) {
                        if (z6) {
                            tryReleaseCpu(c.c);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.b);
                            this.b = 0L;
                            break;
                        }
                        z6 = true;
                    } else if (this.nextParkedWorker != d.NOT_IN_STACK) {
                        e.set(this, -1);
                        while (this.nextParkedWorker != d.NOT_IN_STACK) {
                            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = e;
                            if (atomicIntegerFieldUpdater.get(this) != -1) {
                                break;
                            }
                            d dVar2 = this.d;
                            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = d.c;
                            if (atomicIntegerFieldUpdater2.get(dVar2) != 0) {
                                break;
                            }
                            c cVar3 = this.state;
                            c cVar4 = c.e;
                            if (cVar3 == cVar4) {
                                break;
                            }
                            tryReleaseCpu(c.c);
                            Thread.interrupted();
                            if (this.f4017a == 0) {
                                this.f4017a = System.nanoTime() + this.d.idleWorkerKeepAliveNs;
                            }
                            LockSupport.parkNanos(this.d.idleWorkerKeepAliveNs);
                            if (System.nanoTime() - this.f4017a >= 0) {
                                this.f4017a = 0L;
                                d dVar3 = this.d;
                                synchronized (dVar3.workers) {
                                    try {
                                        if (!(atomicIntegerFieldUpdater2.get(dVar3) != 0)) {
                                            AtomicLongFieldUpdater atomicLongFieldUpdater = d.b;
                                            if (((int) (atomicLongFieldUpdater.get(dVar3) & TarConstants.MAXID)) > dVar3.corePoolSize) {
                                                if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                    int i5 = this.indexInArray;
                                                    d(0);
                                                    dVar3.parkedWorkersStackTopUpdate(this, i5, 0);
                                                    int andDecrement = (int) (atomicLongFieldUpdater.getAndDecrement(dVar3) & TarConstants.MAXID);
                                                    if (andDecrement != i5) {
                                                        Object obj = dVar3.workers.get(andDecrement);
                                                        E.c(obj);
                                                        b bVar = (b) obj;
                                                        dVar3.workers.setSynchronized(i5, bVar);
                                                        bVar.d(i5);
                                                        dVar3.parkedWorkersStackTopUpdate(bVar, andDecrement, i5);
                                                    }
                                                    dVar3.workers.setSynchronized(andDecrement, null);
                                                    this.state = cVar4;
                                                }
                                            }
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }
                    } else {
                        this.d.parkedWorkersStackPush(this);
                    }
                } else {
                    break loop0;
                }
            }
        }
        tryReleaseCpu(c.e);
    }

    public final void setNextParkedWorker(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean tryReleaseCpu(c cVar) {
        c cVar2 = this.state;
        boolean z6 = cVar2 == c.f4018a;
        if (z6) {
            d.b.addAndGet(this.d, 4398046511104L);
        }
        if (cVar2 != cVar) {
            this.state = cVar;
        }
        return z6;
    }
}
