package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0937u extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final p027e3.o c;
    public final Object d;
    public final Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0937u(io.reactivex.B b, io.reactivex.G g6, p027e3.o oVar, Object obj, int i5) {
        super(b);
        this.b = i5;
        this.e = g6;
        this.c = oVar;
        this.d = obj;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                C0927s c0927s = new C0927s(i5, (io.reactivex.G) this.e, this.c, (Callable) this.d);
                i5.onSubscribe(c0927s);
                this.f5141a.subscribe(c0927s);
                break;
            case 1:
                this.f5141a.subscribe(new H1(i5, this.c, (p027e3.o) this.e, (Callable) this.d));
                break;
            default:
                io.reactivex.G g6 = (io.reactivex.G) this.e;
                io.reactivex.G g7 = (io.reactivex.G) this.d;
                io.reactivex.G g8 = this.f5141a;
                p027e3.o oVar = this.c;
                if (g7 != null) {
                    C0902m3 c0902m3 = new C0902m3(oVar, g7, i5);
                    i5.onSubscribe(c0902m3);
                    if (g6 != null) {
                        C0897l3 c0897l3 = new C0897l3(0L, c0902m3);
                        p033f3.h hVar = c0902m3.c;
                        hVar.getClass();
                        if (p033f3.d.c(hVar, c0897l3)) {
                            g6.subscribe(c0897l3);
                        }
                    }
                    g8.subscribe(c0902m3);
                } else {
                    C0907n3 c0907n3 = new C0907n3(i5, oVar);
                    i5.onSubscribe(c0907n3);
                    if (g6 != null) {
                        C0897l3 c0897l4 = new C0897l3(0L, c0907n3);
                        p033f3.h hVar2 = c0907n3.c;
                        hVar2.getClass();
                        if (p033f3.d.c(hVar2, c0897l4)) {
                            g6.subscribe(c0897l4);
                        }
                    }
                    g8.subscribe(c0907n3);
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0937u(io.reactivex.B b, p027e3.o oVar, p027e3.o oVar2, Callable callable) {
        super(b);
        this.b = 1;
        this.c = oVar;
        this.e = oVar2;
        this.d = callable;
    }
}
