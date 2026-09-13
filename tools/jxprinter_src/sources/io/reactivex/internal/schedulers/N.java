package io.reactivex.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N extends io.reactivex.M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityBlockingQueue f5344a = new PriorityBlockingQueue();
    public final AtomicInteger b = new AtomicInteger();
    public final AtomicInteger c = new AtomicInteger();
    public volatile boolean d;

    public final p011b3.c a(Runnable runnable, long j6) {
        p033f3.e eVar = p033f3.e.f3970a;
        if (!this.d) {
            M m6 = new M(runnable, Long.valueOf(j6), this.c.incrementAndGet());
            this.f5344a.add(m6);
            if (this.b.getAndIncrement() != 0) {
                return p011b3.d.fromRunnable(new Q0.b(this, 21, m6, false));
            }
            int iAddAndGet = 1;
            while (!this.d) {
                M m7 = (M) this.f5344a.poll();
                if (m7 == null) {
                    iAddAndGet = this.b.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                    }
                } else if (!m7.d) {
                    m7.f5343a.run();
                }
            }
            this.f5344a.clear();
            return eVar;
        }
        return eVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.d = true;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d;
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable) {
        return a(runnable, now(TimeUnit.MILLISECONDS));
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        long millis = timeUnit.toMillis(j6) + now(TimeUnit.MILLISECONDS);
        return a(new L(runnable, this, millis), millis);
    }
}
