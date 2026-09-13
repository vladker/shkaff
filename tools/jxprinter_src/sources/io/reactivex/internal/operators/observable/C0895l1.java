package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.l1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0895l1 implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p027e3.o f5230a;

    public C0895l1(p027e3.o oVar) {
        this.f5230a = oVar;
    }

    @Override // p027e3.o
    public io.reactivex.G apply(Object obj) {
        Object objApply = this.f5230a.apply(obj);
        p039g3.A.b(objApply, "The mapper returned a null Iterable");
        return new T0((Iterable) objApply, 1);
    }
}
