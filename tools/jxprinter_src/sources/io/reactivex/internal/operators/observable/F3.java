package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F3 extends AbstractC0838a {
    public final io.reactivex.G b;
    public final p027e3.o c;
    public final int d;

    public F3(io.reactivex.B b, io.reactivex.G g6, p027e3.o oVar, int i5) {
        super(b);
        this.b = g6;
        this.c = oVar;
        this.d = i5;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        this.f5141a.subscribe(new D3(new p112t3.e(i5), this.b, this.c, this.d));
    }
}
