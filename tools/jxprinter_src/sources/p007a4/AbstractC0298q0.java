package p007a4;

import E3.g;
import E3.q;
import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.E;
import p028e4.H;
import p028e4.N;
import p028e4.O;
import p028e4.u;
import p147z3.Q;

/* JADX INFO: renamed from: a4.q0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0298q0 extends AbstractC0299r0 implements Y {
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(AbstractC0298q0.class, Object.class, "_queue$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(AbstractC0298q0.class, Object.class, "_delayed$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f956f = AtomicIntegerFieldUpdater.newUpdater(AbstractC0298q0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    @Override // p007a4.Y
    public Object delay(long j6, g<? super Q> gVar) {
        return X.delay(this, j6, gVar);
    }

    @Override // p007a4.F
    /* JADX INFO: renamed from: dispatch */
    public final void mo1035dispatch(q qVar, Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueue(Runnable runnable) {
        i();
        if (!j(runnable)) {
            T.INSTANCE.enqueue(runnable);
            return;
        }
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            LockSupport.unpark(thread);
        }
    }

    @Override // p007a4.AbstractC0288l0
    public final long g() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Runnable runnable;
        C0296p0 c0296p0;
        AbstractRunnableC0294o0 abstractRunnableC0294o0;
        if (!h()) {
            i();
            loop0: while (true) {
                atomicReferenceFieldUpdater = d;
                Object obj = atomicReferenceFieldUpdater.get(this);
                runnable = null;
                if (obj == null) {
                    break;
                }
                if (obj instanceof u) {
                    u uVar = (u) obj;
                    Object objRemoveFirstOrNull = uVar.removeFirstOrNull();
                    if (objRemoveFirstOrNull != u.REMOVE_FROZEN) {
                        runnable = (Runnable) objRemoveFirstOrNull;
                        break;
                    }
                    u next = uVar.next();
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, next) && atomicReferenceFieldUpdater.get(this) == obj) {
                    }
                } else {
                    if (obj == AbstractC0303t0.CLOSED_EMPTY) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                            runnable = (Runnable) obj;
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj);
                }
            }
            if (runnable != null) {
                runnable.run();
                return 0L;
            }
            if (super.c() != 0) {
                Object obj2 = atomicReferenceFieldUpdater.get(this);
                if (obj2 == null) {
                    c0296p0 = (C0296p0) e.get(this);
                    if (c0296p0 == null && (abstractRunnableC0294o0 = (AbstractRunnableC0294o0) c0296p0.peek()) != null) {
                        long jNanoTime = abstractRunnableC0294o0.nanoTime - System.nanoTime();
                        if (jNanoTime >= 0) {
                            return jNanoTime;
                        }
                    }
                } else {
                    if (obj2 instanceof u) {
                        long j6 = u.f3945f.get((u) obj2);
                        if (((int) (1073741823 & j6)) != ((int) ((j6 & 1152921503533105152L) >> 30))) {
                            return 0L;
                        }
                        c0296p0 = (C0296p0) e.get(this);
                        return c0296p0 == null ? LocationRequestCompat.PASSIVE_INTERVAL : LocationRequestCompat.PASSIVE_INTERVAL;
                    }
                    if (obj2 == AbstractC0303t0.CLOSED_EMPTY) {
                        return LocationRequestCompat.PASSIVE_INTERVAL;
                    }
                }
            }
        }
        return 0L;
    }

    public final void i() {
        O oRemoveAtImpl;
        C0296p0 c0296p0 = (C0296p0) e.get(this);
        if (c0296p0 == null || N.b.get(c0296p0) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (c0296p0) {
                try {
                    O oFirstImpl = c0296p0.firstImpl();
                    oRemoveAtImpl = null;
                    if (oFirstImpl != null) {
                        AbstractRunnableC0294o0 abstractRunnableC0294o0 = (AbstractRunnableC0294o0) oFirstImpl;
                        oRemoveAtImpl = ((jNanoTime - abstractRunnableC0294o0.nanoTime) > 0L ? 1 : ((jNanoTime - abstractRunnableC0294o0.nanoTime) == 0L ? 0 : -1)) >= 0 ? j(abstractRunnableC0294o0) : false ? c0296p0.removeAtImpl(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (((AbstractRunnableC0294o0) oRemoveAtImpl) != null);
    }

    public InterfaceC0280h0 invokeOnTimeout(long j6, Runnable runnable, q qVar) {
        return X.invokeOnTimeout(this, j6, runnable, qVar);
    }

    public final boolean j(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (f956f.get(this) != 0) {
                return false;
            }
            if (obj == null) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                    }
                }
                return true;
            }
            if (!(obj instanceof u)) {
                if (obj == AbstractC0303t0.CLOSED_EMPTY) {
                    return false;
                }
                u uVar = new u(8, true);
                uVar.addLast((Runnable) obj);
                uVar.addLast(runnable);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, uVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return true;
            }
            u uVar2 = (u) obj;
            int iAddLast = uVar2.addLast(runnable);
            if (iAddLast == 0) {
                return true;
            }
            if (iAddLast == 1) {
                u next = uVar2.next();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, next) && atomicReferenceFieldUpdater.get(this) == obj) {
                }
            } else if (iAddLast == 2) {
                return false;
            }
        }
    }

    public final boolean k() {
        C0296p0 c0296p0;
        if (!f() || ((c0296p0 = (C0296p0) e.get(this)) != null && N.b.get(c0296p0) != 0)) {
            return false;
        }
        Object obj = d.get(this);
        if (obj != null) {
            if (obj instanceof u) {
                long j6 = u.f3945f.get((u) obj);
                return ((int) (1073741823 & j6)) == ((int) ((j6 & 1152921503533105152L) >> 30));
            }
            if (obj != AbstractC0303t0.CLOSED_EMPTY) {
                return false;
            }
        }
        return true;
    }

    public final void schedule(long j6, AbstractRunnableC0294o0 abstractRunnableC0294o0) {
        int iScheduleTask;
        Thread thread;
        int i5 = f956f.get(this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        if (i5 != 0) {
            iScheduleTask = 1;
        } else {
            C0296p0 c0296p0 = (C0296p0) atomicReferenceFieldUpdater.get(this);
            if (c0296p0 == null) {
                C0296p0 c0296p1 = new C0296p0();
                c0296p1.timeNow = j6;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, c0296p1) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                E.c(obj);
                c0296p0 = (C0296p0) obj;
            }
            iScheduleTask = abstractRunnableC0294o0.scheduleTask(j6, c0296p0, this);
        }
        if (iScheduleTask != 0) {
            if (iScheduleTask == 1) {
                reschedule(j6, abstractRunnableC0294o0);
                return;
            } else {
                if (iScheduleTask != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            }
        }
        C0296p0 c0296p2 = (C0296p0) atomicReferenceFieldUpdater.get(this);
        if ((c0296p2 != null ? (AbstractRunnableC0294o0) c0296p2.peek() : null) != abstractRunnableC0294o0 || Thread.currentThread() == (thread = getThread())) {
            return;
        }
        LockSupport.unpark(thread);
    }

    public final InterfaceC0280h0 scheduleInvokeOnTimeout(long j6, Runnable runnable) {
        int i5 = AbstractC0303t0.f958a;
        long j7 = 0;
        if (j6 > 0) {
            j7 = j6 >= 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : 1000000 * j6;
        }
        if (j7 >= 4611686018427387903L) {
            return C0271d1.INSTANCE;
        }
        long jNanoTime = System.nanoTime();
        C0292n0 c0292n0 = new C0292n0(j7 + jNanoTime, runnable);
        schedule(jNanoTime, c0292n0);
        return c0292n0;
    }

    @Override // p007a4.Y
    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public void mo1036scheduleResumeAfterDelay(long j6, InterfaceC0285k interfaceC0285k) {
        int i5 = AbstractC0303t0.f958a;
        long j7 = 0;
        if (j6 > 0) {
            j7 = j6 >= 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : 1000000 * j6;
        }
        if (j7 < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            C0290m0 c0290m0 = new C0290m0(this, j7 + jNanoTime, interfaceC0285k);
            schedule(jNanoTime, c0290m0);
            AbstractC0293o.disposeOnCancellation(interfaceC0285k, c0290m0);
        }
    }

    @Override // p007a4.AbstractC0288l0
    public void shutdown() {
        AbstractRunnableC0294o0 abstractRunnableC0294o0;
        p1.INSTANCE.getClass();
        p1.a();
        f956f.set(this, 1);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                H h6 = AbstractC0303t0.CLOSED_EMPTY;
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, h6)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == null);
            } else if (obj instanceof u) {
                ((u) obj).a();
                break;
            } else {
                if (obj == AbstractC0303t0.CLOSED_EMPTY) {
                    break;
                }
                u uVar = new u(8, true);
                uVar.addLast((Runnable) obj);
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, uVar)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj);
            }
        }
        while (g() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            C0296p0 c0296p0 = (C0296p0) e.get(this);
            if (c0296p0 == null || (abstractRunnableC0294o0 = (AbstractRunnableC0294o0) c0296p0.removeFirstOrNull()) == null) {
                return;
            } else {
                reschedule(jNanoTime, abstractRunnableC0294o0);
            }
        }
    }
}
