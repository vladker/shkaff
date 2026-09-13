package kotlinx.coroutines.flow.internal;

import p007a4.N;
import p018c4.EnumC0368b;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends AbstractC1122k {
    private final O3.q transform;

    public o(O3.q qVar, InterfaceC0612o interfaceC0612o, E3.q qVar2, int i5, EnumC0368b enumC0368b) {
        super(interfaceC0612o, qVar2, i5, enumC0368b);
        this.transform = qVar;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public AbstractC1117f create(E3.q qVar, int i5, EnumC0368b enumC0368b) {
        return new o(this.transform, this.flow, qVar, i5, enumC0368b);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1122k
    public Object flowCollect(InterfaceC0615p interfaceC0615p, E3.g<? super Q> gVar) {
        Object objCoroutineScope = N.coroutineScope(new n(this, interfaceC0615p, null), gVar);
        return objCoroutineScope == F3.i.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Q.INSTANCE;
    }
}
