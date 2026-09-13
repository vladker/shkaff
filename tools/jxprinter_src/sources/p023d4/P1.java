package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import O3.r;
import kotlinx.coroutines.flow.internal.w;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P1 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3823a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ InterfaceC0612o[] d;
    public final /* synthetic */ r e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ P1(InterfaceC0612o[] interfaceC0612oArr, g gVar, r rVar, int i5) {
        super(2, gVar);
        this.f3823a = i5;
        this.d = interfaceC0612oArr;
        this.e = rVar;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f3823a) {
            case 0:
                P1 p1 = new P1(this.d, gVar, this.e, 0);
                p1.c = obj;
                return p1;
            default:
                P1 p6 = new P1(this.d, gVar, this.e, 1);
                p6.c = obj;
                return p6;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        InterfaceC0615p interfaceC0615p = (InterfaceC0615p) obj;
        g gVar = (g) obj2;
        switch (this.f3823a) {
            case 0:
                break;
        }
        return ((P1) create(interfaceC0615p, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f3823a) {
            case 0:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    InterfaceC0615p interfaceC0615p = (InterfaceC0615p) this.c;
                    L1 l6 = new L1(null, this.e, 1);
                    this.b = 1;
                    if (w.combineInternal(interfaceC0615p, this.d, S1.f3830a, l6, this) == coroutine_suspended) {
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
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 == 0) {
                    v.throwOnFailure(obj);
                    InterfaceC0615p interfaceC0615p2 = (InterfaceC0615p) this.c;
                    L1 l7 = new L1(null, this.e, 2);
                    this.b = 1;
                    if (w.combineInternal(interfaceC0615p2, this.d, S1.f3830a, l7, this) == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
        }
    }
}
