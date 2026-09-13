package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.l0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0894l0 extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final long c;
    public final TimeUnit d;
    public final io.reactivex.N e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f5229f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0894l0(int i5, long j6, io.reactivex.B b, io.reactivex.N n6, TimeUnit timeUnit, boolean z6) {
        super(b);
        this.b = i5;
        this.c = j6;
        this.d = timeUnit;
        this.e = n6;
        this.f5229f = z6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                io.reactivex.I eVar = this.f5229f ? i5 : new p112t3.e(i5);
                this.f5141a.subscribe(new C0889k0(eVar, this.c, this.d, this.e.createWorker(), this.f5229f));
                break;
            case 1:
                p112t3.e eVar2 = new p112t3.e(i5);
                boolean z6 = this.f5229f;
                io.reactivex.N n6 = this.e;
                TimeUnit timeUnit = this.d;
                io.reactivex.G g6 = this.f5141a;
                if (!z6) {
                    g6.subscribe(new G2(eVar2, this.c, timeUnit, n6));
                } else {
                    g6.subscribe(new F2(eVar2, this.c, timeUnit, n6));
                }
                break;
            default:
                this.f5141a.subscribe(new RunnableC0887j3(i5, this.c, this.d, this.e.createWorker(), this.f5229f));
                break;
        }
    }
}
