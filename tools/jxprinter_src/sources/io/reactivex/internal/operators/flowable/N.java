package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N extends io.reactivex.O implements p043h3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0979l f4362a;
    public final Callable b;
    public final p027e3.b c;

    public N(AbstractC0979l abstractC0979l, Callable callable, p027e3.b bVar) {
        this.f4362a = abstractC0979l;
        this.b = callable;
        this.c = bVar;
    }

    @Override // p043h3.b
    public final AbstractC0979l c() {
        return io.reactivex.plugins.a.onAssembly(new D(this.f4362a, this.b, this.c, 2));
    }

    @Override // io.reactivex.O
    public final void subscribeActual(io.reactivex.S s6) {
        try {
            Object objCall = this.b.call();
            p039g3.A.b(objCall, "The initialSupplier returned a null value");
            this.f4362a.subscribe((InterfaceC0984q) new M(s6, objCall, this.c));
        } catch (Throwable th) {
            p033f3.e.f(th, s6);
        }
    }
}
