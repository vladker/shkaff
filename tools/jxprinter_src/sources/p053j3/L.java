package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L extends AtomicReference implements InterfaceC0679f, c {
    private static final long serialVersionUID = 3533011714830024923L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5417a;
    public final K b = new K(this);
    public final AtomicBoolean c = new AtomicBoolean();

    public L(InterfaceC0679f interfaceC0679f) {
        this.f5417a = interfaceC0679f;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.c.compareAndSet(false, true)) {
            d.a(this);
            d.a(this.b);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.get();
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        if (this.c.compareAndSet(false, true)) {
            d.a(this.b);
            this.f5417a.onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        if (!this.c.compareAndSet(false, true)) {
            a.onError(th);
        } else {
            d.a(this.b);
            this.f5417a.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }
}
