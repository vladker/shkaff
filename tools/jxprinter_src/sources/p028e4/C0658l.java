package p028e4;

import A3.AbstractC0157z;
import E3.g;
import E3.q;
import E3.r;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p007a4.F;
import p007a4.InterfaceC0280h0;
import p007a4.InterfaceC0285k;
import p007a4.J;
import p007a4.U;
import p007a4.Y;
import p147z3.Q;

/* JADX INFO: renamed from: e4.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0658l extends F implements Y {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(C0658l.class, "runningWorkers$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y f3941a;
    public final int b;
    private final F dispatcher;
    private final String name;
    private final r queue;
    private volatile /* synthetic */ int runningWorkers$volatile;
    private final Object workerAllocationLock;

    /* JADX INFO: renamed from: e4.l$a */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class a implements Runnable {
        private Runnable currentTask;

        public a(Runnable runnable) {
            this.currentTask = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i5 = 0;
            while (true) {
                try {
                    this.currentTask.run();
                } catch (Throwable th) {
                    J.handleCoroutineException(r.INSTANCE, th);
                }
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C0658l.c;
                C0658l c0658l = C0658l.this;
                Runnable runnableC = c0658l.c();
                if (runnableC == null) {
                    return;
                }
                this.currentTask = runnableC;
                i5++;
                if (i5 >= 16 && c0658l.dispatcher.isDispatchNeeded(c0658l)) {
                    c0658l.dispatcher.mo1035dispatch(c0658l, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0658l(F f6, int i5, String str) {
        Y y6 = f6 instanceof Y ? (Y) f6 : null;
        this.f3941a = y6 == null ? U.getDefaultDelay() : y6;
        this.dispatcher = f6;
        this.b = i5;
        this.name = str;
        this.queue = new r();
        this.workerAllocationLock = new Object();
    }

    public final Runnable c() {
        while (true) {
            Runnable runnable = (Runnable) this.queue.removeFirstOrNull();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.workerAllocationLock) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.queue.b() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean d() {
        synchronized (this.workerAllocationLock) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c;
            if (atomicIntegerFieldUpdater.get(this) >= this.b) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // p007a4.Y
    public Object delay(long j6, g<? super Q> gVar) {
        return this.f3941a.delay(j6, gVar);
    }

    @Override // p007a4.F
    /* JADX INFO: renamed from: dispatch */
    public void mo1035dispatch(q qVar, Runnable runnable) {
        Runnable runnableC;
        this.queue.addLast(runnable);
        if (c.get(this) >= this.b || !d() || (runnableC = c()) == null) {
            return;
        }
        this.dispatcher.mo1035dispatch(this, new a(runnableC));
    }

    @Override // p007a4.F
    public void dispatchYield(q qVar, Runnable runnable) {
        Runnable runnableC;
        this.queue.addLast(runnable);
        if (c.get(this) >= this.b || !d() || (runnableC = c()) == null) {
            return;
        }
        this.dispatcher.dispatchYield(this, new a(runnableC));
    }

    @Override // p007a4.Y
    public InterfaceC0280h0 invokeOnTimeout(long j6, Runnable runnable, q qVar) {
        return this.f3941a.invokeOnTimeout(j6, runnable, qVar);
    }

    @Override // p007a4.F
    public F limitedParallelism(int i5, String str) {
        AbstractC0659m.a(i5);
        return i5 >= this.b ? AbstractC0659m.namedOrThis(this, str) : super.limitedParallelism(i5, str);
    }

    @Override // p007a4.Y
    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public void mo1036scheduleResumeAfterDelay(long j6, InterfaceC0285k interfaceC0285k) {
        this.f3941a.mo1036scheduleResumeAfterDelay(j6, interfaceC0285k);
    }

    @Override // p007a4.F
    public String toString() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.dispatcher);
        sb.append(".limitedParallelism(");
        return AbstractC0157z.p(sb, this.b, ')');
    }
}
