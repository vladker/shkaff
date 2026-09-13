package A4;

import X3.AbstractC0239e;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class a0 implements InterfaceC0171n {
    public final C0169l bufferField;
    public boolean closed;
    public final h0 source;

    public a0(h0 source) {
        kotlin.jvm.internal.E.f(source, "source");
        this.source = source;
        this.bufferField = new C0169l();
    }

    @Override // A4.InterfaceC0171n
    public C0169l buffer() {
        return this.bufferField;
    }

    @Override // A4.InterfaceC0171n, A4.h0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws EOFException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.a();
    }

    @Override // A4.InterfaceC0171n
    public final boolean exhausted() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.bufferField.exhausted() && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // A4.InterfaceC0171n
    public C0169l getBuffer() {
        return this.bufferField;
    }

    @Override // A4.InterfaceC0171n
    public final long indexOf(byte b) {
        return indexOf(b, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // A4.InterfaceC0171n
    public long indexOfElement(C0173p targetBytes) {
        kotlin.jvm.internal.E.f(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // A4.InterfaceC0171n
    public InputStream inputStream() {
        return new Z(this);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    @Override // A4.InterfaceC0171n
    public InterfaceC0171n peek() {
        return N.buffer(new W(this));
    }

    @Override // A4.InterfaceC0171n
    public boolean rangeEquals(long j6, C0173p bytes) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        return rangeEquals(j6, bytes, 0, bytes.size());
    }

    @Override // A4.InterfaceC0171n
    public int read(byte[] sink) {
        kotlin.jvm.internal.E.f(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // A4.InterfaceC0171n
    public long readAll(f0 sink) {
        kotlin.jvm.internal.E.f(sink, "sink");
        long j6 = 0;
        while (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            long jE = this.bufferField.e();
            if (jE > 0) {
                j6 += jE;
                sink.write(this.bufferField, jE);
            }
        }
        if (this.bufferField.size() <= 0) {
            return j6;
        }
        long size = this.bufferField.size() + j6;
        C0169l c0169l = this.bufferField;
        sink.write(c0169l, c0169l.size());
        return size;
    }

    @Override // A4.InterfaceC0171n
    public final byte readByte() throws EOFException {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // A4.InterfaceC0171n
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // A4.InterfaceC0171n
    public C0173p readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    @Override // A4.InterfaceC0171n
    public final long readDecimalLong() throws EOFException {
        require(1L);
        long j6 = 0;
        while (true) {
            long j7 = j6 + 1;
            if (!request(j7)) {
                break;
            }
            byte b = this.bufferField.getByte(j6);
            if ((b < 48 || b > 57) && !(j6 == 0 && b == 45)) {
                if (j6 != 0) {
                    break;
                }
                String string = Integer.toString(b, AbstractC0239e.checkRadix(AbstractC0239e.checkRadix(16)));
                kotlin.jvm.internal.E.e(string, "toString(this, checkRadix(radix))");
                throw new NumberFormatException("Expected a digit or '-' but was 0x".concat(string));
            }
            j6 = j7;
        }
        return this.bufferField.readDecimalLong();
    }

    @Override // A4.InterfaceC0171n
    public void readFully(byte[] sink) throws EOFException {
        kotlin.jvm.internal.E.f(sink, "sink");
        try {
            require(sink.length);
            this.bufferField.readFully(sink);
        } catch (EOFException e) {
            int i5 = 0;
            while (this.bufferField.size() > 0) {
                C0169l c0169l = this.bufferField;
                int i6 = c0169l.read(sink, i5, (int) c0169l.size());
                if (i6 == -1) {
                    throw new AssertionError();
                }
                i5 += i6;
            }
            throw e;
        }
    }

    @Override // A4.InterfaceC0171n
    public final long readHexadecimalUnsignedLong() throws EOFException {
        require(1L);
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (!request(i6)) {
                break;
            }
            byte b = this.bufferField.getByte(i5);
            if ((b < 48 || b > 57) && ((b < 97 || b > 102) && (b < 65 || b > 70))) {
                if (i5 != 0) {
                    break;
                }
                String string = Integer.toString(b, AbstractC0239e.checkRadix(AbstractC0239e.checkRadix(16)));
                kotlin.jvm.internal.E.e(string, "toString(this, checkRadix(radix))");
                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
            }
            i5 = i6;
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override // A4.InterfaceC0171n
    public final int readInt() throws EOFException {
        require(4L);
        return this.bufferField.readInt();
    }

    @Override // A4.InterfaceC0171n
    public final int readIntLe() throws EOFException {
        require(4L);
        return this.bufferField.readIntLe();
    }

    @Override // A4.InterfaceC0171n
    public final long readLong() throws EOFException {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override // A4.InterfaceC0171n
    public final long readLongLe() throws EOFException {
        require(8L);
        return this.bufferField.readLongLe();
    }

    @Override // A4.InterfaceC0171n
    public final short readShort() throws EOFException {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // A4.InterfaceC0171n
    public final short readShortLe() throws EOFException {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @Override // A4.InterfaceC0171n
    public String readString(long j6, Charset charset) throws EOFException {
        kotlin.jvm.internal.E.f(charset, "charset");
        require(j6);
        return this.bufferField.readString(j6, charset);
    }

    @Override // A4.InterfaceC0171n
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override // A4.InterfaceC0171n
    public final int readUtf8CodePoint() throws EOFException {
        require(1L);
        byte b = this.bufferField.getByte(0L);
        if ((b & 224) == 192) {
            require(2L);
        } else if ((b & 240) == 224) {
            require(3L);
        } else if ((b & 248) == 240) {
            require(4L);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    @Override // A4.InterfaceC0171n
    public String readUtf8Line() {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return B4.a.readUtf8Line(this.bufferField, jIndexOf);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    @Override // A4.InterfaceC0171n
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // A4.InterfaceC0171n
    public final boolean request(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount < 0: ").toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (this.bufferField.size() < j6) {
            if (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // A4.InterfaceC0171n
    public final void require(long j6) throws EOFException {
        if (!request(j6)) {
            throw new EOFException();
        }
    }

    @Override // A4.InterfaceC0171n
    public int select(S options) throws EOFException {
        kotlin.jvm.internal.E.f(options, "options");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int iSelectPrefix = B4.a.selectPrefix(this.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    return -1;
                }
                this.bufferField.skip(options.getByteStrings$okio()[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    @Override // A4.InterfaceC0171n
    public final void skip(long j6) throws EOFException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j6 > 0) {
            if (this.bufferField.size() == 0 && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j6, this.bufferField.size());
            this.bufferField.skip(jMin);
            j6 -= jMin;
        }
    }

    @Override // A4.InterfaceC0171n, A4.h0
    public k0 timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // A4.InterfaceC0171n
    public final long indexOf(byte b, long j6) {
        return indexOf(b, j6, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // A4.InterfaceC0171n
    public long indexOfElement(C0173p targetBytes, long j6) {
        kotlin.jvm.internal.E.f(targetBytes, "targetBytes");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jIndexOfElement = this.bufferField.indexOfElement(targetBytes, j6);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j6 = Math.max(j6, size);
        }
    }

    @Override // A4.InterfaceC0171n, A4.h0
    public long read(C0169l sink, long j6) {
        kotlin.jvm.internal.E.f(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "byteCount < 0: ").toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.bufferField.read(sink, Math.min(j6, this.bufferField.size()));
    }

    @Override // A4.InterfaceC0171n
    public String readUtf8LineStrict(long j6) throws EOFException {
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "limit < 0: ").toString());
        }
        long j7 = j6 == LocationRequestCompat.PASSIVE_INTERVAL ? Long.MAX_VALUE : j6 + 1;
        long jIndexOf = indexOf((byte) 10, 0L, j7);
        if (jIndexOf != -1) {
            return B4.a.readUtf8Line(this.bufferField, jIndexOf);
        }
        if (j7 < LocationRequestCompat.PASSIVE_INTERVAL && request(j7) && this.bufferField.getByte(j7 - 1) == 13 && request(j7 + 1) && this.bufferField.getByte(j7) == 10) {
            return B4.a.readUtf8Line(this.bufferField, j7);
        }
        C0169l c0169l = new C0169l();
        C0169l c0169l2 = this.bufferField;
        c0169l2.copyTo(c0169l, 0L, Math.min(32, c0169l2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), j6) + " content=" + c0169l.readByteString().hex() + (char) 8230);
    }

    @Override // A4.InterfaceC0171n
    public long indexOf(C0173p bytes) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override // A4.InterfaceC0171n
    public boolean rangeEquals(long j6, C0173p bytes, int i5, int i6) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        if (!this.closed) {
            if (j6 < 0 || i5 < 0 || i6 < 0 || bytes.size() - i5 < i6) {
                return false;
            }
            for (int i7 = 0; i7 < i6; i7++) {
                long j7 = ((long) i7) + j6;
                if (!request(1 + j7) || this.bufferField.getByte(j7) != bytes.getByte(i5 + i7)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override // A4.InterfaceC0171n
    public final long indexOf(byte b, long j6, long j7) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (0 > j6 || j6 > j7) {
            StringBuilder sbT = androidx.collection.a.t("fromIndex=", j6, " toIndex=");
            sbT.append(j7);
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        long jMax = j6;
        while (jMax < j7) {
            byte b6 = b;
            long j8 = j7;
            long jIndexOf = this.bufferField.indexOf(b6, jMax, j8);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = this.bufferField.size();
            if (size >= j8 || this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                break;
            }
            jMax = Math.max(jMax, size);
            b = b6;
            j7 = j8;
        }
        return -1L;
    }

    @Override // A4.InterfaceC0171n
    public String readString(Charset charset) {
        kotlin.jvm.internal.E.f(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @Override // A4.InterfaceC0171n
    public byte[] readByteArray(long j6) throws EOFException {
        require(j6);
        return this.bufferField.readByteArray(j6);
    }

    @Override // A4.InterfaceC0171n
    public C0173p readByteString(long j6) throws EOFException {
        require(j6);
        return this.bufferField.readByteString(j6);
    }

    @Override // A4.InterfaceC0171n
    public String readUtf8(long j6) throws EOFException {
        require(j6);
        return this.bufferField.readUtf8(j6);
    }

    @Override // A4.InterfaceC0171n
    public void readFully(C0169l sink, long j6) throws EOFException {
        kotlin.jvm.internal.E.f(sink, "sink");
        try {
            require(j6);
            this.bufferField.readFully(sink, j6);
        } catch (EOFException e) {
            sink.writeAll(this.bufferField);
            throw e;
        }
    }

    @Override // A4.InterfaceC0171n
    public int read(byte[] sink, int i5, int i6) {
        kotlin.jvm.internal.E.f(sink, "sink");
        long j6 = i6;
        AbstractC0159b.a(sink.length, i5, j6);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.bufferField.read(sink, i5, (int) Math.min(j6, this.bufferField.size()));
    }

    @Override // A4.InterfaceC0171n
    public long indexOf(C0173p bytes, long j6) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jIndexOf = this.bufferField.indexOf(bytes, j6);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j6 = Math.max(j6, (size - ((long) bytes.size())) + 1);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.E.f(sink, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }
}
