package p011b3;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends AtomicReference implements c {
    private static final long serialVersionUID = 6537757548749041217L;

    @Override // p011b3.c
    public final void dispose() {
        Object andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        onDisposed(andSet);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == null;
    }

    public abstract void onDisposed(Object obj);
}
