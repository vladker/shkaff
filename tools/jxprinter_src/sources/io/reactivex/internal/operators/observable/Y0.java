package io.reactivex.internal.operators.observable;

import java.util.Iterator;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y0 extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5132a = 1;
    public final p027e3.c b;
    public final Object c;
    public final Object d;

    public Y0(io.reactivex.B b, Iterable iterable, p027e3.c cVar) {
        this.c = b;
        this.d = iterable;
        this.b = cVar;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.f5132a) {
            case 0:
                try {
                    Object objCall = ((Callable) this.c).call();
                    p027e3.c cVar = this.b;
                    X0 x6 = new X0(i5, cVar, (p027e3.g) this.d, objCall);
                    i5.onSubscribe(x6);
                    Object objApply = x6.c;
                    if (!x6.d) {
                        while (!x6.d) {
                            x6.f5129f = false;
                            try {
                                objApply = cVar.apply(objApply, x6);
                                if (x6.e) {
                                    x6.d = true;
                                    x6.c = null;
                                    x6.a(objApply);
                                    break;
                                }
                            } catch (Throwable th) {
                                p017c3.d.throwIfFatal(th);
                                x6.c = null;
                                x6.d = true;
                                x6.onError(th);
                                x6.a(objApply);
                                return;
                            }
                        }
                        x6.c = null;
                        x6.a(objApply);
                    } else {
                        x6.c = null;
                        x6.a(objApply);
                    }
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    i5.onSubscribe(p033f3.e.f3970a);
                    i5.onError(th2);
                    return;
                }
                break;
            default:
                p011b3.c cVar2 = p033f3.e.f3970a;
                try {
                    Iterator it = ((Iterable) this.d).iterator();
                    p039g3.A.b(it, "The iterator returned by other is null");
                    try {
                        if (!it.hasNext()) {
                            i5.onSubscribe(cVar2);
                            i5.onComplete();
                        } else {
                            ((io.reactivex.B) this.c).subscribe(new G(i5, it, this.b));
                        }
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        i5.onSubscribe(cVar2);
                        i5.onError(th3);
                        return;
                    }
                } catch (Throwable th4) {
                    p017c3.d.throwIfFatal(th4);
                    i5.onSubscribe(cVar2);
                    i5.onError(th4);
                }
                break;
        }
    }

    public Y0(Callable callable, p027e3.c cVar, p027e3.g gVar) {
        this.c = callable;
        this.b = cVar;
        this.d = gVar;
    }
}
