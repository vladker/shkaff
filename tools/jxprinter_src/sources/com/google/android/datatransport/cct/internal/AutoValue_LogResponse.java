package com.google.android.datatransport.cct.internal;

import A3.AbstractC0157z;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_LogResponse extends LogResponse {
    private final long nextRequestWaitMillis;

    public AutoValue_LogResponse(long j6) {
        this.nextRequestWaitMillis = j6;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof LogResponse) && this.nextRequestWaitMillis == ((LogResponse) obj).getNextRequestWaitMillis();
    }

    @Override // com.google.android.datatransport.cct.internal.LogResponse
    public long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public int hashCode() {
        long j6 = this.nextRequestWaitMillis;
        return ((int) (j6 ^ (j6 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return AbstractC0157z.r(new StringBuilder("LogResponse{nextRequestWaitMillis="), this.nextRequestWaitMillis, VectorFormat.DEFAULT_SUFFIX);
    }
}
