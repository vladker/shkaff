package p049i4;

import F3.h;
import F3.i;
import O3.q;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.Y;
import p007a4.AbstractC0293o;
import p007a4.C0287l;
import p007a4.C0289m;
import p007a4.InterfaceC0285k;
import p007a4.S;
import p028e4.H;
import p044h4.j;
import p044h4.k;
import p044h4.o;
import p044h4.p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends m implements b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4068g = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "owner$volatile");
    private final q onSelectCancellationUnlockConstructor;
    private volatile /* synthetic */ Object owner$volatile;

    public g(boolean z6) {
        super(1, z6 ? 1 : 0);
        this.owner$volatile = z6 ? null : i.NO_OWNER;
        this.onSelectCancellationUnlockConstructor = new C0287l(this, 2);
    }

    public final boolean c() {
        return Math.max(m.f4072f.get(this), 0) == 0;
    }

    @Override // p049i4.b
    public j getOnLock() {
        e eVar = e.f4066a;
        E.d(eVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Y.c(3, eVar);
        f fVar = f.f4067a;
        E.d(fVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        Y.c(3, fVar);
        return new k(this, eVar, fVar, this.onSelectCancellationUnlockConstructor);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x001e A[RETURN] */
    @Override // p049i4.b
    public boolean holdsLock(Object obj) {
        char c;
        while (c()) {
            Object obj2 = f4068g.get(this);
            if (obj2 != i.NO_OWNER) {
                c = obj2 == obj ? (char) 1 : (char) 2;
                if (c == 1) {
                    return true;
                }
                return false;
            }
        }
        c = 0;
        if (c == 1) {
            return true;
        }
        return false;
    }

    @Override // p049i4.b
    public Object lock(Object obj, E3.g<? super Q> gVar) {
        if (tryLock(obj)) {
            return Q.INSTANCE;
        }
        C0289m orCreateCancellableContinuation = AbstractC0293o.getOrCreateCancellableContinuation(h.intercepted(gVar));
        try {
            acquire((InterfaceC0285k) new c(this, orCreateCancellableContinuation, obj));
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

    public Object onLockProcessResult(Object obj, Object obj2) {
        if (!E.a(obj2, i.ON_LOCK_ALREADY_LOCKED_BY_OWNER)) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public void onLockRegFunction(o oVar, Object obj) {
        if (obj != null && holdsLock(obj)) {
            oVar.selectInRegistrationPhase(i.ON_LOCK_ALREADY_LOCKED_BY_OWNER);
        } else {
            E.d(oVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            onAcquireRegFunction(new d(this, (p) oVar, obj), obj);
        }
    }

    public String toString() {
        return "Mutex@" + S.getHexAddress(this) + "[isLocked=" + c() + ",owner=" + f4068g.get(this) + ']';
    }

    @Override // p049i4.b
    public boolean tryLock(Object obj) {
        int i5;
        char c;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = m.f4072f;
            int i6 = atomicIntegerFieldUpdater.get(this);
            int i7 = this.f4073a;
            if (i6 > i7) {
                do {
                    i5 = atomicIntegerFieldUpdater.get(this);
                    if (i5 <= i7) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, i7));
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4068g;
                if (i6 <= 0) {
                    if (obj == null) {
                        break;
                    }
                    while (true) {
                        if (!c()) {
                            c = 0;
                            break;
                        }
                        Object obj2 = atomicReferenceFieldUpdater.get(this);
                        if (obj2 != i.NO_OWNER) {
                            if (obj2 != obj) {
                                c = 2;
                                break;
                            }
                            c = 1;
                            break;
                        }
                    }
                    if (c == 1) {
                        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
                    }
                    if (c == 2) {
                        break;
                    }
                } else if (atomicIntegerFieldUpdater.compareAndSet(this, i6, i6 - 1)) {
                    atomicReferenceFieldUpdater.set(this, obj);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p049i4.b
    public void unlock(Object obj) {
        while (c()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4068g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != i.NO_OWNER) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                H h6 = i.NO_OWNER;
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, h6)) {
                        b();
                        return;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj2);
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }
}
