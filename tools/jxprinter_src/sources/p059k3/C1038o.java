package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;
import java.util.concurrent.Callable;
import p017c3.d;
import p033f3.e;
import p039g3.A;

/* JADX INFO: renamed from: k3.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1038o extends AbstractC0985s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5571a;
    public final Callable b;

    public /* synthetic */ C1038o(Callable callable, int i5) {
        this.f5571a = i5;
        this.b = callable;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.f5571a) {
            case 0:
                try {
                    Object objCall = this.b.call();
                    A.b(objCall, "The maybeSupplier returned a null MaybeSource");
                    ((AbstractC0985s) ((y) objCall)).subscribe(interfaceC0988v);
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    interfaceC0988v.onSubscribe(e.f3970a);
                    interfaceC0988v.onError(th);
                    return;
                }
                break;
            default:
                interfaceC0988v.onSubscribe(p011b3.d.disposed());
                try {
                    Object objCall2 = this.b.call();
                    A.b(objCall2, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
                    th = (Throwable) objCall2;
                } catch (Throwable th2) {
                    th = th2;
                    d.throwIfFatal(th);
                }
                interfaceC0988v.onError(th);
                break;
        }
    }
}
