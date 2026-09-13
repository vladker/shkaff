package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.j0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0884j0 extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5208a;
    public final Callable b;

    public /* synthetic */ C0884j0(Callable callable, int i5) {
        this.f5208a = i5;
        this.b = callable;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.f5208a) {
            case 0:
                try {
                    Object objCall = this.b.call();
                    p039g3.A.b(objCall, "null ObservableSource supplied");
                    ((io.reactivex.G) objCall).subscribe(i5);
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    i5.onSubscribe(p033f3.e.f3970a);
                    i5.onError(th);
                }
                break;
            default:
                try {
                    Object objCall2 = this.b.call();
                    p039g3.A.b(objCall2, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
                    th = (Throwable) objCall2;
                } catch (Throwable th2) {
                    th = th2;
                    p017c3.d.throwIfFatal(th);
                }
                i5.onSubscribe(p033f3.e.f3970a);
                i5.onError(th);
                break;
        }
    }
}
