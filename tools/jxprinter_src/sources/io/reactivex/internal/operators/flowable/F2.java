package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F2 extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = -2935427570954647017L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G2 f4231a;

    public F2(G2 g6) {
        this.f4231a = g6;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        G2 g6 = this.f4231a;
        g6.f4261l = 2;
        if (g6.getAndIncrement() == 0) {
            g6.a();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        G2 g6 = this.f4231a;
        p100r3.c cVar = g6.d;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p094q3.g.a(g6.b);
        if (g6.getAndIncrement() == 0) {
            g6.a();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        G2 g6 = this.f4231a;
        if (g6.compareAndSet(0, 1)) {
            long j6 = g6.f4262m;
            if (g6.e.get() != j6) {
                g6.f4262m = j6 + 1;
                g6.f4254a.onNext(obj);
                g6.f4261l = 2;
            } else {
                g6.f4258i = obj;
                g6.f4261l = 1;
                if (g6.decrementAndGet() == 0) {
                    return;
                }
            }
        } else {
            g6.f4258i = obj;
            g6.f4261l = 1;
            if (g6.getAndIncrement() != 0) {
                return;
            }
        }
        g6.a();
    }
}
