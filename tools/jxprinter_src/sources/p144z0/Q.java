package p144z0;

import androidx.annotation.Nullable;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O f9062a = new O(500);

    @Nullable
    public Object get(Object obj, int i5, int i6) {
        P pA = P.a(obj, i5, i6);
        Object obj2 = this.f9062a.get(pA);
        Queue queue = P.d;
        synchronized (queue) {
            queue.offer(pA);
        }
        return obj2;
    }
}
