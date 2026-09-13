package p018c4;

import E3.g;
import E3.q;
import E3.r;
import F3.h;
import F3.i;
import O3.a;
import O3.l;
import O3.p;
import p007a4.C0289m;
import p007a4.D;
import p007a4.H0;
import p007a4.M;
import p007a4.P;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v0 {
    public static /* synthetic */ B0 a(M m6, int i5, p pVar, int i6) {
        r rVar = r.INSTANCE;
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        return produce(m6, rVar, i5, pVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object awaitClose(x0 x0Var, a aVar, g<? super Q> gVar) throws Throwable {
        t0 t0Var;
        if (gVar instanceof t0) {
            t0Var = (t0) gVar;
            int i5 = t0Var.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                t0Var.c = i5 - Integer.MIN_VALUE;
            } else {
                t0Var = new t0(gVar);
            }
        } else {
            t0Var = new t0(gVar);
        }
        Object obj = t0Var.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = t0Var.c;
        try {
            if (i6 == 0) {
                v.throwOnFailure(obj);
                if (t0Var.getContext().get(H0.Key) != x0Var) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context");
                }
                t0Var.f1187a = aVar;
                t0Var.c = 1;
                C0289m c0289m = new C0289m(h.intercepted(t0Var), 1);
                c0289m.initCancellability();
                x0Var.invokeOnClose(new u0(c0289m, 0));
                Object result = c0289m.getResult();
                if (result == i.getCOROUTINE_SUSPENDED()) {
                    G3.h.probeCoroutineSuspended(t0Var);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = t0Var.f1187a;
                v.throwOnFailure(obj);
            }
            aVar.invoke();
            return Q.INSTANCE;
        } catch (Throwable th) {
            aVar.invoke();
            throw th;
        }
    }

    public static final <E> B0 produce(M m6, q qVar, int i5, p pVar) {
        return produce(m6, qVar, i5, EnumC0368b.f1135a, P.f943a, null, pVar);
    }

    public static final <E> B0 produce(M m6, q qVar, int i5, P p6, l lVar, p pVar) {
        return produce(m6, qVar, i5, EnumC0368b.f1135a, p6, lVar, pVar);
    }

    public static final <E> B0 produce(M m6, q qVar, int i5, EnumC0368b enumC0368b, P p6, l lVar, p pVar) {
        w0 w0Var = new w0(D.newCoroutineContext(m6, qVar), A.a(i5, 4, enumC0368b));
        if (lVar != null) {
            w0Var.invokeOnCompletion(lVar);
        }
        w0Var.start(p6, w0Var, pVar);
        return w0Var;
    }
}
