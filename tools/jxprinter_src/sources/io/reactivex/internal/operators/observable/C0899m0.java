package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC0679f;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.m0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0899m0 implements io.reactivex.I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5234a;
    public final Object b;

    public /* synthetic */ C0899m0(Object obj, int i5) {
        this.f5234a = i5;
        this.b = obj;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f5234a) {
            case 0:
                ((C0904n0) this.b).b.onComplete();
                break;
            case 1:
                K2 k6 = (K2) this.b;
                k6.d.dispose();
                k6.b();
                break;
            case 2:
                break;
            case 3:
                ((InterfaceC0679f) this.b).onComplete();
                break;
            default:
                ((io.reactivex.I) this.b).onComplete();
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f5234a) {
            case 0:
                ((C0904n0) this.b).b.onError(th);
                break;
            case 1:
                K2 k6 = (K2) this.b;
                k6.d.dispose();
                k6.f5000a.onError(th);
                break;
            case 2:
                N3 n6 = (N3) this.b;
                p033f3.d.a(n6.c);
                n6.f5047a.onError(th);
                break;
            case 3:
                ((InterfaceC0679f) this.b).onError(th);
                break;
            default:
                io.reactivex.I i5 = (io.reactivex.I) this.b;
                try {
                    i5.onNext(y5.g.a(th));
                    i5.onComplete();
                    break;
                } catch (Throwable th2) {
                    try {
                        i5.onError(th2);
                        return;
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        io.reactivex.plugins.a.onError(new p017c3.c(th2, th3));
                    }
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f5234a) {
            case 0:
                ((C0904n0) this.b).b.onNext(obj);
                break;
            case 1:
                ((K2) this.b).c();
                break;
            case 2:
                ((N3) this.b).lazySet(obj);
                break;
            case 3:
                break;
            default:
                ((io.reactivex.I) this.b).onNext(y5.g.b((retrofit2.r0) obj));
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5234a) {
            case 0:
                p033f3.h hVar = ((C0904n0) this.b).c;
                hVar.getClass();
                p033f3.d.d(hVar, cVar);
                break;
            case 1:
                p033f3.d.f(((K2) this.b).c, cVar);
                break;
            case 2:
                p033f3.d.f(((N3) this.b).d, cVar);
                break;
            case 3:
                ((InterfaceC0679f) this.b).onSubscribe(cVar);
                break;
            default:
                ((io.reactivex.I) this.b).onSubscribe(cVar);
                break;
        }
    }

    private final void a() {
    }

    private final void b(Object obj) {
    }
}
