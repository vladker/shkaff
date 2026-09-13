package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z extends AbstractC0838a {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Z(io.reactivex.G g6, int i5) {
        super(g6);
        this.b = i5;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                this.f5141a.subscribe(new Y((Object) i5, 0));
                return;
            case 1:
                C0914p0 c0914p0 = new C0914p0();
                c0914p0.b = i5;
                this.f5141a.subscribe(c0914p0);
                return;
            case 2:
                this.f5141a.subscribe(new C0914p0(i5, 1));
                return;
            case 3:
                this.f5141a.subscribe(new C0914p0(i5, 2));
                return;
            case 4:
                try {
                    throw null;
                } catch (NullPointerException e) {
                    throw e;
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    io.reactivex.plugins.a.onError(th);
                    NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
                    nullPointerException.initCause(th);
                    throw nullPointerException;
                }
            case 5:
                this.f5141a.subscribe(new C0914p0(i5, 3));
                return;
            case 6:
                this.f5141a.subscribe(new p112t3.e(i5));
                return;
            default:
                this.f5141a.subscribe(new E1(i5, 1));
                return;
        }
    }
}
