package io.reactivex.internal.operators.observable;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.t0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0933t0 extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0933t0(io.reactivex.B b, Object obj, int i5) {
        super(b);
        this.b = i5;
        this.c = obj;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                this.f5141a.subscribe(new C0928s0(i5, (p027e3.g) this.c));
                break;
            case 1:
                this.f5141a.subscribe(new C0938u0(i5, (p027e3.a) this.c));
                break;
            case 2:
                p033f3.h hVar = new p033f3.h();
                i5.onSubscribe(hVar);
                C0881i2 c0881i2 = new C0881i2(i5, (p027e3.e) this.c, hVar, this.f5141a);
                if (c0881i2.getAndIncrement() == 0) {
                    int iAddAndGet = 1;
                    do {
                        c0881i2.c.subscribe(c0881i2);
                        iAddAndGet = c0881i2.addAndGet(-iAddAndGet);
                    } while (iAddAndGet != 0);
                }
                break;
            case 3:
                p033f3.h hVar2 = new p033f3.h();
                i5.onSubscribe(hVar2);
                new A2(i5, (p027e3.d) this.c, hVar2, this.f5141a).a();
                break;
            case 4:
                this.f5141a.subscribe(new M2(i5, (p027e3.c) this.c));
                break;
            default:
                try {
                    Object objCall = ((Callable) this.c).call();
                    p039g3.A.b(objCall, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    this.f5141a.subscribe(new E1(i5, (Collection) objCall, 2));
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    i5.onSubscribe(p033f3.e.f3970a);
                    i5.onError(th);
                    return;
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0933t0(io.reactivex.G g6) {
        super(g6);
        this.b = 5;
        this.c = new p039g3.c(16);
    }
}
