package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.l;
import O3.p;
import p007a4.M;
import p051j0.f;
import p134x2.K0;
import p134x2.c1;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3804a;
    public int b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ I(Object obj, g gVar, int i5) {
        super(2, gVar);
        this.f3804a = i5;
        this.c = obj;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f3804a) {
            case 0:
                return new I((InterfaceC0612o) this.c, gVar, 0);
            default:
                return new I((l) this.c, gVar, 1);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        M m6 = (M) obj;
        g gVar = (g) obj2;
        switch (this.f3804a) {
            case 0:
                break;
        }
        return ((I) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        u uVarA;
        Object objM1101getWifiStateIoAF18A;
        String ip;
        switch (this.f3804a) {
            case 0:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    InterfaceC0612o interfaceC0612o = (InterfaceC0612o) this.c;
                    this.b = 1;
                    if (AbstractC0618q.collect(interfaceC0612o, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            default:
                l lVar = (l) this.c;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 == 0) {
                    v.throwOnFailure(obj);
                    K0 printer = f.getPrinter();
                    if (printer != null) {
                        this.b = 1;
                        objM1101getWifiStateIoAF18A = printer.m1101getWifiStateIoAF18A(this);
                        if (objM1101getWifiStateIoAF18A == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                    } else {
                        uVarA = null;
                    }
                    if (uVarA != null || (uVarA.b() instanceof u.a)) {
                        lVar.invoke(u.a(u.m1361constructorimpl(v.createFailure(new Exception("get wifi state failed")))));
                    } else {
                        Object objB = uVarA.b();
                        c1 c1Var = (c1) (objB instanceof u.a ? null : objB);
                        if (c1Var == null || (ip = c1Var.getIp()) == null) {
                            ip = "";
                        }
                        lVar.invoke(u.a(u.m1361constructorimpl(ip)));
                    }
                    return Q.INSTANCE;
                }
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                objM1101getWifiStateIoAF18A = ((u) obj).b();
                uVarA = u.a(objM1101getWifiStateIoAF18A);
                if (uVarA != null) {
                    lVar.invoke(u.a(u.m1361constructorimpl(v.createFailure(new Exception("get wifi state failed")))));
                } else {
                    lVar.invoke(u.a(u.m1361constructorimpl(v.createFailure(new Exception("get wifi state failed")))));
                }
                return Q.INSTANCE;
        }
    }
}
