package io.reactivex.internal.operators.observable;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class R2 extends ArrayDeque implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -3807491841935125653L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5099a;
    public final int b;
    public p011b3.c c;

    public R2(io.reactivex.I i5, int i6) {
        super(i6);
        this.f5099a = i5;
        this.b = i6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.c.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5099a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5099a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.b == size()) {
            this.f5099a.onNext(poll());
        }
        offer(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            this.f5099a.onSubscribe(this);
        }
    }
}
