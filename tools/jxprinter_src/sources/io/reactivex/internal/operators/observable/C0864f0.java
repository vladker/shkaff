package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.f0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0864f0 extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final p027e3.o c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0864f0(io.reactivex.G g6, p027e3.o oVar, int i5) {
        super(g6);
        this.b = i5;
        this.c = oVar;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                this.f5141a.subscribe(new C0859e0(new p112t3.e(i5), this.c));
                break;
            case 1:
                this.f5141a.subscribe(new C0909o0(i5, this.c));
                break;
            case 2:
                this.f5141a.subscribe(new R0(i5, this.c, 0));
                break;
            case 3:
                this.f5141a.subscribe(new G1(i5, this.c));
                break;
            case 4:
                this.f5141a.subscribe(new R0(i5, this.c, 1));
                break;
            case 5:
                p129w3.b bVarCreate = p129w3.b.create();
                try {
                    Object objApply = this.c.apply(bVarCreate);
                    p039g3.A.b(objApply, "The selector returned a null ObservableSource");
                    io.reactivex.G g6 = (io.reactivex.G) objApply;
                    X1 x6 = new X1(i5);
                    g6.subscribe(x6);
                    this.f5141a.subscribe(new W1(bVarCreate, x6, 0));
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    i5.onSubscribe(p033f3.e.f3970a);
                    i5.onError(th);
                    return;
                }
                break;
            case 6:
                p129w3.d serialized = p129w3.b.create().toSerialized();
                try {
                    Object objApply2 = this.c.apply(serialized);
                    p039g3.A.b(objApply2, "The handler returned a null ObservableSource");
                    io.reactivex.G g7 = (io.reactivex.G) objApply2;
                    C0891k2 c0891k2 = new C0891k2(i5, serialized, this.f5141a);
                    i5.onSubscribe(c0891k2);
                    g7.subscribe(c0891k2.e);
                    c0891k2.a();
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    i5.onSubscribe(p033f3.e.f3970a);
                    i5.onError(th2);
                    return;
                }
                break;
            default:
                p129w3.d serialized2 = p129w3.b.create().toSerialized();
                try {
                    Object objApply3 = this.c.apply(serialized2);
                    p039g3.A.b(objApply3, "The handler returned a null ObservableSource");
                    io.reactivex.G g8 = (io.reactivex.G) objApply3;
                    E2 e6 = new E2(i5, serialized2, this.f5141a);
                    i5.onSubscribe(e6);
                    g8.subscribe(e6.e);
                    e6.a();
                } catch (Throwable th3) {
                    p017c3.d.throwIfFatal(th3);
                    i5.onSubscribe(p033f3.e.f3970a);
                    i5.onError(th3);
                }
                break;
        }
    }
}
