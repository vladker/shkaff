package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.k1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC0890k1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.B f5222a;
    public final int b;
    public final long c;
    public final TimeUnit d;
    public final io.reactivex.N e;

    public CallableC0890k1(int i5, long j6, io.reactivex.B b, io.reactivex.N n6, TimeUnit timeUnit) {
        this.f5222a = b;
        this.b = i5;
        this.c = j6;
        this.d = timeUnit;
        this.e = n6;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f5222a.replay(this.b, this.c, this.d, this.e);
    }
}
