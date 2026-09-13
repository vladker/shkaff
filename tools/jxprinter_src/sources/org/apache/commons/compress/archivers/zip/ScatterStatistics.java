package org.apache.commons.compress.archivers.zip;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ScatterStatistics {
    private final long compressionElapsed;
    private final long mergingElapsed;

    public ScatterStatistics(long j6, long j7) {
        this.compressionElapsed = j6;
        this.mergingElapsed = j7;
    }

    public long getCompressionElapsed() {
        return this.compressionElapsed;
    }

    public long getMergingElapsed() {
        return this.mergingElapsed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("compressionElapsed=");
        sb.append(this.compressionElapsed);
        sb.append("ms, mergingElapsed=");
        return AbstractC0157z.r(sb, this.mergingElapsed, "ms");
    }
}
