package p059k3;

import io.reactivex.internal.operators.observable.C0851c2;
import p027e3.o;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0851c2 f5518a;

    public K0(C0851c2 c0851c2) {
        this.f5518a = c0851c2;
    }

    @Override // p027e3.o
    public Object apply(Object obj) {
        Object objApply = ((o) this.f5518a.c).apply(new Object[]{obj});
        A.b(objApply, "The zipper returned a null value");
        return objApply;
    }
}
