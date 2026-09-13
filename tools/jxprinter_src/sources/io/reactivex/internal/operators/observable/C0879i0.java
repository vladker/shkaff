package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.i0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0879i0 extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final long c;
    public final TimeUnit d;
    public final io.reactivex.N e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0879i0(int i5, long j6, io.reactivex.B b, io.reactivex.N n6, TimeUnit timeUnit) {
        super(b);
        this.b = i5;
        this.c = j6;
        this.d = timeUnit;
        this.e = n6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                this.f5141a.subscribe(new C0874h0(new p112t3.e(i5), this.c, this.d, this.e.createWorker()));
                break;
            default:
                this.f5141a.subscribe(new RunnableC0882i3(new p112t3.e(i5), this.c, this.d, this.e.createWorker()));
                break;
        }
    }
}
