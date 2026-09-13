package G3;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> E3.g<T> probeCoroutineCreated(E3.g<? super T> completion) {
        E.f(completion, "completion");
        return completion;
    }

    public static final void probeCoroutineResumed(E3.g<?> frame) {
        E.f(frame, "frame");
    }

    public static final void probeCoroutineSuspended(E3.g<?> frame) {
        E.f(frame, "frame");
    }
}
