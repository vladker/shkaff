package org.apache.poi.util;

import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LittleEndianByteArrayInputStream extends ByteArrayInputStream implements LittleEndianInput {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public LittleEndianByteArrayInputStream(byte[] bArr, int i5, int i6) {
        super(bArr, i5, i6);
    }

    public void checkPosition(int i5) {
        if (i5 <= ((ByteArrayInputStream) this).count - ((ByteArrayInputStream) this).pos) {
            return;
        }
        StringBuilder sb = new StringBuilder("Buffer overrun, having ");
        sb.append(((ByteArrayInputStream) this).count);
        sb.append(" bytes in the stream and position is at ");
        throw new IllegalStateException(androidx.exifinterface.media.a.i(", but trying to increment position by ", ((ByteArrayInputStream) this).pos, i5, sb));
    }

    public int getReadIndex() {
        return ((ByteArrayInputStream) this).pos;
    }

    public void limit(int i5) {
        ((ByteArrayInputStream) this).count = Math.min(i5, ((ByteArrayInputStream) this).buf.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        checkPosition(1);
        return (byte) read();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i5, int i6) throws IOException {
        checkPosition(i6);
        read(bArr, i5, i6);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkPosition(4);
        int i5 = LittleEndian.getInt(((ByteArrayInputStream) this).buf, ((ByteArrayInputStream) this).pos);
        super.skip(4L);
        return i5;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        checkPosition(8);
        long j6 = LittleEndian.getLong(((ByteArrayInputStream) this).buf, ((ByteArrayInputStream) this).pos);
        super.skip(8L);
        return j6;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] bArr, int i5, int i6) throws IOException {
        readFully(bArr, i5, i6);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        checkPosition(2);
        short s6 = LittleEndian.getShort(((ByteArrayInputStream) this).buf, ((ByteArrayInputStream) this).pos);
        super.skip(2L);
        return s6;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return readByte() & UnsignedBytes.MAX_VALUE;
    }

    public long readUInt() {
        return ((long) readInt()) & KeyboardMap.kValueMask;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        return readShort() & 65535;
    }

    public void setReadIndex(int i5) {
        if (i5 < 0 || i5 >= ((ByteArrayInputStream) this).count) {
            throw new IndexOutOfBoundsException();
        }
        ((ByteArrayInputStream) this).pos = i5;
    }

    public LittleEndianByteArrayInputStream(byte[] bArr, int i5) {
        this(bArr, i5, bArr.length - i5);
    }

    public LittleEndianByteArrayInputStream(byte[] bArr) {
        super(bArr);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) throws IOException {
        checkPosition(bArr.length);
        read(bArr, 0, bArr.length);
    }
}
