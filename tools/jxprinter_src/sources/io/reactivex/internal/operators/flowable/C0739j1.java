package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0679f;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.j1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0739j1 extends AtomicReference implements InterfaceC0679f, p011b3.c {
    private static final long serialVersionUID = 8606673141535671828L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0745k1 f4676a;

    public C0739j1(C0745k1 c0745k1) {
        this.f4676a = c0745k1;
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
        C0745k1 c0745k1 = this.f4676a;
        c0745k1.e.delete(this);
        c0745k1.onComplete();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        C0745k1 c0745k1 = this.f4676a;
        c0745k1.e.delete(this);
        c0745k1.onError(th);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
