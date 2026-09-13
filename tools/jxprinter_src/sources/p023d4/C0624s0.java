package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import O3.q;
import kotlinx.coroutines.flow.internal.A;
import kotlinx.coroutines.flow.internal.C1112a;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.s0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0624s0 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3909a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ InterfaceC0612o d;
    public final /* synthetic */ q e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0624s0(InterfaceC0612o interfaceC0612o, q qVar, g gVar, int i5) {
        super(2, gVar);
        this.f3909a = i5;
        this.d = interfaceC0612o;
        this.e = qVar;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f3909a) {
            case 0:
                C0624s0 c0624s0 = new C0624s0(this.d, this.e, gVar, 0);
                c0624s0.c = obj;
                return c0624s0;
            default:
                C0624s0 c0624s1 = new C0624s0(this.d, this.e, gVar, 1);
                c0624s1.c = obj;
                return c0624s1;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        InterfaceC0615p interfaceC0615p = (InterfaceC0615p) obj;
        g gVar = (g) obj2;
        switch (this.f3909a) {
            case 0:
                break;
        }
        return ((C0624s0) create(interfaceC0615p, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        R0 r6;
        switch (this.f3909a) {
            case 0:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    C0621r0 c0621r0 = new C0621r0(this.e, (InterfaceC0615p) this.c, 0);
                    this.b = 1;
                    if (this.d.collect(c0621r0, this) == coroutine_suspended) {
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
                if (i6 != 0) {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r6 = (R0) this.c;
                    try {
                        v.throwOnFailure(obj);
                    } catch (C1112a e) {
                        e = e;
                        A.checkOwnership(e, r6);
                    }
                    break;
                } else {
                    v.throwOnFailure(obj);
                    InterfaceC0615p interfaceC0615p = (InterfaceC0615p) this.c;
                    InterfaceC0612o interfaceC0612o = this.d;
                    R0 r7 = new R0(this.e, interfaceC0615p);
                    try {
                        this.c = r7;
                        this.b = 1;
                        if (interfaceC0612o.collect(r7, this) == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                    } catch (C1112a e6) {
                        e = e6;
                        r6 = r7;
                        A.checkOwnership(e, r6);
                    }
                }
                return Q.INSTANCE;
        }
    }
}
