package kotlinx.coroutines.flow.internal;

import p007a4.InterfaceC0310x;
import p018c4.B0;
import p018c4.P;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E3.q f5721a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ B0 c;
    public final /* synthetic */ InterfaceC0615p d;
    public final /* synthetic */ O3.q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0310x f5722f;

    public u(E3.q qVar, Object obj, B0 b1, InterfaceC0615p interfaceC0615p, O3.q qVar2, InterfaceC0310x interfaceC0310x) {
        this.f5721a = qVar;
        this.b = obj;
        this.c = b1;
        this.d = interfaceC0615p;
        this.e = qVar2;
        this.f5722f = interfaceC0310x;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, E3.g gVar) throws Throwable {
        t tVar;
        if (gVar instanceof t) {
            tVar = (t) gVar;
            int i5 = tVar.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                tVar.c = i5 - Integer.MIN_VALUE;
            } else {
                tVar = new t(this, gVar);
            }
        } else {
            tVar = new t(this, gVar);
        }
        Object obj2 = tVar.f5720a;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = tVar.c;
        if (i6 == 0) {
            p147z3.v.throwOnFailure(obj2);
            Q q6 = Q.INSTANCE;
            P p6 = new P(this.c, this.d, this.e, obj, this.f5722f, null);
            tVar.c = 1;
            if (AbstractC1118g.withContextUndispatched(this.f5721a, q6, this.b, p6, tVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p147z3.v.throwOnFailure(obj2);
        }
        return Q.INSTANCE;
    }
}
