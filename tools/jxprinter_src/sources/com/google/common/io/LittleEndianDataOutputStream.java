package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
    public LittleEndianDataOutputStream(OutputStream outputStream) {
        super(new DataOutputStream((OutputStream) Preconditions.checkNotNull(outputStream)));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i5, i6);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z6) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBoolean(z6);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i5) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeByte(i5);
    }

    @Override // java.io.DataOutput
    @Deprecated
    public void writeBytes(String str) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBytes(str);
    }

    @Override // java.io.DataOutput
    public void writeChar(int i5) throws IOException {
        writeShort(i5);
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) throws IOException {
        for (int i5 = 0; i5 < str.length(); i5++) {
            writeChar(str.charAt(i5));
        }
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d) throws IOException {
        writeLong(Double.doubleToLongBits(d));
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f6) throws IOException {
        writeInt(Float.floatToIntBits(f6));
    }

    @Override // java.io.DataOutput
    public void writeInt(int i5) throws IOException {
        ((FilterOutputStream) this).out.write(i5 & 255);
        ((FilterOutputStream) this).out.write((i5 >> 8) & 255);
        ((FilterOutputStream) this).out.write((i5 >> 16) & 255);
        ((FilterOutputStream) this).out.write((i5 >> 24) & 255);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j6) throws IOException {
        byte[] byteArray = Longs.toByteArray(Long.reverseBytes(j6));
        write(byteArray, 0, byteArray.length);
    }

    @Override // java.io.DataOutput
    public void writeShort(int i5) throws IOException {
        ((FilterOutputStream) this).out.write(i5 & 255);
        ((FilterOutputStream) this).out.write((i5 >> 8) & 255);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeUTF(str);
    }
}
