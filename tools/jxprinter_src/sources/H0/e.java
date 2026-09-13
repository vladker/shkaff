package H0;

import L0.p;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f286a = new AtomicReference();
    public final ArrayMap b = new ArrayMap();

    @Nullable
    public List<Class<?>> get(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        p pVar = (p) this.f286a.getAndSet(null);
        if (pVar == null) {
            pVar = new p(cls, cls2, cls3);
        } else {
            pVar.set(cls, cls2, cls3);
        }
        synchronized (this.b) {
            list = (List) this.b.get(pVar);
        }
        this.f286a.set(pVar);
        return list;
    }

    public void put(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.b) {
            this.b.put(new p(cls, cls2, cls3), list);
        }
    }
}
