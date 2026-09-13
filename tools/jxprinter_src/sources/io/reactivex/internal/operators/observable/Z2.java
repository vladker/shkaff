package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z2 extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final io.reactivex.N c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Z2(io.reactivex.B b, io.reactivex.N n6, int i5) {
        super(b);
        this.b = i5;
        this.c = n6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                Y2 y6 = new Y2(i5);
                i5.onSubscribe(y6);
                p033f3.d.f(y6, this.c.scheduleDirect(new Q0.b(this, 17, y6, false)));
                break;
            default:
                this.f5141a.subscribe(new C0941u3(i5, this.c));
                break;
        }
    }
}
