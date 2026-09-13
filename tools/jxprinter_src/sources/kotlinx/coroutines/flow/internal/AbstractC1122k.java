package kotlinx.coroutines.flow.internal;

import p018c4.EnumC0368b;
import p018c4.x0;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1122k extends AbstractC1117f {
    protected final InterfaceC0612o flow;

    public AbstractC1122k(InterfaceC0612o interfaceC0612o, E3.q qVar, int i5, EnumC0368b enumC0368b) {
        super(qVar, i5, enumC0368b);
        this.flow = interfaceC0612o;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f, kotlinx.coroutines.flow.internal.B, p023d4.InterfaceC0612o
    public Object collect(InterfaceC0615p interfaceC0615p, E3.g<? super Q> gVar) {
        if (this.capacity == -3) {
            E3.q context = gVar.getContext();
            E3.q qVarNewCoroutineContext = p007a4.D.newCoroutineContext(context, this.context);
            if (kotlin.jvm.internal.E.a(qVarNewCoroutineContext, context)) {
                Object objFlowCollect = flowCollect(interfaceC0615p, gVar);
                return objFlowCollect == F3.i.getCOROUTINE_SUSPENDED() ? objFlowCollect : Q.INSTANCE;
            }
            E3.i iVar = E3.j.Key;
            if (kotlin.jvm.internal.E.a(qVarNewCoroutineContext.get(iVar), context.get(iVar))) {
                E3.q context2 = gVar.getContext();
                if (!(interfaceC0615p instanceof J) && !(interfaceC0615p instanceof D)) {
                    interfaceC0615p = new M(interfaceC0615p, context2);
                }
                Object objWithContextUndispatched = AbstractC1118g.withContextUndispatched(qVarNewCoroutineContext, interfaceC0615p, p028e4.L.threadContextElements(qVarNewCoroutineContext), new p018c4.G(this, null, 6), gVar);
                return objWithContextUndispatched == F3.i.getCOROUTINE_SUSPENDED() ? objWithContextUndispatched : Q.INSTANCE;
            }
        }
        Object objCollect = super.collect(interfaceC0615p, gVar);
        return objCollect == F3.i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public Object collectTo(x0 x0Var, E3.g<? super Q> gVar) {
        Object objFlowCollect = flowCollect(new J(x0Var), gVar);
        return objFlowCollect == F3.i.getCOROUTINE_SUSPENDED() ? objFlowCollect : Q.INSTANCE;
    }

    public abstract Object flowCollect(InterfaceC0615p interfaceC0615p, E3.g<? super Q> gVar);

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public String toString() {
        return this.flow + " -> " + super.toString();
    }
}
