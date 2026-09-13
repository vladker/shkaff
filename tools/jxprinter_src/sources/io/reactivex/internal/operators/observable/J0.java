package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J0 extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final Object c;
    public final boolean d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ J0(io.reactivex.B b, Object obj, boolean z6, int i5) {
        super(b);
        this.b = i5;
        this.c = obj;
        this.d = z6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                this.f5141a.subscribe(new I0(i5, (p027e3.o) this.c, this.d));
                break;
            case 1:
                this.f5141a.subscribe(new O0(i5, (p027e3.o) this.c, this.d));
                break;
            case 2:
                this.f5141a.subscribe(new Q0(i5, (p027e3.o) this.c, this.d));
                break;
            case 3:
                R1 r6 = new R1(i5, (p027e3.o) this.c, this.d);
                i5.onSubscribe(r6.d);
                this.f5141a.subscribe(r6);
                break;
            default:
                io.reactivex.G g6 = (io.reactivex.G) this.c;
                p112t3.e eVar = new p112t3.e(i5);
                boolean z6 = this.d;
                io.reactivex.G g7 = this.f5141a;
                if (!z6) {
                    g7.subscribe(new J2(eVar, g6));
                } else {
                    g7.subscribe(new I2(eVar, g6));
                }
                break;
        }
    }
}
