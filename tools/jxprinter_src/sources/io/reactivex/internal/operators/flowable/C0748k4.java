package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.k4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0748k4 extends AbstractC0683a {
    public final long c;
    public final TimeUnit d;
    public final io.reactivex.N e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f4692g;

    public C0748k4(int i5, long j6, AbstractC0979l abstractC0979l, io.reactivex.N n6, TimeUnit timeUnit, boolean z6) {
        super(abstractC0979l);
        this.c = j6;
        this.d = timeUnit;
        this.e = n6;
        this.f4691f = i5;
        this.f4692g = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        this.b.subscribe((InterfaceC0984q) new C0742j4(cVar, this.c, this.d, this.e, this.f4691f, this.f4692g));
    }
}
