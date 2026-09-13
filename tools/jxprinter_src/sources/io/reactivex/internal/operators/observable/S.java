package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S extends AtomicReference implements io.reactivex.I, InterfaceC0679f, p011b3.c {
    private static final long serialVersionUID = -1953724749712440952L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5100a;
    public InterfaceC0682i b;
    public boolean c;

    public S(io.reactivex.I i5, InterfaceC0682i interfaceC0682i) {
        this.f5100a = i5;
        this.b = interfaceC0682i;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.c) {
            this.f5100a.onComplete();
            return;
        }
        this.c = true;
        p033f3.d.c(this, null);
        InterfaceC0682i interfaceC0682i = this.b;
        this.b = null;
        ((AbstractC0676c) interfaceC0682i).subscribe(this);
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5100a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5100a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (!p033f3.d.f(this, cVar) || this.c) {
            return;
        }
        this.f5100a.onSubscribe(this);
    }
}
