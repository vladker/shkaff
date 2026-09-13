package p018c4;

import E3.g;
import F3.h;
import F3.i;
import G3.b;
import O3.l;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0293o;
import p007a4.B1;
import p007a4.C0289m;
import p028e4.G;
import p147z3.u;
import p147z3.v;

/* JADX INFO: renamed from: c4.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0374e implements InterfaceC0395z, B1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0376f f1143a;
    private C0289m continuation;
    private Object receiveResult = AbstractC0388s.NO_RECEIVE_RESULT;

    public C0374e(C0376f c0376f) {
        this.f1143a = c0376f;
    }

    public final Object a() throws Throwable {
        Object obj = this.receiveResult;
        if (obj == AbstractC0388s.NO_RECEIVE_RESULT) {
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }
        this.receiveResult = AbstractC0388s.NO_RECEIVE_RESULT;
        if (obj != AbstractC0388s.getCHANNEL_CLOSED()) {
            return obj;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = C0376f.b;
        throw G.recoverStackTrace(this.f1143a.m());
    }

    public final boolean b(Object obj) {
        C0289m c0289m = this.continuation;
        E.c(c0289m);
        this.continuation = null;
        this.receiveResult = obj;
        Boolean bool = Boolean.TRUE;
        l lVar = this.f1143a.onUndeliveredElement;
        return AbstractC0388s.p(c0289m, bool, lVar != null ? new C0370c(lVar, obj, 0) : null);
    }

    public final void c() {
        C0289m c0289m = this.continuation;
        E.c(c0289m);
        this.continuation = null;
        this.receiveResult = AbstractC0388s.getCHANNEL_CLOSED();
        Throwable closeCause = this.f1143a.getCloseCause();
        if (closeCause == null) {
            c0289m.resumeWith(u.m1361constructorimpl(Boolean.FALSE));
        } else {
            c0289m.resumeWith(u.m1361constructorimpl(v.createFailure(closeCause)));
        }
    }

    @Override // p018c4.InterfaceC0395z
    public Object hasNext(g<? super Boolean> gVar) throws Throwable {
        E eL;
        Boolean boolBoxBoolean;
        boolean z6 = true;
        if (this.receiveResult == AbstractC0388s.NO_RECEIVE_RESULT || this.receiveResult == AbstractC0388s.getCHANNEL_CLOSED()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C0376f.f1150g;
            C0376f c0376f = this.f1143a;
            E e = (E) atomicReferenceFieldUpdater.get(c0376f);
            while (!c0376f.q()) {
                long andIncrement = C0376f.c.getAndIncrement(c0376f);
                int i5 = AbstractC0388s.SEGMENT_SIZE;
                long j6 = andIncrement / ((long) i5);
                int i6 = (int) (andIncrement % ((long) i5));
                if (e.id != j6) {
                    eL = c0376f.l(j6, e);
                    if (eL == null) {
                        continue;
                    }
                } else {
                    eL = e;
                }
                Object objB = c0376f.B(eL, i6, andIncrement, null);
                if (objB == AbstractC0388s.SUSPEND) {
                    throw new IllegalStateException("unreachable");
                }
                if (objB == AbstractC0388s.FAILED) {
                    if (andIncrement < c0376f.n()) {
                        eL.a();
                    }
                    e = eL;
                } else {
                    if (objB == AbstractC0388s.SUSPEND_NO_WAITER) {
                        C0376f c0376f2 = this.f1143a;
                        C0289m orCreateCancellableContinuation = AbstractC0293o.getOrCreateCancellableContinuation(h.intercepted(gVar));
                        try {
                            this.continuation = orCreateCancellableContinuation;
                            Object objB2 = c0376f2.B(eL, i6, andIncrement, this);
                            if (objB2 != AbstractC0388s.SUSPEND) {
                                C0370c c0370c = null;
                                if (objB2 == AbstractC0388s.FAILED) {
                                    if (andIncrement < c0376f2.n()) {
                                        eL.a();
                                    }
                                    E e6 = (E) C0376f.f1150g.get(c0376f2);
                                    while (true) {
                                        if (c0376f2.q()) {
                                            C0289m c0289m = this.continuation;
                                            E.c(c0289m);
                                            this.continuation = null;
                                            this.receiveResult = AbstractC0388s.getCHANNEL_CLOSED();
                                            Throwable closeCause = c0376f.getCloseCause();
                                            if (closeCause != null) {
                                                c0289m.resumeWith(u.m1361constructorimpl(v.createFailure(closeCause)));
                                                break;
                                            }
                                            c0289m.resumeWith(u.m1361constructorimpl(Boolean.FALSE));
                                            break;
                                        }
                                        long andIncrement2 = C0376f.c.getAndIncrement(c0376f2);
                                        long j7 = AbstractC0388s.SEGMENT_SIZE;
                                        long j8 = andIncrement2 / j7;
                                        int i7 = (int) (andIncrement2 % j7);
                                        if (e6.id != j8) {
                                            E eL2 = c0376f2.l(j8, e6);
                                            if (eL2 != null) {
                                                e6 = eL2;
                                            }
                                        }
                                        Object objB3 = c0376f2.B(e6, i7, andIncrement2, this);
                                        if (objB3 == AbstractC0388s.SUSPEND) {
                                            invokeOnCancellation(e6, i7);
                                            break;
                                        }
                                        if (objB3 == AbstractC0388s.FAILED) {
                                            if (andIncrement2 < c0376f2.n()) {
                                                e6.a();
                                            }
                                        } else {
                                            if (objB3 == AbstractC0388s.SUSPEND_NO_WAITER) {
                                                throw new IllegalStateException("unexpected");
                                            }
                                            e6.a();
                                            this.receiveResult = objB3;
                                            this.continuation = null;
                                            boolBoxBoolean = b.boxBoolean(true);
                                            l lVar = c0376f2.onUndeliveredElement;
                                            if (lVar != null) {
                                                c0370c = new C0370c(lVar, objB3, 0);
                                            }
                                        }
                                    }
                                } else {
                                    eL.a();
                                    this.receiveResult = objB2;
                                    this.continuation = null;
                                    boolBoxBoolean = b.boxBoolean(true);
                                    l lVar2 = c0376f2.onUndeliveredElement;
                                    if (lVar2 != null) {
                                        c0370c = new C0370c(lVar2, objB2, 0);
                                    }
                                }
                                orCreateCancellableContinuation.resume(boolBoxBoolean, c0370c);
                                break;
                            }
                            invokeOnCancellation(eL, i6);
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
                    eL.a();
                    this.receiveResult = objB;
                }
            }
            this.receiveResult = AbstractC0388s.getCHANNEL_CLOSED();
            Throwable closeCause2 = c0376f.getCloseCause();
            if (closeCause2 != null) {
                throw G.recoverStackTrace(closeCause2);
            }
            z6 = false;
        }
        return b.boxBoolean(z6);
    }

    @Override // p007a4.B1
    public void invokeOnCancellation(p028e4.E e, int i5) {
        C0289m c0289m = this.continuation;
        if (c0289m != null) {
            c0289m.invokeOnCancellation(e, i5);
        }
    }

    @Override // p018c4.InterfaceC0395z
    public /* synthetic */ Object next(g gVar) {
        return AbstractC0393x.next(this, gVar);
    }
}
