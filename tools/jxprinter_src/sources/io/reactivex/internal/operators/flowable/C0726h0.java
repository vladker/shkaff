package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.h0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0726h0 extends p088p3.l implements InterfaceC0988v {
    private static final long serialVersionUID = -7346385463600070225L;
    public final AtomicReference e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public io.reactivex.y f4636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4637g;

    public C0726h0(t5.c cVar, io.reactivex.y yVar) {
        super(cVar);
        this.f4636f = yVar;
        this.e = new AtomicReference();
    }

    @Override // p088p3.l, t5.d
    public final void cancel() {
        super.cancel();
        p033f3.d.a(this.e);
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4637g) {
            this.f7750a.onComplete();
            return;
        }
        this.f4637g = true;
        this.b = p094q3.g.f7849a;
        io.reactivex.y yVar = this.f4636f;
        this.f4636f = null;
        ((AbstractC0985s) yVar).subscribe(this);
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

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.e, cVar);
    }
}
