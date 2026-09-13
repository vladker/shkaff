package p023d4;

import E3.g;
import F3.i;
import java.util.ArrayList;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.A;
import kotlinx.coroutines.flow.internal.C1112a;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F0 implements InterfaceC0612o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3795a;
    public final /* synthetic */ InterfaceC0612o b;
    public final /* synthetic */ int c;

    public /* synthetic */ F0(InterfaceC0612o interfaceC0612o, int i5, int i6) {
        this.f3795a = i6;
        this.b = interfaceC0612o;
        this.c = i5;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008c  */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p023d4.InterfaceC0612o
    public final Object collect(InterfaceC0615p interfaceC0615p, g gVar) throws Throwable {
        K0 k6;
        C1112a e;
        Object obj;
        C0637w1 c0637w1;
        InterfaceC0615p interfaceC0615p2;
        T t6;
        switch (this.f3795a) {
            case 0:
                Object objCollect = this.b.collect(new H0(new Q(), this.c, interfaceC0615p, 0), gVar);
                return objCollect == i.getCOROUTINE_SUSPENDED() ? objCollect : p147z3.Q.INSTANCE;
            case 1:
                if (gVar instanceof K0) {
                    k6 = (K0) gVar;
                    int i5 = k6.b;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        k6.b = i5 - Integer.MIN_VALUE;
                    } else {
                        k6 = new K0(this, gVar);
                    }
                } else {
                    k6 = new K0(this, gVar);
                }
                Object obj2 = k6.f3810a;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = k6.b;
                if (i6 != 0) {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj = k6.d;
                    try {
                        v.throwOnFailure(obj2);
                    } catch (C1112a e6) {
                        e = e6;
                        A.checkOwnership(e, obj);
                    }
                    break;
                } else {
                    v.throwOnFailure(obj2);
                    Object obj3 = new Object();
                    Q q6 = new Q();
                    try {
                        InterfaceC0612o interfaceC0612o = this.b;
                        M0 m6 = new M0(q6, this.c, interfaceC0615p, obj3);
                        k6.d = obj3;
                        k6.b = 1;
                        if (interfaceC0612o.collect(m6, k6) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (C1112a e7) {
                        e = e7;
                        obj = obj3;
                        A.checkOwnership(e, obj);
                    }
                }
                return p147z3.Q.INSTANCE;
            default:
                if (gVar instanceof C0637w1) {
                    c0637w1 = (C0637w1) gVar;
                    int i7 = c0637w1.b;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0637w1.b = i7 - Integer.MIN_VALUE;
                    } else {
                        c0637w1 = new C0637w1(this, gVar);
                    }
                } else {
                    c0637w1 = new C0637w1(this, gVar);
                }
                Object obj4 = c0637w1.f3921a;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i8 = c0637w1.b;
                if (i8 != 0) {
                    if (i8 == 1) {
                        t6 = c0637w1.e;
                        interfaceC0615p2 = c0637w1.d;
                        v.throwOnFailure(obj4);
                    } else {
                        if (i8 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.throwOnFailure(obj4);
                    }
                    return p147z3.Q.INSTANCE;
                }
                v.throwOnFailure(obj4);
                T t7 = new T();
                H0 h1 = new H0(t7, this.c, interfaceC0615p, 1);
                c0637w1.d = interfaceC0615p;
                c0637w1.e = t7;
                c0637w1.b = 1;
                if (this.b.collect(h1, c0637w1) == coroutine_suspended2) {
                    return coroutine_suspended2;
                }
                interfaceC0615p2 = interfaceC0615p;
                t6 = t7;
                ArrayList arrayList = (ArrayList) t6.f5689a;
                if (arrayList != null) {
                    c0637w1.d = null;
                    c0637w1.e = null;
                    c0637w1.b = 2;
                    if (interfaceC0615p2.emit(arrayList, c0637w1) == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                }
                return p147z3.Q.INSTANCE;
        }
    }
}
