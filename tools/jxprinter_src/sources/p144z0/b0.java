package p144z0;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 {
    @NonNull
    public <Model, Data> Y build(@NonNull List<T> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        return new Y(list, pool);
    }
}
