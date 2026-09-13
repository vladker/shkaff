package p077n3;

import io.reactivex.N;
import io.reactivex.O;
import io.reactivex.S;
import java.util.concurrent.TimeUnit;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6279a;
    public final TimeUnit b;
    public final N c;

    public T(long j6, TimeUnit timeUnit, N n6) {
        this.f6279a = j6;
        this.b = timeUnit;
        this.c = n6;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        S s7 = new S(s6);
        s6.onSubscribe(s7);
        d.c(s7, this.c.scheduleDirect(s7, this.f6279a, this.b));
    }
}
