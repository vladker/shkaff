package androidx.emoji2.text.flatbuffer;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i5) {
        return this.buffer[i5];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int i5) {
        return this.buffer[i5] != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i5) {
        return Double.longBitsToDouble(getLong(i5));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i5) {
        return Float.intBitsToFloat(getInt(i5));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i5) {
        byte[] bArr = this.buffer;
        return (bArr[i5] & UnsignedBytes.MAX_VALUE) | (bArr[i5 + 3] << Ascii.CAN) | ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i5) {
        byte[] bArr = this.buffer;
        int i6 = i5 + 6;
        return (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i6]) & 255) << 48) | (((long) bArr[i5 + 7]) << 56);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i5) {
        byte[] bArr = this.buffer;
        return (short) ((bArr[i5] & UnsignedBytes.MAX_VALUE) | (bArr[i5 + 1] << 8));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int i5, int i6) {
        return Utf8Safe.decodeUtf8Array(this.buffer, i5, i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] bArr, int i5, int i6) {
        set(this.writePos, bArr, i5, i6);
        this.writePos += i6;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean z6) {
        setBoolean(this.writePos, z6);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double d) {
        setDouble(this.writePos, d);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float f6) {
        setFloat(this.writePos, f6);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int i5) {
        setInt(this.writePos, i5);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long j6) {
        setLong(this.writePos, j6);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short s6) {
        setShort(this.writePos, s6);
        this.writePos += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int i5) {
        byte[] bArr = this.buffer;
        if (bArr.length > i5) {
            return true;
        }
        int length = bArr.length;
        this.buffer = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i5, byte b) {
        requestCapacity(i5 + 1);
        this.buffer[i5] = b;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int i5, boolean z6) {
        set(i5, z6 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int i5, double d) {
        requestCapacity(i5 + 8);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        int i6 = (int) jDoubleToRawLongBits;
        byte[] bArr = this.buffer;
        bArr[i5] = (byte) (i6 & 255);
        bArr[i5 + 1] = (byte) ((i6 >> 8) & 255);
        bArr[i5 + 2] = (byte) ((i6 >> 16) & 255);
        bArr[i5 + 3] = (byte) ((i6 >> 24) & 255);
        int i7 = (int) (jDoubleToRawLongBits >> 32);
        bArr[i5 + 4] = (byte) (i7 & 255);
        bArr[i5 + 5] = (byte) ((i7 >> 8) & 255);
        bArr[i5 + 6] = (byte) ((i7 >> 16) & 255);
        bArr[i5 + 7] = (byte) ((i7 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int i5, float f6) {
        requestCapacity(i5 + 4);
        int iFloatToRawIntBits = Float.floatToRawIntBits(f6);
        byte[] bArr = this.buffer;
        bArr[i5] = (byte) (iFloatToRawIntBits & 255);
        bArr[i5 + 1] = (byte) ((iFloatToRawIntBits >> 8) & 255);
        bArr[i5 + 2] = (byte) ((iFloatToRawIntBits >> 16) & 255);
        bArr[i5 + 3] = (byte) ((iFloatToRawIntBits >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int i5, int i6) {
        requestCapacity(i5 + 4);
        byte[] bArr = this.buffer;
        bArr[i5] = (byte) (i6 & 255);
        bArr[i5 + 1] = (byte) ((i6 >> 8) & 255);
        bArr[i5 + 2] = (byte) ((i6 >> 16) & 255);
        bArr[i5 + 3] = (byte) ((i6 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int i5, long j6) {
        requestCapacity(i5 + 8);
        int i6 = (int) j6;
        byte[] bArr = this.buffer;
        bArr[i5] = (byte) (i6 & 255);
        bArr[i5 + 1] = (byte) ((i6 >> 8) & 255);
        bArr[i5 + 2] = (byte) ((i6 >> 16) & 255);
        bArr[i5 + 3] = (byte) ((i6 >> 24) & 255);
        int i7 = (int) (j6 >> 32);
        bArr[i5 + 4] = (byte) (i7 & 255);
        bArr[i5 + 5] = (byte) ((i7 >> 8) & 255);
        bArr[i5 + 6] = (byte) ((i7 >> 16) & 255);
        bArr[i5 + 7] = (byte) ((i7 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int i5, short s6) {
        requestCapacity(i5 + 2);
        byte[] bArr = this.buffer;
        bArr[i5] = (byte) (s6 & 255);
        bArr[i5 + 1] = (byte) ((s6 >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(int i5) {
        this(new byte[i5]);
    }

    public ArrayReadWriteBuf(byte[] bArr) {
        this.buffer = bArr;
        this.writePos = 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte b) {
        set(this.writePos, b);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i5, byte[] bArr, int i6, int i7) {
        requestCapacity((i7 - i6) + i5);
        System.arraycopy(bArr, i6, this.buffer, i5, i7);
    }

    public ArrayReadWriteBuf(byte[] bArr, int i5) {
        this.buffer = bArr;
        this.writePos = i5;
    }
}
