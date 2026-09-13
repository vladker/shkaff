package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.c2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0698c2 implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p027e3.o f4578a;

    public C0698c2(p027e3.o oVar) {
        this.f4578a = oVar;
    }

    @Override // p027e3.o
    public t5.b apply(Object obj) {
        Object objApply = this.f4578a.apply(obj);
        p039g3.A.b(objApply, "The itemDelay returned a null Publisher");
        return new H1((t5.b) objApply, 1).map(new p039g3.m(obj)).defaultIfEmpty(obj);
    }
}
