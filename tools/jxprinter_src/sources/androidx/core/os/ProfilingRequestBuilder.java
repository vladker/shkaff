package androidx.core.os;

import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.os.ProfilingRequestBuilder;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 35)
public abstract class ProfilingRequestBuilder<T extends ProfilingRequestBuilder<T>> {
    private android.os.CancellationSignal mCancellationSignal;
    private String mTag;

    public final ProfilingRequest build() {
        return new ProfilingRequest(getProfilingType(), getParams(), this.mTag, this.mCancellationSignal);
    }

    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    public abstract Bundle getParams();

    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    public abstract int getProfilingType();

    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    public abstract T getThis();

    public final T setCancellationSignal(android.os.CancellationSignal cancellationSignal) {
        E.f(cancellationSignal, "cancellationSignal");
        this.mCancellationSignal = cancellationSignal;
        return (T) getThis();
    }

    public final T setTag(String tag) {
        E.f(tag, "tag");
        this.mTag = tag;
        return (T) getThis();
    }
}
