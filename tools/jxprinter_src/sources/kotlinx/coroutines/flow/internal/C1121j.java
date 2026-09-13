package kotlinx.coroutines.flow.internal;

import p007a4.H0;
import p018c4.B0;
import p018c4.EnumC0368b;
import p018c4.v0;
import p018c4.x0;
import p023d4.InterfaceC0612o;
import p147z3.Q;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1121j extends AbstractC1117f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5710a;
    private final InterfaceC0612o flow;

    public C1121j(InterfaceC0612o interfaceC0612o, int i5, E3.q qVar, int i6, EnumC0368b enumC0368b) {
        super(qVar, i6, enumC0368b);
        this.flow = interfaceC0612o;
        this.f5710a = i5;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public String additionalToStringProps() {
        return "concurrency=" + this.f5710a;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public Object collectTo(x0 x0Var, E3.g<? super Q> gVar) {
        Object objCollect = this.flow.collect(new C1120i((H0) gVar.getContext().get(H0.Key), p049i4.p.Semaphore(this.f5710a, 0), x0Var, new J(x0Var), 0), gVar);
        return objCollect == F3.i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public AbstractC1117f create(E3.q qVar, int i5, EnumC0368b enumC0368b) {
        return new C1121j(this.flow, this.f5710a, qVar, i5, enumC0368b);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1117f
    public B0 produceImpl(p007a4.M m6) {
        return v0.produce(m6, this.context, this.capacity, getCollectToFun$kotlinx_coroutines_core());
    }
}
