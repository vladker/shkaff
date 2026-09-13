package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.DataOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public interface ByteArrayDataOutput extends DataOutput {
    byte[] toByteArray();

    @Override // java.io.DataOutput
    void write(int i5);

    @Override // java.io.DataOutput
    void write(byte[] bArr);

    @Override // java.io.DataOutput
    void write(byte[] bArr, int i5, int i6);

    @Override // java.io.DataOutput
    void writeBoolean(boolean z6);

    @Override // java.io.DataOutput
    void writeByte(int i5);

    @Override // java.io.DataOutput
    @Deprecated
    void writeBytes(String str);

    @Override // java.io.DataOutput
    void writeChar(int i5);

    @Override // java.io.DataOutput
    void writeChars(String str);

    @Override // java.io.DataOutput
    void writeDouble(double d);

    @Override // java.io.DataOutput
    void writeFloat(float f6);

    @Override // java.io.DataOutput
    void writeInt(int i5);

    @Override // java.io.DataOutput
    void writeLong(long j6);

    @Override // java.io.DataOutput
    void writeShort(int i5);

    @Override // java.io.DataOutput
    void writeUTF(String str);
}
