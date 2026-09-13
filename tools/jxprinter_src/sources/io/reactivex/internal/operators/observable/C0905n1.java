package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.n1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0905n1 implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p027e3.c f5240a;
    public final p027e3.o b;

    public C0905n1(p027e3.o oVar, p027e3.c cVar) {
        this.f5240a = cVar;
        this.b = oVar;
    }

    @Override // p027e3.o
    public io.reactivex.G apply(Object obj) {
        Object objApply = this.b.apply(obj);
        p039g3.A.b(objApply, "The mapper returned a null ObservableSource");
        return new C0864f0((io.reactivex.G) objApply, new C0900m1(obj, this.f5240a), 3);
    }
}
