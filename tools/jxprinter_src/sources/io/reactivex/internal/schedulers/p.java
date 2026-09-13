package io.reactivex.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends io.reactivex.M {
    public final RunnableC0976o b;
    public final q c;
    public final AtomicBoolean d = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p011b3.b f5359a = new p011b3.b();

    public p(RunnableC0976o runnableC0976o) {
        q qVar;
        q qVar2;
        this.b = runnableC0976o;
        if (runnableC0976o.c.b) {
            qVar2 = r.f5361g;
        } else {
            do {
                if (runnableC0976o.b.isEmpty()) {
                    qVar = new q(runnableC0976o.f5358f);
                    runnableC0976o.c.add(qVar);
                    break;
                }
                qVar = (q) runnableC0976o.b.poll();
            } while (qVar == null);
            qVar2 = qVar;
        }
        this.c = qVar2;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.d.compareAndSet(false, true)) {
            this.f5359a.dispose();
            RunnableC0976o runnableC0976o = this.b;
            runnableC0976o.getClass();
            long jNanoTime = System.nanoTime() + runnableC0976o.f5357a;
            q qVar = this.c;
            qVar.c = jNanoTime;
            runnableC0976o.b.offer(qVar);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d.get();
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        return this.f5359a.b ? p033f3.e.f3970a : this.c.scheduleActual(runnable, j6, timeUnit, this.f5359a);
    }
}
