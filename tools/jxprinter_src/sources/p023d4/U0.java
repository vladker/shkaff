package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import O3.q;
import p147z3.InterfaceC1927g;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U0 extends m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3833a;
    public int b;
    public /* synthetic */ InterfaceC0615p c;
    public /* synthetic */ Object d;
    public final /* synthetic */ InterfaceC1927g e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ U0(InterfaceC1927g interfaceC1927g, g gVar, int i5) {
        super(3, gVar);
        this.f3833a = i5;
        this.e = interfaceC1927g;
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        InterfaceC0615p interfaceC0615p = (InterfaceC0615p) obj;
        switch (this.f3833a) {
            case 0:
                U0 u6 = new U0((p) this.e, (g) obj3, 0);
                u6.c = interfaceC0615p;
                u6.d = obj2;
                return u6.invokeSuspend(Q.INSTANCE);
            case 1:
                U0 u7 = new U0((p) this.e, (g) obj3, 1);
                u7.c = interfaceC0615p;
                u7.d = obj2;
                return u7.invokeSuspend(Q.INSTANCE);
            case 2:
                U0 u8 = new U0((p) this.e, (g) obj3, 2);
                u8.c = interfaceC0615p;
                u8.d = obj2;
                return u8.invokeSuspend(Q.INSTANCE);
            default:
                U0 u9 = new U0((q) this.e, (g) obj3, 3);
                u9.c = interfaceC0615p;
                u9.d = (Object[]) obj2;
                return u9.invokeSuspend(Q.INSTANCE);
        }
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        InterfaceC0615p interfaceC0615p;
        InterfaceC0615p interfaceC0615p2;
        InterfaceC0615p interfaceC0615p3;
        InterfaceC0615p interfaceC0615p4;
        switch (this.f3833a) {
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
                Object obj2 = this.d;
                p pVar = (p) this.e;
                this.c = interfaceC0615p;
                this.b = 1;
                obj = pVar.invoke(obj2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.c = null;
                this.b = 2;
                if (AbstractC0618q.emitAll(interfaceC0615p, (InterfaceC0612o) obj, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Q.INSTANCE;
            case 1:
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        interfaceC0615p2 = this.c;
                        v.throwOnFailure(obj);
                    } else {
                        if (i6 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj);
                interfaceC0615p2 = this.c;
                Object obj3 = this.d;
                p pVar2 = (p) this.e;
                this.c = interfaceC0615p2;
                this.b = 1;
                obj = pVar2.invoke(obj3, this);
                if (obj == coroutine_suspended2) {
                    return coroutine_suspended2;
                }
                this.c = null;
                this.b = 2;
                if (interfaceC0615p2.emit(obj, this) == coroutine_suspended2) {
                    return coroutine_suspended2;
                }
                return Q.INSTANCE;
            case 2:
                Object coroutine_suspended3 = i.getCOROUTINE_SUSPENDED();
                int i7 = this.b;
                if (i7 != 0) {
                    if (i7 == 1) {
                        interfaceC0615p3 = this.c;
                        v.throwOnFailure(obj);
                    } else {
                        if (i7 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj);
                interfaceC0615p3 = this.c;
                Object obj4 = this.d;
                p pVar3 = (p) this.e;
                this.c = interfaceC0615p3;
                this.b = 1;
                obj = pVar3.invoke(obj4, this);
                if (obj == coroutine_suspended3) {
                    return coroutine_suspended3;
                }
                this.c = null;
                this.b = 2;
                if (AbstractC0618q.emitAll(interfaceC0615p3, (InterfaceC0612o) obj, this) == coroutine_suspended3) {
                    return coroutine_suspended3;
                }
                return Q.INSTANCE;
            default:
                Object coroutine_suspended4 = i.getCOROUTINE_SUSPENDED();
                int i8 = this.b;
                if (i8 != 0) {
                    if (i8 == 1) {
                        interfaceC0615p4 = this.c;
                        v.throwOnFailure(obj);
                    } else {
                        if (i8 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj);
                interfaceC0615p4 = this.c;
                Object[] objArr = (Object[]) this.d;
                q qVar = (q) this.e;
                Object obj5 = objArr[0];
                Object obj6 = objArr[1];
                this.c = interfaceC0615p4;
                this.b = 1;
                obj = qVar.invoke(obj5, obj6, this);
                if (obj == coroutine_suspended4) {
                    return coroutine_suspended4;
                }
                this.c = null;
                this.b = 2;
                if (interfaceC0615p4.emit(obj, this) == coroutine_suspended4) {
                    return coroutine_suspended4;
                }
                return Q.INSTANCE;
        }
    }
}
