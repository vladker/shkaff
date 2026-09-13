package p007a4;

import E3.g;
import E3.o;
import E3.q;
import F3.h;
import F3.i;
import O3.l;
import O3.p;
import W3.InterfaceC0233q;
import W3.t;
import W3.y;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.Y;
import p028e4.C0660n;
import p028e4.C0663q;
import p028e4.H;
import p044h4.f;
import p147z3.AbstractC1926f;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class X0 implements H0, InterfaceC0302t, f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f949a = AtomicReferenceFieldUpdater.newUpdater(X0.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(X0.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public X0(boolean z6) {
        this._state$volatile = z6 ? Y0.EMPTY_ACTIVE : Y0.EMPTY_NEW;
    }

    public static C0300s m(C0663q c0663q) {
        while (c0663q.c()) {
            c0663q = c0663q.getPrevNode();
        }
        while (true) {
            c0663q = c0663q.getNextNode();
            if (!c0663q.c()) {
                if (c0663q instanceof C0300s) {
                    return (C0300s) c0663q;
                }
                if (c0663q instanceof C0268c1) {
                    return null;
                }
            }
        }
    }

    public static String s(Object obj) {
        if (!(obj instanceof R0)) {
            if (obj instanceof B0) {
                return ((B0) obj).isActive() ? "Active" : "New";
            }
            return obj instanceof C0314z ? "Cancelled" : "Completed";
        }
        R0 r6 = (R0) obj;
        if (r6.a()) {
            return "Cancelling";
        }
        return R0.f944a.get(r6) != 0 ? "Completing" : "Active";
    }

    @Override // p007a4.H0
    public final r attachChild(InterfaceC0302t interfaceC0302t) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        C0300s c0300s = new C0300s(interfaceC0302t);
        c0300s.setJob(this);
        loop0: while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof C0286k0) {
                C0286k0 c0286k0 = (C0286k0) state$kotlinx_coroutines_core;
                if (c0286k0.f951a) {
                    do {
                        atomicReferenceFieldUpdater = f949a;
                        if (atomicReferenceFieldUpdater.compareAndSet(this, state$kotlinx_coroutines_core, c0300s)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == state$kotlinx_coroutines_core);
                } else {
                    p(c0286k0);
                }
            } else {
                Throwable rootCause = null;
                if (!(state$kotlinx_coroutines_core instanceof B0)) {
                    Object state$kotlinx_coroutines_core2 = getState$kotlinx_coroutines_core();
                    C0314z c0314z = state$kotlinx_coroutines_core2 instanceof C0314z ? (C0314z) state$kotlinx_coroutines_core2 : null;
                    c0300s.invoke(c0314z != null ? c0314z.cause : null);
                    return C0271d1.INSTANCE;
                }
                C0268c1 list = ((B0) state$kotlinx_coroutines_core).getList();
                if (list != null) {
                    if (!list.addLast(c0300s, 7)) {
                        boolean zAddLast = list.addLast(c0300s, 3);
                        Object state$kotlinx_coroutines_core3 = getState$kotlinx_coroutines_core();
                        if (state$kotlinx_coroutines_core3 instanceof R0) {
                            rootCause = ((R0) state$kotlinx_coroutines_core3).getRootCause();
                        } else {
                            C0314z c0314z2 = state$kotlinx_coroutines_core3 instanceof C0314z ? (C0314z) state$kotlinx_coroutines_core3 : null;
                            if (c0314z2 != null) {
                                rootCause = c0314z2.cause;
                            }
                        }
                        c0300s.invoke(rootCause);
                        if (zAddLast) {
                            break;
                        }
                        return C0271d1.INSTANCE;
                    }
                    break;
                }
                q((O0) state$kotlinx_coroutines_core);
            }
        }
        return c0300s;
    }

    public final Object awaitInternal(g<Object> gVar) throws Throwable {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof B0)) {
                if (state$kotlinx_coroutines_core instanceof C0314z) {
                    throw ((C0314z) state$kotlinx_coroutines_core).cause;
                }
                return Y0.unboxState(state$kotlinx_coroutines_core);
            }
        } while (r(state$kotlinx_coroutines_core) < 0);
        P0 p1 = new P0(h.intercepted(gVar), this);
        p1.initCancellability();
        AbstractC0293o.disposeOnCancellation(p1, K0.invokeOnCompletion(this, true, new h1(p1)));
        Object result = p1.getResult();
        if (result == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result;
    }

    @Override // p007a4.H0
    public final boolean b() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof C0314z) {
            return true;
        }
        return (state$kotlinx_coroutines_core instanceof R0) && ((R0) state$kotlinx_coroutines_core).a();
    }

    @Override // p007a4.H0
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    public final boolean cancelCoroutine(Throwable th) {
        return cancelImpl$kotlinx_coroutines_core(th);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x004a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:? A[LOOP:2: B:59:0x00c6->B:101:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0042 A[PHI: r0
  0x0042: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v12 java.lang.Object) binds: [B:3:0x000a, B:16:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x0048  */
    /* JADX WARN: Code duplicated, block: B:26:0x0062  */
    /* JADX WARN: Code duplicated, block: B:27:0x0064  */
    /* JADX WARN: Code duplicated, block: B:29:0x0067 A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #0 {, blocks: (B:24:0x0053, B:29:0x0067, B:34:0x0071, B:40:0x0088, B:38:0x007e, B:39:0x0082), top: B:84:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0071 A[Catch: all -> 0x006f, TRY_ENTER, TryCatch #0 {, blocks: (B:24:0x0053, B:29:0x0067, B:34:0x0071, B:40:0x0088, B:38:0x007e, B:39:0x0082), top: B:84:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x007c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x007e A[Catch: all -> 0x006f, TryCatch #0 {, blocks: (B:24:0x0053, B:29:0x0067, B:34:0x0071, B:40:0x0088, B:38:0x007e, B:39:0x0082), top: B:84:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0091  */
    /* JADX WARN: Code duplicated, block: B:45:0x0095  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:81:0x0123 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x0124  */
    /* JADX WARN: Code duplicated, block: B:84:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x010b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0052 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x004a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x004a A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x0048, please report this as an issue */
    public final boolean cancelImpl$kotlinx_coroutines_core(Object obj) throws Throwable {
        Throwable thF;
        Object state$kotlinx_coroutines_core;
        boolean z6;
        Throwable rootCause;
        H h6;
        B0 b1;
        C0268c1 c0268c1K;
        R0 r6;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object objT;
        Object objT2 = Y0.COMPLETING_ALREADY;
        if (j()) {
            do {
                Object state$kotlinx_coroutines_core2 = getState$kotlinx_coroutines_core();
                if (state$kotlinx_coroutines_core2 instanceof B0) {
                    if (state$kotlinx_coroutines_core2 instanceof R0) {
                        if (R0.f944a.get((R0) state$kotlinx_coroutines_core2) != 0) {
                        }
                    }
                    objT2 = t(state$kotlinx_coroutines_core2, new C0314z(f(obj), false));
                }
                objT2 = Y0.COMPLETING_ALREADY;
                break;
            } while (objT2 == Y0.COMPLETING_RETRY);
            if (objT2 != Y0.COMPLETING_WAITING_CHILDREN) {
                if (objT2 == Y0.COMPLETING_ALREADY) {
                    thF = null;
                    loop1: while (true) {
                        state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
                        if (state$kotlinx_coroutines_core instanceof R0) {
                            synchronized (state$kotlinx_coroutines_core) {
                                if (R0.c.get((R0) state$kotlinx_coroutines_core) == Y0.SEALED) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (z6) {
                                    h6 = Y0.TOO_LATE_TO_CANCEL;
                                } else {
                                    boolean zA = ((R0) state$kotlinx_coroutines_core).a();
                                    if (obj == null || !zA) {
                                        if (thF == null) {
                                            thF = f(obj);
                                        }
                                        ((R0) state$kotlinx_coroutines_core).addExceptionLocked(thF);
                                    }
                                    rootCause = zA ? null : ((R0) state$kotlinx_coroutines_core).getRootCause();
                                    if (rootCause != null) {
                                        n(((R0) state$kotlinx_coroutines_core).getList(), rootCause);
                                    }
                                    h6 = Y0.COMPLETING_ALREADY;
                                }
                            }
                        } else if (state$kotlinx_coroutines_core instanceof B0) {
                            if (thF == null) {
                                thF = f(obj);
                            }
                            b1 = (B0) state$kotlinx_coroutines_core;
                            if (b1.isActive()) {
                                c0268c1K = k(b1);
                                if (c0268c1K == null) {
                                    continue;
                                } else {
                                    r6 = new R0(c0268c1K, false, thF);
                                    atomicReferenceFieldUpdater = f949a;
                                    while (true) {
                                        if (atomicReferenceFieldUpdater.compareAndSet(this, b1, r6)) {
                                            n(c0268c1K, thF);
                                            h6 = Y0.COMPLETING_ALREADY;
                                        } else if (atomicReferenceFieldUpdater.get(this) != b1) {
                                        }
                                    }
                                }
                            } else {
                                objT = t(state$kotlinx_coroutines_core, new C0314z(thF, false));
                                if (objT != Y0.COMPLETING_ALREADY) {
                                    throw new IllegalStateException(("Cannot happen in " + state$kotlinx_coroutines_core).toString());
                                }
                                if (objT != Y0.COMPLETING_RETRY) {
                                    objT2 = objT;
                                    break;
                                }
                            }
                        } else {
                            h6 = Y0.TOO_LATE_TO_CANCEL;
                        }
                        objT2 = h6;
                        break;
                    }
                }
                if (objT2 != Y0.COMPLETING_ALREADY && objT2 != Y0.COMPLETING_WAITING_CHILDREN) {
                    if (objT2 == Y0.TOO_LATE_TO_CANCEL) {
                        return false;
                    }
                    afterCompletion(objT2);
                    return true;
                }
            }
        } else {
            if (objT2 == Y0.COMPLETING_ALREADY) {
                thF = null;
                loop1: while (true) {
                    state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
                    if (state$kotlinx_coroutines_core instanceof R0) {
                        synchronized (state$kotlinx_coroutines_core) {
                            if (R0.c.get((R0) state$kotlinx_coroutines_core) == Y0.SEALED) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (z6) {
                                h6 = Y0.TOO_LATE_TO_CANCEL;
                            } else {
                                boolean zA2 = ((R0) state$kotlinx_coroutines_core).a();
                                if (obj == null) {
                                    if (thF == null) {
                                        thF = f(obj);
                                    }
                                    ((R0) state$kotlinx_coroutines_core).addExceptionLocked(thF);
                                } else {
                                    if (thF == null) {
                                        thF = f(obj);
                                    }
                                    ((R0) state$kotlinx_coroutines_core).addExceptionLocked(thF);
                                }
                                if (zA2) {
                                }
                                if (rootCause != null) {
                                    n(((R0) state$kotlinx_coroutines_core).getList(), rootCause);
                                }
                                h6 = Y0.COMPLETING_ALREADY;
                            }
                        }
                    } else if (state$kotlinx_coroutines_core instanceof B0) {
                        if (thF == null) {
                            thF = f(obj);
                        }
                        b1 = (B0) state$kotlinx_coroutines_core;
                        if (b1.isActive()) {
                            c0268c1K = k(b1);
                            if (c0268c1K == null) {
                                continue;
                            } else {
                                r6 = new R0(c0268c1K, false, thF);
                                atomicReferenceFieldUpdater = f949a;
                                while (true) {
                                    if (atomicReferenceFieldUpdater.compareAndSet(this, b1, r6)) {
                                        n(c0268c1K, thF);
                                        h6 = Y0.COMPLETING_ALREADY;
                                    } else if (atomicReferenceFieldUpdater.get(this) != b1) {
                                    }
                                }
                            }
                        } else {
                            objT = t(state$kotlinx_coroutines_core, new C0314z(thF, false));
                            if (objT != Y0.COMPLETING_ALREADY) {
                                throw new IllegalStateException(("Cannot happen in " + state$kotlinx_coroutines_core).toString());
                            }
                            if (objT != Y0.COMPLETING_RETRY) {
                                objT2 = objT;
                                break;
                            }
                        }
                    } else {
                        h6 = Y0.TOO_LATE_TO_CANCEL;
                    }
                    objT2 = h6;
                    break;
                }
            }
            if (objT2 != Y0.COMPLETING_ALREADY) {
                if (objT2 == Y0.TOO_LATE_TO_CANCEL) {
                    return false;
                }
                afterCompletion(objT2);
                return true;
            }
        }
        return true;
    }

    public void cancelInternal(Throwable th) throws Throwable {
        cancelImpl$kotlinx_coroutines_core(th);
    }

    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th) && i();
    }

    public final boolean d(Throwable th) {
        if (!l()) {
            boolean z6 = th instanceof CancellationException;
            r parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
            if (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == C0271d1.INSTANCE) {
                return z6;
            }
            return parentHandle$kotlinx_coroutines_core.childCancelled(th) || z6;
        }
        return true;
    }

    public final I0 defaultCancellationException$kotlinx_coroutines_core(String str, Throwable th) {
        if (str == null) {
            str = cancellationExceptionMessage();
        }
        return new I0(str, th, this);
    }

    public final void e(B0 b1, Object obj) throws Throwable {
        r parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(C0271d1.INSTANCE);
        }
        A a6 = null;
        C0314z c0314z = obj instanceof C0314z ? (C0314z) obj : null;
        Throwable th = c0314z != null ? c0314z.cause : null;
        if (b1 instanceof O0) {
            try {
                ((O0) b1).invoke(th);
                return;
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new A("Exception in completion handler " + b1 + " for " + this, th2));
                return;
            }
        }
        C0268c1 list = b1.getList();
        if (list != null) {
            list.addLast(new C0660n(1), 1);
            Object next = list.getNext();
            E.d(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            for (C0663q nextNode = (C0663q) next; !E.a(nextNode, list); nextNode = nextNode.getNextNode()) {
                if (nextNode instanceof O0) {
                    try {
                        ((O0) nextNode).invoke(th);
                    } catch (Throwable th3) {
                        if (a6 != null) {
                            AbstractC1926f.addSuppressed(a6, th3);
                        } else {
                            a6 = new A("Exception in completion handler " + nextNode + " for " + this, th3);
                        }
                    }
                }
            }
            if (a6 != null) {
                handleOnCompletionException$kotlinx_coroutines_core(a6);
            }
        }
    }

    public final Throwable f(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new I0(cancellationExceptionMessage(), null, this) : th;
        }
        E.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((f1) obj).getChildJobCancellationCause();
    }

    @Override // p007a4.H0, E3.o, E3.q
    public <R> R fold(R r6, p pVar) {
        return (R) F0.fold(this, r6, pVar);
    }

    public final Object g(R0 r6, Object obj) throws Throwable {
        boolean zA;
        Throwable thH;
        C0314z c0314z = obj instanceof C0314z ? (C0314z) obj : null;
        Throwable th = c0314z != null ? c0314z.cause : null;
        synchronized (r6) {
            zA = r6.a();
            List<Throwable> listSealLocked = r6.sealLocked(th);
            thH = h(r6, listSealLocked);
            if (thH != null && listSealLocked.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(listSealLocked.size()));
                for (Throwable th2 : listSealLocked) {
                    if (th2 != thH && th2 != thH && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        AbstractC1926f.addSuppressed(thH, th2);
                    }
                }
            }
        }
        if (thH != null && thH != th) {
            obj = new C0314z(thH, false);
        }
        if (thH != null && (d(thH) || handleJobException(thH))) {
            E.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            C0314z c0314z2 = (C0314z) obj;
            c0314z2.getClass();
            C0314z.f960a.compareAndSet(c0314z2, 0, 1);
        }
        if (!zA) {
            onCancelling(thH);
        }
        onCompletionInternal(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f949a;
        Object objBoxIncomplete = Y0.boxIncomplete(obj);
        while (!atomicReferenceFieldUpdater.compareAndSet(this, r6, objBoxIncomplete) && atomicReferenceFieldUpdater.get(this) == r6) {
        }
        e(r6, obj);
        return obj;
    }

    @Override // p007a4.H0, E3.o, E3.q
    public <E extends o> E get(E3.p pVar) {
        return (E) F0.get(this, pVar);
    }

    @Override // p007a4.H0
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof R0)) {
            if (state$kotlinx_coroutines_core instanceof B0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (state$kotlinx_coroutines_core instanceof C0314z) {
                return toCancellationException(((C0314z) state$kotlinx_coroutines_core).cause, null);
            }
            return new I0(S.getClassSimpleName(this) + " has completed normally", null, this);
        }
        Throwable rootCause = ((R0) state$kotlinx_coroutines_core).getRootCause();
        if (rootCause != null) {
            CancellationException cancellationException = toCancellationException(rootCause, S.getClassSimpleName(this) + " is cancelling");
            if (cancellationException != null) {
                return cancellationException;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // p007a4.f1
    public CancellationException getChildJobCancellationCause() {
        Throwable rootCause;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof R0) {
            rootCause = ((R0) state$kotlinx_coroutines_core).getRootCause();
        } else if (state$kotlinx_coroutines_core instanceof C0314z) {
            rootCause = ((C0314z) state$kotlinx_coroutines_core).cause;
        } else {
            if (state$kotlinx_coroutines_core instanceof B0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
            }
            rootCause = null;
        }
        CancellationException cancellationException = rootCause instanceof CancellationException ? (CancellationException) rootCause : null;
        return cancellationException == null ? new I0("Parent job is ".concat(s(state$kotlinx_coroutines_core)), rootCause, this) : cancellationException;
    }

    @Override // p007a4.H0
    public final InterfaceC0233q getChildren() {
        return t.sequence(new y(null, this));
    }

    public Object getCompleted() {
        return getCompletedInternal$kotlinx_coroutines_core();
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() throws Throwable {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof B0) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (state$kotlinx_coroutines_core instanceof C0314z) {
            throw ((C0314z) state$kotlinx_coroutines_core).cause;
        }
        return Y0.unboxState(state$kotlinx_coroutines_core);
    }

    public final Throwable getCompletionCause() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof R0) {
            Throwable rootCause = ((R0) state$kotlinx_coroutines_core).getRootCause();
            if (rootCause != null) {
                return rootCause;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (state$kotlinx_coroutines_core instanceof B0) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (state$kotlinx_coroutines_core instanceof C0314z) {
            return ((C0314z) state$kotlinx_coroutines_core).cause;
        }
        return null;
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof B0) {
            throw new IllegalStateException("This job has not completed yet");
        }
        C0314z c0314z = state$kotlinx_coroutines_core instanceof C0314z ? (C0314z) state$kotlinx_coroutines_core : null;
        if (c0314z != null) {
            return c0314z.cause;
        }
        return null;
    }

    @Override // p007a4.H0, E3.o
    public final E3.p getKey() {
        return H0.Key;
    }

    public final p044h4.h getOnAwaitInternal() {
        U0 u6 = U0.f946a;
        E.d(u6, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Y.c(3, u6);
        V0 v6 = V0.f947a;
        E.d(v6, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        Y.c(3, v6);
        return new p044h4.i(this, u6, v6, null);
    }

    @Override // p007a4.H0
    public final f getOnJoin() {
        W0 w6 = W0.f948a;
        E.d(w6, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Y.c(3, w6);
        return new p044h4.g(this, w6, null);
    }

    @Override // p007a4.H0
    public H0 getParent() {
        r parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            return parentHandle$kotlinx_coroutines_core.getParent();
        }
        return null;
    }

    public final r getParentHandle$kotlinx_coroutines_core() {
        return (r) b.get(this);
    }

    public final Object getState$kotlinx_coroutines_core() {
        return f949a.get(this);
    }

    public final Throwable h(R0 r6, List list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (r6.a()) {
                return new I0(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Throwable) next) instanceof CancellationException);
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) list.get(0);
        if (th2 instanceof u1) {
            for (Object obj2 : list) {
                Throwable th3 = (Throwable) obj2;
                if (th3 != th2 && (th3 instanceof u1)) {
                    obj = obj2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean handleJobException(Throwable th) {
        return false;
    }

    public boolean i() {
        return true;
    }

    public final void initParentJob(H0 h1) {
        if (h1 == null) {
            setParentHandle$kotlinx_coroutines_core(C0271d1.INSTANCE);
            return;
        }
        h1.start();
        r rVarAttachChild = h1.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(rVarAttachChild);
        if (getState$kotlinx_coroutines_core() instanceof B0) {
            return;
        }
        rVarAttachChild.dispose();
        setParentHandle$kotlinx_coroutines_core(C0271d1.INSTANCE);
    }

    @Override // p007a4.H0
    public final InterfaceC0280h0 invokeOnCompletion(l lVar) {
        return invokeOnCompletionInternal$kotlinx_coroutines_core(true, new E0(lVar));
    }

    public final InterfaceC0280h0 invokeOnCompletionInternal$kotlinx_coroutines_core(boolean z6, O0 o6) {
        boolean z7;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        boolean zAddLast;
        o6.setJob(this);
        loop0: while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            z7 = true;
            if (!(state$kotlinx_coroutines_core instanceof C0286k0)) {
                if (!(state$kotlinx_coroutines_core instanceof B0)) {
                    z7 = false;
                    break;
                }
                B0 b1 = (B0) state$kotlinx_coroutines_core;
                C0268c1 list = b1.getList();
                if (list == null) {
                    q((O0) state$kotlinx_coroutines_core);
                } else {
                    if (o6.d()) {
                        R0 r6 = b1 instanceof R0 ? (R0) b1 : null;
                        Throwable rootCause = r6 != null ? r6.getRootCause() : null;
                        if (rootCause != null) {
                            if (z6) {
                                o6.invoke(rootCause);
                            }
                            return C0271d1.INSTANCE;
                        }
                        zAddLast = list.addLast(o6, 5);
                    } else {
                        zAddLast = list.addLast(o6, 1);
                    }
                    if (zAddLast) {
                        break;
                    }
                }
            } else {
                C0286k0 c0286k0 = (C0286k0) state$kotlinx_coroutines_core;
                if (c0286k0.f951a) {
                    do {
                        atomicReferenceFieldUpdater = f949a;
                        if (atomicReferenceFieldUpdater.compareAndSet(this, state$kotlinx_coroutines_core, o6)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == state$kotlinx_coroutines_core);
                } else {
                    p(c0286k0);
                }
            }
        }
        if (z7) {
            return o6;
        }
        if (z6) {
            Object state$kotlinx_coroutines_core2 = getState$kotlinx_coroutines_core();
            C0314z c0314z = state$kotlinx_coroutines_core2 instanceof C0314z ? (C0314z) state$kotlinx_coroutines_core2 : null;
            o6.invoke(c0314z != null ? c0314z.cause : null);
        }
        return C0271d1.INSTANCE;
    }

    @Override // p007a4.H0
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof B0) && ((B0) state$kotlinx_coroutines_core).isActive();
    }

    public boolean j() {
        return this instanceof C0306v;
    }

    @Override // p007a4.H0
    public final Object join(g<? super Q> gVar) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof B0)) {
                K0.ensureActive(gVar.getContext());
                return Q.INSTANCE;
            }
        } while (r(state$kotlinx_coroutines_core) < 0);
        C0289m c0289m = new C0289m(h.intercepted(gVar), 1);
        c0289m.initCancellability();
        AbstractC0293o.disposeOnCancellation(c0289m, K0.invokeOnCompletion(this, true, new i1(c0289m)));
        Object result = c0289m.getResult();
        if (result == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        if (result != i.getCOROUTINE_SUSPENDED()) {
            result = Q.INSTANCE;
        }
        return result == i.getCOROUTINE_SUSPENDED() ? result : Q.INSTANCE;
    }

    public final C0268c1 k(B0 b1) {
        C0268c1 list = b1.getList();
        if (list != null) {
            return list;
        }
        if (b1 instanceof C0286k0) {
            return new C0268c1();
        }
        if (b1 instanceof O0) {
            q((O0) b1);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + b1).toString());
    }

    public boolean l() {
        return this instanceof C0266c;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object obj) {
        Object objT;
        do {
            objT = t(getState$kotlinx_coroutines_core(), obj);
            if (objT == Y0.COMPLETING_ALREADY) {
                return false;
            }
            if (objT == Y0.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        } while (objT == Y0.COMPLETING_RETRY);
        afterCompletion(objT);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object obj) {
        Object objT;
        do {
            objT = t(getState$kotlinx_coroutines_core(), obj);
            if (objT == Y0.COMPLETING_ALREADY) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                C0314z c0314z = obj instanceof C0314z ? (C0314z) obj : null;
                throw new IllegalStateException(str, c0314z != null ? c0314z.cause : null);
            }
        } while (objT == Y0.COMPLETING_RETRY);
        return objT;
    }

    @Override // p007a4.H0, E3.o, E3.q
    public q minusKey(E3.p pVar) {
        return F0.minusKey(this, pVar);
    }

    public final void n(C0268c1 c0268c1, Throwable th) throws Throwable {
        onCancelling(th);
        c0268c1.getClass();
        c0268c1.addLast(new C0660n(4), 4);
        Object next = c0268c1.getNext();
        E.d(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        A a6 = null;
        for (C0663q nextNode = (C0663q) next; !E.a(nextNode, c0268c1); nextNode = nextNode.getNextNode()) {
            if ((nextNode instanceof O0) && ((O0) nextNode).d()) {
                try {
                    ((O0) nextNode).invoke(th);
                } catch (Throwable th2) {
                    if (a6 != null) {
                        AbstractC1926f.addSuppressed(a6, th2);
                    } else {
                        a6 = new A("Exception in completion handler " + nextNode + " for " + this, th2);
                    }
                }
            }
        }
        if (a6 != null) {
            handleOnCompletionException$kotlinx_coroutines_core(a6);
        }
        d(th);
    }

    public String nameString$kotlinx_coroutines_core() {
        return S.getClassSimpleName(this);
    }

    public final void p(C0286k0 c0286k0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        C0268c1 c0268c1 = new C0268c1();
        Object a6 = c0268c1;
        if (!c0286k0.f951a) {
            a6 = new A0(c0268c1);
        }
        do {
            atomicReferenceFieldUpdater = f949a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, c0286k0, a6)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == c0286k0);
    }

    @Override // p007a4.InterfaceC0302t
    public final void parentCancelled(f1 f1Var) throws Throwable {
        cancelImpl$kotlinx_coroutines_core(f1Var);
    }

    @Override // p007a4.H0, E3.o, E3.q
    public q plus(q qVar) {
        return F0.plus(this, qVar);
    }

    public final void q(O0 o6) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        o6.addOneIfEmpty(new C0268c1());
        C0663q nextNode = o6.getNextNode();
        do {
            atomicReferenceFieldUpdater = f949a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, o6, nextNode)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == o6);
    }

    public final int r(Object obj) {
        boolean z6 = obj instanceof C0286k0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f949a;
        if (z6) {
            if (((C0286k0) obj).f951a) {
                return 0;
            }
            C0286k0 c0286k0 = Y0.EMPTY_ACTIVE;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0286k0)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            o();
            return 1;
        }
        if (!(obj instanceof A0)) {
            return 0;
        }
        C0268c1 list = ((A0) obj).getList();
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, list)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        o();
        return 1;
    }

    public final void removeNode$kotlinx_coroutines_core(O0 o6) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof O0)) {
                if (!(state$kotlinx_coroutines_core instanceof B0) || ((B0) state$kotlinx_coroutines_core).getList() == null) {
                    return;
                }
                o6.removeOrNext();
                return;
            }
            if (state$kotlinx_coroutines_core != o6) {
                return;
            }
            C0286k0 c0286k0 = Y0.EMPTY_ACTIVE;
            do {
                atomicReferenceFieldUpdater = f949a;
                if (atomicReferenceFieldUpdater.compareAndSet(this, state$kotlinx_coroutines_core, c0286k0)) {
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == state$kotlinx_coroutines_core);
        }
    }

    public final void setParentHandle$kotlinx_coroutines_core(r rVar) {
        b.set(this, rVar);
    }

    @Override // p007a4.H0
    public final boolean start() {
        int iR;
        do {
            iR = r(getState$kotlinx_coroutines_core());
            if (iR == 0) {
                return false;
            }
        } while (iR != 1);
        return true;
    }

    public final Object t(Object obj, Object obj2) throws Throwable {
        if (!(obj instanceof B0)) {
            return Y0.COMPLETING_ALREADY;
        }
        if (((obj instanceof C0286k0) || (obj instanceof O0)) && !(obj instanceof C0300s) && !(obj2 instanceof C0314z)) {
            B0 b1 = (B0) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f949a;
            Object objBoxIncomplete = Y0.boxIncomplete(obj2);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, b1, objBoxIncomplete)) {
                if (atomicReferenceFieldUpdater.get(this) != b1) {
                    return Y0.COMPLETING_RETRY;
                }
            }
            onCancelling(null);
            onCompletionInternal(obj2);
            e(b1, obj2);
            return obj2;
        }
        B0 b6 = (B0) obj;
        C0268c1 c0268c1K = k(b6);
        if (c0268c1K == null) {
            return Y0.COMPLETING_RETRY;
        }
        R0 r6 = b6 instanceof R0 ? (R0) b6 : null;
        if (r6 == null) {
            r6 = new R0(c0268c1K, false, null);
        }
        synchronized (r6) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = R0.f944a;
            if (atomicIntegerFieldUpdater.get(r6) != 0) {
                return Y0.COMPLETING_ALREADY;
            }
            atomicIntegerFieldUpdater.set(r6, 1);
            if (r6 != b6) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f949a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, b6, r6)) {
                    if (atomicReferenceFieldUpdater2.get(this) != b6) {
                        return Y0.COMPLETING_RETRY;
                    }
                }
            }
            boolean zA = r6.a();
            C0314z c0314z = obj2 instanceof C0314z ? (C0314z) obj2 : null;
            if (c0314z != null) {
                r6.addExceptionLocked(c0314z.cause);
            }
            Throwable rootCause = zA ? null : r6.getRootCause();
            if (rootCause != null) {
                n(c0268c1K, rootCause);
            }
            C0300s c0300sM = m(c0268c1K);
            if (c0300sM != null && u(r6, c0300sM, obj2)) {
                return Y0.COMPLETING_WAITING_CHILDREN;
            }
            c0268c1K.addLast(new C0660n(2), 2);
            C0300s c0300sM2 = m(c0268c1K);
            return (c0300sM2 == null || !u(r6, c0300sM2, obj2)) ? g(r6, obj2) : Y0.COMPLETING_WAITING_CHILDREN;
        }
    }

    public final CancellationException toCancellationException(Throwable th, String str) {
        CancellationException i1 = th instanceof CancellationException ? (CancellationException) th : null;
        if (i1 == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            i1 = new I0(str, th, this);
        }
        return i1;
    }

    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + s(getState$kotlinx_coroutines_core()) + '}';
    }

    public String toString() {
        return toDebugString() + '@' + S.getHexAddress(this);
    }

    public final boolean u(R0 r6, C0300s c0300s, Object obj) {
        while (K0.invokeOnCompletion(c0300s.childJob, false, new Q0(this, r6, c0300s, obj)) == C0271d1.INSTANCE) {
            c0300s = m(c0300s);
            if (c0300s == null) {
                return false;
            }
        }
        return true;
    }

    @Override // p007a4.H0
    public /* synthetic */ boolean cancel(Throwable th) throws Throwable {
        Throwable i1;
        if (th == null || (i1 = toCancellationException(th, null)) == null) {
            i1 = new I0(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(i1);
        return true;
    }

    @Override // p007a4.H0
    public H0 plus(H0 h1) {
        return F0.plus((H0) this, h1);
    }

    @Override // p007a4.H0
    public final InterfaceC0280h0 invokeOnCompletion(boolean z6, boolean z7, l lVar) {
        O0 e1;
        if (z6) {
            e1 = new D0(lVar);
        } else {
            e1 = new E0(lVar);
        }
        return invokeOnCompletionInternal$kotlinx_coroutines_core(z7, e1);
    }

    @Override // p007a4.H0
    public void cancel(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new I0(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    public void o() {
    }

    public void afterCompletion(Object obj) {
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable th) throws Throwable {
        throw th;
    }

    public void onCancelling(Throwable th) {
    }

    public void onCompletionInternal(Object obj) {
    }
}
