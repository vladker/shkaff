package p077n3;

import io.reactivex.I;
import io.reactivex.O;
import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p048i3.t;

/* JADX INFO: renamed from: n3.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1255i extends AtomicReference implements I, c {
    private static final long serialVersionUID = -8565274649390031272L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6297a;
    public final O b;
    public boolean c;

    public C1255i(O o6, S s6) {
        this.f6297a = s6;
        this.b = o6;
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
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.subscribe(new t(this, this.f6297a, 0));
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.c) {
            a.onError(th);
        } else {
            this.c = true;
            this.f6297a.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        ((c) get()).dispose();
        onComplete();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        if (d.d(this, cVar)) {
            this.f6297a.onSubscribe(this);
        }
    }
}
