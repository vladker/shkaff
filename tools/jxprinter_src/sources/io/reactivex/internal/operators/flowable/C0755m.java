package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.InterfaceC0988v;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0755m implements InterfaceC0984q, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4701a;
    public final Object b;
    public Object c;
    public t5.d d;
    public boolean e;

    public /* synthetic */ C0755m(io.reactivex.S s6, p027e3.q qVar, int i5) {
        this.f4701a = i5;
        this.b = s6;
        this.c = qVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f4701a) {
            case 0:
                this.d.cancel();
                this.d = p094q3.g.f7849a;
                break;
            case 1:
                this.d.cancel();
                this.d = p094q3.g.f7849a;
                break;
            default:
                this.d.cancel();
                this.d = p094q3.g.f7849a;
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f4701a) {
            case 0:
                return this.d == p094q3.g.f7849a;
            case 1:
                return this.d == p094q3.g.f7849a;
            default:
                return this.d == p094q3.g.f7849a;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.f4701a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    this.d = p094q3.g.f7849a;
                    ((io.reactivex.S) this.b).onSuccess(Boolean.TRUE);
                    break;
                }
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    this.d = p094q3.g.f7849a;
                    ((io.reactivex.S) this.b).onSuccess(Boolean.FALSE);
                }
                break;
            default:
                InterfaceC0988v interfaceC0988v = (InterfaceC0988v) this.b;
                if (!this.e) {
                    this.e = true;
                    this.d = p094q3.g.f7849a;
                    Object obj = this.c;
                    this.c = null;
                    if (obj != null) {
                        interfaceC0988v.onSuccess(obj);
                    } else {
                        interfaceC0988v.onComplete();
                    }
                    break;
                }
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.f4701a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    this.d = p094q3.g.f7849a;
                    ((io.reactivex.S) this.b).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    this.d = p094q3.g.f7849a;
                    ((io.reactivex.S) this.b).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    this.d = p094q3.g.f7849a;
                    ((InterfaceC0988v) this.b).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.f4701a) {
            case 0:
                p094q3.g gVar = p094q3.g.f7849a;
                if (!this.e) {
                    try {
                        if (!((p027e3.q) this.c).test(obj)) {
                            this.e = true;
                            this.d.cancel();
                            this.d = gVar;
                            ((io.reactivex.S) this.b).onSuccess(Boolean.FALSE);
                        }
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        this.d.cancel();
                        this.d = gVar;
                        onError(th);
                        return;
                    }
                    break;
                }
                break;
            case 1:
                p094q3.g gVar2 = p094q3.g.f7849a;
                if (!this.e) {
                    try {
                        if (((p027e3.q) this.c).test(obj)) {
                            this.e = true;
                            this.d.cancel();
                            this.d = gVar2;
                            ((io.reactivex.S) this.b).onSuccess(Boolean.TRUE);
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        this.d.cancel();
                        this.d = gVar2;
                        onError(th2);
                        return;
                    }
                    break;
                }
                break;
            default:
                if (!this.e) {
                    if (this.c == null) {
                        this.c = obj;
                    } else {
                        this.e = true;
                        this.d.cancel();
                        this.d = p094q3.g.f7849a;
                        ((InterfaceC0988v) this.b).onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    }
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        switch (this.f4701a) {
            case 0:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    ((io.reactivex.S) this.b).onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
            case 1:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    ((io.reactivex.S) this.b).onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
            default:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    ((InterfaceC0988v) this.b).onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
        }
    }

    public C0755m(InterfaceC0988v interfaceC0988v) {
        this.f4701a = 2;
        this.b = interfaceC0988v;
    }
}
