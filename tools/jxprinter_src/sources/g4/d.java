package g4;

import A3.AbstractC0157z;
import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.E;
import org.apache.commons.compress.archivers.tar.TarConstants;
import p007a4.S;
import p028e4.C;
import p028e4.H;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;
    public final int corePoolSize;
    public final g globalBlockingQueue;
    public final g globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;
    public final String schedulerName;
    public final C workers;
    public static final a Companion = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f4021a = AtomicLongFieldUpdater.newUpdater(d.class, "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater b = AtomicLongFieldUpdater.newUpdater(d.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(d.class, "_isTerminated$volatile");
    public static final H NOT_IN_STACK = new H("NOT_IN_STACK");

    public d(int i5, int i6, long j6, String str) {
        this.corePoolSize = i5;
        this.maxPoolSize = i6;
        this.idleWorkerKeepAliveNs = j6;
        this.schedulerName = str;
        if (i5 < 1) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Core pool size ", " should be at least 1").toString());
        }
        if (i6 < i5) {
            throw new IllegalArgumentException(androidx.collection.a.h(i6, i5, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i6 > 2097150) {
            throw new IllegalArgumentException(androidx.collection.a.i(i6, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j6 <= 0) {
            throw new IllegalArgumentException(androidx.exifinterface.media.a.k("Idle worker keep alive time ", j6, " must be positive").toString());
        }
        this.globalCpuQueue = new g();
        this.globalBlockingQueue = new g();
        this.workers = new C((i5 + 1) * 2);
        this.controlState$volatile = ((long) i5) << 42;
        this._isTerminated$volatile = 0;
    }

    public static /* synthetic */ void b(d dVar, Runnable runnable, int i5) {
        dVar.dispatch(runnable, false, (i5 & 4) == 0);
    }

    public final int a() {
        synchronized (this.workers) {
            try {
                if (c.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = b;
                long j6 = atomicLongFieldUpdater.get(this);
                int i5 = (int) (j6 & TarConstants.MAXID);
                int i6 = i5 - ((int) ((j6 & 4398044413952L) >> 21));
                if (i6 < 0) {
                    i6 = 0;
                }
                if (i6 >= this.corePoolSize) {
                    return 0;
                }
                if (i5 >= this.maxPoolSize) {
                    return 0;
                }
                int i7 = ((int) (atomicLongFieldUpdater.get(this) & TarConstants.MAXID)) + 1;
                if (i7 <= 0 || this.workers.get(i7) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                b bVar = new b(this, i7);
                this.workers.setSynchronized(i7, bVar);
                if (i7 != ((int) (TarConstants.MAXID & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i8 = i6 + 1;
                bVar.start();
                return i8;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c(long j6) {
        int i5 = ((int) (TarConstants.MAXID & j6)) - ((int) ((j6 & 4398044413952L) >> 21));
        if (i5 < 0) {
            i5 = 0;
        }
        if (i5 < this.corePoolSize) {
            int iA = a();
            if (iA == 1 && this.corePoolSize > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i5;
        k kVarFindTask;
        if (c.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            b bVar = null;
            b bVar2 = threadCurrentThread instanceof b ? (b) threadCurrentThread : null;
            if (bVar2 != null && E.a(bVar2.d, this)) {
                bVar = bVar2;
            }
            synchronized (this.workers) {
                i5 = (int) (b.get(this) & TarConstants.MAXID);
            }
            if (1 <= i5) {
                int i6 = 1;
                while (true) {
                    Object obj = this.workers.get(i6);
                    E.c(obj);
                    b bVar3 = (b) obj;
                    if (bVar3 != bVar) {
                        while (bVar3.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(bVar3);
                            bVar3.join(10000L);
                        }
                        bVar3.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                    }
                    if (i6 == i5) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            this.globalBlockingQueue.a();
            this.globalCpuQueue.a();
            while (true) {
                if (bVar == null) {
                    kVarFindTask = (k) this.globalCpuQueue.removeFirstOrNull();
                    if (kVarFindTask == null && (kVarFindTask = (k) this.globalBlockingQueue.removeFirstOrNull()) == null) {
                        break;
                    }
                } else {
                    kVarFindTask = bVar.findTask(true);
                    if (kVarFindTask == null) {
                        kVarFindTask = (k) this.globalCpuQueue.removeFirstOrNull();
                        if (kVarFindTask == null) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                runSafely(kVarFindTask);
            }
            if (bVar != null) {
                bVar.tryReleaseCpu(c.e);
            }
            f4021a.set(this, 0L);
            b.set(this, 0L);
        }
    }

    public final k createTask(Runnable runnable, boolean z6) {
        ((h) m.schedulerTimeSource).getClass();
        long jNanoTime = System.nanoTime();
        if (!(runnable instanceof k)) {
            return m.asTask(runnable, jNanoTime, z6);
        }
        k kVar = (k) runnable;
        kVar.submissionTime = jNanoTime;
        kVar.taskContext = z6;
        return kVar;
    }

    public final boolean d() {
        H h6;
        int iA;
        while (true) {
            long j6 = f4021a.get(this);
            b bVar = (b) this.workers.get((int) (TarConstants.MAXID & j6));
            if (bVar == null) {
                bVar = null;
            } else {
                long j7 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j6) & (-2097152);
                Object nextParkedWorker = bVar.getNextParkedWorker();
                while (true) {
                    h6 = NOT_IN_STACK;
                    if (nextParkedWorker == h6) {
                        iA = -1;
                        break;
                    }
                    if (nextParkedWorker == null) {
                        iA = 0;
                        break;
                    }
                    b bVar2 = (b) nextParkedWorker;
                    iA = bVar2.a();
                    if (iA != 0) {
                        break;
                    }
                    nextParkedWorker = bVar2.getNextParkedWorker();
                }
                if (iA >= 0) {
                    if (f4021a.compareAndSet(this, j6, ((long) iA) | j7)) {
                        bVar.setNextParkedWorker(h6);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (bVar == null) {
                return false;
            }
            if (b.e.compareAndSet(bVar, -1, 0)) {
                LockSupport.unpark(bVar);
                return true;
            }
        }
    }

    public final void dispatch(Runnable runnable, boolean z6, boolean z7) {
        c cVar;
        k kVarCreateTask = createTask(runnable, z6);
        boolean z8 = kVarCreateTask.taskContext;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        long jAddAndGet = z8 ? atomicLongFieldUpdater.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        b bVar = null;
        b bVar2 = threadCurrentThread instanceof b ? (b) threadCurrentThread : null;
        if (bVar2 != null && E.a(bVar2.d, this)) {
            bVar = bVar2;
        }
        if (bVar != null && (cVar = bVar.state) != c.e && (kVarCreateTask.taskContext || cVar != c.b)) {
            bVar.mayHaveLocalTasks = true;
            kVarCreateTask = bVar.localQueue.add(kVarCreateTask, z7);
        }
        if (kVarCreateTask != null) {
            if (!(kVarCreateTask.taskContext ? this.globalBlockingQueue.addLast(kVarCreateTask) : this.globalCpuQueue.addLast(kVarCreateTask))) {
                throw new RejectedExecutionException(AbstractC0157z.s(new StringBuilder(), this.schedulerName, " was terminated"));
            }
        }
        boolean z9 = z7 && bVar != null;
        if (z8) {
            if (z9 || d() || c(jAddAndGet)) {
                return;
            }
            d();
            return;
        }
        if (z9 || d() || c(atomicLongFieldUpdater.get(this))) {
            return;
        }
        d();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        b(this, runnable, 6);
    }

    public final boolean parkedWorkersStackPush(b bVar) {
        long j6;
        long j7;
        int iA;
        if (bVar.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        do {
            j6 = f4021a.get(this);
            int i5 = (int) (TarConstants.MAXID & j6);
            j7 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j6) & (-2097152);
            iA = bVar.a();
            bVar.setNextParkedWorker(this.workers.get(i5));
        } while (!f4021a.compareAndSet(this, j6, ((long) iA) | j7));
        return true;
    }

    public final void parkedWorkersStackTopUpdate(b bVar, int i5, int i6) {
        while (true) {
            long j6 = f4021a.get(this);
            int i7 = (int) (TarConstants.MAXID & j6);
            long j7 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j6) & (-2097152);
            if (i7 == i5) {
                if (i6 == 0) {
                    Object nextParkedWorker = bVar.getNextParkedWorker();
                    while (true) {
                        if (nextParkedWorker == NOT_IN_STACK) {
                            i7 = -1;
                            break;
                        }
                        if (nextParkedWorker == null) {
                            i7 = 0;
                            break;
                        }
                        b bVar2 = (b) nextParkedWorker;
                        int iA = bVar2.a();
                        if (iA != 0) {
                            i7 = iA;
                            break;
                        }
                        nextParkedWorker = bVar2.getNextParkedWorker();
                    }
                } else {
                    i7 = i6;
                }
            }
            if (i7 >= 0) {
                if (f4021a.compareAndSet(this, j6, ((long) i7) | j7)) {
                    return;
                }
            }
        }
    }

    public final void runSafely(k kVar) {
        try {
            kVar.run();
        } catch (Throwable th) {
            Thread threadCurrentThread = Thread.currentThread();
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.workers.a();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 1; i10 < iA; i10++) {
            b bVar = (b) this.workers.get(i10);
            if (bVar != null) {
                o oVar = bVar.localQueue;
                oVar.getClass();
                int i11 = o.f4022a.get(oVar) != null ? (o.b.get(oVar) - o.c.get(oVar)) + 1 : o.b.get(oVar) - o.c.get(oVar);
                int iOrdinal = bVar.state.ordinal();
                if (iOrdinal == 0) {
                    i5++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i11);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i6++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i11);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i7++;
                } else if (iOrdinal == 3) {
                    i8++;
                    if (i11 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i11);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        throw new C1937q();
                    }
                    i9++;
                }
            }
        }
        long j6 = b.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.schedulerName);
        sb4.append('@');
        sb4.append(S.getHexAddress(this));
        sb4.append("[Pool Size {core = ");
        sb4.append(this.corePoolSize);
        sb4.append(", max = ");
        androidx.exifinterface.media.a.y(sb4, this.maxPoolSize, "}, Worker States {CPU = ", i5, ", blocking = ");
        androidx.exifinterface.media.a.y(sb4, i6, ", parked = ", i7, ", dormant = ");
        androidx.exifinterface.media.a.y(sb4, i8, ", terminated = ", i9, "}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.globalCpuQueue.b());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.globalBlockingQueue.b());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (TarConstants.MAXID & j6));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j6) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(this.corePoolSize - ((int) ((9223367638808264704L & j6) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
