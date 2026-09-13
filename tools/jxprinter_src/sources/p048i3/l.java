package p048i3;

import io.reactivex.I;
import io.reactivex.S;
import java.util.NoSuchElementException;
import p011b3.c;
import p027e3.a;
import p027e3.g;
import p033f3.d;
import p033f3.e;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements I, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4054a;
    public c b;
    public final Object c;
    public final Object d;
    public Object e;

    public /* synthetic */ l(Object obj, int i5, Object obj2, Object obj3) {
        this.f4054a = i5;
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f4054a) {
            case 0:
                c cVar = this.b;
                d dVar = d.f3969a;
                if (cVar != dVar) {
                    this.b = dVar;
                    try {
                        ((a) this.e).run();
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        io.reactivex.plugins.a.onError(th);
                    }
                    cVar.dispose();
                }
                break;
            case 1:
                this.b.dispose();
                this.b = d.f3969a;
                break;
            default:
                this.b.dispose();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f4054a) {
            case 0:
                return this.b.e();
            case 1:
                return this.b == d.f3969a;
            default:
                return this.b.e();
        }
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f4054a) {
            case 0:
                c cVar = this.b;
                d dVar = d.f3969a;
                if (cVar != dVar) {
                    this.b = dVar;
                    ((I) this.c).onComplete();
                }
                break;
            case 1:
                S s6 = (S) this.c;
                this.b = d.f3969a;
                Object obj = this.e;
                if (obj == null) {
                    Object obj2 = this.d;
                    if (obj2 == null) {
                        s6.onError(new NoSuchElementException());
                    } else {
                        s6.onSuccess(obj2);
                    }
                } else {
                    this.e = null;
                    s6.onSuccess(obj);
                }
                break;
            default:
                Object obj3 = this.e;
                if (obj3 != null) {
                    this.e = null;
                    ((S) this.c).onSuccess(obj3);
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f4054a) {
            case 0:
                c cVar = this.b;
                d dVar = d.f3969a;
                if (cVar == dVar) {
                    io.reactivex.plugins.a.onError(th);
                } else {
                    this.b = dVar;
                    ((I) this.c).onError(th);
                }
                break;
            case 1:
                this.b = d.f3969a;
                this.e = null;
                ((S) this.c).onError(th);
                break;
            default:
                if (this.e == null) {
                    io.reactivex.plugins.a.onError(th);
                } else {
                    this.e = null;
                    ((S) this.c).onError(th);
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f4054a) {
            case 0:
                ((I) this.c).onNext(obj);
                break;
            case 1:
                this.e = obj;
                break;
            default:
                Object obj2 = this.e;
                if (obj2 != null) {
                    try {
                        Object objApply = ((p027e3.c) this.d).apply(obj2, obj);
                        A.b(objApply, "The reducer returned a null value");
                        this.e = objApply;
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        this.b.dispose();
                        onError(th);
                    }
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        switch (this.f4054a) {
            case 0:
                I i5 = (I) this.c;
                try {
                    ((g) this.d).accept(cVar);
                    if (d.g(this.b, cVar)) {
                        this.b = cVar;
                        i5.onSubscribe(this);
                    }
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    cVar.dispose();
                    this.b = d.f3969a;
                    e.a(th, i5);
                    return;
                }
                break;
            case 1:
                if (d.g(this.b, cVar)) {
                    this.b = cVar;
                    ((S) this.c).onSubscribe(this);
                }
                break;
            default:
                if (d.g(this.b, cVar)) {
                    this.b = cVar;
                    ((S) this.c).onSubscribe(this);
                }
                break;
        }
    }

    public l(S s6, Object obj) {
        this.f4054a = 1;
        this.c = s6;
        this.d = obj;
    }
}
