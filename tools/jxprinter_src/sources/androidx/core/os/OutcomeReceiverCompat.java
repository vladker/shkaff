package androidx.core.os;

import java.lang.Throwable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface OutcomeReceiverCompat<R, E extends Throwable> {
    void onResult(R r6);

    default void onError(E e) {
    }
}
