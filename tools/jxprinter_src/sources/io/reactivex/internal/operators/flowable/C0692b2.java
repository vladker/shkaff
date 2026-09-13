package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.b2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0692b2 implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p027e3.c f4570a;
    public final p027e3.o b;

    public C0692b2(p027e3.o oVar, p027e3.c cVar) {
        this.f4570a = cVar;
        this.b = oVar;
    }

    @Override // p027e3.o
    public t5.b apply(Object obj) {
        Object objApply = this.b.apply(obj);
        p039g3.A.b(objApply, "The mapper returned a null Publisher");
        return new C0779q((t5.b) objApply, new C0686a2(obj, this.f4570a), 2);
    }
}
