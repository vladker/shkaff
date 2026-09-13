package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p048i3.t;

/* JADX INFO: renamed from: n3.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1258l extends AtomicReference implements S, c {
    private static final long serialVersionUID = -8565274649390031272L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6300a;
    public final O b;

    public C1258l(O o6, S s6) {
        this.f6300a = s6;
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

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f6300a.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f6300a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.b.subscribe(new t((Object) this, (Object) this.f6300a, 0));
    }
}
