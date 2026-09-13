package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k5 implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n5 f4693a;

    public k5(n5 n5Var) {
        this.f4693a = n5Var;
    }

    @Override // p027e3.o
    public Object apply(Object obj) {
        Object objApply = this.f4693a.c.apply(new Object[]{obj});
        p039g3.A.b(objApply, "The combiner returned a null value");
        return objApply;
    }
}
