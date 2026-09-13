package p053j3;

import io.reactivex.InterfaceC0679f;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p017c3.d;
import p027e3.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends AtomicInteger implements InterfaceC0679f, c {
    private static final long serialVersionUID = 4109457741734051389L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5455a;
    public final a b;
    public c c;

    public v(InterfaceC0679f interfaceC0679f, a aVar) {
        this.f5455a = interfaceC0679f;
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

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5455a.onComplete();
        a();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.f5455a.onError(th);
        a();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            this.f5455a.onSubscribe(this);
        }
    }
}
