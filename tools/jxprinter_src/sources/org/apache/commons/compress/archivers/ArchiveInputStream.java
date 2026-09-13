package org.apache.commons.compress.archivers;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ArchiveInputStream extends InputStream {
    private static final int BYTE_MASK = 255;
    private long bytesRead;
    private final byte[] single = new byte[1];

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        return true;
    }

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

    public abstract ArchiveEntry getNextEntry();

    public void pushedBackBytes(long j6) {
        this.bytesRead -= j6;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.single, 0, 1) == -1) {
            return -1;
        }
        return this.single[0] & UnsignedBytes.MAX_VALUE;
    }

    public void count(long j6) {
        if (j6 != -1) {
            this.bytesRead += j6;
        }
    }
}
