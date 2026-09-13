package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.q;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M1 extends m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3815a;
    public int b;
    public /* synthetic */ InterfaceC0615p c;
    public /* synthetic */ Object[] d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ M1(int i5, g gVar, int i6) {
        super(i5, gVar);
        this.f3815a = i6;
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        InterfaceC0615p interfaceC0615p = (InterfaceC0615p) obj;
        Object[] objArr = (Object[]) obj2;
        g gVar = (g) obj3;
        switch (this.f3815a) {
            case 0:
                M1 m6 = new M1(3, gVar, 0);
                m6.c = interfaceC0615p;
                m6.d = objArr;
                return m6.invokeSuspend(Q.INSTANCE);
            default:
                M1 m7 = new M1(3, gVar, 1);
                m7.c = interfaceC0615p;
                m7.d = objArr;
                return m7.invokeSuspend(Q.INSTANCE);
        }
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f3815a) {
            case 0:
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    InterfaceC0615p interfaceC0615p = this.c;
                    Object[] objArr = this.d;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    Object obj5 = objArr[3];
                    this.c = interfaceC0615p;
                    this.b = 1;
                    throw null;
                }
                if (i5 == 1) {
                    InterfaceC0615p interfaceC0615p2 = this.c;
                    v.throwOnFailure(obj);
                    this.c = null;
                    this.b = 2;
                    if (interfaceC0615p2.emit(obj, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                return Q.INSTANCE;
            default:
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        InterfaceC0615p interfaceC0615p3 = this.c;
                        v.throwOnFailure(obj);
                        this.c = null;
                        this.b = 2;
                        if (interfaceC0615p3.emit(obj, this) == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                    } else {
                        if (i6 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj);
                InterfaceC0615p interfaceC0615p4 = this.c;
                Object[] objArr2 = this.d;
                Object obj6 = objArr2[0];
                Object obj7 = objArr2[1];
                Object obj8 = objArr2[2];
                Object obj9 = objArr2[3];
                Object obj10 = objArr2[4];
                this.c = interfaceC0615p4;
                this.b = 1;
                throw null;
        }
    }
}
