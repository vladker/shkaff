package p065l3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p100r3.c;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H extends AtomicReference implements S {
    private static final long serialVersionUID = 8042919737683345351L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f5810a;
    public volatile Object b;

    public H(I i5) {
        this.f5810a = i5;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        I i5 = this.f5810a;
        AtomicReference atomicReference = i5.e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                a.onError(th);
            }
        }
        c cVar = i5.d;
        cVar.getClass();
        if (g.a(cVar, th)) {
            if (!i5.c) {
                i5.f5813f.dispose();
                i5.a();
            }
            i5.b();
            return;
        }
        a.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(p011b3.c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.b = obj;
        this.f5810a.b();
    }
}
