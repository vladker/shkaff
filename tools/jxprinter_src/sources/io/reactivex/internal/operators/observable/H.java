package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H extends io.reactivex.O implements p043h3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.B f4953a;
    public final Callable b;
    public final p027e3.b c;

    public H(io.reactivex.B b, Callable callable, p027e3.b bVar) {
        this.f4953a = b;
        this.b = callable;
        this.c = bVar;
    }

    @Override // p043h3.d
    public final io.reactivex.B b() {
        return io.reactivex.plugins.a.onAssembly(new C0950x(this.f4953a, this.b, this.c, 2));
    }

    @Override // io.reactivex.O
    public final void subscribeActual(io.reactivex.S s6) {
        try {
            Object objCall = this.b.call();
            p039g3.A.b(objCall, "The initialSupplier returned a null value");
            this.f4953a.subscribe(new G(s6, objCall, this.c, 1));
        } catch (Throwable th) {
            p033f3.e.f(th, s6);
        }
    }
}
