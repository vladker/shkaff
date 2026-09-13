package p007a4;

import E3.g;
import E3.q;
import F3.i;
import G3.e;
import O3.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p028e4.C0654h;
import p028e4.E;
import p028e4.H;

/* JADX INFO: renamed from: a4.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class C0289m extends AbstractC0267c0 implements InterfaceC0285k, e, B1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f954a = AtomicIntegerFieldUpdater.newUpdater(C0289m.class, "_decisionAndIndex$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(C0289m.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(C0289m.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    private final q context;
    private final g<Object> delegate;

    public C0289m(g<Object> gVar, int i5) {
        super(i5);
        this.delegate = gVar;
        this.context = gVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = C0263b.INSTANCE;
    }

    public static void g(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public static Object i(InterfaceC0274e1 interfaceC0274e1, Object obj, int i5, O3.q qVar, Object obj2) {
        if (obj instanceof C0314z) {
            return obj;
        }
        if ((i5 == 1 || i5 == 2 || obj2 != null) && !(qVar == null && !(interfaceC0274e1 instanceof InterfaceC0283j) && obj2 == null)) {
            return new C0312y(obj, interfaceC0274e1 instanceof InterfaceC0283j ? (InterfaceC0283j) interfaceC0274e1 : null, qVar, obj2, null, 16);
        }
        return obj;
    }

    public final void a(E e, Throwable th) {
        int i5 = f954a.get(this) & 536870911;
        if (i5 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            e.onCancellation(i5, th, getContext());
        } catch (Throwable th2) {
            J.handleCoroutineException(getContext(), new A("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        InterfaceC0280h0 interfaceC0280h0 = (InterfaceC0280h0) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0280h0 == null) {
            return;
        }
        interfaceC0280h0.dispose();
        atomicReferenceFieldUpdater.set(this, C0271d1.INSTANCE);
    }

    public final void c(int i5) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        do {
            atomicIntegerFieldUpdater = f954a;
            i6 = atomicIntegerFieldUpdater.get(this);
            int i7 = i6 >> 29;
            if (i7 != 0) {
                if (i7 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                AbstractC0270d0.dispatch(this, i5);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, 1073741824 + (536870911 & i6)));
    }

    public final void callCancelHandler(InterfaceC0283j interfaceC0283j, Throwable th) {
        try {
            interfaceC0283j.invoke(th);
        } catch (Throwable th2) {
            J.handleCoroutineException(getContext(), new A("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final <R> void callOnCancellation(O3.q qVar, Throwable th, R r6) {
        try {
            qVar.invoke(th, r6, getContext());
        } catch (Throwable th2) {
            J.handleCoroutineException(getContext(), new A("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // p007a4.InterfaceC0285k
    public boolean cancel(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof InterfaceC0274e1)) {
                return false;
            }
            C0295p c0295p = new C0295p(this, th, (obj instanceof InterfaceC0283j) || (obj instanceof E));
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, c0295p)) {
                    InterfaceC0274e1 interfaceC0274e1 = (InterfaceC0274e1) obj;
                    if (interfaceC0274e1 instanceof InterfaceC0283j) {
                        callCancelHandler((InterfaceC0283j) obj, th);
                    } else if (interfaceC0274e1 instanceof E) {
                        a((E) obj, th);
                    }
                    if (!f()) {
                        b();
                    }
                    c(this.resumeMode);
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }

    @Override // p007a4.AbstractC0267c0
    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
        Throwable th2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof InterfaceC0274e1) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof C0314z) {
                return;
            }
            if (!(obj2 instanceof C0312y)) {
                th2 = th;
                C0312y c0312y = new C0312y(obj2, null, null, null, th2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0312y)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    }
                }
                return;
            }
            C0312y c0312y2 = (C0312y) obj2;
            if (c0312y2.cancelCause != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            C0312y c0312yA = C0312y.a(c0312y2, null, th, 15);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0312yA)) {
                    c0312y2.invokeHandlers(this, th);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj2);
            th2 = th;
            th = th2;
        }
    }

    @Override // p007a4.InterfaceC0285k
    public void completeResume(Object obj) {
        c(this.resumeMode);
    }

    public final InterfaceC0280h0 d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        H0 h1 = (H0) getContext().get(H0.Key);
        if (h1 == null) {
            return null;
        }
        InterfaceC0280h0 interfaceC0280h0InvokeOnCompletion = K0.invokeOnCompletion(h1, true, new C0297q(this));
        do {
            atomicReferenceFieldUpdater = c;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, interfaceC0280h0InvokeOnCompletion)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return interfaceC0280h0InvokeOnCompletion;
    }

    public final void e(InterfaceC0274e1 interfaceC0274e1) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof C0263b) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, interfaceC0274e1)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            if ((obj instanceof InterfaceC0283j) || (obj instanceof E)) {
                g(interfaceC0274e1, obj);
                throw null;
            }
            if (obj instanceof C0314z) {
                C0314z c0314z = (C0314z) obj;
                if (!C0314z.f960a.compareAndSet(c0314z, 0, 1)) {
                    g(interfaceC0274e1, obj);
                    throw null;
                }
                if (obj instanceof C0295p) {
                    Throwable th = c0314z.cause;
                    if (interfaceC0274e1 instanceof InterfaceC0283j) {
                        callCancelHandler((InterfaceC0283j) interfaceC0274e1, th);
                        return;
                    } else {
                        kotlin.jvm.internal.E.d(interfaceC0274e1, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        a((E) interfaceC0274e1, th);
                        return;
                    }
                }
                return;
            }
            if (!(obj instanceof C0312y)) {
                if (interfaceC0274e1 instanceof E) {
                    return;
                }
                kotlin.jvm.internal.E.d(interfaceC0274e1, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                C0312y c0312y = new C0312y(obj, (InterfaceC0283j) interfaceC0274e1, null, null, null, 28);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0312y)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            C0312y c0312y2 = (C0312y) obj;
            if (c0312y2.cancelHandler != null) {
                g(interfaceC0274e1, obj);
                throw null;
            }
            if (interfaceC0274e1 instanceof E) {
                return;
            }
            kotlin.jvm.internal.E.d(interfaceC0274e1, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
            InterfaceC0283j interfaceC0283j = (InterfaceC0283j) interfaceC0274e1;
            Throwable th2 = c0312y2.cancelCause;
            if (th2 != null) {
                callCancelHandler(interfaceC0283j, th2);
                return;
            }
            C0312y c0312yA = C0312y.a(c0312y2, interfaceC0283j, null, 29);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0312yA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                }
            }
            return;
        }
    }

    public final boolean f() {
        if (this.resumeMode != 2) {
            return false;
        }
        g<Object> gVar = this.delegate;
        kotlin.jvm.internal.E.d(gVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        C0654h c0654h = (C0654h) gVar;
        c0654h.getClass();
        return C0654h.f3940a.get(c0654h) != null;
    }

    @Override // G3.e
    public e getCallerFrame() {
        g<Object> gVar = this.delegate;
        if (gVar instanceof e) {
            return (e) gVar;
        }
        return null;
    }

    @Override // p007a4.InterfaceC0285k, E3.g
    public q getContext() {
        return this.context;
    }

    public Throwable getContinuationCancellationCause(H0 h1) {
        return h1.getCancellationException();
    }

    @Override // p007a4.AbstractC0267c0
    public final g<Object> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // p007a4.AbstractC0267c0
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            return exceptionalResult$kotlinx_coroutines_core;
        }
        return null;
    }

    public final Object getResult() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i5;
        H0 h1;
        boolean zF = f();
        do {
            atomicIntegerFieldUpdater = f954a;
            i5 = atomicIntegerFieldUpdater.get(this);
            int i6 = i5 >> 29;
            if (i6 != 0) {
                if (i6 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zF) {
                    h();
                }
                Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
                if (state$kotlinx_coroutines_core instanceof C0314z) {
                    throw ((C0314z) state$kotlinx_coroutines_core).cause;
                }
                int i7 = this.resumeMode;
                if ((i7 != 1 && i7 != 2) || (h1 = (H0) getContext().get(H0.Key)) == null || h1.isActive()) {
                    return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
                }
                CancellationException cancellationException = h1.getCancellationException();
                cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
                throw cancellationException;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, 536870912 + (536870911 & i5)));
        if (((InterfaceC0280h0) c.get(this)) == null) {
            d();
        }
        if (zF) {
            h();
        }
        return i.getCOROUTINE_SUSPENDED();
    }

    @Override // G3.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return b.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007a4.AbstractC0267c0
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj instanceof C0312y ? (T) ((C0312y) obj).result : obj;
    }

    public final void h() {
        Throwable thTryReleaseClaimedContinuation$kotlinx_coroutines_core;
        g<Object> gVar = this.delegate;
        C0654h c0654h = gVar instanceof C0654h ? (C0654h) gVar : null;
        if (c0654h == null || (thTryReleaseClaimedContinuation$kotlinx_coroutines_core = c0654h.tryReleaseClaimedContinuation$kotlinx_coroutines_core(this)) == null) {
            return;
        }
        b();
        cancel(thTryReleaseClaimedContinuation$kotlinx_coroutines_core);
    }

    @Override // p007a4.InterfaceC0285k
    public final void initCancellability() {
        InterfaceC0280h0 interfaceC0280h0D = d();
        if (interfaceC0280h0D == null || (getState$kotlinx_coroutines_core() instanceof InterfaceC0274e1)) {
            return;
        }
        interfaceC0280h0D.dispose();
        c.set(this, C0271d1.INSTANCE);
    }

    @Override // p007a4.B1
    public void invokeOnCancellation(E e, int i5) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        do {
            atomicIntegerFieldUpdater = f954a;
            i6 = atomicIntegerFieldUpdater.get(this);
            if ((i6 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, ((i6 >> 29) << 29) + i5));
        e(e);
    }

    public final void invokeOnCancellationInternal$kotlinx_coroutines_core(InterfaceC0283j interfaceC0283j) {
        e(interfaceC0283j);
    }

    public final H j(Object obj, Object obj2, O3.q qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof InterfaceC0274e1)) {
                if ((obj3 instanceof C0312y) && obj2 != null && ((C0312y) obj3).idempotentResume == obj2) {
                    return AbstractC0291n.RESUME_TOKEN;
                }
                return null;
            }
            Object objI = i((InterfaceC0274e1) obj3, obj, this.resumeMode, qVar, obj2);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, objI)) {
                    if (!f()) {
                        b();
                    }
                    return AbstractC0291n.RESUME_TOKEN;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj3);
        }
    }

    public String nameString() {
        return "CancellableContinuation";
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable th) {
        boolean zPostponeCancellation$kotlinx_coroutines_core;
        if (f()) {
            g<Object> gVar = this.delegate;
            kotlin.jvm.internal.E.d(gVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            zPostponeCancellation$kotlinx_coroutines_core = ((C0654h) gVar).postponeCancellation$kotlinx_coroutines_core(th);
        } else {
            zPostponeCancellation$kotlinx_coroutines_core = false;
        }
        if (zPostponeCancellation$kotlinx_coroutines_core) {
            return;
        }
        cancel(th);
        if (f()) {
            return;
        }
        b();
    }

    public final boolean resetStateReusable() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof C0312y) && ((C0312y) obj).idempotentResume != null) {
            b();
            return false;
        }
        f954a.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, C0263b.INSTANCE);
        return true;
    }

    @Override // p007a4.InterfaceC0285k
    public void resume(Object obj, l lVar) {
        resumeImpl$kotlinx_coroutines_core(obj, this.resumeMode, lVar != null ? new C0287l(lVar, 0) : null);
    }

    public final <R> void resumeImpl$kotlinx_coroutines_core(R r6, int i5, O3.q qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof InterfaceC0274e1)) {
                if (obj instanceof C0295p) {
                    C0295p c0295p = (C0295p) obj;
                    if (C0295p.b.compareAndSet(c0295p, 0, 1)) {
                        if (qVar != null) {
                            callOnCancellation(qVar, c0295p.cause, r6);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + r6).toString());
            }
            Object objI = i((InterfaceC0274e1) obj, r6, i5, qVar, null);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, objI)) {
                    if (!f()) {
                        b();
                    }
                    c(i5);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }

    @Override // p007a4.InterfaceC0285k
    public void resumeUndispatched(F f6, Object obj) {
        g<Object> gVar = this.delegate;
        C0654h c0654h = gVar instanceof C0654h ? (C0654h) gVar : null;
        resumeImpl$kotlinx_coroutines_core(obj, (c0654h != null ? c0654h.dispatcher : null) == f6 ? 4 : this.resumeMode, null);
    }

    @Override // p007a4.InterfaceC0285k
    public void resumeUndispatchedWithException(F f6, Throwable th) {
        g<Object> gVar = this.delegate;
        C0654h c0654h = gVar instanceof C0654h ? (C0654h) gVar : null;
        resumeImpl$kotlinx_coroutines_core(new C0314z(th, false), (c0654h != null ? c0654h.dispatcher : null) == f6 ? 4 : this.resumeMode, null);
    }

    @Override // p007a4.InterfaceC0285k, E3.g
    public void resumeWith(Object obj) {
        resumeImpl$kotlinx_coroutines_core(B.toState(obj, this), this.resumeMode, null);
    }

    @Override // p007a4.AbstractC0267c0
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(nameString());
        sb.append('(');
        sb.append(S.toDebugString(this.delegate));
        sb.append("){");
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof InterfaceC0274e1) {
            str = "Active";
        } else {
            str = state$kotlinx_coroutines_core instanceof C0295p ? "Cancelled" : "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(S.getHexAddress(this));
        return sb.toString();
    }

    @Override // p007a4.InterfaceC0285k
    public Object tryResume(Object obj, Object obj2) {
        return j(obj, obj2, null);
    }

    @Override // p007a4.InterfaceC0285k
    public Object tryResumeWithException(Throwable th) {
        return j(new C0314z(th, false), null, null);
    }

    @Override // p007a4.InterfaceC0285k
    public <R> void resume(R r6, O3.q qVar) {
        resumeImpl$kotlinx_coroutines_core(r6, this.resumeMode, qVar);
    }

    @Override // p007a4.InterfaceC0285k
    public <R> Object tryResume(R r6, Object obj, O3.q qVar) {
        return j(r6, obj, qVar);
    }

    @Override // p007a4.InterfaceC0285k
    public void invokeOnCancellation(l lVar) {
        AbstractC0293o.invokeOnCancellation(this, new C0281i(lVar));
    }
}
