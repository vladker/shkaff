package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0942v extends p112t3.c {
    public final /* synthetic */ int b;
    public boolean c;
    public final Object d;

    public /* synthetic */ C0942v(Object obj, int i5) {
        this.b = i5;
        this.d = obj;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.b) {
            case 0:
                if (!this.c) {
                    this.c = true;
                    ((C0946w) this.d).h();
                    break;
                }
                break;
            case 1:
                if (!this.c) {
                    this.c = true;
                    A3 a6 = (A3) this.d;
                    p033f3.d.a(a6.d);
                    a6.f4870i = true;
                    a6.a();
                    break;
                }
                break;
            default:
                if (!this.c) {
                    this.c = true;
                    G3 g6 = (G3) this.d;
                    g6.f4950i.dispose();
                    g6.f4951j = true;
                    g6.b();
                    break;
                }
                break;
        }
    }

    @Override // p112t3.c, io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.b) {
            case 0:
                if (!this.c) {
                    this.c = true;
                    ((C0946w) this.d).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            case 1:
                if (!this.c) {
                    this.c = true;
                    A3 a6 = (A3) this.d;
                    p033f3.d.a(a6.d);
                    p100r3.c cVar = a6.f4868g;
                    cVar.getClass();
                    if (!p100r3.g.a(cVar, th)) {
                        io.reactivex.plugins.a.onError(th);
                    } else {
                        a6.f4870i = true;
                        a6.a();
                    }
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.c) {
                    this.c = true;
                    G3 g6 = (G3) this.d;
                    g6.f4950i.dispose();
                    p100r3.c cVar2 = g6.f4947f;
                    cVar2.getClass();
                    if (!p100r3.g.a(cVar2, th)) {
                        io.reactivex.plugins.a.onError(th);
                    } else {
                        g6.f4951j = true;
                        g6.b();
                    }
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // p112t3.c, io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.b) {
            case 0:
                if (!this.c) {
                    this.c = true;
                    dispose();
                    ((C0946w) this.d).h();
                    break;
                }
                break;
            case 1:
                if (!this.c) {
                    ((A3) this.d).b();
                    break;
                }
                break;
            default:
                if (!this.c) {
                    this.c = true;
                    dispose();
                    G3 g6 = (G3) this.d;
                    AtomicReference atomicReference = g6.c;
                    while (!atomicReference.compareAndSet(this, null) && atomicReference.get() == this) {
                    }
                    g6.e.offer(G3.f4945m);
                    g6.b();
                    break;
                }
                break;
        }
    }
}
