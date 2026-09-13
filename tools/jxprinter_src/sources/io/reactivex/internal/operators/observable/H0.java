package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC0679f;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H0 extends AtomicReference implements InterfaceC0679f, p011b3.c {
    private static final long serialVersionUID = 8606673141535671828L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I0 f4954a;

    public H0(I0 i1) {
        this.f4954a = i1;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) get());
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        I0 i1 = this.f4954a;
        i1.e.delete(this);
        i1.onComplete();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        I0 i1 = this.f4954a;
        i1.e.delete(this);
        i1.onError(th);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
