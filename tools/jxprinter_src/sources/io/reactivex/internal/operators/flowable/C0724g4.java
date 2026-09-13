package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.g4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0724g4 implements InterfaceC0984q, t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4633a;
    public long b;
    public t5.d c;

    public C0724g4(t5.c cVar, long j6) {
        this.f4633a = cVar;
        this.b = j6;
    }

    @Override // t5.d
    public final void cancel() {
        this.c.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4633a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4633a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        long j6 = this.b;
        if (j6 != 0) {
            this.b = j6 - 1;
        } else {
            this.f4633a.onNext(obj);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.c, dVar)) {
            long j6 = this.b;
            this.c = dVar;
            this.f4633a.onSubscribe(this);
            dVar.request(j6);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.c.request(j6);
    }
}
