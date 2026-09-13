package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0932t extends AtomicReference implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -8498650778633225126L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0927s f5281a;
    public final long b;

    public C0932t(C0927s c0927s, long j6) {
        this.f5281a = c0927s;
        this.b = j6;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == p033f3.d.f3969a;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        Object obj = get();
        p033f3.d dVar = p033f3.d.f3969a;
        if (obj != dVar) {
            lazySet(dVar);
            this.f5281a.a(this, this.b);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        Object obj = get();
        p033f3.d dVar = p033f3.d.f3969a;
        if (obj == dVar) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        lazySet(dVar);
        C0927s c0927s = this.f5281a;
        p033f3.d.a(c0927s.f5270f);
        c0927s.e.delete(this);
        c0927s.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        p011b3.c cVar = (p011b3.c) get();
        p033f3.d dVar = p033f3.d.f3969a;
        if (cVar != dVar) {
            lazySet(dVar);
            cVar.dispose();
            this.f5281a.a(this, this.b);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
