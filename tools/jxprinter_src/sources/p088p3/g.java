package p088p3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p017c3.d;
import p027e3.a;
import p027e3.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends AtomicReference implements InterfaceC0984q, c {
    private static final long serialVersionUID = -4403180040475402120L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f7741a;
    public final p027e3.g b;
    public final a c;
    public boolean d;

    public g(q qVar, p027e3.g gVar, a aVar) {
        this.f7741a = qVar;
        this.b = gVar;
        this.c = aVar;
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
        if (this.d) {
            return;
        }
        this.d = true;
        try {
            this.c.run();
        } catch (Throwable th) {
            d.throwIfFatal(th);
            io.reactivex.plugins.a.onError(th);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.d) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.d = true;
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            d.throwIfFatal(th2);
            io.reactivex.plugins.a.onError(new p017c3.c(th, th2));
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        try {
            if (this.f7741a.test(obj)) {
                return;
            }
            p094q3.g.a(this);
            onComplete();
        } catch (Throwable th) {
            d.throwIfFatal(th);
            p094q3.g.a(this);
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
