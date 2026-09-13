package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G1 implements io.reactivex.I, t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4253a;
    public p011b3.c b;

    public G1(t5.c cVar) {
        this.f4253a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        this.b.dispose();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f4253a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f4253a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f4253a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        this.b = cVar;
        this.f4253a.onSubscribe(this);
    }

    @Override // t5.d
    public final void request(long j6) {
    }
}
