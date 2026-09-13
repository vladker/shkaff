package p077n3;

import io.reactivex.internal.operators.flowable.C0817w2;
import p027e3.o;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0817w2 f6283a;

    public Z(C0817w2 c0817w2) {
        this.f6283a = c0817w2;
    }

    @Override // p027e3.o
    public Object apply(Object obj) {
        Object objApply = ((o) this.f6283a.b).apply(new Object[]{obj});
        A.b(objApply, "The zipper returned a null value");
        return objApply;
    }
}
