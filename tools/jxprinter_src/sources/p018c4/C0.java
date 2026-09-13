package p018c4;

import p028e4.G;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class C0 {
    public static <E> boolean offer(D0 d1, E e) throws Throwable {
        Object objMo1011trySendJP2dKIU = d1.mo1011trySendJP2dKIU(e);
        if (!(objMo1011trySendJP2dKIU instanceof D)) {
            return true;
        }
        Throwable thM1003exceptionOrNullimpl = B.m1003exceptionOrNullimpl(objMo1011trySendJP2dKIU);
        if (thM1003exceptionOrNullimpl == null) {
            return false;
        }
        throw G.recoverStackTrace(thM1003exceptionOrNullimpl);
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }
}
