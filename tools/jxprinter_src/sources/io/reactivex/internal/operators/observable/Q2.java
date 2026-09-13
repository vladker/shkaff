package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q2 extends io.reactivex.O implements p043h3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.G f5094a;
    public final io.reactivex.G b;
    public final p027e3.d c;
    public final int d;

    public Q2(io.reactivex.G g6, io.reactivex.G g7, p027e3.d dVar, int i5) {
        this.f5094a = g6;
        this.b = g7;
        this.c = dVar;
        this.d = i5;
    }

    @Override // p043h3.d
    public final io.reactivex.B b() {
        return io.reactivex.plugins.a.onAssembly(new C0903n(this.f5094a, this.b, this.c, this.d));
    }

    @Override // io.reactivex.O
    public final void subscribeActual(io.reactivex.S s6) {
        P2 p6 = new P2(s6, this.d, this.f5094a, this.b, this.c);
        s6.onSubscribe(p6);
        O2[] o2Arr = p6.f5082f;
        p6.d.subscribe(o2Arr[0]);
        p6.e.subscribe(o2Arr[1]);
    }
}
