package p088p3;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.a;
import p027e3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends AtomicReference implements InterfaceC0984q, d, c {
    private static final long serialVersionUID = -7251123623727029452L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f7746a;
    public final g b;
    public final a c;
    public final g d;

    public j(g gVar, g gVar2, a aVar, g gVar3) {
        this.f7746a = gVar;
        this.b = gVar2;
        this.c = aVar;
        this.d = gVar3;
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this);
    }

    @Override // p011b3.c
    public final void dispose() {
        p094q3.g.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == p094q3.g.f7849a;
    }

    @Override // t5.c
    public final void onComplete() {
        Object obj = get();
        p094q3.g gVar = p094q3.g.f7849a;
        if (obj != gVar) {
            lazySet(gVar);
            try {
                this.c.run();
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                io.reactivex.plugins.a.onError(th);
            }
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        Object obj = get();
        p094q3.g gVar = p094q3.g.f7849a;
        if (obj == gVar) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        lazySet(gVar);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            io.reactivex.plugins.a.onError(new p017c3.c(th, th2));
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (e()) {
            return;
        }
        try {
            this.f7746a.accept(obj);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            ((d) get()).cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (p094q3.g.e(this, dVar)) {
            try {
                this.d.accept(this);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                dVar.cancel();
                onError(th);
            }
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        ((d) get()).request(j6);
    }
}
