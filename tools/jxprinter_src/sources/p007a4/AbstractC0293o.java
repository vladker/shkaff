package p007a4;

import E3.g;
import F3.h;
import F3.i;
import O3.l;
import p028e4.C0654h;

/* JADX INFO: renamed from: a4.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0293o {
    public static final void disposeOnCancellation(InterfaceC0285k interfaceC0285k, InterfaceC0280h0 interfaceC0280h0) {
        invokeOnCancellation(interfaceC0285k, new C0282i0(interfaceC0280h0));
    }

    public static final <T> C0289m getOrCreateCancellableContinuation(g<? super T> gVar) {
        if (!(gVar instanceof C0654h)) {
            return new C0289m(gVar, 1);
        }
        C0289m c0289mClaimReusableCancellableContinuation$kotlinx_coroutines_core = ((C0654h) gVar).claimReusableCancellableContinuation$kotlinx_coroutines_core();
        if (c0289mClaimReusableCancellableContinuation$kotlinx_coroutines_core != null) {
            if (!c0289mClaimReusableCancellableContinuation$kotlinx_coroutines_core.resetStateReusable()) {
                c0289mClaimReusableCancellableContinuation$kotlinx_coroutines_core = null;
            }
            if (c0289mClaimReusableCancellableContinuation$kotlinx_coroutines_core != null) {
                return c0289mClaimReusableCancellableContinuation$kotlinx_coroutines_core;
            }
        }
        return new C0289m(gVar, 2);
    }

    public static final <T> void invokeOnCancellation(InterfaceC0285k interfaceC0285k, InterfaceC0283j interfaceC0283j) {
        if (!(interfaceC0285k instanceof C0289m)) {
            throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
        }
        ((C0289m) interfaceC0285k).invokeOnCancellationInternal$kotlinx_coroutines_core(interfaceC0283j);
    }

    public static final <T> Object suspendCancellableCoroutine(l lVar, g<? super T> gVar) {
        C0289m c0289m = new C0289m(h.intercepted(gVar), 1);
        c0289m.initCancellability();
        lVar.invoke(c0289m);
        Object result = c0289m.getResult();
        if (result == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result;
    }

    public static final <T> Object suspendCancellableCoroutineReusable(l lVar, g<? super T> gVar) {
        C0289m orCreateCancellableContinuation = getOrCreateCancellableContinuation(h.intercepted(gVar));
        try {
            lVar.invoke(orCreateCancellableContinuation);
            Object result = orCreateCancellableContinuation.getResult();
            if (result == i.getCOROUTINE_SUSPENDED()) {
                G3.h.probeCoroutineSuspended(gVar);
            }
            return result;
        } catch (Throwable th) {
            orCreateCancellableContinuation.h();
            throw th;
        }
    }
}
