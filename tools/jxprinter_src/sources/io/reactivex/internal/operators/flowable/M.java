package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.InterfaceC0988v;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M implements InterfaceC0984q, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4352a = 2;
    public Object b;
    public t5.d c;
    public boolean d;
    public final Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f4353f;

    public M(io.reactivex.S s6, Object obj) {
        this.e = s6;
        this.b = obj;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f4352a) {
            case 0:
                this.c.cancel();
                this.c = p094q3.g.f7849a;
                break;
            case 1:
                this.c.cancel();
                this.d = true;
                break;
            default:
                this.c.cancel();
                this.c = p094q3.g.f7849a;
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f4352a) {
            case 0:
                return this.c == p094q3.g.f7849a;
            case 1:
                return this.d;
            default:
                return this.c == p094q3.g.f7849a;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.f4352a) {
            case 0:
                if (!this.d) {
                    this.d = true;
                    this.c = p094q3.g.f7849a;
                    ((io.reactivex.S) this.e).onSuccess(this.b);
                    break;
                }
                break;
            case 1:
                InterfaceC0988v interfaceC0988v = (InterfaceC0988v) this.e;
                if (!this.d) {
                    this.d = true;
                    Object obj = this.b;
                    if (obj == null) {
                        interfaceC0988v.onComplete();
                    } else {
                        interfaceC0988v.onSuccess(obj);
                    }
                    break;
                }
                break;
            default:
                io.reactivex.S s6 = (io.reactivex.S) this.e;
                if (!this.d) {
                    this.d = true;
                    this.c = p094q3.g.f7849a;
                    Object obj2 = this.f4353f;
                    this.f4353f = null;
                    if (obj2 == null) {
                        obj2 = this.b;
                    }
                    if (obj2 == null) {
                        s6.onError(new NoSuchElementException());
                    } else {
                        s6.onSuccess(obj2);
                    }
                    break;
                }
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.f4352a) {
            case 0:
                if (!this.d) {
                    this.d = true;
                    this.c = p094q3.g.f7849a;
                    ((io.reactivex.S) this.e).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            case 1:
                if (!this.d) {
                    this.d = true;
                    ((InterfaceC0988v) this.e).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.d) {
                    this.d = true;
                    this.c = p094q3.g.f7849a;
                    ((io.reactivex.S) this.e).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.f4352a) {
            case 0:
                if (!this.d) {
                    try {
                        ((p027e3.b) this.f4353f).accept(this.b, obj);
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        this.c.cancel();
                        onError(th);
                        return;
                    }
                    break;
                }
                break;
            case 1:
                if (!this.d) {
                    Object obj2 = this.b;
                    if (obj2 == null) {
                        this.b = obj;
                    } else {
                        try {
                            Object objApply = ((p027e3.c) this.f4353f).apply(obj2, obj);
                            p039g3.A.b(objApply, "The reducer returned a null value");
                            this.b = objApply;
                        } catch (Throwable th2) {
                            p017c3.d.throwIfFatal(th2);
                            this.c.cancel();
                            onError(th2);
                            return;
                        }
                    }
                    break;
                }
                break;
            default:
                if (!this.d) {
                    if (this.f4353f == null) {
                        this.f4353f = obj;
                    } else {
                        this.d = true;
                        this.c.cancel();
                        this.c = p094q3.g.f7849a;
                        ((io.reactivex.S) this.e).onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    }
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        switch (this.f4352a) {
            case 0:
                if (p094q3.g.g(this.c, dVar)) {
                    this.c = dVar;
                    ((io.reactivex.S) this.e).onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
            case 1:
                if (p094q3.g.g(this.c, dVar)) {
                    this.c = dVar;
                    ((InterfaceC0988v) this.e).onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
            default:
                if (p094q3.g.g(this.c, dVar)) {
                    this.c = dVar;
                    ((io.reactivex.S) this.e).onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
        }
    }

    public M(InterfaceC0988v interfaceC0988v, p027e3.c cVar) {
        this.e = interfaceC0988v;
        this.f4353f = cVar;
    }

    public M(io.reactivex.S s6, Object obj, p027e3.b bVar) {
        this.e = s6;
        this.f4353f = bVar;
        this.b = obj;
    }
}
