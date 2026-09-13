package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q extends AbstractC0838a {
    public final p027e3.o b;
    public final int c;
    public final int d;
    public final int e;

    public Q(io.reactivex.B b, p027e3.o oVar, int i5, int i6, int i7) {
        super(b);
        this.b = oVar;
        this.c = i5;
        this.d = i6;
        this.e = i7;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        this.f5141a.subscribe(new P(i5, this.b, this.d, this.e, this.c));
    }
}
