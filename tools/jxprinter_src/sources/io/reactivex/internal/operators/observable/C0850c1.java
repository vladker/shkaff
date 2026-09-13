package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.c1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0850c1 extends AbstractC0838a {
    public final p027e3.o b;
    public final p027e3.o c;
    public final int d;
    public final boolean e;

    public C0850c1(io.reactivex.B b, p027e3.o oVar, p027e3.o oVar2, int i5, boolean z6) {
        super(b);
        this.b = oVar;
        this.c = oVar2;
        this.d = i5;
        this.e = z6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        this.f5141a.subscribe(new Z0(i5, this.b, this.c, this.d, this.e));
    }
}
