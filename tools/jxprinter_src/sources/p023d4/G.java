package p023d4;

import E3.g;
import F3.i;
import O3.p;
import kotlinx.coroutines.flow.internal.C1112a;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3798a;
    public final /* synthetic */ p b;

    public /* synthetic */ G(p pVar, int i5) {
        this.f3798a = i5;
        this.b = pVar;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        E0 e1;
        G g6;
        switch (this.f3798a) {
            case 0:
                Object objInvoke = this.b.invoke(obj, gVar);
                return objInvoke == i.getCOROUTINE_SUSPENDED() ? objInvoke : Q.INSTANCE;
            default:
                if (gVar instanceof E0) {
                    e1 = (E0) gVar;
                    int i5 = e1.d;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        e1.d = i5 - Integer.MIN_VALUE;
                    } else {
                        e1 = new E0(this, gVar);
                    }
                } else {
                    e1 = new E0(this, gVar);
                }
                Object objInvoke2 = e1.b;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = e1.d;
                if (i6 == 0) {
                    v.throwOnFailure(objInvoke2);
                    e1.f3793a = this;
                    e1.d = 1;
                    objInvoke2 = this.b.invoke(obj, e1);
                    if (objInvoke2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    g6 = this;
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    g6 = e1.f3793a;
                    v.throwOnFailure(objInvoke2);
                }
                if (((Boolean) objInvoke2).booleanValue()) {
                    return Q.INSTANCE;
                }
                throw new C1112a(g6);
        }
    }
}
