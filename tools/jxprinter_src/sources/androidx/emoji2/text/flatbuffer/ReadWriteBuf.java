package androidx.emoji2.text.flatbuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte b);

    void put(byte[] bArr, int i5, int i6);

    void putBoolean(boolean z6);

    void putDouble(double d);

    void putFloat(float f6);

    void putInt(int i5);

    void putLong(long j6);

    void putShort(short s6);

    boolean requestCapacity(int i5);

    void set(int i5, byte b);

    void set(int i5, byte[] bArr, int i6, int i7);

    void setBoolean(int i5, boolean z6);

    void setDouble(int i5, double d);

    void setFloat(int i5, float f6);

    void setInt(int i5, int i6);

    void setLong(int i5, long j6);

    void setShort(int i5, short s6);

    int writePosition();
}
