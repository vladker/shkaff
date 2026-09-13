package p028e4;

import E3.g;
import E3.q;
import java.util.concurrent.CancellationException;
import p007a4.AbstractC0288l0;
import p007a4.B;
import p007a4.D;
import p007a4.H0;
import p007a4.p1;
import p007a4.z1;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: renamed from: e4.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0655i {
    private static final H UNDEFINED = new H("UNDEFINED");
    public static final H REUSABLE_CLAIMED = new H("REUSABLE_CLAIMED");

    public static final <T> void resumeCancellableWith(g<? super T> gVar, Object obj) {
        if (!(gVar instanceof C0654h)) {
            gVar.resumeWith(obj);
            return;
        }
        C0654h c0654h = (C0654h) gVar;
        Object state = B.toState(obj);
        if (c0654h.dispatcher.isDispatchNeeded(c0654h.getContext())) {
            c0654h._state = state;
            c0654h.resumeMode = 1;
            c0654h.dispatcher.mo1035dispatch(c0654h.getContext(), c0654h);
            return;
        }
        AbstractC0288l0 eventLoop$kotlinx_coroutines_core = p1.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.e()) {
            c0654h._state = state;
            c0654h.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(c0654h);
            return;
        }
        eventLoop$kotlinx_coroutines_core.d(true);
        try {
            H0 h1 = (H0) c0654h.getContext().get(H0.Key);
            if (h1 == null || h1.isActive()) {
                g<Object> gVar2 = c0654h.continuation;
                Object obj2 = c0654h.countOrElement;
                q context = gVar2.getContext();
                Object objUpdateThreadContext = L.updateThreadContext(context, obj2);
                z1 z1VarUpdateUndispatchedCompletion = objUpdateThreadContext != L.NO_THREAD_ELEMENTS ? D.updateUndispatchedCompletion(gVar2, context, objUpdateThreadContext) : null;
                try {
                    c0654h.continuation.resumeWith(obj);
                    if (z1VarUpdateUndispatchedCompletion == null || z1VarUpdateUndispatchedCompletion.w()) {
                        L.restoreThreadContext(context, objUpdateThreadContext);
                    }
                } catch (Throwable th) {
                    if (z1VarUpdateUndispatchedCompletion == null || z1VarUpdateUndispatchedCompletion.w()) {
                        L.restoreThreadContext(context, objUpdateThreadContext);
                    }
                    throw th;
                }
            } else {
                CancellationException cancellationException = h1.getCancellationException();
                c0654h.cancelCompletedResult$kotlinx_coroutines_core(state, cancellationException);
                c0654h.resumeWith(u.m1361constructorimpl(v.createFailure(cancellationException)));
            }
            while (eventLoop$kotlinx_coroutines_core.h()) {
            }
        } catch (Throwable th2) {
            try {
                c0654h.handleFatalException$kotlinx_coroutines_core(th2);
            } finally {
                eventLoop$kotlinx_coroutines_core.a(true);
            }
        }
    }

    public static final boolean yieldUndispatched(C0654h c0654h) {
        Q q6 = Q.INSTANCE;
        AbstractC0288l0 eventLoop$kotlinx_coroutines_core = p1.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.f()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.e()) {
            c0654h._state = q6;
            c0654h.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(c0654h);
            return true;
        }
        eventLoop$kotlinx_coroutines_core.d(true);
        try {
            c0654h.run();
            do {
            } while (eventLoop$kotlinx_coroutines_core.h());
        } catch (Throwable th) {
            try {
                c0654h.handleFatalException$kotlinx_coroutines_core(th);
            } finally {
                eventLoop$kotlinx_coroutines_core.a(true);
            }
        }
        return false;
    }
}
