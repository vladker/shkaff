package p023d4;

import E3.g;
import F3.i;
import O3.q;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.E;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H1 implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3803a;
    public final /* synthetic */ T b;
    public final /* synthetic */ q c;
    public final /* synthetic */ InterfaceC0615p d;

    public /* synthetic */ H1(T t6, q qVar, InterfaceC0615p interfaceC0615p, int i5) {
        this.f3803a = i5;
        this.b = t6;
        this.c = qVar;
        this.d = interfaceC0615p;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0090  */
    /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        G1 g1;
        T t6;
        H1 h1;
        I1 i1;
        T t7;
        T t8;
        H1 h6;
        InterfaceC0615p interfaceC0615p;
        Object obj2;
        switch (this.f3803a) {
            case 0:
                if (gVar instanceof G1) {
                    g1 = (G1) gVar;
                    int i5 = g1.e;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        g1.e = i5 - Integer.MIN_VALUE;
                    } else {
                        g1 = new G1(this, gVar);
                    }
                } else {
                    g1 = new G1(this, gVar);
                }
                Object obj3 = g1.c;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = g1.e;
                if (i6 != 0) {
                    if (i6 == 1) {
                        t6 = g1.b;
                        h1 = g1.f3800a;
                        v.throwOnFailure(obj3);
                    } else {
                        if (i6 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj3);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj3);
                T t9 = this.b;
                Object obj4 = t9.f5689a;
                g1.f3800a = this;
                g1.b = t9;
                g1.e = 1;
                Object objInvoke = this.c.invoke(obj4, obj, g1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj3 = objInvoke;
                t6 = t9;
                h1 = this;
                t6.f5689a = obj3;
                InterfaceC0615p interfaceC0615p2 = h1.d;
                Object obj5 = h1.b.f5689a;
                g1.f3800a = null;
                g1.b = null;
                g1.e = 2;
                if (interfaceC0615p2.emit(obj5, g1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Q.INSTANCE;
            default:
                if (gVar instanceof I1) {
                    i1 = (I1) gVar;
                    int i7 = i1.e;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        i1.e = i7 - Integer.MIN_VALUE;
                    } else {
                        i1 = new I1(this, gVar);
                    }
                } else {
                    i1 = new I1(this, gVar);
                }
                Object obj6 = i1.c;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i8 = i1.e;
                if (i8 != 0) {
                    if (i8 == 1) {
                        t8 = i1.b;
                        h6 = i1.f3806a;
                        v.throwOnFailure(obj6);
                    } else {
                        if (i8 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj6);
                    }
                    return Q.INSTANCE;
                }
                v.throwOnFailure(obj6);
                t7 = this.b;
                Object obj7 = t7.f5689a;
                if (obj7 == E.NULL) {
                    h6 = this;
                } else {
                    i1.f3806a = this;
                    i1.b = t7;
                    i1.e = 1;
                    Object objInvoke2 = this.c.invoke(obj7, obj, i1);
                    if (objInvoke2 == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                    obj6 = objInvoke2;
                    t8 = t7;
                    h6 = this;
                }
                t7.f5689a = obj;
                interfaceC0615p = h6.d;
                obj2 = h6.b.f5689a;
                i1.f3806a = null;
                i1.b = null;
                i1.e = 2;
                if (interfaceC0615p.emit(obj2, i1) == coroutine_suspended2) {
                    return coroutine_suspended2;
                }
                return Q.INSTANCE;
                Object obj8 = obj6;
                t7 = t8;
                obj = obj8;
                t7.f5689a = obj;
                interfaceC0615p = h6.d;
                obj2 = h6.b.f5689a;
                i1.f3806a = null;
                i1.b = null;
                i1.e = 2;
                if (interfaceC0615p.emit(obj2, i1) == coroutine_suspended2) {
                    return coroutine_suspended2;
                }
                return Q.INSTANCE;
        }
    }
}
