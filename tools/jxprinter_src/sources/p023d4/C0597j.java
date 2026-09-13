package p023d4;

import E3.g;
import E3.q;
import F3.i;
import O3.p;
import kotlinx.coroutines.flow.internal.AbstractC1117f;
import p018c4.EnumC0368b;
import p018c4.x0;
import p147z3.Q;

/* JADX INFO: renamed from: d4.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class C0597j extends AbstractC1117f {
    private final p block;

    public C0597j(p pVar, q qVar, int i5, EnumC0368b enumC0368b) {
        super(qVar, i5, enumC0368b);
        this.block = pVar;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public Object collectTo(x0 x0Var, g<? super Q> gVar) {
        Object objInvoke = this.block.invoke(x0Var, gVar);
        return objInvoke == i.getCOROUTINE_SUSPENDED() ? objInvoke : Q.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public AbstractC1117f create(q qVar, int i5, EnumC0368b enumC0368b) {
        return new C0597j(this.block, qVar, i5, enumC0368b);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public String toString() {
        return "block[" + this.block + "] -> " + super.toString();
    }
}
