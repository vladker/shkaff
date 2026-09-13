package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer buffer;

    public ByteBufferReadWriteBuf(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer.array();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i5) {
        return this.buffer.get(i5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int i5) {
        return get(i5) != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i5) {
        return this.buffer.getDouble(i5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i5) {
        return this.buffer.getFloat(i5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i5) {
        return this.buffer.getInt(i5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i5) {
        return this.buffer.getLong(i5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i5) {
        return this.buffer.getShort(i5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int i5, int i6) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, i5, i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.buffer.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] bArr, int i5, int i6) {
        this.buffer.put(bArr, i5, i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean z6) {
        this.buffer.put(z6 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double d) {
        this.buffer.putDouble(d);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float f6) {
        this.buffer.putFloat(f6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int i5) {
        this.buffer.putInt(i5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long j6) {
        this.buffer.putLong(j6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short s6) {
        this.buffer.putShort(s6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int i5) {
        return i5 <= this.buffer.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i5, byte b) {
        requestCapacity(i5 + 1);
        this.buffer.put(i5, b);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int i5, boolean z6) {
        set(i5, z6 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int i5, double d) {
        requestCapacity(i5 + 8);
        this.buffer.putDouble(i5, d);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int i5, float f6) {
        requestCapacity(i5 + 4);
        this.buffer.putFloat(i5, f6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int i5, int i6) {
        requestCapacity(i5 + 4);
        this.buffer.putInt(i5, i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int i5, long j6) {
        requestCapacity(i5 + 8);
        this.buffer.putLong(i5, j6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int i5, short s6) {
        requestCapacity(i5 + 2);
        this.buffer.putShort(i5, s6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.buffer.position();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte b) {
        this.buffer.put(b);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i5, byte[] bArr, int i6, int i7) {
        requestCapacity((i7 - i6) + i5);
        int iPosition = this.buffer.position();
        this.buffer.position(i5);
        this.buffer.put(bArr, i6, i7);
        this.buffer.position(iPosition);
    }
}
