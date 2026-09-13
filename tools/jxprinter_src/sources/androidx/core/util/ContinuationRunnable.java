package androidx.core.util;

import E3.g;
import java.util.concurrent.atomic.AtomicBoolean;
import p147z3.Q;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final g<Q> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationRunnable(g<? super Q> gVar) {
        super(false);
        this.continuation = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(u.m1361constructorimpl(Q.INSTANCE));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
