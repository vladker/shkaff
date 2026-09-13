package io.reactivex.internal.operators.observable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0863f extends p112t3.c {
    public final ArrayBlockingQueue b = new ArrayBlockingQueue(1);
    public final AtomicInteger c = new AtomicInteger();

    @Override // p112t3.c, io.reactivex.I
    public final void onError(Throwable th) {
        io.reactivex.plugins.a.onError(th);
    }

    @Override // p112t3.c, io.reactivex.I
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

    @Override // io.reactivex.I
    public final void onComplete() {
    }
}
