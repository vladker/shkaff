package p007a4;

import E3.g;
import E3.q;
import F3.h;
import O3.p;
import p034f4.a;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z0 extends W {
    private final g<Q> continuation;

    public Z0(q qVar, p pVar) {
        super(qVar, false);
        this.continuation = h.createCoroutineUnintercepted(pVar, this, this);
    }

    @Override // p007a4.X0
    public final void o() {
        a.startCoroutineCancellable(this.continuation, this);
    }
}
