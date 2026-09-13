package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0844b0 extends AtomicReference implements io.reactivex.D, p011b3.c {
    private static final long serialVersionUID = -3434801548987643227L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5146a;

    public C0844b0(io.reactivex.I i5) {
        this.f5146a = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) get());
    }

    @Override // io.reactivex.D, io.reactivex.InterfaceC0978k
    public final void onError(Throwable th) {
        if (tryOnError(th)) {
            return;
        }
        io.reactivex.plugins.a.onError(th);
    }

    @Override // io.reactivex.D, io.reactivex.InterfaceC0978k
    public final void onNext(Object obj) {
        if (obj == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            if (e()) {
                return;
            }
            this.f5146a.onNext(obj);
        }
    }

    @Override // io.reactivex.D
    public final io.reactivex.D serialize() {
        return new C0849c0(this);
    }

    @Override // io.reactivex.D
    public final void setCancellable(p027e3.f fVar) {
        p033f3.d.d(this, new p033f3.b(null));
    }

    @Override // io.reactivex.D
    public final void setDisposable(p011b3.c cVar) {
        p033f3.d.d(this, cVar);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        return androidx.exifinterface.media.a.A(C0844b0.class.getSimpleName(), VectorFormat.DEFAULT_PREFIX, super.toString(), VectorFormat.DEFAULT_SUFFIX);
    }

    @Override // io.reactivex.D
    public final boolean tryOnError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (e()) {
            return false;
        }
        try {
            this.f5146a.onError(th);
            return true;
        } finally {
            p033f3.d.a(this);
        }
    }
}
