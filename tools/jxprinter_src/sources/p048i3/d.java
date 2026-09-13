package p048i3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends AtomicReference implements S, c {
    private static final long serialVersionUID = 4943102778943297569L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f4047a;

    public d(b bVar) {
        this.f4047a = bVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == p033f3.d.f3969a;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        try {
            lazySet(p033f3.d.f3969a);
            this.f4047a.accept(null, th);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            a.onError(new p017c3.c(th, th2));
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        p033f3.d.f(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        try {
            lazySet(p033f3.d.f3969a);
            this.f4047a.accept(obj, null);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            a.onError(th);
        }
    }
}
