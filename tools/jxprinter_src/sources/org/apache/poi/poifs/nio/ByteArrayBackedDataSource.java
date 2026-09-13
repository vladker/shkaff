package org.apache.poi.poifs.nio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ByteArrayBackedDataSource extends DataSource {
    private static final int MAX_RECORD_LENGTH = Integer.MAX_VALUE;
    private byte[] buffer;
    private long size;

    public ByteArrayBackedDataSource(byte[] bArr, int i5) {
        this.buffer = bArr;
        this.size = i5;
    }

    private void extend(long j6) {
        byte[] bArr = this.buffer;
        long length = j6 - ((long) bArr.length);
        if (length < ((double) bArr.length) * 0.25d) {
            length = (long) (((double) bArr.length) * 0.25d);
        }
        if (length < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            length = 4096;
        }
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(length + ((long) bArr.length), Integer.MAX_VALUE);
        System.arraycopy(this.buffer, 0, bArrSafelyAllocate, 0, (int) this.size);
        this.buffer = bArrSafelyAllocate;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void close() {
        this.buffer = null;
        this.size = -1L;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void copyTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.buffer, 0, (int) this.size);
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public ByteBuffer read(int i5, long j6) {
        long j7 = this.size;
        if (j6 < j7) {
            return ByteBuffer.wrap(this.buffer, (int) j6, (int) Math.min(i5, j7 - j6));
        }
        throw new IndexOutOfBoundsException("Unable to read " + i5 + " bytes from " + j6 + " in stream of length " + this.size);
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public long size() {
        return this.size;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void write(ByteBuffer byteBuffer, long j6) {
        long jCapacity = ((long) byteBuffer.capacity()) + j6;
        if (jCapacity > this.buffer.length) {
            extend(jCapacity);
        }
        byteBuffer.get(this.buffer, (int) j6, byteBuffer.capacity());
        if (jCapacity > this.size) {
            this.size = jCapacity;
        }
    }

    public ByteArrayBackedDataSource(byte[] bArr) {
        this(bArr, bArr.length);
    }
}
