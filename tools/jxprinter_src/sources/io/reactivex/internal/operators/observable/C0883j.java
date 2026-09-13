package io.reactivex.internal.operators.observable;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0883j extends io.reactivex.O implements p043h3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5207a;
    public final io.reactivex.B b;
    public final Object c;

    public /* synthetic */ C0883j(io.reactivex.B b, Object obj, int i5) {
        this.f5207a = i5;
        this.b = b;
        this.c = obj;
    }

    @Override // p043h3.d
    public final io.reactivex.B b() {
        switch (this.f5207a) {
            case 0:
                return io.reactivex.plugins.a.onAssembly(new C0873h(this.b, (p027e3.q) this.c, 0));
            case 1:
                return io.reactivex.plugins.a.onAssembly(new C0873h(this.b, (p027e3.q) this.c, 1));
            default:
                return io.reactivex.plugins.a.onAssembly(new C0933t0(this.b, (Callable) this.c, 5));
        }
    }

    @Override // io.reactivex.O
    public final void subscribeActual(io.reactivex.S s6) {
        switch (this.f5207a) {
            case 0:
                this.b.subscribe(new C0878i(s6, (p027e3.q) this.c, 0));
                break;
            case 1:
                this.b.subscribe(new C0878i(s6, (p027e3.q) this.c, 1));
                break;
            default:
                try {
                    Object objCall = ((Callable) this.c).call();
                    p039g3.A.b(objCall, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    this.b.subscribe(new E1(s6, (Collection) objCall, 3));
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    p033f3.e.f(th, s6);
                    return;
                }
                break;
        }
    }

    public C0883j(io.reactivex.B b, int i5) {
        this.f5207a = 2;
        this.b = b;
        this.c = new p039g3.c(i5);
    }
}
