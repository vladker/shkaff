package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC0988v;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4941a;
    public Object b;
    public Object c;
    public p011b3.c d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f4942f;

    public /* synthetic */ G(Object obj, Object obj2, p027e3.b bVar, int i5) {
        this.f4941a = i5;
        this.f4942f = obj;
        this.b = bVar;
        this.c = obj2;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f4941a) {
            case 0:
                this.d.dispose();
                break;
            case 1:
                this.d.dispose();
                break;
            case 2:
                this.d.dispose();
                break;
            case 3:
                this.d.dispose();
                break;
            default:
                this.d.dispose();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f4941a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return this.d.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f4941a) {
            case 0:
                io.reactivex.I i5 = (io.reactivex.I) this.f4942f;
                if (!this.e) {
                    this.e = true;
                    i5.onNext(this.c);
                    i5.onComplete();
                    break;
                }
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    ((io.reactivex.S) this.f4942f).onSuccess(this.c);
                    break;
                }
                break;
            case 2:
                InterfaceC0988v interfaceC0988v = (InterfaceC0988v) this.f4942f;
                if (!this.e) {
                    this.e = true;
                    Object obj = this.c;
                    this.c = null;
                    if (obj == null) {
                        interfaceC0988v.onComplete();
                    } else {
                        interfaceC0988v.onSuccess(obj);
                    }
                    break;
                }
                break;
            case 3:
                io.reactivex.S s6 = (io.reactivex.S) this.f4942f;
                if (!this.e) {
                    this.e = true;
                    Object obj2 = this.b;
                    this.b = null;
                    if (obj2 == null) {
                        obj2 = this.c;
                    }
                    if (obj2 == null) {
                        s6.onError(new NoSuchElementException());
                    } else {
                        s6.onSuccess(obj2);
                    }
                    break;
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    ((io.reactivex.I) this.f4942f).onComplete();
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f4941a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    ((io.reactivex.I) this.f4942f).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    ((io.reactivex.S) this.f4942f).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            case 2:
                if (!this.e) {
                    this.e = true;
                    this.c = null;
                    ((InterfaceC0988v) this.f4942f).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            case 3:
                if (!this.e) {
                    this.e = true;
                    ((io.reactivex.S) this.f4942f).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    ((io.reactivex.I) this.f4942f).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f4941a) {
            case 0:
                if (!this.e) {
                    try {
                        ((p027e3.b) this.b).accept(this.c, obj);
                    } catch (Throwable th) {
                        this.d.dispose();
                        onError(th);
                        return;
                    }
                    break;
                }
                break;
            case 1:
                if (!this.e) {
                    try {
                        ((p027e3.b) this.b).accept(this.c, obj);
                    } catch (Throwable th2) {
                        this.d.dispose();
                        onError(th2);
                        return;
                    }
                    break;
                }
                break;
            case 2:
                if (!this.e) {
                    Object obj2 = this.c;
                    if (obj2 == null) {
                        this.c = obj;
                    } else {
                        try {
                            Object objApply = ((p027e3.c) this.b).apply(obj2, obj);
                            p039g3.A.b(objApply, "The reducer returned a null value");
                            this.c = objApply;
                        } catch (Throwable th3) {
                            p017c3.d.throwIfFatal(th3);
                            this.d.dispose();
                            onError(th3);
                            return;
                        }
                    }
                }
                break;
            case 3:
                if (!this.e) {
                    if (this.b == null) {
                        this.b = obj;
                    } else {
                        this.e = true;
                        this.d.dispose();
                        ((io.reactivex.S) this.f4942f).onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    }
                    break;
                }
                break;
            default:
                io.reactivex.I i5 = (io.reactivex.I) this.f4942f;
                Iterator it = (Iterator) this.b;
                if (!this.e) {
                    try {
                        Object next = it.next();
                        p039g3.A.b(next, "The iterator returned a null value");
                        try {
                            Object objApply2 = ((p027e3.c) this.c).apply(obj, next);
                            p039g3.A.b(objApply2, "The zipper function returned a null value");
                            i5.onNext(objApply2);
                            try {
                                if (!it.hasNext()) {
                                    this.e = true;
                                    this.d.dispose();
                                    i5.onComplete();
                                }
                            } catch (Throwable th4) {
                                p017c3.d.throwIfFatal(th4);
                                this.e = true;
                                this.d.dispose();
                                i5.onError(th4);
                                return;
                            }
                        } catch (Throwable th5) {
                            p017c3.d.throwIfFatal(th5);
                            this.e = true;
                            this.d.dispose();
                            i5.onError(th5);
                            return;
                        }
                    } catch (Throwable th6) {
                        p017c3.d.throwIfFatal(th6);
                        this.e = true;
                        this.d.dispose();
                        i5.onError(th6);
                    }
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f4941a) {
            case 0:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    ((io.reactivex.I) this.f4942f).onSubscribe(this);
                }
                break;
            case 1:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    ((io.reactivex.S) this.f4942f).onSubscribe(this);
                }
                break;
            case 2:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    ((InterfaceC0988v) this.f4942f).onSubscribe(this);
                }
                break;
            case 3:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    ((io.reactivex.S) this.f4942f).onSubscribe(this);
                }
                break;
            default:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    ((io.reactivex.I) this.f4942f).onSubscribe(this);
                }
                break;
        }
    }

    public G(io.reactivex.S s6, Object obj) {
        this.f4941a = 3;
        this.f4942f = s6;
        this.c = obj;
    }

    public G(InterfaceC0988v interfaceC0988v, p027e3.c cVar) {
        this.f4941a = 2;
        this.f4942f = interfaceC0988v;
        this.b = cVar;
    }

    public G(io.reactivex.I i5, Iterator it, p027e3.c cVar) {
        this.f4941a = 4;
        this.f4942f = i5;
        this.b = it;
        this.c = cVar;
    }
}
