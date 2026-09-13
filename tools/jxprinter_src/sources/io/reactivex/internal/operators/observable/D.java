package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D extends AbstractC0838a {
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final io.reactivex.N e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Callable f4894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4896h;

    public D(io.reactivex.B b, long j6, long j7, TimeUnit timeUnit, io.reactivex.N n6, Callable callable, int i5, boolean z6) {
        super(b);
        this.b = j6;
        this.c = j7;
        this.d = timeUnit;
        this.e = n6;
        this.f4894f = callable;
        this.f4895g = i5;
        this.f4896h = z6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        long j6 = this.b;
        long j7 = this.c;
        io.reactivex.N n6 = this.e;
        TimeUnit timeUnit = this.d;
        Callable callable = this.f4894f;
        io.reactivex.G g6 = this.f5141a;
        if (j6 == j7 && this.f4895g == Integer.MAX_VALUE) {
            g6.subscribe(new A(new p112t3.e(i5), callable, this.b, timeUnit, n6));
            return;
        }
        io.reactivex.M mCreateWorker = n6.createWorker();
        if (j6 != j7) {
            g6.subscribe(new C(new p112t3.e(i5), callable, this.b, this.c, timeUnit, mCreateWorker));
            return;
        }
        g6.subscribe(new RunnableC0958z(new p112t3.e(i5), callable, this.b, timeUnit, this.f4895g, this.f4896h, mCreateWorker));
    }
}
