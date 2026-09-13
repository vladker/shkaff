package org.apache.commons.compress.archivers.sevenz;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class BoundedSeekableByteChannelInputStream extends InputStream {
    private static final int MAX_BUF_LEN = 8192;
    private final ByteBuffer buffer;
    private long bytesRemaining;
    private final SeekableByteChannel channel;

    public BoundedSeekableByteChannelInputStream(SeekableByteChannel seekableByteChannel, long j6) {
        this.channel = seekableByteChannel;
        this.bytesRemaining = j6;
        if (j6 >= PlaybackStateCompat.ACTION_PLAY_FROM_URI || j6 <= 0) {
            this.buffer = ByteBuffer.allocate(8192);
        } else {
            this.buffer = ByteBuffer.allocate((int) j6);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        long j6 = this.bytesRemaining;
        if (j6 <= 0) {
            return -1;
        }
        this.bytesRemaining = j6 - 1;
        int i5 = read(1);
        return i5 < 0 ? i5 : this.buffer.get() & UnsignedBytes.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        ByteBuffer byteBufferAllocate;
        int i7;
        if (i6 == 0) {
            return 0;
        }
        long j6 = this.bytesRemaining;
        if (j6 <= 0) {
            return -1;
        }
        if (i6 > j6) {
            i6 = (int) j6;
        }
        if (i6 <= this.buffer.capacity()) {
            byteBufferAllocate = this.buffer;
            i7 = read(i6);
        } else {
            byteBufferAllocate = ByteBuffer.allocate(i6);
            i7 = this.channel.read(byteBufferAllocate);
            byteBufferAllocate.flip();
        }
        if (i7 >= 0) {
            byteBufferAllocate.get(bArr, i5, i7);
            this.bytesRemaining -= (long) i7;
        }
        return i7;
    }

    private int read(int i5) throws IOException {
        this.buffer.rewind().limit(i5);
        int i6 = this.channel.read(this.buffer);
        this.buffer.flip();
        return i6;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
