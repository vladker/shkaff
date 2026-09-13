package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C extends p088p3.k implements t5.d, p011b3.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f4188h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Callable f4189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t5.d f4190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Collection f4191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f4192l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Object f4193m;

    public C(p135x3.c cVar, Callable callable, t5.b bVar) {
        super(cVar, new p083o3.b());
        this.f4189i = callable;
        this.f4192l = bVar;
    }

    @Override // t5.d
    public final void cancel() {
        switch (this.f4188h) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    this.f4190j.cancel();
                    p033f3.d.a((AtomicReference) this.f4193m);
                    if (p()) {
                        this.d.clear();
                    }
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    ((E) this.f4193m).dispose();
                    this.f4190j.cancel();
                    if (p()) {
                        this.d.clear();
                    }
                }
                break;
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f4188h) {
            case 0:
                this.f4190j.cancel();
                p033f3.d.a((AtomicReference) this.f4193m);
                break;
            default:
                cancel();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f4188h) {
            case 0:
                return ((AtomicReference) this.f4193m).get() == p033f3.d.f3969a;
            default:
                return this.e;
        }
    }

    @Override // p088p3.k
    public final boolean o(Object obj, t5.c cVar) {
        switch (this.f4188h) {
            case 0:
                this.c.onNext((Collection) obj);
                break;
            default:
                this.c.onNext((Collection) obj);
                break;
        }
        return true;
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.f4188h) {
            case 0:
                synchronized (this) {
                    try {
                        Collection collection = this.f4191k;
                        if (collection == null) {
                            return;
                        }
                        this.f4191k = null;
                        this.d.offer(collection);
                        this.f7748f = true;
                        if (p()) {
                            com.bumptech.glide.f.d(this.d, this.c, this, this);
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
                        Collection collection2 = this.f4191k;
                        if (collection2 == null) {
                            return;
                        }
                        this.f4191k = null;
                        this.d.offer(collection2);
                        this.f7748f = true;
                        if (p()) {
                            com.bumptech.glide.f.d(this.d, this.c, this, this);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.f4188h) {
            case 0:
                cancel();
                this.c.onError(th);
                break;
            default:
                cancel();
                this.c.onError(th);
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.f4188h) {
            case 0:
                synchronized (this) {
                    try {
                        Collection collection = this.f4191k;
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
                        Collection collection2 = this.f4191k;
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

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        switch (this.f4188h) {
            case 0:
                if (p094q3.g.g(this.f4190j, dVar)) {
                    this.f4190j = dVar;
                    p135x3.c cVar = this.c;
                    try {
                        Object objCall = this.f4189i.call();
                        p039g3.A.b(objCall, "The buffer supplied is null");
                        this.f4191k = (Collection) objCall;
                        try {
                            Object objCall2 = ((Callable) this.f4192l).call();
                            p039g3.A.b(objCall2, "The boundary publisher supplied is null");
                            t5.b bVar = (t5.b) objCall2;
                            B b = new B(this, 0);
                            ((AtomicReference) this.f4193m).set(b);
                            cVar.onSubscribe(this);
                            if (!this.e) {
                                dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                                bVar.subscribe(b);
                            }
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            this.e = true;
                            dVar.cancel();
                            p094q3.d.e(th, cVar);
                            return;
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        this.e = true;
                        dVar.cancel();
                        p094q3.d.e(th2, cVar);
                        return;
                    }
                    break;
                }
                break;
            default:
                if (p094q3.g.g(this.f4190j, dVar)) {
                    this.f4190j = dVar;
                    try {
                        Object objCall3 = this.f4189i.call();
                        p039g3.A.b(objCall3, "The buffer supplied is null");
                        this.f4191k = (Collection) objCall3;
                        E e = new E(this, 0);
                        this.f4193m = e;
                        this.c.onSubscribe(this);
                        if (!this.e) {
                            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                            ((t5.b) this.f4192l).subscribe(e);
                        }
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        this.e = true;
                        dVar.cancel();
                        p094q3.d.e(th3, this.c);
                    }
                    break;
                }
                break;
        }
    }

    public void u() {
        try {
            Object objCall = this.f4189i.call();
            p039g3.A.b(objCall, "The buffer supplied is null");
            Collection collection = (Collection) objCall;
            try {
                Object objCall2 = ((Callable) this.f4192l).call();
                p039g3.A.b(objCall2, "The boundary publisher supplied is null");
                t5.b bVar = (t5.b) objCall2;
                B b = new B(this, 0);
                if (p033f3.d.c((AtomicReference) this.f4193m, b)) {
                    synchronized (this) {
                        try {
                            Collection collection2 = this.f4191k;
                            if (collection2 == null) {
                                return;
                            }
                            this.f4191k = collection;
                            bVar.subscribe(b);
                            r(collection2, this);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                this.e = true;
                this.f4190j.cancel();
                this.c.onError(th2);
            }
        } catch (Throwable th3) {
            p017c3.d.throwIfFatal(th3);
            cancel();
            this.c.onError(th3);
        }
    }

    public C(p135x3.c cVar, Callable callable, Callable callable2) {
        super(cVar, new p083o3.b());
        this.f4193m = new AtomicReference();
        this.f4189i = callable;
        this.f4192l = callable2;
    }
}
