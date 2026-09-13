package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M0 extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = 3323743579927613702L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L0 f5523a;
    public final int b;

    public M0(L0 l6, int i5) {
        this.f5523a = l6;
        this.b = i5;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        L0 l6 = this.f5523a;
        if (l6.getAndSet(0) > 0) {
            l6.a(this.b);
            l6.f5522a.onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        L0 l6 = this.f5523a;
        if (l6.getAndSet(0) <= 0) {
            a.onError(th);
        } else {
            l6.a(this.b);
            l6.f5522a.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        L0 l6 = this.f5523a;
        InterfaceC0988v interfaceC0988v = l6.f5522a;
        Object[] objArr = l6.d;
        objArr[this.b] = obj;
        if (l6.decrementAndGet() == 0) {
            try {
                Object objApply = l6.b.apply(objArr);
                A.b(objApply, "The zipper returned a null value");
                interfaceC0988v.onSuccess(objApply);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                interfaceC0988v.onError(th);
            }
        }
    }
}
