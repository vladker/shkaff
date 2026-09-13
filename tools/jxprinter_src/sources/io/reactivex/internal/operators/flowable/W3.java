package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W3 implements InterfaceC0984q, t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4491a = 0;
    public final t5.c b;
    public final p027e3.c c;
    public t5.d d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f4492f;

    public W3(t5.c cVar, p027e3.c cVar2) {
        this.b = cVar;
        this.c = cVar2;
    }

    public void a(Throwable th) {
        p017c3.d.throwIfFatal(th);
        this.e = true;
        this.d.cancel();
        this.b.onError(th);
    }

    @Override // t5.d
    public final void cancel() {
        switch (this.f4491a) {
            case 0:
                this.d.cancel();
                break;
            default:
                this.d.cancel();
                break;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.f4491a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    this.b.onComplete();
                    break;
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    this.b.onComplete();
                    break;
                }
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.f4491a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    this.b.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    this.b.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.f4491a) {
            case 0:
                if (!this.e) {
                    Object obj2 = this.f4492f;
                    t5.c cVar = this.b;
                    if (obj2 == null) {
                        this.f4492f = obj;
                        cVar.onNext(obj);
                    } else {
                        try {
                            Object objApply = this.c.apply(obj2, obj);
                            p039g3.A.b(objApply, "The value returned by the accumulator is null");
                            this.f4492f = objApply;
                            cVar.onNext(objApply);
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            this.d.cancel();
                            onError(th);
                            return;
                        }
                    }
                    break;
                }
                break;
            default:
                Iterator it = (Iterator) this.f4492f;
                if (!this.e) {
                    try {
                        Object next = it.next();
                        p039g3.A.b(next, "The iterator returned a null value");
                        try {
                            Object objApply2 = this.c.apply(obj, next);
                            p039g3.A.b(objApply2, "The zipper function returned a null value");
                            t5.c cVar2 = this.b;
                            cVar2.onNext(objApply2);
                            try {
                                if (!it.hasNext()) {
                                    this.e = true;
                                    this.d.cancel();
                                    cVar2.onComplete();
                                }
                            } catch (Throwable th2) {
                                a(th2);
                                return;
                            }
                        } catch (Throwable th3) {
                            a(th3);
                            return;
                        }
                    } catch (Throwable th4) {
                        a(th4);
                    }
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        switch (this.f4491a) {
            case 0:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    this.b.onSubscribe(this);
                }
                break;
            default:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    this.b.onSubscribe(this);
                }
                break;
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        switch (this.f4491a) {
            case 0:
                this.d.request(j6);
                break;
            default:
                this.d.request(j6);
                break;
        }
    }

    public W3(t5.c cVar, Iterator it, p027e3.c cVar2) {
        this.b = cVar;
        this.f4492f = it;
        this.c = cVar2;
    }
}
