package p077n3;

import io.reactivex.S;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p017c3.d;
import p027e3.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends AtomicInteger implements S, c {
    private static final long serialVersionUID = 4109457741734051389L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6306a;
    public final a b;
    public c c;

    public r(S s6, a aVar) {
        this.f6306a = s6;
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

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f6306a.onError(th);
        a();
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            this.f6306a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.f6306a.onSuccess(obj);
        a();
    }
}
