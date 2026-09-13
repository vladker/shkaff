package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X2 extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final io.reactivex.G c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ X2(io.reactivex.B b, io.reactivex.G g6, int i5) {
        super(b);
        this.b = i5;
        this.c = g6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                p112t3.e eVar = new p112t3.e(i5);
                p033f3.a aVar = new p033f3.a(2);
                eVar.onSubscribe(aVar);
                W2 w6 = new W2(eVar, aVar);
                this.c.subscribe(new V2(aVar, w6, eVar));
                this.f5141a.subscribe(w6);
                break;
            case 1:
                C0904n0 c0904n0 = new C0904n0(i5, this.c);
                i5.onSubscribe(c0904n0.c);
                this.f5141a.subscribe(c0904n0);
                break;
            default:
                C0877h3 c0877h3 = new C0877h3(i5);
                i5.onSubscribe(c0877h3);
                this.c.subscribe(c0877h3.c);
                this.f5141a.subscribe(c0877h3);
                break;
        }
    }
}
