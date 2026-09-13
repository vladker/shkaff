package p007a4;

import O3.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D0 extends O0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(D0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;
    private final l handler;

    public D0(l lVar) {
        this.handler = lVar;
    }

    @Override // p007a4.O0
    public final boolean d() {
        return true;
    }

    @Override // p007a4.O0
    public void invoke(Throwable th) {
        if (e.compareAndSet(this, 0, 1)) {
            this.handler.invoke(th);
        }
    }
}
