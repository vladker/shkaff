package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q1 extends AbstractC0838a {
    public final /* synthetic */ int b = 0;
    public final int c;
    public final boolean d;
    public final Object e;

    public Q1(io.reactivex.B b, io.reactivex.N n6, boolean z6, int i5) {
        super(b);
        this.e = n6;
        this.d = z6;
        this.c = i5;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                io.reactivex.N n6 = (io.reactivex.N) this.e;
                boolean z6 = n6 instanceof io.reactivex.internal.schedulers.O;
                io.reactivex.G g6 = this.f5141a;
                if (!z6) {
                    g6.subscribe(new P1(i5, n6.createWorker(), this.d, this.c));
                } else {
                    g6.subscribe(i5);
                }
                break;
            default:
                p027e3.o oVar = (p027e3.o) this.e;
                io.reactivex.G g7 = this.f5141a;
                if (!com.android.billingclient.api.v1.l(oVar, g7, i5)) {
                    g7.subscribe(new C0847b3(i5, oVar, this.c, this.d));
                    break;
                }
                break;
        }
    }

    public Q1(io.reactivex.G g6, p027e3.o oVar, int i5, boolean z6) {
        super(g6);
        this.e = oVar;
        this.c = i5;
        this.d = z6;
    }
}
