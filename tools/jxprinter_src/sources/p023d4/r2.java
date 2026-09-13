package p023d4;

import E3.g;
import F3.h;
import F3.i;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.E;
import kotlinx.coroutines.flow.internal.AbstractC1114c;
import kotlinx.coroutines.flow.internal.AbstractC1115d;
import p007a4.C0289m;
import p028e4.AbstractC0649c;
import p028e4.H;
import p147z3.Q;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r2 extends AbstractC1115d {
    private final AtomicReference<Object> _state = new AtomicReference<>(null);

    @Override // kotlinx.coroutines.flow.internal.AbstractC1115d
    /* JADX INFO: renamed from: allocateLocked, reason: merged with bridge method [inline-methods] */
    public boolean a(p2 p2Var) {
        if (AbstractC0649c.getValue(this._state) != null) {
            return false;
        }
        AbstractC0649c.setValue(this._state, q2.NONE);
        return true;
    }

    public final Object awaitPending(g<? super Q> gVar) {
        C0289m c0289m = new C0289m(h.intercepted(gVar), 1);
        c0289m.initCancellability();
        AtomicReference<Object> atomicReference = this._state;
        H h6 = q2.NONE;
        while (!atomicReference.compareAndSet(h6, c0289m)) {
            if (atomicReference.get() != h6) {
                c0289m.resumeWith(u.m1361constructorimpl(Q.INSTANCE));
                break;
            }
        }
        Object result = c0289m.getResult();
        if (result == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result == i.getCOROUTINE_SUSPENDED() ? result : Q.INSTANCE;
    }

    public final void b() {
        AtomicReference<Object> atomicReference = this._state;
        while (true) {
            Object value = AbstractC0649c.getValue(atomicReference);
            if (value == null || value == q2.PENDING) {
                return;
            }
            if (value == q2.NONE) {
                AtomicReference<Object> atomicReference2 = this._state;
                H h6 = q2.PENDING;
                while (!atomicReference2.compareAndSet(value, h6)) {
                    if (atomicReference2.get() != value) {
                    }
                }
                return;
            }
            AtomicReference<Object> atomicReference3 = this._state;
            H h7 = q2.NONE;
            do {
                if (atomicReference3.compareAndSet(value, h7)) {
                    ((C0289m) value).resumeWith(u.m1361constructorimpl(Q.INSTANCE));
                    return;
                }
            } while (atomicReference3.get() == value);
        }
    }

    public final boolean c() {
        Object andSet = this._state.getAndSet(q2.NONE);
        E.c(andSet);
        return andSet == q2.PENDING;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC1115d
    public g<Q>[] freeLocked(p2 p2Var) {
        AbstractC0649c.setValue(this._state, null);
        return AbstractC1114c.EMPTY_RESUMES;
    }
}
