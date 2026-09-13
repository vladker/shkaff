package p059k3;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.a;
import p027e3.g;
import p033f3.d;

/* JADX INFO: renamed from: k3.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1018e extends AtomicReference implements InterfaceC0988v, c {
    private static final long serialVersionUID = -6076952298809384986L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f5545a;
    public final g b;
    public final a c;

    public C1018e(g gVar, g gVar2, a aVar) {
        this.f5545a = gVar;
        this.b = gVar2;
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

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        lazySet(d.f3969a);
        try {
            this.c.run();
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            io.reactivex.plugins.a.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        lazySet(d.f3969a);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            io.reactivex.plugins.a.onError(new p017c3.c(th, th2));
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        lazySet(d.f3969a);
        try {
            this.f5545a.accept(obj);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            io.reactivex.plugins.a.onError(th);
        }
    }
}
