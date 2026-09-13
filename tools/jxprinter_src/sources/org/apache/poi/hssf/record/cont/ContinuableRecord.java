package org.apache.poi.hssf.record.cont;

import java.io.IOException;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ContinuableRecord extends Record {
    public ContinuableRecord() {
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int getRecordSize() {
        ContinuableRecordOutput continuableRecordOutputCreateForCountingOnly = ContinuableRecordOutput.createForCountingOnly();
        serialize(continuableRecordOutputCreateForCountingOnly);
        continuableRecordOutputCreateForCountingOnly.terminate();
        return continuableRecordOutputCreateForCountingOnly.getTotalSize();
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int serialize(int i5, byte[] bArr) {
        try {
            LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, i5);
            try {
                ContinuableRecordOutput continuableRecordOutput = new ContinuableRecordOutput(littleEndianByteArrayOutputStream, getSid());
                serialize(continuableRecordOutput);
                continuableRecordOutput.terminate();
                int totalSize = continuableRecordOutput.getTotalSize();
                littleEndianByteArrayOutputStream.close();
                return totalSize;
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
    }

    public abstract void serialize(ContinuableRecordOutput continuableRecordOutput);

    public ContinuableRecord(ContinuableRecord continuableRecord) {
        super(continuableRecord);
    }
}
