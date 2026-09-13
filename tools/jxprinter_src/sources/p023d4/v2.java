package p023d4;

import E3.g;
import F3.i;
import O3.p;
import java.util.List;
import p147z3.C1929i;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v2 implements Z1 {
    private final p action;
    private final Z1 sharedFlow;

    public v2(Z1 z6, p pVar) {
        this.sharedFlow = z6;
        this.action = pVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // p023d4.Z1, p023d4.InterfaceC0612o
    public Object collect(InterfaceC0615p interfaceC0615p, g<?> gVar) throws Throwable {
        u2 u2Var;
        if (gVar instanceof u2) {
            u2Var = (u2) gVar;
            int i5 = u2Var.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                u2Var.c = i5 - Integer.MIN_VALUE;
            } else {
                u2Var = new u2(this, gVar);
            }
        } else {
            u2Var = new u2(this, gVar);
        }
        Object obj = u2Var.f3917a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = u2Var.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            Z1 z6 = this.sharedFlow;
            t2 t2Var = new t2(interfaceC0615p, this.action);
            u2Var.c = 1;
            if (z6.collect(t2Var, u2Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
        }
        throw new C1929i();
    }

    @Override // p023d4.Z1
    public List<Object> getReplayCache() {
        return this.sharedFlow.getReplayCache();
    }
}
