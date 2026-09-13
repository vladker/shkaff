package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0918q extends AbstractC0838a {
    public final /* synthetic */ int b = 0;
    public final int c;
    public final int d;
    public final Object e;

    public C0918q(io.reactivex.B b, int i5, int i6, Callable callable) {
        super(b);
        this.c = i5;
        this.d = i6;
        this.e = callable;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                Callable callable = (Callable) this.e;
                io.reactivex.G g6 = this.f5141a;
                int i6 = this.d;
                int i7 = this.c;
                if (i6 != i7) {
                    g6.subscribe(new C0913p(i5, i7, i6, callable));
                } else {
                    C0908o c0908o = new C0908o(i5, i7, callable);
                    if (c0908o.a()) {
                        g6.subscribe(c0908o);
                    }
                }
                break;
            default:
                p027e3.o oVar = (p027e3.o) this.e;
                io.reactivex.G g7 = this.f5141a;
                if (!com.android.billingclient.api.v1.l(oVar, g7, i5)) {
                    int i8 = this.c;
                    int i9 = this.d;
                    if (i9 != 1) {
                        g7.subscribe(new M(i5, oVar, i8, i9 == 3));
                    } else {
                        g7.subscribe(new O(new p112t3.e(i5), oVar, i8));
                    }
                    break;
                }
                break;
        }
    }

    public C0918q(io.reactivex.G g6, p027e3.o oVar, int i5, int i6) {
        super(g6);
        this.e = oVar;
        this.d = i6;
        this.c = Math.max(8, i5);
    }
}
