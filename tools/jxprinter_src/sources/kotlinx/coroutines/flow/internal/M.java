package kotlinx.coroutines.flow.internal;

import p023d4.C0577c0;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M implements InterfaceC0615p {
    private final Object countOrElement;
    private final E3.q emitContext;
    private final O3.p emitRef;

    public M(InterfaceC0615p interfaceC0615p, E3.q qVar) {
        this.emitContext = qVar;
        this.countOrElement = p028e4.L.threadContextElements(qVar);
        this.emitRef = new C0577c0(interfaceC0615p, null, 1);
    }

    @Override // p023d4.InterfaceC0615p
    public Object emit(Object obj, E3.g<? super Q> gVar) {
        Object objWithContextUndispatched = AbstractC1118g.withContextUndispatched(this.emitContext, obj, this.countOrElement, this.emitRef, gVar);
        return objWithContextUndispatched == F3.i.getCOROUTINE_SUSPENDED() ? objWithContextUndispatched : Q.INSTANCE;
    }
}
