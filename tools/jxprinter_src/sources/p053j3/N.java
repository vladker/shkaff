package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicBoolean;
import p011b3.b;
import p011b3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N implements InterfaceC0679f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f5419a;
    public final AtomicBoolean b;
    public final InterfaceC0679f c;

    public N(b bVar, InterfaceC0679f interfaceC0679f, AtomicBoolean atomicBoolean) {
        this.f5419a = bVar;
        this.b = atomicBoolean;
        this.c = interfaceC0679f;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        if (this.b.compareAndSet(false, true)) {
            this.f5419a.dispose();
            this.c.onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        if (!this.b.compareAndSet(false, true)) {
            a.onError(th);
        } else {
            this.f5419a.dispose();
            this.c.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        this.f5419a.add(cVar);
    }
}
