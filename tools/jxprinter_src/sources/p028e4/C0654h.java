package p028e4;

import E3.g;
import E3.q;
import G3.e;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0267c0;
import p007a4.AbstractC0288l0;
import p007a4.B;
import p007a4.C0289m;
import p007a4.D;
import p007a4.F;
import p007a4.H0;
import p007a4.InterfaceC0285k;
import p007a4.S;
import p007a4.p1;
import p007a4.z1;
import p147z3.u;
import p147z3.v;

/* JADX INFO: renamed from: e4.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0654h extends AbstractC0267c0 implements e, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3940a = AtomicReferenceFieldUpdater.newUpdater(C0654h.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public Object _state;
    public final g<Object> continuation;
    public final Object countOrElement;
    public final F dispatcher;

    public C0654h(F f6, g<Object> gVar) {
        super(-1);
        this.dispatcher = f6;
        this.continuation = gVar;
        this._state = AbstractC0655i.UNDEFINED;
        this.countOrElement = L.threadContextElements(getContext());
    }

    public final C0289m claimReusableCancellableContinuation$kotlinx_coroutines_core() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3940a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, AbstractC0655i.REUSABLE_CLAIMED);
                return null;
            }
            if (obj instanceof C0289m) {
                H h6 = AbstractC0655i.REUSABLE_CLAIMED;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, h6)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return (C0289m) obj;
            }
            if (obj != AbstractC0655i.REUSABLE_CLAIMED && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void dispatchYield$kotlinx_coroutines_core(q qVar, Object obj) {
        this._state = obj;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(qVar, this);
    }

    @Override // G3.e
    public e getCallerFrame() {
        g<Object> gVar = this.continuation;
        if (gVar instanceof e) {
            return (e) gVar;
        }
        return null;
    }

    @Override // E3.g
    public q getContext() {
        return this.continuation.getContext();
    }

    @Override // G3.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final boolean postponeCancellation$kotlinx_coroutines_core(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3940a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            H h6 = AbstractC0655i.REUSABLE_CLAIMED;
            if (E.a(obj, h6)) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, h6, th)) {
                    if (atomicReferenceFieldUpdater.get(this) != h6) {
                    }
                }
                return true;
            }
            if (obj instanceof Throwable) {
                return true;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                }
            }
            return false;
        }
    }

    public final void resumeCancellableWith$kotlinx_coroutines_core(Object obj) {
        Object state = B.toState(obj);
        if (this.dispatcher.isDispatchNeeded(getContext())) {
            this._state = state;
            this.resumeMode = 1;
            this.dispatcher.mo1035dispatch(getContext(), this);
            return;
        }
        AbstractC0288l0 eventLoop$kotlinx_coroutines_core = p1.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.e()) {
            this._state = state;
            this.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        eventLoop$kotlinx_coroutines_core.d(true);
        try {
            H0 h1 = (H0) getContext().get(H0.Key);
            if (h1 == null || h1.isActive()) {
                g<Object> gVar = this.continuation;
                Object obj2 = this.countOrElement;
                q context = gVar.getContext();
                Object objUpdateThreadContext = L.updateThreadContext(context, obj2);
                z1 z1VarUpdateUndispatchedCompletion = objUpdateThreadContext != L.NO_THREAD_ELEMENTS ? D.updateUndispatchedCompletion(gVar, context, objUpdateThreadContext) : null;
                try {
                    this.continuation.resumeWith(obj);
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
                cancelCompletedResult$kotlinx_coroutines_core(state, cancellationException);
                resumeWith(u.m1361constructorimpl(v.createFailure(cancellationException)));
            }
            while (eventLoop$kotlinx_coroutines_core.h()) {
            }
        } catch (Throwable th2) {
            try {
                handleFatalException$kotlinx_coroutines_core(th2);
            } finally {
                eventLoop$kotlinx_coroutines_core.a(true);
            }
        }
    }

    public final boolean resumeCancelled$kotlinx_coroutines_core(Object obj) {
        H0 h1 = (H0) getContext().get(H0.Key);
        if (h1 == null || h1.isActive()) {
            return false;
        }
        CancellationException cancellationException = h1.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(obj, cancellationException);
        resumeWith(u.m1361constructorimpl(v.createFailure(cancellationException)));
        return true;
    }

    public final void resumeUndispatchedWith$kotlinx_coroutines_core(Object obj) {
        g<Object> gVar = this.continuation;
        Object obj2 = this.countOrElement;
        q context = gVar.getContext();
        Object objUpdateThreadContext = L.updateThreadContext(context, obj2);
        z1 z1VarUpdateUndispatchedCompletion = objUpdateThreadContext != L.NO_THREAD_ELEMENTS ? D.updateUndispatchedCompletion(gVar, context, objUpdateThreadContext) : null;
        try {
            this.continuation.resumeWith(obj);
        } finally {
            if (z1VarUpdateUndispatchedCompletion == null || z1VarUpdateUndispatchedCompletion.w()) {
                L.restoreThreadContext(context, objUpdateThreadContext);
            }
        }
    }

    @Override // E3.g
    public void resumeWith(Object obj) {
        Object state = B.toState(obj);
        if (this.dispatcher.isDispatchNeeded(getContext())) {
            this._state = state;
            this.resumeMode = 0;
            this.dispatcher.mo1035dispatch(getContext(), this);
            return;
        }
        AbstractC0288l0 eventLoop$kotlinx_coroutines_core = p1.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.e()) {
            this._state = state;
            this.resumeMode = 0;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        eventLoop$kotlinx_coroutines_core.d(true);
        try {
            q context = getContext();
            Object objUpdateThreadContext = L.updateThreadContext(context, this.countOrElement);
            try {
                this.continuation.resumeWith(obj);
                L.restoreThreadContext(context, objUpdateThreadContext);
                while (eventLoop$kotlinx_coroutines_core.h()) {
                }
            } catch (Throwable th) {
                L.restoreThreadContext(context, objUpdateThreadContext);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                handleFatalException$kotlinx_coroutines_core(th2);
            } finally {
                eventLoop$kotlinx_coroutines_core.a(true);
            }
        }
    }

    @Override // p007a4.AbstractC0267c0
    public Object takeState$kotlinx_coroutines_core() {
        Object obj = this._state;
        this._state = AbstractC0655i.UNDEFINED;
        return obj;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + S.toDebugString(this.continuation) + ']';
    }

    public final Throwable tryReleaseClaimedContinuation$kotlinx_coroutines_core(InterfaceC0285k interfaceC0285k) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3940a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            H h6 = AbstractC0655i.REUSABLE_CLAIMED;
            if (obj == h6) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, h6, interfaceC0285k)) {
                    if (atomicReferenceFieldUpdater.get(this) != h6) {
                    }
                }
                return null;
            }
            if (!(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            return (Throwable) obj;
        }
    }

    @Override // p007a4.AbstractC0267c0
    public g<Object> getDelegate$kotlinx_coroutines_core() {
        return this;
    }
}
