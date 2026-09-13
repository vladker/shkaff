package p049i4;

import E3.g;
import p044h4.j;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface b {
    j getOnLock();

    boolean holdsLock(Object obj);

    Object lock(Object obj, g<? super Q> gVar);

    boolean tryLock(Object obj);

    void unlock(Object obj);
}
