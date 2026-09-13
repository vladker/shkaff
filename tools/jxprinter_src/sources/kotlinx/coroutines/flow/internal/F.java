package kotlinx.coroutines.flow.internal;

import X3.O;
import p007a4.K0;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F extends G3.d implements InterfaceC0615p {
    public final E3.q collectContext;
    public final int collectContextSize;
    public final InterfaceC0615p collector;
    private E3.g<? super Q> completion_;
    private E3.q lastEmissionContext;

    public F(InterfaceC0615p interfaceC0615p, E3.q qVar) {
        super(C.INSTANCE, E3.r.INSTANCE);
        this.collector = interfaceC0615p;
        this.collectContext = qVar;
        this.collectContextSize = ((Number) qVar.fold(0, new E3.d(14))).intValue();
    }

    public final Object c(E3.g gVar, Object obj) {
        E3.q context = gVar.getContext();
        K0.ensureActive(context);
        E3.q qVar = this.lastEmissionContext;
        if (qVar != context) {
            if (qVar instanceof x) {
                throw new IllegalStateException(O.trimIndent("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((x) qVar).e + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            I.checkContext(this, context);
            this.lastEmissionContext = context;
        }
        this.completion_ = gVar;
        O3.q qVar2 = H.emitFun;
        InterfaceC0615p interfaceC0615p = this.collector;
        kotlin.jvm.internal.E.d(interfaceC0615p, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object objInvoke = qVar2.invoke(interfaceC0615p, obj, this);
        if (!kotlin.jvm.internal.E.a(objInvoke, F3.i.getCOROUTINE_SUSPENDED())) {
            this.completion_ = null;
        }
        return objInvoke;
    }

    @Override // p023d4.InterfaceC0615p
    public Object emit(Object obj, E3.g<? super Q> gVar) {
        try {
            Object objC = c(gVar, obj);
            if (objC == F3.i.getCOROUTINE_SUSPENDED()) {
                G3.h.probeCoroutineSuspended(gVar);
            }
            return objC == F3.i.getCOROUTINE_SUSPENDED() ? objC : Q.INSTANCE;
        } catch (Throwable th) {
            this.lastEmissionContext = new x(th, gVar.getContext());
            throw th;
        }
    }

    @Override // G3.a, G3.e
    public G3.e getCallerFrame() {
        E3.g<? super Q> gVar = this.completion_;
        if (gVar instanceof G3.e) {
            return (G3.e) gVar;
        }
        return null;
    }

    @Override // G3.d, G3.a, E3.g
    public E3.q getContext() {
        E3.q qVar = this.lastEmissionContext;
        return qVar == null ? E3.r.INSTANCE : qVar;
    }

    @Override // G3.a, G3.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // G3.a
    public Object invokeSuspend(Object obj) {
        Throwable thM1362exceptionOrNullimpl = p147z3.u.m1362exceptionOrNullimpl(obj);
        if (thM1362exceptionOrNullimpl != null) {
            this.lastEmissionContext = new x(thM1362exceptionOrNullimpl, getContext());
        }
        E3.g<? super Q> gVar = this.completion_;
        if (gVar != null) {
            gVar.resumeWith(obj);
        }
        return F3.i.getCOROUTINE_SUSPENDED();
    }
}
