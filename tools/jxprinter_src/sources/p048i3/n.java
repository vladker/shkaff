package p048i3;

import io.reactivex.I;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.a;
import p027e3.g;
import p027e3.q;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends AtomicReference implements I, c {
    private static final long serialVersionUID = -4403180040475402120L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f4055a;
    public final g b;
    public final a c;
    public boolean d;

    public n(q qVar, g gVar, a aVar) {
        this.f4055a = qVar;
        this.b = gVar;
        this.c = aVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        try {
            this.c.run();
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            io.reactivex.plugins.a.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.d) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.d = true;
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            io.reactivex.plugins.a.onError(new p017c3.c(th, th2));
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        try {
            if (this.f4055a.test(obj)) {
                return;
            }
            d.a(this);
            onComplete();
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            d.a(this);
            onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }
}
