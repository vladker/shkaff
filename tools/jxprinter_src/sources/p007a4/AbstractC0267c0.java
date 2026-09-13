package p007a4;

import E3.g;
import E3.q;
import g4.k;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.E;
import p028e4.C0654h;
import p028e4.L;
import p147z3.u;
import p147z3.v;

/* JADX INFO: renamed from: a4.c0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0267c0 extends k {
    public int resumeMode;

    public AbstractC0267c0(int i5) {
        super(0L, false);
        this.resumeMode = i5;
    }

    public abstract g<Object> getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        C0314z c0314z = obj instanceof C0314z ? (C0314z) obj : null;
        if (c0314z != null) {
            return c0314z.cause;
        }
        return null;
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th) {
        J.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new Q("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            g<Object> delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            E.d(delegate$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            C0654h c0654h = (C0654h) delegate$kotlinx_coroutines_core;
            g<Object> gVar = c0654h.continuation;
            Object obj = c0654h.countOrElement;
            q context = gVar.getContext();
            Object objUpdateThreadContext = L.updateThreadContext(context, obj);
            H0 h1 = null;
            z1 z1VarUpdateUndispatchedCompletion = objUpdateThreadContext != L.NO_THREAD_ELEMENTS ? D.updateUndispatchedCompletion(gVar, context, objUpdateThreadContext) : null;
            try {
                q context2 = gVar.getContext();
                Object objTakeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
                if (exceptionalResult$kotlinx_coroutines_core == null) {
                    int i5 = this.resumeMode;
                    boolean z6 = true;
                    if (i5 != 1 && i5 != 2) {
                        z6 = false;
                    }
                    if (z6) {
                        h1 = (H0) context2.get(H0.Key);
                    }
                }
                if (h1 != null && !h1.isActive()) {
                    CancellationException cancellationException = h1.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core, cancellationException);
                    gVar.resumeWith(u.m1361constructorimpl(v.createFailure(cancellationException)));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    gVar.resumeWith(u.m1361constructorimpl(v.createFailure(exceptionalResult$kotlinx_coroutines_core)));
                } else {
                    gVar.resumeWith(u.m1361constructorimpl(getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core)));
                }
            } finally {
                if (z1VarUpdateUndispatchedCompletion == null || z1VarUpdateUndispatchedCompletion.w()) {
                    L.restoreThreadContext(context, objUpdateThreadContext);
                }
            }
        } catch (Throwable th) {
            handleFatalException$kotlinx_coroutines_core(th);
        }
    }

    public abstract Object takeState$kotlinx_coroutines_core();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
    }
}
