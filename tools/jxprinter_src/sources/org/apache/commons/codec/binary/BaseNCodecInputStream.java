package org.apache.commons.codec.binary;

import androidx.collection.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BaseNCodecInputStream extends FilterInputStream {
    private final BaseNCodec baseNCodec;
    private final BaseNCodec.Context context;
    private final boolean doEncode;
    private final byte[] singleByte;

    public BaseNCodecInputStream(InputStream inputStream, BaseNCodec baseNCodec, boolean z6) {
        super(inputStream);
        this.singleByte = new byte[1];
        this.context = new BaseNCodec.Context();
        this.doEncode = z6;
        this.baseNCodec = baseNCodec;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return !this.context.eof ? 1 : 0;
    }

    public boolean isStrictDecoding() {
        return this.baseNCodec.isStrictDecoding();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i5) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i5 = read(this.singleByte, 0, 1);
        while (i5 == 0) {
            i5 = read(this.singleByte, 0, 1);
        }
        if (i5 <= 0) {
            return -1;
        }
        byte b = this.singleByte[0];
        return b < 0 ? b + 256 : b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j6) {
        int i5;
        if (j6 < 0) {
            throw new IllegalArgumentException(a.j(j6, "Negative skip length: "));
        }
        byte[] bArr = new byte[512];
        long j7 = j6;
        while (j7 > 0 && (i5 = read(bArr, 0, (int) Math.min(512, j7))) != -1) {
            j7 -= (long) i5;
        }
        return j6 - j7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        Objects.requireNonNull(bArr, "array");
        if (i5 >= 0 && i6 >= 0) {
            if (i5 > bArr.length || i5 + i6 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i6 == 0) {
                return 0;
            }
            int results = 0;
            while (results == 0) {
                if (!this.baseNCodec.hasData(this.context)) {
                    byte[] bArr2 = new byte[this.doEncode ? 4096 : 8192];
                    int i7 = ((FilterInputStream) this).in.read(bArr2);
                    if (this.doEncode) {
                        this.baseNCodec.encode(bArr2, 0, i7, this.context);
                    } else {
                        this.baseNCodec.decode(bArr2, 0, i7, this.context);
                    }
                }
                results = this.baseNCodec.readResults(bArr, i5, i6, this.context);
            }
            return results;
        }
        throw new IndexOutOfBoundsException();
    }
}
