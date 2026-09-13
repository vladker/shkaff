package org.apache.poi.hssf.record;

import java.io.IOException;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class StandardRecord extends Record {
    public StandardRecord() {
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public abstract StandardRecord copy();

    public abstract int getDataSize();

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int getRecordSize() {
        return getDataSize() + 4;
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int serialize(int i5, byte[] bArr) {
        int dataSize = getDataSize();
        int i6 = dataSize + 4;
        try {
            LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, i5, i6);
            try {
                littleEndianByteArrayOutputStream.writeShort(getSid());
                littleEndianByteArrayOutputStream.writeShort(dataSize);
                serialize(littleEndianByteArrayOutputStream);
                if (littleEndianByteArrayOutputStream.getWriteIndex() - i5 == i6) {
                    littleEndianByteArrayOutputStream.close();
                    return i6;
                }
                throw new IllegalStateException("Error in serialization of (" + getClass().getName() + "): Incorrect number of bytes written - expected " + i6 + " but got " + (littleEndianByteArrayOutputStream.getWriteIndex() - i5));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        littleEndianByteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    public abstract void serialize(LittleEndianOutput littleEndianOutput);

    public StandardRecord(StandardRecord standardRecord) {
    }
}
