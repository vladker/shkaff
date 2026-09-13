package io.reactivex.internal.operators.observable;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0946w extends p048i3.s implements p011b3.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5295g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Callable f5296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p011b3.c f5297i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Collection f5298j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f5299k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Object f5300l;

    public C0946w(p112t3.e eVar, Callable callable, io.reactivex.G g6) {
        super(eVar, new p083o3.b());
        this.f5296h = callable;
        this.f5299k = g6;
    }

    @Override // p048i3.s
    public final void b(io.reactivex.I i5, Object obj) {
        switch (this.f5295g) {
            case 0:
                this.b.onNext((Collection) obj);
                break;
            default:
                this.b.onNext((Collection) obj);
                break;
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5295g) {
            case 0:
                if (!this.d) {
                    this.d = true;
                    this.f5297i.dispose();
                    p033f3.d.a((AtomicReference) this.f5300l);
                    if (c()) {
                        this.c.clear();
                    }
                }
                break;
            default:
                if (!this.d) {
                    this.d = true;
                    ((C0954y) this.f5300l).dispose();
                    this.f5297i.dispose();
                    if (c()) {
                        this.c.clear();
                    }
                }
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5295g) {
            case 0:
                break;
        }
        return this.d;
    }

    public void h() {
        try {
            Object objCall = this.f5296h.call();
            p039g3.A.b(objCall, "The buffer supplied is null");
            Collection collection = (Collection) objCall;
            try {
                Object objCall2 = ((Callable) this.f5299k).call();
                p039g3.A.b(objCall2, "The boundary ObservableSource supplied is null");
                io.reactivex.G g6 = (io.reactivex.G) objCall2;
                C0942v c0942v = new C0942v(this, 0);
                if (p033f3.d.c((AtomicReference) this.f5300l, c0942v)) {
                    synchronized (this) {
                        try {
                            Collection collection2 = this.f5298j;
                            if (collection2 == null) {
                                return;
                            }
                            this.f5298j = collection;
                            g6.subscribe(c0942v);
                            f(collection2, this);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                this.d = true;
                this.f5297i.dispose();
                this.b.onError(th2);
            }
        } catch (Throwable th3) {
            p017c3.d.throwIfFatal(th3);
            dispose();
            this.b.onError(th3);
        }
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f5295g) {
            case 0:
                synchronized (this) {
                    try {
                        Collection collection = this.f5298j;
                        if (collection == null) {
                            return;
                        }
                        this.f5298j = null;
                        this.c.offer(collection);
                        this.e = true;
                        if (c()) {
                            com.bumptech.glide.f.c(this.c, this.b, this, this);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            default:
                synchronized (this) {
                    try {
                        Collection collection2 = this.f5298j;
                        if (collection2 == null) {
                            return;
                        }
                        this.f5298j = null;
                        this.c.offer(collection2);
                        this.e = true;
                        if (c()) {
                            com.bumptech.glide.f.c(this.c, this.b, this, this);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
        }
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f5295g) {
            case 0:
                dispose();
                this.b.onError(th);
                break;
            default:
                dispose();
                this.b.onError(th);
                break;
        }
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f5295g) {
            case 0:
                synchronized (this) {
                    try {
                        Collection collection = this.f5298j;
                        if (collection == null) {
                            return;
                        }
                        collection.add(obj);
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            default:
                synchronized (this) {
                    try {
                        Collection collection2 = this.f5298j;
                        if (collection2 == null) {
                            return;
                        }
                        collection2.add(obj);
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
        }
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5295g) {
            case 0:
                if (p033f3.d.g(this.f5297i, cVar)) {
                    this.f5297i = cVar;
                    p112t3.e eVar = this.b;
                    try {
                        Object objCall = this.f5296h.call();
                        p039g3.A.b(objCall, "The buffer supplied is null");
                        this.f5298j = (Collection) objCall;
                        try {
                            Object objCall2 = ((Callable) this.f5299k).call();
                            p039g3.A.b(objCall2, "The boundary ObservableSource supplied is null");
                            io.reactivex.G g6 = (io.reactivex.G) objCall2;
                            C0942v c0942v = new C0942v(this, 0);
                            ((AtomicReference) this.f5300l).set(c0942v);
                            eVar.onSubscribe(this);
                            if (!this.d) {
                                g6.subscribe(c0942v);
                            }
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            this.d = true;
                            cVar.dispose();
                            p033f3.e.a(th, eVar);
                            return;
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        this.d = true;
                        cVar.dispose();
                        p033f3.e.a(th2, eVar);
                        return;
                    }
                }
                break;
            default:
                if (p033f3.d.g(this.f5297i, cVar)) {
                    this.f5297i = cVar;
                    try {
                        Object objCall3 = this.f5296h.call();
                        p039g3.A.b(objCall3, "The buffer supplied is null");
                        this.f5298j = (Collection) objCall3;
                        C0954y c0954y = new C0954y(this, 0);
                        this.f5300l = c0954y;
                        this.b.onSubscribe(this);
                        if (!this.d) {
                            ((io.reactivex.G) this.f5299k).subscribe(c0954y);
                        }
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        this.d = true;
                        cVar.dispose();
                        p033f3.e.a(th3, this.b);
                    }
                }
                break;
        }
    }

    public C0946w(p112t3.e eVar, Callable callable, Callable callable2) {
        super(eVar, new p083o3.b());
        this.f5300l = new AtomicReference();
        this.f5296h = callable;
        this.f5299k = callable2;
    }
}
