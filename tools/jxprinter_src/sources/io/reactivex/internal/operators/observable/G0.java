package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G0 extends AbstractC0838a {
    public final p027e3.o b;
    public final boolean c;
    public final int d;
    public final int e;

    public G0(io.reactivex.G g6, p027e3.o oVar, boolean z6, int i5, int i6) {
        super(g6);
        this.b = oVar;
        this.c = z6;
        this.d = i5;
        this.e = i6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        p027e3.o oVar = this.b;
        io.reactivex.G g6 = this.f5141a;
        if (com.android.billingclient.api.v1.l(oVar, g6, i5)) {
            return;
        }
        g6.subscribe(new F0(this.d, this.e, oVar, i5, this.c));
    }
}
