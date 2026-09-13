package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC0988v;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.o0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0909o0 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5245a = 0;
    public p011b3.c b;
    public boolean c;
    public final Object d;
    public Object e;

    public C0909o0(InterfaceC0988v interfaceC0988v) {
        this.d = interfaceC0988v;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5245a) {
            case 0:
                this.b.dispose();
                break;
            default:
                this.b.dispose();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5245a) {
            case 0:
                break;
        }
        return this.b.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f5245a) {
            case 0:
                if (!this.c) {
                    this.c = true;
                    ((io.reactivex.I) this.d).onComplete();
                    break;
                }
                break;
            default:
                InterfaceC0988v interfaceC0988v = (InterfaceC0988v) this.d;
                if (!this.c) {
                    this.c = true;
                    Object obj = this.e;
                    this.e = null;
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

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f5245a) {
            case 0:
                if (!this.c) {
                    this.c = true;
                    ((io.reactivex.I) this.d).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.c) {
                    this.c = true;
                    ((InterfaceC0988v) this.d).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f5245a) {
            case 0:
                if (!this.c) {
                    try {
                        Object objApply = ((p027e3.o) this.e).apply(obj);
                        p039g3.A.b(objApply, "The selector returned a null Notification");
                        io.reactivex.A a6 = (io.reactivex.A) objApply;
                        Object obj2 = a6.f4169a;
                        if (obj2 instanceof p100r3.l) {
                            this.b.dispose();
                            onError(a6.getError());
                        } else if (obj2 != null) {
                            ((io.reactivex.I) this.d).onNext(a6.getValue());
                        } else {
                            this.b.dispose();
                            onComplete();
                        }
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        this.b.dispose();
                        onError(th);
                        return;
                    }
                } else if (obj instanceof io.reactivex.A) {
                    io.reactivex.A a7 = (io.reactivex.A) obj;
                    if (a7.f4169a instanceof p100r3.l) {
                        io.reactivex.plugins.a.onError(a7.getError());
                    }
                }
                break;
            default:
                if (!this.c) {
                    if (this.e == null) {
                        this.e = obj;
                    } else {
                        this.c = true;
                        this.b.dispose();
                        ((InterfaceC0988v) this.d).onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    }
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5245a) {
            case 0:
                if (p033f3.d.g(this.b, cVar)) {
                    this.b = cVar;
                    ((io.reactivex.I) this.d).onSubscribe(this);
                }
                break;
            default:
                if (p033f3.d.g(this.b, cVar)) {
                    this.b = cVar;
                    ((InterfaceC0988v) this.d).onSubscribe(this);
                }
                break;
        }
    }

    public C0909o0(io.reactivex.I i5, p027e3.o oVar) {
        this.d = i5;
        this.e = oVar;
    }
}
