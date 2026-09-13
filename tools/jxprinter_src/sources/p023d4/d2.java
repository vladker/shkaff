package p023d4;

import E3.g;
import kotlinx.coroutines.flow.internal.AbstractC1115d;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d2 extends AbstractC1115d {
    public g<? super Q> cont;
    public long index;

    @Override // kotlinx.coroutines.flow.internal.AbstractC1115d
    /* JADX INFO: renamed from: allocateLocked, reason: merged with bridge method [inline-methods] */
    public boolean a(a2 a2Var) {
        if (this.index >= 0) {
            return false;
        }
        long j6 = a2Var.e;
        if (j6 < a2Var.f3850f) {
            a2Var.f3850f = j6;
        }
        this.index = j6;
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1115d
    public g<Q>[] freeLocked(a2 a2Var) {
        long j6 = this.index;
        this.index = -1L;
        this.cont = null;
        return a2Var.updateCollectorIndexLocked$kotlinx_coroutines_core(j6);
    }
}
