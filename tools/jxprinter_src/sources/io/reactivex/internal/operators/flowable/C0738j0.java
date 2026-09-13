package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.j0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0738j0 extends p088p3.l implements io.reactivex.S {
    private static final long serialVersionUID = -7346385463600070225L;
    public final AtomicReference e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public io.reactivex.V f4675f;

    public C0738j0(t5.c cVar, io.reactivex.V v6) {
        super(cVar);
        this.f4675f = v6;
        this.e = new AtomicReference();
    }

    @Override // p088p3.l, t5.d
    public final void cancel() {
        super.cancel();
        p033f3.d.a(this.e);
    }

    @Override // t5.c
    public final void onComplete() {
        this.b = p094q3.g.f7849a;
        io.reactivex.V v6 = this.f4675f;
        this.f4675f = null;
        ((io.reactivex.O) v6).subscribe(this);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f7750a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.d++;
        this.f7750a.onNext(obj);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.e, cVar);
    }
}
