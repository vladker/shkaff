package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.ArrayDeque;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.h4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0730h4 extends ArrayDeque implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -3807491841935125653L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4655a;
    public final int b;
    public t5.d c;

    public C0730h4(t5.c cVar, int i5) {
        super(i5);
        this.f4655a = cVar;
        this.b = i5;
    }

    @Override // t5.d
    public final void cancel() {
        this.c.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4655a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4655a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.b == size()) {
            this.f4655a.onNext(poll());
        } else {
            this.c.request(1L);
        }
        offer(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.c, dVar)) {
            this.c = dVar;
            this.f4655a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.c.request(j6);
    }
}
