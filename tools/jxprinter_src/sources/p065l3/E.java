package p065l3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p100r3.c;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = 8042919737683345351L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f5803a;
    public volatile Object b;

    public E(F f6) {
        this.f5803a = f6;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        F f6 = this.f5803a;
        AtomicReference atomicReference = f6.e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                return;
            }
        }
        f6.b();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        F f6 = this.f5803a;
        AtomicReference atomicReference = f6.e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                a.onError(th);
            }
        }
        c cVar = f6.d;
        cVar.getClass();
        if (g.a(cVar, th)) {
            if (!f6.c) {
                f6.f5806f.dispose();
                f6.a();
            }
            f6.b();
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
        this.f5803a.b();
    }
}
