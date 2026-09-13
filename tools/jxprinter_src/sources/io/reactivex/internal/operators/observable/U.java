package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U extends AtomicReference implements io.reactivex.I, InterfaceC0988v, p011b3.c {
    private static final long serialVersionUID = -1953724749712440952L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5115a;
    public io.reactivex.y b;
    public boolean c;

    public U(io.reactivex.I i5, io.reactivex.y yVar) {
        this.f5115a = i5;
        this.b = yVar;
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
            this.f5115a.onComplete();
            return;
        }
        this.c = true;
        p033f3.d.c(this, null);
        io.reactivex.y yVar = this.b;
        this.b = null;
        ((AbstractC0985s) yVar).subscribe(this);
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5115a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5115a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (!p033f3.d.f(this, cVar) || this.c) {
            return;
        }
        this.f5115a.onSubscribe(this);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        io.reactivex.I i5 = this.f5115a;
        i5.onNext(obj);
        i5.onComplete();
    }
}
