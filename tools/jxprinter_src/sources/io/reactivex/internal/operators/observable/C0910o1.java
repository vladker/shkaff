package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.o1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0910o1 implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p027e3.o f5246a;

    public C0910o1(p027e3.o oVar) {
        this.f5246a = oVar;
    }

    @Override // p027e3.o
    public io.reactivex.G apply(Object obj) {
        Object objApply = this.f5246a.apply(obj);
        p039g3.A.b(objApply, "The itemDelay returned a null ObservableSource");
        return new C0876h2((io.reactivex.G) objApply, 1L, 2).map(new p039g3.m(obj)).defaultIfEmpty(obj);
    }
}
