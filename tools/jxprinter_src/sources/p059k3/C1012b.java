package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicBoolean;
import p011b3.b;
import p011b3.c;

/* JADX INFO: renamed from: k3.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1012b implements InterfaceC0988v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5538a;
    public final AtomicBoolean b;
    public final b c;
    public c d;

    public C1012b(InterfaceC0988v interfaceC0988v, b bVar, AtomicBoolean atomicBoolean) {
        this.f5538a = interfaceC0988v;
        this.c = bVar;
        this.b = atomicBoolean;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        if (this.b.compareAndSet(false, true)) {
            c cVar = this.d;
            b bVar = this.c;
            bVar.delete(cVar);
            bVar.dispose();
            this.f5538a.onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        if (!this.b.compareAndSet(false, true)) {
            a.onError(th);
            return;
        }
        c cVar = this.d;
        b bVar = this.c;
        bVar.delete(cVar);
        bVar.dispose();
        this.f5538a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        this.d = cVar;
        this.c.add(cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        if (this.b.compareAndSet(false, true)) {
            c cVar = this.d;
            b bVar = this.c;
            bVar.delete(cVar);
            bVar.dispose();
            this.f5538a.onSuccess(obj);
        }
    }
}
