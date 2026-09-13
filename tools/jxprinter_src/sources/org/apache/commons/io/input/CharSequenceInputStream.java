package org.apache.commons.io.input;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CharSequenceInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private static final int NO_MARK = -1;
    private final ByteBuffer bbuf;
    private final CharBuffer cbuf;
    private final CharsetEncoder encoder;
    private int mark_bbuf;
    private int mark_cbuf;

    public CharSequenceInputStream(CharSequence charSequence, Charset charset, int i5) {
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder charsetEncoderOnUnmappableCharacter = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        this.encoder = charsetEncoderOnUnmappableCharacter;
        float fMaxBytesPerChar = charsetEncoderOnUnmappableCharacter.maxBytesPerChar();
        if (i5 < fMaxBytesPerChar) {
            throw new IllegalArgumentException("Buffer size " + i5 + " is less than maxBytesPerChar " + fMaxBytesPerChar);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i5);
        this.bbuf = byteBufferAllocate;
        byteBufferAllocate.flip();
        this.cbuf = CharBuffer.wrap(charSequence);
        this.mark_cbuf = -1;
        this.mark_bbuf = -1;
    }

    private void fillBuffer() throws CharacterCodingException {
        this.bbuf.compact();
        CoderResult coderResultEncode = this.encoder.encode(this.cbuf, this.bbuf, true);
        if (coderResultEncode.isError()) {
            coderResultEncode.throwException();
        }
        this.bbuf.flip();
    }

    @Override // java.io.InputStream
    public int available() {
        return this.cbuf.remaining() + this.bbuf.remaining();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i5) {
        this.mark_cbuf = this.cbuf.position();
        this.mark_bbuf = this.bbuf.position();
        this.cbuf.mark();
        this.bbuf.mark();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws CharacterCodingException {
        Objects.requireNonNull(bArr, "array");
        if (i6 < 0 || i5 + i6 > bArr.length) {
            StringBuilder sb = new StringBuilder("Array Size=");
            androidx.exifinterface.media.a.y(sb, bArr.length, ", offset=", i5, ", length=");
            sb.append(i6);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int i7 = 0;
        if (i6 == 0) {
            return 0;
        }
        if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
            return -1;
        }
        while (i6 > 0) {
            if (!this.bbuf.hasRemaining()) {
                fillBuffer();
                if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
                    break;
                }
            } else {
                int iMin = Math.min(this.bbuf.remaining(), i6);
                this.bbuf.get(bArr, i5, iMin);
                i5 += iMin;
                i6 -= iMin;
                i7 += iMin;
            }
        }
        if (i7 != 0 || this.cbuf.hasRemaining()) {
            return i7;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        try {
            if (this.mark_cbuf != -1) {
                if (this.cbuf.position() != 0) {
                    this.encoder.reset();
                    this.cbuf.rewind();
                    this.bbuf.rewind();
                    this.bbuf.limit(0);
                    while (this.cbuf.position() < this.mark_cbuf) {
                        this.bbuf.rewind();
                        this.bbuf.limit(0);
                        fillBuffer();
                    }
                }
                if (this.cbuf.position() != this.mark_cbuf) {
                    throw new IllegalStateException("Unexpected CharBuffer position: actual=" + this.cbuf.position() + " expected=" + this.mark_cbuf);
                }
                this.bbuf.position(this.mark_bbuf);
                this.mark_cbuf = -1;
                this.mark_bbuf = -1;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws CharacterCodingException {
        long j7 = 0;
        while (j6 > 0 && available() > 0) {
            read();
            j6--;
            j7++;
        }
        return j7;
    }

    public CharSequenceInputStream(CharSequence charSequence, String str, int i5) {
        this(charSequence, Charset.forName(str), i5);
    }

    public CharSequenceInputStream(CharSequence charSequence, Charset charset) {
        this(charSequence, charset, 2048);
    }

    public CharSequenceInputStream(CharSequence charSequence, String str) {
        this(charSequence, str, 2048);
    }

    @Override // java.io.InputStream
    public int read() throws CharacterCodingException {
        while (!this.bbuf.hasRemaining()) {
            fillBuffer();
            if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
                return -1;
            }
        }
        return this.bbuf.get() & UnsignedBytes.MAX_VALUE;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }
}
