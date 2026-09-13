package S2;

import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0615p f664a;
    public final /* synthetic */ int b;

    public x(InterfaceC0615p interfaceC0615p, int i5) {
        this.f664a = interfaceC0615p;
        this.b = i5;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, E3.g gVar) throws Throwable {
        w wVar;
        if (gVar instanceof w) {
            wVar = (w) gVar;
            int i5 = wVar.b;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                wVar.b = i5 - Integer.MIN_VALUE;
            } else {
                wVar = new w(this, gVar);
            }
        } else {
            wVar = new w(this, gVar);
        }
        Object obj2 = wVar.f663a;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = wVar.b;
        if (i6 == 0) {
            p147z3.v.throwOnFailure(obj2);
            int iIntValue = ((Number) obj).intValue();
            if (iIntValue != this.b || iIntValue < 1) {
                wVar.b = 1;
                if (this.f664a.emit(obj, wVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
