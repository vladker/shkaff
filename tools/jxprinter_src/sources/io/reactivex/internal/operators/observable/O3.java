package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O3 implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ R3 f5062a;

    public O3(R3 r6) {
        this.f5062a = r6;
    }

    @Override // p027e3.o
    public Object apply(Object obj) {
        Object objApply = this.f5062a.combiner.apply(new Object[]{obj});
        p039g3.A.b(objApply, "The combiner returned a null value");
        return objApply;
    }
}
