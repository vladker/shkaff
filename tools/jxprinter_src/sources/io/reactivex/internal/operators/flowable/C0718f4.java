package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.f4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0718f4 extends io.reactivex.O implements p043h3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4617a;
    public final AbstractC0979l b;
    public final Object c;

    public /* synthetic */ C0718f4(AbstractC0979l abstractC0979l, Object obj, int i5) {
        this.f4617a = i5;
        this.b = abstractC0979l;
        this.c = obj;
    }

    @Override // p043h3.b
    public final AbstractC0979l c() {
        switch (this.f4617a) {
            case 0:
                return io.reactivex.plugins.a.onAssembly(new U2(this.b, this.c, true, 1));
            default:
                return io.reactivex.plugins.a.onAssembly(new T0(this.b, (Callable) this.c, 3));
        }
    }

    @Override // io.reactivex.O
    public final void subscribeActual(io.reactivex.S s6) {
        switch (this.f4617a) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new M(s6, this.c));
                break;
            default:
                try {
                    Object objCall = ((Callable) this.c).call();
                    p039g3.A.b(objCall, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    this.b.subscribe((InterfaceC0984q) new C0799t2(s6, (Collection) objCall));
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    p033f3.e.f(th, s6);
                    return;
                }
                break;
        }
    }
}
