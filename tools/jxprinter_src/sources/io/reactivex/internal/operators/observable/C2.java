package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C2 extends AbstractC0838a {
    public final p027e3.q b;
    public final long c;

    public C2(io.reactivex.B b, long j6, p027e3.q qVar) {
        super(b);
        this.b = qVar;
        this.c = j6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        p033f3.h hVar = new p033f3.h();
        i5.onSubscribe(hVar);
        new B2(i5, this.c, this.b, hVar, this.f5141a).a();
    }
}
