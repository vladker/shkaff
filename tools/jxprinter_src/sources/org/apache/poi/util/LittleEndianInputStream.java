package org.apache.poi.util;

import io.flutter.embedding.android.KeyboardMap;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LittleEndianInputStream extends FilterInputStream implements LittleEndianInput {
    private static final int BUFFERED_SIZE = 8096;
    private static final int EOF = -1;
    private int markIndex;
    private int readIndex;

    public LittleEndianInputStream(InputStream inputStream) {
        super(inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, BUFFERED_SIZE));
        this.readIndex = 0;
        this.markIndex = -1;
    }

    private int _read(byte[] bArr, int i5, int i6) throws IOException {
        int i7 = i6;
        while (i7 > 0) {
            int i8 = read(bArr, (i6 - i7) + i5, i7);
            if (-1 == i8) {
                break;
            }
            i7 -= i8;
        }
        return i6 - i7;
    }

    private static void checkEOF(int i5, int i6) {
        if (i6 != 0) {
            if (i5 == -1 || i5 != i6) {
                throw new RuntimeException("Unexpected end-of-file");
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, org.apache.poi.util.LittleEndianInput
    @SuppressForbidden("just delegating")
    public int available() {
        try {
            return super.available();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getReadIndex() {
        return this.readIndex;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i5) {
        super.mark(i5);
        this.markIndex = this.readIndex;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        int i7 = super.read(bArr, i5, i6);
        this.readIndex = Math.max(0, i7) + this.readIndex;
        return i7;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        return (byte) readUByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        byte[] bArr = new byte[4];
        try {
            checkEOF(read(bArr), 4);
            return LittleEndian.getInt(bArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        byte[] bArr = new byte[8];
        try {
            checkEOF(read(bArr), 8);
            return LittleEndian.getLong(bArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readPlain(byte[] bArr, int i5, int i6) {
        readFully(bArr, i5, i6);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        return (short) readUShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        byte[] bArr = new byte[1];
        try {
            checkEOF(read(bArr), 1);
            return LittleEndian.getUByte(bArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long readUInt() {
        return ((long) readInt()) & KeyboardMap.kValueMask;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        byte[] bArr = new byte[2];
        try {
            checkEOF(read(bArr), 2);
            return LittleEndian.getUShort(bArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        int i5 = this.markIndex;
        if (i5 > -1) {
            this.readIndex = i5;
            this.markIndex = -1;
        }
    }

    public void skipFully(int i5) throws IOException {
        if (i5 == 0) {
            return;
        }
        long jSkipFully = IOUtils.skipFully(this, i5);
        if (jSkipFully > 2147483647L) {
            throw new IOException("can't skip further than 2147483647");
        }
        checkEOF((int) jSkipFully, i5);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i5, int i6) {
        try {
            checkEOF(_read(bArr, i5, i6), i6);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
