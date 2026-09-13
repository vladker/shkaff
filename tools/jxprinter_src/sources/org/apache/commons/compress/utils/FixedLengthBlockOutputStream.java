package org.apache.commons.compress.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FixedLengthBlockOutputStream extends OutputStream implements WritableByteChannel {
    private final int blockSize;
    private final ByteBuffer buffer;
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final WritableByteChannel out;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class BufferAtATimeOutputChannel implements WritableByteChannel {
        private final AtomicBoolean closed;
        private final OutputStream out;

        @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed.compareAndSet(false, true)) {
                this.out.close();
            }
        }

        @Override // java.nio.channels.Channel
        public boolean isOpen() {
            return !this.closed.get();
        }

        @Override // java.nio.channels.WritableByteChannel
        public int write(ByteBuffer byteBuffer) throws IOException {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (!byteBuffer.hasArray()) {
                throw new IOException("Direct buffer somehow written to BufferAtATimeOutputChannel");
            }
            try {
                int iPosition = byteBuffer.position();
                int iLimit = byteBuffer.limit() - iPosition;
                this.out.write(byteBuffer.array(), byteBuffer.arrayOffset() + iPosition, iLimit);
                byteBuffer.position(byteBuffer.limit());
                return iLimit;
            } catch (IOException e) {
                try {
                    close();
                } catch (IOException unused) {
                }
                throw e;
            }
        }

        private BufferAtATimeOutputChannel(OutputStream outputStream) {
            this.closed = new AtomicBoolean(false);
            this.out = outputStream;
        }
    }

    public FixedLengthBlockOutputStream(OutputStream outputStream, int i5) {
        if (outputStream instanceof FileOutputStream) {
            this.out = ((FileOutputStream) outputStream).getChannel();
            this.buffer = ByteBuffer.allocateDirect(i5);
        } else {
            this.out = new BufferAtATimeOutputChannel(outputStream);
            this.buffer = ByteBuffer.allocate(i5);
        }
        this.blockSize = i5;
    }

    private void maybeFlush() throws IOException {
        if (this.buffer.hasRemaining()) {
            return;
        }
        writeBlock();
    }

    private void padBlock() {
        this.buffer.order(ByteOrder.nativeOrder());
        int iRemaining = this.buffer.remaining();
        if (iRemaining > 8) {
            int iPosition = this.buffer.position() & 7;
            if (iPosition != 0) {
                int i5 = 8 - iPosition;
                for (int i6 = 0; i6 < i5; i6++) {
                    this.buffer.put((byte) 0);
                }
                iRemaining -= i5;
            }
            while (iRemaining >= 8) {
                this.buffer.putLong(0L);
                iRemaining -= 8;
            }
        }
        while (this.buffer.hasRemaining()) {
            this.buffer.put((byte) 0);
        }
    }

    private void writeBlock() throws IOException {
        this.buffer.flip();
        int iWrite = this.out.write(this.buffer);
        boolean zHasRemaining = this.buffer.hasRemaining();
        int i5 = this.blockSize;
        if (iWrite != i5 || zHasRemaining) {
            throw new IOException(String.format("Failed to write %,d bytes atomically. Only wrote  %,d", Integer.valueOf(i5), Integer.valueOf(iWrite)));
        }
        this.buffer.clear();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.closed.compareAndSet(false, true)) {
            try {
                flushBlock();
            } finally {
                this.out.close();
            }
        }
    }

    public void flushBlock() throws IOException {
        if (this.buffer.position() != 0) {
            padBlock();
            writeBlock();
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        if (!this.out.isOpen()) {
            this.closed.set(true);
        }
        return !this.closed.get();
    }

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        this.buffer.put((byte) i5);
        maybeFlush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        while (i6 > 0) {
            int iMin = Math.min(i6, this.buffer.remaining());
            this.buffer.put(bArr, i5, iMin);
            maybeFlush();
            i6 -= iMin;
            i5 += iMin;
        }
    }

    public FixedLengthBlockOutputStream(WritableByteChannel writableByteChannel, int i5) {
        this.out = writableByteChannel;
        this.blockSize = i5;
        this.buffer = ByteBuffer.allocateDirect(i5);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        int i5;
        if (isOpen()) {
            int iRemaining = byteBuffer.remaining();
            if (iRemaining < this.buffer.remaining()) {
                this.buffer.put(byteBuffer);
                return iRemaining;
            }
            int iLimit = byteBuffer.limit();
            if (this.buffer.position() != 0) {
                int iRemaining2 = this.buffer.remaining();
                byteBuffer.limit(byteBuffer.position() + iRemaining2);
                this.buffer.put(byteBuffer);
                writeBlock();
                i5 = iRemaining - iRemaining2;
            } else {
                i5 = iRemaining;
            }
            while (i5 >= this.blockSize) {
                byteBuffer.limit(byteBuffer.position() + this.blockSize);
                this.out.write(byteBuffer);
                i5 -= this.blockSize;
            }
            byteBuffer.limit(iLimit);
            this.buffer.put(byteBuffer);
            return iRemaining;
        }
        throw new ClosedChannelException();
    }
}
