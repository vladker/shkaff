package p059k3;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p017c3.d;
import p027e3.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A extends AtomicInteger implements InterfaceC0988v, c {
    private static final long serialVersionUID = 4109457741734051389L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5501a;
    public final a b;
    public c c;

    public A(InterfaceC0988v interfaceC0988v, a aVar) {
        this.f5501a = interfaceC0988v;
        this.b = aVar;
    }

    public final void a() {
        if (compareAndSet(0, 1)) {
            try {
                this.b.run();
            } catch (Throwable th) {
                d.throwIfFatal(th);
                io.reactivex.plugins.a.onError(th);
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        this.c.dispose();
        a();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.e();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5501a.onComplete();
        a();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.f5501a.onError(th);
        a();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            this.f5501a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.f5501a.onSuccess(obj);
        a();
    }
}
