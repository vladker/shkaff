package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.N;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: j3.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1006q extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0676c f5450a;
    public final long b;
    public final TimeUnit c;
    public final N d;
    public final boolean e;

    public C1006q(AbstractC0676c abstractC0676c, long j6, TimeUnit timeUnit, N n6, boolean z6) {
        this.f5450a = abstractC0676c;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
        this.e = z6;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        this.f5450a.subscribe(new RunnableC1005p(interfaceC0679f, this.b, this.c, this.d, this.e));
    }
}
