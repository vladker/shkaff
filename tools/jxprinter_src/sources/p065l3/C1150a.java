package p065l3;

import io.reactivex.G;
import io.reactivex.I;
import io.reactivex.InterfaceC0679f;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: renamed from: l3.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1150a extends AtomicReference implements I, InterfaceC0679f, c {
    private static final long serialVersionUID = -8948264376121066672L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f5818a;
    public G b;

    public C1150a(I i5, G g6) {
        this.b = g6;
        this.f5818a = i5;
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
        G g6 = this.b;
        if (g6 == null) {
            this.f5818a.onComplete();
        } else {
            this.b = null;
            g6.subscribe(this);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5818a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5818a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        d.c(this, cVar);
    }
}
