package org.apache.commons.compress.compressors;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CompressorInputStream extends InputStream {
    private long bytesRead;

    public void count(int i5) {
        count(i5);
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesRead;
    }

    public long getUncompressedCount() {
        return getBytesRead();
    }

    public void pushedBackBytes(long j6) {
        this.bytesRead -= j6;
    }

    public void count(long j6) {
        if (j6 != -1) {
            this.bytesRead += j6;
        }
    }
}
