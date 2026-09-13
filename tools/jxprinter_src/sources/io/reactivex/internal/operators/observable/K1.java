package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K1 extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = -2935427570954647017L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L1 f4999a;

    public K1(L1 l6) {
        this.f4999a = l6;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        L1 l6 = this.f4999a;
        l6.f5010i = 2;
        if (l6.getAndIncrement() == 0) {
            l6.a();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        L1 l6 = this.f4999a;
        p100r3.c cVar = l6.d;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p033f3.d.a(l6.b);
        if (l6.getAndIncrement() == 0) {
            l6.a();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        L1 l6 = this.f4999a;
        if (l6.compareAndSet(0, 1)) {
            l6.f5006a.onNext(obj);
            l6.f5010i = 2;
        } else {
            l6.f5007f = obj;
            l6.f5010i = 1;
            if (l6.getAndIncrement() != 0) {
                return;
            }
        }
        l6.a();
    }
}
