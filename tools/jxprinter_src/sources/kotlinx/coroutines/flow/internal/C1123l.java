package kotlinx.coroutines.flow.internal;

import p018c4.EnumC0368b;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1123l extends AbstractC1122k {
    public /* synthetic */ C1123l(InterfaceC0612o interfaceC0612o, int i5, E3.q qVar, int i6, EnumC0368b enumC0368b) {
        this(interfaceC0612o, (i6 & 2) != 0 ? E3.r.INSTANCE : qVar, (i6 & 4) != 0 ? -3 : i5, (i6 & 8) != 0 ? EnumC0368b.f1135a : enumC0368b);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public AbstractC1117f create(E3.q qVar, int i5, EnumC0368b enumC0368b) {
        return new C1123l(this.flow, qVar, i5, enumC0368b);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public InterfaceC0612o dropChannelOperators() {
        return this.flow;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1122k
    public Object flowCollect(InterfaceC0615p interfaceC0615p, E3.g<? super Q> gVar) {
        Object objCollect = this.flow.collect(interfaceC0615p, gVar);
        return objCollect == F3.i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
    }

    public C1123l(InterfaceC0612o interfaceC0612o, E3.q qVar, int i5, EnumC0368b enumC0368b) {
        super(interfaceC0612o, qVar, i5, enumC0368b);
    }
}
