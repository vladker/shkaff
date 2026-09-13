package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.r4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0789r4 implements InterfaceC0984q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4760a;
    public final t5.b b;
    public boolean d = true;
    public final p094q3.f c = new p094q3.f(false);

    public C0789r4(t5.c cVar, t5.b bVar) {
        this.f4760a = cVar;
        this.b = bVar;
    }

    @Override // t5.c
    public final void onComplete() {
        if (!this.d) {
            this.f4760a.onComplete();
        } else {
            this.d = false;
            this.b.subscribe(this);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4760a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.d) {
            this.d = false;
        }
        this.f4760a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        this.c.e(dVar);
    }
}
