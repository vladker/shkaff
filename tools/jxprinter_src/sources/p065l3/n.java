package p065l3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p100r3.c;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = 8042919737683345351L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f5861a;
    public volatile Object b;

    public n(o oVar) {
        this.f5861a = oVar;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        o oVar = this.f5861a;
        AtomicReference atomicReference = oVar.f5864f;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                return;
            }
        }
        oVar.b();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        o oVar = this.f5861a;
        AtomicReference atomicReference = oVar.f5864f;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                a.onError(th);
            }
        }
        c cVar = oVar.d;
        cVar.getClass();
        if (g.a(cVar, th)) {
            if (!oVar.c) {
                oVar.f5865g.cancel();
                oVar.a();
            }
            oVar.b();
            return;
        }
        a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.b = obj;
        this.f5861a.b();
    }
}
