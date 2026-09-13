package p018c4;

import A3.AbstractC0157z;
import A3.I;
import E3.g;
import F3.i;
import G3.b;
import G3.d;
import O3.l;
import O3.p;
import O3.q;
import X3.e0;
import androidx.core.location.LocationRequestCompat;
import androidx.webkit.ProxyConfig;
import com.google.common.primitives.Longs;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.Y;
import p007a4.AbstractC0293o;
import p007a4.B1;
import p007a4.C0287l;
import p007a4.C0289m;
import p007a4.InterfaceC0285k;
import p007a4.S;
import p028e4.A;
import p028e4.AbstractC0647a;
import p028e4.AbstractC0648b;
import p028e4.AbstractC0657k;
import p028e4.F;
import p028e4.G;
import p028e4.H;
import p044h4.h;
import p044h4.j;
import p044h4.k;
import p044h4.m;
import p044h4.o;
import p044h4.s;
import p147z3.AbstractC1926f;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: renamed from: c4.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class C0376f implements InterfaceC0391v {
    public static final /* synthetic */ AtomicLongFieldUpdater b = AtomicLongFieldUpdater.newUpdater(C0376f.class, "sendersAndCloseStatus$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater c = AtomicLongFieldUpdater.newUpdater(C0376f.class, "receivers$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(C0376f.class, "bufferEnd$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(C0376f.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1149f = AtomicReferenceFieldUpdater.newUpdater(C0376f.class, Object.class, "sendSegment$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1150g = AtomicReferenceFieldUpdater.newUpdater(C0376f.class, Object.class, "receiveSegment$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1151h = AtomicReferenceFieldUpdater.newUpdater(C0376f.class, Object.class, "bufferEndSegment$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1152i = AtomicReferenceFieldUpdater.newUpdater(C0376f.class, Object.class, "_closeCause$volatile");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1153j = AtomicReferenceFieldUpdater.newUpdater(C0376f.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1154a;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    public final l onUndeliveredElement;
    private final q onUndeliveredElementReceiveCancellationConstructor;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    /* JADX INFO: renamed from: c4.f$a */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a implements B1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0289m f1155a;
        private final InterfaceC0285k cont;

        public a(InterfaceC0285k interfaceC0285k) {
            E.d(interfaceC0285k, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.f1155a = (C0289m) interfaceC0285k;
            this.cont = interfaceC0285k;
        }

        public final InterfaceC0285k getCont() {
            return this.cont;
        }

        @Override // p007a4.B1
        public void invokeOnCancellation(p028e4.E e, int i5) {
            this.f1155a.invokeOnCancellation(e, i5);
        }
    }

    public C0376f(int i5, l lVar) {
        this.f1154a = i5;
        this.onUndeliveredElement = lVar;
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        int i6 = AbstractC0388s.SEGMENT_SIZE;
        this.bufferEnd$volatile = i5 != 0 ? i5 != Integer.MAX_VALUE ? i5 : LocationRequestCompat.PASSIVE_INTERVAL : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = d.get(this);
        E e6 = new E(0L, null, this, 3);
        this.sendSegment$volatile = e6;
        this.receiveSegment$volatile = e6;
        if (s()) {
            e6 = AbstractC0388s.NULL_SEGMENT;
            E.d(e6, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = e6;
        this.onUndeliveredElementReceiveCancellationConstructor = lVar != null ? new C0287l(this, 1) : null;
        this._closeCause$volatile = AbstractC0388s.NO_CLOSE_CAUSE;
    }

    public static final E b(C0376f c0376f, long j6, E e6) {
        Object objFindSegmentInternal;
        C0376f c0376f2;
        p pVar = (p) AbstractC0388s.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = AbstractC0647a.findSegmentInternal(e6, j6, pVar);
            if (!F.a(objFindSegmentInternal)) {
                p028e4.E eM1031getSegmentimpl = F.m1031getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1149f;
                    p028e4.E e7 = (p028e4.E) atomicReferenceFieldUpdater.get(c0376f);
                    if (e7.id >= eM1031getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!eM1031getSegmentimpl.g()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(c0376f, e7, eM1031getSegmentimpl)) {
                            if (!e7.d()) {
                                break loop0;
                            }
                            e7.c();
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(c0376f) == e7);
                    if (eM1031getSegmentimpl.d()) {
                        eM1031getSegmentimpl.c();
                    }
                }
            } else {
                break;
            }
        }
        boolean zA = F.a(objFindSegmentInternal);
        AtomicLongFieldUpdater atomicLongFieldUpdater = c;
        if (zA) {
            c0376f.c();
            if (e6.id * ((long) AbstractC0388s.SEGMENT_SIZE) < atomicLongFieldUpdater.get(c0376f)) {
                e6.a();
                return null;
            }
        } else {
            E e8 = (E) F.m1031getSegmentimpl(objFindSegmentInternal);
            long j7 = e8.id;
            if (j7 <= j6) {
                return e8;
            }
            long j8 = j7 * ((long) AbstractC0388s.SEGMENT_SIZE);
            while (true) {
                long j9 = b.get(c0376f);
                long j10 = 1152921504606846975L & j9;
                if (j10 >= j8) {
                    c0376f2 = c0376f;
                    break;
                }
                c0376f2 = c0376f;
                if (b.compareAndSet(c0376f2, j9, (((long) ((int) (j9 >> 60))) << 60) + j10)) {
                    break;
                }
                c0376f = c0376f2;
            }
            if (e8.id * ((long) AbstractC0388s.SEGMENT_SIZE) < atomicLongFieldUpdater.get(c0376f2)) {
                e8.a();
            }
        }
        return null;
    }

    public static final void d(C0376f c0376f, Object obj, C0289m c0289m) {
        l lVar = c0376f.onUndeliveredElement;
        if (lVar != null) {
            A.callUndeliveredElement(lVar, obj, c0289m.getContext());
        }
        c0289m.resumeWith(u.m1361constructorimpl(v.createFailure(c0376f.getSendException())));
    }

    public static final void e(C0376f c0376f, B1 b1, E e6, int i5) {
        b1.invokeOnCancellation(e6, i5 + AbstractC0388s.SEGMENT_SIZE);
    }

    public static final void f(C0376f c0376f, o oVar) {
        E e6;
        Object obj;
        c0376f.getClass();
        E e7 = (E) f1150g.get(c0376f);
        while (!c0376f.q()) {
            long andIncrement = c.getAndIncrement(c0376f);
            long j6 = AbstractC0388s.SEGMENT_SIZE;
            long j7 = andIncrement / j6;
            int i5 = (int) (andIncrement % j6);
            if (e7.id != j7) {
                E eL = c0376f.l(j7, e7);
                if (eL == null) {
                    continue;
                } else {
                    e6 = eL;
                }
            } else {
                e6 = e7;
            }
            Object objB = c0376f.B(e6, i5, andIncrement, oVar);
            e7 = e6;
            if (objB == AbstractC0388s.SUSPEND) {
                B1 b1 = oVar instanceof B1 ? (B1) obj : null;
                if (b1 == null) {
                    obj = oVar;
                    return;
                } else {
                    obj = oVar;
                    b1.invokeOnCancellation(e7, i5);
                    return;
                }
            }
            if (objB != AbstractC0388s.FAILED) {
                if (objB == AbstractC0388s.SUSPEND_NO_WAITER) {
                    throw new IllegalStateException("unexpected");
                }
                e7.a();
                oVar.selectInRegistrationPhase(objB);
                return;
            }
            if (andIncrement < c0376f.n()) {
                e7.a();
            }
            c0376f = c0376f;
            oVar = oVar;
        }
        oVar.selectInRegistrationPhase(AbstractC0388s.getCHANNEL_CLOSED());
    }

    public static final int g(C0376f c0376f, E e6, int i5, Object obj, long j6, Object obj2, boolean z6) {
        e6.j(i5, obj);
        if (z6) {
            return c0376f.C(e6, i5, obj, j6, obj2, z6);
        }
        Object state$kotlinx_coroutines_core = e6.getState$kotlinx_coroutines_core(i5);
        if (state$kotlinx_coroutines_core == null) {
            if (c0376f.h(j6)) {
                if (e6.casState$kotlinx_coroutines_core(i5, null, AbstractC0388s.BUFFERED)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (e6.casState$kotlinx_coroutines_core(i5, null, obj2)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof B1) {
            e6.j(i5, null);
            if (c0376f.z(state$kotlinx_coroutines_core, obj)) {
                e6.setState$kotlinx_coroutines_core(i5, AbstractC0388s.DONE_RCV);
                return 0;
            }
            if (e6.getAndSetState$kotlinx_coroutines_core(i5, AbstractC0388s.INTERRUPTED_RCV) == AbstractC0388s.INTERRUPTED_RCV) {
                return 5;
            }
            e6.i(i5, true);
            return 5;
        }
        return c0376f.C(e6, i5, obj, j6, obj2, z6);
    }

    public static void o(C0376f c0376f) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = e;
        if ((atomicLongFieldUpdater.addAndGet(c0376f, 1L) & Longs.MAX_POWER_OF_TWO) != 0) {
            while ((atomicLongFieldUpdater.get(c0376f) & Longs.MAX_POWER_OF_TWO) != 0) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static /* synthetic */ Object w(C0376f c0376f, g gVar) throws Throwable {
        C0386p c0386p;
        E e6;
        if (gVar instanceof C0386p) {
            c0386p = (C0386p) gVar;
            int i5 = c0386p.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0386p.c = i5 - Integer.MIN_VALUE;
            } else {
                c0386p = new C0386p(c0376f, gVar);
            }
        } else {
            c0386p = new C0386p(c0376f, gVar);
        }
        C0386p c0386p2 = c0386p;
        Object obj = c0386p2.f1183a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0386p2.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((B) obj).c();
        }
        v.throwOnFailure(obj);
        E e7 = (E) f1150g.get(c0376f);
        while (!c0376f.q()) {
            long andIncrement = c.getAndIncrement(c0376f);
            long j6 = AbstractC0388s.SEGMENT_SIZE;
            long j7 = andIncrement / j6;
            int i7 = (int) (andIncrement % j6);
            if (e7.id != j7) {
                E eL = c0376f.l(j7, e7);
                if (eL == null) {
                    continue;
                } else {
                    e6 = eL;
                }
            } else {
                e6 = e7;
            }
            C0376f c0376f2 = c0376f;
            Object objB = c0376f2.B(e6, i7, andIncrement, null);
            if (objB == AbstractC0388s.SUSPEND) {
                throw new IllegalStateException("unexpected");
            }
            if (objB != AbstractC0388s.FAILED) {
                if (objB != AbstractC0388s.SUSPEND_NO_WAITER) {
                    e6.a();
                    return B.Companion.m1010successJP2dKIU(objB);
                }
                c0386p2.c = 1;
                Object objX = c0376f2.x(e6, i7, andIncrement, c0386p2);
                return objX == coroutine_suspended ? coroutine_suspended : objX;
            }
            if (andIncrement < c0376f2.n()) {
                e6.a();
            }
            c0376f = c0376f2;
            e7 = e6;
        }
        return B.Companion.m1008closedJP2dKIU(c0376f.getCloseCause());
    }

    public final boolean A(Object obj, E e6, int i5) {
        if (obj instanceof InterfaceC0285k) {
            return AbstractC0388s.p((InterfaceC0285k) obj, Q.INSTANCE, null);
        }
        if (obj instanceof o) {
            s sVarTrySelectDetailed = ((m) obj).trySelectDetailed(this, Q.INSTANCE);
            if (sVarTrySelectDetailed == s.b) {
                e6.j(i5, null);
            }
            return sVarTrySelectDetailed == s.f4039a;
        }
        if (obj instanceof a) {
            return AbstractC0388s.p(((a) obj).getCont(), Boolean.TRUE, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public final Object B(E e6, int i5, long j6, Object obj) {
        Object state$kotlinx_coroutines_core = e6.getState$kotlinx_coroutines_core(i5);
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        if (state$kotlinx_coroutines_core == null) {
            if (j6 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return AbstractC0388s.SUSPEND_NO_WAITER;
                }
                if (e6.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, obj)) {
                    k();
                    return AbstractC0388s.SUSPEND;
                }
            }
        } else if (state$kotlinx_coroutines_core == AbstractC0388s.BUFFERED && e6.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, AbstractC0388s.DONE_RCV)) {
            k();
            Object objH = e6.h(i5);
            e6.j(i5, null);
            return objH;
        }
        while (true) {
            Object state$kotlinx_coroutines_core2 = e6.getState$kotlinx_coroutines_core(i5);
            if (state$kotlinx_coroutines_core2 == null || state$kotlinx_coroutines_core2 == AbstractC0388s.IN_BUFFER) {
                if (j6 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (e6.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core2, AbstractC0388s.POISONED)) {
                        k();
                        return AbstractC0388s.FAILED;
                    }
                } else {
                    if (obj == null) {
                        return AbstractC0388s.SUSPEND_NO_WAITER;
                    }
                    if (e6.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core2, obj)) {
                        k();
                        return AbstractC0388s.SUSPEND;
                    }
                }
            } else {
                if (state$kotlinx_coroutines_core2 != AbstractC0388s.BUFFERED) {
                    if (state$kotlinx_coroutines_core2 != AbstractC0388s.INTERRUPTED_SEND && state$kotlinx_coroutines_core2 != AbstractC0388s.POISONED) {
                        if (state$kotlinx_coroutines_core2 == AbstractC0388s.getCHANNEL_CLOSED()) {
                            k();
                            return AbstractC0388s.FAILED;
                        }
                        if (state$kotlinx_coroutines_core2 != AbstractC0388s.RESUMING_BY_EB && e6.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core2, AbstractC0388s.RESUMING_BY_RCV)) {
                            boolean z6 = state$kotlinx_coroutines_core2 instanceof E0;
                            if (z6) {
                                state$kotlinx_coroutines_core2 = ((E0) state$kotlinx_coroutines_core2).waiter;
                            }
                            if (A(state$kotlinx_coroutines_core2, e6, i5)) {
                                e6.setState$kotlinx_coroutines_core(i5, AbstractC0388s.DONE_RCV);
                                k();
                                Object objH2 = e6.h(i5);
                                e6.j(i5, null);
                                return objH2;
                            }
                            e6.setState$kotlinx_coroutines_core(i5, AbstractC0388s.INTERRUPTED_SEND);
                            e6.f();
                            if (z6) {
                                k();
                            }
                            return AbstractC0388s.FAILED;
                        }
                    }
                    return AbstractC0388s.FAILED;
                }
                if (e6.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core2, AbstractC0388s.DONE_RCV)) {
                    k();
                    Object objH3 = e6.h(i5);
                    e6.j(i5, null);
                    return objH3;
                }
            }
        }
    }

    public final int C(E e6, int i5, Object obj, long j6, Object obj2, boolean z6) {
        while (true) {
            Object state$kotlinx_coroutines_core = e6.getState$kotlinx_coroutines_core(i5);
            if (state$kotlinx_coroutines_core == null) {
                if (!h(j6) || z6) {
                    if (z6) {
                        if (e6.casState$kotlinx_coroutines_core(i5, null, AbstractC0388s.INTERRUPTED_SEND)) {
                            e6.f();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (e6.casState$kotlinx_coroutines_core(i5, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (e6.casState$kotlinx_coroutines_core(i5, null, AbstractC0388s.BUFFERED)) {
                    break;
                }
            } else {
                if (state$kotlinx_coroutines_core != AbstractC0388s.IN_BUFFER) {
                    if (state$kotlinx_coroutines_core == AbstractC0388s.INTERRUPTED_RCV) {
                        e6.j(i5, null);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == AbstractC0388s.POISONED) {
                        e6.j(i5, null);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == AbstractC0388s.getCHANNEL_CLOSED()) {
                        e6.j(i5, null);
                        c();
                        return 4;
                    }
                    e6.j(i5, null);
                    if (state$kotlinx_coroutines_core instanceof E0) {
                        state$kotlinx_coroutines_core = ((E0) state$kotlinx_coroutines_core).waiter;
                    }
                    if (z(state$kotlinx_coroutines_core, obj)) {
                        e6.setState$kotlinx_coroutines_core(i5, AbstractC0388s.DONE_RCV);
                        return 0;
                    }
                    if (e6.getAndSetState$kotlinx_coroutines_core(i5, AbstractC0388s.INTERRUPTED_RCV) != AbstractC0388s.INTERRUPTED_RCV) {
                        e6.i(i5, true);
                    }
                    return 5;
                }
                if (e6.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, AbstractC0388s.BUFFERED)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void D(long j6) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        C0376f c0376f = this;
        if (c0376f.s()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = d;
            if (atomicLongFieldUpdater.get(c0376f) > j6) {
                break;
            } else {
                c0376f = this;
            }
        }
        int i5 = AbstractC0388s.f1186a;
        int i6 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = e;
            if (i6 < i5) {
                long j7 = atomicLongFieldUpdater.get(c0376f);
                if (j7 == (4611686018427387903L & atomicLongFieldUpdater2.get(c0376f)) && j7 == atomicLongFieldUpdater.get(c0376f)) {
                    return;
                } else {
                    i6++;
                }
            } else {
                while (true) {
                    long j8 = atomicLongFieldUpdater2.get(c0376f);
                    if (atomicLongFieldUpdater2.compareAndSet(c0376f, j8, (j8 & 4611686018427387903L) + Longs.MAX_POWER_OF_TWO)) {
                        break;
                    } else {
                        c0376f = this;
                    }
                }
                while (true) {
                    long j9 = atomicLongFieldUpdater.get(c0376f);
                    long j10 = atomicLongFieldUpdater2.get(c0376f);
                    long j11 = j10 & 4611686018427387903L;
                    boolean z6 = (j10 & Longs.MAX_POWER_OF_TWO) != 0;
                    if (j9 == j11 && j9 == atomicLongFieldUpdater.get(c0376f)) {
                        break;
                    }
                    if (z6) {
                        c0376f = this;
                    } else {
                        c0376f = this;
                        atomicLongFieldUpdater2.compareAndSet(c0376f, j10, Longs.MAX_POWER_OF_TWO + j11);
                    }
                }
                while (true) {
                    long j12 = atomicLongFieldUpdater2.get(c0376f);
                    if (atomicLongFieldUpdater2.compareAndSet(c0376f, j12, j12 & 4611686018427387903L)) {
                        return;
                    } else {
                        c0376f = this;
                    }
                }
            }
        }
    }

    @Override // p018c4.D0
    public final boolean c() {
        return p(b.get(this), false);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public final boolean cancel(Throwable th) {
        return cancelImpl$kotlinx_coroutines_core(th);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(th, true);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.D0
    public boolean close(Throwable th) {
        return closeOrCancelImpl(th, false);
    }

    public boolean closeOrCancelImpl(Throwable th, boolean z6) {
        C0376f c0376f;
        boolean z7;
        long j6;
        long j7;
        long j8;
        Object obj;
        long j9;
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        if (!z6) {
            c0376f = this;
            break;
        }
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) != 0) {
                c0376f = this;
                break;
            }
            int i5 = AbstractC0388s.SEGMENT_SIZE;
            c0376f = this;
        } while (!atomicLongFieldUpdater.compareAndSet(c0376f, j10, (j10 & 1152921504606846975L) + (((long) 1) << 60)));
        H h6 = AbstractC0388s.NO_CLOSE_CAUSE;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1152i;
            if (atomicReferenceFieldUpdater.compareAndSet(this, h6, th)) {
                z7 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != h6) {
                z7 = false;
                break;
            }
        }
        if (z6) {
            do {
                j9 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(c0376f, j9, (((long) 3) << 60) + (j9 & 1152921504606846975L)));
        } else {
            do {
                j6 = atomicLongFieldUpdater.get(this);
                int i6 = (int) (j6 >> 60);
                if (i6 == 0) {
                    j7 = j6 & 1152921504606846975L;
                    j8 = 2;
                } else {
                    if (i6 != 1) {
                        break;
                    }
                    j7 = j6 & 1152921504606846975L;
                    j8 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(c0376f, j6, (j8 << 60) + j7));
        }
        c();
        if (z7) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f1153j;
                obj = atomicReferenceFieldUpdater2.get(this);
                H h7 = obj == null ? AbstractC0388s.CLOSE_HANDLER_CLOSED : AbstractC0388s.CLOSE_HANDLER_INVOKED;
                do {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, obj, h7)) {
                        break loop3;
                    }
                } while (atomicReferenceFieldUpdater2.get(this) == obj);
            }
            if (obj != null) {
                Y.c(1, obj);
                ((l) obj).invoke(getCloseCause());
                return z7;
            }
        }
        return z7;
    }

    public final Throwable getCloseCause() {
        return (Throwable) f1152i.get(this);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public h getOnReceive() {
        C0378h c0378h = C0378h.f1161a;
        E.d(c0378h, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Y.c(3, c0378h);
        C0379i c0379i = C0379i.f1163a;
        E.d(c0379i, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        Y.c(3, c0379i);
        return new p044h4.i(this, c0378h, c0379i, this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public h getOnReceiveCatching() {
        C0380j c0380j = C0380j.f1165a;
        E.d(c0380j, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Y.c(3, c0380j);
        C0381k c0381k = C0381k.f1167a;
        E.d(c0381k, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        Y.c(3, c0381k);
        return new p044h4.i(this, c0380j, c0381k, this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public h getOnReceiveOrNull() {
        C0382l c0382l = C0382l.f1169a;
        E.d(c0382l, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Y.c(3, c0382l);
        C0383m c0383m = C0383m.f1171a;
        E.d(c0383m, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        Y.c(3, c0383m);
        return new p044h4.i(this, c0382l, c0383m, this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.D0
    public j getOnSend() {
        C0384n c0384n = C0384n.f1173a;
        E.d(c0384n, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Y.c(3, c0384n);
        C0385o c0385o = C0385o.f1176a;
        E.d(c0385o, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        Y.c(3, c0385o);
        return new k(this, c0384n, c0385o, null);
    }

    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new r0(F.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    public final boolean h(long j6) {
        return j6 < d.get(this) || j6 < c.get(this) + ((long) this.f1154a);
    }

    public final E i(long j6) {
        long j7;
        Object obj = f1151h.get(this);
        E e6 = (E) f1149f.get(this);
        if (e6.id > ((E) obj).id) {
            obj = e6;
        }
        E e7 = (E) f1150g.get(this);
        if (e7.id > ((E) obj).id) {
            obj = e7;
        }
        E e8 = (E) AbstractC0647a.close((AbstractC0648b) obj);
        if (r()) {
            E e9 = e8;
            loop0: while (true) {
                int i5 = AbstractC0388s.SEGMENT_SIZE - 1;
                while (true) {
                    if (-1 < i5) {
                        j7 = (e9.id * ((long) AbstractC0388s.SEGMENT_SIZE)) + ((long) i5);
                        if (j7 >= c.get(this)) {
                            while (true) {
                                Object state$kotlinx_coroutines_core = e9.getState$kotlinx_coroutines_core(i5);
                                if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != AbstractC0388s.IN_BUFFER) {
                                    if (state$kotlinx_coroutines_core != AbstractC0388s.BUFFERED) {
                                        break;
                                    }
                                    break loop0;
                                }
                                if (e9.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, AbstractC0388s.getCHANNEL_CLOSED())) {
                                    e9.f();
                                    break;
                                }
                            }
                            i5--;
                        }
                    } else {
                        e9 = (E) e9.getPrev();
                        if (e9 == null) {
                        }
                    }
                    j7 = -1;
                    break loop0;
                }
            }
            if (j7 != -1) {
                j(j7);
            }
        }
        Object objM1032constructorimpl = AbstractC0657k.m1032constructorimpl(null);
        loop3: for (E e10 = e8; e10 != null; e10 = (E) e10.getPrev()) {
            for (int i6 = AbstractC0388s.SEGMENT_SIZE - 1; -1 < i6; i6--) {
                if ((e10.id * ((long) AbstractC0388s.SEGMENT_SIZE)) + ((long) i6) < j6) {
                    break loop3;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core2 = e10.getState$kotlinx_coroutines_core(i6);
                    if (state$kotlinx_coroutines_core2 != null && state$kotlinx_coroutines_core2 != AbstractC0388s.IN_BUFFER) {
                        if (!(state$kotlinx_coroutines_core2 instanceof E0)) {
                            if (!(state$kotlinx_coroutines_core2 instanceof B1)) {
                                break;
                            }
                            if (e10.casState$kotlinx_coroutines_core(i6, state$kotlinx_coroutines_core2, AbstractC0388s.getCHANNEL_CLOSED())) {
                                objM1032constructorimpl = AbstractC0657k.m1034plusFjFbRPM(objM1032constructorimpl, state$kotlinx_coroutines_core2);
                                e10.i(i6, true);
                                break;
                            }
                        } else {
                            if (e10.casState$kotlinx_coroutines_core(i6, state$kotlinx_coroutines_core2, AbstractC0388s.getCHANNEL_CLOSED())) {
                                objM1032constructorimpl = AbstractC0657k.m1034plusFjFbRPM(objM1032constructorimpl, ((E0) state$kotlinx_coroutines_core2).waiter);
                                e10.i(i6, true);
                                break;
                            }
                        }
                    } else {
                        if (e10.casState$kotlinx_coroutines_core(i6, state$kotlinx_coroutines_core2, AbstractC0388s.getCHANNEL_CLOSED())) {
                            e10.f();
                            break;
                        }
                    }
                }
            }
        }
        if (objM1032constructorimpl != null) {
            if (!(objM1032constructorimpl instanceof ArrayList)) {
                y((B1) objM1032constructorimpl, true);
                return e8;
            }
            ArrayList arrayList = (ArrayList) objM1032constructorimpl;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                y((B1) arrayList.get(size), true);
            }
        }
        return e8;
    }

    @Override // p018c4.InterfaceC0391v, p018c4.D0
    public void invokeOnClose(l lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = f1153j;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, lVar)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != AbstractC0388s.CLOSE_HANDLER_CLOSED) {
                if (obj == AbstractC0388s.CLOSE_HANDLER_INVOKED) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            H h6 = AbstractC0388s.CLOSE_HANDLER_CLOSED;
            H h7 = AbstractC0388s.CLOSE_HANDLER_INVOKED;
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, h6, h7)) {
                    lVar.invoke(getCloseCause());
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == h6);
        }
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public InterfaceC0395z iterator() {
        return new C0374e(this);
    }

    public final void j(long j6) {
        p028e4.Q qCallUndeliveredElementCatchingException;
        E e6 = (E) f1150g.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
            long j7 = atomicLongFieldUpdater.get(this);
            if (j6 < Math.max(((long) this.f1154a) + j7, d.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j7, 1 + j7)) {
                long j8 = AbstractC0388s.SEGMENT_SIZE;
                long j9 = j7 / j8;
                int i5 = (int) (j7 % j8);
                if (e6.id != j9) {
                    E eL = l(j9, e6);
                    if (eL == null) {
                        continue;
                    } else {
                        e6 = eL;
                    }
                }
                E e7 = e6;
                Object objB = B(e7, i5, j7, null);
                if (objB != AbstractC0388s.FAILED) {
                    e7.a();
                    l lVar = this.onUndeliveredElement;
                    if (lVar != null && (qCallUndeliveredElementCatchingException = A.callUndeliveredElementCatchingException(lVar, objB, null)) != null) {
                        throw qCallUndeliveredElementCatchingException;
                    }
                } else if (j7 < n()) {
                    e7.a();
                }
                e6 = e7;
            }
        }
    }

    public final void k() {
        Object objFindSegmentInternal;
        if (s()) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1151h;
        E e6 = (E) atomicReferenceFieldUpdater.get(this);
        while (true) {
            long andIncrement = d.getAndIncrement(this);
            long j6 = andIncrement / ((long) AbstractC0388s.SEGMENT_SIZE);
            if (n() <= andIncrement) {
                if (e6.id < j6 && e6.getNext() != null) {
                    t(j6, e6);
                }
                o(this);
                return;
            }
            if (e6.id != j6) {
                p pVar = (p) AbstractC0388s.createSegmentFunction();
                while (true) {
                    objFindSegmentInternal = AbstractC0647a.findSegmentInternal(e6, j6, pVar);
                    if (!F.a(objFindSegmentInternal)) {
                        p028e4.E eM1031getSegmentimpl = F.m1031getSegmentimpl(objFindSegmentInternal);
                        while (true) {
                            p028e4.E e7 = (p028e4.E) atomicReferenceFieldUpdater.get(this);
                            if (e7.id >= eM1031getSegmentimpl.id) {
                                break;
                            }
                            if (!eM1031getSegmentimpl.g()) {
                                break;
                            }
                            do {
                                if (atomicReferenceFieldUpdater.compareAndSet(this, e7, eM1031getSegmentimpl)) {
                                    if (!e7.d()) {
                                        break;
                                    }
                                    e7.c();
                                    break;
                                }
                            } while (atomicReferenceFieldUpdater.get(this) == e7);
                            if (eM1031getSegmentimpl.d()) {
                                eM1031getSegmentimpl.c();
                            }
                        }
                    } else {
                        break;
                    }
                }
                E e8 = null;
                if (F.a(objFindSegmentInternal)) {
                    c();
                    t(j6, e6);
                    o(this);
                } else {
                    E e9 = (E) F.m1031getSegmentimpl(objFindSegmentInternal);
                    long j7 = e9.id;
                    if (j7 > j6) {
                        long j8 = AbstractC0388s.SEGMENT_SIZE;
                        if (d.compareAndSet(this, 1 + andIncrement, j7 * j8)) {
                            long j9 = (e9.id * j8) - andIncrement;
                            AtomicLongFieldUpdater atomicLongFieldUpdater = e;
                            if ((atomicLongFieldUpdater.addAndGet(this, j9) & Longs.MAX_POWER_OF_TWO) != 0) {
                                while ((atomicLongFieldUpdater.get(this) & Longs.MAX_POWER_OF_TWO) != 0) {
                                }
                            }
                        } else {
                            o(this);
                        }
                    } else {
                        e8 = e9;
                    }
                }
                if (e8 == null) {
                    continue;
                } else {
                    e6 = e8;
                }
            }
            int i5 = (int) (andIncrement % ((long) AbstractC0388s.SEGMENT_SIZE));
            Object state$kotlinx_coroutines_core = e6.getState$kotlinx_coroutines_core(i5);
            boolean z6 = state$kotlinx_coroutines_core instanceof B1;
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = c;
            if (!z6 || andIncrement < atomicLongFieldUpdater2.get(this) || !e6.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, AbstractC0388s.RESUMING_BY_EB)) {
                while (true) {
                    Object state$kotlinx_coroutines_core2 = e6.getState$kotlinx_coroutines_core(i5);
                    if (state$kotlinx_coroutines_core2 instanceof B1) {
                        if (andIncrement < atomicLongFieldUpdater2.get(this)) {
                            if (e6.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core2, new E0((B1) state$kotlinx_coroutines_core2))) {
                                o(this);
                                return;
                            }
                        } else if (e6.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core2, AbstractC0388s.RESUMING_BY_EB)) {
                            if (!A(state$kotlinx_coroutines_core2, e6, i5)) {
                                e6.setState$kotlinx_coroutines_core(i5, AbstractC0388s.INTERRUPTED_SEND);
                                e6.f();
                                break;
                            } else {
                                e6.setState$kotlinx_coroutines_core(i5, AbstractC0388s.BUFFERED);
                                o(this);
                                return;
                            }
                        }
                    } else {
                        if (state$kotlinx_coroutines_core2 == AbstractC0388s.INTERRUPTED_SEND) {
                            break;
                        }
                        if (state$kotlinx_coroutines_core2 == null) {
                            if (e6.casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core2, AbstractC0388s.IN_BUFFER)) {
                                o(this);
                                return;
                            }
                        } else if (state$kotlinx_coroutines_core2 == AbstractC0388s.BUFFERED || state$kotlinx_coroutines_core2 == AbstractC0388s.POISONED || state$kotlinx_coroutines_core2 == AbstractC0388s.DONE_RCV || state$kotlinx_coroutines_core2 == AbstractC0388s.INTERRUPTED_RCV || state$kotlinx_coroutines_core2 == AbstractC0388s.getCHANNEL_CLOSED()) {
                            o(this);
                            return;
                        } else if (state$kotlinx_coroutines_core2 != AbstractC0388s.RESUMING_BY_RCV) {
                            throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core2).toString());
                        }
                    }
                }
                o(this);
            } else if (A(state$kotlinx_coroutines_core, e6, i5)) {
                e6.setState$kotlinx_coroutines_core(i5, AbstractC0388s.BUFFERED);
                o(this);
                return;
            } else {
                e6.setState$kotlinx_coroutines_core(i5, AbstractC0388s.INTERRUPTED_SEND);
                e6.f();
                o(this);
            }
        }
    }

    public final E l(long j6, E e6) {
        Object objFindSegmentInternal;
        long j7;
        p pVar = (p) AbstractC0388s.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = AbstractC0647a.findSegmentInternal(e6, j6, pVar);
            if (!F.a(objFindSegmentInternal)) {
                p028e4.E eM1031getSegmentimpl = F.m1031getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1150g;
                    p028e4.E e7 = (p028e4.E) atomicReferenceFieldUpdater.get(this);
                    if (e7.id >= eM1031getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!eM1031getSegmentimpl.g()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, e7, eM1031getSegmentimpl)) {
                            if (!e7.d()) {
                                break loop0;
                            }
                            e7.c();
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == e7);
                    if (eM1031getSegmentimpl.d()) {
                        eM1031getSegmentimpl.c();
                    }
                }
            } else {
                break;
            }
        }
        if (F.a(objFindSegmentInternal)) {
            c();
            if (e6.id * ((long) AbstractC0388s.SEGMENT_SIZE) < n()) {
                e6.a();
                return null;
            }
        } else {
            E e8 = (E) F.m1031getSegmentimpl(objFindSegmentInternal);
            if (!s() && j6 <= d.get(this) / ((long) AbstractC0388s.SEGMENT_SIZE)) {
                loop3: while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f1151h;
                    p028e4.E e9 = (p028e4.E) atomicReferenceFieldUpdater2.get(this);
                    if (e9.id >= e8.id || !e8.g()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater2.compareAndSet(this, e9, e8)) {
                            if (!e9.d()) {
                                break loop3;
                            }
                            e9.c();
                            break loop3;
                        }
                    } while (atomicReferenceFieldUpdater2.get(this) == e9);
                    if (e8.d()) {
                        e8.c();
                    }
                }
            }
            long j8 = e8.id;
            if (j8 <= j6) {
                return e8;
            }
            long j9 = j8 * ((long) AbstractC0388s.SEGMENT_SIZE);
            do {
                j7 = c.get(this);
                if (j7 >= j9) {
                    break;
                }
            } while (!c.compareAndSet(this, j7, j9));
            if (e8.id * ((long) AbstractC0388s.SEGMENT_SIZE) < n()) {
                e8.a();
            }
        }
        return null;
    }

    public final Throwable m() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new q0(F.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    public final long n() {
        return b.get(this) & 1152921504606846975L;
    }

    @Override // p018c4.InterfaceC0391v, p018c4.D0
    public boolean offer(Object obj) {
        return AbstractC0389t.offer(this, obj);
    }

    public final boolean p(long j6, boolean z6) {
        C0376f c0376f = this;
        int i5 = (int) (j6 >> 60);
        if (i5 != 0 && i5 != 1) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
            if (i5 == 2) {
                c0376f.i(j6 & 1152921504606846975L);
                if (z6) {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1150g;
                        E eL = (E) atomicReferenceFieldUpdater.get(c0376f);
                        long j7 = atomicLongFieldUpdater.get(c0376f);
                        if (c0376f.n() <= j7) {
                            break;
                        }
                        long j8 = AbstractC0388s.SEGMENT_SIZE;
                        long j9 = j7 / j8;
                        if (eL.id != j9 && (eL = c0376f.l(j9, eL)) == null) {
                            if (((E) atomicReferenceFieldUpdater.get(c0376f)).id < j9) {
                                break;
                            }
                        } else {
                            eL.a();
                            int i6 = (int) (j7 % j8);
                            while (true) {
                                Object state$kotlinx_coroutines_core = eL.getState$kotlinx_coroutines_core(i6);
                                if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != AbstractC0388s.IN_BUFFER) {
                                    if (state$kotlinx_coroutines_core != AbstractC0388s.BUFFERED && (state$kotlinx_coroutines_core == AbstractC0388s.INTERRUPTED_SEND || state$kotlinx_coroutines_core == AbstractC0388s.getCHANNEL_CLOSED() || state$kotlinx_coroutines_core == AbstractC0388s.DONE_RCV || state$kotlinx_coroutines_core == AbstractC0388s.POISONED || (state$kotlinx_coroutines_core != AbstractC0388s.RESUMING_BY_EB && (state$kotlinx_coroutines_core == AbstractC0388s.RESUMING_BY_RCV || j7 != atomicLongFieldUpdater.get(c0376f))))) {
                                        break;
                                        break;
                                        break;
                                        break;
                                        break;
                                        break;
                                    }
                                } else {
                                    if (eL.casState$kotlinx_coroutines_core(i6, state$kotlinx_coroutines_core, AbstractC0388s.POISONED)) {
                                        c0376f.k();
                                        break;
                                    }
                                    c0376f = this;
                                }
                            }
                            c.compareAndSet(c0376f, j7, 1 + j7);
                            c0376f = this;
                        }
                    }
                }
            } else {
                if (i5 != 3) {
                    throw new IllegalStateException(AbstractC0157z.k(i5, "unexpected close status: ").toString());
                }
                E eI = c0376f.i(j6 & 1152921504606846975L);
                l lVar = c0376f.onUndeliveredElement;
                Object objM1032constructorimpl = AbstractC0657k.m1032constructorimpl(null);
                p028e4.Q qCallUndeliveredElementCatchingException = null;
                loop0: do {
                    for (int i7 = AbstractC0388s.SEGMENT_SIZE - 1; -1 < i7; i7--) {
                        long j10 = (eI.id * ((long) AbstractC0388s.SEGMENT_SIZE)) + ((long) i7);
                        while (true) {
                            Object state$kotlinx_coroutines_core2 = eI.getState$kotlinx_coroutines_core(i7);
                            if (state$kotlinx_coroutines_core2 == AbstractC0388s.DONE_RCV) {
                                break loop0;
                            }
                            if (state$kotlinx_coroutines_core2 != AbstractC0388s.BUFFERED) {
                                if (state$kotlinx_coroutines_core2 != AbstractC0388s.IN_BUFFER && state$kotlinx_coroutines_core2 != null) {
                                    if (!(state$kotlinx_coroutines_core2 instanceof B1) && !(state$kotlinx_coroutines_core2 instanceof E0)) {
                                        if (state$kotlinx_coroutines_core2 == AbstractC0388s.RESUMING_BY_EB || state$kotlinx_coroutines_core2 == AbstractC0388s.RESUMING_BY_RCV) {
                                            break loop0;
                                        }
                                        if (state$kotlinx_coroutines_core2 != AbstractC0388s.RESUMING_BY_EB) {
                                            break;
                                        }
                                    } else {
                                        if (j10 < atomicLongFieldUpdater.get(c0376f)) {
                                            break loop0;
                                        }
                                        B1 b1 = state$kotlinx_coroutines_core2 instanceof E0 ? ((E0) state$kotlinx_coroutines_core2).waiter : (B1) state$kotlinx_coroutines_core2;
                                        if (eI.casState$kotlinx_coroutines_core(i7, state$kotlinx_coroutines_core2, AbstractC0388s.getCHANNEL_CLOSED())) {
                                            if (lVar != null) {
                                                qCallUndeliveredElementCatchingException = A.callUndeliveredElementCatchingException(lVar, eI.h(i7), qCallUndeliveredElementCatchingException);
                                            }
                                            objM1032constructorimpl = AbstractC0657k.m1034plusFjFbRPM(objM1032constructorimpl, b1);
                                            eI.j(i7, null);
                                            eI.f();
                                            break;
                                        }
                                    }
                                } else {
                                    if (eI.casState$kotlinx_coroutines_core(i7, state$kotlinx_coroutines_core2, AbstractC0388s.getCHANNEL_CLOSED())) {
                                        eI.f();
                                        break;
                                    }
                                }
                            } else {
                                if (j10 < atomicLongFieldUpdater.get(c0376f)) {
                                    break loop0;
                                }
                                if (eI.casState$kotlinx_coroutines_core(i7, state$kotlinx_coroutines_core2, AbstractC0388s.getCHANNEL_CLOSED())) {
                                    if (lVar != null) {
                                        qCallUndeliveredElementCatchingException = A.callUndeliveredElementCatchingException(lVar, eI.h(i7), qCallUndeliveredElementCatchingException);
                                    }
                                    eI.j(i7, null);
                                    eI.f();
                                    break;
                                }
                            }
                        }
                    }
                    eI = (E) eI.getPrev();
                } while (eI != null);
                if (objM1032constructorimpl != null) {
                    if (objM1032constructorimpl instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) objM1032constructorimpl;
                        for (int size = arrayList.size() - 1; -1 < size; size--) {
                            c0376f.y((B1) arrayList.get(size), false);
                        }
                    } else {
                        c0376f.y((B1) objM1032constructorimpl, false);
                    }
                }
                if (qCallUndeliveredElementCatchingException != null) {
                    throw qCallUndeliveredElementCatchingException;
                }
            }
            return true;
        }
        return false;
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public Object poll() {
        return AbstractC0389t.poll(this);
    }

    public final boolean q() {
        return p(b.get(this), true);
    }

    public boolean r() {
        return false;
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public Object receive(g<Object> gVar) throws Throwable {
        E e6;
        Throwable th;
        E e7;
        C0376f c0376f;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1150g;
        E e8 = (E) atomicReferenceFieldUpdater.get(this);
        while (!q()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j6 = AbstractC0388s.SEGMENT_SIZE;
            long j7 = andIncrement / j6;
            int i5 = (int) (andIncrement % j6);
            if (e8.id != j7) {
                E eL = l(j7, e8);
                if (eL == null) {
                    continue;
                } else {
                    e6 = eL;
                }
            } else {
                e6 = e8;
            }
            Object objB = B(e6, i5, andIncrement, null);
            if (objB == AbstractC0388s.SUSPEND) {
                throw new IllegalStateException("unexpected");
            }
            if (objB == AbstractC0388s.FAILED) {
                if (andIncrement < n()) {
                    e6.a();
                }
                e8 = e6;
            } else {
                if (objB != AbstractC0388s.SUSPEND_NO_WAITER) {
                    e6.a();
                    return objB;
                }
                C0289m orCreateCancellableContinuation = AbstractC0293o.getOrCreateCancellableContinuation(F3.h.intercepted(gVar));
                C0376f c0376f2 = this;
                try {
                    Object objB2 = c0376f2.B(e6, i5, andIncrement, orCreateCancellableContinuation);
                    if (objB2 == AbstractC0388s.SUSPEND) {
                        orCreateCancellableContinuation.invokeOnCancellation(e6, i5);
                    } else {
                        if (objB2 == AbstractC0388s.FAILED) {
                            if (andIncrement < n()) {
                                e6.a();
                            }
                            E e9 = (E) atomicReferenceFieldUpdater.get(this);
                            while (true) {
                                if (q()) {
                                    orCreateCancellableContinuation.resumeWith(u.m1361constructorimpl(v.createFailure(m())));
                                    break;
                                }
                                C0289m c0289m = orCreateCancellableContinuation;
                                try {
                                    long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                    long j8 = AbstractC0388s.SEGMENT_SIZE;
                                    long j9 = andIncrement2 / j8;
                                    int i6 = (int) (andIncrement2 % j8);
                                    try {
                                        if (e9.id != j9) {
                                            try {
                                                E eL2 = l(j9, e9);
                                                if (eL2 == null) {
                                                    orCreateCancellableContinuation = c0289m;
                                                } else {
                                                    e7 = eL2;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                orCreateCancellableContinuation = c0289m;
                                                orCreateCancellableContinuation.h();
                                                throw th;
                                            }
                                        } else {
                                            e7 = e9;
                                        }
                                        Object objB3 = c0376f.B(e7, i6, andIncrement2, c0289m);
                                        c0376f2 = c0376f;
                                        E e10 = e7;
                                        orCreateCancellableContinuation = c0289m;
                                        if (objB3 == AbstractC0388s.SUSPEND) {
                                            C0289m c0289m2 = orCreateCancellableContinuation != null ? orCreateCancellableContinuation : null;
                                            if (c0289m2 == null) {
                                                break;
                                            }
                                            c0289m2.invokeOnCancellation(e10, i6);
                                            break;
                                        }
                                        if (objB3 != AbstractC0388s.FAILED) {
                                            if (objB3 == AbstractC0388s.SUSPEND_NO_WAITER) {
                                                throw new IllegalStateException("unexpected");
                                            }
                                            e10.a();
                                            orCreateCancellableContinuation.resume(objB3, c0376f2.onUndeliveredElement != null ? new C0377g(this, 0) : null);
                                            break;
                                        }
                                        if (andIncrement2 < n()) {
                                            e10.a();
                                        }
                                        e9 = e10;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        orCreateCancellableContinuation = c0289m;
                                        th = th;
                                        orCreateCancellableContinuation.h();
                                        throw th;
                                    }
                                    c0376f = c0376f2;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            }
                        } else {
                            e6.a();
                            orCreateCancellableContinuation.resume(objB2, c0376f2.onUndeliveredElement != null ? new C0377g(this, 0) : null);
                        }
                    }
                    Object result = orCreateCancellableContinuation.getResult();
                    if (result == i.getCOROUTINE_SUSPENDED()) {
                        G3.h.probeCoroutineSuspended(gVar);
                    }
                    return result;
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        }
        throw G.recoverStackTrace(m());
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    public Object mo1006receiveCatchingJP2dKIU(g<? super B> gVar) {
        return w(this, gVar);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public Object receiveOrNull(g<Object> gVar) {
        return AbstractC0389t.receiveOrNull(this, gVar);
    }

    public void registerSelectForSend(o oVar, Object obj) {
        E e6;
        E e7 = (E) f1149f.get(this);
        while (true) {
            long andIncrement = b.getAndIncrement(this);
            long j6 = andIncrement & 1152921504606846975L;
            boolean zP = p(andIncrement, false);
            int i5 = AbstractC0388s.SEGMENT_SIZE;
            long j7 = j6 / ((long) i5);
            int i6 = (int) (j6 % ((long) i5));
            if (e7.id != j7) {
                E eB = b(this, j7, e7);
                if (eB != null) {
                    e6 = eB;
                } else if (zP) {
                    u(oVar, obj);
                    return;
                }
            } else {
                e6 = e7;
            }
            o oVar2 = oVar;
            Object obj2 = obj;
            int iG = g(this, e6, i6, obj2, j6, oVar2, zP);
            e7 = e6;
            if (iG == 0) {
                e7.a();
                oVar2.selectInRegistrationPhase(Q.INSTANCE);
                return;
            }
            if (iG == 1) {
                oVar2.selectInRegistrationPhase(Q.INSTANCE);
                return;
            }
            if (iG == 2) {
                if (zP) {
                    e7.f();
                    u(oVar2, obj2);
                    return;
                } else {
                    B1 b1 = oVar2 instanceof B1 ? (B1) oVar2 : null;
                    if (b1 != null) {
                        e(this, b1, e7, i6);
                        return;
                    }
                    return;
                }
            }
            if (iG == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iG == 4) {
                if (j6 < c.get(this)) {
                    e7.a();
                }
                u(oVar2, obj2);
                return;
            } else {
                if (iG == 5) {
                    e7.a();
                }
                obj = obj2;
                oVar = oVar2;
            }
        }
    }

    public final boolean s() {
        long j6 = d.get(this);
        return j6 == 0 || j6 == LocationRequestCompat.PASSIVE_INTERVAL;
    }

    /* JADX WARN: Code duplicated, block: B:90:0x016c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0176  */
    /* JADX WARN: Code duplicated, block: B:97:0x017e A[RETURN] */
    @Override // p018c4.InterfaceC0391v, p018c4.D0
    public Object send(Object obj, g<? super Q> gVar) throws IllegalAccessException, InvocationTargetException {
        Q q6;
        Object result;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1149f;
        E e6 = (E) atomicReferenceFieldUpdater.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = b;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j6 = andIncrement & 1152921504606846975L;
            boolean zP = p(andIncrement, false);
            int i5 = AbstractC0388s.SEGMENT_SIZE;
            long j7 = i5;
            long j8 = j6 / j7;
            int i6 = (int) (j6 % j7);
            if (e6.id != j8) {
                E eB = b(this, j8, e6);
                if (eB != null) {
                    e6 = eB;
                } else if (zP) {
                    Object objV = v(gVar, obj);
                    if (objV != i.getCOROUTINE_SUSPENDED()) {
                        break;
                    }
                    return objV;
                }
            }
            int iG = g(this, e6, i6, obj, j6, null, zP);
            if (iG == 0) {
                e6.a();
                break;
            }
            if (iG != 1) {
                if (iG == 2) {
                    if (!zP) {
                        break;
                    }
                    e6.f();
                    Object objV2 = v(gVar, obj);
                    if (objV2 != i.getCOROUTINE_SUSPENDED()) {
                        break;
                    }
                    return objV2;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = c;
                if (iG == 3) {
                    C0289m orCreateCancellableContinuation = AbstractC0293o.getOrCreateCancellableContinuation(F3.h.intercepted(gVar));
                    try {
                        int iG2 = g(this, e6, i6, obj, j6, orCreateCancellableContinuation, false);
                        if (iG2 == 0) {
                            e6.a();
                            q6 = Q.INSTANCE;
                        } else {
                            if (iG2 != 1) {
                                if (iG2 != 2) {
                                    if (iG2 != 4) {
                                        String str = "unexpected";
                                        if (iG2 != 5) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        e6.a();
                                        E e7 = (E) atomicReferenceFieldUpdater.get(this);
                                        while (true) {
                                            long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                            long j9 = andIncrement2 & 1152921504606846975L;
                                            boolean zP2 = p(andIncrement2, false);
                                            int i7 = AbstractC0388s.SEGMENT_SIZE;
                                            long j10 = i7;
                                            atomicLongFieldUpdater2 = atomicLongFieldUpdater2;
                                            long j11 = j9 / j10;
                                            int i8 = (int) (j9 % j10);
                                            if (e7.id != j11) {
                                                E eB2 = b(this, j11, e7);
                                                if (eB2 != null) {
                                                    e7 = eB2;
                                                } else if (zP2) {
                                                }
                                            }
                                            String str2 = str;
                                            int iG3 = g(this, e7, i8, obj, j9, orCreateCancellableContinuation, zP2);
                                            if (iG3 == 0) {
                                                e7.a();
                                                q6 = Q.INSTANCE;
                                            } else if (iG3 == 1) {
                                                q6 = Q.INSTANCE;
                                            } else if (iG3 == 2) {
                                                if (!zP2) {
                                                    B1 b1 = orCreateCancellableContinuation != null ? orCreateCancellableContinuation : null;
                                                    if (b1 == null) {
                                                        break;
                                                    }
                                                    b1.invokeOnCancellation(e7, i8 + i7);
                                                    break;
                                                }
                                                e7.f();
                                            } else {
                                                if (iG3 == 3) {
                                                    throw new IllegalStateException(str2);
                                                }
                                                if (iG3 != 4) {
                                                    if (iG3 == 5) {
                                                        e7.a();
                                                    }
                                                    str = str2;
                                                } else if (j9 < atomicLongFieldUpdater2.get(this)) {
                                                    e7.a();
                                                }
                                            }
                                        }
                                    } else if (j6 < atomicLongFieldUpdater2.get(this)) {
                                        e6.a();
                                    }
                                    d(this, obj, orCreateCancellableContinuation);
                                    break;
                                } else {
                                    orCreateCancellableContinuation.invokeOnCancellation(e6, i6 + i5);
                                }
                                result = orCreateCancellableContinuation.getResult();
                                if (result == i.getCOROUTINE_SUSPENDED()) {
                                    G3.h.probeCoroutineSuspended(gVar);
                                }
                                if (result != i.getCOROUTINE_SUSPENDED()) {
                                    result = Q.INSTANCE;
                                }
                                if (result == i.getCOROUTINE_SUSPENDED()) {
                                    break;
                                }
                                return result;
                            }
                            q6 = Q.INSTANCE;
                        }
                        orCreateCancellableContinuation.resumeWith(u.m1361constructorimpl(q6));
                        result = orCreateCancellableContinuation.getResult();
                        if (result == i.getCOROUTINE_SUSPENDED()) {
                            G3.h.probeCoroutineSuspended(gVar);
                        }
                        if (result != i.getCOROUTINE_SUSPENDED()) {
                            result = Q.INSTANCE;
                        }
                        if (result == i.getCOROUTINE_SUSPENDED()) {
                            break;
                        }
                        return result;
                    } catch (Throwable th) {
                        orCreateCancellableContinuation.h();
                        throw th;
                    }
                }
                if (iG == 4) {
                    if (j6 < atomicLongFieldUpdater2.get(this)) {
                        e6.a();
                    }
                    Object objV3 = v(gVar, obj);
                    if (objV3 != i.getCOROUTINE_SUSPENDED()) {
                        break;
                    }
                    return objV3;
                }
                if (iG == 5) {
                    e6.a();
                }
            } else {
                break;
            }
        }
        return Q.INSTANCE;
    }

    public Object sendBroadcast$kotlinx_coroutines_core(Object obj, g<? super Boolean> gVar) {
        E eB;
        C0289m c0289m = new C0289m(F3.h.intercepted(gVar), 1);
        c0289m.initCancellability();
        if (this.onUndeliveredElement != null) {
            throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`");
        }
        a aVar = new a(c0289m);
        E e6 = (E) f1149f.get(this);
        while (true) {
            long andIncrement = b.getAndIncrement(this);
            long j6 = andIncrement & 1152921504606846975L;
            boolean zP = p(andIncrement, false);
            long j7 = AbstractC0388s.SEGMENT_SIZE;
            long j8 = j6 / j7;
            int i5 = (int) (j6 % j7);
            if (e6.id != j8) {
                eB = b(this, j8, e6);
                if (eB == null) {
                    if (zP) {
                        c0289m.resumeWith(u.m1361constructorimpl(b.boxBoolean(false)));
                        break;
                    }
                }
            } else {
                eB = e6;
            }
            int iG = g(this, eB, i5, obj, j6, aVar, zP);
            if (iG == 0) {
                eB.a();
            } else if (iG != 1) {
                if (iG == 2) {
                    if (!zP) {
                        e(this, aVar, eB, i5);
                        break;
                    }
                    eB.f();
                } else {
                    if (iG == 3) {
                        throw new IllegalStateException("unexpected");
                    }
                    if (iG != 4) {
                        if (iG == 5) {
                            eB.a();
                        }
                        e6 = eB;
                    } else if (j6 < c.get(this)) {
                        eB.a();
                    }
                }
                c0289m.resumeWith(u.m1361constructorimpl(b.boxBoolean(false)));
                break;
            }
            c0289m.resumeWith(u.m1361constructorimpl(b.boxBoolean(true)));
            break;
        }
        Object result = c0289m.getResult();
        if (result == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result;
    }

    public final void t(long j6, E e6) {
        E e7;
        E e8;
        while (e6.id < j6 && (e8 = (E) e6.getNext()) != null) {
            e6 = e8;
        }
        while (true) {
            if (!e6.b() || (e7 = (E) e6.getNext()) == null) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1151h;
                    p028e4.E e9 = (p028e4.E) atomicReferenceFieldUpdater.get(this);
                    if (e9.id >= e6.id) {
                        return;
                    }
                    if (!e6.g()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, e9, e6)) {
                            if (e9.d()) {
                                e9.c();
                                return;
                            }
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == e9);
                    if (e6.d()) {
                        e6.c();
                    }
                }
            } else {
                e6 = e7;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        int i5 = (int) (b.get(this) >> 60);
        if (i5 == 2) {
            sb.append("closed,");
        } else if (i5 == 3) {
            sb.append("cancelled,");
        }
        sb.append("capacity=" + this.f1154a + ',');
        sb.append("data=[");
        int i6 = 0;
        boolean z6 = true;
        List listListOf = I.listOf((Object[]) new E[]{f1150g.get(this), f1149f.get(this), f1151h.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((E) obj) != AbstractC0388s.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j6 = ((E) next).id;
            do {
                Object next2 = it.next();
                long j7 = ((E) next2).id;
                if (j6 > j7) {
                    next = next2;
                    j6 = j7;
                }
            } while (it.hasNext());
        }
        E e6 = (E) next;
        long j8 = c.get(this);
        long jN = n();
        loop2: while (true) {
            int i7 = AbstractC0388s.SEGMENT_SIZE;
            int i8 = i6;
            while (i8 < i7) {
                long j9 = (e6.id * ((long) AbstractC0388s.SEGMENT_SIZE)) + ((long) i8);
                if (j9 >= jN && j9 >= j8) {
                    break loop2;
                }
                Object state$kotlinx_coroutines_core = e6.getState$kotlinx_coroutines_core(i8);
                Object objH = e6.h(i8);
                boolean z7 = z6;
                if (state$kotlinx_coroutines_core instanceof InterfaceC0285k) {
                    string = (j9 >= j8 || j9 < jN) ? (j9 >= jN || j9 < j8) ? "cont" : "send" : "receive";
                } else if (state$kotlinx_coroutines_core instanceof o) {
                    string = (j9 >= j8 || j9 < jN) ? (j9 >= jN || j9 < j8) ? "select" : "onSend" : "onReceive";
                } else if (state$kotlinx_coroutines_core instanceof y0) {
                    string = "receiveCatching";
                } else if (state$kotlinx_coroutines_core instanceof a) {
                    string = "sendBroadcast";
                } else if (state$kotlinx_coroutines_core instanceof E0) {
                    string = "EB(" + state$kotlinx_coroutines_core + ')';
                } else if (E.a(state$kotlinx_coroutines_core, AbstractC0388s.RESUMING_BY_RCV) || E.a(state$kotlinx_coroutines_core, AbstractC0388s.RESUMING_BY_EB)) {
                    string = "resuming_sender";
                } else {
                    if (state$kotlinx_coroutines_core != null && !state$kotlinx_coroutines_core.equals(AbstractC0388s.IN_BUFFER) && !state$kotlinx_coroutines_core.equals(AbstractC0388s.DONE_RCV) && !state$kotlinx_coroutines_core.equals(AbstractC0388s.POISONED) && !state$kotlinx_coroutines_core.equals(AbstractC0388s.INTERRUPTED_RCV) && !state$kotlinx_coroutines_core.equals(AbstractC0388s.INTERRUPTED_SEND) && !state$kotlinx_coroutines_core.equals(AbstractC0388s.getCHANNEL_CLOSED())) {
                        string = state$kotlinx_coroutines_core.toString();
                    }
                    i8++;
                    z6 = z7;
                }
                if (objH != null) {
                    sb.append("(" + string + ',' + objH + "),");
                } else {
                    sb.append(string + ',');
                }
                i8++;
                z6 = z7;
            }
            boolean z8 = z6;
            e6 = (E) e6.getNext();
            if (e6 == null) {
                break;
            }
            z6 = z8;
            i6 = 0;
        }
        if (e0.last(sb) == ',') {
            E.e(sb.deleteCharAt(sb.length() - 1), "deleteCharAt(...)");
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toStringDebug$kotlinx_coroutines_core() {
        String strValueOf;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("S=");
        sb2.append(n());
        sb2.append(",R=");
        sb2.append(c.get(this));
        sb2.append(",B=");
        sb2.append(d.get(this));
        sb2.append(",B'=");
        sb2.append(e.get(this));
        sb2.append(",C=");
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        sb2.append((int) (atomicLongFieldUpdater.get(this) >> 60));
        sb2.append(',');
        sb.append(sb2.toString());
        int i5 = (int) (atomicLongFieldUpdater.get(this) >> 60);
        if (i5 == 1) {
            sb.append("CANCELLATION_STARTED,");
        } else if (i5 == 2) {
            sb.append("CLOSED,");
        } else if (i5 == 3) {
            sb.append("CANCELLED,");
        }
        StringBuilder sb3 = new StringBuilder("SEND_SEGM=");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1149f;
        sb3.append(S.getHexAddress(atomicReferenceFieldUpdater.get(this)));
        sb3.append(",RCV_SEGM=");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f1150g;
        sb3.append(S.getHexAddress(atomicReferenceFieldUpdater2.get(this)));
        sb.append(sb3.toString());
        boolean zS = s();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f1151h;
        if (!zS) {
            sb.append(",EB_SEGM=" + S.getHexAddress(atomicReferenceFieldUpdater3.get(this)));
        }
        sb.append("  ");
        List listListOf = I.listOf((Object[]) new E[]{atomicReferenceFieldUpdater2.get(this), atomicReferenceFieldUpdater.get(this), atomicReferenceFieldUpdater3.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((E) obj) != AbstractC0388s.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j6 = ((E) next).id;
            do {
                Object next2 = it.next();
                long j7 = ((E) next2).id;
                if (j6 > j7) {
                    next = next2;
                    j6 = j7;
                }
            } while (it.hasNext());
        }
        E e6 = (E) next;
        do {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(S.getHexAddress(e6));
            sb4.append("=[");
            sb4.append(e6.b() ? ProxyConfig.MATCH_ALL_SCHEMES : "");
            sb4.append(e6.id);
            sb4.append(",prev=");
            E e7 = (E) e6.getPrev();
            sb4.append(e7 != null ? S.getHexAddress(e7) : null);
            sb4.append(',');
            sb.append(sb4.toString());
            int i6 = AbstractC0388s.SEGMENT_SIZE;
            for (int i7 = 0; i7 < i6; i7++) {
                Object state$kotlinx_coroutines_core = e6.getState$kotlinx_coroutines_core(i7);
                Object objH = e6.h(i7);
                if (state$kotlinx_coroutines_core instanceof InterfaceC0285k) {
                    strValueOf = "cont";
                } else if (state$kotlinx_coroutines_core instanceof o) {
                    strValueOf = "select";
                } else if (state$kotlinx_coroutines_core instanceof y0) {
                    strValueOf = "receiveCatching";
                } else if (state$kotlinx_coroutines_core instanceof a) {
                    strValueOf = "send(broadcast)";
                } else if (state$kotlinx_coroutines_core instanceof E0) {
                    strValueOf = "EB(" + state$kotlinx_coroutines_core + ')';
                } else {
                    strValueOf = String.valueOf(state$kotlinx_coroutines_core);
                }
                sb.append("[" + i7 + "]=(" + strValueOf + ',' + objH + "),");
            }
            StringBuilder sb5 = new StringBuilder("next=");
            E e8 = (E) e6.getNext();
            sb5.append(e8 != null ? S.getHexAddress(e8) : null);
            sb5.append("]  ");
            sb.append(sb5.toString());
            e6 = (E) e6.getNext();
        } while (e6 != null);
        return sb.toString();
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    public Object mo1007tryReceivePtdJZtk() {
        E eL;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c;
        long j6 = atomicLongFieldUpdater.get(this);
        long j7 = b.get(this);
        if (p(j7, true)) {
            return B.Companion.m1008closedJP2dKIU(getCloseCause());
        }
        if (j6 >= (j7 & 1152921504606846975L)) {
            return B.Companion.m1009failurePtdJZtk();
        }
        Object obj = AbstractC0388s.INTERRUPTED_RCV;
        E e6 = (E) f1150g.get(this);
        while (!q()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            int i5 = AbstractC0388s.SEGMENT_SIZE;
            long j8 = andIncrement / ((long) i5);
            int i6 = (int) (andIncrement % ((long) i5));
            if (e6.id != j8) {
                eL = l(j8, e6);
                if (eL == null) {
                    continue;
                }
            } else {
                eL = e6;
            }
            Object objB = B(eL, i6, andIncrement, obj);
            e6 = eL;
            if (objB == AbstractC0388s.SUSPEND) {
                B1 b1 = obj instanceof B1 ? (B1) obj : null;
                if (b1 != null) {
                    b1.invokeOnCancellation(e6, i6);
                }
                D(andIncrement);
                e6.f();
                return B.Companion.m1009failurePtdJZtk();
            }
            if (objB != AbstractC0388s.FAILED) {
                if (objB == AbstractC0388s.SUSPEND_NO_WAITER) {
                    throw new IllegalStateException("unexpected");
                }
                e6.a();
                return B.Companion.m1010successJP2dKIU(objB);
            }
            if (andIncrement < n()) {
                e6.a();
            }
        }
        return B.Companion.m1008closedJP2dKIU(getCloseCause());
    }

    /* JADX WARN: Code duplicated, block: B:21:0x006c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x006e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0071  */
    /* JADX WARN: Code duplicated, block: B:26:0x0074  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:31:0x007b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0089  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00af  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x009f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x007f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x005c A[SYNTHETIC] */
    @Override // p018c4.InterfaceC0391v, p018c4.D0
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo1011trySendJP2dKIU(Object obj) {
        int iG;
        B1 b1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        long j6 = atomicLongFieldUpdater.get(this);
        long j7 = 1152921504606846975L;
        if (p(j6, false) ? false : !h(j6 & 1152921504606846975L)) {
            return B.Companion.m1009failurePtdJZtk();
        }
        Object obj2 = AbstractC0388s.INTERRUPTED_SEND;
        E e6 = (E) f1149f.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j8 = andIncrement & j7;
            boolean zP = p(andIncrement, false);
            int i5 = AbstractC0388s.SEGMENT_SIZE;
            long j9 = j8 / ((long) i5);
            int i6 = (int) (j8 % ((long) i5));
            if (e6.id == j9) {
                iG = g(this, e6, i6, obj, j8, obj2, zP);
                if (iG != 0) {
                    e6.a();
                    return B.Companion.m1010successJP2dKIU(Q.INSTANCE);
                }
                if (iG != 1) {
                    return B.Companion.m1010successJP2dKIU(Q.INSTANCE);
                }
                if (iG != 2) {
                    if (zP) {
                        e6.f();
                        return B.Companion.m1008closedJP2dKIU(getSendException());
                    }
                    if (obj2 instanceof B1) {
                        b1 = (B1) obj2;
                    } else {
                        b1 = null;
                    }
                    if (b1 != null) {
                        e(this, b1, e6, i6);
                    }
                    e6.f();
                    return B.Companion.m1009failurePtdJZtk();
                }
                if (iG != 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (iG != 4) {
                    if (j8 < c.get(this)) {
                        e6.a();
                    }
                    return B.Companion.m1008closedJP2dKIU(getSendException());
                }
                if (iG != 5) {
                    e6.a();
                }
            } else {
                E eB = b(this, j9, e6);
                if (eB != null) {
                    e6 = eB;
                    iG = g(this, e6, i6, obj, j8, obj2, zP);
                    if (iG != 0) {
                        e6.a();
                        return B.Companion.m1010successJP2dKIU(Q.INSTANCE);
                    }
                    if (iG != 1) {
                        return B.Companion.m1010successJP2dKIU(Q.INSTANCE);
                    }
                    if (iG != 2) {
                        if (zP) {
                            e6.f();
                            return B.Companion.m1008closedJP2dKIU(getSendException());
                        }
                        if (obj2 instanceof B1) {
                            b1 = (B1) obj2;
                        } else {
                            b1 = null;
                        }
                        if (b1 != null) {
                            e(this, b1, e6, i6);
                        }
                        e6.f();
                        return B.Companion.m1009failurePtdJZtk();
                    }
                    if (iG != 3) {
                        throw new IllegalStateException("unexpected");
                    }
                    if (iG != 4) {
                        if (j8 < c.get(this)) {
                            e6.a();
                        }
                        return B.Companion.m1008closedJP2dKIU(getSendException());
                    }
                    if (iG != 5) {
                        e6.a();
                    }
                } else if (zP) {
                    return B.Companion.m1008closedJP2dKIU(getSendException());
                }
            }
            j7 = 1152921504606846975L;
        }
    }

    /* JADX INFO: renamed from: trySendDropOldest-JP2dKIU, reason: not valid java name */
    public final Object m1012trySendDropOldestJP2dKIU(Object obj) {
        E eB;
        Object obj2 = AbstractC0388s.BUFFERED;
        E e6 = (E) f1149f.get(this);
        while (true) {
            long andIncrement = b.getAndIncrement(this);
            long j6 = andIncrement & 1152921504606846975L;
            boolean zP = p(andIncrement, false);
            int i5 = AbstractC0388s.SEGMENT_SIZE;
            long j7 = j6 / ((long) i5);
            int i6 = (int) (j6 % ((long) i5));
            if (e6.id != j7) {
                eB = b(this, j7, e6);
                if (eB == null) {
                    if (zP) {
                        return B.Companion.m1008closedJP2dKIU(getSendException());
                    }
                }
            } else {
                eB = e6;
            }
            Object obj3 = obj;
            int iG = g(this, eB, i6, obj3, j6, obj2, zP);
            e6 = eB;
            if (iG == 0) {
                e6.a();
                return B.Companion.m1010successJP2dKIU(Q.INSTANCE);
            }
            if (iG == 1) {
                return B.Companion.m1010successJP2dKIU(Q.INSTANCE);
            }
            if (iG == 2) {
                if (zP) {
                    e6.f();
                    return B.Companion.m1008closedJP2dKIU(getSendException());
                }
                B1 b1 = obj2 instanceof B1 ? (B1) obj2 : null;
                if (b1 != null) {
                    e(this, b1, e6, i6);
                }
                j((e6.id * ((long) i5)) + ((long) i6));
                return B.Companion.m1010successJP2dKIU(Q.INSTANCE);
            }
            if (iG == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iG == 4) {
                if (j6 < c.get(this)) {
                    e6.a();
                }
                return B.Companion.m1008closedJP2dKIU(getSendException());
            }
            if (iG == 5) {
                e6.a();
            }
            obj = obj3;
        }
    }

    public final void u(o oVar, Object obj) {
        l lVar = this.onUndeliveredElement;
        if (lVar != null) {
            A.callUndeliveredElement(lVar, obj, oVar.getContext());
        }
        oVar.selectInRegistrationPhase(AbstractC0388s.getCHANNEL_CLOSED());
    }

    public final Object v(g gVar, Object obj) throws IllegalAccessException, InvocationTargetException {
        p028e4.Q qCallUndeliveredElementCatchingException;
        C0289m c0289m = new C0289m(F3.h.intercepted(gVar), 1);
        c0289m.initCancellability();
        l lVar = this.onUndeliveredElement;
        if (lVar == null || (qCallUndeliveredElementCatchingException = A.callUndeliveredElementCatchingException(lVar, obj, null)) == null) {
            c0289m.resumeWith(u.m1361constructorimpl(v.createFailure(getSendException())));
        } else {
            AbstractC1926f.addSuppressed(qCallUndeliveredElementCatchingException, getSendException());
            c0289m.resumeWith(u.m1361constructorimpl(v.createFailure(qCallUndeliveredElementCatchingException)));
        }
        Object result = c0289m.getResult();
        if (result == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result == i.getCOROUTINE_SUSPENDED() ? result : Q.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object x(E e6, int i5, long j6, d dVar) throws Throwable {
        C0387q c0387q;
        B b6;
        E eL;
        if (dVar instanceof C0387q) {
            c0387q = (C0387q) dVar;
            int i6 = c0387q.c;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c0387q.c = i6 - Integer.MIN_VALUE;
            } else {
                c0387q = new C0387q(this, dVar);
            }
        } else {
            c0387q = new C0387q(this, dVar);
        }
        Object result = c0387q.f1184a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i7 = c0387q.c;
        if (i7 == 0) {
            v.throwOnFailure(result);
            c0387q.c = 1;
            C0289m orCreateCancellableContinuation = AbstractC0293o.getOrCreateCancellableContinuation(F3.h.intercepted(c0387q));
            try {
                E.d(orCreateCancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>");
                y0 y0Var = new y0(orCreateCancellableContinuation);
                Object objB = B(e6, i5, j6, y0Var);
                if (objB != AbstractC0388s.SUSPEND) {
                    C0377g c0377g = null;
                    if (objB == AbstractC0388s.FAILED) {
                        if (j6 < n()) {
                            e6.a();
                        }
                        E e7 = (E) f1150g.get(this);
                        while (true) {
                            if (q()) {
                                orCreateCancellableContinuation.resumeWith(u.m1361constructorimpl(B.b(B.Companion.m1008closedJP2dKIU(getCloseCause()))));
                                break;
                            }
                            long andIncrement = c.getAndIncrement(this);
                            long j7 = AbstractC0388s.SEGMENT_SIZE;
                            long j8 = andIncrement / j7;
                            int i8 = (int) (andIncrement % j7);
                            if (e7.id != j8) {
                                eL = l(j8, e7);
                                if (eL == null) {
                                }
                            } else {
                                eL = e7;
                            }
                            Object objB2 = B(eL, i8, andIncrement, y0Var);
                            if (objB2 == AbstractC0388s.SUSPEND) {
                                y0Var.invokeOnCancellation(eL, i8);
                                break;
                            }
                            if (objB2 == AbstractC0388s.FAILED) {
                                if (andIncrement < n()) {
                                    eL.a();
                                }
                                e7 = eL;
                            } else {
                                if (objB2 == AbstractC0388s.SUSPEND_NO_WAITER) {
                                    throw new IllegalStateException("unexpected");
                                }
                                eL.a();
                                b6 = B.b(B.Companion.m1010successJP2dKIU(objB2));
                                if (this.onUndeliveredElement != null) {
                                    c0377g = new C0377g(this, 1);
                                }
                            }
                        }
                    } else {
                        e6.a();
                        b6 = B.b(B.Companion.m1010successJP2dKIU(objB));
                        if (this.onUndeliveredElement != null) {
                            c0377g = new C0377g(this, 1);
                        }
                    }
                    orCreateCancellableContinuation.resume(b6, c0377g);
                    break;
                }
                y0Var.invokeOnCancellation(e6, i5);
                result = orCreateCancellableContinuation.getResult();
                if (result == i.getCOROUTINE_SUSPENDED()) {
                    G3.h.probeCoroutineSuspended(c0387q);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th) {
                orCreateCancellableContinuation.h();
                throw th;
            }
        } else {
            if (i7 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(result);
        }
        return ((B) result).c();
    }

    public final void y(B1 b1, boolean z6) {
        if (b1 instanceof a) {
            ((a) b1).getCont().resumeWith(u.m1361constructorimpl(Boolean.FALSE));
            return;
        }
        if (b1 instanceof InterfaceC0285k) {
            ((g) b1).resumeWith(u.m1361constructorimpl(v.createFailure(z6 ? m() : getSendException())));
            return;
        }
        if (b1 instanceof y0) {
            ((y0) b1).cont.resumeWith(u.m1361constructorimpl(B.b(B.Companion.m1008closedJP2dKIU(getCloseCause()))));
            return;
        }
        if (b1 instanceof C0374e) {
            ((C0374e) b1).c();
        } else if (b1 instanceof o) {
            ((o) b1).trySelect(this, AbstractC0388s.getCHANNEL_CLOSED());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + b1).toString());
        }
    }

    public final boolean z(Object obj, Object obj2) {
        if (obj instanceof o) {
            return ((o) obj).trySelect(this, obj2);
        }
        if (obj instanceof y0) {
            return AbstractC0388s.p(((y0) obj).cont, B.b(B.Companion.m1010successJP2dKIU(obj2)), this.onUndeliveredElement != null ? new C0377g(this, 1) : null);
        }
        if (obj instanceof C0374e) {
            return ((C0374e) obj).b(obj2);
        }
        if (obj instanceof InterfaceC0285k) {
            return AbstractC0388s.p((InterfaceC0285k) obj, obj2, this.onUndeliveredElement != null ? new C0377g(this, 0) : null);
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public final void cancel() {
        cancelImpl$kotlinx_coroutines_core(null);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public final void cancel(CancellationException cancellationException) {
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    public static /* synthetic */ void isEmpty$annotations() {
    }
}
