package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.f3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0867f3 extends AbstractC0838a {
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final io.reactivex.N e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f5189g;

    public C0867f3(io.reactivex.B b, long j6, long j7, TimeUnit timeUnit, io.reactivex.N n6, int i5, boolean z6) {
        super(b);
        this.b = j6;
        this.c = j7;
        this.d = timeUnit;
        this.e = n6;
        this.f5188f = i5;
        this.f5189g = z6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        this.f5141a.subscribe(new C0862e3(i5, this.b, this.c, this.d, this.e, this.f5188f, this.f5189g));
    }
}
