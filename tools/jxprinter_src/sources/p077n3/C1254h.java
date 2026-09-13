package p077n3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.O;
import io.reactivex.S;
import io.reactivex.V;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p048i3.t;

/* JADX INFO: renamed from: n3.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1254h extends AtomicReference implements InterfaceC0679f, c {
    private static final long serialVersionUID = -8565274649390031272L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6296a;
    public final V b;

    public C1254h(S s6, V v6) {
        this.f6296a = s6;
        this.b = v6;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        ((O) this.b).subscribe(new t(this, this.f6296a, 0));
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.f6296a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f6296a.onSubscribe(this);
        }
    }
}
