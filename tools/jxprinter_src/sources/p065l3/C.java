package p065l3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p100r3.c;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C extends AtomicReference implements InterfaceC0679f {
    private static final long serialVersionUID = -8003404460084760287L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D f5798a;

    public C(D d) {
        this.f5798a = d;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        D d = this.f5798a;
        AtomicReference atomicReference = d.e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                return;
            }
        }
        if (d.f5801f) {
            c cVar = d.d;
            cVar.getClass();
            Throwable thB = g.b(cVar);
            if (thB == null) {
                d.f5800a.onComplete();
            } else {
                d.f5800a.onError(thB);
            }
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        D d = this.f5798a;
        AtomicReference atomicReference = d.e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                a.onError(th);
            }
        }
        c cVar = d.d;
        cVar.getClass();
        if (g.a(cVar, th)) {
            if (d.c) {
                if (d.f5801f) {
                    c cVar2 = d.d;
                    cVar2.getClass();
                    d.f5800a.onError(g.b(cVar2));
                    return;
                }
                return;
            }
            d.dispose();
            c cVar3 = d.d;
            cVar3.getClass();
            Throwable thB = g.b(cVar3);
            if (thB != g.f7961a) {
                d.f5800a.onError(thB);
                return;
            }
            return;
        }
        a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        d.f(this, cVar);
    }
}
