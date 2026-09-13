package p007a4;

import E3.a;
import E3.g;
import E3.h;
import E3.j;
import E3.o;
import E3.p;
import E3.q;
import S2.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.E;
import p028e4.AbstractC0655i;
import p028e4.AbstractC0659m;
import p028e4.C0654h;
import p028e4.C0658l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class F extends a implements j {
    public static final E Key = new E(j.Key, new l(10));

    public F() {
        super(j.Key);
    }

    public static /* synthetic */ F limitedParallelism$default(F f6, int i5, String str, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
        }
        if ((i6 & 2) != 0) {
            str = null;
        }
        return f6.limitedParallelism(i5, str);
    }

    /* JADX INFO: renamed from: dispatch */
    public abstract void mo1035dispatch(q qVar, Runnable runnable);

    public void dispatchYield(q qVar, Runnable runnable) {
        mo1035dispatch(qVar, runnable);
    }

    @Override // E3.a, E3.o, E3.q
    public <E extends o> E get(p pVar) {
        return (E) h.get(this, pVar);
    }

    @Override // E3.j
    public final <T> g<T> interceptContinuation(g<? super T> gVar) {
        return new C0654h(this, gVar);
    }

    public boolean isDispatchNeeded(q qVar) {
        return true;
    }

    public F limitedParallelism(int i5, String str) {
        AbstractC0659m.a(i5);
        return new C0658l(this, i5, str);
    }

    @Override // E3.a, E3.o, E3.q
    public q minusKey(p pVar) {
        return h.minusKey(this, pVar);
    }

    @Override // E3.j
    public final void releaseInterceptedContinuation(g<?> gVar) {
        E.d(gVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        C0654h c0654h = (C0654h) gVar;
        c0654h.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C0654h.f3940a;
        while (atomicReferenceFieldUpdater.get(c0654h) == AbstractC0655i.REUSABLE_CLAIMED) {
        }
        Object obj = atomicReferenceFieldUpdater.get(c0654h);
        C0289m c0289m = obj instanceof C0289m ? (C0289m) obj : null;
        if (c0289m != null) {
            c0289m.b();
        }
    }

    public String toString() {
        return S.getClassSimpleName(this) + '@' + S.getHexAddress(this);
    }

    public /* synthetic */ F limitedParallelism(int i5) {
        return limitedParallelism(i5, null);
    }

    public final F plus(F f6) {
        return f6;
    }
}
