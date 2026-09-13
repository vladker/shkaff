package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B extends p135x3.a {
    public final /* synthetic */ int b;
    public boolean c;
    public final Object d;

    public /* synthetic */ B(Object obj, int i5) {
        this.b = i5;
        this.d = obj;
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.b) {
            case 0:
                if (!this.c) {
                    this.c = true;
                    ((C) this.d).u();
                    break;
                }
                break;
            case 1:
                if (!this.c) {
                    this.c = true;
                    W4 w6 = (W4) this.d;
                    p094q3.g.a(w6.d);
                    w6.f4499j = true;
                    w6.a();
                    break;
                }
                break;
            default:
                if (!this.c) {
                    this.c = true;
                    c5 c5Var = (c5) this.d;
                    c5Var.f4588j.cancel();
                    c5Var.f4589k = true;
                    c5Var.b();
                    break;
                }
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.b) {
            case 0:
                if (!this.c) {
                    this.c = true;
                    ((C) this.d).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            case 1:
                if (!this.c) {
                    this.c = true;
                    W4 w6 = (W4) this.d;
                    p094q3.g.a(w6.d);
                    p100r3.c cVar = w6.f4496g;
                    cVar.getClass();
                    if (!p100r3.g.a(cVar, th)) {
                        io.reactivex.plugins.a.onError(th);
                    } else {
                        w6.f4499j = true;
                        w6.a();
                    }
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.c) {
                    this.c = true;
                    c5 c5Var = (c5) this.d;
                    c5Var.f4588j.cancel();
                    p100r3.c cVar2 = c5Var.f4584f;
                    cVar2.getClass();
                    if (!p100r3.g.a(cVar2, th)) {
                        io.reactivex.plugins.a.onError(th);
                    } else {
                        c5Var.f4589k = true;
                        c5Var.b();
                    }
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.b) {
            case 0:
                if (!this.c) {
                    this.c = true;
                    dispose();
                    ((C) this.d).u();
                    break;
                }
                break;
            case 1:
                if (!this.c) {
                    ((W4) this.d).b();
                    break;
                }
                break;
            default:
                if (!this.c) {
                    this.c = true;
                    dispose();
                    c5 c5Var = (c5) this.d;
                    AtomicReference atomicReference = c5Var.c;
                    while (!atomicReference.compareAndSet(this, null) && atomicReference.get() == this) {
                    }
                    c5Var.e.offer(c5.f4582o);
                    c5Var.b();
                    break;
                }
                break;
        }
    }
}
