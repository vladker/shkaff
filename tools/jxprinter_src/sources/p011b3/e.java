package p011b3;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends AtomicReference implements c {
    private static final long serialVersionUID = 6545242830671168775L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1088a;

    public e(Future future, boolean z6) {
        super(future);
        this.f1088a = z6;
    }

    @Override // p011b3.c
    public final void dispose() {
        Future future = (Future) getAndSet(null);
        if (future != null) {
            future.cancel(this.f1088a);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        Future future = (Future) get();
        return future == null || future.isDone();
    }
}
