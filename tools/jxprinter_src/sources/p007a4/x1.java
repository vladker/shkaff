package p007a4;

import E3.g;
import F3.i;
import G3.h;
import O3.p;
import androidx.exifinterface.media.a;
import kotlin.jvm.internal.T;
import p034f4.b;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x1 {
    public static final u1 TimeoutCancellationException(long j6, Y y6, H0 h1) {
        return new u1(a.k("Timed out waiting for ", j6, " ms"), h1);
    }

    public static final <T> Object withTimeout(long j6, p pVar, g<? super T> gVar) throws Throwable {
        if (j6 <= 0) {
            throw new u1("Timed out immediately");
        }
        v1 v1Var = new v1(j6, gVar);
        K0.disposeOnCompletion(v1Var, AbstractC0261a0.getDelay(v1Var.uCont.getContext()).invokeOnTimeout(v1Var.time, v1Var, v1Var.getContext()));
        Object objStartUndispatchedOrReturnIgnoreTimeout = b.startUndispatchedOrReturnIgnoreTimeout(v1Var, v1Var, pVar);
        if (objStartUndispatchedOrReturnIgnoreTimeout == i.getCOROUTINE_SUSPENDED()) {
            h.probeCoroutineSuspended(gVar);
        }
        return objStartUndispatchedOrReturnIgnoreTimeout;
    }

    /* JADX INFO: renamed from: withTimeout-KLykuaI, reason: not valid java name */
    public static final <T> Object m931withTimeoutKLykuaI(long j6, p pVar, g<? super T> gVar) {
        return withTimeout(AbstractC0261a0.a(j6), pVar, gVar);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0085 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0087  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object withTimeoutOrNull(long j6, p pVar, g<? super T> gVar) throws Throwable {
        w1 w1Var;
        T t6;
        if (gVar instanceof w1) {
            w1Var = (w1) gVar;
            int i5 = w1Var.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                w1Var.c = i5 - Integer.MIN_VALUE;
            } else {
                w1Var = new w1(gVar);
            }
        } else {
            w1Var = new w1(gVar);
        }
        Object obj = w1Var.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = w1Var.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            if (j6 <= 0) {
                return null;
            }
            T t7 = new T();
            try {
                w1Var.f959a = t7;
                w1Var.c = 1;
                v1 v1Var = new v1(j6, w1Var);
                t7.f5689a = v1Var;
                try {
                    K0.disposeOnCompletion(v1Var, AbstractC0261a0.getDelay(v1Var.uCont.getContext()).invokeOnTimeout(v1Var.time, v1Var, v1Var.getContext()));
                    Object objStartUndispatchedOrReturnIgnoreTimeout = b.startUndispatchedOrReturnIgnoreTimeout(v1Var, v1Var, pVar);
                    if (objStartUndispatchedOrReturnIgnoreTimeout == i.getCOROUTINE_SUSPENDED()) {
                        h.probeCoroutineSuspended(w1Var);
                    }
                    return objStartUndispatchedOrReturnIgnoreTimeout == coroutine_suspended ? coroutine_suspended : objStartUndispatchedOrReturnIgnoreTimeout;
                } catch (u1 e) {
                    e = e;
                    t6 = t7;
                    if (e.coroutine == t6.f5689a) {
                        return null;
                    }
                    throw e;
                }
            } catch (u1 e6) {
                e = e6;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t6 = w1Var.f959a;
            try {
                v.throwOnFailure(obj);
                return obj;
            } catch (u1 e7) {
                e = e7;
            }
        }
        if (e.coroutine == t6.f5689a) {
            return null;
        }
        throw e;
    }

    /* JADX INFO: renamed from: withTimeoutOrNull-KLykuaI, reason: not valid java name */
    public static final <T> Object m932withTimeoutOrNullKLykuaI(long j6, p pVar, g<? super T> gVar) {
        return withTimeoutOrNull(AbstractC0261a0.a(j6), pVar, gVar);
    }
}
