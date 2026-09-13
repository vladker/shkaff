package io.reactivex.internal.operators.observable;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.w0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0947w0 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5301a;
    public final long b;
    public final Object c;
    public final boolean d;
    public p011b3.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5303g;

    public C0947w0(io.reactivex.I i5, long j6, Object obj, boolean z6) {
        this.f5301a = i5;
        this.b = j6;
        this.c = obj;
        this.d = z6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.e.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.e.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.f5303g) {
            return;
        }
        this.f5303g = true;
        io.reactivex.I i5 = this.f5301a;
        Object obj = this.c;
        if (obj == null && this.d) {
            i5.onError(new NoSuchElementException());
            return;
        }
        if (obj != null) {
            i5.onNext(obj);
        }
        i5.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.f5303g) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f5303g = true;
            this.f5301a.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f5303g) {
            return;
        }
        long j6 = this.f5302f;
        if (j6 != this.b) {
            this.f5302f = j6 + 1;
            return;
        }
        this.f5303g = true;
        this.e.dispose();
        io.reactivex.I i5 = this.f5301a;
        i5.onNext(obj);
        i5.onComplete();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.e, cVar)) {
            this.e = cVar;
            this.f5301a.onSubscribe(this);
        }
    }
}
