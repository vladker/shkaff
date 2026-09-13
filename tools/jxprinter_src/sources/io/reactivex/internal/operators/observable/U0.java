package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U0 extends io.reactivex.B implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f5116a;

    public U0(Callable callable) {
        this.f5116a = callable;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        p048i3.k kVar = new p048i3.k(i5);
        i5.onSubscribe(kVar);
        if (kVar.e()) {
            return;
        }
        try {
            Object objCall = this.f5116a.call();
            p039g3.A.b(objCall, "Callable returned null");
            kVar.a(objCall);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            if (kVar.e()) {
                io.reactivex.plugins.a.onError(th);
            } else {
                i5.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        Object objCall = this.f5116a.call();
        p039g3.A.b(objCall, "The callable returned a null value");
        return objCall;
    }
}
