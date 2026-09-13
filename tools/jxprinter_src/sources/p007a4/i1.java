package p007a4;

import E3.g;
import p147z3.Q;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i1 extends O0 {
    private final g<Q> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public i1(g<? super Q> gVar) {
        this.continuation = gVar;
    }

    @Override // p007a4.O0
    public final boolean d() {
        return false;
    }

    @Override // p007a4.O0
    public void invoke(Throwable th) {
        this.continuation.resumeWith(u.m1361constructorimpl(Q.INSTANCE));
    }
}
