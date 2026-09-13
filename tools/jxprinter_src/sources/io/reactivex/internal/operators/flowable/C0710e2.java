package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.e2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0710e2 implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p027e3.o f4598a;
    public final io.reactivex.N b;

    public C0710e2(p027e3.o oVar, io.reactivex.N n6) {
        this.f4598a = oVar;
        this.b = n6;
    }

    @Override // p027e3.o
    public t5.b apply(AbstractC0979l abstractC0979l) {
        Object objApply = this.f4598a.apply(abstractC0979l);
        p039g3.A.b(objApply, "The selector returned a null Publisher");
        return AbstractC0979l.fromPublisher((t5.b) objApply).observeOn(this.b);
    }
}
