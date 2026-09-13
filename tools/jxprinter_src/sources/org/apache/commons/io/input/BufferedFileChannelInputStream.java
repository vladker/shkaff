package org.apache.commons.io.input;

import com.google.common.primitives.UnsignedBytes;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class BufferedFileChannelInputStream extends InputStream {
    private static final Class<?> DIRECT_BUFFER_CLASS = getDirectBufferClass();
    private final ByteBuffer byteBuffer;
    private final FileChannel fileChannel;

    public BufferedFileChannelInputStream(File file) {
        this(file, 8192);
    }

    private void clean(ByteBuffer byteBuffer) {
        if (isDirectBuffer(byteBuffer)) {
            cleanDirectBuffer(byteBuffer);
        }
    }

    private void cleanDirectBuffer(ByteBuffer byteBuffer) {
        if ("1.8".equals(System.getProperty("java.specification.version"))) {
            try {
                Class<?> cls = Class.forName("sun.misc.Cleaner");
                Object objInvoke = DIRECT_BUFFER_CLASS.getMethod("cleaner", null).invoke(byteBuffer, null);
                if (objInvoke != null) {
                    cls.getMethod("clean", null).invoke(objInvoke, null);
                    return;
                }
                return;
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class<?> cls2 = Class.forName("sun.misc.Unsafe");
            Method method = cls2.getMethod("invokeCleaner", ByteBuffer.class);
            Field declaredField = cls2.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            method.invoke(declaredField.get(null), byteBuffer);
        } catch (ReflectiveOperationException e6) {
            throw new IllegalStateException(e6);
        }
    }

    private static Class<?> getDirectBufferClass() {
        try {
            return Class.forName("sun.nio.ch.DirectBuffer");
        } catch (ClassNotFoundException | IllegalAccessError unused) {
            return null;
        }
    }

    private static boolean isDirectBuffer(Object obj) {
        Class<?> cls = DIRECT_BUFFER_CLASS;
        return cls != null && cls.isInstance(obj);
    }

    private boolean refill() throws IOException {
        if (this.byteBuffer.hasRemaining()) {
            return true;
        }
        this.byteBuffer.clear();
        int i5 = 0;
        while (i5 == 0) {
            i5 = this.fileChannel.read(this.byteBuffer);
        }
        this.byteBuffer.flip();
        return i5 >= 0;
    }

    private long skipFromFileChannel(long j6) throws IOException {
        long jPosition = this.fileChannel.position();
        long size = this.fileChannel.size();
        long j7 = size - jPosition;
        if (j6 > j7) {
            this.fileChannel.position(size);
            return j7;
        }
        this.fileChannel.position(jPosition + j6);
        return j6;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return this.byteBuffer.remaining();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.fileChannel.close();
            clean(this.byteBuffer);
        } catch (Throwable th) {
            clean(this.byteBuffer);
            throw th;
        }
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        if (!refill()) {
            return -1;
        }
        return this.byteBuffer.get() & UnsignedBytes.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public synchronized long skip(long j6) {
        if (j6 <= 0) {
            return 0L;
        }
        if (this.byteBuffer.remaining() >= j6) {
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.position(byteBuffer.position() + ((int) j6));
            return j6;
        }
        long jRemaining = this.byteBuffer.remaining();
        this.byteBuffer.position(0);
        this.byteBuffer.flip();
        return jRemaining + skipFromFileChannel(j6 - jRemaining);
    }

    public BufferedFileChannelInputStream(File file, int i5) {
        this(file.toPath(), i5);
    }

    public BufferedFileChannelInputStream(Path path) {
        this(path, 8192);
    }

    public BufferedFileChannelInputStream(Path path, int i5) {
        Objects.requireNonNull(path, "path");
        this.fileChannel = FileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i5);
        this.byteBuffer = byteBufferAllocateDirect;
        byteBufferAllocateDirect.flip();
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i5, int i6) {
        int i7;
        if (i5 >= 0 && i6 >= 0 && (i7 = i5 + i6) >= 0) {
            if (i7 <= bArr.length) {
                if (!refill()) {
                    return -1;
                }
                int iMin = Math.min(i6, this.byteBuffer.remaining());
                this.byteBuffer.get(bArr, i5, iMin);
                return iMin;
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
