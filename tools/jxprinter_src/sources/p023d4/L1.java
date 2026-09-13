package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.q;
import O3.r;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L1 extends m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3813a;
    public int b;
    public /* synthetic */ InterfaceC0615p c;
    public /* synthetic */ Object[] d;
    public final /* synthetic */ r e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ L1(g gVar, r rVar, int i5) {
        super(3, gVar);
        this.f3813a = i5;
        this.e = rVar;
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        InterfaceC0615p interfaceC0615p = (InterfaceC0615p) obj;
        Object[] objArr = (Object[]) obj2;
        g gVar = (g) obj3;
        switch (this.f3813a) {
            case 0:
                L1 l6 = new L1(gVar, this.e, 0);
                l6.c = interfaceC0615p;
                l6.d = objArr;
                return l6.invokeSuspend(Q.INSTANCE);
            case 1:
                L1 l7 = new L1(gVar, this.e, 1);
                l7.c = interfaceC0615p;
                l7.d = objArr;
                return l7.invokeSuspend(Q.INSTANCE);
            default:
                L1 l8 = new L1(gVar, this.e, 2);
                l8.c = interfaceC0615p;
                l8.d = objArr;
                return l8.invokeSuspend(Q.INSTANCE);
        }
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        InterfaceC0615p interfaceC0615p;
        switch (this.f3813a) {
            case 0:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 != 0) {
                    if (i5 == 1) {
                        interfaceC0615p = this.c;
                        v.throwOnFailure(obj);
                    } else {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj);
                interfaceC0615p = this.c;
                Object[] objArr = this.d;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                this.c = interfaceC0615p;
                this.b = 1;
                obj = this.e.invoke(obj2, obj3, obj4, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.c = null;
                this.b = 2;
                if (interfaceC0615p.emit(obj, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Q.INSTANCE;
            case 1:
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 == 0) {
                    v.throwOnFailure(obj);
                    InterfaceC0615p interfaceC0615p2 = this.c;
                    Object[] objArr2 = this.d;
                    Object obj5 = objArr2[0];
                    Object obj6 = objArr2[1];
                    this.b = 1;
                    if (this.e.invoke(interfaceC0615p2, obj5, obj6, this) == coroutine_suspended2) {
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
                    InterfaceC0615p interfaceC0615p3 = this.c;
                    Object[] objArr3 = this.d;
                    Object obj7 = objArr3[0];
                    Object obj8 = objArr3[1];
                    this.b = 1;
                    if (this.e.invoke(interfaceC0615p3, obj7, obj8, this) == coroutine_suspended3) {
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
