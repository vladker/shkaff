package p023d4;

import A3.C0133b0;
import E3.g;
import F3.i;
import G3.b;
import O3.q;
import kotlinx.coroutines.flow.internal.r;
import p007a4.E1;
import p018c4.InterfaceC0391v;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3801a = 0;
    public int b;
    public final /* synthetic */ Object c;

    public H(InterfaceC0391v interfaceC0391v, int i5) {
        this.c = interfaceC0391v;
        this.b = i5;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        r rVar;
        switch (this.f3801a) {
            case 0:
                q qVar = (q) this.c;
                int i5 = this.b;
                this.b = i5 + 1;
                if (i5 < 0) {
                    throw new ArithmeticException("Index overflow has happened");
                }
                Object objInvoke = qVar.invoke(b.boxInt(i5), obj, gVar);
                return objInvoke == i.getCOROUTINE_SUSPENDED() ? objInvoke : Q.INSTANCE;
            default:
                if (gVar instanceof r) {
                    rVar = (r) gVar;
                    int i6 = rVar.c;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        rVar.c = i6 - Integer.MIN_VALUE;
                    } else {
                        rVar = new r(this, gVar);
                    }
                } else {
                    rVar = new r(this, gVar);
                }
                Object obj2 = rVar.f5713a;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i7 = rVar.c;
                if (i7 != 0) {
                    if (i7 == 1) {
                        v.throwOnFailure(obj2);
                    } else {
                        if (i7 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj2);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj2);
                InterfaceC0391v interfaceC0391v = (InterfaceC0391v) this.c;
                C0133b0 c0133b0 = new C0133b0(this.b, obj);
                rVar.c = 1;
                if (interfaceC0391v.send(c0133b0, rVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                rVar.c = 2;
                if (E1.yield(rVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Q.INSTANCE;
        }
    }

    public H(q qVar) {
        this.c = qVar;
    }
}
