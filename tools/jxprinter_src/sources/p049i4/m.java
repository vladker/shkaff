package p049i4;

import A3.AbstractC0157z;
import E3.g;
import F3.h;
import F3.i;
import O3.q;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p007a4.AbstractC0293o;
import p007a4.B1;
import p007a4.C0287l;
import p007a4.C0289m;
import p007a4.InterfaceC0285k;
import p028e4.AbstractC0647a;
import p028e4.E;
import p028e4.F;
import p028e4.H;
import p044h4.o;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class m {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "head$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater c = AtomicLongFieldUpdater.newUpdater(m.class, "deqIdx$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "tail$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(m.class, "enqIdx$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4072f = AtomicIntegerFieldUpdater.newUpdater(m.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4073a;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private final q onCancellationRelease;
    private volatile /* synthetic */ Object tail$volatile;

    public m(int i5, int i6) {
        this.f4073a = i5;
        if (i5 <= 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Semaphore should have at least 1 permit, but had ").toString());
        }
        if (i6 < 0 || i6 > i5) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "The number of acquired permits should be in 0..").toString());
        }
        q qVar = new q(0L, null, 2);
        this.head$volatile = qVar;
        this.tail$volatile = qVar;
        this._availablePermits$volatile = i5 - i6;
        this.onCancellationRelease = new C0287l(this, 3);
    }

    public final boolean a(B1 b1) {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
        q qVar = (q) atomicReferenceFieldUpdater.get(this);
        long andIncrement = e.getAndIncrement(this);
        k kVar = k.f4070a;
        long j6 = andIncrement / ((long) p.b);
        loop0: while (true) {
            objFindSegmentInternal = AbstractC0647a.findSegmentInternal(qVar, j6, kVar);
            if (!F.a(objFindSegmentInternal)) {
                E eM1031getSegmentimpl = F.m1031getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    E e6 = (E) atomicReferenceFieldUpdater.get(this);
                    if (e6.id >= eM1031getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!eM1031getSegmentimpl.g()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, e6, eM1031getSegmentimpl)) {
                            if (!e6.d()) {
                                break loop0;
                            }
                            e6.c();
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == e6);
                    if (eM1031getSegmentimpl.d()) {
                        eM1031getSegmentimpl.c();
                    }
                }
            } else {
                break;
            }
        }
        q qVar2 = (q) F.m1031getSegmentimpl(objFindSegmentInternal);
        int i5 = (int) (andIncrement % ((long) p.b));
        AtomicReferenceArray atomicReferenceArray = qVar2.d;
        while (!atomicReferenceArray.compareAndSet(i5, null, b1)) {
            if (atomicReferenceArray.get(i5) != null) {
                H h6 = p.PERMIT;
                H h7 = p.TAKEN;
                AtomicReferenceArray atomicReferenceArray2 = qVar2.d;
                while (!atomicReferenceArray2.compareAndSet(i5, h6, h7)) {
                    if (atomicReferenceArray2.get(i5) != h6) {
                        return false;
                    }
                }
                if (b1 instanceof InterfaceC0285k) {
                    kotlin.jvm.internal.E.d(b1, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                    ((InterfaceC0285k) b1).resume(Q.INSTANCE, this.onCancellationRelease);
                    return true;
                }
                if (b1 instanceof o) {
                    ((o) b1).selectInRegistrationPhase(Q.INSTANCE);
                    return true;
                }
                throw new IllegalStateException(("unexpected: " + b1).toString());
            }
        }
        b1.invokeOnCancellation(qVar2, i5);
        return true;
    }

    public final Object acquire(g<? super Q> gVar) {
        int andDecrement;
        do {
            andDecrement = f4072f.getAndDecrement(this);
        } while (andDecrement > this.f4073a);
        if (andDecrement > 0) {
            return Q.INSTANCE;
        }
        C0289m orCreateCancellableContinuation = AbstractC0293o.getOrCreateCancellableContinuation(h.intercepted(gVar));
        try {
            if (!a(orCreateCancellableContinuation)) {
                acquire((InterfaceC0285k) orCreateCancellableContinuation);
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == i.getCOROUTINE_SUSPENDED()) {
                G3.h.probeCoroutineSuspended(gVar);
            }
            if (result != i.getCOROUTINE_SUSPENDED()) {
                result = Q.INSTANCE;
            }
            return result == i.getCOROUTINE_SUSPENDED() ? result : Q.INSTANCE;
        } catch (Throwable th) {
            orCreateCancellableContinuation.h();
            throw th;
        }
    }

    public final void b() {
        int i5;
        Object objFindSegmentInternal;
        boolean zTrySelect;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4072f;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i6 = this.f4073a;
            if (andIncrement >= i6) {
                do {
                    i5 = atomicIntegerFieldUpdater.get(this);
                    if (i5 <= i6) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, i6));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i6).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = c.getAndIncrement(this);
            long j6 = andIncrement2 / ((long) p.b);
            l lVar = l.f4071a;
            while (true) {
                objFindSegmentInternal = AbstractC0647a.findSegmentInternal(qVar, j6, lVar);
                if (!F.a(objFindSegmentInternal)) {
                    E eM1031getSegmentimpl = F.m1031getSegmentimpl(objFindSegmentInternal);
                    while (true) {
                        E e6 = (E) atomicReferenceFieldUpdater.get(this);
                        if (e6.id >= eM1031getSegmentimpl.id) {
                            break;
                        }
                        if (!eM1031getSegmentimpl.g()) {
                            break;
                        }
                        do {
                            if (atomicReferenceFieldUpdater.compareAndSet(this, e6, eM1031getSegmentimpl)) {
                                if (!e6.d()) {
                                    break;
                                }
                                e6.c();
                                break;
                            }
                        } while (atomicReferenceFieldUpdater.get(this) == e6);
                        if (eM1031getSegmentimpl.d()) {
                            eM1031getSegmentimpl.c();
                        }
                    }
                } else {
                    break;
                }
            }
            q qVar2 = (q) F.m1031getSegmentimpl(objFindSegmentInternal);
            qVar2.a();
            AtomicReferenceArray atomicReferenceArray = qVar2.d;
            zTrySelect = false;
            if (qVar2.id <= j6) {
                int i7 = (int) (andIncrement2 % ((long) p.b));
                Object andSet = atomicReferenceArray.getAndSet(i7, p.PERMIT);
                if (andSet == null) {
                    int i8 = p.f4075a;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= i8) {
                            H h6 = p.PERMIT;
                            H h7 = p.BROKEN;
                            do {
                                if (atomicReferenceArray.compareAndSet(i7, h6, h7)) {
                                    zTrySelect = true;
                                    break;
                                }
                            } while (atomicReferenceArray.get(i7) == h6);
                            zTrySelect = !zTrySelect;
                            break;
                        }
                        if (atomicReferenceArray.get(i7) == p.TAKEN) {
                            zTrySelect = true;
                            break;
                        }
                        i9++;
                    }
                } else if (andSet != p.CANCELLED) {
                    if (andSet instanceof InterfaceC0285k) {
                        InterfaceC0285k interfaceC0285k = (InterfaceC0285k) andSet;
                        Object objTryResume = interfaceC0285k.tryResume(Q.INSTANCE, null, this.onCancellationRelease);
                        if (objTryResume != null) {
                            interfaceC0285k.completeResume(objTryResume);
                            zTrySelect = true;
                            break;
                            break;
                        }
                    } else {
                        if (!(andSet instanceof o)) {
                            throw new IllegalStateException(("unexpected: " + andSet).toString());
                        }
                        zTrySelect = ((o) andSet).trySelect(this, Q.INSTANCE);
                    }
                }
            }
        } while (!zTrySelect);
    }

    public final void onAcquireRegFunction(o oVar, Object obj) {
        while (true) {
            int andDecrement = f4072f.getAndDecrement(this);
            if (andDecrement <= this.f4073a) {
                if (andDecrement > 0) {
                    oVar.selectInRegistrationPhase(Q.INSTANCE);
                    return;
                } else {
                    kotlin.jvm.internal.E.d(oVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
                    if (a((B1) oVar)) {
                        return;
                    }
                }
            }
        }
    }

    public final void acquire(InterfaceC0285k interfaceC0285k) {
        while (true) {
            int andDecrement = f4072f.getAndDecrement(this);
            if (andDecrement <= this.f4073a) {
                if (andDecrement > 0) {
                    interfaceC0285k.resume(Q.INSTANCE, this.onCancellationRelease);
                    return;
                } else {
                    kotlin.jvm.internal.E.d(interfaceC0285k, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
                    if (a((B1) interfaceC0285k)) {
                        return;
                    }
                }
            }
        }
    }
}
