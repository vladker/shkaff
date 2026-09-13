package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import kotlinx.coroutines.flow.internal.w;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class R1 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3828a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ InterfaceC0612o[] d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ R1(InterfaceC0612o[] interfaceC0612oArr, g gVar, int i5) {
        super(2, gVar);
        this.f3828a = i5;
        this.d = interfaceC0612oArr;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f3828a) {
            case 0:
                R1 r6 = new R1(this.d, gVar, 0);
                r6.c = obj;
                return r6;
            case 1:
                R1 r7 = new R1(this.d, gVar, 1);
                r7.c = obj;
                return r7;
            default:
                R1 r8 = new R1(this.d, gVar, 2);
                r8.c = obj;
                return r8;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        InterfaceC0615p interfaceC0615p = (InterfaceC0615p) obj;
        g gVar = (g) obj2;
        switch (this.f3828a) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((R1) create(interfaceC0615p, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f3828a) {
            case 0:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    InterfaceC0615p interfaceC0615p = (InterfaceC0615p) this.c;
                    Q1 q6 = new Q1(3, null, 0);
                    this.b = 1;
                    if (w.combineInternal(interfaceC0615p, this.d, S1.f3830a, q6, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            case 1:
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 == 0) {
                    v.throwOnFailure(obj);
                    InterfaceC0615p interfaceC0615p2 = (InterfaceC0615p) this.c;
                    Q1 q7 = new Q1(3, null, 1);
                    this.b = 1;
                    if (w.combineInternal(interfaceC0615p2, this.d, S1.f3830a, q7, this) == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            default:
                Object coroutine_suspended3 = i.getCOROUTINE_SUSPENDED();
                int i7 = this.b;
                if (i7 == 0) {
                    v.throwOnFailure(obj);
                    InterfaceC0615p interfaceC0615p3 = (InterfaceC0615p) this.c;
                    Q1 q8 = new Q1(3, null, 2);
                    this.b = 1;
                    if (w.combineInternal(interfaceC0615p3, this.d, S1.f3830a, q8, this) == coroutine_suspended3) {
                        return coroutine_suspended3;
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
        }
    }
}
