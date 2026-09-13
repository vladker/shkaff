package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.l3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0897l3 extends AtomicReference implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 8708641127342403073L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5232a;
    public final long b;

    public C0897l3(long j6, InterfaceC0912o3 interfaceC0912o3) {
        this.b = j6;
        this.f5232a = interfaceC0912o3;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) get());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.internal.operators.observable.r3, java.lang.Object] */
    @Override // io.reactivex.I
    public final void onComplete() {
        Object obj = get();
        p033f3.d dVar = p033f3.d.f3969a;
        if (obj != dVar) {
            lazySet(dVar);
            this.f5232a.b(this.b);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.internal.operators.observable.o3, java.lang.Object] */
    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        Object obj = get();
        p033f3.d dVar = p033f3.d.f3969a;
        if (obj == dVar) {
            io.reactivex.plugins.a.onError(th);
        } else {
            lazySet(dVar);
            this.f5232a.a(this.b, th);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [io.reactivex.internal.operators.observable.r3, java.lang.Object] */
    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        p011b3.c cVar = (p011b3.c) get();
        p033f3.d dVar = p033f3.d.f3969a;
        if (cVar != dVar) {
            cVar.dispose();
            lazySet(dVar);
            this.f5232a.b(this.b);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
