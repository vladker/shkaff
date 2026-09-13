package p018c4;

import E3.g;
import O3.l;
import p044h4.j;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface D0 {
    boolean c();

    boolean close(Throwable th);

    j getOnSend();

    void invokeOnClose(l lVar);

    boolean offer(Object obj);

    Object send(Object obj, g<? super Q> gVar);

    /* JADX INFO: renamed from: trySend-JP2dKIU, reason: not valid java name */
    Object mo1011trySendJP2dKIU(Object obj);
}
