package p018c4;

import E3.g;
import S2.r;
import p007a4.AbstractC0275f;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class H {
    public static final void sendBlocking(D0 d1, Object obj) {
        if (d1.mo1011trySendJP2dKIU(obj) instanceof D) {
            AbstractC0275f.runBlocking$default(null, new G(d1, obj, null, 0), 1, null);
        }
    }

    public static final <E> Object trySendBlocking(D0 d1, E e) {
        Object objMo1011trySendJP2dKIU = d1.mo1011trySendJP2dKIU(e);
        if (objMo1011trySendJP2dKIU instanceof D) {
            return ((B) AbstractC0275f.runBlocking$default(null, new r(d1, e, (g) null, 1), 1, null)).c();
        }
        return B.Companion.m1010successJP2dKIU(Q.INSTANCE);
    }
}
