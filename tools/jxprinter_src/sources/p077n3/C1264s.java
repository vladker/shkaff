package p077n3;

import io.reactivex.S;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p017c3.d;
import p027e3.a;

/* JADX INFO: renamed from: n3.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1264s extends AtomicReference implements S, c {
    private static final long serialVersionUID = -8583764624474935784L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6307a;
    public c b;

    public C1264s(S s6, a aVar) {
        this.f6307a = s6;
        lazySet(aVar);
    }

    @Override // p011b3.c
    public final void dispose() {
        a aVar = (a) getAndSet(null);
        if (aVar != null) {
            try {
                aVar.run();
            } catch (Throwable th) {
                d.throwIfFatal(th);
                io.reactivex.plugins.a.onError(th);
            }
            this.b.dispose();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b.e();
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f6307a.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        if (p033f3.d.g(this.b, cVar)) {
            this.b = cVar;
            this.f6307a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.f6307a.onSuccess(obj);
    }
}
