package io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G3 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4264a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.N d;

    public G3(int i5, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        this.f4264a = i5;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return new H3(this.f4264a, this.b, this.c, this.d);
    }
}
