package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0808v extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -5616169793639412593L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4805a;
    public final Callable b;
    public final int c;
    public final int d;
    public Collection e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t5.d f4806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4808h;

    public C0808v(t5.c cVar, int i5, int i6, Callable callable) {
        this.f4805a = cVar;
        this.c = i5;
        this.d = i6;
        this.b = callable;
    }

    @Override // t5.d
    public final void cancel() {
        this.f4806f.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4807g) {
            return;
        }
        this.f4807g = true;
        Collection collection = this.e;
        this.e = null;
        t5.c cVar = this.f4805a;
        if (collection != null) {
            cVar.onNext(collection);
        }
        cVar.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4807g) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4807g = true;
        this.e = null;
        this.f4805a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4807g) {
            return;
        }
        Collection collection = this.e;
        int i5 = this.f4808h;
        int i6 = i5 + 1;
        if (i5 == 0) {
            try {
                Object objCall = this.b.call();
                p039g3.A.b(objCall, "The bufferSupplier returned a null buffer");
                collection = (Collection) objCall;
                this.e = collection;
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                cancel();
                onError(th);
                return;
            }
        }
        if (collection != null) {
            collection.add(obj);
            if (collection.size() == this.c) {
                this.e = null;
                this.f4805a.onNext(collection);
            }
        }
        if (i6 == this.d) {
            i6 = 0;
        }
        this.f4808h = i6;
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4806f, dVar)) {
            this.f4806f = dVar;
            this.f4805a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            int i5 = get();
            int i6 = this.d;
            if (i5 != 0 || !compareAndSet(0, 1)) {
                this.f4806f.request(p122v2.a.d(i6, j6));
                return;
            }
            int i7 = this.c;
            this.f4806f.request(p122v2.a.c(p122v2.a.d(j6, i7), p122v2.a.d(i6 - i7, j6 - 1)));
        }
    }
}
