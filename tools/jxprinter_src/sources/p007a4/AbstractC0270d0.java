package p007a4;

import E3.g;
import E3.q;
import O3.a;
import kotlin.jvm.internal.E;
import p028e4.C0654h;
import p028e4.L;
import p147z3.u;
import p147z3.v;

/* JADX INFO: renamed from: a4.d0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0270d0 {
    public static final <T> void dispatch(AbstractC0267c0 abstractC0267c0, int i5) {
        g<Object> delegate$kotlinx_coroutines_core = abstractC0267c0.getDelegate$kotlinx_coroutines_core();
        boolean z6 = i5 == 4;
        if (!z6 && (delegate$kotlinx_coroutines_core instanceof C0654h)) {
            boolean z7 = i5 == 1 || i5 == 2;
            int i6 = abstractC0267c0.resumeMode;
            if (z7 == (i6 == 1 || i6 == 2)) {
                C0654h c0654h = (C0654h) delegate$kotlinx_coroutines_core;
                F f6 = c0654h.dispatcher;
                q context = c0654h.getContext();
                if (f6.isDispatchNeeded(context)) {
                    f6.mo1035dispatch(context, abstractC0267c0);
                    return;
                }
                AbstractC0288l0 eventLoop$kotlinx_coroutines_core = p1.INSTANCE.getEventLoop$kotlinx_coroutines_core();
                if (eventLoop$kotlinx_coroutines_core.e()) {
                    eventLoop$kotlinx_coroutines_core.dispatchUnconfined(abstractC0267c0);
                    return;
                }
                eventLoop$kotlinx_coroutines_core.d(true);
                try {
                    resume(abstractC0267c0, abstractC0267c0.getDelegate$kotlinx_coroutines_core(), true);
                    do {
                    } while (eventLoop$kotlinx_coroutines_core.h());
                } catch (Throwable th) {
                    try {
                        abstractC0267c0.handleFatalException$kotlinx_coroutines_core(th);
                    } finally {
                        eventLoop$kotlinx_coroutines_core.a(true);
                    }
                }
                return;
            }
        }
        resume(abstractC0267c0, delegate$kotlinx_coroutines_core, z6);
    }

    public static final <T> void resume(AbstractC0267c0 abstractC0267c0, g<? super T> gVar, boolean z6) {
        Object objTakeState$kotlinx_coroutines_core = abstractC0267c0.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = abstractC0267c0.getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
        Object objM1361constructorimpl = u.m1361constructorimpl(exceptionalResult$kotlinx_coroutines_core != null ? v.createFailure(exceptionalResult$kotlinx_coroutines_core) : abstractC0267c0.getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core));
        if (!z6) {
            gVar.resumeWith(objM1361constructorimpl);
            return;
        }
        E.d(gVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        C0654h c0654h = (C0654h) gVar;
        g<Object> gVar2 = c0654h.continuation;
        Object obj = c0654h.countOrElement;
        q context = gVar2.getContext();
        Object objUpdateThreadContext = L.updateThreadContext(context, obj);
        z1 z1VarUpdateUndispatchedCompletion = objUpdateThreadContext != L.NO_THREAD_ELEMENTS ? D.updateUndispatchedCompletion(gVar2, context, objUpdateThreadContext) : null;
        try {
            c0654h.continuation.resumeWith(objM1361constructorimpl);
        } finally {
            if (z1VarUpdateUndispatchedCompletion == null || z1VarUpdateUndispatchedCompletion.w()) {
                L.restoreThreadContext(context, objUpdateThreadContext);
            }
        }
    }

    public static final void resumeWithStackTrace(g<?> gVar, Throwable th) {
        gVar.resumeWith(u.m1361constructorimpl(v.createFailure(th)));
    }

    public static final void runUnconfinedEventLoop(AbstractC0267c0 abstractC0267c0, AbstractC0288l0 abstractC0288l0, a aVar) {
        abstractC0288l0.d(true);
        try {
            aVar.invoke();
            do {
            } while (abstractC0288l0.h());
            abstractC0288l0.a(true);
        } catch (Throwable th) {
            try {
                abstractC0267c0.handleFatalException$kotlinx_coroutines_core(th);
            } finally {
                abstractC0288l0.a(true);
            }
        }
    }

    public static /* synthetic */ void getMODE_CANCELLABLE$annotations() {
    }
}
