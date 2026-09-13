package p023d4;

import A3.AbstractC0157z;
import E3.g;
import F3.i;
import G3.d;
import O3.p;
import O3.q;
import androidx.collection.a;
import kotlinx.coroutines.flow.internal.A;
import kotlinx.coroutines.flow.internal.C1112a;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class S0 {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(InterfaceC0615p interfaceC0615p, Object obj, Object obj2, d dVar) throws Throwable {
        J0 j1;
        if (dVar instanceof J0) {
            j1 = (J0) dVar;
            int i5 = j1.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                j1.c = i5 - Integer.MIN_VALUE;
            } else {
                j1 = new J0(dVar);
            }
        } else {
            j1 = new J0(dVar);
        }
        Object obj3 = j1.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = j1.c;
        if (i6 == 0) {
            v.throwOnFailure(obj3);
            j1.f3807a = obj2;
            j1.c = 1;
            if (interfaceC0615p.emit(obj, j1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = j1.f3807a;
            v.throwOnFailure(obj3);
        }
        throw new C1112a(obj2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object collectWhile(InterfaceC0612o interfaceC0612o, p pVar, g<? super Q> gVar) throws Throwable {
        D0 d1;
        G g6;
        if (gVar instanceof D0) {
            d1 = (D0) gVar;
            int i5 = d1.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                d1.c = i5 - Integer.MIN_VALUE;
            } else {
                d1 = new D0(gVar);
            }
        } else {
            d1 = new D0(gVar);
        }
        Object obj = d1.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = d1.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            G g7 = new G(pVar, 1);
            try {
                d1.f3789a = g7;
                d1.c = 1;
                if (interfaceC0612o.collect(g7, d1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (C1112a e) {
                e = e;
                g6 = g7;
                A.checkOwnership(e, g6);
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g6 = d1.f3789a;
            try {
                v.throwOnFailure(obj);
            } catch (C1112a e6) {
                e = e6;
                A.checkOwnership(e, g6);
            }
        }
        return Q.INSTANCE;
    }

    public static final <T> InterfaceC0612o drop(InterfaceC0612o interfaceC0612o, int i5) {
        if (i5 >= 0) {
            return new F0(interfaceC0612o, i5, 0);
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Drop count should be non-negative, but had ").toString());
    }

    public static final <T> InterfaceC0612o dropWhile(InterfaceC0612o interfaceC0612o, p pVar) {
        return new C0616p0(interfaceC0612o, 1, pVar);
    }

    public static final <T> InterfaceC0612o take(InterfaceC0612o interfaceC0612o, int i5) {
        if (i5 > 0) {
            return new F0(interfaceC0612o, i5, 1);
        }
        throw new IllegalArgumentException(a.i(i5, "Requested element count ", " should be positive").toString());
    }

    public static final <T> InterfaceC0612o takeWhile(InterfaceC0612o interfaceC0612o, p pVar) {
        return new C0616p0(interfaceC0612o, 2, pVar);
    }

    public static final <T, R> InterfaceC0612o transformWhile(InterfaceC0612o interfaceC0612o, q qVar) {
        return AbstractC0618q.flow(new C0624s0(interfaceC0612o, qVar, null, 1));
    }
}
