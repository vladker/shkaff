package org.apache.poi.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface LittleEndianOutput {
    void write(byte[] bArr);

    void write(byte[] bArr, int i5, int i6);

    void writeByte(int i5);

    void writeDouble(double d);

    void writeInt(int i5);

    void writeLong(long j6);

    void writeShort(int i5);
}
