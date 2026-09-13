package p065l3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p100r3.c;
import p100r3.g;

/* JADX INFO: renamed from: l3.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1160k extends AtomicReference implements InterfaceC0679f {
    private static final long serialVersionUID = -8003404460084760287L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f5855a;

    public C1160k(l lVar) {
        this.f5855a = lVar;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        l lVar = this.f5855a;
        AtomicReference atomicReference = lVar.e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                return;
            }
        }
        if (lVar.f5858f) {
            c cVar = lVar.d;
            cVar.getClass();
            Throwable thB = g.b(cVar);
            if (thB == null) {
                lVar.f5857a.onComplete();
            } else {
                lVar.f5857a.onError(thB);
            }
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        l lVar = this.f5855a;
        AtomicReference atomicReference = lVar.e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                a.onError(th);
            }
        }
        c cVar = lVar.d;
        cVar.getClass();
        if (g.a(cVar, th)) {
            if (lVar.c) {
                if (lVar.f5858f) {
                    c cVar2 = lVar.d;
                    cVar2.getClass();
                    lVar.f5857a.onError(g.b(cVar2));
                    return;
                }
                return;
            }
            lVar.dispose();
            c cVar3 = lVar.d;
            cVar3.getClass();
            Throwable thB = g.b(cVar3);
            if (thB != g.f7961a) {
                lVar.f5857a.onError(thB);
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
