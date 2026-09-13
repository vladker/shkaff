package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.w1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC0948w1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.B f5304a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.N d;

    public CallableC0948w1(io.reactivex.B b, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        this.f5304a = b;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f5304a.replay(this.b, this.c, this.d);
    }
}
