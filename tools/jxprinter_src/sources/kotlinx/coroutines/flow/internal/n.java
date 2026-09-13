package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.T;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends G3.m implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5712a = 0;
    public int b;
    public final /* synthetic */ o c;
    public final /* synthetic */ InterfaceC0615p d;
    public /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, InterfaceC0615p interfaceC0615p, E3.g gVar) {
        super(2, gVar);
        this.c = oVar;
        this.d = interfaceC0615p;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f5712a) {
            case 0:
                n nVar = new n(this.c, this.d, gVar);
                nVar.e = obj;
                return nVar;
            default:
                return new n(this.c, this.d, this.e, gVar);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        p007a4.M m6 = (p007a4.M) obj;
        E3.g gVar = (E3.g) obj2;
        switch (this.f5712a) {
            case 0:
                break;
        }
        return ((n) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f5712a) {
            case 0:
                Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    p147z3.v.throwOnFailure(obj);
                    p007a4.M m6 = (p007a4.M) this.e;
                    T t6 = new T();
                    o oVar = this.c;
                    InterfaceC0612o interfaceC0612o = oVar.flow;
                    C1120i c1120i = new C1120i(t6, m6, oVar, this.d, 1);
                    this.b = 1;
                    if (interfaceC0612o.collect(c1120i, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p147z3.v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            default:
                Object coroutine_suspended2 = F3.i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 == 0) {
                    p147z3.v.throwOnFailure(obj);
                    O3.q qVar = this.c.transform;
                    Object obj2 = this.e;
                    this.b = 1;
                    if (qVar.invoke(this.d, obj2, this) == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p147z3.v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, InterfaceC0615p interfaceC0615p, Object obj, E3.g gVar) {
        super(2, gVar);
        this.c = oVar;
        this.d = interfaceC0615p;
        this.e = obj;
    }
}
