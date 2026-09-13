package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.c3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0699c3 implements InterfaceC0984q, t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4579a;
    public final C0687a3 b;
    public t5.d c;

    public C0699c3(t5.c cVar, C0687a3 c0687a3) {
        this.f4579a = cVar;
        this.b = c0687a3;
    }

    @Override // t5.d
    public final void cancel() {
        this.c.cancel();
        this.b.dispose();
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4579a.onComplete();
        this.b.dispose();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4579a.onError(th);
        this.b.dispose();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4579a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.c, dVar)) {
            this.c = dVar;
            this.f4579a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.c.request(j6);
    }
}
