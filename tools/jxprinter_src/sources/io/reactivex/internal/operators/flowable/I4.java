package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I4 implements InterfaceC0984q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4295a;
    public final p094q3.f b;

    public I4(t5.c cVar, p094q3.f fVar) {
        this.f4295a = cVar;
        this.b = fVar;
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4295a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4295a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4295a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        this.b.e(dVar);
    }
}
