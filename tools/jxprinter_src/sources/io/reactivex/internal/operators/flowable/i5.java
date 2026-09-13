package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i5 extends AbstractC0683a {
    public final long c;
    public final long d;
    public final TimeUnit e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.reactivex.N f4671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f4673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f4674i;

    public i5(AbstractC0979l abstractC0979l, long j6, long j7, TimeUnit timeUnit, io.reactivex.N n6, long j8, int i5, boolean z6) {
        super(abstractC0979l);
        this.c = j6;
        this.d = j7;
        this.e = timeUnit;
        this.f4671f = n6;
        this.f4672g = j8;
        this.f4673h = i5;
        this.f4674i = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        p135x3.c cVar2 = new p135x3.c(cVar);
        long j6 = this.c;
        long j7 = this.d;
        AbstractC0979l abstractC0979l = this.b;
        if (j6 != j7) {
            abstractC0979l.subscribe((InterfaceC0984q) new h5(cVar2, j6, j7, this.e, this.f4671f.createWorker(), this.f4673h));
            return;
        }
        long j8 = this.f4672g;
        if (j8 == LocationRequestCompat.PASSIVE_INTERVAL) {
            abstractC0979l.subscribe((InterfaceC0984q) new f5(cVar2, j6, this.e, this.f4671f, this.f4673h));
        } else {
            abstractC0979l.subscribe((InterfaceC0984q) new e5(cVar2, j6, this.e, this.f4671f, this.f4673h, j8, this.f4674i));
        }
    }
}
