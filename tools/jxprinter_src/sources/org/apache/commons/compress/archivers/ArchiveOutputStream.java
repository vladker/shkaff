package org.apache.commons.compress.archivers;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.LinkOption;
import java.nio.file.Path;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ArchiveOutputStream extends OutputStream {
    static final int BYTE_MASK = 255;
    private long bytesWritten;
    private final byte[] oneByte = new byte[1];

    public boolean canWriteEntryData(ArchiveEntry archiveEntry) {
        return true;
    }

    public abstract void closeArchiveEntry();

    public void count(int i5) {
        count(i5);
    }

    public abstract ArchiveEntry createArchiveEntry(File file, String str);

    public ArchiveEntry createArchiveEntry(Path path, String str, LinkOption... linkOptionArr) {
        return createArchiveEntry(path.toFile(), str);
    }

    public abstract void finish();

    public long getBytesWritten() {
        return this.bytesWritten;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesWritten;
    }

    public abstract void putArchiveEntry(ArchiveEntry archiveEntry);

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i5 & 255);
        write(bArr, 0, 1);
    }

    public void count(long j6) {
        if (j6 != -1) {
            this.bytesWritten += j6;
        }
    }
}
