package A4;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Y implements InterfaceC0170m {
    public final C0169l bufferField;
    public boolean closed;
    public final f0 sink;

    public Y(f0 sink) {
        kotlin.jvm.internal.E.f(sink, "sink");
        this.sink = sink;
        this.bufferField = new C0169l();
    }

    @Override // A4.InterfaceC0170m
    public C0169l buffer() {
        return this.bufferField;
    }

    @Override // A4.InterfaceC0170m, A4.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        if (this.closed) {
            return;
        }
        if (this.bufferField.size() > 0) {
            f0 f0Var = this.sink;
            C0169l c0169l = this.bufferField;
            f0Var.write(c0169l, c0169l.size());
        }
        th = null;
        try {
            this.sink.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m emit() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long size = this.bufferField.size();
        if (size > 0) {
            this.sink.write(this.bufferField, size);
        }
        return this;
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m emitCompleteSegments() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long jE = this.bufferField.e();
        if (jE > 0) {
            this.sink.write(this.bufferField, jE);
        }
        return this;
    }

    @Override // A4.InterfaceC0170m, A4.f0, java.io.Flushable
    public final void flush() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.bufferField.size() > 0) {
            f0 f0Var = this.sink;
            C0169l c0169l = this.bufferField;
            f0Var.write(c0169l, c0169l.size());
        }
        this.sink.flush();
    }

    @Override // A4.InterfaceC0170m
    public C0169l getBuffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    @Override // A4.InterfaceC0170m
    public OutputStream outputStream() {
        return new X(this);
    }

    @Override // A4.InterfaceC0170m, A4.f0
    public k0 timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.E.f(source, "source");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.bufferField.write(source);
        emitCompleteSegments();
        return iWrite;
    }

    @Override // A4.InterfaceC0170m
    public long writeAll(h0 source) {
        kotlin.jvm.internal.E.f(source, "source");
        long j6 = 0;
        while (true) {
            long j7 = source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (j7 == -1) {
                return j6;
            }
            j6 += j7;
            emitCompleteSegments();
        }
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeByte(int i5) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeByte(i5);
        return emitCompleteSegments();
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeDecimalLong(long j6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeDecimalLong(j6);
        return emitCompleteSegments();
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeHexadecimalUnsignedLong(long j6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeHexadecimalUnsignedLong(j6);
        return emitCompleteSegments();
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeInt(int i5) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeInt(i5);
        return emitCompleteSegments();
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeIntLe(int i5) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeIntLe(i5);
        return emitCompleteSegments();
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeLong(long j6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeLong(j6);
        return emitCompleteSegments();
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeLongLe(long j6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeLongLe(j6);
        return emitCompleteSegments();
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeShort(int i5) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeShort(i5);
        return emitCompleteSegments();
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeShortLe(int i5) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeShortLe(i5);
        return emitCompleteSegments();
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeString(String string, Charset charset) {
        kotlin.jvm.internal.E.f(string, "string");
        kotlin.jvm.internal.E.f(charset, "charset");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeString(string, charset);
        return emitCompleteSegments();
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeUtf8(String string) {
        kotlin.jvm.internal.E.f(string, "string");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeUtf8(string);
        return emitCompleteSegments();
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeUtf8CodePoint(int i5) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeUtf8CodePoint(i5);
        return emitCompleteSegments();
    }

    @Override // A4.InterfaceC0170m, A4.f0
    public void write(C0169l source, long j6) {
        kotlin.jvm.internal.E.f(source, "source");
        if (!this.closed) {
            this.bufferField.write(source, j6);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeString(String string, int i5, int i6, Charset charset) {
        kotlin.jvm.internal.E.f(string, "string");
        kotlin.jvm.internal.E.f(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(string, i5, i6, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m writeUtf8(String string, int i5, int i6) {
        kotlin.jvm.internal.E.f(string, "string");
        if (!this.closed) {
            this.bufferField.writeUtf8(string, i5, i6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m write(C0173p byteString) {
        kotlin.jvm.internal.E.f(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m write(C0173p byteString, int i5, int i6) {
        kotlin.jvm.internal.E.f(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString, i5, i6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m write(byte[] source) {
        kotlin.jvm.internal.E.f(source, "source");
        if (!this.closed) {
            this.bufferField.write(source);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m write(byte[] source, int i5, int i6) {
        kotlin.jvm.internal.E.f(source, "source");
        if (!this.closed) {
            this.bufferField.write(source, i5, i6);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // A4.InterfaceC0170m
    public InterfaceC0170m write(h0 source, long j6) throws EOFException {
        kotlin.jvm.internal.E.f(source, "source");
        while (j6 > 0) {
            long j7 = source.read(this.bufferField, j6);
            if (j7 != -1) {
                j6 -= j7;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}
