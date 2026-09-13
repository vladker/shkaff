package io.reactivex.internal.operators.observable;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0950x extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final Object c;
    public final Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0950x(io.reactivex.B b, Object obj, Object obj2, int i5) {
        super(b);
        this.b = i5;
        this.c = obj;
        this.d = obj2;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                this.f5141a.subscribe(new C0946w(new p112t3.e(i5), (Callable) this.d, (Callable) this.c));
                break;
            case 1:
                this.f5141a.subscribe(new C0946w(new p112t3.e(i5), (Callable) this.c, (io.reactivex.G) this.d));
                break;
            case 2:
                try {
                    Object objCall = ((Callable) this.c).call();
                    p039g3.A.b(objCall, "The initialSupplier returned a null value");
                    this.f5141a.subscribe(new G(i5, objCall, (p027e3.b) this.d, 0));
                } catch (Throwable th) {
                    i5.onSubscribe(p033f3.e.f3970a);
                    i5.onError(th);
                    return;
                }
                break;
            case 3:
                try {
                    Object objCall2 = ((Callable) this.c).call();
                    p039g3.A.b(objCall2, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    this.f5141a.subscribe(new C0919q0(i5, (p027e3.o) this.d, (Collection) objCall2));
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    i5.onSubscribe(p033f3.e.f3970a);
                    i5.onError(th2);
                    return;
                }
                break;
            case 4:
                this.f5141a.subscribe(new C0923r0(i5, (p027e3.o) this.c, (p027e3.d) this.d));
                break;
            case 5:
                this.f5141a.subscribe(new p048i3.l(i5, 0, (p027e3.g) this.c, (p027e3.a) this.d));
                break;
            case 6:
                try {
                    Object objCall3 = ((Callable) this.c).call();
                    p039g3.A.b(objCall3, "The seed supplied is null");
                    this.f5141a.subscribe(new M2(i5, (p027e3.c) this.d, objCall3));
                } catch (Throwable th3) {
                    p017c3.d.throwIfFatal(th3);
                    i5.onSubscribe(p033f3.e.f3970a);
                    i5.onError(th3);
                    return;
                }
                break;
            case 7:
                this.f5141a.subscribe(new C0892k3(i5, (TimeUnit) this.d, (io.reactivex.N) this.c));
                break;
            default:
                p112t3.e eVar = new p112t3.e(i5);
                N3 n6 = new N3(eVar, (p027e3.c) this.c);
                eVar.onSubscribe(n6);
                ((io.reactivex.G) this.d).subscribe(new C0899m0(n6, 2));
                this.f5141a.subscribe(n6);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0950x(io.reactivex.B b, Object obj, Object obj2, int i5, boolean z6) {
        super(b);
        this.b = i5;
        this.d = obj;
        this.c = obj2;
    }
}
