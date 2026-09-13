package kotlinx.coroutines.flow.internal;

import p023d4.a2;
import p023d4.n2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L extends a2 implements n2 {
    public final void q(int i5) {
        synchronized (this) {
            b(Integer.valueOf(((Number) k()).intValue() + i5));
        }
    }

    @Override // p023d4.n2
    public Integer getValue() {
        Integer numValueOf;
        synchronized (this) {
            numValueOf = Integer.valueOf(((Number) k()).intValue());
        }
        return numValueOf;
    }
}
