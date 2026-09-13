package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M1 extends AtomicReference implements io.reactivex.S {
    private static final long serialVersionUID = -2935427570954647017L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N1 f5029a;

    public M1(N1 n6) {
        this.f5029a = n6;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        N1 n6 = this.f5029a;
        p100r3.c cVar = n6.d;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p033f3.d.a(n6.b);
        if (n6.getAndIncrement() == 0) {
            n6.a();
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        N1 n6 = this.f5029a;
        if (n6.compareAndSet(0, 1)) {
            n6.f5037a.onNext(obj);
            n6.f5041i = 2;
        } else {
            n6.f5038f = obj;
            n6.f5041i = 1;
            if (n6.getAndIncrement() != 0) {
                return;
            }
        }
        n6.a();
    }
}
