package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.u2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0940u2 implements InterfaceC0901m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5287a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.N d;

    public C0940u2(int i5, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        this.f5287a = i5;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0901m2
    public final InterfaceC0925r2 call() {
        return new C0945v2(this.f5287a, this.b, this.c, this.d);
    }
}
