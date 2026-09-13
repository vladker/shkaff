package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final io.reactivex.V c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ X(io.reactivex.B b, io.reactivex.V v6, int i5) {
        super(b);
        this.b = i5;
        this.c = v6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                this.f5141a.subscribe(new W(i5, this.c));
                break;
            default:
                N1 n6 = new N1(i5);
                i5.onSubscribe(n6);
                this.f5141a.subscribe(n6);
                ((io.reactivex.O) this.c).subscribe(n6.c);
                break;
        }
    }
}
