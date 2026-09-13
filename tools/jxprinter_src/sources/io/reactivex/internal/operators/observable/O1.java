package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O1 extends io.reactivex.B {
    public static final O1 b = new O1(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5059a;

    public /* synthetic */ O1(int i5) {
        this.f5059a = i5;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.f5059a) {
            case 0:
                i5.onSubscribe(p033f3.e.b);
                return;
            default:
                C0844b0 c0844b0 = new C0844b0(i5);
                i5.onSubscribe(c0844b0);
                try {
                    throw null;
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    c0844b0.onError(th);
                    return;
                }
        }
    }
}
