package org.apache.commons.codec.binary;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BaseNCodecOutputStream extends FilterOutputStream {
    private final BaseNCodec baseNCodec;
    private final BaseNCodec.Context context;
    private final boolean doEncode;
    private final byte[] singleByte;

    public BaseNCodecOutputStream(OutputStream outputStream, BaseNCodec baseNCodec, boolean z6) {
        super(outputStream);
        this.singleByte = new byte[1];
        this.context = new BaseNCodec.Context();
        this.baseNCodec = baseNCodec;
        this.doEncode = z6;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        eof();
        flush();
        ((FilterOutputStream) this).out.close();
    }

    public void eof() {
        if (this.doEncode) {
            this.baseNCodec.encode(this.singleByte, 0, -1, this.context);
        } else {
            this.baseNCodec.decode(this.singleByte, 0, -1, this.context);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flush(true);
    }

    public boolean isStrictDecoding() {
        return this.baseNCodec.isStrictDecoding();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        Objects.requireNonNull(bArr, "array");
        if (i5 < 0 || i6 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i5 > bArr.length || i5 + i6 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i6 > 0) {
            if (this.doEncode) {
                this.baseNCodec.encode(bArr, i5, i6, this.context);
            } else {
                this.baseNCodec.decode(bArr, i5, i6, this.context);
            }
            flush(false);
        }
    }

    private void flush(boolean z6) throws IOException {
        byte[] bArr;
        int results;
        int iAvailable = this.baseNCodec.available(this.context);
        if (iAvailable > 0 && (results = this.baseNCodec.readResults((bArr = new byte[iAvailable]), 0, iAvailable, this.context)) > 0) {
            ((FilterOutputStream) this).out.write(bArr, 0, results);
        }
        if (z6) {
            ((FilterOutputStream) this).out.flush();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i5) throws IOException {
        byte[] bArr = this.singleByte;
        bArr[0] = (byte) i5;
        write(bArr, 0, 1);
    }
}
