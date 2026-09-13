package p144z0;

import L0.n;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class O extends n {
    @Override // L0.n
    public void onItemEvicted(@NonNull P p6, @Nullable Object obj) {
        p6.getClass();
        Queue queue = P.d;
        synchronized (queue) {
            queue.offer(p6);
        }
    }
}
