package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultContract<I, O> {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T t6) {
            this.value = t6;
        }

        public final T getValue() {
            return this.value;
        }
    }

    public abstract Intent createIntent(Context context, I i5);

    public SynchronousResult<O> getSynchronousResult(Context context, I i5) {
        E.f(context, "context");
        return null;
    }

    public abstract O parseResult(int i5, Intent intent);
}
