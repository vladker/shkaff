package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC0988v;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.y0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0955y0 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5311a;
    public final long b;
    public p011b3.c c;
    public long d;
    public boolean e;

    public C0955y0(InterfaceC0988v interfaceC0988v, long j6) {
        this.f5311a = interfaceC0988v;
        this.b = j6;
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
        if (this.e) {
            return;
        }
        this.e = true;
        this.f5311a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.e) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.e = true;
            this.f5311a.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.e) {
            return;
        }
        long j6 = this.d;
        if (j6 != this.b) {
            this.d = j6 + 1;
            return;
        }
        this.e = true;
        this.c.dispose();
        this.f5311a.onSuccess(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            this.f5311a.onSubscribe(this);
        }
    }
}
