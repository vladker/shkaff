package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.t1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0934t1 implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p027e3.o f5282a;
    public final io.reactivex.N b;

    public C0934t1(p027e3.o oVar, io.reactivex.N n6) {
        this.f5282a = oVar;
        this.b = n6;
    }

    @Override // p027e3.o
    public io.reactivex.G apply(io.reactivex.B<Object> b) {
        Object objApply = this.f5282a.apply(b);
        p039g3.A.b(objApply, "The selector returned a null ObservableSource");
        return io.reactivex.B.wrap((io.reactivex.G) objApply).observeOn(this.b);
    }
}
