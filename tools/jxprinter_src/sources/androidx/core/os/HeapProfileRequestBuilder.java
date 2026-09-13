package androidx.core.os;

import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 35)
public final class HeapProfileRequestBuilder extends ProfilingRequestBuilder<HeapProfileRequestBuilder> {
    private final Bundle mParams = new Bundle();

    @Override // androidx.core.os.ProfilingRequestBuilder
    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    public Bundle getParams() {
        return this.mParams;
    }

    @Override // androidx.core.os.ProfilingRequestBuilder
    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    public int getProfilingType() {
        return 2;
    }

    @Override // androidx.core.os.ProfilingRequestBuilder
    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    public HeapProfileRequestBuilder getThis() {
        return this;
    }

    public final HeapProfileRequestBuilder setBufferSizeKb(int i5) {
        this.mParams.putInt("KEY_SIZE_KB", i5);
        return this;
    }

    public final HeapProfileRequestBuilder setDurationMs(int i5) {
        this.mParams.putInt("KEY_DURATION_MS", i5);
        return this;
    }

    public final HeapProfileRequestBuilder setSamplingIntervalBytes(long j6) {
        this.mParams.putLong("KEY_SAMPLING_INTERVAL_BYTES", j6);
        return this;
    }

    public final HeapProfileRequestBuilder setTrackJavaAllocations(boolean z6) {
        this.mParams.putBoolean("KEY_TRACK_JAVA_ALLOCATIONS", z6);
        return this;
    }
}
