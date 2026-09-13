package p059k3;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;
import p027e3.c;
import p033f3.d;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = -2897979525538174559L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5512a;
    public final c b;
    public Object c;

    public H(InterfaceC0988v interfaceC0988v, c cVar) {
        this.f5512a = interfaceC0988v;
        this.b = cVar;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5512a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.f5512a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        InterfaceC0988v interfaceC0988v = this.f5512a;
        Object obj2 = this.c;
        this.c = null;
        try {
            Object objApply = this.b.apply(obj2, obj);
            A.b(objApply, "The resultSelector returned a null value");
            interfaceC0988v.onSuccess(objApply);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            interfaceC0988v.onError(th);
        }
    }
}
