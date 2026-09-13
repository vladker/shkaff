package org.apache.poi.util;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RLEDecompressingInputStream extends InputStream {
    private static final int[] POWER2 = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768};
    private final InputStream in;
    private int len;
    private final byte[] buf = new byte[4096];
    private int pos = 0;

    public RLEDecompressingInputStream(InputStream inputStream) throws IOException {
        this.in = inputStream;
        int i5 = inputStream.read();
        if (i5 != 1) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "Header byte 0x01 expected, received 0x%02X", Integer.valueOf(i5 & 255)));
        }
        this.len = readChunk();
    }

    public static byte[] decompress(byte[] bArr) {
        return decompress(bArr, 0, bArr.length);
    }

    public static int getCopyLenBits(int i5) {
        for (int i6 = 11; i6 >= 4; i6--) {
            if ((POWER2[i6] & i5) != 0) {
                return 15 - i6;
            }
        }
        return 12;
    }

    private int readChunk() throws IOException {
        this.pos = 0;
        int i5 = readShort(this.in);
        if (i5 == -1 || i5 == 0) {
            return -1;
        }
        int i6 = (i5 & 4095) + 1;
        if ((i5 & 28672) != 12288) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "Chunksize header A should be 0x3000, received 0x%04X", Integer.valueOf(i5 & 57344)));
        }
        if ((i5 & 32768) == 0) {
            if (IOUtils.readFully(this.in, this.buf, 0, i6) >= i6) {
                return i6;
            }
            Locale locale = Locale.ROOT;
            throw new IllegalStateException(AbstractC0157z.k(i6, "Not enough bytes read, expected "));
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int i9 = this.in.read();
            i7++;
            if (i9 == -1) {
                break;
            }
            for (int i10 = 0; i10 < 8 && i7 < i6; i10++) {
                int[] iArr = POWER2;
                if ((iArr[i10] & i9) == 0) {
                    int i11 = this.in.read();
                    if (i11 == -1) {
                        return -1;
                    }
                    this.buf[i8] = (byte) i11;
                    i7++;
                    i8++;
                } else {
                    int i12 = readShort(this.in);
                    if (i12 == -1) {
                        return -1;
                    }
                    i7 += 2;
                    int copyLenBits = getCopyLenBits(i8 - 1);
                    int i13 = ((iArr[copyLenBits] - 1) & i12) + 3;
                    int i14 = i8 - ((i12 >> copyLenBits) + 1);
                    int i15 = i13 + i14;
                    while (i14 < i15) {
                        byte[] bArr = this.buf;
                        bArr[i8] = bArr[i14];
                        i14++;
                        i8++;
                    }
                }
            }
        }
        return i8;
    }

    @Override // java.io.InputStream
    public int available() {
        int i5 = this.len;
        if (i5 > 0) {
            return i5 - this.pos;
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i5 = this.len;
        if (i5 == -1) {
            return -1;
        }
        if (this.pos >= i5) {
            int chunk = readChunk();
            this.len = chunk;
            if (chunk == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buf;
        int i6 = this.pos;
        this.pos = i6 + 1;
        return bArr[i6] & UnsignedBytes.MAX_VALUE;
    }

    public int readInt() {
        return readInt(this);
    }

    public int readShort() {
        return readShort(this);
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        long j7 = j6;
        while (j7 > 0) {
            if (this.pos >= this.len) {
                int chunk = readChunk();
                this.len = chunk;
                if (chunk == -1) {
                    return -1L;
                }
            }
            int iMin = (int) Math.min(j6, ((long) this.len) - ((long) this.pos));
            this.pos += iMin;
            j7 -= (long) iMin;
        }
        return j6;
    }

    public static byte[] decompress(byte[] bArr, int i5, int i6) {
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        try {
            UnsynchronizedByteArrayInputStream unsynchronizedByteArrayInputStream = new UnsynchronizedByteArrayInputStream(bArr, i5, i6);
            try {
                RLEDecompressingInputStream rLEDecompressingInputStream = new RLEDecompressingInputStream(unsynchronizedByteArrayInputStream);
                try {
                    IOUtils.copy(rLEDecompressingInputStream, unsynchronizedByteArrayOutputStream);
                    byte[] byteArray = unsynchronizedByteArrayOutputStream.toByteArray();
                    rLEDecompressingInputStream.close();
                    unsynchronizedByteArrayInputStream.close();
                    unsynchronizedByteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            rLEDecompressingInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        unsynchronizedByteArrayInputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } catch (Throwable th7) {
            try {
                throw th7;
            } catch (Throwable th8) {
                try {
                    unsynchronizedByteArrayOutputStream.close();
                } catch (Throwable th9) {
                    th7.addSuppressed(th9);
                }
                throw th8;
            }
        }
    }

    private int readInt(InputStream inputStream) throws IOException {
        int i5;
        int i6;
        int i7;
        int i8 = inputStream.read();
        if (i8 == -1 || (i5 = inputStream.read()) == -1 || (i6 = inputStream.read()) == -1 || (i7 = inputStream.read()) == -1) {
            return -1;
        }
        return ((i7 & 255) << 24) | (i8 & 255) | ((i5 & 255) << 8) | ((i6 & 255) << 16);
    }

    private int readShort(InputStream inputStream) throws IOException {
        int i5;
        int i6 = inputStream.read();
        if (i6 == -1 || (i5 = inputStream.read()) == -1) {
            return -1;
        }
        return ((i5 & 255) << 8) | (i6 & 255);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (this.len == -1) {
            return -1;
        }
        int i7 = i5;
        int i8 = i6;
        while (i8 > 0) {
            if (this.pos >= this.len) {
                int chunk = readChunk();
                this.len = chunk;
                if (chunk == -1) {
                    if (i7 > i5) {
                        return i7 - i5;
                    }
                    return -1;
                }
            }
            int iMin = Math.min(i8, this.len - this.pos);
            System.arraycopy(this.buf, this.pos, bArr, i7, iMin);
            this.pos += iMin;
            i8 -= iMin;
            i7 += iMin;
        }
        return i6;
    }
}
