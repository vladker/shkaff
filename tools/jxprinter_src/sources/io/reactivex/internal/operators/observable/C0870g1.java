package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.g1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0870g1 extends AtomicReference implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 1883890389173668373L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f5192a;
    public final boolean b;

    /* JADX WARN: Multi-variable type inference failed */
    public C0870g1(InterfaceC0860e1 interfaceC0860e1, boolean z6) {
        this.f5192a = (AtomicInteger) interfaceC0860e1;
        this.b = z6;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) get());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.internal.operators.observable.e1, java.util.concurrent.atomic.AtomicInteger] */
    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5192a.f(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.internal.operators.observable.e1, java.util.concurrent.atomic.AtomicInteger] */
    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5192a.a(th);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.internal.operators.observable.e1, java.util.concurrent.atomic.AtomicInteger] */
    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5192a.c(obj, this.b);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
