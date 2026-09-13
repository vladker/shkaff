package p023d4;

import E3.g;
import F3.i;
import O3.q;
import kotlinx.coroutines.flow.internal.C1112a;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class R0 implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f3827a;
    public final /* synthetic */ InterfaceC0615p b;

    public R0(q qVar, InterfaceC0615p interfaceC0615p) {
        this.f3827a = qVar;
        this.b = interfaceC0615p;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        Q0 q6;
        R0 r6;
        if (gVar instanceof Q0) {
            q6 = (Q0) gVar;
            int i5 = q6.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                q6.c = i5 - Integer.MIN_VALUE;
            } else {
                q6 = new Q0(this, gVar);
            }
        } else {
            q6 = new Q0(this, gVar);
        }
        Object objInvoke = q6.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = q6.c;
        if (i6 == 0) {
            v.throwOnFailure(objInvoke);
            q6.f3825a = this;
            q6.c = 1;
            objInvoke = this.f3827a.invoke(this.b, obj, q6);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            r6 = this;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r6 = q6.f3825a;
            v.throwOnFailure(objInvoke);
        }
        if (((Boolean) objInvoke).booleanValue()) {
            return Q.INSTANCE;
        }
        throw new C1112a(r6);
    }
}
