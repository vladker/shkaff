package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC0978k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X0 implements InterfaceC0978k, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5128a;
    public final p027e3.g b;
    public Object c;
    public volatile boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5129f;

    public X0(io.reactivex.I i5, p027e3.c cVar, p027e3.g gVar, Object obj) {
        this.f5128a = i5;
        this.b = gVar;
        this.c = obj;
    }

    public final void a(Object obj) {
        try {
            this.b.accept(obj);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            io.reactivex.plugins.a.onError(th);
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        this.d = true;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d;
    }

    @Override // io.reactivex.InterfaceC0978k
    public final void onError(Throwable th) {
        if (this.e) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.e = true;
        this.f5128a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0978k
    public final void onNext(Object obj) {
        if (this.e) {
            return;
        }
        if (this.f5129f) {
            onError(new IllegalStateException("onNext already called in this generate turn"));
        } else if (obj == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.f5129f = true;
            this.f5128a.onNext(obj);
        }
    }
}
