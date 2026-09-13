package p007a4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p028e4.N;
import p028e4.O;

/* JADX INFO: renamed from: a4.o0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRunnableC0294o0 implements Runnable, Comparable, InterfaceC0280h0, O {
    private volatile Object _heap;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f955a = -1;
    public long nanoTime;

    public AbstractRunnableC0294o0(long j6) {
        this.nanoTime = j6;
    }

    @Override // p007a4.InterfaceC0280h0
    public final void dispose() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                if (obj == AbstractC0303t0.DISPOSED_TASK) {
                    return;
                }
                C0296p0 c0296p0 = obj instanceof C0296p0 ? (C0296p0) obj : null;
                if (c0296p0 != null) {
                    c0296p0.remove(this);
                }
                this._heap = AbstractC0303t0.DISPOSED_TASK;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p028e4.O
    public N getHeap() {
        Object obj = this._heap;
        if (obj instanceof N) {
            return (N) obj;
        }
        return null;
    }

    public final int scheduleTask(long j6, C0296p0 c0296p0, AbstractC0298q0 abstractC0298q0) {
        synchronized (this) {
            if (this._heap == AbstractC0303t0.DISPOSED_TASK) {
                return 2;
            }
            synchronized (c0296p0) {
                try {
                    AbstractRunnableC0294o0 abstractRunnableC0294o0 = (AbstractRunnableC0294o0) c0296p0.firstImpl();
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = AbstractC0298q0.d;
                    abstractC0298q0.getClass();
                    if (AbstractC0298q0.f956f.get(abstractC0298q0) != 0) {
                        return 1;
                    }
                    if (abstractRunnableC0294o0 == null) {
                        c0296p0.timeNow = j6;
                    } else {
                        long j7 = abstractRunnableC0294o0.nanoTime;
                        if (j7 - j6 < 0) {
                            j6 = j7;
                        }
                        if (j6 - c0296p0.timeNow > 0) {
                            c0296p0.timeNow = j6;
                        }
                    }
                    long j8 = this.nanoTime;
                    long j9 = c0296p0.timeNow;
                    if (j8 - j9 < 0) {
                        this.nanoTime = j9;
                    }
                    c0296p0.addImpl(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // p028e4.O
    public void setHeap(N n6) {
        if (this._heap == AbstractC0303t0.DISPOSED_TASK) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this._heap = n6;
    }

    public String toString() {
        return "Delayed[nanos=" + this.nanoTime + ']';
    }

    @Override // java.lang.Comparable
    public int compareTo(AbstractRunnableC0294o0 abstractRunnableC0294o0) {
        long j6 = this.nanoTime - abstractRunnableC0294o0.nanoTime;
        if (j6 > 0) {
            return 1;
        }
        return j6 < 0 ? -1 : 0;
    }
}
