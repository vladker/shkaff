package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.N;
import java.util.concurrent.TimeUnit;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5422a;
    public final TimeUnit b;
    public final N c;

    public Q(long j6, TimeUnit timeUnit, N n6) {
        this.f5422a = j6;
        this.b = timeUnit;
        this.c = n6;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        P p6 = new P(interfaceC0679f);
        interfaceC0679f.onSubscribe(p6);
        d.c(p6, this.c.scheduleDirect(p6, this.f5422a, this.b));
    }
}
