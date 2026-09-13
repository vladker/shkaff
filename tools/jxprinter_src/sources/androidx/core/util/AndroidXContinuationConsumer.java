package androidx.core.util;

import E3.g;
import java.util.concurrent.atomic.AtomicBoolean;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
final class AndroidXContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    private final g<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidXContinuationConsumer(g<? super T> gVar) {
        super(false);
        this.continuation = gVar;
    }

    @Override // androidx.core.util.Consumer
    public void accept(T t6) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(u.m1361constructorimpl(t6));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
