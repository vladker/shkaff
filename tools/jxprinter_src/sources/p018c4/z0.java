package p018c4;

import E3.g;
import F3.i;
import kotlin.jvm.internal.E;
import p028e4.G;
import p044h4.h;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z0 {
    public static <E> h getOnReceiveOrNull(B0 b1) {
        E.d(b1, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel<E of kotlinx.coroutines.channels.ReceiveChannel>");
        return ((C0376f) b1).getOnReceiveOrNull();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> E poll(B0 b1) throws Throwable {
        Throwable th;
        E e = (E) b1.mo1007tryReceivePtdJZtk();
        boolean z6 = e instanceof D;
        if (z6) {
            Throwable thM1003exceptionOrNullimpl = B.m1003exceptionOrNullimpl(e);
            if (thM1003exceptionOrNullimpl == null) {
                return null;
            }
            throw G.recoverStackTrace(thM1003exceptionOrNullimpl);
        }
        if (!z6) {
            return e;
        }
        if ((e instanceof B.a) && (th = ((B.a) e).cause) != null) {
            throw th;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + e).toString());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static <E> Object receiveOrNull(B0 b1, g<? super E> gVar) throws Throwable {
        A0 a6;
        Object objMo1006receiveCatchingJP2dKIU;
        if (gVar instanceof A0) {
            a6 = (A0) gVar;
            int i5 = a6.b;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                a6.b = i5 - Integer.MIN_VALUE;
            } else {
                a6 = new A0(gVar);
            }
        } else {
            a6 = new A0(gVar);
        }
        Object obj = a6.f1102a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = a6.b;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            a6.b = 1;
            objMo1006receiveCatchingJP2dKIU = b1.mo1006receiveCatchingJP2dKIU(a6);
            if (objMo1006receiveCatchingJP2dKIU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            objMo1006receiveCatchingJP2dKIU = ((B) obj).c();
        }
        return B.m1004getOrNullimpl(objMo1006receiveCatchingJP2dKIU);
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    public static /* synthetic */ void isEmpty$annotations() {
    }
}
