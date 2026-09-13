package p077n3;

import io.reactivex.N;
import io.reactivex.O;
import io.reactivex.S;
import io.reactivex.V;
import java.util.concurrent.TimeUnit;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O f6277a;
    public final long b;
    public final TimeUnit c;
    public final N d;
    public final V e;

    public Q(O o6, long j6, TimeUnit timeUnit, N n6, V v6) {
        this.f6277a = o6;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
        this.e = v6;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        P p6 = new P(s6, this.e, this.b, this.c);
        s6.onSubscribe(p6);
        d.c(p6.b, this.d.scheduleDirect(p6, this.b, this.c));
        this.f6277a.subscribe(p6);
    }
}
