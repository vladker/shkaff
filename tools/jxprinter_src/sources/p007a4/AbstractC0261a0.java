package p007a4;

import E3.g;
import E3.j;
import E3.o;
import E3.q;
import F3.h;
import F3.i;
import Y3.a;
import Y3.b;
import Y3.d;
import Y3.e;
import androidx.core.location.LocationRequestCompat;
import p147z3.C1929i;
import p147z3.C1937q;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: a4.a0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0261a0 {
    public static final long a(long j6) {
        a aVar = b.Companion;
        boolean z6 = j6 > 0;
        if (z6) {
            long jH = b.h(j6, d.toDuration(999999L, e.NANOSECONDS));
            return ((((int) jH) & 1) != 1 || b.g(jH)) ? b.m920toLongimpl(jH, e.MILLISECONDS) : jH >> 1;
        }
        if (z6) {
            throw new C1937q();
        }
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object awaitCancellation(g<?> gVar) throws Throwable {
        Z z6;
        if (gVar instanceof Z) {
            z6 = (Z) gVar;
            int i5 = z6.b;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                z6.b = i5 - Integer.MIN_VALUE;
            } else {
                z6 = new Z(gVar);
            }
        } else {
            z6 = new Z(gVar);
        }
        Object obj = z6.f950a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = z6.b;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            z6.b = 1;
            C0289m c0289m = new C0289m(h.intercepted(z6), 1);
            c0289m.initCancellability();
            Object result = c0289m.getResult();
            if (result == i.getCOROUTINE_SUSPENDED()) {
                G3.h.probeCoroutineSuspended(z6);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
        }
        throw new C1929i();
    }

    public static final Object delay(long j6, g<? super Q> gVar) {
        if (j6 <= 0) {
            return Q.INSTANCE;
        }
        C0289m c0289m = new C0289m(h.intercepted(gVar), 1);
        c0289m.initCancellability();
        if (j6 < LocationRequestCompat.PASSIVE_INTERVAL) {
            getDelay(c0289m.getContext()).mo1036scheduleResumeAfterDelay(j6, c0289m);
        }
        Object result = c0289m.getResult();
        if (result == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result == i.getCOROUTINE_SUSPENDED() ? result : Q.INSTANCE;
    }

    /* JADX INFO: renamed from: delay-VtjQ1oo, reason: not valid java name */
    public static final Object m929delayVtjQ1oo(long j6, g<? super Q> gVar) {
        Object objDelay = delay(a(j6), gVar);
        return objDelay == i.getCOROUTINE_SUSPENDED() ? objDelay : Q.INSTANCE;
    }

    public static final Y getDelay(q qVar) {
        o oVar = qVar.get(j.Key);
        Y y6 = oVar instanceof Y ? (Y) oVar : null;
        return y6 == null ? U.getDefaultDelay() : y6;
    }
}
