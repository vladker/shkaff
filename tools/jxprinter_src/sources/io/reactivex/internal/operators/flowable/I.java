package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I extends AbstractC0683a {
    public final long c;
    public final long d;
    public final TimeUnit e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.reactivex.N f4277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Callable f4278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f4279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f4280i;

    public I(AbstractC0979l abstractC0979l, long j6, long j7, TimeUnit timeUnit, io.reactivex.N n6, Callable callable, int i5, boolean z6) {
        super(abstractC0979l);
        this.c = j6;
        this.d = j7;
        this.e = timeUnit;
        this.f4277f = n6;
        this.f4278g = callable;
        this.f4279h = i5;
        this.f4280i = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        long j6 = this.d;
        long j7 = this.c;
        AbstractC0979l abstractC0979l = this.b;
        if (j7 == j6 && this.f4279h == Integer.MAX_VALUE) {
            abstractC0979l.subscribe((InterfaceC0984q) new G(new p135x3.c(cVar), this.f4278g, j7, this.e, this.f4277f));
            return;
        }
        io.reactivex.M mCreateWorker = this.f4277f.createWorker();
        long j8 = this.c;
        long j9 = this.d;
        if (j8 != j9) {
            abstractC0979l.subscribe((InterfaceC0984q) new H(new p135x3.c(cVar), this.f4278g, j8, j9, this.e, mCreateWorker));
            return;
        }
        abstractC0979l.subscribe((InterfaceC0984q) new F(new p135x3.c(cVar), this.f4278g, j8, this.e, this.f4279h, this.f4280i, mCreateWorker));
    }
}
