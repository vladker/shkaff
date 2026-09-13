package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.b;
import p011b3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D extends AtomicInteger implements InterfaceC0679f {
    private static final long serialVersionUID = -8360547806504310570L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5407a;
    public final AtomicBoolean b;
    public final b c;

    public D(InterfaceC0679f interfaceC0679f, AtomicBoolean atomicBoolean, b bVar, int i5) {
        this.f5407a = interfaceC0679f;
        this.b = atomicBoolean;
        this.c = bVar;
        lazySet(i5);
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        if (decrementAndGet() == 0 && this.b.compareAndSet(false, true)) {
            this.f5407a.onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.c.dispose();
        if (this.b.compareAndSet(false, true)) {
            this.f5407a.onError(th);
        } else {
            a.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        this.c.add(cVar);
    }
}
