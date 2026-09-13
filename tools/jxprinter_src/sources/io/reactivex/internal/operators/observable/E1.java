package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC0988v;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E1 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4912a;
    public p011b3.c b;
    public Object c;
    public final Object d;

    public /* synthetic */ E1(Object obj, int i5) {
        this.f4912a = i5;
        this.d = obj;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f4912a) {
            case 0:
                this.b.dispose();
                this.b = p033f3.d.f3969a;
                break;
            case 1:
                this.c = null;
                this.b.dispose();
                break;
            case 2:
                this.b.dispose();
                break;
            default:
                this.b.dispose();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f4912a) {
            case 0:
                return this.b == p033f3.d.f3969a;
            case 1:
                return this.b.e();
            case 2:
                return this.b.e();
            default:
                return this.b.e();
        }
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f4912a) {
            case 0:
                InterfaceC0988v interfaceC0988v = (InterfaceC0988v) this.d;
                this.b = p033f3.d.f3969a;
                Object obj = this.c;
                if (obj == null) {
                    interfaceC0988v.onComplete();
                } else {
                    this.c = null;
                    interfaceC0988v.onSuccess(obj);
                }
                break;
            case 1:
                io.reactivex.I i5 = (io.reactivex.I) this.d;
                Object obj2 = this.c;
                if (obj2 != null) {
                    this.c = null;
                    i5.onNext(obj2);
                }
                i5.onComplete();
                break;
            case 2:
                Collection collection = (Collection) this.c;
                this.c = null;
                io.reactivex.I i6 = (io.reactivex.I) this.d;
                i6.onNext(collection);
                i6.onComplete();
                break;
            default:
                Collection collection2 = (Collection) this.c;
                this.c = null;
                ((io.reactivex.S) this.d).onSuccess(collection2);
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f4912a) {
            case 0:
                this.b = p033f3.d.f3969a;
                this.c = null;
                ((InterfaceC0988v) this.d).onError(th);
                break;
            case 1:
                this.c = null;
                ((io.reactivex.I) this.d).onError(th);
                break;
            case 2:
                this.c = null;
                ((io.reactivex.I) this.d).onError(th);
                break;
            default:
                this.c = null;
                ((io.reactivex.S) this.d).onError(th);
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f4912a) {
            case 0:
                this.c = obj;
                break;
            case 1:
                this.c = obj;
                break;
            case 2:
                ((Collection) this.c).add(obj);
                break;
            default:
                ((Collection) this.c).add(obj);
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f4912a) {
            case 0:
                if (p033f3.d.g(this.b, cVar)) {
                    this.b = cVar;
                    ((InterfaceC0988v) this.d).onSubscribe(this);
                }
                break;
            case 1:
                if (p033f3.d.g(this.b, cVar)) {
                    this.b = cVar;
                    ((io.reactivex.I) this.d).onSubscribe(this);
                }
                break;
            case 2:
                if (p033f3.d.g(this.b, cVar)) {
                    this.b = cVar;
                    ((io.reactivex.I) this.d).onSubscribe(this);
                }
                break;
            default:
                if (p033f3.d.g(this.b, cVar)) {
                    this.b = cVar;
                    ((io.reactivex.S) this.d).onSubscribe(this);
                }
                break;
        }
    }

    public /* synthetic */ E1(Object obj, Collection collection, int i5) {
        this.f4912a = i5;
        this.d = obj;
        this.c = collection;
    }
}
