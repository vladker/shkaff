package g4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4022a = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "lastScheduledTask$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(o.class, "producerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(o.class, "consumerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(o.class, "blockingTasksInBuffer$volatile");
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private final AtomicReferenceArray<k> buffer = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final k a(k kVar) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = b;
        if (atomicIntegerFieldUpdater.get(this) - c.get(this) == 127) {
            return kVar;
        }
        if (kVar.taskContext) {
            d.incrementAndGet(this);
        }
        int i5 = atomicIntegerFieldUpdater.get(this) & 127;
        while (this.buffer.get(i5) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i5, kVar);
        atomicIntegerFieldUpdater.incrementAndGet(this);
        return null;
    }

    public final k add(k kVar, boolean z6) {
        if (z6) {
            return a(kVar);
        }
        k kVar2 = (k) f4022a.getAndSet(this, kVar);
        if (kVar2 == null) {
            return null;
        }
        return a(kVar2);
    }

    public final k b() {
        k andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c;
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 - b.get(this) == 0) {
                return null;
            }
            int i6 = i5 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i5, i5 + 1) && (andSet = this.buffer.getAndSet(i6, null)) != null) {
                if (andSet.taskContext) {
                    d.decrementAndGet(this);
                }
                return andSet;
            }
        }
    }

    public final k c(boolean z6) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4022a;
            k kVar = (k) atomicReferenceFieldUpdater.get(this);
            if (kVar == null || kVar.taskContext != z6) {
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, kVar, null)) {
                if (atomicReferenceFieldUpdater.get(this) != kVar) {
                }
            }
            return kVar;
        }
        int i5 = c.get(this);
        int i6 = b.get(this);
        while (i5 != i6 && (!z6 || d.get(this) != 0)) {
            i6--;
            k kVarD = d(i6, z6);
            if (kVarD != null) {
                return kVarD;
            }
        }
        return null;
    }

    public final k d(int i5, boolean z6) {
        int i6 = i5 & 127;
        k kVar = this.buffer.get(i6);
        if (kVar != null && kVar.taskContext == z6) {
            AtomicReferenceArray<k> atomicReferenceArray = this.buffer;
            while (!atomicReferenceArray.compareAndSet(i6, kVar, null)) {
                if (atomicReferenceArray.get(i6) != kVar) {
                }
            }
            if (z6) {
                d.decrementAndGet(this);
            }
            return kVar;
        }
        return null;
    }

    public final void offloadAllWorkTo(g gVar) {
        k kVar = (k) f4022a.getAndSet(this, null);
        if (kVar != null) {
            gVar.addLast(kVar);
        }
        while (true) {
            k kVarB = b();
            if (kVarB == null) {
                return;
            } else {
                gVar.addLast(kVarB);
            }
        }
    }

    public final k poll() {
        k kVar = (k) f4022a.getAndSet(this, null);
        return kVar == null ? b() : kVar;
    }

    public final k pollBlocking() {
        return c(true);
    }

    public final k pollCpu() {
        return c(false);
    }

    public final long trySteal(int i5, T t6) {
        k kVarD;
        if (i5 != 3) {
            int i6 = c.get(this);
            int i7 = b.get(this);
            boolean z6 = i5 == 1;
            while (true) {
                if (i6 != i7 && (!z6 || d.get(this) != 0)) {
                    int i8 = i6 + 1;
                    kVarD = d(i6, z6);
                    if (kVarD != null) {
                        break;
                    }
                    i6 = i8;
                } else {
                    kVarD = null;
                    break;
                }
            }
        } else {
            kVarD = b();
        }
        if (kVarD != null) {
            t6.f5689a = kVarD;
            return -1L;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4022a;
            k kVar = (k) atomicReferenceFieldUpdater.get(this);
            if (kVar == null) {
                return -2L;
            }
            if (((kVar.taskContext ? 1 : 2) & i5) == 0) {
                return -2L;
            }
            ((h) m.schedulerTimeSource).getClass();
            long jNanoTime = System.nanoTime() - kVar.submissionTime;
            long j6 = m.WORK_STEALING_TIME_RESOLUTION_NS;
            if (jNanoTime < j6) {
                return j6 - jNanoTime;
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, kVar, null)) {
                    t6.f5689a = kVar;
                    return -1L;
                }
            } while (atomicReferenceFieldUpdater.get(this) == kVar);
        }
    }
}
