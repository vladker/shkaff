package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U2 extends AbstractC0838a {
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.N d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f5118f;

    public U2(int i5, long j6, io.reactivex.B b, io.reactivex.N n6, TimeUnit timeUnit, boolean z6) {
        super(b);
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
        this.e = i5;
        this.f5118f = z6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        this.f5141a.subscribe(new T2(i5, this.b, this.c, this.d, this.e, this.f5118f));
    }
}
