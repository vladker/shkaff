package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import p007a4.AbstractC0272e;
import p018c4.B0;
import p018c4.EnumC0368b;
import p018c4.v0;
import p018c4.x0;
import p023d4.InterfaceC0612o;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends AbstractC1117f {
    private final Iterable<InterfaceC0612o> flows;

    /* JADX WARN: Multi-variable type inference failed */
    public p(Iterable<? extends InterfaceC0612o> iterable, E3.q qVar, int i5, EnumC0368b enumC0368b) {
        super(qVar, i5, enumC0368b);
        this.flows = iterable;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public Object collectTo(x0 x0Var, E3.g<? super Q> gVar) {
        J j6 = new J(x0Var);
        Iterator<InterfaceC0612o> it = this.flows.iterator();
        while (it.hasNext()) {
            AbstractC0272e.b(x0Var, null, 3, new p018c4.G(it.next(), j6, null, 7));
        }
        return Q.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public AbstractC1117f create(E3.q qVar, int i5, EnumC0368b enumC0368b) {
        return new p(this.flows, qVar, i5, enumC0368b);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public B0 produceImpl(p007a4.M m6) {
        return v0.produce(m6, this.context, this.capacity, getCollectToFun$kotlinx_coroutines_core());
    }
}
