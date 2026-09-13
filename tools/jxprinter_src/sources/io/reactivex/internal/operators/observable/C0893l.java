package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0893l extends AtomicReference implements io.reactivex.I {
    private static final long serialVersionUID = -1185974347409665484L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0888k f5228a;
    public final int b;
    public final io.reactivex.I c;
    public boolean d;

    public C0893l(C0888k c0888k, int i5, io.reactivex.I i6) {
        this.f5228a = c0888k;
        this.b = i5;
        this.c = i6;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        boolean z6 = this.d;
        io.reactivex.I i5 = this.c;
        if (z6) {
            i5.onComplete();
        } else if (this.f5228a.a(this.b)) {
            this.d = true;
            i5.onComplete();
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        boolean z6 = this.d;
        io.reactivex.I i5 = this.c;
        if (z6) {
            i5.onError(th);
        } else if (!this.f5228a.a(this.b)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.d = true;
            i5.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        boolean z6 = this.d;
        io.reactivex.I i5 = this.c;
        if (z6) {
            i5.onNext(obj);
        } else if (!this.f5228a.a(this.b)) {
            ((p011b3.c) get()).dispose();
        } else {
            this.d = true;
            i5.onNext(obj);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
