package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M3 extends AbstractC0838a {
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final io.reactivex.N e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f5032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f5034h;

    public M3(io.reactivex.B b, long j6, long j7, TimeUnit timeUnit, io.reactivex.N n6, long j8, int i5, boolean z6) {
        super(b);
        this.b = j6;
        this.c = j7;
        this.d = timeUnit;
        this.e = n6;
        this.f5032f = j8;
        this.f5033g = i5;
        this.f5034h = z6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        p112t3.e eVar = new p112t3.e(i5);
        long j6 = this.b;
        long j7 = this.c;
        io.reactivex.N n6 = this.e;
        TimeUnit timeUnit = this.d;
        io.reactivex.G g6 = this.f5141a;
        if (j6 != j7) {
            g6.subscribe(new L3(eVar, j6, j7, timeUnit, n6.createWorker(), this.f5033g));
            return;
        }
        long j8 = this.f5032f;
        if (j8 == LocationRequestCompat.PASSIVE_INTERVAL) {
            g6.subscribe(new J3(eVar, j6, timeUnit, n6, this.f5033g));
        } else {
            g6.subscribe(new I3(eVar, j6, timeUnit, n6, this.f5033g, j8, this.f5034h));
        }
    }
}
