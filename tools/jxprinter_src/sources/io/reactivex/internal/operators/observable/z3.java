package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class z3 extends AbstractC0838a {
    public final long b;
    public final long c;
    public final int d;

    public z3(io.reactivex.B b, long j6, long j7, int i5) {
        super(b);
        this.b = j6;
        this.c = j7;
        this.d = i5;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        long j6 = this.c;
        long j7 = this.b;
        io.reactivex.G g6 = this.f5141a;
        if (j7 == j6) {
            g6.subscribe(new x3(i5, j7, this.d));
            return;
        }
        g6.subscribe(new y3(i5, this.b, this.c, this.d));
    }
}
