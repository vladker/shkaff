package org.apache.poi.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class LittleEndianOutputStream extends FilterOutputStream implements LittleEndianOutput {
    public LittleEndianOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void putUShort(int i5) {
        try {
            ((FilterOutputStream) this).out.write((byte) (i5 & 255));
            ((FilterOutputStream) this).out.write((byte) ((i5 >>> 8) & 255));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr) {
        try {
            super.write(bArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeByte(int i5) {
        try {
            ((FilterOutputStream) this).out.write(i5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeDouble(double d) {
        writeLong(Double.doubleToLongBits(d));
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeInt(int i5) {
        int i6 = (i5 >>> 24) & 255;
        int i7 = (i5 >>> 16) & 255;
        int i8 = (i5 >>> 8) & 255;
        try {
            ((FilterOutputStream) this).out.write(i5 & 255);
            ((FilterOutputStream) this).out.write(i8);
            ((FilterOutputStream) this).out.write(i7);
            ((FilterOutputStream) this).out.write(i6);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeLong(long j6) {
        writeInt((int) j6);
        writeInt((int) (j6 >> 32));
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeShort(int i5) {
        int i6 = (i5 >>> 8) & 255;
        try {
            ((FilterOutputStream) this).out.write(i5 & 255);
            ((FilterOutputStream) this).out.write(i6);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeUInt(long j6) {
        try {
            ((FilterOutputStream) this).out.write((byte) (j6 & 255));
            ((FilterOutputStream) this).out.write((byte) ((j6 >>> 8) & 255));
            ((FilterOutputStream) this).out.write((byte) ((j6 >>> 16) & 255));
            ((FilterOutputStream) this).out.write((byte) ((j6 >>> 24) & 255));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr, int i5, int i6) {
        try {
            super.write(bArr, i5, i6);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
