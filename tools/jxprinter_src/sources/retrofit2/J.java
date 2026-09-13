package retrofit2;

import p007a4.C0276f0;
import p007a4.C0289m;
import p147z3.C1929i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class J {
    public static final <T> Object await(InterfaceC1613k<T> interfaceC1613k, E3.g<? super T> gVar) {
        C0289m c0289m = new C0289m(F3.h.intercepted(gVar), 1);
        c0289m.initCancellability();
        c0289m.invokeOnCancellation(new C(interfaceC1613k));
        interfaceC1613k.b(new D(c0289m));
        Object result = c0289m.getResult();
        if (result == F3.i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result;
    }

    public static final <T> Object awaitNullable(InterfaceC1613k<T> interfaceC1613k, E3.g<? super T> gVar) {
        C0289m c0289m = new C0289m(F3.h.intercepted(gVar), 1);
        c0289m.initCancellability();
        c0289m.invokeOnCancellation(new E(interfaceC1613k));
        interfaceC1613k.b(new F(c0289m));
        Object result = c0289m.getResult();
        if (result == F3.i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result;
    }

    public static final <T> Object awaitResponse(InterfaceC1613k<T> interfaceC1613k, E3.g<? super r0<T>> gVar) {
        C0289m c0289m = new C0289m(F3.h.intercepted(gVar), 1);
        c0289m.initCancellability();
        c0289m.invokeOnCancellation(new G(interfaceC1613k));
        interfaceC1613k.b(new H(c0289m));
        Object result = c0289m.getResult();
        if (result == F3.i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result;
    }

    public static final Object awaitUnit(InterfaceC1613k<p147z3.Q> interfaceC1613k, E3.g<? super p147z3.Q> gVar) {
        kotlin.jvm.internal.E.d(interfaceC1613k, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
        return awaitNullable(interfaceC1613k, gVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object suspendAndThrow(Throwable th, E3.g<?> gVar) throws Throwable {
        I i5;
        if (gVar instanceof I) {
            i5 = (I) gVar;
            int i6 = i5.b;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                i5.b = i6 - Integer.MIN_VALUE;
            } else {
                i5 = new I(gVar);
            }
        } else {
            i5 = new I(gVar);
        }
        Object obj = i5.f8099a;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i7 = i5.b;
        if (i7 == 0) {
            p147z3.v.throwOnFailure(obj);
            i5.b = 1;
            C0276f0.getDefault().mo1035dispatch(i5.getContext(), new Q0.b(i5, th, 25));
            Object coroutine_suspended2 = F3.i.getCOROUTINE_SUSPENDED();
            if (coroutine_suspended2 == F3.i.getCOROUTINE_SUSPENDED()) {
                G3.h.probeCoroutineSuspended(i5);
            }
            if (coroutine_suspended2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i7 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p147z3.v.throwOnFailure(obj);
        }
        throw new C1929i();
    }
}
