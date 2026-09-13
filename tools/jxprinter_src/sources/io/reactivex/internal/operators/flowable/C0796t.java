package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0796t implements InterfaceC0984q, t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4766a;
    public final Callable b;
    public final int c;
    public Collection d;
    public t5.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4768g;

    public C0796t(t5.c cVar, int i5, Callable callable) {
        this.f4766a = cVar;
        this.c = i5;
        this.b = callable;
    }

    @Override // t5.d
    public final void cancel() {
        this.e.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4767f) {
            return;
        }
        this.f4767f = true;
        Collection collection = this.d;
        t5.c cVar = this.f4766a;
        if (collection != null && !collection.isEmpty()) {
            cVar.onNext(collection);
        }
        cVar.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4767f) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4767f = true;
            this.f4766a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4767f) {
            return;
        }
        Collection collection = this.d;
        if (collection == null) {
            try {
                Object objCall = this.b.call();
                p039g3.A.b(objCall, "The bufferSupplier returned a null buffer");
                collection = (Collection) objCall;
                this.d = collection;
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                cancel();
                onError(th);
                return;
            }
        }
        collection.add(obj);
        int i5 = this.f4768g + 1;
        if (i5 != this.c) {
            this.f4768g = i5;
            return;
        }
        this.f4768g = 0;
        this.d = null;
        this.f4766a.onNext(collection);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.e, dVar)) {
            this.e = dVar;
            this.f4766a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            this.e.request(p122v2.a.d(j6, this.c));
        }
    }
}
