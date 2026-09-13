package io.reactivex.internal.operators.flowable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0737j extends p135x3.a {
    public final ArrayBlockingQueue b = new ArrayBlockingQueue(1);
    public final AtomicInteger c = new AtomicInteger();

    @Override // t5.c
    public final void onError(Throwable th) {
        io.reactivex.plugins.a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        io.reactivex.A a6 = (io.reactivex.A) obj;
        if (this.c.getAndSet(0) != 1 && a6.a()) {
            return;
        }
        while (true) {
            ArrayBlockingQueue arrayBlockingQueue = this.b;
            if (arrayBlockingQueue.offer(a6)) {
                return;
            }
            io.reactivex.A a7 = (io.reactivex.A) arrayBlockingQueue.poll();
            if (a7 != null && !a7.a()) {
                a6 = a7;
            }
        }
    }

    public io.reactivex.A takeNext() {
        this.c.set(1);
        return (io.reactivex.A) this.b.take();
    }

    @Override // t5.c
    public final void onComplete() {
    }
}
