package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.b;
import p011b3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E extends AtomicBoolean implements InterfaceC0679f {
    private static final long serialVersionUID = -7730517613164279224L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f5408a;
    public final InterfaceC0679f b;
    public final AtomicInteger c;

    public E(InterfaceC0679f interfaceC0679f, b bVar, AtomicInteger atomicInteger) {
        this.b = interfaceC0679f;
        this.f5408a = bVar;
        this.c = atomicInteger;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        if (this.c.decrementAndGet() == 0 && compareAndSet(false, true)) {
            this.b.onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.f5408a.dispose();
        if (compareAndSet(false, true)) {
            this.b.onError(th);
        } else {
            a.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        this.f5408a.add(cVar);
    }
}
