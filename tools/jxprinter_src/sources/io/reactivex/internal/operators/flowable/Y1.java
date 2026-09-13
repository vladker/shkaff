package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0979l f4519a;
    public final int b;
    public final long c;
    public final TimeUnit d;
    public final io.reactivex.N e;

    public Y1(AbstractC0979l abstractC0979l, int i5, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        this.f4519a = abstractC0979l;
        this.b = i5;
        this.c = j6;
        this.d = timeUnit;
        this.e = n6;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f4519a.replay(this.b, this.c, this.d, this.e);
    }
}
