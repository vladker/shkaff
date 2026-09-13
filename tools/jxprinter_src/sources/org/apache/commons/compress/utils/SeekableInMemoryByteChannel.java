package org.apache.commons.compress.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SeekableByteChannel;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SeekableInMemoryByteChannel implements SeekableByteChannel {
    private static final int NAIVE_RESIZE_LIMIT = 1073741823;
    private final AtomicBoolean closed;
    private byte[] data;
    private int position;
    private int size;

    public SeekableInMemoryByteChannel(byte[] bArr) {
        this.closed = new AtomicBoolean();
        this.data = bArr;
        this.size = bArr.length;
    }

    private void ensureOpen() throws ClosedChannelException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    private void resize(int i5) {
        int length = this.data.length;
        if (length <= 0) {
            length = 1;
        }
        if (i5 < NAIVE_RESIZE_LIMIT) {
            while (length < i5) {
                length <<= 1;
            }
            i5 = length;
        }
        this.data = Arrays.copyOf(this.data, i5);
    }

    public byte[] array() {
        return this.data;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed.set(true);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed.get();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long position() {
        return this.position;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws ClosedChannelException {
        ensureOpen();
        int iRemaining = byteBuffer.remaining();
        int i5 = this.size;
        int i6 = this.position;
        int i7 = i5 - i6;
        if (i7 <= 0) {
            return -1;
        }
        if (iRemaining > i7) {
            iRemaining = i7;
        }
        byteBuffer.put(this.data, i6, iRemaining);
        this.position += iRemaining;
        return iRemaining;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() {
        return this.size;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long j6) {
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException("Size has to be in range 0.. 2147483647");
        }
        if (this.size > j6) {
            this.size = (int) j6;
        }
        if (this.position > j6) {
            this.position = (int) j6;
        }
        return this;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws ClosedChannelException {
        ensureOpen();
        int iRemaining = byteBuffer.remaining();
        int i5 = this.size;
        int i6 = this.position;
        if (iRemaining > i5 - i6) {
            int i7 = i6 + iRemaining;
            if (i7 < 0) {
                resize(Integer.MAX_VALUE);
                iRemaining = Integer.MAX_VALUE - this.position;
            } else {
                resize(i7);
            }
        }
        byteBuffer.get(this.data, this.position, iRemaining);
        int i8 = this.position + iRemaining;
        this.position = i8;
        if (this.size < i8) {
            this.size = i8;
        }
        return iRemaining;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel position(long j6) throws IOException {
        ensureOpen();
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IOException("Position has to be in range 0.. 2147483647");
        }
        this.position = (int) j6;
        return this;
    }

    public SeekableInMemoryByteChannel() {
        this(ByteUtils.EMPTY_BYTE_ARRAY);
    }

    public SeekableInMemoryByteChannel(int i5) {
        this(new byte[i5]);
    }
}
