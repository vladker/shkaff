package io.reactivex.internal.operators.observable;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A0 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.S f4861a;
    public final long b;
    public final Object c;
    public p011b3.c d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4862f;

    public A0(io.reactivex.S s6, long j6, Object obj) {
        this.f4861a = s6;
        this.b = j6;
        this.c = obj;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.d.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.f4862f) {
            return;
        }
        this.f4862f = true;
        io.reactivex.S s6 = this.f4861a;
        Object obj = this.c;
        if (obj != null) {
            s6.onSuccess(obj);
        } else {
            s6.onError(new NoSuchElementException());
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.f4862f) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4862f = true;
            this.f4861a.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f4862f) {
            return;
        }
        long j6 = this.e;
        if (j6 != this.b) {
            this.e = j6 + 1;
            return;
        }
        this.f4862f = true;
        this.d.dispose();
        this.f4861a.onSuccess(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.d, cVar)) {
            this.d = cVar;
            this.f4861a.onSubscribe(this);
        }
    }
}
